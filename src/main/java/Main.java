import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] indexes = {"1,3-5", "2", "3-4"};
        Port port = new Port(indexes);
        ParsePort parsePort = new ParsePort();
        List<List<Integer>> result = parsePort.getUniqueGroups(port);

        for (List<Integer> innerList : result) {
            for (Integer element : innerList) {
                System.out.print(element + " ");
            }
            System.out.println();
        }


    }
}
