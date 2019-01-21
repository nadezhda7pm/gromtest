package lesson11.hometask;

import java.util.Arrays;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        int n = 0;
        for (API api : apis) {
            n += api.findRooms(price, persons, city, hotel).length;
        }

        Room[] requestedRooms = new Room[n];
        int i = 0;
        for (API api : apis) {
            for (Room room : api.findRooms(price, persons, city, hotel)) {
                requestedRooms[i] = room;
                i++;
            }
        }
        return requestedRooms;
    }


    public Room[] check(API api1, API api2) {
        int n = 0;
        for (Room room : api1.getAll()) {
            if (checkRoom(room, api2) == true)
                n++;
        }


        Room[] checkedRooms = new Room[n];
        int i = 0;
        for (Room room : api1.getAll()) {
            if (checkRoom(room, api2) == true) {
                checkedRooms[i] = room;
                i++;
            }
        }
        return checkedRooms;
    }

    public boolean checkRoom(Room room, API api) {
        boolean identicalRoomFound = false;
        for (Room apiRoom : api.getAll()) {
            if (room.getPrice() == apiRoom.getPrice() && room.getPersons() == apiRoom.getPersons() &&
                    room.getHotelName() == apiRoom.getHotelName() && room.getCityName() == apiRoom.getCityName()) {
                identicalRoomFound = true;
            }
        }
        return identicalRoomFound;
    }
}

//    public Controller() {
//        BookingComAPI bookingComAPI = new BookingComAPI();
//        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI();
//        GoogleAPI googleAPI = new GoogleAPI();
//        apis = new API[]{bookingComAPI, tripAdvisorAPI, googleAPI};
//    }
//    BookingComAPI bookingComAPI;
//    TripAdvisorAPI tripAdvisorAPI;
//    GoogleAPI googleAPI;
//
//        public Room[] requestRooms ( int price, int persons, String city, String hotel){
//
//            bookingComAPI.findRooms(price, persons, city, hotel);
//            tripAdvisorAPI.findRooms(price, persons, city, hotel);
//            googleAPI.findRooms(price, persons, city, hotel);

// Room[] rooms = new Room[5];
//        for(Room room : rooms){
//            Room[] rooms1 =
//        }
//        }
//    }

//    public Room[] check(API api1, API api2){
//        int i = 0;
//        int j = 1;
//        Room[] rooms = new Room[]
//    }


//}


//        private static void requestRooms1(Room rooms,API api){
//            System.out.println("method is starting");
//            readable.readFilesFromStorage(storage);
//        }


//
//        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
//        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
//        GoogleAPI googleAPI = new GoogleAPI();

//        bookingComAPI.findRooms(requestRooms())
