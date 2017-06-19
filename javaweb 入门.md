入门知识
在开发之前需要安装服务器
服务器的作用就是：相当于相应客户端的请求返回响应的资源

动态网页和静态网页
并不是指网页是否有动画，静态网页是指内容不会变化
动态网页是指内容有程序产生并会时时变化

丶具体的web服务器
Weblogic 、WebSphere 、 Tomcat

[Tomcat获取地址](http://jakarta.apache.org)
丶Tomcat的目录结构

webapps		放置的是我们所写的应用程序Servlet
conf			放置的是Tomcat的配置文件可以配置虚拟主机，以及tomcat的端口、管理用户等配置信息
JavaWEB项目目录结构
-webapp

-ROOT
-WEB-INF
-classes
-lib
web.xml
index.jsp

注意： WEB-INF 目录子外界是无法访问到的。