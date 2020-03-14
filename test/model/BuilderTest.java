package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BuilderTest {
	
	private Builder b;
	private House[] hs;
	
	public void setUp1(){
		b = new Builder();
	}

	public void setUp2(){
		b = new Builder();
		hs = new House[]{
				new House(87.2,1)
		};
		b.addHouse(hs[0].getArea(), hs[0].getFloors());
	}

	public void setUp3(){
		b = new Builder();
		hs = new House[]{
				new House(87.2,1),
				new House(73.8,2),
				new House(169.5,3),
				new House(69.3,1)
		};
		b.addHouse(hs[0].getArea(), hs[0].getFloors());
		b.addHouse(hs[1].getArea(), hs[1].getFloors());
		b.addHouse(hs[2].getArea(), hs[2].getFloors());
		b.addHouse(hs[3].getArea(), hs[3].getFloors());
	}

	@Test
	public void testAddHouse1() {
		setUp1();
		House h = b.getFirstHouse();
		assertNull(h);
	}
	
	@Test
	public void testAddHouse2() {
		setUp1();
		double a = 165.3;
		int f = 2;
		b.addHouse(a, f);
		
		House h = b.getFirstHouse();
		assertEquals(a, h.getArea(),0);
		assertEquals(f, h.getFloors());
		assertEquals(h,h.getNextH());
	}
	
	@Test
	public void testAddHouse3() {
		setUp2();
		double a = 248.5;
		int f = 3;
		b.addHouse(a, f);
		
		House h1 = b.getFirstHouse();
		assertEquals(hs[0].getArea(), h1.getArea(),0);
		assertEquals(hs[0].getFloors(), h1.getFloors());
		
		House h2 = h1.getNextH();
		assertEquals(a, h2.getArea(),0);
		assertEquals(f, h2.getFloors());
		assertEquals(h1,h2.getNextH());
	}
	
	@Test
	public void testAddHouse4() {
		setUp3();
		double a = 672.8;
		int f = 5;
		b.addHouse(a, f);
		
		House h1 = b.getFirstHouse();
		assertEquals(hs[0].getArea(), h1.getArea(),0);
		assertEquals(hs[0].getFloors(), h1.getFloors());
		
		House h2 = h1.getNextH();
		assertEquals(hs[1].getArea(), h2.getArea(),0);
		assertEquals(hs[1].getFloors(), h2.getFloors());
		
		House h3 = h2.getNextH();
		assertEquals(hs[2].getArea(), h3.getArea(),0);
		assertEquals(hs[2].getFloors(), h3.getFloors());
		
		House h4 = h3.getNextH();
		assertEquals(hs[3].getArea(), h4.getArea(),0);
		assertEquals(hs[3].getFloors(), h4.getFloors());
		
		House h5 = h4.getNextH();
		assertEquals(a, h5.getArea(),0);
		assertEquals(f, h5.getFloors());
		assertEquals(h1,h5.getNextH());
	}

	@Test
	public void testExchangeHouses1() {
		setUp1();
		b.exchangeHouses(0, 1);
		assertNull(b.getFirstHouse());
		b.exchangeHouses(1, 2);
		assertNull(b.getFirstHouse());
		b.exchangeHouses(0, 5);
		assertNull(b.getFirstHouse());
		b.exchangeHouses(2, 9);
		assertNull(b.getFirstHouse());
	}

	@Test
	public void testExchangeHouses2() {
		setUp2();
		b.exchangeHouses(0, 1);
		House h1 = b.getFirstHouse();
		assertEquals(hs[0].getArea(), h1.getArea(),0);
		assertEquals(hs[0].getFloors(), h1.getFloors());
		assertEquals(h1,h1.getNextH());
		
		b.exchangeHouses(1, 2);
		h1 = b.getFirstHouse();
		assertEquals(hs[0].getArea(), h1.getArea(),0);
		assertEquals(hs[0].getFloors(), h1.getFloors());
		assertEquals(h1,h1.getNextH());
		
		b.exchangeHouses(0, 5);
		h1 = b.getFirstHouse();
		assertEquals(hs[0].getArea(), h1.getArea(),0);
		assertEquals(hs[0].getFloors(), h1.getFloors());
		assertEquals(h1,h1.getNextH());
		
		b.exchangeHouses(2, 9);
		h1 = b.getFirstHouse();
		assertEquals(hs[0].getArea(), h1.getArea(),0);
		assertEquals(hs[0].getFloors(), h1.getFloors());
		assertEquals(h1,h1.getNextH());		
	}
	
	@Test
	public void testExchangeHouses3() {
		setUp3();
		b.exchangeHouses(0, 1);
		
		House h1 = b.getFirstHouse();
		assertEquals(hs[1].getArea(), h1.getArea(),0);
		assertEquals(hs[1].getFloors(), h1.getFloors());
		
		House h2 = h1.getNextH();
		assertEquals(hs[0].getArea(), h2.getArea(),0);
		assertEquals(hs[0].getFloors(), h2.getFloors());
		
		House h3 = h2.getNextH();
		assertEquals(hs[2].getArea(), h3.getArea(),0);
		assertEquals(hs[2].getFloors(), h3.getFloors());
		
		House h4 = h3.getNextH();
		assertEquals(hs[3].getArea(), h4.getArea(),0);
		assertEquals(hs[3].getFloors(), h4.getFloors());
		
		assertEquals(h1,h4.getNextH());
	}
	
	@Test
	public void testExchangeHouses4() {
		setUp3();
		b.exchangeHouses(0, 2);
		
		House h1 = b.getFirstHouse();
		assertEquals(hs[2].getArea(), h1.getArea(),0);
		assertEquals(hs[2].getFloors(), h1.getFloors());
		
		House h2 = h1.getNextH();
		assertEquals(hs[1].getArea(), h2.getArea(),0);
		assertEquals(hs[1].getFloors(), h2.getFloors());
		
		House h3 = h2.getNextH();
		assertEquals(hs[0].getArea(), h3.getArea(),0);
		assertEquals(hs[0].getFloors(), h3.getFloors());
		
		House h4 = h3.getNextH();
		assertEquals(hs[3].getArea(), h4.getArea(),0);
		assertEquals(hs[3].getFloors(), h4.getFloors());
		
		assertEquals(h1,h4.getNextH());
	}
	
	@Test
	public void testExchangeHouses5() {
		setUp3();
		b.exchangeHouses(1, 2);
		
		House h1 = b.getFirstHouse();
		assertEquals(hs[0].getArea(), h1.getArea(),0);
		assertEquals(hs[0].getFloors(), h1.getFloors());
		
		House h2 = h1.getNextH();
		assertEquals(hs[2].getArea(), h2.getArea(),0);
		assertEquals(hs[2].getFloors(), h2.getFloors());
		
		House h3 = h2.getNextH();
		assertEquals(hs[1].getArea(), h3.getArea(),0);
		assertEquals(hs[1].getFloors(), h3.getFloors());
		
		House h4 = h3.getNextH();
		assertEquals(hs[3].getArea(), h4.getArea(),0);
		assertEquals(hs[3].getFloors(), h4.getFloors());
		
		assertEquals(h1,h4.getNextH());
	}
	
	@Test
	public void testExchangeHouses6() {
		setUp3();
		b.exchangeHouses(1, 3);
		
		House h1 = b.getFirstHouse();
		assertEquals(hs[0].getArea(), h1.getArea(),0);
		assertEquals(hs[0].getFloors(), h1.getFloors());
		
		House h2 = h1.getNextH();
		assertEquals(hs[3].getArea(), h2.getArea(),0);
		assertEquals(hs[3].getFloors(), h2.getFloors());
		
		House h3 = h2.getNextH();
		assertEquals(hs[2].getArea(), h3.getArea(),0);
		assertEquals(hs[2].getFloors(), h3.getFloors());
		
		House h4 = h3.getNextH();
		assertEquals(hs[1].getArea(), h4.getArea(),0);
		assertEquals(hs[1].getFloors(), h4.getFloors());
		
		assertEquals(h1,h4.getNextH());
	}
	
	@Test
	public void testExchangeHouses7() {
		setUp3();
		b.exchangeHouses(2, 3);
		
		House h1 = b.getFirstHouse();
		assertEquals(hs[0].getArea(), h1.getArea(),0);
		assertEquals(hs[0].getFloors(), h1.getFloors());
		
		House h2 = h1.getNextH();
		assertEquals(hs[1].getArea(), h2.getArea(),0);
		assertEquals(hs[1].getFloors(), h2.getFloors());
		
		House h3 = h2.getNextH();
		assertEquals(hs[3].getArea(), h3.getArea(),0);
		assertEquals(hs[3].getFloors(), h3.getFloors());
		
		House h4 = h3.getNextH();
		assertEquals(hs[2].getArea(), h4.getArea(),0);
		assertEquals(hs[2].getFloors(), h4.getFloors());
		
		assertEquals(h1,h4.getNextH());
	}
}
