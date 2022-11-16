import java.util.Scanner;
import java.util.Random;

/** 
 * Permainan KatakLompat yang terdiri dari katak,koin dan monster
 * lintasan lompat ada 500 kotak dengan range 0 sampai 499
 * Katak dapat melompat maju atau mundur
 * Jumlah kotak tiap lompatan adalah 1 atau 2
 * Monster dan koin terdiri dari beberapa jenis 
 * Monster dan koin tersebar acak pada lintasan
 * 
 * @author Ivan Chiari
 * @version 1.0
 * NPM : 2108107010027
 */
public class katakLompat{

/** 
 *
 * Main
 *
 * @param args[]  the args []
 */
    public static void main(String args[]){ 

        //scanner input
        Scanner s = new Scanner(System.in);
        //lintasan kotak lompat
        int[] kotak= new int[500];
        //vairabel level permainan
        int level;
        //jenis jenis koin
        int koin1=0,koin2=0,koin3=0;
        //jenis jenis monster
        int monster1=0,monster2=0,monster3=0;
        //pilihan untuk lompatan
        int pilihan;
        //posisi awal katak pada lintasan
        int posisiKatak=0;
        //score awal pemain dalam permainan
        int score=100;
        //variabel untuk memulai kembali permainan
        char ulang;
        
        do{
        /**
         * menu utama
         * untuk memulai permainan berisi 2 pilihan 
         * yaitu:
         * 1.mainkan
         * 2.keluar
         */ 
        System.out.println("\n+-------------------------------+");
        System.out.println("|## Lompat hai katak, lompat! ##|");
        System.out.println("|           1. Mainkan          |");
        System.out.println("|           2. Keluar           |");
        System.out.println("+-------------------------------+");
        System.out.print("Masukkan pilihan anda: ");
        int option = s.nextInt();
    
        if(option == 1){
            /**
             * jika pilihan 1 atau bermain
             * rules permainan akan ditampilkan
             */
            System.out.println("\nSelamat datang !");
            System.out.println( "Rule: ");
            System.out.println( "-Katak berada pada posisi 0 ");
            System.out.println( "-Katak harus melompat samapi kotak ke 500 atau posisi 499");
            System.out.println( "-Katak mendapatkan koin perunggu, poin bertambah 10  ");
            System.out.println( "-Katak mendapatkan koin perak, poin bertambah 20  ");
            System.out.println( "-Katak mendapatkan koin emas, poin bertambah 30  ");
            System.out.println( "-Katak diserang oleh ular, poin berkurang 5  ");
            System.out.println( "-Katak diserang oleh musang, poin berkurang 10  ");
            System.out.println( "-Katak diserang oleh elang, poin berkurang 20  ");
        }
        else{
            //jika pilihan selain 1 maka keluar
            System.out.println("\n Selamat tinggal ");
            System.exit(0);
        }

        /**
         * Pemilihan level permainan yang tersedia
         * Pemain dapat memilih level 1,2 atau 3
         */
        System.out.println("\nLevel tersedia:");
        System.out.println("\t1. level mudah");
        System.out.println("\t2. level sedang");
        System.out.println("\t3. level susah");
        System.out.print("pilih level:");
        level = s.nextInt();
        if(level==1)
        {
            koin1=100;
            koin2=80;
            koin3=20;
            monster1=50;
            monster2=40;
            monster3=10;
        }
        else if(level== 2)
        {
            koin1=100;
            koin2=80;
            koin3=20;
            monster1=30;
            monster2=100;
            monster3=20;
        }
        else if(level==3){
            koin1=100;
            koin2=50;
            koin3=50;
            monster1=20;
            monster2=100;
            monster3=80;     
         }
         //Jika memilih selain 1,2,atau 3 maka permainan level defualt 
        else{
           koin1=200;
           monster1=100;
        }
    
        /**
         * Perulangan for untuk setiap item koin dan monster 
         * Secara acak dimasukkan kedalam kotak permainan
         */
        Random p_acak=new Random();
        for (int i=0;i<=koin1;i++){
            int Acak=p_acak.nextInt(500);
            while(kotak[Acak]!=0){
                Acak+=1;
                    if(Acak>499){
                        Acak=1;
                    }
             }
            kotak[Acak]=1;
        }
        for (int i=0;i<=monster1;i++){
            int Acak=p_acak.nextInt(500);
            while(kotak[Acak]!=0){
                Acak+=1;
                    if(Acak>499){
                        Acak = 1;
                    }
            }
            kotak[Acak]=2;
         }
         for (int i=0;i<=koin2;i++){
            int Acak=p_acak.nextInt(500);
            while(kotak[Acak]!=0){
                Acak+=1;
                    if(Acak>499){
                        Acak=1;
                    }
             }
            kotak[Acak]=3;
        }
        for (int i=0;i<=monster2;i++){
            int Acak=p_acak.nextInt(500);
            while(kotak[Acak]!=0){
                Acak+=1;
                    if(Acak>499){
                        Acak=1;
                    }
             }
            kotak[Acak]=4;
        }
        for (int i=0;i<=koin3;i++){
            int Acak=p_acak.nextInt(500);
            while(kotak[Acak]!=0){
                Acak+=1;
                    if(Acak>499){
                        Acak=1;
                    }
             }
            kotak[Acak]=5;
        }
        for (int i=0;i<=monster3;i++){
            int Acak=p_acak.nextInt(500);
            while(kotak[Acak]!=0){
                Acak+=1;
                    if(Acak>499){
                        Acak=1;
                    }
             }
            kotak[Acak]=6;
        }
    
        for(int o=0;o<500;o++){ System.out.print("|"+kotak[o]+"|");}

        /**
         * Perulangan for digunakan untuk gerakan katak melompat di kotak sesuai pilihan pemain
         * Gerakan lompat maju 1 kotak dan 2 kotak
         * Gerakan lompat mundur 1 kotak dan 2 kotak
         * Jika mencapai kotak 498 maka katak hanya bisa maju 1 langkah atau mundur
         * Jika mencapai kotak 499 atau score kurang dari 0 maka permainan selesai
         */
          for(posisiKatak=0;posisiKatak!=499 && score>=0;){
            System.out.println("\nPosisi katak di kotak "+ posisiKatak);
            System.out.println("Score saat ini:"+score);
            //jika katak berada pada posisi 498 maka katak tinggal sekali lompatan maju 1 kotak untuk mengakhiri permainan 
            if(posisiKatak==498) 
            {
                System.out.println("1 lompatan maju terkahir  ");
            }
            System.out.println("\nTentukan langkah anda");
            System.out.println("1.Maju 1 langkah");
            System.out.println("2.Maju 2 langkah");
            System.out.println("3.Mundur 1 langkah");
            System.out.println("4.Mundur 2 langkah");
           
            System.out.print("Masukkan pilihan :");
            pilihan=s.nextInt();
            if (pilihan == 1) {
                if (posisiKatak + 1 > 499) {
                    continue;
                } else {
                    posisiKatak += 1;
                }
            } else if (pilihan == 2) {
                if (posisiKatak + 2 > 499) {
                    continue;
                } else {
                    posisiKatak += 2;
                }
            } else if (pilihan == 3) {
                if (posisiKatak - 1 < 0) {
                    continue;
                } else {
                    posisiKatak -= 1;
                }
            } else if (pilihan == 4) {
                if (posisiKatak - 2 < 0) {
                    continue;
                } else {
                    posisiKatak -= 2;
                }
            } else {
                continue;
            }

            /**
             * perubahan score berdasarkan posisi katak dan benda yang ditemui saat melompat
             * Melompat pada kotak berisi koin perunggu maka score +10
             * Melompat pada kotak berisi koin perak maka score +20
             * Melompat pada kotak berisi koin emas maka score +40
             * Melompat pada kotak berisi ular maka score -5
             * Melompat pada kotak berisi musang maka score -10
             * Melompat pada kotak berisi elang maka score -20 
             */
            if(kotak[posisiKatak]==1){
                kotak[posisiKatak]=0;
                score+=10;
                System.out.println("Anda mendapatkan koin perunggu,score bertambah 10");
            }else if(kotak[posisiKatak]==2){
                kotak[posisiKatak]=0;
                score -=5;
                System.out.println("Ular menyerang katak,score berkurang 5");
            } else if (kotak[posisiKatak] == 3) {
                kotak[posisiKatak]=0;
                score += 20;
                System.out.println("Anda mendapatkan koin perak, Score bertambah 20");
            }else if (kotak[posisiKatak] == 4) {
                kotak[posisiKatak]=0;
                score -= 10;
                System.out.println("Musang menyerang katak, Score berkurang 10");
            } else if (kotak[posisiKatak] == 5) {
                kotak[posisiKatak]=0;
                score += 30;
                System.out.println("Anda mendapatkan koin emas, Score bertambah 30");
            } else if (kotak[posisiKatak] == 6) {
                kotak[posisiKatak]=0;
                score -=20;
                System.out.println("Elang menyerang katak, Score berkurang 20");
            }
        }

        /**
         * penilaian score akhir
         * jika score lebih dari 1500 maka excelent
         * jika score diantara 500 dan 1500 maka good
         * jika score kurang dari 500 maka good luck
         */
            if(score > 1500){
                System.out.println("\nExcellent!!!!");
                System.out.println("\nLevel permainan: "+ level);
                System.out.println("Score akhir :"+score);
            } else if(score > 500 && score < 1500){
                System.out.println("\nGood!!!!");
                System.out.println("\nLevel permainan: "+ level);
                System.out.println("Score akhir :"+score);
            } else{
                System.out.println("\nBad. Good luck next time");
                System.out.println("\nLevel permainan: "+ level);
                System.out.println("score akhir :"+score);
            }
            
            /**
             * jika permainan selesai
             * maka berikan pilihan ingin lanjut bermain atau tidak
             */
            System.out.println("\n+-------------------------------+");
            System.out.println("|## Ingin bermain lagi (y/t)? ##|");
            System.out.println("|            Ya (y)             |");
            System.out.println("|           Tidak (T)           |");
            System.out.println("+-------------------------------+");
            System.out.print("Masukkan pilihan anda: ");
            ulang = s.next().charAt(0);
             
            System.out.println();
          }
          while (ulang!= 't');
            System.out.println( "\nTerima kasih telah bermain");
            s.close();
        }
}        
