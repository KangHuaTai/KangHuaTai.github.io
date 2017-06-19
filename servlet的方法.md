    (1) init() 方法
在 Servlet 的生命期中，仅执行一次 init() 方法。它是在服务器装入 Servlet 时执行的。可以配置服务器，以在启动服务器或客户机首次访问 Servlet 时装入 Servlet。 无论有多少客户机访问 Servlet，都不会重复执行 init() 。
缺省的 init() 方法通常是符合要求的，但也可以用定制 init() 方法来覆盖它，典型的是管理服务器端资源。例如，可能编写一个定制 init() 来只用于一次装入 GIF 图像，改进 Servlet 返回 GIF 图像和含有多个客户机请求的性能。另一个示例是初始化数据库连接。缺省的 init() 方法设置了 Servlet 的初始化参数，并用它的 ServletConfig 对象参数来启动配置， 因此所有覆盖 init() 方法的 Servlet 应调用 super.init() 以确保仍然执行这些任务。在调用 service() 方法之前，应确保已完成了 init() 方法。

    (2) service() 方法
service() 方法是 Servlet 的核心。每当一个客户请求一个HttpServlet 对象，该对象的service() 方法就要被调用，而且传递给这个方法一个"请求"(ServletRequest)对象和一个"响应"(ServletResponse)对象作为参数。在 HttpServlet 中已存在 service() 方法。缺省的服务功能是调用与 HTTP 请求的方法相应的 do 功能。例如，如果 HTTP 请求方法为 GET，则缺省情况下就调用 doGet() 。Servlet 应该为 Servlet 支持的 HTTP 方法覆盖 do 功能。因为 HttpServlet.service() 方法会检查请求方法是否调用了适当的处理方法，不必要覆盖 service() 方法。只需覆盖相应的 do 方法就可以了。
Servlet的响应可以是下列几种类型：
一个输出流，浏览器根据它的内容类型(如text/HTML)进行解释。
一个HTTP错误响应,重定向到另一个URL、servlet、JSP。

    (3)doGet()方法
当一个客户通过HTML 表单发出一个HTTP GET请求或直接请求一个URL时，doGet()方法被调用。与GET请求相关的参数添加到URL的后面，并与这个请求一起发送。当不会修改服务器端的数据时，应该使用doGet()方法。

    (4)doPost()方法
当一个客户通过HTML 表单发出一个HTTP POST请求时，doPost()方法被调用。与POST请求相关的参数作为一个单独的HTTP 请求从浏览器发送到服务器。当需要修改服务器端的数据时，应该使用doPost()方法。

    (5) destroy() 方法
destroy() 方法仅执行一次，即在服务器停止且卸装Servlet 时执行该方法。典型的，将 Servlet 作为服务器进程的一部分来关闭。缺省的 destroy() 方法通常是符合要求的，但也可以覆盖它，典型的是管理服务器端资源。例如，如果 Servlet 在运行时会累计统计数据，则可以编写一个 destroy() 方法，该方法用于在未装入 Servlet 时将统计数字保存在文件中。另一个示例是关闭数据库连接。
当服务器卸装 Servlet时，将在所有service()方法调用完成后，或在指定的时间间隔过后调用 destroy() 方法。一个Servlet在运行service()方法时可能会产生其它的线程，因此请确认在调用destroy()方法时，这些线程已终止或完成。

    (6) GetServletConfig()方法
GetServletConfig()方法返回一个ServletConfig对象，该对象用来返回初始化参数和ServletContext。ServletContext 接口提供有关servlet 的环境信息。

    (7) GetServletInfo()方法
GetServletInfo()方法是一个可选的方法，它提供有关servlet 的信息，如作者、版本、版权。

当服务器调用sevlet的Service()、doGet()和doPost()这三个方法时，均需要"请求"和"响应"对象作为参数。"请求"对象提供有关请求的信息，而"响应"对象提供了一个将响应信息返回给浏览器的一个通信途径。
javax.servlet 软件包中的相关类为ServletResponse和ServletRequest，而javax.servlet.http 软件包中的相关类为HttpServletRequest 和 HttpServletResponse。Servlet 通过这些对象与服务器通信并最终与客户机通信。Servlet 能通过调用"请求"对象的方法获知客户机环境，服务器环境的信息和所有由客户机提供的信息。Servlet 可以调用"响应"对象的方法发送响应，该响应是准备发回客户机的。