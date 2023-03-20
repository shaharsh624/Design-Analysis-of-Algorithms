public class CityDataBaseLinked {
    String name;
    int x;
    int y;
    CityDataBaseLinked next;

    public CityDataBaseLinked(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        next = null;
    }

    public String toString() {
        return name + " (" + x + "," + y + ")";
    }
}

class CityDatabase {

    private CityDataBaseLinked head;
    private int size;

    public CityDatabase() {
        head = null;
        size = 0;
    }

    // Inserts a record with the given name and coordinates
    public void insert(String name, int x, int y) {
        CityDataBaseLinked newCity = new CityDataBaseLinked(name, x, y);
        newCity.next = head;
        head = newCity;
        size++;
    }

    // Deletes a record with the given name or coordinates
    public void delete(String nameOrCoord) {
        if (head == null) {
            return;
        }
        if (head.name.equals(nameOrCoord) || (head.x + "," + head.y).equals(nameOrCoord)) {
            head = head.next;
            size--;
            return;
        }
        CityDataBaseLinked curr = head;
        while (curr.next != null) {
            if (curr.next.name.equals(nameOrCoord) || (curr.next.x + "," + curr.next.y).equals(nameOrCoord)) {
                curr.next = curr.next.next;
                size--;
                return;
            }
            curr = curr.next;
        }
    }

    // Searches for a record with the given name or coordinates and returns its index, or -1 if not found
    public CityDataBaseLinked search(String nameOrCoord) {
        CityDataBaseLinked curr = head;
        while (curr != null) {
            if (curr.name.equals(nameOrCoord) || (curr.x + "," + curr.y).equals(nameOrCoord)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    // Prints all records within the given distance of the specified point
    public void printNearby(int x, int y, double distance) {
        CityDataBaseLinked curr = head;
        while (curr != null) {
            double dx = curr.x - x;
            double dy = curr.y - y;
            double dist = Math.sqrt(dx * dx + dy * dy);
            if (dist <= distance) {
                System.out.println(curr);
            }
            curr = curr.next;
        }
    }

    // Returns the size of the database
    public int size() {
        return size;
    }

    public static void main(String[] args) {


        CityDatabase db = new CityDatabase();

        db.insert("New York", 0, 0);
        db.insert("Los Angeles", 100, 0);
        db.insert("Chicago", 50, 50);

        CityDataBaseLinked city = db.search("Chicago");
        if (city != null) {
            System.out.println("Found: " + city);
        }

        db.delete("New York");

        db.printNearby(0, 0, 50);

    }
}