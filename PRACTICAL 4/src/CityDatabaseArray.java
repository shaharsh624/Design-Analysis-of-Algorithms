public class CityDatabaseArray {

    private static final int N = 10;

    private String[] cityNames;
    private int[] xCoords;
    private int[] yCoords;
    private int size;

    public CityDatabaseArray() {
        cityNames = new String[N];
        xCoords = new int[N];
        yCoords = new int[N];
        size = 0;
    }

    // Inserts a record with the given name and coordinates
    public void insert(String name, int x, int y) {
        if (size >= cityNames.length) {
            resize();
        }
        cityNames[size] = name;
        xCoords[size] = x;
        yCoords[size] = y;
        size++;
    }

    // Deletes a record with the given name or coordinates
    public void delete(String nameOrCoord) {
        for (int i = 0; i < size; i++) {
            if (cityNames[i].equals(nameOrCoord) || (xCoords[i] + "," + yCoords[i]).equals(nameOrCoord)) {
                cityNames[i] = cityNames[size - 1];
                xCoords[i] = xCoords[size - 1];
                yCoords[i] = yCoords[size - 1];
                size--;
                return;
            }
        }
    }

    // Search - Returns its index, or -1 if not found
    public int search(String coordinate) {
        for (int i = 0; i < size; i++) {
            if (cityNames[i].equals(coordinate) || (xCoords[i] + "," + yCoords[i]).equals(coordinate)) {
                return i;
            }
        }
        System.out.println("City is:");
        return -1;
    }

    // Prints all records within the given distance of the specified point
    public void printNearby(int x, int y, double distance) {
        for (int i = 0; i < size; i++) {
            double dx = xCoords[i] - x;
            double dy = yCoords[i] - y;
            double dist = Math.sqrt(dx*dx + dy*dy);
            if (dist <= distance) {
                System.out.println(cityNames[i] + " (" + xCoords[i] + "," + yCoords[i] + ")");
            }
        }
    }

    // Resizes the arrays to twice their current capacity
    private void resize() {
        int newCapacity = 2 * cityNames.length;
        String[] newCityNames = new String[newCapacity];
        int[] newXCoords = new int[newCapacity];
        int[] newYCoords = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newCityNames[i] = cityNames[i];
            newXCoords[i] = xCoords[i];
            newYCoords[i] = yCoords[i];
        }
        cityNames = newCityNames;
        xCoords = newXCoords;
        yCoords = newYCoords;
    }


    public static void main(String[] args) {
        CityDatabaseArray db = new CityDatabaseArray();
        db.insert("Chennai",50,60);
        db.insert("Kolkata",40 ,70);
        db.insert("Mumbai",50,90);
        db.insert("Delhi",20 ,70);
        System.out.println("Index: " + db.search("Mumbai")); // Search
        db.printNearby(30,70,20); // Find Nearby
    }

}

