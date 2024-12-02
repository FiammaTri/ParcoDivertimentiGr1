//GRUPPO 1: Fiamma Trillò, Giorgia Savioli, Nico Fiorini, Chiara Messina

package main;

import java.util.Scanner;

public class ParcoDivertimenti {

	public static void main(String[] args) {

		// Dati attrazioni

		//Giorni di apertura
		String venerdì = "venerdì";
		String sabato = "sabato";
		String domenica = "domenica";

		// GIOSTRA 1
		String attrazione1 = "Tazze Rotanti";
		int biglietto1 = 5;
		int costoOp1 = 2;
		int b1 = 0;

		// GIOSTRA 2
		String attrazione2 = "Torre Magica";
		int biglietto2 = 10;
		int costoOp2 = 3;
		int b2 = 0;

		// GIOSTRA 3
		String attrazione3 = "Bruco Mela";
		int biglietto3 = 2;
		int costoOp3 = 5;
		int b3 = 0;

		int statistica;
		int tentativi1 = 0;
		int tentativi2 = 0;
		int tentativi3 = 0;
		int numeroVisitatori = 100;
		int attesaAtt1 = 0;
		int attesaAtt2 = 0;
		int attesaAtt3 = 0;
		int soddisfattiTot=0;
		boolean vSoddisfatto=false;
			
		
		Scanner scanner = new Scanner(System.in);


		int sceltaGiornoRandom = (int) Math.random() * 5 + 1; 	// scelta random per verificare se il parco è aperto. Il numero è <7 per velocizzare i tentativi
																//L'ideale era usare un array.
		if (sceltaGiornoRandom==1) {
		System.out.println(
				"Benvenuti al parco divertimenti. Oggi è " + venerdì + " e il parco è aperto.");
		} else if (sceltaGiornoRandom==2) {
			System.out.println(
					"Benvenuti al parco divertimenti. Oggi è " + sabato + " e il parco è aperto.");
		} else if (sceltaGiornoRandom==3) {
			System.out.println(
					"Benvenuti al parco divertimenti. Oggi è " + domenica + " e il parco è aperto.");
		} else {System.out.println(
				"Oggi il parco non è aperto.");
				System.exit(0);
		}

		for (numeroVisitatori = 0; numeroVisitatori < 100; numeroVisitatori++) {

			System.out.println("Entra il visitatore n. " + (numeroVisitatori+1));
			double budget = Math.random() * 8 + 1; 		// viene assegnato randomicamente il budget
			System.out.println("Il budget del visitatore è di: " + (int) budget + " euro.");

			double attmax = Math.random() * 8 + 1; 		// viene assegnato randomicamente l'attesa massima del visitatore
			System.out.println("Il visitatore è disposto ad aspettare in fila al massimo " + (int) attmax + " minuti.");

			double fila1 = Math.random() * 12 + 3; 		// viene assegnato randomicamente la fila
			double fila2 = Math.random() * 3 + 2;
			double fila3 = Math.random() * 1 + 1;

			System.out.println();
			
			//verifica per i visitatori soddisfatti. Se diventa vero 1 volta nel ciclo aggiunge 1 al numero totale
			vSoddisfatto=false;		//per ogni visitatore imposta la soddisfazione su falso finchè non avviene la condizione che lo modifica
			
			
			do {

				if (attmax < fila1 && attmax < fila2 && attmax < fila3) {
					System.out.println("A causa della troppa fila su tutte le attrazioni, decide di andare via.");
					break;
				}

				double scelta = Math.random() * 3 + 1; // in un intero per fare la scelta della giostra
				scelta = Math.floor(scelta); // floor lo uso per trasformare il numero casuale

				
				// INIZIO CALCOLO ATTRAZIONI
				// Attrazione 1
				if (scelta == 1) {
					
					
					attesaAtt1 += fila1; // aumento il calcolo della fila per le statistiche
					if (budget >= biglietto1) { // Controllo se può comprare il biglietto
						
						if (attmax >= fila1) { // e se non c'è troppa fila
							System.out.println("Decide di visitare l'attrazione " + attrazione1 + " e il costo è €"
									+ biglietto1 + ".");
							System.out.println("Acquista il biglietto e si mette in fila."); 
							System.out.println("Al visitatore rimangono €" + ((int) budget - biglietto1) + ".");
							System.out.println("");
							budget = budget - biglietto1;
							b1++;
							vSoddisfatto=true;
							continue; // riparte il ciclo

						} else if (attmax < fila1) {		//condizione se c'è troppa fila
							System.out.println("Per " + attrazione1 + " c'è una fila di " + (int) fila1
									+ " minuti. A causa della troppa fila decide di cambiare attrazione.");

							System.out.println("");

						}
						
					
					} 
					tentativi1++; // arriva qui se il visitatore non ha abbastanza soldi o se c'è troppa fila
									// riparte da capo
				}

				else if (scelta == 2) {

					attesaAtt2 += fila2;	// aumento il calcolo della fila per le statistiche
					
					if (budget >= biglietto2) { // Controllo se può comprare il biglietto
						
						if (attmax >= fila2) { // e se non c'è troppa fila
							System.out.println("Decide di visitare l'attrazione " + attrazione2 + " e il costo è €"
									+ biglietto2 + ".");
							System.out.println("Acquista il biglietto e si mette in fila."); 
							System.out.println("Al visitatore rimangono €" + ((int) budget - biglietto2) + ".");
							System.out.println("");
							budget = budget - biglietto2;
							b2++;
							vSoddisfatto=true;
							
							continue; // riparte il ciclo

						} else if (attmax < fila2) {		//condizione se c'è troppa fila
							System.out.println("Per " + attrazione2 + " c'è una fila di " + (int) fila2
									+ " minuti. A causa della troppa fila decide di cambiare attrazione.");
							System.out.println("");

						}

					}
					tentativi2++; // arriva qui se il visitatore non ha abbastanza soldi o se c'è troppa fila
									// riparte da capo
				}

				else if (scelta == 3) {

					attesaAtt3 += fila3;	// aumento il calcolo della fila per le statistiche
					
					if (budget >= biglietto3) { // Controllo se può comprare il biglietto
						if (attmax >= fila3) { // e se non c'è troppa fila
							System.out.println("Decide di visitare l'attrazione " + attrazione3 + " e il costo è €"
									+ biglietto3 + ".");
							System.out.println("Acquista il biglietto e si mette in fila."); 
							System.out.println("Al visitatore rimangono €" + ((int) budget - biglietto3) + ".");
							;
							System.out.println("");
							budget = budget - biglietto3;
							b3++;
							vSoddisfatto=true;		
							
							continue; // riparte il ciclo

						}
						if (attmax < fila3) {		//condizione se c'è troppa fila
							System.out.println("Per " + attrazione3 + " c'è una fila di " + (int) fila3
									+ " minuti. A causa della troppa fila decide di cambiare attrazione.");
							System.out.println("");

						}

					}
					tentativi3++; 	// arriva qui se il visitatore non ha abbastanza soldi o se c'è troppa fila
									// riparte da capo
				} 

			} while (budget >= biglietto1 || budget >= biglietto2 || budget >= biglietto3);
			if (vSoddisfatto) {						//imposta +1 ai soddisfatti totali solo a fine ciclo
		        soddisfattiTot++;
		}
		}
		
		System.out.println("Visualizzare statistiche (1) o uscire(2)?");			
		statistica = scanner.nextInt();

		if (statistica == 1) {
			System.out.println(
					"Il guadagno netto del giorno è: " + ((b1 - costoOp1) + (b2 - costoOp2) + (b3 - costoOp3))); // calcolo guadagno giornaliero
																													
			if (b1 > b2 && b1 > b3) { // if per capire quale è stata l'attrazione più visitata tra la 1,2,3 prendendo
										// come indicazione la parte precedente in cui il visitatore ha scelto le
										// attrazioni
				System.out.println("L'attrazione più visitata è: " + attrazione1 + ".");
			} else if (b2 > b3 && b2 > b1) {
				System.out.println("L'attrazione più visitata è: " + attrazione2 + ".");
			} else {
				System.out.println("L'attrazione più visitata è: " + attrazione3 + ".");
			}
			System.out.println("Il tempo medio di attesa per " + attrazione1 + " è: " + (attesaAtt1 / (b1 + tentativi1))		//calcolo dei tempi medi di attesa per attrazione
					+ " minuti.");
			System.out.println("Il tempo medio di attesa per " + attrazione2 + " è: " + (attesaAtt2 / (b2 + tentativi2))
					+ " minuti.");
			System.out.println("Il tempo medio di attesa per " + attrazione3 + " è: " + (attesaAtt3 / (b3 + tentativi3))
					+ " minuti.");
			
			double statSoddisfatti= (double)soddisfattiTot / (double) numeroVisitatori *100;				//calcolo la media
			System.out.println("I visitatori sono soddisfatti per il " +((int)statSoddisfatti) + "%");		// la trasformo in int
			

		} else
			System.out.println("Arrivederci!");

		scanner.close();

	}
}
