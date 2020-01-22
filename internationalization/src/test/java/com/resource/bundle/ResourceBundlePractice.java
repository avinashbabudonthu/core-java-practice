package com.resource.bundle;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import org.junit.Test;

public class ResourceBundlePractice {

	/**
	 * Read different properties files based on locale
	 */
	@Test
	public void propertyResourceBundle() {
		Locale enUSLocale = new Locale("en", "US");
		ResourceBundle defaultResourceBundle = ResourceBundle.getBundle("labels", enUSLocale);
		System.out.println(defaultResourceBundle.getString("label1")); // Welcome to I18N
		System.out.println(defaultResourceBundle.getString("label2.label3")); // Welcome to ResourceBundle

		Locale deLocale = new Locale("telugu");
		ResourceBundle daResourceBundle = ResourceBundle.getBundle("labels", deLocale);
		System.out.println(daResourceBundle.getString("label1")); // Let's learn to I18N
		System.out.println(daResourceBundle.getString("label2.label3")); // Let's learn PropertyResourceBundle

		// get all keys in a ResourceBundle
		Set<String> keys = defaultResourceBundle.keySet();
		System.out.println("keys: " + keys); // keys: [label2.label3, label1]
	}

	@Test
	public void listResourceBundle() {
		Locale defaultLocale = new Locale("de");
		ResourceBundle defaultResourceBundle = ResourceBundle.getBundle("core.java.i18n.MyListResourceBundle",
				defaultLocale);
		System.out.println(defaultResourceBundle.getObject("name")); // jack
		System.out.println(defaultResourceBundle.getObject("course")); // Java
		System.out.println(defaultResourceBundle.getObject("grade")); // 3.9

		Locale teluguLocale = new Locale("telugu");
		ResourceBundle teluguResourceBundle = ResourceBundle.getBundle("core.java.i18n.MyListResourceBundle",
				teluguLocale);
		System.out.println(teluguResourceBundle.getObject("name")); // john
		System.out.println(teluguResourceBundle.getObject("course")); // Groovy
		System.out.println(teluguResourceBundle.getObject("grade")); // 3.8
	}
}