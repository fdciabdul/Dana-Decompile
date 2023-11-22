package fsimpl;

import android.content.res.Resources;
import android.content.res.ResourcesImpl;
import android.graphics.Bitmap;
import android.util.ArrayMap;
import android.util.LongSparseArray;
import com.fullstory.jni.FSNative;
import com.fullstory.util.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class bC {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f7869a;
    static final Map b = new WeakHashMap();
    private static final Field c;
    private static final Field d;
    private static final Field e;
    private static final Field f;
    private static final Field g;
    private static final Field h;

    static {
        Field field = null;
        if (FSNative.b) {
            c = eV.a(Resources.class, "mResourcesImpl");
            d = eV.a(ResourcesImpl.class, "mAccessLock");
            e = eV.a(ResourcesImpl.class, "mDrawableCache");
            Class a2 = eV.a("android.content.res.ThemedResourceCache");
            f = eV.a(30, a2, "mUnthemedEntries");
            g = eV.a(30, a2, "mNullThemedEntries");
            field = eV.a(a2, "mThemedEntries");
        } else {
            c = null;
            d = null;
            e = null;
            f = null;
            g = null;
        }
        h = field;
        f7869a = (c == null || d == null || e == null || f == null || g == null || field == null) ? false : true;
    }

    public static void a(Resources resources) {
        if (f7869a) {
            synchronized (b) {
                b.put(resources, null);
            }
        }
    }

    public static void a(bA bAVar) {
        if (f7869a) {
            ArrayList arrayList = null;
            synchronized (b) {
                for (Resources resources : b.keySet()) {
                    if (resources != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(resources);
                    }
                }
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    a(bAVar, (Resources) it.next());
                }
            }
        }
    }

    private static void a(bA bAVar, Resources resources) {
        Object obj;
        try {
            ResourcesImpl resourcesImpl = (ResourcesImpl) c.get(resources);
            if (resourcesImpl == null || (obj = d.get(resourcesImpl)) == null) {
                return;
            }
            synchronized (obj) {
                Object obj2 = e.get(resourcesImpl);
                if (obj2 != null) {
                    b(bAVar, resources, f.get(obj2));
                    b(bAVar, resources, g.get(obj2));
                    a(bAVar, resources, h.get(obj2));
                }
            }
        } catch (Throwable unused) {
            boolean z = Log.DISABLE_LOGGING;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(bA bAVar, Resources resources, Bitmap bitmap, long j) {
        if (bitmap != null) {
            bAVar.a(resources, bitmap, j);
        }
    }

    private static void a(bA bAVar, Resources resources, ArrayMap arrayMap) {
        Iterator it = arrayMap.values().iterator();
        while (it.hasNext()) {
            b(bAVar, resources, it.next());
        }
    }

    private static void a(bA bAVar, Resources resources, LongSparseArray longSparseArray) {
        Object obj;
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            Object valueAt = longSparseArray.valueAt(i);
            if ((valueAt instanceof WeakReference) && (obj = ((WeakReference) valueAt).get()) != null) {
                long keyAt = longSparseArray.keyAt(i);
                if (bB.a(obj)) {
                    bB.a(bAVar, resources, obj, keyAt);
                } else if (bE.a(obj)) {
                    bE.a(bAVar, resources, obj, keyAt);
                } else if (bF.a(obj)) {
                    bF.a(bAVar, resources, obj, keyAt);
                }
            }
        }
    }

    private static void a(bA bAVar, Resources resources, Object obj) {
        if (obj instanceof ArrayMap) {
            a(bAVar, resources, (ArrayMap) obj);
        }
    }

    private static void b(bA bAVar, Resources resources, Object obj) {
        if (obj instanceof LongSparseArray) {
            a(bAVar, resources, (LongSparseArray) obj);
        }
    }
}
