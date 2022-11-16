import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * class MainKataklompat adalah class main tempat program permainan dijalan
 *
 * @author Ivan chiari
 * @npm 2108107010027
 * @version 1.0
 * @since 28-10-2022
 * @version 1.1
 * @since 12-11-2022
 */

public class MainLompatKatak implements Bermain {
    private boolean play;
    public Scanner s = new Scanner(System.in);

    /*
     * constructor MainLompatkatak
     */
    public MainLompatKatak() {
        this.play = true;
    }

    /**
     * method mainkan berisi semua permainan katak lompat
     * mengisi nama pemain, memilih level, membuat papan permainam
     * menjalankan loncatan dan menampilkan hasil akhir.
     * 
     */
    @Override
    public void mainkan() {
        Pemain pemain;
        Katak katak = new Katak();
        KotakPermainan game;

        System.out.println("Selamat datang di game katak1 Lompat");
        System.out.println("Rule: ");
        System.out.println("-katak berada pada 0 ");
        System.out.println("-katak harus melompat samapai kotak ke 500 atau 499");
        System.out.println("-katak mendapatkan koin , poin bertambah 10  ");
        System.out.println("-katak diserang oleh ular, poin berkurang 5  ");
        System.out.println("-Jika katak1 berada pada kotak 500, permainan selesai ");
        System.out.println("-Jika score kurang dari 0, permainan selesai \n");

        // menu nama player
        System.out.print("masukkan nama pemain :");
        String namaPlayer = s.nextLine();
        pemain = new Pemain(namaPlayer);

        /**
         * menu level
         * Pemilihan level permainan yang tersedia
         * Pemain dapat memilih level 1,2 atau 3
         */
        System.out.println("\nLevel tersedia:");
        System.out.println("\t1. level mudah");
        System.out.println("\t2. level sedang");
        System.out.println("\t3. level susah");
        System.out.print("pilih level:");
        int level = this.s.nextInt();
        int jk, jm;
        int j = 500;
        if (level == 1) {
            jk = 200;
            jm = 100;
        } else if (level == 2) {
            jk = 200;
            jm = 150;
        } else if (level == 3) {
            jk = 250;
            jm = 200;
        } else {
            // jika tidak memilih level 1,2 atau 3 maka level dibuat default
            System.out.println("**Input salah!");
            System.out.println("level default = 1");
            jk = 200;
            jm = 100;
        }

        /**
         * membuat papan permainan game dengan jumlah kotak,koin dan mosnter tertentu
         * dilanjutkan menampilkan isi 100 kotak permainan
         */
        game = new KotakPermainan(j, jk, jm);
        System.out.println("-------------------------------------------------------");
        System.out.println("contoh dari isi list kotak permainan");
        for (int i = 0; i < 50; i++) {
            System.out.print(game.contain(i));
        }
        System.out.println("-------------------------------------------------------");
        System.out.println();

        /**
         * pilihan untuk meloncat maju atau mundur dengan menampilkan posisi dan skor
         */
        int pilihan;
        while (katak.getSkor() > 0 && katak.getPosisi() != 499) {
            System.out.println("posisi katak: " + katak.getPosisi());
            System.out.println("Score saat ini: " + katak.getSkor());
            System.out.println("-------------------------------------------------------");
            // jika katak1 berada pada katak1.getPosisi() 498 maka katak1 tinggal sekali
            // lompatan maju 1 kotak untuk mengakhiri permainan
            if (katak.getPosisi() == 498) {
                System.out.println("1 lompatan maju terkahir  ");
            }
            System.out.println("\nTentukan langkah anda");
            System.out.println("1.Maju 1 langkah");
            System.out.println("2.Maju 2 langkah");
            System.out.println("3.Mundur 1 langkah");
            System.out.println("4.Mundur 2 langkah");
            System.out.print("Masukkan pilihan :");
            pilihan = this.s.nextInt();
            if (pilihan == 1) {
                if (katak.getPosisi() + 1 > 499) {
                    continue;
                } else {
                    katak.loncatDekat();// langkah maju 1 kotak
                }
            } else if (pilihan == 2) {
                if (katak.getPosisi() + 2 > 499) {
                    continue;
                } else {
                    katak.loncatJauh(); // langkah maju 2 kotak
                }
            } else if (pilihan == 3) {
                if (katak.getPosisi() - 1 < 0) {
                    System.out.println("katak berada di posisi 0 dan tidak bisa mundur lagi");
                    continue;
                } else {
                    katak.mundurDekat(); // langkah mundur 1 kotak
                }
            } else if (pilihan == 4) {
                if (katak.getPosisi() - 2 < 0) {
                    System.out.println("katak berada di posisi 0 dan tidak bisa mundur lagi");
                    continue;
                } else {
                    katak.mundurJauh(); // langkah mundur 2 kotak
                }
            } else {
                System.out.println("Upss... you crossed the line!");
                continue;
            }

            // merubah skor setiap melalui kotak dengan menambah skor sebelumnya dengan isi
            // dari kotak
            katak.setSkor(katak.getSkor() + game.contain(katak.getPosisi()));
            if (game.contain(katak.getPosisi()) == 10) {
                System.out.println("-------------------------------------------------------");
                System.out.println("katak mendapat koin dan skor bertambah 10");
            } else if (game.contain(katak.getPosisi()) == -5) {
                System.out.println("-------------------------------------------------------");
                System.out.println("katak diserang ular dan skor berkurang 5");
            } else {
                System.out.println("-------------------------------------------------------");
                System.out.println("Kamu di zona aman");
            }
        }

        if (katak.getSkor() < 0) { // jika belum mencapai kotak 499, namun skor sudah kurang dari 0
            System.out.println("----------------------Game Over------------------------");
        } else { // jika katak sudah mencapai kotak 499
            System.out.println("------------------------You Win------------------------");
        }

        // tampilan skor dan nama setelah selesai bermain
        System.out.println("\npermainnan selesai");
        pemain.setNilai(katak.getSkor());
        System.out.println("Pemain :" + pemain.getNama());
        System.out.println("Skor akhir :" + pemain.getNilai());
        if (pemain.getNilai() > 1500) {
            System.out.println("Excellent!!! Keep the record !");
        } else if (pemain.getNilai() > 500 && pemain.getNilai() < 1500) {
            System.out.println("Good!!!! keep playing and get more better score");
        } else {
            System.out.println("Bad game. Good luck next time");
        }
        System.out.println("Terima kasih telah bermain\n\n");
    }

    /**
     * fungsi main dari program menampilkan menu awal dan menu akhir permainan
     * 
     * @param args
     */
    public static void main(String[] args) {
        MainLompatKatak main = new MainLompatKatak();

        /**
         * selama play masih true maka permainan akan terus dilanjutkan
         * menu berisi pilihan main dan keluar
         * jika pilihan 1 maka menjalankan method mainkan yang berisi isi permainan
         * jika pilihan 2 maka meninggalkan permainan
         */

        do {
            do {
                try {
                    System.out.println("\n+-------------------------------+");
                    System.out.println("|##   Permainan lompat katak  ##|");
                    System.out.println("|           1. Mainkan          |");
                    System.out.println("|           2. Keluar           |");
                    System.out.println("+-------------------------------+");

                    System.out.print("Masukkan pilihan anda: ");
                    int option = main.s.nextInt();
                    main.s.nextLine();
                    if (option == 1) {
                        main.mainkan();
                        break;
                    } else if (option == 2) {
                        // jika pilihan selain 1 maka keluar
                        System.out.println("\n \tSelamat tinggal ");
                        System.out.println("Terima kasih & datang kembali");
                        System.exit(1);
                    }
                } catch (InputMismatchException ex) {
                    System.out.println();
                    System.out.println("Inputan harus berupa angka ");
                    System.out.println("kembali menu utama ");
                }
                main.s.nextLine();
            } while (true);

            /**
             * jika permainan selesai
             * maka berikan pilihan ingin lanjut bermain atau tidak
             */
            System.out.println("+-------------------------------+");
            System.out.println("|## Ingin bermain lagi (y/t)? ##|");
            System.out.println("|            Ya (y)             |");
            System.out.println("|           Tidak (T)           |");
            System.out.println("+-------------------------------+");
            System.out.print("Masukkan pilihan anda: ");
            char ulang = main.s.next().charAt(0);
            if (ulang == 't') {
                System.out.println("\nTerima kasih telah bermain");
                main.play = false;
                break;
            }
        } while (main.play);

    }
}