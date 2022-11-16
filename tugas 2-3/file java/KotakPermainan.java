import java.util.ArrayList;
import java.util.Collections;
/**
 * class KotakPermainan terdiri dari banyak kotak yang akan diisi 
 * dan digunakan sebagai tempat bermain
 *
 * @author Ivan chiari
 * @version 1.0
 */


public class KotakPermainan {
    private Kotak boardGame[];
    private int jumKotak;
    private int jumKoin;
    private int jumMonster;
    private int acakKoin[];
    private int acakMonster[];

    /**
     * 
     * @param j
     * @param jk
     * @param jm
     */
    public KotakPermainan(int j, int jk, int jm) {
        // initialise instance variables
        this.jumKotak = j;
        this.jumKoin = jk;
        this.jumMonster = jm;

        generateAcak();
        inisialisasiKotak();
    }

    /**
     * Method mengacak list yang digunakan untuk diisi koin dan monster
     * sesuai dengan jumlah kotak,mosnter ,dan koin
     *
     */
    private void generateAcak() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        acakKoin = new int[jumKoin];
        acakMonster = new int[jumMonster];
        // nilai acak sesaui jumlahkotak
        for (int i = 0; i < jumKotak; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        // generate nilai acak untuk koin
        for (int i = 1; i < jumKoin; i++) {
            acakKoin[i] = list.get(i);// koin
        }
        // mengenerate posisi monster pada kotak
        // posisi tidak boleh sama dengan koin
        for (int i = jumKoin ; i < jumMonster + jumKoin ; i++) {
            acakMonster[i - jumKoin] = list.get(i);
        }
    }

    /**
     * Method inisialisasi kotak mengisi kotak yang sudah ada dengan obj koin dan monster
     */
    private void inisialisasiKotak() {
        boardGame = new Kotak[jumKotak];
        Koin koin1 = new Koin(10);
        Monster monster1 = new Monster(-5, "Ular");

        for (int i = 0; i < jumKotak; i++) {
            boardGame[i] = new Kotak();
        }

        for (int i = 0; i < jumKoin; i++) {
            boardGame[acakKoin[i]].addKoin(koin1);
            // System.out.print(acakKoin[i]+"\t");
        }

        for (int i = 0; i < jumMonster; i++) {
            boardGame[acakMonster[i]].addMonster(monster1);
            // System.out.println(acakMonster[i]);
        }

    }

    /**
     * Method contain untuk memberi nilai dari koin dan monster ke dalam array list yang sudah ada
     * 
     * @param posisi
     * @return nilai koin,nilai monster, 0
     */
    public int contain(int posisi) {
        if (boardGame[posisi].isThereKoin()) {
            return boardGame[posisi].getKoin().getNilai();
        } else if (boardGame[posisi].isThereMonster()) {
            return boardGame[posisi].getMonster().getNilai();
        } else {
            return 0;
        }
    }
}