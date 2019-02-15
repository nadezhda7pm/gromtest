package lesson15.homeTask.apis;

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
        for (Room roomApi1 : api1.getAll()) {
            for (Room roomApi2 : api2.getAll()) {
                if (roomApi1 != null && roomApi1.equals(roomApi2))
                    n++;
            }
        }

        Room[] checkedRooms = new Room[n];
        int i = 0;
        if (api1 != null && api2 != null) {
            for (Room roomApi1 : api1.getAll()) {
                for (Room roomApi2 : api2.getAll()) {
                    if (roomApi1 != null && roomApi1.equals(roomApi2)) {
                        checkedRooms[i] = roomApi1;
                        i++;
                    }
                }
            }
        }
        return checkedRooms;
    }
}

//    public boolean checkRoom(Room room, API api) {
//        boolean identicalRoomFound = false;
//        if (api != null) {
//            for (Room apiRoom : api.getAll()) {
//                if (apiRoom.equals(room)) {
//                    identicalRoomFound = true;
//                }
//            }
//        }
//        return identicalRoomFound;
//    }
