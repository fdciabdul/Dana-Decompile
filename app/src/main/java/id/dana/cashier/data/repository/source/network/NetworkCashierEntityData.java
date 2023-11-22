package id.dana.cashier.data.repository.source.network;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import id.dana.cashier.data.mapper.MobileEnvInfoMapperKt;
import id.dana.cashier.data.repository.source.CashierEntityData;
import id.dana.cashier.data.repository.source.network.request.AddAssetCardForUserEntityRequest;
import id.dana.cashier.data.repository.source.network.request.AdditionalPaylaterCashierPayRequest;
import id.dana.cashier.data.repository.source.network.request.CashierAddOnModalTooltipEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CashierAgreementEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CashierPayEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CashierUpdateOrderEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CreateOrderEntityRequest;
import id.dana.cashier.data.repository.source.network.request.FetchBannerEntityRequest;
import id.dana.cashier.data.repository.source.network.request.GetCashierKybProductEntityRequest;
import id.dana.cashier.data.repository.source.network.request.MixPayMethodRequest;
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
import id.dana.cashier.data.repository.source.network.result.CashierAddOnCdnTooltipResult;
import id.dana.cashier.data.repository.source.network.result.CashierAddOnModalCategoryResult;
import id.dana.cashier.data.repository.source.network.result.CashierAddOnModalContentResult;
import id.dana.cashier.data.repository.source.network.result.CashierAddOnModalTooltipResult;
import id.dana.cashier.data.repository.source.network.result.CashierAgreementResult;
import id.dana.cashier.data.repository.source.network.result.CashierCurrencyFromCdnResult;
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
import id.dana.cashier.domain.model.CheckoutExternalInfo;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.constant.DanaUrl;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.model.DefaultInfoResult;
import id.dana.data.network.constant.CashierHeader;
import id.dana.domain.payasset.model.PayMethod;
import id.dana.network.base.BaseSecureRestNetwork;
import id.dana.network.base.ExceptionParserAphome;
import id.dana.network.base.ResultResponse;
import id.dana.utils.config.model.DeviceInfo;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B?\b\u0007\u0012\b\u0010\u0088\u0001\u001a\u00030\u0087\u0001\u0012\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001\u0012\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001\u0012\t\b\u0001\u0010\u0081\u0001\u001a\u00020\u0002\u0012\t\b\u0001\u0010\u0086\u0001\u001a\u00020\u0002¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00062\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010$J1\u0010(\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u001d\u00101\u001a\b\u0012\u0004\u0012\u0002000\u00062\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b1\u00102J!\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u0002030%0\u0006H\u0016¢\u0006\u0004\b4\u00105J\u0015\u00107\u001a\b\u0012\u0004\u0012\u0002060\u0006H\u0016¢\u0006\u0004\b7\u00105J\u0015\u00109\u001a\b\u0012\u0004\u0012\u0002080\u0006H\u0016¢\u0006\u0004\b9\u00105J%\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u00062\u0006\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020&H\u0016¢\u0006\u0004\b=\u0010>J\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020A0\u00062\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\bB\u0010CJ\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020F0\u00062\u0006\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bG\u0010HJ\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bK\u0010LJ\u001d\u0010P\u001a\b\u0012\u0004\u0012\u00020O0\u00062\u0006\u0010N\u001a\u00020MH\u0016¢\u0006\u0004\bP\u0010QJ\u001d\u0010U\u001a\b\u0012\u0004\u0012\u00020T0\u00062\u0006\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\bU\u0010VJ\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0\u00062\u0006\u0010W\u001a\u00020&H\u0016¢\u0006\u0004\bY\u0010ZJ\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\u00062\u0006\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b^\u0010_J\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\u00062\u0006\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b`\u0010_J\u0017\u0010a\u001a\u00020*2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\ba\u0010bJ\u001d\u0010d\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010c0%H\u0002¢\u0006\u0004\bd\u0010eJ\u0017\u0010f\u001a\u00020*2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\bf\u0010bJ)\u0010i\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010&\u0012\u0006\u0012\u0004\u0018\u00010h0g2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\bi\u0010jJ\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020m0\u00062\u0006\u0010l\u001a\u00020kH\u0016¢\u0006\u0004\bn\u0010oJ\u001d\u0010s\u001a\b\u0012\u0004\u0012\u00020r0\u00062\u0006\u0010q\u001a\u00020pH\u0016¢\u0006\u0004\bs\u0010tJ\u001d\u0010w\u001a\b\u0012\u0004\u0012\u00020r0\u00062\u0006\u0010v\u001a\u00020uH\u0016¢\u0006\u0004\bw\u0010xJ\u001d\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010z\u001a\u00020yH\u0016¢\u0006\u0004\b{\u0010|J6\u0010\u007f\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0g*\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0g2\b\u0010~\u001a\u0004\u0018\u00010}H\u0002¢\u0006\u0005\b\u007f\u0010\u0080\u0001R\u0017\u0010\u0081\u0001\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0017\u0010\u0086\u0001\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0082\u0001"}, d2 = {"Lid/dana/cashier/data/repository/source/network/NetworkCashierEntityData;", "Lid/dana/network/base/BaseSecureRestNetwork;", "Lid/dana/cashier/data/repository/source/network/CashierSecureApi;", "Lid/dana/cashier/data/repository/source/CashierEntityData;", "Lid/dana/cashier/data/repository/source/network/request/AddAssetCardForUserEntityRequest;", "addAssetCardForUserEntityRequest", "Lio/reactivex/Observable;", "Lid/dana/data/model/DefaultInfoResult;", "addAssetCardForUser", "(Lid/dana/cashier/data/repository/source/network/request/AddAssetCardForUserEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/CashierAgreementEntityRequest;", "cashierEKtpAgreementEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/CashierAgreementResult;", "createCashierEKtpAgreement", "(Lid/dana/cashier/data/repository/source/network/request/CashierAgreementEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/CashierPayEntityRequest;", "cashierPayEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/AdditionalPaylaterCashierPayRequest;", "additionalPaylaterCashierPayRequest", "Lid/dana/cashier/data/repository/source/network/result/CashierPayInfoResult;", "doCashierPay", "(Lid/dana/cashier/data/repository/source/network/request/CashierPayEntityRequest;Lid/dana/cashier/data/repository/source/network/request/AdditionalPaylaterCashierPayRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/CreateOrderEntityRequest;", "createOrderEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/CreateOrderInfoResult;", "doCreateOrder", "(Lid/dana/cashier/data/repository/source/network/request/CreateOrderEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/FetchBannerEntityRequest;", "fetchBannerEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/FetchBannerInfoResult;", "fetchBanner", "(Lid/dana/cashier/data/repository/source/network/request/FetchBannerEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveyConsultEntityRequest;", "npsSurveyConsultEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/npssurvey/NpsSurveyInfoResult;", "fetchNpsSurvey", "(Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveyConsultEntityRequest;)Lio/reactivex/Observable;", "", "", "orderInfo", "generateTopUpSubmitExtParams", "(Ljava/util/Map;)Ljava/util/Map;", "", "useSecureApi", "getCashierApi", "(Z)Lid/dana/cashier/data/repository/source/network/CashierSecureApi;", "Lid/dana/cashier/data/repository/source/network/request/GetCashierKybProductEntityRequest;", "cashierKybProductEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/CashierKybProductInfoResult;", "getCashierKybProduct", "(Lid/dana/cashier/data/repository/source/network/request/GetCashierKybProductEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/result/CashierCurrencyFromCdnResult;", "getCurrencyFromCdn", "()Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/result/CashierAddOnModalCategoryResult;", "getModalCategory", "Lid/dana/cashier/data/repository/source/network/result/CashierAddOnModalContentResult;", "getModalContent", "scenario", "deviceId", "Lid/dana/cashier/data/repository/source/network/result/QueryOneklikRedirectUrlResult;", "getOneklikRedirectUrl", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/QueryCardPolicyRequest;", "queryCardPolicyRequest", "Lid/dana/cashier/data/repository/source/network/result/QueryCardPolicyInfoResult;", "getQueryCardPolicyByCardNo", "(Lid/dana/cashier/data/repository/source/network/request/QueryCardPolicyRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/QueryInstallmentEntityRequest;", "queryInstallmentEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/QueryInstallmentResult;", "getQueryInstallment", "(Lid/dana/cashier/data/repository/source/network/request/QueryInstallmentEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/QueryPayOptionRequest;", "queryPayOptionRequest", "getQueryPayOption", "(Lid/dana/cashier/data/repository/source/network/request/QueryPayOptionRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/QueryPromotionEntityRequest;", "queryPromotionEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/QueryPromotionInfoResult;", "getQueryPromotion", "(Lid/dana/cashier/data/repository/source/network/request/QueryPromotionEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/CashierAddOnModalTooltipEntityRequest;", "cashierAddOnModalTooltipEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/CashierAddOnModalTooltipResult;", "getTooltipContent", "(Lid/dana/cashier/data/repository/source/network/request/CashierAddOnModalTooltipEntityRequest;)Lio/reactivex/Observable;", "tooltip", "Lid/dana/cashier/data/repository/source/network/result/CashierAddOnCdnTooltipResult;", "getTooltipFromCdn", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/TopUpConsultEntityRequest;", "topUpConsultEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/TopUpConsultResult;", "getTopUpAgent", "(Lid/dana/cashier/data/repository/source/network/request/TopUpConsultEntityRequest;)Lio/reactivex/Observable;", "getTopUpConsult", "isPaylaterRequest", "(Lid/dana/cashier/data/repository/source/network/request/CashierPayEntityRequest;)Z", "Lid/dana/utils/config/model/DeviceInfo;", "mapDeviceInfo", "()Ljava/util/Map;", "needToUseSecureApi", "", "", "setPaylaterExtParams", "(Lid/dana/cashier/data/repository/source/network/request/AdditionalPaylaterCashierPayRequest;)Ljava/util/Map;", "Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitEntityRequest;", "npsSurveySubmitEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/npssurvey/NpsSurveySubmitEntityResult;", "submitNpsSurvey", "(Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/TopUpSubmitEntityRequest;", "topUpSubmitEntityRequest", "Lid/dana/cashier/data/repository/source/network/result/TopUpPayEntityResult;", "topUpSubmit", "(Lid/dana/cashier/data/repository/source/network/request/TopUpSubmitEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/TopUpVerifyEntityRequest;", "topUpVerifyEntityRequest", "topUpVerify", "(Lid/dana/cashier/data/repository/source/network/request/TopUpVerifyEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/CashierUpdateOrderEntityRequest;", "cashierUpdateOrderEntityRequest", "updateOrder", "(Lid/dana/cashier/data/repository/source/network/request/CashierUpdateOrderEntityRequest;)Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", "envInfo", "addFeVersionFromEnvInfo", "(Ljava/util/Map;Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;)Ljava/util/Map;", "cashierApi", "Lid/dana/cashier/data/repository/source/network/CashierSecureApi;", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "securedCashierApi", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "<init>", "(Landroid/content/Context;Lid/dana/data/foundation/facade/ApSecurityFacade;Lid/dana/data/config/DeviceInformationProvider;Lid/dana/cashier/data/repository/source/network/CashierSecureApi;Lid/dana/cashier/data/repository/source/network/CashierSecureApi;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NetworkCashierEntityData extends BaseSecureRestNetwork<CashierSecureApi> implements CashierEntityData {
    private final CashierSecureApi cashierApi;
    private final DeviceInformationProvider deviceInformationProvider;
    private final CashierSecureApi securedCashierApi;

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getCashierHighlightConfig() {
        return CashierEntityData.CC.$default$getCashierHighlightConfig(this);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getHighlightNewInstId(String str) {
        return CashierEntityData.CC.$default$getHighlightNewInstId(this, str);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getHighlightTimeShown(String str, String str2, String str3) {
        return CashierEntityData.CC.$default$getHighlightTimeShown(this, str, str2, str3);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getHighlightVersion(String str, String str2) {
        return CashierEntityData.CC.$default$getHighlightVersion(this, str, str2);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getLastTimeSmartPayActivationShow(String str) {
        return CashierEntityData.CC.$default$getLastTimeSmartPayActivationShow(this, str);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getPaylaterCicilRegistrationCacheCooldownCount(String str) {
        return CashierEntityData.CC.$default$getPaylaterCicilRegistrationCacheCooldownCount(this, str);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getPaylaterCicilRegistrationCacheCooldownDelay(String str) {
        return CashierEntityData.CC.$default$getPaylaterCicilRegistrationCacheCooldownDelay(this, str);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable saveHighlightNewInstId(String str, String str2) {
        return CashierEntityData.CC.$default$saveHighlightNewInstId(this, str, str2);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable saveHighlightTimeShown(String str, String str2, String str3) {
        return CashierEntityData.CC.$default$saveHighlightTimeShown(this, str, str2, str3);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable saveHighlightVersion(String str, String str2, int i) {
        return CashierEntityData.CC.$default$saveHighlightVersion(this, str, str2, i);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable savePaylaterCicilRegistrationCacheCooldownCount(int i, String str) {
        return CashierEntityData.CC.$default$savePaylaterCicilRegistrationCacheCooldownCount(this, i, str);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable savePaylaterCicilRegistrationCacheCooldownDelay(long j, String str) {
        return CashierEntityData.CC.$default$savePaylaterCicilRegistrationCacheCooldownDelay(this, j, str);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable setLastSmartPayActivationShow(long j, String str) {
        return CashierEntityData.CC.$default$setLastSmartPayActivationShow(this, j, str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkCashierEntityData(Context context, ApSecurityFacade apSecurityFacade, DeviceInformationProvider deviceInformationProvider, @Named("CASHIER_API") CashierSecureApi cashierSecureApi, @Named("SECURED_CASHIER_API") CashierSecureApi cashierSecureApi2) {
        super(context, apSecurityFacade);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        Intrinsics.checkNotNullParameter(cashierSecureApi, "");
        Intrinsics.checkNotNullParameter(cashierSecureApi2, "");
        this.deviceInformationProvider = deviceInformationProvider;
        this.cashierApi = cashierSecureApi;
        this.securedCashierApi = cashierSecureApi2;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<CashierPayInfoResult> doCashierPay(final CashierPayEntityRequest cashierPayEntityRequest, AdditionalPaylaterCashierPayRequest additionalPaylaterCashierPayRequest) {
        Intrinsics.checkNotNullParameter(cashierPayEntityRequest, "");
        cashierPayEntityRequest.setEnvInfo(MobileEnvInfoMapperKt.toMobileEnvInfoWithCity(generateMobileEnvInfo(), cashierPayEntityRequest.getCityName()));
        if (isPaylaterRequest(cashierPayEntityRequest)) {
            cashierPayEntityRequest.setExtParams(setPaylaterExtParams(additionalPaylaterCashierPayRequest));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        addFeVersionFromEnvInfo(linkedHashMap, cashierPayEntityRequest.getEnvInfo());
        Observable<CashierPayInfoResult> flatMap = wrapper(getCashierApi(needToUseSecureApi(cashierPayEntityRequest)), new NetworkCashierEntityData$doCashierPay$1$1(linkedHashMap, cashierPayEntityRequest)).flatMap(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m545doCashierPay$lambda1$lambda0;
                m545doCashierPay$lambda1$lambda0 = NetworkCashierEntityData.m545doCashierPay$lambda1$lambda0(CashierPayEntityRequest.this, (CashierPayInfoResult) obj);
                return m545doCashierPay$lambda1$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: doCashierPay$lambda-1$lambda-0 */
    public static final ObservableSource m545doCashierPay$lambda1$lambda0(CashierPayEntityRequest cashierPayEntityRequest, CashierPayInfoResult cashierPayInfoResult) {
        Observable just;
        Intrinsics.checkNotNullParameter(cashierPayEntityRequest, "");
        Intrinsics.checkNotNullParameter(cashierPayInfoResult, "");
        if (cashierPayEntityRequest.getValidateData() == null) {
            just = new ExceptionParserAphome().apply((ExceptionParserAphome) cashierPayInfoResult);
        } else {
            just = Observable.just(cashierPayInfoResult);
        }
        return just;
    }

    private final Map<String, Object> setPaylaterExtParams(AdditionalPaylaterCashierPayRequest additionalPaylaterCashierPayRequest) {
        Map<String, Object> mutableMap = MapsKt.toMutableMap(mapDeviceInfo());
        if ((additionalPaylaterCashierPayRequest != null ? additionalPaylaterCashierPayRequest.getAgreementInfo() : null) != null && additionalPaylaterCashierPayRequest.getAgreementInfo().getNeedUserAgreement()) {
            mutableMap.put("signedPaylaterAgreementKey", additionalPaylaterCashierPayRequest.getAgreementInfo().getAgreementKey());
        }
        if ((additionalPaylaterCashierPayRequest != null ? additionalPaylaterCashierPayRequest.getInstallmentPlanId() : null) != null) {
            mutableMap.put(CashierKeyParams.INSTALLMENT_PLAN_ID, additionalPaylaterCashierPayRequest.getInstallmentPlanId());
        }
        if ((additionalPaylaterCashierPayRequest != null ? additionalPaylaterCashierPayRequest.getLoanAgreementUrl() : null) != null) {
            mutableMap.put(CashierKeyParams.LOAN_AGREEMENT_URL, additionalPaylaterCashierPayRequest.getLoanAgreementUrl());
        }
        return mutableMap;
    }

    private final boolean isPaylaterRequest(CashierPayEntityRequest cashierPayEntityRequest) {
        String selectedPayOption;
        if (cashierPayEntityRequest.getInstallmentPeriod() == null) {
            CheckoutExternalInfo externalInfo = cashierPayEntityRequest.getExternalInfo();
            if (!((externalInfo == null || (selectedPayOption = externalInfo.getSelectedPayOption()) == null || !StringsKt.contains$default((CharSequence) selectedPayOption, (CharSequence) "ONLINE_CREDIT", false, 2, (Object) null)) ? false : true) && !Intrinsics.areEqual(cashierPayEntityRequest.getPayMethod(), PayMethod.LOAN_CREDIT)) {
                MixPayMethodRequest mixPayMethod = cashierPayEntityRequest.getMixPayMethod();
                if (!Intrinsics.areEqual(mixPayMethod != null ? mixPayMethod.getPayMethod() : null, PayMethod.LOAN_CREDIT)) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean needToUseSecureApi(CashierPayEntityRequest cashierPayEntityRequest) {
        return (cashierPayEntityRequest.getPayMethod() == null || Intrinsics.areEqual(cashierPayEntityRequest.getPayMethod(), "BALANCE")) ? false : true;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<QueryOneklikRedirectUrlResult> getOneklikRedirectUrl(String scenario, String deviceId) {
        Intrinsics.checkNotNullParameter(scenario, "");
        Intrinsics.checkNotNullParameter(deviceId, "");
        Observable map = this.cashierApi.queryOneklikRedirectUrl(new QueryOneklikRedirectUrlRequest(scenario, deviceId)).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                QueryOneklikRedirectUrlResult m552getOneklikRedirectUrl$lambda2;
                m552getOneklikRedirectUrl$lambda2 = NetworkCashierEntityData.m552getOneklikRedirectUrl$lambda2((BaseCashierResponse) obj);
                return m552getOneklikRedirectUrl$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getOneklikRedirectUrl$lambda-2 */
    public static final QueryOneklikRedirectUrlResult m552getOneklikRedirectUrl$lambda2(BaseCashierResponse baseCashierResponse) {
        Intrinsics.checkNotNullParameter(baseCashierResponse, "");
        return (QueryOneklikRedirectUrlResult) baseCashierResponse.result;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<NpsSurveyInfoResult> fetchNpsSurvey(NpsSurveyConsultEntityRequest npsSurveyConsultEntityRequest) {
        Intrinsics.checkNotNullParameter(npsSurveyConsultEntityRequest, "");
        npsSurveyConsultEntityRequest.envInfo = generateMobileEnvInfo();
        Observable<NpsSurveyInfoResult> flatMap = this.cashierApi.fetchNpsSurvey(npsSurveyConsultEntityRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                NpsSurveyInfoResult m547fetchNpsSurvey$lambda3;
                m547fetchNpsSurvey$lambda3 = NetworkCashierEntityData.m547fetchNpsSurvey$lambda3((ResultResponse) obj);
                return m547fetchNpsSurvey$lambda3;
            }
        }).flatMap(new ExceptionParserAphome());
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: fetchNpsSurvey$lambda-3 */
    public static final NpsSurveyInfoResult m547fetchNpsSurvey$lambda3(ResultResponse resultResponse) {
        Intrinsics.checkNotNullParameter(resultResponse, "");
        return (NpsSurveyInfoResult) resultResponse.getResult();
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<NpsSurveySubmitEntityResult> submitNpsSurvey(NpsSurveySubmitEntityRequest npsSurveySubmitEntityRequest) {
        Intrinsics.checkNotNullParameter(npsSurveySubmitEntityRequest, "");
        npsSurveySubmitEntityRequest.envInfo = generateMobileEnvInfo();
        Observable map = this.cashierApi.submitSurvey(npsSurveySubmitEntityRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                NpsSurveySubmitEntityResult m560submitNpsSurvey$lambda4;
                m560submitNpsSurvey$lambda4 = NetworkCashierEntityData.m560submitNpsSurvey$lambda4((ResultResponse) obj);
                return m560submitNpsSurvey$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: submitNpsSurvey$lambda-4 */
    public static final NpsSurveySubmitEntityResult m560submitNpsSurvey$lambda4(ResultResponse resultResponse) {
        Intrinsics.checkNotNullParameter(resultResponse, "");
        return (NpsSurveySubmitEntityResult) resultResponse.getResult();
    }

    private final CashierSecureApi getCashierApi(boolean useSecureApi) {
        if (useSecureApi) {
            return this.securedCashierApi;
        }
        return this.cashierApi;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<CreateOrderInfoResult> doCreateOrder(final CreateOrderEntityRequest createOrderEntityRequest) {
        Intrinsics.checkNotNullParameter(createOrderEntityRequest, "");
        createOrderEntityRequest.envInfo = generateMobileEnvInfo();
        return wrapper(this.cashierApi, new Function1<CashierSecureApi, Observable<ResultResponse<CreateOrderInfoResult>>>() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$doCreateOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<ResultResponse<CreateOrderInfoResult>> invoke(CashierSecureApi cashierSecureApi) {
                Intrinsics.checkNotNullParameter(cashierSecureApi, "");
                return cashierSecureApi.createOrder(CreateOrderEntityRequest.this);
            }
        });
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<CashierAgreementResult> createCashierEKtpAgreement(CashierAgreementEntityRequest cashierEKtpAgreementEntityRequest) {
        Intrinsics.checkNotNullParameter(cashierEKtpAgreementEntityRequest, "");
        cashierEKtpAgreementEntityRequest.envInfo = generateMobileEnvInfo();
        Observable<CashierAgreementResult> flatMap = this.cashierApi.createAgreement(cashierEKtpAgreementEntityRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CashierAgreementResult m544createCashierEKtpAgreement$lambda5;
                m544createCashierEKtpAgreement$lambda5 = NetworkCashierEntityData.m544createCashierEKtpAgreement$lambda5((ResultResponse) obj);
                return m544createCashierEKtpAgreement$lambda5;
            }
        }).flatMap(new ExceptionParserAphome());
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: createCashierEKtpAgreement$lambda-5 */
    public static final CashierAgreementResult m544createCashierEKtpAgreement$lambda5(ResultResponse resultResponse) {
        Intrinsics.checkNotNullParameter(resultResponse, "");
        return (CashierAgreementResult) resultResponse.getResult();
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<QueryCardPolicyInfoResult> getQueryCardPolicyByCardNo(QueryCardPolicyRequest queryCardPolicyRequest) {
        Intrinsics.checkNotNullParameter(queryCardPolicyRequest, "");
        queryCardPolicyRequest.envInfo = generateMobileEnvInfo();
        Observable<QueryCardPolicyInfoResult> flatMap = this.cashierApi.queryCardPolicyByCardNo(queryCardPolicyRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                QueryCardPolicyInfoResult m553getQueryCardPolicyByCardNo$lambda6;
                m553getQueryCardPolicyByCardNo$lambda6 = NetworkCashierEntityData.m553getQueryCardPolicyByCardNo$lambda6((ResultResponse) obj);
                return m553getQueryCardPolicyByCardNo$lambda6;
            }
        }).flatMap(new ExceptionParserAphome());
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: getQueryCardPolicyByCardNo$lambda-6 */
    public static final QueryCardPolicyInfoResult m553getQueryCardPolicyByCardNo$lambda6(ResultResponse resultResponse) {
        Intrinsics.checkNotNullParameter(resultResponse, "");
        return (QueryCardPolicyInfoResult) resultResponse.getResult();
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<CashierPayInfoResult> getQueryPayOption(QueryPayOptionRequest queryPayOptionRequest) {
        Intrinsics.checkNotNullParameter(queryPayOptionRequest, "");
        queryPayOptionRequest.envInfo = generateMobileEnvInfo();
        Observable<CashierPayInfoResult> flatMap = this.cashierApi.queryPayOption(queryPayOptionRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CashierPayInfoResult m554getQueryPayOption$lambda7;
                m554getQueryPayOption$lambda7 = NetworkCashierEntityData.m554getQueryPayOption$lambda7((BaseCashierResponse) obj);
                return m554getQueryPayOption$lambda7;
            }
        }).flatMap(new ExceptionParserAphome());
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: getQueryPayOption$lambda-7 */
    public static final CashierPayInfoResult m554getQueryPayOption$lambda7(BaseCashierResponse baseCashierResponse) {
        Intrinsics.checkNotNullParameter(baseCashierResponse, "");
        return (CashierPayInfoResult) baseCashierResponse.result;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<FetchBannerInfoResult> fetchBanner(FetchBannerEntityRequest fetchBannerEntityRequest) {
        Intrinsics.checkNotNullParameter(fetchBannerEntityRequest, "");
        fetchBannerEntityRequest.envInfo = generateMobileEnvInfo();
        Observable<FetchBannerInfoResult> flatMap = this.cashierApi.fetchBanner(fetchBannerEntityRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                FetchBannerInfoResult m546fetchBanner$lambda8;
                m546fetchBanner$lambda8 = NetworkCashierEntityData.m546fetchBanner$lambda8((BaseCashierResponse) obj);
                return m546fetchBanner$lambda8;
            }
        }).flatMap(new ExceptionParserAphome());
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: fetchBanner$lambda-8 */
    public static final FetchBannerInfoResult m546fetchBanner$lambda8(BaseCashierResponse baseCashierResponse) {
        Intrinsics.checkNotNullParameter(baseCashierResponse, "");
        return (FetchBannerInfoResult) baseCashierResponse.result;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<QueryPromotionInfoResult> getQueryPromotion(QueryPromotionEntityRequest queryPromotionEntityRequest) {
        Intrinsics.checkNotNullParameter(queryPromotionEntityRequest, "");
        queryPromotionEntityRequest.envInfo = generateMobileEnvInfo();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        addFeVersionFromEnvInfo(linkedHashMap, queryPromotionEntityRequest.envInfo);
        Observable<QueryPromotionInfoResult> flatMap = this.cashierApi.queryPromotion(linkedHashMap, queryPromotionEntityRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                QueryPromotionInfoResult m555getQueryPromotion$lambda9;
                m555getQueryPromotion$lambda9 = NetworkCashierEntityData.m555getQueryPromotion$lambda9((BaseCashierResponse) obj);
                return m555getQueryPromotion$lambda9;
            }
        }).flatMap(new ExceptionParserAphome());
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: getQueryPromotion$lambda-9 */
    public static final QueryPromotionInfoResult m555getQueryPromotion$lambda9(BaseCashierResponse baseCashierResponse) {
        Intrinsics.checkNotNullParameter(baseCashierResponse, "");
        return (QueryPromotionInfoResult) baseCashierResponse.result;
    }

    private final Map<String, String> addFeVersionFromEnvInfo(Map<String, String> map, MobileEnvInfo mobileEnvInfo) {
        String str = mobileEnvInfo != null ? mobileEnvInfo.appVersion : null;
        if (!(str == null || StringsKt.isBlank(str))) {
            String str2 = mobileEnvInfo != null ? mobileEnvInfo.appVersion : null;
            if (str2 == null) {
                str2 = "";
            }
            map.put(CashierHeader.FE_VERSION, str2);
        }
        return map;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<CashierKybProductInfoResult> getCashierKybProduct(GetCashierKybProductEntityRequest cashierKybProductEntityRequest) {
        Intrinsics.checkNotNullParameter(cashierKybProductEntityRequest, "");
        cashierKybProductEntityRequest.envInfo = generateMobileEnvInfo();
        Observable<CashierKybProductInfoResult> flatMap = this.cashierApi.getCashierKybProduct(cashierKybProductEntityRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CashierKybProductInfoResult m548getCashierKybProduct$lambda11;
                m548getCashierKybProduct$lambda11 = NetworkCashierEntityData.m548getCashierKybProduct$lambda11((BaseCashierResponse) obj);
                return m548getCashierKybProduct$lambda11;
            }
        }).flatMap(new ExceptionParserAphome());
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: getCashierKybProduct$lambda-11 */
    public static final CashierKybProductInfoResult m548getCashierKybProduct$lambda11(BaseCashierResponse baseCashierResponse) {
        Intrinsics.checkNotNullParameter(baseCashierResponse, "");
        return (CashierKybProductInfoResult) baseCashierResponse.result;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<CashierAddOnModalCategoryResult> getModalCategory() {
        Observable map = this.cashierApi.getCdnContent(DanaUrl.CASHIER_ADD_ON_MODAL_CATEGORY).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CashierAddOnModalCategoryResult m550getModalCategory$lambda12;
                m550getModalCategory$lambda12 = NetworkCashierEntityData.m550getModalCategory$lambda12((JSONObject) obj);
                return m550getModalCategory$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getModalCategory$lambda-12 */
    public static final CashierAddOnModalCategoryResult m550getModalCategory$lambda12(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        return (CashierAddOnModalCategoryResult) JSON.parseObject(jSONObject.toJSONString(), CashierAddOnModalCategoryResult.class);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<CashierAddOnModalContentResult> getModalContent() {
        Observable map = this.cashierApi.getCdnContent(DanaUrl.CASHIER_ADD_ON_MODAL_CONTENT).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CashierAddOnModalContentResult m551getModalContent$lambda13;
                m551getModalContent$lambda13 = NetworkCashierEntityData.m551getModalContent$lambda13((JSONObject) obj);
                return m551getModalContent$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getModalContent$lambda-13 */
    public static final CashierAddOnModalContentResult m551getModalContent$lambda13(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        return (CashierAddOnModalContentResult) JSON.parseObject(jSONObject.toJSONString(), CashierAddOnModalContentResult.class);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<DefaultInfoResult> updateOrder(CashierUpdateOrderEntityRequest cashierUpdateOrderEntityRequest) {
        Intrinsics.checkNotNullParameter(cashierUpdateOrderEntityRequest, "");
        cashierUpdateOrderEntityRequest.envInfo = generateMobileEnvInfo();
        Observable map = this.cashierApi.updateOrder(cashierUpdateOrderEntityRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DefaultInfoResult m563updateOrder$lambda14;
                m563updateOrder$lambda14 = NetworkCashierEntityData.m563updateOrder$lambda14((BaseCashierResponse) obj);
                return m563updateOrder$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: updateOrder$lambda-14 */
    public static final DefaultInfoResult m563updateOrder$lambda14(BaseCashierResponse baseCashierResponse) {
        Intrinsics.checkNotNullParameter(baseCashierResponse, "");
        return (DefaultInfoResult) baseCashierResponse.result;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<CashierAddOnModalTooltipResult> getTooltipContent(CashierAddOnModalTooltipEntityRequest cashierAddOnModalTooltipEntityRequest) {
        Intrinsics.checkNotNullParameter(cashierAddOnModalTooltipEntityRequest, "");
        cashierAddOnModalTooltipEntityRequest.envInfo = generateMobileEnvInfo();
        Observable<CashierAddOnModalTooltipResult> flatMap = this.cashierApi.getTooltipContent(cashierAddOnModalTooltipEntityRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CashierAddOnModalTooltipResult m556getTooltipContent$lambda15;
                m556getTooltipContent$lambda15 = NetworkCashierEntityData.m556getTooltipContent$lambda15((BaseCashierResponse) obj);
                return m556getTooltipContent$lambda15;
            }
        }).flatMap(new ExceptionParserAphome());
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: getTooltipContent$lambda-15 */
    public static final CashierAddOnModalTooltipResult m556getTooltipContent$lambda15(BaseCashierResponse baseCashierResponse) {
        Intrinsics.checkNotNullParameter(baseCashierResponse, "");
        return (CashierAddOnModalTooltipResult) baseCashierResponse.result;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<CashierAddOnCdnTooltipResult> getTooltipFromCdn(String tooltip) {
        Intrinsics.checkNotNullParameter(tooltip, "");
        CashierSecureApi cashierSecureApi = this.cashierApi;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(DanaUrl.CASHIER_ADD_ON_MODAL_TOOLTIP, Arrays.copyOf(new Object[]{tooltip}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        Observable map = cashierSecureApi.getCdnContent(format).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CashierAddOnCdnTooltipResult m557getTooltipFromCdn$lambda16;
                m557getTooltipFromCdn$lambda16 = NetworkCashierEntityData.m557getTooltipFromCdn$lambda16((JSONObject) obj);
                return m557getTooltipFromCdn$lambda16;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getTooltipFromCdn$lambda-16 */
    public static final CashierAddOnCdnTooltipResult m557getTooltipFromCdn$lambda16(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        return (CashierAddOnCdnTooltipResult) JSON.parseObject(jSONObject.toJSONString(), CashierAddOnCdnTooltipResult.class);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<TopUpConsultResult> getTopUpConsult(TopUpConsultEntityRequest topUpConsultEntityRequest) {
        Intrinsics.checkNotNullParameter(topUpConsultEntityRequest, "");
        topUpConsultEntityRequest.envInfo = generateMobileEnvInfo();
        Observable map = this.cashierApi.getTopUpConsult(topUpConsultEntityRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                TopUpConsultResult m559getTopUpConsult$lambda17;
                m559getTopUpConsult$lambda17 = NetworkCashierEntityData.m559getTopUpConsult$lambda17((BaseCashierResponse) obj);
                return m559getTopUpConsult$lambda17;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getTopUpConsult$lambda-17 */
    public static final TopUpConsultResult m559getTopUpConsult$lambda17(BaseCashierResponse baseCashierResponse) {
        Intrinsics.checkNotNullParameter(baseCashierResponse, "");
        return (TopUpConsultResult) baseCashierResponse.result;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<TopUpPayEntityResult> topUpSubmit(TopUpSubmitEntityRequest topUpSubmitEntityRequest) {
        Intrinsics.checkNotNullParameter(topUpSubmitEntityRequest, "");
        topUpSubmitEntityRequest.envInfo = generateMobileEnvInfo();
        topUpSubmitEntityRequest.extParams = generateTopUpSubmitExtParams(topUpSubmitEntityRequest.getTopupPayOrderInfo());
        topUpSubmitEntityRequest.setTopupPayOrderInfo(null);
        Observable map = this.cashierApi.topUpSubmit(topUpSubmitEntityRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                TopUpPayEntityResult m561topUpSubmit$lambda18;
                m561topUpSubmit$lambda18 = NetworkCashierEntityData.m561topUpSubmit$lambda18((BaseCashierResponse) obj);
                return m561topUpSubmit$lambda18;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: topUpSubmit$lambda-18 */
    public static final TopUpPayEntityResult m561topUpSubmit$lambda18(BaseCashierResponse baseCashierResponse) {
        Intrinsics.checkNotNullParameter(baseCashierResponse, "");
        return (TopUpPayEntityResult) baseCashierResponse.result;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<TopUpPayEntityResult> topUpVerify(TopUpVerifyEntityRequest topUpVerifyEntityRequest) {
        Intrinsics.checkNotNullParameter(topUpVerifyEntityRequest, "");
        topUpVerifyEntityRequest.envInfo = generateMobileEnvInfo();
        Observable map = this.cashierApi.topUpVerify(topUpVerifyEntityRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                TopUpPayEntityResult m562topUpVerify$lambda19;
                m562topUpVerify$lambda19 = NetworkCashierEntityData.m562topUpVerify$lambda19((BaseCashierResponse) obj);
                return m562topUpVerify$lambda19;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: topUpVerify$lambda-19 */
    public static final TopUpPayEntityResult m562topUpVerify$lambda19(BaseCashierResponse baseCashierResponse) {
        Intrinsics.checkNotNullParameter(baseCashierResponse, "");
        return (TopUpPayEntityResult) baseCashierResponse.result;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<TopUpConsultResult> getTopUpAgent(TopUpConsultEntityRequest topUpConsultEntityRequest) {
        Intrinsics.checkNotNullParameter(topUpConsultEntityRequest, "");
        topUpConsultEntityRequest.envInfo = generateMobileEnvInfo();
        Observable map = this.cashierApi.getTopUpAgent(topUpConsultEntityRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                TopUpConsultResult m558getTopUpAgent$lambda20;
                m558getTopUpAgent$lambda20 = NetworkCashierEntityData.m558getTopUpAgent$lambda20((BaseCashierResponse) obj);
                return m558getTopUpAgent$lambda20;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getTopUpAgent$lambda-20 */
    public static final TopUpConsultResult m558getTopUpAgent$lambda20(BaseCashierResponse baseCashierResponse) {
        Intrinsics.checkNotNullParameter(baseCashierResponse, "");
        return (TopUpConsultResult) baseCashierResponse.result;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<DefaultInfoResult> addAssetCardForUser(AddAssetCardForUserEntityRequest addAssetCardForUserEntityRequest) {
        Intrinsics.checkNotNullParameter(addAssetCardForUserEntityRequest, "");
        addAssetCardForUserEntityRequest.envInfo = generateMobileEnvInfo();
        Observable map = this.cashierApi.addAssetCardForUser(addAssetCardForUserEntityRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DefaultInfoResult m543addAssetCardForUser$lambda21;
                m543addAssetCardForUser$lambda21 = NetworkCashierEntityData.m543addAssetCardForUser$lambda21((BaseCashierResponse) obj);
                return m543addAssetCardForUser$lambda21;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: addAssetCardForUser$lambda-21 */
    public static final DefaultInfoResult m543addAssetCardForUser$lambda21(BaseCashierResponse baseCashierResponse) {
        Intrinsics.checkNotNullParameter(baseCashierResponse, "");
        return (DefaultInfoResult) baseCashierResponse.result;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<QueryInstallmentResult> getQueryInstallment(final QueryInstallmentEntityRequest queryInstallmentEntityRequest) {
        Intrinsics.checkNotNullParameter(queryInstallmentEntityRequest, "");
        if (Intrinsics.areEqual(queryInstallmentEntityRequest.getPayMethod(), "ONLINE_CREDIT")) {
            queryInstallmentEntityRequest.setEnvInfo(generateMobileEnvInfo());
        }
        queryInstallmentEntityRequest.setExtParams(mapDeviceInfo());
        return wrapper(getCashierApi(true), new Function1<CashierSecureApi, Observable<BaseCashierResponse<QueryInstallmentResult>>>() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$getQueryInstallment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<BaseCashierResponse<QueryInstallmentResult>> invoke(CashierSecureApi cashierSecureApi) {
                Intrinsics.checkNotNullParameter(cashierSecureApi, "");
                return cashierSecureApi.queryInstallment(QueryInstallmentEntityRequest.this);
            }
        });
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<Map<String, CashierCurrencyFromCdnResult>> getCurrencyFromCdn() {
        Observable map = this.cashierApi.getCdnContent(DanaUrl.GN_COUNTRY_CURRENCY_CODE).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Map m549getCurrencyFromCdn$lambda22;
                m549getCurrencyFromCdn$lambda22 = NetworkCashierEntityData.m549getCurrencyFromCdn$lambda22((JSONObject) obj);
                return m549getCurrencyFromCdn$lambda22;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getCurrencyFromCdn$lambda-22 */
    public static final Map m549getCurrencyFromCdn$lambda22(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        return (Map) new Gson().fromJson(jSONObject.toString(), new TypeToken<Map<String, ? extends CashierCurrencyFromCdnResult>>() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$getCurrencyFromCdn$1$countryDetailResult$1
        }.getType());
    }

    private final Map<String, DeviceInfo> mapDeviceInfo() {
        return MapsKt.mapOf(TuplesKt.to(DanaLogConstants.BizType.DEVICE_INFO, this.deviceInformationProvider.assembleDeviceInfo()));
    }

    private final Map<String, String> generateTopUpSubmitExtParams(Map<String, String> orderInfo) {
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("clientId", "");
        if (orderInfo == null) {
            orderInfo = MapsKt.emptyMap();
        }
        pairArr[1] = TuplesKt.to("topupOrderInfo", new org.json.JSONObject(orderInfo).toString());
        return MapsKt.mapOf(pairArr);
    }
}
