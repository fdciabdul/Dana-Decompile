package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.onboarding.verify.VerifyNumberContract;
import id.dana.onboarding.verify.VerifyPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\b\u001a\u00020\nH\u0007¢\u0006\u0004\b\b\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/di/modules/VerifyNumberModule;", "", "", "getAuthRequestContext", "()Z", "Lid/dana/onboarding/verify/VerifyPresenter;", "p0", "Lid/dana/onboarding/verify/VerifyNumberContract$Presenter;", "MyBillsEntityDataFactory", "(Lid/dana/onboarding/verify/VerifyPresenter;)Lid/dana/onboarding/verify/VerifyNumberContract$Presenter;", "Lid/dana/onboarding/verify/VerifyNumberContract$View;", "()Lid/dana/onboarding/verify/VerifyNumberContract$View;", "Z", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "Lid/dana/onboarding/verify/VerifyNumberContract$View;", "p1", "<init>", "(Lid/dana/onboarding/verify/VerifyNumberContract$View;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class VerifyNumberModule {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final boolean BuiltInFictitiousFunctionClassFactory;
    private final VerifyNumberContract.View PlaceComponentResult;

    public VerifyNumberModule(VerifyNumberContract.View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = view;
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    @Provides
    @PerActivity
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Provides
    @PerActivity
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final VerifyNumberContract.View getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Provides
    @PerActivity
    public final VerifyNumberContract.Presenter MyBillsEntityDataFactory(VerifyPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
