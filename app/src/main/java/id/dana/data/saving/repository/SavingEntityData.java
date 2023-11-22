package id.dana.data.saving.repository;

import id.dana.data.constant.UrlParam;
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
import id.dana.domain.saving.model.SavingWithdrawInitRequest;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007H&¢\u0006\u0004\b\u0016\u0010\u0014J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00072\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00072\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u0019J\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00072\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00072\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\"\u0010\u0019J-\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b%\u0010&J5\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b(\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/saving/repository/SavingEntityData;", "", "", UrlParam.REQUEST_ID, "categoryCode", "title", "targetAmount", "Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/GoalCreateSubmitResult;", "createSaving", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "savingId", "", "topUpViewsPage", "topUpViewsSize", "Lid/dana/data/saving/repository/source/network/response/SavingDetailResult;", "getSavingDetail", "(Ljava/lang/String;JJ)Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/UserSavingSummaryConsultResult;", "getSavingSummary", "()Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/GoalCreateInitResult;", "initSavingCreate", "Lid/dana/data/saving/repository/source/network/response/GoalTopUpInitResult;", "initSavingTopUp", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/GoalUpdateInitResult;", "initSavingUpdate", "Lid/dana/domain/saving/model/SavingWithdrawInitRequest;", "savingWithdrawInitRequest", "Lid/dana/data/saving/repository/source/network/response/SavingWithdrawInitEntityResult;", "initSavingWithdraw", "(Lid/dana/domain/saving/model/SavingWithdrawInitRequest;)Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/GoalRevokeResult;", "revokeSaving", "fundAmount", "Lid/dana/data/saving/repository/source/network/response/SavingTopUpSubmitResult;", "topUpSaving", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/GoalUpdateSubmitResult;", "updateSaving"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface SavingEntityData {
    Observable<GoalCreateSubmitResult> createSaving(String requestId, String categoryCode, String title, String targetAmount);

    Observable<SavingDetailResult> getSavingDetail(String savingId, long topUpViewsPage, long topUpViewsSize);

    Observable<UserSavingSummaryConsultResult> getSavingSummary();

    Observable<GoalCreateInitResult> initSavingCreate();

    Observable<GoalTopUpInitResult> initSavingTopUp(String savingId);

    Observable<GoalUpdateInitResult> initSavingUpdate(String savingId);

    Observable<SavingWithdrawInitEntityResult> initSavingWithdraw(SavingWithdrawInitRequest savingWithdrawInitRequest);

    Observable<GoalRevokeResult> revokeSaving(String savingId);

    Observable<SavingTopUpSubmitResult> topUpSaving(String savingId, String fundAmount, String requestId);

    Observable<GoalUpdateSubmitResult> updateSaving(String savingId, String categoryCode, String title, String targetAmount);
}
