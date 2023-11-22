package id.dana.domain.nearbyme.interactor;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.model.MerchantReviews;
import id.dana.domain.social.Result;
import id.dana.domain.social.core.SingleUseCase;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetMerchantReviews;", "Lid/dana/domain/social/core/SingleUseCase;", "Lid/dana/domain/nearbyme/interactor/GetMerchantReviews$Param;", "Lid/dana/domain/nearbyme/model/MerchantReviews;", "params", "Lid/dana/domain/social/Result;", "buildUseCase", "(Lid/dana/domain/nearbyme/interactor/GetMerchantReviews$Param;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/account/AccountRepository;", "accountRepository", "Lid/dana/domain/account/AccountRepository;", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "merchantInfoRepository", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "<init>", "(Lid/dana/domain/nearbyme/MerchantInfoRepository;Lid/dana/domain/account/AccountRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetMerchantReviews extends SingleUseCase<Param, MerchantReviews> {
    private final AccountRepository accountRepository;
    private final MerchantInfoRepository merchantInfoRepository;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* bridge */ /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        return buildUseCase((Param) obj, (Continuation<? super Result<MerchantReviews>>) continuation);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetMerchantReviews(id.dana.domain.nearbyme.MerchantInfoRepository r3, id.dana.domain.account.AccountRepository r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            r2.merchantInfoRepository = r3
            r2.accountRepository = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.GetMerchantReviews.<init>(id.dana.domain.nearbyme.MerchantInfoRepository, id.dana.domain.account.AccountRepository):void");
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJH\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u001a\u0010\u0010\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b \u0010\bR\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b!\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetMerchantReviews$Param;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "", "component5", "()Ljava/util/List;", "merchantId", FeatureParams.SHOP_ID, "pageNum", SecurityConstants.KEY_PAGE_SIZE, "filterCriteria", "copy", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/List;)Lid/dana/domain/nearbyme/interactor/GetMerchantReviews$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/util/List;", "getFilterCriteria", "Ljava/lang/String;", "getMerchantId", "I", "getPageNum", "getPageSize", "getShopId", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final List<String> filterCriteria;
        private final String merchantId;
        private final int pageNum;
        private final int pageSize;
        private final String shopId;

        public static /* synthetic */ Param copy$default(Param param, String str, String str2, int i, int i2, List list, int i3, Object obj) {
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
            List<String> list2 = list;
            if ((i3 & 16) != 0) {
                list2 = param.filterCriteria;
            }
            return param.copy(str, str3, i4, i5, list2);
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

        public final List<String> component5() {
            return this.filterCriteria;
        }

        public final Param copy(String merchantId, String shopId, int pageNum, int pageSize, List<String> filterCriteria) {
            Intrinsics.checkNotNullParameter(merchantId, "");
            Intrinsics.checkNotNullParameter(shopId, "");
            Intrinsics.checkNotNullParameter(filterCriteria, "");
            return new Param(merchantId, shopId, pageNum, pageSize, filterCriteria);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Param) {
                Param param = (Param) other;
                return Intrinsics.areEqual(this.merchantId, param.merchantId) && Intrinsics.areEqual(this.shopId, param.shopId) && this.pageNum == param.pageNum && this.pageSize == param.pageSize && Intrinsics.areEqual(this.filterCriteria, param.filterCriteria);
            }
            return false;
        }

        public final int hashCode() {
            return (((((((this.merchantId.hashCode() * 31) + this.shopId.hashCode()) * 31) + this.pageNum) * 31) + this.pageSize) * 31) + this.filterCriteria.hashCode();
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
            sb.append(", filterCriteria=");
            sb.append(this.filterCriteria);
            sb.append(')');
            return sb.toString();
        }

        public Param(String str, String str2, int i, int i2, List<String> list) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(list, "");
            this.merchantId = str;
            this.shopId = str2;
            this.pageNum = i;
            this.pageSize = i2;
            this.filterCriteria = list;
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

        public /* synthetic */ Param(String str, String str2, int i, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i3 & 4) != 0 ? 1 : i, (i3 & 8) != 0 ? 10 : i2, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list);
        }

        @JvmName(name = "getFilterCriteria")
        public final List<String> getFilterCriteria() {
            return this.filterCriteria;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object buildUseCase(id.dana.domain.nearbyme.interactor.GetMerchantReviews.Param r11, kotlin.coroutines.Continuation<? super id.dana.domain.social.Result<id.dana.domain.nearbyme.model.MerchantReviews>> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof id.dana.domain.nearbyme.interactor.GetMerchantReviews$buildUseCase$1
            if (r0 == 0) goto L14
            r0 = r12
            id.dana.domain.nearbyme.interactor.GetMerchantReviews$buildUseCase$1 r0 = (id.dana.domain.nearbyme.interactor.GetMerchantReviews$buildUseCase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 + r2
            r0.label = r12
            goto L19
        L14:
            id.dana.domain.nearbyme.interactor.GetMerchantReviews$buildUseCase$1 r0 = new id.dana.domain.nearbyme.interactor.GetMerchantReviews$buildUseCase$1
            r0.<init>(r10, r12)
        L19:
            r7 = r0
            java.lang.Object r12 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r8 = 1
            if (r1 == 0) goto L37
            if (r1 != r8) goto L2f
            java.lang.Object r11 = r7.L$0
            java.lang.String r11 = (java.lang.String) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L6a
        L2f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L37:
            kotlin.ResultKt.throwOnFailure(r12)
            id.dana.domain.account.AccountRepository r12 = r10.accountRepository
            io.reactivex.Observable r12 = r12.getUserId()
            java.lang.Object r12 = r12.blockingFirst()
            java.lang.String r12 = (java.lang.String) r12
            id.dana.domain.nearbyme.MerchantInfoRepository r1 = r10.merchantInfoRepository
            java.lang.String r2 = r11.getMerchantId()
            java.lang.String r3 = r11.getShopId()
            int r4 = r11.getPageNum()
            int r5 = r11.getPageSize()
            java.util.List r6 = r11.getFilterCriteria()
            r7.L$0 = r12
            r7.label = r8
            java.lang.Object r11 = r1.getMerchantReview(r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L67
            return r0
        L67:
            r9 = r12
            r12 = r11
            r11 = r9
        L6a:
            r0 = r12
            id.dana.domain.nearbyme.model.MerchantReviews r0 = (id.dana.domain.nearbyme.model.MerchantReviews) r0
            java.util.List r1 = r0.getReviews()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L7e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L9a
            java.lang.Object r3 = r1.next()
            r4 = r3
            id.dana.domain.nearbyme.model.MerchantReview r4 = (id.dana.domain.nearbyme.model.MerchantReview) r4
            java.lang.String r4 = r4.getUserId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r11)
            r4 = r4 ^ r8
            if (r4 == 0) goto L7e
            r2.add(r3)
            goto L7e
        L9a:
            java.util.List r2 = (java.util.List) r2
            r0.setReviews(r2)
            id.dana.domain.social.Result$Success r11 = new id.dana.domain.social.Result$Success
            r11.<init>(r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.GetMerchantReviews.buildUseCase(id.dana.domain.nearbyme.interactor.GetMerchantReviews$Param, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
