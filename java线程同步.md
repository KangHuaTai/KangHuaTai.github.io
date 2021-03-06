# 同步
//就是在操作共享数据代码时，访问时只能让一个线程进去访问，此线程执行完退出后，别的线程才能再对此共享数据代码进行访问。

好处：解决了线程安全问题。Synchronized

弊端：相对降低性能，因为判断锁需要消耗资源，产生了死锁。

定义同步是有前提的：

    1，必须要有两个或者两个以上的线程，才需要同步。
    2，多个线程必须保证使用的是同一个锁。
同步的第二种表现形式：      //对共享资源的方法定义同步

同步函数：其实就是将同步关键字定义在函数上，让函数具备了同步性。

同步函数是用的哪个锁呢？ 

//synchronized(this)用以定义需要进行同步的某一部分代码块
通过验证，函数都有自己所属的对象this，所以同步函数所使用的锁就是this锁。This.方法名

当同步函数被static修饰时，这时的同步用的是哪个锁呢？

静态函数在加载时所属于类，这时有可能还没有该类产生的对象，但是该类的字节码文件加载进内存就已经被封装成了对象，这个对象就是该类的字节码文件对象。

所以静态加载时，只有一个对象存在，那么静态同步函数就使用的这个对象。

这个对象就是 类名.class

同步代码块和同步函数的区别？

    同步代码块使用的锁可以是任意对象。
    同步函数使用的锁是this，静态同步函数的锁是该类的字节码文件对象。
    在一个类中只有一个同步的话，可以使用同步函数。如果有多同步，必须使用同步代码块，来确定不同的锁。所以同步代码块相对灵活一些。
-------------------------------------------------------

//懒汉式：延迟加载方式。

当多线程访问懒汉式时，因为懒汉式的方法内对共性数据进行多条语句的操作。所以容易出现线程安全问题。为了解决，加入同步机制，解决安全问题。但是却带来了效率降低。
为了效率问题，通过双重判断的形式解决。

    class Single{
        private static Single s = null;
        private Single(){}
        public static Single getInstance(){ //锁是谁？字节码文件对象；
           if(s == null){
             synchronized(Single.class){
                if(s == null)
                    s = new Single();
             }
          }
           return s;
        }
    }
---------------------------------------------------------
同步死锁：通常只要将同步进行嵌套，就可以看到现象。同步函数中有同步代码块，同步代码块中还有同步函数。

线程间通信：思路：多个线程在操作同一个资源，但是操作的动作却不一样。

    1：将资源封装成对象。
    2：将线程执行的任务(任务其实就是run方法。)也封装成对象。
等待唤醒机制：涉及的方法：

    wait:将同步中的线程处于冻结状态。释放了执行权，释放了资格。同时将线程对象存储到线程池中。
    notify：唤醒线程池中某一个等待线程。
    notifyAll:唤醒的是线程池中的所有线程。
### 注意：

    1：这些方法都需要定义在同步中。
    2：因为这些方法必须要标示所属的锁。
        你要知道 A锁上的线程被wait了,那这个线程就相当于处于A锁的线程池中，只能A锁的notify唤醒。
    3：这三个方法都定义在Object类中。为什么操作线程的方法定义在Object类中？
        因为这三个方法都需要定义同步内，并标示所属的同步锁，既然被锁调用，而锁又可以是任意对象，那么能被任意对象调用的方法一定定义在Object类中。
wait和sleep区别：

    分析这两个方法：从执行权和锁上来分析：
    wait：可以指定时间也可以不指定时间。不指定时间，只能由对应的notify或者notifyAll来唤醒。
    sleep：必须指定时间，时间到自动从冻结状态转成运行状态(临时阻塞状态)。
    wait：线程会释放执行权，而且线程会释放锁。
    Sleep：线程会释放执行权，但不是不释放锁。
线程的停止：通过stop方法就可以停止线程。但是这个方式过时了。

停止线程：原理就是：让线程运行的代码结束，也就是结束run方法。

怎么结束run方法？一般run方法里肯定定义循环。所以只要结束循环即可。

    第一种方式：定义循环的结束标记。
    第二种方式：如果线程处于了冻结状态，是不可能读到标记的，这时就需要通过Thread类中的interrupt方法，将其冻结状态强制清除。让线程恢复具备执行资格的状态，让线程可以读到标记，并结束。
---------< java.lang.Thread >----------

    interrupt()：中断线程。
    setPriority(int newPriority)：更改线程的优先级。
    getPriority()：返回线程的优先级。
    toString()：返回该线程的字符串表示形式，包括线程名称、优先级和线程组。
    Thread.yield()：暂停当前正在执行的线程对象，并执行其他线程。
    setDaemon(true)：将该线程标记为守护线程或用户线程。将该线程标记为守护线程或用户线程。当正在运行的线程都是守护线程时，Java 虚拟机退出。该方法必须在启动线程前调用。
    join：临时加入一个线程的时候可以使用join方法。
    当A线程执行到了B线程的join方式。A线程处于冻结状态，释放了执行权，B开始执行。A什么时候执行呢？只有当B线程运行结束后，A才从冻结状态恢复运行状态执行。