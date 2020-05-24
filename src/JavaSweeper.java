import java.awt.*;
import javax.swing.*;

import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

public class JavaSweeper extends JFrame {

	private Game game;
	private JPanel panel;
	private final int COLS = 9;
	private final int ROWS = 9;
	private final int BOMBS = 10;
	private final int IMAGE_SIZE = 50;
	
	public static void main(String[] args) {
		new JavaSweeper();
	}
	
	private JavaSweeper() {
		game = new Game(COLS, ROWS, BOMBS);
		game.start();
		setImages();
		initPanel();
		initFrame();
	}
	
	private void initPanel() {
		panel = new JPanel()
		{
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				for (Coord coord: Ranges.GetAllCoords()) {
					
					g.drawImage((Image) game.getBox(coord).image, coord.x * IMAGE_SIZE, coord.y * IMAGE_SIZE, this);
				}
			}
		};
		panel.setPreferredSize(new Dimension(Ranges.GetSize().x * IMAGE_SIZE,
				Ranges.GetSize().y * IMAGE_SIZE));
		add(panel);
	}
	
	/**
	 * 
	 */
	private void initFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Java Sweeper");
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setIconImage(getImage("icon"));
		pack();
	}
	
	private void setImages() {
		for (Box box : Box.values()) {
			box.image = getImage(box.name().toLowerCase());
		}
	}
	
	private Image getImage (String name) 
	{
		String filename = "img/" + name + ".png";
		ImageIcon icon = new ImageIcon(getClass().getResource(filename));
		return icon.getImage();
	}
}
