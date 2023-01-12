package tech.ival.tugasMinggu5;

public class Segitiga {
    public int a;
    public int t;
    public int s1;
    public int s2;

    public Segitiga(int a, int t, int s1, int s2) {
        this.a = a;
        this.t = t;
        this.s1 = s1;
        this.s2 = s2;
    }

    public int luas(){
        return a*t/2;
    }

    public int keliling(){
        return s1+s2+a;
    }

}
