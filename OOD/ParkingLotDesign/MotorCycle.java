package parkingLotDesign;

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
