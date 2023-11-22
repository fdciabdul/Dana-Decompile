package id.dana.tracker.model;

import android.content.Context;
import android.text.TextUtils;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.oauth.OauthLoginManager;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.ChallengeEvent;
import id.dana.tracker.mixpanel.MixPanelTracker;
import javax.annotation.Nullable;

/* loaded from: classes5.dex */
public class TrackOtpModel {
    private Context BuiltInFictitiousFunctionClassFactory;
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;

    public TrackOtpModel(Context context, String str) {
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
    }

    public final EventTrackerModel BuiltInFictitiousFunctionClassFactory(String str, @Nullable String str2) {
        this.MyBillsEntityDataFactory = str;
        MixPanelTracker.getAuthRequestContext(TrackerKey.Event.OTP_INPUT);
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this.BuiltInFictitiousFunctionClassFactory);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.OTP_REQUEST;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", this.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory(ChallengeEvent.Property.OTP_CHANNEL, TextUtils.isEmpty(this.MyBillsEntityDataFactory) ? ChallengeEvent.Channel.SMS : this.MyBillsEntityDataFactory);
        if (str2 != null) {
            MyBillsEntityDataFactory.MyBillsEntityDataFactory(ChallengeEvent.Property.OTP_PURPOSE, str2);
        }
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

    public final EventTrackerModel PlaceComponentResult(@Nullable String str) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this.BuiltInFictitiousFunctionClassFactory);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.OTP_INPUT;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", this.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory(ChallengeEvent.Property.OTP_CHANNEL, TextUtils.isEmpty(this.MyBillsEntityDataFactory) ? ChallengeEvent.Channel.SMS : this.MyBillsEntityDataFactory);
        if (str != null) {
            MyBillsEntityDataFactory.MyBillsEntityDataFactory(ChallengeEvent.Property.OTP_PURPOSE, str);
        }
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

    public final EventTrackerModel BuiltInFictitiousFunctionClassFactory(boolean z, int i, int i2, @Nullable String str) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this.BuiltInFictitiousFunctionClassFactory);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.OTP_COMPLETED;
        EventTrackerModel.Builder PlaceComponentResult = builder.MyBillsEntityDataFactory("Source", this.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory(ChallengeEvent.Property.OTP_CHANNEL, TextUtils.isEmpty(this.MyBillsEntityDataFactory) ? ChallengeEvent.Channel.SMS : this.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory(ChallengeEvent.Property.OTP_SUCCESS, z).PlaceComponentResult(ChallengeEvent.Property.OTP_NUMBER_OF_ATTEMPTS, i + 1).PlaceComponentResult(ChallengeEvent.Property.OTP_NUMBER_OF_REQUESTS, i2);
        if (str != null) {
            PlaceComponentResult.MyBillsEntityDataFactory(ChallengeEvent.Property.OTP_PURPOSE, str);
        }
        OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
        if (!OauthLoginManager.scheduleImpl().isEmpty()) {
            OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
            PlaceComponentResult.MyBillsEntityDataFactory("Merchant Name", OauthLoginManager.scheduleImpl());
        } else {
            PlaceComponentResult.MyBillsEntityDataFactory("Merchant Name", this.BuiltInFictitiousFunctionClassFactory.getString(R.string.dana_string));
        }
        PlaceComponentResult.PlaceComponentResult();
        return new EventTrackerModel(PlaceComponentResult, (byte) 0);
    }
}
