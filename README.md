# Kütüphane Yönetim Sistemi 

### Nedir ? 
Basit bir şekilde yayın evi, yazar ve kitap bilgilerinin tutulduğu bir projedir.

Bu projede toplam da 6 adet sayfa bulunmaktadır. Bu sayfalarda belli rollere göre ayrılmış ve ayarlanmıştır. 

Login ve Register sayfaları giriş ve kayıt olmak için kullanılmaktadır.   
Author sayfası, yeni bir yazar kaydı, yazar güncelleme ve silme işlemi için kullanılmaktadır.  
Publisher sayfası, yeni bir yayınevi kaydı, yayınevi güncelleme ve yayınevi işlemi için kullanılmaktadır.  
Book sayfası, yeni bir kitap kaydı, kitap güncelleme ve kitap işlemi için kullanılmaktadır.  
Users sayfası, kayıtlı kullanıcıların bilgilerinin bulunduğu yerdir. Buraya sadece ADMIN erişebilmektedir.  

Mevcut sistem de toplam 2 adet rol bulunmaktadır. **ROLE_ADMIN** ve **ROLE_USER**.   

**ROLE_ADMIN** var olan kayıtlı kullanıcıları görebilir, oluşturma,değiştirme,silme ve okuma yetkilerine sahiptir.  
**ROLE_USER** ise sadece oluşturma ve güncelleme işlemleri yapabilmektedir. Var olan kayıtlı diğer kullanıcıları göremez. Silme işlemini gerçekleştiremez.  

Kayıt olmadan sadece github hesabınızı kullanarak da giriş yapabilmeniz mümkündür. Oauth2 ile gelen kullanıcılar default olarak ROLE_USER sahiptir.

### Nasıl Kurulur ? 

Projeyi kendi makinanız da kurmadan önce bazı gereksinimleri karşılamanız gerekmektedir. Öncelikle proje de lombok kullanılmıştır. Eğer mevcut IDE'nizde bu aktif değilse https://projectlombok.org/ adresinden indirerek kurabilirsiniz. 

Database olarak MySQL kullanıldı fakat makinanız da bulunması gerekmiyor. Hali hazır da yetkileri kısıtlanmış bir kullanıcı oluşturarak kendime ait bir sunucudaki database'ye bağlanmaktadır.

Aşağıdaki komutları terminal ekranında kullanarak kendi bilgisayarınıza indirebilirsiniz.

```
git clone https://github.com/firatkaya1/library-management.git 
```
Projeyi indirdikten sonra projenin bulunduğu klasöre gidin.

```
cd library-management
```
Gerekli dosyaları yükledikten sonra projeyi çalıştırın. Proje https://localhost:8443 portunda açılacaktır.
```
mvn install && mvn spring-boot:run
```
### Kullanılan Teknolojiler

Arayüz tarafında HTML,CSS,JS,Bootstrap ve Thymeleaf kullanılmıştır. Arkaplan da ise Spring Boot, Spring Security, Spring JPA, MySQL kullanılmıştır.

Aşağıda projenin çalıştırıldıktan sonra 1 dakikalık bir kısa videosu bulunmaktadır. Burada Github hesabı kullanılarak giriş yapılmış, Yazar,yayınevi ve kitap eklenmiştir. Kullanılan hesabın sahip olduğu rol ROLE_USER'dir.



























