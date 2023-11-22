package id.dana.data.recentrecipient.mapper;

import id.dana.data.encryptcardno.EncryptCardNumber;
import id.dana.data.recentrecipient.model.BankCardConversionRequest;
import id.dana.data.recentrecipient.model.BankCardConversionResult;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0006\u0010\r"}, d2 = {"Lid/dana/data/recentrecipient/mapper/BankCardConversionMapper;", "", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "recentRecipient", "Lid/dana/data/recentrecipient/model/BankCardConversionResult;", "result", "transform", "(Lid/dana/domain/recentrecipient/model/RecentRecipient;Lid/dana/data/recentrecipient/model/BankCardConversionResult;)Lid/dana/domain/recentrecipient/model/RecentRecipient;", "", "publicKey", "", "encryptCardEnabled", "Lid/dana/data/recentrecipient/model/BankCardConversionRequest;", "(Lid/dana/domain/recentrecipient/model/RecentRecipient;Ljava/lang/String;Z)Lid/dana/data/recentrecipient/model/BankCardConversionRequest;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BankCardConversionMapper {
    @Inject
    public BankCardConversionMapper() {
    }

    public final BankCardConversionRequest transform(RecentRecipient recentRecipient, String publicKey, boolean encryptCardEnabled) {
        Intrinsics.checkNotNullParameter(recentRecipient, "");
        Intrinsics.checkNotNullParameter(publicKey, "");
        String number = recentRecipient.getNumber();
        String replace$default = number != null ? StringsKt.replace$default(number, " ", "", false, 4, (Object) null) : null;
        if (replace$default == null) {
            replace$default = "";
        }
        String MyBillsEntityDataFactory = EncryptCardNumber.MyBillsEntityDataFactory(replace$default, publicKey, encryptCardEnabled);
        if (MyBillsEntityDataFactory.length() > 0) {
            String id2 = recentRecipient.getId();
            Intrinsics.checkNotNullExpressionValue(id2, "");
            return new BankCardConversionRequest(MyBillsEntityDataFactory, "", id2);
        }
        String id3 = recentRecipient.getId();
        Intrinsics.checkNotNullExpressionValue(id3, "");
        return new BankCardConversionRequest("", replace$default, id3);
    }

    public final RecentRecipient transform(RecentRecipient recentRecipient, BankCardConversionResult result) {
        Intrinsics.checkNotNullParameter(recentRecipient, "");
        Intrinsics.checkNotNullParameter(result, "");
        recentRecipient.setNumber(result.getFormattedMaskedCardNo());
        recentRecipient.setCardIndexNo(result.getCardIndexNo());
        return recentRecipient;
    }
}
