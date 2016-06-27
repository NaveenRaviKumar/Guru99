package utility;

import java.util.Hashtable;



public class Utility {
	
	
	public static boolean isExecutable(String test_name, excel_reader excel){
		
		String sheetName="testcases";
		for(int rowNum=2;rowNum<=excel.getRowCount(sheetName);rowNum++){
			
			if(excel.getCellData(sheetName, "test_name", rowNum).equals(test_name)){
						
				if(excel.getCellData(sheetName, "runmode", rowNum).equalsIgnoreCase("Y"))
						return true;
					else
						return false;
				
			}
		}
		
		return false;
		
	}
	
	/*
	//TestNG Parameterization
		public static Object[][] getData(String sheetName, excel_reader excel){
			int rows = excel.getRowCount(sheetName);  
			int cols = excel.getColumnCount(sheetName);
			Object data[][] = new Object[rows-1][cols];
			
			for( int rowNum = 2 ; rowNum <= rows ; rowNum++){
				
				for(int colNum=0 ; colNum< cols; colNum++){
					data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
				}
			}
			
			return data;
		}*/
		
		//TestNG Parameterization using HashTable
				public static Object[][] getData(String sheetName, excel_reader excel){
					int rows = excel.getRowCount(sheetName);
					int cols= excel.getColumnCount(sheetName);
					
					Object[][] data = new Object[rows-1][1];
				Hashtable<String,String> table = null;
					
					for(int rowNum = 2 ; rowNum <= rows ; rowNum++){ //2
						
					table = new Hashtable<String,String>();	
						
						for(int colNum=0 ; colNum< cols; colNum++){
						
						table.put(excel.getCellData(sheetName,colNum,1),excel.getCellData(sheetName,colNum,rowNum));
						data[rows-2][0]=table;
						}
					}
					
					return data;
					
					}

		
	

}
