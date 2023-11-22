package id.dana.danapoly.ui.dailycheck;

import android.content.Intent;
import id.dana.danapoly.ui.dailycheck.adapter.DailyCheckAdapter;
import id.dana.danapoly.ui.dailycheck.adapter.DailyCheckItemState;
import id.dana.danapoly.ui.dailycheck.viewmodel.DailyCheckUiState;
import id.dana.danapoly.ui.model.DailyCheckItemModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danapoly.ui.dailycheck.DailyCheckActivity$initViewModel$1", f = "DailyCheckActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class DailyCheckActivity$initViewModel$1 extends SuspendLambda implements Function2<DailyCheckUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DailyCheckActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyCheckActivity$initViewModel$1(DailyCheckActivity dailyCheckActivity, Continuation<? super DailyCheckActivity$initViewModel$1> continuation) {
        super(2, continuation);
        this.this$0 = dailyCheckActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DailyCheckActivity$initViewModel$1 dailyCheckActivity$initViewModel$1 = new DailyCheckActivity$initViewModel$1(this.this$0, continuation);
        dailyCheckActivity$initViewModel$1.L$0 = obj;
        return dailyCheckActivity$initViewModel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DailyCheckUiState dailyCheckUiState, Continuation<? super Unit> continuation) {
        return ((DailyCheckActivity$initViewModel$1) create(dailyCheckUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        DailyCheckAdapter dailyCheckAdapter;
        DailyCheckAdapter dailyCheckAdapter2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DailyCheckUiState dailyCheckUiState = (DailyCheckUiState) this.L$0;
            int i2 = 0;
            boolean z = true;
            if (dailyCheckUiState instanceof DailyCheckUiState.OnGetCheckInHistorySuccess) {
                dailyCheckAdapter2 = this.this$0.PlaceComponentResult;
                DailyCheckUiState.OnGetCheckInHistorySuccess onGetCheckInHistorySuccess = (DailyCheckUiState.OnGetCheckInHistorySuccess) dailyCheckUiState;
                List<DailyCheckItemModel> list = onGetCheckInHistorySuccess.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullParameter(list, "");
                dailyCheckAdapter2.KClassImpl$Data$declaredNonStaticMembers$2 = list;
                dailyCheckAdapter2.notifyDataSetChanged();
                DailyCheckActivity dailyCheckActivity = this.this$0;
                List<DailyCheckItemModel> list2 = onGetCheckInHistorySuccess.BuiltInFictitiousFunctionClassFactory;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        if (((DailyCheckItemModel) it.next()).isActive()) {
                            break;
                        }
                    }
                }
                z = false;
                dailyCheckActivity.PlaceComponentResult(z);
                DailyCheckActivity.access$renderErrorState(this.this$0, false);
            } else if (dailyCheckUiState instanceof DailyCheckUiState.OnGetCheckInHistoryError) {
                DailyCheckActivity.access$renderErrorState(this.this$0, true);
            } else if (dailyCheckUiState instanceof DailyCheckUiState.OnDoCheckInComplete) {
                if (((DailyCheckUiState.OnDoCheckInComplete) dailyCheckUiState).getGetAuthRequestContext()) {
                    DailyCheckActivity dailyCheckActivity2 = this.this$0;
                    i = dailyCheckActivity2.MyBillsEntityDataFactory;
                    dailyCheckAdapter = this.this$0.PlaceComponentResult;
                    Iterator<DailyCheckItemModel> it2 = dailyCheckAdapter.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            i3 = -1;
                            break;
                        }
                        if (it2.next().getState() == DailyCheckItemState.ACTIVE) {
                            break;
                        }
                        i3++;
                    }
                    if (i3 != -1) {
                        dailyCheckAdapter.KClassImpl$Data$declaredNonStaticMembers$2.get(i3).setState(DailyCheckItemState.COMPLETED);
                        dailyCheckAdapter.notifyItemChanged(i3);
                        i2 = dailyCheckAdapter.KClassImpl$Data$declaredNonStaticMembers$2.get(i3).getPoint();
                    }
                    DailyCheckActivity.access$setPoint(dailyCheckActivity2, i + i2);
                    DailyCheckActivity dailyCheckActivity3 = this.this$0;
                    Intent intent = new Intent();
                    intent.putExtra(DailyCheckActivity.BUNDLE_SHOULD_REFRESH_CHECK_IN, true);
                    Unit unit = Unit.INSTANCE;
                    dailyCheckActivity3.setResult(-1, intent);
                } else {
                    DailyCheckActivity.access$showErrorToast(this.this$0);
                }
                this.this$0.PlaceComponentResult(!r11.getGetAuthRequestContext());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
