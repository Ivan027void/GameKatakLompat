/**
 * class Kotak untuk diisi koin atau monster
 *
 * @author Ivan chiari
 * @version 1.0
 */
public class Kotak {
    private Koin coin;
    private Monster monsta;

    /**
     * Constructor for objects of class Kotak
     */
    public Kotak() {
    }

    /**
     * method addKoin kedalam kotak
     *
     * @param c Koin
     */
    public void addKoin(Koin c) {
        // put your code here
        this.coin = c;
    }

    /**
     * Method addMonster kedalam kotak
     *
     * @param m Monster
     */
    public void addMonster(Monster m) {
        // put your code here
        this.monsta = m;
    }

    /**
     * Method untuk mendapat koin ke kotak
     * 
     * @return coin kotak Koin
     */
    public Koin getKoin() {
        // put your code here
        return coin;
    }

    /**
     * Method untuk memanggil/ mendapat monster ke kotak
     *
     * @return monsta kotak Monster
     */
    public Monster getMonster() {
        // put your code here
        return monsta;
    }

    /**
     * Method boolean untuk memeriksa isi kotak
     *
     * @return coin != null
     */
    public boolean isThereKoin() {
        return coin != null;
    }

    /**
     * Method boolean untuk memeriksa isi kotak
     *
     * @return monsta != null
     */
    public boolean isThereMonster() {
        return monsta != null;
    }

}
