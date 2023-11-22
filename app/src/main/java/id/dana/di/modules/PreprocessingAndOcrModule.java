package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.ocr.PreprocessingAndOcrContract;
import id.dana.ocr.PreprocessingAndOcrPresenter;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/di/modules/PreprocessingAndOcrModule;", "", "Lio/reactivex/disposables/CompositeDisposable;", "PlaceComponentResult", "()Lio/reactivex/disposables/CompositeDisposable;", "Lid/dana/ocr/PreprocessingAndOcrPresenter;", "p0", "Lid/dana/ocr/PreprocessingAndOcrContract$Presenter;", "MyBillsEntityDataFactory", "(Lid/dana/ocr/PreprocessingAndOcrPresenter;)Lid/dana/ocr/PreprocessingAndOcrContract$Presenter;", "Lid/dana/ocr/PreprocessingAndOcrContract$View;", "getAuthRequestContext", "()Lid/dana/ocr/PreprocessingAndOcrContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/ocr/PreprocessingAndOcrContract$View;", "<init>", "(Lid/dana/ocr/PreprocessingAndOcrContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public final class PreprocessingAndOcrModule {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final PreprocessingAndOcrContract.View MyBillsEntityDataFactory;

    public PreprocessingAndOcrModule(PreprocessingAndOcrContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final PreprocessingAndOcrContract.View getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    public final CompositeDisposable PlaceComponentResult() {
        return new CompositeDisposable();
    }

    @Provides
    public final PreprocessingAndOcrContract.Presenter MyBillsEntityDataFactory(PreprocessingAndOcrPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
