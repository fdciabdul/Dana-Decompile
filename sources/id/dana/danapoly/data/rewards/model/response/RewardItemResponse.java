package id.dana.danapoly.data.rewards.model.response;

import com.alibaba.griver.core.GriverParams;
import id.dana.danapoly.data.play.model.response.LocalizationResponse;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010"}, d2 = {"Lid/dana/danapoly/data/rewards/model/response/RewardItemResponse;", "", "Lid/dana/danapoly/data/play/model/response/LocalizationResponse;", "actionButton", "Lid/dana/danapoly/data/play/model/response/LocalizationResponse;", "getActionButton", "()Lid/dana/danapoly/data/play/model/response/LocalizationResponse;", "", "expiryTime", "Ljava/lang/Long;", "getExpiryTime", "()Ljava/lang/Long;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", GriverParams.ShareParams.IMAGE_URL, "getImageUrl", "name", "getName", "redirectLink", "getRedirectLink", "status", "getStatus", "subtitle", "getSubtitle", "title", "getTitle", "type", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lid/dana/danapoly/data/play/model/response/LocalizationResponse;Lid/dana/danapoly/data/play/model/response/LocalizationResponse;Lid/dana/danapoly/data/play/model/response/LocalizationResponse;Lid/dana/danapoly/data/play/model/response/LocalizationResponse;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RewardItemResponse {
    private final LocalizationResponse actionButton;
    private final Long expiryTime;
    private final String id;
    private final String imageUrl;
    private final LocalizationResponse name;
    private final String redirectLink;
    private final String status;
    private final LocalizationResponse subtitle;
    private final LocalizationResponse title;
    private final String type;

    public RewardItemResponse() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public RewardItemResponse(String str, String str2, String str3, String str4, Long l, LocalizationResponse localizationResponse, LocalizationResponse localizationResponse2, LocalizationResponse localizationResponse3, LocalizationResponse localizationResponse4, String str5) {
        this.id = str;
        this.type = str2;
        this.imageUrl = str3;
        this.status = str4;
        this.expiryTime = l;
        this.title = localizationResponse;
        this.subtitle = localizationResponse2;
        this.actionButton = localizationResponse3;
        this.name = localizationResponse4;
        this.redirectLink = str5;
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

    public /* synthetic */ RewardItemResponse(String str, String str2, String str3, String str4, Long l, LocalizationResponse localizationResponse, LocalizationResponse localizationResponse2, LocalizationResponse localizationResponse3, LocalizationResponse localizationResponse4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? 0L : l, (i & 32) != 0 ? null : localizationResponse, (i & 64) != 0 ? null : localizationResponse2, (i & 128) != 0 ? null : localizationResponse3, (i & 256) == 0 ? localizationResponse4 : null, (i & 512) == 0 ? str5 : "");
    }

    @JvmName(name = "getExpiryTime")
    public final Long getExpiryTime() {
        return this.expiryTime;
    }

    @JvmName(name = "getTitle")
    public final LocalizationResponse getTitle() {
        return this.title;
    }

    @JvmName(name = "getSubtitle")
    public final LocalizationResponse getSubtitle() {
        return this.subtitle;
    }

    @JvmName(name = "getActionButton")
    public final LocalizationResponse getActionButton() {
        return this.actionButton;
    }

    @JvmName(name = "getName")
    public final LocalizationResponse getName() {
        return this.name;
    }

    @JvmName(name = "getRedirectLink")
    public final String getRedirectLink() {
        return this.redirectLink;
    }
}
