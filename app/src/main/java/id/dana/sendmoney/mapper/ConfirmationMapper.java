package id.dana.sendmoney.mapper;

import android.content.Context;
import android.text.TextUtils;
import id.dana.domain.sendmoney.model.OTCTransferInit;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.PayMethodModel;
import id.dana.sendmoney.confirmation.ConfirmationType;
import id.dana.sendmoney.model.ConfirmationModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.VoucherModel;
import id.dana.sendmoney.model.WithdrawOTCModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ConfirmationMapper {
    public final Context KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public ConfirmationMapper(Context context) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    public final ConfirmationModel KClassImpl$Data$declaredNonStaticMembers$2(RecipientModel recipientModel, String str, CurrencyAmountModel currencyAmountModel, PayMethodModel payMethodModel, String str2, String str3) {
        ConfirmationModel authRequestContext = getAuthRequestContext(recipientModel, payMethodModel);
        authRequestContext.newProxyInstance(str3);
        authRequestContext.I(str);
        authRequestContext.getValueOfTouchPositionAbsolute(recipientModel.B);
        authRequestContext.GetContactSyncConfig(str2);
        authRequestContext.getErrorConfigVersion(currencyAmountModel.MyBillsEntityDataFactory);
        authRequestContext.SubSequence(payMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda1);
        authRequestContext.C(payMethodModel.scheduleImpl() ? ConfirmationType.Origin.DANA : ConfirmationType.Origin.BANK);
        authRequestContext.VerifyPinStateManager$executeRiskChallenge$2$1(payMethodModel.PlaceComponentResult());
        authRequestContext.readMicros(payMethodModel.getAuthRequestContext);
        authRequestContext.getCallingPid(payMethodModel.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
        authRequestContext.MyBillsEntityDataFactory(payMethodModel.BuiltInFictitiousFunctionClassFactory());
        authRequestContext.getSupportButtonTintMode(payMethodModel.lookAheadTest);
        authRequestContext.whenAvailable(payMethodModel.newProxyInstance);
        authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda7(payMethodModel.moveToNextValue);
        if (payMethodModel.scheduleImpl()) {
            CurrencyAmountModel currencyAmountModel2 = payMethodModel.PlaceComponentResult;
            authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda6(currencyAmountModel2 == null ? "" : currencyAmountModel2.MyBillsEntityDataFactory);
        }
        return authRequestContext;
    }

    public static ConfirmationModel getAuthRequestContext(RecipientModel recipientModel, PayMethodModel payMethodModel) {
        ConfirmationModel confirmationModel = new ConfirmationModel();
        confirmationModel.E(recipientModel.whenAvailable);
        confirmationModel.A(recipientModel.SubSequence);
        confirmationModel.KClassImpl$Data$declaredNonStaticMembers$2(recipientModel.getCallingPid);
        confirmationModel.BuiltInFictitiousFunctionClassFactory(recipientModel.A);
        String str = recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (TextUtils.isEmpty(str)) {
            str = TextUtils.isEmpty(payMethodModel.initRecordTimeStamp) ? "" : payMethodModel.initRecordTimeStamp;
        }
        confirmationModel.FragmentBottomSheetPaymentSettingBinding(str);
        return confirmationModel;
    }

    public static String MyBillsEntityDataFactory(PayMethodModel payMethodModel) {
        return payMethodModel.scheduleImpl() ? ConfirmationType.Origin.DANA : ConfirmationType.Origin.BANK;
    }

    public static boolean MyBillsEntityDataFactory(OTCConfirmationModelData oTCConfirmationModelData) {
        return (oTCConfirmationModelData.PlaceComponentResult == null || oTCConfirmationModelData.PlaceComponentResult.getTransferMethod() == null || oTCConfirmationModelData.PlaceComponentResult.getTransferMethod().get(0).getChargeAmount() == null) ? false : true;
    }

    /* loaded from: classes5.dex */
    public static class OTCConfirmationModelData {
        public String BuiltInFictitiousFunctionClassFactory;
        public String MyBillsEntityDataFactory;
        public OTCTransferInit PlaceComponentResult;
        public WithdrawOTCModel getAuthRequestContext;
    }

    public static void BuiltInFictitiousFunctionClassFactory(RecipientModel recipientModel, PayMethodModel payMethodModel, ConfirmationModel confirmationModel) {
        confirmationModel.getValueOfTouchPositionAbsolute(recipientModel.B);
        if (payMethodModel.scheduleImpl()) {
            CurrencyAmountModel currencyAmountModel = payMethodModel.PlaceComponentResult;
            confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda6(currencyAmountModel == null ? "" : currencyAmountModel.MyBillsEntityDataFactory);
        }
        if (payMethodModel.BuiltInFictitiousFunctionClassFactory != null) {
            confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda0(payMethodModel.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
        }
        confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda5(recipientModel.KClassImpl$Data$declaredNonStaticMembers$2());
        confirmationModel.VerifyPinStateManager$executeRiskChallenge$2$2(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda6);
        confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda4(recipientModel.BuiltInFictitiousFunctionClassFactory);
        confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda3(recipientModel.BuiltInFictitiousFunctionClassFactory);
        confirmationModel.lookAheadTest(recipientModel.getErrorConfigVersion);
        confirmationModel.whenAvailable(payMethodModel.newProxyInstance);
        confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda8(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda2);
    }

    public static void BuiltInFictitiousFunctionClassFactory(VoucherModel voucherModel, ConfirmationModel confirmationModel) {
        if (voucherModel == null || voucherModel.DatabaseTableConfigUtil == null) {
            return;
        }
        confirmationModel.F(voucherModel.DatabaseTableConfigUtil.MyBillsEntityDataFactory);
        confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda1(voucherModel.MyBillsEntityDataFactory);
    }
}
