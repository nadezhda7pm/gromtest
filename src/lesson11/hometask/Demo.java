package lesson11.hometask;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

// 1. rooms that match the requirements found for all APIs
// 2. NullPointerException checked and verification added
// 3. rooms that do not match the requirements (id1 and id4) not found for all API

        Room room1 = new Room(1, 50, 1, new Date(), "Hotel1", "City1");
        Room room2 = new Room(2, 120, 2, new Date(), "Hotel", "City1");
        Room room3 = new Room(3, 100, 3, new Date(), "Hotel1", "City1");
        Room room4 = new Room(4, 5000, 5, new Date(), "Hotel2", "City2");
        Room room5 = new Room(5, 250, 1, new Date(), "Hotel3", "City3");
        Room room6 = new Room(6, 200, 2, null, "Hotel", "City1");
        Room[] rooms = new Room[]{room1, room2, room3, room4, room5,room6, null};
        Room[] roomsX = new Room[]{};

        API bookingComAPI = new BookingComAPI(rooms);
        API tripAdvisorAPI = new TripAdvisorAPI(rooms);
        API googleAPI = new GoogleAPI(rooms);

        API[] apis = new API[]{bookingComAPI, tripAdvisorAPI, googleAPI};

        for (API api : apis) {
            System.out.println("1" + Arrays.toString(api.findRooms(120, 2, "City1", "Hotel")));
            System.out.println("2" + Arrays.toString(api.findRooms(100, 2, "City1", "Hotel1")));
            System.out.println("3" + Arrays.toString(api.findRooms(200, 3, "City1", "Hotel1")));
            System.out.println("4" + Arrays.toString(api.findRooms(250, 1, "City3", "Hotel3")));
            System.out.println(Arrays.toString(api.getAll()));
            System.out.println();
        }

        System.out.println("-----------------------------------------------------------------------------------");

        API bookingComAPIx = new BookingComAPI(roomsX);
        API tripAdvisorAPIx = new TripAdvisorAPI(roomsX);
        API googleAPIx = new GoogleAPI(roomsX);
        API[] apisX = new API[]{bookingComAPIx, tripAdvisorAPIx, googleAPIx};

        for (API api : apisX) {
            System.out.println(Arrays.toString(api.findRooms(120, 2, "City1", "Hotel")));
            System.out.println(Arrays.toString(api.getAll()));
            System.out.println();
        }
    }
}
