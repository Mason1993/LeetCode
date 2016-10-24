package parkingLotDesign;

import java.util.ArrayList;
import java.util.List;

enum VehicleSize {
    Motorcycle,
    Compact,
    Large,
}

abstract class Vehicle {
    // Write your code here
    String licesnPlate;
    VehicleSize size;
    int spotsNeeded;
    List<Spot> spots = new ArrayList<Spot>();
    
    public abstract boolean canFitInSpot(Spot spot);
    
    public boolean park(Spot spot) {
        if (spot.canFitInSpot(this)) {
            spot.isAvailable = false;
            spot.vehicle = this;
            spots.add(spot);
            return true;
        }
        return false;
    }
    
    public void unpark() {
    	for (int i = 0; i < spots.size(); i++) {
			spots.get(i).unpark();
		}
		spots.clear();
    }
}