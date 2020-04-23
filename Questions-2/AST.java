abstract class Exp { 
    public abstract String accept(Visitor v);
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
