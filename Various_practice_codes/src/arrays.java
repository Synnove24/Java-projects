import java.util.Arrays;
import java.util.Random;
public class arrays{
	public static void main (String[] args) {
		int size = 10;
		int [] array1;
		int r = 2;
		Random r1 = new Random();
		array1 = new int[size];		
		for (int i = 0; i < size; i++) {
			array1[i] = r1.nextInt(11);
		}
		for (int i = 0; i< size; i++) {
			System.out.println(array1[i]);
		}
		System.out.println(Arrays.toString(array1));
		System.out.println(array1);
	}
	
}
