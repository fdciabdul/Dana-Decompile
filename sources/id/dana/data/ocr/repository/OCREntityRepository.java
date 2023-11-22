package id.dana.data.ocr.repository;

import android.graphics.Bitmap;
import id.dana.data.ocr.mapper.ReceiptInfoMapperKt;
import id.dana.data.ocr.model.RequestReceiptInfo;
import id.dana.data.ocr.repository.source.OCREntityData;
import id.dana.data.ocr.repository.source.OCREntityDataFactory;
import id.dana.domain.ocr.OCRRepository;
import id.dana.domain.ocr.model.ReceiptInfoModel;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J;\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\r8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/data/ocr/repository/OCREntityRepository;", "Lid/dana/domain/ocr/OCRRepository;", "", "sourceOcr", "rules", "", "merchantNameAlias", "Landroid/graphics/Bitmap;", "image", "Lio/reactivex/Observable;", "Lid/dana/domain/ocr/model/ReceiptInfoModel;", "processReceiptOcr", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Landroid/graphics/Bitmap;)Lio/reactivex/Observable;", "Lid/dana/data/ocr/repository/source/OCREntityData;", "firebaseOcrData$delegate", "Lkotlin/Lazy;", "getFirebaseOcrData", "()Lid/dana/data/ocr/repository/source/OCREntityData;", "firebaseOcrData", "Lid/dana/data/ocr/repository/source/OCREntityDataFactory;", "ocrEntityDataFactory", "Lid/dana/data/ocr/repository/source/OCREntityDataFactory;", "<init>", "(Lid/dana/data/ocr/repository/source/OCREntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OCREntityRepository implements OCRRepository {

    /* renamed from: firebaseOcrData$delegate  reason: from kotlin metadata */
    private final Lazy firebaseOcrData;
    private final OCREntityDataFactory ocrEntityDataFactory;

    @Inject
    public OCREntityRepository(OCREntityDataFactory oCREntityDataFactory) {
        Intrinsics.checkNotNullParameter(oCREntityDataFactory, "");
        this.ocrEntityDataFactory = oCREntityDataFactory;
        this.firebaseOcrData = LazyKt.lazy(new Function0<OCREntityData>() { // from class: id.dana.data.ocr.repository.OCREntityRepository$firebaseOcrData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OCREntityData invoke() {
                OCREntityDataFactory oCREntityDataFactory2;
                oCREntityDataFactory2 = OCREntityRepository.this.ocrEntityDataFactory;
                return oCREntityDataFactory2.createData("FIREBASE_VISION");
            }
        });
    }

    @JvmName(name = "getFirebaseOcrData")
    private final OCREntityData getFirebaseOcrData() {
        return (OCREntityData) this.firebaseOcrData.getValue();
    }

    @Override // id.dana.domain.ocr.OCRRepository
    public final Observable<ReceiptInfoModel> processReceiptOcr(String sourceOcr, String rules, List<String> merchantNameAlias, Bitmap image) {
        Intrinsics.checkNotNullParameter(sourceOcr, "");
        Intrinsics.checkNotNullParameter(rules, "");
        Intrinsics.checkNotNullParameter(merchantNameAlias, "");
        Intrinsics.checkNotNullParameter(image, "");
        Observable<ReceiptInfoModel> receiptInfoModel = ReceiptInfoMapperKt.toReceiptInfoModel(getFirebaseOcrData().getOcrReceiptResponse(new RequestReceiptInfo(rules, merchantNameAlias, image)));
        Intrinsics.checkNotNullExpressionValue(receiptInfoModel, "");
        return receiptInfoModel;
    }
}
