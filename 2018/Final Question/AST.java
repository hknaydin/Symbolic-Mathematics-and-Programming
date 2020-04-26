
class Poly {
	
	public int n;
	public int[] t;
	
	public Poly(int a, int b) {
		n = 2;
		t = new int[n];
		t[1] = a;
		t[0] = b;
	}
	
	public Poly(Poly a, Poly b) {
		n = a.n + b.n - 1;
		t = new int[n];
		
		for(int i = 0; i < n - 1; i++)
			t[i] = b.t[i] * a.t[0];
		
		for(int i = 1; i < n - 1; i++)
			t[i] = t[i] + b.t[i - 1] * a.t[1];
			
		t[n - 1] = b.t[n - 2] * a.t[1];
	}
	
	public String toString() {
		String output = "";
		for(int i = n - 1; i > -1; i--)
		{
			if(i != n - 1 && t[i] > -1)
				output += "+";
			
			output += t[i] + "x^" + i;
		}
		return output;
	}
	
	public String accept(Visitor v) {
		return v.visit(this);
	}
}