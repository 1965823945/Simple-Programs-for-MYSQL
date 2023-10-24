package by.bsu.lab2.connector;
import java.util.*;
public class ConfigurationManager {
	private String url;
	private String driver;
	private String user;
	private String pass;
	
	private static ConfigurationManager instance = null;
    private ConfigurationManager() {
    ResourceBundle  resource = ResourceBundle.getBundle("resources.database");
    url= resource.getString("url");
    driver= resource.getString("driver");
    user = resource.getString("user");
    pass = resource.getString("password");
    }
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            System.out.println("Creating instance");
            instance = new ConfigurationManager();
            System.out.println(" instance created");
        }
        return instance;
    }
    public void showInfo() {
        System.out.println("Method called");
    }
	public String getDriver() {
		return driver;
	}
	public String getPass() {
		return pass;
	}
	public String getURL() {
		return url;
	}
	public String getUser() {
		return user;
	}

    
	
	
}
