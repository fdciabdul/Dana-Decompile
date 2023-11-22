package com.bumptech.glide.util;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.model.Model;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* loaded from: classes3.dex */
public final class Util {
    private static volatile Handler BuiltInFictitiousFunctionClassFactory;
    private static final char[] KClassImpl$Data$declaredNonStaticMembers$2 = "0123456789abcdef".toCharArray();
    private static final char[] getAuthRequestContext = new char[64];

    public static int MyBillsEntityDataFactory(int i) {
        return i + 527;
    }

    public static int PlaceComponentResult(boolean z, int i) {
        return (i * 31) + (z ? 1 : 0);
    }

    public static int getAuthRequestContext(int i, int i2) {
        return (i2 * 31) + i;
    }

    private static boolean getAuthRequestContext(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    private Util() {
    }

    public static String PlaceComponentResult(byte[] bArr) {
        String str;
        char[] cArr = getAuthRequestContext;
        synchronized (cArr) {
            for (int i = 0; i < bArr.length; i++) {
                int i2 = bArr[i] & 255;
                int i3 = i * 2;
                char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
                cArr[i3] = cArr2[i2 >>> 4];
                cArr[i3 + 1] = cArr2[i2 & 15];
            }
            str = new String(cArr);
        }
        return str;
    }

    public static int getAuthRequestContext(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot obtain size for recycled Bitmap: ");
            sb.append(bitmap);
            sb.append("[");
            sb.append(bitmap.getWidth());
            sb.append("x");
            sb.append(bitmap.getHeight());
            sb.append("] ");
            sb.append(bitmap.getConfig());
            throw new IllegalStateException(sb.toString());
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    /* renamed from: com.bumptech.glide.util.Util$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        return getAuthRequestContext(i) && getAuthRequestContext(i2);
    }

    public static void BuiltInFictitiousFunctionClassFactory(Runnable runnable) {
        KClassImpl$Data$declaredNonStaticMembers$2().post(runnable);
    }

    private static Handler KClassImpl$Data$declaredNonStaticMembers$2() {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            synchronized (Util.class) {
                if (BuiltInFictitiousFunctionClassFactory == null) {
                    BuiltInFictitiousFunctionClassFactory = new Handler(Looper.getMainLooper());
                }
            }
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static void BuiltInFictitiousFunctionClassFactory() {
        if (!MyBillsEntityDataFactory()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static void getAuthRequestContext() {
        if (!PlaceComponentResult()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static boolean MyBillsEntityDataFactory() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean PlaceComponentResult() {
        return !MyBillsEntityDataFactory();
    }

    public static <T> Queue<T> BuiltInFictitiousFunctionClassFactory(int i) {
        return new ArrayDeque(i);
    }

    public static <T> List<T> KClassImpl$Data$declaredNonStaticMembers$2(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean MyBillsEntityDataFactory(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else if (obj instanceof Model) {
            return ((Model) obj).PlaceComponentResult();
        } else {
            return obj.equals(obj2);
        }
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(float f, int i) {
        return (i * 31) + Float.floatToIntBits(f);
    }

    public static int PlaceComponentResult(Object obj, int i) {
        return (i * 31) + (obj == null ? 0 : obj.hashCode());
    }

    public static int MyBillsEntityDataFactory(int i, int i2, Bitmap.Config config) {
        int i3 = i * i2;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i4 = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[config.ordinal()];
        int i5 = 2;
        if (i4 == 1) {
            i5 = 1;
        } else if (i4 != 2 && i4 != 3) {
            i5 = i4 == 4 ? 8 : 4;
        }
        return i3 * i5;
    }

    public static int BuiltInFictitiousFunctionClassFactory(float f) {
        return Float.floatToIntBits(f) + 527;
    }
}
