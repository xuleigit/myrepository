package com.jsict.common.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 廖师兄
 * 2018-02-21 10:40
 */
public class JsonUtil {

	private static ObjectMapper objectMapper = new ObjectMapper();


/*

	public static <T> T parse(String jsonString, Class<T> type) {
		return Json.getJson().parse(jsonString, type);
	}

*/


	/***
	 * 将对象转换为List对象
	 * @param object
	 * @return
	 */
	public static List toArrayList(Object object)
	{
		List arrayList = new ArrayList();

		JSONArray jsonArray = JSONArray.fromObject(object);
		Iterator it = jsonArray.iterator();
		while (it.hasNext())
		{
			JSONObject jsonObject = (JSONObject) it.next();
			arrayList.add(jsonObject);
			/*Iterator keys = jsonObject.keys();
			while (keys.hasNext())
			{
				Object key = keys.next();
				Object value = jsonObject.get(key);
				arrayList.add(value);
			}*/
		}

		return arrayList;
	}

	/**
	 * string转object 用于转为集合对象
	 * @param str json字符串
	 * @param collectionClass 被转集合class
	 * @param elementClasses 被转集合中对象类型class
	 * @param <T>
	 * @return
	 */
	public static <T> T string2List(String str,Class<?> collectionClass,Class<?>... elementClasses){
		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass,elementClasses);
		try {
			return objectMapper.readValue(str,javaType);
		} catch (IOException e) {
			System.out.println("Parse String to Object error");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Convert JsonString to Simple Object
	 *
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> T jsonString2SimpleObj(String jsonString, Class<T> cls) {
		T jsonObj = null;

		try {
			jsonObj = objectMapper.readValue(jsonString, cls);
		} catch (IOException e) {
			System.out.printf("pasre json Object[{}] to string failed.",jsonString);
		}

		return jsonObj;
	}

	/**
	 * 转换为json字符串
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	static {
		objectMapper = new ObjectMapper();

		// 设置FAIL_ON_EMPTY_BEANS属性，当序列化空对象不要抛异常
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		// 设置FAIL_ON_UNKNOWN_PROPERTIES属性，当JSON字符串中存在Java对象没有的属性，忽略
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * Convert Object to JsonString
	 *
	 * @param jsonObj
	 * @return
	 */
	public static String jsonObj2Sting(Object jsonObj) {
		String jsonString = null;

		try {
			jsonString = objectMapper.writeValueAsString(jsonObj);
		} catch (IOException e) {
			System.out.printf("pasre json Object[{}] to string failed.",jsonString);
		}

		return jsonString;
	}

	/**
	 * Method that will convert object to the ObjectNode.
	 *
	 * @param object
	 *            the source data; if null, will return null.
	 * @return the ObjectNode data after converted.
	 * @throws Exception
	 */
	public static <T> ObjectNode convertObject2ObjectNode(T object)
			throws Exception {
		if (null == object) {
			return null;
		}

		ObjectNode objectNode = null;

		if (object instanceof String) {
			objectNode = convertJsonStringToObject((String) object,
					ObjectNode.class);
		} else {
			objectNode = convertValue(object, ObjectNode.class);
		}

		return objectNode;
	}

	/**
	 * Method that will convert the json string to destination by the type(cls).
	 *
	 * @param jsonString
	 *            the source json string; if null, will return null.
	 * @param cls
	 *            the destination data type.
	 * @return
	 * @throws Exception
	 */
	public static <T> T convertJsonStringToObject(String jsonString,
												  Class<T> cls) throws Exception {
		if (StringUtil.strIsNullOrEmpty(jsonString)) {
			return null;
		}

		try {
			T object = objectMapper.readValue(jsonString, cls);
			return object;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	/**
	 * Method that will convert from given value into instance of given value
	 * type.
	 *
	 * @param fromValue
	 * @param toValueType
	 * @return
	 * @throws Exception
	 */
	private static <T> T convertValue(Object fromValue, Class<T> toValueType)
			throws Exception {
		try {
			return objectMapper.convertValue(fromValue, toValueType);
		} catch (IllegalArgumentException e) {
			throw new Exception(e);
		}
	}

}
