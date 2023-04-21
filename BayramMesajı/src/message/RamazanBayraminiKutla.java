package message;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class RamazanBayraminiKutla {
    public static void main(String[] args) {
       
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Kullanıcıdan tarih bilgisini al
        String tarihString = JOptionPane.showInputDialog("Lütfen tarihi (GG/AA/YYYY) formatında girin:");

        try {
            // Kullanıcının girdiği tarihi java.util.Date formatına çevir
            Date tarih = dateFormat.parse(tarihString);

            // Ramazan Bayramı'nın başlangıç tarihini ayarla
            Date ramazanBayramiBaslangic = dateFormat.parse("21/04/2023");

            // Tarihin kaçıncı gününde olduğunu hesapla
            Calendar cal = Calendar.getInstance();
            cal.setTime(tarih);
            long diff = cal.getTimeInMillis() - ramazanBayramiBaslangic.getTime();
            long gun = diff / (24 * 60 * 60 * 1000);

            // Girilen tarihin Ramazan Bayramı'na denk gelip gelmediğini kontrol et
            if (gun >= 0 && gun <= 3) {
                JOptionPane.showMessageDialog(null, "Ramazan Bayramınız Kutlu Olsun! Bugün bayramın " + (gun + 1) + ". günü.");
            } else {
                JOptionPane.showMessageDialog(null, "Girilen tarih Ramazan Bayramı'na eşit değil. Bayramın "  + (gun + 1) + ". günündeyiz.");
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Lütfen tarihi doğru formatta girin.");
        }
    }
}
