/*
 * Sistema di Simulazione per un Parco Divertimenti

Progetta un programma in Java che simuli la gestione di un parco divertimenti. L’obiettivo è creare un sistema per monitorare l’affluenza, gestire le code alle attrazioni e calcolare ricavi e costi operativi.

Requisiti
Attrazioni:

Ogni attrazione ha un nome, una capacità massima di persone, un costo operativo per giro, e un prezzo del biglietto per persona.
Ogni attrazione può funzionare più volte al giorno, ma non può superare il numero massimo di giri giornalieri.

Visitatori:

Ogni visitatore ha un budget casuale assegnato all’ingresso e può scegliere quante attrazioni visitare in base ai prezzi.
Se un’attrazione è piena, il visitatore può aspettare (se il tempo di attesa stimato è sotto un limite casuale assegnato) o scegliere un’altra attrazione.

Turni di Gestione:

Il parco è aperto per un numero definito di giorni.
Ogni giorno si esegue una simulazione in cui:
I visitatori entrano nel parco.
Sceglieranno le attrazioni da visitare in base al budget e ai tempi di attesa.
Gli incassi e i costi operativi delle attrazioni vengono calcolati.

Statistiche Finali:

Calcola:
Il guadagno netto totale del parco.
L’attrazione più visitata.
Il tempo medio di attesa per attrazione.
La percentuale di visitatori soddisfatti (che hanno potuto visitare almeno un'attrazione).

Vincoli Tecnici

Non usare array o strutture complesse come liste o mappe. Devi gestire tutto tramite variabili e cicli.
Ogni attrazione e visitatore deve essere trattato singolarmente.
Il codice deve essere ben commentato e includere spiegazioni per ogni sezione logica.
 */

package main;

import java.util.Scanner;

public class ParcoDivertimenti {

	public static void main(String[] args) {

		// Dati attrazioni

		// Aggiungere giorni di apertura
		String venerdì = "venerdì";
		String sabato = "sabato";
		String domenica = "domenica";

		// GIOSTRA 1
		String attrazione1 = "Tazze Rotanti";
		int biglietto1 = 5;
		int postiDisponibili1 = 12;
		int giriMax1 = 8;
		int costoOp1 = 2;
		int b1 = 0;

		// GIOSTRA 2
		String attrazione2 = "Torre Magica";
		int biglietto2 = 10;
		int postiDisponibili2 = 8;
		int giriMax2 = 10;
		int costoOp2 = 3;
		int b2 = 0;

		// GIOSTRA 3
		String attrazione3 = "Bruco Mela";
		int biglietto3 = 2;
		int postiDisponibili3 = 20;
		int giriMax3 = 6;
		int costoOp3 = 5;
		int b3 = 0;

		int statistica;
		int tentativi1 = 0;
		int tentativi2 = 0;
		int tentativi3 = 0;
		int numeroVisitatori = 10;
		int attesaAtt1 = 0;
		int attesaAtt2 = 0;
		int attesaAtt3 = 0;
		int soddisfattiTot=1;
		boolean vSoddisfatto=false;
		//double statSoddisfatti = ((double) soddisfattiTot / numeroVisitatori) * 100;
		
		

		Scanner scanner = new Scanner(System.in);

		String giorni[] = { "venerdì", "sabato", "domenica" };

		int sceltaGiornoRandom = ((int) (Math.random()) * giorni.length); // scelta random per verificare se il parco è
																			// aperto
		System.out.println(
				"Benvenuti al parco divertimenti. Oggi è " + giorni[sceltaGiornoRandom] + " il parco è aperto.");

		for (numeroVisitatori = 1; numeroVisitatori <= 10; numeroVisitatori++) {

			System.out.println("Entra il visitatore n. " + (numeroVisitatori));
			double budget = Math.random() * 4 + 2; // viene assegnato randomicamente il budget
			System.out.println("Il budget del visitatore è di: " + (int) budget + " euro.");

			double attmax = Math.random() * 6 + 2; // viene assegnato randomicamente il budget
			System.out.println("Il visitatore è disposto ad aspettare in fila al massimo " + (int) attmax + " minuti.");

			double fila1 = Math.random() * 9 + 1; // viene assegnato randomicamente la fila
			double fila2 = Math.random() * 5 + 1;
			double fila3 = Math.random() * 1 + 1;

			System.out.println();
			if (vSoddisfatto==true) {
				soddisfattiTot+=1;
				System.out.println(soddisfattiTot);
			}
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
					
					// controllo se l'attrazione è in funzione
					attesaAtt1 += fila1; // aumento il calcolo della fila
					if (budget >= biglietto1) { // e se non c'è troppa fila
						
						if (attmax >= fila1) { // se positivo procede, altrimenti cambia attrazione
							System.out.println("Decide di visitare l'attrazione " + attrazione1 + " e il costo è €"
									+ biglietto1 + ".");
							System.out.println("Acquista il biglietto e si mette in fila."); 
							System.out.println("Al visitatore rimangono €" + ((int) budget - biglietto1) + ".");
							System.out.println("");
							budget = budget - biglietto1;
							b1++;
							vSoddisfatto=true;
							continue; // riparte il ciclo

						} else if (attmax < fila1) {
							System.out.println("Per " + attrazione1 + " c'è una fila di " + (int) fila1
									+ " minuti. A causa della troppa fila decide di cambiare attrazione.");

							System.out.println("");

						}
						
					
					} 
					tentativi1++; // arriva qui se il visitatore non ha abbastanza soldi o se c'è troppa fila
									// riparte da capo
				}

				else if (scelta == 2) {

					attesaAtt2 += fila2;
					// Controllo se può comprare il biglietto
					if (budget >= biglietto2) { // e se non c'è troppa fila
						
						if (attmax >= fila2) { // se positivo procede, altrimenti cambia attrazione
							System.out.println("Decide di visitare l'attrazione " + attrazione2 + " e il costo è €"
									+ biglietto2 + ".");
							System.out.println("Acquista il biglietto e si mette in fila."); 
							System.out.println("Al visitatore rimangono €" + ((int) budget - biglietto2) + ".");
							System.out.println("");
							budget = budget - biglietto2;
							b2++;
							vSoddisfatto=true;
							
							continue; // riparte il ciclo

						} else if (attmax < fila2) {
							System.out.println("Per " + attrazione2 + " c'è una fila di " + (int) fila2
									+ " minuti. A causa della troppa fila decide di cambiare attrazione.");
							System.out.println("");

						}

					}
					tentativi2++; // arriva qui se il visitatore non ha abbastanza soldi o se c'è troppa fila
									// riparte da capo
				}

				else if (scelta == 3) {

					attesaAtt3 += fila3;
					// Controllo se può comprare il biglietto
					if (budget >= biglietto3) { // e se non c'è troppa fila
						if (attmax >= fila3) { // se positivo procede, altrimenti cambia attrazione
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
						if (attmax < fila3) {
							System.out.println("Per " + attrazione3 + " c'è una fila di " + (int) fila3
									+ " minuti. A causa della troppa fila decide di cambiare attrazione.");
							System.out.println("");

						}

					}
					tentativi3++; // arriva qui se il visitatore non ha abbastanza soldi o se c'è troppa fila
									// riparte da capo
				} 

			} while (budget >= biglietto1 && budget >= biglietto2 && budget >= biglietto3); // && stop1<=giriMax1 || budget>=b2 && stop2<=giriMax2
																	// || budget>=b2 && stop3<=giriMax3);

		}
		
		System.out.println("Visualizzare statistiche (1) o uscire(2)?");
		statistica = scanner.nextInt();

		if (statistica == 1) {
			System.out.println(
					"Il guadagno netto del giorno è: " + ((b1 - costoOp1) + (b2 - costoOp2) + (b3 - costoOp3))); // calcolo
																													// guadagno
																													// giornaliero
			if (b1 > b2 && b1 > b3) { // if per capire quale è stata l'attrazione più visitata tra la 1,2,3 prendendo
										// come indicazione la parte precedente in cui il visitatore ha scelto le
										// attrazioni
				System.out.println("L'attrazione più visitata è: " + attrazione1 + ".");
			} else if (b2 > b3 && b2 > b1) {
				System.out.println("L'attrazione più visitata è: " + attrazione2 + ".");
			} else {
				System.out.println("L'attrazione più visitata è: " + attrazione3 + ".");
			}
			System.out.println("Il tempo medio di attesa per " + attrazione1 + " è: " + (attesaAtt1 / (b1 + tentativi1))
					+ " minuti.");
			// System.out.println((int) attesaAtt1);
			// System.out.println("biglietti venduti: " + b1);
			System.out.println("Il tempo medio di attesa per " + attrazione2 + " è: " + (attesaAtt2 / (b2 + tentativi2))
					+ " minuti.");
			System.out.println("Il tempo medio di attesa per " + attrazione3 + " è: " + (attesaAtt3 / (b3 + tentativi3))
					+ " minuti.");
			
			double statSoddisfatti=(soddisfattiTot / numeroVisitatori) * 100;
			System.out.println(statSoddisfatti);
			System.out.println("I visitatori sono soddisfatti per il " +((int)statSoddisfatti) + "%");
			System.out.println("Numero di soddisfatti: " + soddisfattiTot);
			System.out.println("Numero di visitatori: " + numeroVisitatori);
					//+ (((b1 + b2 + b3) - (tentativi1 + tentativi2 + tentativi3) / numeroVisitatori)) + "%"); // scopri
																												// come
																												// fare
																												// una
																												// percentuale

		} else
			System.out.println("Arrivederci!");

		scanner.close();

	}
}
