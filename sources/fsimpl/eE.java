package fsimpl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes4.dex */
class eE {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(fi fiVar, Object obj) {
        eB a2;
        int length = Array.getLength(obj);
        if (length == 0 || (a2 = eB.a(obj.getClass().getComponentType())) == eB.Unhandled) {
            return 0;
        }
        eJ eJVar = new eJ(length);
        for (int i = 0; i < length; i++) {
            int a3 = eF.a(fiVar, a2, Array.get(obj, i));
            if (a3 != 0) {
                eJVar.a(a3);
            }
        }
        if (eJVar.b() <= 0) {
            return 0;
        }
        return a(fiVar, eJVar.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(fi fiVar, Collection collection) {
        eB b;
        int size = collection.size();
        if (size == 0 || (b = b(collection)) == null || b == eB.Unhandled) {
            return 0;
        }
        eJ eJVar = new eJ(size);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            int a2 = eF.a(fiVar, b, it.next());
            if (a2 != 0) {
                eJVar.a(a2);
            }
        }
        if (eJVar.b() <= 0) {
            return 0;
        }
        return a(fiVar, eJVar.c());
    }

    private static int a(fi fiVar, int[] iArr) {
        return C0285ci.a(fiVar, (byte) 2, C0286cj.a(fiVar, C0286cj.a(fiVar, iArr)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collection a(Object obj) {
        int length = Array.getLength(obj);
        eB a2 = eB.a(obj.getClass().getComponentType());
        if (length == 0 || a2 == eB.Unhandled) {
            return null;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Object a3 = eF.a(a2, Array.get(obj, i));
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collection a(Collection collection) {
        eB b;
        ArrayList arrayList = null;
        if (collection != null && !collection.isEmpty() && (b = b(collection)) != null && b != eB.Unhandled) {
            arrayList = new ArrayList(collection.size());
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Object a2 = eF.a(b, it.next());
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    private static eB b(Collection collection) {
        boolean z = false;
        Class cls = null;
        for (Object obj : collection) {
            if (obj != null) {
                Class<?> cls2 = obj.getClass();
                if (cls == null) {
                    z = CharSequence.class.isAssignableFrom(cls2);
                    cls = cls2;
                } else if (!cls.isAssignableFrom(cls2)) {
                    do {
                        cls = cls.getSuperclass();
                    } while (!cls.isAssignableFrom(cls2));
                    if (z) {
                        z = CharSequence.class.isAssignableFrom(cls2);
                    }
                }
            }
        }
        if (cls == null) {
            return null;
        }
        return z ? eB.CharSequence : eB.a(cls);
    }
}
