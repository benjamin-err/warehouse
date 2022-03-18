package swe.group_one.warehouse.transportation;

public enum Transportation {
    Car(1000, 3500), Plane(50000, 400000), Boat(1000000, 2000000);

    private float curbWeight; // in tons
    private float gvwrWeight;

    Transportation(float kg, float gvwr) {
        this.curbWeight = kg;
        this.gvwrWeight = gvwr;
    }

    public float getCurbWeight(){
        return curbWeight;
    }

    public float getGvwrWeight() {
        return gvwrWeight;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
