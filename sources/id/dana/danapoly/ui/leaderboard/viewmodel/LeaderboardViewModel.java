package id.dana.danapoly.ui.leaderboard.viewmodel;

import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import id.dana.danapoly.domain.play.interactor.FetchLeaderboard;
import id.dana.danapoly.domain.play.model.GetLeaderboard;
import id.dana.danapoly.domain.play.model.PrizeInfo;
import id.dana.danapoly.ui.leaderboard.viewmodel.LeaderboardUiState;
import id.dana.danapoly.ui.model.leaderboard.LeaderboardModel;
import id.dana.danapoly.ui.model.mapper.LeaderboardMapperKt;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0002\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0013R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardViewModel;", "Landroidx/lifecycle/ViewModel;", "fetchLeaderboard", "Lid/dana/danapoly/domain/play/interactor/FetchLeaderboard;", "(Lid/dana/danapoly/domain/play/interactor/FetchLeaderboard;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "", "lastEventId", "", "generateDefaultLeaderboard", "", "Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;", "existingSize", "", "feature-danapoly_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LeaderboardViewModel extends ViewModel {
    public final StateFlow<LeaderboardUiState> BuiltInFictitiousFunctionClassFactory;
    private final FetchLeaderboard MyBillsEntityDataFactory;
    private final MutableStateFlow<LeaderboardUiState> PlaceComponentResult;

    @Inject
    public LeaderboardViewModel(FetchLeaderboard fetchLeaderboard) {
        Intrinsics.checkNotNullParameter(fetchLeaderboard, "");
        this.MyBillsEntityDataFactory = fetchLeaderboard;
        MutableStateFlow<LeaderboardUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(LeaderboardUiState.None.INSTANCE);
        this.PlaceComponentResult = MutableStateFlow;
        this.BuiltInFictitiousFunctionClassFactory = FlowKt.asStateFlow(MutableStateFlow);
    }

    public static /* synthetic */ void getAuthRequestContext(LeaderboardViewModel leaderboardViewModel) {
        leaderboardViewModel.KClassImpl$Data$declaredNonStaticMembers$2("");
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        BaseFlowUseCase.execute$default(this.MyBillsEntityDataFactory, new FetchLeaderboard.Params(str), null, new Function1<GetLeaderboard, Unit>() { // from class: id.dana.danapoly.ui.leaderboard.viewmodel.LeaderboardViewModel$fetchLeaderboard$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(GetLeaderboard getLeaderboard) {
                invoke2(getLeaderboard);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(GetLeaderboard getLeaderboard) {
                MutableStateFlow mutableStateFlow;
                Object value;
                List mutableList;
                Long eventExpiryDate;
                PrizeInfo prizeInfo;
                Intrinsics.checkNotNullParameter(getLeaderboard, "");
                mutableStateFlow = LeaderboardViewModel.this.PlaceComponentResult;
                do {
                    value = mutableStateFlow.getValue();
                    LeaderboardUiState leaderboardUiState = (LeaderboardUiState) value;
                    mutableList = CollectionsKt.toMutableList((Collection) LeaderboardMapperKt.toLeaderboardModel(getLeaderboard));
                    if (mutableList.size() < 10) {
                        mutableList.addAll(LeaderboardViewModel.getAuthRequestContext(mutableList.size()));
                    }
                    eventExpiryDate = getLeaderboard.getEventExpiryDate();
                    prizeInfo = getLeaderboard.getPrizeInfo();
                } while (!mutableStateFlow.compareAndSet(value, new LeaderboardUiState.OnFetchLeaderboardSuccess(mutableList, eventExpiryDate, prizeInfo != null ? LeaderboardMapperKt.toPrizeInfoModel(prizeInfo) : null)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danapoly.ui.leaderboard.viewmodel.LeaderboardViewModel$fetchLeaderboard$2
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
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = LeaderboardViewModel.this.PlaceComponentResult;
                do {
                    value = mutableStateFlow.getValue();
                    LeaderboardUiState leaderboardUiState = (LeaderboardUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, LeaderboardUiState.OnFetchLeaderboardFailed.INSTANCE));
            }
        }, new Function0<Unit>() { // from class: id.dana.danapoly.ui.leaderboard.viewmodel.LeaderboardViewModel$fetchLeaderboard$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = LeaderboardViewModel.this.PlaceComponentResult;
                do {
                    value = mutableStateFlow.getValue();
                    LeaderboardUiState leaderboardUiState = (LeaderboardUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, LeaderboardUiState.None.INSTANCE));
            }
        }, ViewModelKt.PlaceComponentResult(this), 2, null);
    }

    public static List<LeaderboardModel> getAuthRequestContext(int i) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            i++;
            if (i >= 11) {
                return arrayList;
            }
            arrayList.add(new LeaderboardModel(i, "", "•••••", 0, false, 0, 0, 112, null));
        }
    }
}
