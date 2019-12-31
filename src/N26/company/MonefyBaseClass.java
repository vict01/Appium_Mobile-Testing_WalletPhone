package N26.company;

import java.net.URL;
import java.io.File;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.util.List;
import java.math.BigDecimal;

public class MonefyBaseClass {

    public static  AndroidDriver<AndroidElement> capabilities() throws Exception {
        File apkPath = new File("src");
        File apkName = new File(apkPath, "com.monefy.app.lite_2019-10-27.apk");
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "N26phone");
        cap.setCapability(MobileCapabilityType.APP, apkName.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        return driver;
    }

    public static void typeAmountId(String value, AndroidDriver<AndroidElement> driver) {
        int aLength = value.length();
        int begging = 0;
        String dot = ".";
        driver.findElementById("com.monefy.app.lite:id/buttonKeyboardPlus").click();
        for (int i=1; i<=aLength; i++){
            String aSubstring = value.substring(begging, i);
               if (aSubstring.equals(dot)){
                   aSubstring="Dot";}

            driver.findElementById("com.monefy.app.lite:id/buttonKeyboard"+aSubstring).click();
            begging++;
        }
    }

    public static List<AndroidElement> typeElementId(AndroidDriver<AndroidElement> driver, String str){
        final List<AndroidElement> amounts = driver.findElementsById(str);
        return amounts;
    }

    public static BigDecimal restTwoNum(BigDecimal valueA, BigDecimal valueB) {
        BigDecimal result = new BigDecimal(String.valueOf(valueA)).subtract(valueB);
       return result;
    }

    public static BigDecimal str2BigDecimal (String num){
        BigDecimal newValue = new BigDecimal(num).setScale(2, BigDecimal.ROUND_DOWN);
        return newValue;
    }

    public static String removeChar(String str, String charValue) {
        int aLength = charValue.length();
        int begging = 0;

        for (int i=1; i<=aLength; i++){
            String aSubstring = charValue.substring(begging, i);
            str = str.replace(aSubstring, "");
            begging++;
        }
        return str;
    }

    public static boolean areEqual (BigDecimal firstNumber, BigDecimal secondNumber){
        return firstNumber.equals(secondNumber);
    }

    public static void printElement(String value) {
        System.out.println(value);
    }


}
