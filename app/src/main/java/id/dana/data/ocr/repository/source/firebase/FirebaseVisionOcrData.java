package id.dana.data.ocr.repository.source.firebase;

import id.dana.data.ocr.model.ReceiptInfo;
import id.dana.data.ocr.model.RequestReceiptInfo;
import id.dana.data.ocr.repository.source.OCREntityData;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/data/ocr/repository/source/firebase/FirebaseVisionOcrData;", "Lid/dana/data/ocr/repository/source/OCREntityData;", "Lid/dana/data/ocr/model/RequestReceiptInfo;", "requestReceiptInfo", "Lio/reactivex/Observable;", "Lid/dana/data/ocr/model/ReceiptInfo;", "getOcrReceiptResponse", "(Lid/dana/data/ocr/model/RequestReceiptInfo;)Lio/reactivex/Observable;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FirebaseVisionOcrData implements OCREntityData {
    @Inject
    public FirebaseVisionOcrData() {
    }

    @Override // id.dana.data.ocr.repository.source.OCREntityData
    public final Observable<ReceiptInfo> getOcrReceiptResponse(RequestReceiptInfo requestReceiptInfo) {
        Intrinsics.checkNotNullParameter(requestReceiptInfo, "");
        Observable<ReceiptInfo> create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.ocr.repository.source.firebase.FirebaseVisionOcrData$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                FirebaseVisionOcrData.m1550getOcrReceiptResponse$lambda0(observableEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getOcrReceiptResponse$lambda-0  reason: not valid java name */
    public static final void m1550getOcrReceiptResponse$lambda0(ObservableEmitter observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        observableEmitter.onNext(new ReceiptInfo());
    }
}
