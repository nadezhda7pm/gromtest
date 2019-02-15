package lesson15.homeTask.apis;

import java.util.Arrays;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int n = 0;
        for (Room room : rooms) {
            if (room != null){
            if ((price - 100 <= room.getPrice()) && (room.getPrice() <= price + 100) && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)){
                n++;}
            }
        }


        int i = 0;
        Room[] foundRooms = new Room[n];
        for (Room room : rooms) {
            if (room != null)
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingComAPI that = (BookingComAPI) o;
        return Arrays.equals(rooms, that.rooms);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rooms);
    }
}
