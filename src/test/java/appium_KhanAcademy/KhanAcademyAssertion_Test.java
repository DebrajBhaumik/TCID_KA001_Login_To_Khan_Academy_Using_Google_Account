package appium_KhanAcademy;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class KhanAcademyAssertion_Test {
	public AndroidDriver driver ;
  @Test
  public void LoginValidation() {
	 
      driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
       
      driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Continue with Google\")")).click();
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException, InterruptedException {
	  DesiredCapabilities capability= new DesiredCapabilities();
      capability.setCapability("deviceName", "Manzoor");
      capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
      capability.setCapability(MobileCapabilityType.NO_RESET, true);
      capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
      capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
      driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      Thread.sleep(10000);
  }

  @AfterClass
  public void afterClass() throws InterruptedException, Exception {
	  try {
	      	String Message= driver.findElement(By.xpath("//*[contains(@text, 'Choose an account')]")).getText();
	          System.out.println("User Google Account Is Seen :"+ Message);
	          driver.findElement(By.xpath("//*[contains(@class, 'android.widget.LinearLayout')]")).click();
	          driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	          Thread.sleep(20000);
	          File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	          FileUtils.copyFile(file,new File("C:\\All Document\\Mobile Testing\\Screenshots\\Scr1.jpg"));
	          
	      }
	      catch(NoSuchElementException e)
	      {       
	      	System.out.println("Google Account Can Not Be Clicked");

	  	}
	      driver.findElement(By.xpath("//*[contains(@class,'android.widget.ImageView')]")).click();
	      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	      Thread.sleep(10000);
	      File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(file,new File("C:\\All Document\\Mobile Testing\\Screenshots\\Scr2.jpg"));
	      Thread.sleep(10000);
	      driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign out\")")).click();
	      driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"SIGN OUT\")")).click();
	      System.out.println("Log Out From The Khan Academy App Was Successfull");
	      Thread.sleep(10000);
	      driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	      driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"CLEAR ALL\")")).click();
	      System.out.println("Successfully Closed The Khan Academy App");

	  
  }

}
