waimai program - SpringBoot(外卖管理系统)

---

> 本项目是为餐饮企业定制的一款软件产品，包括系统管理后台和移动端应用两部分。
>
> 其中系统管理后台主要提供给餐饮企业内部员工使用，可以对餐厅的菜品、套餐、订单等进行管理维护。
>
> 移动端应用主要提供给消费者使用，可以在线浏览菜品、添加购物车、下单等。
>
> by 赵俊人

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/show02.png" width="17.5%">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/show01.png" width="79%">

## 项目介绍

---

### 💻 环境

- Intellij IDEA 2021.2
- JDK 8.0 版本
- Maven 3.3.9
- MySql 8.0.23
- Redis 3.0.504

### 🛠️ 技术选型

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/jsxx.png" width="100%">

### 🔦 功能架构

[comment]: <> (<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/gnjg.png" width="100%">)

#### 📱 移动端应用

<table>
<tr>
<tr>
<td>手机号登录</td>
<td>个人中心</td>
<td>地址管理</td>
<td>历史订单</td>
<td>浏览菜品、套餐</td>
</tr>
<td>购物车</td>
<td>添加购物车</td>
<td>清空购物车</td>
<td>下单</td>
<td>菜品浏览</td></tr>
</table>

#### 🖥️ 系统管理后台

<table>
<th>类别</th>
<th colspan="8">功能</th>
<tr>
<td>员工管理</td>
<td>员工登录</td>
<td>员工退出</td>
<td>新增员工</td>
<td>修改信息</td>
<td>员工列表</td>
<td>启用/禁用</td>
</tr>
<tr>
<td>分类管理</td>
<td>新增分类</td>
<td>新增套餐</td>
<td colspan="2">修改分类/套餐</td>
<td>分类列表</td>
<td>删除分类</td>
</tr>
<tr>
<td>菜品管理</td>
<td>新增菜品</td>
<td>修改菜品</td>
<td>菜品列表</td>
<td>删除菜品</td>
<td colspan="2">启售/停售</td>
</tr>
<tr>
<td>套餐管理</td>
<td>新增套餐</td>
<td>修改套餐</td>
<td>套餐列表</td>
<td>删除套餐</td>
<td colspan="2">启售/停售</td>
</tr>
<tr>
<td>订单明细</td>
<td colspan="2">订单列表</td>
<td colspan="2">订单操作（查看/配送）</td>
<td colspan="2">查询订单</td>
</tr>
</table>

### 🧑🏻 角色

- #### 后台系统管理员：登录后台系统，拥有后台系统中的操作权限
- #### 后台系统普通员工：登录后台系统，对菜品、套餐、订单进行管理
- #### C端用户：登录移动端应用，可以浏览菜品、添加购物车、设置地址、在线下单等

## 项目使用

---

### 📄 使用说明

1. #### 本项目自带前端代码，也可以不用分离运行
2. #### 注意：启动项目前，需要启动Redis服务，因为项目前端验证码、前后端的菜品、套餐等模块都使用到了Redis。
3. #### 使用时需要使用相应的端口及主机地址，可通过配置文件修改。
- 后台管理：http://localhost:8080/backend/index.html
- 前端页面：http://localhost:8080/front/index.html


### 🔑 项目优化

#### 在原本项目的基础上，我自行实现了如下功能：

1. ###### 菜品（批量）启售和（批量）停售
2. ###### 菜品的批量删除
3. ###### 套餐的（批量）启售、停售
4. ###### 套餐管理的修改
5. ###### 后台按条件查看和展示客户订单
6. ###### 手机端减少购物车中的菜品或者套餐数量
7. ###### 用户查看自己订单 移动端点击套餐图片查看套餐具体菜品

### 🧬 开发目录

0. #### [环境搭建](#0)
1. #### [后台登录功能开发](#1)
2. #### [后台退出功能开发](#2)
3. #### [完善登录功能](#3)
4. #### [新增员工](#4)
5. #### [员工分类查询](#5)
6. #### [启用/禁用员工账号](#6)
7. #### [编辑员工信息](#7)
8. #### [公共字段自动填充](#8)
9. #### [新增分类](#9)
10. #### [分类信息分页查询](#10)
11. #### [删除分类](#11)
12. #### [修改分类](#12)
13. #### [文件上传](#13)
14. #### [文件下载](#14)
15. #### [新增菜品](#15)
16. #### [菜品信息分页查询](#16)
17. #### [修改菜品](#17)
18. #### [停售/启售菜品，删除菜品](#18)
19. #### [新增套餐](#19)
20. #### [套餐分页查询](#20)
21. #### [删除、起售、停售套餐](#21)
22. #### [修改套餐](#22)
23. #### [短信发送](#23)
24. #### [手机验证码登录](#24)
25. #### [地址簿相关功能](#25)
26. #### [菜品展示](#26)
27. #### [购物车](#27)
28. #### [下单](#28)
29. #### [功能补充](#29)
30. #### [缓存优化](#30)

<h2 id="0">环境搭建</h2>

---

### 数据库环境搭建

1. #### 创建数据库

按如图设置在数据库软件创建出对应数据库

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/createDB.png" width="60%">

或者使用命令行创建数据库

`create database reggie character set utf8mb4`

2. ##### 执行SQL脚本 db_reggie.sql

存放路径：cc_reggie\src\main\resources\db_reggie.sql

直接运行sql文件：

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/importDB.png" width="60%">

- 或者使用命令行导入数据库：`source D:\db_reggie.sql`

3. ##### 数据库表说明

 <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/sjb.png" width="80%">

---

### maven项目搭建

1. #### 创建maven工程（可以直接创建SpringBoot工程）

 <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/createMaven.png" width="80%">

2. #### 导入maven配置

- 添加spring-boot-starter-parent
- 指定java版本为1.8
- 导入依赖
- 添加spring-boot-maven-plugin插件

完整pom.xml文件如下：

pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.4.5</version>
    <relativePath/> <!-- lookup parent from repository -->
  </parent>
  <groupId>com.cc</groupId>
  <artifactId>reggie</artifactId>
  <version>1.0-SNAPSHOT</version>
  <properties>
    <java.version>1.8</java.version>
  </properties>
  <dependencies>

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter</artifactId>
    </dependency>

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      <scope>compile</scope>
    </dependency>

    <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>mybatis-plus-boot-starter</artifactId>
      <version>3.4.2</version>
    </dependency>

    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.24</version>
    </dependency>

    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>fastjson</artifactId>
      <version>1.2.76</version>
    </dependency>

    <dependency>
      <groupId>commons-lang</groupId>
      <artifactId>commons-lang</artifactId>
      <version>2.6</version>
    </dependency>

    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <scope>runtime</scope>
    </dependency>

    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid-spring-boot-starter</artifactId>
      <version>1.1.23</version>
    </dependency>

    <dependency>
      <groupId>com.aliyun</groupId>
      <artifactId>aliyun-java-sdk-core</artifactId>
      <version>4.5.16</version>
    </dependency>

    <dependency>
      <groupId>com.aliyun</groupId>
      <artifactId>aliyun-java-sdk-dysmsapi</artifactId>
      <version>2.1.0</version>
    </dependency>

    <dependency>
      <groupId>com.aliyun</groupId>
      <artifactId>dysmsapi20170525</artifactId>
      <version>2.0.5</version>
    </dependency>

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>


  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <version>2.4.5</version>
      </plugin>
    </plugins>
  </build>

</project>
```

3. #### 配置application.yml

- 在resources目录下创建application.yml
- 配置端口
- 配置项目名称
- 配置数据库连接

完整application.yml文件如下：
- application.yml
```yml
server:
  port: 8080 //端口号
spring:
  main:
    allow-bean-definition-overriding: true  //允许bean定义覆盖
  application:
    name: cc_reggie
  datasource:
    druid:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://localhost:3306/reggie?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true
      username: root
      password: 123456
  redis:
    host: 127.0.0.1  //redis服务器地址
    port: 6379      //redis服务器端口
    #    password: 123456  //redis服务器密码
    database: 0
    cache:
      redis:
        time-to-live: 1800000   //缓存时间
mybatis-plus:
  configuration:
    #在映射实体或者属性时，将数据库中表名和字段名中的下划线去掉，按照驼峰命名法映射
    map-underscore-to-camel-case: true
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    db-config:
      id-type: ASSIGN_ID
reggie:
  path: D:\\desktop\\img\\   //图片存放路径
```

4. #### 启动SpringBoot

创建启动类ReggieApplication，点击运行

- ReggieApplication.java
```java
package com.cc.reggie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@EnableCaching //开启缓存
public class ReggieApplication {
  public static void main(String[] args) {
    SpringApplication.run(ReggieApplication.class, args);
    log.info("项目启动成功...");
  }
}
```

 ---

### 导入前端页面

#### 1. 把资料里的backend和front目录复制到resources目录下

 <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/dir01.png" width="60%">

#### 2. 创建配置类WebMvcConfig配置前端资源请求映射

- WebMvcConfig.java
```java
package com.cc.reggie.config;

import com.cc.reggie.common.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
  /**
   * 设置静态资源映射
   *
   * @param registry
   */
  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    log.info("开始进行静态资源映射...");
    registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
    registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
  }
}

```

#### 3. 重启服务，访问 http://localhost:8080/backend/index.html  查看效果

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/index.png" width="100%">

<h2 id="1"> 一、后台登录功能开发</h2>

---

### 需求分析

- 登录页面展示(http://localhost:8080/backend/page/login/login.html)
  <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/login.png" width="100%">

- 查看登录请求信息
  <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/fsqq.png" width="100%">

- 数据模型（employee表）

### 代码开发

- 创建实体类Employee，和employee表进行映射

- Employee.java
```java
package com.cc.reggie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Employee implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String username;

  private String name;

  private String password;

  private String phone;

  private String sex;

  private String idNumber;

  private Integer status;

  @TableField(fill = FieldFill.INSERT)//插入时填充字段
  private LocalDateTime createTime;

  @TableField(fill = FieldFill.INSERT_UPDATE)//插入和更新时填充字段
  private LocalDateTime updateTime;

  @TableField(fill = FieldFill.INSERT)
  private Long createUser;

  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Long updateUser;

}
```

- 创建Controller，Service，Mapper

- EmployeeMapper.java

```java

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
```

- EmployeeService.java

```java
public interface EmployeeService extends IService<Employee> {
}
```

- EmployeeServiceImpl.java

```java

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
  @Autowired
  private EmployeeServiceImpl employeeService;
}
```

- EmployeeController.java

```java

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
  @Autowired
  private EmployeeServiceImpl employeeService;
}
```

- 导入返回结果类R
  - 此类是一个通用结果类，服务端响应的所有结果最终都会包装成此种类型返回给前端页面

- R.java
```java
package com.cc.reggie.common;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用结果返回类。服务端响应的数据最终都会封装成此对象,一定要实现erializable接口
 *
 * @param <T>
 */
@Data
public class R<T> implements Serializable {

  private Integer code; //编码：1成功，0和其它数字为失败

  private String msg; //错误信息

  private T data; //数据

  private Map map = new HashMap(); //动态数据

  public static <T> R<T> success(T object) {
    R<T> r = new R<T>();
    r.data = object;
    r.code = 1;
    return r;
  }

  public static <T> R<T> error(String msg) {
    R r = new R();
    r.msg = msg;
    r.code = 0;
    return r;
  }

  public R<T> add(String key, Object value) {
    this.map.put(key, value);
    return this;
  }

}
```

- 在Controller中创建登录方法

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/login02.png" width="50%">
<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/md5.png" width="50%">

- EmployeeController.java

```java
    /**
 * 员工登录
 *
 * @param request
 * @param employee
 * @return
 */
@PostMapping("/login")
public R<Object> login(HttpServletRequest request,@RequestBody Employee employee){
        return employeeService.login(request,employee);
        }
```

- EmployeeService.java

```java
   //员工登录
public R<Object> login(HttpServletRequest request,@RequestBody Employee employee);
```

- EmployeeServiceImpl.java

```java
/**
 * 员工登录
 *
 * @param request
 * @param employee
 * @return
 */
@Transactional
@Override
public R<Object> login(HttpServletRequest request,Employee employee){
        //1.将页面提交的密码password进行md5加密
        String password=employee.getPassword();
        password=DigestUtils.md5DigestAsHex(password.getBytes());

        //2.根据页面提交用户名username查询数据库
        LambdaQueryWrapper<Employee> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp=employeeService.getOne(queryWrapper);

        //3.如果没有查询到则返回登陆失败结果
        if(emp==null){
        return R.error("登陆失败：用户名错误！");
        }

        //4.密码比对，如果不一致则返回登录失败结果
        if(!emp.getPassword().equals(password)){
        return R.error("登陆失败：密码错误！");
        }

        //5.查看员工状态，如果已禁用状态，则返回员工已禁用
        if(emp.getStatus()==0){
        return R.error("账号已禁用！");
        }

        //6.登录成功，将员工id存入Session并返回登录成功结果
        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);
        }
```

<h2 id="2">二、后台退出功能开发</h2>

---

### 需求分析

 <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/ht.png" width="100%">

### 代码实现

- EmployeeController.java

```java
/**
 * 员工退出
 *
 * @param request
 * @return
 */
@PostMapping("/logout")
public R<String> logout(HttpServletRequest request){
        return employeeService.logout(request);
        }
```

- EmployeeService.java

```java
//员工退出
public R<String> logout(HttpServletRequest request);
```

- EmployeeServiceImpl.java

```java
    /**
 * 员工退出
 *
 * @param request
 * @return
 */
@Override
public R<String> logout(HttpServletRequest request){
        //清理Session中保存的当前登录员工id
        request.getSession().removeAttribute("employee");
        return R.success("退出成功！");
        }
```

<h2 id="3">三、完善登录功能<h3>

---

### 问题分析

前面我们已经完成了后台系统的员工登录功能开发，但是还存在一个问题:用户如果不登录，直接访问系统首页面，照样可以正常访问。

这种设计并不合理，我们希望看到的效果应该是，只有登录成功后才可以访问系统中的页面，如果没有登录则跳转到登录页面。

解决方案：使用过滤器或者拦截器，在过滤器或者拦截器中判断用户是否已经完成登录，如果没有登录则跳转到登录页面

### 代码实现

- 创建自定义过滤器LoginCheckFilter

- LoginCheckFilter.java
```java

@WebFilter(filterName = "LoginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    log.info("拦截到请求：{}", request.getRequestURI());
    filterChain.doFilter(request, response);
  }
}
```

- 在启动类上加入注解@ServletComponentScan

```java

@Slf4j
@SpringBootApplication
@ServletComponentScan
public class ReggieApplication {
  public static void main(String[] args) {
    SpringApplication.run(ReggieApplication.class, args);
    log.info("项目启动成功！！！");
  }
}
```

- 过滤器具体的处理逻辑如下:

1. 获取本次请求的URI
2. 判断本次请求是否需要处理
3. 如果不需要处理，则直接放行
4. 判断登录状态，如果已登录，则直接放行
5. 如果未登录则返回未登录结果

 <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/filter.png" width="80%">

- LoginCheckFilter.java
```java
package com.cc.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.cc.reggie.common.BaseContext;
import com.cc.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否完成登录
 */
@ServletComponentScan
@WebFilter(filterName = "LoginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
  //路径匹配器，支持通配符
  public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    //1.获取本次请求的URL
    String requestURI = request.getRequestURI();
    log.info("拦截到请求：{}", requestURI);

    //定义不需要处理的路径
    String[] urls = new String[]{
            "/employee/login",
            "/employee/logout",
            "/backend/**",
            "/front/**",
            "/common/**",
            "/user/sendMsg",
            "/user/login",
            "/user/sendMsg",
            "/webjars/**"
    };

    //2.判断本次请求是否要处理
    boolean check = check(urls, requestURI);

    //3.如果不需要处理，则直接放行
    if (check) {
      log.info("本次请求{}不需要处理", requestURI);
      filterChain.doFilter(request, response);
      return;
    }

    //4-1.判断登录状态，如果已登录，则直接放行
    if (request.getSession().getAttribute("employee") != null) {
      log.info("用户已登录，用户id为：{}", request.getSession().getAttribute("employee"));

      Long empId = (Long) request.getSession().getAttribute("employee");
      BaseContext.setCurrentId(empId);

//            long id = Thread.currentThread().getId();
//            log.info("线程id为{}", id);

      filterChain.doFilter(request, response);
      return;
    }
    log.info("用户未登录");

    //4-2.判断登录状态，如果已登录，则直接放行
    if (request.getSession().getAttribute("user") != null) {
      log.info("用户已登录，用户id为：{}", request.getSession().getAttribute("user"));

      Long usersId = (Long) request.getSession().getAttribute("user");
      BaseContext.setCurrentId(usersId);

      filterChain.doFilter(request, response);
      return;
    }

    //5.如果未登录则返回未登录结果,通过输出流向客户都页面响应数据
    log.info("用户未登录");
    response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
    return;
  }

  /**
   * 路径匹配，检查本次请求是否需要放行
   *
   * @param urls
   * @param requestURI
   * @return
   */
  public boolean check(String[] urls, String requestURI) {
    for (String url : urls) {
      boolean match = PATH_MATCHER.match(url, requestURI);
      if (match) {
        return true;
      }
    }
    return false;
  }
}
```

<h2 id="4">四、新增员工</h2>

---

### 需求分析

后台系统中可以管理员工信息，通过新增员工来添加后台系统用户。点击 添加员工 按钮跳转到新增页面，如下:

 <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xzyg.png" width="80%">

### 数据模型

新增员工，其实就是将我们新增页面录入的员工数据插入到employee表。需要注意，employee表中对username字段加入了唯一约束，因为username是员工的登录账号，必须是唯一的

### 代码开发

在开发代码之前，需要梳理一下整个程序的执行过程:

- 页面发送ajax请求，将新增员工页面中输入的数据以json的形式提交到服务端
- 服务端Controller接收页面提交的数据并调用Service将数据进行保存
- Service调用Mapper操作数据库，保存数据

  <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xzyg02.png" width="100%">

- EmployeeController.java

```java
 /**
 * 新增员工
 *
 * @param employee
 * @return
 */
@PostMapping
public R<String> save(HttpServletRequest request,@RequestBody Employee employee){
        return employeeService.save(request,employee);
        }
```

- EmployeeService.java

```java
//新增员工
public R<String> save(HttpServletRequest request,@RequestBody Employee employee);
```

- EmployeeServiceImpl.java

```java
/**
 * 新增员工
 *
 * @param employee
 * @return
 */
@Transactional
@Override
public R<String> save(HttpServletRequest request,Employee employee){
        log.info("新增员工，员工信息：{}",employee.toString());
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

//        employee.setCreateTime(LocalDateTime.now());
//        employee.setUpdateTime(LocalDateTime.now());

        //获得当前登录用户的id
//        Long empID = (Long) request.getSession().getAttribute("employee");

//        employee.setCreateUser(empID);
//        employee.setUpdateUser(empID);

        employeeService.save(employee);

        return R.success("新增员工成功");
        }
```

前面的程序还存在一个问题，就是当我们在新增员工时输入的账号已经存在，由于employee表中对该字段加入了唯一约束，此时程序会抛出异常:

```java
java.sql.SQLIntegrityConstraintViolationException:Duplicate entry'heniang'for key'idx_username'
```

此时需要我们的程序进行异常捕获，通常有两种处理方式:

1. 在Controller方法中加入try.catch进行异常捕获
2. 使用异常处理器进行全局异常捕获

```java

@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

  //进行异常处理方法
  @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
  public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex) {
    log.error(ex.getMessage());

    if (ex.getMessage().contains("Duplicate entry")) {
      String[] split = ex.getMessage().split(" ");
      String msg = split[2] + "已存在";
      return R.error(msg);
    }

    return R.error("未知错误");
  }
}
```

### 总结

1. ##### 根据产品原型明确业务需求
2. ##### 重点分析数据的流转过程和数据格式
3. ##### 通过debug断点调试跟踪程序执行过程

<h2 id="5">五、员工分页查询</h5>

---

### 需求分析

系统中的员工很多的时候，如果在一个页面中全部展示出来会显得比较乱，不便于查看，所以一般的系统中都会以分页的方式来展示列表数据。
<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/ygfy.png" width="100%">

### 代码开发

在开发代码之前，需要梳理一下整个程序的执行过程:

- 页面发送ajax请求，将分页查询参数(page.pageSize、name)提交到服务端
- 服务端Controller接收页面提交的数据并调用Service查询数据
- Service调用Mapper操作数据库，查询分页数据
- Controller将查询到的分页数据响应给页面
- 页面接收到分页数据并通过ElementUI的Table组件展示到页面上

配置MP分页插件

- MybatisPlusConfig.java
```java

@Configuration
public class MybatisPlusConfig {
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
    mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
    return mybatisPlusInterceptor;
  }
}
```

员工信息分页查询

- EmployeeController.java

```java
 /**
 * 员工信息查询
 *
 * @param page
 * @param pageSize
 * @param name
 * @return
 */
@GetMapping("/page")
public R<Page> page(int page,int pageSize,String name){
        return employeeService.page(page,pageSize,name);
        }
```

- EmployeeService.java

```java
 //员工分页
public R<Page> page(int page,int pageSize,String name);
```

- EmployeeServiceImpl.java

```java
 /**
 * 员工信息查询
 *
 * @param page
 * @param pageSize
 * @param name
 * @return
 */
@Transactional
@Override
public R<Page> page(int page,int pageSize,String name){
        log.info("page = {}，pageSize = {},name = {}",page,pageSize,name);

        //构造分页条件
        Page pageInfo=new Page(page,pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Employee> queryWrapper=new LambdaQueryWrapper();
        //添加一个过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name),Employee::getName,name);
        //添加排序条件
        queryWrapper.orderByDesc(Employee::getUpdateTime);

        //执行查询
        employeeService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
        }
```

<h2 id="6">六、启用/禁用员工账号</h6>

---

### 需求分析

在员工管理列表页面，可以对某个员工账号进行启用或者禁用操作。账号禁用的员工不能登录系统，启用后的员工可以正常登录。

需要注意，只有管理员（admin用户）可以对其他普通用户进行启用、禁用操作，所以普通用户登录系统后启用、禁用按钮不显示。

### 代码开发

页面中是怎么做到只有管理员admin能够看到启用、禁用按钮的？

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/qyzt.png" width="50%">

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/qyzt1.png" width="50%">

在开发代码之前，需要梳理一下整个程序的执行过程:

1. 页面发送ajax请求，将参数(id、 status)提交到服务端
2. 服务端Controller接收页面提交的数据并调用Service更新数据
3. Service调用Mapper操作数据库

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/qyzt03.png" width="80%">

页面中的ajax请求是如何发送的？

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/qyzt2.png" width="100%">

根据id修改员工信息

- EmployeeController.java

```java
/**
 * 根据id修改员工信息
 *
 * @param employee
 * @return
 */
@PutMapping
public R<String> update(HttpServletRequest request,@RequestBody Employee employee){
        return employeeService.update(request,employee);
        }
```

- EmployeeService.java

```java
//修改员工
public R<String> update(HttpServletRequest request,@RequestBody Employee employee);
```

- EmployeeServiceImpl.java

```java
/**
 * 员工信息更新
 *
 * @param employee
 * @return
 */
@Transactional
@Override
public R<String> update(HttpServletRequest request,Employee employee){
        log.info(employee.toString());

        long id=Thread.currentThread().getId();
        log.info("线程id为{}",id);

        Long empId=(Long)request.getSession().getAttribute("employee");
        employee.setUpdateTime(LocalDateTime.now());
        employee.setUpdateUser(empId);
        employeeService.updateById(employee);
        return R.success("员工信息修改成功！");
        }
```

测试过程中没有报错，但是功能并没有实现，查看数据库中的数据也没有变化。观察控制台输出的SQL:

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/qyzt5.png" width="100%">

SQL执行的结果是更新的数据行数为0，仔细观察id的值，和数据库中对应记录的id值并不相同

### 代码修复

通过观察控制台输出的SQL发现页面传递过来的员工id的值和数据库中的id值不一致，这是怎么回事呢?

分页查询时服务端响应给页面的数据中id的值为19位数字，类型为long

页面中js处理long型数字只能精确到前16位，所以最终通过ajax请求提交给服务端的时候id就改变了

前面我们已经发现了问题的原因，即js对long型数据进行处理时丢失精度，导致提交的id和数据库中的id不一致。

如何解决这个问题?

我们可以在服务端给页面响应json数据时进行处理，将long型数据统一转为String字符串。

具体实现步骤:

1) 提供对象转换器JacksonobjectMapper，基于Jackson进行Java对象到json数据的转换（资料中已经提供，直接复制到项目中使用)

```java
/**
 * 对象映射器:基于jackson将Java对象转为json，或者将json转为Java对象
 * 将JSON解析为Java对象的过程称为 [从JSON反序列化Java对象]
 * 从Java对象生成JSON的过程称为 [序列化Java对象到JSON]
 */
public class JacksonObjectMapper extends ObjectMapper {

  public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
  public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
  public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

  public JacksonObjectMapper() {
    super();
    //收到未知属性时不报异常
    this.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

    //反序列化时，属性不存在的兼容处理
    this.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);


    SimpleModule simpleModule = new SimpleModule()
            .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)))
            .addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)))
            .addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT)))

            .addSerializer(BigInteger.class, ToStringSerializer.instance)
            .addSerializer(Long.class, ToStringSerializer.instance)
            .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)))
            .addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)))
            .addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT)));

    //注册功能模块 例如，可以添加自定义序列化器和反序列化器
    this.registerModule(simpleModule);
  }
}

```

2) 在WebMvcConfig配置类中扩展Spring mvc的消息转换器，在此消息转换器中使用提供的对象转换器进行Java对象到json数据的转换

```java
@Override
protected void extendMessageConverters(List<HttpMessageConverter<?>>converters){
        //创建消息转换器
        MappingJackson2HttpMessageConverter messageConverter=new MappingJackson2HttpMessageConverter();
        //设置对象转换器，底层使用Jackson将Java转换为json
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        //将上面的消息转换器对象追加到mvc框架的转换器集合中
        converters.add(0,messageConverter);
        super.extendMessageConverters(converters);
        }
```

<h2 id="7">七、编辑员工信息</h2>

---

### 需求分析

在员工管理列表页面点击编辑按钮，跳转到编辑页面，在编辑页面回显员工信息并进行修改，最后点击保存按钮完成编辑操作

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xgyg.png" width="100%">

### 代码开发

在开发代码之前需要梳理一下操作过程和对应的程序的执行流程:

1. 点击编辑按钮时，页面跳转到add.html，并在url中携带参数[员工id]
2. 在add.html页面获取url中的参数[员工id]
3. 发送ajax请求，请求服务端，同时提交员工id参数
4. 服务端接收请求，根据员工id查询员工信息，将员工信息以json形式响应给页面

- EmployeeController.java

```java
/**
 * 根据id查询员工信息
 *
 * @param id
 * @return
 */
@GetMapping("/{id}")
public R<Employee> findById(@PathVariable Long id){
        return employeeService.findById(id);
        }
```

- EmployeeService.java

```java
//根据信息查询员工
public R<Employee> findById(@PathVariable Long id);
```

- EmployeeServiceImpl.java

```java
 /**
 * 根据id查询员工信息
 *
 * @param id
 * @return
 */
@Transactional
@Override
public R<Employee> findById(Long id){
        log.info("根据id查询员工信息...");
        if(id!=null){
        return R.success(employeeService.getById(id));
        }
        return R.error("没有查询到对应员工信息！");
        }
```

5. 页面接收服务端响应的json数据，通过VUE的数据绑定进行员工信息回显
6. 点击保存按钮，发送ajax请求，将页面中的员工信息以json方式提交给服务端
7. 服务端接收员工信息，并进行处理，完成后给页面响应
8. 页面接收到服务端响应信息后进行相应处理

注意:add.html页面为公共页面，新增员工和编辑员工都是在此页面操作，所以该代码部分与之前添加员工代码对应，不需要重写。

<h2 id="8">八、公共字段自动填充</h6>

---

### 问题分析

前面我们已经完成了后台系统的员工管理功能开发，在新增员工时需要设置创建时间、创建人、修改时间、修改人等字段，在编辑员工时需要设置修改时间和修改人等字段。这些字段属于公共字段，也就是很多表中都有这些字段，如下:

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/ggzd.png" width="50%">

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/ggzd02.png" width="80%">

能不能对于这些公共字段在某个地方统一处理，来简化开发呢?答案就是使用Mybatis Plus提供的公共字段自动填充功能。

### 代码实现

Mybatis Plus公共字段自动填充，也就是在插入或者更新的时候为指定字段赋予指定的值，使用它的好处就是可以统一对这些字段进行处理，避免了重复代码。

实现步骤:

1. 在实体类的属性上加入@TableField注解，指定自动填充的策略

```java
@TableField(fill = FieldFill.INSERT)//插入时填充字段
private LocalDateTime createTime;

@TableField(fill = FieldFill.INSERT_UPDATE)//插入和更新时填充字段
private LocalDateTime updateTime;

@TableField(fill = FieldFill.INSERT)
private Long createUser;

@TableField(fill = FieldFill.INSERT_UPDATE)
private Long updateUser;
```

2. 按照框架要求编写元数据对象处理器，在此类中统一为公共字段赋值，此类需要实现MetaObjectHandler接口

- MyMetaObjecthander.java

```java
/**
 * 自定义元数据处理器
 */
@Component
@Slf4j
public class MyMetaObjecthander implements MetaObjectHandler {
  /**
   * 插入操作，自动填充
   *
   * @param metaObject
   */
  @Override
  public void insertFill(MetaObject metaObject) {
    log.info("公共字段自动填充[insert]...");
    log.info(metaObject.toString());
    metaObject.setValue("createTime", LocalDateTime.now());
    metaObject.setValue("updateTime", LocalDateTime.now());
    metaObject.setValue("createUser", BaseContext.getCurrentId());
    metaObject.setValue("updateUser", BaseContext.getCurrentId());
  }

  /**
   * 更新操作，自动填充
   *
   * @param metaObject
   */
  @Override
  public void updateFill(MetaObject metaObject) {
    log.info("公共字段自动填充[update]...");
    log.info(metaObject.toString());

    long id = Thread.currentThread().getId();
    log.info("线程id为{}", id);

    metaObject.setValue("updateTime", LocalDateTime.now());
    metaObject.setValue("updateUser", BaseContext.getCurrentId());
  }
}
```

#### 功能完善

前面我们已经完成了公共字段自动填充功能的代码开发，但是还有一个问题没有解决，就是我们在自动填充createUser和updateUser时设置的用户id是固定值，现在我们需要改造成动态获取当前登录用户的id。

有的同学可能想到，用户登录成功后我们将用户id存入了HttpSession中，现在我从HttpSession中获取不就行了?

注意，我们在MyMetaObjectHandler类中是不能获得HttpSession对象的，所以我们需要通过其他方式来获取登录用户id。

可以使用ThreadLocal来解决此问题,它是JDK中提供的一个类。

在学习ThreadLocal之前，我们需要先确认一个事情，就是客户端发送的每次http请求，对应的在服务端都会分配一个新的线程来处理，在处理过程中涉及到下面类中的方法都属于相同的一个线程:

1. LoginCheckFilter的doFilter方法
2. EmployeeContraller的update方法
3. MyMetaObjectHandler的updateFill方法

可以在上面的三个方法中分别加入下面代码（获取当前线程id):

```java
long id=Thread.currentThread().getId();
        log.info("线程id:{}",id);
```

执行编辑员工功能进行验证，通过观察控制台输出可以发现，一次请求对应的线程id是相同的

**什么是ThreadLocal?**

ThreadLocal并不是一个Thread，而是Thread的局部变量。当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
ThreadLocal为每个线程提供单独一份存储空间，具有线程隔离的效果，只有在线程内才能获取到对应的值，线程外则不能访问。

ThreadLocal常用方法：

    public void set(T value) 设置当前线程局部变量的值
    public T get() 返回当前线程所对应的线程局部变量的值

我们可以在LoginCheckFilter的doFilter方法中获取当前登录用户id，并调用ThreadLocal的set方法来设置当前线程的线程局部变量的值（用户id)
，然后在MyMetaObjectHandler的updateFill方法中调用ThreadLocal的get方法来获得当前线程所对应的线程局部变量的值(用户id)。

### 实现步骤:

1. 编写BaseContext工具类，基于ThreadLocal封装的工具类

```java
/**
 * 基于ThreadLocal封装的工具类，用于保存和获取当前登录用户的id
 */
public class BaseContext {
  private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

  public static void setCurrentId(Long id) {
    threadLocal.set(id);
  }

  public static Long getCurrentId() {
    return threadLocal.get();
  }
}
```

2. 在LogincheckFilter的doFilter方法中调用BaseContext来设置当前登录用户的id

LogincheckFilter.java

```java
if(request.getSession().getAttribute("employee")!=null){
        log.info("用户已登录，用户id为：{}",request.getSession().getAttribute("employee"));

        Long empId=(Long)request.getSession().getAttribute("employee");

        BaseContext.setCurrentId(empId);

        filterChain.doFilter(request,response);
        return;
        }
```

3. 在MyMeta0bjectHandler的方法中调用BaseContext获取登录用户的id

```java

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
  //插入时自动填充
  @Override
  public void insertFill(MetaObject metaObject) {
    log.info("公共字段自动填充【insert】...");
    log.info(metaObject.toString());
    metaObject.setValue("createTime", LocalDateTime.now());
    metaObject.setValue("updateTime", LocalDateTime.now());
    metaObject.setValue("createUser", BaseContext.getCurrentId());
    metaObject.setValue("updateUser", BaseContext.getCurrentId());
  }

  //更新时自动填充
  @Override
  public void updateFill(MetaObject metaObject) {
    log.info("公共字段自动填充【update】...");
    log.info(metaObject.toString());

    metaObject.setValue("updateTime", LocalDateTime.now());
    metaObject.setValue("updateUser", BaseContext.getCurrentId());
  }
}
```

<h2 id="9">九、新增分类</h5>

---

### 需求分析

后台系统中可以管理分类信息，分类包括两种类型，分别是菜品分类和套餐分类。当我们在后台系统中添加菜品时需要选择一个菜品分类，当我们在后台系统中添加一个套餐时需要选择一个套餐分类，在移动端也会按照菜品分类和套餐分类来展示对应的菜品和套餐。

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xzfl1.png" width="45%"> <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xzfl2.png" width="45%">

### 数据模型

新增分类，其实就是将我们新增窗口录入的分类数据插入到category表，表结构如下:
<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xzfl3.png" width="80%">

### 代码开发

在开发业务功能前，先将需要用到的类和接口基本结构创建好:

- 实体类Category

```java

@Data
public class Category implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;


  //类型 1 菜品分类 2 套餐分类
  private Integer type;


  //分类名称
  private String name;


  //顺序
  private Integer sort;


  //创建时间
  @TableField(fill = FieldFill.INSERT)
  private LocalDateTime createTime;


  //更新时间
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime updateTime;


  //创建人
  @TableField(fill = FieldFill.INSERT)
  private Long createUser;


  //修改人
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Long updateUser;


  //是否删除
  private Integer isDeleted;

}
```

- CategoryMapper.java

```java

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
```

- CategoryController.java

```java

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
  @Autowired
  private CategoryService categoryService;
}
```

- CategoryService.java

```java
public interface CategoryService extends IService<Category> {
}
```

- CategoryServicelmpl.java

```java

@Service
public class CategoryServicelmpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
  @Autowired
  private CategoryService categoryService;
}
```

在开发代码之前，需要梳理一下整个程序的执行过程:

1. 页面(backend/page/category/list.html)发送ajax请求，将新增分类窗口输入的数据以json形式提交到服务端
2. 服务端Controller接收页面提交的数据并调用Service将数据进行保存
3. Service调用Mapper操作数据库，保存数据

可以看到新增菜品分类和新增套餐分类请求的服务端地址和提交的json数据结构相同，所以服务端只需要提供一个方法统一处理即可

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xzfl4.png" width="80%">
<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xzfl5.png" width="80%">
<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xzfl6.png" width="80%">

- CategoryController.java

```java
/**
 * 添加菜品分类
 *
 * @return
 */
@PostMapping
public R<String> saveCategory(@RequestBody Category category){
        categoryService.saveCategory(category);
        return R.success("新增分类成功！");
        }
```

- CategoryService.java

```java
    //添加分类
public R<String> saveCategory(@RequestBody Category category);
```

- CategoryServicelmpl.java

```java
    /**
 * 添加菜品分类
 *
 * @return
 */
@Transactional
@Override
public R<String> saveCategory(Category category){
        log.info("category:{}",category);
        categoryService.save(category);
        return R.success("新增分类成功！");
        }
        }
```

<h2 id="10">十、 分类信息分页查询</h6>

---

### 需求分析

系统中的分类很多的时候，如果在一个页面中全部展示出来会显得比较乱，不便于查看，所以一般的系统中都会以分页的方式来展示列表数据。

### 代码开发

在开发代码之前，需要梳理一下整个程序的执行过程:

1. 页面发送ajax请求，将分页查询参数(page.pageSize)提交到服务端
2. 服务端Controller接收页面提交的数据并调用Service查询数据
3. Service调用Mapper操作数据库，查询分页数据
4. Controller将查询到的分页数据响应给页面
5. 页面接收到分页数据并通过ElementUI的Table组件展示到页面上

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/fycx.png" width="80%">

- CategoryController.java

```java
/**
 * 分页查询
 *
 * @param page
 * @param pageSize
 * @return
 */
@GetMapping("/page")
public R<Page> page(int page,int pageSize){
        return categoryService.page(page,pageSize);
        }
```

- CategoryService.java

```java
//分页查询
public R<Page> page(int page,int pageSize);
```

- CategoryServicelmpl.java

```java
/**
 * 分页查询
 *
 * @param page
 * @param pageSize
 * @return
 */
@Transactional
@Override
public R<Page> page(int page,int pageSize){
        //分页构造器
        Page<Category> pageInfo=new Page<>(page,pageSize);
        //条件构造器对象
        LambdaQueryWrapper<Category> queryWrapper=new LambdaQueryWrapper<>();
        //添加排序条件，根据sort进行排序
        queryWrapper.orderByAsc(Category::getSort);

        //进行分页查询
        categoryService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
        }
```

注意：要把Category中的private Integer isDeleted;注释掉才能查询到数据

<h2 id="11">十一、 删除分类</h6>

---

### 需求分析

在分类管理列表页面，可以对某个分类进行删除操作。需要注意的是当分类关联了菜品或者套餐时，此分类不允许删除。

### 代码开发

在开发代码之前，需要梳理一下整个程序的执行过程:

1. 页面发送ajax请求，将参数(id)提交到服务端

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/scfl.png" width="80%">

2. 服务端Controller接收页面提交的数据并调用Service删除数据
3. Service调用Mapper操作数据库

- CategoryController.java

```java
 /**
 * 根据id删除分类
 *
 * @param id
 * @return
 */
@DeleteMapping
public R<String> delete(Long id){
        categoryService.removeById(id);
        return R.success("删除分类成功！");
        }
```

- CategoryService.java

```java
    //删除分类
public R<String> delete(Long id);

public void remove(Long id);
```

- CategoryServicelmpl.java

```java
 /**
 * 根据id删除分类
 *
 * @param id
 * @return
 */
@Override
public R<String> delete(Long id){
        log.info("删除分类，id分类为：{}",id);
        categoryService.remove(id);
//        categoryService.removeById(id);
        return R.success("分类信息删除成功！");
        }
```

### 代码完善

前面我们已经实现了根据id删除分类的功能，但是并没有检查删除的分类是否关联了菜品或者套餐，所以我们需要进行功能完善。

要完善分类删除功能，需要先准备基础的类和接口:

1. 实体类Dish和Setmeal

- Dish.java

```java
/**
 * 菜品
 */
@Data
public class Dish implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;


  //菜品名称
  private String name;


  //菜品分类id
  private Long categoryId;


  //菜品价格
  private BigDecimal price;


  //商品码
  private String code;


  //图片
  private String image;


  //描述信息
  private String description;


  //0 停售 1 起售
  private Integer status;


  //顺序
  private Integer sort;


  @TableField(fill = FieldFill.INSERT)
  private LocalDateTime createTime;


  @TableField(fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime updateTime;


  @TableField(fill = FieldFill.INSERT)
  private Long createUser;


  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Long updateUser;


  //是否删除
  private Integer isDeleted;

}

```

- Setmeal.java

```java
/**
 * 套餐
 */
@Data
public class Setmeal implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;


  //分类id
  private Long categoryId;


  //套餐名称
  private String name;


  //套餐价格
  private BigDecimal price;


  //状态 0:停用 1:启用
  private Integer status;


  //编码
  private String code;


  //描述信息
  private String description;


  //图片
  private String image;


  @TableField(fill = FieldFill.INSERT)
  private LocalDateTime createTime;


  @TableField(fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime updateTime;


  @TableField(fill = FieldFill.INSERT)
  private Long createUser;


  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Long updateUser;


  //是否删除
  private Integer isDeleted;
}

```

- DishMapper.java

```java
public interface DishMapper extends BaseMapper<Dish> {
}

```

- SetmealMapper.java

```java

@Mapper
public interface SetmealMapper extends BaseMapper<Setmeal> {
}

```

- DishService.java

```java
public interface DishService extends IService<Dish> {
}
```

- SetmealService.java

```java
public interface SetmealService extends IService<Setmeal> {
}
```

- DishServiceImpl.java

```java

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}

```

- SetmealServiceImpl.java

```java

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}
```

### 关键代码

#### 在CategoryService添加remove方法

- CategoryService.java

```java
public void remove(Long id);
```

#### 在CategoryServicelmpl实现remove方法

- CategoryServicelmpl.java

```java
/**
 * 菜品分类业务接口
 *
 * @author 郑梓聪
 * @since 2022-06-21
 */
@Slf4j
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
  @Autowired
  private CategoryService categoryService;

  @Autowired
  private DishService dishService;

  @Autowired
  private SetmealService setmealService;


  /**
   * 根据id删除分类，删除之前进行判断
   *
   * @param id
   */
  @Override
  public void remove(Long id) {
    LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
    //添加查询条件，根据分类id进行查询
    dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
    int count1 = dishService.count(dishLambdaQueryWrapper);

    //查询当前分类是否关联了菜品，如果已经关联，抛出一个业务异常
    if (count1 > 0) {
      //已经关联了菜品，抛出业务异常
      throw new CustomException("当前分类下关联了菜品，不能删除");
    }

    //查询当前分类是否关联了套餐，如果已经关联，抛出一个业务异常
    LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
    //添加查询条件，根据分类id进行查询
    LambdaQueryWrapper<Setmeal> eq = setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
    int count2 = setmealService.count(eq);
    if (count2 > 0) {
      //已经关联套餐，抛出一个业务异常
      throw new CustomException("当前分类下关联了套餐，不能删除");
    }
    //正常删除
    super.removeById(id);
  }
}
```

#### 定义异常类CustomException

- CustomException.java

```java
public class CustomException extends RuntimeException {
  public CustomException(String message) {
    super(message);
  }
}
```

#### 在全局异常处理器GlobalExceptionHandler添加

- GlobalExceptionHandler.java

```java
//进行异常处理方法
@ExceptionHandler(CustomException.class)
public R<String> exceptionHandler(CustomException ex){
        log.error(ex.getMessage());

        return R.error(ex.getMessage());
        }
```

<h2 id="12">十二、 修改分类</h6>

---

### 需求分析

在分类管理列表页面点击修改按钮，弹出修改窗口，在修改窗口回显分类信息并进行修改，最后点击确定按钮完成修改操作

### 代码实现

- CategoryController.java

```java
    /**
 * 根据id修改分类信息
 *
 * @param category
 * @return
 */
@PutMapping
public R<String> update(@RequestBody Category category){
        categoryService.updateById(category);
        return R.success("修改分类成功！");
        }
```

- CategoryService.java

```java
    //更新分类信息
public R<String> update(@RequestBody Category category);
```

- CategoryServiceImpl.java

```java
    /**
 * 根据id修改分类信息
 *
 * @param category
 * @return
 */
@Transactional
@Override
public R<String> update(Category category){
        log.info("修改分类信息：{}",category);
        categoryService.updateById(category);
        return R.success("修改分类信息成功！");
        }
```

<h2 id="13">十三、 文件上传</h6>

---

### 文件上传介绍

文件上传，也称为upload，是指将本地图片、视频、音频等文件上传到服务器上，可以供其他用户浏览或下载的过程。文件上传在项目中应用非常广泛，我们经常发微博、发微信朋友圈都用到了文件上传功能。

文件上传时，对页面的form表单有如下要求:

- method="post"            采用post方式提交数据
- enctype="multipart/form-data"     采用multipart格式上传文件
- type="file"              使用input的file控件上传

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/wjsc.png" width="80%">

目前一些前端组件库也提供了相应的上传组件，但是底层原理还是基于form表单的文件上传。例如ElementUI中提供的upload上传组件:

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/wjsc2.png" width="80%">


服务端要接收客户端页面上传的文件，通常都会使用Apache的两个组件:

- commons-fileupload
- commons-io

Spring框架在spring-web包中对文件上传进行了封装，大大简化了服务端代码，我们只需要在Controller的方法中声明一个MultipartFile类型的参数即可接收上传的文件。

### 文件下载介绍

文件下载，也称为download，是指将文件从服务器传输到本地计算机的过程。 通过浏览器进行文件下载，通常有两种表现形式:

- 以附件形式下载，弹出保存对话框，将文件保存到指定磁盘目录
- 直接在浏览器中打开

通过浏览器进行文件下载，本质上就是服务端将文件以流的形式写回浏览器的过程。

### 文件上传代码实现

文件上传，页面端可以使用ElementuI提供的上传组件。 可以直接使用资料中提供的上传页面

- upload.html

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>文件上传</title>
  <!-- 引入样式 -->
  <link rel="stylesheet" href="../../plugins/element-ui/index.css"/>
  <link rel="stylesheet" href="../../styles/common.css"/>
  <link rel="stylesheet" href="../../styles/page.css"/>
  <link rel="shortcut icon" href="../../favicon.ico">
</head>
<body>
<div class="addBrand-container" id="food-add-app">
  <div class="container">
    <el-upload class="avatar-uploader"
               action="/common/upload"
               :show-file-list="false"
               :on-success="handleAvatarSuccess"
               :before-upload="beforeUpload"
               ref="upload">
      <img v-if="imageUrl" :src="imageUrl" class="avatar"></img>
      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
  </div>
</div>
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="../../plugins/vue/vue.js"></script>
<!-- 引入组件库 -->
<script src="../../plugins/element-ui/index.js"></script>
<!-- 引入axios -->
<script src="../../plugins/axios/axios.min.js"></script>
<script src="../../js/index.js"></script>
<script>
  new Vue({
    el: '#food-add-app',
    data() {
      return {
        imageUrl: ''
      }
    },
    methods: {
      handleAvatarSuccess(response, file, fileList) {
        this.imageUrl = `/common/download?name=${response.data}`
      },
      beforeUpload(file) {
        if (file) {
          const suffix = file.name.split('.')[1]
          const size = file.size / 1024 / 1024 < 2
          if (['png', 'jpeg', 'jpg'].indexOf(suffix) < 0) {
            this.$message.error('上传图片只支持 png、jpeg、jpg 格式！')
            this.$refs.upload.clearFiles()
            return false
          }
          if (!size) {
            this.$message.error('上传文件大小不能超过 2MB!')
            return false
          }
          return file
        }
      }
    }
  })
</script>
</body>
</html>

```

添加CommonController,负责文件上传与下载

```java

@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {

  //文件上传
  @PostMapping("/upload")
  public R<String> upload(MultipartFile file) {
    //file 是一个临时文件，需要转存到指定位置，否则请求完成后临时文件会删除
    log.info("file:{}", file.toString());
    return null;
  }
}
```

MultipartFile定义的file变量必须与name保持一致

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/wjsc3.png" width="80%">


完整代码

- CommonController.java

```java

@RestController
@Slf4j
@RequestMapping("/common")
public class CommonController {
  @Value("${reggie.path}")
  private String basePath;

  /**
   * 文件上传
   *
   * @param file
   * @return
   */
  @PostMapping("/upload")
  public R<String> upload(MultipartFile file) {
    //file是一个临时文件，需要转存到指定位置，否则本次请求完成后临时文件会删除
    log.info(file.toString());

    //原始文件名
    String originalFilename = file.getOriginalFilename();
    String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

    //使用UUID重新生成文件名，防止文件名重复造成文件覆盖
    String fileName = UUID.randomUUID().toString() + suffix;

    //创建一个目录对象
    File dir = new File(basePath);
    //判断目录是否存在
    if (!dir.exists()) {
      //目录不存在
      dir.mkdirs();
    }

    try {
      //将临时文件转存到指定位置
      file.transferTo(new File(basePath + fileName));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return R.success(fileName);
  }
}

```

<h2 id="14">十四、 文件下载</h6>

---

### 文件上传介绍

文件下载，页面端可以使用标签展示下载的图片

标签展示下载的图片

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/wjxz.png" width="80%">

- CommonController.java

```java

/**
 * 文件下载
 *
 * @param name
 * @param response
 */
@GetMapping("/download")
public void download(String name,HttpServletResponse response){

        try{
        //输入流，通过输入流读取文件内容
        FileInputStream fileInputStream=new FileInputStream(basePath+name);

        //输出流，通过输出流将文件回写到浏览器，在浏览器展示图片
        ServletOutputStream outputStream=response.getOutputStream();

        response.setContentType("image/jpeg");

        int len=0;
        byte[]bytes=new byte[1024];
        while((len=fileInputStream.read(bytes))!=-1){
        outputStream.write(bytes,0,len);
        outputStream.flush();
        }

        //关闭资源
        outputStream.close();
        fileInputStream.close();
        }catch(Exception e){
        e.printStackTrace();
        }
        }
```

<h2 id="15">十五、 新增菜品</h6>

---

### 需求分析

后台系统中可以管理菜品信息，通过新增功能来添加一个新的菜品，在添加菜品时需要选择当前菜品所属的菜品分类,并且需要上传菜品图片，在移动端会按照菜品分类来展示对应的菜品信息。

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/wjxz.png" width="80%">

### 数据模型

新增菜品，其实就是将新增页面录入的菜品信息插入到dish表，如果添加了口味做法，还需要向dish_flavor表插入数据。所以在新增菜品时，涉及到两个表:

- dish(菜品表)

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xzcp2.png" width="80%">

- dish_flavor(菜品口味表)

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xzcp3.png" width="80%">

### 代码开发-准备工作

在开发业务功能前，先将需要用到的类和接口基本结构创建好:

- 实体类DishFlavor(Dish实体前面已经导入过了)

```java

@Data
public class DishFlavor implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;


  //菜品id
  private Long dishId;


  //口味名称
  private String name;


  //口味数据list
  private String value;


  @TableField(fill = FieldFill.INSERT)
  private LocalDateTime createTime;


  @TableField(fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime updateTime;


  @TableField(fill = FieldFill.INSERT)
  private Long createUser;


  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Long updateUser;


  //是否删除
  private Integer isDeleted;
}

```

- DishFlavorMapper.java

```java

@Mapper
public interface DishFlavorMapper extends BaseMapper<DishFlavor> {
}
```

- DishController.java

```java

@RestController
@RequestMapping("/dish")
public class DishController {
  @Autowired
  private DishService dishService;
  @Autowired
  private DishFlavorService dishFlavorService;
}
```

- DishFlavorService.java

```java
public interface DishFlavorService extends IService<DishFlavor> {
}
```

- DishFlavorServiceImpl.java

```java

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}

```

### 代码开发-梳理交互过程

在开发代码之前，需要梳理一下新增菜品时前端页面和服务端的交互过程:

1. 页面(backend/page/food/add.html)发送ajax请求，请求服务端获取菜品分类数据并展示到下拉框中
2. 页面发送请求进行图片上传，请求服务端将图片保存到服务器
3. 页面发送请求进行图片下载，将上传的图片进行回显
4. 点击保存按钮，发送ajax请求，将菜品相关数据以json形式提交到服务端

开发新增菜品功能，其实就是在服务端编写代码去处理前端页面发送的这4次请求即可。

菜品分类下拉框：在CategoryController添加

- DishController.java

```java
/**
 * 根据条件查询菜品信息
 *
 * @param dish
 * @return
 */
@GetMapping("/list")
public R<List<DishDto>>list(Dish dish){
        return dishService.list(dish);
        }
```

- DishFlavorService.java

```java
//根据菜品id查询菜品信息
public R<List<DishDto>>list(Dish dish);
```

- DishFlavorServiceImpl.java

```java
    /**
 * 根据条件查询菜品信息
 *
 * @param dish
 * @return
 */
@Transactional
@Override
public R<List<DishDto>>list(Dish dish){
        List<DishDto> dishDtoList=null;

        //缓存key
        String key="dish_"+dish.getCategoryId()+"_"+dish.getName();//dish_categoryId_name

        //先从redis中查询是否有缓存数据
        dishDtoList=(List<DishDto>)redisTemplate.opsForValue().get(key);

        if(dishDtoList!=null){
        //如果存在缓存数据，则直接返回缓存数据
        return R.success(dishDtoList);
        }

        //条件构造器
        LambdaQueryWrapper<Dish> queryWrapper=new LambdaQueryWrapper<>();
        //分类id
        queryWrapper.eq(dish.getCategoryId()!=null,Dish::getCategoryId,dish.getCategoryId());
        //查询状态为1，起售状态
        queryWrapper.eq(Dish::getStatus,1);

        //添加排序条件
        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        List<Dish> list=dishService.list(queryWrapper);

        dishDtoList=list.stream().map((item)->{//对分页数据进行处理
        DishDto dishDto=new DishDto();//菜品DTO对象

        BeanUtils.copyProperties(item,dishDto);//对象拷贝

        Long categoryId=item.getCategoryId();//分类id
        Category category=categoryService.getById(categoryId);//根据分类id查询分类信息

        if(category!=null){//分类信息不为空
        String categoryName=category.getName();//分类名称
        dishDto.setCategoryName(categoryName);//设置分类名称
        }

        //当前菜品id
        Long dishId=item.getId();
        LambdaQueryWrapper<DishFlavor> queryWrapper1=new LambdaQueryWrapper<>();
        queryWrapper1.eq(DishFlavor::getDishId,dishId);
        //SQL: SELECT * FROM dish_flavor WHERE dish_id = ?
        List<DishFlavor> dishFlavorList=dishFlavorService.list(queryWrapper1);
        dishDto.setFlavors(dishFlavorList);//设置口味信息

        return dishDto;//返回菜品DTO对象
        }).collect(Collectors.toList());//转换成List集合

        //如果不存在缓存数据，则查询数据库，并将数据添加到缓存中
        redisTemplate.opsForValue().set(key,dishDtoList,60,TimeUnit.MINUTES);

        return R.success(dishDtoList);
        }
```

导入DishDto，用于封装页面提交的数据

- DishDto.java

```java

@Data
public class DishDto extends Dish {

  private List<DishFlavor> flavors = new ArrayList<>();

  private String categoryName;

  private Integer copies;
}
```

注意：DTO，全称为Data Transfer object，即数据传输对象，一般用于展示层与服务层之间的数据传输。

新增菜品同时插入菜品对应的口味数据,需要操作两张表：dish、dishflavor

在DishService接口中添加方法saveWithFlavor,在DishServiceImpl实现

- DishService.java

```java
/**
 * 菜品管理业务接口层
 *
 * @author 郑梓聪
 * @date 2022-06-22
 */
@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
  @Autowired
  private DishService dishService;

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private DishFlavorService dishFlavorService;

  @Autowired
  private RedisTemplate redisTemplate;

  /**
   * //新增菜品，同时保存菜品对应的口味数据
   *
   * @param dishDto
   */
  @Transactional
  public void saveWithFlavor(DishDto dishDto) {
    //保存菜品的基本信息到菜品表
    this.save(dishDto);

    Long dishId = dishDto.getId();//菜品id

    //菜品口味
    List<DishFlavor> flavors = dishDto.getFlavors();
    flavors.stream().map((item) -> {
      item.setDishId(dishId);
      return item;
    }).collect(Collectors.toList());

    //保存菜品口味数据到菜品口味表dish flavor
    dishFlavorService.saveBatch(flavors);
  }
```

由于以上代码涉及多表操作，在启动类上开启事务支持添加@EnableTransactionManagement注解，但是本人添加该注解会报错，项目启动会失败，并且springboot该注解应该是默认开启的，故没有添加

新增菜品

```java
@PostMapping
public R<String> save(@RequestBody DishDto dishDto){
        dishService.saveWithFlavor(dishDto);
        return R.success("新增菜品成功");
        }
```

<h2 id="16">十六、 菜品信息分页查询</h6>

---

### 需求分析

系统中的菜品数据很多的时候，如果在一个页面中全部展示出来会显得比较乱，不便于查看，所以一般的系统中都会以分页的方式来展示列表数据。

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/cpfy.png" width="80%">

### 代码开发-梳理交互过程

在开发代码之前，需要梳理一下菜品分页查询时前端页面和服务端的交互过程:

1 页面(backend/page/food/list.html)发送ajax请求，将分页查询参数(page、pageSize、name)提交到服务端，获取分页数据

2. 页面发送请求，请求服务端进行图片下载，用于页面图片展示

开发菜品信息分页查询功能，其实就是在服务端编写代码去处理前端页面发送的这2次请求即可。

- DishController.java

```java
    /**
 * 菜品信息分页
 *
 * @param page
 * @param pageSize
 * @param name
 * @return
 */
@GetMapping("/page")
public R<Page> page(int page,int pageSize,String name){
        return dishService.page(page,pageSize,name);
        }
```

- DishService.java

```java
    //分页查询菜品信息
public R<Page> page(int page,int pageSize,String name);
```

- DishServiceImpl.java

```java
  /**
 * 菜品信息分页
 *
 * @param page
 * @param pageSize
 * @param name
 * @return
 */
@Transactional
@Override
public R<Page> page(int page,int pageSize,String name){
        //构造分页构造器对象
        Page<Dish> pageIfo=new Page<>(page,pageSize);
        Page<DishDto> dishDtoPage=new Page<>();

        //条件构造器
        LambdaQueryWrapper<Dish> queryWrapper=new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(name!=null,Dish::getName,name);

        //执行分页查询
        dishService.page(pageIfo,queryWrapper);

        //对象拷贝
        BeanUtils.copyProperties(pageIfo,dishDtoPage,"records");

        List<Dish> records=pageIfo.getRecords();//获取分页数据
        List<DishDto> list=records.stream().map((item)->{//对分页数据进行处理
        DishDto dishDto=new DishDto();//菜品DTO对象

        BeanUtils.copyProperties(item,dishDto);//对象拷贝

        Long categoryId=item.getCategoryId();//分类id
        Category category=categoryService.getById(categoryId);//根据分类id查询分类信息

        if(category!=null){//分类信息不为空
        String categoryName=category.getName();//分类名称
        dishDto.setCategoryName(categoryName);//设置分类名称
        }
        return dishDto;//返回菜品DTO对象
        }).collect(Collectors.toList());//转换成List集合

        dishDtoPage.setRecords(list);//设置分页数据

        return R.success(dishDtoPage);
        }
```

<h2 id="17">十七、 修改菜品</h6>

---

### 需求分析

在菜品管理列表页面点击修改按钮，跳转到修改菜品页面，在修改页面回显菜品相关信息并进行修改，最后点击确定按钮完成修改操作

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xgcp.png" width="80%">

### 代码开发-梳理交互过程

在开发代码之前，需要梳理一下修改菜品时前端页面（ add.html)和服务端的交互过程:

1. 页面发送ajax请求，请求服务端获取分类数据，用于菜品分类下拉框中数据展示
2. 页面发送ajax请求，请求服务端，根据id查询当前菜品信息，用于菜品信息回显

DishController处理Get请求

- DishController.java

```java
    /**
 * 根据ID查询菜品信息分页和口味信息
 *
 * @param id
 * @return
 */
@GetMapping("/{id}")
public R<DishDto> get(@PathVariable Long id){
        //根据菜品id查询菜品信息
        DishDto dishDto=dishService.getByIdWithFlavor(id);
        return R.success(dishDto);
        }
```

- DishService.java

```java
//分页查询菜品信息
public R<Page> page(int page,int pageSize,String name);
```

在DishServiceImpl添加getByIdWithFlavor方法

- DishServiceImpl.java

```java
    /**
 * 根据菜品id删除菜品及其对应的口味数据
 *
 * @param id
 * @return
 */
public DishDto getByIdWithFlavor(Long id){
        //查询菜品基本信息
        Dish dish=this.getById(id);

        //对象拷贝
        DishDto dishDto=new DishDto();
        BeanUtils.copyProperties(dish,dishDto);

        //查询菜品口味信息
        LambdaQueryWrapper<DishFlavor> queryWrappe=new LambdaQueryWrapper<>();
        queryWrappe.eq(DishFlavor::getDishId,dish.getId());
        List<DishFlavor> flavors=dishFlavorService.list(queryWrappe);
        dishDto.setFlavors(flavors);

        return dishDto;
        }
```

3. 页面发送请求，请求服务端进行图片下载，用于页图片回显

4. 点击保存按钮，页面发送ajax请求，将修改后的菜品相关数据以json形式提交到服务端

在DishController添加put方法

- DishController.java

```java
 /**
 * 修改菜品信息
 *
 * @param dishDto
 * @return
 */
@PutMapping
public R<String> update(@RequestBody DishDto dishDto){
        dishService.updateWithFlavor(dishDto);

        //清理所有菜品缓存
//        Set keys = redisTemplate.keys("dish_*");
//        redisTemplate.delete(keys);

        //清理指定菜品缓存
        String key="dish_"+dishDto.getCategoryId()+"_1";
        redisTemplate.delete(key);


        return R.success("修改菜品成功！");
        }
```

- DishService.java

```java
//更新菜品及其对应的口味数据
public void updateWithFlavor(DishDto dishDto);
```

在DishServiceImpl添加updateWithFlavor方法

- DishServiceImpl.java

```java
/**
 * //更新菜品，同时更新菜品对应的口味数据
 *
 * @param dishDto
 */
@Transactional
public void updateWithFlavor(DishDto dishDto){
        //更新菜品基本信息
        this.updateById(dishDto);

        //清理菜品口味数据
        LambdaQueryWrapper<DishFlavor> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId,dishDto.getId());

        dishFlavorService.remove(queryWrapper);

        //更新菜品口味信息
        List<DishFlavor> flavors=dishDto.getFlavors();

        flavors=flavors.stream().map((item)->{
        item.setDishId(dishDto.getId());
        return item;
        }).collect(Collectors.toList());

        dishFlavorService.saveBatch(flavors);
        }
```

开发修改菜品功能，其实就是在服务端编写代码去处理前端页面发送的这4次请求即可。

<h2 id="18">十八、 停售/起售菜品，删除菜品</h6>

---

### 需求分析

在商品买卖过程中，商品停售，起售可以更加方便的让用户知道店家还有什么类型的商品在卖。删除方法也更方便的管理菜品

### 代码实现

在DishController添加sale方法与delete方法,通过数组保存ids，批量起售停售、删除都能生效

- DishController.java

```java
    /**
 * 对菜品批量或者是单个 进行停售或者是起售
 *
 * @return
 */
@PostMapping("/status/{status}")
//这个参数这里一定记得加注解才能获取到参数，否则这里非常容易出问题
public R<String> status(@PathVariable("status") Integer status,@RequestParam List<Long> ids){
        dishService.updateStatus(status,ids);
        return R.success("售卖状态修改成功");
        }
```

- DishService.java

```java
    //批量停售、起售菜品
public void updateStatus(Integer status,List<Long> ids);
```

- DishServiceImpl.java

```java
  /**
 * 对菜品批量或者是单个 进行停售或者是起售
 *
 * @return
 */
@PostMapping("/status/{status}")
//这个参数这里一定记得加注解才能获取到参数，否则这里非常容易出问题
public R<String> status(@PathVariable("status") Integer status,@RequestParam List<Long> ids){
        dishService.updateStatus(status,ids);
        return R.success("售卖状态修改成功");
        }
```

<h2 id="19">十九、 新增套餐</h6>

---

### 需求分析

套餐就是菜品的集合。

后台系统中可以管理套餐信息，通过新增套餐功能来添加一个新的套餐，在添加套餐时需要选择当前套餐所属的套餐分类和包含的菜品，并且需要上传套餐对应的图片，在移动端会按照套餐分类来展示对应的套餐。

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xztc2.png" width="19%">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xztc.png" width="73%">

### 数据模型

新增套餐，其实就是将新增页面录入的套餐信息插入到setmeal表，还需要向setmeal_dish表插入套餐和菜品关联数据。所以在新增套餐时，涉及到两个表:

- setmeall 套餐表
  <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xztc3.png" width="80%">

- setmeal_dish 套餐菜品关系表
  <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xztc4.png" width="80%">

### 代码开发-准备工作

在开发业务功能前，先将需要用到的类和接口基本结构创建好:

- 实体类SetmealDish(直接从课程资料中导入即可，Setmeal实体前面+已经导入过了)
- DTO SetmealDto(直接从课程资料中导入即可)
- Mapper接口SetmealDishMapper
- 业务层接口SetmealDishService
- 业务层实现类SetmealDishServicelmpl
- 控制层SetmealController

### 代码开发-梳理交互过程

在开发代码之前，需要梳理一下新增套餐时前端页面和服务端的交互过程:

1. 页面(backend/page/comboladd.html)发送ajax请求，请求服务端获取套餐分类数据并展示到下拉框中
2. 页面发送ajax请求，请求服务端获取菜品分类数据并展示到添加菜品窗口中
3. 页面发送ajax请求，请求服务端，根据菜品分类查询对应的菜品数据并展示到添加菜品窗口中

   <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xztc5.png" width="80%">

在DishController添加list方法

- DishController.java

```java
    /**
 * 根据条件查询菜品信息
 *
 * @param dish
 * @return
 */
@GetMapping("/list")
public R<List<DishDto>>list(Dish dish){
        return dishService.list(dish);
        }

/**
 * 对菜品批量或者是单个 进行停售或者是起售
 *
 * @return
 */
```

   <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xztc6.png" width="80%">

4. 页面发送请求进行图片上传，请求服务端将图片保存到服务器
5. 页面发送请求进行图片下载，将上传的图片进行回显
6. 点击保存按钮，发送ajax请求，将套餐相关数据以json形式提交到服务端

在SetmealServiceImpl实现saveWithDish方法：新增套餐，同时要保持与菜品的关联关系

- SetmealServiceImpl.java

```java
@Transactional
@Override
public R<List<DishDto>>dish(@PathVariable Long SetmealId){
        LambdaQueryWrapper<SetmealDish> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(SetmealDish::getSetmealId,SetmealId);
        //获取套餐里面的所有菜品  这个就是SetmealDish表里面的数据
        List<SetmealDish> list=setmealDishService.list(queryWrapper);

        List<DishDto> dishDtos=list.stream().map((setmealDish)->{
        DishDto dishDto=new DishDto();
        //其实这个BeanUtils的拷贝是浅拷贝，这里要注意一下
        BeanUtils.copyProperties(setmealDish,dishDto);
        //这里是为了把套餐中的菜品的基本信息填充到dto中，比如菜品描述，菜品图片等菜品的基本信息
        Long dishId=setmealDish.getDishId();
        Dish dish=dishService.getById(dishId);
        BeanUtils.copyProperties(dish,dishDto);

        return dishDto;
        }).collect(Collectors.toList());

        return R.success(dishDtos);
```

在SetmealController添加save方法

- SetmealController.java

```java
/**
 * @author 郑梓聪
 * @description 套餐管理控制器
 * @date 2022-06-22
 */
@RestController
@RequestMapping("/setmeal")
@Slf4j
public class SetmealController {

  @Autowired
  private SetmealService setmealService;

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private SetmealDishService setmealDishService;

  @Autowired
  private DishService dishService;

  /**
   * 新增套餐
   *
   * @param setmealDto
   * @return
   */
  @PostMapping
  @CacheEvict(value = "setmealCache", allEntries = true)
  public R<String> save(@RequestBody SetmealDto setmealDto) {
    log.info("新增套餐，套餐信息：{}", setmealDto);
    setmealService.saveWithDish(setmealDto);
    return R.success("新增套餐成功");
  }
}
```

开发新增套餐功能，其实就是在服务端编写代码去处理前端页面发送的这6次请求即可。

<h2 id="20">二十、 套餐分页查询</h6>

---

### 需求分析

系统中的套餐数据很多的时候，如果在一个页面中全部展示出来会显得比较乱，不便于查看，所以一般的系统中都会以分页的方式来展示列表数据。

### 代码开发-梳理交互过程

在开发代码之前，需要梳理一下套餐分页查询时前端页面和服务端的交互过程:

1. 页面(backend/page/combo/list.html)发送ajax请求，将分页查询参数(page、pageSize、name)提交到服务端，获取分页数据
2. 页面发送请求，请求服务端进行图片下载，用于页面图片展示

开发套餐信息分页查询功能，其实就是在服务端编写代码去处理前端页面发送的这2次请求即可。

- SetmealController.java

```java
/**
 * 套餐信息分页
 *
 * @param page
 * @param pageSize
 * @param name
 * @return
 */
@GetMapping("/page")
public R<Page> page(int page,int pageSize,String name){
        return setmealService.page(page,pageSize,name);
        }
```

- SetmealService.java

```java
    //套餐信息分页
public R<Page> page(int page,int pageSize,String name);
```

- SetmealServiceImpl.java

```java
    @Transactional
@Override
public R<Page> page(int page,int pageSize,String name){
        //分页构造器对象
        Page<Setmeal> pageInfo=new Page<>(page,pageSize);
        Page<SetmealDto> dtoPage=new Page<>();

        LambdaQueryWrapper<Setmeal> queryWrapper=new LambdaQueryWrapper<>();
        //模糊查询
        queryWrapper.like(name!=null,Setmeal::getName,name);
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);

        setmealService.page(pageInfo,queryWrapper);

        //对象拷贝
        BeanUtils.copyProperties(pageInfo,dtoPage,"records");
        List<Setmeal> records=pageInfo.getRecords();

        List<SetmealDto> list=records.stream().map((item)->{
        SetmealDto setmealDto=new SetmealDto();
        BeanUtils.copyProperties(item,setmealDto);
        Long categoryId=item.getCategoryId(); //获取分类id
        Category category=categoryService.getById(categoryId);//根据分类id查询分类信息
        if(category!=null){
        String categoryName=category.getName();//获取分类名称
        setmealDto.setCategoryName(categoryName);
        }
        return setmealDto;
        }).collect(Collectors.toList());

        dtoPage.setRecords(list);
        return R.success(dtoPage);
        }
```

<h2 id="21">二十一、 删除、起售、停售套餐</h6>

---

### 需求分析

在套餐管理列表页面点击删除按钮，可以删除对应的套餐信息。也可以通过复选框选择多个套餐，点击批量删除按钮一次删除多个套餐。注意，对于状态为售卖中的套餐不能删除，需要先停售，然后才能删除。

### 代码实现

开发删除套餐功能，其实就是在服务端编写代码去处理前端页面发送的这2次请求即可。 观察删除单个套餐和批量删除套餐的请求信息可以发现，两种请求的地址和请求方式都是相同的，不同的则是传递的id个数，所以在服务端可以提供一个方法来统一处理。

- SetmealController.java

```java
    /**
 * 套餐批量删除和单个删除
 *
 * @param ids
 * @return
 */
@DeleteMapping
@CacheEvict(value = "setmealCache", allEntries = true)
public R<String> delete(@RequestParam("ids") List<Long> ids){
        log.info("ids:{}",ids);
        //删除菜品  这里的删除是逻辑删除
        setmealService.removeWithDish(ids);
        return R.success("套餐删除成功");
        }
```

- SetmealService.java

```java
    // 删除套餐，同时删除套餐与菜品的关系
    void removeWithDish(List<Long> ids);
```

- SetmealServiceImpl.java

```java
    @Transactional
@Override
public R<String> delete(@RequestBody List<Long> ids){
        log.info("删除套餐，套餐id：{}",ids);

        setmealService.removeWithDish(ids);
        setmealDishService.remove(new QueryWrapper<SetmealDish>().eq("setmeal_id",ids));
        return R.success("删除套餐成功");
        }
```

<h2 id="22">二十二、 修改套餐</h6>

---

### 需求分析

在套餐管理列表页面点击修改按钮，跳转到修改套餐页面，在修改页面回显套餐相关信息并进行修改，最后点击确定按钮完成修改操作

### 代码开发-梳理交互过程

在开发代码之前，需要梳理一下修改套餐时前端页面（ add.html)和服务端的交互过程:

1. 页面发送ajax请求，请求服务端获取分类数据，用于套餐分类下拉框中数据展示
2. 页面发送ajax请求，请求服务端，根据id查询当前套餐信息，用于套餐信息回显

- SetmealController.java

```java
//根据Id查询套餐信息
@GetMapping("/{id}")
public R<SetmealDto> getById(@PathVariable Long id){
        SetmealDto setmealDto=setmealService.getByIdWithDish(id);

        return R.success(setmealDto);
        }

```

- SetmealService.java

```java
//根据套餐id查询套餐信息
SetmealDto getByIdWithDish(Long id);
```

- SetmealServiceImpl.java

```java
@Override
public SetmealDto getByIdWithDish(Long id){
        //查询套餐基本信息
        Setmeal setmeal=this.getById(id);
        SetmealDto setmealDto=new SetmealDto();
        BeanUtils.copyProperties(setmeal,setmealDto);

        //查询套餐菜品信息
        LambdaQueryWrapper<SetmealDish> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(SetmealDish::getSetmealId,setmeal.getId());
        List<SetmealDish> list=setmealDishService.list(queryWrapper);

        setmealDto.setSetmealDishes(list);
        return setmealDto;
        }

```

   <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xgtc.png" width="80%">

3. 页面发送请求，请求服务端进行图片下载，用于页图片回显
4. 点击保存按钮，页面发送ajax请求，将修改后的菜品相关数据以json形式提交到服务端

- 在SetmealServiceImpl添加updateWithDish方法

```java
@Override
public void updateWithDish(SetmealDto setmealDto){
        //更新setmeal表基本信息
        this.updateById(setmealDto);

        //更新setmeal_dish表信息delete操作
        LambdaQueryWrapper<SetmealDish> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(SetmealDish::getSetmealId,setmealDto.getId());
        setmealDishService.remove(queryWrapper);

        //更新setmeal_dish表信息insert操作
        List<SetmealDish> SetmealDishes=setmealDto.getSetmealDishes();

        SetmealDishes=SetmealDishes.stream().map((item)->{
        item.setSetmealId(setmealDto.getId());
        return item;
        }).collect(Collectors.toList());

        setmealDishService.saveBatch(SetmealDishes);
        }
```

- 在SetmealController处理put请求

```java
//修改套餐
@PutMapping
public R<String> update(@RequestBody SetmealDto setmealDto){
        setmealService.updateWithDish(setmealDto);
        return R.success("修改成功");
        }

```

注意：开发修改套餐功能，其实就是在服务端编写代码去处理前端页面发送的这4次请求即可。

<h2 id="23">二十三、 短信发送</h6>

---

### 短信服务介绍

目前市面上有很多第三方提供的短信服务，这些第三方短信服务会和各个运营商（移动、联通、电信)对接，我们只需要注册成为会员并且按照提供的开发文档进行调用就可以发送短信。需要说明的是，这些短信服务一般都是收费服务。

### 常用短信服务:

- 阿里云
- 华为云
- 腾讯云
- 京东
- 梦网
- 乐信

### 阿里云短信服务-介绍

阿里云短信服务（Short Message Service)
是广大企业客户快速触达手机用户所优选使用的通信能力。调用API或用群发助手，即可发送验证码、通知类和营销类短信;国内验证短信秒级触达，到达率最高可达99%;国际/港澳台短信覆盖200多个国家和地区，安全稳定，广受出海企业选用。

应用场景:

- 验证码
- 短信通知
- 推广短信

### 阿里云短信服务-注册账号

阿里云官网: https://www.aliyun.com/

点击官网首页注册按钮。 阿里云短信服务-设置短信签名

注册成功后，点击登录按钮进行登录。登录后进入短信服务管理页面，选择国内消息菜单:

   <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/dxfs.png" width="80%">

短信签名是短信发送者的署名，表示发送方的身份。

### 阿里云短信服务-设置短信模板

切换到【模板管理】标签页:

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/dxfs2.png" width="80%">

短信模板包含短信发送内容、场景、变量信息。

### 阿里云短信服务-设置AccessKey

光标移动到用户头像上，在弹出的窗口中点击【AccessKey管理】∶

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/dxfs3.png" width="30%">

### 代码开发

使用阿里云短信服务发送短信，可以参照官方提供的文档即可。 具体开发步骤:

1. 导入maven坐标

```html

<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.5.16</version>
</dependency>
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-dysmsapi</artifactId>
  <version>1.1.0</version>
</dependency>

```

2. 调用API

```java
    /**
 * 发送短信
 *
 * @param phoneNumbers
 * @param param
 * @throws Exception
 */
public static void sendMessage(String phoneNumbers,String param)throws Exception{
        // 使用环境变量或配置文件中的凭证，不要硬编码
        String accessKeyId = System.getenv("ALIYUN_ACCESS_KEY_ID");
        String accessKeySecret = System.getenv("ALIYUN_ACCESS_KEY_SECRET");
        com.aliyun.dysmsapi20170525.Client client=SMSUtils
        .createClient(accessKeyId, accessKeySecret);
        SendSmsRequest sendSmsRequest=new SendSmsRequest()
        .setPhoneNumbers(phoneNumbers) //目标手机号
        .setSignName("传智播客") //签名名称
        .setTemplateCode("Tcode") //短信模板code
        .setTemplateParam("{\"code\":\""+param+"\"}");//模板中变量替换
        SendSmsResponse sendSmsResponse=client.sendSms(sendSmsRequest);
        SendSmsResponseBody body=sendSmsResponse.getBody();
        // code = OK 代表成功
        System.out.println(body.getCode()+"  "+body.getMessage());
        }
```

<h2 id="24">二十四、 手机验证码登录</h6>

---

### 短信服务介绍

为了方便用户登录，移动端通常都会提供通过手机验证码登录的功能。

手机验证码登录的优点:

- 方便快捷，无需注册，直接登录
- 使用短信验证码作为登录凭证，无需记忆密码
- 安全

### 登录流程:

输入手机号>获取验证码>输入验证码>点击登录>登录成功

注意:通过手机验证码登录，手机号是区分不同用户的标识。

### 数据模型

通过手机验证码登录时，涉及的表为user表，即用户表。结构如下:

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/yzmdd.png" width="80%">

### 代码开发

在开发代码之前，需要梳理一下登录时前端页面和服务端的交互过程:

1. 在登录页面(front/page/login.html)输入手机号，点击【获取验证码】按钮，页面发送ajax请求，在服务端调用短信服务API给指定手机号发送验证码短信
2. 在登录页面输入验证码，点击【登录】按钮，发送ajax请求，在服务端处理登录请求

开发手机验证码登录功能，其实就是在服务端编写代码去处理前端页面发送的这2次请求即可。

在开发业务功能前，先将需要用到的类和接口基本结构创建好:

- 实体类User(直接从课程资料中导入即可)
- Mapper接口UserMapper
- 业务层接口UserService
- 业务层实现类UserServicelmpl
- 控制层UserController
- 工具类SMSutils、 ValidateCodeutils（直接从课程资料中导入即可)

前面我们已经完成了LogincheckFilter过滤器的开发，此过滤器用于检查用户的登录状态。我们在进行手机验证码登录时，发送的请求需要在此过滤器处理时直接放行。

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/yzmdd2.png" width="50%">

- LoginCheckFilter过滤器添加

```java
//        4-2、判断登录状态，如果已登录，则直接放行
if(request.getSession().getAttribute("user")!=null){
        log.info("用户已登录，用户id为：{}",request.getSession().getAttribute("user"));

        Long userId=(Long)request.getSession().getAttribute("user");

        BaseContext.setCurrentId(userId);

        filterChain.doFilter(request,response);
        return;
        }

```

- 由于资料中代码不全login.js自行添加

```javascript
function sendMsgApi(data) {
  return $axios({
    'url': '/user/sendMsg',
    'method': 'post',
    data
  })
}
```

- login.html

```html
// this.form.code = (Math.random()*1000000).toFixed(0)
sendMsgApi({phone:this.form.phone})
```

处理post请求（发送验证码的请求）和 编写login和loout处理post请求

-UserController.java

```java
/**
 * 移动端用户控制器
 *
 * @author 郑梓聪
 * @date 2022-06-23
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * 发送手机验证码
   *
   * @param user
   * @return
   */
  @PostMapping("/sendMsg")
  public R<String> sendMsg(@RequestBody User user, HttpSession session) {
    userService.sendMsg(user, session);
    return R.success("手机验证码发送成功！");
  }

  /**
   * 用户登录
   *
   * @param map
   * @param session
   * @return
   */
  @PostMapping("/login")
  public R<User> login(@RequestBody Map map, HttpSession session) {
    return userService.login(map, session);
  }

  /**
   * 退出登录
   *
   * @param request
   * @return
   */
  @PostMapping("/loginout")
  public R<String> logout(HttpServletRequest request) {
    return userService.logout(request);
  }
}
```

-UserService.java

```java
    //发送验证码
public R<String> sendMsg(@RequestBody User user,HttpSession session);

//用户登录
public R<User> login(@RequestBody Map map,HttpSession session);

//退出登录
public R<String> logout(HttpServletRequest request);
```

-UserServiceImpl.java

```java
/**
 * 移动端用户业务层接口
 *
 * @author 郑梓聪
 * @date 2022-06-23
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
  @Autowired
  private UserService userService;

  @Autowired
  private RedisTemplate redisTemplate;

  /**
   * 发送手机验证码
   *
   * @param user
   * @return
   */
  @Transactional
  @Override
  public R<String> sendMsg(User user, HttpSession session) {
    //获取手机号
    String phone = user.getPhone();

    if (StringUtils.isNotEmpty(phone)) {
      //生成随机验证码
      String code = ValidateCodeUtils.generateValidateCode(6).toString();
      log.info("验证码：{}", code);

      //调用阿里云提供的短信API发送验证码
      try {
        SMSUtils.sendMessage(phone, code);
      } catch (Exception e) {
        e.printStackTrace();
      }
      //将验证码存入session
//            session.setAttribute(phone, code);

      //将验证码存入redis。设置过期时间为5分钟
      redisTemplate.opsForValue().set(phone, code, 5, TimeUnit.MINUTES);

      return R.success("手机验证码发送成功！");
    }

    return R.error("短信发送失败！");
  }

  /**
   * 用户登录
   *
   * @param map
   * @param session
   * @return
   */
  @Transactional
  @Override
  public R<User> login(Map map, HttpSession session) {
    //获取手机号
    String phone = (String) map.get("phone");

    //获取验证码
    String code = (String) map.get("code");

    //从session中获取验证码
//        String sessionCode = (String) session.getAttribute(phone);

    //从redis中获取验证码
    Object redisCode = redisTemplate.opsForValue().get(phone);

    //验证验证码是否正确
    if (redisCode != null && redisCode.equals(code)) {
      //验证码正确，登录成功
      //判断当前手机号对应的用户是否存在，如果是新用户，则注册
      LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
      queryWrapper.eq(User::getPhone, phone);
      User user = userService.getOne(queryWrapper);
      if (user == null) {
        //新用户，注册
        user = new User();
        user.setPhone(phone);
        user.setStatus(1);
        userService.save(user);
      }

      //将用户信息存入session
      session.setAttribute("user", user.getId());

      //如果用户登陆成功。删除redis中的验证码
      redisTemplate.delete(phone);

      return R.success(user);
    }

    return R.error("登录失败！");
  }

  /**
   * 用户退出
   *
   * @param request
   * @return
   */
  @Override
  public R<String> logout(HttpServletRequest request) {
    request.getSession().removeAttribute("user");
    return R.success("退出成功");
  }
}

```

### 效果展示

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/yzmdd3.png" width="25%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/yzmdd4.png" width="24.5%">

<h2 id="25">二十五、 导入用户地址簿相关功能代码</h6>

---

### 需求分析

地址簿，指的是移动端消费者用户的地址信息，用户登录成功后可以维护自己的地址信息。同一个用户可以有多个地址信息，但是只能有一个默认地址。

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/dzb1.png" width="25%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/dzb2.png" width="24.5%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/dzb3.png" width="24.5%">

### 数据模型

用户的地址信息会存储在address_book表，即地址簿表中。具体表结构如下:
<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/dzb4.png" width="80%">

### 导入功能代码

功能代码清单:

- 实体类AddressBook(直接导入即可)
- Mapper接口AddressBookMapper
- 业务层接口AddressBookService
- 业务层实现类AddressBookServicelmpl
- 控制层AddressBookController(直接导入即可)


- AddressBookController.java

```java
/**
 * 地址簿管理
 */
@Slf4j
@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

  @Autowired
  private AddressBookService addressBookService;

  /**
   * 新增地址
   *
   * @param addressBook
   * @return
   */
  @PostMapping
  public R<AddressBook> save(@RequestBody AddressBook addressBook) {

    return addressBookService.saveAddress(addressBook);
  }

  /**
   * 设置默认地址
   * @param addressBook
   * @return
   */
  @PutMapping("default")
  public R<AddressBook> setDefault(@RequestBody AddressBook addressBook) {
    return addressBookService.setDefault(addressBook);
  }

  /**
   * 根据用户id查询地址列表
   * @param id
   * @return
   */
  @GetMapping("/{id}")
  public R get(@PathVariable Long id) {
    return addressBookService.get(id);
  }

  /**
   * 查询默认地址
   * @return
   */
  @GetMapping("default")
  public R<AddressBook> getDefault() {
    return addressBookService.getDefault();
  }

  /**
   * 查询地址列表
   * @param addressBook
   * @return
   */
  @GetMapping("/list")
  public R<List<AddressBook>> list(AddressBook addressBook) {
    return addressBookService.list(addressBook);
  }

  /**
   * 修改收货地址
   *
   * @param addressBook
   * @return
   */
  @PutMapping
  public R<String> update(@RequestBody AddressBook addressBook) {
    return addressBookService.update(addressBook);
  }

  /**
   * 删除地址
   * 巨坑：
   * 不用@RequestBody，因为前端传过来的是一个数组，而不是一个对象
   *
   * @param
   * @return
   */
  @DeleteMapping
  public R<String> delete(Long ids) {
    return addressBookService.deleteAddress(ids);
  }
}

```

- AddressBookService.java

```java
public interface AddressBookService extends IService<AddressBook> {
  //新增地址
  public R<AddressBook> saveAddress(@RequestBody AddressBook addressBook);

  //设置默认地址
  public R<AddressBook> setDefault(@RequestBody AddressBook addressBook);

  //根据用户id查询地址列表
  public R get(@PathVariable Long id);

  //查询默认地址
  public R<AddressBook> getDefault();

  //查询地址列表
  public R<List<AddressBook>> list(AddressBook addressBook);

  //修改地址
  public R<String> update(@RequestBody AddressBook addressBook);

  //删除地址
  public R<String> deleteAddress(Long ids);

}
```

- AddressBookServiceImpl.java

```java

@Service
@Slf4j
public class AddressServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
  @Autowired
  private AddressBookService addressBookService;

  /**
   * 新增地址
   *
   * @param addressBook
   * @return
   */
  @Transactional
  @Override
  public R<AddressBook> saveAddress(AddressBook addressBook) {
    addressBook.setUserId(BaseContext.getCurrentId());
    log.info("addressBook:{}", addressBook);
    addressBookService.save(addressBook);
    return R.success(addressBook);
  }

  /**
   * 设置默认地址
   *
   * @param addressBook
   * @return
   */
  @Transactional
  @Override
  public R<AddressBook> setDefault(AddressBook addressBook) {
    log.info("addressBook:{}", addressBook);
    LambdaUpdateWrapper<AddressBook> wrapper = new LambdaUpdateWrapper<>();
    wrapper.eq(AddressBook::getUserId, BaseContext.getCurrentId());
    wrapper.set(AddressBook::getIsDefault, 0);
    //SQL:update address_book set is_default = 0 where user_id = ?
    addressBookService.update(wrapper);

    addressBook.setIsDefault(1);
    //SQL:update address_book set is_default = 1 where id = ?
    addressBookService.updateById(addressBook);
    return R.success(addressBook);
  }

  /**
   * 根据用户id查询地址列表
   *
   * @param id
   * @return
   */
  @Transactional
  @Override
  public R get(Long id) {
    AddressBook addressBook = addressBookService.getById(id);
    if (addressBook != null) {
      return R.success(addressBook);
    } else {
      return R.error("没有找到该对象");
    }
  }

  /**
   * 查询默认地址
   *
   * @return
   */
  @Transactional
  @Override
  public R<AddressBook> getDefault() {
    LambdaQueryWrapper<AddressBook> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(AddressBook::getUserId, BaseContext.getCurrentId());
    queryWrapper.eq(AddressBook::getIsDefault, 1);

    //SQL:select * from address_book where user_id = ? and is_default = 1
    AddressBook addressBook = addressBookService.getOne(queryWrapper);

    if (null == addressBook) {
      return R.error("没有找到该对象");
    } else {
      return R.success(addressBook);
    }
  }

  /**
   * 查询地址列表
   *
   * @param addressBook
   * @return
   */
  @Transactional
  @Override
  public R<List<AddressBook>> list(AddressBook addressBook) {
    addressBook.setUserId(BaseContext.getCurrentId());
    log.info("addressBook:{}", addressBook);

    //条件构造器
    LambdaQueryWrapper<AddressBook> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(null != addressBook.getUserId(), AddressBook::getUserId, addressBook.getUserId());
    queryWrapper.orderByDesc(AddressBook::getUpdateTime);

    //SQL:select * from address_book where user_id = ? order by update_time desc
    return R.success(addressBookService.list(queryWrapper));
  }

  /**
   * 修改收货地址
   *
   * @param addressBook
   * @return
   */
  @Transactional
  @Override
  public R<String> update(@RequestBody AddressBook addressBook) {
    log.info("修改后的地址信息为{}", addressBook);
    if (addressBook == null) {
      return R.error("请求异常");
    }
    addressBookService.updateById(addressBook);
    return R.success("修改地址成功");

  }

  /**
   * 删除
   *
   * @param
   * @return
   */
  @Transactional
  @Override
  public R<String> deleteAddress(Long ids) {
    log.info("需要删除的id为:{}", ids);
    if (ids == null) {
      return R.error("请求异常");
    }
    LambdaQueryWrapper<AddressBook> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(AddressBook::getId, ids).eq(AddressBook::getUserId, BaseContext.getCurrentId());
    addressBookService.remove(queryWrapper);
    return R.success("删除地址成功");
  }


}

```

### 功能测试

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/dzb5.png" width="24.5%">

<h2 id="26">二十六、 菜品展示</h6>

---

### 需求分析

用户登录成功后跳转到系统首页，在首页需要根据分类来展示菜品和套餐。如果菜品设置了口味信息需要展示 [选择规格] 按钮，否则显示 [+] 按钮。

### 代码开发

代码开发-梳理交互过程

在开发代码之前，需要梳理一下前端页面和服务端的交互过程:

1. 页面(front/index.html)发送ajax请求，获取分类数据（菜品分类和套餐分类)
2. 页面发送ajax请求，获取第一个分类下的菜品或者套餐

开发菜品展示功能，其实就是在服务端编写代码去处理前端页面发送的这2次请求即可。

注意:首页加载完成后，还发送了一次ajax请求用于加载购物车数据，此处可以将这次请求的地址暂时修改一下，从静态json文件获取数据，等后续开发购物车功能时再修改回来，如下:

```js
//获取购物车内商品的集合
function cartListApi(data) {
  return $axios({
    // 'url': '/shoppingCart/list',
    'url': '/front/cartData.json',
    'method': 'get',
    params: {...data}
  })
}
```

- cartData.json:

```json
{
  "code": 1,
  "msg": null,
  "data": [],
  "map": {}
}
```

- 改造DishServiceImpl中的list方法

```java
 /**
 * 根据条件查询菜品信息
 *
 * @param dish
 * @return
 */
@Transactional
@Override
public R<List<DishDto>>list(Dish dish){
        List<DishDto> dishDtoList=null;

        //缓存key
        String key="dish_"+dish.getCategoryId()+"_"+dish.getName();//dish_categoryId_name

        //先从redis中查询是否有缓存数据
        dishDtoList=(List<DishDto>)redisTemplate.opsForValue().get(key);

        if(dishDtoList!=null){
        //如果存在缓存数据，则直接返回缓存数据
        return R.success(dishDtoList);
        }

        //条件构造器
        LambdaQueryWrapper<Dish> queryWrapper=new LambdaQueryWrapper<>();
        //分类id
        queryWrapper.eq(dish.getCategoryId()!=null,Dish::getCategoryId,dish.getCategoryId());
        //查询状态为1，起售状态
        queryWrapper.eq(Dish::getStatus,1);

        //添加排序条件
        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        List<Dish> list=dishService.list(queryWrapper);

        dishDtoList=list.stream().map((item)->{//对分页数据进行处理
        DishDto dishDto=new DishDto();//菜品DTO对象

        BeanUtils.copyProperties(item,dishDto);//对象拷贝

        Long categoryId=item.getCategoryId();//分类id
        Category category=categoryService.getById(categoryId);//根据分类id查询分类信息

        if(category!=null){//分类信息不为空
        String categoryName=category.getName();//分类名称
        dishDto.setCategoryName(categoryName);//设置分类名称
        }

        //当前菜品id
        Long dishId=item.getId();
        LambdaQueryWrapper<DishFlavor> queryWrapper1=new LambdaQueryWrapper<>();
        queryWrapper1.eq(DishFlavor::getDishId,dishId);
        //SQL: SELECT * FROM dish_flavor WHERE dish_id = ?
        List<DishFlavor> dishFlavorList=dishFlavorService.list(queryWrapper1);
        dishDto.setFlavors(dishFlavorList);//设置口味信息

        return dishDto;//返回菜品DTO对象
        }).collect(Collectors.toList());//转换成List集合

        //如果不存在缓存数据，则查询数据库，并将数据添加到缓存中
        redisTemplate.opsForValue().set(key,dishDtoList,60,TimeUnit.MINUTES);

        return R.success(dishDtoList);
        }
```

- SetmealController.java

```java
    /**
 * 查询套餐列表
 *
 * @param setmeal
 * @return
 */
@GetMapping("/list")
@Cacheable(value = "setmealCache", key = "#setmeal.categoryId+'_'+#setmeal.name")
public R<List<Setmeal>>list(Setmeal setmeal){

        return setmealService.list(setmeal);
        }
```

### 功能测试

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/cpzs.png" width="24.5%">

<h2 id="27">二十七、 购物车</h6>

---

### 需求分析

移动端用户可以将菜品或者套餐添加到购物车。对于菜品来说，如果设置了口味信息，则需要选择规格后才能加入购物车;对于套餐来说，可以直接点击 [+] 将当前套餐加入购物车。在购物车中可以修改菜品和套餐的数量,也可以清空购物车。

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/gwc1.png" width="20%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/gwc2.png" width="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/gwc3.png" width="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/gwc4.png" width="20%">

### 数据模型

购物车对应的数据表为shopping_cart表，具体表结构如下:

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/gwc5.png" width="80%">

### 代码开发

代码开发-梳理交互过程

在开发代码之前，需要梳理一下购物车操作时前端页面和服务端的交互过程:

1. 点击 [加入购物车] 或者 [+] 按钮，页面发送ajax请求，请求服务端，将菜品或者套餐添加到购物车
2. 点击购物车图标，页面发送ajax请求，请求服务端查询购物车中的菜品和套餐
3. 点击清空购物车按钮，页面发送ajax请求，请求服务端来执行清空购物车操作

开发购物车功能，其实就是在服务端编写代码去处理前端页面发送的这3次请求即可。

### 代码开发-准备工作

在开发业务功能前，先将需要用到的类和接口基本结构创建好:

- 实体类ShoppingCart(直接从课程资料中导入即可)
- Mapper接口ShoppingCartMapper
- 业务层接口ShoppingcartService
- 业务层实现类ShoppingCartServicelmpl
- 控制层ShoppingCartController

### 代码开发-添加购物车

- ShoppingCartController.java

```java
/**
 * @author 郑梓聪
 * @description 购物车控制器
 * @date 2022-06-22
 */
@RestController
@RequestMapping("/shoppingCart")
@Slf4j
public class ShoppingCartController {

  @Autowired
  private ShoppingCartService shoppingCartService;

  @PostMapping("/add")
  public R<ShoppingCart> shoppingCartadd(@RequestBody ShoppingCart shoppingCart) {
    return shoppingCartService.shoppingCartadd(shoppingCart);
  }

  /**
   * 查询当前用户的购物车列表
   *
   * @return
   */
  @GetMapping("/list")
  public R<List<ShoppingCart>> list() {
    log.info("查询当前用户的购物车列表");
    LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(ShoppingCart::getUserId, BaseContext.getCurrentId());
    queryWrapper.orderByDesc(ShoppingCart::getCreateTime);

    List<ShoppingCart> list = shoppingCartService.list(queryWrapper);

    return R.success(list);
  }
}
```

-
- ShoppingCartService.java

```java
/**
 * @author 郑梓聪
 * @description 购物车服务接口
 * @date 2022-06-22
 */
public interface ShoppingCartService extends IService<ShoppingCart> {
  //添加购物车商品
  public R<ShoppingCart> shoppingCartadd(@RequestBody ShoppingCart shoppingCart);
}

```

-
- ShoppingCartServiceImpl.java

```java
/**
 * @author 郑梓聪
 * @description 购物车服务实现类
 * @date 2022-06-22
 */
@Service
@Slf4j
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

  @Autowired
  private ShoppingCartService shoppingCartService;

  /**
   * 添加购物车商品
   *
   * @param shoppingCart
   * @return
   */
  @Transactional
  @Override
  public R<ShoppingCart> shoppingCartadd(@RequestBody ShoppingCart shoppingCart) {
    log.info("购物车数据: {}", shoppingCart);

    //设置用户id,指定用户添加购物车
    Long currentId = BaseContext.getCurrentId();
    shoppingCart.setUserId(currentId);

    //查询当前菜品或者套餐是否已经存在购物车中
    Long dishId = shoppingCart.getDishId();
    LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(ShoppingCart::getUserId, currentId);

    if (dishId != null) {
      //添加到购物车的是菜品
      queryWrapper.eq(ShoppingCart::getDishId, dishId);
    } else {
      //添加到购物车的是套餐
      queryWrapper.eq(ShoppingCart::getSetmealId, shoppingCart.getSetmealId());
    }

    //SQL: select * from shopping_cart where user_id = #{currentId} and (dish_id = #{dishId} or setmeal_id = #{setmealId})
    ShoppingCart cartServiceOne = shoppingCartService.getOne(queryWrapper);

    //如果购物车中已经存在该菜品或者套餐,则只修改数量
    if (cartServiceOne != null) {
      //如果存在,则更新数量
      Integer number = cartServiceOne.getNumber();
      cartServiceOne.setNumber(number + 1);
      shoppingCart.setCreateTime(LocalDateTime.now());
      shoppingCartService.updateById(cartServiceOne);
    } else {
      //如果不存在,则添加到购物车
      shoppingCart.setNumber(1);
      shoppingCart.setCreateTime(LocalDateTime.now());
      shoppingCartService.save(shoppingCart);
      cartServiceOne = shoppingCart;
    }
    return R.success(cartServiceOne);
  }
}

```

### 代码开发-清空购物车

- ShoppingCartController.java

```java
    /**
 * 清空购物车
 *
 * @return
 */
@DeleteMapping("/clean")
public R<String> clean(){
        log.info("清空购物车");
        LambdaQueryWrapper<ShoppingCart> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());
        shoppingCartService.remove(queryWrapper);
        return R.success("清空购物车成功!");
        }
```

- ShoppingCartService.java

```java
    //清空购物车
    void clean();
```

- ShoppingCartServiceImpl.java

```java
    /**
 * 清空购物车
 */
@Transactional
@Override
public void clean(){
        //设置用户id，指定当前是哪个用户的购物车数据
        Long currentId=BaseContext.getCurrentId();
        LambdaQueryWrapper<ShoppingCart> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,currentId);
        // DELETE FROM shopping_cart WHERE user_id=?
        shoppingCartService.remove(queryWrapper);
        //用下面这句user_id查不到，查的是id DELETE FROM shopping_cart WHERE id=?
//        shoppingCartService.removeById(currentId);
        }
```

### 代码开发-清空购物车

- ShoppingCartController.java

```java
/**
 * 减少购物车商品数量
 *
 * @param shoppingCart
 * @return
 */
@PostMapping("/sub")
public R<ShoppingCart> sub(@RequestBody ShoppingCart shoppingCart){
        return shoppingCartService.sub(shoppingCart);
        }
```

- ShoppingCartService.java

```java
    //减少购物车商品数量
    R<ShoppingCart> sub(ShoppingCart shoppingCart);
```

- ShoppingCartServiceImpl.java

```java
    /**
 * 减少购物车商品数量
 * @param shoppingCart
 * @return
 */
@Transactional
@Override
public R<ShoppingCart> sub(ShoppingCart shoppingCart){
        Long setmealId=shoppingCart.getSetmealId();
        Long dishId=shoppingCart.getDishId();
        LambdaQueryWrapper<ShoppingCart> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());

        if(setmealId!=null){
        queryWrapper.eq(ShoppingCart::getSetmealId,setmealId);
        }else{
        queryWrapper.eq(ShoppingCart::getDishId,dishId);
        }
        ShoppingCart one=shoppingCartService.getOne(queryWrapper);
        Integer number=one.getNumber();
        if(number==1){
        shoppingCartService.remove(queryWrapper);
        }else{
        one.setNumber(number-1);
        shoppingCartService.updateById(one);
        }

        return R.success(one);
        }
```

<h2 id="28">二十八、下单</h6>

---

### 需求分析

移动端用户将菜品或者套餐加入购物车后，可以点击购物车中的 【去结算】 按钮，页面跳转到订单确认页面，点击 【去支付】 按钮则完成下单操作。

### 数据模型

用户下单业务对应的数据表为orders表和order_detail表:

- orders:订单表：

  <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xd1.png" width="80%">

- order_detail:订单明细表

  <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xd2.png" width="80%">

### 代码开发

代码开发-梳理交互过程

在开发代码之前，需要梳理一下用户下单操作时前端页面和服务端的交互过程:

1. 在购物车中点击 【去结算】 按钮，页面跳转到订单确认页面
2. 在订单确认页面，发送ajax请求，请求服务端获取当前登录用户的默认地址
3. 在订单确认页面，发送ajax请求，请求服务端获取当前登录用户的购物车数据
4. 在订单确认页面点击 【去支付】 按钮，发送ajax请求，请求服务端完成下单操作

开发用户下单功能，其实就是在服务端编写代码去处理前端页面发送的请求即可。

### 代码开发-准备工作

在开发业务功能前，先将需要用到的类和接口基本结构创建好:

- 实体类Orders、OrderDetail（直接从课程资料中导入即可)
- Mapper接口OrderMapper、OrderDetailMapper
- 业务层接口OrderService、OrderDetailService
- 业务层实现类OrderServicelmpl、OrderDetailServicelmpl
- 控制层OrderController、OrderDetailController

### 代码开发

- 在OrderService添加submit方法用于用户下单

```java

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {

  @Autowired
  private ShoppingcartService shoppingcartService;

  @Autowired
  private UserService userService;

  @Autowired
  private AddressBookService addressBookService;

  @Autowired
  private OrderDetailService orderDetailService;

  @Override
  @Transactional
  public void submit(Orders orders) {
    //获取当前用户id
    Long currentId = BaseContext.getCurrentId();
    //查询当前用户的购物车数据
    LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(ShoppingCart::getUserId, currentId);
    List<ShoppingCart> list = shoppingcartService.list(queryWrapper);

    if (list == null || list.size() == 0) {
      throw new CustomException("购物车为空，不能下单");
    }
    //查询用户数据
    User user = userService.getById(currentId);
    //查询地址数据
    Long addressBookId = orders.getAddressBookId();
    AddressBook addressBook = addressBookService.getById(addressBookId);
    if (addressBook == null) {
      throw new CustomException("地址有误，不能下单");
    }

    long orderId = IdWorker.getId();//订单号

    AtomicInteger amount = new AtomicInteger(0);

    List<OrderDetail> orderDetails = list.stream().map((item) -> {
      OrderDetail orderDetail = new OrderDetail();
      orderDetail.setOrderId(orderId);
      orderDetail.setNumber(item.getNumber());
      orderDetail.setDishFlavor(item.getDishFlavor());
      orderDetail.setDishId(item.getDishId());
      orderDetail.setSetmealId(item.getSetmealId());
      orderDetail.setName(item.getName());
      orderDetail.setImage(item.getImage());
      orderDetail.setAmount(item.getAmount());
      amount.addAndGet(item.getAmount().multiply(new BigDecimal(item.getNumber())).intValue());
      return orderDetail;
    }).collect(Collectors.toList());


    //向订单表中插入一条数据
    orders.setNumber(String.valueOf(orderId));
    orders.setId(orderId);
    orders.setOrderTime(LocalDateTime.now());
    orders.setCheckoutTime(LocalDateTime.now());
    orders.setStatus(2);
    orders.setAmount(new BigDecimal(amount.get()));//计算总金额
    orders.setUserId(currentId);
    orders.setUserName(user.getName());
    orders.setConsignee(addressBook.getConsignee());
    orders.setPhone(addressBook.getPhone());
    orders.setAddress((addressBook.getProvinceName() == null ? "" : addressBook.getProvinceName())
            + (addressBook.getCityName() == null ? "" : addressBook.getCityName())
            + (addressBook.getDistrictName() == null ? "" : addressBook.getDistrictName())
            + (addressBook.getDetail() == null ? "" : addressBook.getDetail()));
    this.save(orders);

    //向订单明细表中插入多条数据
    orderDetailService.saveBatch(orderDetails);
    //清空购物车数据
    shoppingcartService.remove(queryWrapper);
  }
}

```

- 在OrderController的submit方法处理post请求实现上面的方法

```java
 /**
 * 用户下单
 *
 * @param order
 * @return
 */
@PostMapping("/submit")
public R<String> submit(@RequestBody Orders order){
        log.info("下单数据: {}",order);
        orderService.submit(order);
        return R.success("下单成功!");
        }
```

### 功能测试

下单界面：

  <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xd3.png" width="30%">

下单成功界面：

  <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xd4.png" width="30%">


<h2 id="29">二十九、 功能补充</h6>

---

### 用户登出

- 在UserController添加loginout方法

```java
//用户登出
@PostMapping("/loginout")
public R<String> loginout(HttpServletRequest request){
        //清理Session中保存的当前用户登录的id
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
        }
```

### 订单管理

- OrderDetailController.java

```java
 /**
 * 用户端展示自己的订单分页查询
 * 正确方法:直接从分页对象中获取订单id就行，问题大大简化了......
 *
 * @param page
 * @param pageSize
 * @return
 */
@GetMapping("/userPage")
public R<Page> page(int page,int pageSize){
        return orderDetailService.page(page,pageSize);
        }
```

- `OrderDetailServiceImpl.java

```java
/**
 * 抽离的一个方法，通过订单id查询订单明细，得到一个订单明细的集合
 * 这里抽离出来是为了避免在stream中遍历的时候直接使用构造条件来查询导致eq叠加，从而导致后面查询的数据都是null
 *
 * @param orderId
 * @return
 */
@Transactional
@Override
public List<OrderDetail> getOrderDetailListByOrderId(Long orderId){
        LambdaQueryWrapper<OrderDetail> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDetail::getOrderId,orderId);
        List<OrderDetail> orderDetailList=orderDetailService.list(queryWrapper);
        return orderDetailList;
        }

/**
 * 订单分页
 *
 * @param page
 * @param pageSize
 * @return
 */
@Transactional
@Override
public R<Page> page(int page,int pageSize){
        //分页构造器对象
        Page<Orders> pageInfo=new Page<>(page,pageSize);
        Page<OrdersDto> pageDto=new Page<>(page,pageSize);
        //构造条件查询对象
        LambdaQueryWrapper<Orders> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Orders::getUserId,BaseContext.getCurrentId());
        //这里是直接把当前用户分页的全部结果查询出来，要添加用户id作为查询条件，否则会出现用户可以查询到其他用户的订单情况
        //添加排序条件，根据更新时间降序排列
        queryWrapper.orderByDesc(Orders::getOrderTime);
        orderService.page(pageInfo,queryWrapper);

        //通过OrderId查询对应的OrderDetail
        LambdaQueryWrapper<OrderDetail> queryWrapper2=new LambdaQueryWrapper<>();

        //对OrderDto进行需要的属性赋值
        List<Orders> records=pageInfo.getRecords();
        List<OrdersDto> orderDtoList=records.stream().map((item)->{
        OrdersDto orderDto=new OrdersDto();
        //此时的orderDto对象里面orderDetails属性还是空 下面准备为它赋值
        Long orderId=item.getId();//获取订单id
        List<OrderDetail> orderDetailList=this.getOrderDetailListByOrderId(orderId);
        BeanUtils.copyProperties(item,orderDto);
        //对orderDto进行OrderDetails属性的赋值
        orderDto.setOrderDetails(orderDetailList);
        return orderDto;
        }).collect(Collectors.toList());

        //使用dto的分页有点难度.....需要重点掌握
        BeanUtils.copyProperties(pageInfo,pageDto,"records");
        pageDto.setRecords(orderDtoList);
        return R.success(pageDto);
        }

```

  <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xmyh.png" width="30%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xmyh1.png" width="29%">

### 管理端订单明细

- 在OrderDetailController添加page方法处理get请求

```java
    /**
 * 分页查询订单详情
 *
 * @param page
 * @param pageSize
 * @param number
 * @param beginTime
 * @param endTime
 * @return
 */
@GetMapping("/page")
public R<Page> page(int page,int pageSize,String number,String beginTime,String endTime){
        return orderDetailService.page(page,pageSize,number,beginTime,endTime);
        }
```

- OrderDetailServiceImpl.java

```java
    @Override
public R<Page> page(int page,int pageSize,String number,String beginTime,String endTime){
        log.info("page={}, pageSize={}, number={}, beginTime={}, endTime={}",page,pageSize,number,beginTime,endTime);
        //构造分页构造器
        Page<Orders> pageInfo=new Page<>(page,pageSize);
        //构造条件构造器
        LambdaQueryWrapper<Orders> queryWrapper=new LambdaQueryWrapper<>();

        queryWrapper.like(number!=null,Orders::getNumber,number)
        .ge(StringUtils.isNotEmpty(beginTime),Orders::getOrderTime,beginTime)
        .le(StringUtils.isNotEmpty(endTime),Orders::getOrderTime,endTime);

        //添加排序条件
        queryWrapper.orderByDesc(Orders::getOrderTime);

        //执行查询
        orderService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
        }
```

  <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xmyh3.png" width="80%">

### 外卖订单派送

- 在OrderDetailController处理post请求修改status

```java
/**
 * 更新状态
 *
 * @param orders
 * @return
 */
@PutMapping
public R<String> update(@RequestBody Orders orders){
        return orderDetailService.updateOrderDetail(orders);
        }
```

- OrderDetailServiceImpl.java

```java
/**
 * 更新状态
 *
 * @param orders
 * @return
 */
@Transactional
@Override
public R<String> updateOrderDetail(Orders orders){
        //判断传入参数是否合法
        Long orderId=orders.getId();
        Integer status=orders.getStatus();

        if(orderId==null||status==null){
        return R.error("传入信息不合法");
        }

        log.info("订单数据{}",orders);
        //SQL: UPDATE orders SET status=? WHERE id=?
        orderService.updateById(orders);
        return R.success("订单修改状态成功");
        }
```

  <img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/xmyh2.png" width="30%">

<h2 id="30">三十、 缓存优化</h6>

---

### 问题说明

用户数量多，系统访问量大频繁访问数据库，系统性能下降，用户体验差

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/hcyh.png" width="80%">

### 环境搭建

#### maven坐标

在项目的pom.xm1文件中导入spring data redis的maven坐标:

```xml

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

#### 配置文件

在项目的application.yml中加入redis相关配置:

```yml
spring
redis:
  host:172.17.2.94
  port: 6379
  password: root@123456
  database: 0
```

#### 配置类

在项目中加入配置类RedisConfig:

```java

@Configuration
public class RedisConfig extends CachingConfigurerSupport {
  @Bean
  public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
    RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
    //默认的Key序列化器为: JdkSerializationRedisSerializer
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setConnectionFactory(connectionFactory);
    return redisTemplate;
  }
}
```

可以用StringRedisTemplate就不用配置类

### 缓存短信验证码

#### 实现思路

前面我们已经实现了移动端手机验证码登录，随机生成的验证码我们是保存在HttpSession中的。现在需要改造为将验证码缓存在Redis中，具体的实现思路如下:

1. 在服务端UserController中注入RedisTemplate对象，用于操作Redis

```java
@Autowired
private RedisTemplate redisTemplate;
```

2. 在服务端UserController的sendMsg方法中，将随机生成的验证码缓存到Redis中，并设置有效期为5分钟

 ```java
redisTemplate.opsForValue().set(phone,code,5,TimeUnit.MINUTES);
```

3.在服务端UserController的login方法中，从Redis中获取缓存的验证码，如果登录成功则删除Redis中的验证码

```java
//从redis中获取保存的验证码
Object codeInSession=redisTemplate.opsForValue().get(phone);
//如果用户登录成功则删除Redis中缓存的验证码
        redisTemplate.delete(phone);
```

### 缓存菜品数据

#### 实现思路

前面我们已经实现了移动端菜品查看功能，对应的服务端方法为DishController的list方法，此方法会根据前端提交的查询条件进行数据库查询操作。在高并发的情况下，频繁查询数据库会导致系统性能下降，服务端响应时间增长。现在需要对此方法进行缓存优化，提高系统的性能。

具体的实现思路如下:

1. 改造DishController的list方法，先从Redis中获取菜品数据，如果有则直接返回，无需查询数据库;如果没有则查询数据库，并将查询到的菜品数据放入Redis。

```java
List<DishDto> dishDtoList=null;
//动态构造Key
        String key="dish_"+dish.getCategoryId()+"_"+dish.getStatus();
//先从redis中获取缓存数据
        dishDtoList=(List<DishDto>)redisTemplate.opsForValue().get(key);
        if(dishDtoList!=null){
        //如果存在，则直接返回，无需查询数据库
        return R.success(dishDtoList);
        }
        ...
        ...
        ...
//如果不存在，则查询数据库，并且将查询到的菜品数据添加到缓存中
        redisTemplate.opsForValue().set(key,dishDtoList,60,TimeUnit.MINUTES);

```

2. 改造DishController的save和update方法，加入清理缓存的逻辑

```java
//清理所有菜品缓存数据
//Set keys = redisTemplate.keys("dish_*");
//redisTemplate.delete(keys);

//清理某个分类下面的菜品缓存数据
String key="dish_"+dishDto.getCategoryId()+"_"+dishDto.getStatus();
        redisTemplate.delete(key);

```

注意：在使用缓存过程中，要注意保证数据库中的数据和缓存中的数据一致，如果数据库中的数据发生变化，需要及时清理缓存数据。

### Spring Cache介绍

Spring cache是一个框架，实现了基于注解的缓存功能，只需要简单地加一个注解，就能实现缓存功能。

Spring Cache提供了一层抽象，底层可以切换不同的cache实现。具体就是通过CacheManager接口来统一不同的缓存技术。

CacheManager是Spring提供的各种缓存技术抽象接口。

针对不同的缓存技术需要实现不同的CacheManager:

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/hcyh1.png" width="80%">

#### Spring Cache常用注解

<img src="https://gitee.com/zheng-zicong27/cc-code/raw/master/src/main/resources/img/hcyh2.png" width="80%">


在spring boot项目中，使用缓存技术只需在项目中导入相关缓存技术的依赖包，并在启动类上使用@EnableCaching开启缓存支持即可。

例如，使用Redis作为缓存技术，只需要导入Spring data Redis的maven坐标即可。

#### Spring Cache使用方式

在Spring Boot项目中使用Spring Cache的操作步骤(使用redis缓存技术);

1. 导入maven坐标

- spring-boot-starter-data-redis、spring-boot-starter-cache

2. 配置application.yml

```yaml
spring:
  cache:
    redis:
      time-to-live: 1800000#设置缓存有效期

```

3. 在启动类上加入@EnableCaching注解，开启缓存注解功能

4. 在Controller的方法上加入@Cacheable、@CacheEvict等注解，进行缓存操作

### 缓存套餐数据

#### 实现思路

前面我们已经实现了移动端套餐查看功能，对应的服务端方法为SetmealController的list方法，此方法会根据前端提交的查询条件进行数据库查询操作。在高并发的情况下，频繁查询数据库会导致系统性能下降，服务端响应时间增长。现在需要对此方法进行缓存优化，提高系统的性能。

具体的实现思路如下:

1. 导入Spring Cache和Redis相关maven坐标
2. 在application.yml中配置缓存数据的过期时间
3. 在启动类上加入@EnableCaching注解，开启缓存注解功能
4. 在SetmealController的list方法上加入@Cacheable注解
5. 在SetmealController的save和delete方法上加入CacheEvict注解

#### 代码改造

在pom.xml文件中导入maven坐标:

```java
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-cache</artifactId>
</dependency>

```

在application.yml中配置缓存数据过期时间:

```yml
cache:
  redis:
    time-to-live: 1800000 #设置缓存数据过期时间
```

在启动类@EnableCaching注解

在list方法上添加注解，实现在redis里添加缓存：

```java
@Cacheable(value = "setmealCache", key = "#setmeal.categoryId+'_'+#setmeal.status")
```

在update，add，delete方法上添加注解，清除缓存：

```java
@CacheEvict(value = "setmealCache", allEntries = true)
```

注意：要让R实现Serializable接口（序列化），注解才能生效

## 🎊写在最后

---

> #### 🍻 感谢您能看到这里，如果您有什么想法或建议，请随时反馈给我。
> #### 🚿 本次有幸通过传智播客黑马的与学校合作的实训接触这个项目，通过自己的学习和学习、网络资源完成此项目。
> #### 🛏️ 通过此次实训，掌握了 SpringBoot 框架的各种知识，且能够在实训中独立自己完成一个项目。
> #### 🛋️ 本次项目使我加深了 debug 的经验，能通过调试去发现 bug 从而进行解决。
> #### 🕹️ 最大的收获还是独立开发一个完整项目的经验与乐趣，以后可以更加深入了解 SpringBoot 框架。

## 🤖 智能客服模块

---

### 📖 模块简介

这是一个为外卖系统添加的智能客服模块，可以作为 Spring AI 应用示范项目，非常适合用于后端岗位面试。

#### 核心功能

✅ **智能问答** - 基于 DeepSeek 大模型的 AI 智能回复  
✅ **聊天历史** - 自动保存聊天记录，支持查看历史对话  
✅ **快捷问题** - 预设常见问题，一键快速提问  
✅ **友好界面** - 现代化的聊天界面，实时消息展示  

### 🏗️ 技术架构

#### 后端技术栈

- **Spring Boot 2.4.5** - 核心框架
- **MyBatis-Plus 3.4.2** - ORM 框架
- **MySQL** - 数据库
- **DeepSeek AI** - 大模型集成

#### 前端技术栈

- **Vue.js 2.x** - 渐进式 JavaScript 框架
- **Vant UI** - 移动端组件库
- **Axios** - HTTP 客户端

### 🚀 快速开始

#### 方式一：使用 IDE（推荐）

1. **打开 IDE** → IntelliJ IDEA 或 Eclipse
2. **导入项目** → File → Open → 选择项目根目录
3. **运行应用** → 找到 `ReggieApplication.java` → 右键 Run
4. **访问系统** → http://localhost:8080/front/index.html

#### 方式二：使用启动脚本

```powershell
# 在 PowerShell 中执行
$env:JAVA_HOME = "C:\Program Files\Java\jdk1.8.0_202"
$env:PATH = "$env:JAVA_HOME\bin;$env:PATH"
mvn spring-boot:run
```

### 📱 使用流程

1. **登录系统** → 使用已有账号或注册新账号
2. **进入个人中心** → 点击右上角用户头像
3. **点击"联系客服"** → 进入聊天界面
4. **开始对话** → 输入问题或点击快捷问题

#### 测试示例

| 提问 | 预期回复 |
|------|----------|
| 配送费多少钱？ | 配送费为 6 元，满 50 元免配送费哦！ |
| 有什么优惠活动？ | 新用户注册即送 18 元红包！每日签到也可领取优惠券... |
| 推荐几个招牌菜 | 我们的招牌菜有：宫保鸡丁、鱼香肉丝、麻婆豆腐... |
| 如何申请退款？ | 如需退款，请在订单页面申请退款，我们会在 1-3 个工作日内处理。 |

### 💡 面试加分点

#### 技术能力展示

- ✅ Spring Boot 整合能力
- ✅ MyBatis-Plus 使用
- ✅ MySQL 数据库设计
- ✅ Vue.js 前端开发
- ✅ RESTful API 设计
- ✅ AI 应用集成概念

#### 工程化思维

- ✅ 代码分层清晰
- ✅ 注释规范详细
- ✅ 异常处理完善
- ✅ 日志记录合理
- ✅ 文档齐全

#### 产品思维

- ✅ 用户体验优先
- ✅ 快捷问题设计
- ✅ 降级方案完备
- ✅ 可扩展性强

### 🔧 技术实现

#### 项目结构

```
waimai program/
├── src/main/java/com/cc/reggie/
│   ├── entity/              # 实体类
│   │   └── ChatRecord.java
│   ├── mapper/              # 数据访问层
│   │   └── ChatRecordMapper.java
│   ├── dto/                 # 数据传输对象
│   │   ├── ChatRequest.java
│   │   └── ChatResponse.java
│   ├── service/             # 业务逻辑层
│   │   ├── ChatService.java
│   │   └── impl/ChatServiceImpl.java
│   └── controller/          # 控制器
│       └── ChatController.java
├── src/main/resources/
│   ├── front/
│   │   ├── page/chat.html   # 聊天页面
│   │   └── api/chat.js      # 聊天 API
│   └── chat_record.sql      # 建表脚本
└── pom.xml                  # Maven 配置
```

#### 数据库表结构

```sql
CREATE TABLE IF NOT EXISTS `chat_record` (
    `id` bigint(20) NOT NULL COMMENT '主键 ID',
    `user_id` bigint(20) DEFAULT NULL COMMENT '用户 ID',
    `question` text COMMENT '用户问题',
    `answer` text COMMENT 'AI 回答',
    `session_id` varchar(100) DEFAULT NULL COMMENT '会话 ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `deleted` int(11) DEFAULT '0' COMMENT '逻辑删除 0-未删除 1-已删除',
    PRIMARY KEY (`id`),
    KEY `idx_session_id` (`session_id`),
    KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='智能客服聊天记录';
```

### ❓ 常见问题

#### Q1: 编译失败 "No compiler is provided"

**原因**: Maven 使用的是 JRE 而不是 JDK

**解决方案**:
- 方案 A: 使用 IDE（最简单）直接在 IntelliJ IDEA 或 Eclipse 中运行
- 方案 B: 配置环境变量（永久解决）

以管理员身份运行 PowerShell：
```powershell
[System.Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\Java\jdk1.8.0_202", "Machine")
$currentPath = [System.Environment]::GetEnvironmentVariable("PATH", "Machine")
[System.Environment]::SetEnvironmentVariable("PATH", "$currentPath;%JAVA_HOME%\bin", "Machine")
```

重启终端后再次运行启动脚本

#### Q2: 端口被占用怎么办？

**解决方案**: 在 `application.yml` 中修改端口号：
```yaml
server:
  port: 8081  # 改为其他端口
```

#### Q3: 如何清除聊天记录？

**解决方案**: 执行 SQL 清空表：
```sql
TRUNCATE TABLE chat_record;
```

### 🎯 扩展升级

#### 集成真实 AI 服务

当前已集成 DeepSeek 大模型，可以轻松替换为其他 AI 服务：

```java
// 在 ChatServiceImpl.java 中
public ChatResponse chat(Long userId, String sessionId, String question) {
    // 调用 DeepSeek API
    String answer = callAiApi(question);
    return new ChatResponse(answer, sessionId);
}
```

#### 可配置 API Key

在 `application.yml` 中配置：
```yaml
reggie:
  ai:
    enabled: true  # 是否启用 AI
    api-key: your-api-key-here  # API Key
    api-url: https://api.example.com/v1/chat/completions  # API 地址
    model: model-name  # 模型名称
    system-prompt: 你是一个外卖系统的智能客服助手...  # 系统提示词
```

### 📝 注意事项

1. **API 余额**: 定期检查 DeepSeek 账户余额，避免欠费
2. **错误处理**: 代码已实现降级方案，API 失败时自动切换到本地关键词匹配
3. **日志记录**: 所有对话都会保存到数据库 chat_record 表
4. **安全考虑**: API Key 保存在配置文件，不要提交到 Git

### 🎉 总结

智能客服模块展示了从需求分析、技术选型、系统设计到编码实现的完整过程。通过集成 DeepSeek 大模型，实现了专业的智能客服功能，适合作为面试项目展示技术实力。

**祝你面试顺利，拿到理想的 Offer！🎉**