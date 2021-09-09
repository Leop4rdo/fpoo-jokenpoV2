package jokenpo;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Random randomizer = new Random();
		Scanner sc = new Scanner(System.in);

		int pMove = 0, cpuMove, placarPlayer = 0, placarCpu = 0, melhorDe = 0;
		String pMoveName = "", cpuMoveName = "", jogarNovamente = "s";
		
		System.out.println("------------ Jokenpo ------------");
		System.out.println();
		
		while (jogarNovamente.equalsIgnoreCase("s")) {
			System.out.println("Como jogar?");
			System.out.println("  - Escolha um numero de 1 a 3 onde:");
			System.out.println("     - Pedra = 1");
			System.out.println("     - Papel = 2");
			System.out.println("     - Tesoura = 3");
			System.out.println("  - Espere o computador fazer seu movimento");
			System.out.println("  - Comemore ou chore!");

			System.out.println();

			// o bloco de codigo abaixo le a resposta do usuario e valida se ela é valida.
			while (!(melhorDe >= 3 && (melhorDe % 2) == 1)) {
				System.out.print("Vamos jogar melhor de: ");
				melhorDe = sc.nextInt();

				if (!(melhorDe >= 3 && (melhorDe % 2) == 1)) {
					System.out.println("Resposta Invalida!");
				}

				System.out.println();
			}
			
			// o bloco de codigo abaixo é responsavel por repetir as partidas até que
			// o contador seja > do que o numero total de partidas
			int contador = 1;
			while (contador <= melhorDe && !(placarPlayer > melhorDe/2 || placarCpu > melhorDe/2)) {
				System.out.println("---------------------------------");
				System.out.println();
				System.out.println("           Partida " + contador);
				System.out.println();

				// o bloco de codigo abaixo recebe o movimento do jogador e ve se é um movimento
				// valido
				while (!(pMove <= 3 && pMove >= 1)) {
					System.out.println("Qual seu proximo movimento? (1 a 3)");
					pMove = sc.nextInt();

					if (!(pMove <= 3 && pMove >= 1)) {
						System.out.println("Resposta Invalida! \n");
					}
				}

				System.out.println();
				System.out.println("---------------------------------");
				System.out.println();

				System.out.println("Jo...");
				System.out.println("Ken......");
				System.out.println("Po!!!!!!!!!!");

				System.out.println();

				cpuMove = randomizer.nextInt(3) + 1;

				// o bloco de codigo abaixo define o resultado do jogo
				if ((pMove == 1 && cpuMove == 3) || (pMove == 2 && cpuMove == 1) || (pMove == 3 && cpuMove == 2)) { 
					System.out.println("Parabéns! você ganhou.");
					placarPlayer++;
				} else if (pMove == cpuMove) { // EMPATE
					System.out.println("Eita! empatou.");
				} else { // CPU VENCEU
					System.out.println("Urgh! não foi dessa vez.");
					placarCpu++;
				}

				switch (pMove) { // atribui nome ao movimento do jogador
				case 1:
					pMoveName = "Pedra";
					break;
				case 2:
					pMoveName = "Papel";
					break;
				case 3:
					pMoveName = "Tesoura";
					break;

				default:
					pMoveName = "Invalido";
					break;
				}

				switch (cpuMove) { // atribui nome ao movimento do computador
				case 1:
					cpuMoveName = "Pedra";
					break;
				case 2:
					cpuMoveName = "Papel";
					break;
				case 3:
					cpuMoveName = "Tesoura";
					break;

				default:
					cpuMoveName = "Invalido";
					break;
				}

				System.out.println();
				System.out.println("Seu movimento: " + pMoveName);
				System.out.println("Movimento do computador: " + cpuMoveName);
				System.out.println();

				contador++;
				pMove = 0;
				cpuMove = 0;
			}

			if (placarCpu == placarPlayer) {
				System.out.println("-------- Partida de Ouro --------");
				System.out.println();

				System.out.println("O jogo empatou, vamos desempatar \ncom a Partida de Ouro");
				System.out.println();

				while (placarCpu == placarPlayer) {
					System.out.println("Qual seu proximo movimento? (1 a 3)");
					pMove = sc.nextInt();

					System.out.println();
					System.out.println("---------------------------------");
					System.out.println();

					System.out.println("Jo...");
					System.out.println("Ken......");
					System.out.println("Po!!!!!!!!!!");

					System.out.println();

					cpuMove = randomizer.nextInt(3) + 1;

					if (pMove >= 1 && pMove <= 3) { // valida se o movimento do jogador foi valido
						if ((pMove == 1 && cpuMove == 3) || (pMove == 2 && cpuMove == 1)
								|| (pMove == 3 && cpuMove == 2)) { // valida se o jogador ganhou
							System.out.println("Parabéns! você ganhou.");
							placarPlayer++;
						} else if (pMove == cpuMove) { // valida caso o resultado tenha dado empate
							System.out.println("Eita! empatou.");
						} else {
							System.out.println("Urgh! não foi dessa vez.");
							placarCpu++;
						}
					} else {
						System.out.println("Ops! você realizou um movimento invalido.");
					}
					System.out.println();
				}
			}

			System.out.println();
			System.out.println("------------- Placar ------------");
			System.out.println();

			System.out.println("Jogador: " + placarPlayer);
			System.out.println("Cpu: " + placarCpu);
			System.out.println();
			String quemGanhou = (placarPlayer > placarCpu) ? "O Player ganhou!" : "A Cpu ganhou!";
			System.out.println(quemGanhou);

			System.out.println();
			System.out.println("---------------------------------");
			System.out.println();
			
			jogarNovamente = "";
			while (!jogarNovamente.equalsIgnoreCase("s") && !jogarNovamente.equalsIgnoreCase("n")) {
				System.out.println("Jogar novamente? (S/N)");
				jogarNovamente = sc.next();
				
				if (!jogarNovamente.equalsIgnoreCase("s") && !jogarNovamente.equalsIgnoreCase("n")) {
					System.out.println("Resposta Invalida!");
				}
				
				System.out.println();
			}
			
			
			
			melhorDe = 0;
			placarCpu = 0;
			placarPlayer = 0;
			pMove = 0;
			cpuMove = 0;
		}
	
		
		System.out.println("Obrigado por jogar!");
		System.out.println();
		System.out.println("---------------------------------");
	}
}
