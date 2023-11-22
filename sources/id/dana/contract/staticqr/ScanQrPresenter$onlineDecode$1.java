package id.dana.contract.staticqr;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import dagger.Lazy;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.domain.qrbarcode.DecodedScan;
import id.dana.domain.qrbarcode.interactor.GetDecodedQrBarcode;
import id.dana.model.ScanModel;
import id.dana.requestmoney.RequestMoneyTrackingHelperKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ScanQrPresenter$onlineDecode$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $$isFromScanQRBridge;
    final /* synthetic */ boolean $$isNeedCheckScanSelf;
    final /* synthetic */ String $$scanResultStr;
    final /* synthetic */ String $$scene;
    final /* synthetic */ String $$source;
    final /* synthetic */ ScanQrPresenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScanQrPresenter$onlineDecode$1(ScanQrPresenter scanQrPresenter, String str, String str2, boolean z, boolean z2, String str3) {
        super(0);
        this.this$0 = scanQrPresenter;
        this.$$scanResultStr = str;
        this.$$scene = str2;
        this.$$isNeedCheckScanSelf = z;
        this.$$isFromScanQRBridge = z2;
        this.$$source = str3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Lazy lazy;
        lazy = this.this$0.getErrorConfigVersion;
        GetDecodedQrBarcode getDecodedQrBarcode = (GetDecodedQrBarcode) lazy.get();
        GetDecodedQrBarcode.Params.Companion companion = GetDecodedQrBarcode.Params.INSTANCE;
        String KClassImpl$Data$declaredNonStaticMembers$2 = RequestMoneyTrackingHelperKt.KClassImpl$Data$declaredNonStaticMembers$2(this.$$scanResultStr, "request_money");
        String str = this.$$scene;
        if (str == null) {
            str = "";
        }
        GetDecodedQrBarcode.Params forDecodeQrBarcode = companion.forDecodeQrBarcode(KClassImpl$Data$declaredNonStaticMembers$2, str, this.$$isNeedCheckScanSelf);
        final ScanQrPresenter scanQrPresenter = this.this$0;
        final boolean z = this.$$isFromScanQRBridge;
        final String str2 = this.$$scanResultStr;
        final String str3 = this.$$source;
        Function1<DecodedScan, Unit> function1 = new Function1<DecodedScan, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$onlineDecode$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DecodedScan decodedScan) {
                invoke2(decodedScan);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DecodedScan decodedScan) {
                Lazy lazy2;
                Lazy lazy3;
                Lazy lazy4;
                Lazy lazy5;
                ScanModel PlaceComponentResult;
                Lazy lazy6;
                Intrinsics.checkNotNullParameter(decodedScan, "");
                lazy2 = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                ((ScanQrContract.View) lazy2.get()).moveToNextValue();
                lazy3 = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                ((ScanQrContract.View) lazy3.get()).PlaceComponentResult(false);
                if (decodedScan.isSuccess()) {
                    if (z) {
                        lazy6 = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                        ((ScanQrContract.View) lazy6.get()).BuiltInFictitiousFunctionClassFactory(true, "");
                    }
                    PlaceComponentResult = ScanQrPresenter.this.PlaceComponentResult(decodedScan, str2, str3);
                    ScanQrPresenter scanQrPresenter2 = ScanQrPresenter.this;
                    scanQrPresenter2.PlaceComponentResult(PlaceComponentResult);
                    scanQrPresenter2.MyBillsEntityDataFactory(PlaceComponentResult);
                    return;
                }
                if (z) {
                    lazy5 = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    ((ScanQrContract.View) lazy5.get()).BuiltInFictitiousFunctionClassFactory(false, str2);
                }
                lazy4 = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                ((ScanQrContract.View) lazy4.get()).dismissProgress();
            }
        };
        final ScanQrPresenter scanQrPresenter2 = this.this$0;
        final boolean z2 = this.$$isFromScanQRBridge;
        final String str4 = this.$$scanResultStr;
        final String str5 = this.$$source;
        getDecodedQrBarcode.execute(forDecodeQrBarcode, function1, new Function1<Throwable, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$onlineDecode$1.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy2;
                Lazy lazy3;
                Lazy lazy4;
                Intrinsics.checkNotNullParameter(th, "");
                lazy2 = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                ((ScanQrContract.View) lazy2.get()).moveToNextValue();
                if (z2) {
                    lazy4 = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    ((ScanQrContract.View) lazy4.get()).BuiltInFictitiousFunctionClassFactory(false, str4);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.SCAN_QRCODE_PREFIX);
                sb.append(ScanQrPresenter.this.getClass().getName());
                sb.append("getDecodedQrBarcode :onError");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString(), th);
                lazy3 = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                ((ScanQrContract.View) lazy3.get()).dismissProgress();
                ScanQrPresenter.MyBillsEntityDataFactory(ScanQrPresenter.this, th, str5);
            }
        });
    }
}
