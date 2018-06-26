package arcanor;

import javax.swing.table.AbstractTableModel;
import javax.swing.ImageIcon;
import java.io.Serializable;

/**
 * Describe what to do when a mouse exit the panel
 */
public class GridTableModel extends AbstractTableModel implements Serializable {
	
	/**
	 * The number of row and column
	 */
	private int noOfRows, noOfCols;
	
	/**
	 * The grid
	 */
	private Piece[][] grid;
	
	/**
	 * The path to the folder with the images
	 */
	private static final String PATH = "/images/"; 
	
	/**
	 * The path to the folder with the images of black pawns
	 */
	private String imageBlack= "BLACK.png";
	
	/**
	 * The path to the folder with the images of white pawns
	 */
	private String imageWhite= "WHITE.png";
	
	
	/**
	 * The Constructor
	 * @param grid : the table to display
	 */
  public GridTableModel(Piece[][] grid) {
    this.grid = grid;
    noOfRows = this.grid[0].length;
    noOfCols = this.grid.length;
  }

// Implementing the tree abstract methods:

   /**
    * Return the number of row
    * @return noOfRows
    */
   public int getRowCount() {
    return(noOfRows);
  }
  
  /**
   * Return the number of column
   * @return noOfCols
   */
  public int getColumnCount() {
    return(noOfCols);
  }

	/**
     * Return a designated image in the grid
     * @return result the image
     */
  public Object getValueAt(int r,int c) {
    Object result = new Object();
    Piece p = grid[c][grid[0].length-r-1];
    if (p==null) result= new ImageIcon("/ddsgh");
    else if(p.getColor()) result=new ImageIcon(getClass().getResource(PATH + p.getValue()+imageBlack));
    else result= new ImageIcon(getClass().getResource(PATH + p.getValue()+imageWhite));
    this.fireTableDataChanged();
    return result;
  }
 
  /**
   * get the name of the column
   * @param c : the number of the column
   * @return a String for the name of the column
   */
  public String getColumnName(int c){
    return (new Integer(c).toString());
  }
  
   /**
   * get the class of the object at column c
   * @param c : the number of the column
   * @return the class of the object at column c
   */
   public Class getColumnClass(int c) {
      return this.getValueAt(0, c).getClass();
   }
}
