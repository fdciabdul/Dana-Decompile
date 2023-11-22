package id.dana.danapoly.ui.board.viewmodel;

import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import id.dana.danapoly.domain.config.interactor.GetLastBackgroundColor;
import id.dana.danapoly.domain.config.interactor.GetPlayBoard;
import id.dana.danapoly.domain.config.interactor.GetPlayerInfo;
import id.dana.danapoly.domain.config.interactor.HasShownTutorial;
import id.dana.danapoly.domain.config.interactor.SaveLastBackgroundColor;
import id.dana.danapoly.domain.config.interactor.SaveShownTutorial;
import id.dana.danapoly.domain.config.model.PlayerInfo;
import id.dana.danapoly.domain.dailycheck.interactor.FetchCheckInHistory;
import id.dana.danapoly.domain.dailycheck.model.CheckInInfo;
import id.dana.danapoly.domain.play.interactor.PlayDanapoly;
import id.dana.danapoly.domain.play.model.RollDice;
import id.dana.danapoly.ui.board.viewmodel.DanapolyBoardUiState;
import id.dana.danapoly.ui.model.BackgroundColorType;
import id.dana.danapoly.ui.model.PlayBoardModel;
import id.dana.danapoly.ui.model.mapper.PlayerInfoModelMapperKt;
import id.dana.danapoly.ui.model.mapper.RollDiceModelMapperKt;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.network.exception.NetworkException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0019\u0012\u0006\u0010\n\u001a\u00020 \u0012\u0006\u0010,\u001a\u00020$\u0012\u0006\u0010-\u001a\u00020\u0015\u0012\u0006\u0010.\u001a\u00020\u0017\u0012\u0006\u0010/\u001a\u00020\u001c\u0012\u0006\u00100\u001a\u00020'\u0012\u0006\u00101\u001a\u00020\u0012¢\u0006\u0004\b2\u00103J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u001f\u0010\u000b\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0014\u0010\u000b\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u0006\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u000f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u001fR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010%R\u0014\u0010\u0013\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010(R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0)X\u0006¢\u0006\u0006\n\u0004\b&\u0010*"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardViewModel;", "Landroidx/lifecycle/ViewModel;", "", "getAuthRequestContext", "()V", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/danapoly/ui/model/PlayBoardModel;", "p0", "", "p1", "MyBillsEntityDataFactory", "(Lid/dana/danapoly/ui/model/PlayBoardModel;Z)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlinx/coroutines/flow/MutableStateFlow;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danapoly/domain/dailycheck/interactor/FetchCheckInHistory;", "getErrorConfigVersion", "Lid/dana/danapoly/domain/dailycheck/interactor/FetchCheckInHistory;", "Lid/dana/danapoly/domain/config/interactor/GetLastBackgroundColor;", "Lid/dana/danapoly/domain/config/interactor/GetLastBackgroundColor;", "Lid/dana/danapoly/domain/config/interactor/GetPlayBoard;", "Lid/dana/danapoly/domain/config/interactor/GetPlayBoard;", "Lid/dana/danapoly/domain/config/interactor/GetPlayerInfo;", "lookAheadTest", "Lid/dana/danapoly/domain/config/interactor/GetPlayerInfo;", "Lid/dana/danapoly/domain/config/interactor/HasShownTutorial;", "Lid/dana/danapoly/domain/config/interactor/HasShownTutorial;", "Lid/dana/danapoly/ui/model/BackgroundColorType;", "Lid/dana/danapoly/ui/model/BackgroundColorType;", "Lid/dana/danapoly/domain/play/interactor/PlayDanapoly;", "initRecordTimeStamp", "Lid/dana/danapoly/domain/play/interactor/PlayDanapoly;", "scheduleImpl", "Lid/dana/danapoly/domain/config/interactor/SaveLastBackgroundColor;", "Lid/dana/danapoly/domain/config/interactor/SaveLastBackgroundColor;", "moveToNextValue", "Lid/dana/danapoly/domain/config/interactor/SaveShownTutorial;", "Lid/dana/danapoly/domain/config/interactor/SaveShownTutorial;", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Lid/dana/danapoly/domain/config/interactor/GetPlayerInfo;Lid/dana/danapoly/domain/play/interactor/PlayDanapoly;Lid/dana/danapoly/domain/config/interactor/SaveLastBackgroundColor;Lid/dana/danapoly/domain/config/interactor/GetLastBackgroundColor;Lid/dana/danapoly/domain/config/interactor/GetPlayBoard;Lid/dana/danapoly/domain/config/interactor/HasShownTutorial;Lid/dana/danapoly/domain/config/interactor/SaveShownTutorial;Lid/dana/danapoly/domain/dailycheck/interactor/FetchCheckInHistory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyBoardViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public BackgroundColorType lookAheadTest;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final SaveLastBackgroundColor moveToNextValue;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final GetLastBackgroundColor getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final MutableStateFlow<DanapolyBoardUiState> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final GetPlayBoard MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final HasShownTutorial NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final FetchCheckInHistory PlaceComponentResult;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final PlayDanapoly scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetPlayerInfo BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final StateFlow<DanapolyBoardUiState> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final SaveShownTutorial getErrorConfigVersion;

    @Inject
    public DanapolyBoardViewModel(GetPlayerInfo getPlayerInfo, PlayDanapoly playDanapoly, SaveLastBackgroundColor saveLastBackgroundColor, GetLastBackgroundColor getLastBackgroundColor, GetPlayBoard getPlayBoard, HasShownTutorial hasShownTutorial, SaveShownTutorial saveShownTutorial, FetchCheckInHistory fetchCheckInHistory) {
        Intrinsics.checkNotNullParameter(getPlayerInfo, "");
        Intrinsics.checkNotNullParameter(playDanapoly, "");
        Intrinsics.checkNotNullParameter(saveLastBackgroundColor, "");
        Intrinsics.checkNotNullParameter(getLastBackgroundColor, "");
        Intrinsics.checkNotNullParameter(getPlayBoard, "");
        Intrinsics.checkNotNullParameter(hasShownTutorial, "");
        Intrinsics.checkNotNullParameter(saveShownTutorial, "");
        Intrinsics.checkNotNullParameter(fetchCheckInHistory, "");
        this.BuiltInFictitiousFunctionClassFactory = getPlayerInfo;
        this.scheduleImpl = playDanapoly;
        this.moveToNextValue = saveLastBackgroundColor;
        this.getAuthRequestContext = getLastBackgroundColor;
        this.MyBillsEntityDataFactory = getPlayBoard;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = hasShownTutorial;
        this.getErrorConfigVersion = saveShownTutorial;
        this.PlaceComponentResult = fetchCheckInHistory;
        MutableStateFlow<DanapolyBoardUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(DanapolyBoardUiState.None.INSTANCE);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MutableStateFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final void MyBillsEntityDataFactory(PlayBoardModel p0, boolean p1) {
        Unit unit;
        if (p0 != null) {
            MutableStateFlow<DanapolyBoardUiState> mutableStateFlow = this.KClassImpl$Data$declaredNonStaticMembers$2;
            do {
            } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new DanapolyBoardUiState.OnConfigurationLoaded(p0, p1)));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            MutableStateFlow<DanapolyBoardUiState> mutableStateFlow2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            do {
            } while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), DanapolyBoardUiState.OnConfigurationError.INSTANCE));
        }
    }

    public final void getAuthRequestContext() {
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$getPlayerInfo$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, new Function1<PlayerInfo, Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$getPlayerInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PlayerInfo playerInfo) {
                invoke2(playerInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PlayerInfo playerInfo) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(playerInfo, "");
                mutableStateFlow = DanapolyBoardViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyBoardUiState danapolyBoardUiState = (DanapolyBoardUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DanapolyBoardUiState.OnPlayerInfoLoaded(PlayerInfoModelMapperKt.toPlayerInfoModel(playerInfo))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$getPlayerInfo$3
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
                mutableStateFlow = DanapolyBoardViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyBoardUiState danapolyBoardUiState = (DanapolyBoardUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DanapolyBoardUiState.OnPlayerInfoError(th)));
            }
        }, new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$getPlayerInfo$4
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, ViewModelKt.PlaceComponentResult(this));
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        this.scheduleImpl.execute(NoParams.INSTANCE, new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$rollDice$1
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
                mutableStateFlow = DanapolyBoardViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyBoardUiState danapolyBoardUiState = (DanapolyBoardUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DanapolyBoardUiState.RollDiceLoading(true)));
            }
        }, new Function1<RollDice, Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$rollDice$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RollDice rollDice) {
                invoke2(rollDice);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RollDice rollDice) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(rollDice, "");
                mutableStateFlow = DanapolyBoardViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyBoardUiState danapolyBoardUiState = (DanapolyBoardUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DanapolyBoardUiState.RollDiceSuccess(RollDiceModelMapperKt.toRollDiceModel(rollDice), rollDice.getUsingFreeAttempt(), rollDice.getUserCurrentFund(), rollDice.getUserCurrentLap())));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$rollDice$3
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
                DanapolyBoardUiState rollDiceError;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = DanapolyBoardViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyBoardUiState danapolyBoardUiState = (DanapolyBoardUiState) value;
                    if (th instanceof NetworkException) {
                        rollDiceError = Intrinsics.areEqual(((NetworkException) th).getErrorCode(), "DP002010104") ? DanapolyBoardUiState.OutOfDiceError.INSTANCE : new DanapolyBoardUiState.RollDiceError(th);
                    } else {
                        rollDiceError = new DanapolyBoardUiState.RollDiceError(th);
                    }
                } while (!mutableStateFlow.compareAndSet(value, rollDiceError));
            }
        }, new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$rollDice$4
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
                mutableStateFlow = DanapolyBoardViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyBoardUiState danapolyBoardUiState = (DanapolyBoardUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DanapolyBoardUiState.RollDiceLoading(false)));
            }
        }, ViewModelKt.PlaceComponentResult(this));
    }

    public final void PlaceComponentResult() {
        BaseFlowUseCase.execute$default(this.PlaceComponentResult, NoParams.INSTANCE, null, new Function1<CheckInInfo, Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$getUserCheckInHistory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CheckInInfo checkInInfo) {
                invoke2(checkInInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CheckInInfo checkInInfo) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(checkInInfo, "");
                mutableStateFlow = DanapolyBoardViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyBoardUiState danapolyBoardUiState = (DanapolyBoardUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DanapolyBoardUiState.OnCheckInHistoryFetched(checkInInfo.getTodayCheckInPosition() != null)));
            }
        }, null, null, ViewModelKt.PlaceComponentResult(this), 26, null);
    }
}
