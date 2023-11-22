package id.dana.domain.sendmoney.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004JL\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004R\u0017\u0010\u0010\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b!\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\"\u0010\u0004"}, d2 = {"Lid/dana/domain/sendmoney/model/EWalletInnovConfig;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Z", "component6", "clientId", "redirectUrlDev", "redirectUrlProd", "scopes", "agreed", "flavorType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lid/dana/domain/sendmoney/model/EWalletInnovConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getAgreed", "Ljava/lang/String;", "getClientId", "getFlavorType", "getRedirectUrlDev", "getRedirectUrlProd", "getScopes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class EWalletInnovConfig {
    private final boolean agreed;
    private final String clientId;
    private final String flavorType;
    private final String redirectUrlDev;
    private final String redirectUrlProd;
    private final String scopes;

    public static /* synthetic */ EWalletInnovConfig copy$default(EWalletInnovConfig eWalletInnovConfig, String str, String str2, String str3, String str4, boolean z, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eWalletInnovConfig.clientId;
        }
        if ((i & 2) != 0) {
            str2 = eWalletInnovConfig.redirectUrlDev;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = eWalletInnovConfig.redirectUrlProd;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = eWalletInnovConfig.scopes;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            z = eWalletInnovConfig.agreed;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            str5 = eWalletInnovConfig.flavorType;
        }
        return eWalletInnovConfig.copy(str, str6, str7, str8, z2, str5);
    }

    /* renamed from: component1  reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getRedirectUrlDev() {
        return this.redirectUrlDev;
    }

    /* renamed from: component3  reason: from getter */
    public final String getRedirectUrlProd() {
        return this.redirectUrlProd;
    }

    /* renamed from: component4  reason: from getter */
    public final String getScopes() {
        return this.scopes;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getAgreed() {
        return this.agreed;
    }

    /* renamed from: component6  reason: from getter */
    public final String getFlavorType() {
        return this.flavorType;
    }

    public final EWalletInnovConfig copy(String clientId, String redirectUrlDev, String redirectUrlProd, String scopes, boolean agreed, String flavorType) {
        Intrinsics.checkNotNullParameter(clientId, "");
        Intrinsics.checkNotNullParameter(redirectUrlDev, "");
        Intrinsics.checkNotNullParameter(redirectUrlProd, "");
        Intrinsics.checkNotNullParameter(scopes, "");
        Intrinsics.checkNotNullParameter(flavorType, "");
        return new EWalletInnovConfig(clientId, redirectUrlDev, redirectUrlProd, scopes, agreed, flavorType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof EWalletInnovConfig) {
            EWalletInnovConfig eWalletInnovConfig = (EWalletInnovConfig) other;
            return Intrinsics.areEqual(this.clientId, eWalletInnovConfig.clientId) && Intrinsics.areEqual(this.redirectUrlDev, eWalletInnovConfig.redirectUrlDev) && Intrinsics.areEqual(this.redirectUrlProd, eWalletInnovConfig.redirectUrlProd) && Intrinsics.areEqual(this.scopes, eWalletInnovConfig.scopes) && this.agreed == eWalletInnovConfig.agreed && Intrinsics.areEqual(this.flavorType, eWalletInnovConfig.flavorType);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.clientId.hashCode();
        int hashCode2 = this.redirectUrlDev.hashCode();
        int hashCode3 = this.redirectUrlProd.hashCode();
        int hashCode4 = this.scopes.hashCode();
        boolean z = this.agreed;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i) * 31) + this.flavorType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EWalletInnovConfig(clientId=");
        sb.append(this.clientId);
        sb.append(", redirectUrlDev=");
        sb.append(this.redirectUrlDev);
        sb.append(", redirectUrlProd=");
        sb.append(this.redirectUrlProd);
        sb.append(", scopes=");
        sb.append(this.scopes);
        sb.append(", agreed=");
        sb.append(this.agreed);
        sb.append(", flavorType=");
        sb.append(this.flavorType);
        sb.append(')');
        return sb.toString();
    }

    public EWalletInnovConfig(String str, String str2, String str3, String str4, boolean z, String str5) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.clientId = str;
        this.redirectUrlDev = str2;
        this.redirectUrlProd = str3;
        this.scopes = str4;
        this.agreed = z;
        this.flavorType = str5;
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "getRedirectUrlDev")
    public final String getRedirectUrlDev() {
        return this.redirectUrlDev;
    }

    @JvmName(name = "getRedirectUrlProd")
    public final String getRedirectUrlProd() {
        return this.redirectUrlProd;
    }

    @JvmName(name = "getScopes")
    public final String getScopes() {
        return this.scopes;
    }

    @JvmName(name = "getAgreed")
    public final boolean getAgreed() {
        return this.agreed;
    }

    @JvmName(name = "getFlavorType")
    public final String getFlavorType() {
        return this.flavorType;
    }
}
