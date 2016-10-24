package parkingLotDesign;

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
