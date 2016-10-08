package maxsubarray;

import org.junit.Assert;
import org.junit.Test;

// low, high, sum
public class MaxSubarrayTest {

	@Test
	public void verifyNull() {
		Assert.assertNull(MaxSubarray.maxSubarray(null));
	}

	@Test
	public void verifyEmpty() {
		Assert.assertNull(MaxSubarray.maxSubarray(new int[] {}));
	}

	@Test
	public void verifySingle() {
		Assert.assertArrayEquals(new int[] { 0, 0, 1 }, MaxSubarray.maxSubarray(new int[] { 1 }));
	}

	@Test
	public void verifySingleNegative() {
		Assert.assertArrayEquals(new int[] { 0, 0, -1 }, MaxSubarray.maxSubarray(new int[] { -1 }));
	}

	@Test
	public void verifyAllPositives() {
		Assert.assertArrayEquals(new int[] { 0, 3, 10 }, MaxSubarray.maxSubarray(new int[] { 1, 2, 3, 4 }));
	}

	@Test
	public void verifyAllNegatives() {
		Assert.assertArrayEquals(new int[] { 0, 0, -1 }, MaxSubarray.maxSubarray(new int[] { -1, -2, -3, -4 }));
	}

	@Test
	public void verifyAllNegativesGreatestInMiddle() {
		Assert.assertArrayEquals(new int[] { 1, 1, -1 }, MaxSubarray.maxSubarray(new int[] { -10, -1, -3, -4 }));
	}

	@Test
	public void verifyEqualArrayElements() {
		Assert.assertArrayEquals(new int[] { 0, 0, -1 }, MaxSubarray.maxSubarray(new int[] { -1, -1, -1, -1, -1 }));
	}

}
