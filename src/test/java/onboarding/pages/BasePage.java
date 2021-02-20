package onboarding.pages;

public class BasePage {
	private static int firstCharClassIndex;
	private static String currentbBaseScreenName;

	public long lowSync() {
		return 20;
	}

	public long mediumSync() {
		return 30;
	}

	public long highSync() {
		return 60;
	}

	@SuppressWarnings("rawtypes")
	public static String getClassName(Class c) {
		firstCharClassIndex = c.getName().lastIndexOf(".") + 1;
		if (firstCharClassIndex > 0) {
			currentbBaseScreenName = c.getName().substring(firstCharClassIndex).toString();
			return currentbBaseScreenName;
		}

		return null;
	}

	@SuppressWarnings("rawtypes")
	public static Object getPage(String pageName) {
		try {
			Class cls = Class.forName(pageName);
			Object obj = cls.newInstance();
			return obj;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getLuhnFormatNPI(long num) {
		String strVals = Long.toString(num);
		int strLen = strVals.length();
		int[] intVals = new int[strLen];
		for (int i = 0; i < strVals.length(); i++) {
			intVals[i] = Integer.parseInt(strVals.substring(i, i + 1));
		}
		for (int i = intVals.length - 1; i >= 0; i = i - 2) {
			int j = intVals[i];
			j = j * 2;
			if (j > 9) {
				j = j % 10 + 1;
			}
			intVals[i] = j;
		}
		int sum = 0;
		for (int i = 0; i < intVals.length; i++) {
			sum += intVals[i];
		}
		sum = sum + 24;

		if (sum % 10 == 0) {
			return strVals;
		} else {
			int highDigit = 10 * (sum / 10) + (sum % 10) + (10 - (sum % 10));
			int chkDigit = highDigit - sum;
			return strVals + Integer.toString(chkDigit);
		}

	}

}
