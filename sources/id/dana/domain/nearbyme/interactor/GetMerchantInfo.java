package id.dana.domain.nearbyme.interactor;

import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.domain.social.Result;
import id.dana.domain.social.core.SingleUseCase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetMerchantInfo;", "Lid/dana/domain/social/core/SingleUseCase;", "Lid/dana/domain/nearbyme/interactor/GetMerchantInfo$Params;", "Lid/dana/domain/nearbyme/model/Shop;", "params", "Lid/dana/domain/social/Result;", "buildUseCase", "(Lid/dana/domain/nearbyme/interactor/GetMerchantInfo$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "merchantInfoRepository", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "<init>", "(Lid/dana/domain/nearbyme/MerchantInfoRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetMerchantInfo extends SingleUseCase<Params, Shop> {
    public static final String OPERATION_TYPE = "alipayplus.mobilewallet.merchant.info.query";
    private final MerchantInfoRepository merchantInfoRepository;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* bridge */ /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        return buildUseCase((Params) obj, (Continuation<? super Result<Shop>>) continuation);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetMerchantInfo(id.dana.domain.nearbyme.MerchantInfoRepository r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.GetMerchantInfo.<init>(id.dana.domain.nearbyme.MerchantInfoRepository):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object buildUseCase(id.dana.domain.nearbyme.interactor.GetMerchantInfo.Params r6, kotlin.coroutines.Continuation<? super id.dana.domain.social.Result<id.dana.domain.nearbyme.model.Shop>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof id.dana.domain.nearbyme.interactor.GetMerchantInfo$buildUseCase$1
            if (r0 == 0) goto L14
            r0 = r7
            id.dana.domain.nearbyme.interactor.GetMerchantInfo$buildUseCase$1 r0 = (id.dana.domain.nearbyme.interactor.GetMerchantInfo$buildUseCase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            id.dana.domain.nearbyme.interactor.GetMerchantInfo$buildUseCase$1 r0 = new id.dana.domain.nearbyme.interactor.GetMerchantInfo$buildUseCase$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4c
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            id.dana.domain.nearbyme.MerchantInfoRepository r7 = r5.merchantInfoRepository
            java.lang.String r2 = r6.getMerchantId()
            java.lang.String r4 = r6.getShopId()
            boolean r6 = r6.getUseNewMerchantCategory()
            r0.label = r3
            java.lang.Object r7 = r7.getMerchantInfo(r2, r4, r6, r0)
            if (r7 != r1) goto L4c
            return r1
        L4c:
            id.dana.domain.social.Result$Success r6 = new id.dana.domain.social.Result$Success
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.GetMerchantInfo.buildUseCase(id.dana.domain.nearbyme.interactor.GetMerchantInfo$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\b"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetMerchantInfo$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", FeatureParams.SHOP_ID, "merchantId", "useNewMerchantCategory", "copy", "(Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/domain/nearbyme/interactor/GetMerchantInfo$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMerchantId", "getShopId", "Z", "getUseNewMerchantCategory", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final String merchantId;
        private final String shopId;
        private final boolean useNewMerchantCategory;

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.shopId;
            }
            if ((i & 2) != 0) {
                str2 = params.merchantId;
            }
            if ((i & 4) != 0) {
                z = params.useNewMerchantCategory;
            }
            return params.copy(str, str2, z);
        }

        /* renamed from: component1  reason: from getter */
        public final String getShopId() {
            return this.shopId;
        }

        /* renamed from: component2  reason: from getter */
        public final String getMerchantId() {
            return this.merchantId;
        }

        /* renamed from: component3  reason: from getter */
        public final boolean getUseNewMerchantCategory() {
            return this.useNewMerchantCategory;
        }

        public final Params copy(String shopId, String merchantId, boolean useNewMerchantCategory) {
            Intrinsics.checkNotNullParameter(shopId, "");
            Intrinsics.checkNotNullParameter(merchantId, "");
            return new Params(shopId, merchantId, useNewMerchantCategory);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.shopId, params.shopId) && Intrinsics.areEqual(this.merchantId, params.merchantId) && this.useNewMerchantCategory == params.useNewMerchantCategory;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.shopId.hashCode();
            int hashCode2 = this.merchantId.hashCode();
            boolean z = this.useNewMerchantCategory;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (((hashCode * 31) + hashCode2) * 31) + i;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(shopId=");
            sb.append(this.shopId);
            sb.append(", merchantId=");
            sb.append(this.merchantId);
            sb.append(", useNewMerchantCategory=");
            sb.append(this.useNewMerchantCategory);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.shopId = str;
            this.merchantId = str2;
            this.useNewMerchantCategory = z;
        }

        public /* synthetic */ Params(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? false : z);
        }

        @JvmName(name = "getShopId")
        public final String getShopId() {
            return this.shopId;
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "getUseNewMerchantCategory")
        public final boolean getUseNewMerchantCategory() {
            return this.useNewMerchantCategory;
        }
    }
}
