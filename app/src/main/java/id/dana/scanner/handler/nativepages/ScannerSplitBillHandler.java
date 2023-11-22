package id.dana.scanner.handler.nativepages;

import android.content.Context;
import id.dana.model.ScanModel;
import id.dana.splitbill.mapper.SplitBillModelMapper;
import id.dana.splitbill.view.SplitBillDetailsActivity;

/* loaded from: classes5.dex */
public class ScannerSplitBillHandler extends BaseScannerNativePageHandler {
    public ScannerSplitBillHandler(Context context, ScanModel scanModel, String str) {
        super(context, scanModel, str);
    }

    @Override // id.dana.scanner.handler.ScannerActionHandler
    public final void PlaceComponentResult() {
        KClassImpl$Data$declaredNonStaticMembers$2().startActivity(SplitBillDetailsActivity.createIntent(KClassImpl$Data$declaredNonStaticMembers$2(), new SplitBillModelMapper().apply(getAuthRequestContext()), "Scan QR"));
    }
}
