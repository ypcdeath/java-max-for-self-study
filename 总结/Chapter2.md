# Chapter2 学习内容总结

## 1. Map集合体系 🗺️

### Map接口特点
- **键值对存储**：像身份证和人的关系，一对一映射
- **键唯一性**：像手机号码，每个号码只能对应一个人
- **值可重复**：像职业，多个人可以从事同一职业

### 常见实现类对比
- **`HashMap`**：像超市储物柜，快速存取但无序排列
- **`LinkedHashMap`**：像图书馆书架，按存放顺序排列
- **`TreeMap`**：像电话簿，按键的自然顺序或自定义顺序排序

### Map核心操作
```java
Map<String, Integer> map = new HashMap<>();
map.put("张三", 23);        // 存入键值对
Integer age = map.get("张三"); // 根据键获取值
boolean hasKey = map.containsKey("张三"); // 检查是否存在键
```


## 2. Map遍历方式 🔍

### 三种主要遍历方法
1. **键找值遍历**：像查字典，先找目录再找内容
   ```java
   for(String key : map.keySet()) {
       Integer value = map.get(key);
   }
   ```


2. **Entry遍历**：像购物清单，直接拿到商品和价格
   ```java
   for(Map.Entry<String, Integer> entry : map.entrySet()) {
       String key = entry.getKey();
       Integer value = entry.getValue();
   }
   ```


3. **forEach遍历**：像快递配送，直接送货上门
   ```java
   map.forEach((k, v) -> System.out.println(k + "---" + v));
   ```


## 3. Stream流式编程 💧

### Stream核心概念
- **流水线操作**：像工厂生产线，数据依次经过各个工序处理
- **惰性求值**：像懒加载，只有遇到终结操作才真正执行

### 创建Stream的方式
- **集合创建**：`list.stream()` 像打开水龙头
- **数组创建**：`Arrays.stream(array)` 像连接水管
- **直接创建**：`Stream.of(1,2,3)` 像准备原材料

### 中间操作（Intermediate Operations）
- **filter过滤**：像筛子筛选豆子，留下符合条件的
- **sorted排序**：像排队，按规则重新排列
- **map转换**：像翻译，把一种语言转成另一种
- **distinct去重**：像去重工具，去除重复元素

### 终结操作（Terminal Operations）
- **collect收集**：像收网捕鱼，把处理结果收集起来
- **forEach遍历**：像广播通知，对每个元素执行操作
- **count计数**：像点名，统计元素个数
- **max/min最值**：像评选冠军亚军

## 4. Collections工具类 🛠️

### 常用功能
- **批量添加**：`Collections.addAll()` 像批发进货，一次性添加多个元素
- **打乱顺序**：`Collections.shuffle()` 像洗牌，随机改变元素顺序
- **排序**：`Collections.sort()` 像军训列队，按指定规则排列

## 5. 可变参数机制 🎯

### 特点和使用
```java
public static int sum(int... numbers) {
    // 可变参数像魔术口袋，可以装任意数量的同类型物品
    int total = 0;
    for(int num : numbers) {
        total += num;
    }
    return total;
}
```


## 6. 实际应用场景 🎮

### 斗地主案例综合运用
整个章节知识在斗地主游戏中得到了完美体现：
- **[Card](file://D:\JavaCode\JavaMax\2025-Chapter2\src\com\itheima\testdemo\Card.java#L6-L18)类**：封装扑克牌属性
- **[Room](file://D:\JavaCode\JavaMax\2025-Chapter2\src\com\itheima\testdemo\Room.java#L4-L74)类**：管理游戏流程
- **`Map<String,List<Card>>`**：存储玩家和手牌对应关系
- **`Collections.shuffle()`**：实现洗牌功能
- **自定义排序**：按牌面大小排序手牌

这个章节就像学习烹饪，从认识厨具(`Map`集合)、掌握切菜技巧(遍历方式)、学会调料搭配(Stream流)、熟悉厨房工具(Collections)到最终做出一道完整的菜品(斗地主游戏)，每个知识点都是构建复杂应用程序的重要基石。