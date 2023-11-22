package id.dana.familyaccount.contract;

import id.dana.data.content.SpaceCode;
import id.dana.domain.auth.face.result.VerificationMethodInfo;
import id.dana.domain.autoroute.model.SecurityContext;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.familyaccount.interactor.GetQuestionnaireData;
import id.dana.domain.familyaccount.interactor.InviteFamilyAccount;
import id.dana.domain.familyaccount.interactor.RecordAgreementFamilyAccount;
import id.dana.domain.familyaccount.model.InviteMemberResult;
import id.dana.domain.familyaccount.model.QuestionnaireDataConfig;
import id.dana.domain.useragreement.interactor.ConsultAgreement;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import id.dana.familyaccount.contract.FamilyInvitationContract;
import id.dana.familyaccount.model.InviteMemberModel;
import id.dana.familyaccount.model.InviteMemberModelKt;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020 \u0012\u0006\u0010\u0005\u001a\u00020\u001e\u0012\u0006\u0010\u000f\u001a\u00020\u0018\u0012\u0006\u0010\u0010\u001a\u00020\u0015\u0012\u0006\u0010\u0011\u001a\u00020\u001a¢\u0006\u0004\b\"\u0010#J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\tJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\nJG\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000b\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0014\u0010\u000b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0014\u0010\u001b\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010!"}, d2 = {"Lid/dana/familyaccount/contract/FamilyInvitationPresenter;", "Lid/dana/familyaccount/contract/FamilyInvitationContract$Presenter;", "Lid/dana/familyaccount/model/InviteMemberModel;", "p0", "Lid/dana/sendmoney/model/RecipientModel;", "p1", "", "PlaceComponentResult", "(Lid/dana/familyaccount/model/InviteMemberModel;Lid/dana/sendmoney/model/RecipientModel;)V", "(Lid/dana/familyaccount/model/InviteMemberModel;)V", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "onDestroy", "", "", "p2", "p3", "p4", "p5", "p6", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/domain/useragreement/interactor/ConsultAgreement;", "Lid/dana/domain/useragreement/interactor/ConsultAgreement;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/familyaccount/interactor/GetQuestionnaireData;", "Lid/dana/domain/familyaccount/interactor/GetQuestionnaireData;", "Lid/dana/domain/familyaccount/interactor/RecordAgreementFamilyAccount;", "getAuthRequestContext", "Lid/dana/domain/familyaccount/interactor/RecordAgreementFamilyAccount;", "MyBillsEntityDataFactory", "Lid/dana/domain/familyaccount/interactor/InviteFamilyAccount;", "Lid/dana/domain/familyaccount/interactor/InviteFamilyAccount;", "Lid/dana/familyaccount/contract/FamilyInvitationContract$View;", "Lid/dana/familyaccount/contract/FamilyInvitationContract$View;", "<init>", "(Lid/dana/familyaccount/contract/FamilyInvitationContract$View;Lid/dana/domain/familyaccount/interactor/InviteFamilyAccount;Lid/dana/domain/familyaccount/interactor/GetQuestionnaireData;Lid/dana/domain/useragreement/interactor/ConsultAgreement;Lid/dana/domain/familyaccount/interactor/RecordAgreementFamilyAccount;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyInvitationPresenter implements FamilyInvitationContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetQuestionnaireData KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final InviteFamilyAccount PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FamilyInvitationContract.View getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ConsultAgreement BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final RecordAgreementFamilyAccount MyBillsEntityDataFactory;

    @Inject
    public FamilyInvitationPresenter(FamilyInvitationContract.View view, InviteFamilyAccount inviteFamilyAccount, GetQuestionnaireData getQuestionnaireData, ConsultAgreement consultAgreement, RecordAgreementFamilyAccount recordAgreementFamilyAccount) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(inviteFamilyAccount, "");
        Intrinsics.checkNotNullParameter(getQuestionnaireData, "");
        Intrinsics.checkNotNullParameter(consultAgreement, "");
        Intrinsics.checkNotNullParameter(recordAgreementFamilyAccount, "");
        this.getAuthRequestContext = view;
        this.PlaceComponentResult = inviteFamilyAccount;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getQuestionnaireData;
        this.BuiltInFictitiousFunctionClassFactory = consultAgreement;
        this.MyBillsEntityDataFactory = recordAgreementFamilyAccount;
    }

    @Override // id.dana.familyaccount.contract.FamilyInvitationContract.Presenter
    public final void PlaceComponentResult(final InviteMemberModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.execute(InviteFamilyAccount.Params.INSTANCE.create(InviteMemberModelKt.PlaceComponentResult(p0)), new Function1<InviteMemberResult, Unit>() { // from class: id.dana.familyaccount.contract.FamilyInvitationPresenter$doInvite$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(InviteMemberResult inviteMemberResult) {
                invoke2(inviteMemberResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(InviteMemberResult inviteMemberResult) {
                FamilyInvitationContract.View view;
                Intrinsics.checkNotNullParameter(inviteMemberResult, "");
                view = FamilyInvitationPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                FamilyInvitationPresenter.PlaceComponentResult(FamilyInvitationPresenter.this, inviteMemberResult, p0);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyInvitationPresenter$doInvite$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                FamilyInvitationContract.View view;
                FamilyInvitationContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FamilyInvitationPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                view2 = FamilyInvitationPresenter.this.getAuthRequestContext;
                InviteMemberModel inviteMemberModel = p0;
                String message = th.getMessage();
                view2.BuiltInFictitiousFunctionClassFactory(inviteMemberModel, message != null ? message : "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FAMILY_ACCOUNT, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyInvitationContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.getAuthRequestContext.showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function1<QuestionnaireDataConfig, Unit>() { // from class: id.dana.familyaccount.contract.FamilyInvitationPresenter$getQuestionnaireData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QuestionnaireDataConfig questionnaireDataConfig) {
                invoke2(questionnaireDataConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QuestionnaireDataConfig questionnaireDataConfig) {
                FamilyInvitationContract.View view;
                FamilyInvitationContract.View view2;
                Intrinsics.checkNotNullParameter(questionnaireDataConfig, "");
                view = FamilyInvitationPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                view2 = FamilyInvitationPresenter.this.getAuthRequestContext;
                view2.PlaceComponentResult(questionnaireDataConfig);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyInvitationPresenter$getQuestionnaireData$2
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
                FamilyInvitationContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = FamilyInvitationPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FAMILY_ACCOUNT, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyInvitationContract.Presenter
    public final void PlaceComponentResult() {
        this.getAuthRequestContext.PlaceComponentResult();
        this.BuiltInFictitiousFunctionClassFactory.execute(new ConsultAgreement.Params("", CollectionsKt.listOf(SpaceCode.TNC_FAMILY_ACCOUNT_AGREEMENT), "", "", null, false), new Function1<ConsultAgreementResponse, Unit>() { // from class: id.dana.familyaccount.contract.FamilyInvitationPresenter$getAgreement$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ConsultAgreementResponse consultAgreementResponse) {
                invoke2(consultAgreementResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ConsultAgreementResponse consultAgreementResponse) {
                FamilyInvitationContract.View view;
                Intrinsics.checkNotNullParameter(consultAgreementResponse, "");
                view = FamilyInvitationPresenter.this.getAuthRequestContext;
                view.MyBillsEntityDataFactory(consultAgreementResponse);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyInvitationPresenter$getAgreement$2
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
                FamilyInvitationContract.View view;
                FamilyInvitationContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FAMILY_ACCOUNT, th.getMessage(), th);
                view = FamilyInvitationPresenter.this.getAuthRequestContext;
                view.KClassImpl$Data$declaredNonStaticMembers$2();
                view2 = FamilyInvitationPresenter.this.getAuthRequestContext;
                view2.getAuthRequestContext(th);
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyInvitationContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, boolean p1, String p2, String p3, String p4, String p5, String p6) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        Intrinsics.checkNotNullParameter(p5, "");
        Intrinsics.checkNotNullParameter(p6, "");
        this.getAuthRequestContext.showProgress();
        this.MyBillsEntityDataFactory.execute(new RecordAgreementFamilyAccount.Params(p0, p1, "", p2, p3, p4, p5, p5), new Function1<Unit, Unit>() { // from class: id.dana.familyaccount.contract.FamilyInvitationPresenter$recordAgreement$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                FamilyInvitationContract.View view;
                Intrinsics.checkNotNullParameter(unit, "");
                view = FamilyInvitationPresenter.this.getAuthRequestContext;
                view.MyBillsEntityDataFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyInvitationPresenter$recordAgreement$2
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
                FamilyInvitationContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FAMILY_ACCOUNT, th.getMessage(), th);
                view = FamilyInvitationPresenter.this.getAuthRequestContext;
                view.dismissProgress();
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyInvitationContract.Presenter
    public final void PlaceComponentResult(InviteMemberModel p0, final RecipientModel p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getAuthRequestContext.showProgress();
        this.PlaceComponentResult.execute(InviteFamilyAccount.Params.INSTANCE.create(InviteMemberModelKt.PlaceComponentResult(p0)), new Function1<InviteMemberResult, Unit>() { // from class: id.dana.familyaccount.contract.FamilyInvitationPresenter$doConsultCheckStatusMember$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(InviteMemberResult inviteMemberResult) {
                invoke2(inviteMemberResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(InviteMemberResult inviteMemberResult) {
                FamilyInvitationContract.View view;
                FamilyInvitationContract.View view2;
                Intrinsics.checkNotNullParameter(inviteMemberResult, "");
                view = FamilyInvitationPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                view2 = FamilyInvitationPresenter.this.getAuthRequestContext;
                view2.PlaceComponentResult(p1);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyInvitationPresenter$doConsultCheckStatusMember$2
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
                FamilyInvitationContract.View view;
                FamilyInvitationContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FamilyInvitationPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                view2 = FamilyInvitationPresenter.this.getAuthRequestContext;
                String message = th.getMessage();
                view2.getAuthRequestContext(message != null ? message : "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FAMILY_ACCOUNT, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }

    public static final /* synthetic */ void PlaceComponentResult(FamilyInvitationPresenter familyInvitationPresenter, InviteMemberResult inviteMemberResult, InviteMemberModel inviteMemberModel) {
        Iterator<T> it = inviteMemberResult.getVerificationMethodInfoList().iterator();
        while (it.hasNext()) {
            String verificationMethod = ((VerificationMethodInfo) it.next()).getVerificationMethod();
            if (verificationMethod == null) {
                familyInvitationPresenter.getAuthRequestContext.PlaceComponentResult(inviteMemberModel);
            } else if (!Intrinsics.areEqual(verificationMethod, "PASSWORD")) {
                if (Intrinsics.areEqual(verificationMethod, "REJECT")) {
                    familyInvitationPresenter.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(inviteMemberModel, "REJECT");
                }
            } else {
                String securityId = inviteMemberResult.getSecurityId();
                if (securityId == null) {
                    securityId = "";
                }
                SecurityContext securityContext = inviteMemberResult.getSecurityContext();
                String pubKey = securityContext != null ? securityContext.getPubKey() : null;
                familyInvitationPresenter.getAuthRequestContext.MyBillsEntityDataFactory(inviteMemberModel, securityId, pubKey != null ? pubKey : "");
            }
        }
    }
}
