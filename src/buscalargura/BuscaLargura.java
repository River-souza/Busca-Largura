/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscalargura;

import java.util.ArrayList;

/**
 *
 * @author 53IIMQH
 */
public class BuscaLargura {

    int distancia = 0;//ou peso
    int inicio = -1;
    int objetivo = -1;
    int qtdNos = 0;
    int[][] matriz;

    public BuscaLargura(int inicio, int objetivo, int[][] matriz) {

        this.matriz = matriz;
        this.qtdNos = matriz.length;
        this.inicio = inicio;
        this.objetivo = objetivo;

        System.out.println("nó de partida : " + this.inicio);
        System.out.println("meu objetivo : " + this.objetivo);
        System.out.println("\n");
        this.iniciar();

    }

    private void iniciar() {
        for (int i = 0; i < this.qtdNos; i++) {//encontra o inicio setado 
            if (this.inicio == this.matriz[i][0]) {

                int pai = this.inicio;

                System.out.println(pai + " é a raiz");

                ArrayList<Integer> f = new ArrayList<>();

                for (int rep = 0; rep < this.qtdNos; rep++) {

                    if (pai == this.matriz[rep][2]) {
                        System.out.println(this.matriz[rep][0] + " filho de " + pai);//encontra os antecessores do nó atual 
                        f.add(this.matriz[rep][0]);
                    }
                }

                pFila(f);
            } else {
                //System.out.println(this.matriz[i][0] + " não é o inicio");
            }
        }

    }

    void pFila(ArrayList<Integer> f) {

        for (int i = 0; i < f.size(); i++) {

            ArrayList<Integer> f1 = new ArrayList<>();

            for (int rep = 0; rep < this.qtdNos; rep++) {

                if (f.get(i) == this.matriz[rep][2]) {

                    System.out.println(this.matriz[rep][0] + " filho de " + f.get(i));//encontra os antecessores do nó atual 

                    f1.add(this.matriz[rep][0]);

                    if (this.matriz[rep][0] == this.objetivo) {
                        System.out.println("\n----------- Objetivo atingido! -----------\n");//encontra os antecessores do nó atual 
                        pCaminho(this.objetivo, this.matriz[rep][2]);
                    }
                }
            }
            pFila(f1);
        }
    }

    void pCaminho(int v, int a) {
        StringBuilder t = new StringBuilder(v + "");

        int ant = a;

        while (true) {

            for (int rep = 0; rep < this.qtdNos; rep++) {

                if (ant == this.matriz[rep][0]) {
                    t.append(" - ").append(ant);
                    ant = this.matriz[rep][2];
                }
            }

            if (ant == inicio) {
                t.append(" - ").append(ant);
                System.out.println("\nCaminho a ser percorrido : " + t.reverse());
                System.exit(0);
            }

        }
    }

    public void lerEntrada() {

    }
}
