package model;

public class Builder {
	
	private House firstH;
	
	public Builder() {		
	}
	
	public House getFirstHouse() {
		return firstH;
	}
	
	public void addHouse(double a, int f) {
		House h = firstH;
		if(firstH != null) {
			if(firstH.getNextH() != firstH) {
				while(h.getNextH() != firstH) {
					h = h.getNextH();
				}				
			}
			h.setNextH(new House(a,f));
			h.getNextH().setNextH(firstH);			
		}
		else {
			firstH = new House(a,f);
			firstH.setNextH(firstH);
		}
	}
	
	public void exchangeHouses(int i1, int i2) {		
		int counter = 0;
		if(firstH != null && firstH != firstH.getNextH()) {
			House auxH = firstH;
			
			while(auxH.getNextH() != firstH) {
				auxH = auxH.getNextH();
			}
			
			House preH1 = auxH;
			House preH2 = auxH;
			House H1 = firstH;
			House H2 = firstH;
			
			
			while(H1.getNextH()!=firstH && counter < i1) {
				preH1 = H1;
				H1 = H1.getNextH();
				counter++;
			}
			
			counter = 0;
			
			while(H2.getNextH()!=firstH && counter < i2) {
				preH2 = H2;
				H2 = H2.getNextH();
				counter++;
			}
			if(H1 == preH2) {
				preH1.setNextH(H2);
				H1.setNextH(H2.getNextH());
				H2.setNextH(H1);
				
				if(H1 == firstH) {
					firstH = H2;
				}
				
			}
			else {
				auxH = H2.getNextH();
				H2.setNextH(H1.getNextH());
				preH2.setNextH(H1);
				H1.setNextH(auxH);
				preH1.setNextH(H2);
				
				if(H1 == firstH) {					
					firstH = H2;
				}
			}
			
			
		}
		
		
		
	}
}
