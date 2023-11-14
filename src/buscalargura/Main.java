/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscalargura;

/**
 *
 * @author 53IIMQH
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        
//       
//        String [] txt = {
//            
//        };
//        
//        SerializadorTexto st = new SerializadorTexto(txt, "C:\\Users\\maico\\Documents\\NetBeansProjects\\BuscaLargura\\matriz.txt");
//        

//int [][] matriz = {
//    //valor, peso, antecessor
//    {8,1,-1},//nó peso 1
//    
//    {1,2,8},//nó peso 2
//    {2,2,8},
//    {3,2,8},
//    
//    {4,3,1},//nó peso 3
//    {5,3,1},
//    {6,3,2},
//    {7,3,3},
//    
//    {10,4,4},//nó peso 4
//    {11,4,6},
//    {17,4,7}
//    };
//int [][] matriz = {
//    //valor, peso, antecessor
//    {8,1,-1},//nó peso 1
//    
//    {4,2,8},//nó peso 2
//    {3,2,8},
//    
//    {7,3,4},//nó peso 3
//    {5,3,4},
//    
//    {9,3,3},//nó peso 4
//    {2,3,3}
//    };
        Leitor1 l = new Leitor1();

        l.lerArquivoUTF8("grafo.txt");

        int[][] matriz = new int[l.getArray().length][3];

        int inicio = Integer.parseInt(l.getArray()[1]);
        int objetivo = Integer.parseInt(l.getArray()[3]);

        for (int i = 5; i < (l.getArray().length); i++) {

            if (l.getArray()[i] != null) {

                String[] tokens = (l.getArray()[i]).split(",");

                matriz[i][0] = Integer.parseInt(tokens[0]);
                matriz[i][1] = Integer.parseInt(tokens[1]);
                matriz[i][2] = Integer.parseInt(tokens[2]);

            }
        }
        BuscaLargura b = new BuscaLargura(inicio, objetivo, matriz);

    }

}
