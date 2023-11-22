package id.dana.scanner.handler.h5pages;

import android.content.Context;
import id.dana.danah5.DanaH5;
import id.dana.model.ScanModel;
import id.dana.scanner.handler.ScannerActionHandler;
import id.dana.utils.danah5.DanaH5Listener;

/* loaded from: classes5.dex */
public abstract class BaseScannerH5PageHandler implements ScannerActionHandler {
    private final Context MyBillsEntityDataFactory;
    private final ScanModel PlaceComponentResult;
    private final DanaH5Listener getAuthRequestContext;

    protected abstract String BuiltInFictitiousFunctionClassFactory();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseScannerH5PageHandler(Context context, DanaH5Listener danaH5Listener, ScanModel scanModel) {
        this.MyBillsEntityDataFactory = context;
        this.getAuthRequestContext = danaH5Listener;
        this.PlaceComponentResult = scanModel;
    }

    @Override // id.dana.scanner.handler.ScannerActionHandler
    public final void PlaceComponentResult() {
        DanaH5.startContainerFullUrl(BuiltInFictitiousFunctionClassFactory(), this.getAuthRequestContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ScanModel getAuthRequestContext() {
        return this.PlaceComponentResult;
    }
}
