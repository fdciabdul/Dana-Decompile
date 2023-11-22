package id.dana.familyaccount.contract;

import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.familyaccount.interactor.ApproveSendMoneyFamilyAccount;
import id.dana.domain.familyaccount.interactor.GetOrganizerSummary;
import id.dana.domain.familyaccount.interactor.RejectSendMoneyFamilyAccount;
import id.dana.domain.familyaccount.model.ApproveSendMoneyRequest;
import id.dana.domain.familyaccount.model.ApproveSendMoneyResult;
import id.dana.domain.familyaccount.model.OrganizerSummaryRequest;
import id.dana.domain.familyaccount.model.RejectSendMoneyRequest;
import id.dana.domain.familyaccount.model.SummaryResult;
import id.dana.domain.featureconfig.interactor.CheckCashierFeature;
import id.dana.domain.sendmoney.interactor.GetBankFreeTransferCheck;
import id.dana.familyaccount.constants.StatusInformationType;
import id.dana.familyaccount.contract.OrganizerSummaryContract;
import id.dana.familyaccount.mapper.OrganizerSummaryResultMapperKt;
import id.dana.familyaccount.model.SummaryModel;
import id.dana.familyaccount.util.FamilyAccountErrorHelper;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0001(B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u001d\u0012\u0006\u0010!\u001a\u00020\u0014\u0012\u0006\u0010\"\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u0016\u0012\u0006\u0010$\u001a\u00020\u001b\u0012\u0006\u0010%\u001a\u00020\u0011¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0005\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0015R\u0014\u0010\f\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0019\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/familyaccount/contract/OrganizerSummaryPresenter;", "Lid/dana/familyaccount/contract/OrganizerSummaryContract$Presenter;", "Lid/dana/domain/familyaccount/model/ApproveSendMoneyRequest;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/familyaccount/model/ApproveSendMoneyRequest;)V", "getAuthRequestContext", "()V", "Lid/dana/familyaccount/model/SummaryModel;", "(Lid/dana/familyaccount/model/SummaryModel;)V", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "onDestroy", "Lid/dana/domain/familyaccount/model/RejectSendMoneyRequest;", "(Lid/dana/domain/familyaccount/model/RejectSendMoneyRequest;)V", "Lid/dana/domain/familyaccount/interactor/ApproveSendMoneyFamilyAccount;", "Lid/dana/domain/familyaccount/interactor/ApproveSendMoneyFamilyAccount;", "PlaceComponentResult", "Lid/dana/domain/featureconfig/interactor/CheckCashierFeature;", "Lid/dana/domain/featureconfig/interactor/CheckCashierFeature;", "Lid/dana/domain/sendmoney/interactor/GetBankFreeTransferCheck;", "Lid/dana/domain/sendmoney/interactor/GetBankFreeTransferCheck;", "Lid/dana/domain/familyaccount/interactor/GetOrganizerSummary;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/familyaccount/interactor/GetOrganizerSummary;", "Lid/dana/domain/familyaccount/interactor/RejectSendMoneyFamilyAccount;", "Lid/dana/domain/familyaccount/interactor/RejectSendMoneyFamilyAccount;", "Lid/dana/familyaccount/contract/OrganizerSummaryContract$View;", "lookAheadTest", "Lid/dana/familyaccount/contract/OrganizerSummaryContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/familyaccount/contract/OrganizerSummaryContract$View;Lid/dana/domain/featureconfig/interactor/CheckCashierFeature;Lid/dana/domain/familyaccount/interactor/GetOrganizerSummary;Lid/dana/domain/sendmoney/interactor/GetBankFreeTransferCheck;Lid/dana/domain/familyaccount/interactor/RejectSendMoneyFamilyAccount;Lid/dana/domain/familyaccount/interactor/ApproveSendMoneyFamilyAccount;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OrganizerSummaryPresenter implements OrganizerSummaryContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final RejectSendMoneyFamilyAccount KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetOrganizerSummary getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final CheckCashierFeature BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetBankFreeTransferCheck MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ApproveSendMoneyFamilyAccount PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final OrganizerSummaryContract.View NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public OrganizerSummaryPresenter(OrganizerSummaryContract.View view, CheckCashierFeature checkCashierFeature, GetOrganizerSummary getOrganizerSummary, GetBankFreeTransferCheck getBankFreeTransferCheck, RejectSendMoneyFamilyAccount rejectSendMoneyFamilyAccount, ApproveSendMoneyFamilyAccount approveSendMoneyFamilyAccount) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(checkCashierFeature, "");
        Intrinsics.checkNotNullParameter(getOrganizerSummary, "");
        Intrinsics.checkNotNullParameter(getBankFreeTransferCheck, "");
        Intrinsics.checkNotNullParameter(rejectSendMoneyFamilyAccount, "");
        Intrinsics.checkNotNullParameter(approveSendMoneyFamilyAccount, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
        this.BuiltInFictitiousFunctionClassFactory = checkCashierFeature;
        this.getAuthRequestContext = getOrganizerSummary;
        this.MyBillsEntityDataFactory = getBankFreeTransferCheck;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = rejectSendMoneyFamilyAccount;
        this.PlaceComponentResult = approveSendMoneyFamilyAccount;
    }

    @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.Presenter
    public final void getAuthRequestContext(final SummaryModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2();
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<Integer>() { // from class: id.dana.familyaccount.contract.OrganizerSummaryPresenter$getBankFreeTransfer$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                OrganizerSummaryContract.View view;
                OrganizerSummaryContract.View view2;
                int intValue = ((Number) obj).intValue();
                view = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.PlaceComponentResult();
                view2 = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view2.MyBillsEntityDataFactory(p0, intValue);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                OrganizerSummaryContract.View view;
                OrganizerSummaryContract.View view2;
                Intrinsics.checkNotNullParameter(p02, "");
                view = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.PlaceComponentResult();
                view2 = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                FamilyAccountErrorHelper familyAccountErrorHelper = FamilyAccountErrorHelper.INSTANCE;
                view2.PlaceComponentResult(FamilyAccountErrorHelper.MyBillsEntityDataFactory(p02));
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FAMILY_ACCOUNT, p02.toString());
            }
        });
    }

    @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.Presenter
    public final void getAuthRequestContext() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2();
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.familyaccount.contract.OrganizerSummaryPresenter$checkCashierFeature$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                OrganizerSummaryContract.View view;
                view = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.PlaceComponentResult(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.OrganizerSummaryPresenter$checkCashierFeature$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                OrganizerSummaryContract.View view;
                OrganizerSummaryContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.PlaceComponentResult();
                view2 = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view2.PlaceComponentResult(StatusInformationType.GENERAL_STATUS_ERROR);
            }
        });
    }

    @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.Presenter
    public final void MyBillsEntityDataFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2();
        this.getAuthRequestContext.execute(new OrganizerSummaryRequest(p0), new Function1<SummaryResult, Unit>() { // from class: id.dana.familyaccount.contract.OrganizerSummaryPresenter$getOrganizerSummary$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SummaryResult summaryResult) {
                invoke2(summaryResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SummaryResult summaryResult) {
                Intrinsics.checkNotNullParameter(summaryResult, "");
                OrganizerSummaryPresenter.PlaceComponentResult(OrganizerSummaryPresenter.this, summaryResult, p0);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.OrganizerSummaryPresenter$getOrganizerSummary$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                OrganizerSummaryContract.View view;
                OrganizerSummaryContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.PlaceComponentResult();
                view2 = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                FamilyAccountErrorHelper familyAccountErrorHelper = FamilyAccountErrorHelper.INSTANCE;
                view2.PlaceComponentResult(FamilyAccountErrorHelper.MyBillsEntityDataFactory(th));
            }
        });
    }

    @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(RejectSendMoneyRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(p0, new Function1<String, Unit>() { // from class: id.dana.familyaccount.contract.OrganizerSummaryPresenter$rejectSendMoney$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                OrganizerSummaryContract.View view;
                OrganizerSummaryContract.View view2;
                Intrinsics.checkNotNullParameter(str, "");
                view = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.dismissProgress();
                view2 = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view2.BuiltInFictitiousFunctionClassFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.OrganizerSummaryPresenter$rejectSendMoney$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                OrganizerSummaryContract.View view;
                OrganizerSummaryContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.dismissProgress();
                view2 = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view2.BuiltInFictitiousFunctionClassFactory(String.valueOf(th.getMessage()));
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.FAMILY_REJECT_SEND_MONEY, th.toString());
            }
        });
    }

    @Override // id.dana.familyaccount.contract.OrganizerSummaryContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(ApproveSendMoneyRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.showProgress();
        this.PlaceComponentResult.execute(p0, new Function1<ApproveSendMoneyResult, Unit>() { // from class: id.dana.familyaccount.contract.OrganizerSummaryPresenter$approveSendMoney$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ApproveSendMoneyResult approveSendMoneyResult) {
                invoke2(approveSendMoneyResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ApproveSendMoneyResult approveSendMoneyResult) {
                OrganizerSummaryContract.View view;
                OrganizerSummaryContract.View view2;
                Intrinsics.checkNotNullParameter(approveSendMoneyResult, "");
                view = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.dismissProgress();
                view2 = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view2.PlaceComponentResult(approveSendMoneyResult);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.OrganizerSummaryPresenter$approveSendMoney$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                OrganizerSummaryContract.View view;
                OrganizerSummaryContract.View view2;
                OrganizerSummaryContract.View view3;
                OrganizerSummaryContract.View view4;
                Intrinsics.checkNotNullParameter(th, "");
                view = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.dismissProgress();
                FamilyAccountErrorHelper familyAccountErrorHelper = FamilyAccountErrorHelper.INSTANCE;
                if (Intrinsics.areEqual(FamilyAccountErrorHelper.MyBillsEntityDataFactory(th), "ACCOUNT_FREEZE")) {
                    view4 = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    FamilyAccountErrorHelper familyAccountErrorHelper2 = FamilyAccountErrorHelper.INSTANCE;
                    view4.PlaceComponentResult(FamilyAccountErrorHelper.MyBillsEntityDataFactory(th));
                } else {
                    FamilyAccountErrorHelper familyAccountErrorHelper3 = FamilyAccountErrorHelper.INSTANCE;
                    if (Intrinsics.areEqual(FamilyAccountErrorHelper.MyBillsEntityDataFactory(th), StatusInformationType.MEMBER_USER_FREEZE)) {
                        view3 = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        FamilyAccountErrorHelper familyAccountErrorHelper4 = FamilyAccountErrorHelper.INSTANCE;
                        view3.MyBillsEntityDataFactory(FamilyAccountErrorHelper.MyBillsEntityDataFactory(th));
                    } else {
                        view2 = OrganizerSummaryPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        view2.KClassImpl$Data$declaredNonStaticMembers$2(String.valueOf(th.getMessage()));
                    }
                }
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.FAMILY_APPROVE_SEND_MONEY, th.toString());
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.getAuthRequestContext.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.PlaceComponentResult.dispose();
    }

    public static final /* synthetic */ void PlaceComponentResult(OrganizerSummaryPresenter organizerSummaryPresenter, SummaryResult summaryResult, String str) {
        if (Intrinsics.areEqual(summaryResult.getStatus(), "INIT")) {
            organizerSummaryPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult();
            organizerSummaryPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(OrganizerSummaryResultMapperKt.BuiltInFictitiousFunctionClassFactory(summaryResult));
            return;
        }
        organizerSummaryPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(str);
    }
}
