
package Java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VehicleAlgorithms {

    // LINEAR SEARCH
    public static int linearSearch(
            List<String> plates, String target) {

        for (int i = 0; i < plates.size(); i++) {
            if (plates.get(i).equals(target)) {
                return i;
            }
        }

        return -1;
    }

    // MERGE SORT WITH COMPARATOR
    public static List<String> mergeSort(
            List<String> types,
            Comparator<String> comparator) {

        if (types.size() <= 1) {
            return new ArrayList<>(types);
        }

        int middle = types.size() / 2;

        List<String> left = mergeSort(
            types.subList(0, middle), comparator);

        List<String> right = mergeSort(
            types.subList(middle, types.size()), comparator);

        List<String> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < left.size() && j < right.size()) {
            if (comparator.compare(
                    left.get(i), right.get(j)) <= 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            result.add(left.get(i++));
        }

        while (j < right.size()) {
            result.add(right.get(j++));
        }

        return result;
    }
}
