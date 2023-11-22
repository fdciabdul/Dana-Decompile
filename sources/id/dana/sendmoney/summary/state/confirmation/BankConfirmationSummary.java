package id.dana.sendmoney.summary.state.confirmation;

import id.dana.domain.sendmoney.model.TransferParticipant;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract;
import id.dana.sendmoney.model.ConfirmToBankParamModel;
import id.dana.sendmoney.model.ConfirmationModel;
import id.dana.sendmoney.model.RecentBankModel;
import id.dana.sendmoney.summary.state.model.SummaryConfirmationModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/sendmoney/summary/state/confirmation/BankConfirmationSummary;", "Lid/dana/sendmoney/summary/state/confirmation/ConfirmationSummary;", "Lid/dana/sendmoney/summary/state/model/SummaryConfirmationModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/sendmoney/summary/state/model/SummaryConfirmationModel;)V", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationBankContract$Presenter;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationBankContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lid/dana/sendmoney/confirmation/SendMoneyConfirmationBankContract$Presenter;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BankConfirmationSummary implements ConfirmationSummary {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SendMoneyConfirmationBankContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public BankConfirmationSummary(SendMoneyConfirmationBankContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = presenter;
    }

    @Override // id.dana.sendmoney.summary.state.confirmation.ConfirmationSummary
    public final void getAuthRequestContext(SummaryConfirmationModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ConfirmationModel confirmationModel = p0.BuiltInFictitiousFunctionClassFactory;
        ConfirmToBankParamModel.Builder builder = new ConfirmToBankParamModel.Builder();
        builder.BuiltInFictitiousFunctionClassFactory = confirmationModel.getErrorConfigVersion().toString();
        builder.MyBillsEntityDataFactory = confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda1();
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda8();
        builder.moveToNextValue = confirmationModel.readMicros();
        builder.scheduleImpl = confirmationModel.DatabaseTableConfigUtil();
        builder.lookAheadTest = confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda3();
        builder.getAuthRequestContext = confirmationModel.MyBillsEntityDataFactory();
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = confirmationModel.getAuthRequestContext();
        builder.PlaceComponentResult = confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda0();
        builder.DatabaseTableConfigUtil = confirmationModel.E();
        TransferParticipant transferParticipant = new TransferParticipant();
        transferParticipant.setBankAccountIndexNo(confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda1());
        transferParticipant.setUserId(confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda7());
        builder.getErrorConfigVersion = transferParticipant;
        builder.initRecordTimeStamp = confirmationModel.getOnBoardingScenario();
        ConfirmToBankParamModel MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(MyBillsEntityDataFactory, confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda6(), confirmationModel.PlaceComponentResult());
        ConfirmationModel confirmationModel2 = p0.BuiltInFictitiousFunctionClassFactory;
        SendMoneyConfirmationBankContract.Presenter presenter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        RecentBankModel recentBankModel = new RecentBankModel(0, null, null, null, 15, null);
        recentBankModel.BuiltInFictitiousFunctionClassFactory = confirmationModel2.scheduleImpl();
        String KClassImpl$Data$declaredNonStaticMembers$2 = confirmationModel2.KClassImpl$Data$declaredNonStaticMembers$2();
        recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = KClassImpl$Data$declaredNonStaticMembers$2 != null ? KClassImpl$Data$declaredNonStaticMembers$2 : "";
        recentBankModel.BuiltInFictitiousFunctionClassFactory = confirmationModel2.KClassImpl$Data$declaredNonStaticMembers$2();
        recentBankModel.getAuthRequestContext = confirmationModel2.BuiltInFictitiousFunctionClassFactory();
        recentBankModel.KClassImpl$Data$declaredNonStaticMembers$2 = confirmationModel2.lookAheadTest();
        recentBankModel.lookAheadTest = confirmationModel2.NetworkUserEntityData$$ExternalSyntheticLambda5();
        recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = confirmationModel2.NetworkUserEntityData$$ExternalSyntheticLambda4();
        recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = confirmationModel2.GetContactSyncConfig();
        recentBankModel.initRecordTimeStamp = confirmationModel2.whenAvailable();
        recentBankModel.newProxyInstance = confirmationModel2.VerifyPinStateManager$executeRiskChallenge$2$1();
        recentBankModel.KClassImpl$Data$declaredNonStaticMembers$2 = confirmationModel2.NetworkUserEntityData$$ExternalSyntheticLambda1();
        recentBankModel.PlaceComponentResult = confirmationModel2.isLayoutRequested();
        recentBankModel.PrepareContext = confirmationModel2.VerifyPinStateManager$executeRiskChallenge$2$2();
        recentBankModel.getErrorConfigVersion = confirmationModel2.I();
        presenter.BuiltInFictitiousFunctionClassFactory(recentBankModel);
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext("BANK_TRANSFER");
    }
}
