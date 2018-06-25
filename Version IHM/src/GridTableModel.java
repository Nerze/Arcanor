package arcanor;

import javax.swing.table.AbstractTableModel;
import javax.swing.ImageIcon;

public class GridTableModel extends AbstractTableModel {

  private int noOfRows, noOfCols;
  private Piece[][] grid;
  private static final String PATH = "images/"; 
  private String imageFree= "noir.jpg";
  private String imageYellow= "blanc.jpg";
  private String imageRed= "noir.jpg";
    
  
 /*
  * Constructor
  * @param grid : the table to display
  */
  public GridTableModel(Piece[][] grid) {
    this.grid = grid;
    noOfRows = this.grid[0].length;
    noOfCols = this.grid.length;
  }

// Implementing the tree abstract methods:
  
   public int getRowCount() {
    return(noOfRows);
  }
  public int getColumnCount() {
    return(noOfCols);
  }

  public Object getValueAt(int r,int c) {
    Object result = new Object();
    Piece p = grid[c][grid[0].length-r-1];
    if (p==null) result= new ImageIcon("/ddsgh");
    else if(p.getColor()) result=new ImageIcon(PATH + imageYellow);
    else result= new ImageIcon(PATH + imageRed);
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
