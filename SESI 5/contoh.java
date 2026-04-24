class Tabungan {
    private double saldo;

    void tambah(double jumlah) {
        saldo += jumlah;
    }

    void ambil(double jumlah) {
        saldo -= jumlah;
    }

    void infoSaldo() {
        System.out.println("Saldo :" + saldo);
    }
}

public class contoh {
    public static void main(String[] args) {
        Tabungan yulhan = new Tabungan();
        //yulhan.saldo = -100000; //bisa diubah langsung
        yulhan.tambah(100000); //diubah melalui metods setter
        yulhan.ambil(50000);
        yulhan.infoSaldo();
    }
}