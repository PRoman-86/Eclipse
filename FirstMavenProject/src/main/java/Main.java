import org.apache.commons.lang3.StringUtils;

public class Main {

	public static void main(String[] args) {

		complexAbbreviateTest();
	}

	public static void complexAbbreviateTest() {

		System.out.println("������ ...".equals(StringUtils.abbreviate("������ ����, ��� ����� �� ����", 10))); // true
		System.out.println("������ ����, ��� ...".equals(StringUtils.abbreviate("������ ����, ��� ����� �� ����", 20))); // true
		System.out.println(StringUtils.abbreviate(null, 2)); // null
		System.out.println("".equals(StringUtils.abbreviate("", 1))); // true
		System.out.println("12...".equals(StringUtils.abbreviate("123 456", 5))); //true

	}

}
