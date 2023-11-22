package id.dana.data.devicestats.entity;

import id.dana.data.devicestats.DeviceStatsPreferenceEntityData;
import id.dana.data.storage.PreferenceFacade;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\n"}, d2 = {"Lid/dana/data/devicestats/entity/SecurePrefDeviceStatsPreferenceEntityData;", "Lid/dana/data/devicestats/DeviceStatsPreferenceEntityData;", "", "BuiltInFictitiousFunctionClassFactory", "()J", "p0", "", "MyBillsEntityDataFactory", "(J)V", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/PreferenceFacade;", "PlaceComponentResult", "<init>", "(Lid/dana/data/storage/PreferenceFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SecurePrefDeviceStatsPreferenceEntityData implements DeviceStatsPreferenceEntityData {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final PreferenceFacade PlaceComponentResult;

    public SecurePrefDeviceStatsPreferenceEntityData(PreferenceFacade preferenceFacade) {
        Intrinsics.checkNotNullParameter(preferenceFacade, "");
        this.PlaceComponentResult = preferenceFacade;
    }

    @Override // id.dana.data.devicestats.DeviceStatsPreferenceEntityData
    public final long BuiltInFictitiousFunctionClassFactory() {
        Long l = this.PlaceComponentResult.getLong("lasttimetracke");
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    @Override // id.dana.data.devicestats.DeviceStatsPreferenceEntityData
    public final void MyBillsEntityDataFactory(long p0) {
        this.PlaceComponentResult.saveData("lasttimetracke", Long.valueOf(p0));
    }
}
