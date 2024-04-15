            import com.beust.ah.A;
            import org.openqa.selenium.By;
            import org.openqa.selenium.JavascriptExecutor;
            import org.openqa.selenium.WebDriver;
            import org.openqa.selenium.WebElement;
            import org.openqa.selenium.chrome.ChromeDriver;
            import org.openqa.selenium.chrome.ChromeOptions;
            import org.openqa.selenium.firefox.FirefoxDriver;
            import org.testng.Assert;
            import org.testng.annotations.Test;

            import java.nio.file.WatchEvent;
            import java.time.Duration;


   public class GoogleTest {

        @Test
        public void LocatorXPath() throws InterruptedException {

         WebDriver driver = new ChromeDriver();

          try {

           driver.get("https://demoqa.com/");
            driver.manage().window().maximize();

            WebElement elementsBtn = driver.findElement(By.xpath("//h5[1]"));
            String value = elementsBtn.getText();
            Assert.assertEquals("Elements", value);
            elementsBtn.click();

             WebElement mainHeaderElements = driver.findElement(By.xpath("//*[@class ='main-header']"));
             String valueMainHeader = mainHeaderElements.getText();
             Assert.assertEquals("Elements", valueMainHeader);

             WebElement textBoxTab = driver.findElement(By.xpath("//span[text()='Text Box']"));
             String valueTextBoxTab = textBoxTab.getText();
             Assert.assertEquals("Text Box", valueTextBoxTab);
             textBoxTab.click();

             WebElement mainHeaderTextBox = driver.findElement(By.xpath("//*[@class ='main-header']"));
             String valueMainHeader1 = mainHeaderTextBox.getText();
             Assert.assertEquals("Text Box", valueMainHeader1 );

            WebElement fullName = driver.findElement(By.xpath("//*[@placeholder='Full Name']"));
            fullName.sendKeys("Nat");

            WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
            email.sendKeys("new@new.new");

            WebElement country = driver.findElement(By.xpath("//*[@id='currentAddress']"));
            country.sendKeys("USA");

            WebElement countryPermanent = driver.findElement(By.xpath("//*[@id='permanentAddress']"));
            countryPermanent.sendKeys("NY");

            WebElement submit = driver.findElement(By.xpath("//*[@id='submit']"));
            submit.click();

            WebElement displayedName = driver.findElement(By.xpath("//*[@id='name']"));
            String nameValue = displayedName.getText();

            Assert.assertEquals("Name:Nat", nameValue);

            WebElement displayedEmail = driver.findElement(By.xpath("//*[@id='email']"));
            String emailValue = displayedEmail.getText();

            Assert.assertEquals("Email:new@new.new", emailValue);

            WebElement displayedCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
            String currAddressValue = displayedCurrentAddress.getText();

            Assert.assertEquals("Current Address :USA", currAddressValue);

            WebElement displayedPermAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
            String permAddressValue = displayedPermAddress.getText();

            Assert.assertEquals("Permananet Address :NY", permAddressValue);
               }finally {
                         driver.quit();
               }
        }
@Test
        public void useDiffSeleniumLocators() throws InterruptedException {
            WebDriver driver = new ChromeDriver();

            driver.get("https://rahulshettyacademy.com/locatorspractice/");
            driver.manage().window().maximize();
        try {
            WebElement h1Text = driver.findElement(By.cssSelector("form h1"));
            String h1TextValue = h1Text.getText();
            Assert.assertEquals("Sign in", h1TextValue);

            WebElement nameInput = driver.findElement(By.id("inputUsername"));
            nameInput.sendKeys("rahulshetty");

            WebElement password = driver.findElement(By.name("inputPassword"));
            password.sendKeys("hello123");

            WebElement submitButton = driver.findElement(By.className("signInBtn"));
            submitButton.click();
            Thread.sleep(1000);
            WebElement errorMsg = driver.findElement(By.cssSelector("p.error"));
            String errorMessageText = errorMsg.getText();
            Assert.assertEquals("* Incorrect username or password", errorMessageText);

            WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password?"));
            forgotPasswordLink.click();
            Thread.sleep(1000);
            WebElement h2Text = driver.findElement(By.cssSelector("h2"));
            String h2TextValue = h2Text.getText();

            Assert.assertEquals("Forgot password", h2TextValue);
             WebElement nameNew = driver.findElement(By.xpath("//input[@placeholder='Name']"));
             nameNew.sendKeys("John");
             WebElement email = driver.findElement(By.xpath("//input[@type='text'][2]")); //By.cssSelector("input[type='text']:nth-child(4)")
             email.sendKeys("123123");
             email.clear();
             email.sendKeys("new@new.new");


             WebElement phoneNumber = driver.findElement(By.xpath("//input[@placeholder='Phone Number']"));
             phoneNumber.sendKeys("1234654654646");

             WebElement resetLogin = driver.findElement(By.xpath("//button[@class='reset-pwd-btn']"));
             resetLogin.click();

             Thread.sleep(500);
             WebElement infoMsg = driver.findElement(By.xpath("//p[@class='infoMsg']"));
             String infoMsgValue = infoMsg.getText();

             Assert.assertEquals("Please use temporary password 'rahulshettyacademy' to Login.", infoMsgValue);

        } finally {
            driver.quit();
        }
     }
     @Test
     public void locatorsPart2() throws InterruptedException {
         //Generating Cxx selectors based on regular expressions
         String name = "Nat";
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         String password = getPassword(driver);

         driver.get("https://rahulshettyacademy.com/locatorspractice/");

         WebElement nameInput = driver.findElement(By.cssSelector("#inputUsername"));
         nameInput.sendKeys(name);

         WebElement getPassword = driver.findElement(By.cssSelector("input[type*='pass']")); //* regular exp
         getPassword.sendKeys(password);

         WebElement rememberMyUserNameCheckbox = driver.findElement(By.xpath("//input[@id='chkboxOne']"));
         rememberMyUserNameCheckbox.click();
         WebElement submitButton = driver.findElement(By.xpath("//button[contains(@class, 'submit')]")); //contains method for xpath

         submitButton.click();
         Thread.sleep(1000);
         WebElement successLoginText = driver.findElement(By.tagName("p"));
         String successLoginTextVal = successLoginText.getText();
         Assert.assertEquals("You are successfully logged in.", successLoginTextVal);

         WebElement helloText = driver.findElement(By.tagName("h2"));
         String nameVal = helloText.getText();
         Assert.assertEquals("Hello " + name + ",", nameVal);

         WebElement logoutBtn = driver.findElement(By.xpath("//button[text()='Log Out']"));

         driver.close();
       }
       public static String getPassword(WebDriver driver) throws InterruptedException {

           driver.get("https://rahulshettyacademy.com/locatorspractice/");
           WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password?"));
           forgotPasswordLink.click();
           Thread.sleep(1000);

           WebElement resetLogin = driver.findElement(By.xpath("//button[@class='reset-pwd-btn']"));
           resetLogin.click();

           WebElement infoMsg = driver.findElement(By.xpath("//p[@class='infoMsg']"));
           String passwordText = infoMsg.getText();
             //"Please use temporary password 'rahulshettyacademy' to Login."
           String[] passwordArray = passwordText.split("'");
           //oth index - Please use temporary password
           //1th index - rahulshettyacademy' to Login.

           String password = passwordArray[1].split("'")[0];
           return password;
       }




   }

