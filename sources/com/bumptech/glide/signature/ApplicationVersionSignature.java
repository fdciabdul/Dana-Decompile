package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bumptech.glide.load.Key;
import com.fullstory.instrumentation.InstrumentInjector;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
public final class ApplicationVersionSignature {
    private static final ConcurrentMap<String, Key> KClassImpl$Data$declaredNonStaticMembers$2 = new ConcurrentHashMap();

    public static Key getAuthRequestContext(Context context) {
        String obj;
        String packageName = context.getPackageName();
        ConcurrentMap<String, Key> concurrentMap = KClassImpl$Data$declaredNonStaticMembers$2;
        Key key = concurrentMap.get(packageName);
        if (key == null) {
            PackageInfo BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(context);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                obj = String.valueOf(BuiltInFictitiousFunctionClassFactory.versionCode);
            } else {
                obj = UUID.randomUUID().toString();
            }
            ObjectKey objectKey = new ObjectKey(obj);
            Key putIfAbsent = concurrentMap.putIfAbsent(packageName, objectKey);
            return putIfAbsent != null ? putIfAbsent : objectKey;
        }
        return key;
    }

    private static PackageInfo BuiltInFictitiousFunctionClassFactory(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot resolve info for");
            sb.append(context.getPackageName());
            InstrumentInjector.log_e("AppVersionSignature", sb.toString(), e);
            return null;
        }
    }

    private ApplicationVersionSignature() {
    }
}
