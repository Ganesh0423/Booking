package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class redBusBookingPage{

    private static WebDriver driver;

    public void openChromeBrowser() throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Project\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        try{
            driver.get("https://www.redbus.in/");
            //Thread.sleep(20000);
        } catch (Exception e){
            System.out.println("Error while loading the page");
        }
        String Title = driver.getTitle();
        System.out.println("Page Title : " + Title);
        String URL = driver.getCurrentUrl();
        System.out.println("Page URL : " + URL);
        this.takeScreenshot(driver, "D:\\Selenium Project\\Booking_SS\\01-RedBus_Homepage.png");
    }

    private void takeScreenshot(WebDriver webDriver, String fileWithPath) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) webDriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public void provideLocationAndDate() throws InterruptedException {

        WebElement ScrField = driver.findElement(By.xpath("//*[@id='src']"));
        ScrField.click();
        ScrField.sendKeys("Miyapur");
        ScrField.sendKeys(Keys.RETURN);
        Thread.sleep(2000);

        WebElement DesField = driver.findElement(By.xpath("//*[@id='dest']"));
        DesField.click();
        DesField.sendKeys("Vijayawada");
        Thread.sleep(2000);
        DesField.sendKeys(Keys.RETURN);

        WebElement DateField = driver.findElement(By.xpath("//*[@id='onwardCal']/div"));
        DateField.click();
        Thread.sleep(2000);

        WebElement SelectDate = driver.findElement(By.xpath("//div[6]/span/div[6]/span"));
        SelectDate.click();
        Thread.sleep(5000);
    }

    public void selectBus() throws InterruptedException {
        WebElement SearchBtn = driver.findElement(By.xpath("//*[@id='search_button']"));
        SearchBtn.click();
        Thread.sleep(7000);

        WebElement ViewAPSRTCBuses = driver.findElement(By.xpath("//div[2]/div/div[2]/div/div[4]/div[2]"));
        Thread.sleep(10000);
        ViewAPSRTCBuses.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250);");
        Thread.sleep(2000);

        WebElement SelectBus = driver.findElement(By.xpath("//div[2]/ul/div[1]/li/div/div[2]/div[1]"));
        SelectBus.click();
        Thread.sleep(2000);
    }

    public void selectDetailsToViewSeats() throws InterruptedException {
        try {
            WebElement PopUpClose = driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div[1]/div/i"));
            PopUpClose.click();
        } catch (Exception e) {
            System.err.println("Pop-up doesn't exist");
        }

        WebElement OnBoardLocation = driver.findElement(By.xpath("//div[2]/div/div/div[1]/div/ul/li[1]/div[1]/div"));
        OnBoardLocation.click();
        Thread.sleep(2000);

        WebElement DropLocation = driver.findElement(By.xpath("//div[2]/ul/li[6]/div[1]/div"));
        DropLocation.click();
        Thread.sleep(2000);

        WebElement ViewSeats = driver.findElement(By.xpath("//div[2]/button"));
        ViewSeats.click();
        Thread.sleep(5000);

        WebElement ProceedBtn = driver.findElement(By.xpath("//ul/div[1]/div/div/div/div[4]"));
        ProceedBtn.click();
        Thread.sleep(5000);
    }

    public void selectSeatAndProceed() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250);");
        Thread.sleep(2000);

        WebElement seatMap = driver.findElement(By.xpath("//*[@id='rt_26056285']/div/div/div/div[2]/div[2]/div[2]/canvas"));
        int width = seatMap.getSize().getWidth();
        int height = seatMap.getSize().getHeight();
        int xCoordinate = (int) (width/2.5); // Replace with actual x-coordinate of the seat
        int yCoordinate = (int) (height/1.5); // Replace with actual y-coordinate of the seat
        System.out.println("height: " + height + ", width: " + width + ", xCoordinate: " + xCoordinate + ", yCoordinate: " + yCoordinate);
        Actions actions = new Actions(driver);
        Thread.sleep(5000);
        actions.moveToElement(seatMap, xCoordinate, yCoordinate).click().build().perform();

        WebElement ProceedToBookBtn = driver.findElement(By.xpath("//*[@id=\"seatBpdp_26056285\"]/div/div[2]/div/div/div[1]/div[2]/div[6]/button"));
        ProceedToBookBtn.click();
        Thread.sleep(5000);
    }

    public void PassengerDetailsAndProceedToPay() throws InterruptedException {
        WebElement NameInput = driver.findElement(By.xpath("//div[2]/div/div/div[2]/div[1]/div/label/input"));
        NameInput.sendKeys("Ganesh");
        Thread.sleep(2000);

        WebElement Gender = driver.findElement(By.xpath("//div[2]/div/div/div[2]/div[1]/div/label/input"));
        Gender.click();
        Thread.sleep(2000);

        WebElement AgeInput = driver.findElement(By.xpath("//div[2]/div[2]/div/div/label/input"));
        AgeInput.sendKeys("26");
        Thread.sleep(2000);

        WebElement StateInput = driver.findElement(By.xpath("//div[2]/div[2]/div/div/label/input"));
        StateInput.sendKeys("Andhra Pradesh");
        Thread.sleep(2000);

        AgeInput.sendKeys(Keys.ARROW_DOWN);
        AgeInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250);");
        Thread.sleep(2000);

        WebElement EmailInput = driver.findElement(By.xpath("//div[2]/div[2]/div/label/input"));
        EmailInput.sendKeys("abc@def.com");
        Thread.sleep(2000);

        WebElement ContactInput = driver.findElement(By.xpath("//div[3]/div/div[2]/div/label/input"));
        ContactInput.sendKeys("9876543210");
        Thread.sleep(2000);

        WebElement ProceedToPay = driver.findElement(By.xpath("//div[2]/input"));
        ProceedToPay.click();
        Thread.sleep(2000);
    }

    public void endBrowser() {
        driver.quit();
    }
}