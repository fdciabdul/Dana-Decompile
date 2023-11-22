package id.dana.domain.requestmoney.model;

import id.dana.domain.sendmoney.model.DigitalMoney;
import id.dana.domain.sendmoney.model.TransferInit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\b8\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u0007R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b!\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010\u0004"}, d2 = {"Lid/dana/domain/requestmoney/model/BankSelectorConfig;", "", "Lid/dana/domain/sendmoney/model/TransferInit;", "component1", "()Lid/dana/domain/sendmoney/model/TransferInit;", "Lid/dana/domain/requestmoney/model/NameCheckConfig;", "component2", "()Lid/dana/domain/requestmoney/model/NameCheckConfig;", "", "", "component3", "()Ljava/util/List;", "Lid/dana/domain/sendmoney/model/DigitalMoney;", "component4", "transferInit", "nameCheckConfig", "topFeaturedBanks", "digitalMoneys", "copy", "(Lid/dana/domain/sendmoney/model/TransferInit;Lid/dana/domain/requestmoney/model/NameCheckConfig;Ljava/util/List;Ljava/util/List;)Lid/dana/domain/requestmoney/model/BankSelectorConfig;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getDigitalMoneys", "Lid/dana/domain/requestmoney/model/NameCheckConfig;", "getNameCheckConfig", "getTopFeaturedBanks", "Lid/dana/domain/sendmoney/model/TransferInit;", "getTransferInit", "<init>", "(Lid/dana/domain/sendmoney/model/TransferInit;Lid/dana/domain/requestmoney/model/NameCheckConfig;Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BankSelectorConfig {
    private final List<DigitalMoney> digitalMoneys;
    private final NameCheckConfig nameCheckConfig;
    private final List<String> topFeaturedBanks;
    private final TransferInit transferInit;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BankSelectorConfig copy$default(BankSelectorConfig bankSelectorConfig, TransferInit transferInit, NameCheckConfig nameCheckConfig, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            transferInit = bankSelectorConfig.transferInit;
        }
        if ((i & 2) != 0) {
            nameCheckConfig = bankSelectorConfig.nameCheckConfig;
        }
        if ((i & 4) != 0) {
            list = bankSelectorConfig.topFeaturedBanks;
        }
        if ((i & 8) != 0) {
            list2 = bankSelectorConfig.digitalMoneys;
        }
        return bankSelectorConfig.copy(transferInit, nameCheckConfig, list, list2);
    }

    /* renamed from: component1  reason: from getter */
    public final TransferInit getTransferInit() {
        return this.transferInit;
    }

    /* renamed from: component2  reason: from getter */
    public final NameCheckConfig getNameCheckConfig() {
        return this.nameCheckConfig;
    }

    public final List<String> component3() {
        return this.topFeaturedBanks;
    }

    public final List<DigitalMoney> component4() {
        return this.digitalMoneys;
    }

    public final BankSelectorConfig copy(TransferInit transferInit, NameCheckConfig nameCheckConfig, List<String> topFeaturedBanks, List<DigitalMoney> digitalMoneys) {
        Intrinsics.checkNotNullParameter(transferInit, "");
        Intrinsics.checkNotNullParameter(nameCheckConfig, "");
        Intrinsics.checkNotNullParameter(topFeaturedBanks, "");
        Intrinsics.checkNotNullParameter(digitalMoneys, "");
        return new BankSelectorConfig(transferInit, nameCheckConfig, topFeaturedBanks, digitalMoneys);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BankSelectorConfig) {
            BankSelectorConfig bankSelectorConfig = (BankSelectorConfig) other;
            return Intrinsics.areEqual(this.transferInit, bankSelectorConfig.transferInit) && Intrinsics.areEqual(this.nameCheckConfig, bankSelectorConfig.nameCheckConfig) && Intrinsics.areEqual(this.topFeaturedBanks, bankSelectorConfig.topFeaturedBanks) && Intrinsics.areEqual(this.digitalMoneys, bankSelectorConfig.digitalMoneys);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.transferInit.hashCode() * 31) + this.nameCheckConfig.hashCode()) * 31) + this.topFeaturedBanks.hashCode()) * 31) + this.digitalMoneys.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BankSelectorConfig(transferInit=");
        sb.append(this.transferInit);
        sb.append(", nameCheckConfig=");
        sb.append(this.nameCheckConfig);
        sb.append(", topFeaturedBanks=");
        sb.append(this.topFeaturedBanks);
        sb.append(", digitalMoneys=");
        sb.append(this.digitalMoneys);
        sb.append(')');
        return sb.toString();
    }

    public BankSelectorConfig(TransferInit transferInit, NameCheckConfig nameCheckConfig, List<String> list, List<DigitalMoney> list2) {
        Intrinsics.checkNotNullParameter(transferInit, "");
        Intrinsics.checkNotNullParameter(nameCheckConfig, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        this.transferInit = transferInit;
        this.nameCheckConfig = nameCheckConfig;
        this.topFeaturedBanks = list;
        this.digitalMoneys = list2;
    }

    @JvmName(name = "getTransferInit")
    public final TransferInit getTransferInit() {
        return this.transferInit;
    }

    @JvmName(name = "getNameCheckConfig")
    public final NameCheckConfig getNameCheckConfig() {
        return this.nameCheckConfig;
    }

    @JvmName(name = "getTopFeaturedBanks")
    public final List<String> getTopFeaturedBanks() {
        return this.topFeaturedBanks;
    }

    @JvmName(name = "getDigitalMoneys")
    public final List<DigitalMoney> getDigitalMoneys() {
        return this.digitalMoneys;
    }
}
