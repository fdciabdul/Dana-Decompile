package fsimpl;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.fullstory.jni.FSNative;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class bA {
    private static final Object d = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final bG f7867a;
    private final WeakHashMap b = new WeakHashMap();
    private final Map c = new WeakHashMap();

    public bA(bG bGVar) {
        this.f7867a = bGVar;
    }

    private Integer a(Bitmap bitmap, Integer num) {
        Integer num2;
        synchronized (this) {
            num2 = (Integer) this.b.put(bitmap, num);
        }
        return num2;
    }

    private Integer a(String str) {
        Integer num;
        if (str == null || (num = (Integer) this.f7867a.y().get(str)) == null) {
            return -1;
        }
        return num;
    }

    private Integer b(Bitmap bitmap) {
        return a(C0331eb.identify(bitmap));
    }

    private Integer b(Bitmap bitmap, boolean[] zArr) {
        int b;
        Integer c = c(bitmap);
        if (c != null) {
            return c;
        }
        if (FSNative.b) {
            if (zArr != null && !zArr[0]) {
                zArr[0] = true;
                bC.a(this);
                Integer c2 = c(bitmap);
                if (c2 != null) {
                    return c2;
                }
            }
            b = -1;
        } else {
            b = b(bitmap);
        }
        a(bitmap, b);
        return b;
    }

    private Integer c(Bitmap bitmap) {
        Integer num;
        synchronized (this) {
            num = (Integer) this.b.get(bitmap);
        }
        return num;
    }

    private boolean d(Bitmap bitmap) {
        boolean z;
        synchronized (this) {
            z = this.c.put(bitmap, d) != d;
        }
        return z;
    }

    public String a(Bitmap bitmap) {
        C0350eu.b("The identifyAssetSha check should NEVER be on the UI thread", new Object[0]);
        Integer b = b(bitmap, null);
        if (b.intValue() == -1 || b.intValue() == -2) {
            return null;
        }
        return (String) this.f7867a.z().get(b);
    }

    public void a(Resources resources, Bitmap bitmap, long j) {
        C0350eu.a("The markAsAsset call should always be on the UI thread", new Object[0]);
        if (d(bitmap)) {
            Integer a2 = a(bD.a(resources.getAssets(), j));
            if (a2.intValue() == -1) {
                a2 = -2;
            }
            a(bitmap, a2);
        }
    }

    public boolean a(Bitmap bitmap, boolean[] zArr) {
        C0350eu.a("The isAsset check should always be on the UI thread", new Object[0]);
        return b(bitmap, zArr).intValue() != -1;
    }
}
