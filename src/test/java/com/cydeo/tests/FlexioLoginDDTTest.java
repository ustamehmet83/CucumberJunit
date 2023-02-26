package com.cydeo.tests;

import com.cydeo.pages.FidexioLoginPage;
import com.cydeo.pages.FlexioDashBoardPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.Before;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class FlexioLoginDDTTest {
    FidexioLoginPage fidexioLoginPage = new FidexioLoginPage();
    FlexioDashBoardPage dashBoardPage = new FlexioDashBoardPage();


    @Test
    public void loginDDTTest() throws IOException {
        Driver.getDriver().get(ConfigurationReader.getProperty("fidexio.url"));
        String filePath = "FlexioQaUser.xlsx";
        FileInputStream in = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheet("data");

        for (int numRow = 1; numRow < sheet.getLastRowNum(); numRow++) {
            String username = sheet.getRow(numRow).getCell(0).toString();
            String password = sheet.getRow(numRow).getCell(1).toString();
            fidexioLoginPage.loginUser.sendKeys(username);
            fidexioLoginPage.loginPass.sendKeys(password);
            fidexioLoginPage.loginBtn.click();
            dashBoardPage.fullName.click();
            dashBoardPage.logOutLink.click();


        }
    }
}
