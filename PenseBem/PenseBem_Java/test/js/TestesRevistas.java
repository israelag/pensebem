package js;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.RegistraLog;

public class TestesRevistas {
	private RegistraLog log = new RegistraLog();


	@Test
	public void testRevista011() {
		RevistaTeste rvt = new RevistaTeste(log, "011");
		
		rvt.aplicaQuestionario();
		
		assertEquals("D", rvt.mapaGabaritoTest.get(1));
		assertEquals("B", rvt.mapaGabaritoTest.get(2));
		assertEquals("A", rvt.mapaGabaritoTest.get(3));
		assertEquals("A", rvt.mapaGabaritoTest.get(4));
		assertEquals("D", rvt.mapaGabaritoTest.get(5));
		assertEquals("C", rvt.mapaGabaritoTest.get(6));
		assertEquals("B", rvt.mapaGabaritoTest.get(7));
		assertEquals("D", rvt.mapaGabaritoTest.get(8));
		assertEquals("A", rvt.mapaGabaritoTest.get(9));
		assertEquals("A", rvt.mapaGabaritoTest.get(10));

		rvt = null;
	}
	
	@Test
	public void testRevista255() {
		RevistaTeste rvt = new RevistaTeste(log, "255");
		
		rvt.aplicaQuestionario();
		
		assertEquals("A", rvt.mapaGabaritoTest.get(121));
		assertEquals("A", rvt.mapaGabaritoTest.get(122));
		assertEquals("A", rvt.mapaGabaritoTest.get(123));
		assertEquals("A", rvt.mapaGabaritoTest.get(124));
		assertEquals("A", rvt.mapaGabaritoTest.get(125));
		assertEquals("D", rvt.mapaGabaritoTest.get(126));
		assertEquals("B", rvt.mapaGabaritoTest.get(127));
		assertEquals("A", rvt.mapaGabaritoTest.get(128));
		assertEquals("A", rvt.mapaGabaritoTest.get(129));
		assertEquals("D", rvt.mapaGabaritoTest.get(130));

		rvt = null;
	}

}
