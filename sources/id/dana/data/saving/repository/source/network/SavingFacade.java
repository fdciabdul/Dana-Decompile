package id.dana.data.saving.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.saving.repository.source.network.request.GoalRevokeRequest;
import id.dana.data.saving.repository.source.network.request.GoalTopUpInitRequest;
import id.dana.data.saving.repository.source.network.request.GoalUpdateInitRequest;
import id.dana.data.saving.repository.source.network.request.GoalUpdateSubmitRequest;
import id.dana.data.saving.repository.source.network.request.SavingDetailRequest;
import id.dana.data.saving.repository.source.network.request.SavingTopUpSubmitRequest;
import id.dana.data.saving.repository.source.network.request.SavingWithdrawInitEntityRequest;
import id.dana.data.saving.repository.source.network.request.UserGoalCreateSubmitRequest;
import id.dana.data.saving.repository.source.network.request.UserSavingSummaryConsultRequest;
import id.dana.data.saving.repository.source.network.response.GoalCreateInitResult;
import id.dana.data.saving.repository.source.network.response.GoalCreateSubmitResult;
import id.dana.data.saving.repository.source.network.response.GoalRevokeResult;
import id.dana.data.saving.repository.source.network.response.GoalTopUpInitResult;
import id.dana.data.saving.repository.source.network.response.GoalUpdateInitResult;
import id.dana.data.saving.repository.source.network.response.GoalUpdateSubmitResult;
import id.dana.data.saving.repository.source.network.response.SavingDetailResult;
import id.dana.data.saving.repository.source.network.response.SavingTopUpSubmitResult;
import id.dana.data.saving.repository.source.network.response.SavingWithdrawInitEntityResult;
import id.dana.data.saving.repository.source.network.response.UserSavingSummaryConsultResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 +2\u00020\u0001:\u0001+J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020#H'¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020'H'¢\u0006\u0004\b)\u0010*ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/saving/repository/source/network/SavingFacade;", "", "Lid/dana/data/saving/repository/source/network/request/UserGoalCreateSubmitRequest;", "request", "Lid/dana/data/saving/repository/source/network/response/GoalCreateSubmitResult;", "createSaving", "(Lid/dana/data/saving/repository/source/network/request/UserGoalCreateSubmitRequest;)Lid/dana/data/saving/repository/source/network/response/GoalCreateSubmitResult;", "Lid/dana/data/saving/repository/source/network/request/SavingDetailRequest;", "Lid/dana/data/saving/repository/source/network/response/SavingDetailResult;", "getSavingDetail", "(Lid/dana/data/saving/repository/source/network/request/SavingDetailRequest;)Lid/dana/data/saving/repository/source/network/response/SavingDetailResult;", "Lid/dana/data/saving/repository/source/network/request/UserSavingSummaryConsultRequest;", "Lid/dana/data/saving/repository/source/network/response/UserSavingSummaryConsultResult;", "getSavingSummary", "(Lid/dana/data/saving/repository/source/network/request/UserSavingSummaryConsultRequest;)Lid/dana/data/saving/repository/source/network/response/UserSavingSummaryConsultResult;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "Lid/dana/data/saving/repository/source/network/response/GoalCreateInitResult;", "initSavingCreate", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/saving/repository/source/network/response/GoalCreateInitResult;", "Lid/dana/data/saving/repository/source/network/request/GoalTopUpInitRequest;", "Lid/dana/data/saving/repository/source/network/response/GoalTopUpInitResult;", "initSavingTopUp", "(Lid/dana/data/saving/repository/source/network/request/GoalTopUpInitRequest;)Lid/dana/data/saving/repository/source/network/response/GoalTopUpInitResult;", "Lid/dana/data/saving/repository/source/network/request/GoalUpdateInitRequest;", "Lid/dana/data/saving/repository/source/network/response/GoalUpdateInitResult;", "initSavingUpdate", "(Lid/dana/data/saving/repository/source/network/request/GoalUpdateInitRequest;)Lid/dana/data/saving/repository/source/network/response/GoalUpdateInitResult;", "Lid/dana/data/saving/repository/source/network/request/SavingWithdrawInitEntityRequest;", "Lid/dana/data/saving/repository/source/network/response/SavingWithdrawInitEntityResult;", "initSavingWithdraw", "(Lid/dana/data/saving/repository/source/network/request/SavingWithdrawInitEntityRequest;)Lid/dana/data/saving/repository/source/network/response/SavingWithdrawInitEntityResult;", "Lid/dana/data/saving/repository/source/network/request/GoalRevokeRequest;", "Lid/dana/data/saving/repository/source/network/response/GoalRevokeResult;", "revokeSaving", "(Lid/dana/data/saving/repository/source/network/request/GoalRevokeRequest;)Lid/dana/data/saving/repository/source/network/response/GoalRevokeResult;", "Lid/dana/data/saving/repository/source/network/request/SavingTopUpSubmitRequest;", "Lid/dana/data/saving/repository/source/network/response/SavingTopUpSubmitResult;", "topUpSaving", "(Lid/dana/data/saving/repository/source/network/request/SavingTopUpSubmitRequest;)Lid/dana/data/saving/repository/source/network/response/SavingTopUpSubmitResult;", "Lid/dana/data/saving/repository/source/network/request/GoalUpdateSubmitRequest;", "Lid/dana/data/saving/repository/source/network/response/GoalUpdateSubmitResult;", "updateSaving", "(Lid/dana/data/saving/repository/source/network/request/GoalUpdateSubmitRequest;)Lid/dana/data/saving/repository/source/network/response/GoalUpdateSubmitResult;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface SavingFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String SAVING_ADD_INIT = "dana.saving.add.init";
    public static final String SAVING_ADD_SUBMIT = "dana.saving.add.submit";
    public static final String SAVING_REVOKE_SUBMIT = "dana.saving.revoke.submit";
    public static final String SAVING_SUMMARY_CONSULT = "dana.saving.summary.consult";
    public static final String SAVING_SUMMARY_DETAIL = "dana.saving.summary.detail";
    public static final String SAVING_TOPUP_INIT = "dana.saving.topup.init";
    public static final String SAVING_TOPUP_SUBMIT = "dana.saving.topup.submit";
    public static final String SAVING_UPDATE_INIT = "dana.saving.update.init";
    public static final String SAVING_UPDATE_SUBMIT = "dana.saving.update.submit";
    public static final String SAVING_WITHDRAW_INIT = "dana.saving.withdraw.init";

    @OperationType("dana.saving.add.submit")
    @SignCheck
    GoalCreateSubmitResult createSaving(UserGoalCreateSubmitRequest request);

    @OperationType("dana.saving.summary.detail")
    @SignCheck
    SavingDetailResult getSavingDetail(SavingDetailRequest request);

    @OperationType("dana.saving.summary.consult")
    @SignCheck
    UserSavingSummaryConsultResult getSavingSummary(UserSavingSummaryConsultRequest request);

    @OperationType("dana.saving.add.init")
    @SignCheck
    GoalCreateInitResult initSavingCreate(BaseRpcRequest request);

    @OperationType("dana.saving.topup.init")
    @SignCheck
    GoalTopUpInitResult initSavingTopUp(GoalTopUpInitRequest request);

    @OperationType("dana.saving.update.init")
    @SignCheck
    GoalUpdateInitResult initSavingUpdate(GoalUpdateInitRequest request);

    @OperationType("dana.saving.withdraw.init")
    @SignCheck
    SavingWithdrawInitEntityResult initSavingWithdraw(SavingWithdrawInitEntityRequest request);

    @OperationType("dana.saving.revoke.submit")
    @SignCheck
    GoalRevokeResult revokeSaving(GoalRevokeRequest request);

    @OperationType("dana.saving.topup.submit")
    @SignCheck
    SavingTopUpSubmitResult topUpSaving(SavingTopUpSubmitRequest request);

    @OperationType("dana.saving.update.submit")
    @SignCheck
    GoalUpdateSubmitResult updateSaving(GoalUpdateSubmitRequest request);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004"}, d2 = {"Lid/dana/data/saving/repository/source/network/SavingFacade$Companion;", "", "", "SAVING_ADD_INIT", "Ljava/lang/String;", "SAVING_ADD_SUBMIT", "SAVING_REVOKE_SUBMIT", "SAVING_SUMMARY_CONSULT", "SAVING_SUMMARY_DETAIL", "SAVING_TOPUP_INIT", "SAVING_TOPUP_SUBMIT", "SAVING_UPDATE_INIT", "SAVING_UPDATE_SUBMIT", "SAVING_WITHDRAW_INIT", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String SAVING_ADD_INIT = "dana.saving.add.init";
        public static final String SAVING_ADD_SUBMIT = "dana.saving.add.submit";
        public static final String SAVING_REVOKE_SUBMIT = "dana.saving.revoke.submit";
        public static final String SAVING_SUMMARY_CONSULT = "dana.saving.summary.consult";
        public static final String SAVING_SUMMARY_DETAIL = "dana.saving.summary.detail";
        public static final String SAVING_TOPUP_INIT = "dana.saving.topup.init";
        public static final String SAVING_TOPUP_SUBMIT = "dana.saving.topup.submit";
        public static final String SAVING_UPDATE_INIT = "dana.saving.update.init";
        public static final String SAVING_UPDATE_SUBMIT = "dana.saving.update.submit";
        public static final String SAVING_WITHDRAW_INIT = "dana.saving.withdraw.init";

        private Companion() {
        }
    }
}
