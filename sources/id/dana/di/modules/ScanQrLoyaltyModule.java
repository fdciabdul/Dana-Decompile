package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.animation.ScanQrLoyaltyContract;
import id.dana.animation.ScanQrLoyaltyPresenter;
import id.dana.di.PerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/di/modules/ScanQrLoyaltyModule;", "", "Lid/dana/loyalty/ScanQrLoyaltyContract$View;", "MyBillsEntityDataFactory", "()Lid/dana/loyalty/ScanQrLoyaltyContract$View;", "Lid/dana/loyalty/ScanQrLoyaltyPresenter;", "p0", "Lid/dana/loyalty/ScanQrLoyaltyContract$Presenter;", "getAuthRequestContext", "(Lid/dana/loyalty/ScanQrLoyaltyPresenter;)Lid/dana/loyalty/ScanQrLoyaltyContract$Presenter;", "PlaceComponentResult", "Lid/dana/loyalty/ScanQrLoyaltyContract$View;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/loyalty/ScanQrLoyaltyContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public final class ScanQrLoyaltyModule {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ScanQrLoyaltyContract.View BuiltInFictitiousFunctionClassFactory;

    public ScanQrLoyaltyModule(ScanQrLoyaltyContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Provides
    @PerActivity
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final ScanQrLoyaltyContract.View getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Provides
    @PerActivity
    public final ScanQrLoyaltyContract.Presenter getAuthRequestContext(ScanQrLoyaltyPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
