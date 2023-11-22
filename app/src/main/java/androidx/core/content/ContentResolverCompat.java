package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.OperationCanceledException;
import androidx.core.os.CancellationSignal;

/* loaded from: classes3.dex */
public final class ContentResolverCompat {
    private ContentResolverCompat() {
    }

    public static Cursor BuiltInFictitiousFunctionClassFactory(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        Object KClassImpl$Data$declaredNonStaticMembers$2;
        if (Build.VERSION.SDK_INT >= 16) {
            if (cancellationSignal != null) {
                try {
                    KClassImpl$Data$declaredNonStaticMembers$2 = cancellationSignal.KClassImpl$Data$declaredNonStaticMembers$2();
                } catch (Exception e) {
                    if (e instanceof OperationCanceledException) {
                        throw new androidx.core.os.OperationCanceledException();
                    }
                    throw e;
                }
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }
            return Api16Impl.BuiltInFictitiousFunctionClassFactory(contentResolver, uri, strArr, str, strArr2, str2, (android.os.CancellationSignal) KClassImpl$Data$declaredNonStaticMembers$2);
        } else if (cancellationSignal == null || !cancellationSignal.MyBillsEntityDataFactory()) {
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        } else {
            throw new androidx.core.os.OperationCanceledException();
        }
    }

    /* loaded from: classes3.dex */
    static class Api16Impl {
        private Api16Impl() {
        }

        static Cursor BuiltInFictitiousFunctionClassFactory(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, android.os.CancellationSignal cancellationSignal) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
        }
    }
}
