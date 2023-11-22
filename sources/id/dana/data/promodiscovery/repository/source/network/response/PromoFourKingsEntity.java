package id.dana.data.promodiscovery.repository.source.network.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004"}, d2 = {"Lid/dana/data/promodiscovery/repository/source/network/response/PromoFourKingsEntity;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "pillarType", "amount", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lid/dana/data/promodiscovery/repository/source/network/response/PromoFourKingsEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/Integer;", "getAmount", "Ljava/lang/String;", "getPillarType", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PromoFourKingsEntity {
    @SerializedName("amount")
    private final Integer amount;
    @SerializedName("pillarType")
    private final String pillarType;

    public static /* synthetic */ PromoFourKingsEntity copy$default(PromoFourKingsEntity promoFourKingsEntity, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = promoFourKingsEntity.pillarType;
        }
        if ((i & 2) != 0) {
            num = promoFourKingsEntity.amount;
        }
        return promoFourKingsEntity.copy(str, num);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPillarType() {
        return this.pillarType;
    }

    /* renamed from: component2  reason: from getter */
    public final Integer getAmount() {
        return this.amount;
    }

    public final PromoFourKingsEntity copy(String pillarType, Integer amount) {
        return new PromoFourKingsEntity(pillarType, amount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PromoFourKingsEntity) {
            PromoFourKingsEntity promoFourKingsEntity = (PromoFourKingsEntity) other;
            return Intrinsics.areEqual(this.pillarType, promoFourKingsEntity.pillarType) && Intrinsics.areEqual(this.amount, promoFourKingsEntity.amount);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.pillarType;
        int hashCode = str == null ? 0 : str.hashCode();
        Integer num = this.amount;
        return (hashCode * 31) + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoFourKingsEntity(pillarType=");
        sb.append(this.pillarType);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(')');
        return sb.toString();
    }

    public PromoFourKingsEntity(String str, Integer num) {
        this.pillarType = str;
        this.amount = num;
    }

    @JvmName(name = "getPillarType")
    public final String getPillarType() {
        return this.pillarType;
    }

    @JvmName(name = "getAmount")
    public final Integer getAmount() {
        return this.amount;
    }
}
