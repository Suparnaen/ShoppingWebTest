package com.shop.dataprovider;

import com.shop.utility.NewExcelLibrary;
import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author - Suparna Das added on 4/9/2022
 */
public class DataProviders {

    NewExcelLibrary obj = new NewExcelLibrary();

    @org.testng.annotations.DataProvider(name = "credentials")
    public Object[][] getCredentials(){
        int rows = obj.getRowCount("Credentials");
        int columns = obj.getColumnCount("Credentials");
        int actRows = rows -1;
        Object[][] data = new Object[actRows][columns];

        for(int i=0;i< actRows;i++){
            for(int j=0; j< columns; j++){
                data[i][j] = obj.getCellData("Credentials",j,i+2);
            }
        }
        return data;
    }

    @org.testng.annotations.DataProvider(name = "email")
    public Object[][] getEmail(){
        int rows = obj.getRowCount("Email");
        int columns = obj.getColumnCount("Email");
        int actRows = rows -1;
        Object[][] data = new Object[actRows][columns];

        for(int i=0;i< actRows;i++){
            for(int j=0; j< columns; j++){
                data[i][j] = obj.getCellData("Email",j,i+2);
            }
        }
        return data;
    }

    @org.testng.annotations.DataProvider(name = "getProduct")
    public Object[][] getProduct(){
        int rows = obj.getRowCount("ProductDetails");
        int columns = obj.getColumnCount("ProductDetails");
        int actRows = rows -1;
        Object[][] data = new Object[actRows][columns];

        for(int i=0;i< actRows;i++){
            for(int j=0; j< columns; j++){
                data[i][j] = obj.getCellData("ProductDetails",j,i+2);
            }
        }
        return data;
    }

    @org.testng.annotations.DataProvider(name = "searchProduct")
    public Object[][] getProductPrice(){
        int rows = obj.getRowCount("SearchProduct");
        int columns = obj.getColumnCount("SearchProduct");
        int actRows = rows -1;
        Object[][] data = new Object[actRows][columns];

        for(int i=0;i< actRows;i++){
            for(int j=0; j< columns; j++){
                data[i][j] = obj.getCellData("SearchProduct",j,i+2);
            }
        }
        return data;
    }

    @org.testng.annotations.DataProvider(name = "newAcountDetailsData")
    public Object[][] accountCreation() {

        // Totals rows count
        int rows = obj.getRowCount("AccountCreationData");
        // Total Columns
        int column = obj.getColumnCount("AccountCreationData");
        int actRows = rows - 1;
        //Created an object of array to store data
        Object[][] data = new Object[actRows][1];

        for (int i = 0; i < actRows; i++) {
            Map<String, String> hashMap = new HashMap<>();
            for (int j = 0; j < column; j++) {
                hashMap.put(obj.getCellData("AccountCreationData", j, 1),
                        obj.getCellData("AccountCreationData", j, i + 2));
            }
            data[i][0]=hashMap;
        }
        return data;
    }

}
