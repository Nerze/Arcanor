package arcanor;

public abstract class Menu{

	private String title;

	public Menu(String title){
		this.title=title;
	}

	public abstract void display();
	public abstract void back();

}
