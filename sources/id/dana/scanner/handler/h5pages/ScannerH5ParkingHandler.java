package id.dana.scanner.handler.h5pages;

import android.content.Context;
import id.dana.data.constant.DanaUrl;
import id.dana.model.BizInfoModel;
import id.dana.model.ScanModel;
import id.dana.utils.TagFormat;
import id.dana.utils.danah5.DanaH5Listener;

/* loaded from: classes5.dex */
public class ScannerH5ParkingHandler extends BaseScannerH5PageHandler {
    public ScannerH5ParkingHandler(Context context, DanaH5Listener danaH5Listener, ScanModel scanModel) {
        super(context, danaH5Listener, scanModel);
    }

    @Override // id.dana.scanner.handler.h5pages.BaseScannerH5PageHandler
    protected final String BuiltInFictitiousFunctionClassFactory() {
        BizInfoModel bizInfo = getAuthRequestContext().getBizInfo();
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(TagFormat.MyBillsEntityDataFactory(DanaUrl.PARKING_CONFIRMATION).MyBillsEntityDataFactory("qrCode", bizInfo.NetworkUserEntityData$$ExternalSyntheticLambda6).MyBillsEntityDataFactory());
        return sb.toString();
    }
}
