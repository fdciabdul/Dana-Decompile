package id.dana.danapoly.ui.board;

import android.media.MediaPlayer;
import androidx.view.ViewModelKt;
import id.dana.danapoly.databinding.FragmentDanapolyBinding;
import id.dana.danapoly.ui.board.view.DanapolyBoardView;
import id.dana.danapoly.ui.board.viewmodel.DanapolyBoardUiState;
import id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel;
import id.dana.danapoly.ui.sound.DanapolyAudioPlayer;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.NoParams;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danapoly.ui.board.DanapolyBoardFragment$initViewModel$1", f = "DanapolyBoardFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class DanapolyBoardFragment$initViewModel$1 extends SuspendLambda implements Function2<DanapolyBoardUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DanapolyBoardFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanapolyBoardFragment$initViewModel$1(DanapolyBoardFragment danapolyBoardFragment, Continuation<? super DanapolyBoardFragment$initViewModel$1> continuation) {
        super(2, continuation);
        this.this$0 = danapolyBoardFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DanapolyBoardFragment$initViewModel$1 danapolyBoardFragment$initViewModel$1 = new DanapolyBoardFragment$initViewModel$1(this.this$0, continuation);
        danapolyBoardFragment$initViewModel$1.L$0 = obj;
        return danapolyBoardFragment$initViewModel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DanapolyBoardUiState danapolyBoardUiState, Continuation<? super Unit> continuation) {
        return ((DanapolyBoardFragment$initViewModel$1) create(danapolyBoardUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DanapolyBoardUiState danapolyBoardUiState = (DanapolyBoardUiState) this.L$0;
            if (!(danapolyBoardUiState instanceof DanapolyBoardUiState.OnConfigurationLoaded)) {
                if (!(danapolyBoardUiState instanceof DanapolyBoardUiState.OnConfigurationError)) {
                    if (danapolyBoardUiState instanceof DanapolyBoardUiState.OnPlayerInfoError) {
                        this.this$0.KClassImpl$Data$declaredNonStaticMembers$2(true, false);
                    } else if (danapolyBoardUiState instanceof DanapolyBoardUiState.OnPlayerInfoLoaded) {
                        this.this$0.moveToNextValue = ((DanapolyBoardUiState.OnPlayerInfoLoaded) danapolyBoardUiState).KClassImpl$Data$declaredNonStaticMembers$2;
                        final DanapolyBoardViewModel moveToNextValue = DanapolyBoardFragment.moveToNextValue(this.this$0);
                        BaseFlowUseCase.execute$default(moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0, NoParams.INSTANCE, null, new Function1<Boolean, Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$checkShownTutorial$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z2) {
                                MutableStateFlow mutableStateFlow;
                                Object value;
                                mutableStateFlow = DanapolyBoardViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                                do {
                                    value = mutableStateFlow.getValue();
                                    DanapolyBoardUiState danapolyBoardUiState2 = (DanapolyBoardUiState) value;
                                } while (!mutableStateFlow.compareAndSet(value, new DanapolyBoardUiState.OnCheckShownTutorial(z2)));
                            }
                        }, new Function1<Throwable, Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$checkShownTutorial$2
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
                                    DanapolyBoardUiState danapolyBoardUiState2 = (DanapolyBoardUiState) value;
                                } while (!mutableStateFlow.compareAndSet(value, new DanapolyBoardUiState.OnCheckShownTutorial(false)));
                            }
                        }, null, ViewModelKt.PlaceComponentResult(moveToNextValue), 18, null);
                        if (this.this$0.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                            DanapolyBoardFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(this.this$0);
                            DanapolyBoardFragment.BuiltInFictitiousFunctionClassFactory(this.this$0);
                        }
                    } else if (danapolyBoardUiState instanceof DanapolyBoardUiState.RollDiceLoading) {
                        DanapolyBoardUiState.RollDiceLoading rollDiceLoading = (DanapolyBoardUiState.RollDiceLoading) danapolyBoardUiState;
                        this.this$0.NetworkUserEntityData$$ExternalSyntheticLambda0 = rollDiceLoading.getPlaceComponentResult();
                        if (rollDiceLoading.getPlaceComponentResult()) {
                            DanapolyAudioPlayer danapolyAudioPlayer = ((BaseDanapolyAudioFragment) this.this$0).MyBillsEntityDataFactory;
                            if (danapolyAudioPlayer != null) {
                                danapolyAudioPlayer.KClassImpl$Data$declaredNonStaticMembers$2();
                            }
                            VB vb = this.this$0.PlaceComponentResult;
                            if (vb != 0) {
                                ((FragmentDanapolyBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda1.setClickable(true);
                                this.this$0.KClassImpl$Data$declaredNonStaticMembers$2(false, false);
                                VB vb2 = this.this$0.PlaceComponentResult;
                                if (vb2 != 0) {
                                    DanapolyBoardView danapolyBoardView = ((FragmentDanapolyBinding) vb2).BuiltInFictitiousFunctionClassFactory;
                                    Intrinsics.checkNotNullExpressionValue(danapolyBoardView, "");
                                    DanapolyBoardView.animateRollDice$default(danapolyBoardView, false, 1, null);
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        }
                    } else if (!(danapolyBoardUiState instanceof DanapolyBoardUiState.RollDiceSuccess)) {
                        if (!(danapolyBoardUiState instanceof DanapolyBoardUiState.RollDiceError)) {
                            if (!(danapolyBoardUiState instanceof DanapolyBoardUiState.OutOfDiceError)) {
                                if (!(danapolyBoardUiState instanceof DanapolyBoardUiState.OnGetLastBackgroundColor)) {
                                    if (danapolyBoardUiState instanceof DanapolyBoardUiState.OnEventNotExist) {
                                        DanapolyBoardFragment.getAuthRequestContext(this.this$0, ((DanapolyBoardUiState.OnEventNotExist) danapolyBoardUiState).getAuthRequestContext);
                                    } else if (danapolyBoardUiState instanceof DanapolyBoardUiState.OnCheckInHistoryFetched) {
                                        this.this$0.lookAheadTest = ((DanapolyBoardUiState.OnCheckInHistoryFetched) danapolyBoardUiState).getGetAuthRequestContext();
                                        if (this.this$0.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                                            DanapolyBoardFragment danapolyBoardFragment = this.this$0;
                                            z = danapolyBoardFragment.lookAheadTest;
                                            DanapolyBoardFragment.PlaceComponentResult(danapolyBoardFragment, z);
                                        }
                                    }
                                } else {
                                    VB vb3 = this.this$0.PlaceComponentResult;
                                    if (vb3 != 0) {
                                        ((FragmentDanapolyBinding) vb3).BuiltInFictitiousFunctionClassFactory.changeColor(((DanapolyBoardUiState.OnGetLastBackgroundColor) danapolyBoardUiState).KClassImpl$Data$declaredNonStaticMembers$2);
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                }
                            } else {
                                DanapolyAudioPlayer danapolyAudioPlayer2 = ((BaseDanapolyAudioFragment) this.this$0).MyBillsEntityDataFactory;
                                if (danapolyAudioPlayer2 != null && (mediaPlayer = danapolyAudioPlayer2.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                                    mediaPlayer.pause();
                                }
                                VB vb4 = this.this$0.PlaceComponentResult;
                                if (vb4 != 0) {
                                    DanapolyBoardView danapolyBoardView2 = ((FragmentDanapolyBinding) vb4).BuiltInFictitiousFunctionClassFactory;
                                    Intrinsics.checkNotNullExpressionValue(danapolyBoardView2, "");
                                    DanapolyBoardView.renderErrorState$default(danapolyBoardView2, false, null, 2, null);
                                    VB vb5 = this.this$0.PlaceComponentResult;
                                    if (vb5 != 0) {
                                        ((FragmentDanapolyBinding) vb5).BuiltInFictitiousFunctionClassFactory.animateRollDice(false);
                                        DanapolyBoardFragment.GetContactSyncConfig(this.this$0);
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            }
                        } else {
                            DanapolyAudioPlayer danapolyAudioPlayer3 = ((BaseDanapolyAudioFragment) this.this$0).MyBillsEntityDataFactory;
                            if (danapolyAudioPlayer3 != null && (mediaPlayer2 = danapolyAudioPlayer3.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                                mediaPlayer2.pause();
                            }
                            VB vb6 = this.this$0.PlaceComponentResult;
                            if (vb6 != 0) {
                                ((FragmentDanapolyBinding) vb6).BuiltInFictitiousFunctionClassFactory.animateRollDice(false);
                                DanapolyBoardFragment.BuiltInFictitiousFunctionClassFactory(this.this$0);
                                VB vb7 = this.this$0.PlaceComponentResult;
                                if (vb7 != 0) {
                                    ((FragmentDanapolyBinding) vb7).BuiltInFictitiousFunctionClassFactory.renderErrorState(true, DanapolyBoardView.BoardState.ERROR_ROLL_DICE);
                                    VB vb8 = this.this$0.PlaceComponentResult;
                                    if (vb8 != 0) {
                                        ((FragmentDanapolyBinding) vb8).BuiltInFictitiousFunctionClassFactory.hidePawn();
                                        this.this$0.KClassImpl$Data$declaredNonStaticMembers$2(true, false);
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        }
                    } else {
                        VB vb9 = this.this$0.PlaceComponentResult;
                        if (vb9 != 0) {
                            ((FragmentDanapolyBinding) vb9).NetworkUserEntityData$$ExternalSyntheticLambda1.setClickable(true);
                            DanapolyBoardUiState.RollDiceSuccess rollDiceSuccess = (DanapolyBoardUiState.RollDiceSuccess) danapolyBoardUiState;
                            this.this$0.scheduleImpl = rollDiceSuccess.PlaceComponentResult;
                            DanapolyBoardFragment.getAuthRequestContext(this.this$0, rollDiceSuccess.getAuthRequestContext);
                            DanapolyBoardFragment.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0, rollDiceSuccess.MyBillsEntityDataFactory);
                            DanapolyBoardFragment.MyBillsEntityDataFactory(this.this$0, rollDiceSuccess.MyBillsEntityDataFactory);
                            VB vb10 = this.this$0.PlaceComponentResult;
                            if (vb10 != 0) {
                                DanapolyBoardView danapolyBoardView3 = ((FragmentDanapolyBinding) vb10).BuiltInFictitiousFunctionClassFactory;
                                final DanapolyBoardFragment danapolyBoardFragment2 = this.this$0;
                                danapolyBoardView3.setOnShowRollDiceResult(new DanapolyBoardView.OnRollDiceShowListener() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$initViewModel$1$$ExternalSyntheticLambda0
                                    @Override // id.dana.danapoly.ui.board.view.DanapolyBoardView.OnRollDiceShowListener
                                    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                                        DanapolyBoardFragment$initViewModel$1.m727invokeSuspend$lambda1(DanapolyBoardFragment.this);
                                    }
                                });
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                } else {
                    VB vb11 = this.this$0.PlaceComponentResult;
                    if (vb11 != 0) {
                        ((FragmentDanapolyBinding) vb11).BuiltInFictitiousFunctionClassFactory.renderErrorState(true, DanapolyBoardView.BoardState.ERROR_BOARD);
                        this.this$0.KClassImpl$Data$declaredNonStaticMembers$2(true, false);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
            } else {
                VB vb12 = this.this$0.PlaceComponentResult;
                if (vb12 != 0) {
                    DanapolyBoardView danapolyBoardView4 = ((FragmentDanapolyBinding) vb12).BuiltInFictitiousFunctionClassFactory;
                    DanapolyBoardUiState.OnConfigurationLoaded onConfigurationLoaded = (DanapolyBoardUiState.OnConfigurationLoaded) danapolyBoardUiState;
                    danapolyBoardView4.loadBoard(onConfigurationLoaded.KClassImpl$Data$declaredNonStaticMembers$2.getBoards());
                    Intrinsics.checkNotNullExpressionValue(danapolyBoardView4, "");
                    DanapolyBoardView.renderErrorState$default(danapolyBoardView4, false, null, 2, null);
                    if (onConfigurationLoaded.getBuiltInFictitiousFunctionClassFactory()) {
                        danapolyBoardView4.showBoard();
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-1  reason: not valid java name */
    public static final void m727invokeSuspend$lambda1(DanapolyBoardFragment danapolyBoardFragment) {
        DanapolyAudioPlayer danapolyAudioPlayer;
        MediaPlayer mediaPlayer;
        DanapolyAudioPlayer danapolyAudioPlayer2 = ((BaseDanapolyAudioFragment) danapolyBoardFragment).MyBillsEntityDataFactory;
        if (danapolyAudioPlayer2 != null && (mediaPlayer = danapolyAudioPlayer2.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
            mediaPlayer.pause();
        }
        if (danapolyBoardFragment.getContext() == null || (danapolyAudioPlayer = danapolyBoardFragment.PlaceComponentResult) == null) {
            return;
        }
        danapolyAudioPlayer.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
