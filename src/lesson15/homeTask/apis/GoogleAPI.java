package lesson15.homeTask.apis;

import java.util.Arrays;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int n = 0;
        for (Room room : rooms) {
            if (room != null)
            if (room.getPrice() == price && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel))
                n++;
        }

        Room[] foundRooms = new Room[n];
        int i = 0;
        for (Room room : rooms) {
            if (room != null)
            if (room.getPrice() == price && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
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
        GoogleAPI googleAPI = (GoogleAPI) o;
        return Arrays.equals(rooms, googleAPI.rooms);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rooms);
    }
}

