package com.actitime.generic;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils
{
	public static void getScreenshot(WebDriver driver,String name)
	{
		try 
		{
		TakesScreenshot t= (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./screenshots/"+name+".png");
		FileUtils.copyFile(src, dest);
		}
		catch(Exception e)
		{
			
		}
	}
	
	public static void selectByIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement element,String value)
	{
		Select sel =new Select(element);
		sel.selectByValue(value);
	}
//	
//	public static void selectByVisibleText(WebElement element,String text)
//	{
//		Select sel =new Select(element);
//		sel.selectByVisibleText(text);
//	}
//	
//	public static void deSelectByIndex(WebElement element, int index) 
//	{
//		Select sel = new Select(element);
//		sel.deselectByIndex(index);
//	}
//	public static void deSelectByValue(WebElement element,String value)
//	{
//		Select sel =new Select(element);
//		sel.deselectByValue(value);
//	}
//	
//	public static void deSelectByVisibleText(WebElement element,String text)
//	{
//		Select sel =new Select(element);
//		sel.deselectByVisibleText(text);
//	}
//	
//	public static void deselectAll(WebElement element)
//	{
//		Select sel =new Select(element);
//		sel.deselectAll();
//	}
//
//	public static List<String> getAllOptions(WebElement element)
//	{
//		Select sel= new Select(element);
//		List<String> alltext = new ArrayList<>();
//		List<WebElement> alloptions = sel.getOptions();
//		for(WebElement option :alloptions)
//		{
//			String text = option.getText();
//			alltext.add(text);
//		}
//		return alltext;
//	}
//	
//	public static List<String> getAllSelectedOptions(WebElement element)
//	{
//		Select sel= new Select(element);
//		List<String> alltext = new ArrayList<>();
//		List<WebElement> alloptions = sel.getAllSelectedOptions();
//		for(WebElement option :alloptions)
//		{
//			String text = option.getText();
//			alltext.add(text);
//		}
//		return alltext;
//	}
//	
//	public static void moveToElement(WebDriver driver, WebElement element)
//	{
//		Actions act= new Actions(driver);
//		act.moveToElement(element).perform();
//	}
//	
//	public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target)
//	{
//		Actions act= new Actions(driver);
//		act.dragAndDrop(source, target);		
//	}
	
	public static void accept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
}
	

