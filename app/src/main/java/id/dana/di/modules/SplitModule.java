package id.dana.di.modules;

import android.content.Context;
import com.google.firebase.perf.metrics.Trace;
import dagger.Module;
import dagger.Provides;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.data.BuildConfig;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.data.toggle.annotation.Split;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.data.toggle.traffictype.LazyTrafficTypeFactory;
import id.dana.data.toggle.traffictype.TrafficType;
import id.dana.data.toggle.traffictype.device.TrafficTypeDevice;
import id.dana.data.tracker.MixpanelEntityRepository;
import id.dana.lib.toggle.ToggleClientConfig;
import id.dana.toggle.TrafficTypeUserProxy;
import id.dana.toggle.userloginlogout.LoginLogoutObserver;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\tJ)\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0005\u0010\u000fJ1\u0010\n\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\n\u0010\u0015"}, d2 = {"Lid/dana/di/modules/SplitModule;", "", "Landroid/content/Context;", "p0", "Lid/dana/data/storage/PreferenceFacade;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/lib/toggle/ToggleClientConfig$Builder;", "MyBillsEntityDataFactory", "()Lid/dana/lib/toggle/ToggleClientConfig$Builder;", "PlaceComponentResult", "p1", "Lid/dana/data/tracker/MixpanelEntityRepository;", "p2", "Lid/dana/data/toggle/traffictype/BaseTrafficType;", "(Landroid/content/Context;Lid/dana/lib/toggle/ToggleClientConfig$Builder;Lid/dana/data/tracker/MixpanelEntityRepository;)Lid/dana/data/toggle/traffictype/BaseTrafficType;", "Lid/dana/toggle/userloginlogout/LoginLogoutObserver;", "Lid/dana/data/login/LoginLogoutSubject;", "Lid/dana/data/account/repository/source/preference/PreferenceAccountEntityData;", "p3", "Lid/dana/data/toggle/traffictype/LazyTrafficTypeFactory;", "(Lid/dana/toggle/userloginlogout/LoginLogoutObserver;Lid/dana/data/login/LoginLogoutSubject;Lid/dana/data/account/repository/source/preference/PreferenceAccountEntityData;Lid/dana/data/toggle/traffictype/BaseTrafficType;)Lid/dana/data/toggle/traffictype/LazyTrafficTypeFactory;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes.dex */
public final class SplitModule {
    @Provides
    @Named("SteadyConfig")
    public final ToggleClientConfig.Builder PlaceComponentResult() {
        ToggleClientConfig.Builder builder = new ToggleClientConfig.Builder();
        builder.getAuthRequestContext = 15000;
        builder.BuiltInFictitiousFunctionClassFactory = false;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = 15000;
        Intrinsics.checkNotNullExpressionValue(builder, "");
        return builder;
    }

    @Provides
    @Named("QuickConfig")
    public final ToggleClientConfig.Builder MyBillsEntityDataFactory() {
        ToggleClientConfig.Builder builder = new ToggleClientConfig.Builder();
        builder.getAuthRequestContext = 15000;
        builder.BuiltInFictitiousFunctionClassFactory = false;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = -1;
        Intrinsics.checkNotNullExpressionValue(builder, "");
        return builder;
    }

    @Provides
    @Split
    public final PreferenceFacade KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(p0).setPreferenceGroup("SPLIT_CACHEproduction").setPassword(BuildConfig.SPLIT_KEY_TT_DEVICE)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return new SimpleSecureKeyPreference(createData2);
    }

    @Provides
    @Singleton
    @TrafficType(TrafficType.DEVICE)
    public final BaseTrafficType KClassImpl$Data$declaredNonStaticMembers$2(Context p0, @Named("SteadyConfig") ToggleClientConfig.Builder p1, MixpanelEntityRepository p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        TrafficTypeDevice trafficTypeDevice = new TrafficTypeDevice(p0, p1, BuildConfig.SPLIT_KEY_TT_DEVICE, p2);
        FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2("Split_Initial_Sync");
        trafficTypeDevice.MyBillsEntityDataFactory("DANAID");
        FirebasePerformanceMonitor MyBillsEntityDataFactory = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullParameter("Split_Initial_Sync", "");
        Trace trace = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.get("Split_Initial_Sync");
        if (trace != null) {
            trace.stop();
        }
        return trafficTypeDevice;
    }

    @Provides
    @Singleton
    @TrafficType("User")
    public final LazyTrafficTypeFactory PlaceComponentResult(LoginLogoutObserver p0, LoginLogoutSubject p1, PreferenceAccountEntityData p2, @TrafficType("Device") BaseTrafficType p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        return new TrafficTypeUserProxy(p0, p1, p2, p3);
    }
}
