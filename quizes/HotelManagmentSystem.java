import java.util.HashMap;
import java.util.List;
import java.util.Map;
import quizes.q3.lizi_zarkua_1.PersonManager;
import quizes.q3.lizi_zarkua_1.Persons;

class Person {
    private String name;
    private String surname;
    private String id;

    public Person( String name, String surname,String id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}

class Room {
    private int roomNumber;
    private String type;

    public Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }
}


class HotelManager {
    private Map<String, Room> guestRooms;

    public HotelManager() {
        this.guestRooms = new HashMap<>();
    }

    public void checkIn(String personId, Room room) {
        guestRooms.put(personId, room);
        System.out.println("Guest with ID " + personId + " checked into room " + room.getRoomNumber());
    }

    public void checkOut(String personId) {
        if (guestRooms.containsKey(personId)) {
            Room room = guestRooms.remove(personId);
            System.out.println("Guest with ID " + personId + " checked out of room " + room.getRoomNumber());
        } else {
            System.out.println("Guest with ID " + personId + " is not currently checked in.");
        }
    }

    public void displayInfo() {
        System.out.println("Hotel Guests and Room Information:");
        for (Map.Entry<String, Room> entry : guestRooms.entrySet()) {
            String personId = entry.getKey();
            Room room = entry.getValue();
            System.out.println("Guest with ID " + personId + " is assigned to room number " + room.getRoomNumber());
        }
    }
}


class HotelManagementSystem{
    public static void main(String[] args) {
        Map<String, Person> personsMap = PersonManager.getPersons();
        HotelManager hotelManager = new HotelManager();
        for (Map.Entry<String, Person> entry : personsMap.entrySet()) {
            String personId = entry.getKey();
            Person person = entry.getValue();
            Room room = new Room(101, "Standard");
            hotelManager.checkIn(personId, room);
        }
        hotelManager.displayInfo();
    }
}

 class Info{
    private Map<String, Room> guestRooms;

    public HotelManager() {
        guestRooms = new HashMap<>();
    }

    public void checkIn(Person person, Room room) {
        guestRooms.put(person.getId(), room);
    }

    public void checkOut(Person person) {
        guestRooms.remove(person.getId());
    }

    public void displayInfo() {
        System.out.println("Hotel Guest Information:");
        for (Map.Entry<String, Room> entry : guestRooms.entrySet()) {
            String personId = entry.getKey();
            Room room = entry.getValue();
            System.out.println("Person ID: " + personId + ", Room Number: " + room.getRoomNumber());
        }
    }
}
public static void main(String[] args) {
    List<quizes.q3.lizi_zarkua_1.Person> personsList = PersonManager.getPersons();
    HotelManager hotelManager = new HotelManager();
    Room room101 = new Room(101);
    Person firstPerson = personsList.get(0);
    Person myPerson = new Person();
    myPerson.setName("YourFirstName");
    myPerson.setSurname("YourLastName");

}

