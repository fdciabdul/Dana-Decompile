package id.dana.tracker.model;

import android.content.Context;
import android.text.TextUtils;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.oauth.OauthLoginManager;
import id.dana.tracker.EventTrackerModel;

/* loaded from: classes5.dex */
public class TrackPinModel {
    public final Context BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String PlaceComponentResult;

    public TrackPinModel(Context context) {
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    public TrackPinModel(Context context, String str) {
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.PlaceComponentResult = str;
    }

    public final EventTrackerModel MyBillsEntityDataFactory() {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this.BuiltInFictitiousFunctionClassFactory);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.PIN_REQUEST;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", TextUtils.isEmpty(this.PlaceComponentResult) ? "" : this.PlaceComponentResult).MyBillsEntityDataFactory("Purpose", TextUtils.isEmpty(this.KClassImpl$Data$declaredNonStaticMembers$2) ? "" : this.KClassImpl$Data$declaredNonStaticMembers$2);
        OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
        if (!OauthLoginManager.scheduleImpl().isEmpty()) {
            OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
            MyBillsEntityDataFactory.MyBillsEntityDataFactory("Merchant Name", OauthLoginManager.scheduleImpl());
        } else {
            MyBillsEntityDataFactory.MyBillsEntityDataFactory("Merchant Name", this.BuiltInFictitiousFunctionClassFactory.getString(R.string.dana_string));
        }
        MyBillsEntityDataFactory.PlaceComponentResult();
        return new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0);
    }
}
