package id.dana.nearbyme.merchantdetail.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;", "Ljava/io/Serializable;", "", "dealsLimit", "I", "getDealsLimit", "()I", "setDealsLimit", "(I)V", "", "dealsSectionEnable", "Z", "getDealsSectionEnable", "()Z", "setDealsSectionEnable", "(Z)V", "<init>", "(ZI)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDetailPromoConfigModel implements Serializable {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MerchantDetailPromoConfigModel DEFAULT_SETTING = new MerchantDetailPromoConfigModel(false, 4);
    private int dealsLimit;
    private boolean dealsSectionEnable;

    public MerchantDetailPromoConfigModel(boolean z, int i) {
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

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel$Companion;", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;", "DEFAULT_SETTING", "Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;", "PlaceComponentResult", "()Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "PlaceComponentResult")
        public static MerchantDetailPromoConfigModel PlaceComponentResult() {
            return MerchantDetailPromoConfigModel.DEFAULT_SETTING;
        }
    }
}
