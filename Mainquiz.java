package week4;
import java.util.Scanner;

public class Mainquiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz();

        System.out.println("Selamat datang di kuis pengetahuan umum!");
        System.out.println("Jawab semua pertanyaan dengan memilih nomor (1-4)\n");

        // Looping untuk menampilkan pertanyaan dan menerima jawaban
        for (int i = 0; i < quiz.getQuestionCount(); i++) {
            quiz.displayQuestion(i);
            System.out.print("Jawaban Anda: ");
            
            int userAnswer;
            while (true) {
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt();
                    if (userAnswer >= 1 && userAnswer <= 4) {
                        break; 
                    }
                } else {
                    scanner.next();
                }
                System.out.print("Masukkan angka antara 1-4: ");
            }

            quiz.checkAnswer(i, userAnswer);
        }

        // Menampilkan skor akhir
        int finalScore = quiz.getScore();
        System.out.println("\nSkor akhir Anda: " + finalScore);

        // Pesan berdasarkan skor
        if (finalScore == 30) {
            System.out.println("🎉 Luar biasa! Anda menjawab semua pertanyaan dengan benar! 🎉");
        } else if (finalScore >= 20) {
            System.out.println("👍 Bagus! Anda cukup memahami materi.");
        } else if (finalScore >= 10) {
            System.out.println("😊 Lumayan, tapi masih bisa ditingkatkan.");
        } else {
            System.out.println("😞 Anda perlu belajar lebih banyak!");
        }

        
        scanner.close();
    } 
}