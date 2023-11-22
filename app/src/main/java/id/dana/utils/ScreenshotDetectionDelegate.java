package id.dana.utils;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import java.lang.ref.WeakReference;

/* loaded from: classes9.dex */
public class ScreenshotDetectionDelegate {
    private WeakReference<Activity> KClassImpl$Data$declaredNonStaticMembers$2;

    /* loaded from: classes9.dex */
    public interface ScreenshotDetectionListener {
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
    }

    static /* synthetic */ void getAuthRequestContext() {
    }

    /* renamed from: id.dana.utils.ScreenshotDetectionDelegate$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass1 extends ContentObserver {
        final /* synthetic */ ScreenshotDetectionDelegate MyBillsEntityDataFactory;

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return super.deliverSelfNotifications();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            if (this.MyBillsEntityDataFactory.MyBillsEntityDataFactory()) {
                ScreenshotDetectionDelegate.KClassImpl$Data$declaredNonStaticMembers$2((Context) this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.get(), uri);
                ScreenshotDetectionDelegate.getAuthRequestContext();
                return;
            }
            ScreenshotDetectionDelegate.BuiltInFictitiousFunctionClassFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String KClassImpl$Data$declaredNonStaticMembers$2(Context context, Uri uri) {
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_display_name", "_data"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndex("_data"));
                        if (query != null) {
                            query.close();
                        }
                        return string;
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
                return null;
            }
            return null;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MyBillsEntityDataFactory() {
        return ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }
}
