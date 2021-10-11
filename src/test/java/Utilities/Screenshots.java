/***************************************************************************************************************
 /**
 * Helper file save screenshots and attaching into reports
 *
 * @author  Vaibhav Khachane
 * @since   26/03/2020
 */

package Utilities;

import stepDef.ServiceHooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshots {
    public static String takeScreenShots(String screenshotName) throws IOException {
        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        File sourceFile = ((TakesScreenshot) ServiceHooks.driver).getScreenshotAs(OutputType.FILE);
        String imgPath =  "StepScreenshots/" + screenshotName + "_"+ timestamp + ".png";
        File path = new File("./report/maven-JVM-report/Maven-Extent-Reports/" + imgPath);
        FileUtils.copyFile(sourceFile, path);
        return imgPath;
    }

}