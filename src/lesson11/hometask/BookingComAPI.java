package lesson11.hometask;

import java.util.Date;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int n = 0;
        for (Room room : rooms) {
            if (((price - 100) <= room.getPrice()) && (room.getPrice() <= (price + 100)) && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel))
                n++;
        }

        int i = 0;
        Room[] foundRooms = new Room[n];
        for (Room room : rooms) {
            if (((price - 100) <= room.getPrice()) && (room.getPrice() <= (price + 100)) && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
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
