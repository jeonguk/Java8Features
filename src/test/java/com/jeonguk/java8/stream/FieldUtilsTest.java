package com.jeonguk.java8.stream;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Slf4j
public class FieldUtilsTest {

	@Test
	public void fieldUtil_Test() throws Exception {
		Person p = new Person();
		p.setName("name");
		p.setAge(22);
		FieldUtils.writeField(p, "nickName", "nick name setting", true);
		assertEquals("nick name setting", p.getNickName());
	}
}
