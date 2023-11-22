package id.dana.data.sendmoney.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JB\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001d\u0010\u0004"}, d2 = {"Lid/dana/data/sendmoney/model/DigitalMoneyEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "instId", "eWalletPrefix", "bankName", "eWalletName", "identifier", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/sendmoney/model/DigitalMoneyEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBankName", "getEWalletName", "getEWalletPrefix", "getIdentifier", "getInstId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DigitalMoneyEntity {
    private final String bankName;
    private final String eWalletName;
    private final String eWalletPrefix;
    private final String identifier;
    private final String instId;

    public static /* synthetic */ DigitalMoneyEntity copy$default(DigitalMoneyEntity digitalMoneyEntity, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = digitalMoneyEntity.instId;
        }
        if ((i & 2) != 0) {
            str2 = digitalMoneyEntity.eWalletPrefix;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = digitalMoneyEntity.bankName;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = digitalMoneyEntity.eWalletName;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = digitalMoneyEntity.identifier;
        }
        return digitalMoneyEntity.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getEWalletPrefix() {
        return this.eWalletPrefix;
    }

    /* renamed from: component3  reason: from getter */
    public final String getBankName() {
        return this.bankName;
    }

    /* renamed from: component4  reason: from getter */
    public final String getEWalletName() {
        return this.eWalletName;
    }

    /* renamed from: component5  reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    public final DigitalMoneyEntity copy(String instId, String eWalletPrefix, String bankName, String eWalletName, String identifier) {
        Intrinsics.checkNotNullParameter(instId, "");
        Intrinsics.checkNotNullParameter(eWalletPrefix, "");
        Intrinsics.checkNotNullParameter(bankName, "");
        Intrinsics.checkNotNullParameter(eWalletName, "");
        Intrinsics.checkNotNullParameter(identifier, "");
        return new DigitalMoneyEntity(instId, eWalletPrefix, bankName, eWalletName, identifier);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DigitalMoneyEntity) {
            DigitalMoneyEntity digitalMoneyEntity = (DigitalMoneyEntity) other;
            return Intrinsics.areEqual(this.instId, digitalMoneyEntity.instId) && Intrinsics.areEqual(this.eWalletPrefix, digitalMoneyEntity.eWalletPrefix) && Intrinsics.areEqual(this.bankName, digitalMoneyEntity.bankName) && Intrinsics.areEqual(this.eWalletName, digitalMoneyEntity.eWalletName) && Intrinsics.areEqual(this.identifier, digitalMoneyEntity.identifier);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((this.instId.hashCode() * 31) + this.eWalletPrefix.hashCode()) * 31) + this.bankName.hashCode()) * 31) + this.eWalletName.hashCode()) * 31) + this.identifier.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DigitalMoneyEntity(instId=");
        sb.append(this.instId);
        sb.append(", eWalletPrefix=");
        sb.append(this.eWalletPrefix);
        sb.append(", bankName=");
        sb.append(this.bankName);
        sb.append(", eWalletName=");
        sb.append(this.eWalletName);
        sb.append(", identifier=");
        sb.append(this.identifier);
        sb.append(')');
        return sb.toString();
    }

    public DigitalMoneyEntity(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.instId = str;
        this.eWalletPrefix = str2;
        this.bankName = str3;
        this.eWalletName = str4;
        this.identifier = str5;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getEWalletPrefix")
    public final String getEWalletPrefix() {
        return this.eWalletPrefix;
    }

    @JvmName(name = "getBankName")
    public final String getBankName() {
        return this.bankName;
    }

    @JvmName(name = "getEWalletName")
    public final String getEWalletName() {
        return this.eWalletName;
    }

    @JvmName(name = "getIdentifier")
    public final String getIdentifier() {
        return this.identifier;
    }
}
