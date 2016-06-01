package com.racing.commons.xml;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.util.StringUtils;

import com.racing.commons.base64.Base64;

/**
 * xml
 * 
 * @author liupeng
 * 
 */
@SuppressWarnings("unchecked")
public class XmlEngine {
	private static XmlEngine engine;

	public static XmlEngine instance() {
		synchronized(engine){
			if (engine == null)
				return new XmlEngine();
		}
		return engine;
	}

	public String decodeString2XML(String base64XML) throws Exception {
		XMLNode node = getResultsByXML(base64XML, true, null);
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("UTF-8");
		node.addElementXML(document);
		return document.asXML();
	}

	/**
	 * 解析XML
	 * 
	 * @param result
	 * @param is_decode
	 * @return
	 * @throws Exception
	 */
	public XMLNode getResultsByXML(String result, boolean is_decode, Set<String> ignoreAttrs) throws Exception {
		XMLNode node = new XMLNode();
		if (is_decode)
			result = new String(Base64.decode(result, Base64.NO_WRAP), "GBK");

		Document document = DocumentHelper.parseText(result);

		Element rootElement = document.getRootElement();
		node.setName(rootElement.getName());
		node.setContent(rootElement.getTextTrim());
		node.setAttribute(getAttributeByElement(rootElement, is_decode, ignoreAttrs));
		node.setChildren(getClildrenNode(rootElement, is_decode, ignoreAttrs));
		return node;
	}

	private List<XMLNode> getClildrenNode(Element element, boolean is_decode, Set<String> ignoreAttrs) throws UnsupportedEncodingException {
		List<XMLNode> nodes = new ArrayList<XMLNode>();
		for (Iterator<Element> it = element.elementIterator(); it.hasNext();) {
			Element emt = it.next();
			XMLNode childNode = new XMLNode();
			childNode.setName(emt.getName());
			childNode.setContent(emt.getTextTrim());
			childNode.setAttribute(getAttributeByElement(emt, is_decode, ignoreAttrs));
			childNode.setChildren(getClildrenNode(emt, is_decode, ignoreAttrs));
			nodes.add(childNode);
		}
		return nodes;
	}

	private Map<String, String> getAttributeByElement(Element rootElement, boolean is_decode, Set<String> ignoreAttrs) throws UnsupportedEncodingException {
		Map<String, String> attributes = new HashMap<String, String>();

		for (Iterator<Attribute> it = rootElement.attributeIterator(); it.hasNext();) {
			Attribute attribute = it.next();
			boolean isflag = false;
			if (ignoreAttrs == null)
				isflag = is_decode;
			else
				isflag = is_decode && ignoreAttrs != null && !ignoreAttrs.contains(attribute.getName());
			String value = isflag ? new String(Base64.decode(attribute.getValue().getBytes("GBK"), Base64.NO_WRAP), "GBK") : attribute.getValue();
			attributes.put(attribute.getName(), value);
		}
		return attributes;
	}


	public <T> T property2Entity(XMLNode xmlNode, Class<?> clazz) throws Exception {
		T undefindObject = (T) clazz.newInstance();
		for (Iterator<String> keyIt = xmlNode.getAttribute().keySet().iterator(); keyIt.hasNext();) {
			String key = keyIt.next();
			String value_ = xmlNode.getAttributeVaue(key);
			Object value = null;
			Method method = setGetMethodByClazz(key, clazz);
			if (method == null)
				continue;

			String paramTypeName = method.getParameterTypes()[0].getName();
			if (paramTypeName.equals(String.class.getName())) {
				value = (String) value_;
			} else if (paramTypeName.equals(BigDecimal.class.getName())) {
				if(StringUtils.isEmpty(value_)){
					value_=String.valueOf(0);
				}
				value = new BigDecimal(value_);
			} else if (paramTypeName.equals(Integer.class.getName())) {
				value = Integer.valueOf(value_);
			}
			method.invoke(undefindObject, value);
		}
		return undefindObject;
	}

	private Method setGetMethodByClazz(String key, Class<?> clazz) {
		String methodName = "set".concat(key.substring(0, 1).toUpperCase()).concat(key.substring(1).toLowerCase());
		Method setMethod = null;

		Method[] methods = clazz.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methodName.equals(methods[i].getName())) {
				setMethod = methods[i];
				break;
			}
		}
		return setMethod;
	}
}
