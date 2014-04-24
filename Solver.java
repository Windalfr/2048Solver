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
		
		
		
		// Phase de calculs et d'évaluations
		
		
		
		
		 
		
		[...]
		
		
		
		return 0;
	}
	
	
	
	// Simulation du déplacement d'une case
	int deplacement(int direction, int x, int y){
		
		// Traitement des cas d'erreur
		if (x<0 || y<0 || x>3 || y>3){System.out.println ("Erreur coordonnees deplacement"); return -1;}
		
		
		// Cas d'une case non nulle
		if (area[x][y] != 0){
			
			// Vers le haut
			if (direction == 0){
				// Premiere rangée : ne rien faire
				if (y==0){}
				
				// Seconde rangée
				else if (y==1){
					// Cas ou la case précèdente est libre, on y glisse, aucun verrou car aucune fusion
					if (area[x][0] == 0){	
						area[x][0] = area[x][1];
						area[x][1] = 0;
					}
					// Cas ou la case précèdente est identique à l'actuelle : fusion possible, verrou
					else if (area[x][0] == area[x][1]){
						area[x][0] *= 2;
						area[x][1] = 0;
						verrou[x][0] = 1;
					}
					
					// Cas ou les cases sont toutes les deux occupés, mais de valeurs diff : on ne fait rien
					else {}
				}
				
				// Troisième rangée
				else if (y==2){
					// Cas ou les deux cases précèdentes sont libres, on glisse jusqu'à la première, aucun verrou car aucune fusion
					if (area[x][0] == 0 && area[x][1] == 0){	
						area[x][0] = area[x][2];
						area[x][2] = 0;
					}
					// Cas ou la case précèdente est libre et... 
					else if (area[x][1] == 0){	
						// ... la première est occupée mais différente, ou verouillée : on glisse simplement sur celle d'avant
						if (area[x][0] != area[x][2] || verrou[x][0] == 1){
							area[x][1] = area[x][2];
							area[x][2] = 0;
						}
						
						// ... la première est identique, et non verrouilée, donc fusion et verrouillage
						else if (area[x][0] == area[x][2] && verrou[x][0] == 0){
							area[x][0] *= 2;
							area[x][2] = 0;
							verrou[x][0] = 1;
						}
						
						// On n'est pas sencé arriver dans ce cas
						else {System.out.println ("Erreur deplacement rangee 3>2"); return -1;}	
					}
					
					// Cas ou la case précèdente est identique à l'actuelle : fusion et verrou
					else if (area[x][1] == area[x][2]){
						area[x][1] *= 2;
						area[x][2] = 0;
						verrou[x][1] = 1;
					}
					
					// Cas ou la case précèdente est occupée et différente de l'actuelle : on ne fait rien
					else {}
				}
				
				
				// Dernière rangée
				else if (y==3){
					// Cas ou les trois rangées précèdentes sont vides
					if (area[x][0] == 0 && area[x][1] == 0 && area[x][2] == 0){	
						area[x][0] = area[x][3];
						area[x][3] = 0;
					}
					
					// Cas ou les 2 rangées précèdentes sont vides et la premiere est ... 
					else if (area[x][1] == 0 && area[x][2] == 0){
						// ... occupée par une valeur différente, ou verrouilée
						if (area[x][0] != area[x][3] || verrou[x][0] == 1){
							area[x][1] = area[x][3];
							area[x][3] = 0;
						}
						
						// ... la première est identique, et non verrouilée, donc fusion et verrouillage
						else if (area[x][0] == area[x][3] && verrou[x][0] == 0){
							area[x][0] *= 2;
							area[x][3] = 0;
							verrou[x][0] = 1;
						}
				
						// On n'est pas sencé arriver dans ce cas
						else {System.out.println ("Erreur deplacement rangee 4>2"); return -1;}	
					}
					
					
					// Cas les 2 premières rangées sont occupées, et ...
					
					[...]
					
				}
				
				// Cas d'erreur
				else {System.out.println ("Erreur nombre rangees"); return -1;}
			}
		}
		
		return 0;
	}
	
	
	
	// Evaluation pour le niveau actuel et les niveaux à venir
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