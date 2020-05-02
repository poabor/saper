package sweeper;

import java.util.ArrayList;

public class Ranges {
	private static Coord size;
	private static ArrayList<Coord>  allCoords;
	
	public static void setSize(Coord _size) {
		size = _size;
		allCoords = new ArrayList<Coord>();
		for (int y = 0; y < size.y; y++) {
			for (int x = 0; x < size.x; x++) {
				allCoords.add(new Coord(x, y));
			}
			
		}
	}
	
	public static Coord GetSize() {
		return size;
	}
	
	public static ArrayList<Coord> GetAllCoords()
	{
		return allCoords;
	}
	
	static boolean InRange(Coord coord) {
		return coord.x >= 0 && coord.x < size.x &&
				coord.y >= 0 && coord.y < size.y;
	}
}