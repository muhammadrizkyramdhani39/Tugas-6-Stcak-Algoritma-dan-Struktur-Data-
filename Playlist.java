import java.util.*;

public class Playlist {
    private static Stack<String> playlist = new Stack<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            System.out.println("-----------------------------------------------\n - Tugas 6 Stack - M.Rizky Ramdhani (20220040048) -");
            System.out.println("=== Program Pengaturan Playlist Lagu === \nMenu:");
            System.out.println("1. Tampilkan Data Playlist");
            System.out.println("2. Tambah Data Playlist");
            System.out.println("3. Hapus Data Playlist");
            System.out.println("4. Tambah Data Playlist di Urutan Tertentu");
            System.out.println("5. Hapus Data Playlist di Urutan Tertentu");
            System.out.println("6. Hapus Semua Playlist");
            System.out.println("7. Keluar \n----------------------------------------------");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayPlaylist();
                    break;
                case 2:
                    addSong();
                    break;
                case 3:
                    removeSong();
                    break;
                case 4:
                    addSongAtPosition();
                    break;
                case 5:
                    removeSongAtPosition();
                    break;
                case 6:
                    clearPlaylist();
                    break;
                case 7:
                    quit = true;
                    System.out.println("Terima kasih telah menggunakan Program ini");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
        scanner.close();
    }

    private static void displayPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist kosong.");
            return;
        }
        System.out.println("Daftar Lagu di Playlist:");
        for (String song : playlist) {
            System.out.println(song);
        }
    }

    private static void addSong() {
        System.out.print("Masukkan judul lagu: ");
        String song = scanner.nextLine();
        playlist.push(song);
        System.out.println("Lagu berhasil ditambahkan ke playlist.");
    }

    private static void removeSong() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist kosong.");
            return;
        }
        String song = playlist.pop();
        System.out.println("Lagu " + song + " telah dihapus dari playlist.");
    }

    private static void addSongAtPosition() {
        System.out.print("Masukkan judul lagu: ");
        String song = scanner.nextLine();
        System.out.print("Masukkan posisi untuk menambahkan lagu: ");
        int position = scanner.nextInt();
        scanner.nextLine();
        if (position < 1 || position > playlist.size() + 1) {
            System.out.println("Posisi tidak valid.");
            return;
        }
        playlist.add(position - 1, song);
        System.out.println("Lagu berhasil ditambahkan ke playlist.");
    }

    private static void removeSongAtPosition() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist kosong.");
            return;
        }
        System.out.print("Masukkan posisi untuk menghapus lagu: ");
        int position = scanner.nextInt();
        scanner.nextLine();
        if (position < 1 || position > playlist.size()) {
            System.out.println("Posisi tidak valid.");
            return;
        }
        String song = playlist.remove(position - 1);
        System.out.println("Lagu " + song + " telah dihapus dari playlist.");
    }

    private static void clearPlaylist() {
        playlist.clear();
        System.out.println("Playlist telah dikosongkan.");
    }
}
