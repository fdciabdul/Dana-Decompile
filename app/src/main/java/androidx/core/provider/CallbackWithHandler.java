package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CallbackWithHandler {
    private final FontsContractCompat.FontRequestCallback KClassImpl$Data$declaredNonStaticMembers$2;
    private final Handler MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackWithHandler(FontsContractCompat.FontRequestCallback fontRequestCallback, Handler handler) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fontRequestCallback;
        this.MyBillsEntityDataFactory = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.MyBillsEntityDataFactory()) {
            final Typeface typeface = typefaceResult.PlaceComponentResult;
            final FontsContractCompat.FontRequestCallback fontRequestCallback = this.KClassImpl$Data$declaredNonStaticMembers$2;
            this.MyBillsEntityDataFactory.post(new Runnable() { // from class: androidx.core.provider.CallbackWithHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.MyBillsEntityDataFactory(typeface);
                }
            });
            return;
        }
        final int i = typefaceResult.BuiltInFictitiousFunctionClassFactory;
        final FontsContractCompat.FontRequestCallback fontRequestCallback2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        this.MyBillsEntityDataFactory.post(new Runnable() { // from class: androidx.core.provider.CallbackWithHandler.2
            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback2.BuiltInFictitiousFunctionClassFactory(i);
            }
        });
    }
}
