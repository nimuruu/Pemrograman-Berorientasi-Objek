import java.util.Scanner;
import java.util.ArrayList;

class Mahasiswa {
    String nim;
    String nama;
    int nilai;

    public Mahasiswa(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
    }
}

class HitungNilai extends Mahasiswa {
    String grade;
    String status;

    public HitungNilai(String nim, String nama, int nilai) {
        super(nim, nama, nilai);
        tentukanGrade();
    }

    private void tentukanGrade() {
        if (nilai >= 80 && nilai <= 100) {
            grade = "A";
            status = "Lulus";
        } else if (nilai >= 70 && nilai <= 79) {
            grade = "B";
            status = "Lulus";
        } else if (nilai >= 60 && nilai <= 69) {
            grade = "C";
            status = "Lulus";
        } else if (nilai >= 50 && nilai <= 59) {
            grade = "D";
            status = "Tidak Lulus";
        } else if (nilai >= 0 && nilai < 50) {
            grade = "E";
            status = "Tidak Lulus";
        } else {
            grade = "Salah";
            status = "Input nilai anda salah";
        }
    }

    public void tampilkanData() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Nilai : " + nilai);
        System.out.println("Grade : " + grade);
        System.out.println("------------------------------------");
    }
}

public class TUGAS1_REF {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<HitungNilai> daftarMhs = new ArrayList<>();
        
        System.out.print("Masukkan Jumlah Mahasiswa: ");
        int jumlah = input.nextInt();

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData Ke-" + (i + 1));
            System.out.print("NIM   : "); String nim = input.next();
            System.out.print("Nama  : "); String nama = input.next();
            System.out.print("Nilai : "); int nilai = input.nextInt();
            
            daftarMhs.add(new HitungNilai(nim, nama, nilai));
        }

        System.out.println("\n========== HASIL OUTPUT ==========");
        
        int totalNilai = 0;
        int lulus = 0, tidakLulus = 0;
        int gradeA = 0, gradeB = 0, gradeD = 0;
        String namaLulus = "", namaTidakLulus = "", namaA = "", namaB = "", namaD = "";

        for (HitungNilai mhs : daftarMhs) {
            mhs.tampilkanData();
            totalNilai += mhs.nilai;

            if (mhs.status.equals("Lulus")) {
                lulus++;
                namaLulus += mhs.nama + ", ";
            } else {
                tidakLulus++;
                namaTidakLulus += mhs.nama + ", ";
            }

            if (mhs.grade.equals("A")) { gradeA++; namaA += mhs.nama + ", "; }
            else if (mhs.grade.equals("B")) { gradeB++; namaB += mhs.nama + ", "; }
            else if (mhs.grade.equals("D")) { gradeD++; namaD += mhs.nama + ", "; }
        }

        double rataRata = (double) totalNilai / jumlah;
        
        System.out.println("Jumlah Mahasiswa : " + jumlah);
        System.out.println("Jumlah Mahasiswa yg Lulus : " + lulus + " yaitu " + namaLulus);
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus : " + tidakLulus + " yaitu " + namaTidakLulus);
        System.out.println("Jumlah Mahasiswa dengan Nilai A = " + gradeA + " yaitu " + namaA);
        System.out.println("Jumlah Mahasiswa dengan Nilai B = " + gradeB + " yaitu " + namaB);
        System.out.println("Jumlah Mahasiswa dengan Nilai D = " + gradeD + " yaitu " + namaD);
        System.out.println("Rata-rata nilai mahasiswa adalah : " + rataRata);
    }
}