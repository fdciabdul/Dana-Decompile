package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerService;
import id.dana.ocr.UploadSnapReceiptContract;
import id.dana.ocr.UploadSnapReceiptPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/di/modules/UploadSnapReceiptModule;", "", "Lid/dana/ocr/UploadSnapReceiptPresenter;", "p0", "Lid/dana/ocr/UploadSnapReceiptContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/ocr/UploadSnapReceiptPresenter;)Lid/dana/ocr/UploadSnapReceiptContract$Presenter;", "Lid/dana/ocr/UploadSnapReceiptContract$View;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/ocr/UploadSnapReceiptContract$View;", "PlaceComponentResult", "Lid/dana/ocr/UploadSnapReceiptContract$View;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/ocr/UploadSnapReceiptContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public final class UploadSnapReceiptModule {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final UploadSnapReceiptContract.View MyBillsEntityDataFactory;

    public UploadSnapReceiptModule(UploadSnapReceiptContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    @PerService
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final UploadSnapReceiptContract.View getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    @PerService
    public final UploadSnapReceiptContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(UploadSnapReceiptPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
