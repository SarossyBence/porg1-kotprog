Sárossy Bence JES7V1 - programozás1 - kötelező prgoram - JSlender: The eight pages

A karakter mozgása a fel le balra jobbra nyilakkal történi a papír felvétel space billentyűre kilépés ESC gombra



A pálya vátoztatható az alapján hogy a map.txt fáj hogyan van feltöltve a benne lévő
számok veszővvel el választva a 15x15 mátrix alakját követve legyen kitöltve ha modosítani akarsz a pályán akkor a számok egy terptárgyat jelentenek amit a feladatban leírtak szerint kell méretezni tehát pl. egy nagy méretű fa nem lehet teljesen egy sorban
mert az 2x2 méretű
a tárgyakhoz rendelt számok:
0 föld 
1 szikla
2 kisméretű fa, nagyméretű fa
3 autó és a kamion eleje
4 ház falai 
5 ház belső része 
6 kamion platója 
7 hordó

ha modosítod a pályát figyelj arra hogy a papírok fix helyen vannak ha őket is át akarod helyezni akkor a Map.javaban a példányosított papírokat kell úgy át helyezned hogy az egy terep tárgyon legyen fontos hogy a papír a tárgyakon van és olyan helyen ahol a player mellé tudd lépni meg csak így tudja felszedni azt 


ja a tesztelés során szeretnéd látni a pályán merre vannak a papírok érdemes át állítani a Papers.java-ban ezt a sort:
public static ImageIcon icon = new ImageIcon("src/img/paperv2.png");
erre:public static ImageIcon icon = new ImageIcon("src/img/paper.png"); 