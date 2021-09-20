package module;
/**
 * @author yasir
 * 
 *  Klasse für das UI 
 */

import java.util.Scanner;

public class UI {

	private boolean loop = true;
	private Database db1 = new Database();
	private StopWatch timer = new StopWatch();

	/**
	 * Konstruktor dient als Menuaufbau und logik, mit Schleife wird das Menu ausgeführt, so lange das Programm läuft
	 */
	public UI() {
		timer.stopTime(0); // Startet die Stoppuhr
		while (loop) {
			switch (hauptMenue()) {
			case "0":
				boerseBeenden();
				break;
			case "1":
				fzgAnlegen();
				break;
			case "2":
				fzgBearbeiten();
				break;
			case "3":
				fzgSuchen();
				break;
			case "4":
				fzgLoeschen();
				break;
			case "5":
				db1.showAll();
				break;
			default:
				break;
			}

		}

	}

	/**
	 * Aufbau Hauptmenu
	 * @return Gibt Auswahl an eine Switch-Case-Logik weiter
	 */
	String hauptMenue() {

		Scanner sc = new Scanner(System.in);
		String eingabe = "";
		boolean matches = false;

		while (!matches) {
			System.out.println("---------------------------------------------------");
			System.out.println("Fahrzeugbörse\tHauptmenü\tvon: Dizman, Yasir");
			System.out.println("---------------------------------------------------");
			System.out.println("(1)\t-->\tFahrzeug anlegen");
			System.out.println("(2)\t-->\tFahrzeug bearbeiten");
			System.out.println("(3)\t-->\tFahrzeug suchen");
			System.out.println("(4)\t-->\tFahrzeug löschen");
			System.out.println("(5)\t-->\tFahrzeuge anzeigen");
			System.out.println("(0)\t-->\tBoerse beenden");
			System.out.println("----------------------------------------------------");
			System.out.println("Bitte wählen");
			eingabe = sc.next();
			if (eingabe.equals("0") || eingabe.equals("1") || eingabe.equals("2") || eingabe.equals("3")
					|| eingabe.equals("4") || eingabe.equals("5")) {
				matches = true;
			} else
				System.out.println("Falsche Eingabe, versuchen Sie es erneut!");
		}
		return eingabe;
	}

	/**
	 * legt Fahrzeuge an
	 */
	void fzgAnlegen() {
		boolean matches = false;
		Scanner sc = new Scanner(System.in);
		String eingabe = "";
		String marke = "";
		String modell = "";
		String farbe = "";
		int x = 0;
		int baujahr = 0;
		double preis = 0;
		while (!matches) {
			System.out.println("---------------------------------------------------");
			System.out.println("Welches Fahrzeug möchten Sie anlegen?");
			System.out.println("---------------------------------------------------");
			System.out.println("(1)\t-->\tPkw anlegen");
			System.out.println("(2)\t-->\tLkw anlegen");
			System.out.println("(3)\t-->\tBoot anlegen");
			System.out.println("(4)\t-->\tMotorrad anlegen");
			System.out.println("---------------------------------------------------");
			System.out.println("Bitte wählen");
			eingabe = sc.next();
			if (eingabe.equals("1") || eingabe.equals("2") || eingabe.equals("3") || eingabe.equals("4")) {
				matches = true;
			} else
				System.out.println("Falsche Eingabe, bitte erneut eingeben");
		}
		sc.nextLine();
		System.out.println("Bitte Marke eingeben:");
		marke = sc.nextLine();
		System.out.println("Bitte Modell eigeben:");
		modell = sc.nextLine();
		System.out.println("Bitte Farbe eingeben");
		farbe = sc.nextLine();

		System.out.println("Bitte Baujahr eingeben");
		baujahr = sc.nextInt();

		System.out.println("Bitte geben Sie den Preis ein");
		preis = sc.nextDouble();

		matches = true;
		if (marke.equals("") || modell.equals("") || farbe.equals("") || baujahr == 0 || preis == 0.0) {
			System.out.println("Unvollständige Angaben!! Daten konnten nicht gespeichert werden");
			matches = false;
		}
		if (matches) {
			if (eingabe.equals("1"))
				db1.createFzg(new Pkw(marke, modell, farbe, baujahr, preis));
			else if (eingabe.equals("2"))
				db1.createFzg(new Lkw(marke, modell, farbe, baujahr, preis));
			else if (eingabe.equals("3"))
				db1.createFzg(new Boot(marke, modell, farbe, baujahr, preis));
			else if (eingabe.equals("4"))
				db1.createFzg(new Motorrad(marke, modell, farbe, baujahr, preis));

			matches = false;
			while (!matches) {
				System.out.println("Möchten Sie noch ein Fahrzeug hinzufügen");
				System.out.println("(1) -- > JA");
				System.out.println("(2) -- > NEIN");
				eingabe = sc.next();
				if (eingabe.equals("1") || eingabe.equals("2"))
					matches = true;
				else
					System.out.println("Falsche Eingabe, bitte erneut eingeben!");
			}

			if (eingabe.equals("1"))
				fzgAnlegen();

		}
	}

	/**
	 * lässt Einträge bearbeiten
	 */
	void fzgBearbeiten() {
		Scanner sc = new Scanner(System.in);
		int id;
		boolean matches = false;
		String eingabe;
		String marke = "";
		String modell = "";
		String farbe = "";
		int baujahr = 0;
		double preis = 0;
		int choice = 0;
		System.out.println("Fahrzeugdaten bearbeiten");
		System.out.println("------------------------------------");
		db1.showAll();
		System.out.println("Bitte den Eintragsnummer wählen");
		id = sc.nextInt();
		if (id >= 1 && id <= db1.collection.size()) {
			sc.nextLine();
			System.out.println(
					"Bitte Typ des Fahrzeugs wählen:\n(1) -- > Pkw\n(2) -- > Lkw\n(3) -- >Boot\n(4) -- > Motorrad");
			choice = sc.nextInt();
			sc.nextLine();
			System.out.println("Bitte Marke eingeben:");
			marke = sc.nextLine();
			System.out.println("Bitte Modell eigeben:");
			modell = sc.nextLine();
			System.out.println("Bitte Farbe eingeben");
			farbe = sc.nextLine();
			System.out.println("Bitte Baujahr eingeben");
			baujahr = sc.nextInt();
			System.out.println("Bitte geben Sie den Preis ein");
			preis = sc.nextDouble();
			db1.changeEntry(id, modell, marke, farbe, baujahr, preis, choice);
		} else {
			while (!matches) {
				System.out.println("Falsche Auswahl!");
				System.out.println("(1) -- > Nochmal bearbeiten");
				System.out.println("(2) -- > Hauptmenü");
				eingabe = sc.next();
				if (eingabe.equals("1"))
					fzgBearbeiten();
				else if (eingabe.equals("2"))
					matches = true;
				else
					System.out.println("Falsche Eingabe");
			}

		}

	}

	/**
	 * Suche nach verschieden Parametern
	 */
	void fzgSuchen() {
		Scanner sc = new Scanner(System.in);
		String eingabe = "";
		boolean matches = false;
		String text;
		int baujahr;
		double preis;
		while (!matches) {
			System.out.println("Fahrzeug suchen");
			System.out.println("------------------------------------------");
			System.out.println("Suchparameter auswählen:");
			System.out.println("(1) -- > Marke, Modell, Farbe");
			System.out.println("(2) -- > Baujahr");
			System.out.println("(3) -- > Preis");
			eingabe = sc.next();
			if (eingabe.equals("1") || eingabe.equals("2") || eingabe.equals("3"))
				matches = true;
			else
				System.out.println("Falsche Eingabe");
		}
		System.out.println("Suchparameter eingeben");

		sc.nextLine();
		if (eingabe.equals("1"))
			db1.searchByText(sc.nextLine().toLowerCase());
		else if (eingabe.equals("2"))
			db1.searchByBaujahr(sc.nextInt());
		else if (eingabe.equals("3"))
			db1.searchByPreis(sc.nextDouble());

		matches = false;
		while (!matches) {
			System.out.println("Möchten Sie erneut suchen");
			System.out.println("(1) -- > Ja");
			System.out.println("(2) -- > Nein");
			eingabe = sc.next();
			if (eingabe.equals("1") || eingabe.equals("2"))
				matches = true;
			else
				System.out.println("Falsche Eingabe");
		}
		if (eingabe.equals("1"))
			fzgSuchen();

	}

	/**
	 * Löscht Einträge
	 */
	void fzgLoeschen() {
		int id;
		String eingabe = "";
		boolean matches = false;
		Scanner sc = new Scanner(System.in);
		db1.showAll();
		System.out.println("Fahrzeug löschen");
		System.out.println("Bitte den Eintragsnummer wählen");
		id = sc.nextInt();
		if (id >= 1 && id <= db1.collection.size()) {
			while (!matches) {
				System.out.println("Soll das Fahrzeug wirklich gelöscht werden?");
				System.out.println("(1) -- > JA");
				System.out.println("(2) -- > NEIN");
				eingabe = sc.next();
				if (eingabe.equals("1") || eingabe.equals("2"))
					matches = true;
				else
					System.out.println("Falsche Eingabe");
			}
			if (eingabe.equals("1"))
				db1.deleteById(id);

		} else
			System.out.println("Falsche Eingabe");
	}

	/**
	 * beenden des Programms
	 */
	void boerseBeenden() {
		Scanner sc = new Scanner(System.in);
		String eingabe = "";
		boolean matches = false;
		while (!matches) {
			System.out.println("Möchten Sie das Programm wirklich beeneden?");
			System.out.println("(1) -- > JA");
			System.out.println("(2) -- > NEIN");
			eingabe = sc.next();
			if (eingabe.equals("1") || eingabe.equals("2"))
				matches = true;
			else
				System.out.println("Falsche Eingabe");
		}
		if (eingabe.equals("1")) {
			loop = false; // dadurch wird die Schleife im Konstruktor beendet, weil kein Code mehr folgt, endet die Konsole
			timer.stopTime(1); // Zeit wird gestoppt
			System.out.println("Im Programm verbrachte Zeit");
			System.out.println(timer.getElapsedTime()); // Ausgabe der vergangenen Zeit
		}

	}
}
