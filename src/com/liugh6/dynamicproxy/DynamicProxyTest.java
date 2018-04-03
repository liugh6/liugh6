package com.liugh6.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

	interface IHello {
		void sayHello(String s);
	}

	static class Hello implements IHello {

		@Override
		public void sayHello(String s) {
			// TODO Auto-generated method stub
			System.out.println("hello world");
			System.out.println("����ֵ��" + s);
		}

	}

	static class DynamicProxy implements InvocationHandler {

		Object originalObj;

		Object bind(Object originalObj) {
			this.originalObj = originalObj;
			return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),
					originalObj.getClass().getInterfaces(), this);
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			// TODO Auto-generated method stub
			System.out.println("welcome");
			return method.invoke(originalObj, args);
		}

	}

	public static void main(String[] args) {
		IHello hello = (IHello) new DynamicProxy().bind(new Hello());
		hello.sayHello("123");
		// System.getProperties().put("sun.misc.ProxyGenerator.saveGenerateFiles",
		// "true");
		// helloΪ�ڴ������ɵĴ�����$Proxy0
		System.out.println(hello.getClass());
	}
}
