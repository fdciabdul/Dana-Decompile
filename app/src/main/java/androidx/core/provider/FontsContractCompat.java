package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class FontsContractCompat {

    /* loaded from: classes.dex */
    public static final class Columns implements BaseColumns {
    }

    /* loaded from: classes.dex */
    public static class FontRequestCallback {

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface FontRequestFailReason {
        }

        public void BuiltInFictitiousFunctionClassFactory(int i) {
        }

        public void MyBillsEntityDataFactory(Typeface typeface) {
        }
    }

    private FontsContractCompat() {
    }

    public static Typeface MyBillsEntityDataFactory(Context context, CancellationSignal cancellationSignal, FontInfo[] fontInfoArr) {
        return TypefaceCompat.MyBillsEntityDataFactory(context, cancellationSignal, fontInfoArr, 0);
    }

    public static FontFamilyResult PlaceComponentResult(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
        return FontProvider.BuiltInFictitiousFunctionClassFactory(context, fontRequest, cancellationSignal);
    }

    public static Typeface MyBillsEntityDataFactory(Context context, FontRequest fontRequest, int i, boolean z, int i2, Handler handler, FontRequestCallback fontRequestCallback) {
        CallbackWithHandler callbackWithHandler = new CallbackWithHandler(fontRequestCallback, handler);
        if (z) {
            return FontRequestWorker.MyBillsEntityDataFactory(context, fontRequest, callbackWithHandler, i, i2);
        }
        return FontRequestWorker.KClassImpl$Data$declaredNonStaticMembers$2(context, fontRequest, i, callbackWithHandler);
    }

    /* loaded from: classes.dex */
    public static class FontInfo {
        private final int BuiltInFictitiousFunctionClassFactory;
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private final int MyBillsEntityDataFactory;
        private final int PlaceComponentResult;
        private final Uri getAuthRequestContext;

        @Deprecated
        public FontInfo(Uri uri, int i, int i2, boolean z, int i3) {
            this.getAuthRequestContext = (Uri) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(uri);
            this.PlaceComponentResult = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            this.MyBillsEntityDataFactory = i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static FontInfo KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, int i, int i2, boolean z, int i3) {
            return new FontInfo(uri, i, i2, z, i3);
        }

        public Uri PlaceComponentResult() {
            return this.getAuthRequestContext;
        }

        public int BuiltInFictitiousFunctionClassFactory() {
            return this.PlaceComponentResult;
        }

        public int getAuthRequestContext() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        public boolean MyBillsEntityDataFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public int KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.MyBillsEntityDataFactory;
        }
    }

    /* loaded from: classes.dex */
    public static class FontFamilyResult {
        private final int BuiltInFictitiousFunctionClassFactory;
        private final FontInfo[] KClassImpl$Data$declaredNonStaticMembers$2;

        @Deprecated
        public FontFamilyResult(int i, FontInfo[] fontInfoArr) {
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = fontInfoArr;
        }

        public int BuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        public FontInfo[] getAuthRequestContext() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static FontFamilyResult getAuthRequestContext(int i, FontInfo[] fontInfoArr) {
            return new FontFamilyResult(i, fontInfoArr);
        }
    }
}
