package id.dana.domain.wallet_v3.model;

import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005Jj\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001d\u0010\u0005R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001e\u0010\u0005R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001f\u0010\u0005R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b \u0010\u0005"}, d2 = {"Lid/dana/domain/wallet_v3/model/BottomSheetAllService;", "", "", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "component1", "()Ljava/util/List;", "component2", "component3", "component4", "component5", "paymentService", "financialService", "voucherService", "loyaltyService", "identityService", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lid/dana/domain/wallet_v3/model/BottomSheetAllService;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getFinancialService", "getIdentityService", "getLoyaltyService", "getPaymentService", "getVoucherService", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BottomSheetAllService {
    private final List<ThirdPartyServiceResponse> financialService;
    private final List<ThirdPartyServiceResponse> identityService;
    private final List<ThirdPartyServiceResponse> loyaltyService;
    private final List<ThirdPartyServiceResponse> paymentService;
    private final List<ThirdPartyServiceResponse> voucherService;

    public BottomSheetAllService() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ BottomSheetAllService copy$default(BottomSheetAllService bottomSheetAllService, List list, List list2, List list3, List list4, List list5, int i, Object obj) {
        List<ThirdPartyServiceResponse> list6 = list;
        if ((i & 1) != 0) {
            list6 = bottomSheetAllService.paymentService;
        }
        List<ThirdPartyServiceResponse> list7 = list2;
        if ((i & 2) != 0) {
            list7 = bottomSheetAllService.financialService;
        }
        List list8 = list7;
        List<ThirdPartyServiceResponse> list9 = list3;
        if ((i & 4) != 0) {
            list9 = bottomSheetAllService.voucherService;
        }
        List list10 = list9;
        List<ThirdPartyServiceResponse> list11 = list4;
        if ((i & 8) != 0) {
            list11 = bottomSheetAllService.loyaltyService;
        }
        List list12 = list11;
        List<ThirdPartyServiceResponse> list13 = list5;
        if ((i & 16) != 0) {
            list13 = bottomSheetAllService.identityService;
        }
        return bottomSheetAllService.copy(list6, list8, list10, list12, list13);
    }

    public final List<ThirdPartyServiceResponse> component1() {
        return this.paymentService;
    }

    public final List<ThirdPartyServiceResponse> component2() {
        return this.financialService;
    }

    public final List<ThirdPartyServiceResponse> component3() {
        return this.voucherService;
    }

    public final List<ThirdPartyServiceResponse> component4() {
        return this.loyaltyService;
    }

    public final List<ThirdPartyServiceResponse> component5() {
        return this.identityService;
    }

    public final BottomSheetAllService copy(List<ThirdPartyServiceResponse> paymentService, List<ThirdPartyServiceResponse> financialService, List<ThirdPartyServiceResponse> voucherService, List<ThirdPartyServiceResponse> loyaltyService, List<ThirdPartyServiceResponse> identityService) {
        return new BottomSheetAllService(paymentService, financialService, voucherService, loyaltyService, identityService);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BottomSheetAllService) {
            BottomSheetAllService bottomSheetAllService = (BottomSheetAllService) other;
            return Intrinsics.areEqual(this.paymentService, bottomSheetAllService.paymentService) && Intrinsics.areEqual(this.financialService, bottomSheetAllService.financialService) && Intrinsics.areEqual(this.voucherService, bottomSheetAllService.voucherService) && Intrinsics.areEqual(this.loyaltyService, bottomSheetAllService.loyaltyService) && Intrinsics.areEqual(this.identityService, bottomSheetAllService.identityService);
        }
        return false;
    }

    public final int hashCode() {
        List<ThirdPartyServiceResponse> list = this.paymentService;
        int hashCode = list == null ? 0 : list.hashCode();
        List<ThirdPartyServiceResponse> list2 = this.financialService;
        int hashCode2 = list2 == null ? 0 : list2.hashCode();
        List<ThirdPartyServiceResponse> list3 = this.voucherService;
        int hashCode3 = list3 == null ? 0 : list3.hashCode();
        List<ThirdPartyServiceResponse> list4 = this.loyaltyService;
        int hashCode4 = list4 == null ? 0 : list4.hashCode();
        List<ThirdPartyServiceResponse> list5 = this.identityService;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (list5 != null ? list5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BottomSheetAllService(paymentService=");
        sb.append(this.paymentService);
        sb.append(", financialService=");
        sb.append(this.financialService);
        sb.append(", voucherService=");
        sb.append(this.voucherService);
        sb.append(", loyaltyService=");
        sb.append(this.loyaltyService);
        sb.append(", identityService=");
        sb.append(this.identityService);
        sb.append(')');
        return sb.toString();
    }

    public BottomSheetAllService(List<ThirdPartyServiceResponse> list, List<ThirdPartyServiceResponse> list2, List<ThirdPartyServiceResponse> list3, List<ThirdPartyServiceResponse> list4, List<ThirdPartyServiceResponse> list5) {
        this.paymentService = list;
        this.financialService = list2;
        this.voucherService = list3;
        this.loyaltyService = list4;
        this.identityService = list5;
    }

    public /* synthetic */ BottomSheetAllService(List list, List list2, List list3, List list4, List list5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3, (i & 8) != 0 ? CollectionsKt.emptyList() : list4, (i & 16) != 0 ? CollectionsKt.emptyList() : list5);
    }

    @JvmName(name = "getPaymentService")
    public final List<ThirdPartyServiceResponse> getPaymentService() {
        return this.paymentService;
    }

    @JvmName(name = "getFinancialService")
    public final List<ThirdPartyServiceResponse> getFinancialService() {
        return this.financialService;
    }

    @JvmName(name = "getVoucherService")
    public final List<ThirdPartyServiceResponse> getVoucherService() {
        return this.voucherService;
    }

    @JvmName(name = "getLoyaltyService")
    public final List<ThirdPartyServiceResponse> getLoyaltyService() {
        return this.loyaltyService;
    }

    @JvmName(name = "getIdentityService")
    public final List<ThirdPartyServiceResponse> getIdentityService() {
        return this.identityService;
    }
}
