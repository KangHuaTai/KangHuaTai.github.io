# Java反射
反射技术：其实就是动态加载一个指定的类，并获取该类中的所有的内容。而且将字节码文件封装成对象，并将字节码文件中的内容都封装成对象，这样便于操作这些成员。简单说：反射技术可以对一个类进行解剖。

反射的好处：大大的增强了程序的扩展性。

反射的基本步骤：

    1、获得Class对象，就是获取到指定的名称的字节码文件对象。
    2、实例化对象，获得类的属性、方法或构造函数。
    3、访问属性、调用方法、调用构造函数创建对象。
获取这个Class对象，有三种方式：

    1：通过每个对象都具备的方法getClass来获取。弊端：必须要创建该类对象，才可以调用getClass方法。
    2：每一个数据类型(基本数据类型和引用数据类型)都有一个静态的属性class。弊端：必须要先明确该类。
         前两种方式不利于程序的扩展，因为都需要在程序使用具体的类来完成。
    3：使用的Class类中的方法，静态的forName方法。
指定什么类名，就获取什么类字节码文件对象，这种方式的扩展性最强，只要将类名的字符串传入即可。

// 1. 根据给定的类名来获得  用于类加载
String classname = "cn.itcast.reflect.Person";// 来自配置文件
Class clazz = Class.forName(classname);// 此对象代表Person.class

// 2. 如果拿到了对象，不知道是什么类型   用于获得对象的类型
Object obj = new Person();
Class clazz1 = obj.getClass();// 获得对象具体的类型

// 3. 如果是明确地获得某个类的Class对象  主要用于传参
Class clazz2 = Person.class; 
### 反射的用法：

    1）、需要获得java类的各个组成部分，首先需要获得类的Class对象，获得Class对象的三种方式：
           Class.forName(classname)    用于做类加载
           obj.getClass()                            用于获得对象的类型
           类名.class                   用于获得指定的类型，传参用
    2)、反射类的成员方法：
           Class clazz = Person.class;
           Method method = clazz.getMethod(methodName, new Class[]{paramClazz1, paramClazz2});
           method.invoke();
    3)、反射类的构造函数：
           Constructor con = clazz.getConstructor(new Class[]{paramClazz1, paramClazz2,...})
           con.newInstance(params...)
    4)、反射类的属性：
           Field field = clazz.getField(fieldName);
           field.setAccessible(true);
           field.setObject(value);
获取了字节码文件对象后，最终都需要创建指定类的对象：
创建对象的两种方式(其实就是对象在进行实例化时的初始化方式)：

    1，调用空参数的构造函数：使用了Class类中的newInstance()方法。
    2，调用带参数的构造函数：先要获取指定参数列表的构造函数对象，然后通过该构造函数的对象的newInstance(实际参数) 进行对象的初始化。
综上所述，第二种方式，必须要先明确具体的构造函数的参数类型，不便于扩展。所以一般情况下，被反射的类，内部通常都会提供一个公有的空参数的构造函数。

    // 如何生成获取到字节码文件对象的实例对象。
           Class clazz = Class.forName("cn.itcast.bean.Person");//类加载
    // 直接获得指定的类型
          clazz = Person.class;
          // 根据对象获得类型
          Object obj = new Person("zhangsan", 19);
          clazz = obj.getClass();
           Object obj = clazz.newInstance();//该实例化对象的方法调用就是指定类中的空参数构造函数，给创建对象进行初始化。当指定类中没有空参数构造函数时，该如何创建该类对象呢？请看method_2();
        public static void method_2() throws Exception {
           Class clazz = Class.forName("cn.itcast.bean.Person");
           //既然类中没有空参数的构造函数,那么只有获取指定参数的构造函数,用该函数来进行实例化。
           //获取一个带参数的构造器。
           Constructor constructor = clazz.getConstructor(String.class,int.class);
           //想要对对象进行初始化，使用构造器的方法newInstance();
           Object obj = constructor.newInstance("zhagnsan",30);
           //获取所有构造器。
           Constructor[] constructors = clazz.getConstructors();//只包含公共的
           constructors = clazz.getDeclaredConstructors();//包含私有的
           for(Constructor con : constructors) {
               System.out.println(con);
           }
        }
反射指定类中的方法：

    //获取类中所有的方法。
    public static void method_1() throws Exception {
       Class clazz = Class.forName("cn.itcast.bean.Person");
       Method[] methods = clazz.getMethods();//获取的是该类中的公有方法和父类中的公有方法。
       methods = clazz.getDeclaredMethods();//获取本类中的方法，包含私有方法。
       for(Method method : methods) {
           System.out.println(method);
       }
    }
    //获取指定方法；
    public static void method_2() throws Exception {
       Class clazz = Class.forName("cn.itcast.bean.Person");
       //获取指定名称的方法。
       Method method = clazz.getMethod("show", int.class,String.class);
       //想要运行指定方法，当然是方法对象最清楚，为了让方法运行，调用方法对象的invoke方法即可，但是方法运行必须要明确所属的对象和具体的实际参数。
       Object obj = clazz.newInstance();
       method.invoke(obj, 39,"hehehe");//执行一个方法
    }
    //想要运行私有方法。
    public static void method_3() throws Exception {
       Class clazz = Class.forName("cn.itcast.bean.Person");
       //想要获取私有方法。必须用getDeclearMethod();
       Method method = clazz.getDeclaredMethod("method", null);
       // 私有方法不能直接访问，因为权限不够。非要访问，可以通过暴力的方式。
       method.setAccessible(true);//一般很少用，因为私有就是隐藏起来，所以尽量不要访问。
    }
    //反射静态方法。
    public static void method_4() throws Exception {
       Class clazz = Class.forName("cn.itcast.bean.Person");
       Method method = clazz.getMethod("function",null);
       method.invoke(null,null);
    }