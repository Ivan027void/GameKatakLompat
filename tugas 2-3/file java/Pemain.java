/**
 * class Pemain untuk menyimpan nama pemain dan skor permainan 
 *
 * @author Ivan chiari
 * @version 1.0
 */
public class Pemain {
    private String nama;
    private int nilai;

    /**
     * Constructor untuk objek dari class Pemain
     * 
     * @param nama nama pemain
     */
    public Pemain(String nama) {
        this.nama = nama;
        nilai = 0;
    }

    /**
     * Method untuk mendapatkan nama pemain
     * 
     * @return nama pemain
     */
    public String getNama() {
        return this.nama;
    }

    /**
     * Method untuk mengatur nama pemain
     * 
     * @param nama nama pemain
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * Method untuk mendapatkan nilai pemain
     * 
     * @return nilai pemain
     */
    public int getNilai() {
        return this.nilai;
    }

    /**
     * Method untuk mengatur nilai pemain
     * 
     * @param nilai nilai pemain
     */
    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}