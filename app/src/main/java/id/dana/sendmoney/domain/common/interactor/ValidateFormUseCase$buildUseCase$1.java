package id.dana.sendmoney.domain.common.interactor;

import id.dana.sendmoney.domain.common.interactor.ValidateFormUseCase;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.domain.common.interactor.ValidateFormUseCase$buildUseCase$1", f = "ValidateFormUseCase.kt", i = {}, l = {34, 36}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class ValidateFormUseCase$buildUseCase$1 extends SuspendLambda implements Function2<FlowCollector<? super Map<String, ? extends String>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ValidateFormUseCase.Params $param;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValidateFormUseCase$buildUseCase$1(ValidateFormUseCase.Params params, Continuation<? super ValidateFormUseCase$buildUseCase$1> continuation) {
        super(2, continuation);
        this.$param = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ValidateFormUseCase$buildUseCase$1 validateFormUseCase$buildUseCase$1 = new ValidateFormUseCase$buildUseCase$1(this.$param, continuation);
        validateFormUseCase$buildUseCase$1.L$0 = obj;
        return validateFormUseCase$buildUseCase$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Map<String, ? extends String>> flowCollector, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super Map<String, String>>) flowCollector, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Map<String, String>> flowCollector, Continuation<? super Unit> continuation) {
        return ((ValidateFormUseCase$buildUseCase$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map<String, String> map = this.$param.getAuthRequestContext.MyBillsEntityDataFactory;
            ValidateFormUseCase.Params params = this.$param;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                List<Function1<String, Boolean>> list = params.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.get(key);
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        if ((!((Boolean) ((Function1) obj2).invoke(value)).booleanValue()) != false) {
                            break;
                        }
                    }
                    Function1 function1 = (Function1) obj2;
                    if (function1 != null) {
                        linkedHashMap.put(key, function1.toString());
                    }
                }
            }
            if (linkedHashMap.isEmpty()) {
                this.label = 1;
                if (flowCollector.emit(MapsKt.emptyMap(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.label = 2;
                if (flowCollector.emit(linkedHashMap, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1 || i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
