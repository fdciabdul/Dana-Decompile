package id.dana.domain.featureconfig.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007"}, d2 = {"Lid/dana/domain/featureconfig/model/HelpButtonConfig;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "enable", "type", "url", "copy", "(ZLjava/lang/String;Ljava/lang/String;)Lid/dana/domain/featureconfig/model/HelpButtonConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getEnable", "Ljava/lang/String;", "getType", "getUrl", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HelpButtonConfig {
    public boolean enable;
    public String type;
    public String url;

    public /* synthetic */ HelpButtonConfig() {
    }

    public static /* synthetic */ HelpButtonConfig copy$default(HelpButtonConfig helpButtonConfig, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = helpButtonConfig.enable;
        }
        if ((i & 2) != 0) {
            str = helpButtonConfig.type;
        }
        if ((i & 4) != 0) {
            str2 = helpButtonConfig.url;
        }
        return helpButtonConfig.copy(z, str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3  reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final HelpButtonConfig copy(boolean enable, String type, String url) {
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(url, "");
        return new HelpButtonConfig(enable, type, url);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof HelpButtonConfig) {
            HelpButtonConfig helpButtonConfig = (HelpButtonConfig) other;
            return this.enable == helpButtonConfig.enable && Intrinsics.areEqual(this.type, helpButtonConfig.type) && Intrinsics.areEqual(this.url, helpButtonConfig.url);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.type.hashCode()) * 31) + this.url.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HelpButtonConfig(enable=");
        sb.append(this.enable);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(')');
        return sb.toString();
    }

    public HelpButtonConfig(boolean z, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.enable = z;
        this.type = str;
        this.url = str2;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getUrl")
    public final String getUrl() {
        return this.url;
    }
}
