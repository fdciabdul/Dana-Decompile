package id.dana.animation;

import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import java.util.List;

/* loaded from: classes9.dex */
public final /* synthetic */ class ScanQrLoyaltyActivity$$ExternalSyntheticLambda2 implements BarcodeCallback {
    public final /* synthetic */ ScanQrLoyaltyActivity KClassImpl$Data$declaredNonStaticMembers$2;

    public /* synthetic */ ScanQrLoyaltyActivity$$ExternalSyntheticLambda2(ScanQrLoyaltyActivity scanQrLoyaltyActivity) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = scanQrLoyaltyActivity;
    }

    @Override // com.journeyapps.barcodescanner.BarcodeCallback
    public final void getAuthRequestContext(BarcodeResult barcodeResult) {
        ScanQrLoyaltyActivity.m2662$r8$lambda$FdXIWf2z_oskfI9DM_Wccnhd5c(this.KClassImpl$Data$declaredNonStaticMembers$2, barcodeResult);
    }

    @Override // com.journeyapps.barcodescanner.BarcodeCallback
    public final /* synthetic */ void getAuthRequestContext(List list) {
        BarcodeCallback.CC.PlaceComponentResult();
    }
}
