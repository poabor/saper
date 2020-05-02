package sweeper;

class Matrix {
	private Box [] [] matrix;
	
	public Matrix(Box defaultBox) {
		matrix = new Box[Ranges.GetSize().x] [Ranges.GetSize().y];
		for (Coord coord:Ranges.GetAllCoords()) {
			matrix [coord.x][coord.y] = defaultBox;
		}
	}
	
	Box get (Coord coord) {
		if (Ranges.InRange(coord))
			return matrix [coord.x][coord.y];
		return null;
	}
	
	void set (Coord coord, Box box) {
		if (Ranges.InRange(coord))
			matrix[coord.x][coord.y] = box;
	}
}
