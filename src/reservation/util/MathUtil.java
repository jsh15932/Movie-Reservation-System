package reservation.util;

import java.util.Random;

public class MathUtil {
	
	// ���ĺ��� ���ڸ� �����ϴ� ������ 12�ڸ� ���ڿ��� �����ϴ� �޼ҵ��Դϴ�.
	public static String getPasswordCode() {
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 12; i++) {
			int j = rnd.nextInt(2);
			switch (j) {
				case 0:
					temp.append((rnd.nextInt(10)));
					break;
				case 1:
					temp.append((char) ((int) (rnd.nextInt(26)) + 65));
			}
		}
		return temp.toString();
	}
	
}
