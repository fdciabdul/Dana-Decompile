package id.dana.data.nearbyme.repository.source.network;

import android.content.Context;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.nearbyme.MerchantInfoEntityData;
import id.dana.data.nearbyme.repository.source.network.request.ProductOrderRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.BaseMerchantInfoRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.MerchantAdditionalInfoRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.MerchantDetailInfoRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.MerchantImageRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.MerchantPromoDanaDealRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.MerchantQueryReviewRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantreview.MerchantCreateReviewRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantreview.QueryUserReviewsRequest;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantAdditionalInfoResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantConsultResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantDetailInfoResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantImageResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantPromoDanaDealResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantQueryReviewResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantReviewSummaryResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.ProductOrderResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantreview.MerchantCreateReviewResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantreview.QueryUserReviewsResult;
import id.dana.data.social.core.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B!\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BJ\u001b\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\u00020\u0013H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J3\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0096@ø\u0001\u0000¢\u0006\u0004\b \u0010!J#\u0010#\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0096@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J3\u0010&\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0096@ø\u0001\u0000¢\u0006\u0004\b&\u0010!JA\u0010*\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190'H\u0096@ø\u0001\u0000¢\u0006\u0004\b*\u0010+J#\u0010-\u001a\u00020,2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0096@ø\u0001\u0000¢\u0006\u0004\b-\u0010$J\u001b\u00100\u001a\u00020/2\u0006\u0010\u000f\u001a\u00020.H\u0096@ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001b\u00104\u001a\u0002032\u0006\u0010\u000f\u001a\u000202H\u0096@ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u001b\u00108\u001a\u0002072\u0006\u00106\u001a\u00020\u0013H\u0096@ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001b\u0010:\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0004\b:\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/NetworkMerchantInfoEntityData;", "Lid/dana/data/social/core/SecureBaseNetwork;", "Lid/dana/data/nearbyme/repository/source/network/MerchantInfoFacade;", "Lid/dana/data/nearbyme/MerchantInfoEntityData;", "Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/BaseMerchantInfoRequest;", "merchantConsultRequest", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantConsultResult;", "consultMerchantReview", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/BaseMerchantInfoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/nearbyme/repository/source/network/request/ProductOrderRequest;", "productOrderRequest", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/ProductOrderResult;", "createProductOrder", "(Lid/dana/data/nearbyme/repository/source/network/request/ProductOrderRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/MerchantCreateReviewRequest;", "request", "Lid/dana/data/nearbyme/repository/source/network/result/merchantreview/MerchantCreateReviewResult;", "createReview", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/MerchantCreateReviewRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getCoachmarkVisibility", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "merchantId", FeatureParams.SHOP_ID, "", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantImageResult;", "getMerchantImage", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantDetailInfoResult;", "getMerchantInfo", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantPromoDanaDealResult;", "getMerchantPromoDanaDeal", "", "filterCriteria", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantQueryReviewResult;", "getMerchantReview", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantReviewSummaryResult;", "getMerchantReviewSummary", "Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/QueryUserReviewsRequest;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantreview/QueryUserReviewsResult;", "getReviewedMerchantsList", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/QueryUserReviewsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantAdditionalInfoRequest;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantAdditionalInfoResult;", "queryAdditionalInfo", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantAdditionalInfoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enabled", "", "setCoachmarkVisibility", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReview", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkMerchantInfoEntityData extends SecureBaseNetwork<MerchantInfoFacade> implements MerchantInfoEntityData {
    @Override // id.dana.data.social.core.BaseNetwork
    public final Class<MerchantInfoFacade> getFacadeClass() {
        return MerchantInfoFacade.class;
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final /* synthetic */ Object saveMerchantImage(String str, String str2, int i, int i2, MerchantImageResult merchantImageResult, Continuation continuation) {
        Object saveMerchantImage$suspendImpl;
        saveMerchantImage$suspendImpl = MerchantInfoEntityData.CC.saveMerchantImage$suspendImpl(this, str, str2, i, i2, merchantImageResult, continuation);
        return saveMerchantImage$suspendImpl;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkMerchantInfoEntityData(RpcConnector rpcConnector, ApSecurityFacade apSecurityFacade, Context context) {
        super(apSecurityFacade, context, rpcConnector);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object getMerchantInfo(String str, String str2, Continuation<? super MerchantDetailInfoResult> continuation) {
        if (str.length() == 0) {
            str = null;
        }
        final MerchantDetailInfoRequest merchantDetailInfoRequest = new MerchantDetailInfoRequest(str, str2, 0, 0, 12, null);
        merchantDetailInfoRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new Function1<MerchantInfoFacade, MerchantDetailInfoResult>() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData$getMerchantInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MerchantDetailInfoResult invoke(MerchantInfoFacade merchantInfoFacade) {
                Intrinsics.checkNotNullParameter(merchantInfoFacade, "");
                return merchantInfoFacade.queryInfo(MerchantDetailInfoRequest.this);
            }
        }, continuation);
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object getMerchantReviewSummary(final String str, final String str2, Continuation<? super MerchantReviewSummaryResult> continuation) {
        return wrapper(new Function1<MerchantInfoFacade, MerchantReviewSummaryResult>() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData$getMerchantReviewSummary$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MerchantReviewSummaryResult invoke(MerchantInfoFacade merchantInfoFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(merchantInfoFacade, "");
                MerchantQueryReviewRequest merchantQueryReviewRequest = new MerchantQueryReviewRequest(str, str2, 0, 0, null, 28, null);
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                merchantQueryReviewRequest.envInfo = generateMobileEnvInfo;
                return merchantInfoFacade.queryReviewSummary(merchantQueryReviewRequest);
            }
        }, continuation);
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object getMerchantReview(final String str, final String str2, final int i, final int i2, final List<String> list, Continuation<? super MerchantQueryReviewResult> continuation) {
        return wrapper(new Function1<MerchantInfoFacade, MerchantQueryReviewResult>() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData$getMerchantReview$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MerchantQueryReviewResult invoke(MerchantInfoFacade merchantInfoFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(merchantInfoFacade, "");
                MerchantQueryReviewRequest merchantQueryReviewRequest = new MerchantQueryReviewRequest(str, str2, i, i2, list);
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                merchantQueryReviewRequest.envInfo = generateMobileEnvInfo;
                return merchantInfoFacade.queryReview(merchantQueryReviewRequest);
            }
        }, continuation);
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object getMerchantImage(final String str, final String str2, final int i, final int i2, Continuation<? super MerchantImageResult> continuation) {
        return wrapper(new Function1<MerchantInfoFacade, MerchantImageResult>() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData$getMerchantImage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MerchantImageResult invoke(MerchantInfoFacade merchantInfoFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(merchantInfoFacade, "");
                MerchantImageRequest merchantImageRequest = new MerchantImageRequest(str, str2, i, i2);
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                merchantImageRequest.envInfo = generateMobileEnvInfo;
                return merchantInfoFacade.queryImage(merchantImageRequest);
            }
        }, continuation);
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object getMerchantPromoDanaDeal(final String str, final String str2, final int i, final int i2, Continuation<? super MerchantPromoDanaDealResult> continuation) {
        return wrapper(new Function1<MerchantInfoFacade, MerchantPromoDanaDealResult>() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData$getMerchantPromoDanaDeal$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MerchantPromoDanaDealResult invoke(MerchantInfoFacade merchantInfoFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(merchantInfoFacade, "");
                MerchantPromoDanaDealRequest merchantPromoDanaDealRequest = new MerchantPromoDanaDealRequest(str, str2, i, i2);
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                merchantPromoDanaDealRequest.envInfo = generateMobileEnvInfo;
                return merchantInfoFacade.queryPromoDanaDeal(merchantPromoDanaDealRequest);
            }
        }, continuation);
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object createProductOrder(final ProductOrderRequest productOrderRequest, Continuation<? super ProductOrderResult> continuation) {
        return wrapper(new Function1<MerchantInfoFacade, ProductOrderResult>() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData$createProductOrder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ProductOrderResult invoke(MerchantInfoFacade merchantInfoFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(merchantInfoFacade, "");
                ProductOrderRequest productOrderRequest2 = ProductOrderRequest.this;
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                productOrderRequest2.envInfo = generateMobileEnvInfo;
                return merchantInfoFacade.createProductOrder(productOrderRequest2);
            }
        }, continuation);
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object consultMerchantReview(final BaseMerchantInfoRequest baseMerchantInfoRequest, Continuation<? super MerchantConsultResult> continuation) {
        return wrapper(new Function1<MerchantInfoFacade, MerchantConsultResult>() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData$consultMerchantReview$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MerchantConsultResult invoke(MerchantInfoFacade merchantInfoFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(merchantInfoFacade, "");
                BaseMerchantInfoRequest baseMerchantInfoRequest2 = BaseMerchantInfoRequest.this;
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                baseMerchantInfoRequest2.envInfo = generateMobileEnvInfo;
                return merchantInfoFacade.consultReview(baseMerchantInfoRequest2);
            }
        }, continuation);
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object createReview(final MerchantCreateReviewRequest merchantCreateReviewRequest, Continuation<? super MerchantCreateReviewResult> continuation) {
        return wrapper(new Function1<MerchantInfoFacade, MerchantCreateReviewResult>() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData$createReview$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MerchantCreateReviewResult invoke(MerchantInfoFacade merchantInfoFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(merchantInfoFacade, "");
                MerchantCreateReviewRequest merchantCreateReviewRequest2 = MerchantCreateReviewRequest.this;
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                merchantCreateReviewRequest2.envInfo = generateMobileEnvInfo;
                return merchantInfoFacade.createReview(merchantCreateReviewRequest2);
            }
        }, continuation);
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object queryAdditionalInfo(final MerchantAdditionalInfoRequest merchantAdditionalInfoRequest, Continuation<? super MerchantAdditionalInfoResult> continuation) {
        return wrapper(new Function1<MerchantInfoFacade, MerchantAdditionalInfoResult>() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData$queryAdditionalInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MerchantAdditionalInfoResult invoke(MerchantInfoFacade merchantInfoFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(merchantInfoFacade, "");
                MerchantAdditionalInfoRequest merchantAdditionalInfoRequest2 = MerchantAdditionalInfoRequest.this;
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                merchantAdditionalInfoRequest2.envInfo = generateMobileEnvInfo;
                return merchantInfoFacade.queryAdditionalInfo(merchantAdditionalInfoRequest2);
            }
        }, continuation);
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object getCoachmarkVisibility(Continuation<? super Boolean> continuation) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object setCoachmarkVisibility(boolean z, Continuation<? super Unit> continuation) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object updateReview(final MerchantCreateReviewRequest merchantCreateReviewRequest, Continuation<? super MerchantCreateReviewResult> continuation) {
        return wrapper(new Function1<MerchantInfoFacade, MerchantCreateReviewResult>() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData$updateReview$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MerchantCreateReviewResult invoke(MerchantInfoFacade merchantInfoFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(merchantInfoFacade, "");
                MerchantCreateReviewRequest merchantCreateReviewRequest2 = MerchantCreateReviewRequest.this;
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                merchantCreateReviewRequest2.envInfo = generateMobileEnvInfo;
                return merchantInfoFacade.updateReview(merchantCreateReviewRequest2);
            }
        }, continuation);
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object getReviewedMerchantsList(final QueryUserReviewsRequest queryUserReviewsRequest, Continuation<? super QueryUserReviewsResult> continuation) {
        return wrapper(new Function1<MerchantInfoFacade, QueryUserReviewsResult>() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData$getReviewedMerchantsList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final QueryUserReviewsResult invoke(MerchantInfoFacade merchantInfoFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(merchantInfoFacade, "");
                QueryUserReviewsRequest queryUserReviewsRequest2 = QueryUserReviewsRequest.this;
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                queryUserReviewsRequest2.envInfo = generateMobileEnvInfo;
                return merchantInfoFacade.queryUserReviews(queryUserReviewsRequest2);
            }
        }, continuation);
    }
}
