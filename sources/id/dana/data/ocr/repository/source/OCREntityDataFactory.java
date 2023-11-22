package id.dana.data.ocr.repository.source;

import id.dana.data.ocr.AbstractEntityOcrDataFactory;
import id.dana.data.ocr.repository.source.firebase.FirebaseVisionOcrData;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/data/ocr/repository/source/OCREntityDataFactory;", "Lid/dana/data/ocr/AbstractEntityOcrDataFactory;", "Lid/dana/data/ocr/repository/source/OCREntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/ocr/repository/source/OCREntityData;", "Lid/dana/data/ocr/repository/source/firebase/FirebaseVisionOcrData;", "firebaseVisionOcrData", "Lid/dana/data/ocr/repository/source/firebase/FirebaseVisionOcrData;", "<init>", "(Lid/dana/data/ocr/repository/source/firebase/FirebaseVisionOcrData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OCREntityDataFactory implements AbstractEntityOcrDataFactory<OCREntityData> {
    private final FirebaseVisionOcrData firebaseVisionOcrData;

    @Inject
    public OCREntityDataFactory(FirebaseVisionOcrData firebaseVisionOcrData) {
        Intrinsics.checkNotNullParameter(firebaseVisionOcrData, "");
        this.firebaseVisionOcrData = firebaseVisionOcrData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.ocr.AbstractEntityOcrDataFactory
    public final OCREntityData createData(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        return this.firebaseVisionOcrData;
    }
}
