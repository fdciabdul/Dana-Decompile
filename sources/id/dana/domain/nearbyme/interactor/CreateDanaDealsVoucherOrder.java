package id.dana.domain.nearbyme.interactor;

import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.model.DanaDealsOrderRequest;
import id.dana.domain.nearbyme.model.ProductOrder;
import id.dana.domain.social.Result;
import id.dana.domain.social.core.SingleUseCase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/domain/nearbyme/interactor/CreateDanaDealsVoucherOrder;", "Lid/dana/domain/social/core/SingleUseCase;", "Lid/dana/domain/nearbyme/interactor/CreateDanaDealsVoucherOrder$Param;", "Lid/dana/domain/nearbyme/model/ProductOrder;", "params", "Lid/dana/domain/social/Result;", "buildUseCase", "(Lid/dana/domain/nearbyme/interactor/CreateDanaDealsVoucherOrder$Param;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "merchantInfoRepository", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "getMerchantInfoRepository", "()Lid/dana/domain/nearbyme/MerchantInfoRepository;", "<init>", "(Lid/dana/domain/nearbyme/MerchantInfoRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CreateDanaDealsVoucherOrder extends SingleUseCase<Param, ProductOrder> {
    private final MerchantInfoRepository merchantInfoRepository;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* bridge */ /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        return buildUseCase((Param) obj, (Continuation<? super Result<ProductOrder>>) continuation);
    }

    @JvmName(name = "getMerchantInfoRepository")
    public final MerchantInfoRepository getMerchantInfoRepository() {
        return this.merchantInfoRepository;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CreateDanaDealsVoucherOrder(id.dana.domain.nearbyme.MerchantInfoRepository r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.CreateDanaDealsVoucherOrder.<init>(id.dana.domain.nearbyme.MerchantInfoRepository):void");
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyme/interactor/CreateDanaDealsVoucherOrder$Param;", "", "Lid/dana/domain/nearbyme/model/DanaDealsOrderRequest;", "component1", "()Lid/dana/domain/nearbyme/model/DanaDealsOrderRequest;", "orderRequest", "copy", "(Lid/dana/domain/nearbyme/model/DanaDealsOrderRequest;)Lid/dana/domain/nearbyme/interactor/CreateDanaDealsVoucherOrder$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/nearbyme/model/DanaDealsOrderRequest;", "getOrderRequest", "<init>", "(Lid/dana/domain/nearbyme/model/DanaDealsOrderRequest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final DanaDealsOrderRequest orderRequest;

        public static /* synthetic */ Param copy$default(Param param, DanaDealsOrderRequest danaDealsOrderRequest, int i, Object obj) {
            if ((i & 1) != 0) {
                danaDealsOrderRequest = param.orderRequest;
            }
            return param.copy(danaDealsOrderRequest);
        }

        /* renamed from: component1  reason: from getter */
        public final DanaDealsOrderRequest getOrderRequest() {
            return this.orderRequest;
        }

        public final Param copy(DanaDealsOrderRequest orderRequest) {
            Intrinsics.checkNotNullParameter(orderRequest, "");
            return new Param(orderRequest);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Param) && Intrinsics.areEqual(this.orderRequest, ((Param) other).orderRequest);
        }

        public final int hashCode() {
            return this.orderRequest.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(orderRequest=");
            sb.append(this.orderRequest);
            sb.append(')');
            return sb.toString();
        }

        public Param(DanaDealsOrderRequest danaDealsOrderRequest) {
            Intrinsics.checkNotNullParameter(danaDealsOrderRequest, "");
            this.orderRequest = danaDealsOrderRequest;
        }

        @JvmName(name = "getOrderRequest")
        public final DanaDealsOrderRequest getOrderRequest() {
            return this.orderRequest;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object buildUseCase(id.dana.domain.nearbyme.interactor.CreateDanaDealsVoucherOrder.Param r5, kotlin.coroutines.Continuation<? super id.dana.domain.social.Result<id.dana.domain.nearbyme.model.ProductOrder>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof id.dana.domain.nearbyme.interactor.CreateDanaDealsVoucherOrder$buildUseCase$1
            if (r0 == 0) goto L14
            r0 = r6
            id.dana.domain.nearbyme.interactor.CreateDanaDealsVoucherOrder$buildUseCase$1 r0 = (id.dana.domain.nearbyme.interactor.CreateDanaDealsVoucherOrder$buildUseCase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            id.dana.domain.nearbyme.interactor.CreateDanaDealsVoucherOrder$buildUseCase$1 r0 = new id.dana.domain.nearbyme.interactor.CreateDanaDealsVoucherOrder$buildUseCase$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L44
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            id.dana.domain.nearbyme.MerchantInfoRepository r6 = r4.merchantInfoRepository
            id.dana.domain.nearbyme.model.DanaDealsOrderRequest r5 = r5.getOrderRequest()
            r0.label = r3
            java.lang.Object r6 = r6.createDanaDealsVoucherOrder(r5, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            id.dana.domain.nearbyme.model.ProductOrder r6 = (id.dana.domain.nearbyme.model.ProductOrder) r6
            java.lang.String r5 = r6.getCheckOutUrl()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 == 0) goto L53
            r3 = 0
        L53:
            if (r3 == 0) goto L62
            id.dana.domain.social.Result$Error r5 = new id.dana.domain.social.Result$Error
            java.lang.Exception r6 = new java.lang.Exception
            r6.<init>()
            r5.<init>(r6)
            id.dana.domain.social.Result r5 = (id.dana.domain.social.Result) r5
            goto L69
        L62:
            id.dana.domain.social.Result$Success r5 = new id.dana.domain.social.Result$Success
            r5.<init>(r6)
            id.dana.domain.social.Result r5 = (id.dana.domain.social.Result) r5
        L69:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.CreateDanaDealsVoucherOrder.buildUseCase(id.dana.domain.nearbyme.interactor.CreateDanaDealsVoucherOrder$Param, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
