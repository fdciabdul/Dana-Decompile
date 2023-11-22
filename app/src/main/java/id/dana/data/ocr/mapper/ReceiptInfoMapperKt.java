package id.dana.data.ocr.mapper;

import id.dana.data.ocr.model.ReceiptInfo;
import id.dana.domain.ocr.model.ReceiptInfoModel;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0003\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00020\u0002*\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u00000\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/reactivex/Observable;", "Lid/dana/data/ocr/model/ReceiptInfo;", "Lid/dana/domain/ocr/model/ReceiptInfoModel;", "toReceiptInfoModel", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ReceiptInfoMapperKt {
    public static final Observable<ReceiptInfoModel> toReceiptInfoModel(Observable<ReceiptInfo> observable) {
        Intrinsics.checkNotNullParameter(observable, "");
        return observable.map(new Function() { // from class: id.dana.data.ocr.mapper.ReceiptInfoMapperKt$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ReceiptInfoModel m1548toReceiptInfoModel$lambda0;
                m1548toReceiptInfoModel$lambda0 = ReceiptInfoMapperKt.m1548toReceiptInfoModel$lambda0((ReceiptInfo) obj);
                return m1548toReceiptInfoModel$lambda0;
            }
        });
    }

    /* renamed from: toReceiptInfoModel$lambda-0 */
    public static final ReceiptInfoModel m1548toReceiptInfoModel$lambda0(ReceiptInfo receiptInfo) {
        Intrinsics.checkNotNullParameter(receiptInfo, "");
        return new ReceiptInfoModel();
    }
}
