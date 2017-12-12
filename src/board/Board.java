package board;

import java.util.List;
import java.util.Random;
import java.util.LinkedList;

public class Board {
	public static final int BOARD_HEIGHT = 16;
	public static final int BOARD_WIDTH = 20;
	private Location[][] locations;
	Random randomizer;
	public Board() {
		randomizer = new Random();
		locations = new Location[BOARD_HEIGHT][BOARD_WIDTH];
		for(int i=0;i<BOARD_HEIGHT;i++) {
			for(int j=0; j<BOARD_WIDTH; j++) {
				locations[i][j] = new Location(this,i,j);
			}
		}
	}
	
	public Location getLocation(int x, int y) {
		if(x < 0|| x>=BOARD_HEIGHT || y<0 || y>=BOARD_WIDTH) { return null;}
		return locations[x][y];
	}
	
	public Location getLocationByOffset(Location baseLocation, int xMod, int yMod) {
		return getLocation(baseLocation.getX()+xMod, baseLocation.getY()+yMod);
	}
	
	public List<Location> getAdjacentLocations(Location location){
		List<Location> adjacentLocations = new LinkedList<Location>();
		int[] validIndex = {-1,1};
		Location temp;
		for(int i=0; i<validIndex.length;i++) {
			for(int j=0; j<validIndex.length;j++) {
				temp = getLocationByOffset(location,validIndex[i],validIndex[j]);
				if(temp != null) {
					adjacentLocations.add(temp);
				}
			}
		}
		return adjacentLocations;
	}
	
	public List<Location> getAllOpenLocations() {
		List<Location> openLocations = new LinkedList<Location>();
		for(int i=0;i<BOARD_HEIGHT;i++) {
			for(int j=0; j<BOARD_WIDTH; j++) {
				Location currLocation = getLocation(i,j);
				if(!currLocation.isOccupied()) {
					openLocations.add(currLocation);
				}
			}
		}
		return openLocations;
	}
	
	public boolean isLocationOccupied(int x,int y) {
		return getLocation(x,y).isOccupied();
	}
	
	public Location getRandomOpenLocation() {
		List<Location> openings = getAllOpenLocations();
		return openings.get(randomizer.nextInt(openings.size()));
	}
	
	
	//null means we didn't find a valid location
	public List<Location> getRandomOpenBlock(int height, int width){
		if(height<0 || width <0) { throw new IllegalArgumentException("Invalid object dimensions.");}
		List<Location> block = new LinkedList<Location>();
		Location base = this.getRandomOpenLocation();
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				Location currLoc = this.getLocationByOffset(base, -i, -j);
				if( currLoc != null && !currLoc.isOccupied()) {
					block.add(currLoc);
				}else {
					return null;
				}
			}
		}
		return block;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<BOARD_WIDTH; j++) {
			sb.append("*");
		}
		sb.append('\n');
		for(int i=0; i<BOARD_HEIGHT; i++) {
			sb.append("*");
			for(int j=0; j<BOARD_WIDTH; j++) {
				Location currLoc = locations[i][j];
				if(!currLoc.isOccupied()) {
					sb.append(' ');
				}else {
					sb.append(currLoc.getItem().toString());
				}
			}
			sb.append("*");
			sb.append('\n');
		}
		for(int j=0; j<BOARD_WIDTH; j++) {
			sb.append("*");
		}
		return sb.toString();
	}
}
