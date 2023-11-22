package id.dana.data.nearbyme.repository.source.session;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.data.nearbyme.MerchantInfoEntityData;
import id.dana.data.nearbyme.repository.source.network.request.ProductOrderRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.BaseMerchantInfoRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.MerchantAdditionalInfoRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantreview.MerchantCreateReviewRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantreview.QueryUserReviewsRequest;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantAdditionalInfoResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantDetailInfoResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantImageResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantPromoDanaDealResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantQueryReviewResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantReviewSummaryResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.ProductOrderResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantreview.MerchantCreateReviewResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantreview.QueryUserReviewsResult;
import id.dana.data.storage.PreferenceFacade;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.KClassesJvm;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 92\u00020\u0001:\u00019B\u0011\b\u0007\u0012\u0006\u00105\u001a\u000204¢\u0006\u0004\b7\u00108J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0017JA\u0010 \u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001dH\u0096@ø\u0001\u0000¢\u0006\u0004\b \u0010!J#\u0010#\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0096@ø\u0001\u0000¢\u0006\u0004\b#\u0010\u001aJ\u001b\u0010&\u001a\u00020%2\u0006\u0010\b\u001a\u00020$H\u0096@ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001b\u0010*\u001a\u00020)2\u0006\u0010\b\u001a\u00020(H\u0096@ø\u0001\u0000¢\u0006\u0004\b*\u0010+J;\u0010.\u001a\u00020-2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0015H\u0096@ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u001b\u00101\u001a\u00020-2\u0006\u00100\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u001b\u00103\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b3\u0010\u000bR\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/data/nearbyme/repository/source/session/LocalMerchantInfoEntityData;", "Lid/dana/data/nearbyme/MerchantInfoEntityData;", "Lid/dana/data/nearbyme/repository/source/network/request/ProductOrderRequest;", "productOrderRequest", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/ProductOrderResult;", "createProductOrder", "(Lid/dana/data/nearbyme/repository/source/network/request/ProductOrderRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/MerchantCreateReviewRequest;", "request", "Lid/dana/data/nearbyme/repository/source/network/result/merchantreview/MerchantCreateReviewResult;", "createReview", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/MerchantCreateReviewRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getCoachmarkVisibility", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "merchantId", FeatureParams.SHOP_ID, "", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantImageResult;", "getMerchantImage", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantDetailInfoResult;", "getMerchantInfo", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantPromoDanaDealResult;", "getMerchantPromoDanaDeal", "", "filterCriteria", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantQueryReviewResult;", "getMerchantReview", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantReviewSummaryResult;", "getMerchantReviewSummary", "Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/QueryUserReviewsRequest;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantreview/QueryUserReviewsResult;", "getReviewedMerchantsList", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/QueryUserReviewsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantAdditionalInfoRequest;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantAdditionalInfoResult;", "queryAdditionalInfo", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantAdditionalInfoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data", "", "saveMerchantImage", "(Ljava/lang/String;Ljava/lang/String;IILid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantImageResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enabled", "setCoachmarkVisibility", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReview", "Lid/dana/data/nearbyme/repository/source/session/MerchantInfoPreferences;", "merchantInfoPreferences", "Lid/dana/data/nearbyme/repository/source/session/MerchantInfoPreferences;", "<init>", "(Lid/dana/data/nearbyme/repository/source/session/MerchantInfoPreferences;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalMerchantInfoEntityData implements MerchantInfoEntityData {
    private static final String MERCHANT_COACHMARK = "user_review_coachmark";
    private final MerchantInfoPreferences merchantInfoPreferences;

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final /* synthetic */ Object consultMerchantReview(BaseMerchantInfoRequest baseMerchantInfoRequest, Continuation continuation) {
        Object consultMerchantReview$suspendImpl;
        consultMerchantReview$suspendImpl = MerchantInfoEntityData.CC.consultMerchantReview$suspendImpl(this, baseMerchantInfoRequest, continuation);
        return consultMerchantReview$suspendImpl;
    }

    @Inject
    public LocalMerchantInfoEntityData(MerchantInfoPreferences merchantInfoPreferences) {
        Intrinsics.checkNotNullParameter(merchantInfoPreferences, "");
        this.merchantInfoPreferences = merchantInfoPreferences;
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object getMerchantInfo(String str, String str2, Continuation<? super MerchantDetailInfoResult> continuation) {
        PreferenceFacade preferenceFacade$data_productionRelease = this.merchantInfoPreferences.getPreferenceFacade$data_productionRelease();
        StringBuilder sb = new StringBuilder();
        sb.append(KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(MerchantDetailInfoResult.class)));
        Object object = preferenceFacade$data_productionRelease.getObject(sb.toString(), MerchantDetailInfoResult.class);
        Intrinsics.checkNotNullExpressionValue(object, "");
        return object;
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object getMerchantReviewSummary(String str, String str2, Continuation<? super MerchantReviewSummaryResult> continuation) {
        PreferenceFacade preferenceFacade$data_productionRelease = this.merchantInfoPreferences.getPreferenceFacade$data_productionRelease();
        StringBuilder sb = new StringBuilder();
        sb.append(KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(MerchantReviewSummaryResult.class)));
        Object object = preferenceFacade$data_productionRelease.getObject(sb.toString(), MerchantReviewSummaryResult.class);
        Intrinsics.checkNotNullExpressionValue(object, "");
        return object;
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object getMerchantReview(String str, String str2, int i, int i2, List<String> list, Continuation<? super MerchantQueryReviewResult> continuation) {
        PreferenceFacade preferenceFacade$data_productionRelease = this.merchantInfoPreferences.getPreferenceFacade$data_productionRelease();
        StringBuilder sb = new StringBuilder();
        sb.append(KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(MerchantQueryReviewResult.class)));
        Object object = preferenceFacade$data_productionRelease.getObject(sb.toString(), MerchantQueryReviewResult.class);
        Intrinsics.checkNotNullExpressionValue(object, "");
        return object;
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object getMerchantImage(String str, String str2, int i, int i2, Continuation<? super MerchantImageResult> continuation) {
        return this.merchantInfoPreferences.getMerchantImageResult(str, str2, i, i2);
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object saveMerchantImage(String str, String str2, int i, int i2, MerchantImageResult merchantImageResult, Continuation<? super Unit> continuation) {
        this.merchantInfoPreferences.saveMerchantImageResult(str, str2, i, i2, merchantImageResult);
        return Unit.INSTANCE;
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object getMerchantPromoDanaDeal(String str, String str2, int i, int i2, Continuation<? super MerchantPromoDanaDealResult> continuation) {
        PreferenceFacade preferenceFacade$data_productionRelease = this.merchantInfoPreferences.getPreferenceFacade$data_productionRelease();
        StringBuilder sb = new StringBuilder();
        sb.append(KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(MerchantPromoDanaDealResult.class)));
        Object object = preferenceFacade$data_productionRelease.getObject(sb.toString(), MerchantPromoDanaDealResult.class);
        Intrinsics.checkNotNullExpressionValue(object, "");
        return object;
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object createProductOrder(ProductOrderRequest productOrderRequest, Continuation<? super ProductOrderResult> continuation) {
        PreferenceFacade preferenceFacade$data_productionRelease = this.merchantInfoPreferences.getPreferenceFacade$data_productionRelease();
        StringBuilder sb = new StringBuilder();
        sb.append(KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(ProductOrderResult.class)));
        Object object = preferenceFacade$data_productionRelease.getObject(sb.toString(), ProductOrderResult.class);
        Intrinsics.checkNotNullExpressionValue(object, "");
        return object;
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object createReview(MerchantCreateReviewRequest merchantCreateReviewRequest, Continuation<? super MerchantCreateReviewResult> continuation) {
        PreferenceFacade preferenceFacade$data_productionRelease = this.merchantInfoPreferences.getPreferenceFacade$data_productionRelease();
        StringBuilder sb = new StringBuilder();
        sb.append(KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(MerchantCreateReviewResult.class)));
        Object object = preferenceFacade$data_productionRelease.getObject(sb.toString(), MerchantCreateReviewResult.class);
        Intrinsics.checkNotNullExpressionValue(object, "");
        return object;
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object queryAdditionalInfo(MerchantAdditionalInfoRequest merchantAdditionalInfoRequest, Continuation<? super MerchantAdditionalInfoResult> continuation) {
        PreferenceFacade preferenceFacade$data_productionRelease = this.merchantInfoPreferences.getPreferenceFacade$data_productionRelease();
        StringBuilder sb = new StringBuilder();
        sb.append(KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(MerchantAdditionalInfoResult.class)));
        Object object = preferenceFacade$data_productionRelease.getObject(sb.toString(), MerchantAdditionalInfoResult.class);
        Intrinsics.checkNotNullExpressionValue(object, "");
        return object;
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object getCoachmarkVisibility(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(this.merchantInfoPreferences.getBoolean(MERCHANT_COACHMARK, true));
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object setCoachmarkVisibility(boolean z, Continuation<? super Unit> continuation) {
        this.merchantInfoPreferences.saveBoolean(MERCHANT_COACHMARK, z);
        return Unit.INSTANCE;
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object updateReview(MerchantCreateReviewRequest merchantCreateReviewRequest, Continuation<? super MerchantCreateReviewResult> continuation) {
        PreferenceFacade preferenceFacade$data_productionRelease = this.merchantInfoPreferences.getPreferenceFacade$data_productionRelease();
        StringBuilder sb = new StringBuilder();
        sb.append(KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(MerchantCreateReviewResult.class)));
        Object object = preferenceFacade$data_productionRelease.getObject(sb.toString(), MerchantCreateReviewResult.class);
        Intrinsics.checkNotNullExpressionValue(object, "");
        return object;
    }

    @Override // id.dana.data.nearbyme.MerchantInfoEntityData
    public final Object getReviewedMerchantsList(QueryUserReviewsRequest queryUserReviewsRequest, Continuation<? super QueryUserReviewsResult> continuation) {
        PreferenceFacade preferenceFacade$data_productionRelease = this.merchantInfoPreferences.getPreferenceFacade$data_productionRelease();
        StringBuilder sb = new StringBuilder();
        sb.append(KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(QueryUserReviewsResult.class)));
        Object object = preferenceFacade$data_productionRelease.getObject(sb.toString(), QueryUserReviewsResult.class);
        Intrinsics.checkNotNullExpressionValue(object, "");
        return object;
    }
}
