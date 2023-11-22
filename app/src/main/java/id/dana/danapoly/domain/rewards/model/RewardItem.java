package id.dana.danapoly.domain.rewards.model;

import com.alibaba.griver.core.GriverParams;
import id.dana.danapoly.domain.play.model.Localization;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u001d\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010"}, d2 = {"Lid/dana/danapoly/domain/rewards/model/RewardItem;", "", "Lid/dana/danapoly/domain/play/model/Localization;", "actionButton", "Lid/dana/danapoly/domain/play/model/Localization;", "getActionButton", "()Lid/dana/danapoly/domain/play/model/Localization;", "", "expiryTime", "J", "getExpiryTime", "()J", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", GriverParams.ShareParams.IMAGE_URL, "getImageUrl", "name", "getName", "redirectLink", "getRedirectLink", "status", "getStatus", "subtitle", "getSubtitle", "title", "getTitle", "type", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLid/dana/danapoly/domain/play/model/Localization;Lid/dana/danapoly/domain/play/model/Localization;Lid/dana/danapoly/domain/play/model/Localization;Ljava/lang/String;Lid/dana/danapoly/domain/play/model/Localization;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RewardItem {
    private final Localization actionButton;
    private final long expiryTime;
    private final String id;
    private final String imageUrl;
    private final Localization name;
    private final String redirectLink;
    private final String status;
    private final Localization subtitle;
    private final Localization title;
    private final String type;

    public RewardItem(String str, String str2, String str3, String str4, long j, Localization localization, Localization localization2, Localization localization3, String str5, Localization localization4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(localization, "");
        Intrinsics.checkNotNullParameter(localization2, "");
        Intrinsics.checkNotNullParameter(localization3, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(localization4, "");
        this.id = str;
        this.type = str2;
        this.imageUrl = str3;
        this.status = str4;
        this.expiryTime = j;
        this.title = localization;
        this.subtitle = localization2;
        this.actionButton = localization3;
        this.redirectLink = str5;
        this.name = localization4;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getImageUrl")
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getExpiryTime")
    public final long getExpiryTime() {
        return this.expiryTime;
    }

    @JvmName(name = "getTitle")
    public final Localization getTitle() {
        return this.title;
    }

    @JvmName(name = "getSubtitle")
    public final Localization getSubtitle() {
        return this.subtitle;
    }

    @JvmName(name = "getActionButton")
    public final Localization getActionButton() {
        return this.actionButton;
    }

    @JvmName(name = "getRedirectLink")
    public final String getRedirectLink() {
        return this.redirectLink;
    }

    @JvmName(name = "getName")
    public final Localization getName() {
        return this.name;
    }
}
