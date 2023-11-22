package id.dana.cashier.data.repository.source.network;

import com.alibaba.fastjson.JSONObject;
import id.dana.cashier.data.repository.source.network.request.AddAssetCardForUserEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CashierAddOnModalTooltipEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CashierAgreementEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CashierPayEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CashierUpdateOrderEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CreateOrderEntityRequest;
import id.dana.cashier.data.repository.source.network.request.FetchBannerEntityRequest;
import id.dana.cashier.data.repository.source.network.request.GetCashierKybProductEntityRequest;
import id.dana.cashier.data.repository.source.network.request.QueryCardPolicyRequest;
import id.dana.cashier.data.repository.source.network.request.QueryInstallmentEntityRequest;
import id.dana.cashier.data.repository.source.network.request.QueryOneklikRedirectUrlRequest;
import id.dana.cashier.data.repository.source.network.request.QueryPayOptionRequest;
import id.dana.cashier.data.repository.source.network.request.QueryPromotionEntityRequest;
import id.dana.cashier.data.repository.source.network.request.TopUpConsultEntityRequest;
import id.dana.cashier.data.repository.source.network.request.TopUpSubmitEntityRequest;
import id.dana.cashier.data.repository.source.network.request.TopUpVerifyEntityRequest;
import id.dana.cashier.data.repository.source.network.request.npssurvey.NpsSurveyConsultEntityRequest;
import id.dana.cashier.data.repository.source.network.request.npssurvey.NpsSurveySubmitEntityRequest;
import id.dana.cashier.data.repository.source.network.result.CashierAddOnModalTooltipResult;
import id.dana.cashier.data.repository.source.network.result.CashierAgreementResult;
import id.dana.cashier.data.repository.source.network.result.CashierKybProductInfoResult;
import id.dana.cashier.data.repository.source.network.result.CashierPayInfoResult;
import id.dana.cashier.data.repository.source.network.result.CreateOrderInfoResult;
import id.dana.cashier.data.repository.source.network.result.FetchBannerInfoResult;
import id.dana.cashier.data.repository.source.network.result.QueryCardPolicyInfoResult;
import id.dana.cashier.data.repository.source.network.result.QueryInstallmentResult;
import id.dana.cashier.data.repository.source.network.result.QueryOneklikRedirectUrlResult;
import id.dana.cashier.data.repository.source.network.result.QueryPromotionInfoResult;
import id.dana.cashier.data.repository.source.network.result.TopUpConsultResult;
import id.dana.cashier.data.repository.source.network.result.TopUpPayEntityResult;
import id.dana.cashier.data.repository.source.network.result.npssurvey.NpsSurveyInfoResult;
import id.dana.cashier.data.repository.source.network.result.npssurvey.NpsSurveySubmitEntityResult;
import id.dana.data.model.DefaultInfoResult;
import id.dana.network.base.ResultResponse;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 d2\u00020\u0001:\u0001dJ%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ;\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u00042\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00042\b\b\u0001\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00130\u00042\b\b\u0001\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00050\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u001cH'¢\u0006\u0004\b\u001f\u0010 J%\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00130\u00042\b\b\u0001\u0010\"\u001a\u00020!H'¢\u0006\u0004\b$\u0010%J%\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00050\u00042\b\b\u0001\u0010'\u001a\u00020&H'¢\u0006\u0004\b)\u0010*J\u001f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u00042\b\b\u0001\u0010+\u001a\u00020\nH'¢\u0006\u0004\b-\u0010.J%\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u00050\u00042\b\b\u0001\u00100\u001a\u00020/H'¢\u0006\u0004\b2\u00103J%\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u00050\u00042\b\b\u0001\u00105\u001a\u000204H'¢\u0006\u0004\b7\u00108J%\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u00050\u00042\b\b\u0001\u00105\u001a\u000204H'¢\u0006\u0004\b9\u00108J%\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0\u00130\u00042\b\b\u0001\u0010;\u001a\u00020:H'¢\u0006\u0004\b=\u0010>J%\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\u00050\u00042\b\b\u0001\u0010@\u001a\u00020?H'¢\u0006\u0004\bB\u0010CJ%\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\u00050\u00042\b\b\u0001\u0010E\u001a\u00020DH'¢\u0006\u0004\bG\u0010HJ%\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u00042\b\b\u0001\u0010J\u001a\u00020IH'¢\u0006\u0004\bK\u0010LJ;\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0\u00050\u00042\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010N\u001a\u00020MH'¢\u0006\u0004\bP\u0010QJ%\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0\u00130\u00042\b\b\u0001\u0010S\u001a\u00020RH'¢\u0006\u0004\bU\u0010VJ%\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0\u00050\u00042\b\b\u0001\u0010X\u001a\u00020WH'¢\u0006\u0004\bZ\u0010[J%\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0\u00050\u00042\b\b\u0001\u0010]\u001a\u00020\\H'¢\u0006\u0004\b^\u0010_J%\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010a\u001a\u00020`H'¢\u0006\u0004\bb\u0010cø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/data/repository/source/network/CashierSecureApi;", "", "Lid/dana/cashier/data/repository/source/network/request/AddAssetCardForUserEntityRequest;", "addAssetCardForUserRequest", "Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/BaseCashierResponse;", "Lid/dana/data/model/DefaultInfoResult;", "addAssetCardForUser", "(Lid/dana/cashier/data/repository/source/network/request/AddAssetCardForUserEntityRequest;)Lio/reactivex/Observable;", "", "", "headers", "Lid/dana/cashier/data/repository/source/network/request/CashierPayEntityRequest;", "cashierPayRequest", "Lid/dana/cashier/data/repository/source/network/result/CashierPayInfoResult;", "cashierPay", "(Ljava/util/Map;Lid/dana/cashier/data/repository/source/network/request/CashierPayEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/CashierAgreementEntityRequest;", "cashierAgreementEntityRequest", "Lid/dana/network/base/ResultResponse;", "Lid/dana/cashier/data/repository/source/network/result/CashierAgreementResult;", "createAgreement", "(Lid/dana/cashier/data/repository/source/network/request/CashierAgreementEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/CreateOrderEntityRequest;", "createOrderRequest", "Lid/dana/cashier/data/repository/source/network/result/CreateOrderInfoResult;", "createOrder", "(Lid/dana/cashier/data/repository/source/network/request/CreateOrderEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/FetchBannerEntityRequest;", "fetchBannerRequest", "Lid/dana/cashier/data/repository/source/network/result/FetchBannerInfoResult;", "fetchBanner", "(Lid/dana/cashier/data/repository/source/network/request/FetchBannerEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveyConsultEntityRequest;", "npsSurveyConsultEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/npssurvey/NpsSurveyInfoResult;", "fetchNpsSurvey", "(Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveyConsultEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/GetCashierKybProductEntityRequest;", "getCashierKybProductEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/CashierKybProductInfoResult;", "getCashierKybProduct", "(Lid/dana/cashier/data/repository/source/network/request/GetCashierKybProductEntityRequest;)Lio/reactivex/Observable;", "url", "Lcom/alibaba/fastjson/JSONObject;", "getCdnContent", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/CashierAddOnModalTooltipEntityRequest;", "cashierAddOnModalTooltipEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/CashierAddOnModalTooltipResult;", "getTooltipContent", "(Lid/dana/cashier/data/repository/source/network/request/CashierAddOnModalTooltipEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/TopUpConsultEntityRequest;", "topUpConsultEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/TopUpConsultResult;", "getTopUpAgent", "(Lid/dana/cashier/data/repository/source/network/request/TopUpConsultEntityRequest;)Lio/reactivex/Observable;", "getTopUpConsult", "Lid/dana/cashier/data/repository/source/network/request/QueryCardPolicyRequest;", "queryCardPolicyRequest", "Lid/dana/cashier/data/repository/source/network/result/QueryCardPolicyInfoResult;", "queryCardPolicyByCardNo", "(Lid/dana/cashier/data/repository/source/network/request/QueryCardPolicyRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/QueryInstallmentEntityRequest;", "queryInstallmentEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/QueryInstallmentResult;", "queryInstallment", "(Lid/dana/cashier/data/repository/source/network/request/QueryInstallmentEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/QueryOneklikRedirectUrlRequest;", "requestQueryOneklikRedirectUrlRequest", "Lid/dana/cashier/data/repository/source/network/result/QueryOneklikRedirectUrlResult;", "queryOneklikRedirectUrl", "(Lid/dana/cashier/data/repository/source/network/request/QueryOneklikRedirectUrlRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/QueryPayOptionRequest;", "queryPayOptionRequest", "queryPayOption", "(Lid/dana/cashier/data/repository/source/network/request/QueryPayOptionRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/QueryPromotionEntityRequest;", "queryPromotionEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/QueryPromotionInfoResult;", "queryPromotion", "(Ljava/util/Map;Lid/dana/cashier/data/repository/source/network/request/QueryPromotionEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitEntityRequest;", "npsSurveySubmitEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/npssurvey/NpsSurveySubmitEntityResult;", "submitSurvey", "(Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/TopUpSubmitEntityRequest;", "topUpSubmitEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/TopUpPayEntityResult;", "topUpSubmit", "(Lid/dana/cashier/data/repository/source/network/request/TopUpSubmitEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/TopUpVerifyEntityRequest;", "topUpVerifyEntityRequest", "topUpVerify", "(Lid/dana/cashier/data/repository/source/network/request/TopUpVerifyEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/CashierUpdateOrderEntityRequest;", "cashierUpdateOrderRequest", "updateOrder", "(Lid/dana/cashier/data/repository/source/network/request/CashierUpdateOrderEntityRequest;)Lio/reactivex/Observable;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface CashierSecureApi {
    public static final String ACCESS_TOKEN_NETBANKING = "wallet/api/alipayplus.mobilewallet.netbanking.get.accesstoken.json";
    public static final String ADD_ASSET_CARD = "wallet/api/alipayplus.mobilewallet.user.asset.addAssetCardForUser.json";
    public static final String CASHIER_PAY = "wallet/api/alipayplus.mobilewallet.cashier.pay.json";
    public static final String CONSULT_NPS_SURVEY = "wallet/api/alipayplus.mobilewallet.survey.consult.json";
    public static final String CREATE_AGREEMENT = "wallet/api/alipayplus.mobilewallet.user.asset.createAgreement.json";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String FETCH_AND_VALIDATE_BANNER = "wallet/api/alipayplus.mobilewallet.activity.banner.fetchAndValidate.json";
    public static final String GET_PRODUCT_BY_ORDER_ID = "wallet/api/dana.mobilewallet.p2m.productlink.getproductbyorderid.json";
    public static final String GET_TOOLTIP_CONTENT = "wallet/api/alipayplus.mobilewallet.product.getTooltipContent.json";
    public static final String QR_APPLY_PAY = "wallet/api/alipayplus.mobilewallet.qr.applypay.json";
    public static final String QUERY_CARD_POLICY_BY_CARD_NO = "wallet/api/alipayplus.home.user.asset.queryCardPolicyByCardNo.json";
    public static final String QUERY_INSTALLMENT = "wallet/api/alipayplus.mobilewallet.cashier.queryInstallment.json";
    public static final String QUERY_PAY_OPTION = "wallet/api/alipayplus.mobilewallet.cashier.queryPayOption.json";
    public static final String QUERY_PROMOTION = "wallet/api/alipayplus.mobilewallet.cashier.queryPromotion.json";
    public static final String SURVEY_SUBMIT = "wallet/api/alipayplus.mobilewallet.survey.submit.json";
    public static final String TOP_UP_AGENT = "wallet/api/alipayplus.mobilewallet.fund.asset.assign.json";
    public static final String TOP_UP_CONSULT = "wallet/api/alipayplus.mobilewallet.fund.topup.consult.json";
    public static final String TOP_UP_PAY = "wallet/api/alipayplus.mobilewallet.topup.pay.json";
    public static final String UPDATE_ORDER_CASHIER = "wallet/api/alipayplus.mobilewallet.cashier.updateOrder.json";

    @POST("/wallet/api/alipayplus.mobilewallet.user.asset.addAssetCardForUser.json")
    Observable<BaseCashierResponse<DefaultInfoResult>> addAssetCardForUser(@Body AddAssetCardForUserEntityRequest addAssetCardForUserRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.cashier.pay.json")
    Observable<BaseCashierResponse<CashierPayInfoResult>> cashierPay(@HeaderMap Map<String, String> headers, @Body CashierPayEntityRequest cashierPayRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.user.asset.createAgreement.json")
    Observable<ResultResponse<CashierAgreementResult>> createAgreement(@Body CashierAgreementEntityRequest cashierAgreementEntityRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.qr.applypay.json")
    Observable<ResultResponse<CreateOrderInfoResult>> createOrder(@Body CreateOrderEntityRequest createOrderRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.activity.banner.fetchAndValidate.json")
    Observable<BaseCashierResponse<FetchBannerInfoResult>> fetchBanner(@Body FetchBannerEntityRequest fetchBannerRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.survey.consult.json")
    Observable<ResultResponse<NpsSurveyInfoResult>> fetchNpsSurvey(@Body NpsSurveyConsultEntityRequest npsSurveyConsultEntityRequest);

    @POST("/wallet/api/dana.mobilewallet.p2m.productlink.getproductbyorderid.json")
    Observable<BaseCashierResponse<CashierKybProductInfoResult>> getCashierKybProduct(@Body GetCashierKybProductEntityRequest getCashierKybProductEntityRequest);

    @GET
    Observable<JSONObject> getCdnContent(@Url String url);

    @POST("/wallet/api/alipayplus.mobilewallet.product.getTooltipContent.json")
    Observable<BaseCashierResponse<CashierAddOnModalTooltipResult>> getTooltipContent(@Body CashierAddOnModalTooltipEntityRequest cashierAddOnModalTooltipEntityRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.fund.asset.assign.json")
    Observable<BaseCashierResponse<TopUpConsultResult>> getTopUpAgent(@Body TopUpConsultEntityRequest topUpConsultEntityRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.fund.topup.consult.json")
    Observable<BaseCashierResponse<TopUpConsultResult>> getTopUpConsult(@Body TopUpConsultEntityRequest topUpConsultEntityRequest);

    @POST("/wallet/api/alipayplus.home.user.asset.queryCardPolicyByCardNo.json")
    Observable<ResultResponse<QueryCardPolicyInfoResult>> queryCardPolicyByCardNo(@Body QueryCardPolicyRequest queryCardPolicyRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.cashier.queryInstallment.json")
    Observable<BaseCashierResponse<QueryInstallmentResult>> queryInstallment(@Body QueryInstallmentEntityRequest queryInstallmentEntityRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.netbanking.get.accesstoken.json")
    Observable<BaseCashierResponse<QueryOneklikRedirectUrlResult>> queryOneklikRedirectUrl(@Body QueryOneklikRedirectUrlRequest requestQueryOneklikRedirectUrlRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.cashier.queryPayOption.json")
    Observable<BaseCashierResponse<CashierPayInfoResult>> queryPayOption(@Body QueryPayOptionRequest queryPayOptionRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.cashier.queryPromotion.json")
    Observable<BaseCashierResponse<QueryPromotionInfoResult>> queryPromotion(@HeaderMap Map<String, String> headers, @Body QueryPromotionEntityRequest queryPromotionEntityRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.survey.submit.json")
    Observable<ResultResponse<NpsSurveySubmitEntityResult>> submitSurvey(@Body NpsSurveySubmitEntityRequest npsSurveySubmitEntityRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.topup.pay.json")
    Observable<BaseCashierResponse<TopUpPayEntityResult>> topUpSubmit(@Body TopUpSubmitEntityRequest topUpSubmitEntityRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.topup.pay.json")
    Observable<BaseCashierResponse<TopUpPayEntityResult>> topUpVerify(@Body TopUpVerifyEntityRequest topUpVerifyEntityRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.cashier.updateOrder.json")
    Observable<BaseCashierResponse<DefaultInfoResult>> updateOrder(@Body CashierUpdateOrderEntityRequest cashierUpdateOrderRequest);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/CashierSecureApi$Companion;", "", "", "ACCESS_TOKEN_NETBANKING", "Ljava/lang/String;", "ADD_ASSET_CARD", "CASHIER_PAY", "CONSULT_NPS_SURVEY", "CREATE_AGREEMENT", "FETCH_AND_VALIDATE_BANNER", "GET_PRODUCT_BY_ORDER_ID", "GET_TOOLTIP_CONTENT", "QR_APPLY_PAY", "QUERY_CARD_POLICY_BY_CARD_NO", "QUERY_INSTALLMENT", "QUERY_PAY_OPTION", "QUERY_PROMOTION", "SURVEY_SUBMIT", "TOP_UP_AGENT", "TOP_UP_CONSULT", "TOP_UP_PAY", "UPDATE_ORDER_CASHIER", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String ACCESS_TOKEN_NETBANKING = "wallet/api/alipayplus.mobilewallet.netbanking.get.accesstoken.json";
        public static final String ADD_ASSET_CARD = "wallet/api/alipayplus.mobilewallet.user.asset.addAssetCardForUser.json";
        public static final String CASHIER_PAY = "wallet/api/alipayplus.mobilewallet.cashier.pay.json";
        public static final String CONSULT_NPS_SURVEY = "wallet/api/alipayplus.mobilewallet.survey.consult.json";
        public static final String CREATE_AGREEMENT = "wallet/api/alipayplus.mobilewallet.user.asset.createAgreement.json";
        public static final String FETCH_AND_VALIDATE_BANNER = "wallet/api/alipayplus.mobilewallet.activity.banner.fetchAndValidate.json";
        public static final String GET_PRODUCT_BY_ORDER_ID = "wallet/api/dana.mobilewallet.p2m.productlink.getproductbyorderid.json";
        public static final String GET_TOOLTIP_CONTENT = "wallet/api/alipayplus.mobilewallet.product.getTooltipContent.json";
        public static final String QR_APPLY_PAY = "wallet/api/alipayplus.mobilewallet.qr.applypay.json";
        public static final String QUERY_CARD_POLICY_BY_CARD_NO = "wallet/api/alipayplus.home.user.asset.queryCardPolicyByCardNo.json";
        public static final String QUERY_INSTALLMENT = "wallet/api/alipayplus.mobilewallet.cashier.queryInstallment.json";
        public static final String QUERY_PAY_OPTION = "wallet/api/alipayplus.mobilewallet.cashier.queryPayOption.json";
        public static final String QUERY_PROMOTION = "wallet/api/alipayplus.mobilewallet.cashier.queryPromotion.json";
        public static final String SURVEY_SUBMIT = "wallet/api/alipayplus.mobilewallet.survey.submit.json";
        public static final String TOP_UP_AGENT = "wallet/api/alipayplus.mobilewallet.fund.asset.assign.json";
        public static final String TOP_UP_CONSULT = "wallet/api/alipayplus.mobilewallet.fund.topup.consult.json";
        public static final String TOP_UP_PAY = "wallet/api/alipayplus.mobilewallet.topup.pay.json";
        public static final String UPDATE_ORDER_CASHIER = "wallet/api/alipayplus.mobilewallet.cashier.updateOrder.json";

        private Companion() {
        }
    }
}
