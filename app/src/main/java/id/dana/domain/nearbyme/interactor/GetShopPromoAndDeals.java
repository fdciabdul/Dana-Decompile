package id.dana.domain.nearbyme.interactor;

import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.domain.core.usecase.FlowUseCase;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.model.PromoDealsInfo;
import id.dana.domain.social.Result;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetShopPromoAndDeals;", "Lid/dana/domain/core/usecase/FlowUseCase;", "Lid/dana/domain/nearbyme/interactor/GetShopPromoAndDeals$Params;", "Lid/dana/domain/nearbyme/model/PromoDealsInfo;", "params", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/domain/social/Result;", "execute", "(Lid/dana/domain/nearbyme/interactor/GetShopPromoAndDeals$Params;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "merchantInfoRepository", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "Lkotlinx/coroutines/CoroutineDispatcher;", "defaultDispatcher", "<init>", "(Lid/dana/domain/nearbyme/MerchantInfoRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetShopPromoAndDeals extends FlowUseCase<Params, PromoDealsInfo> {
    private final MerchantInfoRepository merchantInfoRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetShopPromoAndDeals(MerchantInfoRepository merchantInfoRepository, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        Intrinsics.checkNotNullParameter(merchantInfoRepository, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        this.merchantInfoRepository = merchantInfoRepository;
    }

    @Override // id.dana.domain.core.usecase.FlowUseCase
    public final Flow<Result<PromoDealsInfo>> execute(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return FlowKt.combine(FlowKt.flow(new GetShopPromoAndDeals$execute$promoFlow$1(params, this, null)), FlowKt.flow(new GetShopPromoAndDeals$execute$dealsFlow$1(this, params, null)), new GetShopPromoAndDeals$execute$1(null));
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u0018\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\b"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetShopPromoAndDeals$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "", "component4", "()I", "merchantId", FeatureParams.SHOP_ID, "shouldFetchPromo", "dealsPageSize", "copy", "(Ljava/lang/String;Ljava/lang/String;ZI)Lid/dana/domain/nearbyme/interactor/GetShopPromoAndDeals$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getDealsPageSize", "Ljava/lang/String;", "getMerchantId", "getShopId", "Z", "getShouldFetchPromo", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final int dealsPageSize;
        private final String merchantId;
        private final String shopId;
        private final boolean shouldFetchPromo;

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, boolean z, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = params.merchantId;
            }
            if ((i2 & 2) != 0) {
                str2 = params.shopId;
            }
            if ((i2 & 4) != 0) {
                z = params.shouldFetchPromo;
            }
            if ((i2 & 8) != 0) {
                i = params.dealsPageSize;
            }
            return params.copy(str, str2, z, i);
        }

        /* renamed from: component1  reason: from getter */
        public final String getMerchantId() {
            return this.merchantId;
        }

        /* renamed from: component2  reason: from getter */
        public final String getShopId() {
            return this.shopId;
        }

        /* renamed from: component3  reason: from getter */
        public final boolean getShouldFetchPromo() {
            return this.shouldFetchPromo;
        }

        /* renamed from: component4  reason: from getter */
        public final int getDealsPageSize() {
            return this.dealsPageSize;
        }

        public final Params copy(String merchantId, String shopId, boolean shouldFetchPromo, int dealsPageSize) {
            Intrinsics.checkNotNullParameter(merchantId, "");
            Intrinsics.checkNotNullParameter(shopId, "");
            return new Params(merchantId, shopId, shouldFetchPromo, dealsPageSize);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.merchantId, params.merchantId) && Intrinsics.areEqual(this.shopId, params.shopId) && this.shouldFetchPromo == params.shouldFetchPromo && this.dealsPageSize == params.dealsPageSize;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.merchantId.hashCode();
            int hashCode2 = this.shopId.hashCode();
            boolean z = this.shouldFetchPromo;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (((((hashCode * 31) + hashCode2) * 31) + i) * 31) + this.dealsPageSize;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(merchantId=");
            sb.append(this.merchantId);
            sb.append(", shopId=");
            sb.append(this.shopId);
            sb.append(", shouldFetchPromo=");
            sb.append(this.shouldFetchPromo);
            sb.append(", dealsPageSize=");
            sb.append(this.dealsPageSize);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, boolean z, int i) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.merchantId = str;
            this.shopId = str2;
            this.shouldFetchPromo = z;
            this.dealsPageSize = i;
        }

        public /* synthetic */ Params(String str, String str2, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, z, (i2 & 8) != 0 ? 10 : i);
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "getShopId")
        public final String getShopId() {
            return this.shopId;
        }

        @JvmName(name = "getShouldFetchPromo")
        public final boolean getShouldFetchPromo() {
            return this.shouldFetchPromo;
        }

        @JvmName(name = "getDealsPageSize")
        public final int getDealsPageSize() {
            return this.dealsPageSize;
        }
    }
}
