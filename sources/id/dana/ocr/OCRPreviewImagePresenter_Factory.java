package id.dana.ocr;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.ocr.OCRPreviewImageContract;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class OCRPreviewImagePresenter_Factory implements Factory<OCRPreviewImagePresenter> {
    private final Provider<CompositeDisposable> MyBillsEntityDataFactory;
    private final Provider<OCRPreviewImageContract.View> PlaceComponentResult;
    private final Provider<PostExecutionThread> getAuthRequestContext;

    private OCRPreviewImagePresenter_Factory(Provider<OCRPreviewImageContract.View> provider, Provider<PostExecutionThread> provider2, Provider<CompositeDisposable> provider3) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static OCRPreviewImagePresenter_Factory PlaceComponentResult(Provider<OCRPreviewImageContract.View> provider, Provider<PostExecutionThread> provider2, Provider<CompositeDisposable> provider3) {
        return new OCRPreviewImagePresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OCRPreviewImagePresenter(this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
