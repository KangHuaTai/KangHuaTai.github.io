# Java枚举
#### 枚举：关键字 enum 

问题：对象的某个属性的值不能是任意的，必须为固定的一组取值其中的某一个； 解决办法：

    1）、在setGrade方法中做判断，不符合格式要求就抛出异常； 
    2）、直接限定用户的选择，通过自定义类模拟枚举的方式来限定用户的输入，写一个Grade类，私有构造函数，对外提供5个静态的常量表示类的实例； 
    3)、jdk5中新定义了枚举类型，专门用于解决此类问题；  
    4)、枚举就是一个特殊的java类，可以定义属性、方法、构造函数、实现接口、继承类；