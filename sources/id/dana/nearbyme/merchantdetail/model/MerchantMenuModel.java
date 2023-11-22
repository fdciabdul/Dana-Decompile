package id.dana.nearbyme.merchantdetail.model;

import id.dana.nearbyme.merchantdetail.enums.MerchantMenu;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00038\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u0010X\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011"}, d2 = {"Lid/dana/nearbyme/merchantdetail/model/MerchantMenuModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Z", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantdetail/enums/MerchantMenu;", "Lid/dana/nearbyme/merchantdetail/enums/MerchantMenu;", "MyBillsEntityDataFactory", "p1", "<init>", "(Lid/dana/nearbyme/merchantdetail/enums/MerchantMenu;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MerchantMenuModel {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final MerchantMenu MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MerchantMenuModel) {
            MerchantMenuModel merchantMenuModel = (MerchantMenuModel) p0;
            return this.MyBillsEntityDataFactory == merchantMenuModel.MyBillsEntityDataFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 == merchantMenuModel.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.MyBillsEntityDataFactory.hashCode();
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (hashCode * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantMenuModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    public MerchantMenuModel(MerchantMenu merchantMenu, boolean z) {
        Intrinsics.checkNotNullParameter(merchantMenu, "");
        this.MyBillsEntityDataFactory = merchantMenu;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    public /* synthetic */ MerchantMenuModel(MerchantMenu merchantMenu, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(merchantMenu, (i & 2) != 0 ? true : z);
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
