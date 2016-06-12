package mountains_in_france;

import java.util.Comparator;

/**
 * Created 6/10/16
 *
 * @author Niels Norberg
 */
public class MountainRangeComparator implements Comparator<Mountain> {
    @Override
    public int compare(Mountain o1, Mountain o2) {
        if (o1.getRangeName().compareTo(o2.getRangeName()) == 0) {
            return o1.compareTo(o2);
        } else {
            return o1.getRangeName().compareTo(o2.getRangeName());
        }
    }
}
