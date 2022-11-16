/**
 * class Monster sebagai hambatan/tantangan dalam permainan 
 *
 * @author Ivan chiari
 * @version 1.0
 */
public class Monster extends nilai{
    private int nilai;
    private String nama;

    /**
     * Constructor class Monster tanpa parameter
     */
    public Monster() {
        // initialise instance variables
        nama = "ular";
        nilai = -5;
    }

    /**
     * Constructor monster dengan parameter
     *
     * @param nilai int
     * @param nama  String
     */
    public Monster(int nilai, String nama) {
        this.nilai = nilai;
        this.nama = nama;
    }

    /**
     * Method mengembalikan nilai dari monster
     *
     * @return nilai
     */
    public int getNilai() {
        // put your code here
        return nilai;
    }

    /**
     * Method untuk mengatur monster
     * 
     * @param nama nama monster
     */
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setNilai(int nilai) {
        this.nilai = nilai;
    }


}