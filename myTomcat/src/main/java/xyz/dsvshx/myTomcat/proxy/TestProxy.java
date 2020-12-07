package xyz.dsvshx.myTomcat.proxy;

import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassReader;

import net.sf.cglib.core.DebuggingClassWriter;
import sun.misc.ProxyGenerator;

/**
 * @author dongzhonghua
 * Created on 2020-12-06
 */
public class TestProxy {
    private static String outputFile =
            "/Users/dzh/Documents/kuai/github/Tomdog/myTomcat/src/main/java/xyz/dzh/myTomcat/proxy/output";

    //控制cglib生成的class文件持久化到本地硬盘
    static {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, outputFile);
    }

    public static void main(String[] args) throws IOException {
        TestProxy testProxy = new TestProxy();
        BookFacadeImpl bookProxy = testProxy.cglibProxyClient();
        bookProxy.addBook();


        jdkToFile(bookProxy);
        testProxy.testSerail();
    }

    public void testSerail() throws IOException {
        BookFacadeImpl obj = new BookFacadeImpl();
        toFile(obj);
    }

    public void jdkProxyClient() {
        BookFacadeProxyJdk proxy = new BookFacadeProxyJdk();
        BookFacade bookProxy = (BookFacade) proxy.createProxy(new BookFacadeImpl());
        bookProxy.addBook();
    }

    public BookFacadeImpl cglibProxyClient() {
        BookFacadeProxyCglib proxy = new BookFacadeProxyCglib();
        BookFacadeImpl bookProxy = (BookFacadeImpl) proxy.getInstance(new BookFacadeImpl());
        return bookProxy;
    }

    //JDK动态代理生成的字节码文件持久化
    public static void jdkToFile(BookFacadeImpl obj) throws IOException {
        Class clazz = obj.getClass();
        String className = clazz.getName();
        byte[] classFile = ProxyGenerator.generateProxyClass(className, BookFacadeImpl.class.getInterfaces());
        FileOutputStream fos = new FileOutputStream(outputFile);
        // ClassReader cr = new ClassReader(className);
        // byte[] bits = cr.b;
        fos.write(classFile);
    }

    //另一种JDK字节码文件持久化方法
    public static void toFile(BookFacadeImpl obj) throws IOException {
        Class clazz = obj.getClass();
        String className = clazz.getName();
        FileOutputStream fos = new FileOutputStream(outputFile);
        ClassReader cr = new ClassReader(className);
        byte[] bits = cr.b;
        fos.write(bits);
    }
}