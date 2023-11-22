package id.dana.domain.registration.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007"}, d2 = {"Lid/dana/domain/registration/model/HelpButtonOtpLimitDeviceModel;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "enable", "url", "copy", "(ZLjava/lang/String;)Lid/dana/domain/registration/model/HelpButtonOtpLimitDeviceModel;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getEnable", "Ljava/lang/String;", "getUrl", "<init>", "(ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HelpButtonOtpLimitDeviceModel {
    private final boolean enable;
    private final String url;

    public static /* synthetic */ HelpButtonOtpLimitDeviceModel copy$default(HelpButtonOtpLimitDeviceModel helpButtonOtpLimitDeviceModel, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = helpButtonOtpLimitDeviceModel.enable;
        }
        if ((i & 2) != 0) {
            str = helpButtonOtpLimitDeviceModel.url;
        }
        return helpButtonOtpLimitDeviceModel.copy(z, str);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final HelpButtonOtpLimitDeviceModel copy(boolean enable, String url) {
        Intrinsics.checkNotNullParameter(url, "");
        return new HelpButtonOtpLimitDeviceModel(enable, url);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof HelpButtonOtpLimitDeviceModel) {
            HelpButtonOtpLimitDeviceModel helpButtonOtpLimitDeviceModel = (HelpButtonOtpLimitDeviceModel) other;
            return this.enable == helpButtonOtpLimitDeviceModel.enable && Intrinsics.areEqual(this.url, helpButtonOtpLimitDeviceModel.url);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.url.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HelpButtonOtpLimitDeviceModel(enable=");
        sb.append(this.enable);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(')');
        return sb.toString();
    }

    public HelpButtonOtpLimitDeviceModel(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.enable = z;
        this.url = str;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getUrl")
    public final String getUrl() {
        return this.url;
    }
}
