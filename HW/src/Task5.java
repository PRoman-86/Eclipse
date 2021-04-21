public class Task5 {

	public static void main(String[] args) {

		int[] array = { 9, 2, 6, 4, 5, 12, 7, 8, 6 };
		int sum = 0;
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
			if (max < array[i])
				max = array[i];
			if (min > array[i])
				min = array[i];
		}

		System.out.println("Задача №1: " + sum);
		System.out.println("Задача №2: " + max);
		System.out.println("Задача №3: " + min);

		int[] arrayTwo = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int sumForAverage = 0;
		for (int i = 0; i < arrayTwo.length; i++) {
			sumForAverage = sumForAverage + arrayTwo[i];
		}

		System.out.println("Задача №4: " + sumForAverage / arrayTwo.length);

		int[][] arrayThree = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9 }, { -1, -2, -3, -4 }, { -5, -6 } };
		sum = 0;
		max = 0;
		for (int a = 0; a < arrayThree[0].length; a++) {
			sum = sum + arrayThree[0][a];
			if (max < arrayThree[0][a])
				max = arrayThree[0][a];
		}
		for (int b = 0; b < arrayThree[1].length; b++) {
			sum = sum + arrayThree[1][b];
			if (max < arrayThree[1][b])
				max = arrayThree[1][b];
		}
		for (int c = 0; c < arrayThree[2].length; c++) {
			sum = sum + arrayThree[2][c];
			if (max < arrayThree[2][c])
				max = arrayThree[2][c];
		}
		for (int d = 0; d < arrayThree[3].length; d++) {
			sum = sum + arrayThree[3][d];
			if (max < arrayThree[3][d])
				max = arrayThree[3][d];
		}

		System.out.println("Задача №5: " + sum);
		System.out.println("Задача №6: " + max);
		System.out.println("Задача №7: " + (arrayThree.length + arrayThree[0].length + arrayThree[1].length
				+ arrayThree[2].length + arrayThree[3].length));

	}

}
