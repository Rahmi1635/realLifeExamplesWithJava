# realLifeExamplesWithJava
📰 Haber Yönetim Sistemi – Java Console App

Bu proje, Java kullanılarak geliştirilmiş bir Haber Yönetim Sistemi uygulamasıdır. Konsol üzerinden haber ekleme, silme, güncelleme, arama ve haber önerme işlemlerini yapmanıza olanak sağlar.

Uygulama, özellikle Supplier, Consumer, Comparator, Stream API, Filter, Sort, Lambda Expressions gibi modern Java özelliklerini öğrenmek ve pratik yapmak amacıyla geliştirilmiştir.

🚀 Özellikler
✔ 1. Haber Ekleme

Kullanıcı yeni bir haber ekleyebilir. Başlık, içerik, yazar, kategori ve zaman bilgisi alınır.

✔ 2. Haber Güncelleme

ID’ye göre haber bulunur ve başlık, içerik, yazar ve kategori güncellenebilir.

✔ 3. Haber Silme

Kullanıcının girdiği ID’ye göre ilgili haber listeden kaldırılır.

✔ 4. Haber Arama

Kategori ve yazar bilgisine göre filtreleme yapılır.
Sonuçlar tarihe göre sıralanarak kullanıcıya gösterilir.

✔ 5. Haber Öneri Sistemi

Girilen anahtar kelimeye göre haber araması yapılır.
Arama sonucunda bulunan ilk haberin kategorisine göre ilgili diğer haberler önerilir.

✔ 6. Tüm Haberleri Listeleme

Eklenen tüm haberler Consumer kullanılarak formatlı şekilde görüntülenir.

🛠 Kullanılan Java Yapıları

Bu proje, Java’nın modern fonksiyonel programlama yapılarından birçoğunu içerir:

Kullanım	Açıklama
Supplier : İlk haber listesini oluşturmak için kullanıldı.
Consumer :	Haberlerin ekrana basılma şeklini yönetiyor.
Comparator :	Haberleri tarihe göre sıralamak için kullanıldı.
Streams API : Filtreleme, sıralama, listeleme işlemleri için kullanıldı.
Lambda Expressions :	Kodun daha okunabilir ve kısa olması sağlandı.

📁 Proje Yapısı

src/
 ├── Main.java        → İşlemlerin yönetildiği ana sınıf
 ├── News.java        → Haber nesnesi


📌 Kullanım

Program çalıştığında kullanıcıya aşağıdaki menü sunulur:

1 - Haber Ekle
2 - Güncelle
3 - Sil
4 - Ara
5 - Haber Önerileri
6 - Tüm Haberler


Her seçeneğin ardından ilgili işlem yapılır ve ekrana sonuçlar yazdırılır.

🎯 Amaç

Bu proje;  fonksiyonel programlama yapıları, koleksiyonlar, lambda ifadeleri ve Stream API'nin gerçek bir senaryoda nasıl kullanılacağını öğrenmek için geliştirilmiştir.
