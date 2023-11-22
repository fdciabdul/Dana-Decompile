package id.dana.cardbinding.model;

import id.dana.cardbinding.domain.model.BankCardInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/domain/model/BankCardInfo;", "Lid/dana/cardbinding/model/BankCardInfoModel;", "MyBillsEntityDataFactory", "(Lid/dana/cardbinding/domain/model/BankCardInfo;)Lid/dana/cardbinding/model/BankCardInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class BankCardInfoModelKt {
    public static final BankCardInfoModel MyBillsEntityDataFactory(BankCardInfo bankCardInfo) {
        Intrinsics.checkNotNullParameter(bankCardInfo, "");
        return new BankCardInfoModel(bankCardInfo.PlaceComponentResult, bankCardInfo.getAuthRequestContext, bankCardInfo.getBuiltInFictitiousFunctionClassFactory(), bankCardInfo.getMyBillsEntityDataFactory());
    }
}
