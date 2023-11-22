package id.dana.familyaccount.contract;

import id.dana.domain.auth.face.result.VerificationMethodInfo;
import id.dana.domain.autoroute.model.SecurityContext;
import id.dana.domain.familyaccount.interactor.RemoveFamilyAccount;
import id.dana.domain.familyaccount.interactor.RemoveFamilyMember;
import id.dana.domain.familyaccount.interactor.SetLimitAndServicesFamilyAccount;
import id.dana.domain.familyaccount.model.RemoveFamilyAccountResult;
import id.dana.domain.familyaccount.model.RemoveFamilyMemberResult;
import id.dana.familyaccount.contract.FamilyManageContract;
import id.dana.familyaccount.model.SetLimitAndServicesRequestModel;
import id.dana.familyaccount.model.SetLimitAndServicesRequestModelKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u000e\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016"}, d2 = {"Lid/dana/familyaccount/contract/FamilyManagePresenter;", "Lid/dana/familyaccount/contract/FamilyManageContract$Presenter;", "", "onDestroy", "()V", "BuiltInFictitiousFunctionClassFactory", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)V", "Lid/dana/familyaccount/model/SetLimitAndServicesRequestModel;", "MyBillsEntityDataFactory", "(Lid/dana/familyaccount/model/SetLimitAndServicesRequestModel;)V", "Lid/dana/domain/familyaccount/interactor/RemoveFamilyAccount;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/familyaccount/interactor/RemoveFamilyAccount;", "Lid/dana/domain/familyaccount/interactor/RemoveFamilyMember;", "Lid/dana/domain/familyaccount/interactor/RemoveFamilyMember;", "getAuthRequestContext", "Lid/dana/domain/familyaccount/interactor/SetLimitAndServicesFamilyAccount;", "Lid/dana/domain/familyaccount/interactor/SetLimitAndServicesFamilyAccount;", "Lid/dana/familyaccount/contract/FamilyManageContract$View;", "Lid/dana/familyaccount/contract/FamilyManageContract$View;", "p1", "p2", "p3", "<init>", "(Lid/dana/familyaccount/contract/FamilyManageContract$View;Lid/dana/domain/familyaccount/interactor/SetLimitAndServicesFamilyAccount;Lid/dana/domain/familyaccount/interactor/RemoveFamilyAccount;Lid/dana/domain/familyaccount/interactor/RemoveFamilyMember;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyManagePresenter implements FamilyManageContract.Presenter {
    private final SetLimitAndServicesFamilyAccount BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final RemoveFamilyAccount PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final RemoveFamilyMember getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FamilyManageContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public FamilyManagePresenter(FamilyManageContract.View view, SetLimitAndServicesFamilyAccount setLimitAndServicesFamilyAccount, RemoveFamilyAccount removeFamilyAccount, RemoveFamilyMember removeFamilyMember) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(setLimitAndServicesFamilyAccount, "");
        Intrinsics.checkNotNullParameter(removeFamilyAccount, "");
        Intrinsics.checkNotNullParameter(removeFamilyMember, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.BuiltInFictitiousFunctionClassFactory = setLimitAndServicesFamilyAccount;
        this.PlaceComponentResult = removeFamilyAccount;
        this.getAuthRequestContext = removeFamilyMember;
    }

    @Override // id.dana.familyaccount.contract.FamilyManageContract.Presenter
    public final void MyBillsEntityDataFactory(final SetLimitAndServicesRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(SetLimitAndServicesFamilyAccount.Params.INSTANCE.create(SetLimitAndServicesRequestModelKt.PlaceComponentResult(p0)), new Function1<Boolean, Unit>() { // from class: id.dana.familyaccount.contract.FamilyManagePresenter$setLimitAndServices$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                FamilyManageContract.View view;
                FamilyManageContract.View view2;
                view = FamilyManagePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.dismissProgress();
                view2 = FamilyManagePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(z, p0);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyManagePresenter$setLimitAndServices$2
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
                FamilyManageContract.View view;
                FamilyManageContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FamilyManagePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.dismissProgress();
                view2 = FamilyManagePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyManageContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.showProgress();
        this.PlaceComponentResult.execute(new RemoveFamilyAccount.Params(""), new Function1<RemoveFamilyAccountResult, Unit>() { // from class: id.dana.familyaccount.contract.FamilyManagePresenter$removeFamilyAccount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RemoveFamilyAccountResult removeFamilyAccountResult) {
                invoke2(removeFamilyAccountResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RemoveFamilyAccountResult removeFamilyAccountResult) {
                Intrinsics.checkNotNullParameter(removeFamilyAccountResult, "");
                FamilyManagePresenter.PlaceComponentResult(FamilyManagePresenter.this, removeFamilyAccountResult);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyManagePresenter$removeFamilyAccount$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FAMILY_ACCOUNT, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyManageContract.Presenter
    public final void PlaceComponentResult(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.showProgress();
        this.getAuthRequestContext.execute(new RemoveFamilyMember.Params("", p0), new Function1<RemoveFamilyMemberResult, Unit>() { // from class: id.dana.familyaccount.contract.FamilyManagePresenter$removeFamilyMember$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RemoveFamilyMemberResult removeFamilyMemberResult) {
                invoke2(removeFamilyMemberResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RemoveFamilyMemberResult removeFamilyMemberResult) {
                Intrinsics.checkNotNullParameter(removeFamilyMemberResult, "");
                FamilyManagePresenter.MyBillsEntityDataFactory(FamilyManagePresenter.this, removeFamilyMemberResult, p0);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyManagePresenter$removeFamilyMember$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FAMILY_ACCOUNT, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.getAuthRequestContext.dispose();
    }

    public static final /* synthetic */ void PlaceComponentResult(FamilyManagePresenter familyManagePresenter, RemoveFamilyAccountResult removeFamilyAccountResult) {
        Iterator<T> it = removeFamilyAccountResult.getVerificationMethodInfoList().iterator();
        while (it.hasNext()) {
            String verificationMethod = ((VerificationMethodInfo) it.next()).getVerificationMethod();
            if (verificationMethod == null) {
                familyManagePresenter.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
            } else if (!Intrinsics.areEqual(verificationMethod, "PASSWORD")) {
                if (Intrinsics.areEqual(verificationMethod, "REJECT")) {
                    familyManagePresenter.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
                }
            } else {
                String securityId = removeFamilyAccountResult.getSecurityId();
                if (securityId == null) {
                    securityId = "";
                }
                SecurityContext securityContext = removeFamilyAccountResult.getSecurityContext();
                String pubKey = securityContext != null ? securityContext.getPubKey() : null;
                familyManagePresenter.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(securityId, pubKey != null ? pubKey : "");
            }
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(FamilyManagePresenter familyManagePresenter, RemoveFamilyMemberResult removeFamilyMemberResult, String str) {
        Iterator<T> it = removeFamilyMemberResult.getVerificationMethodInfoList().iterator();
        while (it.hasNext()) {
            String verificationMethod = ((VerificationMethodInfo) it.next()).getVerificationMethod();
            if (verificationMethod == null) {
                familyManagePresenter.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
            } else if (!Intrinsics.areEqual(verificationMethod, "PASSWORD")) {
                if (Intrinsics.areEqual(verificationMethod, "REJECT")) {
                    familyManagePresenter.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
                }
            } else {
                String securityId = removeFamilyMemberResult.getSecurityId();
                if (securityId == null) {
                    securityId = "";
                }
                SecurityContext securityContext = removeFamilyMemberResult.getSecurityContext();
                String pubKey = securityContext != null ? securityContext.getPubKey() : null;
                familyManagePresenter.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(securityId, str, pubKey != null ? pubKey : "");
            }
        }
    }
}
