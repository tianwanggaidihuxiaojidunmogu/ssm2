package com.racing.redis.serializable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.io.output.ByteArrayOutputStream;

/**
 * 对象序列化
 * 
 * @author liupeng
 * @param <T>
 */
public class ObjectSerializable {

	/**
	 * 序列化
	 * 
	 * @param key
	 * @param serializableObj
	 * @return
	 */
	public static byte[] serializable(Object serializableObj) {
		byte[] serializableBytes = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			byteArrayOutputStream = new ByteArrayOutputStream();
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(serializableObj);
			serializableBytes = byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				byteArrayOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				objectOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return serializableBytes;
	}

	/**
	 * 反序列化
	 * 
	 * @param serializableBytes
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deserializable(byte[] serializableBytes, Class<T> clazz) {
		T serializableObj = null;
		ByteArrayInputStream byteArrayInputStream = null;
		ObjectInputStream objectInputStream = null;

		try {
			byteArrayInputStream = new ByteArrayInputStream(serializableBytes);
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
			serializableObj = (T) objectInputStream.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				byteArrayInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return serializableObj;
	}
}
