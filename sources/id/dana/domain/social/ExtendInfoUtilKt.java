package id.dana.domain.social;

import com.alibaba.griver.core.GriverParams;
import id.dana.danah5.constant.BridgeName;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.utils.extension.JSONExtKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\"\u001aK\u0010\u0007\u001a\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022*\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0004j\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u0001`\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a[\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u0005*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u00052\u0006\u0010\t\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001aQ\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u0005*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u0005¢\u0006\u0004\b\f\u0010\r\u001a3\u0010\u000e\u001a\u0004\u0018\u00010\u0000*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u0005¢\u0006\u0004\b\u000e\u0010\u000f\u001a1\u0010\u0010\u001a\u00020\u0000*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u0005¢\u0006\u0004\b\u0010\u0010\u000f\u001a9\u0010\u0011\u001a\u00020\u0000*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u00052\u0006\u0010\t\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a9\u0010\u0013\u001a\u00020\u0000*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u00052\u0006\u0010\t\u001a\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0012\u001a1\u0010\u0014\u001a\u00020\u0000*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u0005¢\u0006\u0004\b\u0014\u0010\u000f\u001a1\u0010\u0015\u001a\u00020\u0000*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u0005¢\u0006\u0004\b\u0015\u0010\u000f\u001a1\u0010\u0016\u001a\u00020\u0000*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u0005¢\u0006\u0004\b\u0016\u0010\u000f\u001aY\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u0005*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u00052\u0006\u0010\t\u001a\u00020\u0000¢\u0006\u0004\b\u0017\u0010\u000b\u001a1\u0010\u0018\u001a\u00020\u0000*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u0005¢\u0006\u0004\b\u0018\u0010\u000f\u001a1\u0010\u0019\u001a\u00020\u0000*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u0005¢\u0006\u0004\b\u0019\u0010\u000f\u001a1\u0010\u001a\u001a\u00020\u0000*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u0005¢\u0006\u0004\b\u001a\u0010\u000f\u001a1\u0010\u001b\u001a\u00020\u0000*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u0005¢\u0006\u0004\b\u001b\u0010\u000f\u001a1\u0010\u001c\u001a\u00020\u0000*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u0005¢\u0006\u0004\b\u001c\u0010\u000f\u001aY\u0010\u001f\u001a\u00020\u001e*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u00052&\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u0005¢\u0006\u0004\b\u001f\u0010 \u001a9\u0010\"\u001a\u00020\u001e*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u00052\u0006\u0010!\u001a\u00020\u0000¢\u0006\u0004\b\"\u0010#\u001a9\u0010%\u001a\u00020\u001e*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u00052\u0006\u0010$\u001a\u00020\u0000¢\u0006\u0004\b%\u0010#\u001a9\u0010'\u001a\u00020\u001e*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u00052\u0006\u0010&\u001a\u00020\u0000¢\u0006\u0004\b'\u0010#\u001a9\u0010)\u001a\u00020\u001e*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u00052\u0006\u0010(\u001a\u00020\u0000¢\u0006\u0004\b)\u0010#\u001aQ\u0010.\u001a\u00020\u001e*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u00052\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0000¢\u0006\u0004\b.\u0010/\u001a9\u00100\u001a\u00020\u001e*\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000`\u00052\u0006\u0010,\u001a\u00020\u0000¢\u0006\u0004\b0\u0010#\"\u0014\u00101\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u00102\"\u0014\u00103\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u00102\"\u0014\u00104\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u00102\"\u0014\u00105\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u00102\"\u0014\u00106\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u00102\"\u0014\u00107\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u00102\"\u0014\u00108\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u00102\"\u0014\u00109\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u0010:\"\u0014\u0010;\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u00102\"\u0014\u0010<\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u00102\"\u0014\u0010=\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u00102\"\u0014\u0010>\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u00102\"\u0014\u0010?\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u00102\"\u0014\u0010@\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u00102"}, d2 = {"", GriverParams.ShareParams.IMAGE_URL, "", "type", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extendInfo", "getAvatar", "(Ljava/lang/String;ILjava/util/HashMap;)Ljava/lang/String;", "key", "convertJson", "(Ljava/util/HashMap;Ljava/lang/String;)Ljava/util/HashMap;", "getActorMap", "(Ljava/util/HashMap;)Ljava/util/HashMap;", "getContentCode", "(Ljava/util/HashMap;)Ljava/lang/String;", "getDisplayName", "getDisplayNameEn", "(Ljava/util/HashMap;Ljava/lang/String;)Ljava/lang/String;", "getDisplayNameId", "getFeedNotificationRelatedActivity", "getFeedNotificationRelatedComment", "getHeaderName", "getKeyMap", "getNickName", "getProfileAvatar", "getShareFeedRequestId", "getUserId", BridgeName.GET_USERNAME, "actorMap", "", "setActorMap", "(Ljava/util/HashMap;Ljava/util/HashMap;)V", "nickname", "setActorNickname", "(Ljava/util/HashMap;Ljava/lang/String;)V", ExtendInfoUtilKt.DISPLAY_NAME_KEY, "setDisplayName", ExtendInfoUtilKt.HEADER_NAME_KEY, "setHeaderName", ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID, "setShareFeedRequestId", "userId", AccountEntityRepository.UpdateType.AVATAR, "username", "name", "setUserInfo", "(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "setUsername", "ACTOR_KEY", "Ljava/lang/String;", "CONTENT_CODE", "DISPLAY_NAME_EN_KEY", "DISPLAY_NAME_ID_KEY", "DISPLAY_NAME_KEY", "EXTEND_INFO_ACTIVITY_ID", "EXTEND_INFO_REACTION_ID", "FEED_FRIEND", "I", "HEADER_NAME_KEY", "NICKNAME_KEY", "PROFILE_AVATAR_KEY", "SHARE_FEED_REQUEST_ID", "USERNAME_KEY", "USER_ID_KEY"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExtendInfoUtilKt {
    public static final String ACTOR_KEY = "actor";
    public static final String CONTENT_CODE = "contentCode";
    public static final String DISPLAY_NAME_EN_KEY = "displayNameEN";
    public static final String DISPLAY_NAME_ID_KEY = "displayNameID";
    public static final String DISPLAY_NAME_KEY = "displayName";
    public static final String EXTEND_INFO_ACTIVITY_ID = "activityId";
    public static final String EXTEND_INFO_REACTION_ID = "reactionId";
    public static final int FEED_FRIEND = 9;
    public static final String HEADER_NAME_KEY = "headerName";
    public static final String NICKNAME_KEY = "nickname";
    public static final String PROFILE_AVATAR_KEY = "profilePictureUrl";
    public static final String SHARE_FEED_REQUEST_ID = "shareFeedRequestId";
    public static final String USERNAME_KEY = "username";
    public static final String USER_ID_KEY = "id";

    public static final void setActorNickname(HashMap<String, String> hashMap, String str) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        Intrinsics.checkNotNullParameter(str, "");
        HashMap<String, String> actorMap = getActorMap(hashMap);
        actorMap.put("nickname", str);
        setActorMap(hashMap, actorMap);
    }

    public static final void setUserInfo(HashMap<String, String> hashMap, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        HashMap<String, String> actorMap = getActorMap(hashMap);
        HashMap<String, String> hashMap2 = actorMap;
        hashMap2.put("id", str);
        hashMap2.put(PROFILE_AVATAR_KEY, str2);
        hashMap2.put("username", str3);
        hashMap2.put("nickname", str4);
        setActorMap(hashMap, actorMap);
    }

    public static final void setDisplayName(HashMap<String, String> hashMap, String str) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        Intrinsics.checkNotNullParameter(str, "");
        HashMap<String, String> actorMap = getActorMap(hashMap);
        actorMap.put(DISPLAY_NAME_KEY, str);
        setActorMap(hashMap, actorMap);
    }

    public static final String getNickName(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        String str = getActorMap(hashMap).get("nickname");
        return str == null ? "" : str;
    }

    public static final String getDisplayName(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        String str = getActorMap(hashMap).get(DISPLAY_NAME_KEY);
        return str == null ? "" : str;
    }

    public static final String getDisplayNameEn(HashMap<String, String> hashMap, String str) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        Intrinsics.checkNotNullParameter(str, "");
        String str2 = getKeyMap(hashMap, str).get(DISPLAY_NAME_EN_KEY);
        return str2 == null ? "" : str2;
    }

    public static final String getDisplayNameId(HashMap<String, String> hashMap, String str) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        Intrinsics.checkNotNullParameter(str, "");
        String str2 = getKeyMap(hashMap, str).get(DISPLAY_NAME_ID_KEY);
        return str2 == null ? "" : str2;
    }

    public static final void setUsername(HashMap<String, String> hashMap, String str) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        Intrinsics.checkNotNullParameter(str, "");
        getActorMap(hashMap).put("username", str);
    }

    public static final String getUsername(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        String str = getActorMap(hashMap).get("username");
        return str == null ? "" : str;
    }

    public static final String getProfileAvatar(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        String str = getActorMap(hashMap).get(PROFILE_AVATAR_KEY);
        return str == null ? "" : str;
    }

    public static final String getUserId(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        String str = getActorMap(hashMap).get("id");
        return str == null ? "" : str;
    }

    public static final HashMap<String, String> getActorMap(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        return convertJson(hashMap, ACTOR_KEY);
    }

    public static final HashMap<String, String> getKeyMap(HashMap<String, String> hashMap, String str) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        Intrinsics.checkNotNullParameter(str, "");
        return convertJson(hashMap, str);
    }

    private static final HashMap<String, String> convertJson(HashMap<String, String> hashMap, String str) {
        try {
            HashMap<String, String> hashMap2 = (HashMap) JSONExtKt.PlaceComponentResult().fromJson(hashMap.get(str), (Class) new HashMap().getClass());
            return hashMap2 == null ? new HashMap<>() : hashMap2;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }

    public static final String getContentCode(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        return hashMap.get("contentCode");
    }

    public static final void setActorMap(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        Intrinsics.checkNotNullParameter(hashMap2, "");
        hashMap.put(ACTOR_KEY, JSONExtKt.PlaceComponentResult().toJson(hashMap2));
    }

    public static final String getAvatar(String str, int i, HashMap<String, String> hashMap) {
        if (i == 9) {
            str = hashMap != null ? getProfileAvatar(hashMap) : null;
        }
        return str == null ? "" : str;
    }

    public static final String getFeedNotificationRelatedActivity(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        String str = hashMap.get(EXTEND_INFO_ACTIVITY_ID);
        return str == null ? "" : str;
    }

    public static final String getFeedNotificationRelatedComment(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        String str = hashMap.get(EXTEND_INFO_REACTION_ID);
        return str == null ? "" : str;
    }

    public static final String getHeaderName(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        String str = getActorMap(hashMap).get(HEADER_NAME_KEY);
        return str == null ? "" : str;
    }

    public static final void setHeaderName(HashMap<String, String> hashMap, String str) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        Intrinsics.checkNotNullParameter(str, "");
        HashMap<String, String> actorMap = getActorMap(hashMap);
        actorMap.put(HEADER_NAME_KEY, str);
        setActorMap(hashMap, actorMap);
    }

    public static final void setShareFeedRequestId(HashMap<String, String> hashMap, String str) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        Intrinsics.checkNotNullParameter(str, "");
        hashMap.put(SHARE_FEED_REQUEST_ID, str);
    }

    public static final String getShareFeedRequestId(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        String str = hashMap.get(SHARE_FEED_REQUEST_ID);
        return str == null ? "" : str;
    }
}
