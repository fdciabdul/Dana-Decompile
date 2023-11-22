package id.dana.social.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.social.contract.SocialProfileContract;
import id.dana.social.presenter.SocialProfilePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/social/di/module/SocialProfileModule;", "", "Lid/dana/social/presenter/SocialProfilePresenter;", "p0", "Lid/dana/social/contract/SocialProfileContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/social/presenter/SocialProfilePresenter;)Lid/dana/social/contract/SocialProfileContract$Presenter;", "Lid/dana/social/contract/SocialProfileContract$View;", "MyBillsEntityDataFactory", "()Lid/dana/social/contract/SocialProfileContract$View;", "getAuthRequestContext", "Lid/dana/social/contract/SocialProfileContract$View;", "<init>", "(Lid/dana/social/contract/SocialProfileContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class SocialProfileModule {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SocialProfileContract.View BuiltInFictitiousFunctionClassFactory;

    public SocialProfileModule(SocialProfileContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Provides
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final SocialProfileContract.View getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Provides
    public final SocialProfileContract.Presenter BuiltInFictitiousFunctionClassFactory(SocialProfilePresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
