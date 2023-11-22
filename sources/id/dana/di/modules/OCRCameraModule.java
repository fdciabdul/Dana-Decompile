package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.ocr.OCRCameraContract;
import id.dana.ocr.OCRCameraPresenter;
import id.dana.ocr.model.OCRRequestModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0014\u0010\u0003\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/di/modules/OCRCameraModule;", "", "Lid/dana/ocr/model/OCRRequestModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/ocr/model/OCRRequestModel;", "Lid/dana/ocr/OCRCameraPresenter;", "p0", "Lid/dana/ocr/OCRCameraContract$Presenter;", "PlaceComponentResult", "(Lid/dana/ocr/OCRCameraPresenter;)Lid/dana/ocr/OCRCameraContract$Presenter;", "Lid/dana/ocr/OCRCameraContract$View;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/ocr/OCRCameraContract$View;", "Lid/dana/ocr/model/OCRRequestModel;", "MyBillsEntityDataFactory", "getAuthRequestContext", "Lid/dana/ocr/OCRCameraContract$View;", "p1", "<init>", "(Lid/dana/ocr/OCRCameraContract$View;Lid/dana/ocr/model/OCRRequestModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public final class OCRCameraModule {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final OCRRequestModel MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final OCRCameraContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    public OCRCameraModule(OCRCameraContract.View view, OCRRequestModel oCRRequestModel) {
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.MyBillsEntityDataFactory = oCRRequestModel;
    }

    @Provides
    @PerActivity
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final OCRCameraContract.View getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Provides
    @PerActivity
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final OCRRequestModel getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    @PerActivity
    public final OCRCameraContract.Presenter PlaceComponentResult(OCRCameraPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
