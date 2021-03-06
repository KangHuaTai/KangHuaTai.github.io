# 多 态
函数本身就具备多态性，某一种事物有不同的具体的体现。

体现：父类引用或者接口的引用指向了自己的子类对象。//Animal a = new Cat();父类可以调用子类中覆写过的（父类中有的方法）

多态的好处：

    提高了程序的扩展性。继承的父类或接口一般是类库中的东西，（如果要修改某个方法的具体实现方式）只有通过子类去覆写要改变的某一个方法，这样在通过将父类的应用指向子类的实例去调用覆写过的方法就行了！
多态的弊端：

    当父类引用指向子类对象时，虽然提高了扩展性，但是只能访问父类中具备的方法，不可以访问子类中特有的方法。(前期不能使用后期产生的功能，即访问的局限性)
多态的前提：

    1：必须要有关系，比如继承、或者实现。
    2：通常会有覆盖操作。
    
#### 多态的出现思想上也做着变化：以前是创建对象并指挥对象做事情。有了多态以后，我们可以找到对象的共性类型，直接操作共性类型做事情即可，这样可以指挥一批对象做事情，即通过操作父类或接口实现。
--------------------------------------------------------------

    class 毕姥爷{
        void 讲课(){
           System.out.println("企业管理");
        }
        void 钓鱼(){
           System.out.println("钓鱼");
        }
    }
    class 毕老师 extends 毕姥爷{
        void 讲课(){
           System.out.println("JAVA");
        }
        void 看电影(){
           System.out.println("看电影");
        }
    }
    class {
        public static void main(String[] args) {
           毕姥爷 x = new 毕老师(); //毕老师对象被提升为了毕姥爷类型。
    //     x.讲课();
    //     x.看电影();  //错误.
           毕老师 y = (毕老师)x; //将毕姥爷类型强制转换成毕老师类型。
           y.看电影();//在多态中，自始自终都是子类对象在做着类型的变化。
        }
    }
---------------------------------------------------------------
如果想用子类对象的特有方法，如何判断对象是哪个具体的子类类型呢？

可以可以通过一个关键字 instanceof ;//判断对象是否实现了指定的接口或继承了指定的类
格式：<对象 instanceof 类型> ，判断一个对象是否所属于指定的类型。
Student instanceof Person = true;//student继承了person类

多态在子父类中的成员上的体现的特点：

    1，成员变量：在多态中，子父类成员变量同名。
        在编译时期：参考的是引用型变量所属的类中是否有调用的成员。（编译时不产生对象，只检查语法错误）
        运行时期：也是参考引用型变量所属的类中是否有调用的成员。
        简单一句话：无论编译和运行，成员变量参考的都是引用变量所属的类中的成员变量。
        再说的更容易记忆一些：成员变量 --- 编译运行都看 = 左边。
    2，成员函数。
        编译时期：参考引用型变量所属的类中是否有调用的方法。
        运行事情：参考的是对象所属的类中是否有调用的方法。
        为什么是这样的呢？因为在子父类中，对于一模一样的成员函数，有一个特性：覆盖。
        简单一句：成员函数，编译看引用型变量所属的类，运行看对象所属的类。
        更简单：成员函数 --- 编译看 = 左边，运行看 = 右边。
    3，静态函数。
        编译时期：参考的是引用型变量所属的类中是否有调用的成员。
        运行时期：也是参考引用型变量所属的类中是否有调用的成员。
        为什么是这样的呢？因为静态方法，其实不所属于对象，而是所属于该方法所在的类。
        调用静态的方法引用是哪个类的引用调用的就是哪个类中的静态方法。