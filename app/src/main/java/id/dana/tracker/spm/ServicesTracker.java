package id.dana.tracker.spm;

import android.content.Context;
import android.text.TextUtils;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.performancetracker.FirstActionEntryPointClickTracker;
import id.dana.performancetracker.IdleTimeUtil;
import id.dana.rum.Rum;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;

/* loaded from: classes5.dex */
public class ServicesTracker {
    private ServicesTracker() {
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2, String str3, String str4) {
        FirstActionEntryPointClickTracker.BuiltInFictitiousFunctionClassFactory();
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(context);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.SERVICE_OPEN;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Service Name", str);
        IdleTimeUtil idleTimeUtil = IdleTimeUtil.INSTANCE;
        EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.IDLE_TIME, IdleTimeUtil.PlaceComponentResult()).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.ROAMING_TIME, FirstActionEntryPointClickTracker.PlaceComponentResult(IdleTimeUtil.MyBillsEntityDataFactory()));
        AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
        EventTrackerModel.Builder MyBillsEntityDataFactory2 = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.TOTAL_TIME, FirstActionEntryPointClickTracker.BuiltInFictitiousFunctionClassFactory(AppReadyMixpanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda0())).MyBillsEntityDataFactory(TrackerKey.ServiceProperty.SERVICE_CATEGORY, str2).MyBillsEntityDataFactory(TrackerKey.ServiceProperty.SERVICE_DIRECT_OPEN, str4);
        if ("service_akulaku".equals(str) && !TextUtils.isEmpty(str3)) {
            MyBillsEntityDataFactory2.MyBillsEntityDataFactory(TrackerKey.ServiceProperty.SERVICE_LINK, str3);
        }
        MyBillsEntityDataFactory2.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, (byte) 0));
        Rum.CC.getAuthRequestContext().getAuthRequestContext(TrackerKey.Event.FIRST_ACTION, Rum.CC.MyBillsEntityDataFactory("operation", TrackerKey.Event.SERVICE_OPEN)).PlaceComponentResult();
    }

    public static void getAuthRequestContext(Context context, String str, String str2, String str3, String str4) {
        FirstActionEntryPointClickTracker.BuiltInFictitiousFunctionClassFactory();
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(context);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.SERVICE_OPEN;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Service Name", str);
        IdleTimeUtil idleTimeUtil = IdleTimeUtil.INSTANCE;
        EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.IDLE_TIME, IdleTimeUtil.PlaceComponentResult()).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.ROAMING_TIME, FirstActionEntryPointClickTracker.PlaceComponentResult(IdleTimeUtil.MyBillsEntityDataFactory()));
        AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
        EventTrackerModel.Builder MyBillsEntityDataFactory2 = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.TOTAL_TIME, FirstActionEntryPointClickTracker.BuiltInFictitiousFunctionClassFactory(AppReadyMixpanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda0())).MyBillsEntityDataFactory(TrackerKey.ServiceProperty.SERVICE_CATEGORY, str2).MyBillsEntityDataFactory(TrackerKey.ServiceProperty.SERVICE_OPEN_SOURCE, TrackerKey.DanaWalletProperties.DANA_WALLET).MyBillsEntityDataFactory(TrackerKey.ServiceProperty.SERVICE_DIRECT_OPEN, str4);
        if ("service_akulaku".equals(str) && !TextUtils.isEmpty(str3)) {
            MyBillsEntityDataFactory2.MyBillsEntityDataFactory(TrackerKey.ServiceProperty.SERVICE_LINK, str3);
        }
        MyBillsEntityDataFactory2.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, (byte) 0));
    }

    public static void MyBillsEntityDataFactory(Context context) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(context);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.ALL_SERVICE_SEARCH_OPEN;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
    }
}
