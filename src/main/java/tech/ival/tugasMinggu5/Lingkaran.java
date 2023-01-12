package tech.ival.tugasMinggu5;

public class Lingkaran {

    public int r;

    public Lingkaran(int r) {
        this.r = r;
    }

    public int luas(){
        return (int) (Math.PI*r*r);
    }

    public int keliling(){
        return (int) (2*Math.PI*r);
    }
}
