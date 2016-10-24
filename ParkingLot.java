// Design a parking lot.

// see CC150 OO Design for details.
// 1) n levels, each level has m rows of spots and each row has k spots.So each level has m x k spots.
// 2) The parking lot can park motorcycles, cars and buses
// 3) The parking lot has motorcycle spots, compact spots, and large spots
// 4) Each row, motorcycle spots id is in range [0,k/4)(0 is included, k/4 is not included), compact spots id is in range [k/4,k/4*3) and large spots id is in range [k/4*3,k).
// 5) A motorcycle can park in any spot
// 6) A car park in single compact spot or large spot
// 7) A bus can park in five large spots that are consecutive and within same row. it can not park in small spots

// testcase 1
// level=1, num_rows=1, spots_per_row=11
// parkVehicle("Motorcycle_1")
// parkVehicle("Car_1")
// parkVehicle("Car_2")
// parkVehicle("Car_3")
// parkVehicle("Car_4")
// parkVehicle("Car_5")
// parkVehicle("Bus_1")
// unParkVehicle("Car_5")
// parkVehicle("Bus_1")

// testcase 2
// level=1, num_rows=1, spots_per_row=14
// parkVehicle("Motorcycle_1")
// parkVehicle("Motorcycle_2")
// parkVehicle("Motorcycle_3")
// parkVehicle("Car_1")
// parkVehicle("Car_2")
// parkVehicle("Car_3")
// parkVehicle("Motorcycle_4")
// parkVehicle("Car_4")
// parkVehicle("Car_5")
// parkVehicle("Car_6")
// parkVehicle("Car_7")
// parkVehicle("Bus_1")
// unParkVehicle("Car_1")
// unParkVehicle("Motorcycle_4")
// unParkVehicle("Car_3")
// unParkVehicle("Car_6")
// parkVehicle("Bus_1")
// unParkVehicle("Car_7")
// parkVehicle("Bus_1")
import java.util.*;
// enum type for Vehicle
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

class Motorcycle extends Vehicle {
    // Write your code here
    public Motorcycle() {
        size = VehicleSize.Motorcycle;
        this.spotsNeeded = 1;
    }
    
    public boolean canFitInSpot (Spot spot) {
        return true;
    }
}

class Car extends Vehicle {
    // Write your code here
    public Car() {
        size = VehicleSize.Compact;
        this.spotsNeeded = 1;
    }
    public boolean canFitInSpot (Spot spot) {
        if (spot.size != VehicleSize.Motorcycle) {
            return true;
        }
        return false;
    }
}

class Bus extends Vehicle {
    // Write your code here
    public Bus() {
       size = VehicleSize.Large;
        this.spotsNeeded = 5;    
    }
    
    public boolean canFitInSpot (Spot spot) {
        if (spot.size == VehicleSize.Large) {
            return true;
        }
        return false;
    }
}

class Spot {
    int id;
    int level;
    int row;
    int spotIndex;
    VehicleSize size;
    boolean isAvailable;
    Vehicle vehicle;
    
    public Spot(int l, int r, int index, VehicleSize s) {
        this.level = l;
        this.row = r;
        this.spotIndex = index;
        this.size = s;
        isAvailable = true;
    }
    
    public boolean canFitInSpot(Vehicle vehicle) {
        return isAvailable && vehicle.canFitInSpot(this);
    }
    
    public boolean park(Vehicle vehicle) {
        if (canFitInSpot(vehicle)) {
            vehicle.park(this);
            return true;
        }
        return false;
    }
    
    public void unpark() {
        this.isAvailable = true;
        this.vehicle = null;
    }
}

/* Represents a level in a parking garage */
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
        this.availableSpotsNum = m * k;
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

public class ParkingLot {
    int id;
    final int floorNum;
    List<Level> levels;
    // @param n number of leves
    // @param num_rows  each level has num_rows rows of spots
    // @param spots_per_row each row has spots_per_row spots
    public ParkingLot(int n, int num_rows, int spots_per_row) {
        // Write your code here
        levels = new ArrayList<Level>();
        floorNum = n;
        for (int i = 0; i < n; i++) {
            Level level = new Level(i, i, num_rows, spots_per_row);
            levels.add(level);
        }
    }

    // Park the vehicle in a spot (or multiple spots)
    // Return false if failed
    public boolean parkVehicle(Vehicle vehicle) {
        // Write your code here
        boolean res;
        for (int i = 0; i < levels.size(); i++) {
            if (levels.get(i).park(vehicle)) {
                return true;
            }
        }
        return false;
    }

    // unPark the vehicle
    public void unParkVehicle(Vehicle vehicle) {
        // Write your code here
        vehicle.unpark();
    }
}