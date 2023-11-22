package id.dana.data.qrbarcode.repository;

import id.dana.data.qrbarcode.repository.source.network.result.UserBankQrResult;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class QrBarcodeEntityRepository$$ExternalSyntheticLambda3 implements Function {
    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return UserBankQrResult.toQrUserBankResult((UserBankQrResult) obj);
    }
}
