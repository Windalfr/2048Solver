import java.util.Scanner;

public class Solver {
	public static void main(String[] args) {
		Principal programme = new Principal();
		
		System.out.println("Haha");
		programme.start();
	}
}



class Principal{
	int area[][];		// Table du jeu
	int verrou[][];		// Verrou des cases
	
	int start(){
		int i, j, x, y;
		int saisie, tempo;
		Scanner sc = new Scanner(System.in);
		
		// Initialisation de la zone de jeu
		area = new int[4][];
		verrou = new int[4][];
		for (i=0; i<4; i++){
			area[i] = new int[4];
			verrou[i] = new int[4];
		}
		
		
		// Affichage de la zone de jeu
		System.out.println("Voici le plan du terrain avec le numero des cases :");
		System.out.println("_____________________");
		System.out.println("| 00 | 01 | 02 | 03 |");
		System.out.println("_____________________");
		System.out.println("| 04 | 05 | 06 | 07 |");
		System.out.println("_____________________");
		System.out.println("| 08 | 09 | 10 | 11 |");
		System.out.println("_____________________");
		System.out.println("| 12 | 13 | 14 | 15 |");
		System.out.println("_____________________");
		
		
		// Saisie des 2 cases initiales
		System.out.println("Entrez le numero de la case ou est apparu le premier '2' :");
		saisie = sc.nextInt();
		x = saisie%4;
		y = saisie-(x*4);
		area[x][y] = 2;
		
		System.out.println("Entrez le numero de la case ou est apparu le second '2' :");
		saisie = sc.nextInt();
		x = saisie%4;
		y = saisie-(x*4);
		area[x][y] = 2;
		
		
		
		// Phase de calculs et d'�valuations
		
		
		
		
		 
		
		[...]
		
		
		
		return 0;
	}
	
	
	
	// Simulation du d�placement d'une case
	int deplacement(int direction, int x, int y){
		
		// Traitement des cas d'erreur
		if (x<0 || y<0 || x>3 || y>3){System.out.println ("Erreur coordonnees deplacement"); return -1;}
		
		
		// Cas d'une case non nulle
		if (area[x][y] != 0){
			
			// Vers le haut
			if (direction == 0){
				// Premiere rang�e : ne rien faire
				if (y==0){}
				
				// Seconde rang�e
				else if (y==1){
					// Cas ou la case pr�c�dente est libre, on y glisse, aucun verrou car aucune fusion
					if (area[x][0] == 0){	
						area[x][0] = area[x][1];
						area[x][1] = 0;
					}
					// Cas ou la case pr�c�dente est identique � l'actuelle : fusion possible, verrou
					else if (area[x][0] == area[x][1]){
						area[x][0] *= 2;
						area[x][1] = 0;
						verrou[x][0] = 1;
					}
					
					// Cas ou les cases sont toutes les deux occup�s, mais de valeurs diff : on ne fait rien
					else {}
				}
				
				// Troisi�me rang�e
				else if (y==2){
					// Cas ou les deux cases pr�c�dentes sont libres, on glisse jusqu'� la premi�re, aucun verrou car aucune fusion
					if (area[x][0] == 0 && area[x][1] == 0){	
						area[x][0] = area[x][2];
						area[x][2] = 0;
					}
					// Cas ou la case pr�c�dente est libre et... 
					else if (area[x][1] == 0){	
						// ... la premi�re est occup�e mais diff�rente, ou verouill�e : on glisse simplement sur celle d'avant
						if (area[x][0] != area[x][2] || verrou[x][0] == 1){
							area[x][1] = area[x][2];
							area[x][2] = 0;
						}
						
						// ... la premi�re est identique, et non verrouil�e, donc fusion et verrouillage
						else if (area[x][0] == area[x][2] && verrou[x][0] == 0){
							area[x][0] *= 2;
							area[x][2] = 0;
							verrou[x][0] = 1;
						}
						
						// On n'est pas senc� arriver dans ce cas
						else {System.out.println ("Erreur deplacement rangee 3>2"); return -1;}	
					}
					
					// Cas ou la case pr�c�dente est identique � l'actuelle : fusion et verrou
					else if (area[x][1] == area[x][2]){
						area[x][1] *= 2;
						area[x][2] = 0;
						verrou[x][1] = 1;
					}
					
					// Cas ou la case pr�c�dente est occup�e et diff�rente de l'actuelle : on ne fait rien
					else {}
				}
				
				
				// Derni�re rang�e
				else if (y==3){
					// Cas ou les trois rang�es pr�c�dentes sont vides
					if (area[x][0] == 0 && area[x][1] == 0 && area[x][2] == 0){	
						area[x][0] = area[x][3];
						area[x][3] = 0;
					}
					
					// Cas ou les 2 rang�es pr�c�dentes sont vides et la premiere est ... 
					else if (area[x][1] == 0 && area[x][2] == 0){
						// ... occup�e par une valeur diff�rente, ou verrouil�e
						if (area[x][0] != area[x][3] || verrou[x][0] == 1){
							area[x][1] = area[x][3];
							area[x][3] = 0;
						}
						
						// ... la premi�re est identique, et non verrouil�e, donc fusion et verrouillage
						else if (area[x][0] == area[x][3] && verrou[x][0] == 0){
							area[x][0] *= 2;
							area[x][3] = 0;
							verrou[x][0] = 1;
						}
				
						// On n'est pas senc� arriver dans ce cas
						else {System.out.println ("Erreur deplacement rangee 4>2"); return -1;}	
					}
					
					
					// Cas les 2 premi�res rang�es sont occup�es, et ...
					
					[...]
					
				}
				
				// Cas d'erreur
				else {System.out.println ("Erreur nombre rangees"); return -1;}
			}
		}
		
		return 0;
	}
	
	
	
	// Evaluation pour le niveau actuel et les niveaux � venir
	int evaluationAll(){
		int score= 0;
		
		return score;
	}
	
	
	
	// Evaluation basique pour commencer, plus il y a de cases vides, mieux c'est, donc une case vide = un point
	int evaluation(){
		int score = 0;
		int x,y;
		
		for (x=0; x<4; x++){
			for (y=0; y<4; y++){
				if (area[x][y] == 0){score++;}
			}
		}
		return score;
	}
	
	
	int initialisationArea(){
		int i,j;
		for (i=0; i<4; i++){
			for (j=0; j<4; j++){
				area[i][j] = 0;
			}
		}
		return 0;
	}
	
	int initialisationVerrou(){
		int i,j;
		for (i=0; i<4; i++){
			for (j=0; j<4; j++){
				verrou[i][j] = 0;
			}
		}
		return 0;
	}
	
}