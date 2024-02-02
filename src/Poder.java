import java.util.Arrays;

class Poder implements Comparable<Poder> {
    private int power;
    private static int powers[] = new int[10];
    private int number;

    public Poder(int number) {
        this.number = number;
    }

    public int getPower() {
        return this.power;
    }

    private int getNumber() {
        return this.number;
    }

    public int compareTo(Poder c) {
        if (this.power < c.getPower()) {
            return -1;
        } else if (this.power > c.getPower()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void darPoder() {
        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * (100 - 1) + 1);
            powers[i] = num;
        }
    }

    public static void main(String[] args) {
        Poder[] poderes = new Poder[10];

        darPoder();

        for (int i = 0; i < 10; i++) {
            poderes[i] = new Poder(i + 1);
            poderes[i].power = powers[i];
        }

        System.out.println("Antes de ordenar:\n");
        for (Poder p : poderes) {
            System.out.println("El cromo " + p.getNumber() + " tiene poder " + p.getPower());
        }

        Arrays.sort(poderes);

        System.out.println("\nDespués de ordenar:\n");
        for (Poder p : poderes) {
            System.out.println("El cromo " + p.getNumber() + " tiene poder " + p.getPower());
        }
    }
}
