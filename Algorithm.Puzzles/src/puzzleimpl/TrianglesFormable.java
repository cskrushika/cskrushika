package puzzleimpl;

public class TrianglesFormable {
	public static void main(String[] args) {
		int[] intArray = { 10, 21, 22, 100, 101, 200, 300};
		int count = calculateTriangles(intArray);
		System.out.println("Number of triangles: " + count);
	}

	public static int calculateTriangles(int[] a) {
		int i,j,k;
		int count = 0;
		int len = a.length;
		for (i = 0; i < len - 2; ++i) {
			k = i + 2;
			for (j = i + 1; j < len; ++j) {
				while (k < len && a[i] + a[j] > a[k]) {
					count += k - j;
					k++;
				}
			}
		}
		return count;
	}
}
