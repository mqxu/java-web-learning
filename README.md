> java-web-learning 2022
***
# day01-servlet
## 一、学习目标

> 理解Web相关概念和Web服务器概述
>
> 会安装、卸载、启动和关闭Tomcat
>
> 掌握使用Tomcat部署项目
>
> 能够创建动态Web项目和Tomcat与IDEA集成配置
>
> 了解Servlet概念
>
> 掌握Servlet的执行原理和生命周期
>
> 了解Servlet注解配置

## 二、学习内容
### 1. Web相关基本概念
1.1 软件架构

1.2 资源分类

1.3 网络通信三要素
### 2. Web服务器软件概述
2.1 服务器

2.2 服务器软件

2.3 Web服务器软件
### 3. Tomcat
3.1 安装、卸载、启动

3.2 Tomcat启动问题分析

3.3 Tomcat的关闭

### 4. Web开发初体验
4.1 部署Web项目的方式

4.2 Tomcat的目录结构

4.3 IDEA创建Web项目

### 5. Servlet入门
5.1 Servlet概述

5.2 Servlet快速入门

5.3  Servlet执行原理

5.4 Servlet生命周期方法

5.5 Servlet生命周期详解

### 6. 基于注解的Servlet
6.1 使用注解的优点

6.2 使用注解来开发Servlet的步骤

### 7. Servlet体系结构和配置
7.1 Servlet体系结构

7.2 Servlet之url-pattern配置

### 8. 补充
8.1 JakartaEE

8.2 不同版本Servlet与Tomcat、JDK的对应关系


![day01](https://cdn.jsdelivr.net/gh/mqxu/wiki-image@master/day01-Tomcat&Servlet.2lkdd8liqkk0.webp)
***

# day02-request
## 一、学习目标

> 1. 掌握Servlet的体系结构，了解其他Servlet配置
> 2. 理解HTTP协议及HTTP请求的结构（请求行，头，体）
> 3. 熟练掌握使用HttpServletRequest获取常用的头信息， 请求参数，请求参数乱码处理，转发的特点

## 二、学习内容

### 1. HTTP协议之请求
1.1 HTTP_概述

1.2 HTTP_请求消息_请求行

1.3 HTTP_请求消息_请求头&请求体

### 2. HttpServletRequest（一）
2.1 Request原理

2.2 Request继承体系

2.3 Request获取请求行数据_方法介绍

2.4 Request获取请求行数据_代码演示

2.5 Request_获取请求头数据

2.6 Request_获取请求体数据

### 3. HttpServletRequest（二）
3.1 Request_获取请求参数通用方式介绍

3.2 Request_获取请求参数通用方式演示

3.3 Request_获取请求参数中文乱码问题处理

3.4 Request_请求转发

3.5 Request_共享数据(域对象)

3.6 Request_获取ServletContext

![day02](https://cdn.jsdelivr.net/gh/mqxu/wiki-image@master/day02-HTTP&Request.2mkeq9dwfe00.webp)
***
# day03-response
## 一、学习目标

> 1. 掌握http协议之响应部分
> 2. 熟练掌握Response的相关 API （重定向，路径，输出流）
> 3. 掌握ServletContext的常用API
> 4. 独立完成文件下载案例

## 二、学习内容

### 1. HTTP协议之响应消息
1.1 HTTP_响应消息_概述

1.2 HTTP_响应消息_响应行_状态码

1.3 HTTP_响应消息_响应头

### 2. Response对象（一）
2.1 Response_功能介绍

2.2 Response_案例1_重定向_代码实现

2.3 Response_案例1_重定向_特点

### 3. Response对象（二）
3.1 Response_案例1_路径_相对路径

3.2 Response_案例1_路径_绝对路径

3.3 Response_案例2_输出字符数据

3.4 Response_案例3_输出字节数据

### 4. Response对象（三）
4.1 Response_案例4_验证码_分析

4.2 Response_案例4_验证码_代码实现

4.3 Response_案例4_验证码_点击切换

### 5. ServletContext对象
5.1 ServletContext_概述

5.2 ServletContext_获取

5.3 ServletContext_功能_获取MIME类型

5.4 ServletContext_功能_域对象

5.5 ServletContext_功能_获取文件服务器路径

### 6. 文件下载案例
6.1 案例_文件下载_分析

6.2 案例_文件下载_代码实现

6.3 案例_文件下载_中文文件名问题

![day03](https://cdn.jsdelivr.net/gh/mqxu/wiki-image@master/day03-Response.13cf5hu3y4xs.webp)
***

