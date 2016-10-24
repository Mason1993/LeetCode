package parkingLotDesign;

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