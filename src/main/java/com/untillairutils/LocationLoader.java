package com.untillairutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationLoader {

    String url;
    String login;
    String password;
    WebDriver driver;
    String location;

    public LocationLoader(String url, String login, String password, String location) {
        this.url = url;
        this.login = login;
        this.password = password;
        this.driver = new ChromeDriver();
        this.location = location;

    }

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out
                    .print("Syntax: LocationLoader <url> <username> <password> <locationname>");
            System.exit(1);
        }
        LocationLoader loader = new LocationLoader(args[0], args[1], args[2], args[3]);

        loader.loadLocation();

    }

    private void initSettings() {
        Helpers.clickByXpath(driver, "//span[text()='Settings']");
        Helpers.clickByXpath(driver, "//li[text()='Location']");

        WebElement checkbox = driver.findElement(By.xpath("//input[@id='UseCourses']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
            Helpers.clickByXpath(driver, "//button[@type='submit']");
        }
    }

    private void loadCategories() {

        Helpers.clickByXpath(driver, "//span[text()='Categories']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ExpectedCondition<WebElement> c1 = ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Add new category']"));
        ExpectedCondition<WebElement> c2 = ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Add your first category']"));
        wait.until(ExpectedConditions.or(c1, c2));

        Article[] articles = Article.getTestArticles();
        for (Article a : articles) {
            String xp = String.format("//span[text()='%s']", a.category);
            if (driver.findElements(By.xpath(xp)).size() == 0) {
                Helpers.clickByXpath(driver, "//span[text()='Add new category']");
                Helpers.inputById(driver, "names_0", a.category);

                // TODO: make like... String continueXP2 = String.format("//span[text()='%s']",
                // Labels.CONTINUE);

                String continueXP = "//span[text()='Continue']";
                Helpers.clickByXpath(driver, continueXP);
                Helpers.waitInvisibleByXpath(driver, continueXP);
                Helpers.waitVisibleByXpath(driver, xp);
            }
        }
    }

    private void loadFoodGroups() {
        Helpers.clickByXpath(driver, "//span[text()='Groups']");
        Helpers.waitByXpath(driver, "//span[text()='Add new group']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ExpectedCondition<WebElement> c1 = ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Add new group']"));
        ExpectedCondition<WebElement> c2 = ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Add your first group']"));
        wait.until(ExpectedConditions.or(c1, c2));

        Map<String, String> foodGroups = new HashMap<>();
        Article[] articles = Article.getTestArticles();
        for (Article a : articles) {
            foodGroups.put(a.foodGroup, a.category);
        }

        for (Map.Entry<String, String> entry : foodGroups.entrySet()) {
            String foodGroup = entry.getKey();
            String category = entry.getValue();

            String searchFG = "//input[contains(@class, 'ant-input-borderless')]";
            if (driver.findElements(By.xpath(searchFG)).size() > 0) {
                Helpers.inputByXpath(driver, searchFG, foodGroup);
            }

            String xp = String.format("//span[text()='%s']", foodGroup);

            if (driver.findElements(By.xpath(xp)).size() == 0) {
                driver.findElement(By.xpath("//span[text()='Add new group']")).click();
                Helpers.inputById(driver, "name", foodGroup);
                driver.findElement(By.id("id_category")).click();
                xp = String.format("//div[@class='ant-select-item-option-content' and text()='%s']", category);
                Helpers.clickByXpath(driver, xp);

                driver.findElement(By.id("id_vat")).click();
                xp = String.format("//div[@class='ant-select-item-option-content' and text()='%s']", "Zero");
                Helpers.clickByXpath(driver, xp);

                String continueXp = "//span[text()='Continue']";
                Helpers.clickByXpath(driver, continueXp);
                Helpers.waitInvisibleByXpath(driver, continueXp);

            }

        }
        Helpers.inputByXpath(driver, "//input[contains(@class, 'ant-input-borderless')]", "");

    }

    private void loadDepartmens() {
        Helpers.clickByXpath(driver, "//span[text()='Departments']");
        Helpers.waitByXpath(driver, "//span[text()='Add new department']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ExpectedCondition<WebElement> c1 = ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Add new department']"));
        ExpectedCondition<WebElement> c2 = ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Add your first department']"));
        wait.until(ExpectedConditions.or(c1, c2));

        Map<String, String> departmens = new HashMap<>();
        Article[] articles = Article.getTestArticles();
        for (Article a : articles) {
            departmens.put(a.department, a.foodGroup);
        }
        for (Map.Entry<String, String> entry : departmens.entrySet()) {
            String department = entry.getKey();
            String foodGroup = entry.getValue();

            String searchDep = "//input[contains(@class, 'ant-input-borderless')]";
            if (driver.findElements(By.xpath(searchDep)).size() > 0) {
                Helpers.inputByXpath(driver, searchDep, department);
            }
            String xp = String.format("//span[text()='%s']", department);
            if (driver.findElements(By.xpath(xp)).size() == 0) {
                driver.findElement(By.xpath("//span[text()='Add new department']")).click();
                Helpers.inputById(driver, "name", department);

                Helpers.selectDropDownItemById(driver, "id_food_group", foodGroup);

                String saveXp = "//span[text()='Save']";
                Helpers.clickByXpath(driver, saveXp);
                Helpers.waitInvisibleByXpath(driver, saveXp);

            }
        }
    }

    private void loadCourses() {
        Helpers.clickByXpath(driver, "//span[text()='Courses']");
        Helpers.waitByXpath(driver, "//span[text()='Add new course']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ExpectedCondition<WebElement> c1 = ExpectedConditions
                .elementToBeClickable(By.xpath("//tbody[@Class='ant-table-tbody']"));
        ExpectedCondition<WebElement> c2 = ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Add your first course']"));
        wait.until(ExpectedConditions.or(c1, c2));

        String xp = String.format("//span[text()='%s']", "Default course");
        if (driver.findElements(By.xpath(xp)).size() == 0) {
            Helpers.clickByXpath(driver, "//span[text()='Add new course']");
            Helpers.inputById(driver, "name", "Default course");

            String continueXP = "//span[text()='Continue']";
            Helpers.clickByXpath(driver, continueXP);
            Helpers.waitInvisibleByXpath(driver, continueXP);
        }
    }

    private void loadArticles() {
        Helpers.clickByXpath(driver, "//span[text()='Articles']");
        Helpers.waitByXpath(driver, "//span[text()='Add new article']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ExpectedCondition<WebElement> c1 = ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Add new article']"));
        ExpectedCondition<WebElement> c2 = ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Add your first article']"));
        wait.until(ExpectedConditions.or(c1, c2));

        Article[] articles = Article.getTestArticles();

        for (Article a : articles) {

            String searchArticle = "//input[contains(@class, 'ant-input-borderless')]";
            if (driver.findElements(By.xpath(searchArticle)).size() > 0) {
                Helpers.inputByXpath(driver, searchArticle, a.name);
            }
            String xp = String.format("//span[text()='%s']", a.name);
            if (driver.findElements(By.xpath(xp)).size() == 0) {
                Helpers.clickByXpathWithAttempts(driver, "//span[text()='Add new article']", 100);
                Helpers.inputById(driver, "name", a.name);

                String inputPrice = "//input[contains(@class, 'ant-input-number-input')]";

                Helpers.inputByXpath(driver, inputPrice, Helpers.formatDbl(a.price));

                Helpers.selectDropDownItemById(driver, "id_departament", a.department);

                Helpers.selectDropDownItemById(driver, "id_courses", "No course");

                String saveXp = "//span[text()='Save']";
                Helpers.clickByXpath(driver, saveXp);
                Actions actions = new Actions(driver);
                actions.moveByOffset(0, 50);
                Helpers.waitInvisibleByXpath(driver, saveXp);
            }
        }

    }

    private void loadPosUsers() {
        Helpers.clickByXpath(driver, "//span[text()='POS Users']");
        Helpers.waitByXpath(driver, "//span[text()='Add new user']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ExpectedCondition<WebElement> c1 = ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Add new user']"));
        ExpectedCondition<WebElement> c2 = ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Add your first user']"));
        wait.until(ExpectedConditions.or(c1, c2));

        User[] users = User.inputUsers();
        for (User s : users) {
            String searchUser = "//input[contains(@class, 'ant-input-borderless')]";
            if (driver.findElements(By.xpath(searchUser)).size() > 0) {
                Helpers.inputByXpath(driver, searchUser, s.displayName);
            }
            String inputDisplayName = String.format("//span[text()='%s']", s.displayName);
            if (driver.findElements(By.xpath(inputDisplayName)).size() == 0) {
                Helpers.clickByXpathWithAttempts(driver, "//span[text()='Add new user']", 100);
                Helpers.inputById(driver, "name", s.displayName);
                Helpers.inputById(driver, "firstname", s.firstName);
                Helpers.inputById(driver, "lastname", s.lastName);
                Helpers.selectDropDownItemById(driver, "language", s.language);
                Helpers.inputById(driver, "user_poscode", s.posPassword);
                String saveXp = "//span[text()='Save']";
                Helpers.clickByXpath(driver, saveXp);
            }
        }

    }

    private void loadPrinters() {
        Helpers.clickByXpathWithAttempts(driver, "//span[text()='General']", 10);
        Helpers.clickByXpath(driver, "//span[text()='Equipment']");
        Helpers.waitByXpath(driver, "//span[text()='Add new equipment']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ExpectedCondition<WebElement> c1 = ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Add new equipment']"));
        ExpectedCondition<WebElement> c2 = ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Add your first equipment']"));
        wait.until(ExpectedConditions.or(c1, c2));


        Printer[] printers = Printer.inputPrinters();
        for (Printer p : printers) {
            String searchPrinter = "//input[contains(@class, 'ant-input-borderless')]";
            if (driver.findElements(By.xpath(searchPrinter)).size() > 0) {
                Helpers.inputByXpath(driver, searchPrinter, p.name);
            }
            String inputPrinterName = String.format("//span[text()='%s']", p.name);
            //String inputPrinterName = String.format("//input[@value='%s']", p.name);
            if (driver.findElements(By.xpath(inputPrinterName)).size() == 0) {
                Helpers.clickByXpathWithAttempts(driver, "//span[text()='Add new equipment']", 100);
                Helpers.clickByXpathWithAttempts(driver, "//div[@class='style_element__URMig'][2]", 100);
                Helpers.clickByXpath(driver, "//span[text()='Continue']");
                Helpers.inputById(driver, "name", p.name);
                Helpers.clickByXpath(driver, "//span[text()='Receipt']");
                //Helpers.selectDropDownItemById(driver, "driver_id", p.brand);
                Helpers.scrollAndClickByXpath(driver, "//span[@class='ant-checkbox']/input[@id='null_print']");
                String saveXp = "//span[text()='Save']";
                Helpers.clickByXpath(driver, saveXp);
                Helpers.waitVisibleByXpath(driver, "//span[text()='Add equipment']");
                Helpers.clickByXpathWithAttempts(driver, "//span[text()='Ok']", 10);
                Helpers.clickByXpath(driver, "//span[text()='General']");
            }
        }
    }

    private void loadSpaces() {
        Helpers.clickByXpath(driver, "//span[text()='Spaces']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ExpectedCondition<WebElement> c1 = ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Add new space']"));
        ExpectedCondition<WebElement> c2 = ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Add your first space']"));
        wait.until(ExpectedConditions.or(c1, c2));

        Space[] spaces = Space.inputSpaces();
        for (Space s : spaces) {
            String searchSpace = "//input[contains(@class, 'ant-input-borderless')]";
            if (driver.findElements(By.xpath(searchSpace)).size() > 0) {
                Helpers.inputByXpath(driver, searchSpace, s.name);
            }
            String inputSpaceName = String.format("//span[text()='%s']", s.name);
            //String inputPrinterName = String.format("//input[@value='%s']", p.name);
            if (driver.findElements(By.xpath(inputSpaceName)).size() == 0) {
                Helpers.clickByXpathWithAttempts(driver, "//span[text()='Add new space']", 10);
                Helpers.inputById(driver, "name", s.name);
                Helpers.inputByXpath(driver, "//input[@role='spinbutton']", s.numberOfTables);
                String saveXp = "//span[text()='Continue']";
                Helpers.clickByXpath(driver, saveXp);

            }

        }
    }

    public void loadLocation() {

        driver.get(url);
        driver.manage().window().maximize();
        Auth.login(driver, login, password);

        Helpers.waitVisibleByXpath(driver, "//header");
        String locationXPATH = "//header//div[contains(@class, 'ant-select')]";
        List<WebElement> chooseLocation = driver.findElements(By.xpath(locationXPATH));

        if (chooseLocation.size() != 0) {
            Helpers.selectDropDownItemByXpath(driver, locationXPATH, location);
        } else {
            ////header//span[text()='SingingBird']
        }

        initSettings();

        Helpers.clickByXpath(driver, "//span[text()='Products']");


        loadCategories();
        loadFoodGroups();
        loadDepartmens();
        loadCourses();
        loadArticles();
        loadPosUsers();
        loadPrinters();
//            loadSpaces();

    }

}

