/**
 * class Koin terdiri nilai koin yang memperbanyak skor pemain
 *
 * @author Ivan chiari
 * @version 1.0
 */
public class Koin extends nilai{
    private int nilai;

    /**
     * Constructor koin dengan nilai 10
     */
    public Koin() {
        nilai = 10;
    }

    /**
     * Constructor koin dengan nilai tertentu
     * 
     * @param nilai
     */
    public Koin(int nilai) {
        this.nilai = nilai;
    }

    /**
     * Method accesor untuk mengembalikan nilai koin
     * 
     * @return nilai
     */
    public int getNilai() {
        return nilai;
    }

    /**
     * Method mutator nilai koin
     * 
     * @param nilaibaru
    */
    public void setNilai(int nilaibaru) {
        this.nilai = nilaibaru;
    }

}
