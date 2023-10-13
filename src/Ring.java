public class Ring {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;
    boolean marcFirst;



    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight, boolean marcfirst) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;

        // Hangi dövüşçünün ilk dövüşe başlayacağını belirleme
        if (marcFirst) {
            f1.setFirst(true);
        } else {
            f2.setFirst(true);
        }
    }

    public void run() {

        if (checkWeight()) {
            while (f1.health > 0 && f2.health > 0) {
                System.out.println("======== YENİ ROUND ===========");
                f2.health = f1.hit(f2);
                if (isWin()){
                    break;
                }
                f1.health = f2.hit(f1);
                if (isWin()){
                    break;
                }
                printScore();
            }

        } else {
            System.out.println("Sporcuların ağırlıkları uyuşmuyor.");
        }

        if (f1.isFirst) {
            while (f1.health > 0 && f2.health > 0) {
                // Dövüş sıralarını burada ayarlayın
                System.out.println("======== YENİ ROUND ===========");
                f2.health = f1.hit(f2);
                if (isWin()) {
                    break;
                }
                f1.health = f2.hit(f1);
                if (isWin()) {
                    break;
                }
                printScore();
            }
        } else {
            while (f2.health > 0 && f1.health > 0) {
                // Dövüş sıralarını burada ayarlayın
                System.out.println("======== YENİ ROUND ===========");
                f1.health = f2.hit(f1);
                if (isWin()) {
                    break;
                }
                f2.health = f1.hit(f2);
                if (isWin()) {
                    break;
                }
                printScore();
            }
        }



    }

    public boolean checkWeight() {
        return (f1.weight >= minWeight && f1.weight <= maxWeight) && (f2.weight >= minWeight && f2.weight <= maxWeight);
    }

    public boolean isWin() {
        if (f1.health == 0) {
            System.out.println("Maçı Kazanan : " + f2.name);
            return true;
        } else if (f2.health == 0){
            System.out.println("Maçı Kazanan : " + f2.name);
            return true;
        }

        return false;
    }


    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " Kalan Can \t:" + f1.health);
        System.out.println(f2.name + " Kalan Can \t:" + f2.health);
    }
}
