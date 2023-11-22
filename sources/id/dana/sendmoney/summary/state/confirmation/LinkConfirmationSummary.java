package id.dana.sendmoney.summary.state.confirmation;

import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract;
import id.dana.sendmoney.model.ConfirmToBankParamModel;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.sendmoney.summary.state.model.SummaryConfirmationModel;
import id.dana.sendmoney.summary.state.model.UnitSymbolModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\b"}, d2 = {"Lid/dana/sendmoney/summary/state/confirmation/LinkConfirmationSummary;", "Lid/dana/sendmoney/summary/state/confirmation/ConfirmationSummary;", "Lid/dana/sendmoney/summary/state/model/SummaryConfirmationModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/sendmoney/summary/state/model/SummaryConfirmationModel;)V", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationBankContract$Presenter;", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationBankContract$Presenter;", "PlaceComponentResult", "<init>", "(Lid/dana/sendmoney/confirmation/SendMoneyConfirmationBankContract$Presenter;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LinkConfirmationSummary implements ConfirmationSummary {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SendMoneyConfirmationBankContract.Presenter PlaceComponentResult;

    @Inject
    public LinkConfirmationSummary(SendMoneyConfirmationBankContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.PlaceComponentResult = presenter;
    }

    @Override // id.dana.sendmoney.summary.state.confirmation.ConfirmationSummary
    public final void getAuthRequestContext(SummaryConfirmationModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ConfirmToBankParamModel.Builder builder = new ConfirmToBankParamModel.Builder();
        builder.BuiltInFictitiousFunctionClassFactory = p0.MyBillsEntityDataFactory;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = p0.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8();
        builder.moveToNextValue = p0.BuiltInFictitiousFunctionClassFactory.readMicros();
        builder.scheduleImpl = p0.KClassImpl$Data$declaredNonStaticMembers$2;
        builder.lookAheadTest = p0.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3();
        UnitSymbolModel unitSymbolModel = p0.getAuthRequestContext;
        if (unitSymbolModel != null) {
            if (StringsKt.equals(unitSymbolModel.PlaceComponentResult, unitSymbolModel.MyBillsEntityDataFactory, true) || StringsKt.equals(unitSymbolModel.BuiltInFictitiousFunctionClassFactory, unitSymbolModel.MyBillsEntityDataFactory, true)) {
                r3 = SummaryActivity.HOURS;
            } else if (StringsKt.equals(unitSymbolModel.KClassImpl$Data$declaredNonStaticMembers$2, unitSymbolModel.MyBillsEntityDataFactory, true) || StringsKt.equals(unitSymbolModel.getAuthRequestContext, unitSymbolModel.MyBillsEntityDataFactory, true)) {
                r3 = SummaryActivity.DAYS;
            } else {
                Character orNull = StringsKt.getOrNull(unitSymbolModel.MyBillsEntityDataFactory, 0);
                r3 = orNull != null ? orNull.toString() : null;
                if (r3 == null) {
                    r3 = "";
                }
            }
        }
        builder.getAuthRequestContext = r3;
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = p0.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        builder.PlaceComponentResult = p0.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0();
        builder.DatabaseTableConfigUtil = p0.BuiltInFictitiousFunctionClassFactory.E();
        builder.initRecordTimeStamp = p0.BuiltInFictitiousFunctionClassFactory.getOnBoardingScenario();
        ConfirmToBankParamModel MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        this.PlaceComponentResult.getAuthRequestContext(MyBillsEntityDataFactory, p0.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda6(), p0.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult());
        this.PlaceComponentResult.getAuthRequestContext("LINK");
    }
}
