package id.dana.feeds.ui.tracker;

import android.content.Context;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.feeds.ui.model.FeedTrackerModel;
import id.dana.network.exception.NetworkException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J/\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0005\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0011J?\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0007\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u0011J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0010\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0006J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0011J%\u0010\u0015\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u001fR\u0011\u0010\u0010\u001a\u00020 X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010!"}, d2 = {"Lid/dana/feeds/ui/tracker/FriendshipMixpanelTracker;", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "getAuthRequestContext", "", "p1", "p2", "p3", "MyBillsEntityDataFactory", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "(Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "p4", "p5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "scheduleImpl", "Lid/dana/feeds/ui/model/FeedTrackerModel;", "(Lid/dana/feeds/ui/model/FeedTrackerModel;)V", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "getErrorConfigVersion", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;", "Landroid/content/Context;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendshipMixpanelTracker implements FriendshipAnalyticTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Context KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public FriendshipMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void moveToNextValue(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_SET_BLOCK, BuiltInFictitiousFunctionClassFactory(new JSONObject(), FeedsProperty.IS_BLOCKED, String.valueOf(!Intrinsics.areEqual(p0, "ACTIVE"))));
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_EMOJI_ADD, BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory(new JSONObject(), FeedsProperty.EMOJI_CONTENT_TYPE, p0), FeedsProperty.EMOJI_TYPE, p1));
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void getErrorConfigVersion(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_SET_MUTE, BuiltInFictitiousFunctionClassFactory(new JSONObject(), FeedsProperty.IS_MUTED, String.valueOf(!Intrinsics.areEqual(p0, "ACTIVE"))));
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_SET_PRIVACY, BuiltInFictitiousFunctionClassFactory(new JSONObject(), FeedsProperty.IS_SHARED_TO_FRIEND, String.valueOf(p0)));
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, String p3, String p4, String p5) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        Intrinsics.checkNotNullParameter(p5, "");
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, p3, BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory(new JSONObject(), TrackerDataKey.NotificationInboxProperty.NOTIFICATION_ID, p0), TrackerDataKey.NotificationInboxProperty.REDIRECT_TYPE, p1), TrackerDataKey.NotificationInboxProperty.REDIRECT_VALUE, p2), Intrinsics.areEqual(p3, "Notification Inbox Read") ? "Content Type" : FeedsProperty.FEED_CONTENT_TYPE, p4), TrackerDataKey.NotificationInboxProperty.USECASE_TYPE, p5));
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_ACTIVITY_OPEN, BuiltInFictitiousFunctionClassFactory(new JSONObject(), "Source", p0));
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0.length() > 0) {
            MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_FEEDS_COMMENT_ADD, BuiltInFictitiousFunctionClassFactory(new JSONObject(), FeedsProperty.COMMENT_CONTENT_TYPE, p0));
        }
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0.length() > 0) {
            MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_FEEDS_REPLY_COMMENT_ADD, BuiltInFictitiousFunctionClassFactory(new JSONObject(), FeedsProperty.COMMENT_CONTENT_TYPE, p0));
        }
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void PlaceComponentResult(boolean p0) {
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_ACTIVATE, BuiltInFictitiousFunctionClassFactory(new JSONObject(), FeedsProperty.FEED_STATUS, p0 ? FeedStatusType.ACTIVATE : FeedStatusType.REACTIVATE));
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void scheduleImpl(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_FEED_ACTIVITY_SUBMIT, BuiltInFictitiousFunctionClassFactory(new JSONObject(), FeedsProperty.FEED_CONTENT_TYPE, p0));
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void lookAheadTest(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_FRIEND_ADD, BuiltInFictitiousFunctionClassFactory(new JSONObject(), "Source", p0));
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_ACCEPT_REQUEST, BuiltInFictitiousFunctionClassFactory(new JSONObject(), "Source", p0));
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_DECLINE_REQUEST, BuiltInFictitiousFunctionClassFactory(new JSONObject(), "Source", p0));
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void MyBillsEntityDataFactory(Throwable p0, String p1, String p2, String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        JSONObject jSONObject = new JSONObject();
        BuiltInFictitiousFunctionClassFactory(jSONObject, "Source", p3);
        BuiltInFictitiousFunctionClassFactory(jSONObject, "Displayed Message", p2);
        BuiltInFictitiousFunctionClassFactory(jSONObject, "Operation Type", p1);
        String message = p0.getMessage();
        BuiltInFictitiousFunctionClassFactory(jSONObject, "Error Message", message != null ? message : "");
        if (p0 instanceof NetworkException) {
            NetworkException networkException = (NetworkException) p0;
            BuiltInFictitiousFunctionClassFactory(jSONObject, "Error Code", networkException.getErrorCode());
            BuiltInFictitiousFunctionClassFactory(jSONObject, "Trace ID", networkException.getTraceId());
        }
        Unit unit = Unit.INSTANCE;
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, "Displayed Error", jSONObject);
    }

    private static JSONObject BuiltInFictitiousFunctionClassFactory(JSONObject jSONObject, String str, String str2) {
        String str3 = str2;
        if (!(str3 == null || str3.length() == 0)) {
            jSONObject.put(str, str2);
        }
        return jSONObject;
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void PlaceComponentResult() {
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_DEACTIVATE, new JSONObject());
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_FRIEND_PROFILE_OPEN, new JSONObject());
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void getAuthRequestContext(FeedTrackerModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        KClassImpl$Data$declaredNonStaticMembers$2(p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.PlaceComponentResult, p0.getAuthRequestContext, FeedsEvent.FRIENDSHIP_FEEDS_READ, p0.BuiltInFictitiousFunctionClassFactory, p0.MyBillsEntityDataFactory);
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory() {
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_FRIEND_SEARCH_OPEN, new JSONObject());
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void MyBillsEntityDataFactory() {
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_NOTIFICATION_OPEN, new JSONObject());
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0(String p0) {
        if (p0 != null) {
            MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, TrackerDataKey.Event.INBOX_PAGE_OPEN, BuiltInFictitiousFunctionClassFactory(new JSONObject(), "Source", p0));
        }
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(FeedTrackerModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        KClassImpl$Data$declaredNonStaticMembers$2(p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.PlaceComponentResult, p0.getAuthRequestContext, "Notification Inbox Read", p0.BuiltInFictitiousFunctionClassFactory, p0.MyBillsEntityDataFactory);
    }

    @Override // id.dana.feeds.ui.tracker.FriendshipAnalyticTracker
    public final void getAuthRequestContext() {
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, FeedsEvent.FRIENDSHIP_INTRODUCTION_OPEN, new JSONObject());
    }
}
