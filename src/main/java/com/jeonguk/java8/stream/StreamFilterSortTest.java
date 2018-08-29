package com.jeonguk.java8.stream;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class StreamFilterSortTest {

	public static void main(String[] args) {

		Grid g1 = new Grid();
		g1.setName("name1");
		g1.setNum1("100000000");
		g1.setNum2("3.5");
		g1.setTyCd("01");

		Grid g2 = new Grid();
		g2.setName("name2");
		g2.setNum1("80000000");
		g2.setNum2("3.3");
		g2.setTyCd("02");

		Grid g3 = new Grid();
		g3.setName("name3");
		g3.setNum1("90000000");
		g3.setNum2("1.5");
		g3.setTyCd("03");

		Grid g4 = new Grid();
		g4.setName("name4");
		g4.setNum1("80000000");
		g4.setNum2("1.5");
		g4.setTyCd("04");

		Grid g5 = new Grid();
		g5.setName("name5");
		g5.setNum1("100000000");
		g5.setNum2("3.1");
		g5.setTyCd("05");


		final List<Grid> grids = new ArrayList<>();
		grids.add(g1);
		grids.add(g2);
		grids.add(g3);
		grids.add(g4);
		grids.add(g5);

//		grids.sort(Comparator.comparingDouble(m -> Double.valueOf(m.getNum2())));
//		grids.sort((m1, m2) -> (new BigDecimal(m2.getNum1()).compareTo(new BigDecimal(m1.getNum1()))));

//		grids.sort(new TestComparator());

		String maxGrd = ListUtils.emptyIfNull(grids).stream().max((m1, m2) -> (new BigDecimal(m1.getNum1()).compareTo(new BigDecimal(m2.getNum1())))).map(Grid::getNum1).orElse(StringUtils.EMPTY);

		String minGrd = ListUtils.emptyIfNull(grids).stream().min((m1, m2) -> (new BigDecimal(m1.getNum2()).compareTo(new BigDecimal(m2.getNum2())))).map(Grid::getNum2).orElse(StringUtils.EMPTY);

		log.info("maxGrd ===== {}", maxGrd);
		log.info("minGrd ===== {}", minGrd);

		grids.forEach(r -> {
			if (r.getNum1().equals(maxGrd)) {
				r.setMaxG("MAX");
			}
			if (r.getNum2().equals(minGrd)) {
				r.setMinG("MIN");
			}
		});

//		grids.sort((p1, p2) -> ComparisonChain.start().compare(new BigDecimal(StringUtils.defaultIfBlank(p1.getNum1(), "0")), new BigDecimal(StringUtils.defaultIfBlank(p2.getNum1(), "0")), Ordering.natural().reverse()).compare(new BigDecimal(StringUtils.defaultIfBlank(p1.getNum2(), "0")), new BigDecimal(StringUtils.defaultIfBlank(p2.getNum2(), "0"))).result());


		grids.sort((p1, p2) -> ComparisonChain.start().compare(new BigDecimal(StringUtils.defaultIfBlank(p1.getNum2(), "0")), new BigDecimal(StringUtils.defaultIfBlank(p2.getNum2(), "0"))).compare(new BigDecimal(StringUtils.defaultIfBlank(p1.getNum1(), "0")), new BigDecimal(StringUtils.defaultIfBlank(p2.getNum1(), "0")), Ordering.natural().reverse()).result());


		grids.forEach(
			g -> log.info("g = {}", g)
		);

	}

}

class Response<T> {
	private int status;
	private T result;
}

@Data
class Grid {
	private String name;
	private String num1;
	private String num2;
	private String tyCd;
	private String maxG;
	private String minG;
	private String path;
}

class GridChainedComparator implements Comparator<Grid> {

	private List<Comparator<Grid>> listComparators;

	@SafeVarargs
	public GridChainedComparator(Comparator<Grid>... comparators) {
		this.listComparators = Arrays.asList(comparators);
	}

	@Override
	public int compare(Grid o1, Grid o2) {
		for (Comparator<Grid> comparator : listComparators) {
			int result = comparator.compare(o1, o2);
			if (result != 0) {
				return result;
			}
		}
		return 0;
	}
}

class Num1Comparator implements Comparator<Grid> {
	@Override
	public int compare(Grid o1, Grid o2) {
		return new BigDecimal(o2.getNum1()).compareTo(new BigDecimal(o1.getNum1()));
	}
}

class Num2Comparator implements Comparator<Grid> {
	@Override
	public int compare(Grid o1, Grid o2) {
		return Double.valueOf(o1.getNum2()).compareTo(Double.valueOf(o2.getNum2()));
	}
}

class TestComparator implements Comparator<Grid> {

	@Override
	public int compare(Grid o1, Grid o2) {
		return new BigDecimal(o2.getNum1()).divide(new BigDecimal("100")).multiply(new BigDecimal(o2.getNum2())).compareTo(new BigDecimal(o1.getNum1()).divide(new BigDecimal("100")).multiply(new BigDecimal(o1.getNum2())));
	}
}