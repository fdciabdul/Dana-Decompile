package id.dana.domain.promodiscovery.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\"\u0010\r\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0015\u001a\u0004\b\r\u0010\n\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004"}, d2 = {"Lid/dana/domain/promodiscovery/model/FourKingsPromoModel;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "", "component3", "()Z", "pillarType", "pillarAmount", "isNewlyUpdated", "copy", "(Ljava/lang/String;IZ)Lid/dana/domain/promodiscovery/model/FourKingsPromoModel;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Z", "setNewlyUpdated", "(Z)V", "I", "getPillarAmount", "Ljava/lang/String;", "getPillarType", "<init>", "(Ljava/lang/String;IZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FourKingsPromoModel {
    @SerializedName("isNewlyUpdated")
    private boolean isNewlyUpdated;
    @SerializedName("pillarAmount")
    private final int pillarAmount;
    @SerializedName("pillarType")
    private final String pillarType;

    public static /* synthetic */ FourKingsPromoModel copy$default(FourKingsPromoModel fourKingsPromoModel, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = fourKingsPromoModel.pillarType;
        }
        if ((i2 & 2) != 0) {
            i = fourKingsPromoModel.pillarAmount;
        }
        if ((i2 & 4) != 0) {
            z = fourKingsPromoModel.isNewlyUpdated;
        }
        return fourKingsPromoModel.copy(str, i, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPillarType() {
        return this.pillarType;
    }

    /* renamed from: component2  reason: from getter */
    public final int getPillarAmount() {
        return this.pillarAmount;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getIsNewlyUpdated() {
        return this.isNewlyUpdated;
    }

    public final FourKingsPromoModel copy(String pillarType, int pillarAmount, boolean isNewlyUpdated) {
        Intrinsics.checkNotNullParameter(pillarType, "");
        return new FourKingsPromoModel(pillarType, pillarAmount, isNewlyUpdated);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FourKingsPromoModel) {
            FourKingsPromoModel fourKingsPromoModel = (FourKingsPromoModel) other;
            return Intrinsics.areEqual(this.pillarType, fourKingsPromoModel.pillarType) && this.pillarAmount == fourKingsPromoModel.pillarAmount && this.isNewlyUpdated == fourKingsPromoModel.isNewlyUpdated;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.pillarType.hashCode();
        int i = this.pillarAmount;
        boolean z = this.isNewlyUpdated;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return (((hashCode * 31) + i) * 31) + i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FourKingsPromoModel(pillarType=");
        sb.append(this.pillarType);
        sb.append(", pillarAmount=");
        sb.append(this.pillarAmount);
        sb.append(", isNewlyUpdated=");
        sb.append(this.isNewlyUpdated);
        sb.append(')');
        return sb.toString();
    }

    public FourKingsPromoModel(String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pillarType = str;
        this.pillarAmount = i;
        this.isNewlyUpdated = z;
    }

    @JvmName(name = "getPillarType")
    public final String getPillarType() {
        return this.pillarType;
    }

    @JvmName(name = "getPillarAmount")
    public final int getPillarAmount() {
        return this.pillarAmount;
    }

    @JvmName(name = "isNewlyUpdated")
    public final boolean isNewlyUpdated() {
        return this.isNewlyUpdated;
    }

    @JvmName(name = "setNewlyUpdated")
    public final void setNewlyUpdated(boolean z) {
        this.isNewlyUpdated = z;
    }
}
