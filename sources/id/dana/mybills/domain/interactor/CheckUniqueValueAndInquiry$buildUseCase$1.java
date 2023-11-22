package id.dana.mybills.domain.interactor;

import id.dana.mybills.domain.model.BizProductDestination;
import id.dana.mybills.domain.model.CheckUniqueValue;
import id.dana.mybills.domain.model.CheckUniqueValueAndInquiryResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lid/dana/mybills/domain/model/CheckUniqueValue;", "queryUniqueValue", "Lid/dana/mybills/domain/model/BizProductDestination;", "inquirySubscription", "Lid/dana/mybills/domain/model/CheckUniqueValueAndInquiryResult;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.domain.interactor.CheckUniqueValueAndInquiry$buildUseCase$1", f = "CheckUniqueValueAndInquiry.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class CheckUniqueValueAndInquiry$buildUseCase$1 extends SuspendLambda implements Function3<CheckUniqueValue, BizProductDestination, Continuation<? super CheckUniqueValueAndInquiryResult>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckUniqueValueAndInquiry$buildUseCase$1(Continuation<? super CheckUniqueValueAndInquiry$buildUseCase$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CheckUniqueValue checkUniqueValue, BizProductDestination bizProductDestination, Continuation<? super CheckUniqueValueAndInquiryResult> continuation) {
        CheckUniqueValueAndInquiry$buildUseCase$1 checkUniqueValueAndInquiry$buildUseCase$1 = new CheckUniqueValueAndInquiry$buildUseCase$1(continuation);
        checkUniqueValueAndInquiry$buildUseCase$1.L$0 = checkUniqueValue;
        checkUniqueValueAndInquiry$buildUseCase$1.L$1 = bizProductDestination;
        return checkUniqueValueAndInquiry$buildUseCase$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return new CheckUniqueValueAndInquiryResult((CheckUniqueValue) this.L$0, (BizProductDestination) this.L$1);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
