import java.util.LinkedList;
import java.util.Queue;

public class RotAllOranges {

	public static void main(String[] args) {
		int[][] arr = { { 2, 1, 0, 2, 1 },
				{ 1, 0, 1, 2, 1 },
				{ 1, 0, 0, 2, 1 } };
		int ans = rotOranges(arr, 3, 5);
		if (ans == -1) {
			System.out.println("All oranges cannot rot");
		} else {
			System.out.println("Time required for all oranges to rot = " + ans);
		}
	}

	static int rotOranges(int[][] arr, int rows, int cols) {
		int[] x = { 1, -1, 0, 0 };
		int[] y = { 0, 0, 1, -1 };
		Queue<RottenOrange> rottenOranges = new LinkedList<>();
		int ans = 0;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (arr[i][j] == 2)
					rottenOranges.add(new RottenOrange(i, j));

		rottenOranges.add(new RottenOrange(-1, -1));

		while (!rottenOranges.isEmpty()) {
			boolean flag = false;
			while (!rottenOranges.isEmpty() && !isDelim(rottenOranges.peek())) {
				RottenOrange temp = rottenOranges.remove();
				for (int i = 0; i < 4; i++) {
					int newX = temp.x + x[i];
					int newY = temp.y + y[i];
					if (isValid(newX, newY, arr, rows, cols)) {
						if (!flag) {
							ans++;
							flag = true;
						}
						arr[newX][newY] = 2;
						rottenOranges.add(new RottenOrange(newX, newY));
					}
				}
			}
			rottenOranges.remove();
			if (!rottenOranges.isEmpty()) {
				rottenOranges.add(new RottenOrange(-1, -1));
			}
		}

		return (checkAll(arr, rows, cols)) ? -1 : ans;
	}

	private static boolean isValid(int x, int y, int[][] arr, int rows, int cols) {
		return (x >= 0 && y >= 0 && x < rows && y < cols) && arr[x][y] == 1;
	}

	static boolean isDelim(RottenOrange rottenOrange) {
		return rottenOrange.x == -1 && rottenOrange.y == -1;
	}

	static boolean checkAll(int arr[][], int rows, int cols) {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (arr[i][j] == 1)
					return true;
		return false;
	}

	static class RottenOrange {
		int x = 0;
		int y = 0;

		RottenOrange(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}