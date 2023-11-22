package id.dana.data.devicestats.entity;

import id.dana.data.devicestats.DeviceStatsConfigEntityData;
import id.dana.data.devicestats.model.DeviceStatsConfig;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0014\u0010\t\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f"}, d2 = {"Lid/dana/data/devicestats/entity/SplitDeviceStatsConfigEntityData;", "Lid/dana/data/devicestats/DeviceStatsConfigEntityData;", "", "getAuthRequestContext", "()Z", "Lid/dana/data/devicestats/model/DeviceStatsConfig;", "PlaceComponentResult", "()Lid/dana/data/devicestats/model/DeviceStatsConfig;", "", "MyBillsEntityDataFactory", "()I", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/devicestats/model/DeviceStatsConfig;", "Lid/dana/data/toggle/SplitFacade;", "Lid/dana/data/toggle/SplitFacade;", "p0", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitDeviceStatsConfigEntityData implements DeviceStatsConfigEntityData {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private DeviceStatsConfig getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SplitFacade MyBillsEntityDataFactory;

    @Inject
    public SplitDeviceStatsConfigEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.MyBillsEntityDataFactory = splitFacade;
    }

    @Override // id.dana.data.devicestats.DeviceStatsConfigEntityData
    public final int BuiltInFictitiousFunctionClassFactory() {
        Integer num = PlaceComponentResult().PlaceComponentResult;
        if (num != null) {
            return num.intValue();
        }
        return 500000;
    }

    @Override // id.dana.data.devicestats.DeviceStatsConfigEntityData
    public final int MyBillsEntityDataFactory() {
        Integer num = PlaceComponentResult().getAuthRequestContext;
        if (num != null) {
            return num.intValue();
        }
        return 7;
    }

    @Override // id.dana.data.devicestats.DeviceStatsConfigEntityData
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        Boolean bool = PlaceComponentResult().KClassImpl$Data$declaredNonStaticMembers$2;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // id.dana.data.devicestats.DeviceStatsConfigEntityData
    public final boolean getAuthRequestContext() {
        Boolean bool = PlaceComponentResult().MyBillsEntityDataFactory;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final DeviceStatsConfig PlaceComponentResult() {
        Observable map;
        DeviceStatsConfig deviceStatsConfig = this.getAuthRequestContext;
        if (deviceStatsConfig == null || (map = Observable.just(deviceStatsConfig)) == null) {
            map = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.devicestats.entity.SplitDeviceStatsConfigEntityData$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    DeviceStatsConfig authRequestContext;
                    authRequestContext = SplitDeviceStatsConfigEntityData.getAuthRequestContext(SplitDeviceStatsConfigEntityData.this, (BaseTrafficType) obj);
                    return authRequestContext;
                }
            }).timeout(5L, TimeUnit.SECONDS).onErrorReturn(new Function() { // from class: id.dana.data.devicestats.entity.SplitDeviceStatsConfigEntityData$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SplitDeviceStatsConfigEntityData.MyBillsEntityDataFactory(SplitDeviceStatsConfigEntityData.this, (Throwable) obj);
                }
            }).map(new Function() { // from class: id.dana.data.devicestats.entity.SplitDeviceStatsConfigEntityData$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SplitDeviceStatsConfigEntityData.KClassImpl$Data$declaredNonStaticMembers$2(SplitDeviceStatsConfigEntityData.this, (DeviceStatsConfig) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(map, "");
        }
        Object blockingFirst = map.blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return (DeviceStatsConfig) blockingFirst;
    }

    public static /* synthetic */ DeviceStatsConfig KClassImpl$Data$declaredNonStaticMembers$2(SplitDeviceStatsConfigEntityData splitDeviceStatsConfigEntityData, DeviceStatsConfig deviceStatsConfig) {
        Intrinsics.checkNotNullParameter(splitDeviceStatsConfigEntityData, "");
        Intrinsics.checkNotNullParameter(deviceStatsConfig, "");
        splitDeviceStatsConfigEntityData.getAuthRequestContext = deviceStatsConfig;
        return deviceStatsConfig;
    }

    public static /* synthetic */ DeviceStatsConfig MyBillsEntityDataFactory(SplitDeviceStatsConfigEntityData splitDeviceStatsConfigEntityData, Throwable th) {
        Intrinsics.checkNotNullParameter(splitDeviceStatsConfigEntityData, "");
        Intrinsics.checkNotNullParameter(th, "");
        Boolean bool = Boolean.FALSE;
        return new DeviceStatsConfig(bool, 7, bool, 500000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeviceStatsConfig getAuthRequestContext(SplitDeviceStatsConfigEntityData splitDeviceStatsConfigEntityData, BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(splitDeviceStatsConfigEntityData, "");
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        Boolean bool = Boolean.FALSE;
        Object deviceStatsConfig = new DeviceStatsConfig(bool, 7, bool, 500000);
        String authRequestContext = baseTrafficType.getAuthRequestContext("mixpanel_offline_package_size", false);
        if (DeviceStatsConfig.class.isAssignableFrom(JSONArray.class)) {
            deviceStatsConfig = (DeviceStatsConfig) new JSONArray(authRequestContext != null ? authRequestContext : "");
        } else if (authRequestContext != null) {
            Object obj = null;
            try {
                obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) DeviceStatsConfig.class);
            } catch (Exception unused) {
            }
            if (obj != null) {
                deviceStatsConfig = obj;
            }
        }
        return (DeviceStatsConfig) deviceStatsConfig;
    }
}
