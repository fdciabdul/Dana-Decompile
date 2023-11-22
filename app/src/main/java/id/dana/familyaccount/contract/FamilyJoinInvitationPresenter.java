package id.dana.familyaccount.contract;

import id.dana.domain.DefaultObserver;
import id.dana.domain.auth.face.result.VerificationMethodInfo;
import id.dana.domain.familyaccount.interactor.AcceptFamilyInvitation;
import id.dana.domain.familyaccount.interactor.RejectFamilyInvitation;
import id.dana.domain.familyaccount.model.InvitationDecisionInfo;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.familyaccount.contract.FamilyJoinInvitationContract;
import id.dana.familyaccount.mapper.InvitationDecisionModelMapperKt;
import id.dana.familyaccount.model.InvitationDecisionRequestModel;
import id.dana.familyaccount.util.FamilyAccountErrorHelper;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017"}, d2 = {"Lid/dana/familyaccount/contract/FamilyJoinInvitationPresenter;", "Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$Presenter;", "Lid/dana/familyaccount/model/InvitationDecisionRequestModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/familyaccount/model/InvitationDecisionRequestModel;)V", "getAuthRequestContext", "()V", "onDestroy", "PlaceComponentResult", "Lid/dana/domain/familyaccount/interactor/AcceptFamilyInvitation;", "Lid/dana/domain/familyaccount/interactor/AcceptFamilyInvitation;", "MyBillsEntityDataFactory", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "Lid/dana/domain/familyaccount/interactor/RejectFamilyInvitation;", "Lid/dana/domain/familyaccount/interactor/RejectFamilyInvitation;", "Lid/dana/domain/DefaultObserver;", "Lid/dana/domain/user/UserInfoResponse;", "Lid/dana/domain/DefaultObserver;", "Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$View;", "Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$View;", "p1", "p2", "p3", "<init>", "(Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$View;Lid/dana/domain/user/interactor/GetUserInfoWithKyc;Lid/dana/domain/familyaccount/interactor/AcceptFamilyInvitation;Lid/dana/domain/familyaccount/interactor/RejectFamilyInvitation;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyJoinInvitationPresenter implements FamilyJoinInvitationContract.Presenter {
    private final GetUserInfoWithKyc BuiltInFictitiousFunctionClassFactory;
    private final RejectFamilyInvitation KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private DefaultObserver<UserInfoResponse> PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final AcceptFamilyInvitation MyBillsEntityDataFactory;
    private final FamilyJoinInvitationContract.View getAuthRequestContext;

    @Inject
    public FamilyJoinInvitationPresenter(FamilyJoinInvitationContract.View view, GetUserInfoWithKyc getUserInfoWithKyc, AcceptFamilyInvitation acceptFamilyInvitation, RejectFamilyInvitation rejectFamilyInvitation) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getUserInfoWithKyc, "");
        Intrinsics.checkNotNullParameter(acceptFamilyInvitation, "");
        Intrinsics.checkNotNullParameter(rejectFamilyInvitation, "");
        this.getAuthRequestContext = view;
        this.BuiltInFictitiousFunctionClassFactory = getUserInfoWithKyc;
        this.MyBillsEntityDataFactory = acceptFamilyInvitation;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = rejectFamilyInvitation;
    }

    @Override // id.dana.familyaccount.contract.FamilyJoinInvitationContract.Presenter
    public final void getAuthRequestContext() {
        GetUserInfoWithKyc getUserInfoWithKyc = this.BuiltInFictitiousFunctionClassFactory;
        DefaultObserver<UserInfoResponse> defaultObserver = this.PlaceComponentResult;
        if (defaultObserver != null) {
            if (defaultObserver != null) {
                defaultObserver.dispose();
            }
            this.PlaceComponentResult = null;
        }
        this.getAuthRequestContext.showProgress();
        if (this.PlaceComponentResult == null) {
            this.PlaceComponentResult = new DefaultObserver<UserInfoResponse>() { // from class: id.dana.familyaccount.contract.FamilyJoinInvitationPresenter$getUserInfoObserver$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    FamilyJoinInvitationContract.View view;
                    FamilyJoinInvitationContract.View view2;
                    UserInfoResponse userInfoResponse = (UserInfoResponse) obj;
                    Intrinsics.checkNotNullParameter(userInfoResponse, "");
                    view = FamilyJoinInvitationPresenter.this.getAuthRequestContext;
                    view.dismissProgress();
                    view2 = FamilyJoinInvitationPresenter.this.getAuthRequestContext;
                    view2.MyBillsEntityDataFactory(userInfoResponse.isPremiumUser());
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onError(Throwable p0) {
                    FamilyJoinInvitationContract.View view;
                    Intrinsics.checkNotNullParameter(p0, "");
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GET_USER_INFO_EXCEPTION, p0.toString());
                    view = FamilyJoinInvitationPresenter.this.getAuthRequestContext;
                    view.dismissProgress();
                }
            };
        }
        getUserInfoWithKyc.execute(this.PlaceComponentResult, GetUserInfoWithKyc.Params.forParams(false));
    }

    @Override // id.dana.familyaccount.contract.FamilyJoinInvitationContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final InvitationDecisionRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.showProgress();
        this.MyBillsEntityDataFactory.execute(AcceptFamilyInvitation.Params.INSTANCE.createInvitationRequest(InvitationDecisionModelMapperKt.MyBillsEntityDataFactory(p0)), new Function1<InvitationDecisionInfo, Unit>() { // from class: id.dana.familyaccount.contract.FamilyJoinInvitationPresenter$acceptFamilyInvitation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(InvitationDecisionInfo invitationDecisionInfo) {
                invoke2(invitationDecisionInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(InvitationDecisionInfo invitationDecisionInfo) {
                FamilyJoinInvitationContract.View view;
                Intrinsics.checkNotNullParameter(invitationDecisionInfo, "");
                view = FamilyJoinInvitationPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                FamilyJoinInvitationPresenter.MyBillsEntityDataFactory(FamilyJoinInvitationPresenter.this, invitationDecisionInfo, p0.PlaceComponentResult);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyJoinInvitationPresenter$acceptFamilyInvitation$2
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
                FamilyJoinInvitationContract.View view;
                FamilyJoinInvitationContract.View view2;
                FamilyJoinInvitationContract.View view3;
                Intrinsics.checkNotNullParameter(th, "");
                view = FamilyJoinInvitationPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                FamilyAccountErrorHelper familyAccountErrorHelper = FamilyAccountErrorHelper.INSTANCE;
                if (FamilyAccountErrorHelper.getAuthRequestContext(th)) {
                    view3 = FamilyJoinInvitationPresenter.this.getAuthRequestContext;
                    view3.KClassImpl$Data$declaredNonStaticMembers$2();
                    return;
                }
                view2 = FamilyJoinInvitationPresenter.this.getAuthRequestContext;
                view2.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyJoinInvitationContract.Presenter
    public final void PlaceComponentResult(InvitationDecisionRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(RejectFamilyInvitation.Params.INSTANCE.createInvitationRequest(InvitationDecisionModelMapperKt.MyBillsEntityDataFactory(p0)), new Function1<InvitationDecisionInfo, Unit>() { // from class: id.dana.familyaccount.contract.FamilyJoinInvitationPresenter$rejectFamilyInvitation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(InvitationDecisionInfo invitationDecisionInfo) {
                invoke2(invitationDecisionInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(InvitationDecisionInfo invitationDecisionInfo) {
                FamilyJoinInvitationContract.View view;
                FamilyJoinInvitationContract.View view2;
                Intrinsics.checkNotNullParameter(invitationDecisionInfo, "");
                view = FamilyJoinInvitationPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                view2 = FamilyJoinInvitationPresenter.this.getAuthRequestContext;
                view2.MyBillsEntityDataFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyJoinInvitationPresenter$rejectFamilyInvitation$2
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
                FamilyJoinInvitationContract.View view;
                FamilyJoinInvitationContract.View view2;
                FamilyJoinInvitationContract.View view3;
                Intrinsics.checkNotNullParameter(th, "");
                view = FamilyJoinInvitationPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                FamilyAccountErrorHelper familyAccountErrorHelper = FamilyAccountErrorHelper.INSTANCE;
                if (FamilyAccountErrorHelper.getAuthRequestContext(th)) {
                    view3 = FamilyJoinInvitationPresenter.this.getAuthRequestContext;
                    view3.KClassImpl$Data$declaredNonStaticMembers$2();
                    return;
                }
                view2 = FamilyJoinInvitationPresenter.this.getAuthRequestContext;
                view2.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(FamilyJoinInvitationPresenter familyJoinInvitationPresenter, InvitationDecisionInfo invitationDecisionInfo, String str) {
        List<VerificationMethodInfo> verificationMethodInfos = invitationDecisionInfo.getVerificationMethodInfos();
        if (verificationMethodInfos != null) {
            Iterator<T> it = verificationMethodInfos.iterator();
            while (it.hasNext()) {
                String verificationMethod = ((VerificationMethodInfo) it.next()).getVerificationMethod();
                if (verificationMethod == null) {
                    familyJoinInvitationPresenter.getAuthRequestContext.PlaceComponentResult();
                } else if (!Intrinsics.areEqual(verificationMethod, "PASSWORD")) {
                    if (Intrinsics.areEqual(verificationMethod, "REJECT")) {
                        familyJoinInvitationPresenter.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
                    }
                } else {
                    String securityId = invitationDecisionInfo.getSecurityId();
                    if (securityId == null) {
                        securityId = "";
                    }
                    familyJoinInvitationPresenter.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(str, securityId);
                }
            }
        }
    }
}
