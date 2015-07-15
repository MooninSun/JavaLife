package com.laboon;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class TestToString {
	
	//Test return value of method toString when World size is 0
	@Test
	public void testSizeZero() {
		World world=new World(0,1,1);
		String retValue=world.toString();
		assertEquals(retValue,"  \n");
		
	}
	
	//Test return value of method toString when World size is 1
	@Test
	public void testSizeOne() {
		World world=new World(1,1,1);
		Cell cell=mock(Cell.class);
		world._world[0][0]=cell;
		when(cell.getStateRep()).thenReturn('.');
		String retValue=world.toString();
		assertEquals(retValue,"  0\n0 .\n");
	}
	
	//Test first row of return value of method toString when World size is 50
	@Test
	public void testSizeNormal() {
		World world=new World(50,1,1);
		for(int i=0;i<50;i++){
			for(int j=0;j<50;j++){
				Cell cell=mock(Cell.class);
				world._world[i][j]=cell;
				when(cell.getStateRep()).thenReturn('.');
			}
		}	
		String retValue=world.toString();
		String[] part=retValue.split("\n");
		assertEquals(part[0],"  01234567890123456789012345678901234567890123456789");
	}
	
	//Test row number of return value of method toString when World size is 1000
	@Test
	public void testSizeInf() {
		World world=new World(400,1,1);
		for(int i=0;i<400;i++){
			for(int j=0;j<200;j++){
				Cell cell=mock(Cell.class);
				world._world[i][j]=cell;
				when(cell.getStateRep()).thenReturn('.');
			}
		}
		String retValue=world.toString();
		String[] part=retValue.split("\n");
		assertEquals(part.length,401);
	}
}
