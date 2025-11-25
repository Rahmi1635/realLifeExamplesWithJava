import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    static List<News> currentNews=new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

        //Supplier

        Supplier<List<News>> news=()->List.of(
                new News("Covid-19 Aşısı Gelişmeleri", "Yeni varyanta karşı etkili...", "Sağlık Bakanlığı", "Sağlık", LocalDate.now()),
                new News("Yapay Zeka Sınır Tanımıyor", "GPT-5 duyuruldu!", "OpenAI", "Bilim ve Teknoloji", LocalDate.now()),
                new News("EBA Sistemi Geliştirildi", "Öğrencilere özel yeni modül!", "MEB", "Eğitim", LocalDate.now()),
                new News("Tansiyon İlacı Geri Çekildi", "Yan etkiler nedeniyle toplatıldı.", "HaberTürk", "Sağlık", LocalDate.now()),
                new News("MEB'den Yaz Tatili Açıklaması", "Tatil süresi değişti!", "MEB", "Eğitim", LocalDate.now())
        );

        currentNews.addAll(news.get());

        // Consumer

        Consumer<News> changeNews=newsPart->{
            System.out.println("[ ID : "+newsPart.getId() +"]"+" - "+newsPart.getTitle() );
            System.out.println(newsPart.getAuthor()+" - "+newsPart.getTimeStamp());
            System.out.println(newsPart.getContent());
            System.out.println("\n************************************************\n");
        };

        //



        Comparator<News> sortByDate=(news1,news2)-> news2.getTimeStamp().compareTo(news1.getTimeStamp());

        System.out.println("1 - Haber Ekle");
        System.out.println("2 - Güncelle");
        System.out.println("3 - Sil");
        System.out.println("4 - Ara");
        System.out.println("5 - Haber Önerileri");
        System.out.println("6 - Tüm Haberler");


        System.out.print("Lütfen Yapacağınız İşlemi Seçiniz : ");

        int chose=scan.nextInt();


        switch(chose)
        {
            case 1: News haberler=addNews("Son Dakika","Ekrem İmamoğlu için 7 yıl 4 aya kadar hapis istendi",
                    "Sputnik Türkiye","Türkiye",LocalDate.now());

                currentNews.add(haberler);

                System.out.println("✅ Haber eklendi!");

                System.out.println("\nTüm Haberler\n");

                currentNews.forEach(changeNews);

                break;
            case 2:
                updateNews(currentNews);

                System.out.println("\nHaber Başarıyla Güncellendi\n");

                System.out.println("\nTüm Haberler\n");

                currentNews.forEach(changeNews);
                break;
            case 3:
                deleteNews(currentNews);
                System.out.println("Haber Başarıyla Silindi");

                System.out.println("Tüm Haberler");

                currentNews.forEach(changeNews);
                break;
            case 4:
                System.out.println("Lütfen Haber Kategorisi Giriniz : ");
                String category=scan.next();

                System.out.println("Yazar Giriniz : ");
                String authory=scan.next();

                // Filtreleme İşlemi

                List<News> filteredNews=news.get()
                        .stream()
                        .filter(categorySelect->categorySelect.getCategory().equalsIgnoreCase(category))
                        .filter(author->author.getAuthor().equalsIgnoreCase(authory))
                        .sorted(sortByDate).toList();

                // Filtreleme sonucunda veriyi yoklama

                if(filteredNews.isEmpty())
                {
                    System.out.println("Bu Kategoriye ait Haber Bulunamadı:((");
                }
                else{
                    filteredNews.forEach(changeNews);
                }
                break;
            case 5:
                System.out.println("\nİlginizi Çekebilecek Haberler");

                Scanner input = new Scanner(System.in);

                System.out.print("🔍 Anahtar kelime girin: ");
                String keyword = input.nextLine();

                aramaVeOneri(keyword, currentNews, changeNews);
                break;
            case 6 :
                System.out.println("\nTüm Haberler\n");
                currentNews.forEach(changeNews);
        }


    }

    public static News  addNews(String title,String content,String author2,String categories,LocalDate timeStamp)
    {
        return new News(title,content,author2,categories,timeStamp);
    }

    public static void  deleteNews(List<News> news)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Lütfen Silmek İstediğiniz Haberin Id sini Giriniz : ");
        int id=scan.nextInt();
        scan.nextLine();
        news.removeIf(n->n.getId()==id);
        System.out.printf("%d. id li haber silindi",id);
    }
    public static void  updateNews(List<News> newList)
    {
        Scanner scan=new Scanner(System.in);
        System.out.print("Lütfen Güncellemek İstediğiniz Haberin Id sini Giriniz : ");
        int id=scan.nextInt();
        scan.nextLine();

        News foundNews=null;

        for(News news:newList)
        {
            if(news.getId()==id)
            {
                foundNews=news;
                break;
            }
        }
        if(foundNews==null)
        {
            System.out.println("Böyle bir ID Bulunamadı!!!");
            return;
        }

        System.out.print("Yeni Başlık: ");
        String newTitle = scan.nextLine();

        System.out.print("Yeni İçerik: ");
        String newContent = scan.nextLine();

        System.out.print("Yeni Yazar: ");
        String newAuthor = scan.nextLine();

        System.out.print("Yeni Kategori: ");
        String newCategory = scan.nextLine();

        foundNews.setTitle(newTitle);
        foundNews.setContent(newContent);
        foundNews.setAuthor(newAuthor);
        foundNews.setCategory(newCategory);
        foundNews.setTimeStamp(LocalDate.now()); // güncel tarih

        System.out.println("✅ Haber başarıyla güncellendi!");

    }

    public static void aramaVeOneri(String keyword,List<News> newList,Consumer<News> displayConsumer)
    {
        List<News> results=newList.stream()
                .filter(n->n.getTitle().toLowerCase().contains(keyword.toLowerCase())||
                        n.getContent().toLowerCase().contains(keyword.toLowerCase())||
                        n.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
                .toList();

        if(results.isEmpty())
        {
            System.out.println("Bu anahtar kelimeye ait sonuç bulunamadı!! ");
        }

        else{
            System.out.println("Arama Sonuçları : ");
            results.forEach(displayConsumer);

            // Öneri Kısmı :

            String suggestedCategory=results.get(0).getCategory();
            System.out.println("İlginizi Çekebilecek Diğer Haberler : "+suggestedCategory);

            newList.stream()
                    .filter(n->n.getCategory().equalsIgnoreCase(suggestedCategory))
                    .filter(n->!results.contains(n))
                    .forEach(displayConsumer);
        }

    }
}