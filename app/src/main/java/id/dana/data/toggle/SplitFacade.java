package id.dana.data.toggle;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.gson.Gson;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.toggle.annotation.Split;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.data.toggle.traffictype.LazyTrafficTypeFactory;
import id.dana.data.toggle.traffictype.TrafficType;
import id.dana.data.util.DateTimeUtil;
import id.dana.domain.extension.ObservableExtKt;
import id.dana.lib.toggle.Deserializer;
import id.dana.lib.toggle.OnConfigUpdateListener;
import id.dana.lib.toggle.ToggleManager;
import id.dana.lib.toggle.ToggleManagerContract;
import id.dana.utils.config.model.Device;
import id.dana.utils.config.model.Display;
import id.dana.utils.config.model.Gps;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import o.A;

@Singleton
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B7\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u001a\u0012\b\b\u0001\u0010%\u001a\u00020\u0015\u0012\b\b\u0001\u0010&\u001a\u00020!\u0012\b\b\u0001\u0010'\u001a\u00020\u001e¢\u0006\u0004\b(\u0010)J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0004\b\u0006\u0010\tJ\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\rH\u0002¢\u0006\u0004\b\n\u0010\u000fJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\f2\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e¢\u0006\u0004\b\u0006\u0010\u0016J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e¢\u0006\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0013\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0014\u0010\u0010\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\u0014\u0010\n\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010 R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#"}, d2 = {"Lid/dana/data/toggle/SplitFacade;", "", "", "p0", "p1", "", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/Object;)V", "", "(Ljava/util/Map;)V", "MyBillsEntityDataFactory", "()V", "T", "Lkotlin/Function0;", "Lio/reactivex/Observable;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory", "(Lkotlin/jvm/functions/Function0;)Lio/reactivex/Observable;", "Landroid/content/res/Configuration;", "getAuthRequestContext", "(Landroid/content/res/Configuration;)V", "Lid/dana/data/toggle/traffictype/BaseTrafficType;", "()Lio/reactivex/Observable;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/data/config/DeviceInformationProvider;", "Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/toggle/traffictype/BaseTrafficType;", "Lid/dana/data/toggle/traffictype/LazyTrafficTypeFactory;", "scheduleImpl", "Lid/dana/data/toggle/traffictype/LazyTrafficTypeFactory;", "getErrorConfigVersion", "p2", "p3", "p4", "<init>", "(Landroid/content/Context;Lid/dana/data/config/DeviceInformationProvider;Lid/dana/data/toggle/traffictype/BaseTrafficType;Lid/dana/data/toggle/traffictype/LazyTrafficTypeFactory;Lid/dana/data/storage/PreferenceFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SplitFacade {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    private static int lookAheadTest = 1;
    private static int moveToNextValue;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final DeviceInformationProvider BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final BaseTrafficType KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Gson MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final PreferenceFacade PlaceComponentResult;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final LazyTrafficTypeFactory getErrorConfigVersion;

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 101;
        lookAheadTest = i % 128;
        if (i % 2 != 0) {
            return;
        }
        int i2 = 62 / 0;
    }

    public static /* synthetic */ BaseTrafficType getAuthRequestContext(SplitFacade splitFacade) {
        int i = lookAheadTest + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        BaseTrafficType PlaceComponentResult = PlaceComponentResult(splitFacade);
        int i3 = lookAheadTest + 105;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
        return PlaceComponentResult;
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(SplitFacade splitFacade, Function0 function0, BaseTrafficType baseTrafficType) {
        int i = lookAheadTest + 15;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        boolean z = i % 2 != 0;
        ObservableSource BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(splitFacade, function0, baseTrafficType);
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(Function0 function0, Boolean bool) {
        int i = lookAheadTest + 33;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        ObservableSource BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(function0, bool);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 43;
        lookAheadTest = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return BuiltInFictitiousFunctionClassFactory;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return BuiltInFictitiousFunctionClassFactory;
    }

    static void getAuthRequestContext() {
        moveToNextValue = 269894789;
    }

    public static /* synthetic */ void getAuthRequestContext(ObservableEmitter observableEmitter) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 61;
            try {
                lookAheadTest = i % 128;
                int i2 = i % 2;
                KClassImpl$Data$declaredNonStaticMembers$2(observableEmitter);
                int i3 = lookAheadTest + 31;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                if ((i3 % 2 != 0 ? '=' : '5') != '=') {
                    return;
                }
                int i4 = 53 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(String str, ObservableEmitter observableEmitter) {
        int i = lookAheadTest + 35;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 != 0 ? (char) 14 : (char) 18) != 14) {
            PlaceComponentResult(str, observableEmitter);
            return;
        }
        try {
            PlaceComponentResult(str, observableEmitter);
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    @Inject
    public SplitFacade(Context context, DeviceInformationProvider deviceInformationProvider, @TrafficType("Device") BaseTrafficType baseTrafficType, @TrafficType("User") LazyTrafficTypeFactory lazyTrafficTypeFactory, @Split PreferenceFacade preferenceFacade) {
        try {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
            Intrinsics.checkNotNullParameter(baseTrafficType, "");
            Intrinsics.checkNotNullParameter(lazyTrafficTypeFactory, "");
            Intrinsics.checkNotNullParameter(preferenceFacade, "");
            this.getAuthRequestContext = context;
            this.BuiltInFictitiousFunctionClassFactory = deviceInformationProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = baseTrafficType;
            this.getErrorConfigVersion = lazyTrafficTypeFactory;
            this.PlaceComponentResult = preferenceFacade;
            this.MyBillsEntityDataFactory = new Gson();
            MyBillsEntityDataFactory();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ Gson BuiltInFictitiousFunctionClassFactory(SplitFacade splitFacade) {
        int i = lookAheadTest + 23;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        try {
            Gson gson = splitFacade.MyBillsEntityDataFactory;
            int i3 = lookAheadTest + 99;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
            return gson;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ PreferenceFacade KClassImpl$Data$declaredNonStaticMembers$2(SplitFacade splitFacade) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 77;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        PreferenceFacade preferenceFacade = splitFacade.PlaceComponentResult;
        int i3 = lookAheadTest + 79;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if ((i3 % 2 != 0 ? '_' : '\\') != '\\') {
            Object obj = null;
            obj.hashCode();
            return preferenceFacade;
        }
        return preferenceFacade;
    }

    private void MyBillsEntityDataFactory() {
        ToggleManager.Builder builder = new ToggleManager.Builder();
        builder.getAuthRequestContext = this.getAuthRequestContext.getApplicationContext();
        String osType = this.BuiltInFictitiousFunctionClassFactory.osType();
        builder.lookAheadTest = osType;
        builder.BuiltInFictitiousFunctionClassFactory.put("os_type", osType);
        StringBuilder sb = new StringBuilder();
        sb.append("Add Attribute os_type, ");
        sb.append(this.BuiltInFictitiousFunctionClassFactory.osType());
        DanaLog.getAuthRequestContext("Split", sb.toString());
        Device device = this.BuiltInFictitiousFunctionClassFactory.getDevice();
        if (device != null) {
            String str = device.GetContactSyncConfig;
            builder.scheduleImpl = str;
            builder.BuiltInFictitiousFunctionClassFactory.put("os_version", str);
            String str2 = device.MyBillsEntityDataFactory;
            builder.PlaceComponentResult = str2;
            builder.BuiltInFictitiousFunctionClassFactory.put("device_id", str2);
            builder.BuiltInFictitiousFunctionClassFactory.put("simulator", Boolean.valueOf(device.getNetworkUserEntityData$$ExternalSyntheticLambda1()));
            builder.BuiltInFictitiousFunctionClassFactory.put("device_brand", device.scheduleImpl);
            builder.BuiltInFictitiousFunctionClassFactory.put("device_model", device.NetworkUserEntityData$$ExternalSyntheticLambda0);
            builder.BuiltInFictitiousFunctionClassFactory.put("device_manufacturer", device.getErrorConfigVersion);
            Object[] objArr = new Object[1];
            a(new char[]{7, 6, 65529, '\n', 65523, 4, 4, 65525, 2, 3, 65533}, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 269, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 11, true, 8 - View.resolveSize(0, 0), objArr);
            builder.BuiltInFictitiousFunctionClassFactory.put(((String) objArr[0]).intern(), device.getAuthRequestContext);
            builder.BuiltInFictitiousFunctionClassFactory.put("timezone", device.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Add Attribute os_version, ");
            sb2.append(device.GetContactSyncConfig);
            DanaLog.getAuthRequestContext("Split", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Add Attribute device_id, ");
            sb3.append(device.MyBillsEntityDataFactory);
            DanaLog.getAuthRequestContext("Split", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Add Attribute simulator, ");
            sb4.append(device.getNetworkUserEntityData$$ExternalSyntheticLambda1());
            DanaLog.getAuthRequestContext("Split", sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Add Attribute device_brand, ");
            sb5.append(device.scheduleImpl);
            DanaLog.getAuthRequestContext("Split", sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Add Attribute device_model, ");
            sb6.append(device.NetworkUserEntityData$$ExternalSyntheticLambda0);
            DanaLog.getAuthRequestContext("Split", sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Add Attribute device_manufacturer, ");
            sb7.append(device.getErrorConfigVersion);
            DanaLog.getAuthRequestContext("Split", sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Add Attribute app_version, ");
            sb8.append(device.getAuthRequestContext);
            DanaLog.getAuthRequestContext("Split", sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append("Add Attribute timezone, ");
            sb9.append(device.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2);
            DanaLog.getAuthRequestContext("Split", sb9.toString());
        }
        Gps gps = this.BuiltInFictitiousFunctionClassFactory.getGps();
        if (gps != null) {
            String str3 = gps.getAuthRequestContext;
            builder.moveToNextValue = str3;
            builder.BuiltInFictitiousFunctionClassFactory.put("longitude", str3);
            String str4 = gps.BuiltInFictitiousFunctionClassFactory;
            builder.getErrorConfigVersion = str4;
            builder.BuiltInFictitiousFunctionClassFactory.put("latitude", str4);
            StringBuilder sb10 = new StringBuilder();
            sb10.append("Add Attribute longitude, ");
            sb10.append(gps.getAuthRequestContext);
            DanaLog.getAuthRequestContext("Split", sb10.toString());
            StringBuilder sb11 = new StringBuilder();
            sb11.append("Add Attribute latitude, ");
            sb11.append(gps.BuiltInFictitiousFunctionClassFactory);
            DanaLog.getAuthRequestContext("Split", sb11.toString());
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 81;
            lookAheadTest = i % 128;
            int i2 = i % 2;
        }
        Display display = this.BuiltInFictitiousFunctionClassFactory.getDisplay();
        if (display != null) {
            builder.BuiltInFictitiousFunctionClassFactory.put("screen_dpi", Integer.valueOf(display.BuiltInFictitiousFunctionClassFactory));
            builder.BuiltInFictitiousFunctionClassFactory.put("screen_width", Integer.valueOf(display.PlaceComponentResult));
            builder.BuiltInFictitiousFunctionClassFactory.put("screen_height", Integer.valueOf(display.MyBillsEntityDataFactory));
            StringBuilder sb12 = new StringBuilder();
            sb12.append("Add Attribute screen_dpi, ");
            sb12.append(display.BuiltInFictitiousFunctionClassFactory);
            DanaLog.getAuthRequestContext("Split", sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append("Add Attribute screen_width, ");
            sb13.append(display.PlaceComponentResult);
            DanaLog.getAuthRequestContext("Split", sb13.toString());
            StringBuilder sb14 = new StringBuilder();
            sb14.append("Add Attribute screen_height, ");
            sb14.append(display.MyBillsEntityDataFactory);
            DanaLog.getAuthRequestContext("Split", sb14.toString());
        }
        builder.BuiltInFictitiousFunctionClassFactory.put("reference_utdid", this.BuiltInFictitiousFunctionClassFactory.getReferenceUtdId());
        builder.BuiltInFictitiousFunctionClassFactory.put("package_name", this.getAuthRequestContext.getPackageName());
        builder.BuiltInFictitiousFunctionClassFactory.put("build_type", "release");
        builder.BuiltInFictitiousFunctionClassFactory.put("code_language", "Java");
        builder.BuiltInFictitiousFunctionClassFactory.put("environment", "prod");
        builder.BuiltInFictitiousFunctionClassFactory.put("app_version_build", Integer.valueOf(Integer.parseInt("2470106")));
        builder.BuiltInFictitiousFunctionClassFactory.put("locale", Locale.getDefault().toString());
        builder.BuiltInFictitiousFunctionClassFactory.put("date_time", Long.valueOf(DateTimeUtil.getCurrentTimeMillis()));
        builder.BuiltInFictitiousFunctionClassFactory.put("active_time", Long.valueOf(DateTimeUtil.INSTANCE.getCurrentActiveTime()));
        StringBuilder sb15 = new StringBuilder();
        sb15.append("Add Attribute reference_utdid, ");
        sb15.append(this.BuiltInFictitiousFunctionClassFactory.getReferenceUtdId());
        DanaLog.getAuthRequestContext("Split", sb15.toString());
        StringBuilder sb16 = new StringBuilder();
        sb16.append("Add Attribute package_name, ");
        sb16.append(this.getAuthRequestContext.getPackageName());
        DanaLog.getAuthRequestContext("Split", sb16.toString());
        DanaLog.getAuthRequestContext("Split", "Add Attribute build_type, release");
        DanaLog.getAuthRequestContext("Split", "Add Attribute code_language, Java");
        DanaLog.getAuthRequestContext("Split", "Add Attribute environment, prod");
        DanaLog.getAuthRequestContext("Split", "Add Attribute app_version_build, 2470106");
        StringBuilder sb17 = new StringBuilder();
        sb17.append("Add Attribute locale, ");
        sb17.append(Locale.getDefault());
        DanaLog.getAuthRequestContext("Split", sb17.toString());
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = new Deserializer() { // from class: id.dana.data.toggle.SplitFacade$initDeviceAttributions$4
            /* JADX WARN: Code restructure failed: missing block: B:8:?, code lost:
            
                throw r8;
             */
            @Override // id.dana.lib.toggle.Deserializer
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final <T> T getAuthRequestContext(java.lang.String r6, java.lang.Class<T> r7, java.lang.Throwable r8) {
                /*
                    r5 = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                    id.dana.analytics.firebase.Crashlytics$Companion r1 = id.dana.analytics.firebase.Crashlytics.INSTANCE
                    id.dana.analytics.firebase.Crashlytics r1 = id.dana.analytics.firebase.Crashlytics.Companion.getAuthRequestContext()
                    java.lang.String r2 = "case"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                    java.lang.String r3 = "FastJSON"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    com.google.firebase.crashlytics.FirebaseCrashlytics r4 = r1.getAuthRequestContext
                    r4.setCustomKey(r2, r3)
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "data: "
                    r2.append(r3)
                    r2.append(r6)
                    java.lang.String r2 = r2.toString()
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                    com.google.firebase.crashlytics.FirebaseCrashlytics r3 = r1.getAuthRequestContext
                    r3.log(r2)
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "class: "
                    r2.append(r3)
                    r2.append(r7)
                    java.lang.String r2 = r2.toString()
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                    com.google.firebase.crashlytics.FirebaseCrashlytics r3 = r1.getAuthRequestContext
                    r3.log(r2)
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                    com.google.firebase.crashlytics.FirebaseCrashlytics r0 = r1.getAuthRequestContext
                    r0.recordException(r8)
                    id.dana.data.toggle.SplitFacade r0 = id.dana.data.toggle.SplitFacade.this     // Catch: java.lang.Exception -> L65
                    com.google.gson.Gson r0 = id.dana.data.toggle.SplitFacade.BuiltInFictitiousFunctionClassFactory(r0)     // Catch: java.lang.Exception -> L65
                    java.lang.Object r6 = r0.fromJson(r6, r7)     // Catch: java.lang.Exception -> L65
                    return r6
                L65:
                    throw r8
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.data.toggle.SplitFacade$initDeviceAttributions$4.getAuthRequestContext(java.lang.String, java.lang.Class, java.lang.Throwable):java.lang.Object");
            }
        };
        builder.MyBillsEntityDataFactory = new ToggleManagerContract() { // from class: id.dana.data.toggle.SplitFacade$initDeviceAttributions$5
            @Override // id.dana.lib.toggle.ToggleManagerContract
            public final String getAuthRequestContext(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (SplitFacade.KClassImpl$Data$declaredNonStaticMembers$2(SplitFacade.this).getString(p0) == null) {
                    SplitFacade.KClassImpl$Data$declaredNonStaticMembers$2(SplitFacade.this).createKey(p0);
                    return "";
                }
                String string = SplitFacade.KClassImpl$Data$declaredNonStaticMembers$2(SplitFacade.this).getString(p0);
                Intrinsics.checkNotNullExpressionValue(string, "");
                return string;
            }

            @Override // id.dana.lib.toggle.ToggleManagerContract
            public final void PlaceComponentResult(String p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                SplitFacade.KClassImpl$Data$declaredNonStaticMembers$2(SplitFacade.this).saveData(p0, p1);
            }
        };
        ToggleManager.KClassImpl$Data$declaredNonStaticMembers$2(ToggleManager.MyBillsEntityDataFactory(), builder);
    }

    public final Observable<BaseTrafficType> PlaceComponentResult() {
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = "DANAID";
            Observable<BaseTrafficType> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.toggle.SplitFacade$$ExternalSyntheticLambda3
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return SplitFacade.getAuthRequestContext(SplitFacade.this);
                }
            });
            Intrinsics.checkNotNullExpressionValue(fromCallable, "");
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            return fromCallable;
        } catch (Exception e) {
            throw e;
        }
    }

    private static final BaseTrafficType PlaceComponentResult(SplitFacade splitFacade) {
        int i = lookAheadTest + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(splitFacade, "");
        BaseTrafficType baseTrafficType = splitFacade.KClassImpl$Data$declaredNonStaticMembers$2;
        try {
            int i3 = lookAheadTest + 87;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
            return baseTrafficType;
        } catch (Exception e) {
            throw e;
        }
    }

    public final Observable<BaseTrafficType> KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = lookAheadTest + 71;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Observable<BaseTrafficType> timeoutForFirstEmit = ObservableExtKt.timeoutForFirstEmit(this.getErrorConfigVersion.getAuthRequestContext(), 10000L);
        int i3 = lookAheadTest + 39;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if ((i3 % 2 != 0 ? 'b' : (char) 23) != 23) {
            Object obj = null;
            obj.hashCode();
            return timeoutForFirstEmit;
        }
        return timeoutForFirstEmit;
    }

    public static void PlaceComponentResult(String p0, Object p1) {
        try {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            StringBuilder sb = new StringBuilder();
            sb.append("Add Attribute ");
            sb.append(p0);
            sb.append(", ");
            sb.append(p1);
            DanaLog.getAuthRequestContext("Split", sb.toString());
            ToggleManager.MyBillsEntityDataFactory().getAuthRequestContext.put(p0, p1);
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 17;
            lookAheadTest = i % 128;
            if ((i % 2 == 0 ? InputCardNumberView.DIVIDER : (char) 31) != 31) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void getAuthRequestContext(Configuration p0) {
        int i = lookAheadTest + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(p0, "");
        String obj = Locale.getDefault().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        PlaceComponentResult("locale", obj);
        try {
            int i3 = lookAheadTest + 103;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final <T> Observable<T> BuiltInFictitiousFunctionClassFactory(final Function0<? extends Observable<T>> p0) {
        try {
            Intrinsics.checkNotNullParameter(p0, "");
            Observable<T> observable = (Observable<T>) this.getErrorConfigVersion.getAuthRequestContext().flatMap(new Function() { // from class: id.dana.data.toggle.SplitFacade$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SplitFacade.getAuthRequestContext(SplitFacade.this, p0, (BaseTrafficType) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(observable, "");
            try {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 81;
                lookAheadTest = i % 128;
                int i2 = i % 2;
                return observable;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final ObservableSource BuiltInFictitiousFunctionClassFactory(SplitFacade splitFacade, Function0 function0, BaseTrafficType baseTrafficType) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 87;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(splitFacade, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        Observable MyBillsEntityDataFactory = MyBillsEntityDataFactory(baseTrafficType.BuiltInFictitiousFunctionClassFactory(), function0);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 23;
        lookAheadTest = i3 % 128;
        if (i3 % 2 != 0) {
            return MyBillsEntityDataFactory;
        }
        int i4 = 67 / 0;
        return MyBillsEntityDataFactory;
    }

    private static <T> Observable<T> MyBillsEntityDataFactory(final String p0, final Function0<? extends Observable<T>> p1) {
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.toggle.SplitFacade$$ExternalSyntheticLambda1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SplitFacade.getAuthRequestContext(p0, observableEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        Observable<T> startWith = create.flatMap(new Function() { // from class: id.dana.data.toggle.SplitFacade$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitFacade.getAuthRequestContext(Function0.this, (Boolean) obj);
            }
        }).startWith((ObservableSource) p1.invoke());
        Intrinsics.checkNotNullExpressionValue(startWith, "");
        int i = lookAheadTest + 79;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        return startWith;
    }

    private static final void PlaceComponentResult(String str, final ObservableEmitter observableEmitter) {
        try {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(observableEmitter, "");
            ToggleManager.MyBillsEntityDataFactory().MyBillsEntityDataFactory(str, new OnConfigUpdateListener() { // from class: id.dana.data.toggle.SplitFacade$$ExternalSyntheticLambda0
                @Override // id.dana.lib.toggle.OnConfigUpdateListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    SplitFacade.getAuthRequestContext(ObservableEmitter.this);
                }
            });
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 97;
            lookAheadTest = i % 128;
            if (i % 2 != 0) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    private static final void KClassImpl$Data$declaredNonStaticMembers$2(ObservableEmitter observableEmitter) {
        int i = lookAheadTest + 25;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 != 0 ? 'C' : '^') == '^') {
            Intrinsics.checkNotNullParameter(observableEmitter, "");
            observableEmitter.onNext(Boolean.TRUE);
            return;
        }
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        observableEmitter.onNext(Boolean.TRUE);
        int i2 = 63 / 0;
    }

    private static final ObservableSource BuiltInFictitiousFunctionClassFactory(Function0 function0, Boolean bool) {
        int i = lookAheadTest + 37;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(bool, "");
        ObservableSource observableSource = (ObservableSource) function0.invoke();
        int i3 = lookAheadTest + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return observableSource;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return observableSource;
    }

    public static void PlaceComponentResult(Map<String, ? extends Object> p0) {
        Iterator<Map.Entry<String, ? extends Object>> it;
        int i = lookAheadTest + 107;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if (!(i % 2 == 0)) {
            try {
                Intrinsics.checkNotNullParameter(p0, "");
                it = p0.entrySet().iterator();
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            Intrinsics.checkNotNullParameter(p0, "");
            it = p0.entrySet().iterator();
        }
        while (it.hasNext()) {
            Map.Entry<String, ? extends Object> next = it.next();
            String key = next.getKey();
            Object value = next.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append("Add Attribute ");
            sb.append(key);
            sb.append(", ");
            sb.append(value);
            DanaLog.getAuthRequestContext("Split", sb.toString());
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
            lookAheadTest = i2 % 128;
            int i3 = i2 % 2;
        }
        ToggleManager.MyBillsEntityDataFactory().getAuthRequestContext.putAll(p0);
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        char[] cArr2;
        A a2 = new A();
        char[] cArr3 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (true) {
            if ((a2.MyBillsEntityDataFactory < i2 ? 'Y' : (char) 22) == 22) {
                break;
            }
            int i4 = $10 + 3;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr3[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i6 = a2.MyBillsEntityDataFactory;
            cArr3[i6] = (char) (cArr3[i6] - ((int) (moveToNextValue ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if ((i3 > 0 ? 'O' : 'X') == 'O') {
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr4 = new char[i2];
            System.arraycopy(cArr3, 0, cArr4, 0, i2);
            System.arraycopy(cArr4, 0, cArr3, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr4, a2.BuiltInFictitiousFunctionClassFactory, cArr3, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
            int i7 = $10 + 5;
            $11 = i7 % 128;
            int i8 = i7 % 2;
        }
        if (z) {
            int i9 = $11 + 23;
            $10 = i9 % 128;
            if ((i9 % 2 != 0 ? '\f' : 'T') != 'T') {
                cArr2 = new char[i2];
                a2.MyBillsEntityDataFactory = 1;
            } else {
                cArr2 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
            }
            while (true) {
                if (a2.MyBillsEntityDataFactory >= i2) {
                    break;
                }
                cArr2[a2.MyBillsEntityDataFactory] = cArr3[(i2 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr3 = cArr2;
        }
        String str = new String(cArr3);
        int i10 = $10 + 111;
        $11 = i10 % 128;
        if (i10 % 2 != 0) {
            objArr[0] = str;
            return;
        }
        int i11 = 98 / 0;
        objArr[0] = str;
    }
}
