package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.pushverify.view.verificationlist.list.VerificationListContract;
import id.dana.pushverify.view.verificationlist.list.VerificationListPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\n"}, d2 = {"Lid/dana/di/modules/VerificationListModule;", "", "Lid/dana/pushverify/view/verificationlist/list/VerificationListPresenter;", "p0", "Lid/dana/pushverify/view/verificationlist/list/VerificationListContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/pushverify/view/verificationlist/list/VerificationListPresenter;)Lid/dana/pushverify/view/verificationlist/list/VerificationListContract$Presenter;", "Lid/dana/pushverify/view/verificationlist/list/VerificationListContract$View;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/pushverify/view/verificationlist/list/VerificationListContract$View;", "Lid/dana/pushverify/view/verificationlist/list/VerificationListContract$View;", "<init>", "(Lid/dana/pushverify/view/verificationlist/list/VerificationListContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class VerificationListModule {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final VerificationListContract.View BuiltInFictitiousFunctionClassFactory;

    public VerificationListModule(VerificationListContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Provides
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final VerificationListContract.View getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Provides
    public final VerificationListContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(VerificationListPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
