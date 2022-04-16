**SORU:** <br>
- Layout dizini içinde xml dosyalarımız için kullandığımız namespace nedir ? <br>
-	Niçin kullanılmaktadır ?  <br>
-	Nasıl kullanılmalıdır ? <br>
-	Bir adet Tools (tools namespace) attribute kullanımını gösterir misiniz ? <br>
**CEVAP:** <br>
-Namespace hangi activity de ise onu Android studiomuza tanıtırız. <br>
-Tools namespaceler xml işlevleri için güçlü özellikleri vardır. <br>
-Android studioda tools’lar lokaldır. Apk dosyasını etkilemez. <br>
-XML dosyasın tools, uygulamanın nasıl göründüğünü build edilmeden görebilmemize olanak sağlar. Uygulama build edildiğinde; android studiodaki toolslar lokal olduğu için Apk etkilenmez <br>
```xmlns:tools=http://schemas.android.com/tools ```<br>
```tools:background="@color/<some-color>" ```<br>
