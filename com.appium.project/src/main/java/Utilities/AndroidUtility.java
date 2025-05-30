package Utilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.appmanagement.ApplicationState;

public class AndroidUtility {
	
		AndroidDriver driver;
		public AndroidUtility(AndroidDriver driver) {
			 this.driver=driver;
		}
		public void installApp(String path) {
			driver.installApp(path);
		}
		public void isAppInstalled(String appPakage) {
			boolean result = driver.isAppInstalled(appPakage);
		if (result==true) {
			System.out.println("The App Is Installed");
		}
		else
		{
			System.out.println("The App Is Not Installed");
		}
		}
		public void unInstallApp(String appPackage) {
			driver.removeApp(appPackage);
		}
		public void runAppInBackground(int sec) {
			Duration time = Duration.ofSeconds(sec);
			driver.runAppInBackground(time);
		}
		public void appStatus(String appPackage) {
			ApplicationState status = driver.queryAppState(appPackage);
			System.out.println("The App is "+ status);
		}
		public void launchApp(String appPackage) {
			driver.activateApp(appPackage);
		}
		public void closeApp(String appPackage) {
			driver.terminateApp(appPackage);
		}
		public void seeNotofication() {
			driver.openNotifications();
		}
		@SuppressWarnings("static-access")
		public void portraitOrientation() {
			ScreenOrientation screen = driver.getOrientation();
			driver.rotate(screen.PORTRAIT);
		}
		@SuppressWarnings("static-access")
		public void landscapeOrientation() {
			ScreenOrientation screen = driver.getOrientation();
			driver.rotate(screen.LANDSCAPE);
		}
		public void increaseBrightness() {
			driver.pressKey(new KeyEvent(AndroidKey.BRIGHTNESS_UP));
		}
		public void decraeaseBrightness() {
			driver.pressKey(new KeyEvent(AndroidKey.BRIGHTNESS_DOWN));
		}
		public void hideKeyboard() {
			driver.hideKeyboard();
		}
		public void saveTextInClipboard(String text) {
			driver.setClipboardText(text);
		}
		public void getTextFromClipboard() {
			driver.getClipboardText();
		}
		public void getToastMessage() {
			String msg=driver.findElement(AppiumBy.xpath("//android.widget.Toast[1]")).getText();
			System.out.println(msg);
		}
		public void getContext() {
			Set<String> contexts = driver.getContextHandles();
			System.out.println(contexts.size());
			for(String ch:contexts) {
				System.out.println(ch);
				if(ch.contains("WEBVIEW_")) {
					driver.context(ch);
					break;
				}
			}
		}
		public void wifi() {
			driver.toggleWifi();
		}
		public void Data() {
			driver.toggleData();
		}
		public void airplaneMode() {
			driver.toggleAirplaneMode();
		}
	}



