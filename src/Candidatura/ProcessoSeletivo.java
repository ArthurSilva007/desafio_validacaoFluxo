package Candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {
                "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MARCOS", "JOÃO",
                "ANA", "CARLOS", "BRUNA", "PEDRO", "LAURA", "RAFAEL", "SOFIA",
                "GABRIEL", "ISABELA", "LUCAS",};
        for (String candidato: candidatos) {

            entrandoEmContato(candidato);

        }

    }
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu=false;
        do {
            //elas precisarao sofrer alteracoes
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");
        }while (continuarTentando && tentativasRealizadas < 4);

        if (atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " NÚMERO DE TENTATIVAS  " + tentativasRealizadas + " REALIZADAS");
    }

    //metodo auxiliar
    static Boolean atender() {
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados() {
        String [] candidatos = {
                "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MARCOS", "JOÃO",
                "ANA", "CARLOS", "BRUNA", "PEDRO", "LAURA", "RAFAEL", "SOFIA",
                "GABRIEL", "ISABELA", "LUCAS",
        };
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        for (int indice=0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de indice " + (indice+1) + " é o " + candidatos[indice]);
        }
    }

    static void selecaoCandidatos() {
        String [] candidatos = {
                "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MARCOS", "JOÃO",
                "ANA", "CARLOS", "BRUNA", "PEDRO", "LAURA", "RAFAEL", "SOFIA",
                "GABRIEL", "ISABELA", "LUCAS", "MARIANA", "MATEUS", "CAMILA", "THIAGO",
                "LETICIA", "DANIEL", "BEATRIZ", "VINICIUS", "GIOVANNA", "LEONARDO", "HELENA",
                "GUILHERME", "LIVIA", "EDUARDO", "CLARA", "HENRIQUE", "MANUELA", "ARTHUR",
                "VALENTINA", "RODRIGO", "ALICE", "BERNARDO", "LORENA", "CAIO", "CECILIA",
                "ENZO", "ELOAH", "MIGUEL", "LUIZA", "DAVIS", "JULIANA", "GUSTAVO", "MELISSA"
        };

         int candidatosSelecionados = 0;
         int candidatosAtual=0;
         double salarioBase=2000.0;
         while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
             String candidato = candidatos[candidatosAtual];
             double salarioPretendido = valorPrentendido();


             System.out.println( " O candidato " + candidato + " Solicitou este valor de salario " + salarioPretendido );
             if (salarioBase >= salarioPretendido) {
                 System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                 candidatosSelecionados++;
             }
             candidatosAtual++;
         }
    }
    static double valorPrentendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA CANDIDATO");
        }
        else if(salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARR O CANDIDATO COM CONTRA PROPOSTA");
        }
        else{
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
