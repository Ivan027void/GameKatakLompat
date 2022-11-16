/**
 *  class Katak untuk katak melompat
 *
 * @author Ivan chiari
 * @version 1.0
 */
public class Katak
{
    private int posisi;
    private int skor;

    /**
     * Constructor for objects of class Katak
     */
    public Katak()
    {
        // initialise instance variables
        posisi = 0;
        skor = 100;
    }

    /**
     * Method accessor memunculkan posisi baru
     *
     * @return  posisi
     */
    public int getPosisi()
    {
        // put your code here
        return this.posisi;
    }

    /**
     * Method mutator mendapat posisi baru
     *
     * @param posisiBaru int
     * @return  posisiBaru
     */
    public void setPosisi(int posisiBaru)
    {
        // put your code here
        this.posisi= posisiBaru;
    }

    /**
     * Method accessor mendapat/ mengembalika nilai skor
     *
     * @return  skor
     */
    public int getSkor()
    {
        // put your code here
        return this.skor;
    }

    /**
     * method mutator set skor katak
     *
     * @param skorBaru int
     * @return  skorBaru
     */
    public void setSkor(int skorBaru)
    {
        // put your code here
        this.skor= skorBaru;
    }

    /**
     * Method untuk loncat dekat 1 langkah kedepan
     *
     * @return  posisi+=1
     */
    public int loncatDekat()
    {
        // put your code here
        return posisi+=1;
    }

    /**
     * Method untuk loncat jauh 2 langkah kedepan
     *
     * @return  posisi+=2 
     */
    public int loncatJauh()
    {
        // put your code here
        return posisi+=2;
    }

    /**
     * method untuk mundur dekat 1 langkah 
     *
     * @return  posisi-=1
     */
    public int mundurDekat()
    {
        // put your code here
        return posisi-=1;
    }

    /**
     * Method untuk muundur jauh 2 langkah 
     *
     * @return  posisi-=2 
     */
    public int mundurJauh()
    {
        // put your code here
        return posisi-=2;
    }
}