package id.dana.cashier.guide.di;

import dagger.Module;
import dagger.Provides;
import id.dana.cashier.guide.contract.GuideContract;
import id.dana.cashier.guide.contract.GuidePresenter;
import id.dana.di.PerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/cashier/guide/di/GuideModule;", "", "Lid/dana/cashier/guide/contract/GuidePresenter;", "p0", "Lid/dana/cashier/guide/contract/GuideContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/guide/contract/GuidePresenter;)Lid/dana/cashier/guide/contract/GuideContract$Presenter;", "Lid/dana/cashier/guide/contract/GuideContract$View;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/cashier/guide/contract/GuideContract$View;", "MyBillsEntityDataFactory", "Lid/dana/cashier/guide/contract/GuideContract$View;", "PlaceComponentResult", "<init>", "(Lid/dana/cashier/guide/contract/GuideContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class GuideModule {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GuideContract.View PlaceComponentResult;

    public GuideModule(GuideContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = view;
    }

    @Provides
    @PerActivity
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final GuideContract.View getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Provides
    public final GuideContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(GuidePresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
