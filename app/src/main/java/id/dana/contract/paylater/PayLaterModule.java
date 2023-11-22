package id.dana.contract.paylater;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.paylater.PayLaterContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/contract/paylater/PayLaterModule;", "", "Lid/dana/contract/paylater/PayLaterPresenter;", "p0", "Lid/dana/contract/paylater/PayLaterContract$Presenter;", "PlaceComponentResult", "(Lid/dana/contract/paylater/PayLaterPresenter;)Lid/dana/contract/paylater/PayLaterContract$Presenter;", "Lid/dana/contract/paylater/PayLaterContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/contract/paylater/PayLaterContract$View;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/contract/paylater/PayLaterContract$View;", "<init>", "(Lid/dana/contract/paylater/PayLaterContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class PayLaterModule {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final PayLaterContract.View PlaceComponentResult;

    public PayLaterModule(PayLaterContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = view;
    }

    @Provides
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final PayLaterContract.View getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Provides
    public final PayLaterContract.Presenter PlaceComponentResult(PayLaterPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
