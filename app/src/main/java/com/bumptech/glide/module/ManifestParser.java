package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public final class ManifestParser {
    private final Context BuiltInFictitiousFunctionClassFactory;

    public ManifestParser(Context context) {
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    public final List<GlideModule> MyBillsEntityDataFactory() {
        if (Log.isLoggable("ManifestParser", 3)) {
            InstrumentInjector.log_d("ManifestParser", "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.BuiltInFictitiousFunctionClassFactory.getPackageManager().getApplicationInfo(this.BuiltInFictitiousFunctionClassFactory.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                if (Log.isLoggable("ManifestParser", 3)) {
                    InstrumentInjector.log_d("ManifestParser", "Got null app info metadata");
                }
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Got app info metadata: ");
                sb.append(applicationInfo.metaData);
                InstrumentInjector.log_v("ManifestParser", sb.toString());
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(BuiltInFictitiousFunctionClassFactory(str));
                    if (Log.isLoggable("ManifestParser", 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Loaded Glide module: ");
                        sb2.append(str);
                        InstrumentInjector.log_d("ManifestParser", sb2.toString());
                    }
                }
            }
            if (Log.isLoggable("ManifestParser", 3)) {
                InstrumentInjector.log_d("ManifestParser", "Finished loading Glide modules");
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }

    private static GlideModule BuiltInFictitiousFunctionClassFactory(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object obj = null;
            try {
                obj = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                KClassImpl$Data$declaredNonStaticMembers$2(cls, e);
            } catch (InstantiationException e2) {
                KClassImpl$Data$declaredNonStaticMembers$2(cls, e2);
            } catch (NoSuchMethodException e3) {
                KClassImpl$Data$declaredNonStaticMembers$2(cls, e3);
            } catch (InvocationTargetException e4) {
                KClassImpl$Data$declaredNonStaticMembers$2(cls, e4);
            }
            if (!(obj instanceof GlideModule)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected instanceof GlideModule, but found: ");
                sb.append(obj);
                throw new RuntimeException(sb.toString());
            }
            return (GlideModule) obj;
        } catch (ClassNotFoundException e5) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(Class<?> cls, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to instantiate GlideModule implementation for ");
        sb.append(cls);
        throw new RuntimeException(sb.toString(), exc);
    }
}
