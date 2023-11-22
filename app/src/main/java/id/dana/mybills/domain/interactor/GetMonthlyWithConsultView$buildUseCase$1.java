package id.dana.mybills.domain.interactor;

import id.dana.analytics.executiontime.TrackerExecutionCounter;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.mybills.domain.model.MonthlyAmountWithConsultView;
import id.dana.mybills.domain.model.MyBillsHighlight;
import id.dana.mybills.domain.model.MyBillsMonthlyAmount;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lid/dana/mybills/domain/model/MyBillsMonthlyAmount;", "monthlyAmountResponse", "Lid/dana/mybills/domain/model/MyBillsHighlight;", "consultViewResponse", "Lid/dana/mybills/domain/model/MonthlyAmountWithConsultView;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.domain.interactor.GetMonthlyWithConsultView$buildUseCase$1", f = "GetMonthlyWithConsultView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class GetMonthlyWithConsultView$buildUseCase$1 extends SuspendLambda implements Function3<MyBillsMonthlyAmount, MyBillsHighlight, Continuation<? super MonthlyAmountWithConsultView>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ GetMonthlyWithConsultView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetMonthlyWithConsultView$buildUseCase$1(GetMonthlyWithConsultView getMonthlyWithConsultView, Continuation<? super GetMonthlyWithConsultView$buildUseCase$1> continuation) {
        super(3, continuation);
        this.this$0 = getMonthlyWithConsultView;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(MyBillsMonthlyAmount myBillsMonthlyAmount, MyBillsHighlight myBillsHighlight, Continuation<? super MonthlyAmountWithConsultView> continuation) {
        GetMonthlyWithConsultView$buildUseCase$1 getMonthlyWithConsultView$buildUseCase$1 = new GetMonthlyWithConsultView$buildUseCase$1(this.this$0, continuation);
        getMonthlyWithConsultView$buildUseCase$1.L$0 = myBillsMonthlyAmount;
        getMonthlyWithConsultView$buildUseCase$1.L$1 = myBillsHighlight;
        return getMonthlyWithConsultView$buildUseCase$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TrackerExecutionCounter trackerExecutionCounter;
        TrackerExecutionCounter trackerExecutionCounter2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MyBillsMonthlyAmount myBillsMonthlyAmount = (MyBillsMonthlyAmount) this.L$0;
            MyBillsHighlight myBillsHighlight = (MyBillsHighlight) this.L$1;
            trackerExecutionCounter = this.this$0.getAuthRequestContext;
            trackerExecutionCounter.initiateEndTime();
            FirebasePerformanceMonitor MyBillsEntityDataFactory = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
            trackerExecutionCounter2 = this.this$0.getAuthRequestContext;
            MyBillsEntityDataFactory.MyBillsEntityDataFactory("mybills_track_header_be_time", "Backend Execution Time Inquiry", trackerExecutionCounter2.getExecutionTime());
            return GetMonthlyWithConsultView.PlaceComponentResult(myBillsHighlight, myBillsMonthlyAmount);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
