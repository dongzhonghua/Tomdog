package xyz.dsvshx.aop.proxy;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */
public interface Proxy {
    Object doProxy(ProxyChain proxy) throws Throwable;
}
