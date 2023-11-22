package id.dana.sendmoney.namecheck;

import id.dana.base.AbstractContract;
import id.dana.domain.featureconfig.model.ExpiryTimeConfig;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.domain.user.UserInfoResponse;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.PayMethodModel;
import id.dana.sendmoney.model.ConfirmationModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.VoucherModel;
import id.dana.sendmoney.model.WithdrawOTCModel;
import java.util.List;

/* loaded from: classes5.dex */
public interface SendMoneySummaryContract {

    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(boolean z);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(RecipientModel recipientModel, CurrencyAmountModel currencyAmountModel, PayMethodModel payMethodModel, String str, VoucherModel voucherModel);

        void MyBillsEntityDataFactory(String str);

        void PlaceComponentResult();

        void PlaceComponentResult(CurrencyAmountModel currencyAmountModel, PayMethodModel payMethodModel);

        void getAuthRequestContext();

        void getAuthRequestContext(RecipientModel recipientModel, CurrencyAmountModel currencyAmountModel, PayMethodModel payMethodModel, String str, VoucherModel voucherModel);

        void getAuthRequestContext(RecipientModel recipientModel, CurrencyAmountModel currencyAmountModel, PayMethodModel payMethodModel, String str, VoucherModel voucherModel, WithdrawOTCModel withdrawOTCModel);

        void getAuthRequestContext(RecipientModel recipientModel, CurrencyAmountModel currencyAmountModel, PayMethodModel payMethodModel, String str, String str2, String str3, VoucherModel voucherModel);

        void lookAheadTest();
    }

    /* loaded from: classes5.dex */
    public interface View extends AbstractContract.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(String str);

        void BuiltInFictitiousFunctionClassFactory(List<ExpiryTimeConfig> list);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(ConfirmationModel confirmationModel);

        void MyBillsEntityDataFactory(UserInfoResponse userInfoResponse);

        void MyBillsEntityDataFactory(String str);

        void MyBillsEntityDataFactory(String str, String str2, String str3, Throwable th);

        void PlaceComponentResult(String str);

        void getAuthRequestContext(SmartFrictionConfig smartFrictionConfig);

        void getAuthRequestContext(String str);

        void getAuthRequestContext(List<String> list);

        void getAuthRequestContext(boolean z);
    }
}
