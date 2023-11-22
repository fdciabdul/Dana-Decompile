package id.dana.data.ocr.repository;

import dagger.internal.Factory;
import id.dana.data.ocr.repository.source.OCREntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class OCREntityRepository_Factory implements Factory<OCREntityRepository> {
    private final Provider<OCREntityDataFactory> ocrEntityDataFactoryProvider;

    public OCREntityRepository_Factory(Provider<OCREntityDataFactory> provider) {
        this.ocrEntityDataFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final OCREntityRepository get() {
        return newInstance(this.ocrEntityDataFactoryProvider.get());
    }

    public static OCREntityRepository_Factory create(Provider<OCREntityDataFactory> provider) {
        return new OCREntityRepository_Factory(provider);
    }

    public static OCREntityRepository newInstance(OCREntityDataFactory oCREntityDataFactory) {
        return new OCREntityRepository(oCREntityDataFactory);
    }
}
