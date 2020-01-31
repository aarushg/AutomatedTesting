package edu.cmu.ea.test.sparcs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SparcsStepDefs{

    private WebDriver getContextDriver (){

        return getContext().getDriver();

    }

    public SeleniumContext getContext() {
        return context;
    }


    private SeleniumContext context= (SeleniumContext)
            new ClassPathXmlApplicationContext("sparcs-reg-test.xml").getBean("seleniumContext");

    private boolean isLoggedin = false;

    private void auth(){

        if (!isLoggedin){
            getContextDriver().get("https://sparcs-dev3.andrew.cmu.edu/awards");
            getContextDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("CukeTest");
            getContextDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("Test1");
            getContextDriver().findElement(By.id("frmLogin")).submit();

            isLoggedin = true;
        }

    }

    @Given("I go to award page")
    public void iGoToAwardPage() {
        auth();
        getContextDriver().get("https://sparcs-dev3.andrew.cmu.edu/awards/sd/Rooms/DisplayPages/LayoutInitial?Container=com.webridge.entity.Entity[OID[7859A2CEAA40864CAB57986B43AC089A]]");
    }

    @And("I enter search Award text")
    public void iEnterSearchAwardText() {
        getContextDriver().findElement(By.id("57611D05AAF391459304E90871FE7E88_queryCriteria0")).sendKeys("AWD00000288");
    }

    @And("I click on that award number")
    public void iClickOnThatAwardNumber() {
        //To generalize this use the table path and the name to find the element
        getContextDriver().findElement(By.xpath("//*[@id=\"57611D05AAF391459304E90871FE7E88\"]/table/tbody/tr/td[3]/span/a")).click();
    }

    @Then("I should see that award")
    public void iShouldSeeThatAward() {
        Assert.assertTrue(getContextDriver().findElements(By.xpath("/html/body/main/table/tbody/tr[1]/td/table/tbody/tr[2]/td/span[1]/div/h2\n")).size()>0);
    }

    @Given("Click on edit award")
    public void iClickOnEditAward() {
        auth();
        getContextDriver().get("https://sparcs-dev3.andrew.cmu.edu/awards/sd/ResourceAdministration/Project/ProjectEditor?Project=com.webridge.entity.Entity[OID[61E72E4183726041A4A9359B9582E0E7]]&Mode=smartform&WizardPageOID=com.webridge.entity.Entity[OID[53574D70EAB53440BE4FD11FBD204912]]\n");

        //getContextDriver().findElement(By.xpath("/html/body/main/table/tbody/tr[1]/td/table/tbody/tr[2]/td/span[4]/div/a[1]/img")).click();
    }
    @And("Click Continue")
    public void clickContinue() {
        //getContextDriver().findElement(By.xpath("//*[@id=\"continue_btn_Top\"]")).click();
        getContextDriver().findElement(By.id("continue_btn_Top")).click();

    }


    @And("Click Finish")
    public void clickFinish() {
        getContextDriver().findElement(By.xpath("//*[@id=\"finish_btn_Top\"]")).click();
    }

    @Then("I should see the award number")
    public void iShouldSeeTheAwardNumber() {
        Assert.assertTrue(getContextDriver().findElements(By.xpath("/html/body/main/table/tbody/tr[1]/td/table/tbody/tr[2]/td/span[1]/div/h2")).size()>0);
    }



}
