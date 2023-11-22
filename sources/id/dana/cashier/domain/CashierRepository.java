package id.dana.cashier.domain;

import id.dana.cashier.domain.model.AddAssetCardForUserRequest;
import id.dana.cashier.domain.model.CashierAddOnCdnTooltip;
import id.dana.cashier.domain.model.CashierAddOnModalContent;
import id.dana.cashier.domain.model.CashierAddOnModalTooltip;
import id.dana.cashier.domain.model.CashierAddOnModalTooltipRequest;
import id.dana.cashier.domain.model.CashierAgreementRequest;
import id.dana.cashier.domain.model.CashierAgreementResponse;
import id.dana.cashier.domain.model.CashierCurrencyFromCdn;
import id.dana.cashier.domain.model.CashierHighlightConfig;
import id.dana.cashier.domain.model.CashierKybProductInfo;
import id.dana.cashier.domain.model.CashierPay;
import id.dana.cashier.domain.model.CashierPayRequest;
import id.dana.cashier.domain.model.CashierUpdateOrderRequest;
import id.dana.cashier.domain.model.CreateOrderInfo;
import id.dana.cashier.domain.model.CreateOrderRequest;
import id.dana.cashier.domain.model.FetchBannerInfo;
import id.dana.cashier.domain.model.FetchBannerRequest;
import id.dana.cashier.domain.model.GetCashierKybProductRequest;
import id.dana.cashier.domain.model.NpsSurveyConsultInfo;
import id.dana.cashier.domain.model.NpsSurveyConsultRequest;
import id.dana.cashier.domain.model.NpsSurveySubmitRequest;
import id.dana.cashier.domain.model.QueryCardPolicy;
import id.dana.cashier.domain.model.QueryCardPolicyInfo;
import id.dana.cashier.domain.model.QueryPayOptionInfoRequest;
import id.dana.cashier.domain.model.QueryPromotionInfo;
import id.dana.cashier.domain.model.QueryPromotionRequest;
import id.dana.cashier.domain.model.TopUpConsult;
import id.dana.cashier.domain.model.TopUpConsultRequest;
import id.dana.cashier.domain.model.TopUpPay;
import id.dana.cashier.domain.model.TopUpSubmitRequest;
import id.dana.cashier.domain.model.TopUpVerifyRequest;
import id.dana.cashier.domain.model.paylater.LoanRegisterResultInfo;
import id.dana.cashier.domain.model.paylater.PaylaterCashierPayRequest;
import id.dana.cashier.domain.model.paylater.QueryInstallment;
import id.dana.cashier.domain.model.paylater.QueryInstallmentRequest;
import id.dana.domain.paylater.model.PaylaterAgreementConfig;
import id.dana.domain.promotion.Space;
import id.dana.utils.rpc.response.DefaultResponse;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0003H&J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0003H&J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00032\u0006\u0010\"\u001a\u00020\u0019H&J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u00032\u0006\u0010\"\u001a\u00020\u0019H&J\u001a\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020&0%0\u0003H&J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00190\u0003H&J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00032\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0019H&J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00032\u0006\u0010+\u001a\u00020\u0019H&J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020)0\u0003H&J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00032\u0006\u00101\u001a\u00020\u0019H&J\u0014\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0019030\u0003H&J\u000e\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0003H&J\u001e\u00106\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019H&J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u0003H&J\u000e\u0010;\u001a\b\u0012\u0004\u0012\u00020-0\u0003H&J\u000e\u0010<\u001a\b\u0012\u0004\u0012\u00020)0\u0003H&J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u00032\u0006\u0010?\u001a\u00020@H&J\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u00032\u0006\u0010C\u001a\u00020DH&J\u0016\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u00032\u0006\u0010G\u001a\u00020HH&J\u0016\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\u00032\u0006\u0010K\u001a\u00020LH&J\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u00032\u0006\u0010O\u001a\u00020PH&J\u0016\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\u00032\u0006\u0010S\u001a\u00020\u0019H&J\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00020U0\u00032\u0006\u0010V\u001a\u00020WH&J\u0016\u0010X\u001a\b\u0012\u0004\u0012\u00020U0\u00032\u0006\u0010V\u001a\u00020WH&J*\u0010Y\u001a\b\u0012\u0004\u0012\u00020F0\u00032\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010_H&J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\u00032\u0006\u0010+\u001a\u00020\u0019H&J\u001e\u0010a\u001a\b\u0012\u0004\u0012\u00020]0\u00032\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0019H&J\u001e\u0010b\u001a\b\u0012\u0004\u0012\u00020]0\u00032\u0006\u0010+\u001a\u00020\u00192\u0006\u0010c\u001a\u00020-H&J\u0016\u0010d\u001a\b\u0012\u0004\u0012\u00020]0\u00032\u0006\u0010e\u001a\u00020-H&J\u0016\u0010f\u001a\b\u0012\u0004\u0012\u00020]0\u00032\u0006\u0010g\u001a\u00020)H&J\u0016\u0010h\u001a\b\u0012\u0004\u0012\u00020]0\u00032\u0006\u0010i\u001a\u00020)H&J\u0016\u0010j\u001a\b\u0012\u0004\u0012\u00020]0\u00032\u0006\u0010k\u001a\u00020lH&J\u0016\u0010m\u001a\b\u0012\u0004\u0012\u00020n0\u00032\u0006\u0010o\u001a\u00020pH&J\u0016\u0010q\u001a\b\u0012\u0004\u0012\u00020n0\u00032\u0006\u0010r\u001a\u00020sH&J\u0016\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010u\u001a\u00020vH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006wÀ\u0006\u0001"}, d2 = {"Lid/dana/cashier/domain/CashierRepository;", "", "addAssetCardForUser", "Lio/reactivex/Observable;", "Lid/dana/utils/rpc/response/DefaultResponse;", "addAssetCardForUserRequest", "Lid/dana/cashier/domain/model/AddAssetCardForUserRequest;", "createCashierAgreement", "Lid/dana/cashier/domain/model/CashierAgreementResponse;", "cashierAgreementRequest", "Lid/dana/cashier/domain/model/CashierAgreementRequest;", "createOrder", "Lid/dana/cashier/domain/model/CreateOrderInfo;", "createOrderRequest", "Lid/dana/cashier/domain/model/CreateOrderRequest;", "fetchBanner", "Lid/dana/cashier/domain/model/FetchBannerInfo;", "fetchBannerRequest", "Lid/dana/cashier/domain/model/FetchBannerRequest;", "fetchNpsSurvey", "Lid/dana/cashier/domain/model/NpsSurveyConsultInfo;", "npsSurveyConsultRequest", "Lid/dana/cashier/domain/model/NpsSurveyConsultRequest;", "getCashierEntryPoints", "", "", "getCashierHighlightConfig", "Lid/dana/cashier/domain/model/CashierHighlightConfig;", "getCashierKybProduct", "Lid/dana/cashier/domain/model/CashierKybProductInfo;", "cashierKybProductRequest", "Lid/dana/cashier/domain/model/GetCashierKybProductRequest;", "getCdpGuide", "Lid/dana/domain/promotion/Space;", "spaceCode", "getCdpPaylaterCicilOnboardingContent", "getCurrencyFromCdn", "", "Lid/dana/cashier/domain/model/CashierCurrencyFromCdn;", "getHighlightNewInstId", "getHighlightTimeShown", "", "mode", "instId", "getHighlightVersion", "", "getLastTimeSmartPayActivationShow", "getLoanRegisterInfo", "Lid/dana/cashier/domain/model/paylater/LoanRegisterResultInfo;", "agreementKey", "getModalCategory", "", "getModalContent", "Lid/dana/cashier/domain/model/CashierAddOnModalContent;", "getOneklikRedirectUrl", "scenario", "deviceId", "getPaylaterAgreementConfig", "Lid/dana/domain/paylater/model/PaylaterAgreementConfig;", "getPaylaterCicilRegistrationCacheCooldownCount", "getPaylaterCicilRegistrationCacheCooldownDelay", "getQueryCardPolicyByCardNo", "Lid/dana/cashier/domain/model/QueryCardPolicyInfo;", "queryCardPolicy", "Lid/dana/cashier/domain/model/QueryCardPolicy;", "getQueryInstallment", "Lid/dana/cashier/domain/model/paylater/QueryInstallment;", "queryInstallmentRequest", "Lid/dana/cashier/domain/model/paylater/QueryInstallmentRequest;", "getQueryPayOption", "Lid/dana/cashier/domain/model/CashierPay;", "queryPayOptionInfoRequest", "Lid/dana/cashier/domain/model/QueryPayOptionInfoRequest;", "getQueryPromotion", "Lid/dana/cashier/domain/model/QueryPromotionInfo;", "queryPromotionRequest", "Lid/dana/cashier/domain/model/QueryPromotionRequest;", "getTooltipContent", "Lid/dana/cashier/domain/model/CashierAddOnModalTooltip;", "cashierAddOnModalTooltipRequest", "Lid/dana/cashier/domain/model/CashierAddOnModalTooltipRequest;", "getTooltipFromCdn", "Lid/dana/cashier/domain/model/CashierAddOnCdnTooltip;", "tooltip", "getTopUpAgent", "Lid/dana/cashier/domain/model/TopUpConsult;", "topUpConsultRequest", "Lid/dana/cashier/domain/model/TopUpConsultRequest;", "getTopUpConsult", "payCashier", "cashierPayRequest", "Lid/dana/cashier/domain/model/CashierPayRequest;", "isGpsActive", "", "paylaterCashierPayRequest", "Lid/dana/cashier/domain/model/paylater/PaylaterCashierPayRequest;", "saveHighlightNewInstId", "saveHighlightTimeShown", "saveHighlightVersion", "version", "savePaylaterCicilRegistrationCacheCooldownCount", "cacheCooldownCount", "savePaylaterCicilRegistrationCacheCooldownDelay", "cacheCooldownDelayStartTime", "setLastSmartPayActivationShow", "lastTime", "submitNpsSurvey", "npsSurveySubmitRequest", "Lid/dana/cashier/domain/model/NpsSurveySubmitRequest;", "topUpSubmit", "Lid/dana/cashier/domain/model/TopUpPay;", "topUpSubmitRequest", "Lid/dana/cashier/domain/model/TopUpSubmitRequest;", "topUpVerify", "topUpVerifyRequest", "Lid/dana/cashier/domain/model/TopUpVerifyRequest;", "updateOrder", "cashierUpdateOrderRequest", "Lid/dana/cashier/domain/model/CashierUpdateOrderRequest;", "feature-cashier_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface CashierRepository {
    Observable<DefaultResponse> addAssetCardForUser(AddAssetCardForUserRequest addAssetCardForUserRequest);

    Observable<CashierAgreementResponse> createCashierAgreement(CashierAgreementRequest cashierAgreementRequest);

    Observable<CreateOrderInfo> createOrder(CreateOrderRequest createOrderRequest);

    Observable<FetchBannerInfo> fetchBanner(FetchBannerRequest fetchBannerRequest);

    Observable<NpsSurveyConsultInfo> fetchNpsSurvey(NpsSurveyConsultRequest npsSurveyConsultRequest);

    Observable<List<String>> getCashierEntryPoints();

    Observable<CashierHighlightConfig> getCashierHighlightConfig();

    Observable<CashierKybProductInfo> getCashierKybProduct(GetCashierKybProductRequest cashierKybProductRequest);

    Observable<Space> getCdpGuide(String spaceCode);

    Observable<Space> getCdpPaylaterCicilOnboardingContent(String spaceCode);

    Observable<Map<String, CashierCurrencyFromCdn>> getCurrencyFromCdn();

    Observable<String> getHighlightNewInstId();

    Observable<Long> getHighlightTimeShown(String mode, String instId);

    Observable<Integer> getHighlightVersion(String instId);

    Observable<Long> getLastTimeSmartPayActivationShow();

    Observable<LoanRegisterResultInfo> getLoanRegisterInfo(String agreementKey);

    Observable<List<String>> getModalCategory();

    Observable<CashierAddOnModalContent> getModalContent();

    Observable<String> getOneklikRedirectUrl(String scenario, String deviceId);

    Observable<PaylaterAgreementConfig> getPaylaterAgreementConfig();

    Observable<Integer> getPaylaterCicilRegistrationCacheCooldownCount();

    Observable<Long> getPaylaterCicilRegistrationCacheCooldownDelay();

    Observable<QueryCardPolicyInfo> getQueryCardPolicyByCardNo(QueryCardPolicy queryCardPolicy);

    Observable<QueryInstallment> getQueryInstallment(QueryInstallmentRequest queryInstallmentRequest);

    Observable<CashierPay> getQueryPayOption(QueryPayOptionInfoRequest queryPayOptionInfoRequest);

    Observable<QueryPromotionInfo> getQueryPromotion(QueryPromotionRequest queryPromotionRequest);

    Observable<CashierAddOnModalTooltip> getTooltipContent(CashierAddOnModalTooltipRequest cashierAddOnModalTooltipRequest);

    Observable<CashierAddOnCdnTooltip> getTooltipFromCdn(String tooltip);

    Observable<TopUpConsult> getTopUpAgent(TopUpConsultRequest topUpConsultRequest);

    Observable<TopUpConsult> getTopUpConsult(TopUpConsultRequest topUpConsultRequest);

    Observable<CashierPay> payCashier(CashierPayRequest cashierPayRequest, boolean isGpsActive, PaylaterCashierPayRequest paylaterCashierPayRequest);

    Observable<Boolean> saveHighlightNewInstId(String instId);

    Observable<Boolean> saveHighlightTimeShown(String mode, String instId);

    Observable<Boolean> saveHighlightVersion(String instId, int version);

    Observable<Boolean> savePaylaterCicilRegistrationCacheCooldownCount(int cacheCooldownCount);

    Observable<Boolean> savePaylaterCicilRegistrationCacheCooldownDelay(long cacheCooldownDelayStartTime);

    Observable<Boolean> setLastSmartPayActivationShow(long lastTime);

    Observable<Boolean> submitNpsSurvey(NpsSurveySubmitRequest npsSurveySubmitRequest);

    Observable<TopUpPay> topUpSubmit(TopUpSubmitRequest topUpSubmitRequest);

    Observable<TopUpPay> topUpVerify(TopUpVerifyRequest topUpVerifyRequest);

    Observable<DefaultResponse> updateOrder(CashierUpdateOrderRequest cashierUpdateOrderRequest);

    /* renamed from: id.dana.cashier.domain.CashierRepository$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable payCashier$default(CashierRepository cashierRepository, CashierPayRequest cashierPayRequest, boolean z, PaylaterCashierPayRequest paylaterCashierPayRequest, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    paylaterCashierPayRequest = null;
                }
                return cashierRepository.payCashier(cashierPayRequest, z, paylaterCashierPayRequest);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: payCashier");
        }
    }
}
