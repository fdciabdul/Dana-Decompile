package id.dana.social.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.social.contract.MutedFragmentContract;
import id.dana.social.presenter.MutedFragmentPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007X\u0007¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/social/di/module/MutedFragmentModule;", "", "Lid/dana/social/presenter/MutedFragmentPresenter;", "p0", "Lid/dana/social/contract/MutedFragmentContract$Presenter;", "MyBillsEntityDataFactory", "(Lid/dana/social/presenter/MutedFragmentPresenter;)Lid/dana/social/contract/MutedFragmentContract$Presenter;", "Lid/dana/social/contract/MutedFragmentContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/social/contract/MutedFragmentContract$View;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/contract/MutedFragmentContract$View;", "PlaceComponentResult", "<init>", "(Lid/dana/social/contract/MutedFragmentContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class MutedFragmentModule {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final MutedFragmentContract.View PlaceComponentResult;

    public MutedFragmentModule(MutedFragmentContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = view;
    }

    @Provides
    public final MutedFragmentContract.Presenter MyBillsEntityDataFactory(MutedFragmentPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final MutedFragmentContract.View getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }
}
