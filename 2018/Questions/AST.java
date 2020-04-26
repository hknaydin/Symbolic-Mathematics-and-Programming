
abstract class Exp {
	public abstract double eval();
}
class Plus extends Exp {
	Exp a, b;
	public Plus(Exp a, Exp b) {
		this.a = a;
		this.b = b;
	}
	public double eval() {
		return a.eval() + b.eval();
	}
}
class Minus extends Exp {
	Exp a, b;
	public Minus(Exp a, Exp b) {
		this.a = a;
		this.b = b;
	}
	public double eval() {
		return a.eval() - b.eval();
	}
}
class Times extends Exp {
	Exp a, b;
	public Times(Exp a, Exp b) {
		this.a = a;
		this.b = b;
	}
	public double eval() {
		return a.eval() * b.eval();
	}
}
class Divide extends Exp {
	Exp a, b;
	public Divide(Exp a, Exp b) {
		this.a = a;
		this.b = b;
	}
	public double eval() {
		return a.eval() / b.eval();
	}
}
class Number extends Exp {
	double value;
	public Number(double value) {
		this.value = value;
	}
	public double eval() {
		return value;
	}
}