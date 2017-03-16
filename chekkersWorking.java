package kpt;
import java.io.IOException;
import java.util.ArrayList;

public class chekkersWorking {

	public static void main(String[] args) throws IOException {
		//TODO Auto-generated method stub
		//TODO get shareGameBoard working
		//TODO display checkers

		Game board = new Game();
		
		//Hold doodads		
		ArrayList<DoodadWorking> pieces = new ArrayList<DoodadWorking>();
		
		shareGameBoard(board);
		showReds(pieces);
		showBlacks(pieces);
		kings(pieces);

	}
	
	//create game board
	public static void shareGameBoard(Game board) throws IOException{
		String boardName =  "C:/Users/MotherShip/Documents/Programming/KnightlyParty/Pictures/chekkersPics/checkerboard.jpg";
		board.fileToBoard(boardName);
	}
	
	//Display red checkers
	public static void showReds(ArrayList<DoodadWorking> pieces){
		
		//int num = 0;
		int xorigin = 604;
		int yorigin = 185;
		String redPiece = "C:/Users/MotherShip/Documents/Programming/KnightlyParty/Pictures/chekkersPics/redChecker.png";

		
		try {

			for(int  i = 0; i < 3; i++){
				for(int j = 0; j < 4; j++){
					DoodadWorking piece = new DoodadWorking(xorigin, yorigin, redPiece);
					pieces.add(piece);
					yorigin+=180;
				}
				xorigin+=90;
				if(i%2!=0){
					yorigin-=810;
				}
				else{
					yorigin-=630;
				}
			}
		}
			
		catch(Exception e){
			e.printStackTrace();
		}
		for(int m = 0; m < pieces.size(); m++){
			pieces.get(m).addDragListener();
		}
	}
	
	//display black checkers
	public static void showBlacks(ArrayList<DoodadWorking> pieces){
		
		String blackPiece = "C:/Users/MotherShip/Documents/Programming/KnightlyParty/Pictures/chekkersPics/blackChecker.png";
		//int num = 0;
		int xShift = 90*5;
		int xorigin = 604 + xShift;
		int yorigin = 275;
		int listStart = pieces.size();
		int count=0;
		
		try {
			for(int  i = 0; i < 3; i++){
				for(int j = 0; j < 4; j++){
					DoodadWorking piece = new DoodadWorking(xorigin, yorigin, blackPiece);
					pieces.add(listStart+count, piece);
					yorigin+=180;
					count++;
				}
				xorigin+=90;
				if(i%2!=0){
					yorigin-=630;
				}
				else{
					yorigin-=810;
				}
			}
		}
			
		catch(Exception e){
			e.printStackTrace();
		}
		
		for(int m = listStart; m < pieces.size(); m++){
			pieces.get(m).addDragListener();
		}		
	}
	
	//kinging
	public static void kings(ArrayList<DoodadWorking> pieces) throws IOException{
		//black king stack
		int xBlack = 424;
		int y = 410;
		int xRed = 1415;
		int num = 0;
		int length1 = pieces.size();
		int length2;
		String blackKing = "C:/Users/MotherShip/Documents/Programming/KnightlyParty/Pictures/chekkersPics/blackKing.png";
		String redKing = "C:/Users/MotherShip/Documents/Programming/KnightlyParty/Pictures/chekkersPics/redKing.png";
		
		
		try{
			while(num < 12){
				DoodadWorking piece= new DoodadWorking(xBlack, y, blackKing);
				pieces.add(length1+num, piece);
				num++;
			}
			num = 0;
			length2 = pieces.size();
			while(num < 12){
				DoodadWorking piece = new DoodadWorking(xRed, y, redKing);
				pieces.add(length2+num, piece);
				num++;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

		for(int i = 0; i < 12; i++){
			pieces.get(length1+i).addDragListener();
		}
		
		for(int i = 0; i < 12 ; i++){
			pieces.get(36+i).addDragListener();
		}
	}	
}