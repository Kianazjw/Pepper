#  SUMMARY

##  getApplication()、getApplicationContext()、getBaseContext()、
MainActivity.this、this、getContext()之间的区别
https://blog.csdn.net/guolindonggld/article/details/24243059
this是你当前对象的引用，在你的例子中你肯定在内部类ClickEvent里面实现intent，
他指向的是ClickEvent，而不是你要传入的Activity。
Activity.this指向你所填写的Activity名字的一个实例，也是引用。

##  fragment面页：
context = getActivity().getApplicationContext();

##  TabLayout+ViewPager+Fragment实现导航栏
http://www.jianshu.com/p/ce1d060573ba  

##  Selector 点击变图标什么的，先考虑用这个
http://www.jianshu.com/p/939a6d5760d8  
http://www.jianshu.com/p/342bb75028e2  

##  mipmap和drawable文件夹的区别  
加载图片卡顿是=时候，把图片放在mipmap文件夹下！！！  
mipmap文件夹下，仅仅建议放启动图标/app launcher icons，
也就是应用安装后，会显示在桌面的那个图标。而其他的图片资源等，
还是按照以前方式，放在drawable文件夹下。

##  Gradle
Gradle 是 Google 官方推荐的构建 Android 程序的工具，使用 Android Studio 
进行开发的时候，它会自动在新建的项目中包含一个自带的命令行工具 gradlew。
我们推荐开发者使用这个自带的命令行工具，这是因为 Gradle 存在版本兼容的问题，
很多开发者即使正确配置了 Gradle 脚本，但由于使用了最新版本或不兼容的 Gradle 
版本而仍然无法成功加载依赖包

##  shape 

##  抖动的EditText
http://blog.csdn.net/qianqianyihao/article/details/41281711  

##  Button水波纹点击效果(Ripple Effect)
http://www.cnblogs.com/wingyip/p/4548093.html  

##  一个有三个textview无法对齐，后来在文字后面加空格曲线救国... 

##  推荐使用12sp、14sp、18sp、22sp作为字体设置的大小，不推荐使用奇数和小数，  
容易造成精度的丢失问题；小于12sp的字体会太小导致用户看不清  


##  修改5.0中Datepicker的背景颜色以及样式
http://www.itwendao.com/article/detail/273792.html
http://www.jianshu.com/p/cc8b4187d5d8

##  自定义EditText光标颜色
android:textCursorDrawable="@drawable/edittext_cursor"

##  ImageView
android:scaleType="fitXY"

##  接口回调机制

##  设置TextView最大显示字数为8
android:maxEms="8"
android:maxLines="1"
android:ellipsize="end"

##  屏幕适配
屏幕尺寸指屏幕的对角线的长度，单位是英寸，1英寸=2.54厘米  

屏幕分辨率是指在横纵向上的像素点数，单位是px，1px=1个像素点。 
在Android中，规定以160dpi（即屏幕分辨率为320x480）为基准：1dp=1px 
一般以纵向像素*横向像素，如1960*1080。  

屏幕像素密度是指每英寸上的像素点数，单位是dpi，即“dot per inch”的缩写。  
屏幕像素密度与屏幕尺寸和屏幕分辨率有关，在单一变化条件下，屏幕尺寸越小，  
分辨率越高，像素密度越大，反之越小。

dip和dp是一个意思，都是Density Independent Pixels的缩写，即密度无关像素，  
上面我们说过，dpi是屏幕像素密度，假如一英寸里面有160个像素，这个屏幕的   
像素密度就是160dpi，那么在这种情况下，dp和px如何换算呢？在Android中，  
规定以160dpi为基准，1dip=1px，如果密度是320dpi，则1dip=2px，以此类推。 

如果使用 “wrap_content” 和 “match_parent” 尺寸值而不是硬编码的尺寸，  
视图就会相应地仅使用自身所需的空间或展开以填满可用空间。此方法可让  
布局正确适应各种屏幕尺寸和屏幕方向。 

720X1080  xhdpi
1080X1920 xxhdpi

