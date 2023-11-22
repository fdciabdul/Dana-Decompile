package id.dana.mybills.domain.model;

import id.dana.mybills.ui.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007R\u0017\u0010\n\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0007R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/mybills/domain/model/ExtendInfoQuerySubscription;", "", "Lid/dana/mybills/ui/model/MoneyViewModel;", "component1", "()Lid/dana/mybills/ui/model/MoneyViewModel;", "", "component2", "()Ljava/lang/String;", "component3", "totalAmount", "nickname", "provider", "copy", "(Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;)Lid/dana/mybills/domain/model/ExtendInfoQuerySubscription;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getNickname", "getProvider", "Lid/dana/mybills/ui/model/MoneyViewModel;", "getTotalAmount", "<init>", "(Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ExtendInfoQuerySubscription {
    private final String nickname;
    private final String provider;
    private final MoneyViewModel totalAmount;

    public ExtendInfoQuerySubscription() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ExtendInfoQuerySubscription copy$default(ExtendInfoQuerySubscription extendInfoQuerySubscription, MoneyViewModel moneyViewModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            moneyViewModel = extendInfoQuerySubscription.totalAmount;
        }
        if ((i & 2) != 0) {
            str = extendInfoQuerySubscription.nickname;
        }
        if ((i & 4) != 0) {
            str2 = extendInfoQuerySubscription.provider;
        }
        return extendInfoQuerySubscription.copy(moneyViewModel, str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final MoneyViewModel getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component2  reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component3  reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    public final ExtendInfoQuerySubscription copy(MoneyViewModel totalAmount, String nickname, String provider) {
        Intrinsics.checkNotNullParameter(totalAmount, "");
        Intrinsics.checkNotNullParameter(nickname, "");
        Intrinsics.checkNotNullParameter(provider, "");
        return new ExtendInfoQuerySubscription(totalAmount, nickname, provider);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ExtendInfoQuerySubscription) {
            ExtendInfoQuerySubscription extendInfoQuerySubscription = (ExtendInfoQuerySubscription) other;
            return Intrinsics.areEqual(this.totalAmount, extendInfoQuerySubscription.totalAmount) && Intrinsics.areEqual(this.nickname, extendInfoQuerySubscription.nickname) && Intrinsics.areEqual(this.provider, extendInfoQuerySubscription.provider);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.totalAmount.hashCode() * 31) + this.nickname.hashCode()) * 31) + this.provider.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtendInfoQuerySubscription(totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", provider=");
        sb.append(this.provider);
        sb.append(')');
        return sb.toString();
    }

    public ExtendInfoQuerySubscription(MoneyViewModel moneyViewModel, String str, String str2) {
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.totalAmount = moneyViewModel;
        this.nickname = str;
        this.provider = str2;
    }

    public /* synthetic */ ExtendInfoQuerySubscription(MoneyViewModel moneyViewModel, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
    }

    @JvmName(name = "getTotalAmount")
    public final MoneyViewModel getTotalAmount() {
        return this.totalAmount;
    }

    @JvmName(name = "getNickname")
    public final String getNickname() {
        return this.nickname;
    }

    @JvmName(name = "getProvider")
    public final String getProvider() {
        return this.provider;
    }
}
