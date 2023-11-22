package id.dana.domain.saving;

import id.dana.domain.saving.model.SavingCreateInit;
import id.dana.domain.saving.model.SavingDetail;
import id.dana.domain.saving.model.SavingEmptyState;
import id.dana.domain.saving.model.SavingGoalView;
import id.dana.domain.saving.model.SavingLimit;
import id.dana.domain.saving.model.SavingSummary;
import id.dana.domain.saving.model.SavingTopUpInit;
import id.dana.domain.saving.model.SavingUpdateInit;
import id.dana.domain.saving.model.SavingWithdrawInitRequest;
import id.dana.domain.saving.model.SavingWithdrawInitResult;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006H&¢\u0006\u0004\b\u0015\u0010\u0013J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006H&¢\u0006\u0004\b\u0017\u0010\u0013J\u001b\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00180\u0006H&¢\u0006\u0004\b\u0019\u0010\u0013J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0006H&¢\u0006\u0004\b\u001b\u0010\u0013J\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00062\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b \u0010\u001eJ\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00062\u0006\u0010\n\u001a\u00020!H&¢\u0006\u0004\b#\u0010$J\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00062\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b&\u0010\u001eJ%\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0002H&¢\u0006\u0004\b(\u0010)J5\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b*\u0010+ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/saving/SavingRepository;", "", "", "categoryCode", "title", "targetAmount", "Lio/reactivex/Observable;", "Lid/dana/domain/saving/model/SavingGoalView;", "createSaving", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "savingId", "", "topUpViewsPage", "topUpViewsSize", "Lid/dana/domain/saving/model/SavingDetail;", "getSavingDetail", "(Ljava/lang/String;JJ)Lio/reactivex/Observable;", "Lid/dana/domain/saving/model/SavingEmptyState;", "getSavingEmptyState", "()Lio/reactivex/Observable;", "Lid/dana/domain/saving/model/SavingLimit;", "getSavingLimit", "Lid/dana/domain/saving/model/SavingSummary;", "getSavingSummary", "", "getWithdrawOption", "Lid/dana/domain/saving/model/SavingCreateInit;", "initSavingCreate", "Lid/dana/domain/saving/model/SavingTopUpInit;", "initSavingTopUp", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/saving/model/SavingUpdateInit;", "initSavingUpdate", "Lid/dana/domain/saving/model/SavingWithdrawInitRequest;", "Lid/dana/domain/saving/model/SavingWithdrawInitResult;", "initSavingWithdraw", "(Lid/dana/domain/saving/model/SavingWithdrawInitRequest;)Lio/reactivex/Observable;", "", "revokeSaving", "fundAmount", "topUpSaving", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "updateSaving", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface SavingRepository {
    Observable<SavingGoalView> createSaving(String categoryCode, String title, String targetAmount);

    Observable<SavingDetail> getSavingDetail(String savingId, long topUpViewsPage, long topUpViewsSize);

    Observable<SavingEmptyState> getSavingEmptyState();

    Observable<SavingLimit> getSavingLimit();

    Observable<SavingSummary> getSavingSummary();

    Observable<List<String>> getWithdrawOption();

    Observable<SavingCreateInit> initSavingCreate();

    Observable<SavingTopUpInit> initSavingTopUp(String savingId);

    Observable<SavingUpdateInit> initSavingUpdate(String savingId);

    Observable<SavingWithdrawInitResult> initSavingWithdraw(SavingWithdrawInitRequest savingId);

    Observable<Boolean> revokeSaving(String savingId);

    Observable<String> topUpSaving(String savingId, String fundAmount);

    Observable<SavingGoalView> updateSaving(String savingId, String categoryCode, String title, String targetAmount);
}
