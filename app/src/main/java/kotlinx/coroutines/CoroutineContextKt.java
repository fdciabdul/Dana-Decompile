package kotlinx.coroutines;

import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\u0007\u001a\u00020\u0003*\u00020\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\n\u001a\u00020\u0000*\u00020\f2\u0006\u0010\r\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000e\u001a\u001a\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u00020\u000fH\u0080\u0010¢\u0006\u0004\b\u0011\u0010\u0012\u001a/\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\r\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\"\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u0018*\u00020\u00008AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "originalContext", "appendContext", "", "isNewCoroutine", "foldCopies", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Z)Lkotlin/coroutines/CoroutineContext;", "hasCopyableElements", "(Lkotlin/coroutines/CoroutineContext;)Z", "addedContext", "newCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/CoroutineScope;", HummerConstants.CONTEXT, "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/UndispatchedCoroutine;", "undispatchedCompletion", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlinx/coroutines/UndispatchedCoroutine;", "Lkotlin/coroutines/Continuation;", "", "oldValue", "updateUndispatchedCompletion", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)Lkotlinx/coroutines/UndispatchedCoroutine;", "", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "coroutineName"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CoroutineContextKt {
    public static final CoroutineContext newCoroutineContext(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext foldCopies = foldCopies(coroutineScope.getPlaceComponentResult(), coroutineContext, true);
        CoroutineContext plus = DebugKt.getDEBUG() ? foldCopies.plus(new CoroutineId(DebugKt.getCOROUTINE_ID().incrementAndGet())) : foldCopies;
        return (foldCopies == Dispatchers.getDefault() || foldCopies.get(ContinuationInterceptor.INSTANCE) != null) ? plus : plus.plus(Dispatchers.getDefault());
    }

    public static final CoroutineContext newCoroutineContext(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        return !hasCopyableElements(coroutineContext2) ? coroutineContext.plus(coroutineContext2) : foldCopies(coroutineContext, coroutineContext2, false);
    }

    private static final boolean hasCopyableElements(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.fold(Boolean.FALSE, new Function2<Boolean, CoroutineContext.Element, Boolean>() { // from class: kotlinx.coroutines.CoroutineContextKt$hasCopyableElements$1
            public final Boolean invoke(boolean z, CoroutineContext.Element element) {
                return Boolean.valueOf(z || (element instanceof CopyableThreadContextElement));
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Boolean invoke(Boolean bool, CoroutineContext.Element element) {
                return invoke(bool.booleanValue(), element);
            }
        })).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [T, java.lang.Object] */
    private static final CoroutineContext foldCopies(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, final boolean z) {
        boolean hasCopyableElements = hasCopyableElements(coroutineContext);
        boolean hasCopyableElements2 = hasCopyableElements(coroutineContext2);
        if (!hasCopyableElements && !hasCopyableElements2) {
            return coroutineContext.plus(coroutineContext2);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = coroutineContext2;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(EmptyCoroutineContext.INSTANCE, new Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$folded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.coroutines.CoroutineContext] */
            @Override // kotlin.jvm.functions.Function2
            public final CoroutineContext invoke(CoroutineContext coroutineContext4, CoroutineContext.Element element) {
                if (element instanceof CopyableThreadContextElement) {
                    CoroutineContext.Element element2 = objectRef.element.get(element.getKey());
                    if (element2 == null) {
                        CopyableThreadContextElement copyableThreadContextElement = (CopyableThreadContextElement) element;
                        if (z) {
                            copyableThreadContextElement = copyableThreadContextElement.copyForChild();
                        }
                        return coroutineContext4.plus(copyableThreadContextElement);
                    }
                    Ref.ObjectRef<CoroutineContext> objectRef2 = objectRef;
                    objectRef2.element = objectRef2.element.minusKey(element.getKey());
                    return coroutineContext4.plus(((CopyableThreadContextElement) element).mergeForChild(element2));
                }
                return coroutineContext4.plus(element);
            }
        });
        if (hasCopyableElements2) {
            objectRef.element = ((CoroutineContext) objectRef.element).fold(EmptyCoroutineContext.INSTANCE, new Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$1
                @Override // kotlin.jvm.functions.Function2
                public final CoroutineContext invoke(CoroutineContext coroutineContext4, CoroutineContext.Element element) {
                    if (element instanceof CopyableThreadContextElement) {
                        return coroutineContext4.plus(((CopyableThreadContextElement) element).copyForChild());
                    }
                    return coroutineContext4.plus(element);
                }
            });
        }
        return coroutineContext3.plus((CoroutineContext) objectRef.element);
    }

    public static final UndispatchedCoroutine<?> updateUndispatchedCompletion(Continuation<?> continuation, CoroutineContext coroutineContext, Object obj) {
        if (continuation instanceof CoroutineStackFrame) {
            if (coroutineContext.get(UndispatchedMarker.INSTANCE) != null) {
                UndispatchedCoroutine<?> undispatchedCompletion = undispatchedCompletion((CoroutineStackFrame) continuation);
                if (undispatchedCompletion != null) {
                    undispatchedCompletion.saveThreadContext(coroutineContext, obj);
                }
                return undispatchedCompletion;
            }
            return null;
        }
        return null;
    }

    public static final UndispatchedCoroutine<?> undispatchedCompletion(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof DispatchedCoroutine) && (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) {
            if (coroutineStackFrame instanceof UndispatchedCoroutine) {
                return (UndispatchedCoroutine) coroutineStackFrame;
            }
        }
        return null;
    }

    @JvmName(name = "getCoroutineName")
    public static final String getCoroutineName(CoroutineContext coroutineContext) {
        CoroutineId coroutineId;
        String str;
        if (DebugKt.getDEBUG() && (coroutineId = (CoroutineId) coroutineContext.get(CoroutineId.INSTANCE)) != null) {
            CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.INSTANCE);
            if (coroutineName == null || (str = coroutineName.getName()) == null) {
                str = "coroutine";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append('#');
            sb.append(coroutineId.getId());
            return sb.toString();
        }
        return null;
    }
}
