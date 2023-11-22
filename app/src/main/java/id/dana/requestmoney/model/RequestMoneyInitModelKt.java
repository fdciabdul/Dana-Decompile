package id.dana.requestmoney.model;

import id.dana.domain.bank.model.RequestMoneyInit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/bank/model/RequestMoneyInit;", "Lid/dana/requestmoney/model/RequestMoneyInitModel;", "MyBillsEntityDataFactory", "(Lid/dana/domain/bank/model/RequestMoneyInit;)Lid/dana/requestmoney/model/RequestMoneyInitModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RequestMoneyInitModelKt {
    public static final RequestMoneyInitModel MyBillsEntityDataFactory(RequestMoneyInit requestMoneyInit) {
        Intrinsics.checkNotNullParameter(requestMoneyInit, "");
        return new RequestMoneyInitModel(requestMoneyInit.getMaxBankAccount(), UserBankModelKt.PlaceComponentResult(requestMoneyInit.getUserBanks()));
    }
}
