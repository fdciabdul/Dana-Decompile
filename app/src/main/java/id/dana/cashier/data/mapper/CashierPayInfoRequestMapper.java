package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.request.CashierPayEntityRequest;
import id.dana.cashier.data.repository.source.network.request.MixPayMethodRequest;
import id.dana.cashier.domain.model.CashierPayRequest;
import id.dana.cashier.domain.model.CheckoutExternalInfo;
import id.dana.data.encryptcardno.CardCredInfo;
import id.dana.data.encryptcardno.EncryptCardNumber;
import id.dana.domain.payasset.model.PayMethod;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0012\u0010\u0013JG\u0010\n\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/cashier/data/mapper/CashierPayInfoRequestMapper;", "", "", CardCredInfo.CARD_EXPIRE_MONTH, CardCredInfo.CARD_EXPIRE_YEAR, CardCredInfo.CARD_NO, "cvv2", "publicKey", "", "encryptCardEnabled", "encryptCardCredential", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;", "Lid/dana/cashier/domain/model/CashierPayRequest;", "oldItem", "cityName", "Lid/dana/cashier/data/repository/source/network/request/CashierPayEntityRequest;", "map", "(Lid/dana/cashier/domain/model/CashierPayRequest;Ljava/lang/String;ZLjava/lang/String;)Lid/dana/cashier/data/repository/source/network/request/CashierPayEntityRequest;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPayInfoRequestMapper {
    @Inject
    public CashierPayInfoRequestMapper() {
    }

    public final CashierPayEntityRequest map(CashierPayRequest oldItem, String publicKey, boolean encryptCardEnabled, String cityName) {
        MixPayMethodRequest mixPayMethodRequest;
        Intrinsics.checkNotNullParameter(oldItem, "");
        Intrinsics.checkNotNullParameter(publicKey, "");
        boolean z = false;
        boolean z2 = encryptCardEnabled && Intrinsics.areEqual(oldItem.getMethod(), "cashierPay") && !Intrinsics.areEqual(oldItem.getPayMethod(), "BALANCE") && !Intrinsics.areEqual(oldItem.getPayMethod(), PayMethod.LOAN_CREDIT);
        boolean z3 = encryptCardEnabled && oldItem.isEncryptCardEnabledForTopUpPay();
        if (z2 || z3) {
            oldItem.setCardCredential(encryptCardCredential(oldItem.getCardExpireMonth(), oldItem.getCardExpireYear(), oldItem.getCardNo(), oldItem.getCvv2(), publicKey, encryptCardEnabled));
            oldItem.setCardExpireMonth(null);
            oldItem.setCardExpireYear(null);
            oldItem.setCardNo(null);
            oldItem.setCvv2(null);
        }
        String cashierOrderId = oldItem.getCashierOrderId();
        String channelIndex = oldItem.getChannelIndex();
        String payMethod = oldItem.getPayMethod();
        String method = oldItem.getMethod();
        String cardExpireYear = oldItem.getCardExpireYear();
        String cardExpireMonth = oldItem.getCardExpireMonth();
        String cardNo = oldItem.getCardNo();
        Boolean saveCard = oldItem.getSaveCard();
        String cardIndexNo = oldItem.getCardIndexNo();
        String bindingId = oldItem.getBindingId();
        String cardCredential = oldItem.getCardCredential();
        String xcoId = oldItem.getXcoId();
        String limitMaximum = oldItem.getLimitMaximum();
        String maskedCardNo = oldItem.getMaskedCardNo();
        String bankPhoneNo = oldItem.getBankPhoneNo();
        String deviceId = oldItem.getDeviceId();
        String instCode = oldItem.getInstCode();
        String validateData = oldItem.getValidateData();
        String cashierRequestId = oldItem.getCashierRequestId();
        Integer installmentPeriod = oldItem.getInstallmentPeriod();
        String verificationMethod = oldItem.getVerificationMethod();
        String version = oldItem.getVersion();
        List<String> couponIds = oldItem.getCouponIds();
        String inUrl = oldItem.getInUrl();
        CheckoutExternalInfo externalInfo = oldItem.getExternalInfo();
        Boolean reloadRequest = oldItem.getReloadRequest();
        String payMethodFilter = oldItem.getPayMethodFilter();
        if (cityName != null) {
            if (cityName.length() == 0) {
                z = true;
            }
        }
        String str = z ? null : cityName;
        String cvv2 = oldItem.getCvv2();
        List<String> selectedAddons = oldItem.getSelectedAddons();
        String instId = oldItem.getInstId();
        String bizOrderId = oldItem.getBizOrderId();
        Boolean mixPaymentRequest = oldItem.getMixPaymentRequest();
        Integer bukaCreditAmount = oldItem.getBukaCreditAmount();
        String transType = oldItem.getTransType();
        if (oldItem.getMixPayMethod() != null) {
            mixPayMethodRequest = new MixPayMethodRequest(oldItem.getMixPayMethod().getPayMethod(), oldItem.getMixPayMethod().getChannelIndex(), oldItem.getMixPayMethod().getBindingId(), oldItem.getMixPayMethod().getSaveCard(), oldItem.getMixPayMethod().getCardIndexNo(), oldItem.getMixPayMethod().getCardNo() != null ? encryptCardCredential(oldItem.getMixPayMethod().getCardExpireMonth(), oldItem.getMixPayMethod().getCardExpireYear(), oldItem.getMixPayMethod().getCardNo(), oldItem.getMixPayMethod().getCvv2(), publicKey, encryptCardEnabled) : null, oldItem.getMixPayMethod().getDeviceId(), oldItem.getMixPayMethod().getLimitMaximum(), oldItem.getMixPayMethod().getMaskedCardNo(), oldItem.getMixPayMethod().getBankPhoneNo(), oldItem.getMixPayMethod().getInstCode(), oldItem.getMixPayMethod().getXcoId());
        } else {
            mixPayMethodRequest = null;
        }
        return new CashierPayEntityRequest(method, externalInfo, transType, cashierOrderId, channelIndex, payMethod, cardExpireYear, cardExpireMonth, cardNo, saveCard, cardIndexNo, bindingId, cardCredential, xcoId, limitMaximum, maskedCardNo, bankPhoneNo, deviceId, instCode, instId, validateData, cashierRequestId, installmentPeriod, verificationMethod, version, couponIds, inUrl, reloadRequest, payMethodFilter, str, cvv2, selectedAddons, bizOrderId, mixPaymentRequest, bukaCreditAmount, mixPayMethodRequest);
    }

    private final String encryptCardCredential(String cardExpireMonth, String cardExpireYear, String cardNo, String cvv2, String publicKey, boolean encryptCardEnabled) {
        Pair[] pairArr = new Pair[4];
        if (cardExpireMonth == null) {
            cardExpireMonth = "";
        }
        pairArr[0] = new Pair(CardCredInfo.CARD_EXPIRE_MONTH, cardExpireMonth);
        if (cardExpireYear == null) {
            cardExpireYear = "";
        }
        pairArr[1] = new Pair(CardCredInfo.CARD_EXPIRE_YEAR, cardExpireYear);
        if (cardNo == null) {
            cardNo = "";
        }
        pairArr[2] = new Pair(CardCredInfo.CARD_NO, cardNo);
        if (cvv2 == null) {
            cvv2 = "";
        }
        pairArr[3] = new Pair("cvv2", cvv2);
        return EncryptCardNumber.BuiltInFictitiousFunctionClassFactory(MapsKt.mapOf(pairArr), publicKey, encryptCardEnabled);
    }
}
