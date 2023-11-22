package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;

/* loaded from: classes.dex */
public class DataCollectionConfigStorage {
    public static final String DATA_COLLECTION_DEFAULT_ENABLED = "firebase_data_collection_default_enabled";
    private static final String FIREBASE_APP_PREFS = "com.google.firebase.common.prefs:";
    private boolean dataCollectionDefaultEnabled;
    private final Context deviceProtectedContext;
    private final Publisher publisher;
    private final SharedPreferences sharedPreferences;

    public DataCollectionConfigStorage(Context context, String str, Publisher publisher) {
        Context directBootSafe = directBootSafe(context);
        this.deviceProtectedContext = directBootSafe;
        StringBuilder sb = new StringBuilder();
        sb.append(FIREBASE_APP_PREFS);
        sb.append(str);
        this.sharedPreferences = directBootSafe.getSharedPreferences(sb.toString(), 0);
        this.publisher = publisher;
        this.dataCollectionDefaultEnabled = readAutoDataCollectionEnabled();
    }

    private static Context directBootSafe(Context context) {
        return Build.VERSION.SDK_INT < 24 ? context : ContextCompat.BuiltInFictitiousFunctionClassFactory(context);
    }

    public boolean isEnabled() {
        boolean z;
        synchronized (this) {
            z = this.dataCollectionDefaultEnabled;
        }
        return z;
    }

    private void updateDataCollectionDefaultEnabled(boolean z) {
        synchronized (this) {
            if (this.dataCollectionDefaultEnabled != z) {
                this.dataCollectionDefaultEnabled = z;
                this.publisher.publish(new Event<>(DataCollectionDefaultChange.class, new DataCollectionDefaultChange(z)));
            }
        }
    }

    public void setEnabled(Boolean bool) {
        synchronized (this) {
            if (bool == null) {
                this.sharedPreferences.edit().remove(DATA_COLLECTION_DEFAULT_ENABLED).apply();
                updateDataCollectionDefaultEnabled(readManifestDataCollectionEnabled());
            } else {
                boolean equals = Boolean.TRUE.equals(bool);
                this.sharedPreferences.edit().putBoolean(DATA_COLLECTION_DEFAULT_ENABLED, equals).apply();
                updateDataCollectionDefaultEnabled(equals);
            }
        }
    }

    private boolean readManifestDataCollectionEnabled() {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = this.deviceProtectedContext.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.deviceProtectedContext.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(DATA_COLLECTION_DEFAULT_ENABLED)) {
                return true;
            }
            return applicationInfo.metaData.getBoolean(DATA_COLLECTION_DEFAULT_ENABLED);
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    private boolean readAutoDataCollectionEnabled() {
        if (this.sharedPreferences.contains(DATA_COLLECTION_DEFAULT_ENABLED)) {
            return this.sharedPreferences.getBoolean(DATA_COLLECTION_DEFAULT_ENABLED, true);
        }
        return readManifestDataCollectionEnabled();
    }
}
