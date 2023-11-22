package id.dana.twilio.trusteddevice;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.twilio.trusteddevice.TrustedDeviceContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/twilio/trusteddevice/TrustedDeviceModule;", "", "Lid/dana/twilio/trusteddevice/TrustedDevicePresenter;", "p0", "Lid/dana/twilio/trusteddevice/TrustedDeviceContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/twilio/trusteddevice/TrustedDevicePresenter;)Lid/dana/twilio/trusteddevice/TrustedDeviceContract$Presenter;", "Lid/dana/twilio/trusteddevice/TrustedDeviceContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/twilio/trusteddevice/TrustedDeviceContract$View;", "PlaceComponentResult", "Lid/dana/twilio/trusteddevice/TrustedDeviceContract$View;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/twilio/trusteddevice/TrustedDeviceContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class TrustedDeviceModule {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final TrustedDeviceContract.View MyBillsEntityDataFactory;

    public TrustedDeviceModule(TrustedDeviceContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    @PerActivity
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final TrustedDeviceContract.View getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    @PerActivity
    public final TrustedDeviceContract.Presenter BuiltInFictitiousFunctionClassFactory(TrustedDevicePresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
