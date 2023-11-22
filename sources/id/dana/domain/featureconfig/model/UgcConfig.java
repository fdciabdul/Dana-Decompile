package id.dana.domain.featureconfig.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/featureconfig/model/UgcConfig;", "", "", "reviewEnable", "Z", "getReviewEnable", "()Z", "setReviewEnable", "(Z)V", "", "ugcInterval", "I", "getUgcInterval", "()I", "<init>", "(ZI)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UgcConfig {
    public static final int DEFAULT_UGC_INTERVAL = 86400;
    private boolean reviewEnable;
    private final int ugcInterval;

    public UgcConfig(boolean z, int i) {
        this.reviewEnable = z;
        this.ugcInterval = i;
    }

    @JvmName(name = "getReviewEnable")
    public final boolean getReviewEnable() {
        return this.reviewEnable;
    }

    @JvmName(name = "getUgcInterval")
    public final int getUgcInterval() {
        return this.ugcInterval;
    }

    @JvmName(name = "setReviewEnable")
    public final void setReviewEnable(boolean z) {
        this.reviewEnable = z;
    }
}
