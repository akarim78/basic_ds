public class MedianTwoArrays {

	public static void main(String args[]) {
		int[] a = {1, 3, 6, 7, 9};
		int[] b = {2, 5, 8, 10, 14};

		double med = getMedian(a, b, 5);
		System.out.println("Median: " + med);

		med = getMedian(a, b);
		System.out.println("Median: " + med);
	}

	public static double getMedian(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		if(((m+n)/2) % 2==0) {// even
			return (findKth(a, b, (m+n)/2, 0, m-1, 0, n-1) 
				+ findKth(a, b, (m+n)/2-1, 0, m-1, 0, n-1))/2.0;
		} else { //odd
			return (double)findKth(a, b, (m+n)/2, 0, m-1, 0, n-1);
		}
	}

	public static int findKth(int[] a, int[] b, int k, int aStart, int aEnd, int bStart, int bEnd) {
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
		
		// let's handle special cases
		if(aLen == 0) return b[bStart + k];
		if(bLen == 0) return a[aStart + k];
		if(k == 0) return min(a[aStart], b[bStart]);

		int aMid = aStart + aLen/2;
		int bMid = bStart + bLen/2;
		//int aMid = aLen * k / (aLen + bLen); // a's middle count
		//int bMid = k - aMid - 1; // b's middle count
 
		// make aMid and bMid to be array index
		//aMid = aMid + aStart;
		//bMid = bMid + bStart;
	
		if(a[aMid] < b[bMid]) {
			k = k - (aMid - aStart + 1);
			aStart = aMid + 1;
			bEnd = bMid;
			
		} else{
			k = k -(bMid - bStart + 1);
			bStart = bMid + 1;
			aEnd = aMid;
		}
		return findKth(a, b, k, aStart, aEnd, bStart, bEnd);
	
	}

	public static int max(int x, int y){ 
		if(x > y) return x; 
		return y;
	}
	public static int min(int x, int y) {
		if(x < y) return x;
		return y;
	}

	public static int median(int[] x, int start, int end) {
		int n = end - start + 1;
		if(n % 2 == 0) return (x[n/2] + x[n/2 - 1])/2;
		else return x[n/2];

	}	

	// doesn't work for unequal size
	public static double getMedian(int[] a, int[] b, int n) {
		int m1 = -1;
		int m2 = -1;
		int i = 0;
		int j = 0;

		for(int count = 0; count <= n; count++) {
			if(i == n) {
				m1 = m2;
				m2 = b[0];
				break;
			}

			if(j == n) {
				m1 = m2;
				m2 = a[0];
				break;
			}

			if(a[i] < b[j]) {
				m1 = m2;
				m2 = a[i];
				i++;
			} else{
				m1 = m2;
				m2 = b[j];
				j++;
			}
		}
		
		return  (m1 + m2)/2.0;
	}
}
