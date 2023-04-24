import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ParsePort {

    private int[][] getNumbersArray(Port port) {

        String[] indexes = port.getIndexes();
        List<int[]> result = new ArrayList<>();

        for (String index : indexes) {

            int rangeSize = 0;
            String[] element = index.split(",");
            for (int i = 0; i < element.length; i++) {
                if (element[i].contains("-")) {
                    String[] groupOfNumbers = element[i].split("-");
                    rangeSize += Integer.parseInt(groupOfNumbers[1]) - Integer.parseInt(groupOfNumbers[0]);
                }
                rangeSize += 1;
            }

            String[] indexParts = index.split(",");
            int[] range = new int[rangeSize];
            int rangeIndex = 0;

            for (String part : indexParts) {
                if (part.contains("-")) {
                    String[] rangeParts = part.split("-");
                    int start = Integer.parseInt(rangeParts[0]);
                    int end = Integer.parseInt(rangeParts[1]);

                    for (int i = start; i <= end; i++) {
                        range[rangeIndex] = i;
                        rangeIndex++;
                    }
                } else {
                    range[rangeIndex] = Integer.parseInt(part);
                    rangeIndex++;
                }
            }
            result.add(range);
        }
        return result.toArray(new int[0][]);
    }


    public List<List<Integer>> getUniqueGroups(Port port) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        int[][] arr = getNumbersArray(port);
        if (arr == null || arr.length == 0) {
            return new ArrayList<>(result);
        }
        List<Integer> currentGroup = new ArrayList<>();
        getUniqueGroupsHelper(arr, 0, currentGroup, result);
        return new ArrayList<>(result);
    }

    private static void getUniqueGroupsHelper(int[][] arr, int index, List<Integer> currentGroup, Set<List<Integer>> result) {
        if (index == arr.length) {
            if (!currentGroup.isEmpty()) {
                result.add(new ArrayList<>(currentGroup));
            }
            return;
        }
        for (int i = 0; i < arr[index].length; i++) {
            currentGroup.add(arr[index][i]);
            getUniqueGroupsHelper(arr, index + 1, currentGroup, result);
            currentGroup.remove(currentGroup.size() - 1);
        }
    }

}
