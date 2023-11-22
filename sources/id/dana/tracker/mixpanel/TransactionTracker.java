package id.dana.tracker.mixpanel;

import android.content.Context;
import id.dana.analytics.mixpanel.MixPanelEvent;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.utils.DateTimeUtil;

/* loaded from: classes5.dex */
public class TransactionTracker {
    private TransactionTracker() {
    }

    public static void PlaceComponentResult(Context context, String str) {
        MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(new MixPanelEvent(new MixPanelEvent.Builder(context).KClassImpl$Data$declaredNonStaticMembers$2("First Transaction Type", str).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.PeopleProperty.FIRST_TRANSACTION_DATE, DateTimeUtil.MyBillsEntityDataFactory()), (byte) 0).getAuthRequestContext());
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        MixPanelTracker.getAuthRequestContext(new MixPanelEvent(new MixPanelEvent.Builder(context).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.PeopleProperty.LAST_TRANSACTION_TYPE, str).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.PeopleProperty.LAST_TRANSACTION_DATE, DateTimeUtil.MyBillsEntityDataFactory()), (byte) 0).getAuthRequestContext());
    }
}
