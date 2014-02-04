package com.myspace.common;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class Test {
   public static void main(String[] args) {
	   RealObject obj = new RealObject();
	   simpleDynamicProxy.consumer(obj);
	   Interface proxy = (Interface)Proxy.newProxyInstance(Interface.class.getClassLoader(), 
			     new Class[]{Interface.class}, new ProxyHandler(obj));
	   simpleDynamicProxy.consumer(proxy);
   }
   
   public enum ExecutorType {
	   SIMPLE, REUSE, BATCH
    }
   
   private static <T> T getinstance(Class<T> clazz){
	   return  (T)clazz;
   }
}

class ProxyHandler implements InvocationHandler{
	
	private Object proxied;
	
	public ProxyHandler(Object proxied){
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("***proxy:"+proxy.getClass()+",method:"+method+",args:"+args);
		if(args!=null){
			for(Object arg:args){
				System.out.println(" "+arg);
			}
		}
		return method.invoke(proxied, args);
	}
	
}

interface Interface{
	public void dosomething();
}

class simpleDynamicProxy{
	public static void consumer(Interface iface){
		iface.dosomething();
	}
}

class RealObject implements Interface{
	public void dosomething(){
		System.out.println("do something!");
	}
}


