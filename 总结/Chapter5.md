# Chapter5 网络编程和常用API - 详细总结

## 一、网络编程基础(Network Programming)

### 1.1 InetAddress 类 - 网络身份标识
InetAddress 类用于表示互联网协议(IP)地址，包含主机名和IP地址。

常见方法：
- `getLocalHost()`: 获取本机InetAddress对象
- `getByName(String host)`: 根据主机名获取InetAddress对象
- `getHostName()`: 获取主机名
- `getHostAddress()`: 获取IP地址字符串
- `isReachable(int timeout)`: 测试是否可以到达该地址

```java
// 获取本机IP地址
InetAddress ip1 = InetAddress.getLocalHost();
System.out.println(ip1.getHostAddress()); // 输出IP地址

// 获取指定域名的IP地址
InetAddress ip2 = InetAddress.getByName("www.baidu.com");
System.out.println(ip2.getHostAddress());
```


比喻理解：InetAddress就像我们的身份证，上面有姓名(主机名)和住址(IP地址)，通过这个身份信息我们就可以在网络世界中找到对应的计算机。

### 1.2 UDP通信(User Datagram Protocol) - 不可靠但快速的通信方式

UDP是一种无连接、不可靠但传输效率高的协议。

#### 单次通信(demo2udp1)
- 客户端使用`DatagramSocket`发送数据包
- 服务端使用`DatagramSocket(port)`监听指定端口
- 数据被打包成`DatagramPacket`进行传输

```java
// UDP客户端发送数据示例
DatagramSocket socket = new DatagramSocket();
byte[] bytes = "Hello World".getBytes();
DatagramPacket packet = new DatagramPacket(bytes, bytes.length, 
                                          InetAddress.getLocalHost(), 8080);
socket.send(packet);
socket.close();

// UDP服务端接收数据示例
DatagramSocket socket = new DatagramSocket(8080);
byte[] buf = new byte[1024*64];
DatagramPacket packet = new DatagramPacket(buf, buf.length);
socket.receive(packet); // 阻塞等待接收数据
String data = new String(buf, 0, packet.getLength());
System.out.println(data);
```


比喻理解：就像寄明信片，你写好内容(数据)放进信封(DatagramPacket)，写上收件人地址(目标IP和端口)，投递到邮局窗口(DatagramSocket)。但明信片可能会丢失、重复或乱序到达，这就是UDP的"不可靠"特性。

#### 循环通信(demo3udp2)
在单次通信基础上，通过while(true)循环实现持续通信，客户端可以连续发送消息给服务端。

```java
// 客户端循环发送数据
Scanner sc = new Scanner(System.in);
while (true) {
    String msg = sc.nextLine();
    if("exit".equals(msg)) break;
    byte[] bytes = msg.getBytes();
    DatagramPacket packet = new DatagramPacket(bytes, bytes.length, 
                                              InetAddress.getLocalHost(), 8080);
    socket.send(packet);
}
```


### 1.3 TCP通信(Transmission Control Protocol) - 可靠的面向连接通信

TCP是一种面向连接、可靠的传输协议，虽然速度相对UDP较慢，但确保数据完整性和顺序。

#### 基础一发一收(demo4tcp1)
- 服务端使用`ServerSocket(port)`监听端口，通过`accept()`等待客户端连接
- 客户端使用`Socket(host, port)`主动连接服务端
- 连接建立后，双方通过输入输出流进行数据交换

```java
// TCP客户端示例
Socket socket = new Socket("127.0.0.1", 9999);
OutputStream os = socket.getOutputStream();
DataOutputStream dos = new DataOutputStream(os);
dos.writeUTF("你好服务器");
dos.close();

// TCP服务端示例
ServerSocket ss = new ServerSocket(9999);
Socket socket = ss.accept(); // 等待客户端连接
InputStream is = socket.getInputStream();
DataInputStream dis = new DataInputStream(is);
String msg = dis.readUTF(); // 读取客户端发送的数据
System.out.println(msg);
```


比喻理解：就像打电话，首先要拨号建立连接(三次握手)，连接成功后才能对话，而且保证你说的每句话对方都能准确听到，不会遗漏，这就是TCP的"可靠性"。

#### 客户端持续发送(demo5tcp2)
客户端通过循环可以持续向服务端发送消息，实现双向持续通信。

```java
// 客户端持续发送消息
Scanner sc = new Scanner(System.in);
while (true) {
    String msg = sc.nextLine();
    if("exit".equals(msg)) {
        socket.close();
        break;
    }
    dos.writeUTF(msg);
    dos.flush();
}
```


#### 支持多客户端的服务端(demo6tcp3)
通过为每个连接的客户端创建新线程(ServerReader)，服务端可以同时处理多个客户端。

```java
// 服务端主线程接受连接并创建处理线程
while (true) {
    Socket socket = ss.accept();
    System.out.println("客户端已连接");
    new ServerReader(socket).start(); // 为每个客户端创建独立线程
}

// 处理客户端消息的线程类
public class ServerReader extends Thread {
    private Socket socket;
    
    public ServerReader(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                String msg = dis.readUTF();
                System.out.println("收到：" + msg);
            }
        } catch (Exception e) {
            System.out.println("客户端断开连接");
        }
    }
}
```


比喻理解：就像银行柜台服务，一个总出纳员(ServerSocket)负责接待所有客户，但每接待一位客户就安排一个专门的柜员(Thread)来办理业务，这样就能同时为多位客户服务。

#### BS架构模拟(demo7tcp4)
模拟浏览器/服务器架构(Browser/Server)，服务端返回HTML页面内容。
- 使用线程池(ThreadPoolExecutor)管理并发连接
- 通过HTTP协议格式返回网页内容

```java
// BS架构服务器示例
ServerSocket ss = new ServerSocket(8080);
ExecutorService pool = new ThreadPoolExecutor(3, 10, 10, TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(),
        new ThreadPoolExecutor.AbortPolicy());

while (true) {
    Socket socket = ss.accept();
    pool.execute(new ServerReader(socket)); // 使用线程池处理请求
}

// 服务端响应HTTP请求
public void run() {
    try {
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println("HTTP/1.1 200 OK"); // HTTP状态行
        ps.println("Content-Type:text/html;charset=utf-8"); // 响应头
        ps.println(); // 空行分隔
        ps.println("<h1>Hello World</h1>"); // 响应体
        ps.close();
    } catch (Exception e) {
        // 异常处理
    }
}
```


## 二、常用API(Application Programming Interface)

### 2.1 时间处理(demo8api.Test1) - 日期时间操作

#### JDK8之前的方法(Date + SimpleDateFormat)
- `Date`类表示特定的时间点
- `SimpleDateFormat`类用于格式化和解析日期

#### JDK8之后的新API(推荐使用)
- `LocalDateTime`类表示日期和时间
- `DateTimeFormatter`类用于格式化和解析日期时间

```java
// JDK8之前的时间处理
Date d = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
String format = sdf.format(d);

// JDK8之后的时间处理（推荐）
LocalDateTime now = LocalDateTime.now();
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
String format1 = dtf.format(now);
```


比喻理解：就像表达时间的方式，老方法像是用古老的日晷测量时间，而新方法像是用现代的电子钟，不仅更精确，而且功能更强大，使用更方便。

### 2.2 高精度计算(demo8api.Test3) - 解决浮点数精度问题

`BigDecimal`类用于高精度的十进制数值计算，避免了double类型的精度问题。

常见用法：
- 使用字符串构造器避免精度损失：`new BigDecimal("0.1")`
- 使用静态方法：`BigDecimal.valueOf(0.1)`
- 四则运算方法：add(), subtract(), multiply(), divide()

```java
// 浮点数精度问题演示
double a = 0.1;
double b = 0.2;
System.out.println(a + b); // 输出0.30000000000000004

// 使用BigDecimal解决精度问题
BigDecimal a1 = new BigDecimal("0.1");
BigDecimal b1 = new BigDecimal("0.2");
BigDecimal result = a1.add(b1);
System.out.println(result); // 输出0.3

// 除法运算需要指定精度和舍入模式
BigDecimal d1 = new BigDecimal("10");
BigDecimal d2 = new BigDecimal("3");
BigDecimal result2 = d1.divide(d2, 2, RoundingMode.HALF_UP);
System.out.println(result2); // 输出3.33
```


比喻理解：就像使用计算器和心算的区别，对于简单的数学计算心算足够，但对于需要高精度的金融计算(如银行利息)，就必须使用计算器(BigDecimal)来保证准确性。

### 2.3 字符串高效拼接(demo8api.test2) - 提升字符串操作性能

`StringBuilder`类用于高效的字符串拼接操作(非线程安全)。

特点：
- 相比String的"+"拼接方式，性能大幅提升
- 适用于大量字符串拼接场景
- 注意：线程不安全，只能在单线程环境中使用

```java
// 使用StringBuilder高效拼接字符串
String s = "前缀";
StringBuilder sb = new StringBuilder(s);
for (int i = 0; i < 1000; i++) {
    sb.append(i); // 添加数字到字符串末尾
}
String result = sb.toString(); // 转换为最终字符串
```


比喻理解：就像建造房子，普通String拼接每次都要拆掉旧房子重建新房子，而StringBuilder就像有一个建筑工地，可以在原有基础上不断添加新房间，效率大大提高。

## 总结

Chapter5涵盖的知识体系包括：
1. 网络编程核心概念：理解IP地址、UDP/TCP协议差异
2. UDP编程实践：掌握无连接数据报通信模式
3. TCP编程实践：掌握面向连接的可靠通信模式
4. 多线程网络应用：理解如何支持并发客户端连接
5. BS架构原理：了解Web服务器基本工作机制
6. 常用工具类：掌握日期时间、高精度计算、字符串操作等实用API

这些知识点是构建网络应用程序和服务的基础，也是后续深入学习分布式系统和微服务的重要前置知识。通过理论结合实际代码示例，能够帮助我们更好地理解和掌握网络编程的核心概念与实践技能。