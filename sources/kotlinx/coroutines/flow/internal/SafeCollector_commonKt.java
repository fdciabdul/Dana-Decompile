package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\b\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0080\u0010¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "Lkotlin/coroutines/CoroutineContext;", "currentContext", "", "checkContext", "(Lkotlinx/coroutines/flow/internal/SafeCollector;Lkotlin/coroutines/CoroutineContext;)V", "Lkotlinx/coroutines/Job;", "collectJob", "transitiveCoroutineParent", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/Job;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SafeCollector_commonKt {
    public static final void checkContext(final SafeCollector<?> safeCollector, CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.fold(0, new Function2<Integer, CoroutineContext.Element, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$checkContext$result$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Integer invoke(Integer num, CoroutineContext.Element element) {
                return invoke(num.intValue(), element);
            }

            public final Integer invoke(int i, CoroutineContext.Element element) {
                CoroutineContext.Key<?> key = element.getKey();
                CoroutineContext.Element element2 = safeCollector.collectContext.get(key);
                if (key != Job.INSTANCE) {
                    return Integer.valueOf(element != element2 ? Integer.MIN_VALUE : i + 1);
                }
                Job job = (Job) element2;
                Job transitiveCoroutineParent = SafeCollector_commonKt.transitiveCoroutineParent((Job) element, job);
                if (transitiveCoroutineParent != job) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of ");
                    sb.append(transitiveCoroutineParent);
                    sb.append(", expected child of ");
                    sb.append(job);
                    sb.append(".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'");
                    throw new IllegalStateException(sb.toString().toString());
                }
                if (job != null) {
                    i++;
                }
                return Integer.valueOf(i);
            }
        })).intValue() == safeCollector.collectContextSize) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Flow invariant is violated:\n\t\tFlow was collected in ");
        sb.append(safeCollector.collectContext);
        sb.append(",\n\t\tbut emission happened in ");
        sb.append(coroutineContext);
        sb.append(".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead");
        throw new IllegalStateException(sb.toString().toString());
    }

    public static final Job transitiveCoroutineParent(Job job, Job job2) {
        while (job != null) {
            if (job == job2 || !(job instanceof ScopeCoroutine)) {
                return job;
            }
            job = ((ScopeCoroutine) job).getParent$kotlinx_coroutines_core();
        }
        return null;
    }
}
