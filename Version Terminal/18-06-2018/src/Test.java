import arcanor.*;
import java.io.*;
public class Test{
	public static void main(String[] args){
		ParamMenu param = new ParamMenu();
		String[] params = {"7","3","2","Red","Blue","12"};
		param.setTabParams(params);
		Game game = new Game(param);
		game.start();
	}
}
