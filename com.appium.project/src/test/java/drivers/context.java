package drivers;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class context {
	
	public static void main(String[] args) throws Throwable, Throwable {
		UiAutomator2Options op = new UiAutomator2Options();
		op.setPlatformName("android");
		op.setAutomationName("uiautomator2");
		op.setDeviceName("realme 12 Pro 5G");
		op.setUdid("f3a09c5c");
		op.setIgnoreHiddenApiPolicyError(true);
		op.setAutoGrantPermissions(true);
		
		
        URL u=new URI("http://localhost:4723").toURL();
        
        AndroidDriver driver=new AndroidDriver(u, op);
        
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
       driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable()).scrollIntoView(text(\"India\"))"));
       driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Devika");
       driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
       driver.findElement(AppiumBy.id("")).click();
       driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
       driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']/..//android.widget.TextView[@text='ADD TO CART']")).click();
       driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
       
       Set<String> con = driver.getContextHandles();
       int count = con.size();
       System.out.println(count);
       
       for(String ch:con) {
    	   driver.context("WEBVIEW_com.androidsample.generalstore");
       }
       String s = driver.getTitle();
       System.out.println(s);
            
	} 

}
