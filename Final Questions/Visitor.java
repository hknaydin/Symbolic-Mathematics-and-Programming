
public interface Visitor {
	public String visit(Exp exp);
	
	public String visit(Plus exp);
	public String visit(Minus exp);
	public String visit(Times exp);
	public String visit(Divide exp);
	public String visit(Power exp);
	public String visit(Mod exp);
	
	public String visit(Comma exp);	
	public String visit(IkiNokta exp);
	public String visit(Ok exp);	
	public String visit(Dik exp);
	
	public String visit(Num exp);
	public String visit(Var exp);
}