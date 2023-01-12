package tech.ival.tugasMinggu5;

public class TugasMinggu5 {

    public static void main(String[] args) {

        Persegi persegi = new Persegi(5);
        System.out.println("Luas persegi: "+ persegi.luas());
        System.out.println("Keliling persegi: "+persegi.keliling());
        System.out.println();

        Segitiga segitiga = new Segitiga(10,7,8,9);
        System.out.println("Luas Segitiga: "+ segitiga.luas());
        System.out.println("Keliling Segitiga: "+ segitiga.keliling());
        System.out.println();

        PersegiPanjang persegiPanjang = new PersegiPanjang(10,5);
        System.out.println("Luas persegi panjang: "+ persegiPanjang.luas());
        System.out.println("Keliling persegi panjang: "+ persegiPanjang.keliling());
        System.out.println();

        Lingkaran lingkaran = new Lingkaran(7);
        System.out.println("Luas Lingkaran: "+ lingkaran.luas());
        System.out.println("Keliling Lingkaran: "+ lingkaran.keliling());
        System.out.println();

    }
}
