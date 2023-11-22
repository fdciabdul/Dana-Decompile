package id.dana.scanner.handler.nativepages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import id.dana.model.ScanModel;
import id.dana.scanner.handler.ScannerActionHandler;
import id.dana.scanner.handler.ScannerViewType;

/* loaded from: classes5.dex */
public abstract class BaseScannerNativePageHandler implements ScannerActionHandler {
    private final String BuiltInFictitiousFunctionClassFactory;
    private final ScanModel PlaceComponentResult;
    private final Context getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseScannerNativePageHandler(Context context, ScanModel scanModel, String str) {
        this.getAuthRequestContext = context;
        this.PlaceComponentResult = scanModel;
        this.BuiltInFictitiousFunctionClassFactory = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void KClassImpl$Data$declaredNonStaticMembers$2(Intent intent) {
        Activity activity = (Activity) this.getAuthRequestContext;
        String str = this.BuiltInFictitiousFunctionClassFactory;
        str.hashCode();
        if (str.equals(ScannerViewType.ACTIVITY)) {
            activity.setResult(-1, intent);
            activity.finish();
        } else if (str.equals(ScannerViewType.FRAGMENT)) {
            activity.startActivity(intent);
        }
    }

    public final Context KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ScanModel getAuthRequestContext() {
        return this.PlaceComponentResult;
    }
}
