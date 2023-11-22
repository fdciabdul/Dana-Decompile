package id.dana.data.qrbarcode.repository;

import id.dana.data.qrbarcode.mapper.QrBarcodeMapper;
import id.dana.data.qrbarcode.repository.source.network.result.GenerateQrResult;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class QrBarcodeEntityRepository$$ExternalSyntheticLambda5 implements Function {
    public final /* synthetic */ QrBarcodeMapper f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.transform((GenerateQrResult) obj);
    }
}
