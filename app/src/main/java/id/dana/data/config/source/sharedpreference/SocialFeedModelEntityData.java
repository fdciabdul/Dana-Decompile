package id.dana.data.config.source.sharedpreference;

import id.dana.danah5.share.ShareToFeedBridge;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012,\b\u0002\u0010\u0015\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0013j\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\u0014\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR>\u0010\u0015\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0013j\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001e\u0010\u000bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000bR\u001c\u0010!\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b\"\u0010\u000bR\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006"}, d2 = {"Lid/dana/data/config/source/sharedpreference/SocialFeedModelEntityData;", "", "", "actorCount", "Ljava/lang/Integer;", "getActorCount", "()Ljava/lang/Integer;", "", "contentType", "Ljava/lang/String;", "getContentType", "()Ljava/lang/String;", "", "createdTime", "Ljava/lang/Long;", "getCreatedTime", "()Ljava/lang/Long;", "description", "getDescription", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extendInfo", "Ljava/util/HashMap;", "getExtendInfo", "()Ljava/util/HashMap;", "iconUrl", "getIconUrl", "iconUrl2", "getIconUrl2", "id", "getId", "redirectType", "getRedirectType", ShareToFeedBridge.REDIRECT_VALUE, "getRedirectValue", "viewType", "getViewType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SocialFeedModelEntityData {
    public Integer actorCount;
    public String contentType;
    public Long createdTime;
    public String description;
    public HashMap<String, String> extendInfo;
    public String iconUrl;
    public String iconUrl2;
    public String id;
    public String redirectType;
    public String redirectValue;
    public Integer viewType;

    public SocialFeedModelEntityData() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public SocialFeedModelEntityData(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap, Long l, String str6, Integer num, String str7, Integer num2) {
        this.id = str;
        this.iconUrl = str2;
        this.description = str3;
        this.redirectType = str4;
        this.redirectValue = str5;
        this.extendInfo = hashMap;
        this.createdTime = l;
        this.contentType = str6;
        this.actorCount = num;
        this.iconUrl2 = str7;
        this.viewType = num2;
    }

    public /* synthetic */ SocialFeedModelEntityData(String str, String str2, String str3, String str4, String str5, HashMap hashMap, Long l, String str6, Integer num, String str7, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : hashMap, (i & 64) != 0 ? null : l, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : str7, (i & 1024) == 0 ? num2 : null);
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "getRedirectType")
    public final String getRedirectType() {
        return this.redirectType;
    }

    @JvmName(name = "getRedirectValue")
    public final String getRedirectValue() {
        return this.redirectValue;
    }

    @JvmName(name = "getExtendInfo")
    public final HashMap<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getCreatedTime")
    public final Long getCreatedTime() {
        return this.createdTime;
    }

    @JvmName(name = "getContentType")
    public final String getContentType() {
        return this.contentType;
    }

    @JvmName(name = "getActorCount")
    public final Integer getActorCount() {
        return this.actorCount;
    }

    @JvmName(name = "getIconUrl2")
    public final String getIconUrl2() {
        return this.iconUrl2;
    }

    @JvmName(name = "getViewType")
    public final Integer getViewType() {
        return this.viewType;
    }
}
