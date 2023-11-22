package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.maintenance.EmergencyNotifContract;
import id.dana.maintenance.EmergencyNotifPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/di/modules/EmergencyNotifModule;", "", "Lid/dana/maintenance/EmergencyNotifPresenter;", "p0", "Lid/dana/maintenance/EmergencyNotifContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/maintenance/EmergencyNotifPresenter;)Lid/dana/maintenance/EmergencyNotifContract$Presenter;", "Lid/dana/maintenance/EmergencyNotifContract$View;", "MyBillsEntityDataFactory", "()Lid/dana/maintenance/EmergencyNotifContract$View;", "Lid/dana/maintenance/EmergencyNotifContract$View;", "PlaceComponentResult", "<init>", "(Lid/dana/maintenance/EmergencyNotifContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class EmergencyNotifModule {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final EmergencyNotifContract.View PlaceComponentResult;

    public EmergencyNotifModule(EmergencyNotifContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = view;
    }

    @Provides
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final EmergencyNotifContract.View getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Provides
    public final EmergencyNotifContract.Presenter BuiltInFictitiousFunctionClassFactory(EmergencyNotifPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
