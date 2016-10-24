package parkingLotDesign;

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
