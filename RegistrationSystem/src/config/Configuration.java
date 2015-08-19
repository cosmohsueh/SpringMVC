package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	public static final String MAIL_CONFIG = "/config/mailconfig.properties";

	private final Properties properties = new Properties();

	public Configuration(String resource) {
		InputStream stream = null;
		try {
			stream = getClass().getResourceAsStream(resource);
			properties.load(stream);
		} catch (IOException e) {
			throw new RuntimeException("Could not read " + resource, e);
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String get(String key) {
		return properties.getProperty(key);
	}

	public String get(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public Properties getProperties() {
		return properties;
	}

	/**
	 * Transforms a java resource to a file name.<br>
	 * Avoid such type of access. Better use directly
	 * {@link Class#getResourceAsStream(String)}.
	 */
	public static String getFileName(String resource) {
		return Configuration.class.getResource(resource).getFile();
	}

	public static boolean isInDevelopmentMode() {
		return "x0r".equals(System.getProperty("developer_mode"));
	}
}
