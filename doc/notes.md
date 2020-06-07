#### 1、查看版本对应
[查看版本对应](https://start.spring.io/actuator/info)

#### 2、版本选型
![](https://gitee.com/freedom9/markdown_images/raw/master/springcloud/%E7%89%88%E6%9C%AC%E9%80%89%E5%9E%8B.jpg)

#### 3、config动态刷新
##### 3.1 手动版
```
curl -X POST "http://localhost:3355/actuator/refresh"
```

##### 3.2 全部刷新
```
curl -X POST "http://localhost:3344/actuator/bus-refresh"
```

##### 3.3 定点刷新
```
curl -X POST "http://localhost:3344/actuator/bus-refresh/cloud-config-client:3355"
```

#### 5、注册中心的对比
![](https://gitee.com/freedom9/markdown_images/raw/master/springcloud/%E5%87%A0%E4%B8%AA%E6%B3%A8%E5%86%8C%E4%B8%AD%E5%BF%83%E5%AF%B9%E6%AF%94.jpg)