package candidatura;

import com.sun.tools.javac.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class ProcessoSeletivo {
	static List<String> ListaSelecionados = new ArrayList<String>();
	
	public static void main(String[] args) {
		System.out.println("Processo Seletivo");
		selecaoCandidatos();
		imprimirSelecionados();
		
		for( String candidato : ListaSelecionados){
			entrandoEmContato(candidato);
		}
		
		
	}
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1 ;
		boolean continuarTentando = true ;
		boolean atendeu = false ;
		
		do {
			atendeu = atender() ;
			continuarTentando = !atendeu ;
			if(continuarTentando) {
				tentativasRealizadas++;
			}else {
				System.out.println("CONTATO REALIZADO COM SUCESSO");
			}
			
		}while(continuarTentando && tentativasRealizadas < 3);
		
		if(atendeu) {
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA" );
		}else {
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MAXIMO DE TENTATIVAS");
		}
	}
	// Metodo Auxiliar
	static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	static void imprimirSelecionados() {
		System.out.println("Imprimindo Lista de Candidatos ");
		for	(int i = 0; i < ListaSelecionados.size() ; i++) {
			System.out.println("O candidato de n° "+ (i+1) + " é "  + ListaSelecionados.get(i));
			
		}
	}
	
	static void selecaoCandidatos() {
		String [] candidatos = {"FELIPE" , "MARIA","JULIA","PAULO","AUGUSTO" , "MONICA" , "FABRICIO","MIRELA","DANIELA" , "JORGE"};
		
		int candidatosSelecionados = 0 ;
		int candidatoAtual = 0 ;
		double salarioBase = 2000.0 ;
		
		while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length ) {
			
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			System.out.println("O candidato " + candidato + " Solicitou este valor de salario" + salarioPretendido );
			
			if(salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
				candidatosSelecionados += 1 ;
				
				ListaSelecionados.add(candidato);
			}
			candidatoAtual++ ;
		}
		
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800 , 2200);
	}
	
	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		
		if(salarioBase > salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO");
		}else if(salarioBase == salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
		}else {
			System.out.println("AGUARDANDO RESULTADO DEMAIS CANDIDATOS");
		}
		
	}
}
