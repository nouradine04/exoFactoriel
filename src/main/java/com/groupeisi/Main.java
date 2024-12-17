package com.groupeisi;

import java.util.Scanner;

public class Main {
    public static long calculerFactorielle(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Le nombre ne peut pas être négatif.");
        }
        long resultat = 1;
        for (int i = 1; i <= n; i++) {
            resultat *= i;
        }
        return resultat;
    }

    /**
     * Méthode principale pour exécuter le programme.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans le programme de calcul de factorielle ");
        System.out.print("Entrez un nombre entier positif : ");

        try {
            int nombre = scanner.nextInt();
            long resultat = calculerFactorielle(nombre);
            System.out.println("La factorielle de " + nombre + " est : " + resultat);
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur : " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erreur : Veuillez entrer un nombre entier valide");
        } finally {
            scanner.close();
        }
    }
}
