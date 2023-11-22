package id.dana.danah5.ocrreceipt.usecase;

import dagger.internal.Factory;
import id.dana.appcontainer.plugin.ocrreceipt.repository.OcrConfigRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetOcrPreprocessingConfig_Factory implements Factory<GetOcrPreprocessingConfig> {
    private final Provider<OcrConfigRepository> ocrConfigRepositoryProvider;

    public GetOcrPreprocessingConfig_Factory(Provider<OcrConfigRepository> provider) {
        this.ocrConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetOcrPreprocessingConfig get() {
        return newInstance(this.ocrConfigRepositoryProvider.get());
    }

    public static GetOcrPreprocessingConfig_Factory create(Provider<OcrConfigRepository> provider) {
        return new GetOcrPreprocessingConfig_Factory(provider);
    }

    public static GetOcrPreprocessingConfig newInstance(OcrConfigRepository ocrConfigRepository) {
        return new GetOcrPreprocessingConfig(ocrConfigRepository);
    }
}
