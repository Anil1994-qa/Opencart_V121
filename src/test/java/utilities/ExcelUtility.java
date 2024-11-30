package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
//Create all user defined methods to perform different operations on Excel
public static FileInputStream fi;
public static FileOutputStream fo;
public static XSSFWorkbook wb;
public static XSSFSheet ws;
public static XSSFRow row;
public static XSSFCell cell;
public static CellStyle style;
 String path;


public ExcelUtility(String path) //This constructor is for specifying excel file path
{
	this.path=path;
}
public int getRowCount(String sheetName) throws IOException
{
	fi=new FileInputStream(path);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(sheetName);
	int rowcount=ws.getLastRowNum();
	wb.close();
    fi.close();
	return rowcount;
}
public int getcellCount(String sheetName, int rownum) throws IOException
{
	fi=new FileInputStream(path);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(sheetName);
	row=ws.getRow(rownum);
	int cellcount=row.getLastCellNum();
	wb.close();
	fi.close();
  return cellcount;
}
public String getCellData (String sheetName, int rownum, int colnum) throws IOException
{
            fi=new FileInputStream(path);
            wb=new XSSFWorkbook(fi);
            ws=wb.getSheet(sheetName);
            row=ws.getRow(rownum);
            cell=row.getCell(colnum);

             String data; 
             try
             {
                   //data-cell.toString();
            	 DataFormatter formatter = new DataFormatter();
                 data=formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String rega
             } catch (Exception e)
                  {
                	data="";
                  }
             wb.close();
         	fi.close();
            return data;
}
public void setCellData(String sheetName, int rownum, int celnum, String data) throws IOException
{
                File xlfile=new File(path); 
                if(!xlfile.exists()) //if file not exists then create new file
                {
                	wb=new XSSFWorkbook();
                	fo=new FileOutputStream(path);
                	wb.write(fo); 	
                }
	
				fi=new FileInputStream(path);
			    wb=new XSSFWorkbook(fi);
			    
			    if(wb.getSheetIndex(sheetName)==1) //if file not exists then create new sheet
			    	wb.createSheet(sheetName);	
			      ws=wb.getSheet(sheetName);
			     
			    if(ws.getRow(rownum)==null) //if file not exists then create new Row
			      ws.createRow(rownum);
			     row=ws.getRow(rownum);
			     
			     cell=row.createCell(celnum);
			     cell.setCellValue(data);
			    
			    fo=new FileOutputStream(path);
			    wb.write(fo);
			    wb.close();
	         	fi.close();
			    fo.close();
}
public static void fillGreenColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
{
		fi=new FileInputStream(xlfile); 
		wb=new XSSFWorkbook (fi); 
		ws=wb.getSheet (xlsheet); 
		row=ws.getRow(rownum); 
		cell=row.getCell(colnum);
		style=wb.createCellStyle();
		style.setFillForegroundColor (IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
}
public void fillRedColor( String sheetName, int rownum, int colnum) throws IOException
{
		fi=new FileInputStream(path); 
		wb=new XSSFWorkbook (fi); 
		ws=wb.getSheet (sheetName); 
		row=ws.getRow(rownum); 
		cell=row.getCell(colnum);
		style=wb.createCellStyle();
		style.setFillForegroundColor (IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
}


}