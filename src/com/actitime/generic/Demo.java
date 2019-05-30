package com.actitime.generic;



public class Demo {

	public static void main(String[] args) 
	{
		String data= ExcelData.getData("./data/input.xlsx", "Sheet1", 0, 0);
		System.out.println(data);
		int rowcount = ExcelData.getRowCount("./data/input.xlsx", "Sheet1");
		System.out.println(rowcount);
		int cellcount = ExcelData.getCellCount("./data/input.xlsx", "Sheet1", 0);
		System.out.println(cellcount);
	}

}

