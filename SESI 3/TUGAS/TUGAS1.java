import java.util.Scanner;
import java.util.ArrayList;

class Mahasiswa {
    String nim;
    String nama;
    int nilai;
    String grade;
    String status;

    public Mahasiswa(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
        tentukanGrade();
    }

    private void tentukanGrade() {
        if (nilai >= 80 && nilai <= 100) {
            grade = "A";
            status = "Lulus";
        } else if (nilai >= 70) {
            grade = "B";
            status = "Lulus";
        } else if (nilai >= 60) {
            grade = "C";
            status = "Lulus";
        } else if (nilai >= 50) {
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
}

public class TUGAS1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = input.nextInt();
        input.nextLine(); // membersihkan buffer

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = input.nextLine();
            System.out.print("Nama  : ");
            String nama = input.nextLine();
            System.out.print("Nilai : ");
            int nilai = input.nextInt();
            input.nextLine();

            listMahasiswa.add(new Mahasiswa(nim, nama, nilai));
        }

        // Menampilkan Output Sesuai Layout
        System.out.println("\n========================================");
        double totalNilai = 0;
        int lulus = 0, tidakLulus = 0;
        StringBuilder namaLulus = new StringBuilder();
        StringBuilder namaTidakLulus = new StringBuilder();

        for (Mahasiswa m : listMahasiswa) {
            System.out.println("NIM   : " + m.nim);
            System.out.println("Nama  : " + m.nama);
            System.out.println("Nilai : " + m.nilai);
            System.out.println("Grade : " + m.grade);
            System.out.println("----------------------------------------");
            
            totalNilai += m.nilai;
            if (m.status.equals("Lulus")) {
                lulus++;
                namaLulus.append(m.nama).append(", ");
            } else {
                tidakLulus++;
                namaTidakLulus.append(m.nama).append(", ");
            }
        }

        // Statistik Akhir
        System.out.println("Jumlah Mahasiswa : " + listMahasiswa.size());
        System.out.println("Jumlah Mahasiswa yg Lulus : " + lulus + " yaitu " + formatNama(namaLulus));
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus : " + tidakLulus + " yaitu " + formatNama(namaTidakLulus));
        
        // Contoh tambahan untuk detail per Grade bisa ditambahkan secara manual 
        // atau menggunakan loop filter seperti di atas.
        
        double rataRata = totalNilai / listMahasiswa.size();
        System.out.println("Rata-rata nilai mahasiswa adalah : " + rataRata);
    }

    // Helper untuk merapikan koma di akhir nama
    private static String formatNama(StringBuilder sb) {
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 2);
        }
        return "-";
    }
}