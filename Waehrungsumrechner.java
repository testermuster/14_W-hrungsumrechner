import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Waehrungsumrechner {

    private static final Map<String, Double> wechselkurse = new HashMap<>();

    static {
        // Statische Wechselkurse für die Demonstration
        wechselkurse.put("USD_EUR", 0.85);
        wechselkurse.put("EUR_USD", 1.18);
        wechselkurse.put("USD_GBP", 0.75);
        wechselkurse.put("GBP_USD", 1.33);
        // Fügen Sie nach Bedarf weitere Währungspaare hinzu
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Verfügbare Währungen: USD, EUR, GBP");
        System.out.print("Geben Sie die Quellwährung ein: ");
        String quelle = scanner.nextLine().toUpperCase();

        System.out.print("Geben Sie die Zielwährung ein: ");
        String ziel = scanner.nextLine().toUpperCase();

        System.out.print("Geben Sie den Betrag ein: ");
        double betrag = scanner.nextDouble();

        String schluessel = quelle + "_" + ziel;
        if (wechselkurse.containsKey(schluessel)) {
            double umgerechneterBetrag = betrag * wechselkurse.get(schluessel);
            System.out.printf("%.2f %s entspricht %.2f %s%n", betrag, quelle, umgerechneterBetrag, ziel);
        } else {
            System.out.println("Wechselkurs nicht verfügbar.");
        }

        scanner.close();
    }
}
