package controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import annotation.MostrarAnot;

public class Util {
	public static Object createNewInstance(Class clazz)
			throws InstantiationException, IllegalAccessException,
			InvocationTargetException {
		Constructor<?> ctor;
		try {
			ctor = clazz.getConstructors()[0];
			Object object = ctor.newInstance();
			return object;

		} catch (SecurityException | IllegalArgumentException e) {
			e.printStackTrace();

		}

		return null;
	}

	public static void mostrarValores(Object obj)
			throws InvocationTargetException, IllegalAccessException {
		try {
			Class clazz = obj.getClass();
			for (Method m : clazz.getDeclaredMethods()) {
				if (m.isAnnotationPresent(MostrarAnot.class)) {
					if (m.getParameterTypes().length > 0) {
						System.err.println(" "+ m.getName()+" anotado com @Mostrar");
						continue;
					}
					System.out.println(m.getName() + ": " + m.invoke(obj));
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();

		}
	}

}
