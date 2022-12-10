一、springcloud的介绍

微服务架构的4个核心问题：
    1、服务太多，客户端如何去访问？    api
    2、服务之间如何通信？            HTTP/RPC
    3、如何治理服务？               注册与发现
    4、服务挂了怎么办?              熔断机制

如何解决这四个问题？

    1、springcloud NetFlix （一站式解决方案）
        api网关：
        Fegin：
        服务注册发现：Eureka
        熔断机制：Hystrix

    2、springcloud Alibaba  （一站式解决方案,更简单）


    3、apache dubbo zookeeper



常见的微服务面试题：
    1、什么是微服务？
        关注于一个点，具体解决某一个问题的一个服务应用。可以类比于一个模块项目，一个模块就做一件事！

    8、eureka与zookeeper的区别？
    2、微服务之间如何独立通信？
    3、springcloud和dubbo的区别？
    4、谈谈springboot和springcloud的理解？
        springboot专注于单个微服务开发；
        springcloud关注于全局的微服务协调治理框架，它将一个个单体微服务整合并管理起来;
        springcloud离不开springboot。
        



    5、服务熔断与服务降级？
    6、微服务的优缺点？
    7、列举微服务的技术栈？
        服务开发：spring、springboot。
        服务注册：eureka、zookeeper
        服务熔断：
        消息队列：rabbitmq
        …………



  
二、具体案例实现

1、基础案例部分：

    1.1、
    RestTemplate：
        spring 框架提供的 RestTemplate 类可用于在应用中调用 rest 服务，它简化了与 http 服务的通信方式，统一了 RESTful 
    的标准，封装了 http 链接， 我们只需要传入 url 及返回值类型即可。
    
    注：后面有更多需求再来深入了解即可！


2、eureka（服务注册）
2.1、
    Eureka是用于注册中心的。注册中心的本质是为了接耦服务提供者和服务消费者。

    Eureka 包含两个组件：Eureka Server 和 Eureka Client，Eureka Client是⼀个 Java客户端，
⽤于简化与Eureka Server的交互；Eureka Server提供服务发现的 能⼒，各个微服务启动时，会通过Eureka Client
向Eureka Server 进⾏注册⾃⼰ 的信息（例如⽹络信息），Eureka Server会存储该服务的信息。


    Eureka自我保护机制：某时刻一个微服务不用了，eureka不会立即清理，依旧会对该微服务信息进行保存！

    Eureka关键概念
        服务注册：register
        服务续约：renew， 客户端默认每隔30秒向服务器发送一次心跳进行续约，如果服务器90秒内没有收到心跳，则将该客户端剔除
        获取服务注册列表信息:fetch registries
        服务下线:cancel
        服务剔除eviction



2.2 具体操作
    一般框架组件整合的流程：
        导入依赖：
        查看对应的配置类，编写配置数据个性化：
        开启该功能：@enable……


    2.2.1  集群配置
        一台计算机的微服务项目注册到另外几台主机上面；另外几台主机相互关联
        注：操作简单，具体实现看项目代码即可！




3、负载均衡（尽量让所有的服务者有事可做）   

3.1、ribbon
    负载均衡（Load Balance，LB）:将用户请求平摊到多个服务上，从而到达系统的HA（高可用）。

    负载均衡的分类：
        集中式LB:
            在服务的消费方和服务方之间使用独立的LB设施。如Nginx。            

        进程式LB：
            ribbon就是一个进程式LB。消费方通过它来获取到服务提供方的地址!


3.2 ribbon与具体案例
    为了体验一下负载均衡的功能，我在同一个数据库建了三张相同数据的表（表名不一样）以供三个不同的服务提供者连接。
    然后消费者通过ribbon去得到服务：
        Ribbon和Eureka整合后Consumer可以直接调用服务名而不用再关心ip地址和端口号；
        三个服务者的“Spring.application.name”都是一样，以便消费者调度（端口号可以变）；
        ribbon从提供相同服务的服务者中选出一个最空闲的来提供服务。
    
    ribbon的调度算法可以自定义：
        

4、feign
feign使得微服务之间的调用更简单。
之前的ribbon+resttemplete请求调用不是很方便;feign在前者的基础上做了进一步的封装。
（具体实现见代码）


5、hystrix

5.1 服务熔断

    服务雪崩：
        分布式系统环境下，服务间类似依赖非常常见，一个业务调用通常依赖多个基础服务。当Service A的流量波动很大，
    流量经常会突然性增加！那么在这种情况下，就算Service A能扛得住请求，Service B和Service C未必能扛得住这
    突发的请求。
        简单地讲。一个服务失败，导致整条链路的服务都失败的情形，我们称之为服务雪崩。

        解决方案：服务降级、服务熔断
    
    服务熔断：当下游的服务因为某种原因突然变得不可用或响应过慢，上游服务为了保证自己整体服务的可用性，
    不再继续调用目标服务，直接返回，快速释放资源。如果目标服务情况好转则恢复调用。服务熔断可视为降级方式的一种。

    服务熔断的操作方法：
        导入依赖、编写熔断机制对应的方法放入对应的controller方法下、开启熔断功能：“@EnableCircuitBreaker”
        具体实现见“springcloud-provider-dept-hystrix”


5.2 服务降级

    服务降级：是从整个系统的负荷情况出发和考虑的，对某些负荷会比较高的情况，为了预防某些功能（业务场景）出现负荷过载或者
响应慢的情况，在其内部暂时舍弃对一些非核心的接口和数据的请求，而直接返回一个提前准备好的fallback（退路）错误处理信息。
这样，虽然提供的是一个有损的服务，但却保证了整个系统的稳定性和可用性。


    熔断跟降级的对比：
        相似之处：
            目标一致 都是从可用性和可靠性出发，为了防止系统崩溃；
            用户体验类似 最终都让用户体验到的是某些功能暂时不可用；
        不通点：
            触发原因不同 服务熔断一般是某个服务（下游服务）故障引起，而服务降级一般是从整体负荷考虑； 
            熔断作用在提供者；降级作用在消费者。

    
    代码实现见springcloud-api、springcloud-consumer-dept-feign模块即可。


5.3、服务监控

    简单得很，具体实现见springcloud-consumer-hystrix-dashboard即可！




6、Zuul（路由网关）


zuul的两个主要功能：
    路由：
        将外部请求转发到具体的微服务实例上面，实现外部访问同一入口的基础。
    过滤：
        对请求进行干预，做一些过滤操作，

    
    具体实现见springcloud-zuul9092：

7、configserver

在客户端连接服务端访问远程配置这里遇到一点bug：配置的开发与测试环境读取有问题。（问题不大，但是不舒服，后面回来再解决）

    具体实现见带“config”的案例


三、总结

