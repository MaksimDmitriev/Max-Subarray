package maxsubarray;

public class MaxSubarray {

	private MaxSubarray() {
		throw new AssertionError();
	}

	public static int[] maxSubarray(int[] input) {
		if (input == null || input.length == 0) {
			return null;
		}
		return maxSubarray(input, 0, input.length - 1);
	}

	private static int[] maxSubarray(int[] input, int low, int high) {
		// low, high, sum
		int[] leftRes = new int[3];
		int[] rightRes = new int[3];
		int[] crossRes = new int[3];
		if (low == high) {
			return new int[] { low, high, input[low] };
		} else {
			int mid = low + (high - low) / 2;
			leftRes = maxSubarray(input, low, mid);
			rightRes = maxSubarray(input, mid + 1, high);
			crossRes = maxCrossing(input, low, mid, high);
		}
		if (leftRes[2] >= rightRes[2] && leftRes[2] >= crossRes[2]) {
			return leftRes;
		} else if (rightRes[2] >= leftRes[2] && rightRes[2] >= crossRes[2]) {
			return rightRes;
		} else {
			return crossRes;
		}

	}

	private static int[] maxCrossing(int[] input, int low, int mid, int high) {
		int sumLeft = Integer.MIN_VALUE;
		int sum = 0;
		int maxLeft = mid;
		for (int i = mid; i >= low; i--) {
			sum += input[i];
			if (sum > sumLeft) {
				sumLeft = sum;
				maxLeft = i;
			}
		}

		int sumRight = Integer.MIN_VALUE;
		sum = 0;
		int maxRight = mid + 1;
		for (int i = mid + 1; i <= high; i++) {
			sum += input[i];
			if (sum > sumRight) {
				sumRight = sum;
				maxRight = i;
			}
		}
		// low, high, sum
		return new int[] { maxLeft, maxRight, sumLeft + sumRight };
	}

}
