package test;


import algorithms.Map;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MapTest {

    private Map<String, String> map;

    @Before
    public void before() {
        map = new Map<>();
    }

    @Test
    public void testGetMapEntry() {
        map.put("test", "1234");
        assertThat(map.get("test"), is("1234"));
    }

    @Test
    public void testGetMapSize() {
        map.put("test", "1234");
        map.put("test1", "1234");
        map.put("test2", "1234");
        assertThat(map.size(), is(3));
    }

    @Test
    public void testAutomaticSizeAllocation() {
        for (int i = 1; i <= 17; i++) {
            map.put("test" + i, "number " + i);
        }

        assertThat(map.get("test17"), is("number 17"));
    }
}
