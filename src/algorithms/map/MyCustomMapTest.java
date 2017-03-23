package cphbusiness.algorithms.ex.redblacktree;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cphbusiness.algorithms.ex.redblacktree.map.MinimalMap;
import cphbusiness.algorithms.ex.redblacktree.map.MyCustomMap;

public class MyCustomMapTest {
	MinimalMap<Integer, String> myMap;

	@Before
	public void setup() {
		myMap = new MyCustomMap();
		myMap.put(1, "test1");
		myMap.put(2, "test2");
		myMap.put(10, "test3");
	}

	@Test
	public void testMyMapSizeReturnSize() {
		int result = myMap.size();
		assertThat(result, is(3));
	}

	@Test
	public void testMyMapGetValueByKey() {
		String result = myMap.get(1);
		assertThat(result, is(equalTo("test1")));
	}

}
