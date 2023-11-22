package id.dana.sendmoney_v2.landing.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountContract;
import id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney_v2/landing/di/module/SuspiciousAccountModule;", "", "Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountPresenter;", "p0", "Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountContract$Presenter;", "getAuthRequestContext", "(Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountPresenter;)Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountContract$Presenter;", "Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountContract$View;", "()Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountContract$View;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class SuspiciousAccountModule {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final SuspiciousAccountContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    public SuspiciousAccountModule(SuspiciousAccountContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    @Provides
    @PerActivity
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final SuspiciousAccountContract.View getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Provides
    @PerActivity
    public final SuspiciousAccountContract.Presenter getAuthRequestContext(SuspiciousAccountPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
