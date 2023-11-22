package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.ocr.OCRPreviewImageContract;
import id.dana.ocr.OCRPreviewImagePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\n"}, d2 = {"Lid/dana/di/modules/OCRPreviewImageModule;", "", "Lid/dana/ocr/OCRPreviewImagePresenter;", "p0", "Lid/dana/ocr/OCRPreviewImageContract$Presenter;", "PlaceComponentResult", "(Lid/dana/ocr/OCRPreviewImagePresenter;)Lid/dana/ocr/OCRPreviewImageContract$Presenter;", "Lid/dana/ocr/OCRPreviewImageContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/ocr/OCRPreviewImageContract$View;", "Lid/dana/ocr/OCRPreviewImageContract$View;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/ocr/OCRPreviewImageContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {PreprocessingAndOcrModule.class})
/* loaded from: classes8.dex */
public final class OCRPreviewImageModule {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final OCRPreviewImageContract.View MyBillsEntityDataFactory;

    public OCRPreviewImageModule(OCRPreviewImageContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    @PerActivity
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final OCRPreviewImageContract.View getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    @PerActivity
    public final OCRPreviewImageContract.Presenter PlaceComponentResult(OCRPreviewImagePresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
