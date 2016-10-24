package parkingLotDesign;

import java.util.ArrayList;
import java.util.List;

class Level {
    // Write your code here
    int id;
    int floor;
    final int ROW_NUM;
    final int SPOTS_PER_ROW;
    int availableSpotsNum;
    List<Spot> spots;
    
    public Level(int id, int floor, int m, int k) {
        this.id = id;
        this.floor = floor;
        this.ROW_NUM = m;
        this.SPOTS_PER_ROW = k;
        List<Spot> list = new ArrayList<Spot>();
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                if (j < k / 4) {
                    Spot spot = new Spot(floor, i, count, VehicleSize.Motorcycle);
                    list.add(spot);
                } else if (j < k / 4 * 3) {
                    Spot spot = new Spot(floor, i, count, VehicleSize.Compact);
                    list.add(spot);
                } else {
                    Spot spot = new Spot(floor, i, count, VehicleSize.Large);
                    list.add(spot);
                }
                count++;                
            }    
        }
        this.spots = list;
        this.availableSpotsNum = count;
    }
    
    // return the starting spots index
    public int findSpots(Vehicle vehicle) {
        int spotsNeeded = vehicle.spotsNeeded;
        int spotsFound = 0;
        int lastRow = -1;
    
        for (int i = 0; i < spots.size() ; i++) {
            if (!spots.get(i).canFitInSpot(vehicle)) {
                continue;
            }
            if (lastRow != spots.get(i).row) {
                lastRow = spots.get(i).row;
                spotsFound = 0;
            }
            spotsFound++;
            if (spotsFound == spotsNeeded) {
                return i - (spotsNeeded - 1);
            }
        }
        return -1;
    }
    
    public boolean park(Vehicle vehicle) {
        vehicle.unpark();
        availableSpotsNum += vehicle.spotsNeeded;
        if (availableSpotsNum < vehicle.spotsNeeded) {
			return false; // no enough spots
		}
        int index = findSpots(vehicle);
		
        boolean success = true;
        if (index == -1) {
            return false;
        }
        for (int i = 0; i < vehicle.spotsNeeded; i++) {
            success &= spots.get(index + i).park(vehicle);
        }
        availableSpotsNum -= vehicle.spotsNeeded;
        return success;
    }

    public void unpark(Vehicle vehicle) {
    	vehicle.unpark();
        availableSpotsNum += vehicle.spotsNeeded;
    }
}
