package com.lx.eclipse.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 从配置文件中读取变量
 *
 */
public class PropertyManager {

	private static Logger log = LoggerFactory.getLogger(PropertyManager.class);
	private static final String CONFIG = "config";

	/**
	 * 
	 */
	private static final Map<String, String> properties = new LinkedHashMap<String, String>();

	/**
	 * 
	 * 
	 * @param key
	 * @return value
	 */
	public static String getString(final String key) {
		return getRB(CONFIG, key);
	}

	/**
	 * 
	 * 
	 * @param rb
	 * 
	 * @param key
	 * @return value
	 */
	public static String getRB(final String rb, final String key) {
		try {
			final String rbKey = rb + "_" + key;
			if (properties.containsKey(rbKey)) {
				return properties.get(rbKey);
			}
			final String value = ResourceBundle.getBundle(rb).getString(key);
			properties.put(rbKey, value);
			return value;
		} catch (final MissingResourceException e) {
			log.error('!' + rb + ":" + key + '!');
		}

		return null;
	}

	public static void main(final String[] args) {
		System.out.println(PropertyManager.getString("bbb"));
	}
}
