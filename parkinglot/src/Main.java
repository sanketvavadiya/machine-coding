package src;

import src.enums.CommandType;
import src.enums.DisplayCommand;
import src.enums.VehicleType;
import src.service.AdminService;
import src.service.DisplayService;
import src.service.ParkingService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static  void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        ParkingService parkingService = ParkingService.getInstance();
        DisplayService displayService = DisplayService.getInstance();
        AdminService adminService = AdminService.getInstance();


        while (true) {
            CommandType commandType = CommandType.of(sc.next());
            switch (commandType) {
                case CREATE_PARKING_LOT -> adminService.createParkingLot(sc.nextInt(), sc.nextInt());
                case DISLPAY -> DisplayService.display(DisplayCommand.of(sc.next()), VehicleType.valueOf(sc.next()), sc.nextInt());
                case PARK_VEHICLE -> parkingService.park(sc.next(), sc.next(), sc.next());
                case UNPARK_VEHICLE -> parkingService.unPark(sc.next()+sc.next());
                case EXIT -> {
                    System.out.println("Exiting parking system");
                    return;
                }
                default ->
                    throw new IllegalStateException("Unexpected value: " + commandType);
            }

        }
    }
}
