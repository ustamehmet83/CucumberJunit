package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.jcajce.provider.asymmetric.util.GOST3410Util;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {


    @Test
    public void read_from_excel_file() throws IOException {
        String path = "SampleData.xlsx";
        //to read from excel we need to load i to FileInput Stream
        FileInputStream fileInputStream = new FileInputStream(path);

        // workbook>sheet>row>cell
        //<1> Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //<2> Wee need to get specific sheet from currently opened workbook

        XSSFSheet sheet = workbook.getSheet("Employees");

        //<3>Select row and cell
        //Print out mary's cell
        //Indexes start from 0
        System.out.println(sheet.getRow(1).getCell(0));

        //print out Developer's cell
        System.out.println(sheet.getRow(3).getCell(2));

        // Return the count of used cells only
        //Starts counting from 1

        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        //Return the number from top cell to bottom cell
        // it doesn't care if the cell is empty or not
        //Starts counting from 0
        int lastUsedRows = sheet.getLastRowNum();
        System.out.println(lastUsedRows);
        ;


        //TODO: Create a logic to print Vinod's name row and cell
        int cellNum = 0;
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            for (cellNum = 0; cellNum <sheet.getRow(rowNum).getLastCellNum() ; cellNum++)
                if (sheet.getRow(rowNum).getCell(cellNum).toString().equals("Developer")) {
                    System.out.println("Row number: "+rowNum + " " +"Cell number :"+ cellNum);
                }
        }

        //TODO: Create a logic to print Linda's job ID
        // Chack if name is Linda--> print out Job_Id of Linda

        for (int rowNum=0;rowNum<usedRows;rowNum++){
            for (cellNum = 0; cellNum <sheet.getRow(rowNum).getLastCellNum() ; cellNum++)
            if (sheet.getRow(rowNum).getCell(cellNum).toString().equals("Linda")){
                System.out.println("Linda's job ID :"+sheet.getRow(rowNum).getCell(cellNum+2));
            }
        }



    }


}

