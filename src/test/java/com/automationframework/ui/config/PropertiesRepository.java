package com.automationframework.ui.config;

import java.io.FileReader;
import java.net.URL;
import java.util.Properties;
import java.util.StringTokenizer;




import org.apache.commons.configuration.CombinedConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.tree.OverrideCombiner;






import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.automationframework.exceptions.DriverException;


public final class PropertiesRepository {

	
	
	private static CombinedConfiguration propAggregrator = 
								new CombinedConfiguration(new OverrideCombiner());
	
	private Logger logger = LogManager.getLogger(this.getClass());
	/**
	 * Add additional properties
	 *
	 *@param properties File
	 */
	public static void appendProperties(String propertiesFile) throws Exception {
		
		PropertiesConfiguration properties=null;
		try {
			System.out.println("Loading Property file : "+ propertiesFile);
			properties = new PropertiesConfiguration(propertiesFile);
			properties.setDelimiterParsingDisabled(true);
		} catch (ConfigurationException e) {
				throw new DriverException ("Unable to load properties", e);
		}
		if(properties != null){
			propAggregrator.addConfiguration(properties);
		}
	}
	
	public static void loadAllProperties() throws Exception{
		
		Properties propsFileList = new Properties();
		ClassLoader loader= Thread.currentThread().getContextClassLoader();
		
		try {
			URL url = loader.getResource(GlobalProperties.PROPS_LIST);
			propsFileList.load(new FileReader(url.getPath()));
		} catch (Exception e) {	
		}
		String filesList=propsFileList.getProperty("propFiles");
		StringTokenizer tokens = new StringTokenizer(filesList,",");	
		while (tokens.hasMoreElements()) {
			String fileName = tokens.nextToken();
			appendProperties(fileName);
		}	
		appendProperties(GlobalProperties.GLOBAL_PROPS);
		appendProperties(GlobalProperties.LOG_PROPS);
	}
	
	public static String getString(String key){
		return propAggregrator.getString(key);
		
	}
	
	public static int getInt(String key){
		return propAggregrator.getInt(key);
	}
	
	public static boolean getBoolean(String key){
		return propAggregrator.getBoolean(key);
	}
	
	public static long getLong(String key){
		return propAggregrator.getLong(key);
	}
}
