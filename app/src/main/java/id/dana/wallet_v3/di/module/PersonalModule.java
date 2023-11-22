package id.dana.wallet_v3.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.wallet.personal.PersonalContract;
import id.dana.wallet_v3.identity.presenter.PersonalPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/wallet_v3/di/module/PersonalModule;", "", "Lid/dana/wallet_v3/identity/presenter/PersonalPresenter;", "personalPresenter", "Lid/dana/wallet/personal/PersonalContract$Presenter;", "providePresenter", "(Lid/dana/wallet_v3/identity/presenter/PersonalPresenter;)Lid/dana/wallet/personal/PersonalContract$Presenter;", "Lid/dana/wallet/personal/PersonalContract$View;", "provideView", "()Lid/dana/wallet/personal/PersonalContract$View;", "view", "Lid/dana/wallet/personal/PersonalContract$View;", "<init>", "(Lid/dana/wallet/personal/PersonalContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class PersonalModule {
    private final PersonalContract.View view;

    public PersonalModule(PersonalContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.view = view;
    }

    @Provides
    @PerActivity
    /* renamed from: provideView  reason: from getter */
    public final PersonalContract.View getView() {
        return this.view;
    }

    @Provides
    @PerActivity
    public final PersonalContract.Presenter providePresenter(PersonalPresenter personalPresenter) {
        Intrinsics.checkNotNullParameter(personalPresenter, "");
        return personalPresenter;
    }
}
