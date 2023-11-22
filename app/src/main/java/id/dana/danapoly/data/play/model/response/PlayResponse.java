package id.dana.danapoly.data.play.model.response;

import com.alibaba.griver.core.GriverParams;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b \u0010!R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006"}, d2 = {"Lid/dana/danapoly/data/play/model/response/PlayResponse;", "", "Lid/dana/danapoly/data/play/model/response/LocalizationResponse;", "actionButton", "Lid/dana/danapoly/data/play/model/response/LocalizationResponse;", "getActionButton", "()Lid/dana/danapoly/data/play/model/response/LocalizationResponse;", "", "hasPrize", "Ljava/lang/Boolean;", "getHasPrize", "()Ljava/lang/Boolean;", "", GriverParams.ShareParams.IMAGE_URL, "Ljava/lang/String;", "getImageUrl", "()Ljava/lang/String;", "Lid/dana/danapoly/data/play/model/response/PositionResponse;", "position", "Lid/dana/danapoly/data/play/model/response/PositionResponse;", "getPosition", "()Lid/dana/danapoly/data/play/model/response/PositionResponse;", "randomResult", "getRandomResult", "redirectLink", "getRedirectLink", "rewardType", "getRewardType", "subtitle", "getSubtitle", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/danapoly/data/play/model/response/LocalizationResponse;Lid/dana/danapoly/data/play/model/response/LocalizationResponse;Ljava/lang/String;Ljava/lang/String;Lid/dana/danapoly/data/play/model/response/PositionResponse;Lid/dana/danapoly/data/play/model/response/LocalizationResponse;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayResponse {
    @SerializedName("actionButton")
    private final LocalizationResponse actionButton;
    @SerializedName("hasPrize")
    private final Boolean hasPrize;
    @SerializedName(GriverParams.ShareParams.IMAGE_URL)
    private final String imageUrl;
    @SerializedName("position")
    private final PositionResponse position;
    @SerializedName("randomResult")
    private final String randomResult;
    @SerializedName("redirectLink")
    private final String redirectLink;
    @SerializedName("rewardType")
    private final String rewardType;
    @SerializedName("subtitle")
    private final LocalizationResponse subtitle;
    @SerializedName("title")
    private final LocalizationResponse title;

    public PlayResponse(String str, String str2, LocalizationResponse localizationResponse, LocalizationResponse localizationResponse2, String str3, String str4, PositionResponse positionResponse, LocalizationResponse localizationResponse3, Boolean bool) {
        this.randomResult = str;
        this.rewardType = str2;
        this.title = localizationResponse;
        this.subtitle = localizationResponse2;
        this.imageUrl = str3;
        this.redirectLink = str4;
        this.position = positionResponse;
        this.actionButton = localizationResponse3;
        this.hasPrize = bool;
    }

    @JvmName(name = "getRandomResult")
    public final String getRandomResult() {
        return this.randomResult;
    }

    @JvmName(name = "getRewardType")
    public final String getRewardType() {
        return this.rewardType;
    }

    @JvmName(name = "getTitle")
    public final LocalizationResponse getTitle() {
        return this.title;
    }

    @JvmName(name = "getSubtitle")
    public final LocalizationResponse getSubtitle() {
        return this.subtitle;
    }

    @JvmName(name = "getImageUrl")
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @JvmName(name = "getRedirectLink")
    public final String getRedirectLink() {
        return this.redirectLink;
    }

    @JvmName(name = "getPosition")
    public final PositionResponse getPosition() {
        return this.position;
    }

    @JvmName(name = "getActionButton")
    public final LocalizationResponse getActionButton() {
        return this.actionButton;
    }

    @JvmName(name = "getHasPrize")
    public final Boolean getHasPrize() {
        return this.hasPrize;
    }
}
