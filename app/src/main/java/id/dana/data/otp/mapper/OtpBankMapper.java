package id.dana.data.otp.mapper;

import id.dana.data.encryptcardno.CardCredInfo;
import id.dana.data.encryptcardno.EncryptCardNumber;
import id.dana.data.otp.repository.source.network.request.SendBankOtpEntityRequest;
import id.dana.domain.otp.model.SendBankOtpRequest;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/otp/mapper/OtpBankMapper;", "", "Lid/dana/domain/otp/model/SendBankOtpRequest;", "request", "", "publicKey", "Lid/dana/data/otp/repository/source/network/request/SendBankOtpEntityRequest;", "transform", "(Lid/dana/domain/otp/model/SendBankOtpRequest;Ljava/lang/String;)Lid/dana/data/otp/repository/source/network/request/SendBankOtpEntityRequest;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OtpBankMapper {
    @Inject
    public OtpBankMapper() {
    }

    public final SendBankOtpEntityRequest transform(SendBankOtpRequest request, String publicKey) {
        Intrinsics.checkNotNullParameter(request, "");
        return new SendBankOtpEntityRequest(request.getCardIndexNo(), request.getCashierOrderId(), request.getBindingId(), EncryptCardNumber.BuiltInFictitiousFunctionClassFactory(MapsKt.mapOf(new Pair(CardCredInfo.CARD_EXPIRE_MONTH, request.getCardExpireMonth()), new Pair(CardCredInfo.CARD_EXPIRE_YEAR, request.getCardExpireYear())), publicKey != null ? publicKey : "", true), request.getBankPhoneNo(), request.getEktp(), request.getCardNo(), request.getCardType(), request.getInstId(), null, null, request.getLimitAmountDaily(), request.getMsisdn(), request.getDeviceId(), request.getAccountNo(), 1536, null);
    }
}
