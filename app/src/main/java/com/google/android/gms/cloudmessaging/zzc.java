package com.google.android.gms.cloudmessaging;

import android.os.Build;
import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes7.dex */
public final class zzc extends ClassLoader {
    @Override // java.lang.ClassLoader
    protected final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if ("com.google.android.gms.iid.MessengerCompat".equals(str)) {
            if (Log.isLoggable("CloudMessengerCompat", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("CloudMessengerCompat", 3))) {
                InstrumentInjector.log_d("CloudMessengerCompat", "Using renamed FirebaseIidMessengerCompat class");
                return zzd.class;
            }
            return zzd.class;
        }
        return super.loadClass(str, z);
    }
}
