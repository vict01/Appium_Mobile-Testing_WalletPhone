package N26.company;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class MonefyMainClass extends MonefyBaseClass {

    public static void main(String[] args) throws MalformedURLException, Exception {
    //Enter income:
        String incomeAmount = "4385.55";
    //Enter Expense:
        String expenseAmount = "1569.44";

     //Instantiating driver element:
        AndroidDriver<AndroidElement> driver = null;
        try {
            driver = capabilities();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        assert driver != null;
        final WebDriver.Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Adding new Income:
       driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.monefy.app.lite:id/income_button']").click();
       typeAmountId(incomeAmount, driver);
        // Indicating Income Category:
       driver.findElementById("com.monefy.app.lite:id/textViewChooseCategory").click();
       driver.findElementById("com.monefy.app.lite:id/imageView").click();

        // Adding new Expense:
        driver.findElementById("com.monefy.app.lite:id/expense_button").click();
        typeAmountId(expenseAmount, driver);
        // Indicating Expense Category:
        driver.findElementById("com.monefy.app.lite:id/relativeLayoutChooseCategory").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Entertainment']").click();

        /* Validating balance against income - expense: */
        //Getting balance:
        AndroidElement balance = driver.findElementById("com.monefy.app.lite:id/balance_amount");
        balance.click();
        int balanceLength = balance.getText().length();
        String balanceAmount = balance.getText().substring(9, balanceLength);
        balanceAmount = removeChar(balanceAmount, ",");
        double newBalance = str2tDouble(balanceAmount);

        // Defining common Id for Incomes and Expenses:
        String id = "com.monefy.app.lite:id/textViewWholeAmount";

       //Getting income:
        int incomeLength = typeElementId(driver, id).get(0).getText().length();
        String income = typeElementId(driver, id).get(0).getText().substring(1, incomeLength);
        income = removeChar(income, ",");
        double newIncome = str2tDouble(income);

        //Getting expense:
        int expenseLength = typeElementId(driver, id).get(1).getText().length();
        String expense = typeElementId(driver, id).get(1).getText().substring(1, expenseLength);
        expense = removeChar(expense, ",");
        double newExpense = str2tDouble(expense);

        // Subtract income minus expense:
        double validation = restTwoNum(newIncome, newExpense);
        validation = formatDouble(validation);
        newBalance = formatDouble(newBalance);
        printElement("The balance is: " + newIncome + " - " + newExpense + " = Balance(" + newBalance + ") or (Incomes - Expenses)"+ validation);

        //Obtained result in test execution:
        if (areEqual(validation, newBalance))
            printElement("Successful calculation!");
        else
            printElement("Failed calculation!");

    }

}
