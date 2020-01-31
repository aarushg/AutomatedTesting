package edu.cmu.ea.test.sparcs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumContext {

    private String host;

    private String reportLocation;

    private WebDriver driver;

    private String user;

    private String password;

    public void init(){

        driver = new ChromeDriver();

    }



    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getReportLocation() {
        return reportLocation;
    }

    public void setReportLocation(String reportLocation) {
        this.reportLocation = reportLocation;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
