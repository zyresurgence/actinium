# RabbitMQ

## 安装 

``` tex
1.版本准备 centos8 分别下载erlang socat rabbitmq-server
# erlang
https://github.com/rabbitmq/erlang-rpm/releases
https://github.com/rabbitmq/erlang-rpm/releases/download/v24.1/erlang-24.1-1.el8.x86_64.rpm

# socat 
https://centos.pkgs.org/8-stream/centos-appstream-x86_64/socat-1.7.4.1-1.el8.x86_64.rpm.html

# rabbitmq-server 
https://github.com/rabbitmq/rabbitmq-server/releases/
https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.9.7/rabbitmq-server-3.9.7-1.el7.noarch.rpm

2.安装
在 /usr/local 下创建 rabbitmq并进入
yum install ./erlang-24.1-1.el8.x86_64.rpm
yum install ./socat-1.7.3.3-2.el8.x86_64.rpm
yum install ./rabbitmq-server-3.9.7-1.el8.noarch.rpm

3.启动停止服务
service rabbitmq-server start
service rabbitmq-server stop
service rabbitmq-server status
service rabbitmq-server restart

4.管理
# 启动服务
service rabbitmq-server start

#启用插件页面管理
rabbitmq-plugins enable rabbitmq_managerment

#创建用户
rabbitmqctl add_user admin admin

#赋予权限
rabbitmqctl set_user_tags admin administrator
rabbitmqctl set_permissions -p/admin ".*" ".*" ".*"

5.控制台
访问 IP:15762
```



## 基础入门

**PS:**[参考](https://developer.aliyun.com/article/769883)

### 消息队列(Message Queue)

**消息：**指两个应用之间传递的数据。数据形式多样，包括字符串，对象等。

**消息队列：**在消息传输过程中保存消息的容器。消息队列中主要包括，生产者和消费者两个角色，生产者只负责发送数据到消息队列，消费者支付者从消息队列中取数据。

#### 消息队列作用

1. **解耦。**生产者只用提供数据，具体的调用由消费者决定。
2. **异步。**生产者在发送数据的时候，不需要等待消费者反馈，只用关心数据的发送情况直接响应。
3. **削峰。**可以在短时间内积攒一定的消息，不用一次性的将数据全部保存到数据库，减少数据库的压力。

#### 消息对列的特点

Erlang语言开发。实现AMQP

1. 可靠性。支持持久化，传输确认，发布确认等保证了MQ的可靠性。
2. 灵活的分发消息策略。这应该是RabbitMQ的一大特点。在消息进入MQ前由Exchange(交换机)进行路由消息。分发消息策略有：简单模式、工作队列模式、发布订阅模式、路由模式、通配符模式。
3. 支持集群。多台RabbitMQ服务器可以组成一个集群，形成一个逻辑Broker。
4. 多种协议。RabbitMQ支持多种消息队列协议，比如 STOMP、MQTT 等等。
5. 支持多种语言客户端。RabbitMQ几乎支持所有常用编程语言，包括 Java、.NET、Ruby 等等。
6. 可视化管理界面。RabbitMQ提供了一个易用的用户界面，使得用户可以监控和管理消息 Broker。
7. 插件机制。RabbitMQ提供了许多插件，可以通过插件进行扩展，也可以编写自己的插件。

## RabbitMQ 组成部分

1. Broker：消息队列服务进程。此进程包括两个部分：Exchange和Queue。
2. Exchange：消息队列交换机。**按一定的规则将消息路由转发到某个队列**。
3. Queue：消息队列，存储消息的队列。
4. Producer：消息生产者。生产方客户端将消息同交换机路由发送到队列中。
5. Consumer：消息消费者。消费队列中存储的消息。

### 工作流程

1. 消息生产者连接到RabbitMQ Broker，创建connection，开启channel。
2. 生产者声明交换机类型、名称、是否持久化等。
3. 生产者发送消息，并指定消息是否持久化等属性和routing key。
4. exchange收到消息之后，**根据routing key路由到跟当前交换机绑定的相匹配的队列**里面。
5. 消费者监听接收到消息之后开始业务处理。

### Exchange类型及用法

#### Direct Exchange（私聊）

一对一，由特定的路由键完全匹配，点对点发送。

#### Fanout Exchange（群发）

发送到该交换机的消息会被转发到 所有与该交换机绑定的队列上。

#### Topic Exchange

使用通配符 

***：**有且匹配一个词 。a.*  --> a.b 无法匹配a.b.c

**#：**匹配一个或者多个词。

#### Headers Exchange

匹配请求头中所有带键值的进行路由。分为 **全部匹配和部分匹配**

## 消息确认

### Confirm机制



## 消息丢失

PS:[参考1](https://www.jianshu.com/p/d7dd40a15798)
    [参考2](https://blog.csdn.net/weixin_38405253/article/details/103740420)

### 生产者发送消息

生产者将消息发送到交换机（Exchange）时丢失。例：网络异常，发送的Exchange不存在。

### 路由失败

消息已经发送到了Exchange但是Exchange将消息根据Routing 路由到对应的队列（Queue）时失败。例：未绑定Queue

### 客户端处理消息

客户端获取到了消息，但是处理消息过程中出现异常，未做异常处理导致消息丢失。

