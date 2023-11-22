package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.sendmoney.external.outlet.AddOutletReceiverContract;
import id.dana.sendmoney.external.outlet.AddOutletReceiverPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/di/modules/AddOutletReceiverModule;", "", "Lid/dana/sendmoney/external/outlet/AddOutletReceiverPresenter;", "p0", "Lid/dana/sendmoney/external/outlet/AddOutletReceiverContract$Presenter;", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/external/outlet/AddOutletReceiverPresenter;)Lid/dana/sendmoney/external/outlet/AddOutletReceiverContract$Presenter;", "Lid/dana/sendmoney/external/outlet/AddOutletReceiverContract$View;", "()Lid/dana/sendmoney/external/outlet/AddOutletReceiverContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/external/outlet/AddOutletReceiverContract$View;", "getAuthRequestContext", "<init>", "(Lid/dana/sendmoney/external/outlet/AddOutletReceiverContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class AddOutletReceiverModule {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final AddOutletReceiverContract.View getAuthRequestContext;

    public AddOutletReceiverModule(AddOutletReceiverContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    @PerActivity
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final AddOutletReceiverContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    @PerActivity
    public final AddOutletReceiverContract.Presenter MyBillsEntityDataFactory(AddOutletReceiverPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
