[TOC]

# tomdog
这个项目期初只有myTomcat一个项目，参考了一个大佬的文章，用几百行代码把Tomcat的原理非常清晰的讲明白了。
主要的功能包含socket服务，将HTTP请求封装成自己的Request和Response。提供了servlet风格的接口，实现了dispatch功能。
总之非常牛逼。后来对他进行了改进，每一次添加servlet都需要加一行配置，所以我就想到使用spring风格的注解来完成servlet的自动扫描。
写完之后我就发现，这不就是实现了一个简易版的IOC吗。
于是我就想能不能多干点，继续完善这个项目，把IOC的功能继续完善并且实现AOP等功能？
就在这时我发现网上了一个开源项目，[smart-framework](https://my.oschina.net/huangyong/blog/158380)。
这个项目是黄勇大佬13年的开源项目，实现的功能直到今天也是开发过程中会用到的主流技术。而且代码风格简洁，用到了很多牛逼的技术，
实现一些功能的时候往往用十几行代码就能完成，非常的适合初学者。

研究了一番之后，我便决定参照这个项目自己再实现一遍，毕竟造轮子使我快乐，主要就是实现类似spring的IOC和AOP功能。
另外，项目很久没有维护了，有必要加入一些新的特性。而且我也发现了项目中一些可以优化的点，我会把这些一起都放在我的这个项目里。

## my-tomcat

这个子项目是我以前偶然间跟着一个教程做出来的，已给非常建的的小功能，但是没有这个项目我也不会这么幸运的发现smart。即使看了spring的源码我也不会像现在一样从实现的角度来去看一个东西的源码。
非常感谢这个小项目，我也希望保留这个项目来激励我把这件事情做下去。
原文地址：https://www.jianshu.com/p/dce1ee01fb90

## my-tomdog

就在这个子项目里来重新实现一下smart的一些功能，我也发现了很多有意思的改进的地方。
那就开始干吧。

- util
    - 这个项目先从重构一个ClassUtil开始吧


## spring-example

这个子项目用来测试spring相关的功能，有许多spring的功能需要一些例子来参考。

系列地址：

## thinking

servlet相关的部分是不是可以用netty来实现一个呢，利用netty解析请求，然后自己做一个servlet。我觉得这个可以！

https://github.com/pyloque/httpkids