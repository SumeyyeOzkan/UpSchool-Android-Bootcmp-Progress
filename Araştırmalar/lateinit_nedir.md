**SORU:** <br>
-Lateinit kullanımından bahseder misiniz ? <br>
-Lateinit niçin kullanıyoruz ? <br>
-Örnek kullanım gösterir misiniz ? <br> <br>
**CEVAP:** <br>
- Lateinit var olan değişkenlerde kullanılır. <br>
-	Kod daha güvenlidir <br>
-	Başlatıcının bir kez çağırıldığını garanti eder <br>
-	Lateinit isInitialized() özelliğinin başlatılıp başlatılmadığını kontrol eder. Kotlin 1.2’den itibaren property::isInitialized kullanılabilir. <br>

``` val diceImage:ImageView=findViewById(R.id.dice_image) ```

Tanımlamayı böyle yapmak yerine lateinit ile en başta yapıyoruz. <br>
``` Private lateinit var imageView: imageView ``` <br>
``` Private lateinit var button: Button ``` <br>
``` Private lateinit var textView: textView ``` <br>
Şeklinde yapıyoruz. <br>
