package com.fullstory.jni;

import android.os.Build;
import com.fullstory.util.Log;
import fsimpl.dW;
import fsimpl.dX;
import fsimpl.dY;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class FSNative {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7429a;
    public static final boolean b;
    private static final dW c;
    private static dY d;

    static {
        dX dXVar;
        boolean z = Build.VERSION.SDK_INT < 30;
        f7429a = z;
        b = !z;
        if (z) {
            try {
                dXVar = new dX();
            } catch (Throwable th) {
                Log.e("Unable to initialize Java hooks", th);
            }
            c = dXVar;
            d = null;
        }
        dXVar = null;
        c = dXVar;
        d = null;
    }

    public static int a(FSNativeHooks fSNativeHooks) {
        if (f7429a) {
            if (d == null) {
                dW dWVar = c;
                if (dWVar == null) {
                    return -5;
                }
                if (dWVar.a()) {
                    return -6;
                }
                Method[] methodArr = c.f7928a;
                Method[] methodArr2 = c.b;
                Class[] clsArr = c.c;
                dY dYVar = new dY();
                d = dYVar;
                dYVar.f7929a = jni_fs_native_hook_init(dYVar, methodArr, methodArr2, clsArr, !Log.DISABLE_LOGGING);
            }
            d.a(fSNativeHooks);
            if (fSNativeHooks == null) {
                return -1;
            }
            return d.f7929a;
        }
        return jni_fs_standard_init(!Log.DISABLE_LOGGING);
    }

    public static Field a(Class cls, String str) {
        if (cls == null || str == null) {
            return null;
        }
        return jni_fs_get_declared_field(cls, str);
    }

    public static Method a(Class cls, String str, Class... clsArr) {
        if (cls == null || str == null) {
            return null;
        }
        return jni_fs_get_declared_method(cls, str, clsArr);
    }

    public static boolean a() {
        try {
            System.loadLibrary("k9b44");
            return true;
        } catch (Throwable th) {
            Log.e("Exception trying to load fs-native", th);
            return false;
        }
    }

    private static native Field jni_fs_get_declared_field(Class cls, String str);

    private static native Method jni_fs_get_declared_method(Class cls, String str, Class[] clsArr);

    private static native int jni_fs_native_hook_init(Object obj, Object obj2, Object obj3, Object obj4, boolean z);

    private static native int jni_fs_standard_init(boolean z);

    private native int stub0();

    private native int stub1();

    private native int stub2();
}
