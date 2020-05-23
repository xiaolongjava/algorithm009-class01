学习笔记
queue
    是一个接口 继承了collection接口
    方法：
        1、add :将指定元素添加到队列中
            IllegaStateExceptiion:队列容量不足 添加失败时 
            ClassCastException: 元素的类与队列泛型不一致
            NullPointException:指定元素不在队列中
            IllegaArgumentException: 元素的属性不允许添加
        2、offer:指定元素添加到队尾
            与add相比 在容量限制的时候 添加不会抛出异常 而是返回false
            其他的3个异常 依然抛出
        3、remove：移除队列头元素
            NoSuchElementException 当队列为空时 会抛出异常
        4、poll ：移除队列头元素
           不会抛出异常
        5、element
            获取队列头元素 会抛出异常
        6、peek
            获取队列头元素
            
priorityQueue
    是一个类 继承了 AbstractQueue
    AbstractQueue 继承了 AbstractCollection 实现了Queue 接口
    构造器
        1、无参构造器 默认空间大小=11;
        2、含参构造器(空间大小) 初始化默认空间为入参大小
        3、含参构造器(比较函数) 空间大小为11；初始化对比规则
        4、含参构造器(空间大小+比较函数)
        5、含参构造器(可以初始化 collection sortedset priorityQueue)
    方法：
        grow :扩容方法
            如果旧的空间小于64 就翻倍 否则就增加50%
            同时与最大允许空间做比较  超出则OOM
        1、add
            判空 为空 抛出空指针
            调用次数++
            判断是否需要扩容 需要就扩容 
            size++
            如果队列为空 赋值给0的下标
            添加元素时判断是否设置自定义对比规则
            默认为小顶堆
        2、clear 删除所有队列中元素
        3、comparator    返回此队列的比较器
        4、contains  返回是否包含指定元素
        5、iterator  返回迭代器
        6、offer 元素插入队列中
        7、remove    删除指定元素
        8、spliterator   
        9、toArray() 返回包含队列中所有元素的数组
        10、toArray(T[] a)   