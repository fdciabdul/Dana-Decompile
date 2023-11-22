package id.dana.data.nearbyme.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.domain.nearbyme.model.ShopOpenHour;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u001e\u0010\u001fB%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001d\u0010\u0007"}, d2 = {"Lid/dana/data/nearbyme/model/ShopOpenHourEntity;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "component3", "day", "openHour", "closeHour", "copy", "(Ljava/lang/String;JJ)Lid/dana/data/nearbyme/model/ShopOpenHourEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lid/dana/domain/nearbyme/model/ShopOpenHour;", "toShopOpenHour", "()Lid/dana/domain/nearbyme/model/ShopOpenHour;", "toString", "J", "getCloseHour", "Ljava/lang/String;", "getDay", "getOpenHour", "<init>", "()V", "(Ljava/lang/String;JJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ShopOpenHourEntity {
    private final long closeHour;
    private final String day;
    private final long openHour;

    public static /* synthetic */ ShopOpenHourEntity copy$default(ShopOpenHourEntity shopOpenHourEntity, String str, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopOpenHourEntity.day;
        }
        if ((i & 2) != 0) {
            j = shopOpenHourEntity.openHour;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = shopOpenHourEntity.closeHour;
        }
        return shopOpenHourEntity.copy(str, j3, j2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getDay() {
        return this.day;
    }

    /* renamed from: component2  reason: from getter */
    public final long getOpenHour() {
        return this.openHour;
    }

    /* renamed from: component3  reason: from getter */
    public final long getCloseHour() {
        return this.closeHour;
    }

    public final ShopOpenHourEntity copy(String day, long openHour, long closeHour) {
        Intrinsics.checkNotNullParameter(day, "");
        return new ShopOpenHourEntity(day, openHour, closeHour);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ShopOpenHourEntity) {
            ShopOpenHourEntity shopOpenHourEntity = (ShopOpenHourEntity) other;
            return Intrinsics.areEqual(this.day, shopOpenHourEntity.day) && this.openHour == shopOpenHourEntity.openHour && this.closeHour == shopOpenHourEntity.closeHour;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.day.hashCode() * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.openHour)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.closeHour);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShopOpenHourEntity(day=");
        sb.append(this.day);
        sb.append(", openHour=");
        sb.append(this.openHour);
        sb.append(", closeHour=");
        sb.append(this.closeHour);
        sb.append(')');
        return sb.toString();
    }

    public ShopOpenHourEntity(String str, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.day = str;
        this.openHour = j;
        this.closeHour = j2;
    }

    public /* synthetic */ ShopOpenHourEntity(String str, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2);
    }

    @JvmName(name = "getDay")
    public final String getDay() {
        return this.day;
    }

    @JvmName(name = "getOpenHour")
    public final long getOpenHour() {
        return this.openHour;
    }

    @JvmName(name = "getCloseHour")
    public final long getCloseHour() {
        return this.closeHour;
    }

    public ShopOpenHourEntity() {
        this("", 0L, 0L);
    }

    public final ShopOpenHour toShopOpenHour() {
        return new ShopOpenHour(this.day, this.openHour, this.closeHour);
    }
}
