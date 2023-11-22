package id.dana.domain.cancelsurvey.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006"}, d2 = {"Lid/dana/domain/cancelsurvey/model/CancellationSurveyConfig;", "", "", "ctaLabel", "Ljava/lang/String;", "getCtaLabel", "()Ljava/lang/String;", "", "enable", "Z", "getEnable", "()Z", "headerLabel", "getHeaderLabel", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CancellationSurveyConfig {
    private final String ctaLabel;
    private final boolean enable;
    private final String headerLabel;

    public CancellationSurveyConfig(boolean z, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.enable = z;
        this.headerLabel = str;
        this.ctaLabel = str2;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getHeaderLabel")
    public final String getHeaderLabel() {
        return this.headerLabel;
    }

    @JvmName(name = "getCtaLabel")
    public final String getCtaLabel() {
        return this.ctaLabel;
    }
}
