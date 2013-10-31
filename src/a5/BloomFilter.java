package a5;

public class BloomFilter<T> {
	
	boolean[] a = new boolean[256];

	public int hash(String string, int i) {
		return (byte)(string.hashCode() >> 8*i) & 0xFF;
	}

	public boolean contains(String string) {
		for (int i=0; i<4; i++) {
			if (!a[hash(string, i)]) return false;
		}
		return true;
	}

	public void add(String string) {
		for (int i=0; i<4; i++) {
			a[hash(string, i)] = true;
		}
	}

}
