import java.io.IOException;
import java.util.ArrayList;

public class test extends gameIO {
	
	public static void main(String[] args) throws IOException {
		ArrayList<DoodadTryhard> array = new ArrayList<DoodadTryhard>();
		int x = 296,y=250;
		String filelocation = "D:/RedChecker.png";
		for(int i =0; i<5;i++)
		{
			DoodadTryhard doodad = new DoodadTryhard(x,y,filelocation);
			array.add(doodad);
			x+=50;
			y-=10;
		}
		saveIO(array);
		loadIO(array);
	}
}
