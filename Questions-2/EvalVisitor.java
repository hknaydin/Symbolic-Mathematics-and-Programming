import java.util.Arrays;
import java.util.List;

public class EvalVisitor implements Visitor
{

    public String visit(Exp exp)
    {
    	return exp.accept(this);
    }
    
    public String visit(Plus exp)
	{
		int sayi1 = 1, sayi2=1, sayi3=1, sayi4=1;
		
		String a = exp.a.accept(this);
        String b = exp.b.accept(this);
        
        boolean aDurum = (a.contains("/") || a.contains("*") || a.contains("-") || a.contains("+"));
        boolean bDurum = (b.contains("/") || b.contains("*") || b.contains("-") || b.contains("+"));
        
        a = a.replaceAll("[^-?0-9]+", " "); 
		List<String> aDakiSayilar = Arrays.asList(a.trim().split(" "));
		
		b = b.replaceAll("[^-?0-9]+", " "); 
		List<String> bDekiSayilar = Arrays.asList(b.trim().split(" "));
		
		if (aDurum == true && bDurum == true){//Bu if'e girerse 1/2 + 3/6 gibi bir ifade var demektir
			sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//1/2'den 1 alindi.
			sayi2 = Integer.valueOf(aDakiSayilar.get(1)+"");//1/2'den 2 alindi.

			sayi3 = Integer.valueOf(bDekiSayilar.get(0)+"");//3/6'den 3 alindi.
			sayi4 = Integer.valueOf(bDekiSayilar.get(1)+"");//3/6'den 6 alindi.
			
			sayi1 = (sayi1 * sayi4) + (sayi3 * sayi2); //yeni pay oluyor.
			sayi2 = sayi2 * sayi4; //yeni payda oluyor.
			
		}
		
		else if (aDurum == false && bDurum == false) {//Bu if'e girerse 2 + 3 gibi bir ifade var demektir
			sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//2 alindi.
			sayi2 = Integer.valueOf(bDekiSayilar.get(0)+"");//3 alindi. 
			
			sayi1 = sayi1 + sayi2; //yeni pay oluyor.
			sayi2 = 1; //yeni payda oluyor.
		}
		
		else {
			if (aDurum == true) {//Bu if'e girerse 1/2 + 3 gibi bir ifade var demektir
				sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//1/2'den 1 alindi.
				sayi2 = Integer.valueOf(aDakiSayilar.get(1)+"");//1/2'den 2 alindi.

				sayi3 = Integer.valueOf(bDekiSayilar.get(0)+"");//3 alindi.
				
				sayi1 = (sayi1) + (sayi3 * sayi2); //yeni pay oluyor.
			}
			else if(bDurum == true) {//Bu if'e girerse  3 + 1/2 gibi bir ifade var demektir
				sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//3 alindi.

				sayi3 = Integer.valueOf(bDekiSayilar.get(0)+"");//1/2'den 1 alindi.
				sayi4 = Integer.valueOf(bDekiSayilar.get(1)+"");//1/2'den 2 alindi.
				
				sayi1 = (sayi1 * sayi4) + (sayi3); //yeni pay oluyor.
				sayi2 = sayi4; //yeni payda oluyor.
			}
			
		}
		
    	int[] sayilar = new int[2];
    	sayilar = sadelestirme(sayi1, sayi2);
    	
		return sayilar[0] + "/" + sayilar[1];
	}
    
	public String visit(Minus exp)
	{	
		int sayi1 = 1, sayi2=1, sayi3=1, sayi4=1;
		
		String a = exp.a.accept(this);
        	String b = exp.b.accept(this);
        
        	boolean aDurum = (a.contains("/") || a.contains("*") || a.contains("-") || a.contains("+"));
        	boolean bDurum = (b.contains("/") || b.contains("*") || b.contains("-") || b.contains("+"));
       
        	a = a.replaceAll("[^-?0-9]+", " "); 
		List<String> aDakiSayilar = Arrays.asList(a.trim().split(" "));
		
		b = b.replaceAll("[^-?0-9]+", " "); 
		List<String> bDekiSayilar = Arrays.asList(b.trim().split(" "));
        
		if (aDurum == true && bDurum == true){//Bu if'e girerse 1/2 + 3/6 gibi bir ifade var demektir
			
			sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//1/2'den 1 alindi.
			sayi2 = Integer.valueOf(aDakiSayilar.get(1)+"");//1/2'den 2 alindi.

			
			sayi3 = Integer.valueOf(bDekiSayilar.get(0)+"");//3/6'den 3 alindi.
			sayi4 = Integer.valueOf(bDekiSayilar.get(1)+"");//3/6'den 6 alindi.
			
			sayi1 = (sayi1 * sayi4) - (sayi3 * sayi2); //yeni pay oluyor.
			sayi2 = sayi2 * sayi4; //yeni payda oluyor.
			
		}
		
		else if (aDurum == false && bDurum == false) {//Bu if'e girerse 2 + 3 gibi bir ifade var demektir
			sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//2 alindi.
			sayi2 = Integer.valueOf(bDekiSayilar.get(0)+"");//3 alindi. 
			
			sayi1 = sayi1 - sayi2; //yeni pay oluyor.
			sayi2 = 1; //yeni payda oluyor.
		}
		
		else {
			if (aDurum == true) {//Bu if'e girerse 1/2 + 3 gibi bir ifade var demektir
				sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//1/2'den 1 alindi.
				sayi2 = Integer.valueOf(aDakiSayilar.get(1)+"");//1/2'den 2 alindi.

				sayi3 = Integer.valueOf(bDekiSayilar.get(0)+"");//3 alindi.
				
				sayi1 = (sayi1) - (sayi3 * sayi2); //yeni pay oluyor.
			}
			else if(bDurum == true) {//Bu if'e girerse  3 + 1/2 gibi bir ifade var demektir
				sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//3 alindi.

				sayi3 = Integer.valueOf(bDekiSayilar.get(0)+"");//1/2'den 1 alindi.
				sayi4 = Integer.valueOf(bDekiSayilar.get(1)+"");//1/2'den 2 alindi.
				
				sayi1 = (sayi1 * sayi4) - (sayi3); //yeni pay oluyor.
				sayi2 = sayi4; //yeni payda oluyor.
			}
			
		}
		
    	int[] sayilar = new int[2];
    	sayilar = sadelestirme(sayi1, sayi2);
    	
		return sayilar[0] + "/" + sayilar[1];
	}
	
	public String visit(Times exp)
	{
		int sayi1 = 1, sayi2=1, sayi3=1, sayi4=1;
		
		String a = exp.a.accept(this);
        	String b = exp.b.accept(this);
        
        	boolean aDurum = (a.contains("/") || a.contains("*") || a.contains("-") || a.contains("+"));
        	boolean bDurum = (b.contains("/") || b.contains("*") || b.contains("-") || b.contains("+"));
        
        	a = a.replaceAll("[^-?0-9]+", " "); 
		List<String> aDakiSayilar = Arrays.asList(a.trim().split(" "));
		
		b = b.replaceAll("[^-?0-9]+", " "); 
		List<String> bDekiSayilar = Arrays.asList(b.trim().split(" "));
        
		if (aDurum == true && bDurum == true){//Bu if'e girerse 1/2 * 3/6 gibi bir ifade var demektir
			sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//1/2'den 1 alindi.
			sayi2 = Integer.valueOf(aDakiSayilar.get(1)+"");//1/2'den 2 alindi.

			sayi3 = Integer.valueOf(bDekiSayilar.get(0)+"");//3/6'den 3 alindi.
			sayi4 = Integer.valueOf(bDekiSayilar.get(1)+"");//3/6'den 6 alindi.
			
			sayi1 = sayi1 * sayi3; //yeni pay oluyor.
			sayi2 = sayi2 * sayi4; //yeni payda oluyor.
			
		}
		
		else if (aDurum == false && bDurum == false) {//Bu if'e girerse 2 * 3 gibi bir ifade var demektir
			sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//2 alindi.
			sayi2 = Integer.valueOf(bDekiSayilar.get(0));//3 alindi. 
			
			sayi1 = sayi1 * sayi2; //yeni pay oluyor.
			sayi2 = 1; //yeni payda oluyor.
		}
		
		else {
			if (aDurum == true) {//Bu if'e girerse 1/2 * 3 gibi bir ifade var demektir
				sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//1/2'den 1 alindi.
				sayi2 = Integer.valueOf(aDakiSayilar.get(1)+"");//1/2'den 2 alindi.

				sayi3 = Integer.valueOf(bDekiSayilar.get(0));//3 alindi.
				
				sayi1 = sayi1 * sayi3; //yeni pay oluyor.
			}
			else if(bDurum == true) {//Bu if'e girerse  3 * 1/2 gibi bir ifade var demektir
				sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//3 alindi.

				sayi3 = Integer.valueOf(bDekiSayilar.get(0)+"");//1/2'den 1 alindi.
				sayi4 = Integer.valueOf(bDekiSayilar.get(1)+"");//1/2'den 2 alindi.
				
				sayi1 = sayi1 * sayi3; //yeni pay oluyor.
				sayi2 = sayi4; //yeni payda oluyor.
			}
			
		}
		
    	int[] sayilar = new int[2];
    	sayilar = sadelestirme(sayi1, sayi2);
    	
		return sayilar[0] + "/" + sayilar[1];
	}

	public String visit(Divide exp)
	{
		int sayi1 = 1, sayi2=1, sayi3=1, sayi4=1;
		
		String a = exp.a.accept(this);
        String b = exp.b.accept(this);
        
        boolean aDurum = (a.contains("/") || a.contains("*") || a.contains("-") || a.contains("+"));
        boolean bDurum = (b.contains("/") || b.contains("*") || b.contains("-") || b.contains("+"));
        
        a = a.replaceAll("[^-?0-9]+", " "); 
		List<String> aDakiSayilar = Arrays.asList(a.trim().split(" "));
		
		b = b.replaceAll("[^-?0-9]+", " "); 
		List<String> bDekiSayilar = Arrays.asList(b.trim().split(" "));
        
		if (aDurum == true && bDurum == true){//Bu if'e girerse 1/2 / 3/6 gibi bir ifade var demektir
			sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//1/2'den 1 alindi.
			sayi2 = Integer.valueOf(aDakiSayilar.get(1)+"");//1/2'den 2 alindi.

			sayi3 = Integer.valueOf(bDekiSayilar.get(0)+"");//3/6'den 3 alindi.
			sayi4 = Integer.valueOf(bDekiSayilar.get(1)+"");//3/6'den 6 alindi.
			
			sayi1 = sayi1 * sayi4; //yeni pay oluyor.
			sayi2 = sayi2 * sayi3; //yeni payda oluyor.
			
		}
		
		else if (aDurum == false && bDurum == false) {//Bu if'e girerse 2 / 3 gibi bir ifade var demektir
			sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//2 alindi.
			sayi2 = Integer.valueOf(bDekiSayilar.get(0)+"");//3 alindi. 
			
			sayi1 = sayi1; //yeni pay oluyor.
			sayi2 = sayi2; //yeni payda oluyor.
		}
		
		else {
			if (aDurum == true) {//Bu if'e girerse 1/2 / 3 gibi bir ifade var demektir
				sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//1/2'den 1 alindi.
				sayi2 = Integer.valueOf(aDakiSayilar.get(1)+"");//1/2'den 2 alindi.

				sayi3 = Integer.valueOf(bDekiSayilar.get(0)+"");//3 alindi.
				
				sayi2 = sayi2 * sayi3; //yeni pay oluyor.
			}
			else if(bDurum == true) {//Bu if'e girerse  3 / 1/2 gibi bir ifade var demektir
				sayi1 = Integer.valueOf(aDakiSayilar.get(0)+"");//3 alindi.

				sayi3 = Integer.valueOf(bDekiSayilar.get(0)+"");//1/2'den 1 alindi.
				sayi4 = Integer.valueOf(bDekiSayilar.get(1)+"");//1/2'den 2 alindi.
				
				sayi1 = sayi1 * sayi4; //yeni pay oluyor.
				sayi2 = sayi3; //yeni payda oluyor.
			}
			
		}
		
    	int[] sayilar = new int[2];
    	sayilar = sadelestirme(sayi1, sayi2);
    	
		return sayilar[0] + "/" + sayilar[1];
	}
	
    public String visit(Num exp)
    {
        return exp.a + "/" + 1;
    }
    
    public int[] sadelestirme(int sayi1, int sayi2) {
    	int kucuk = sayi1;
    	if (kucuk  > sayi2) {
    		kucuk = sayi2;
    	}
    	for(int i=1; i<=kucuk;i++) {
    		if((sayi1%i==0) && (sayi2%i==0)) {
    			sayi1 /= i;
    			sayi2 /= i;
    		}
    	}
    	int[] sayilar = new int[2];
    	sayilar[0] = sayi1;
    	sayilar[1] = sayi2;
    	
    	return sayilar;
    }
}
