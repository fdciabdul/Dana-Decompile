package id.dana.danapoly.data.play.model.response;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B9\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b"}, d2 = {"Lid/dana/danapoly/data/play/model/response/PrizeInfoResponse;", "", "Lid/dana/danapoly/data/play/model/response/LocalizationResponse;", "actionButton", "Lid/dana/danapoly/data/play/model/response/LocalizationResponse;", "getActionButton", "()Lid/dana/danapoly/data/play/model/response/LocalizationResponse;", "", "medalImageUrl", "Ljava/lang/String;", "getMedalImageUrl", "()Ljava/lang/String;", "prize", "getPrize", "prizeImageUrl", "getPrizeImageUrl", "redirectLink", "getRedirectLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/danapoly/data/play/model/response/LocalizationResponse;Lid/dana/danapoly/data/play/model/response/LocalizationResponse;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PrizeInfoResponse {
    private final LocalizationResponse actionButton;
    private final String medalImageUrl;
    private final LocalizationResponse prize;
    private final String prizeImageUrl;
    private final String redirectLink;

    public PrizeInfoResponse(String str, String str2, LocalizationResponse localizationResponse, LocalizationResponse localizationResponse2, String str3) {
        this.medalImageUrl = str;
        this.prizeImageUrl = str2;
        this.prize = localizationResponse;
        this.actionButton = localizationResponse2;
        this.redirectLink = str3;
    }

    @JvmName(name = "getMedalImageUrl")
    public final String getMedalImageUrl() {
        return this.medalImageUrl;
    }

    @JvmName(name = "getPrizeImageUrl")
    public final String getPrizeImageUrl() {
        return this.prizeImageUrl;
    }

    @JvmName(name = "getPrize")
    public final LocalizationResponse getPrize() {
        return this.prize;
    }

    @JvmName(name = "getActionButton")
    public final LocalizationResponse getActionButton() {
        return this.actionButton;
    }

    @JvmName(name = "getRedirectLink")
    public final String getRedirectLink() {
        return this.redirectLink;
    }
}
