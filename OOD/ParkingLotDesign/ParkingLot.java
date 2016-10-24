package parkingLotDesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLot {
    int id;
    final int floorNum;
    List<Level> levels;
    // @param n number of leves
    // @param num_rows  each level has num_rows rows of spots
    // @param spots_per_row each row has spots_per_row spots
    public ParkingLot(int n, int num_rows, int spots_per_row) {
        // Write your code here
        floorNum = n;
        levels = new ArrayList<Level>();
        for (int i = 0; i < n; i++) {
            Level level = new Level(i, i, num_rows, spots_per_row);
            levels.add(level);
        }
    }

    // Park the vehicle in a spot (or multiple spots)
    // Return false if failed
    public boolean parkVehicle(Vehicle vehicle) {
        // Write your code here
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
    
    public String[] getAvalability(Level l) {
    	String[] res = new String[l.ROW_NUM * l.SPOTS_PER_ROW];
    	for(int i = 0; i < res.length; i++) {
    		if(l.spots.get(i).isAvailable) {
    			res[i] = "True";
    		} else {
    			res[i] = "False";
    		}
    	}   	
    	return res;
    }
    
    public String[] getSpotsSize(Level l) {
    	String[] res = new String[l.ROW_NUM * l.SPOTS_PER_ROW];
    	for(int i = 0; i < res.length; i++) {
    		if(l.spots.get(i).size == VehicleSize.Motorcycle) {
    			res[i] = "M";
    		} else if (l.spots.get(i).size == VehicleSize.Compact) {
    			res[i] = "C";
    		} else {
    			res[i] = "L";
    		}
    	}   	
    	return res;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
//    	parkVehicle("Motorcycle_1")
//    	parkVehicle("Motorcycle_2")
//    	parkVehicle("Motorcycle_3")
//    	parkVehicle("Car_1")
//    	parkVehicle("Car_2")
//    	parkVehicle("Car_3")
//    	parkVehicle("Motorcycle_4")
//    	parkVehicle("Car_4")
//    	parkVehicle("Car_5")
//    	parkVehicle("Car_6")
//    	parkVehicle("Car_7")
//    	parkVehicle("Bus_1")
//    	unParkVehicle("Car_1")
//    	unParkVehicle("Motorcycle_4")
//    	unParkVehicle("Car_3")
//    	unParkVehicle("Car_6")
//    	parkVehicle("Bus_1")
//    	unParkVehicle("Car_7")
//    	parkVehicle("Bus_1")
		ParkingLot lot = new ParkingLot(1, 1, 14);
		//System.out.println(lot.levels.get(0).availableSpotsNum);
//		
//    	Motorcycle m1 = new Motorcycle();
//    	Motorcycle m2 = new Motorcycle();
//    	Motorcycle m3 = new Motorcycle();
//    	Motorcycle m4 = new Motorcycle();
//    	
//    	//System.out.println(lot.parkVehicle(m1));
//    	Car c1 = new Car();
//    	Car c2 = new Car();
//    	Car c3 = new Car();
//    	Car c4 = new Car();
//    	Car c5 = new Car();
//    	Car c6 = new Car();
//    	Car c7 = new Car();
//    	Bus b1 = new Bus();
//    	
//    	System.out.println(lot.parkVehicle(m1));
//    	System.out.println(lot.parkVehicle(m2));
//    	System.out.println(lot.parkVehicle(m3));
//    	System.out.println(lot.parkVehicle(c1));
//    	System.out.println(lot.parkVehicle(c2));
//    	System.out.println(lot.parkVehicle(c3));
//    	System.out.println(lot.parkVehicle(m4));
//    	System.out.println(lot.parkVehicle(c4));
//    	System.out.println(lot.parkVehicle(c5));
//    	System.out.println(lot.parkVehicle(c6));
//    	System.out.println(lot.parkVehicle(c7));
//    	System.out.println(lot.parkVehicle(b1));
//    	lot.unParkVehicle(c1);
//    	lot.unParkVehicle(m4);
//    	lot.unParkVehicle(c3);
//    	lot.unParkVehicle(c6);
//    	System.out.println(lot.parkVehicle(b1));
//    	lot.unParkVehicle(c7);
//    	String[] resA1 = lot.getAvalability(lot.levels.get(0));
//    	String[] resS1 = lot.getSpotsSize(lot.levels.get(0));
//    	System.out.println(Arrays.toString(resA1));
//    	System.out.println(Arrays.toString(resS1));
//    	System.out.println(lot.parkVehicle(b1));
    	//lot.parkVehicle(m1);
		
	}
}
