package tech.ival.tugasMinggu5;

public class PersegiPanjang {

    int p;
    int l;

    public PersegiPanjang(int p, int l) {
        this.p = p;
        this.l = l;
    }

    public int luas(){
        return p*l;
    }

    public int keliling(){
        return (2*p)+(2*l);
    }
}
