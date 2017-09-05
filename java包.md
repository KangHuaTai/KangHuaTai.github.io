# Java包
包：定义包用package关键字。 

    1：对类文件进行分类管理。 
    2：给类文件提供多层名称空间。
如果生成的包不在当前目录下，需要最好执行classpath，将包所在父目录定义到classpath变量中即可。 

一般在定义包名时，因为包的出现是为了区分重名的类。所以包名要尽量唯一。怎么保证唯一性呢？可以使用url域名来进行包名称的定义。  package pack;//定义了一个包，名称为pack。

注意：包名的写法规范：所有字母都小写。
> //package cn.itcast.pack.demo; 

类的全名称是 包名.类名      编译命令：javac –d 位置（.当前路径） java源文件 （就可以自动生成包）

包是一种封装形式，用于封装类，想要被包以外的程序访问，该类必须public； 类中的成员，如果被包以外访问，也必须public；

包与包之间访问可以使用的权限有两种：
1：public 
2：protected：只能是不同包中的子类可以使用的权限。 
总结java中的四种权限： 

    范围         public      protected   default  private  
    同一个类中       ok        ok         ok          ok 
    同一包中         ok        ok         ok 
    子类             ok  
    不同包中         ok 
Import - 导入：类名称变长，写起来很麻烦。为了简化，使用了一个关键字：import，可以使用这个关键字导入指定包中的类。记住：实际开发时,到的哪个类就导入哪个类，不建议使用

> import packa.*;//这个仅仅是导入了packa当前目录下的所有的类。不包含子包。 
> 
>import packa.abc.*;//导入了packa包中的子包abc下的当前的所有类。

常见的软件包:

    java.lang:language java的核心包，Object System  String Throwable jdk1.2版本后，该包中的类自动被导入。
    java.awt:定义的都是用于java图形界面开发的对象。
    javax.swing:提供所有的windows桌面应用程序包括的控件,比如：Frame , Dialog, Table, List 等等,就是java的图形界面库。
    java.net:用于java网络编程方面的对象都在该包中。 
    java.io:input  output 用于操作设备上数据的对象都在该包中。比如：读取硬盘数据，往硬盘写入数据。
    java.util:java的工具包，时间对象，集合框架。
    java.applet:application+let 客户端java小程序。server+let  -->  servlet 服务端java小程序。
    