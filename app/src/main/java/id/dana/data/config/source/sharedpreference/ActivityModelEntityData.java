package id.dana.data.config.source.sharedpreference;

import com.alibaba.griver.core.GriverParams;
import com.alipay.mobile.zebra.data.ZebraData;
import id.dana.domain.social.ExtendInfoUtilKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b*\u0010+R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006"}, d2 = {"Lid/dana/data/config/source/sharedpreference/ActivityModelEntityData;", "", "", "activityContent", "Ljava/lang/String;", "getActivityContent", "()Ljava/lang/String;", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "getActivityId", "activityTitle", "getActivityTitle", "actorNickname", "getActorNickname", "", ZebraData.ATTR_CLICKABLE, "Z", "getClickable", "()Z", "content", "getContent", "", "deleteStateKey", "Ljava/lang/Integer;", "getDeleteStateKey", "()Ljava/lang/Integer;", "feedType", "getFeedType", "icon", "getIcon", GriverParams.ShareParams.IMAGE_URL, "getImageUrl", "redirectUrl", "getRedirectUrl", "targetNickname", "getTargetNickname", "", "time", "Ljava/lang/Long;", "getTime", "()Ljava/lang/Long;", "verb", "getVerb", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ActivityModelEntityData {
    private final String activityContent;
    private final String activityId;
    private final String activityTitle;
    private final String actorNickname;
    private final boolean clickable;
    private final String content;
    private final Integer deleteStateKey;
    private final String feedType;
    private final String icon;
    private final String imageUrl;
    private final String redirectUrl;
    private final String targetNickname;
    private final Long time;
    private final String verb;

    public ActivityModelEntityData(String str, String str2, String str3, String str4, boolean z, String str5, Integer num, String str6, String str7, String str8, String str9, String str10, Long l, String str11) {
        this.activityContent = str;
        this.activityId = str2;
        this.activityTitle = str3;
        this.actorNickname = str4;
        this.clickable = z;
        this.content = str5;
        this.deleteStateKey = num;
        this.feedType = str6;
        this.icon = str7;
        this.imageUrl = str8;
        this.redirectUrl = str9;
        this.targetNickname = str10;
        this.time = l;
        this.verb = str11;
    }

    @JvmName(name = "getActivityContent")
    public final String getActivityContent() {
        return this.activityContent;
    }

    @JvmName(name = "getActivityId")
    public final String getActivityId() {
        return this.activityId;
    }

    @JvmName(name = "getActivityTitle")
    public final String getActivityTitle() {
        return this.activityTitle;
    }

    @JvmName(name = "getActorNickname")
    public final String getActorNickname() {
        return this.actorNickname;
    }

    @JvmName(name = "getClickable")
    public final boolean getClickable() {
        return this.clickable;
    }

    @JvmName(name = "getContent")
    public final String getContent() {
        return this.content;
    }

    @JvmName(name = "getDeleteStateKey")
    public final Integer getDeleteStateKey() {
        return this.deleteStateKey;
    }

    @JvmName(name = "getFeedType")
    public final String getFeedType() {
        return this.feedType;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }

    @JvmName(name = "getImageUrl")
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "getTargetNickname")
    public final String getTargetNickname() {
        return this.targetNickname;
    }

    @JvmName(name = "getTime")
    public final Long getTime() {
        return this.time;
    }

    @JvmName(name = "getVerb")
    public final String getVerb() {
        return this.verb;
    }
}
