package id.dana.data.ocr.repository.source;

import dagger.internal.Factory;
import id.dana.data.ocr.repository.source.firebase.FirebaseVisionOcrData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class OCREntityDataFactory_Factory implements Factory<OCREntityDataFactory> {
    private final Provider<FirebaseVisionOcrData> firebaseVisionOcrDataProvider;

    public OCREntityDataFactory_Factory(Provider<FirebaseVisionOcrData> provider) {
        this.firebaseVisionOcrDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final OCREntityDataFactory get() {
        return newInstance(this.firebaseVisionOcrDataProvider.get());
    }

    public static OCREntityDataFactory_Factory create(Provider<FirebaseVisionOcrData> provider) {
        return new OCREntityDataFactory_Factory(provider);
    }

    public static OCREntityDataFactory newInstance(FirebaseVisionOcrData firebaseVisionOcrData) {
        return new OCREntityDataFactory(firebaseVisionOcrData);
    }
}
