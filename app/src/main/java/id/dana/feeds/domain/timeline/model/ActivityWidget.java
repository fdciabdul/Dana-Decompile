package id.dana.feeds.domain.timeline.model;

import id.dana.danah5.share.ShareToFeedBridge;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012,\b\u0002\u0010\u0005\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002j\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u0004¢\u0006\u0004\b\u001c\u0010\u001dR;\u0010\u0005\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002j\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u00048\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR\u001a\u0010\u0018\u001a\u00020\u00178\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/feeds/domain/timeline/model/ActivityWidget;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "extendInfo", "Ljava/util/HashMap;", "getExtendInfo", "()Ljava/util/HashMap;", "iconUrl", "Ljava/lang/String;", "getIconUrl", "()Ljava/lang/String;", "redirectType", "getRedirectType", ShareToFeedBridge.REDIRECT_VALUE, "getRedirectValue", "subtitleType", "getSubtitleType", "subtitleValue", "getSubtitleValue", "title", "getTitle", "", "uniqueValue", "Z", "getUniqueValue", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/HashMap;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityWidget {
    public HashMap<String, Object> extendInfo;
    public String iconUrl;
    public String redirectType;
    public String redirectValue;
    public String subtitleType;
    public String subtitleValue;
    public String title;
    public boolean uniqueValue;

    public ActivityWidget() {
        this(null, null, null, null, null, null, false, null, 255, null);
    }

    public ActivityWidget(String str, String str2, String str3, String str4, String str5, String str6, boolean z, HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.title = str;
        this.subtitleType = str2;
        this.subtitleValue = str3;
        this.iconUrl = str4;
        this.redirectType = str5;
        this.redirectValue = str6;
        this.uniqueValue = z;
        this.extendInfo = hashMap;
    }

    public /* synthetic */ ActivityWidget(String str, String str2, String str3, String str4, String str5, String str6, boolean z, HashMap hashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) == 0 ? str6 : "", (i & 64) != 0 ? false : z, (i & 128) != 0 ? null : hashMap);
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

    @JvmName(name = "getUniqueValue")
    public final boolean getUniqueValue() {
        return this.uniqueValue;
    }

    @JvmName(name = "getExtendInfo")
    public final HashMap<String, Object> getExtendInfo() {
        return this.extendInfo;
    }
}
