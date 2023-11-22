package id.dana.social.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.social.contract.BlockedFragmentContract;
import id.dana.social.presenter.BlockedFragmentPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0007X\u0007¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/social/di/module/BlockedFragmentModule;", "", "Lid/dana/social/presenter/BlockedFragmentPresenter;", "p0", "Lid/dana/social/contract/BlockedFragmentContract$Presenter;", "getAuthRequestContext", "(Lid/dana/social/presenter/BlockedFragmentPresenter;)Lid/dana/social/contract/BlockedFragmentContract$Presenter;", "Lid/dana/social/contract/BlockedFragmentContract$View;", "()Lid/dana/social/contract/BlockedFragmentContract$View;", "PlaceComponentResult", "Lid/dana/social/contract/BlockedFragmentContract$View;", "<init>", "(Lid/dana/social/contract/BlockedFragmentContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class BlockedFragmentModule {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final BlockedFragmentContract.View getAuthRequestContext;

    public BlockedFragmentModule(BlockedFragmentContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    public final BlockedFragmentContract.Presenter getAuthRequestContext(BlockedFragmentPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final BlockedFragmentContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }
}
