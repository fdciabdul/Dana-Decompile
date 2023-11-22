package id.dana.wallet_v3.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetContract;
import id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/wallet_v3/di/module/BottomSheetSortAssetModule;", "", "Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetPresenter;", "presenter", "Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetContract$Presenter;", "providePresenter$app_productionRelease", "(Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetPresenter;)Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetContract$Presenter;", "Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetContract$View;", "provideView$app_productionRelease", "()Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetContract$View;", "view", "Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetContract$View;", "<init>", "(Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class BottomSheetSortAssetModule {
    private final BottomSheetSortAssetContract.View view;

    public BottomSheetSortAssetModule(BottomSheetSortAssetContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.view = view;
    }

    @Provides
    /* renamed from: provideView$app_productionRelease  reason: from getter */
    public final BottomSheetSortAssetContract.View getView() {
        return this.view;
    }

    @Provides
    public final BottomSheetSortAssetContract.Presenter providePresenter$app_productionRelease(BottomSheetSortAssetPresenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        return presenter;
    }
}
