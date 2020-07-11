package Week2_HW;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquarelotronTest {

	@Test
	public void testSquarelotron1() {
		Squarelotron testSquarelotron = new Squarelotron(2);
		assertEquals(2, testSquarelotron.size);
		assertEquals(1, testSquarelotron.squarelotron[0][0]);
		assertEquals(2, testSquarelotron.squarelotron[0][1]);
		assertEquals(3, testSquarelotron.squarelotron[1][0]);
		assertEquals(4, testSquarelotron.squarelotron[1][1]);
	}
	
	@Test
	public void testSquarelotron2() {
		Squarelotron testSquarelotron = new Squarelotron(3);
		assertEquals(3, testSquarelotron.size);
		assertEquals(1, testSquarelotron.squarelotron[0][0]);
		assertEquals(2, testSquarelotron.squarelotron[0][1]);
		assertEquals(3, testSquarelotron.squarelotron[0][2]);
		assertEquals(4, testSquarelotron.squarelotron[1][0]);
		assertEquals(5, testSquarelotron.squarelotron[1][1]);
		assertEquals(6, testSquarelotron.squarelotron[1][2]);
		assertEquals(7, testSquarelotron.squarelotron[2][0]);
		assertEquals(8, testSquarelotron.squarelotron[2][1]);
		assertEquals(9, testSquarelotron.squarelotron[2][2]);
	}
	
	public void testSquarelotron8() {
		Squarelotron testSquarelotron = new Squarelotron(8);
		assertEquals(8, testSquarelotron.size);
		assertEquals(1, testSquarelotron.squarelotron[0][0]);
		assertEquals(2, testSquarelotron.squarelotron[0][1]);
		assertEquals(3, testSquarelotron.squarelotron[0][2]);
		assertEquals(4, testSquarelotron.squarelotron[0][3]);
		assertEquals(5, testSquarelotron.squarelotron[0][4]);
		assertEquals(6, testSquarelotron.squarelotron[0][5]);
		assertEquals(7, testSquarelotron.squarelotron[0][6]);
		assertEquals(8, testSquarelotron.squarelotron[0][7]);
	
		assertEquals(57, testSquarelotron.squarelotron[7][0]);
		assertEquals(58, testSquarelotron.squarelotron[7][1]);
		assertEquals(59, testSquarelotron.squarelotron[7][2]);
		assertEquals(60, testSquarelotron.squarelotron[7][3]);
		assertEquals(61, testSquarelotron.squarelotron[7][4]);
		assertEquals(62, testSquarelotron.squarelotron[7][5]);
		assertEquals(63, testSquarelotron.squarelotron[7][6]);
		assertEquals(64, testSquarelotron.squarelotron[7][7]);
		
	}

	@Test
	public void testUpsideDownFlip1() {
		Squarelotron testSquarelotron = new Squarelotron(4);
		testSquarelotron = testSquarelotron.upsideDownFlip(1);
		assertEquals(13, testSquarelotron.squarelotron[0][0]);
		assertEquals(15, testSquarelotron.squarelotron[0][2]);
		assertEquals(9, testSquarelotron.squarelotron[1][0]);
		assertEquals(6, testSquarelotron.squarelotron[1][1]);
		assertEquals(8, testSquarelotron.squarelotron[2][3]);
		assertEquals(4, testSquarelotron.squarelotron[3][3]);
	}
	
	@Test
	public void testUpsideDownFlip2() {
		Squarelotron testSquarelotron = new Squarelotron(5);
		testSquarelotron = testSquarelotron.upsideDownFlip(2);
		assertEquals(1, testSquarelotron.squarelotron[0][0]);
		assertEquals(3, testSquarelotron.squarelotron[0][2]);
		assertEquals(5, testSquarelotron.squarelotron[0][4]);
		
		assertEquals(6, testSquarelotron.squarelotron[1][0]);
		assertEquals(18, testSquarelotron.squarelotron[1][2]);
		assertEquals(10, testSquarelotron.squarelotron[1][4]);
		
		assertEquals(16, testSquarelotron.squarelotron[3][0]);
		assertEquals(8, testSquarelotron.squarelotron[3][2]);
		assertEquals(20, testSquarelotron.squarelotron[3][4]);
		
		assertEquals(21, testSquarelotron.squarelotron[4][0]);
		assertEquals(23, testSquarelotron.squarelotron[4][2]);
		assertEquals(25, testSquarelotron.squarelotron[4][4]);

	}
	
	@Test
	public void testUpsideDownFlip3() {
		Squarelotron testSquarelotron = new Squarelotron(5);
		testSquarelotron = testSquarelotron.upsideDownFlip(1);
		assertEquals(21, testSquarelotron.squarelotron[0][0]);
		assertEquals(23, testSquarelotron.squarelotron[0][2]);
		assertEquals(25, testSquarelotron.squarelotron[0][4]);
		
		assertEquals(11, testSquarelotron.squarelotron[2][0]);
		assertEquals(13, testSquarelotron.squarelotron[2][2]);
		assertEquals(15, testSquarelotron.squarelotron[2][4]);
		
		assertEquals(1, testSquarelotron.squarelotron[4][0]);
		assertEquals(3, testSquarelotron.squarelotron[4][2]);
		assertEquals(5, testSquarelotron.squarelotron[4][4]);

	}

	@Test
	public void testMainDiagonalFlip1() {
		Squarelotron testSquarelotron = new Squarelotron(5);
		testSquarelotron = testSquarelotron.mainDiagonalFlip(1);
		assertEquals(1, testSquarelotron.squarelotron[0][0]);
		assertEquals(11, testSquarelotron.squarelotron[0][2]);
		assertEquals(21, testSquarelotron.squarelotron[0][4]);
		
		assertEquals(3, testSquarelotron.squarelotron[2][0]);
		assertEquals(13, testSquarelotron.squarelotron[2][2]);
		assertEquals(23, testSquarelotron.squarelotron[2][4]);
		
		assertEquals(5, testSquarelotron.squarelotron[4][0]);
		assertEquals(15, testSquarelotron.squarelotron[4][2]);
		assertEquals(25, testSquarelotron.squarelotron[4][4]);
	}
	
	@Test
	public void testMainDiagonalFlip2() {
		Squarelotron testSquarelotron = new Squarelotron(4);
		testSquarelotron = testSquarelotron.mainDiagonalFlip(1);
		assertEquals(13, testSquarelotron.squarelotron[0][3]);
		assertEquals(2, testSquarelotron.squarelotron[1][0]);
		assertEquals(6, testSquarelotron.squarelotron[1][1]);
		assertEquals(7, testSquarelotron.squarelotron[1][2]);
		assertEquals(12, testSquarelotron.squarelotron[3][2]);
	}
	
	@Test
	public void testMainDiagonalFlip3() {
		Squarelotron testSquarelotron = new Squarelotron(2);
		testSquarelotron = testSquarelotron.mainDiagonalFlip(1);
		assertEquals(1, testSquarelotron.squarelotron[0][0]);
		assertEquals(3, testSquarelotron.squarelotron[0][1]);
		assertEquals(2, testSquarelotron.squarelotron[1][0]);
		assertEquals(4, testSquarelotron.squarelotron[1][1]);
	}
	
	@Test
	public void testMainDiagonalFlip4() {
		Squarelotron testSquarelotron = new Squarelotron(3);
		testSquarelotron = testSquarelotron.mainDiagonalFlip(1);
		assertEquals(4, testSquarelotron.squarelotron[0][1]);
		assertEquals(2, testSquarelotron.squarelotron[1][0]);
		assertEquals(8, testSquarelotron.squarelotron[1][2]);
		assertEquals(6, testSquarelotron.squarelotron[2][1]);
	}
	
	@Test
	public void testUpsideDownFlip5() {
		Squarelotron testSquarelotron = new Squarelotron(4);
		testSquarelotron = testSquarelotron.upsideDownFlip(2);
		assertEquals(13, testSquarelotron.squarelotron[3][0]);
		assertEquals(15, testSquarelotron.squarelotron[3][2]);
		assertEquals(6, testSquarelotron.squarelotron[2][1]);
		assertEquals(7, testSquarelotron.squarelotron[2][2]);
		assertEquals(11, testSquarelotron.squarelotron[1][2]);
	}

	@Test 
	public void testRotateRight1() {
		Squarelotron testSquarelotron = new Squarelotron(2);
		testSquarelotron.rotateRight(1);
		assertEquals(3, testSquarelotron.squarelotron[0][0]);
		assertEquals(1, testSquarelotron.squarelotron[0][1]);
		assertEquals(4, testSquarelotron.squarelotron[1][0]);
		assertEquals(2, testSquarelotron.squarelotron[1][1]);
	}
	
	@Test 
	public void testRotateRight2() {
		Squarelotron testSquarelotron = new Squarelotron(2);
		testSquarelotron.rotateRight(-1);
		assertEquals(2, testSquarelotron.squarelotron[0][0]);
		assertEquals(4, testSquarelotron.squarelotron[0][1]);
		assertEquals(1, testSquarelotron.squarelotron[1][0]);
		assertEquals(3, testSquarelotron.squarelotron[1][1]);
	}
	
	@Test 
	public void testRotateRight3() {
		Squarelotron testSquarelotron = new Squarelotron(2);
		testSquarelotron.rotateRight(2);
		assertEquals(4, testSquarelotron.squarelotron[0][0]);
		assertEquals(3, testSquarelotron.squarelotron[0][1]);
		assertEquals(2, testSquarelotron.squarelotron[1][0]);
		assertEquals(1, testSquarelotron.squarelotron[1][1]);
	}
	
	@Test 
	public void testRotateRight4() {
		Squarelotron testSquarelotron = new Squarelotron(3);
		testSquarelotron.rotateRight(1);
		assertEquals(1, testSquarelotron.squarelotron[0][2]);
		assertEquals(2, testSquarelotron.squarelotron[1][2]);
		assertEquals(3, testSquarelotron.squarelotron[2][2]);
		assertEquals(4, testSquarelotron.squarelotron[0][1]);
		assertEquals(5, testSquarelotron.squarelotron[1][1]);
	}

}
