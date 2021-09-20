package module;

/**
 * 
 * @author yasir
 *
 * Mutter Klasse für die verschiedenen Fahrzeuge
 */

public class Fzg {
	
	protected String marke,modell,farbe;
	protected int baujahr;
	protected double preis;

	public Fzg(String marke, String modell, String farbe, int baujahr,double preis) {
		this.marke = marke;
		this.modell = modell;
		this.farbe = farbe;
		this.baujahr = baujahr;
		this.preis = preis;
	}

	//******************* Getter und Setter ****************************************
	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public int getBaujahr() {
		return baujahr;
	}

	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	
	

}
