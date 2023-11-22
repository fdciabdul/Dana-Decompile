package id.dana.tracker;

import android.content.Context;
import id.dana.analytics.firebase.FirebaseAnalyticsEvent;
import id.dana.analytics.mixpanel.MixPanelEvent;
import id.dana.analytics.tracker.EventStrategy;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.constants.AnalyticEventConstant;
import id.dana.tracker.appsflyer.AppsflyerEvent;
import id.dana.tracker.branch.BranchEventStrategy;
import id.dana.tracker.constant.TrackerType;
import id.dana.utils.JSONUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class EventFactory {
    private EventFactory() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static List<EventStrategy> getAuthRequestContext(Context context, String str, EventPropertiesModel eventPropertiesModel) {
        char c;
        char c2;
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        byte b = 0;
        switch (str.hashCode()) {
            case -1811999097:
                if (str.equals(TrackerKey.Event.SPLASH)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1161171580:
                if (str.equals(TrackerKey.Event.PAY_QR_RESULT)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -594018245:
                if (str.equals(TrackerKey.Event.REQUEST_MONEY_OPEN)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 599603983:
                if (str.equals(AnalyticEventConstant.AE_UNSAFE_DEVICE)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1920498033:
                if (str.equals(TrackerKey.Event.PAY_QR_OPEN)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            arrayList2.add(TrackerType.APPSFLYER);
            arrayList2.add("firebase");
            arrayList2.add(TrackerType.BRANCH);
        } else {
            arrayList2.add(TrackerType.MIXPANEL);
        }
        for (String str2 : arrayList2) {
            switch (str2.hashCode()) {
                case -1381030494:
                    if (str2.equals(TrackerType.BRANCH)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1066664664:
                    if (str2.equals(TrackerType.MIXPANEL)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -563351033:
                    if (str2.equals("firebase")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 770434801:
                    if (str2.equals(TrackerType.APPSFLYER)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                arrayList.add(new AppsflyerEvent(context, str, JSONUtil.getAuthRequestContext(eventPropertiesModel.MyBillsEntityDataFactory)));
            } else if (c2 == 1) {
                arrayList.add(new FirebaseAnalyticsEvent(context, str, JSONUtil.KClassImpl$Data$declaredNonStaticMembers$2(eventPropertiesModel.MyBillsEntityDataFactory)));
            } else if (c2 == 2) {
                arrayList.add(new BranchEventStrategy(context, str, JSONUtil.getAuthRequestContext(eventPropertiesModel.MyBillsEntityDataFactory)));
            } else {
                MixPanelEvent.Builder builder = new MixPanelEvent.Builder(context);
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = str;
                builder.getAuthRequestContext = eventPropertiesModel.MyBillsEntityDataFactory;
                arrayList.add(new MixPanelEvent(builder, b));
            }
        }
        return arrayList;
    }
}
