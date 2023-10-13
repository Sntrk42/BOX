public class Main {
    public static void main(String[] args) {
        Fighter marc = new Fighter("Marc" , 15 , 100, 90, 0);
        Fighter alex = new Fighter("Alex" , 10 , 95, 100, 0);

        // Hangi dövüşçünün ilk dövüşe başlayacağını rastgele belirleme
        boolean marcFirst = Math.random() < 0.5;

        Ring r = new Ring(marc, alex, 90, 100, marcFirst);

        r.run();
    }
}