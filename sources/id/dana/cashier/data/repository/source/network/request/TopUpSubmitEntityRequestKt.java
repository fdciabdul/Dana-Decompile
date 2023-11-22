package id.dana.cashier.data.repository.source.network.request;

import id.dana.cashier.domain.model.TopUpSubmitRequest;
import id.dana.data.encryptcardno.CardCredInfo;
import id.dana.data.encryptcardno.EncryptCardNumber;
import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aA\u0010\u0006\u001a\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\n\u001a\u00020\t*\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", CardCredInfo.CARD_EXPIRE_MONTH, CardCredInfo.CARD_EXPIRE_YEAR, CardCredInfo.CARD_NO, "cvv2", "publicKey", "cardCredential", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/cashier/domain/model/TopUpSubmitRequest;", "Lid/dana/cashier/data/repository/source/network/request/TopUpSubmitEntityRequest;", "toTopUpSubmitEntityRequest", "(Lid/dana/cashier/domain/model/TopUpSubmitRequest;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/request/TopUpSubmitEntityRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TopUpSubmitEntityRequestKt {
    public static final TopUpSubmitEntityRequest toTopUpSubmitEntityRequest(TopUpSubmitRequest topUpSubmitRequest, String str) {
        Intrinsics.checkNotNullParameter(topUpSubmitRequest, "");
        Intrinsics.checkNotNullParameter(str, "");
        String method = topUpSubmitRequest.getMethod();
        String payMethod = topUpSubmitRequest.getPayMethod();
        Boolean saveCard = topUpSubmitRequest.getSaveCard();
        String payOption = topUpSubmitRequest.getPayOption();
        MoneyView topUpAmount = topUpSubmitRequest.getTopUpAmount();
        return new TopUpSubmitEntityRequest(method, payMethod, saveCard, payOption, topUpAmount != null ? AmountRequestKt.toAmountRequest(topUpAmount) : null, topUpSubmitRequest.getRequestId(), topUpSubmitRequest.getExpressPayAgreementToken(), topUpSubmitRequest.getCardIndexNo(), topUpSubmitRequest.getBindingId(), cardCredential$default(topUpSubmitRequest.getCardExpireMonth(), topUpSubmitRequest.getCardExpireYear(), null, topUpSubmitRequest.getCvv2(), str, 4, null), topUpSubmitRequest.getBankPhoneNo(), topUpSubmitRequest.getDeviceId(), topUpSubmitRequest.getXcoId(), topUpSubmitRequest.getTopupPayOrderInfo());
    }

    static /* synthetic */ String cardCredential$default(String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        return cardCredential(str, str2, str3, str4, str5);
    }

    private static final String cardCredential(String str, String str2, String str3, String str4, String str5) {
        Pair[] pairArr = new Pair[4];
        if (str == null) {
            str = "";
        }
        pairArr[0] = new Pair(CardCredInfo.CARD_EXPIRE_MONTH, str);
        if (str2 == null) {
            str2 = "";
        }
        pairArr[1] = new Pair(CardCredInfo.CARD_EXPIRE_YEAR, str2);
        if (str3 == null) {
            str3 = "";
        }
        pairArr[2] = new Pair(CardCredInfo.CARD_NO, str3);
        if (str4 == null) {
            str4 = "";
        }
        pairArr[3] = new Pair("cvv2", str4);
        return EncryptCardNumber.BuiltInFictitiousFunctionClassFactory(MapsKt.mapOf(pairArr), str5, true);
    }
}
