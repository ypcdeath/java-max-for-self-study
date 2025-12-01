# Chapter3 学习内容总结

## 1. File类操作 📁

### File类基础操作
- **创建File对象**：像获得房屋钥匙，可以代表文件或文件夹
  ```java
  File file = new File("D:\\a.txt");
  ```

- **文件信息获取**：像查看房产证，获取文件名、绝对路径、大小等信息
- **文件创建与删除**：像建造和拆除房屋
  - `createNewFile()`：建造新房
  - `mkdir()/mkdirs()`：开辟新土地
  - `delete()`：拆除建筑（只能删除空文件夹）

### 递归遍历文件
```java
public static void findFile(File dir, String fileName) {
    // 递归查找文件，像侦探层层深入调查案件
    if(dir.isDirectory()) {
        File[] files = dir.listFiles();
        for(File file : files) {
            if(file.isFile() && file.getName().contains(fileName)) {
                // 找到目标文件
            } else if(file.isDirectory()) {
                findFile(file, fileName); // 继续深入搜索
            }
        }
    }
}
```


## 2. 字节流操作 🔤

### FileInputStream（字节输入流）
- **单字节读取**：像用滴管一滴滴吸取药水，效率较低
  ```java
  int b;
  while((b = is.read()) != -1) {
      System.out.print((char)b);
  }
  ```

- **字节数组读取**：像用水桶批量打水，提高效率
  ```java
  byte[] buffer = new byte[1024];
  int len;
  while((len = is.read(buffer)) != -1) {
      // 处理读取的数据
  }
  ```


### FileOutputStream（字节输出流）
- **写字节**：像在画布上逐点绘制图案
  ```java
  os.write(97); // 写入字符'a'
  os.write("Hello".getBytes()); // 写入字符串
  ```


## 3. 字符流操作 📝

### FileReader（字符输入流）
- **字符读取**：像阅读书籍，专门处理文本内容，避免中文乱码
  ```java
  char[] chs = new char[1024];
  int len;
  while((len = fr.read(chs)) != -1) {
      String str = new String(chs, 0, len);
  }
  ```


### FileWriter（字符输出流）
- **写字符**：像书法家挥毫泼墨
  ```java
  fw.write('a');           // 写字符
  fw.write("hello");       // 写字符串
  fw.write(chs, 0, 3);     // 写字符数组部分
  ```


## 4. 缓冲流优化 ⚡

### BufferedInputStream/BufferedOutputStream
- **缓冲机制**：像水库蓄水，减少频繁的磁盘IO操作
  ```java
  BufferedInputStream bis = new BufferedInputStream(fis);
  BufferedOutputStream bos = new BufferedOutputStream(fos);
  ```


### BufferedReader/BufferedWriter
- **按行读取**：像读书一样，一行一行阅读
  ```java
  String line;
  while((line = br.readLine()) != null) {
      System.out.println(line);
  }
  ```


## 5. 特殊流处理 🎯

### PrintStream（打印流）
- **格式化输出**：像打印机，可以直接打印各种数据类型
  ```java
  PrintStream ps = new PrintStream(new FileOutputStream("file.txt"));
  ps.println(97);      // 打印整数
  ps.println("abc");   // 打印字符串
  ps.println(true);    // 打印布尔值
  ```


### DataInputStream/DataOutputStream（数据流）
- **类型安全读写**：像保险箱，按指定类型存取数据
  ```java
  // 写入
  dos.writeInt(88);
  dos.writeUTF("文本");
  dos.writeBoolean(true);
  
  // 读取（必须按写入顺序读取）
  int num = dis.readInt();
  String str = dis.readUTF();
  boolean flag = dis.readBoolean();
  ```


## 6. 字符编码处理 🌍

### 编码解码操作
```java
String name = "我爱你中国";
byte[] bytes = name.getBytes("GBK");     // 编码
String decoded = new String(bytes, "GBK"); // 解码
```

- 像翻译工作，将文字转换为计算机能理解的二进制码

## 7. 实际应用案例 💼

### 文件复制功能
```java
public static void copyFile(String srcPath, String destPath) {
    try(InputStream fis = new FileInputStream(srcPath);
        OutputStream fos = new FileOutputStream(destPath)) {
        
        byte[] bytes = new byte[1024];
        int len;
        while((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len); // 边读边写，实现复制
        }
    }
}
```


### IO综合实践
- **排行榜系统**：使用`DataInputStream`/`DataOutputStream`保存和读取最高分
- **文章排序**：使用缓冲流读取混乱的文章行，按序号重新排列

这个章节就像学习物流管理，从认识仓库(`File`类)、掌握货物装卸(字节流)、学会分类运输(字符流)、优化运输路线(缓冲流)到特殊货物处理(打印流、数据流)的完整体系。每个知识点都是处理文件数据的重要工具，为开发文件管理系统、日志处理、数据持久化等应用奠定基础。