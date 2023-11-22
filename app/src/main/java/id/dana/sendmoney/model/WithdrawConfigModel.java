package id.dana.sendmoney.model;

import id.dana.model.CurrencyAmountModel;
import java.util.List;

/* loaded from: classes9.dex */
public class WithdrawConfigModel {
    private List<Config> KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    private int getAuthRequestContext;

    public WithdrawConfigModel(List<Config> list, boolean z, int i, int i2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.PlaceComponentResult = z;
        this.getAuthRequestContext = i;
        this.MyBillsEntityDataFactory = i2;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult;
    }

    /* loaded from: classes9.dex */
    public static class Config {
        private CurrencyAmountModel KClassImpl$Data$declaredNonStaticMembers$2;
        private String MyBillsEntityDataFactory;
        private List<PayOptionDTO> PlaceComponentResult;

        public Config(CurrencyAmountModel currencyAmountModel, String str, List<PayOptionDTO> list) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = currencyAmountModel;
            this.MyBillsEntityDataFactory = str;
            this.PlaceComponentResult = list;
        }
    }
}
