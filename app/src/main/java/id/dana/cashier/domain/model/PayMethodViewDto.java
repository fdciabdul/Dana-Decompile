package id.dana.cashier.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010!J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004JL\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004"}, d2 = {"Lid/dana/cashier/domain/model/PayMethodViewDto;", "", "", "component1", "()Ljava/lang/String;", "", "Lid/dana/cashier/domain/model/AssetCard;", "component2", "()Ljava/util/List;", "Lid/dana/cashier/domain/model/CashierPayChannelInfo;", "component3", "component4", "defaultChannelOption", "payCardOptionViewDtos", "payChannelOptionViewDtos", "payMethod", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lid/dana/cashier/domain/model/PayMethodViewDto;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDefaultChannelOption", "Ljava/util/List;", "getPayCardOptionViewDtos", "getPayChannelOptionViewDtos", "getPayMethod", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PayMethodViewDto {
    private final String defaultChannelOption;
    private final List<AssetCard> payCardOptionViewDtos;
    private final List<CashierPayChannelInfo> payChannelOptionViewDtos;
    private final String payMethod;

    public PayMethodViewDto() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PayMethodViewDto copy$default(PayMethodViewDto payMethodViewDto, String str, List list, List list2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payMethodViewDto.defaultChannelOption;
        }
        if ((i & 2) != 0) {
            list = payMethodViewDto.payCardOptionViewDtos;
        }
        if ((i & 4) != 0) {
            list2 = payMethodViewDto.payChannelOptionViewDtos;
        }
        if ((i & 8) != 0) {
            str2 = payMethodViewDto.payMethod;
        }
        return payMethodViewDto.copy(str, list, list2, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getDefaultChannelOption() {
        return this.defaultChannelOption;
    }

    public final List<AssetCard> component2() {
        return this.payCardOptionViewDtos;
    }

    public final List<CashierPayChannelInfo> component3() {
        return this.payChannelOptionViewDtos;
    }

    /* renamed from: component4  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    public final PayMethodViewDto copy(String defaultChannelOption, List<AssetCard> payCardOptionViewDtos, List<CashierPayChannelInfo> payChannelOptionViewDtos, String payMethod) {
        return new PayMethodViewDto(defaultChannelOption, payCardOptionViewDtos, payChannelOptionViewDtos, payMethod);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PayMethodViewDto) {
            PayMethodViewDto payMethodViewDto = (PayMethodViewDto) other;
            return Intrinsics.areEqual(this.defaultChannelOption, payMethodViewDto.defaultChannelOption) && Intrinsics.areEqual(this.payCardOptionViewDtos, payMethodViewDto.payCardOptionViewDtos) && Intrinsics.areEqual(this.payChannelOptionViewDtos, payMethodViewDto.payChannelOptionViewDtos) && Intrinsics.areEqual(this.payMethod, payMethodViewDto.payMethod);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.defaultChannelOption;
        int hashCode = str == null ? 0 : str.hashCode();
        List<AssetCard> list = this.payCardOptionViewDtos;
        int hashCode2 = list == null ? 0 : list.hashCode();
        List<CashierPayChannelInfo> list2 = this.payChannelOptionViewDtos;
        int hashCode3 = list2 == null ? 0 : list2.hashCode();
        String str2 = this.payMethod;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayMethodViewDto(defaultChannelOption=");
        sb.append(this.defaultChannelOption);
        sb.append(", payCardOptionViewDtos=");
        sb.append(this.payCardOptionViewDtos);
        sb.append(", payChannelOptionViewDtos=");
        sb.append(this.payChannelOptionViewDtos);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(')');
        return sb.toString();
    }

    public PayMethodViewDto(String str, List<AssetCard> list, List<CashierPayChannelInfo> list2, String str2) {
        this.defaultChannelOption = str;
        this.payCardOptionViewDtos = list;
        this.payChannelOptionViewDtos = list2;
        this.payMethod = str2;
    }

    public /* synthetic */ PayMethodViewDto(String str, List list, List list2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : str2);
    }

    @JvmName(name = "getDefaultChannelOption")
    public final String getDefaultChannelOption() {
        return this.defaultChannelOption;
    }

    @JvmName(name = "getPayCardOptionViewDtos")
    public final List<AssetCard> getPayCardOptionViewDtos() {
        return this.payCardOptionViewDtos;
    }

    @JvmName(name = "getPayChannelOptionViewDtos")
    public final List<CashierPayChannelInfo> getPayChannelOptionViewDtos() {
        return this.payChannelOptionViewDtos;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }
}
