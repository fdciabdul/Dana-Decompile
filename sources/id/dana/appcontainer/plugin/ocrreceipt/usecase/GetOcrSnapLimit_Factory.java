package id.dana.appcontainer.plugin.ocrreceipt.usecase;

import dagger.internal.Factory;
import id.dana.appcontainer.plugin.ocrreceipt.repository.OcrConfigRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetOcrSnapLimit_Factory implements Factory<GetOcrSnapLimit> {
    private final Provider<OcrConfigRepository> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetOcrSnapLimit(this.PlaceComponentResult.get());
    }
}
