package a4;

public class CaliforniaString implements Comparable<CaliforniaString> {
	final String string;

	public CaliforniaString(String string) {
		this.string = string;
	}
	
	public int length() {
		return string.length();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((string == null) ? 0 : string.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaliforniaString other = (CaliforniaString) obj;
		if (string == null) {
			if (other.string != null)
				return false;
		} else if (!string.equals(other.string))
			return false;
		return true;
	}

	@Override
	/*
	 * Compares this object with the specified object for order. 
	 * Returns a negative integer, zero, or a positive integer 
	 * as this object is less than, equal to, or greater than the specified object.
	 */
	public int compareTo(CaliforniaString that) {
		String sortOrder = "RWQOJMVAHBSGZXNTCIEKUPDYFL";
		if (this.string.equals(that.string)) return 0;
		int n = Math.min(this.length(), that.length());
		for (int i=0; i<n; i++) {
			int c1 = sortOrder.indexOf(this.string.charAt(i));
			int c2 = sortOrder.indexOf(that.string.charAt(i));
			if (c1 < c2) return -1;
			else if (c2 < c1) return 1;
		}
		return (this.length() > that.length())?1:-1;
	}

	@Override
	public String toString() {
		return string;
	}
	
	

}
