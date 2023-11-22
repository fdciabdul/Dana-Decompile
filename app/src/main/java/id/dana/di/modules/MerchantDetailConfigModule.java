package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/di/modules/MerchantDetailConfigModule;", "", "Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigPresenter;", "p0", "Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigPresenter;)Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$Presenter;", "Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$View;", "getAuthRequestContext", "()Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$View;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$View;", "<init>", "(Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class MerchantDetailConfigModule {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final MerchantDetailConfigContract.View getAuthRequestContext;

    public MerchantDetailConfigModule(MerchantDetailConfigContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    @PerActivity
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final MerchantDetailConfigContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    @PerActivity
    public final MerchantDetailConfigContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(MerchantDetailConfigPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
