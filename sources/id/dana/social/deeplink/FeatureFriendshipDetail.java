package id.dana.social.deeplink;

import android.app.Activity;
import android.content.Intent;
import id.dana.animation.HomeTabActivity;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.feeds.ui.tracker.FeedsSourceType;
import id.dana.social.model.FeedModel;
import id.dana.social.view.activity.detail.SocialActivityDetail;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ:\u0010\t\u001a\u00020\b2\r\u0010\u0004\u001a\t\u0018\u00010\u0002¢\u0006\u0002\b\u00032\u0019\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0003H\u0087\u0002¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/social/deeplink/FeatureFriendshipDetail;", "", "Landroid/app/Activity;", "Lorg/jetbrains/annotations/NotNull;", "p0", "", "", "p1", "", "MyBillsEntityDataFactory", "(Landroid/app/Activity;Ljava/util/Map;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeatureFriendshipDetail {
    public static final FeatureFriendshipDetail INSTANCE = new FeatureFriendshipDetail();

    private FeatureFriendshipDetail() {
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory(Activity p0, Map<String, String> p1) {
        int i;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String str = p1.get(FeatureParams.FEED_MAINTENANCE);
        boolean parseBoolean = Boolean.parseBoolean(str != null ? StringsKt.trim((CharSequence) str).toString() : null);
        String str2 = p1.get(FeatureParams.FEED_ENABLED);
        if (Boolean.parseBoolean(str2 != null ? StringsKt.trim((CharSequence) str2).toString() : null) && !parseBoolean) {
            String str3 = p1.get("activityID");
            if (str3 == null) {
                str3 = "";
            }
            if (str3.length() == 0) {
                return;
            }
            String str4 = p1.get("commentID");
            String str5 = str4 == null ? "" : str4;
            String str6 = p1.get("source");
            String str7 = p1.get(FeatureParams.FEED_REPLY_COMMENT_ENABLED);
            boolean parseBoolean2 = Boolean.parseBoolean(str7 != null ? StringsKt.trim((CharSequence) str7).toString() : null);
            SocialActivityDetail.Companion companion = SocialActivityDetail.INSTANCE;
            Activity activity = p0;
            FeedModel.Companion companion2 = FeedModel.INSTANCE;
            FeedModel authRequestContext = FeedModel.Companion.getAuthRequestContext(str3);
            String str8 = p1.get(FeatureParams.FEED_ENABLED);
            Intent MyBillsEntityDataFactory = SocialActivityDetail.Companion.MyBillsEntityDataFactory(activity, authRequestContext, str6, str5, true, parseBoolean2, Boolean.parseBoolean(str8 != null ? StringsKt.trim((CharSequence) str8).toString() : null));
            SocialActivityDetail.Companion companion3 = SocialActivityDetail.INSTANCE;
            i = SocialActivityDetail.lookAheadTest;
            p0.startActivityForResult(MyBillsEntityDataFactory, i);
            return;
        }
        Intent intent = new Intent(p0, HomeTabActivity.class);
        intent.putExtra("target", "maintenance");
        intent.putExtra("Source", FeedsSourceType.FEED_DEEPLINK);
        intent.setFlags(536870912);
        p0.startActivity(intent);
    }
}
