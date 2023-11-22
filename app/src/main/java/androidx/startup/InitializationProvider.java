package androidx.startup;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.tracing.Trace;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class InitializationProvider extends ContentProvider {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context context = getContext();
        if (context != null) {
            if (context.getApplicationContext() != null) {
                AppInitializer KClassImpl$Data$declaredNonStaticMembers$2 = AppInitializer.KClassImpl$Data$declaredNonStaticMembers$2(context);
                try {
                    try {
                        Trace.KClassImpl$Data$declaredNonStaticMembers$2("Startup");
                        Bundle bundle = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getPackageManager().getProviderInfo(new ComponentName(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getPackageName(), InitializationProvider.class.getName()), 128).metaData;
                        String string = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getString(R.string.MyBillsEntityDataFactory);
                        if (bundle != null) {
                            try {
                                HashSet hashSet = new HashSet();
                                for (String str : bundle.keySet()) {
                                    if (string.equals(bundle.getString(str, null))) {
                                        Class<?> cls = Class.forName(str);
                                        if (Initializer.class.isAssignableFrom(cls)) {
                                            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.add(cls);
                                        }
                                    }
                                }
                                Iterator<Class<? extends Initializer<?>>> it = KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.iterator();
                                while (it.hasNext()) {
                                    KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(it.next(), hashSet);
                                }
                            } catch (ClassNotFoundException e) {
                                throw new StartupException(e);
                            }
                        }
                        return true;
                    } catch (PackageManager.NameNotFoundException e2) {
                        throw new StartupException(e2);
                    }
                } finally {
                    Trace.MyBillsEntityDataFactory();
                }
            }
            return true;
        }
        throw new StartupException("Context cannot be null");
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }
}
