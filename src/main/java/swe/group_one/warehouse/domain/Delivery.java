package swe.group_one.warehouse.domain;

import swe.group_one.warehouse.transportation.Transportation;


import java.util.List;
import java.util.Random;

public class Delivery {

    private static List<Transportation> vehicles = List.of(Transportation.Car, Transportation.Plane, Transportation.Boat);

    public static void prepareForDelivery(Order pack) {
        Random r = new Random();
        Transportation deliveryVehicle = vehicles.get(r.nextInt(vehicles.size()));

        float payloadWeight = pack.getWeight();

        if(deliveryVehicle.getCurbWeight() + payloadWeight > deliveryVehicle.getGvwrWeight()){
            System.out.println("NOTE: " + deliveryVehicle + " isn't a suitable vehicle");
        }

    }
}
