package id.dana.cashier.addCard.model;

import id.dana.cashier.model.DailyLimitAmountConfModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cashier/addCard/model/DailyLimitCardVerifyElementModel;", "Lid/dana/cashier/addCard/model/QueryCardVerifyElementModel;", "Lid/dana/cashier/model/DailyLimitAmountConfModel;", "MyBillsEntityDataFactory", "Lid/dana/cashier/model/DailyLimitAmountConfModel;", "p0", "<init>", "(Lid/dana/cashier/model/DailyLimitAmountConfModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DailyLimitCardVerifyElementModel extends QueryCardVerifyElementModel {
    public DailyLimitAmountConfModel MyBillsEntityDataFactory;

    public DailyLimitCardVerifyElementModel(DailyLimitAmountConfModel dailyLimitAmountConfModel) {
        super(3, null, null, 6, null);
        this.MyBillsEntityDataFactory = dailyLimitAmountConfModel;
    }
}
