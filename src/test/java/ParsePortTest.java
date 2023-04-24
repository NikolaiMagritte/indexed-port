import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ParsePortTest extends TestCase {
    Port port1;
    ParsePort parsePort = new ParsePort();
    @Override
    protected void setUp() throws Exception {
        String[] indexes1 = {"1,3-5", "2", "3-4"};
        port1 = new Port(indexes1);
    }

    public void testGetUniqueGroups() {
        List<List<Integer>> expected1 = new ArrayList<>();
        List<Integer> inner1_1 = List.of(1, 2, 3);
        List<Integer> inner1_2 = List.of(1, 2, 4);
        List<Integer> inner1_3 = List.of(3, 2, 3);
        List<Integer> inner1_4 = List.of(3, 2, 4);
        List<Integer> inner1_5 = List.of(4, 2, 3);
        List<Integer> inner1_6 = List.of(4, 2, 4);
        List<Integer> inner1_7 = List.of(5, 2, 3);
        List<Integer> inner1_8 = List.of(5, 2, 4);
        expected1.add(inner1_1);
        expected1.add(inner1_2);
        expected1.add(inner1_3);
        expected1.add(inner1_4);
        expected1.add(inner1_5);
        expected1.add(inner1_6);
        expected1.add(inner1_7);
        expected1.add(inner1_8);

        List<List<Integer>> actual = parsePort.getUniqueGroups(port1);

        assertEquals(expected1, actual);
    }
}
