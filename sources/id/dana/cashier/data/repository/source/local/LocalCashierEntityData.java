package id.dana.cashier.data.repository.source.local;

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
import id.dana.cashier.data.repository.source.network.request.QueryCardPolicyRequest;
import id.dana.cashier.data.repository.source.network.request.QueryInstallmentEntityRequest;
import id.dana.cashier.data.repository.source.network.request.QueryPayOptionRequest;
import id.dana.cashier.data.repository.source.network.request.QueryPromotionEntityRequest;
import id.dana.cashier.data.repository.source.network.request.TopUpConsultEntityRequest;
import id.dana.cashier.data.repository.source.network.request.TopUpSubmitEntityRequest;
import id.dana.cashier.data.repository.source.network.request.TopUpVerifyEntityRequest;
import id.dana.cashier.data.repository.source.network.request.npssurvey.NpsSurveyConsultEntityRequest;
import id.dana.cashier.data.repository.source.network.request.npssurvey.NpsSurveySubmitEntityRequest;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u000eJ-\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ-\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u001dR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lid/dana/cashier/data/repository/source/local/LocalCashierEntityData;", "Lid/dana/cashier/data/repository/source/CashierEntityData;", "", "phoneNumber", "Lio/reactivex/Observable;", "getHighlightNewInstId", "(Ljava/lang/String;)Lio/reactivex/Observable;", "mode", "instId", "", "getHighlightTimeShown", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "getHighlightVersion", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getLastTimeSmartPayActivationShow", "getPaylaterCicilRegistrationCacheCooldownCount", "getPaylaterCicilRegistrationCacheCooldownDelay", "", "saveHighlightNewInstId", "saveHighlightTimeShown", "version", "saveHighlightVersion", "(Ljava/lang/String;Ljava/lang/String;I)Lio/reactivex/Observable;", "cacheCooldownCount", "savePaylaterCicilRegistrationCacheCooldownCount", "(ILjava/lang/String;)Lio/reactivex/Observable;", "cacheCooldownDelayStartTime", "savePaylaterCicilRegistrationCacheCooldownDelay", "(JLjava/lang/String;)Lio/reactivex/Observable;", "lastTime", "setLastSmartPayActivationShow", "Lid/dana/cashier/data/repository/source/local/CashierPreference;", "cashierPreference", "Lid/dana/cashier/data/repository/source/local/CashierPreference;", "<init>", "(Lid/dana/cashier/data/repository/source/local/CashierPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LocalCashierEntityData implements CashierEntityData {
    private final CashierPreference cashierPreference;

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable addAssetCardForUser(AddAssetCardForUserEntityRequest addAssetCardForUserEntityRequest) {
        return CashierEntityData.CC.$default$addAssetCardForUser(this, addAssetCardForUserEntityRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable createCashierEKtpAgreement(CashierAgreementEntityRequest cashierAgreementEntityRequest) {
        return CashierEntityData.CC.$default$createCashierEKtpAgreement(this, cashierAgreementEntityRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable doCashierPay(CashierPayEntityRequest cashierPayEntityRequest, AdditionalPaylaterCashierPayRequest additionalPaylaterCashierPayRequest) {
        return CashierEntityData.CC.$default$doCashierPay(this, cashierPayEntityRequest, additionalPaylaterCashierPayRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable doCreateOrder(CreateOrderEntityRequest createOrderEntityRequest) {
        return CashierEntityData.CC.$default$doCreateOrder(this, createOrderEntityRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable fetchBanner(FetchBannerEntityRequest fetchBannerEntityRequest) {
        return CashierEntityData.CC.$default$fetchBanner(this, fetchBannerEntityRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable fetchNpsSurvey(NpsSurveyConsultEntityRequest npsSurveyConsultEntityRequest) {
        return CashierEntityData.CC.$default$fetchNpsSurvey(this, npsSurveyConsultEntityRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getCashierHighlightConfig() {
        return CashierEntityData.CC.$default$getCashierHighlightConfig(this);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getCashierKybProduct(GetCashierKybProductEntityRequest getCashierKybProductEntityRequest) {
        return CashierEntityData.CC.$default$getCashierKybProduct(this, getCashierKybProductEntityRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getCurrencyFromCdn() {
        return CashierEntityData.CC.$default$getCurrencyFromCdn(this);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getModalCategory() {
        return CashierEntityData.CC.$default$getModalCategory(this);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getModalContent() {
        return CashierEntityData.CC.$default$getModalContent(this);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getOneklikRedirectUrl(String str, String str2) {
        return CashierEntityData.CC.$default$getOneklikRedirectUrl(this, str, str2);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getQueryCardPolicyByCardNo(QueryCardPolicyRequest queryCardPolicyRequest) {
        return CashierEntityData.CC.$default$getQueryCardPolicyByCardNo(this, queryCardPolicyRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getQueryInstallment(QueryInstallmentEntityRequest queryInstallmentEntityRequest) {
        return CashierEntityData.CC.$default$getQueryInstallment(this, queryInstallmentEntityRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getQueryPayOption(QueryPayOptionRequest queryPayOptionRequest) {
        return CashierEntityData.CC.$default$getQueryPayOption(this, queryPayOptionRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getQueryPromotion(QueryPromotionEntityRequest queryPromotionEntityRequest) {
        return CashierEntityData.CC.$default$getQueryPromotion(this, queryPromotionEntityRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getTooltipContent(CashierAddOnModalTooltipEntityRequest cashierAddOnModalTooltipEntityRequest) {
        return CashierEntityData.CC.$default$getTooltipContent(this, cashierAddOnModalTooltipEntityRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getTooltipFromCdn(String str) {
        return CashierEntityData.CC.$default$getTooltipFromCdn(this, str);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getTopUpAgent(TopUpConsultEntityRequest topUpConsultEntityRequest) {
        return CashierEntityData.CC.$default$getTopUpAgent(this, topUpConsultEntityRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getTopUpConsult(TopUpConsultEntityRequest topUpConsultEntityRequest) {
        return CashierEntityData.CC.$default$getTopUpConsult(this, topUpConsultEntityRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable submitNpsSurvey(NpsSurveySubmitEntityRequest npsSurveySubmitEntityRequest) {
        return CashierEntityData.CC.$default$submitNpsSurvey(this, npsSurveySubmitEntityRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable topUpSubmit(TopUpSubmitEntityRequest topUpSubmitEntityRequest) {
        return CashierEntityData.CC.$default$topUpSubmit(this, topUpSubmitEntityRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable topUpVerify(TopUpVerifyEntityRequest topUpVerifyEntityRequest) {
        return CashierEntityData.CC.$default$topUpVerify(this, topUpVerifyEntityRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable updateOrder(CashierUpdateOrderEntityRequest cashierUpdateOrderEntityRequest) {
        return CashierEntityData.CC.$default$updateOrder(this, cashierUpdateOrderEntityRequest);
    }

    @Inject
    public LocalCashierEntityData(CashierPreference cashierPreference) {
        Intrinsics.checkNotNullParameter(cashierPreference, "");
        this.cashierPreference = cashierPreference;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<Boolean> saveHighlightVersion(String phoneNumber, String instId, int version) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(instId, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.cashierPreference.saveHighlightVersion(phoneNumber, instId, version)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<Integer> getHighlightVersion(String phoneNumber, String instId) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(instId, "");
        Observable<Integer> just = Observable.just(Integer.valueOf(this.cashierPreference.getHighlightVersion(phoneNumber, instId)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<Boolean> saveHighlightNewInstId(String phoneNumber, String instId) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(instId, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.cashierPreference.saveHighlightNewInstId(phoneNumber, instId)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<String> getHighlightNewInstId(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<String> just = Observable.just(this.cashierPreference.getHighlightNewInstId(phoneNumber));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<Boolean> saveHighlightTimeShown(String mode, String phoneNumber, String instId) {
        Intrinsics.checkNotNullParameter(mode, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(instId, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.cashierPreference.saveHighlightTimeShown(mode, phoneNumber, instId)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<Long> getHighlightTimeShown(String mode, String phoneNumber, String instId) {
        Intrinsics.checkNotNullParameter(mode, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(instId, "");
        Observable<Long> just = Observable.just(Long.valueOf(this.cashierPreference.getHighlightTimeShown(mode, phoneNumber, instId)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<Long> getLastTimeSmartPayActivationShow(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Long> just = Observable.just(Long.valueOf(this.cashierPreference.getLastTimeSmartPayActivationShow(phoneNumber)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<Boolean> setLastSmartPayActivationShow(long lastTime, String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.cashierPreference.setLastSmartPayActivationShow(lastTime, phoneNumber)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<Integer> getPaylaterCicilRegistrationCacheCooldownCount(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Integer> just = Observable.just(Integer.valueOf(this.cashierPreference.getPaylaterCicilRegistrationCacheCooldownCount(phoneNumber)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<Boolean> savePaylaterCicilRegistrationCacheCooldownCount(int cacheCooldownCount, String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.cashierPreference.savePaylaterCicilRegistrationCacheCooldownCount(cacheCooldownCount, phoneNumber)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<Long> getPaylaterCicilRegistrationCacheCooldownDelay(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Long> just = Observable.just(Long.valueOf(this.cashierPreference.getPaylaterCicilRegistrationCacheCooldownDelay(phoneNumber)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<Boolean> savePaylaterCicilRegistrationCacheCooldownDelay(long cacheCooldownDelayStartTime, String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.cashierPreference.savePaylaterCicilRegistrationCacheCooldownDelay(cacheCooldownDelayStartTime, phoneNumber)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
