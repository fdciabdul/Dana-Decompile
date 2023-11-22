package id.dana.scanner.handler.nativepages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import id.dana.cashier.model.featureTime.FeatureTimeModel;
import id.dana.model.ScanModel;
import id.dana.pay.PayActivity;
import id.dana.scanner.handler.ScannerViewType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0006\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\n\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010"}, d2 = {"Lid/dana/scanner/handler/nativepages/ScannerCashierHandler;", "Lid/dana/scanner/handler/nativepages/BaseScannerNativePageHandler;", "", "PlaceComponentResult", "()V", "Landroid/content/Intent;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Intent;)V", "Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "", "MyBillsEntityDataFactory", "Z", "", "Ljava/lang/String;", "getAuthRequestContext", "Landroid/content/Context;", "Lid/dana/model/ScanModel;", "p1", "p2", "p3", "p4", "<init>", "(Landroid/content/Context;Lid/dana/model/ScanModel;Ljava/lang/String;ZLid/dana/cashier/model/featureTime/FeatureTimeModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScannerCashierHandler extends BaseScannerNativePageHandler {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FeatureTimeModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final boolean BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScannerCashierHandler(Context context, ScanModel scanModel, String str, boolean z, FeatureTimeModel featureTimeModel) {
        super(context, scanModel, str);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(scanModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.getAuthRequestContext = str;
        this.BuiltInFictitiousFunctionClassFactory = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = featureTimeModel;
    }

    @Override // id.dana.scanner.handler.ScannerActionHandler
    public final void PlaceComponentResult() {
        PayActivity.Companion companion = PayActivity.INSTANCE;
        if (PayActivity.Companion.MyBillsEntityDataFactory()) {
            return;
        }
        PayActivity.Companion companion2 = PayActivity.INSTANCE;
        Context KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        String source = getAuthRequestContext().getSource();
        String redirectUrl = getAuthRequestContext().getRedirectUrl();
        if (redirectUrl == null) {
            redirectUrl = "";
        }
        String str = redirectUrl;
        boolean z = this.BuiltInFictitiousFunctionClassFactory;
        HashMap<String, String> nativelyDecodedQr = getAuthRequestContext().getNativelyDecodedQr();
        String requestId = getAuthRequestContext().getRequestId();
        String qrCode = getAuthRequestContext().getQrCode();
        boolean isPrecreateOrder = getAuthRequestContext().isPrecreateOrder();
        KClassImpl$Data$declaredNonStaticMembers$2(PayActivity.Companion.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, source, true, str, z, nativelyDecodedQr, requestId, qrCode, Boolean.valueOf(isPrecreateOrder), false, null, null, 0L, this.KClassImpl$Data$declaredNonStaticMembers$2, 7680));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.scanner.handler.nativepages.BaseScannerNativePageHandler
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Intent p0) {
        String str;
        String str2;
        Context KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
        Activity activity = (Activity) KClassImpl$Data$declaredNonStaticMembers$2;
        String str3 = this.getAuthRequestContext;
        if (Intrinsics.areEqual(str3, ScannerViewType.ACTIVITY)) {
            activity.startActivity(p0);
            activity.finish();
        } else if (Intrinsics.areEqual(str3, ScannerViewType.FRAGMENT)) {
            if (activity instanceof PayActivity) {
                if (getAuthRequestContext().getNativelyDecodedQr() != null) {
                    HashMap<String, String> nativelyDecodedQr = getAuthRequestContext().getNativelyDecodedQr();
                    Intrinsics.checkNotNullExpressionValue(nativelyDecodedQr, "");
                    ((PayActivity) activity).processNativelyDecodedQr(nativelyDecodedQr, getAuthRequestContext().getRequestId(), getAuthRequestContext().getQrCode(), Boolean.valueOf(getAuthRequestContext().isPrecreateOrder()));
                } else {
                    String redirectUrl = getAuthRequestContext().getRedirectUrl();
                    if (redirectUrl == null || redirectUrl.length() == 0) {
                        str = getAuthRequestContext().getBizInfo().isLayoutRequested;
                        if (str == null) {
                            str2 = "";
                            Intrinsics.checkNotNullExpressionValue(str2, "");
                            PayActivity.processCashierUrl$default((PayActivity) activity, str2, null, null, false, null, null, 62, null);
                        }
                    } else {
                        str = getAuthRequestContext().getRedirectUrl();
                    }
                    str2 = str;
                    Intrinsics.checkNotNullExpressionValue(str2, "");
                    PayActivity.processCashierUrl$default((PayActivity) activity, str2, null, null, false, null, null, 62, null);
                }
                PayActivity payActivity = (PayActivity) activity;
                payActivity.setFeatureTimeModel(this.KClassImpl$Data$declaredNonStaticMembers$2);
                payActivity.setCustomKeyboardEnable(this.BuiltInFictitiousFunctionClassFactory);
                return;
            }
            activity.startActivity(p0);
        }
    }
}
