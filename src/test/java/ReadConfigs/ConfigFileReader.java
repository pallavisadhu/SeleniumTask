package ReadConfigs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	Properties prop;
	public final String propertyFile="/Users/pallavisadhu/eclipse-workspace/SeleniumTask/src/test/java/configfiles/config.properties";
	
	public ConfigFileReader() throws IOException {
		FileInputStream fis = new FileInputStream(new File(propertyFile));
		prop = new Properties();
		prop.load(fis);
	}
	
	public String getUrl() {
		return prop.getProperty("url");
	}

}
