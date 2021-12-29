package ThinkDoneSolutions.Prezentar;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AppTest 
{
	/**
	 * Rigorous Test :-)
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("deprecation")

	public void creatSinglePrezentation() throws InterruptedException
	{ 

		System.setProperty("webdriver.chrome.driver", "F:\\Projects\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); 

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://prezentar.net/");

		driver.findElement(By.xpath("//input[@id='txtmail']")).sendKeys("razaahmad9921@gmail.com");

		driver.findElement(By.xpath("//input[@id='txtpasscord']")).sendKeys("123456");

		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();

		driver.findElement(By.xpath("//a[.='Templates']")).click();

		WebElement element = driver.findElement(By.xpath("//div[@class='tab-r-wrapper admin_templates_list custom-scroll']"));

		List<WebElement> list = element.findElements(By.xpath("//div[@class='tab-right-list  ']"));


		int i = 1;

		while(i <= 30) { 


			Actions act = new Actions(driver);
			
			act.moveToElement(list.get(i)).build().perform();			

			act.click(list.get(i).findElement(By.cssSelector("div a i"))).build().perform();
			
			driver.findElement(By.xpath("//input[@id='inputUseMe']")).clear();

			driver.findElement(By.xpath("//input[@id='inputUseMe']")).sendKeys(randomString());

			driver.findElement(By.xpath("//button[@class='btn btn-default prezentar-button-150']")).click();

			driver.findElement(By.xpath("/html/body/div[8]/div[1]/div[1]/div/ul/li[1]/a")).click();

			driver.findElement(By.xpath("/html/body/div[35]/div/div/div[2]/div[2]/div/a[2]")).click();

			i++;

			driver.findElement(By.xpath("//a[.='Templates']")).click();

			element = driver.findElement(By.xpath("//div[@class='tab-r-wrapper admin_templates_list custom-scroll']"));

			list = element.findElements(By.xpath("//div[@class='tab-right-list  ']"));

		}


	}
	@SuppressWarnings("deprecation")
	
	@Test
	public void createMultiplePrezentations() {

		System.setProperty("webdriver.chrome.driver", "F:\\Projects\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); 

		driver.get("https://prezentar.net/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='txtmail']")).sendKeys("razaahmad9921@gmail.com");

		driver.findElement(By.xpath("//input[@id='txtpasscord']")).sendKeys("123456");

		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();

		ArrayList<String> tab = null;

		for (int i = 0; i < 5; i++) {

			WebElement link=driver.findElement(By.xpath("//a[.='Templates']"));
			Actions actions = new Actions(driver);

			actions.keyDown(Keys.LEFT_CONTROL)
			.click(link)
			.keyUp(Keys.LEFT_CONTROL)
			.build()
			.perform();

			tab = new ArrayList<>(driver.getWindowHandles());

		}

		driver.findElement(By.xpath("//a[.='Templates']")).click();

		Actions act = null;

		WebElement  element = null;

		List<WebElement> list = null;
		
		
		for (int i = 0; i < tab.size(); i++) {

			driver.switchTo().window(tab.get(i));	

			element = driver.findElement(By.xpath("//div[@class='tab-r-wrapper admin_templates_list custom-scroll']"));

			list = element.findElements(By.xpath("//div[@class='tab-right-list  ']"));
			
			int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

			act = new Actions(driver);

			act.moveToElement(list.get(randomNum)).build().perform();

			act.click(list.get(randomNum).findElement(By.cssSelector("div a i"))).build().perform();
			
			driver.findElement(By.xpath("//input[@id='inputUseMe']")).clear();

			driver.findElement(By.xpath("//input[@id='inputUseMe']")).sendKeys(randomString());

			driver.findElement(By.xpath("//button[@onclick='CopyTemplate();']")).click();

		}

		for (int i = 0; i < tab.size(); i++) {
			
			driver.switchTo().window(tab.get(i));

			driver.findElement(By.xpath("//a[@id='btnBackToPrezentations']")).click();

			driver.findElement(By.xpath("//a[text()='Save & Exit']")).click();
		}

	}
	
	public void creatSingleVSL() {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Projects\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); 

		driver.get("https://prezentar.net/");
		
		driver.findElement(By.xpath("//input[@id='txtmail']")).sendKeys("razalion903@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='txtpasscord']")).sendKeys("123456");

		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
		
		driver.findElement(By.xpath("//a[.='VSL']")).click();
		
		if(!driver.findElement(By.xpath("//img[@class='default-img']")).isDisplayed()) {
			
			driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[2]/div/div[2]/div[1]/div/div/a/div[2]"));
			
		}
		else {
			
			driver.findElement(By.cssSelector(".btnFloating.btn-add-vsl")).click();
			
			driver.findElement(By.xpath("//input[@id='inputTemplateName']")).sendKeys(randomString());
			
			driver.findElement(By.xpath("//button[@onclick='goToStep2();']")).click();
			
			int randomNum = ThreadLocalRandom.current().nextInt(0, 30);
			
			
			for (int i = 0; i < randomNum; i++) {
				
				driver.findElement(By.xpath("//textarea[@id='area']")).sendKeys(paragraph());
				
				driver.findElement(By.xpath("//button[@title='Click to Make Slides']")).click();
				
			}
			
			
			
			
			

		}
	}


	@SuppressWarnings("deprecation")

	public void upload() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Projects\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); 

		driver.get("https://prezentar.net/");

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='txtmail']")).sendKeys("razaahmad9921@gmail.com");

		driver.findElement(By.xpath("//input[@id='txtpasscord']")).sendKeys("123456");

		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();

		driver.findElement(By.xpath("//a[.='Templates']")).click();

		WebElement element = driver.findElement(By.xpath("//div[@class='tab-r-wrapper admin_templates_list custom-scroll']"));

		List<WebElement> list = element.findElements(By.xpath("//div[@class='tab-right-list  ']"));
		Actions act = new Actions(driver);

		act.moveToElement(list.get(1)).build().perform();

		act.click(list.get(1).findElement(By.cssSelector("div a i"))).build().perform();

		driver.findElement(By.xpath("//input[@id='inputUseMe']")).sendKeys(randomString());

		driver.findElement(By.xpath("//button[@class='btn btn-default prezentar-button-150']")).click();


		int i = 0;

		while(i < 30) {

			driver.findElement(By.xpath("/html/body/div[8]/div[2]/div[2]/ul/li[3]/a")).click();

			driver.findElement(By.xpath("/html/body/div[15]/div/div/div[2]/div/div[2]/div/div/div[1]")).click();

			System.out.println("Dinka");

			driver.findElement(By.xpath("/html/body/div[31]/div/div/div/div/div[1]/button[3]")).click();

			WebElement chooseFile = driver.findElement(By.xpath("/html/body/div[31]/div/div/div/div/div[3]/div[2]/div[1]/div[1]/input"));

			chooseFile.sendKeys("C:\\Users\\Admin\\Downloads\\Images\\1.jpg");

			i++;

			Thread.sleep(6000);

			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).perform();

			Thread.sleep(2000);


		}

		driver.findElement(By.xpath("/html/body/div[8]/div[1]/div[1]/div/ul/li[1]/a")).click();

		driver.findElement(By.xpath("/html/body/div[35]/div/div/div[2]/div[2]/div/a[2]")).click();

		driver.quit();

	}

	@SuppressWarnings("deprecation")
	
	public void uploadImageFileInMyImage() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Projects\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.edureka.co/");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.findElement(By.xpath("/html/body/header/nav/ul/li[4]/span")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("si_popup_email"))));
		driver.findElement(By.id("si_popup_email")).sendKeys("sumailfreakinghassan@gmail.com");
		driver.findElement(By.id("si_popup_passwd")).sendKeys("4303921Ee!");

		driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div[3]/form/button")).click();

		Thread.sleep(2000);
		driver.get("https://learning.edureka.co/my-profile");
		Thread.sleep(1000);

		WebElement imageEdit = driver.findElement(By.xpath("/html/body/app-root/app-profile-main/div/div/div[2]/app-myprofilenew/div[1]/div/div/div[1]/div/div/div/div/i"));

		imageEdit.click();
		Thread.sleep(1000);
		WebElement chooseFile = driver.findElement(By.xpath("/html/body/app-root/app-profile-main/div/div/div[2]/app-myprofilenew/div[2]/div/div/div[2]/div[1]/input"));
		chooseFile.sendKeys("C:\\Users\\Admin\\Downloads\\Images\\1.jpeg");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div[class='submitbtnsec'] > button[type='submit']")).click();

	}

	public  String randomString() {

		// create random string builder
		StringBuilder sb = new StringBuilder();

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// create an object of Random class
		Random random = new Random();

		// specify length of random string
		int length = 9;

		for(int i = 0; i < length; i++) {

			// generate random index number
			int index = random.nextInt(alphabet.length());

			// get character specified by index
			// from the string
			char randomChar = alphabet.charAt(index);

			// append the character to string builder
			sb.append(randomChar);
		}



		return sb.toString();
	}
	
	public String paragraph(){
		

		// create random string builder
		StringBuilder sb = new StringBuilder();

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// create an object of Random class
		Random random = new Random();

		// specify length of random string
		int length = 50;

		for(int i = 0; i < length; i++) {

			// generate random index number
			int index = random.nextInt(alphabet.length());

			// get character specified by index
			// from the string
			char randomChar = alphabet.charAt(index);

			// append the character to string builder
			sb.append(randomChar);
		}



		return sb.toString();
		
	}
}
