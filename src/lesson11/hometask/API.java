package lesson11.hometask;

public interface API {
    Room[] findRooms(int price, int persons, String city, String hotel);
    Room[] getAll();

}
