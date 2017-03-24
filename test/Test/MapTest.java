
package Test;

import map.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class MapTest {
    
    private Map<String, String> map;
    
    @Before
    public void before () {
        map = new Map<>();
    }
   
    
    @Test
    public void testGetMap () {
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        
        assertThat(map.get("key1"), is("value1"));
        assertThat(map.get("key2"), is("value2"));
        assertThat(map.get("key3"), is("value3"));
    }
    
    @Test
    public void testGetMapSize () {
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        
        assertThat(map.size(), is(3));
    }
    
    @Test
    public void testMapIsEmpty () {
        assertThat(map.isEmpty(), is(true));
    }
    
    
    

}
