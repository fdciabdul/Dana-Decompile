package id.dana.danapoly.ui.leaderboard;

import id.dana.danapoly.databinding.FragmentLeaderboardBinding;
import id.dana.danapoly.ui.leaderboard.adapter.LeaderboardAdapter;
import id.dana.danapoly.ui.leaderboard.view.CountDownView;
import id.dana.danapoly.ui.leaderboard.viewmodel.LeaderboardUiState;
import id.dana.danapoly.ui.leaderboard.viewmodel.LeaderboardViewModel;
import id.dana.danapoly.ui.model.leaderboard.LeaderboardModel;
import id.dana.danapoly.ui.model.leaderboard.PrizeInfoModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danapoly.ui.leaderboard.LeaderboardFragment$initViewModel$1", f = "LeaderboardFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class LeaderboardFragment$initViewModel$1 extends SuspendLambda implements Function2<LeaderboardUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LeaderboardFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeaderboardFragment$initViewModel$1(LeaderboardFragment leaderboardFragment, Continuation<? super LeaderboardFragment$initViewModel$1> continuation) {
        super(2, continuation);
        this.this$0 = leaderboardFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LeaderboardFragment$initViewModel$1 leaderboardFragment$initViewModel$1 = new LeaderboardFragment$initViewModel$1(this.this$0, continuation);
        leaderboardFragment$initViewModel$1.L$0 = obj;
        return leaderboardFragment$initViewModel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LeaderboardUiState leaderboardUiState, Continuation<? super Unit> continuation) {
        return ((LeaderboardFragment$initViewModel$1) create(leaderboardUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List authRequestContext;
        LeaderboardAdapter leaderboardAdapter;
        LeaderboardAdapter leaderboardAdapter2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LeaderboardUiState leaderboardUiState = (LeaderboardUiState) this.L$0;
            if (!(leaderboardUiState instanceof LeaderboardUiState.OnFetchLeaderboardSuccess)) {
                if (leaderboardUiState instanceof LeaderboardUiState.OnFetchLeaderboardFailed) {
                    LeaderboardFragment.getAuthRequestContext(this.this$0);
                    authRequestContext = LeaderboardViewModel.getAuthRequestContext(0);
                    VB vb = this.this$0.PlaceComponentResult;
                    if (vb != 0) {
                        List list = authRequestContext;
                        ((FragmentLeaderboardBinding) vb).BuiltInFictitiousFunctionClassFactory.setLeaderboard(CollectionsKt.take(list, 3));
                        leaderboardAdapter = this.this$0.getAuthRequestContext;
                        List<LeaderboardModel> drop = CollectionsKt.drop(list, 3);
                        Intrinsics.checkNotNullParameter(drop, "");
                        leaderboardAdapter.MyBillsEntityDataFactory = drop;
                        leaderboardAdapter.notifyDataSetChanged();
                        VB vb2 = this.this$0.PlaceComponentResult;
                        if (vb2 != 0) {
                            CountDownView countDownView = ((FragmentLeaderboardBinding) vb2).getAuthRequestContext;
                            Intrinsics.checkNotNullExpressionValue(countDownView, "");
                            CountDownView.setCountdown$default(countDownView, null, 1, null);
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
            } else {
                VB vb3 = this.this$0.PlaceComponentResult;
                if (vb3 != 0) {
                    LeaderboardUiState.OnFetchLeaderboardSuccess onFetchLeaderboardSuccess = (LeaderboardUiState.OnFetchLeaderboardSuccess) leaderboardUiState;
                    ((FragmentLeaderboardBinding) vb3).BuiltInFictitiousFunctionClassFactory.setLeaderboard(CollectionsKt.take(onFetchLeaderboardSuccess.MyBillsEntityDataFactory, 3));
                    leaderboardAdapter2 = this.this$0.getAuthRequestContext;
                    List<LeaderboardModel> drop2 = CollectionsKt.drop(onFetchLeaderboardSuccess.MyBillsEntityDataFactory, 3);
                    Intrinsics.checkNotNullParameter(drop2, "");
                    leaderboardAdapter2.MyBillsEntityDataFactory = drop2;
                    leaderboardAdapter2.notifyDataSetChanged();
                    VB vb4 = this.this$0.PlaceComponentResult;
                    if (vb4 != 0) {
                        ((FragmentLeaderboardBinding) vb4).getAuthRequestContext.setCountdown(onFetchLeaderboardSuccess.BuiltInFictitiousFunctionClassFactory);
                        PrizeInfoModel prizeInfoModel = onFetchLeaderboardSuccess.getAuthRequestContext;
                        if (prizeInfoModel != null) {
                            LeaderboardFragment.BuiltInFictitiousFunctionClassFactory(this.this$0, prizeInfoModel);
                        }
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
