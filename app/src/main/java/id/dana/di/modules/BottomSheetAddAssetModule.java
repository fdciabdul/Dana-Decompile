package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract;
import id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/di/modules/BottomSheetAddAssetModule;", "", "Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetPresenter;", "p0", "Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetPresenter;)Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetContract$Presenter;", "Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetContract$View;", "MyBillsEntityDataFactory", "()Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetContract$View;", "getAuthRequestContext", "Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public final class BottomSheetAddAssetModule {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final BottomSheetAddAssetContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    @Provides
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final BottomSheetAddAssetContract.View getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Provides
    public final BottomSheetAddAssetContract.Presenter BuiltInFictitiousFunctionClassFactory(BottomSheetAddAssetPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
