package id.dana.data.saving.repository.source.mock;

import id.dana.data.constant.UrlParam;
import id.dana.data.saving.model.SavingView;
import id.dana.data.saving.model.TopUpViewEntity;
import id.dana.data.saving.repository.SavingEntityData;
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
import id.dana.data.util.RandomMatchers;
import id.dana.domain.saving.model.SavingWithdrawInitRequest;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@Singleton
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\bA\u0010BJ5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ7\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\u0010H\u0002¢\u0006\u0004\b#\u0010\u0012J\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0010H\u0002¢\u0006\u0004\b%\u0010\u0012J-\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00072\u0006\u0010&\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'H\u0016¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0007H\u0016¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u0007H\u0016¢\u0006\u0004\b/\u0010-J\u001d\u00101\u001a\b\u0012\u0004\u0012\u0002000\u00072\u0006\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b1\u00102J\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00180\u00072\u0006\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b3\u00102J\u001d\u00107\u001a\b\u0012\u0004\u0012\u0002060\u00072\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b7\u00108J\u001d\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u00072\u0006\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b:\u00102J-\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u00072\u0006\u0010&\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b=\u0010>J5\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u00072\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b@\u0010\n"}, d2 = {"Lid/dana/data/saving/repository/source/mock/MockSavingEntityData;", "Lid/dana/data/saving/repository/SavingEntityData;", "", UrlParam.REQUEST_ID, "categoryCode", "title", "targetAmount", "Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/GoalCreateSubmitResult;", "createSaving", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "currentAmount", "createdTime", "Lid/dana/data/saving/model/SavingView;", "createSavingViewEntity", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/saving/model/SavingView;", "", "generateCategoryCodes", "()Ljava/util/List;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "generateCurrentAmount", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "generateMaxAmount", "generateMaxTargetAmount", "Lid/dana/data/saving/repository/source/network/response/GoalUpdateInitResult;", "generateMockInitSavingUpdate", "()Lid/dana/data/saving/repository/source/network/response/GoalUpdateInitResult;", "Lid/dana/data/saving/repository/source/network/response/UserSavingSummaryConsultResult;", "generateMockSavingSummary", "()Lid/dana/data/saving/repository/source/network/response/UserSavingSummaryConsultResult;", "Lid/dana/data/saving/repository/source/network/response/SavingDetailResult;", "generateSavingDetail", "()Lid/dana/data/saving/repository/source/network/response/SavingDetailResult;", "generateSavingViewEntity", "()Lid/dana/data/saving/model/SavingView;", "generateSavingViews", "Lid/dana/data/saving/model/TopUpViewEntity;", "generateTopUpViewEntities", "savingId", "", "topUpViewsPage", "topUpViewsSize", "getSavingDetail", "(Ljava/lang/String;JJ)Lio/reactivex/Observable;", "getSavingSummary", "()Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/GoalCreateInitResult;", "initSavingCreate", "Lid/dana/data/saving/repository/source/network/response/GoalTopUpInitResult;", "initSavingTopUp", "(Ljava/lang/String;)Lio/reactivex/Observable;", "initSavingUpdate", "Lid/dana/domain/saving/model/SavingWithdrawInitRequest;", "savingWithdrawInitRequest", "Lid/dana/data/saving/repository/source/network/response/SavingWithdrawInitEntityResult;", "initSavingWithdraw", "(Lid/dana/domain/saving/model/SavingWithdrawInitRequest;)Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/GoalRevokeResult;", "revokeSaving", "fundAmount", "Lid/dana/data/saving/repository/source/network/response/SavingTopUpSubmitResult;", "topUpSaving", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/source/network/response/GoalUpdateSubmitResult;", "updateSaving", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MockSavingEntityData implements SavingEntityData {
    @Inject
    public MockSavingEntityData() {
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<UserSavingSummaryConsultResult> getSavingSummary() {
        Observable<UserSavingSummaryConsultResult> just = Observable.just(generateMockSavingSummary());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<SavingDetailResult> getSavingDetail(String savingId, long topUpViewsPage, long topUpViewsSize) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Observable<SavingDetailResult> just = Observable.just(generateSavingDetail());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<GoalCreateInitResult> initSavingCreate() {
        Observable<GoalCreateInitResult> just = Observable.just(new GoalCreateInitResult(generateCategoryCodes(), generateMaxTargetAmount()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<GoalCreateSubmitResult> createSaving(String requestId, String categoryCode, String title, String targetAmount) {
        Intrinsics.checkNotNullParameter(requestId, "");
        Intrinsics.checkNotNullParameter(categoryCode, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(targetAmount, "");
        Observable<GoalCreateSubmitResult> just = Observable.just(new GoalCreateSubmitResult(generateSavingViewEntity()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<GoalUpdateInitResult> initSavingUpdate(String savingId) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Observable<GoalUpdateInitResult> just = Observable.just(generateMockInitSavingUpdate());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    private final GoalUpdateInitResult generateMockInitSavingUpdate() {
        return new GoalUpdateInitResult(generateCategoryCodes(), generateMaxTargetAmount(), generateSavingViewEntity());
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<GoalUpdateSubmitResult> updateSaving(String savingId, String categoryCode, String title, String targetAmount) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Intrinsics.checkNotNullParameter(categoryCode, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(targetAmount, "");
        GoalUpdateSubmitResult goalUpdateSubmitResult = new GoalUpdateSubmitResult(generateSavingViewEntity());
        goalUpdateSubmitResult.success = true;
        Observable<GoalUpdateSubmitResult> just = Observable.just(goalUpdateSubmitResult);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<GoalRevokeResult> revokeSaving(String savingId) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Observable<GoalRevokeResult> just = Observable.just(new GoalRevokeResult(Random.INSTANCE.nextBoolean()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<GoalTopUpInitResult> initSavingTopUp(String savingId) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Observable<GoalTopUpInitResult> just = Observable.just(new GoalTopUpInitResult(generateMaxAmount(), generateCurrentAmount(), generateMaxTargetAmount()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<SavingTopUpSubmitResult> topUpSaving(String savingId, String fundAmount, String requestId) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Intrinsics.checkNotNullParameter(fundAmount, "");
        Intrinsics.checkNotNullParameter(requestId, "");
        String randomString = RandomMatchers.randomString();
        Intrinsics.checkNotNullExpressionValue(randomString, "");
        Observable<SavingTopUpSubmitResult> just = Observable.just(new SavingTopUpSubmitResult(randomString));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.saving.repository.SavingEntityData
    public final Observable<SavingWithdrawInitEntityResult> initSavingWithdraw(SavingWithdrawInitRequest savingWithdrawInitRequest) {
        Intrinsics.checkNotNullParameter(savingWithdrawInitRequest, "");
        StringBuilder sb = new StringBuilder();
        sb.append("An operation is not implemented: ");
        sb.append("Not yet implemented");
        throw new NotImplementedError(sb.toString());
    }

    private final MoneyViewEntity generateMaxAmount() {
        return new MoneyViewEntity("103.000", "Rp", "Rp");
    }

    private final MoneyViewEntity generateCurrentAmount() {
        return new MoneyViewEntity("1.00.000", "Rp", "Rp");
    }

    private final MoneyViewEntity generateMaxTargetAmount() {
        return new MoneyViewEntity("2.000.000", "Rp", "Rp");
    }

    private final List<String> generateCategoryCodes() {
        return CollectionsKt.listOf((Object[]) new String[]{"entertainment", "fashion", "gadget", "electronic", "travelling", "general"});
    }

    private final SavingDetailResult generateSavingDetail() {
        SavingDetailResult savingDetailResult = new SavingDetailResult(generateSavingViewEntity(), generateTopUpViewEntities(), true);
        savingDetailResult.success = true;
        return savingDetailResult;
    }

    private final List<TopUpViewEntity> generateTopUpViewEntities() {
        return CollectionsKt.listOf((Object[]) new TopUpViewEntity[]{new TopUpViewEntity("202004161013012101010016677091155599", new MoneyViewEntity("30000", "Rp", "Rp"), "SUCCESS", "2020-04-16T15:11:50+07:00", "2020-04-16T15:12:12+07:00", MapsKt.emptyMap()), new TopUpViewEntity("202004161013012101010016677091155598", new MoneyViewEntity("10000", "Rp", "Rp"), "SUCCESS", "2020-04-16T09:45:22+07:00", "2020-04-16T09:45:49+07:00", MapsKt.emptyMap()), new TopUpViewEntity("202004161013012101010016677091155597", new MoneyViewEntity("50000", "Rp", "Rp"), "SUCCESS", "2020-04-15T23:39:19+07:00", "2020-04-15T23:39:58+07:00", MapsKt.emptyMap())});
    }

    private final SavingView generateSavingViewEntity() {
        return new SavingView("202004161013012001010016677091197714", "Beli baju Avengers", "fashion", new MoneyViewEntity("155000", null, null, 6, null), new MoneyViewEntity("275000", null, null, 6, null), "PROCESSING", "", "2020-04-15T14:14:00+07:00", "", "");
    }

    private final UserSavingSummaryConsultResult generateMockSavingSummary() {
        UserSavingSummaryConsultResult userSavingSummaryConsultResult = new UserSavingSummaryConsultResult(new MoneyViewEntity("300000", null, null, 6, null), new MoneyViewEntity("8000000", null, null, 6, null), 10L, new MoneyViewEntity("7700000", null, null, 6, null), 2L, generateSavingViews(), false);
        userSavingSummaryConsultResult.success = true;
        return userSavingSummaryConsultResult;
    }

    private final List<SavingView> generateSavingViews() {
        return CollectionsKt.listOf((Object[]) new SavingView[]{createSavingViewEntity("Title 1", "entertainment", "250.000", "1.000.000", "2020-01-16T18:30:03+07:00"), createSavingViewEntity("Title 2", "fashion", "100.000", "100.000", "2020-04-16T18:30:03+08:00"), createSavingViewEntity("Title 3", "electronic", "600.000", "900.000", "2020-09-16T18:30:03+07:00"), createSavingViewEntity("Title 4", "gadget", "1.100.000", "1.100.000", "2020-05-09T18:30:03+07:00"), createSavingViewEntity("Title 5", "electronic", "40.000", "800.000", "2020-03-16T18:30:03+07:00"), createSavingViewEntity("Title 6", "travelling", "500.000", "600.000", "2020-02-12T18:30:03+07:00"), createSavingViewEntity("Title 7", "general", "10.000", "700.000", "2020-04-15T18:30:03+07:00")});
    }

    private final SavingView createSavingViewEntity(String title, String categoryCode, String currentAmount, String targetAmount, String createdTime) {
        String randomString = RandomMatchers.randomString();
        Intrinsics.checkNotNullExpressionValue(randomString, "");
        MoneyViewEntity moneyViewEntity = new MoneyViewEntity(currentAmount, null, null, 6, null);
        MoneyViewEntity moneyViewEntity2 = new MoneyViewEntity(targetAmount, null, null, 6, null);
        String randomString2 = RandomMatchers.randomString();
        Intrinsics.checkNotNullExpressionValue(randomString2, "");
        return new SavingView(randomString, title, categoryCode, moneyViewEntity, moneyViewEntity2, randomString2, RandomMatchers.randomString(), createdTime, RandomMatchers.randomString(), RandomMatchers.randomString());
    }
}
