package com.groupeisi;

public class Factoriel {


    /**
     * Méthode pour calculer la factorielle d'un nombre.
     *
     * @param n Nombre entier positif.
     * @return La factorielle de n.
     * @throws IllegalArgumentException Si n est négatif.
     */
    public long calculerFactorielle(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Le nombre ne peut pas être négatif.");
        }
        long resultat = 1;
        for (int i = 1; i <= n; i++) {
            resultat *= i;
        }
        return resultat;
    }
}
