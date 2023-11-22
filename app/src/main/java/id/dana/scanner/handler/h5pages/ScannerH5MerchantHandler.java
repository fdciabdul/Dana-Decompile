package id.dana.scanner.handler.h5pages;

import android.content.Context;
import id.dana.model.ScanModel;
import id.dana.utils.danah5.DanaH5Listener;

/* loaded from: classes5.dex */
public class ScannerH5MerchantHandler extends BaseScannerH5PageHandler {
    public ScannerH5MerchantHandler(Context context, DanaH5Listener danaH5Listener, ScanModel scanModel) {
        super(context, danaH5Listener, scanModel);
    }

    @Override // id.dana.scanner.handler.h5pages.BaseScannerH5PageHandler
    protected final String BuiltInFictitiousFunctionClassFactory() {
        return getAuthRequestContext().getBizInfo().isLayoutRequested;
    }
}
