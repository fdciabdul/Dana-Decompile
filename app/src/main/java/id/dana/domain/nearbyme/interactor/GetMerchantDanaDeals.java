package id.dana.domain.nearbyme.interactor;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.model.MerchantProductInfo;
import id.dana.domain.social.Result;
import id.dana.domain.social.core.SingleUseCase;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetMerchantDanaDeals;", "Lid/dana/domain/social/core/SingleUseCase;", "Lid/dana/domain/nearbyme/interactor/GetMerchantDanaDeals$Params;", "", "Lid/dana/domain/nearbyme/model/MerchantProductInfo;", "params", "Lid/dana/domain/social/Result;", "buildUseCase", "(Lid/dana/domain/nearbyme/interactor/GetMerchantDanaDeals$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "merchantInfoRepository", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "<init>", "(Lid/dana/domain/nearbyme/MerchantInfoRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetMerchantDanaDeals extends SingleUseCase<Params, List<? extends MerchantProductInfo>> {
    private final MerchantInfoRepository merchantInfoRepository;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* bridge */ /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        return buildUseCase((Params) obj, (Continuation<? super Result<? extends List<MerchantProductInfo>>>) continuation);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetMerchantDanaDeals(id.dana.domain.nearbyme.MerchantInfoRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            r2.merchantInfoRepository = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.GetMerchantDanaDeals.<init>(id.dana.domain.nearbyme.MerchantInfoRepository):void");
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetMerchantDanaDeals$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Integer;", "merchantId", FeatureParams.SHOP_ID, SecurityConstants.KEY_PAGE_SIZE, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lid/dana/domain/nearbyme/interactor/GetMerchantDanaDeals$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMerchantId", "Ljava/lang/Integer;", "getPageSize", "getShopId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final String merchantId;
        private final Integer pageSize;
        private final String shopId;

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.merchantId;
            }
            if ((i & 2) != 0) {
                str2 = params.shopId;
            }
            if ((i & 4) != 0) {
                num = params.pageSize;
            }
            return params.copy(str, str2, num);
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
        public final Integer getPageSize() {
            return this.pageSize;
        }

        public final Params copy(String merchantId, String shopId, Integer pageSize) {
            Intrinsics.checkNotNullParameter(merchantId, "");
            Intrinsics.checkNotNullParameter(shopId, "");
            return new Params(merchantId, shopId, pageSize);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.merchantId, params.merchantId) && Intrinsics.areEqual(this.shopId, params.shopId) && Intrinsics.areEqual(this.pageSize, params.pageSize);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.merchantId.hashCode();
            int hashCode2 = this.shopId.hashCode();
            Integer num = this.pageSize;
            return (((hashCode * 31) + hashCode2) * 31) + (num == null ? 0 : num.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(merchantId=");
            sb.append(this.merchantId);
            sb.append(", shopId=");
            sb.append(this.shopId);
            sb.append(", pageSize=");
            sb.append(this.pageSize);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, Integer num) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.merchantId = str;
            this.shopId = str2;
            this.pageSize = num;
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "getShopId")
        public final String getShopId() {
            return this.shopId;
        }

        @JvmName(name = "getPageSize")
        public final Integer getPageSize() {
            return this.pageSize;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object buildUseCase(id.dana.domain.nearbyme.interactor.GetMerchantDanaDeals.Params r10, kotlin.coroutines.Continuation<? super id.dana.domain.social.Result<? extends java.util.List<id.dana.domain.nearbyme.model.MerchantProductInfo>>> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof id.dana.domain.nearbyme.interactor.GetMerchantDanaDeals$buildUseCase$1
            if (r0 == 0) goto L14
            r0 = r11
            id.dana.domain.nearbyme.interactor.GetMerchantDanaDeals$buildUseCase$1 r0 = (id.dana.domain.nearbyme.interactor.GetMerchantDanaDeals$buildUseCase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 + r2
            r0.label = r11
            goto L19
        L14:
            id.dana.domain.nearbyme.interactor.GetMerchantDanaDeals$buildUseCase$1 r0 = new id.dana.domain.nearbyme.interactor.GetMerchantDanaDeals$buildUseCase$1
            r0.<init>(r9, r11)
        L19:
            r6 = r0
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.throwOnFailure(r11)
            goto L5e
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            kotlin.ResultKt.throwOnFailure(r11)
            id.dana.domain.nearbyme.MerchantInfoRepository r1 = r9.merchantInfoRepository
            java.lang.String r11 = r10.getMerchantId()
            java.lang.String r3 = r10.getShopId()
            java.lang.Integer r10 = r10.getPageSize()
            if (r10 == 0) goto L4c
            int r10 = r10.intValue()
            r4 = r10
            goto L50
        L4c:
            r10 = 10
            r4 = 10
        L50:
            r6.label = r2
            r5 = 0
            r7 = 8
            r8 = 0
            r2 = r11
            java.lang.Object r11 = id.dana.domain.nearbyme.MerchantInfoRepository.CC.getMerchantPromoDanaDeal$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != r0) goto L5e
            return r0
        L5e:
            id.dana.domain.social.Result$Success r10 = new id.dana.domain.social.Result$Success
            r10.<init>(r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.GetMerchantDanaDeals.buildUseCase(id.dana.domain.nearbyme.interactor.GetMerchantDanaDeals$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
