import java.util.Random;


public class T1 {

    public static void main(String[] args) {

        System.out.println("100 elementos, 50 pares e 50 ímpares;");

        int[] arr = geraVetor(50, 50);
        //for(int i =0;i<arr.length;i++){ System.out.print(" " + arr[i]);}System.out.println();
        arr = separaParImpar(arr);
        //for(int i =0;i<arr.length;i++){ System.out.print(" " + arr[i]);}System.out.println();
        arr = geraVetor(50, 50);
        //for(int i =0;i<arr.length;i++){ System.out.print(" " + arr[i]);}System.out.println();
        arr = separaParImpar2(arr);
        //for(int i =0;i<arr.length;i++){ System.out.print(" " + arr[i]);}System.out.println();
        arr = geraVetor(50, 50);
        //for(int i =0;i<arr.length;i++){ System.out.print(" " + arr[i]);}System.out.println();


        System.out.println("\n100 elementos, 20 pares e 80 ímpares;");
        arr = geraVetor(20, 80);
        arr = separaParImpar(arr);
        arr = geraVetor(20, 80);
        arr = separaParImpar2(arr);

        System.out.println("\n100 elementos, 80 pares e 20 ímpares;");
        arr = geraVetor(80, 20);
        arr = separaParImpar(arr);
        arr = geraVetor(80, 20);
        arr = separaParImpar2(arr);

        System.out.println("\n100000 elementos, 50000  pares e 50000  ímpares;");
        arr = geraVetor(50000, 50000);
        arr = separaParImpar(arr);
        arr = geraVetor(50000, 50000);
        arr = separaParImpar2(arr);

        System.out.println("\n100000 elementos, 20000  pares e 80000  ímpares;");
        arr = geraVetor(20000, 80000);
        arr = separaParImpar(arr);
        arr = geraVetor(20000, 80000);
        arr = separaParImpar2(arr);

        System.out.println("\n100000 elementos, 80000  pares e 20000  ímpares;");
        arr = geraVetor(80000, 20000);
        separaParImpar(arr);
        arr = geraVetor(80000, 20000);
        separaParImpar2(arr);
    }

    public static int[] separaParImpar(int[] vet) {
        int[] vetAux = new int[vet.length];
        int contInicio = 0;
        int contFim = vet.length - 1;
        int cont = 6;
        for (int i = 0; i < vet.length; i++) {
            if (vet[i] % 2 == 0) {
                vetAux[contInicio] = vet[i];
                contInicio++;
                cont = cont + 10;
            } else {
                vetAux[contFim] = vet[i];
                contFim--;
                cont = cont + 10;
            }
        }
        System.out.println("Iterações com vetor aux: " + cont);

        return vetAux;
    }

    public static int[] separaParImpar2(int vet[]) {
        int contInicio = 0;
        int contFim = vet.length - 1;
        int cont = 4;
        while (contInicio < contFim) {
            while (vet[contInicio] % 2 == 0 && contInicio < contFim) {
                contInicio++;
                cont = cont + 7;
            }

            while (vet[contFim] % 2 == 1 && contInicio < contFim) {
                contFim--;
                cont = cont + 9;
            }

            if (contInicio < contFim) {
                int aux = vet[contInicio];
                vet[contInicio] = vet[contFim];
                vet[contFim] = aux;
                contInicio++;
                contFim--;
                cont = cont + 10;
            }
            cont = cont + 1;
        }

        System.out.println("Iterações sem vetor aux: " + cont);
        return vet;
    }

    private static int[] geraVetor(int nroPares, int nroImpares) {
        int[] res = null;
        int contPar = 0, contImpar = 0, novoNum;
        Random rnd = new Random();

        if ((nroPares >= 0) ||
                (nroImpares >= 0) &&
                        (nroPares + nroImpares > 0)) {

            res = new int[nroPares + nroImpares];

            while ((contPar < nroPares) || (contImpar < nroImpares)) {
                novoNum = rnd.nextInt(98) + 1;

                if ((novoNum % 2 == 0) && (contPar < nroPares)) {
                    res[contPar + contImpar] = novoNum;
                    contPar++;
                } else if ((novoNum % 2 == 1) && (contImpar < nroImpares)) {
                    res[contPar + contImpar] = novoNum;
                    contImpar++;
                }
            }
        }

        return res;
    }

    public static int[] separaParImpar3(int[] vet) {// 2
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + " ");
        }
        System.out.println("");
        int index = 0; //1
        int cont = 0;
        all:
        for (int i = 0; i < vet.length; i++) { //3
            cont++;
            if (vet[i] % 2 == 0) { //3
                for (int j = index; j < vet.length; j++) { //3
                    cont++;
                    if (vet[j] % 2 != 0) { //3
                        int aux = vet[j]; //2
                        vet[j] = vet[i]; //3
                        vet[i] = aux; //2
                        index = j + 1; //2
                        break; //1
                    }
                    if (j == vet.length - 1) { //3
                        break all; //1
                    }
                }
            }
        }
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + " ");
        }
        System.out.println("Iteracoes ex2: " + cont);
        return vet; //1
    }

}
