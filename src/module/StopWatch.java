package module;

/**
 * 
 * @author yasir
 *
 * KLasse um die Zeit zu messen, wie lange man sich im Programm aufgehalten hat, leider ab und zu buggy, weil in seltenen Fällen falsche Zeiten angegeben wird!
 */

public class StopWatch {

    long start, end;

    /**
     * Methode zum starten und stoppen der Zeit
     * @param x 0 --> Starten 1 --> Stoppen
     */
    public void stopTime(int x) {
        if (x == 0) {
            start = System.nanoTime();
        }
        if (x == 1) {
            end = System.nanoTime();
        }
    }

    /**
     * Berechnet die vergangene Zeit
     * @return Gibt ein Stringwert zurück
     */
    public String getElapsedTime() {
        long elapsed = end - start; // vergangene Zeit
        double seconds = (double) elapsed / 1000000000; // von Nano zu Sekunden
        double minutes = seconds / 60; // Minuten 
        int minutesInt = (int) minutes;
        int secondsRest = ((int) ((minutes - minutesInt) * 60)); // berechnet den Rest für die Sekunden
        String z = "Minuten: " + minutesInt + " Sekunden: " + secondsRest;
        return z;
    }

    public StopWatch() {
    }

}
