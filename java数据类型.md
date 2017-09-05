### 一、数据类型

Java中主要有8中基本数据类型，分别是byte,short,int,long,char,boolean,float,double，具体如下：

1、boolean：数据值只有true或false，适用于逻辑计算。

2、char：char型（字符型）数据在内存中占用2个字节。char型数据用来表示通常意义上的字符，每个字符占2个字节，Java字符采用Unicode编码，它的前128字节编码与ASCII兼容字符的存储范围在\u0000~\uFFFF，在定义字符型的数据时候要注意加' '，比如 '1'表示字符'1'而不是数值1，

3、byte：byte型（字节型）数据在内存中占用1个字节，表示的存储数据范围为：-128~127。

4、short：short型（短整型）数据在内存中占用2个字节。

5、int：int型（整型）数据在内存中占用4个字节。

6、long：long型（长整型）数据在内存中占用8个字节。

7、float：float型（单精度浮点型）数据在内存中占用4个字节。（float精度为7-8位）

8、double：double型（双精度浮点型）数据在内存中占用8个字节。

Java中所有的基本数据类型都有固定的存储范围和所占内存空间的大小，而不受具体操作系统的影响，来保证Java程序的可移植性。整形数据默认为int数据类型，浮点型默认为double数据类型，如果要表示long型数据或float型数据，要在相应的数值后面加上l、L或f、F，否则会出现编译问题。

在其他语言中如C语言中，字符型数据和整型数据是可以相互转换的，都是以ASCII码来存储，可以将字符型数据当整型数据来看待。

### 二、基本数据类型间的转换

1、boolean类型不能转换成任何其他数据类型。

2、自动类型转换：容量小的数据类型可以自动转换成容量大的数据类型，如byte-short-int-long-float-double。byte、short、int不会互相转换，他们三者在计算时会转换成int类型。
例：int a=257;byte
b=(byte)a;在java中，int类型占4个字节，byte占一个字节，故int类型转化为byte类型会出现位丢失情况，即将int的低4位作为byte类型的值。int型变量的值为257，对应的二进制是100000001，后8位是00000001，第一个0表示符号位，表示正数，所以变量b的值为1。

【备注：在计算机中，存储数据是通过内存地址来区分不同数据的，内存地址用十六进制数表示。在计算机存储单元中，一个ASCII码值占一个字节（8个二进制位），其中最高位符号位。事实上，计算机内的二进制数值是以补码形式表示的，正数的补码和原码的形式相同，负数的补码是将该数的绝对值的二进制形式，按位取反再加一。】

int a=128;byte b=(byte)a;这时b的值是-128。因为变量a对应的二进制是10000000，对应第一位符号位是1，则a是负数，其负数的补码仍是10000000，故b的值是-128。

3、强制类型转换：容量大的数据类型转换成容量小的数据类型时，要加上强制转换符，但这样有可能会造成精度降低或者数据溢出，要小心。
### 三、对象包装器

Java为了能将基本类型（primitive type）视为对象来处理，并能连接相关的方法，Java为每个节本类型都提供了相应的包装类，这样便能将基本类型转化为对象来处理。其对应关系表如下所示：

    基本数据类型	        包装类
    byte（字节）	        java.lang.Byte
    char（字符）	        java.lang.Character
    short（短整型）	        java.lang.Short
    int（整型）	        java.lang.Integer
    long（长整型）	        java.lang.Long
    float（浮点型）	        java.lang.Float
    double（双精度）	        java.lang.Double
    boolean（布尔型）	java.lang.Boolean
包装器类的使用：

    专门用来包裹（Wrap）基本类型的类叫包装类，也叫包装器，如Long，Integer等，其主要目的就是提供一个对象实例作为壳，将其基本类型包到这个对象之中，然后提供很多操作数据的方法，使面向对象的编程变得更加容易。
### 四、装箱和拆箱
在Java SE 5.0之前，要进行操作后才能将int包装为一个Integer类。JDK 5.0为基本数据类型提供了自动装箱(boxing)和拆箱(unboxing)的功能。

    boxing：将基本数据类型包装秤对应的包装类对象。
    unboxing：将包装类对象转换成对应的基本数据类型。
Java编译器在编译时期会根据源代码的语法来决定是否进行装箱和拆箱。在运算时，也可以进行自动装箱和拆箱。

### 五、泛型
泛型只是编译时的概念，是供编译器进行语法检查用的（由于程序员需要一种类型安全的集合，故这种需求产生了泛型）。

使用泛型的目的主要有以下两个方面：

    努力将运行时的异常转换成编译时错误，减少运行时异常数量（提高了编译器的能力）。
    解决模版编程的问题。
    [java] view plain copy print?
    //不用泛型  
    List list0 = new ArrayList();  
    list0.add("hello");  
    String str0 = (String) list0.get(0);  
    //用泛型，这样在获取对象的时候就不用类型转换  
    List<String> list = new ArrayList<String>();  
    list.add("hello");  
    String str = list.get(0);  
注意：泛型是没有数组的。编译器不承认 HashMap<K,V>[]这种形式的： Cannot create a generic array of HashMap<k,v> 
原因就是数组必须确定他每一个元素的类型。但是泛型在编译阶段有一个类型擦除的问题，也就是说编译器理解HashMap<Integer,Integer>和HashMap<String,String>都是同一种类型HashMap。如果泛型数组存在，那么HashMap<Integer,Integer>和HashMap<String,String>对象都可以加入到同一个HashMap[]数组中，这会造成灾难性的结果。 