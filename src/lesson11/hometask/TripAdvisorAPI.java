package lesson11.hometask;

import java.util.Date;

public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int n = 0;
        for (Room room : rooms) {
            if (room != null)
            if (room.getPrice() == price && room.getPersons() >= (persons - 1) && room.getPersons() <= (persons + 1) && room.getCityName().equals(city) && room.getHotelName().equals(hotel))
                n++;
        }

        int i = 0;
        Room[] foundRooms = new Room[n];
        for (Room room : rooms) {
            if (room != null)
            if (room.getPrice() == price && room.getPersons() >= (persons - 1) && room.getPersons() <= (persons + 1) && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                foundRooms[i] = room;
                i++;
            }
        }
        return foundRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}


//    public TripAdvisorAPI() {
//        Room room1 = new Room(1, 50, 1, new Date(), "City1", "Hotel1");
//        Room room2 = new Room(2, 150, 2, new Date(), "City1", "Hotel");
//        Room room3 = new Room(3, 100, 3, new Date(), "City1", "Hotel1");
//        Room room4 = new Room(4, 5000, 5, new Date(), "City2", "Hotel2");
//        Room room5 = new Room(5, 250, 1, new Date(), "City3", "Hotel3");
//        rooms = new Room[]{room1, room2, room3, room4, room5};
//    }