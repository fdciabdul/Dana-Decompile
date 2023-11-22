package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import com.appsflyer.AFLogger;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public abstract class aw<T> {
    public final FutureTask<T> AFInAppEventParameterName = new FutureTask<>(new Callable<T>() { // from class: com.appsflyer.internal.aw.2
        @Override // java.util.concurrent.Callable
        public final T call() {
            if (aw.this.values()) {
                return (T) aw.this.AFKeystoreWrapper();
            }
            return null;
        }
    });
    private final String[] AFKeystoreWrapper;
    public final String valueOf;
    public final Context values;

    protected abstract T AFKeystoreWrapper();

    public aw(Context context, String str, String... strArr) {
        this.values = context;
        this.valueOf = str;
        this.AFKeystoreWrapper = strArr;
    }

    public T AFInAppEventType() {
        try {
            return this.AFInAppEventParameterName.get(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            AFLogger.AFInAppEventType(e.getMessage(), e);
            return null;
        }
    }

    public final boolean values() {
        try {
            ProviderInfo resolveContentProvider = this.values.getPackageManager().resolveContentProvider(this.valueOf, 128);
            if (resolveContentProvider != null) {
                return Arrays.asList(this.AFKeystoreWrapper).contains(aa.values(this.values.getPackageManager(), ((PackageItemInfo) resolveContentProvider).packageName));
            }
            return false;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException | CertificateException e) {
            AFLogger.AFInAppEventType(e.getMessage(), e);
            return false;
        }
    }
}
