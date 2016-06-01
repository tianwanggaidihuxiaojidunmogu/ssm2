package com.racing.commons.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.util.StringUtils;

public class XMLNode {
	private String name;
	private Map<String, String> attribute;
	private List<XMLNode> children;
	private String content;

	public XMLNode() {
		attribute = new HashMap<String, String>();
		children = new ArrayList<XMLNode>();
	}

	public XMLNode(String name) {
		this.setName(name);
		attribute = new HashMap<String, String>();
		children = new ArrayList<XMLNode>();
	}

	public XMLNode(String name, String content) {
		this.setName(name);
		this.setContent(content);
		attribute = new HashMap<String, String>();
		children = new ArrayList<XMLNode>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getAttribute() {
		return attribute;
	}

	public void setAttribute(Map<String, String> attribute) {
		this.attribute = attribute;
	}

	public XMLNode getChildNodeByKey(String key) {
		XMLNode childNode = null;
		for (XMLNode node : getChildren()) {
			if (key.equals(node.getName())) {
				childNode = node;
				break;
			}
		}
		return childNode;
	}

	public List<XMLNode> getChildren() {
		return children;
	}

	public void setChildren(List<XMLNode> children) {
		this.children = children;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAttributeVaue(String attribute) {
		return this.attribute.get(attribute) == null ? "" : this.attribute.get(attribute);
	}

	public Element addElementXML(Object parent) {
		Element element = null;
		if (parent instanceof Document) {
			element = ((Document) parent).addElement(this.getName());
		} else if (parent instanceof Element) {
			element = ((Element) parent).addElement(this.getName());
			for (String key : this.getAttribute().keySet()) {
				element.addAttribute(key, this.getAttributeVaue(key));
			}
		} 
		if (!StringUtils.isEmpty(this.getContent()))
			element.setText(this.getContent());
		if (this.getChildren().size() > 0) {
			for (XMLNode child : this.getChildren()) {
				if(child==null)
					continue;
				child.addElementXML(element);
			}
		}
		return element;
	}

	public String asXmlDocument() {
		Document document = DocumentHelper.createDocument();
		addElementXML(document);
		return document.asXML();
	}

}
