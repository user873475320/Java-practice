package Algorithmic_tasks;

import java.util.List;

public class ListFiltering {
	public static List<Object> filterList(final List<Object> list) {
		return list.stream().filter(Number.class::isInstance).toList();
	}
}
