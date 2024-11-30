package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String [][]getData() throws IOException
	{
		String path="C:\\Users\\Anil kumar N\\eclipse-workspace\\Opencart_V121\\testData\\OpenCart_LoginData.xlsx"; //taking excel sheet from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);  //Created an object for Excel utility
		
		
		int totalrow=xlutil.getRowCount("sheet1");
		int totalcol=xlutil.getcellCount("sheet1",1);
		
		String loginData[][]=new String [totalrow][totalcol];	//Created for two dimensional array	
		
		for(int i=1; 1<totalrow;i++) //Read the data from excel storing in the two dimensional array
		{
			for(int j=0;j<totalcol;j++) // i is rows and j is column
			{
				loginData[i-1][j]=xlutil.getCellData("sheet1", i, j); //1, 0
			}
		}
		return loginData; //returning two dimension array
	}
	
	
	
	
	
	

}
