# Chapter4 学习内容总结

## 1. 线程创建方式 🧵

### 继承Thread类
```java
class MyThread extends Thread{
    @Override
    public void run() {
        // 线程执行的任务
    }
}
// 使用
Thread th = new MyThread();
th.start();
```

像自己创业当老板，独立运营自己的业务。

### 实现Runnable接口
```java
class MyRunnable implements Runnable{
    @Override
    public void run() {
        // 线程执行的任务
    }
}
// 使用
Runnable r = new MyRunnable();
Thread tr = new Thread(r);
tr.start();
```

像接受外包任务，专注于完成指定工作。

### 实现Callable接口
```java
class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        // 可以返回结果的任务
        return "执行结果";
    }
}
// 使用
Callable<String> c = new MyCallable();
FutureTask<String> f = new FutureTask<>(c);
Thread tr = new Thread(f);
tr.start();
String result = f.get(); // 获取返回结果
```

像承接有偿服务，完成后需要交付成果。

## 2. 线程常用API ⚙️

### 线程名称管理
```java
Thread.currentThread().getName() // 获取当前线程名称
Thread th = new MyThread("线程名"); // 设置线程名称
```


### 线程休眠
```java
Thread.sleep(1000); // 让线程暂停1秒
```

像闹钟定时，到时间再继续工作。

### 线程插队(join)
```java
t.join(); // 让当前线程等待t线程执行完毕后再继续
```

像插队买票，必须等前面的人办完才能轮到自己。

## 3. 线程安全问题 🔒

### 线程安全问题演示
多个线程同时操作共享资源时可能出现数据不一致问题，像多个窗口同时卖票导致超卖。

### 同步代码块解决方案
```java
public void drawMoney(double target) {
    synchronized (this) {
        // 线程安全的操作代码
    }
}
```

像银行柜台，同一时间只能一个人办理业务。

### synchronized方法
```java
public synchronized void drawMoney(double target) {
    // 线程安全的方法
}
```

像会议室，进入前必须敲门确认是否有人占用。

### Lock锁机制
```java
private final Lock lock = new ReentrantLock();

public void drawMoney(double target) {
    lock.lock();
    try {
        // 线程安全的操作
    } finally {
        lock.unlock(); // 确保锁被释放
    }
}
```

像智能门锁，刷卡进入，离开时自动上锁。

## 4. 线程池管理 🏊

### ThreadPoolExecutor线程池
```java
ExecutorService pool = new ThreadPoolExecutor(
    3,           // 核心线程数
    5,           // 最大线程数
    10,          // 空闲线程存活时间
    TimeUnit.SECONDS,
    new ArrayBlockingQueue<>(3),  // 任务队列
    Executors.defaultThreadFactory(),
    new ThreadPoolExecutor.AbortPolicy() // 拒绝策略
);
```

像餐厅服务员管理，根据客流量动态调配服务员。

### Executors工具类
```java
ExecutorService pool = Executors.newFixedThreadPool(5); // 固定大小线程池
ExecutorService pool = Executors.newCachedThreadPool();  // 缓存线程池
ExecutorService pool = Executors.newSingleThreadExecutor(); // 单线程池
```

像现成的服务套餐，根据不同需求选择合适的配置。

## 5. 实际应用案例 💼

### 抢红包程序
- **数据竞争**：100个员工抢200个红包
- **同步保护**：使用`synchronized`关键字保护共享红包列表
- **随机分配**：通过`Math.random()`实现红包随机抽取

这个章节就像学习团队协作管理，从人员招聘(线程创建)、工作安排(API使用)、协调配合(线程同步)到人力资源优化(线程池)的完整管理体系。每个知识点都是构建高性能并发程序的基础组件。