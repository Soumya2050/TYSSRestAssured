package assignment;

public class FunctionalClass {

	public static void main(String[] args) {

		FunctionalInterFace fn = (x, y) -> {
			System.out.println("Implemaentation class "+(x+y));
		};
		fn.sum(10, 20);
	}

}
