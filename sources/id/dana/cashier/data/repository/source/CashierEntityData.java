package id.dana.cashier.data.repository.source;

import id.dana.cashier.data.repository.source.network.request.AddAssetCardForUserEntityRequest;
import id.dana.cashier.data.repository.source.network.request.AdditionalPaylaterCashierPayRequest;
import id.dana.cashier.data.repository.source.network.request.CashierAddOnModalTooltipEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CashierAgreementEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CashierPayEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CashierUpdateOrderEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CreateOrderEntityRequest;
import id.dana.cashier.data.repository.source.network.request.FetchBannerEntityRequest;
import id.dana.cashier.data.repository.source.network.request.GetCashierKybProductEntityRequest;
import id.dana.cashier.data.repository.source.network.request.QueryCardPolicyRequest;
import id.dana.cashier.data.repository.source.network.request.QueryInstallmentEntityRequest;
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
import id.dana.cashier.data.repository.source.network.result.CashierHighlightConfigResult;
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
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0003H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$0\u0003H\u0016J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u00032\u0006\u0010(\u001a\u00020%H\u0016J&\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00032\u0006\u0010+\u001a\u00020%2\u0006\u0010(\u001a\u00020%2\u0006\u0010,\u001a\u00020%H\u0016J\u001e\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00032\u0006\u0010(\u001a\u00020%2\u0006\u0010,\u001a\u00020%H\u0016J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020*0\u00032\u0006\u0010(\u001a\u00020%H\u0016J\u000e\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0003H\u0016J\u000e\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0003H\u0016J\u001e\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00032\u0006\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020%H\u0016J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020.0\u00032\u0006\u0010(\u001a\u00020%H\u0016J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020*0\u00032\u0006\u0010(\u001a\u00020%H\u0016J\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00032\u0006\u0010<\u001a\u00020=H\u0016J\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u00032\u0006\u0010@\u001a\u00020AH\u0016J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010C\u001a\u00020DH\u0016J\u0016\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u00032\u0006\u0010G\u001a\u00020HH\u0016J\u0016\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\u00032\u0006\u0010K\u001a\u00020LH\u0016J\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u00032\u0006\u0010O\u001a\u00020%H\u0016J\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u00032\u0006\u0010R\u001a\u00020SH\u0016J\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00020Q0\u00032\u0006\u0010R\u001a\u00020SH\u0016J\u001e\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u00032\u0006\u0010(\u001a\u00020%2\u0006\u0010,\u001a\u00020%H\u0016J&\u0010W\u001a\b\u0012\u0004\u0012\u00020V0\u00032\u0006\u0010+\u001a\u00020%2\u0006\u0010(\u001a\u00020%2\u0006\u0010,\u001a\u00020%H\u0016J&\u0010X\u001a\b\u0012\u0004\u0012\u00020V0\u00032\u0006\u0010(\u001a\u00020%2\u0006\u0010,\u001a\u00020%2\u0006\u0010Y\u001a\u00020.H\u0016J\u001e\u0010Z\u001a\b\u0012\u0004\u0012\u00020V0\u00032\u0006\u0010[\u001a\u00020.2\u0006\u0010(\u001a\u00020%H\u0016J\u001e\u0010\\\u001a\b\u0012\u0004\u0012\u00020V0\u00032\u0006\u0010]\u001a\u00020*2\u0006\u0010(\u001a\u00020%H\u0016J\u001e\u0010^\u001a\b\u0012\u0004\u0012\u00020V0\u00032\u0006\u0010_\u001a\u00020*2\u0006\u0010(\u001a\u00020%H\u0016J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00020a0\u00032\u0006\u0010b\u001a\u00020cH\u0016J\u0016\u0010d\u001a\b\u0012\u0004\u0012\u00020e0\u00032\u0006\u0010f\u001a\u00020gH\u0016J\u0016\u0010h\u001a\b\u0012\u0004\u0012\u00020e0\u00032\u0006\u0010i\u001a\u00020jH\u0016J\u0016\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010l\u001a\u00020mH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006nÀ\u0006\u0001"}, d2 = {"Lid/dana/cashier/data/repository/source/CashierEntityData;", "", "addAssetCardForUser", "Lio/reactivex/Observable;", "Lid/dana/data/model/DefaultInfoResult;", "addAssetCardForUserEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/AddAssetCardForUserEntityRequest;", "createCashierEKtpAgreement", "Lid/dana/cashier/data/repository/source/network/result/CashierAgreementResult;", "cashierEKtpAgreementEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/CashierAgreementEntityRequest;", "doCashierPay", "Lid/dana/cashier/data/repository/source/network/result/CashierPayInfoResult;", "cashierPayEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/CashierPayEntityRequest;", "additionalPaylaterCashierPayRequest", "Lid/dana/cashier/data/repository/source/network/request/AdditionalPaylaterCashierPayRequest;", "doCreateOrder", "Lid/dana/cashier/data/repository/source/network/result/CreateOrderInfoResult;", "createOrderEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/CreateOrderEntityRequest;", "fetchBanner", "Lid/dana/cashier/data/repository/source/network/result/FetchBannerInfoResult;", "fetchBannerEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/FetchBannerEntityRequest;", "fetchNpsSurvey", "Lid/dana/cashier/data/repository/source/network/result/npssurvey/NpsSurveyInfoResult;", "npsSurveyConsultEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveyConsultEntityRequest;", "getCashierHighlightConfig", "Lid/dana/cashier/data/repository/source/network/result/CashierHighlightConfigResult;", "getCashierKybProduct", "Lid/dana/cashier/data/repository/source/network/result/CashierKybProductInfoResult;", "cashierKybProductEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/GetCashierKybProductEntityRequest;", "getCurrencyFromCdn", "", "", "Lid/dana/cashier/data/repository/source/network/result/CashierCurrencyFromCdnResult;", "getHighlightNewInstId", "phoneNumber", "getHighlightTimeShown", "", "mode", "instId", "getHighlightVersion", "", "getLastTimeSmartPayActivationShow", "getModalCategory", "Lid/dana/cashier/data/repository/source/network/result/CashierAddOnModalCategoryResult;", "getModalContent", "Lid/dana/cashier/data/repository/source/network/result/CashierAddOnModalContentResult;", "getOneklikRedirectUrl", "Lid/dana/cashier/data/repository/source/network/result/QueryOneklikRedirectUrlResult;", "scenario", "deviceId", "getPaylaterCicilRegistrationCacheCooldownCount", "getPaylaterCicilRegistrationCacheCooldownDelay", "getQueryCardPolicyByCardNo", "Lid/dana/cashier/data/repository/source/network/result/QueryCardPolicyInfoResult;", "queryCardPolicyRequest", "Lid/dana/cashier/data/repository/source/network/request/QueryCardPolicyRequest;", "getQueryInstallment", "Lid/dana/cashier/data/repository/source/network/result/QueryInstallmentResult;", "queryInstallmentEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/QueryInstallmentEntityRequest;", "getQueryPayOption", "queryPayOptionRequest", "Lid/dana/cashier/data/repository/source/network/request/QueryPayOptionRequest;", "getQueryPromotion", "Lid/dana/cashier/data/repository/source/network/result/QueryPromotionInfoResult;", "queryPromotionEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/QueryPromotionEntityRequest;", "getTooltipContent", "Lid/dana/cashier/data/repository/source/network/result/CashierAddOnModalTooltipResult;", "cashierAddOnModalTooltipEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/CashierAddOnModalTooltipEntityRequest;", "getTooltipFromCdn", "Lid/dana/cashier/data/repository/source/network/result/CashierAddOnCdnTooltipResult;", "tooltip", "getTopUpAgent", "Lid/dana/cashier/data/repository/source/network/result/TopUpConsultResult;", "topUpConsultEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/TopUpConsultEntityRequest;", "getTopUpConsult", "saveHighlightNewInstId", "", "saveHighlightTimeShown", "saveHighlightVersion", "version", "savePaylaterCicilRegistrationCacheCooldownCount", "cacheCooldownCount", "savePaylaterCicilRegistrationCacheCooldownDelay", "cacheCooldownDelayStartTime", "setLastSmartPayActivationShow", "lastTime", "submitNpsSurvey", "Lid/dana/cashier/data/repository/source/network/result/npssurvey/NpsSurveySubmitEntityResult;", "npsSurveySubmitEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitEntityRequest;", "topUpSubmit", "Lid/dana/cashier/data/repository/source/network/result/TopUpPayEntityResult;", "topUpSubmitEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/TopUpSubmitEntityRequest;", "topUpVerify", "topUpVerifyEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/TopUpVerifyEntityRequest;", "updateOrder", "cashierUpdateOrderEntityRequest", "Lid/dana/cashier/data/repository/source/network/request/CashierUpdateOrderEntityRequest;", "feature-cashier_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface CashierEntityData {
    Observable<DefaultInfoResult> addAssetCardForUser(AddAssetCardForUserEntityRequest addAssetCardForUserEntityRequest);

    Observable<CashierAgreementResult> createCashierEKtpAgreement(CashierAgreementEntityRequest cashierEKtpAgreementEntityRequest);

    Observable<CashierPayInfoResult> doCashierPay(CashierPayEntityRequest cashierPayEntityRequest, AdditionalPaylaterCashierPayRequest additionalPaylaterCashierPayRequest);

    Observable<CreateOrderInfoResult> doCreateOrder(CreateOrderEntityRequest createOrderEntityRequest);

    Observable<FetchBannerInfoResult> fetchBanner(FetchBannerEntityRequest fetchBannerEntityRequest);

    Observable<NpsSurveyInfoResult> fetchNpsSurvey(NpsSurveyConsultEntityRequest npsSurveyConsultEntityRequest);

    Observable<CashierHighlightConfigResult> getCashierHighlightConfig();

    Observable<CashierKybProductInfoResult> getCashierKybProduct(GetCashierKybProductEntityRequest cashierKybProductEntityRequest);

    Observable<Map<String, CashierCurrencyFromCdnResult>> getCurrencyFromCdn();

    Observable<String> getHighlightNewInstId(String phoneNumber);

    Observable<Long> getHighlightTimeShown(String mode, String phoneNumber, String instId);

    Observable<Integer> getHighlightVersion(String phoneNumber, String instId);

    Observable<Long> getLastTimeSmartPayActivationShow(String phoneNumber);

    Observable<CashierAddOnModalCategoryResult> getModalCategory();

    Observable<CashierAddOnModalContentResult> getModalContent();

    Observable<QueryOneklikRedirectUrlResult> getOneklikRedirectUrl(String scenario, String deviceId);

    Observable<Integer> getPaylaterCicilRegistrationCacheCooldownCount(String phoneNumber);

    Observable<Long> getPaylaterCicilRegistrationCacheCooldownDelay(String phoneNumber);

    Observable<QueryCardPolicyInfoResult> getQueryCardPolicyByCardNo(QueryCardPolicyRequest queryCardPolicyRequest);

    Observable<QueryInstallmentResult> getQueryInstallment(QueryInstallmentEntityRequest queryInstallmentEntityRequest);

    Observable<CashierPayInfoResult> getQueryPayOption(QueryPayOptionRequest queryPayOptionRequest);

    Observable<QueryPromotionInfoResult> getQueryPromotion(QueryPromotionEntityRequest queryPromotionEntityRequest);

    Observable<CashierAddOnModalTooltipResult> getTooltipContent(CashierAddOnModalTooltipEntityRequest cashierAddOnModalTooltipEntityRequest);

    Observable<CashierAddOnCdnTooltipResult> getTooltipFromCdn(String tooltip);

    Observable<TopUpConsultResult> getTopUpAgent(TopUpConsultEntityRequest topUpConsultEntityRequest);

    Observable<TopUpConsultResult> getTopUpConsult(TopUpConsultEntityRequest topUpConsultEntityRequest);

    Observable<Boolean> saveHighlightNewInstId(String phoneNumber, String instId);

    Observable<Boolean> saveHighlightTimeShown(String mode, String phoneNumber, String instId);

    Observable<Boolean> saveHighlightVersion(String phoneNumber, String instId, int version);

    Observable<Boolean> savePaylaterCicilRegistrationCacheCooldownCount(int cacheCooldownCount, String phoneNumber);

    Observable<Boolean> savePaylaterCicilRegistrationCacheCooldownDelay(long cacheCooldownDelayStartTime, String phoneNumber);

    Observable<Boolean> setLastSmartPayActivationShow(long lastTime, String phoneNumber);

    Observable<NpsSurveySubmitEntityResult> submitNpsSurvey(NpsSurveySubmitEntityRequest npsSurveySubmitEntityRequest);

    Observable<TopUpPayEntityResult> topUpSubmit(TopUpSubmitEntityRequest topUpSubmitEntityRequest);

    Observable<TopUpPayEntityResult> topUpVerify(TopUpVerifyEntityRequest topUpVerifyEntityRequest);

    Observable<DefaultInfoResult> updateOrder(CashierUpdateOrderEntityRequest cashierUpdateOrderEntityRequest);

    /* renamed from: id.dana.cashier.data.repository.source.CashierEntityData$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static Observable $default$doCashierPay(CashierEntityData cashierEntityData, CashierPayEntityRequest cashierPayEntityRequest, AdditionalPaylaterCashierPayRequest additionalPaylaterCashierPayRequest) {
            Intrinsics.checkNotNullParameter(cashierPayEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$doCreateOrder(CashierEntityData cashierEntityData, CreateOrderEntityRequest createOrderEntityRequest) {
            Intrinsics.checkNotNullParameter(createOrderEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$createCashierEKtpAgreement(CashierEntityData cashierEntityData, CashierAgreementEntityRequest cashierAgreementEntityRequest) {
            Intrinsics.checkNotNullParameter(cashierAgreementEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getQueryCardPolicyByCardNo(CashierEntityData cashierEntityData, QueryCardPolicyRequest queryCardPolicyRequest) {
            Intrinsics.checkNotNullParameter(queryCardPolicyRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getQueryPayOption(CashierEntityData cashierEntityData, QueryPayOptionRequest queryPayOptionRequest) {
            Intrinsics.checkNotNullParameter(queryPayOptionRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$fetchBanner(CashierEntityData cashierEntityData, FetchBannerEntityRequest fetchBannerEntityRequest) {
            Intrinsics.checkNotNullParameter(fetchBannerEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getQueryPromotion(CashierEntityData cashierEntityData, QueryPromotionEntityRequest queryPromotionEntityRequest) {
            Intrinsics.checkNotNullParameter(queryPromotionEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getCashierKybProduct(CashierEntityData cashierEntityData, GetCashierKybProductEntityRequest getCashierKybProductEntityRequest) {
            Intrinsics.checkNotNullParameter(getCashierKybProductEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getModalCategory(CashierEntityData cashierEntityData) {
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getModalContent(CashierEntityData cashierEntityData) {
            throw new UnsupportedOperationException();
        }

        public static Observable $default$updateOrder(CashierEntityData cashierEntityData, CashierUpdateOrderEntityRequest cashierUpdateOrderEntityRequest) {
            Intrinsics.checkNotNullParameter(cashierUpdateOrderEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getTooltipContent(CashierEntityData cashierEntityData, CashierAddOnModalTooltipEntityRequest cashierAddOnModalTooltipEntityRequest) {
            Intrinsics.checkNotNullParameter(cashierAddOnModalTooltipEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getTooltipFromCdn(CashierEntityData cashierEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getOneklikRedirectUrl(CashierEntityData cashierEntityData, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getQueryInstallment(CashierEntityData cashierEntityData, QueryInstallmentEntityRequest queryInstallmentEntityRequest) {
            Intrinsics.checkNotNullParameter(queryInstallmentEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getTopUpConsult(CashierEntityData cashierEntityData, TopUpConsultEntityRequest topUpConsultEntityRequest) {
            Intrinsics.checkNotNullParameter(topUpConsultEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$topUpSubmit(CashierEntityData cashierEntityData, TopUpSubmitEntityRequest topUpSubmitEntityRequest) {
            Intrinsics.checkNotNullParameter(topUpSubmitEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$topUpVerify(CashierEntityData cashierEntityData, TopUpVerifyEntityRequest topUpVerifyEntityRequest) {
            Intrinsics.checkNotNullParameter(topUpVerifyEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getTopUpAgent(CashierEntityData cashierEntityData, TopUpConsultEntityRequest topUpConsultEntityRequest) {
            Intrinsics.checkNotNullParameter(topUpConsultEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$addAssetCardForUser(CashierEntityData cashierEntityData, AddAssetCardForUserEntityRequest addAssetCardForUserEntityRequest) {
            Intrinsics.checkNotNullParameter(addAssetCardForUserEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$fetchNpsSurvey(CashierEntityData cashierEntityData, NpsSurveyConsultEntityRequest npsSurveyConsultEntityRequest) {
            Intrinsics.checkNotNullParameter(npsSurveyConsultEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$submitNpsSurvey(CashierEntityData cashierEntityData, NpsSurveySubmitEntityRequest npsSurveySubmitEntityRequest) {
            Intrinsics.checkNotNullParameter(npsSurveySubmitEntityRequest, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getCashierHighlightConfig(CashierEntityData cashierEntityData) {
            throw new UnsupportedOperationException();
        }

        public static Observable $default$saveHighlightVersion(CashierEntityData cashierEntityData, String str, String str2, int i) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getHighlightVersion(CashierEntityData cashierEntityData, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$saveHighlightNewInstId(CashierEntityData cashierEntityData, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getHighlightNewInstId(CashierEntityData cashierEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$saveHighlightTimeShown(CashierEntityData cashierEntityData, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getHighlightTimeShown(CashierEntityData cashierEntityData, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getLastTimeSmartPayActivationShow(CashierEntityData cashierEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$setLastSmartPayActivationShow(CashierEntityData cashierEntityData, long j, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getCurrencyFromCdn(CashierEntityData cashierEntityData) {
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getPaylaterCicilRegistrationCacheCooldownCount(CashierEntityData cashierEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$savePaylaterCicilRegistrationCacheCooldownCount(CashierEntityData cashierEntityData, int i, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getPaylaterCicilRegistrationCacheCooldownDelay(CashierEntityData cashierEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$savePaylaterCicilRegistrationCacheCooldownDelay(CashierEntityData cashierEntityData, long j, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }
    }
}
