import javax.swing.JOptionPane;

public class TUGAS2 {
    public static void main(String[] args) {
        // Mengambil input dari user
        String pelajaran = JOptionPane.showInputDialog(null, "Anda sedang belajar apa?");
        
        // Menampilkan pesan jika user mengisi input
        if (pelajaran != null) {
            JOptionPane.showMessageDialog(null, "Belajar " + pelajaran + " sangat mudah");
        }
    }
}