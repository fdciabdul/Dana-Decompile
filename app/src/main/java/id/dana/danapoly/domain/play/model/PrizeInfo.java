package id.dana.danapoly.domain.play.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b"}, d2 = {"Lid/dana/danapoly/domain/play/model/PrizeInfo;", "", "Lid/dana/danapoly/domain/play/model/Localization;", "actionButton", "Lid/dana/danapoly/domain/play/model/Localization;", "getActionButton", "()Lid/dana/danapoly/domain/play/model/Localization;", "", "medalImageUrl", "Ljava/lang/String;", "getMedalImageUrl", "()Ljava/lang/String;", "prize", "getPrize", "prizeImageUrl", "getPrizeImageUrl", "redirectLink", "getRedirectLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/danapoly/domain/play/model/Localization;Lid/dana/danapoly/domain/play/model/Localization;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PrizeInfo {
    private final Localization actionButton;
    private final String medalImageUrl;
    private final Localization prize;
    private final String prizeImageUrl;
    private final String redirectLink;

    public PrizeInfo(String str, String str2, Localization localization, Localization localization2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(localization, "");
        Intrinsics.checkNotNullParameter(localization2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.medalImageUrl = str;
        this.prizeImageUrl = str2;
        this.prize = localization;
        this.actionButton = localization2;
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

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r14v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ PrizeInfo(java.lang.String r8, java.lang.String r9, id.dana.danapoly.domain.play.model.Localization r10, id.dana.danapoly.domain.play.model.Localization r11, java.lang.String r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 1
            java.lang.String r0 = ""
            if (r14 == 0) goto L8
            r2 = r0
            goto L9
        L8:
            r2 = r8
        L9:
            r8 = r13 & 2
            if (r8 == 0) goto Lf
            r3 = r0
            goto L10
        Lf:
            r3 = r9
        L10:
            r8 = r13 & 4
            r9 = 3
            r14 = 0
            if (r8 == 0) goto L1b
            id.dana.danapoly.domain.play.model.Localization r10 = new id.dana.danapoly.domain.play.model.Localization
            r10.<init>(r14, r14, r9, r14)
        L1b:
            r4 = r10
            r8 = r13 & 8
            if (r8 == 0) goto L25
            id.dana.danapoly.domain.play.model.Localization r11 = new id.dana.danapoly.domain.play.model.Localization
            r11.<init>(r14, r14, r9, r14)
        L25:
            r5 = r11
            r1 = r7
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.domain.play.model.PrizeInfo.<init>(java.lang.String, java.lang.String, id.dana.danapoly.domain.play.model.Localization, id.dana.danapoly.domain.play.model.Localization, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getPrize")
    public final Localization getPrize() {
        return this.prize;
    }

    @JvmName(name = "getActionButton")
    public final Localization getActionButton() {
        return this.actionButton;
    }

    @JvmName(name = "getRedirectLink")
    public final String getRedirectLink() {
        return this.redirectLink;
    }
}
