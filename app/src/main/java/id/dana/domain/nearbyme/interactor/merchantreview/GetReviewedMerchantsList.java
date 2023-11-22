package id.dana.domain.nearbyme.interactor.merchantreview;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.model.QueryUserReviews;
import id.dana.domain.social.Result;
import id.dana.domain.social.core.SingleUseCase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/domain/nearbyme/interactor/merchantreview/GetReviewedMerchantsList;", "Lid/dana/domain/social/core/SingleUseCase;", "Lid/dana/domain/nearbyme/interactor/merchantreview/GetReviewedMerchantsList$Param;", "Lid/dana/domain/nearbyme/model/QueryUserReviews;", "params", "Lid/dana/domain/social/Result;", "buildUseCase", "(Lid/dana/domain/nearbyme/interactor/merchantreview/GetReviewedMerchantsList$Param;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "merchantInfoRepository", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "<init>", "(Lid/dana/domain/nearbyme/MerchantInfoRepository;)V", "Companion", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetReviewedMerchantsList extends SingleUseCase<Param, QueryUserReviews> {
    public static final String GET_REVIEWED_MERCHANT_LIST = "id.dana.discovery.nearby.queryUserReviews";
    private final MerchantInfoRepository merchantInfoRepository;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* bridge */ /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        return buildUseCase((Param) obj, (Continuation<? super Result<QueryUserReviews>>) continuation);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetReviewedMerchantsList(id.dana.domain.nearbyme.MerchantInfoRepository r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.merchantreview.GetReviewedMerchantsList.<init>(id.dana.domain.nearbyme.MerchantInfoRepository):void");
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyme/interactor/merchantreview/GetReviewedMerchantsList$Param;", "", "", "component1", "()I", "component2", SecurityConstants.KEY_PAGE_SIZE, "pageNum", "copy", "(II)Lid/dana/domain/nearbyme/interactor/merchantreview/GetReviewedMerchantsList$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getPageNum", "getPageSize", "<init>", "(II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final int pageNum;
        private final int pageSize;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Param() {
            /*
                r3 = this;
                r0 = 0
                r1 = 3
                r2 = 0
                r3.<init>(r0, r0, r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.merchantreview.GetReviewedMerchantsList.Param.<init>():void");
        }

        public static /* synthetic */ Param copy$default(Param param, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = param.pageSize;
            }
            if ((i3 & 2) != 0) {
                i2 = param.pageNum;
            }
            return param.copy(i, i2);
        }

        /* renamed from: component1  reason: from getter */
        public final int getPageSize() {
            return this.pageSize;
        }

        /* renamed from: component2  reason: from getter */
        public final int getPageNum() {
            return this.pageNum;
        }

        public final Param copy(int pageSize, int pageNum) {
            return new Param(pageSize, pageNum);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Param) {
                Param param = (Param) other;
                return this.pageSize == param.pageSize && this.pageNum == param.pageNum;
            }
            return false;
        }

        public final int hashCode() {
            return (this.pageSize * 31) + this.pageNum;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(pageSize=");
            sb.append(this.pageSize);
            sb.append(", pageNum=");
            sb.append(this.pageNum);
            sb.append(')');
            return sb.toString();
        }

        public Param(int i, int i2) {
            this.pageSize = i;
            this.pageNum = i2;
        }

        public /* synthetic */ Param(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 10 : i, (i3 & 2) != 0 ? 1 : i2);
        }

        @JvmName(name = "getPageSize")
        public final int getPageSize() {
            return this.pageSize;
        }

        @JvmName(name = "getPageNum")
        public final int getPageNum() {
            return this.pageNum;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object buildUseCase(id.dana.domain.nearbyme.interactor.merchantreview.GetReviewedMerchantsList.Param r5, kotlin.coroutines.Continuation<? super id.dana.domain.social.Result<id.dana.domain.nearbyme.model.QueryUserReviews>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof id.dana.domain.nearbyme.interactor.merchantreview.GetReviewedMerchantsList$buildUseCase$1
            if (r0 == 0) goto L14
            r0 = r6
            id.dana.domain.nearbyme.interactor.merchantreview.GetReviewedMerchantsList$buildUseCase$1 r0 = (id.dana.domain.nearbyme.interactor.merchantreview.GetReviewedMerchantsList$buildUseCase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            id.dana.domain.nearbyme.interactor.merchantreview.GetReviewedMerchantsList$buildUseCase$1 r0 = new id.dana.domain.nearbyme.interactor.merchantreview.GetReviewedMerchantsList$buildUseCase$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L48
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            id.dana.domain.nearbyme.MerchantInfoRepository r6 = r4.merchantInfoRepository
            int r2 = r5.getPageSize()
            int r5 = r5.getPageNum()
            r0.label = r3
            java.lang.Object r6 = r6.getReviewedMerchantsList(r2, r5, r0)
            if (r6 != r1) goto L48
            return r1
        L48:
            id.dana.domain.social.Result$Success r5 = new id.dana.domain.social.Result$Success
            r5.<init>(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.merchantreview.GetReviewedMerchantsList.buildUseCase(id.dana.domain.nearbyme.interactor.merchantreview.GetReviewedMerchantsList$Param, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
