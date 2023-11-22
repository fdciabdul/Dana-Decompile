package id.dana.social.mapper;

import android.content.Context;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.social.model.SocialFeedModel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "Landroid/content/Context;", "p0", "Lid/dana/social/model/SocialFeedModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/domain/timeline/model/ActivityResponse;Landroid/content/Context;)Lid/dana/social/model/SocialFeedModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityResponseMapperKt {
    public static final SocialFeedModel BuiltInFictitiousFunctionClassFactory(ActivityResponse activityResponse, Context context) {
        Intrinsics.checkNotNullParameter(activityResponse, "");
        Intrinsics.checkNotNullParameter(context, "");
        String id2 = activityResponse.getId();
        String iconUrl = activityResponse.getIconUrl();
        String content = activityResponse.getContent();
        String redirectType = activityResponse.getRedirectType();
        String redirectValue = activityResponse.getRedirectValue();
        HashMap<String, String> extendInfo = activityResponse.getExtendInfo();
        long createdTime = activityResponse.getCreatedTime();
        return new SocialFeedModel(id2, iconUrl, content, redirectType, redirectValue, extendInfo, Long.valueOf(createdTime), activityResponse.getContentType(), 0, null, 0, 1792, null);
    }
}
