Servlet
应该程序的开发过程：
第一步：实现Servlet接口
第二步：要在WEB-INF目录找web.xml文件

第三步：部署项目，相当于放到了webapps目录下面

Servlet生命周期
直接集成Servlet	会产生
init		在第一次被访问的时候调用
service	在每一次被访问的时候调用
destory	在关闭服务器的时候调用

我们所写的应用程序要继承HTTPServlet
覆写doGet	doPost

继承关系
Servlet
GenericServlet
HttpServlet
我们自己写的类