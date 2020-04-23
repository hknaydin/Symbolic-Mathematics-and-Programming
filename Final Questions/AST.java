abstract class Exp { 
    public abstract String accept(Visitor v);
}

class IkiNokta extends Exp {
	public  Exp a, b;
	public IkiNokta(Exp x, Exp y) {
	  a = x;
	  b = y;
	}
	
	public String accept(Visitor v)
	{
	  return v.visit(this);
	}
}

class Comma extends Exp {
	public  Exp a, b;
	public Comma(Exp x, Exp y) {
	  a = x;
	  b = y;
	}
	
	public String accept(Visitor v)
	{
	  return v.visit(this);
	}
}

class Ok extends Exp {
	public  Exp a, b;
	public Ok(Exp x, Exp y) {
	  a = x;
	  b = y;
	}
	
	public String accept(Visitor v)
	{
	  return v.visit(this);
	}
}

class Dik extends Exp {
	public  Exp a, b;
	public Dik(Exp x, Exp y) {
	  a = x;
	  b = y;
	}
	
	public String accept(Visitor v)
	{
	  return v.visit(this);
	}
}

class Plus extends Exp {
	public  Exp a, b;
	public Plus(Exp x, Exp y) {
	  a = x;
	  b = y;
	}
	
	public String accept(Visitor v)
	{
	  return v.visit(this);
	}
}

class Minus extends Exp {
	public  Exp a, b;
	public Minus(Exp x, Exp y) {
	  a = x;
	  b = y;
	}
	
	public String accept(Visitor v)
	{
	  return v.visit(this);
	}
}

class Times extends Exp {
	public  Exp a, b;
	public Times(Exp x, Exp y) {
	  a = x;
	  b = y;
	}
	
	public String accept(Visitor v)
	{
	  return v.visit(this);
	}
}

class Divide extends Exp {
	public  Exp a, b;
	public Divide(Exp x, Exp y) {
	  a = x;
	  b = y;
	}
	
	public String accept(Visitor v)
	{
	  return v.visit(this);
	}
}

class Power extends Exp {
	public  Exp a, b;
	public Power(Exp x, Exp y) {
	  a = x;
	  b = y;
	}
	
	public String accept(Visitor v)
	{
	  return v.visit(this);
	}
}

class Mod extends Exp {
	public  Exp a, b;
	public Mod(Exp x, Exp y) {
	  a = x;
	  b = y;
	}
	
	public String accept(Visitor v)
	{
	  return v.visit(this);
	}
}

class Num extends Exp {
    public  String a;
    public Num(String x) {
        a = x;
    }
    public String accept(Visitor v)
    {
        return v.visit(this);
    }
}

class Var extends Exp {
    public  String a;
    public Var(String x) {
        a = x;
    }
    public String accept(Visitor v)
    {
        return v.visit(this);
    }
}
