package id.dana.contract.userpersonalization;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.userpersonalization.UserPersonalizationContract;
import id.dana.di.PerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/contract/userpersonalization/UserPersonalizationModule;", "", "Lid/dana/contract/userpersonalization/UserPersonalizationPresenter;", "p0", "Lid/dana/contract/userpersonalization/UserPersonalizationContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/contract/userpersonalization/UserPersonalizationPresenter;)Lid/dana/contract/userpersonalization/UserPersonalizationContract$Presenter;", "Lid/dana/contract/userpersonalization/UserPersonalizationContract$View;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/contract/userpersonalization/UserPersonalizationContract$View;", "getAuthRequestContext", "Lid/dana/contract/userpersonalization/UserPersonalizationContract$View;", "<init>", "(Lid/dana/contract/userpersonalization/UserPersonalizationContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class UserPersonalizationModule {
    private final UserPersonalizationContract.View getAuthRequestContext;

    public UserPersonalizationModule(UserPersonalizationContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    @PerActivity
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final UserPersonalizationContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    @PerActivity
    public final UserPersonalizationContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(UserPersonalizationPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
