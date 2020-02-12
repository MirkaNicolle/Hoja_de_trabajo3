public class Numeros implements Comparable {
    private int n;
    public Numeros (int x) {this.n = x;}
    public int getN () {return this.n;}

    @Override
    public int compareTo(Object o) {
        int r = 0;
        int otroN = ((Numeros) o).getN();

        if (this.n == otroN){
            r = 0;
        } if (this.n < otroN){
            r = -1;
        } if(this.n > otroN){
            r = 1;
        }
        return r;
    }

    @Override
    public String toString() {return " " + this.n;}
}
