package id.dana.contract.globalsearch;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.globalsearch.GlobalSearchBottomSheetContract;
import id.dana.di.PerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\bR\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/contract/globalsearch/GlobalSearchBottomSheetModule;", "", "Lid/dana/contract/globalsearch/GlobalSearchBottomSheetPresenter;", "p0", "Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/contract/globalsearch/GlobalSearchBottomSheetPresenter;)Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract$Presenter;", "Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract$View;", "()Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract$View;", "getAuthRequestContext", "Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract$View;", "<init>", "(Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class GlobalSearchBottomSheetModule {
    private final GlobalSearchBottomSheetContract.View getAuthRequestContext;

    public GlobalSearchBottomSheetModule(GlobalSearchBottomSheetContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    @PerActivity
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final GlobalSearchBottomSheetContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    @PerActivity
    public final GlobalSearchBottomSheetContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchBottomSheetPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
