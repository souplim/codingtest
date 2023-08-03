public class Q15_lv2_쿼드압축후개수세기3 {
	private static class Count {
		public final int zero;
		public final int one;
		
		public Count(int zero, int one) {
			this.zero = zero;
			this.one = one;
		}
		public Count add(Count other) {
			return new Count(zero + other.zero, one + other.one);
		}
	}
	
	private Count count(int offsetX, int offsetY, int size, int[][] arr) {
		int h = size/2;
		for(int x=offsetX; x<offsetX + size; x++) {
			for(int y=offsetY; y<offsetY + size; y++) {
				// 원소가 섞여 있는 경우
				if(arr[y][x] != arr[offsetY][offsetX]) {
					return count(offsetX, offsetY, h, arr)
							.add(count(offsetX + h, offsetY, h, arr))
							.add(count(offsetX, offsetY + h, h, arr))
							.add(count(offsetX + h, offsetY + h, h, arr));
				}
			}
		}
		// 모든 원소가 같은 값인 경우
		if(arr[offsetY][offsetX] == 1)
			return new Count(0, 1);
		return new Count(1, 0);
	}
	
	public int[] solution(int[][] arr) {
		Count count = count(0, 0, arr.length, arr);
        return new int[] {count.zero, count.one};
    }
}	

