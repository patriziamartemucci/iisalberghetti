public class ProvaPrintf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float total3=10.56F;
		System.out.printf("  " + "%10.4f\n\n", (float)total3);
		String grandTotal =
				String.format("Grand Total: %.4f", total3);
		System.out.println(grandTotal);
	}
}
