package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class GestureUtility {
	
	AndroidDriver driver;
	
	public GestureUtility(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public void clickByElement(WebElement element) {
		driver.executeScript("mobile: clickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId()
			));
	}
	public void doubleclickByElement(WebElement element) {
		driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId()
			));
	}
	public void longClickByElement(WebElement element,int time) {
		driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),"duration",time
			));
	}
	public void clickByCoordinates(int x,int y) {
		driver.executeScript("mobile: clickGesture", ImmutableMap.of(
			    "x",x,"y",y
			));
	}
	public void doubleclickByCoordinates(int x,int y) {
		driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
			    "x",x,"y",y
			));
	}
	public void longClickByCoordiantes(int x,int y,int time) {
		driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "x",x,"y",y,"duration",time
			));
	}
	public void DragAndDropByElement(WebElement element,int x,int y) {
		driver.executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),"x",x,"y",y
			));
	}
	public void DragAndDropByCoOrdiante(int StartX,int StartY,int endX,int endY ) {
		driver.executeScript("mobile: dragGesture", ImmutableMap.of(
			    "StartX",StartX,"StartY",StartY,"endX",endX,"endY",endY
			));
	}
	public void zoomIn(WebElement element,int percent) {
		driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),"percent",percent
			));
	}
	public void zoomOut(WebElement element,int percent) {
		driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),"percent",percent
			));
	}
	public void ScrollByCoOrinate(int left,int top,int width,int height,int percent,String direction) {
		driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
			"left",left,"top",top,"width",width,"height",height,"direction",direction,"percent",percent
			));
	}
	public WebElement scrollByText(String text) {
		WebElement element = driver.findElement(AppiumBy
		.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new uiSelector().text(\""+text+"\"));"));
		return element;
	}
	public WebElement scrollByXpath(String xPath) {
	    WebElement element = driver.findElement(AppiumBy
	        .androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"" + xPath + "\"));"));
	    return element;
	}
	public void swipeByCoOrdinate(int left,int top,int height,int width,String direction,int percent) {
		((JavascriptExecutor)driver).executeScript("mobile:swipeGesture",ImmutableMap.of("left",100,"top",200,"height",100,"width",200,
				"direction","right","percent",0.90));
	}
	public void swipeByElement(WebElement element,String direction,int percent) {
		((JavascriptExecutor)driver).executeScript("mobile:swipeGesture",ImmutableMap.of("elementId",
				((RemoteWebElement)element).getId(),"direction","left","percent",1));
	}

	

}
