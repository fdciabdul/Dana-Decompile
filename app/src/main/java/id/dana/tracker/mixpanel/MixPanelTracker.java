package id.dana.tracker.mixpanel;

import android.content.Context;
import android.location.Location;
import com.alipay.mobile.common.rpc.RpcException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.analytics.mixpanel.MixPanelEvent;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.DefaultObserver;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.model.CdpContentModel;
import id.dana.model.DisplayedErrorModel;
import id.dana.network.exception.NetworkException;
import id.dana.rum.Rum;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;
import id.dana.utils.LocationUtil;
import id.dana.utils.LocationUtils;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.permission.PermissionHelper;
import org.json.JSONException;
import org.json.JSONObject;
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider;
import pl.charmas.android.reactivelocation2.observables.location.LastKnownLocationObservableOnSubscribe;

/* loaded from: classes.dex */
public class MixPanelTracker {
    private static String KClassImpl$Data$declaredNonStaticMembers$2 = null;
    static String PlaceComponentResult = "";
    private static MixPanelTracker getAuthRequestContext;
    private final DeviceInformationProvider BuiltInFictitiousFunctionClassFactory;
    private final MixpanelRepository MyBillsEntityDataFactory;

    private MixPanelTracker(MixpanelRepository mixpanelRepository, DeviceInformationProvider deviceInformationProvider) {
        this.MyBillsEntityDataFactory = mixpanelRepository;
        this.BuiltInFictitiousFunctionClassFactory = deviceInformationProvider;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MixpanelRepository mixpanelRepository, DeviceInformationProvider deviceInformationProvider, boolean z) {
        MixPanelTracker mixPanelTracker = new MixPanelTracker(mixpanelRepository, deviceInformationProvider);
        getAuthRequestContext = mixPanelTracker;
        if (z) {
            MixpanelRepository mixpanelRepository2 = mixPanelTracker.MyBillsEntityDataFactory;
            if (mixpanelRepository2 != null) {
                mixpanelRepository2.optInTracking();
                return;
            }
            return;
        }
        MixpanelRepository mixpanelRepository3 = mixPanelTracker.MyBillsEntityDataFactory;
        if (mixpanelRepository3 != null) {
            mixpanelRepository3.optOutTracking();
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2, String str3, Throwable th) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(context);
        builder.MyBillsEntityDataFactory = "Displayed Error";
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Operation Type", str).MyBillsEntityDataFactory("Displayed Message", str2).MyBillsEntityDataFactory("Source", str3);
        if (th != null) {
            String message = th.getMessage();
            if (message != null) {
                MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Message", message);
            }
            if (th instanceof NetworkException) {
                NetworkException networkException = (NetworkException) th;
                MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Code", networkException.getErrorCode());
                MyBillsEntityDataFactory.MyBillsEntityDataFactory("Trace ID", networkException.getTraceId());
                String message2 = networkException.getMessage();
                if (message2 != null) {
                    MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Message", message2);
                }
            }
            if (th instanceof RuntimeException) {
                if (th.getCause() instanceof NetworkException) {
                    MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Code", ((NetworkException) th.getCause()).getErrorCode());
                    MyBillsEntityDataFactory.MyBillsEntityDataFactory("Trace ID", ((NetworkException) th.getCause()).getTraceId());
                    String message3 = ((NetworkException) th.getCause()).getMessage();
                    if (message3 != null) {
                        MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Message", message3);
                    }
                } else if (th instanceof RpcException) {
                    RpcException rpcException = (RpcException) th;
                    MyBillsEntityDataFactory.PlaceComponentResult("Error Code", rpcException.getCode());
                    String msg = rpcException.getMsg();
                    if (msg != null) {
                        MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Message", msg);
                    }
                } else if (th instanceof id.dana.data.foundation.RpcException) {
                    id.dana.data.foundation.RpcException rpcException2 = (id.dana.data.foundation.RpcException) th;
                    MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Code", rpcException2.code);
                    String str4 = rpcException2.msg;
                    if (str4 != null) {
                        MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Message", str4);
                    }
                }
            }
        }
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, String str, String str2, String str3, String str4, String str5) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(context);
        builder.MyBillsEntityDataFactory = "Displayed Error";
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Operation Type", str).MyBillsEntityDataFactory("Error Message", str2).MyBillsEntityDataFactory("Displayed Message", str3).MyBillsEntityDataFactory("Source", str4).MyBillsEntityDataFactory("Trace ID", str5);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(context);
        builder.MyBillsEntityDataFactory = "Displayed Error";
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Error Code", str).MyBillsEntityDataFactory("Operation Type", str2).MyBillsEntityDataFactory("Error Message", str3).MyBillsEntityDataFactory("Displayed Message", str4).MyBillsEntityDataFactory("Source", str5).MyBillsEntityDataFactory("Trace ID", str6);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    public static void getAuthRequestContext(Context context, String str, String str2, String str3, int i, Throwable th) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(context);
        builder.MyBillsEntityDataFactory = "Displayed Error";
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Operation Type", str).MyBillsEntityDataFactory("Displayed Message", str2).MyBillsEntityDataFactory("Source", str3);
        if (i > 0) {
            MyBillsEntityDataFactory.PlaceComponentResult(TrackerDataKey.Property.WAITING_TIME, i);
        }
        if (th != null) {
            String message = th.getMessage();
            if (message != null) {
                MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Message", message);
            }
            if (th instanceof NetworkException) {
                NetworkException networkException = (NetworkException) th;
                MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Code", networkException.getErrorCode());
                MyBillsEntityDataFactory.MyBillsEntityDataFactory("Trace ID", networkException.getTraceId());
                String message2 = networkException.getMessage();
                if (message2 != null) {
                    MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Message", message2);
                }
            }
            if ((th instanceof RuntimeException) && (th.getCause() instanceof NetworkException)) {
                MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Code", ((NetworkException) th.getCause()).getErrorCode());
                MyBillsEntityDataFactory.MyBillsEntityDataFactory("Trace ID", ((NetworkException) th.getCause()).getTraceId());
                String message3 = ((NetworkException) th.getCause()).getMessage();
                if (message3 != null) {
                    MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Message", message3);
                }
            }
        }
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, CdpContentModel cdpContentModel, String str, String str2) {
        EventTrackerModel.Builder MyBillsEntityDataFactory = new EventTrackerModel.Builder(context).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_ID, cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda2).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_TYPE, cdpContentModel.DatabaseTableConfigUtil).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_NAME, cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda1);
        if (str2 == null) {
            str2 = "";
        }
        EventTrackerModel.Builder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_SPACE_CODE, str2);
        MyBillsEntityDataFactory2.MyBillsEntityDataFactory = str;
        if (cdpContentModel.PrepareContext != null) {
            MyBillsEntityDataFactory2.MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_EXPIRY_DATE, DateTimeUtil.MyBillsEntityDataFactory(cdpContentModel.PrepareContext, "yyyy-MM-dd'T'HH:mm:ss", LocaleUtil.getAuthRequestContext()));
        }
        MyBillsEntityDataFactory2.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, (byte) 0));
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, boolean z) {
        if (getAuthRequestContext != null) {
            JSONObject jSONObject = new JSONObject();
            getAuthRequestContext(jSONObject, "User Location Permission", Boolean.valueOf(z));
            getAuthRequestContext.getAuthRequestContext(context, jSONObject, true);
        }
    }

    public static void getAuthRequestContext(boolean z) {
        if (getAuthRequestContext != null) {
            JSONObject jSONObject = new JSONObject();
            getAuthRequestContext(jSONObject, TrackerKey.PeopleProperty.DANA_VIZ_STATUS, Boolean.valueOf(z));
            getAuthRequestContext.MyBillsEntityDataFactory.setPeople(jSONObject);
        }
    }

    public static void MyBillsEntityDataFactory(boolean z) {
        if (getAuthRequestContext != null) {
            JSONObject jSONObject = new JSONObject();
            getAuthRequestContext(jSONObject, TrackerKey.PeopleProperty.DANA_VIZ_ENROLL, Boolean.valueOf(z));
            getAuthRequestContext.MyBillsEntityDataFactory.setPeople(jSONObject);
        }
    }

    public static void MyBillsEntityDataFactory(String str) {
        if (getAuthRequestContext != null) {
            JSONObject jSONObject = new JSONObject();
            getAuthRequestContext(jSONObject, "KYC Level", str);
            getAuthRequestContext.MyBillsEntityDataFactory.setPeople(jSONObject);
        }
    }

    public static void PlaceComponentResult(String str) {
        KClassImpl$Data$declaredNonStaticMembers$2 = str;
    }

    public static void PlaceComponentResult() {
        MixPanelTracker mixPanelTracker = getAuthRequestContext;
        if (mixPanelTracker == null || mixPanelTracker.MyBillsEntityDataFactory == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        DeviceInformationProvider deviceInformationProvider = getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
        getAuthRequestContext(jSONObject, "UTDID", deviceInformationProvider == null ? "" : deviceInformationProvider.getDeviceUtdId());
        getAuthRequestContext.MyBillsEntityDataFactory.registerSuperProperties(jSONObject);
    }

    public static void BuiltInFictitiousFunctionClassFactory() {
        MixPanelTracker mixPanelTracker = getAuthRequestContext;
        if (mixPanelTracker == null || mixPanelTracker.MyBillsEntityDataFactory == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        getAuthRequestContext(jSONObject, TrackerDataKey.SuperProperties.SPLUNK_SESSION_ID, Rum.CC.BuiltInFictitiousFunctionClassFactory());
        getAuthRequestContext.MyBillsEntityDataFactory.registerSuperProperties(jSONObject);
    }

    public static void PlaceComponentResult(boolean z) {
        MixPanelTracker mixPanelTracker = getAuthRequestContext;
        if (mixPanelTracker == null || mixPanelTracker.MyBillsEntityDataFactory == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        getAuthRequestContext(jSONObject, TrackerKey.SuperProperties.GPS_STATUS, z ? "ON" : "OFF");
        getAuthRequestContext.MyBillsEntityDataFactory.registerSuperProperties(jSONObject);
    }

    public static String MyBillsEntityDataFactory() {
        MixPanelTracker mixPanelTracker = getAuthRequestContext;
        return mixPanelTracker != null ? mixPanelTracker.MyBillsEntityDataFactory.getDistinctId() : "";
    }

    public static boolean getAuthRequestContext() {
        MixPanelTracker mixPanelTracker = getAuthRequestContext;
        if (mixPanelTracker != null) {
            return mixPanelTracker.MyBillsEntityDataFactory.isAliasExist();
        }
        return false;
    }

    public static void PlaceComponentResult(Context context, String str, String str2) {
        if (getAuthRequestContext != null) {
            MixPanelEvent.Builder builder = new MixPanelEvent.Builder(context);
            builder.BuiltInFictitiousFunctionClassFactory = str;
            builder.MyBillsEntityDataFactory = str2;
            MixPanelEvent mixPanelEvent = new MixPanelEvent(builder, (byte) 0);
            getAuthRequestContext(mixPanelEvent.KClassImpl$Data$declaredNonStaticMembers$2());
            if (getAuthRequestContext != null) {
                String MyBillsEntityDataFactory = mixPanelEvent.MyBillsEntityDataFactory();
                PlaceComponentResult = MyBillsEntityDataFactory;
                getAuthRequestContext.MyBillsEntityDataFactory.setIdentify(MyBillsEntityDataFactory, true);
            }
            KClassImpl$Data$declaredNonStaticMembers$2(mixPanelEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        MixPanelTracker mixPanelTracker = getAuthRequestContext;
        if (mixPanelTracker != null) {
            mixPanelTracker.MyBillsEntityDataFactory.saveAliasExist(true);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str) {
        MixPanelTracker mixPanelTracker = getAuthRequestContext;
        if (mixPanelTracker != null) {
            mixPanelTracker.MyBillsEntityDataFactory.setAlias(str, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext(Context context) {
        if (getAuthRequestContext != null) {
            JSONObject jSONObject = new JSONObject();
            getAuthRequestContext(jSONObject, "User Location Permission", Boolean.valueOf(PermissionHelper.MyBillsEntityDataFactory(context, "android.permission.ACCESS_FINE_LOCATION")));
            getAuthRequestContext(jSONObject, TrackerDataKey.SuperProperties.MIXPANEL_SOURCE, getAuthRequestContext.MyBillsEntityDataFactory.getMixpanelSource());
            getAuthRequestContext(jSONObject, TrackerKey.SuperProperties.GPS_STATUS, LocationUtil.getAuthRequestContext(context) ? "ON" : "OFF");
            getAuthRequestContext.getAuthRequestContext(context, jSONObject, false);
            getAuthRequestContext(jSONObject, TrackerKey.SuperProperties.ENVIRONMENT, "production");
            DeviceInformationProvider deviceInformationProvider = getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
            getAuthRequestContext(jSONObject, "UTDID", deviceInformationProvider == null ? "" : deviceInformationProvider.getDeviceUtdId());
            getAuthRequestContext(jSONObject, TrackerDataKey.SuperProperties.SPLUNK_SESSION_ID, Rum.CC.BuiltInFictitiousFunctionClassFactory());
            getAuthRequestContext.MyBillsEntityDataFactory.registerSuperProperties(jSONObject);
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MixPanelEvent mixPanelEvent) {
        if (getAuthRequestContext != null) {
            JSONObject jSONObject = new JSONObject();
            getAuthRequestContext(jSONObject, "$user_id", mixPanelEvent.MyBillsEntityDataFactory());
            getAuthRequestContext(jSONObject, "KYC Level", mixPanelEvent.BuiltInFictitiousFunctionClassFactory());
            getAuthRequestContext(jSONObject, "User Location Permission", Boolean.valueOf(PermissionHelper.MyBillsEntityDataFactory(mixPanelEvent.KClassImpl$Data$declaredNonStaticMembers$2(), "android.permission.ACCESS_FINE_LOCATION")));
            DeviceInformationProvider deviceInformationProvider = getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
            getAuthRequestContext(jSONObject, "UTDID", deviceInformationProvider == null ? "" : deviceInformationProvider.getDeviceUtdId());
            getAuthRequestContext(jSONObject, TrackerKey.Property.MEDIA_SOURCE, KClassImpl$Data$declaredNonStaticMembers$2);
            getAuthRequestContext.getAuthRequestContext(mixPanelEvent.KClassImpl$Data$declaredNonStaticMembers$2(), jSONObject, false);
            MixPanelTracker mixPanelTracker = getAuthRequestContext;
            if (mixPanelTracker != null) {
                mixPanelTracker.MyBillsEntityDataFactory.setPeople(jSONObject);
            }
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(JSONObject jSONObject) {
        MixPanelTracker mixPanelTracker = getAuthRequestContext;
        if (mixPanelTracker != null) {
            mixPanelTracker.MyBillsEntityDataFactory.setPeopleOnce(jSONObject);
        }
    }

    public static void getAuthRequestContext(JSONObject jSONObject) {
        MixPanelTracker mixPanelTracker = getAuthRequestContext;
        if (mixPanelTracker != null) {
            mixPanelTracker.MyBillsEntityDataFactory.setPeople(jSONObject);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(MixPanelEvent mixPanelEvent) {
        if (getAuthRequestContext != null) {
            String MyBillsEntityDataFactory = mixPanelEvent.MyBillsEntityDataFactory();
            PlaceComponentResult = MyBillsEntityDataFactory;
            getAuthRequestContext.MyBillsEntityDataFactory.setIdentify(MyBillsEntityDataFactory, true);
        }
    }

    public static void getAuthRequestContext(String str) {
        MixpanelRepository mixpanelRepository;
        MixPanelTracker mixPanelTracker = getAuthRequestContext;
        if (mixPanelTracker == null || (mixpanelRepository = mixPanelTracker.MyBillsEntityDataFactory) == null) {
            return;
        }
        mixpanelRepository.startTimer(str);
    }

    private void getAuthRequestContext(Context context, final JSONObject jSONObject, final boolean z) {
        ReactiveLocationProvider reactiveLocationProvider = new LocationUtil.LocationRequestBuilder(context.getApplicationContext()).BuiltInFictitiousFunctionClassFactory;
        LastKnownLocationObservableOnSubscribe.MyBillsEntityDataFactory(reactiveLocationProvider.MyBillsEntityDataFactory, reactiveLocationProvider.KClassImpl$Data$declaredNonStaticMembers$2).subscribe(new DefaultObserver<Location>() { // from class: id.dana.tracker.mixpanel.MixPanelTracker.1
            private Location BuiltInFictitiousFunctionClassFactory = null;

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* bridge */ /* synthetic */ void onNext(Object obj) {
                this.BuiltInFictitiousFunctionClassFactory = (Location) obj;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("on Get Last Known Location Error: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, sb.toString());
                Location location = this.BuiltInFictitiousFunctionClassFactory;
                if (location != null) {
                    MixPanelTracker.PlaceComponentResult(MixPanelTracker.this, jSONObject, location, z);
                }
                dispose();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onComplete() {
                Location location = this.BuiltInFictitiousFunctionClassFactory;
                if (location != null) {
                    MixPanelTracker.PlaceComponentResult(MixPanelTracker.this, jSONObject, location, z);
                }
                dispose();
            }
        });
    }

    private static void getAuthRequestContext(JSONObject jSONObject, String str, Object obj) {
        if (obj == null) {
            obj = "";
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
        }
    }

    static /* synthetic */ void PlaceComponentResult(MixPanelTracker mixPanelTracker, JSONObject jSONObject, Location location, boolean z) {
        if (location != null) {
            Rum.CC.BuiltInFictitiousFunctionClassFactory(location);
        }
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        Double valueOf = Double.valueOf(location == null ? 0.0d : location.getLatitude());
        if (location != null) {
            d = location.getLongitude();
        }
        Double valueOf2 = Double.valueOf(d);
        boolean z2 = location != null && LocationUtils.BuiltInFictitiousFunctionClassFactory(location);
        getAuthRequestContext(jSONObject, TrackerKey.SuperProperties.LATITUDE, valueOf);
        getAuthRequestContext(jSONObject, TrackerKey.SuperProperties.LONGITUDE, valueOf2);
        getAuthRequestContext(jSONObject, TrackerKey.SuperProperties.MIXPANEL_LATITUDE, valueOf);
        getAuthRequestContext(jSONObject, TrackerKey.SuperProperties.MIXPANEL_LONGITUDE, valueOf2);
        getAuthRequestContext(jSONObject, TrackerKey.SuperProperties.LOCATION_MOCKED, Boolean.valueOf(z2));
        MixpanelRepository mixpanelRepository = mixPanelTracker.MyBillsEntityDataFactory;
        if (mixpanelRepository != null) {
            mixpanelRepository.setPeople(jSONObject);
            mixPanelTracker.MyBillsEntityDataFactory.registerSuperProperties(jSONObject);
            if (z) {
                mixPanelTracker.MyBillsEntityDataFactory.track(TrackerKey.Event.LOCATION_PERMISSION, jSONObject);
            }
        }
    }

    public static void getAuthRequestContext(Context context, String str, String str2, DisplayedErrorModel displayedErrorModel) {
        KClassImpl$Data$declaredNonStaticMembers$2(context, displayedErrorModel.PlaceComponentResult, displayedErrorModel.KClassImpl$Data$declaredNonStaticMembers$2, displayedErrorModel.BuiltInFictitiousFunctionClassFactory, str, str2, displayedErrorModel.getAuthRequestContext);
    }
}
