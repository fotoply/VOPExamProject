package mountains_in_france;

import java.util.Arrays;

/**
 * @author erso
 *         Udleveret kode skelet med main()-metode til opgave 4, VOP eksamen 10 juni 2016
 */
public class Mountain implements Comparable<Mountain> {

    private String name;
    private int height;
    private int prominence;
    private String latitude;
    private String longtitude;
    private String rangeName;

    public Mountain(String name, String height, String prominence, String latitude, String longtitude, String rangeName) {
        this.name = name;
        this.height = Integer.parseInt(height);
        this.prominence = Integer.parseInt(prominence);
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.rangeName = rangeName;
    }

    public static void main(String[] args) {
        // Til test af Mountain-klassen

        //Opg a Test af constructor og toString()
        // NB: \u00B0 er unicode for grade-tegnet
        Mountain m = new Mountain("Mont Ventoux", "1909", "1148", "44\u00B010'26\"", "05\u00B016'42\"", "Alps");
        System.out.println(m);

        // Opg b Test af compareTo()
        Mountain[] testArray = new Mountain[4];
        testArray[3] = new Mountain("Pic du Midi d'Ossau", "2886", "1092", "42\u00B048'22\"", "-00\u00B025'05\"", "Pyrenees");
        testArray[2] = new Mountain("Pic de Bure", "2709", "1268", "44\u00B037'38\"", "05\u00B056'07\"", "Alps");
        testArray[1] = new Mountain("Mont Chaberton", "3131", "1281", "44\u00B057'53\"", "06\u00B045'06\"", "Alps");
        testArray[0] = new Mountain("Pica d'Estats", "3143", "1281", "42\u00B042'43\"", "00\u00B057'23\"", "Pyrenees");

        System.out.println("Usorteret: ");
        System.out.println(Arrays.toString(testArray).replace(',', '\n'));

        System.out.println("Sorteret: "); // Der er i eksemplerne både vist stigende og faldene sortering.
        // I dette tilfælde er der valgt at sorteringen skal gå fra mindst til størst, da det er dette der er givet i det første eksempel samt da det er dette der er standard for sortering af tal i Java.
        Arrays.sort(testArray);
        System.out.println(Arrays.toString(testArray).replace(',', '\n'));

    }

    @Override
    public String toString() {
        return String.format("%-25s| h=%-6d| pro=%-6d| lat=%-10s| lon=%-10s| ran=%-20s", name, height, prominence, latitude, longtitude, rangeName);
    }

    @Override
    public int compareTo(Mountain o) {
        if (this.prominence == o.prominence) {
            return Integer.compare(this.height, o.height);
        } else {
            return Integer.compare(this.prominence, o.prominence);
        }
    }

    public String getRangeName() {
        return rangeName;
    }
}
