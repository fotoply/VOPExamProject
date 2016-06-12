package mountains_in_france;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MountainSet {
    private Set<Mountain> mountains;

    public MountainSet() {
        this.mountains = new TreeSet<>();
    }

    public static void main(String[] args) {
        MountainSet mountainSet = new MountainSet();
        try {
            mountainSet.readDateFromFile(new File("FranskeBjerge.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(mountainSet.getMountains().toString().replace(',', '\n'));
        System.out.println("Sorted by range name: ");
        System.out.println(mountainSet.sortByRange(new MountainRangeComparator()).toString().replace(',', '\n'));
    }

    public Set<Mountain> sortByRange(Comparator comparator) {
        TreeSet<Mountain> newSortedSet = new TreeSet<>(comparator);
        newSortedSet.addAll(mountains);
        return newSortedSet;
    }

    public Set<Mountain> getMountains() {
        return mountains;
    }

    /**
     * Reads data into the set from a file.
     * @param inputFile a semi-colon separated file of the data
     * @throws FileNotFoundException
     */
    public void readDateFromFile(File inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNextLine()) {
            String[] inputs = scanner.nextLine().split(";");

            //Variabler tilføjet for bedre læsebarhed af koden.
            String name = inputs[0];
            String height = inputs[1];
            String prominence = inputs[2];
            String latitude = inputs[3];
            String longtitude = inputs[4];
            String rangeName = inputs[5];

            mountains.add(new Mountain(name, height, prominence, latitude, longtitude, rangeName));
        }
    }
}
