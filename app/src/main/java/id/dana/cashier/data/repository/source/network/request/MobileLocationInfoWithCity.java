package id.dana.cashier.data.repository.source.network.request;

import com.alipayplus.mobile.component.common.facade.base.MobileEnvLocationInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/MobileLocationInfoWithCity;", "Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvLocationInfo;", "", "component1", "()Ljava/lang/String;", "city", "copy", "(Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/request/MobileLocationInfoWithCity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCity", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MobileLocationInfoWithCity extends MobileEnvLocationInfo {
    public String city;

    public /* synthetic */ MobileLocationInfoWithCity() {
    }

    public static /* synthetic */ MobileLocationInfoWithCity copy$default(MobileLocationInfoWithCity mobileLocationInfoWithCity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mobileLocationInfoWithCity.city;
        }
        return mobileLocationInfoWithCity.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCity() {
        return this.city;
    }

    public final MobileLocationInfoWithCity copy(String city) {
        return new MobileLocationInfoWithCity(city);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MobileLocationInfoWithCity) && Intrinsics.areEqual(this.city, ((MobileLocationInfoWithCity) other).city);
    }

    public final int hashCode() {
        String str = this.city;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MobileLocationInfoWithCity(city=");
        sb.append(this.city);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getCity")
    public final String getCity() {
        return this.city;
    }

    public MobileLocationInfoWithCity(String str) {
        this.city = str;
    }
}
