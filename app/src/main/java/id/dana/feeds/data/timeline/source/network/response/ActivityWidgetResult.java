package id.dana.feeds.data.timeline.source.network.response;

import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.feeds.domain.timeline.model.ActivityWidget;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012,\b\u0002\u0010\b\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u0007¢\u0006\u0004\b\u001f\u0010 J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R;\u0010\b\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u00078\u0007¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/feeds/data/timeline/source/network/response/ActivityWidgetResult;", "", "Lid/dana/feeds/domain/timeline/model/ActivityWidget;", "toActivityWidget", "()Lid/dana/feeds/domain/timeline/model/ActivityWidget;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "extendInfo", "Ljava/util/HashMap;", "getExtendInfo", "()Ljava/util/HashMap;", "iconUrl", "Ljava/lang/String;", "getIconUrl", "()Ljava/lang/String;", "redirectType", "getRedirectType", ShareToFeedBridge.REDIRECT_VALUE, "getRedirectValue", "subtitleType", "getSubtitleType", "subtitleValue", "getSubtitleValue", "title", "getTitle", "", "uniqueValue", "Ljava/lang/Boolean;", "getUniqueValue", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/HashMap;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityWidgetResult {
    private final HashMap<String, Object> extendInfo;
    private final String iconUrl;
    private final String redirectType;
    private final String redirectValue;
    private final String subtitleType;
    private final String subtitleValue;
    private final String title;
    private final Boolean uniqueValue;

    public ActivityWidgetResult() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public ActivityWidgetResult(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, HashMap<String, Object> hashMap) {
        this.title = str;
        this.subtitleType = str2;
        this.subtitleValue = str3;
        this.iconUrl = str4;
        this.redirectType = str5;
        this.redirectValue = str6;
        this.uniqueValue = bool;
        this.extendInfo = hashMap;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getSubtitleType")
    public final String getSubtitleType() {
        return this.subtitleType;
    }

    @JvmName(name = "getSubtitleValue")
    public final String getSubtitleValue() {
        return this.subtitleValue;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "getRedirectType")
    public final String getRedirectType() {
        return this.redirectType;
    }

    @JvmName(name = "getRedirectValue")
    public final String getRedirectValue() {
        return this.redirectValue;
    }

    public /* synthetic */ ActivityWidgetResult(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, HashMap hashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) == 0 ? str6 : "", (i & 64) != 0 ? Boolean.FALSE : bool, (i & 128) != 0 ? null : hashMap);
    }

    @JvmName(name = "getUniqueValue")
    public final Boolean getUniqueValue() {
        return this.uniqueValue;
    }

    @JvmName(name = "getExtendInfo")
    public final HashMap<String, Object> getExtendInfo() {
        return this.extendInfo;
    }

    public final ActivityWidget toActivityWidget() {
        String str = this.title;
        String str2 = str == null ? "" : str;
        String str3 = this.subtitleType;
        String str4 = str3 == null ? "" : str3;
        String str5 = this.subtitleValue;
        String str6 = str5 == null ? "" : str5;
        String str7 = this.iconUrl;
        String str8 = str7 == null ? "" : str7;
        String str9 = this.redirectType;
        String str10 = str9 == null ? "" : str9;
        String str11 = this.redirectValue;
        String str12 = str11 == null ? "" : str11;
        Boolean bool = this.uniqueValue;
        return new ActivityWidget(str2, str4, str6, str8, str10, str12, bool != null ? bool.booleanValue() : false, this.extendInfo);
    }
}
