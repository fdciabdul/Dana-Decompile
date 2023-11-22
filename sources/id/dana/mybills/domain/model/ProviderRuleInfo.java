package id.dana.mybills.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/mybills/domain/model/ProviderRuleInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "providerId", "pattern", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/mybills/domain/model/ProviderRuleInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getPattern", "getProviderId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ProviderRuleInfo {
    private final String pattern;
    private final String providerId;

    public static /* synthetic */ ProviderRuleInfo copy$default(ProviderRuleInfo providerRuleInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = providerRuleInfo.providerId;
        }
        if ((i & 2) != 0) {
            str2 = providerRuleInfo.pattern;
        }
        return providerRuleInfo.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getProviderId() {
        return this.providerId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPattern() {
        return this.pattern;
    }

    public final ProviderRuleInfo copy(String providerId, String pattern) {
        return new ProviderRuleInfo(providerId, pattern);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ProviderRuleInfo) {
            ProviderRuleInfo providerRuleInfo = (ProviderRuleInfo) other;
            return Intrinsics.areEqual(this.providerId, providerRuleInfo.providerId) && Intrinsics.areEqual(this.pattern, providerRuleInfo.pattern);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.providerId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.pattern;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProviderRuleInfo(providerId=");
        sb.append(this.providerId);
        sb.append(", pattern=");
        sb.append(this.pattern);
        sb.append(')');
        return sb.toString();
    }

    public ProviderRuleInfo(String str, String str2) {
        this.providerId = str;
        this.pattern = str2;
    }

    @JvmName(name = "getProviderId")
    public final String getProviderId() {
        return this.providerId;
    }

    @JvmName(name = "getPattern")
    public final String getPattern() {
        return this.pattern;
    }
}
