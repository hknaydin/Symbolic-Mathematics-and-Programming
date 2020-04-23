public class EvalVisitor implements Visitor
{	
	public String visit(Exp exp)
	{
		return exp.accept(this);
	}

	public String visit(Plus exp)
	{
	  String a = exp.a.accept(this);
	  String b = exp.b.accept(this);
	      
	  return a + "," + b + "," + "+";
	}
  
	public String visit(Minus exp)
	{
		String a = exp.a.accept(this);
		String b = exp.b.accept(this);
      
      return a + "," + b + "," + "-";
	}
	
	public String visit(Times exp)
	{
		String a = exp.a.accept(this);
		String b = exp.b.accept(this);
      
      return a + "," + b + "," + "*";
	}

	public String visit(Divide exp)
	{
		String a = exp.a.accept(this);
		String b = exp.b.accept(this);
      
      return a + "," + b + "," + "/";
	}
	
	public String visit(Power exp)
	{
		String a = exp.a.accept(this);
		String b = exp.b.accept(this);
      
      return a + "," + b + "," + "^";
	}
	
	public String visit(Mod exp)
	{
		String a = exp.a.accept(this);
		String b = exp.b.accept(this);
      
      return  a + "," + b + "," + "%";
	}
    
	public String visit(IkiNokta exp)
	{
		String a = exp.a.accept(this);
		String b = exp.b.accept(this);

		int ustSinir = Integer.parseInt(b);
		int altSinir = Integer.parseInt(a);

		String sonuc = "";
        for(int i = altSinir; i <= ustSinir; i++)
        	 sonuc += i + ",";
        
        return sonuc.substring(0, sonuc.length() - 1);
	}	
	
	public String visit(Comma exp)
	{
		String a = exp.a.accept(this);
		String b = exp.b.accept(this);

        
        return a + "," + b;
	}
	
	public String visit(Ok exp)
	{
		String ifade = exp.a.accept(this);
		String sayilar = exp.b.accept(this);
		
		return sayilar;
	}

	public String visit(Dik exp)
	{   
		String ifade = exp.a.accept(this);
		String sayilar = exp.b.accept(this);
    
		String sonuc = "";
		String harfler = "asdfghjklþiqwertyuýopðüzxcvbnmöçASDFGHJKLÞÝQWERTYUIOPÐÜZXCVBNMÖÇ";
	    String rakamlar = "-?[0-9]+";
	    String isaretler = "+-/*^%";
	       
	    String[] ifade1 = ifade.split(",");

	    int gecici = 0;
	    String islem = "";
	    String[] karakterler = new String[ifade1.length];//3x* veya x3* ifadesi için
	        
	    for(int j = 0; j < sayilar.length(); j++) {// gelen sayilar 3,4,5,6,7,8
	    	if(sayilar.charAt(j) != ',') {//if'in içine girerse gelen değer rakamdır.
	    		ifade1 = null;
	    		ifade1 = ifade.split(",");//string virgüle göre parçalanarak sonuç diziye atılır.
	    		
			    for(int i = 0; i < ifade1.length; i++) {//ifade x3* olsun
	    	    	if(harfler.indexOf(ifade1[i]+"")>= 0 ) {//gelen deðer x demektir.
			    		ifade1[i] = sayilar.charAt(j)+"";//x yerine rakam konur.
			    	}
			    }
			    
			    if(ifade1.length == 1){//bu if çalışırsa demekki ifade değişkeninin içinde sadece x değeri var.
			    	sonuc += ifade1[0] + ",";
			    	continue;
			    }
			    
			    int sayac = 0;
			    for(int i = 0; i < ifade1.length; i++) {//ifade x3* olsun
			    	
			    	if(ifade1[i].matches(rakamlar) ) {//gelen değer x3*'den 3 demektir.
			    		karakterler[sayac] = ifade1[i];//3 değeri tutulur.
			    		sayac += 1;
			    	}
			    	else if(isaretler.indexOf(ifade1[i])>= 0 ) {//gelen değer x3*'den * demektir.
			    		islem = ifade1[i];
			    		sayac -= 2;
			    		
			    		int birinciSayi = sayac;
			    		int ikinciSayi = sayac + 1;
			    		
		    			if (islem.equals("+")) {
		    				
		    				gecici = Integer.parseInt(karakterler[birinciSayi]) + Integer.parseInt(karakterler[ikinciSayi]);
		    			}
		    			else if (islem.equals("-")) {
		    				gecici = Integer.parseInt(karakterler[birinciSayi]) - Integer.parseInt(karakterler[ikinciSayi]);
		    			}	
		    			else if (islem.equals("*")) {
		    				gecici = Integer.parseInt(karakterler[birinciSayi]) * Integer.parseInt(karakterler[ikinciSayi]);
		    			}
		    			else if (islem.equals("/")) {
		    				gecici = Integer.parseInt(karakterler[birinciSayi]) / Integer.parseInt(karakterler[ikinciSayi]);
		    			}		    			
		    			else if (islem.equals("^")) {
		    				gecici = (int) Math.pow(Double.parseDouble(karakterler[birinciSayi]), Double.parseDouble(karakterler[ikinciSayi]));
		    			}		    			
		    			else if (islem.equals("%")) {
		    				gecici = Integer.parseInt(karakterler[birinciSayi]) % Integer.parseInt(karakterler[ikinciSayi]);
	    			}
		    			karakterler[birinciSayi] =  gecici + "";//x3* işleminin sonucu tutuluyor. 
		    			karakterler[ikinciSayi] = null;
	    			sayac += 1;
			    	} 			
			    }
			    sonuc += gecici + ",";
			    gecici = 0;
		    }
		 }

	    return sonuc.substring(0, sonuc.length() - 1);//en sondaki virgül siliniyor.
	}

    public String visit(Num exp)
    {
        return exp.a;
    } 
    
    public String visit(Var exp)
    {
    	 return exp.a;
    } 
}

