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
            if (api != null)
                n += api.findRooms(price, persons, city, hotel).length;
        }

        Room[] requestedRooms = new Room[n];
        int i = 0;
        for (API api : apis) {
            if (api != null) {
                for (Room room : api.findRooms(price, persons, city, hotel)) {
                    requestedRooms[i] = room;
                    i++;
                }
            }
        }
        return requestedRooms;
    }


    public Room[] check(API api1, API api2) {
        int n = 0;
        for (Room room : api1.getAll()) {
            if (checkRoom(room, api2))
                n++;
        }

        Room[] checkedRooms = new Room[n];
        int i = 0;
        for (Room room : api1.getAll()) {
            if (checkRoom(room, api2)) {
                checkedRooms[i] = room;
                i++;
            }
        }
        return checkedRooms;

    }

    public boolean checkRoom(Room room, API api) {
        boolean identicalRoomFound = false;
        if (api != null) {
            for (Room apiRoom : api.getAll()) {
                if (room != null && apiRoom != null && room.getPrice() == apiRoom.getPrice() && room.getPersons() == apiRoom.getPersons() &&
                        room.getHotelName().equals(apiRoom.getHotelName()) && room.getCityName().equals(apiRoom.getCityName())) {
                    identicalRoomFound = true;
                }
            }
        }
        return identicalRoomFound;
    }


//    public boolean checkFoundRoomAgain(Room foundRoom, Room[] rooms) {
//        boolean identicalRoomFound = false;
//        if (rooms != null) {
//            for (Room room : rooms) {
//                if (foundRoom != null && room != null && foundRoom.getPrice() == room.getPrice() && foundRoom.getPersons() == room.getPersons() &&
//                        foundRoom.getHotelName().equals(room.getHotelName()) && foundRoom.getCityName().equals(room.getCityName())) {
//                    identicalRoomFound = true;
//                }
//            }
//        }
//        return identicalRoomFound;
//    }


}
