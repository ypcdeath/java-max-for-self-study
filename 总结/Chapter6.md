# Chapter6 JUnit、反射、注解和代理 - 详细总结

## 一、JUnit单元测试框架

JUnit是一个Java语言的单元测试框架，用于编写和运行可重复的测试。

### 1.1 基本使用
- 测试类需要导入`org.junit.Test`注解
- 测试方法必须是`public void`且无参数
- 每个测试方法需要添加[@Test](file://D:\JavaCode\JavaMax\2025-Chapter6-junit-reflect-annotation-proxy\src\com\itheima\demo4proxy\Test.java#L2-L12)注解

```java
public class StringUtilTest {
    @Test
    public void testPrintNumber(){
        StringUtil.printNumber("张三abc");
        StringUtil.printNumber("");
        StringUtil.printNumber(null);
    }
    
    @Test
    public void testGetMaxIndex(){
        Assert.assertEquals("本轮测试失败", 4, StringUtil.getMaxIndex("张三123"));
    }
}
```


### 1.2 断言机制
使用`Assert.assertEquals(expected, actual)`等方法进行结果验证，确保程序按预期执行。

比喻理解：JUnit就像一个自动化的质检员，可以自动检查你的代码是否正常工作，而不需要每次都手动运行和验证结果。

## 二、反射(Reflection)

反射是Java语言的一个重要特性，允许程序在运行时检查和操作类、方法、属性等。

### 2.1 获取Class对象的三种方式
```java
// 1. 类名.class
Class c1 = Student.class;

// 2. Class.forName("全类名")
Class c2 = Class.forName("com.itheima.demo2reflect.Student");

// 3. 对象.getClass()
Student s = new Student();
Class c3 = s.getClass();
```


### 2.2 获取构造器并创建对象
```java
Class c1 = Dog.class;
// 获取所有构造器
Constructor[] constructors = c1.getDeclaredConstructors();

// 获取特定构造器
Constructor con3 = c1.getDeclaredConstructor(String.class, int.class);
// 暴力反射访问私有构造器
con3.setAccessible(true);
Dog dog = (Dog) con3.newInstance("张三", 10);
```


### 2.3 操作成员变量
```java
Class c1 = Dog.class;
// 获取所有属性
Field[] fields = c1.getDeclaredFields();

// 获取特定属性
Field field2 = c1.getDeclaredField("hobby");
// 暴力反射访问私有属性
field2.setAccessible(true);
field2.set(d, "吃鸡吧");
String hobby = (String) field2.get(d);
```


### 2.4 调用方法
```java
Class c1 = Dog.class;
// 获取所有方法
Method[] methods = c1.getDeclaredMethods();

// 调用方法
Method m1 = c1.getDeclaredMethod("eat");
Object invoke1 = m1.invoke(d);

Method m2 = c1.getDeclaredMethod("eat", String.class);
Object invoke2 = m2.invoke(d, "急吧");
```


### 2.5 反射的实际应用
反射可以绕过泛型检查，破坏封装性，是框架开发的核心技术。

```java
// 绕过泛型约束
ArrayList<String> list = new ArrayList<>();
Class c1 = list.getClass();
Method add = c1.getMethod("add", Object.class);
add.invoke(list, true);  // 添加布尔值到String类型集合
add.invoke(list, 9.9);   // 添加双精度值到String类型集合
```


### 2.6 反射综合应用示例 - 对象持久化框架
```java
public class SaveObjectFrame {
    public static void saveObject(Object obj) throws Exception {
        PrintStream ps = new PrintStream(new FileOutputStream("savedata.txt", true));
        Class c = obj.getClass();
        String simpleName = c.getSimpleName();
        ps.println("=========="+simpleName+"==========");
        
        // 获取所有属性并保存到文件
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            field.setAccessible(true);
            Object fieldValue = field.get(obj)+"";
            ps.println(fieldName+"="+fieldValue);
        }
        ps.close();
    }
}
```


比喻理解：反射就像一把万能钥匙，可以打开任何类的"门"，查看里面的构造、属性和方法，甚至可以修改私有成员。

## 三、注解(Annotation)

注解是代码中的特殊标记，用于在编译或运行时提供额外信息。

### 3.1 内置注解
- `@Override`：标识重写方法
- `@Deprecated`：标识过时方法
- `@SuppressWarnings`：抑制编译警告

### 3.2 自定义注解
```java
// 简单注解
public @interface MyBook {
    String name();
    int age() default 18;
    String[] address();
}

// 带元注解的注解
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest2 {
    String value();
    double height() default 178;
    String[] address();
}
```


### 3.3 使用注解
```java
@MyBook(name = "明日香", age = 15, address = {"立本", "德国", "中国"})
@A("绫波丽")
public class AnnotationDemo1 {
    @MyBook(name = "渚薰", age = 16, address = {"月球", "立本", "香港"})
    public static void main(String[] args) {
        // 目标：自定义注解
    }
}
```


### 3.4 解析注解
```java
// 解析类上的注解
Class c1 = Demo.class;
if(c1.isAnnotationPresent(MyTest2.class)){
    MyTest2 myTest2 = (MyTest2)c1.getDeclaredAnnotation(MyTest2.class);
    String[] address = myTest2.address();
    double height = myTest2.height();
    String value = myTest2.value();
}

// 解析方法上的注解
Method m1 = c1.getMethod("go");
if(m1.isAnnotationPresent(MyTest2.class)){
    MyTest2 myTest2 = m1.getDeclaredAnnotation(MyTest2.class);
    // 获取属性值...
}
```


### 3.5 注解实际应用 - 模拟JUnit
```java
public class AnnotationDemo3 {
    public static void main(String[] args) {
        AnnotationDemo3 demo = new AnnotationDemo3();
        Class c1 = AnnotationDemo3.class;
        Method[] methods = c1.getMethods();
        
        for (Method method : methods) {
            if(method.isAnnotationPresent(MyTest3.class)){
                MyTest3 myTest3 = method.getDeclaredAnnotation(MyTest3.class);
                int count = myTest3.count();
                for (int i = 0; i < count; i++) {
                    try {
                        method.invoke(demo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    @MyTest3(count = 5)
    public void test1(){
        System.out.println("test1方法执行了");
    }
}
```


比喻理解：注解就像标签，贴在类、方法或属性上，用来标识特殊信息。就像商品上的标签，告诉别人这是什么、怎么用、有什么注意事项。

## 四、代理(Proxy)

代理模式是一种设计模式，为其他对象提供一种代理以控制对这个对象的访问。

### 4.1 静态代理
手动创建代理类，实现相同接口，在代理类中调用真实对象。

### 4.2 动态代理
Java提供`Proxy`类和`InvocationHandler`接口实现动态代理。

```java
public class ProxyUtil {
    public static StarService createProxy(Star star){
       StarService proxy = (StarService) Proxy.newProxyInstance(
               ProxyUtil.class.getClassLoader(),
               star.getClass().getInterfaces(), 
               new InvocationHandler() {
                   @Override
                   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                       if(method.getName().equals("sing")){
                           System.out.println("开始代理唱歌");
                           System.out.println("准备话筒，收钱20w！");
                       } else if (method.getName().equals("dance")){
                           System.out.println("开始代理跳舞");
                           System.out.println("准备舞台，收钱100w！");
                       }
                       // 真正执行明星的方法
                       Object result = method.invoke(star, args);
                       return result;
                   }
               });
       return proxy;
    }
}
```


### 4.3 代理的实际应用 - 性能监控
```java
public class ProxyUtil2 {
    public static <T> T createProxy(T user){
        T proxy = (T) Proxy.newProxyInstance(
                ProxyUtil2.class.getClassLoader(),
                user.getClass().getInterfaces(), 
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long start = System.currentTimeMillis();
                        Object result = method.invoke(user, args);
                        long end = System.currentTimeMillis();
                        System.out.println(method.getName()+"方法耗时"+(end-start)/1000.0+"秒");
                        return result;
                    }
                });
        return proxy;
    }
}
```


使用示例：
```java
UserService proxy = ProxyUtil2.createProxy(new UserServiceImp());
proxy.login("admin", "123456");  // 会输出方法执行时间
proxy.deleteUsers();             // 会输出方法执行时间
```


比喻理解：代理就像经纪人，客户不直接联系明星，而是通过经纪人。经纪人可以处理额外事务（如收钱、安排日程），然后再让明星执行真正的任务。

## 总结

Chapter6涵盖的核心知识点包括：

1. **JUnit单元测试**：自动化测试，保证代码质量
2. **反射机制**：运行时动态获取类信息，是框架开发基础
3. **注解技术**：为代码添加元数据，简化配置
4. **代理模式**：控制对象访问，实现增强功能

这些技术是Java高级开发的核心技能，广泛应用于各种框架中，如Spring的IoC、AOP，MyBatis的ORM等。掌握这些技术有助于理解框架原理，提高代码设计能力。