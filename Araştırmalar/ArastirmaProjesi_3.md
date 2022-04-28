## Araştırma Projesi 3 <br>

**Font family dosyası nasıl oluşturulup kullanıyoruz?** <br> 
**Neden belirttiğiniz şekilde kullanımı tercih ediyoruz?** <br> 
**P.S. [Bu linkten](https://developer.android.com/guide/topics/ui/look-and-feel/fonts-in-xml "android resource") faydalanarak font family projenizde deneyebilirsiniz.** <br> 
 
**Cevap:** <br>
-Projede kullanılacak olan fontta google fontu seçtiysek ilerleyen zamanlarda google bu fontu kaldırabilir. Bu sebeple fontun projeye gömülmesi önemlidir.<br>
-Font dosyasıyla kendimize ait bir font XML dosyası oluşturulmuş olur.<br> <br>
#### Font dosyası oluşturma <br>
-andorid studio klosörü/sağ tık/new/android resource directory/resource type: Font/ name:font / ok <br>
-font directory/sağ tık/new/ font resource file/ name:my_font /ok <br> <br>

```
<font-family
    xmlns:android="http://schemas.android.com/apk/res/android">
   <font
        android:font="@font/acme"
        android:fontStyle="italic"
        android:fontWeight="450"/>

</font-family>
 ```
*style.xml dosyası*  <br>
 ```
 <?xml version="1.0" encoding="utf-8"?>
<resources>
    <style name="yazi">
        <item name="android:fontFamily">@font/my_font</item>
        <item name="android:textSize">24sp</item>
         <item name="android:textStyle">italic</item>
    </style>
 </resources>
 ```
 *activity.main dosyası <br>
  ```
     <TextView
        android:id="@+id/textView"
        style="@style/yazi"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello word"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
 ```
