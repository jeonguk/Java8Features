package com.jeonguk.java8.string;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Random;

@Slf4j
public class RandomStringTest {

	// Generate Random Unbounded String with Plain Java
	@Test
	public void givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect() {
		byte[] array = new byte[7]; // length is bounded by 7
		new Random().nextBytes(array);
		String generatedString = new String(array, Charset.forName("UTF-8"));

		log.info("generatedString = {}", generatedString);
	}

	// Generate Random Bounded String with Plain Java
	@Test
	public void givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect() {

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int)
					(random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();
		log.info("generatedString = {}", generatedString);
	}

	// Generate Bounded Random String with Apache Commons Lang
	@Test
	public void givenUsingApache_whenGeneratingRandomStringBounded_thenCorrect() {

		int length = 10;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		log.info("generatedString = {}", generatedString);
	}

	// Generate Alphabetic String with Apache Commons Lang
	@Test
	public void givenUsingApache_whenGeneratingRandomAlphabeticString_thenCorrect() {
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		log.info("generatedString = {}", generatedString);
	}

	// Generate Alphanumeric String with Apache Commons Lang
	@Test
	public void givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect() {
		String generatedString = RandomStringUtils.randomAlphanumeric(10);
		log.info("generatedString = {}", generatedString);
	}

}
