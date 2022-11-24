# Purpose of the Document

This document will enable you to run through the details of each testcases and how to run it in your local.

### POMLoginTest Class- (Login sayfası testi)

Test1
* Anasayfadan login linkine tıklar. Login ekranında input alanlarına kullanıcı adı ve şifre girişi yapmadan login butonuna tıklar ve ‘e-posta adresinizi ve kullanıcı adınızı girin’ mesajının geldiğini kontrol eder.
* Password linkinin sayfada olduğunu kontrol eder.
* Login sayfasında yanlış password girerek giriş yapılamadığını ve hata mesajı verildiğini kontrol eder.

Test2

* Anasayfadan login linkine tıklar, 
geçerli username ve şifre girişi yaparak login olunabildiğini kontrol eder.

### POMTestClass- (Arama test)

Anasayfadan ‘Otomobil’ linkine tıklar.
Tüm otomobil linkine tıklar,
İlan sayısının 0 dan büyük olduğunu kontrol eder.
Listedeki ilk ilanın ilan başlığı, km ve ücretini alarak ilanın detayına gider ve bu bilgileri eşleyerek doğruluğunu kontrol eder.


### POMNewClassified- (İlan verme testi)

Anasayfadan login linkine tıklayıp login olur,
Bana özel sayfasından yeni ilan vermeye tıklar,
Alışveriş kategorisi seçer,
Input alanı girişlerini yapar, haritadan location işaretler,
Sözleşme checkboxını işaretleyip devam butonuna tıklar, ilan verme ilk adım tamamlanmış olur.
Kategori seçim sayfasında ‘Alt kategori seçimi’ başlığının geldiğini kontrol eder.

Testleri tek tek çalıştırmak isterseniz:
```
mvn surefire:test -Dtest=POMLoginTest
mvn surefire:test -Dtest=POMNewClassifieldTest
mvn surefire:test -Dtest=POMTestClass
```
Tüm testleri çalıştırmak isterseniz:
```
mvn surefire:test -Dtest=POMLoginTest,POMNewClassifieldTest,POMTestClass
```

### Some Notes
Eğitim videolarının tekrar üzerinden geçilip testler POM modele uygun şekilde yazmaya çalışılmıştır.
Testler şuan TB186da çalışmaktadır. TB değişikliği yapmak isterseniz BaseClass içerisinden setCookieTb metodu içinde değişiklik yaparak uygulayabilirsiniz.

Testlerden POMTestClass içinde Try-cache bloğu tanımlayıp error log ve screenshot alma durumunu örneklemeye çalışılmıştır.

BaseClass içinde Webdriver tanımlanması, driverın açılıp kapanması, browser maximize, cookielerin setlenmesi metodlar içinde uygulamaya çalışılmıştır.

