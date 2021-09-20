package module;

/**
 * @author yasir
 * Klasse für das Abspeichern der Fahrzeuge, durch eine ArrayList wird eine Datenbanksimuliert
 */

import java.util.ArrayList;

public class Database {

	ArrayList<Fzg> collection = new ArrayList<>(); // ArrayList für die Fahrzeuge

	public Database() {

	}

	/**
	 * 
	 * @param x bekommt das Objekt Typ Fzg übergeben, um in ArrayList zu speichern
	 */

	public void createFzg(Fzg x) {
		collection.add(x);
	}

	/**
	 * Methode für die gesamte Ausgabe des ArrayLists
	 */
	public void showAll() {
		for (int i = 0; i < collection.size(); i++) {
			if (collection.get(i) instanceof Pkw) {
				System.out.println("Eintrag:\t " + (i + 1));
				System.out.println("Fahrzeugstyp:\t Pkw");
				printer(i);
			} else if (collection.get(i) instanceof Lkw) {
				System.out.println("Eintrag:\t " + (i + 1));
				System.out.println("Fahrzeugstyp:\t Lkw");
				printer(i);
			} else if (collection.get(i) instanceof Boot) {
				System.out.println("Eintrag:\t " + (i + 1));
				System.out.println("Fahrzeugstyp:\t Boot");
				printer(i);
			} else if (collection.get(i) instanceof Motorrad) {
				System.out.println("Eintrag:\t " + (i + 1));
				System.out.println("Fahrzeugstyp:\t Motorrad");
				printer(i);
			}
		}
	}

	/**
	 * Methode um Einträge zu ändern
	 * 
	 * @param id
	 * @param modell
	 * @param marke
	 * @param farbe
	 * @param baujahr
	 * @param preis
	 * @param choice
	 */
	public void changeEntry(int id, String modell, String marke, String farbe, int baujahr, double preis, int choice) {

		if (choice == 1) {
			collection.set(id - 1, new Pkw(marke, modell, farbe, baujahr, preis));
		} else if (choice == 2) {
			collection.set(id - 1, new Lkw(marke, modell, farbe, baujahr, preis));
		} else if (choice == 3) {
			collection.set(id - 1, new Boot(marke, modell, farbe, baujahr, preis));
		} else if (choice == 4) {
			collection.set(id - 1, new Motorrad(marke, modell, farbe, baujahr, preis));
		}
	}

	/**
	 * Methode um Inhalte nach String durchzusuchen
	 * 
	 * @param eingabe
	 */
	public void searchByText(String eingabe) {
		for (int i = 0; i < collection.size(); i++) {
			if (collection.get(i) instanceof Pkw) {
				if (collection.get(i).getMarke().toLowerCase().contains(eingabe)
						|| collection.get(i).getModell().toLowerCase().contains(eingabe)
						|| collection.get(i).getFarbe().toLowerCase().contains(eingabe)) {
					System.out.println("Eintrag:\t " + (i + 1));
					System.out.println("Fahrzeugstyp:\t Pkw");
					printer(i);
				}

			} else if (collection.get(i) instanceof Lkw) {
				if (collection.get(i).getMarke().toLowerCase().contains(eingabe)
						|| collection.get(i).getModell().toLowerCase().contains(eingabe)
						|| collection.get(i).getFarbe().toLowerCase().contains(eingabe)) {
					System.out.println("Eintrag:\t " + (i + 1));
					System.out.println("Fahrzeugstyp:\t Lkw");
					printer(i);
				}

			} else if (collection.get(i) instanceof Boot) {

				if (collection.get(i).getMarke().toLowerCase().contains(eingabe)
						|| collection.get(i).getModell().toLowerCase().contains(eingabe)
						|| collection.get(i).getFarbe().toLowerCase().contains(eingabe)) {
					System.out.println("Eintrag:\t " + (i + 1));
					System.out.println("Fahrzeugstyp:\t Boot");
					printer(i);
				}

			} else if (collection.get(i) instanceof Motorrad) {

				if (collection.get(i).getMarke().toLowerCase().contains(eingabe)
						|| collection.get(i).getModell().toLowerCase().contains(eingabe)
						|| collection.get(i).getFarbe().toLowerCase().contains(eingabe)) {
					System.out.println("Eintrag:\t " + (i + 1));
					System.out.println("Fahrzeugstyp:\t Motorrad");
					printer(i);
				}
			}
		}
	}

	/**
	 * Methode nach Baujahr zu suchen
	 * 
	 * @param eingabe
	 */
	public void searchByBaujahr(int eingabe) {
		for (int i = 0; i < collection.size(); i++) {
			if (collection.get(i) instanceof Pkw) {
				if (collection.get(i).getBaujahr() == eingabe) {
					System.out.println("Eintrag:\t " + (i + 1));
					System.out.println("Fahrzeugstyp:\t Pkw");
					printer(i);
				}

			} else if (collection.get(i) instanceof Lkw) {
				if (collection.get(i).getBaujahr() == eingabe) {
					System.out.println("Eintrag:\t " + (i + 1));
					System.out.println("Fahrzeugstyp:\t Lkw");
					printer(i);
				}

			} else if (collection.get(i) instanceof Boot) {

				if (collection.get(i).getBaujahr() == eingabe) {
					System.out.println("Eintrag:\t " + (i + 1));
					System.out.println("Fahrzeugstyp:\t Boot");
					printer(i);
				}

			} else if (collection.get(i) instanceof Motorrad) {

				if (collection.get(i).getBaujahr() == eingabe) {
					System.out.println("Eintrag:\t " + (i + 1));
					System.out.println("Fahrzeugstyp:\t Motorrad");
					printer(i);
				}
			}
		}
	}

	/**
	 * Methode um nach Preis zu suchen
	 * 
	 * @param eingabe
	 */
	public void searchByPreis(double eingabe) {
		for (int i = 0; i < collection.size(); i++) {
			if (collection.get(i) instanceof Pkw) {
				if (collection.get(i).getPreis() == eingabe) {
					System.out.println("Eintrag:\t " + (i + 1));
					System.out.println("Fahrzeugstyp:\t Pkw");
					printer(i);
				}

			} else if (collection.get(i) instanceof Lkw) {
				if (collection.get(i).getPreis() == eingabe) {
					System.out.println("Eintrag:\t " + (i + 1));
					System.out.println("Fahrzeugstyp:\t Lkw");
					printer(i);
				}

			} else if (collection.get(i) instanceof Boot) {

				if (collection.get(i).getPreis() == eingabe) {
					System.out.println("Eintrag:\t " + (i + 1));
					System.out.println("Fahrzeugstyp:\t Boot");
					printer(i);
				}

			} else if (collection.get(i) instanceof Motorrad) {

				if (collection.get(i).getPreis() == eingabe) {
					System.out.println("Eintrag:\t " + (i + 1));
					System.out.println("Fahrzeugstyp:\t Motorrad");
					printer(i);
				}
			}
		}
	}

	/**
	 * Methode zum löschen eines Eintrages
	 * 
	 * @param id
	 */
	public void deleteById(int id) {
		collection.remove(id - 1);
	}

	/**
	 * Methode um Printelemente auszulagern, um Zeilen an Code zu sparen
	 * 
	 * @param i
	 */
	private void printer(int i) {
		System.out.println("Marke:\t\t " + collection.get(i).getMarke());
		System.out.println("Modell:\t\t " + collection.get(i).getModell());
		System.out.println("Baujahr:\t " + collection.get(i).getBaujahr());
		System.out.println("Farbe:\t\t " + collection.get(i).getFarbe());
		System.out.println("Preis:\t\t " + collection.get(i).getPreis());
		System.out.println("-------------------------------------------------------------");
	}

}
