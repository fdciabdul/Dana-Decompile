package id.dana.familyaccount.contract;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.base.AbstractContractKt;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.familyaccount.model.QuestionnaireDataConfig;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import id.dana.familyaccount.model.InviteMemberModel;
import id.dana.sendmoney.model.RecipientModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/contract/FamilyInvitationContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FamilyInvitationContract {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J@\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/contract/FamilyInvitationContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "doConsultCheckStatusMember", "", "inviteMemberModel", "Lid/dana/familyaccount/model/InviteMemberModel;", "recipientModel", "Lid/dana/sendmoney/model/RecipientModel;", "doInvite", "getAgreement", "getQuestionnaireData", "recordAgreement", "agreementKeys", "", "userAgree", "", "organizerName", "organizerPhoneNumber", "memberPhoneNumber", "memberRelationship", "memberLocation", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, boolean z, String str2, String str3, String str4, String str5, String str6);

        void PlaceComponentResult();

        void PlaceComponentResult(InviteMemberModel inviteMemberModel);

        void PlaceComponentResult(InviteMemberModel inviteMemberModel, RecipientModel recipientModel);
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/contract/FamilyInvitationContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onCheckStatusMemberError", "", "errorMessage", "", "onCheckStatusMemberSuccess", "recipientModel", "Lid/dana/sendmoney/model/RecipientModel;", "onGetAgreementError", "throwable", "", "onGetAgreementSuccess", "consultAgreementResponse", "Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "onGetQuestionnaireDataSuccess", "questionnaireDatas", "Lid/dana/domain/familyaccount/model/QuestionnaireDataConfig;", "onHideShimmeringProgress", "onProcessRisk", "inviteMemberModel", "Lid/dana/familyaccount/model/InviteMemberModel;", BioUtilityBridge.SECURITY_ID, RecordError.KEY_PUB_KEY, "onRecordAgreementSuccess", "onShowSimmeringProgress", "onUserInvitedFail", "message", "onUserInvitedSuccess", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.familyaccount.contract.FamilyInvitationContract$View$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void BuiltInFictitiousFunctionClassFactory(QuestionnaireDataConfig questionnaireDataConfig) {
                Intrinsics.checkNotNullParameter(questionnaireDataConfig, "");
            }

            public static void MyBillsEntityDataFactory(String str) {
                Intrinsics.checkNotNullParameter(str, "");
            }

            public static void MyBillsEntityDataFactory(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            public static void PlaceComponentResult() {
            }

            public static void getAuthRequestContext() {
            }

            public static void getAuthRequestContext(ConsultAgreementResponse consultAgreementResponse) {
                Intrinsics.checkNotNullParameter(consultAgreementResponse, "");
            }
        }

        void BuiltInFictitiousFunctionClassFactory(InviteMemberModel inviteMemberModel, String str);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(ConsultAgreementResponse consultAgreementResponse);

        void MyBillsEntityDataFactory(InviteMemberModel inviteMemberModel, String str, String str2);

        void PlaceComponentResult();

        void PlaceComponentResult(QuestionnaireDataConfig questionnaireDataConfig);

        void PlaceComponentResult(InviteMemberModel inviteMemberModel);

        void PlaceComponentResult(RecipientModel recipientModel);

        void getAuthRequestContext(String str);

        void getAuthRequestContext(Throwable th);
    }
}
