package model;

public class Screen {
    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showOptions() {
        System.out.println("""
                ___________________________
                Choose one option:
                1: ADAUGA_CLIENT <nume>\s
                2: ADAUGA_PRODUS <numeClient> <tipProdus>
                3: STERGE_PRODUS <numeClient> <numeProdus>\s
                4: STERGE_TOATE_PRODUSELE <numeClient>\s
                5: AFISARE_CLIENTI\s
                6: AFISARE_COS <numeClient>\s
                7: AFISARE_COMPLETA\s
                8: EXIT\s
                ___________________________""");
    }

    public void showDetails() {
        System.out.println("""
                ___________________
                Enter product's details:\s
                laptop: <pret> <stoc> <producator> <nrProcesoare> <areTouchScreen>\s
                telefon: <pret> <stoc> <producator> <dimBaterie> <nrMexapixeli> \s
                televizor: <pret> <stoc> <producator> <diagonala> <esteSmart>  \s
                ___________________""");
    }
}

