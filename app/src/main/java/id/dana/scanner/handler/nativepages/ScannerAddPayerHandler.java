package id.dana.scanner.handler.nativepages;

import android.content.Context;
import id.dana.model.ScanModel;
import id.dana.requestmoney.splitbill.mapper.SplitBillScanToRecipientModelMapper;
import id.dana.splitbill.view.SplitBillActivity;

/* loaded from: classes5.dex */
public class ScannerAddPayerHandler extends BaseScannerNativePageHandler {
    public ScannerAddPayerHandler(Context context, ScanModel scanModel, String str) {
        super(context, scanModel, str);
    }

    @Override // id.dana.scanner.handler.ScannerActionHandler
    public final void PlaceComponentResult() {
        new SplitBillScanToRecipientModelMapper();
        KClassImpl$Data$declaredNonStaticMembers$2(SplitBillActivity.createSplitBillIntent(KClassImpl$Data$declaredNonStaticMembers$2(), SplitBillScanToRecipientModelMapper.PlaceComponentResult(getAuthRequestContext(), "contact"), "Scan QR"));
    }
}
