import junit.framework.TestCase;


public class TestPiece extends TestCase {
	
	
	/**
     * Test of Piece builder
     */
	public void testPiece () {
		
		Piece piece1 = new Piece(true, 3, null);
		Piece piece2 = new Piece(true, 3, null);
		
		assertTrue(piece1 != piece2);
		
		System.out.println("Two identical Pieces are not the same object");
		
	}
	
	
	/**
     * Test the getters and setters of Piece
     */
	public void testColor () {
		
		Piece piece1 = new Piece(true, 3, null);
		Piece piece2 = new Piece(false, 2, null);
		
		// Test the color setter and getter
		assertTrue(piece1.getColor() == true);
		piece1.setColor(false);
		assertTrue(piece1.getColor() == false);
		
		// Test the value setter and getter
		assertTrue(piece1.getValue() == 3);
		piece1.setValue(1);
		assertTrue(piece1.getValue() == 1);
		
		// Test the contain setter and getter
		assertTrue(piece1.getContain() == null);
		piece1.setContain(piece2);
		assertTrue(piece1.getContain() == piece2);
		
	}

}
