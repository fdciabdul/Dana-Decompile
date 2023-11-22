package id.dana.danapoly.domain.play.model;

import com.alibaba.griver.core.GriverParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\f\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010R\u001a\u0010\u001c\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001a\u0010\u001e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006"}, d2 = {"Lid/dana/danapoly/domain/play/model/Play;", "", "Lid/dana/danapoly/domain/play/model/Localization;", "actionButton", "Lid/dana/danapoly/domain/play/model/Localization;", "getActionButton", "()Lid/dana/danapoly/domain/play/model/Localization;", "", "hasPrize", "Z", "getHasPrize", "()Z", "", GriverParams.ShareParams.IMAGE_URL, "Ljava/lang/String;", "getImageUrl", "()Ljava/lang/String;", "Lid/dana/danapoly/domain/play/model/Position;", "position", "Lid/dana/danapoly/domain/play/model/Position;", "getPosition", "()Lid/dana/danapoly/domain/play/model/Position;", "randomResult", "getRandomResult", "redirectLink", "getRedirectLink", "rewardType", "getRewardType", "subtitle", "getSubtitle", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/danapoly/domain/play/model/Localization;Lid/dana/danapoly/domain/play/model/Localization;Ljava/lang/String;Ljava/lang/String;Lid/dana/danapoly/domain/play/model/Position;Lid/dana/danapoly/domain/play/model/Localization;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Play {
    private final Localization actionButton;
    private final boolean hasPrize;
    private final String imageUrl;
    private final Position position;
    private final String randomResult;
    private final String redirectLink;
    private final String rewardType;
    private final Localization subtitle;
    private final Localization title;

    public Play(String str, String str2, Localization localization, Localization localization2, String str3, String str4, Position position, Localization localization3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(localization, "");
        Intrinsics.checkNotNullParameter(localization2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(position, "");
        Intrinsics.checkNotNullParameter(localization3, "");
        this.randomResult = str;
        this.rewardType = str2;
        this.title = localization;
        this.subtitle = localization2;
        this.imageUrl = str3;
        this.redirectLink = str4;
        this.position = position;
        this.actionButton = localization3;
        this.hasPrize = z;
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
    public final Localization getTitle() {
        return this.title;
    }

    @JvmName(name = "getSubtitle")
    public final Localization getSubtitle() {
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
    public final Position getPosition() {
        return this.position;
    }

    @JvmName(name = "getActionButton")
    public final Localization getActionButton() {
        return this.actionButton;
    }

    @JvmName(name = "getHasPrize")
    public final boolean getHasPrize() {
        return this.hasPrize;
    }
}
