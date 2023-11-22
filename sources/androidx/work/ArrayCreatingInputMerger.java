package androidx.work;

import androidx.work.Data;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ArrayCreatingInputMerger extends InputMerger {
    @Override // androidx.work.InputMerger
    public final Data PlaceComponentResult(List<Data> list) {
        Object newInstance;
        Object newInstance2;
        Data.Builder builder = new Data.Builder();
        HashMap hashMap = new HashMap();
        Iterator<Data> it = list.iterator();
        while (it.hasNext()) {
            for (Map.Entry entry : Collections.unmodifiableMap(it.next().MyBillsEntityDataFactory).entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                Class<?> cls = value.getClass();
                Object obj = hashMap.get(str);
                if (obj == null) {
                    if (cls.isArray()) {
                        hashMap.put(str, value);
                    } else {
                        newInstance2 = Array.newInstance(value.getClass(), 1);
                        Array.set(newInstance2, 0, value);
                        value = newInstance2;
                        hashMap.put(str, value);
                    }
                } else {
                    Class<?> cls2 = obj.getClass();
                    if (cls2.equals(cls)) {
                        if (cls2.isArray()) {
                            int length = Array.getLength(obj);
                            int length2 = Array.getLength(value);
                            Object newInstance3 = Array.newInstance(obj.getClass().getComponentType(), length + length2);
                            System.arraycopy(obj, 0, newInstance3, 0, length);
                            System.arraycopy(value, 0, newInstance3, length, length2);
                            value = newInstance3;
                        } else {
                            newInstance2 = Array.newInstance(obj.getClass(), 2);
                            Array.set(newInstance2, 0, obj);
                            Array.set(newInstance2, 1, value);
                            value = newInstance2;
                        }
                    } else {
                        if (!cls2.isArray() || !cls2.getComponentType().equals(cls)) {
                            if (!cls.isArray() || !cls.getComponentType().equals(cls2)) {
                                throw new IllegalArgumentException();
                            }
                            int length3 = Array.getLength(value);
                            newInstance = Array.newInstance(obj.getClass(), length3 + 1);
                            System.arraycopy(value, 0, newInstance, 0, length3);
                            Array.set(newInstance, length3, obj);
                        } else {
                            int length4 = Array.getLength(obj);
                            newInstance = Array.newInstance(value.getClass(), length4 + 1);
                            System.arraycopy(obj, 0, newInstance, 0, length4);
                            Array.set(newInstance, length4, value);
                        }
                        value = newInstance;
                    }
                    hashMap.put(str, value);
                }
            }
        }
        builder.BuiltInFictitiousFunctionClassFactory(hashMap);
        Data data = new Data(builder.MyBillsEntityDataFactory);
        Data.getAuthRequestContext(data);
        return data;
    }
}
