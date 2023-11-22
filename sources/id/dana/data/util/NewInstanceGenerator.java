package id.dana.data.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* loaded from: classes8.dex */
public class NewInstanceGenerator {
    public static <T> T createInstance(Constructor<T> constructor, List<Object> list) {
        Object[] objArr = new Object[list.size()];
        list.toArray(objArr);
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }
}
