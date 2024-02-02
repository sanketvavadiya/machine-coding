package src.service;

import src.repository.FloorRepository;

public class AdminService {
    public static AdminService adminService = new AdminService();

    private AdminService() {

    }

    public static AdminService getInstance() {
        return adminService;
    }

    public void createParkingLot(int floors, int slots) {
        FloorRepository.addNFloor(floors, slots);
    }

    public void addFloor(int slots) {
        FloorRepository.addFloor(slots);
    }
}
