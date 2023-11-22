package id.dana.familyaccount.contract;

import id.dana.base.AbstractContractKt;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.familyaccount.model.InvitationDecisionRequestModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/contract/FamilyJoinInvitationContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FamilyJoinInvitationContract {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "Lid/dana/familyaccount/model/InvitationDecisionRequestModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/familyaccount/model/InvitationDecisionRequestModel;)V", "getAuthRequestContext", "()V", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2(InvitationDecisionRequestModel p0);

        void PlaceComponentResult(InvitationDecisionRequestModel p0);

        void getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/contract/FamilyJoinInvitationContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onErrorAcceptInvitation", "", "onErrorRejectInvitation", "onInvitationInvalid", "onProcessRisk", "invitationId", "", BioUtilityBridge.SECURITY_ID, "onSuccessAcceptInvitation", "onSuccessCheckUserIsPremium", BranchLinkConstant.Params.PREMIUM_USER, "", "onSuccessRejectInvitation", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(String str, String str2);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(boolean z);

        void PlaceComponentResult();

        void getAuthRequestContext();
    }
}
