package id.dana.data.nearbyme.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/nearbyme/model/MerchantDetailPromoConfigEntity;", "", "", "dealsLimit", "I", "getDealsLimit", "()I", "setDealsLimit", "(I)V", "", "dealsSectionEnable", "Z", "getDealsSectionEnable", "()Z", "setDealsSectionEnable", "(Z)V", "<init>", "(ZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MerchantDetailPromoConfigEntity {
    @SerializedName("deals_limit")
    private int dealsLimit;
    @SerializedName("deals_section_enable")
    private boolean dealsSectionEnable;

    public MerchantDetailPromoConfigEntity(boolean z, int i) {
        this.dealsSectionEnable = z;
        this.dealsLimit = i;
    }

    @JvmName(name = "getDealsSectionEnable")
    public final boolean getDealsSectionEnable() {
        return this.dealsSectionEnable;
    }

    @JvmName(name = "setDealsSectionEnable")
    public final void setDealsSectionEnable(boolean z) {
        this.dealsSectionEnable = z;
    }

    @JvmName(name = "getDealsLimit")
    public final int getDealsLimit() {
        return this.dealsLimit;
    }

    @JvmName(name = "setDealsLimit")
    public final void setDealsLimit(int i) {
        this.dealsLimit = i;
    }
}
