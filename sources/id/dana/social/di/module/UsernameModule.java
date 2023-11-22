package id.dana.social.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerModule;
import id.dana.feeds.data.username.UserProfileEntityRepository;
import id.dana.feeds.domain.username.UserProfileRepository;
import id.dana.social.contract.UsernameContract;
import id.dana.social.presenter.UsernamePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\r"}, d2 = {"Lid/dana/social/di/module/UsernameModule;", "", "Lid/dana/feeds/data/username/UserProfileEntityRepository;", "p0", "Lid/dana/feeds/domain/username/UserProfileRepository;", "getAuthRequestContext", "(Lid/dana/feeds/data/username/UserProfileEntityRepository;)Lid/dana/feeds/domain/username/UserProfileRepository;", "Lid/dana/social/presenter/UsernamePresenter;", "Lid/dana/social/contract/UsernameContract$Presenter;", "(Lid/dana/social/presenter/UsernamePresenter;)Lid/dana/social/contract/UsernameContract$Presenter;", "Lid/dana/social/contract/UsernameContract$View;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/social/contract/UsernameContract$View;", "Lid/dana/social/contract/UsernameContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lid/dana/social/contract/UsernameContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class UsernameModule {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final UsernameContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    public UsernameModule(UsernameContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    @Provides
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final UsernameContract.View getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Provides
    public final UsernameContract.Presenter getAuthRequestContext(UsernamePresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @PerModule
    public final UserProfileRepository getAuthRequestContext(UserProfileEntityRepository p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
