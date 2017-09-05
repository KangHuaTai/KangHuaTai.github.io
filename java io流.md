# Java IO流
用于处理设备上数据。在流中一般以字节的形式存放这数据！

流：可以理解数据的流动，就是一个数据流。IO流最终要以对象来体现，对象都存在IO包中。

流也进行分类：

    1：输入流和输出流。
    2：因为处理的数据不同，分为字节流和字符流。
字节流：处理字节数据的流对象。设备上的数据无论是图片或者dvd，文字，他们都以二进制存储的。二进制的最终都是以一个8位为数据单元进行体现，所以计算机中的最小数据单元就是字节。意味着，字节流可以处理设备上的所有数据，所以字节流一样可以处理字符数据。

那么为什么要有字符流呢？因为字符每个国家都不一样，所以涉及到了字符编码问题，那么GBK编码的中文用unicode编码解析是有问题的，所以需要获取中文字节数据的同时+指定的编码表才可以解析正确数据。为了方便与文字的解析，所以将字节流和编码表封装成对象，这个对象就是字符流。只要操作字符 数据，优先考虑使用字符流体系。
#### 注意：流的操作只有两种：读和写。
流的体系因为功能不同，但是有共性内容，不断抽取，形成继承体系。该体系一共有四个基类，而且都是抽象类。
#### 字节流：InputStream  OutputStream 
#### 字符流：Reader  Writer
在这四个系统中，它们的子类，都有一个共性特点：子类名后缀都是父类名，前缀名都是这个子类的功能名称。

    public static void main(String[] args) throws IOException { //读、写都会发生IO异常
    /*  
    1：创建一个字符输出流对象，用于操作文件。该对象一建立，就必须明确数据存储位置，是一个文件。
    2：对象产生后，会在堆内存中有一个实体，同时也调用了系统底层资源，在指定的位置创建了一个存储数据的文件。  
    3：如果指定位置，出现了同名文件，文件会被覆盖。  
    */
    FileWriter fw = new FileWriter("demo.txt"); // FileNotFoundException
    /* 
    调用Writer类中的write方法写入字符串。字符串并未直接写入到目的地中，而是写入到了流中，(其实是写入到内存缓冲区中)。怎么把数据弄到文件中？
    */
    fw.write("abcde");
    fw.flush(); // 刷新缓冲区，将缓冲区中的数据刷到目的地文件中。
    fw.close(); // 关闭流，其实关闭的就是java调用的系统底层资源。在关闭前，会先刷新该流。
    }
    
close()和flush()的区别：

    flush()：将缓冲区的数据刷到目的地中后，流可以使用。
    close()：将缓冲区的数据刷到目的地中后，流就关闭了，该方法主要用于结束调用的底层资源。这个动作一定做。
io异常的处理方式：io一定要写finally；

FileWriter写入数据的细节：

    1：window中的换行符：\r\n两个符号组成。 linux：\n。 
    2：续写数据，只要在构造函数中传入新的参数true。
    3：目录分割符：window \\  /
    
>     public static void main(String[] args) {   
>         FileWriter fw = null;
>         try {
>             fw = new FileWriter("demo.txt",true);
>             fw.write("abcde");   
>         }catch (IOException e ){
>             System.out.println(e.toString()+"....");
>         }
>         finally{
>             if(fw!=null)
>                 try{
>                       fw.close();
>                 }catch (IOException e){
>                         System.out.println("close:"+e.toString());
>                 }   
>         }
>     }
>     
   
FileReader：使用Reader体系，读取一个文本文件中的数据。返回 -1 ，标志读到结尾。 

    import java.io.*; 
    class  FileReaderDemo {
        public static void main(String[] args) throws IOException {   /*   创建可以读取文本文件的流对象，FileReader让创建好的流对象和指定的文件相关联。   */   
            FileReader fr = new FileReader("demo.txt");
            int ch = 0;
            while((ch = fr.read())!= -1) {
                //条件是没有读到结尾
                System.out.println((char)ch);
                //调用读取流的read方法，读取一个字符。
                read()方法一次读一个字节的二进制数据—是int型的！
            }   
            fr.close();
        }
    }
    
读取数据的第二种方式：第二种方式较为高效，自定义缓冲区。 
    
    import java.io.*; 
    class FileReaderDemo2 {
        public static void main(String[] args) throws IOException {
            FileReader fr = new FileReader("demo.txt");
            //创建读取流对象和指定文件关联。
            //因为要使用read(char[])方法，将读取到字符存入数组。所以要创建一个字符数组，一般数组的长度都是1024的整数倍。
            char[] buf = new char[1024];//读取的字符数组长度是1024
            int len = 0;
            while(( len=fr.read(buf)) != -1) {
                System.out.println(new String(buf,0,len));//将char类型的数据从0到len转换成String
            } 
            fr.close(); 
        }
    }