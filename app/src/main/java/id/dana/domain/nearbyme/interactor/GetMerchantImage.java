package id.dana.domain.nearbyme.interactor;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.domain.core.usecase.FlowUseCase;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.model.MerchantImage;
import id.dana.domain.social.Result;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u0011B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetMerchantImage;", "Lid/dana/domain/core/usecase/FlowUseCase;", "Lid/dana/domain/nearbyme/interactor/GetMerchantImage$Param;", "", "Lid/dana/domain/nearbyme/model/MerchantImage;", "params", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/domain/social/Result;", "execute", "(Lid/dana/domain/nearbyme/interactor/GetMerchantImage$Param;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "merchantInfoRepository", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "Lkotlinx/coroutines/CoroutineDispatcher;", "defaultDispatcher", "<init>", "(Lid/dana/domain/nearbyme/MerchantInfoRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetMerchantImage extends FlowUseCase<Param, List<? extends MerchantImage>> {
    private final MerchantInfoRepository merchantInfoRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetMerchantImage(MerchantInfoRepository merchantInfoRepository, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        Intrinsics.checkNotNullParameter(merchantInfoRepository, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        this.merchantInfoRepository = merchantInfoRepository;
    }

    @Override // id.dana.domain.core.usecase.FlowUseCase
    public final Flow<Result<List<MerchantImage>>> execute(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.merchantInfoRepository.getMerchantImage(params.getMerchantId(), params.getShopId(), params.getPageNum(), params.getPageSize(), params.getSkipCache());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0017\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R\u0017\u0010\r\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u001a\u0010\u0010\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001d\u0010\bR\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\f"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetMerchantImage$Param;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "", "component5", "()Z", "merchantId", FeatureParams.SHOP_ID, "pageNum", SecurityConstants.KEY_PAGE_SIZE, "skipCache", "copy", "(Ljava/lang/String;Ljava/lang/String;IIZ)Lid/dana/domain/nearbyme/interactor/GetMerchantImage$Param;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getMerchantId", "I", "getPageNum", "getPageSize", "getShopId", "Z", "getSkipCache", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final String merchantId;
        private final int pageNum;
        private final int pageSize;
        private final String shopId;
        private final boolean skipCache;

        public static /* synthetic */ Param copy$default(Param param, String str, String str2, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = param.merchantId;
            }
            if ((i3 & 2) != 0) {
                str2 = param.shopId;
            }
            String str3 = str2;
            if ((i3 & 4) != 0) {
                i = param.pageNum;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                i2 = param.pageSize;
            }
            int i5 = i2;
            if ((i3 & 16) != 0) {
                z = param.skipCache;
            }
            return param.copy(str, str3, i4, i5, z);
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
        public final int getPageNum() {
            return this.pageNum;
        }

        /* renamed from: component4  reason: from getter */
        public final int getPageSize() {
            return this.pageSize;
        }

        /* renamed from: component5  reason: from getter */
        public final boolean getSkipCache() {
            return this.skipCache;
        }

        public final Param copy(String merchantId, String shopId, int pageNum, int pageSize, boolean skipCache) {
            Intrinsics.checkNotNullParameter(merchantId, "");
            Intrinsics.checkNotNullParameter(shopId, "");
            return new Param(merchantId, shopId, pageNum, pageSize, skipCache);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Param) {
                Param param = (Param) other;
                return Intrinsics.areEqual(this.merchantId, param.merchantId) && Intrinsics.areEqual(this.shopId, param.shopId) && this.pageNum == param.pageNum && this.pageSize == param.pageSize && this.skipCache == param.skipCache;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.merchantId.hashCode();
            int hashCode2 = this.shopId.hashCode();
            int i = this.pageNum;
            int i2 = this.pageSize;
            boolean z = this.skipCache;
            int i3 = z;
            if (z != 0) {
                i3 = 1;
            }
            return (((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + i2) * 31) + i3;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(merchantId=");
            sb.append(this.merchantId);
            sb.append(", shopId=");
            sb.append(this.shopId);
            sb.append(", pageNum=");
            sb.append(this.pageNum);
            sb.append(", pageSize=");
            sb.append(this.pageSize);
            sb.append(", skipCache=");
            sb.append(this.skipCache);
            sb.append(')');
            return sb.toString();
        }

        public Param(String str, String str2, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.merchantId = str;
            this.shopId = str2;
            this.pageNum = i;
            this.pageSize = i2;
            this.skipCache = z;
        }

        public /* synthetic */ Param(String str, String str2, int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i3 & 4) != 0 ? 1 : i, (i3 & 8) != 0 ? 10 : i2, (i3 & 16) != 0 ? false : z);
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "getShopId")
        public final String getShopId() {
            return this.shopId;
        }

        @JvmName(name = "getPageNum")
        public final int getPageNum() {
            return this.pageNum;
        }

        @JvmName(name = "getPageSize")
        public final int getPageSize() {
            return this.pageSize;
        }

        @JvmName(name = "getSkipCache")
        public final boolean getSkipCache() {
            return this.skipCache;
        }
    }
}
