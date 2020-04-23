interface Visitor {
	public String visit(Exp exp);
	public String visit(Plus exp);
	public String visit(Minus exp);
	public String visit(Times exp);
	public String visit(Divide exp);
	
	public String visit(Num exp);
}