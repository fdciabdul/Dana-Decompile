package kotlinx.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.ocr.model.SnapReceiptBroadcastData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectInstance;

@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006¸\u0001¹\u0001º\u0001B\u0012\u0012\u0007\u0010µ\u0001\u001a\u00020\u000b¢\u0006\u0006\b¶\u0001\u0010·\u0001J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001dJ\u001f\u0010\"\u001a\u00020\u00122\u000e\u0010!\u001a\n\u0018\u00010\u001fj\u0004\u0018\u0001` H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b$\u0010%J\u0019\u0010&\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000eH\u0002¢\u0006\u0004\b,\u0010%J\u000f\u0010.\u001a\u00020-H\u0014¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b0\u0010%J!\u00103\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b3\u00104J)\u00109\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u0002052\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b;\u0010<J#\u0010=\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u0002052\b\u00108\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b=\u0010>J\u0019\u0010?\u001a\u0004\u0018\u0001062\u0006\u0010\u0015\u001a\u000201H\u0002¢\u0006\u0004\b?\u0010@J\u0011\u0010A\u001a\u00060\u001fj\u0002` ¢\u0006\u0004\bA\u0010BJ\u0013\u0010C\u001a\u00060\u001fj\u0002` H\u0016¢\u0006\u0004\bC\u0010BJ\u0011\u0010D\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bD\u0010EJ'\u0010F\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u0002052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002¢\u0006\u0004\bF\u0010GJ\u0019\u0010H\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u000201H\u0002¢\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u000eH\u0014¢\u0006\u0004\bK\u0010%J\u0017\u0010L\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u000eH\u0010¢\u0006\u0004\bL\u0010)J\u0019\u0010N\u001a\u00020\u00122\b\u0010M\u001a\u0004\u0018\u00010\u0001H\u0004¢\u0006\u0004\bN\u0010OJ<\u0010W\u001a\u00020V2\u0006\u0010P\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u000b2\u001d\u0010U\u001a\u0019\u0012\u000b\u0012\t\u0018\u00010\u000e¢\u0006\u0002\bS\u0012\u0004\u0012\u00020\u00120Rj\u0002`T¢\u0006\u0004\bW\u0010XJ,\u0010W\u001a\u00020V2\u001d\u0010U\u001a\u0019\u0012\u000b\u0012\t\u0018\u00010\u000e¢\u0006\u0002\bS\u0012\u0004\u0012\u00020\u00120Rj\u0002`T¢\u0006\u0004\bW\u0010YJ\u0013\u0010Z\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0004\bZ\u0010\u001dJ\u000f\u0010[\u001a\u00020\u000bH\u0002¢\u0006\u0004\b[\u0010\\J\u0013\u0010]\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0004\b]\u0010\u001dJ\u001b\u0010^\u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b^\u0010+J\u0019\u0010_\u001a\u00020\u000b2\b\u00108\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b_\u0010'J\u001b\u0010`\u001a\u0004\u0018\u00010\u00052\b\u00108\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b`\u0010+J6\u0010a\u001a\u00020\t2\u001d\u0010U\u001a\u0019\u0012\u000b\u0012\t\u0018\u00010\u000e¢\u0006\u0002\bS\u0012\u0004\u0012\u00020\u00120Rj\u0002`T2\u0006\u0010P\u001a\u00020\u000bH\u0002¢\u0006\u0004\ba\u0010bJ\u000f\u0010c\u001a\u00020-H\u0010¢\u0006\u0004\bc\u0010/J\u001f\u0010d\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000eH\u0002¢\u0006\u0004\bd\u0010eJ\u0019\u0010P\u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\bP\u0010)J\u0019\u0010f\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\bf\u0010\u0017J\u000f\u0010g\u001a\u00020\u0012H\u0014¢\u0006\u0004\bg\u0010hJ\u0015\u0010j\u001a\u00020\u00122\u0006\u0010i\u001a\u00020\u0003¢\u0006\u0004\bj\u0010kJ\u0017\u0010m\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020lH\u0002¢\u0006\u0004\bm\u0010nJ\u0017\u0010o\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\bo\u0010pJB\u0010v\u001a\u00020\u0012\"\u0004\b\u0000\u0010q2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000r2\u001c\u0010u\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000t\u0012\u0006\u0012\u0004\u0018\u00010\u00050Rø\u0001\u0000¢\u0006\u0004\bv\u0010wJP\u0010z\u001a\u00020\u0012\"\u0004\b\u0000\u0010x\"\u0004\b\u0001\u0010q2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00010r2\"\u0010u\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010t\u0012\u0006\u0012\u0004\u0018\u00010\u00050yH\u0000ø\u0001\u0000¢\u0006\u0004\bz\u0010{J\u0017\u0010|\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b|\u0010pJP\u0010}\u001a\u00020\u0012\"\u0004\b\u0000\u0010x\"\u0004\b\u0001\u0010q2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00010r2\"\u0010u\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010t\u0012\u0006\u0012\u0004\u0018\u00010\u00050yH\u0000ø\u0001\u0000¢\u0006\u0004\b}\u0010{J\r\u0010~\u001a\u00020\u000b¢\u0006\u0004\b~\u0010\\J\u001c\u0010\u0080\u0001\u001a\u00020\u007f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001c\u0010\u0082\u0001\u001a\u00020-2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u000f\u0010\u0084\u0001\u001a\u00020-¢\u0006\u0005\b\u0084\u0001\u0010/J\u0011\u0010\u0085\u0001\u001a\u00020-H\u0016¢\u0006\u0005\b\u0085\u0001\u0010/J$\u0010\u0086\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\"\u0010\u0088\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u0002012\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J(\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u00108\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J&\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u0002012\b\u00108\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J-\u0010\u008e\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u0002052\u0006\u0010\u0018\u001a\u0002062\b\u00108\u001a\u0004\u0018\u00010\u0005H\u0082\u0010¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0019\u0010\u0091\u0001\u001a\u0004\u0018\u000106*\u00030\u0090\u0001H\u0002¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u001f\u0010\u0093\u0001\u001a\u00020\u0012*\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0005\b\u0093\u0001\u0010eJ'\u0010\u0095\u0001\u001a\u00060\u001fj\u0002` *\u00020\u000e2\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010-H\u0004¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001b\u0010\u009a\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010\u0097\u00018G¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0019\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u000e8EX\u0084\u0004¢\u0006\b\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0016\u0010\u009f\u0001\u001a\u00020\u000b8EX\u0084\u0004¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010\\R\u0016\u0010¡\u0001\u001a\u00020\u000b8QX\u0090\u0004¢\u0006\u0007\u001a\u0005\b \u0001\u0010\\R\u0016\u0010¢\u0001\u001a\u00020\u000b8WX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010\\R\u0013\u0010£\u0001\u001a\u00020\u000b8G¢\u0006\u0007\u001a\u0005\b£\u0001\u0010\\R\u0013\u0010¤\u0001\u001a\u00020\u000b8G¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010\\R\u0016\u0010¥\u0001\u001a\u00020\u000b8UX\u0094\u0004¢\u0006\u0007\u001a\u0005\b¥\u0001\u0010\\R\u0019\u0010©\u0001\u001a\u0007\u0012\u0002\b\u00030¦\u00018G¢\u0006\b\u001a\u0006\b§\u0001\u0010¨\u0001R\u0016\u0010«\u0001\u001a\u00020\u000b8QX\u0090\u0004¢\u0006\u0007\u001a\u0005\bª\u0001\u0010\\R.\u0010±\u0001\u001a\u0004\u0018\u00010\u00192\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u00198A@AX\u0080\u000e¢\u0006\u0010\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00058AX\u0080\u0004¢\u0006\u0007\u001a\u0005\b²\u0001\u0010ER\u001e\u0010´\u0001\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u00058CX\u0082\u0004¢\u0006\u0007\u001a\u0005\b³\u0001\u0010<\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/selects/SelectClause0;", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSuspend", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "(Ljava/lang/Throwable;)Z", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "parent", "initParentJob", "(Lkotlinx/coroutines/Job;)V", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompletingOnce$kotlinx_coroutines_core", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "onCompletionInternal", "onStart", "()V", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "T", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "removeNode$kotlinx_coroutines_core", "selectAwaitCompletion$kotlinx_coroutines_core", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "message", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "()Ljava/lang/Throwable;", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "active", "<init>", "(Z)V", "AwaitContinuation", "ChildCompletion", "Finishing"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class JobSupport implements Job, ChildJob, ParentJob, SelectClause0 {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    public void afterCompletion(Object state) {
    }

    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    @JvmName(name = "getHandlesException$kotlinx_coroutines_core")
    /* renamed from: getHandlesException$kotlinx_coroutines_core */
    public boolean getHandlesException() {
        return true;
    }

    @JvmName(name = "getOnCancelComplete$kotlinx_coroutines_core")
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    protected boolean handleJobException(Throwable exception) {
        return false;
    }

    @JvmName(name = "isScopedCoroutine")
    protected boolean isScopedCoroutine() {
        return false;
    }

    protected void onCancelling(Throwable cause) {
    }

    protected void onCompletionInternal(Object state) {
    }

    protected void onStart() {
    }

    public JobSupport(boolean z) {
        this._state = z ? JobSupportKt.EMPTY_ACTIVE : JobSupportKt.EMPTY_NEW;
        this._parentHandle = null;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel(null);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) Job.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) Job.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return Job.DefaultImpls.plus(this, coroutineContext);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    @JvmName(name = "getKey")
    public final CoroutineContext.Key<?> getKey() {
        return Job.INSTANCE;
    }

    @JvmName(name = "getParentHandle$kotlinx_coroutines_core")
    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle) this._parentHandle;
    }

    @JvmName(name = "setParentHandle$kotlinx_coroutines_core")
    public final void setParentHandle$kotlinx_coroutines_core(ChildHandle childHandle) {
        this._parentHandle = childHandle;
    }

    public final void initParentJob(Job parent) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getParentHandle$kotlinx_coroutines_core() == null)) {
                throw new AssertionError();
            }
        }
        if (parent == null) {
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
            return;
        }
        parent.start();
        ChildHandle attachChild = parent.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(attachChild);
        if (isCompleted()) {
            attachChild.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
    }

    @Override // kotlinx.coroutines.Job
    @JvmName(name = "isActive")
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).getIsActive();
    }

    @Override // kotlinx.coroutines.Job
    @JvmName(name = "isCompleted")
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    @Override // kotlinx.coroutines.Job
    @JvmName(name = "isCancelled")
    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof CompletedExceptionally) || ((state$kotlinx_coroutines_core instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core).isCancelling());
    }

    private final Object finalizeFinishingState(Finishing state, Object proposedUpdate) {
        boolean isCancelling;
        Throwable finalRootCause;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getState$kotlinx_coroutines_core() == state)) {
                throw new AssertionError();
            }
        }
        if (!DebugKt.getASSERTIONS_ENABLED() || (!state.isSealed()) == true) {
            if (!DebugKt.getASSERTIONS_ENABLED() || state.isCompleting()) {
                DefaultConstructorMarker defaultConstructorMarker = null;
                CompletedExceptionally completedExceptionally = proposedUpdate instanceof CompletedExceptionally ? (CompletedExceptionally) proposedUpdate : null;
                Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
                synchronized (state) {
                    isCancelling = state.isCancelling();
                    List<Throwable> sealLocked = state.sealLocked(th);
                    finalRootCause = getFinalRootCause(state, sealLocked);
                    if (finalRootCause != null) {
                        addSuppressedExceptions(finalRootCause, sealLocked);
                    }
                }
                if (finalRootCause != null && finalRootCause != th) {
                    proposedUpdate = new CompletedExceptionally(finalRootCause, r1, 2, defaultConstructorMarker);
                }
                if (finalRootCause != null) {
                    if (cancelParent(finalRootCause) || handleJobException(finalRootCause)) {
                        if (proposedUpdate == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                        }
                        ((CompletedExceptionally) proposedUpdate).makeHandled();
                    }
                }
                if (!isCancelling) {
                    onCancelling(finalRootCause);
                }
                onCompletionInternal(proposedUpdate);
                boolean MyBillsEntityDataFactory = AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, state, JobSupportKt.boxIncomplete(proposedUpdate));
                if (!DebugKt.getASSERTIONS_ENABLED() || MyBillsEntityDataFactory) {
                    completeStateFinalization(state, proposedUpdate);
                    return proposedUpdate;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private final Throwable getFinalRootCause(Finishing state, List<? extends Throwable> exceptions) {
        Object obj;
        Object obj2 = null;
        if (exceptions.isEmpty()) {
            if (state.isCancelling()) {
                return new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            return null;
        }
        List<? extends Throwable> list = exceptions;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if ((!(((Throwable) obj) instanceof CancellationException)) != false) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = exceptions.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th3 = (Throwable) next;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final void addSuppressedExceptions(Throwable rootCause, List<? extends Throwable> exceptions) {
        if (exceptions.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(exceptions.size()));
        Throwable unwrapImpl = !DebugKt.getRECOVER_STACK_TRACES() ? rootCause : StackTraceRecoveryKt.unwrapImpl(rootCause);
        for (Throwable th : exceptions) {
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                th = StackTraceRecoveryKt.unwrapImpl(th);
            }
            if (th != rootCause && th != unwrapImpl && !(th instanceof CancellationException) && newSetFromMap.add(th)) {
                kotlin.ExceptionsKt.addSuppressed(rootCause, th);
            }
        }
    }

    private final boolean tryFinalizeSimpleState(Incomplete state, Object update) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!((state instanceof Empty) || (state instanceof JobNode))) {
                throw new AssertionError();
            }
        }
        if (!DebugKt.getASSERTIONS_ENABLED() || (!(update instanceof CompletedExceptionally)) == true) {
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, state, JobSupportKt.boxIncomplete(update))) {
                onCancelling(null);
                onCompletionInternal(update);
                completeStateFinalization(state, update);
                return true;
            }
            return false;
        }
        throw new AssertionError();
    }

    private final void completeStateFinalization(Incomplete state, Object update) {
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
        CompletedExceptionally completedExceptionally = update instanceof CompletedExceptionally ? (CompletedExceptionally) update : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        if (state instanceof JobNode) {
            try {
                ((JobNode) state).invoke(th);
                return;
            } catch (Throwable th2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Exception in completion handler ");
                sb.append(state);
                sb.append(" for ");
                sb.append(this);
                handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException(sb.toString(), th2));
                return;
            }
        }
        NodeList list = state.getList();
        if (list != null) {
            notifyCompletion(list, th);
        }
    }

    private final void notifyCancelling(NodeList list, Throwable cause) {
        onCancelling(cause);
        NodeList nodeList = list;
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList.getNext(); !Intrinsics.areEqual(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.invoke(cause);
                } catch (Throwable th) {
                    CompletionHandlerException completionHandlerException2 = completionHandlerException;
                    if (completionHandlerException2 != null) {
                        kotlin.ExceptionsKt.addSuppressed(completionHandlerException2, th);
                        if (completionHandlerException2 != null) {
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Exception in completion handler ");
                    sb.append(jobNode);
                    sb.append(" for ");
                    sb.append(this);
                    CompletionHandlerException completionHandlerException3 = new CompletionHandlerException(sb.toString(), th);
                    Unit unit = Unit.INSTANCE;
                    completionHandlerException = completionHandlerException3;
                }
            }
        }
        CompletionHandlerException completionHandlerException4 = completionHandlerException;
        if (completionHandlerException4 != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException4);
        }
        cancelParent(cause);
    }

    private final boolean cancelParent(Throwable cause) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z = cause instanceof CancellationException;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        return (parentHandle$kotlinx_coroutines_core == null || parentHandle$kotlinx_coroutines_core == NonDisposableHandle.INSTANCE) ? z : parentHandle$kotlinx_coroutines_core.childCancelled(cause) || z;
    }

    private final int startInternal(Object state) {
        Empty empty;
        if (state instanceof Empty) {
            if (((Empty) state).getIsActive()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            empty = JobSupportKt.EMPTY_ACTIVE;
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(atomicReferenceFieldUpdater, this, state, empty)) {
                onStart();
                return 1;
            }
            return -1;
        } else if (state instanceof InactiveNodeList) {
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, state, ((InactiveNodeList) state).getList())) {
                onStart();
                return 1;
            }
            return -1;
        } else {
            return 0;
        }
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            Throwable rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
            if (rootCause != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(DebugStringsKt.getClassSimpleName(this));
                sb.append(" is cancelling");
                CancellationException cancellationException = toCancellationException(rootCause, sb.toString());
                if (cancellationException != null) {
                    return cancellationException;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Job is still new or active: ");
            sb2.append(this);
            throw new IllegalStateException(sb2.toString().toString());
        } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Job is still new or active: ");
            sb3.append(this);
            throw new IllegalStateException(sb3.toString().toString());
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return toCancellationException$default(this, ((CompletedExceptionally) state$kotlinx_coroutines_core).cause, null, 1, null);
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(DebugStringsKt.getClassSimpleName(this));
            sb4.append(" has completed normally");
            return new JobCancellationException(sb4.toString(), null, this);
        }
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable th, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return jobSupport.toCancellationException(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    protected final CancellationException toCancellationException(Throwable th, String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = cancellationExceptionMessage();
            }
            return new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    @JvmName(name = "getCompletionCause")
    public final Throwable getCompletionCause() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            Throwable rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
            if (rootCause != null) {
                return rootCause;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Job is still new or active: ");
            sb.append(this);
            throw new IllegalStateException(sb.toString().toString());
        } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Job is still new or active: ");
            sb2.append(this);
            throw new IllegalStateException(sb2.toString().toString());
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else {
            return null;
        }
    }

    @JvmName(name = "getCompletionCauseHandled")
    public final boolean getCompletionCauseHandled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof CompletedExceptionally) && ((CompletedExceptionally) state$kotlinx_coroutines_core).getHandled();
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> handler) {
        return invokeOnCompletion(false, true, handler);
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler) {
        JobNode makeNode = makeNode(handler, onCancelling);
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Empty) {
                Empty empty = (Empty) state$kotlinx_coroutines_core;
                if (empty.getIsActive()) {
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, state$kotlinx_coroutines_core, makeNode)) {
                        return makeNode;
                    }
                } else {
                    promoteEmptyToNodeList(empty);
                }
            } else {
                if (state$kotlinx_coroutines_core instanceof Incomplete) {
                    NodeList list = ((Incomplete) state$kotlinx_coroutines_core).getList();
                    if (list != null) {
                        DisposableHandle disposableHandle = NonDisposableHandle.INSTANCE;
                        if (onCancelling && (state$kotlinx_coroutines_core instanceof Finishing)) {
                            synchronized (state$kotlinx_coroutines_core) {
                                r3 = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
                                if (r3 == null || ((handler instanceof ChildHandleNode) && !((Finishing) state$kotlinx_coroutines_core).isCompleting())) {
                                    if (addLastAtomic(state$kotlinx_coroutines_core, list, makeNode)) {
                                        if (r3 == null) {
                                            return makeNode;
                                        }
                                        disposableHandle = makeNode;
                                    }
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                        }
                        if (r3 != null) {
                            if (invokeImmediately) {
                                handler.invoke(r3);
                            }
                            return disposableHandle;
                        } else if (addLastAtomic(state$kotlinx_coroutines_core, list, makeNode)) {
                            return makeNode;
                        }
                    } else if (state$kotlinx_coroutines_core == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    } else {
                        promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
                    }
                } else {
                    if (invokeImmediately) {
                        CompletedExceptionally completedExceptionally = state$kotlinx_coroutines_core instanceof CompletedExceptionally ? (CompletedExceptionally) state$kotlinx_coroutines_core : null;
                        handler.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
                    }
                    return NonDisposableHandle.INSTANCE;
                }
            }
        }
    }

    private final JobNode makeNode(Function1<? super Throwable, Unit> handler, boolean onCancelling) {
        InvokeOnCompletion invokeOnCompletion;
        if (onCancelling) {
            invokeOnCompletion = handler instanceof JobCancellingNode ? (JobCancellingNode) handler : null;
            if (invokeOnCompletion == null) {
                invokeOnCompletion = new InvokeOnCancelling(handler);
            }
            invokeOnCompletion = invokeOnCompletion;
        } else {
            invokeOnCompletion = handler instanceof JobNode ? (JobNode) handler : null;
            if (invokeOnCompletion != null) {
                if (DebugKt.getASSERTIONS_ENABLED() && (!(invokeOnCompletion instanceof JobCancellingNode)) == false) {
                    throw new AssertionError();
                }
            } else {
                invokeOnCompletion = new InvokeOnCompletion(handler);
            }
        }
        invokeOnCompletion.setJob(this);
        return invokeOnCompletion;
    }

    private final boolean addLastAtomic(final Object expect, NodeList list, JobNode node) {
        int tryCondAddNext;
        NodeList nodeList = list;
        final JobNode jobNode = node;
        LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(jobNode) { // from class: kotlinx.coroutines.JobSupport$addLastAtomic$$inlined$addLastIf$1
            @Override // kotlinx.coroutines.internal.AtomicOp
            public final Object prepare(LockFreeLinkedListNode affected) {
                if (this.getState$kotlinx_coroutines_core() == expect) {
                    return null;
                }
                return LockFreeLinkedListKt.getCONDITION_FALSE();
            }
        };
        do {
            tryCondAddNext = nodeList.getPrevNode().tryCondAddNext(jobNode, nodeList, condAddOp);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    private final void promoteEmptyToNodeList(Empty state) {
        NodeList nodeList = new NodeList();
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, state, state.getIsActive() ? nodeList : new InactiveNodeList(nodeList));
    }

    private final void promoteSingleToNodeList(JobNode state) {
        state.addOneIfEmpty(new NodeList());
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, state, state.getNextNode());
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation<? super Unit> continuation) {
        if (!joinInternal()) {
            JobKt.ensureActive(continuation.getContext());
            return Unit.INSTANCE;
        }
        Object joinSuspend = joinSuspend(continuation);
        return joinSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? joinSuspend : Unit.INSTANCE;
    }

    public void cancelInternal(Throwable cause) {
        cancelImpl$kotlinx_coroutines_core(cause);
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void parentCancelled(ParentJob parentJob) {
        cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    public boolean childCancelled(Throwable cause) {
        if (cause instanceof CancellationException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(cause) && getHandlesException();
    }

    public final boolean cancelCoroutine(Throwable cause) {
        return cancelImpl$kotlinx_coroutines_core(cause);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(Object cause) {
        Object obj;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        obj = JobSupportKt.COMPLETING_ALREADY;
        if (getOnCancelComplete$kotlinx_coroutines_core() && (obj = cancelMakeCompleting(cause)) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        symbol = JobSupportKt.COMPLETING_ALREADY;
        if (obj == symbol) {
            obj = makeCancelling(cause);
        }
        symbol2 = JobSupportKt.COMPLETING_ALREADY;
        if (obj == symbol2 || obj == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        symbol3 = JobSupportKt.TOO_LATE_TO_CANCEL;
        if (obj == symbol3) {
            return false;
        }
        afterCompletion(obj);
        return true;
    }

    @Override // kotlinx.coroutines.ParentJob
    public CancellationException getChildJobCancellationCause() {
        Throwable th;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            th = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            th = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot be cancelling child in this state: ");
            sb.append(state$kotlinx_coroutines_core);
            throw new IllegalStateException(sb.toString().toString());
        } else {
            th = null;
        }
        CancellationException cancellationException = th instanceof CancellationException ? th : null;
        if (cancellationException == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Parent job is ");
            sb2.append(stateString(state$kotlinx_coroutines_core));
            return new JobCancellationException(sb2.toString(), th, this);
        }
        return cancellationException;
    }

    private final Throwable createCauseException(Object cause) {
        if (cause == null ? true : cause instanceof Throwable) {
            Throwable th = (Throwable) cause;
            return th == null ? new JobCancellationException(cancellationExceptionMessage(), null, this) : th;
        } else if (cause != null) {
            return ((ParentJob) cause).getChildJobCancellationCause();
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
    }

    private final NodeList getOrPromoteCancellingList(Incomplete state) {
        NodeList list = state.getList();
        if (list == null) {
            if (state instanceof Empty) {
                return new NodeList();
            }
            if (state instanceof JobNode) {
                promoteSingleToNodeList((JobNode) state);
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("State should have list: ");
            sb.append(state);
            throw new IllegalStateException(sb.toString().toString());
        }
        return list;
    }

    private final boolean tryMakeCancelling(Incomplete state, Throwable rootCause) {
        if (!DebugKt.getASSERTIONS_ENABLED() || (!(state instanceof Finishing)) == true) {
            if (!DebugKt.getASSERTIONS_ENABLED() || state.getIsActive()) {
                NodeList orPromoteCancellingList = getOrPromoteCancellingList(state);
                if (orPromoteCancellingList == null) {
                    return false;
                }
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, state, new Finishing(orPromoteCancellingList, false, rootCause))) {
                    notifyCancelling(orPromoteCancellingList, rootCause);
                    return true;
                }
                return false;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private final Object tryMakeCompleting(Object state, Object proposedUpdate) {
        Symbol symbol;
        Symbol symbol2;
        if (!(state instanceof Incomplete)) {
            symbol2 = JobSupportKt.COMPLETING_ALREADY;
            return symbol2;
        } else if (((state instanceof Empty) || (state instanceof JobNode)) && !(state instanceof ChildHandleNode) && !(proposedUpdate instanceof CompletedExceptionally)) {
            if (tryFinalizeSimpleState((Incomplete) state, proposedUpdate)) {
                return proposedUpdate;
            }
            symbol = JobSupportKt.COMPLETING_RETRY;
            return symbol;
        } else {
            return tryMakeCompletingSlowPath((Incomplete) state, proposedUpdate);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object tryMakeCompletingSlowPath(Incomplete state, Object proposedUpdate) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        NodeList orPromoteCancellingList = getOrPromoteCancellingList(state);
        if (orPromoteCancellingList == null) {
            symbol3 = JobSupportKt.COMPLETING_RETRY;
            return symbol3;
        }
        Finishing finishing = state instanceof Finishing ? (Finishing) state : null;
        if (finishing == null) {
            finishing = new Finishing(orPromoteCancellingList, false, null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (finishing) {
            if (finishing.isCompleting()) {
                symbol2 = JobSupportKt.COMPLETING_ALREADY;
                return symbol2;
            }
            finishing.setCompleting(true);
            if (finishing != state && !AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, state, finishing)) {
                symbol = JobSupportKt.COMPLETING_RETRY;
                return symbol;
            }
            if (DebugKt.getASSERTIONS_ENABLED() && (!finishing.isSealed()) == false) {
                throw new AssertionError();
            }
            boolean isCancelling = finishing.isCancelling();
            CompletedExceptionally completedExceptionally = proposedUpdate instanceof CompletedExceptionally ? (CompletedExceptionally) proposedUpdate : null;
            if (completedExceptionally != null) {
                finishing.addExceptionLocked(completedExceptionally.cause);
            }
            objectRef.element = true ^ isCancelling ? finishing.getRootCause() : 0;
            Unit unit = Unit.INSTANCE;
            Throwable th = (Throwable) objectRef.element;
            if (th != null) {
                notifyCancelling(orPromoteCancellingList, th);
            }
            ChildHandleNode firstChild = firstChild(state);
            if (firstChild != null && tryWaitForChild(finishing, firstChild, proposedUpdate)) {
                return JobSupportKt.COMPLETING_WAITING_CHILDREN;
            }
            return finalizeFinishingState(finishing, proposedUpdate);
        }
    }

    @JvmName(name = "getExceptionOrNull")
    private final Throwable getExceptionOrNull(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    private final ChildHandleNode firstChild(Incomplete state) {
        ChildHandleNode childHandleNode = state instanceof ChildHandleNode ? (ChildHandleNode) state : null;
        if (childHandleNode == null) {
            NodeList list = state.getList();
            if (list != null) {
                return nextChild(list);
            }
            return null;
        }
        return childHandleNode;
    }

    private final boolean tryWaitForChild(Finishing state, ChildHandleNode child, Object proposedUpdate) {
        while (Job.DefaultImpls.invokeOnCompletion$default(child.childJob, false, false, new ChildCompletion(this, state, child, proposedUpdate), 1, null) == NonDisposableHandle.INSTANCE) {
            child = nextChild(child);
            if (child == null) {
                return false;
            }
        }
        return true;
    }

    public final void continueCompleting(Finishing state, ChildHandleNode lastChild, Object proposedUpdate) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getState$kotlinx_coroutines_core() == state)) {
                throw new AssertionError();
            }
        }
        ChildHandleNode nextChild = nextChild(lastChild);
        if (nextChild == null || !tryWaitForChild(state, nextChild, proposedUpdate)) {
            afterCompletion(finalizeFinishingState(state, proposedUpdate));
        }
    }

    private final ChildHandleNode nextChild(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    @JvmName(name = "getChildren")
    public final Sequence<Job> getChildren() {
        return SequencesKt.sequence(new JobSupport$children$1(this, null));
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle attachChild(ChildJob child) {
        return (ChildHandle) Job.DefaultImpls.invokeOnCompletion$default(this, true, false, new ChildHandleNode(child), 2, null);
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable exception) {
        throw exception;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toDebugString());
        sb.append('@');
        sb.append(DebugStringsKt.getHexAddress(this));
        return sb.toString();
    }

    public final String toDebugString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nameString$kotlinx_coroutines_core());
        sb.append('{');
        sb.append(stateString(getState$kotlinx_coroutines_core()));
        sb.append('}');
        return sb.toString();
    }

    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    private final String stateString(Object state) {
        if (state instanceof Finishing) {
            Finishing finishing = (Finishing) state;
            if (finishing.isCancelling()) {
                return "Cancelling";
            }
            if (finishing.isCompleting()) {
                return "Completing";
            }
        } else if (!(state instanceof Incomplete)) {
            return state instanceof CompletedExceptionally ? "Cancelled" : SnapReceiptBroadcastData.Status.Completed;
        } else if (!((Incomplete) state).getIsActive()) {
            return "New";
        }
        return "Active";
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010\u001e\u001a\u00020\u001a\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b+\u0010,J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\tj\b\u0012\u0004\u0012\u00020\u0004`\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0019\u001a\u0004\u0018\u00010\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u00018C@CX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001a8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001cR$\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001a8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001c\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\b!\u0010\u001cR\u001a\u0010#\u001a\u00020\"8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R(\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00048G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\b"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "", "isActive", "()Z", "isCancelling", "isCompleting", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Finishing implements Incomplete {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;
        private final NodeList list;

        @Override // kotlinx.coroutines.Incomplete
        @JvmName(name = "getList")
        public final NodeList getList() {
            return this.list;
        }

        public Finishing(NodeList nodeList, boolean z, Throwable th) {
            this.list = nodeList;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        @JvmName(name = "isCompleting")
        public final boolean isCompleting() {
            return this._isCompleting;
        }

        @JvmName(name = "setCompleting")
        public final void setCompleting(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        @JvmName(name = "getRootCause")
        public final Throwable getRootCause() {
            return (Throwable) this._rootCause;
        }

        @JvmName(name = "setRootCause")
        public final void setRootCause(Throwable th) {
            this._rootCause = th;
        }

        @JvmName(name = "getExceptionsHolder")
        /* renamed from: getExceptionsHolder  reason: from getter */
        private final Object get_exceptionsHolder() {
            return this._exceptionsHolder;
        }

        @JvmName(name = "setExceptionsHolder")
        private final void setExceptionsHolder(Object obj) {
            this._exceptionsHolder = obj;
        }

        @JvmName(name = "isSealed")
        public final boolean isSealed() {
            Symbol symbol;
            Object obj = get_exceptionsHolder();
            symbol = JobSupportKt.SEALED;
            return obj == symbol;
        }

        @JvmName(name = "isCancelling")
        public final boolean isCancelling() {
            return getRootCause() != null;
        }

        @Override // kotlinx.coroutines.Incomplete
        @JvmName(name = "isActive")
        /* renamed from: isActive */
        public final boolean getIsActive() {
            return getRootCause() == null;
        }

        public final List<Throwable> sealLocked(Throwable proposedException) {
            ArrayList<Throwable> arrayList;
            Symbol symbol;
            Object obj = get_exceptionsHolder();
            if (obj == null) {
                arrayList = allocateList();
            } else if (obj instanceof Throwable) {
                ArrayList<Throwable> allocateList = allocateList();
                allocateList.add(obj);
                arrayList = allocateList;
            } else if (!(obj instanceof ArrayList)) {
                StringBuilder sb = new StringBuilder();
                sb.append("State is ");
                sb.append(obj);
                throw new IllegalStateException(sb.toString().toString());
            } else {
                arrayList = (ArrayList) obj;
            }
            Throwable rootCause = getRootCause();
            if (rootCause != null) {
                arrayList.add(0, rootCause);
            }
            if (proposedException != null && !Intrinsics.areEqual(proposedException, rootCause)) {
                arrayList.add(proposedException);
            }
            symbol = JobSupportKt.SEALED;
            setExceptionsHolder(symbol);
            return arrayList;
        }

        public final void addExceptionLocked(Throwable exception) {
            Throwable rootCause = getRootCause();
            if (rootCause == null) {
                setRootCause(exception);
            } else if (exception == rootCause) {
            } else {
                Object obj = get_exceptionsHolder();
                if (obj == null) {
                    setExceptionsHolder(exception);
                } else if (obj instanceof Throwable) {
                    if (exception == obj) {
                        return;
                    }
                    ArrayList<Throwable> allocateList = allocateList();
                    allocateList.add(obj);
                    allocateList.add(exception);
                    setExceptionsHolder(allocateList);
                } else if (obj instanceof ArrayList) {
                    ((ArrayList) obj).add(exception);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("State is ");
                    sb.append(obj);
                    throw new IllegalStateException(sb.toString().toString());
                }
            }
        }

        private final ArrayList<Throwable> allocateList() {
            return new ArrayList<>(4);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Finishing[cancelling=");
            sb.append(isCancelling());
            sb.append(", completing=");
            sb.append(isCompleting());
            sb.append(", rootCause=");
            sb.append(getRootCause());
            sb.append(", exceptions=");
            sb.append(get_exceptionsHolder());
            sb.append(", list=");
            sb.append(getList());
            sb.append(']');
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "", "cause", "", BridgeDSL.INVOKE, "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/ChildHandleNode;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobSupport;", "parent", "Lkotlinx/coroutines/JobSupport;", "", "proposedUpdate", "Ljava/lang/Object;", "Lkotlinx/coroutines/JobSupport$Finishing;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ChildCompletion extends JobNode {
        private final ChildHandleNode child;
        private final JobSupport parent;
        private final Object proposedUpdate;
        private final Finishing state;

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke(th);
            return Unit.INSTANCE;
        }

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            this.parent = jobSupport;
            this.state = finishing;
            this.child = childHandleNode;
            this.proposedUpdate = obj;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke */
        public final void invoke2(Throwable th) {
            this.parent.continueCompleting(this.state, this.child, this.proposedUpdate);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlinx/coroutines/Job;", "parent", "", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "", "nameString", "()Ljava/lang/String;", "Lkotlinx/coroutines/JobSupport;", "job", "Lkotlinx/coroutines/JobSupport;", "Lkotlin/coroutines/Continuation;", "delegate", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        private final JobSupport job;

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        protected final String nameString() {
            return "AwaitContinuation";
        }

        public AwaitContinuation(Continuation<? super T> continuation, JobSupport jobSupport) {
            super(continuation, 1);
            this.job = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public final Throwable getContinuationCancellationCause(Job parent) {
            Throwable rootCause;
            Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            return (!(state$kotlinx_coroutines_core instanceof Finishing) || (rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause()) == null) ? state$kotlinx_coroutines_core instanceof CompletedExceptionally ? ((CompletedExceptionally) state$kotlinx_coroutines_core).cause : parent.getCancellationException() : rootCause;
        }
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if ((!(state$kotlinx_coroutines_core instanceof Incomplete)) == false) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
        return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
    }

    public final Object awaitInternal$kotlinx_coroutines_core(Continuation<Object> continuation) {
        Object state$kotlinx_coroutines_core;
        Throwable recoverFromStackFrame;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                    Throwable th = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
                    if (!DebugKt.getRECOVER_STACK_TRACES()) {
                        throw th;
                    }
                    if (continuation instanceof CoroutineStackFrame) {
                        recoverFromStackFrame = StackTraceRecoveryKt.recoverFromStackFrame(th, (CoroutineStackFrame) continuation);
                        throw recoverFromStackFrame;
                    }
                    throw th;
                }
                return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return awaitSuspend(continuation);
    }

    private final Object awaitSuspend(Continuation<Object> continuation) {
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt.intercepted(continuation), this);
        awaitContinuation.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(awaitContinuation, invokeOnCompletion(new ResumeAwaitOnCompletion(awaitContinuation)));
        Object result = awaitContinuation.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final <T, R> void selectAwaitCompletion$kotlinx_coroutines_core(SelectInstance<? super R> select, Function2<? super T, ? super Continuation<? super R>, ? extends Object> block) {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            select.resumeSelectWithException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause);
        } else {
            CancellableKt.startCoroutineCancellable$default(block, JobSupportKt.unboxState(state$kotlinx_coroutines_core), select.getCompletion(), null, 4, null);
        }
    }

    @JvmName(name = "getState$kotlinx_coroutines_core")
    public final Object getState$kotlinx_coroutines_core() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    private final void notifyCompletion(NodeList nodeList, Throwable th) {
        NodeList nodeList2 = nodeList;
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList2.getNext(); !Intrinsics.areEqual(lockFreeLinkedListNode, nodeList2); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof JobNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.invoke(th);
                } catch (Throwable th2) {
                    CompletionHandlerException completionHandlerException2 = completionHandlerException;
                    if (completionHandlerException2 != null) {
                        kotlin.ExceptionsKt.addSuppressed(completionHandlerException2, th2);
                        if (completionHandlerException2 != null) {
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Exception in completion handler ");
                    sb.append(jobNode);
                    sb.append(" for ");
                    sb.append(this);
                    CompletionHandlerException completionHandlerException3 = new CompletionHandlerException(sb.toString(), th2);
                    Unit unit = Unit.INSTANCE;
                    completionHandlerException = completionHandlerException3;
                }
            }
        }
        CompletionHandlerException completionHandlerException4 = completionHandlerException;
        if (completionHandlerException4 != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException4);
        }
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int startInternal;
        do {
            startInternal = startInternal(getState$kotlinx_coroutines_core());
            if (startInternal == 0) {
                return false;
            }
        } while (startInternal != 1);
        return true;
    }

    private final boolean joinInternal() {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                return false;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return true;
    }

    private final Object joinSuspend(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl2, invokeOnCompletion(new ResumeOnCompletion(cancellableContinuationImpl2)));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.selects.SelectClause0
    public final <R> void registerSelectClause0(SelectInstance<? super R> select, Function1<? super Continuation<? super R>, ? extends Object> block) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (select.isSelected()) {
                return;
            }
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (select.trySelect()) {
                    UndispatchedKt.startCoroutineUnintercepted(block, select.getCompletion());
                    return;
                }
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) != 0);
        select.disposeOnSelect(invokeOnCompletion(new SelectJoinOnCompletion(select, block)));
    }

    public final void removeNode$kotlinx_coroutines_core(JobNode node) {
        Object state$kotlinx_coroutines_core;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Empty empty;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof JobNode)) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete) || ((Incomplete) state$kotlinx_coroutines_core).getList() == null) {
                    return;
                }
                node.mo4660remove();
                return;
            } else if (state$kotlinx_coroutines_core != node) {
                return;
            } else {
                atomicReferenceFieldUpdater = _state$FU;
                empty = JobSupportKt.EMPTY_ACTIVE;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(atomicReferenceFieldUpdater, this, state$kotlinx_coroutines_core, empty));
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException cause) {
        if (cause == null) {
            cause = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cause);
    }

    private final Object cancelMakeCompleting(Object cause) {
        Symbol symbol;
        Object tryMakeCompleting;
        Symbol symbol2;
        do {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete) || ((state$kotlinx_coroutines_core instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core).isCompleting())) {
                symbol = JobSupportKt.COMPLETING_ALREADY;
                return symbol;
            }
            tryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(createCauseException(cause), false, 2, null));
            symbol2 = JobSupportKt.COMPLETING_RETRY;
        } while (tryMakeCompleting == symbol2);
        return tryMakeCompleting;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlinx.coroutines.JobSupport] */
    private final Object makeCancelling(Object cause) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Throwable th = null;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Finishing)) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    symbol3 = JobSupportKt.TOO_LATE_TO_CANCEL;
                    return symbol3;
                }
                if (th == null) {
                    th = createCauseException(cause);
                }
                Incomplete incomplete = (Incomplete) state$kotlinx_coroutines_core;
                if (incomplete.getIsActive()) {
                    if (tryMakeCancelling(incomplete, th)) {
                        symbol4 = JobSupportKt.COMPLETING_ALREADY;
                        return symbol4;
                    }
                } else {
                    Object tryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(th, false, 2, r0));
                    symbol5 = JobSupportKt.COMPLETING_ALREADY;
                    if (tryMakeCompleting != symbol5) {
                        symbol6 = JobSupportKt.COMPLETING_RETRY;
                        if (tryMakeCompleting != symbol6) {
                            return tryMakeCompleting;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Cannot happen in ");
                        sb.append(state$kotlinx_coroutines_core);
                        throw new IllegalStateException(sb.toString().toString());
                    }
                }
            } else {
                synchronized (state$kotlinx_coroutines_core) {
                    if (((Finishing) state$kotlinx_coroutines_core).isSealed()) {
                        symbol2 = JobSupportKt.TOO_LATE_TO_CANCEL;
                        return symbol2;
                    }
                    boolean isCancelling = ((Finishing) state$kotlinx_coroutines_core).isCancelling();
                    if (cause != null || !isCancelling) {
                        if (th == null) {
                            th = createCauseException(cause);
                        }
                        ((Finishing) state$kotlinx_coroutines_core).addExceptionLocked(th);
                    }
                    r0 = isCancelling ^ true ? ((Finishing) state$kotlinx_coroutines_core).getRootCause() : 0;
                    if (r0 != 0) {
                        notifyCancelling(((Finishing) state$kotlinx_coroutines_core).getList(), r0);
                    }
                    symbol = JobSupportKt.COMPLETING_ALREADY;
                    return symbol;
                }
            }
        }
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object proposedUpdate) {
        Object tryMakeCompleting;
        Symbol symbol;
        Symbol symbol2;
        do {
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), proposedUpdate);
            symbol = JobSupportKt.COMPLETING_ALREADY;
            if (tryMakeCompleting == symbol) {
                return false;
            }
            if (tryMakeCompleting == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
            symbol2 = JobSupportKt.COMPLETING_RETRY;
        } while (tryMakeCompleting == symbol2);
        afterCompletion(tryMakeCompleting);
        return true;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object proposedUpdate) {
        Object tryMakeCompleting;
        Symbol symbol;
        Symbol symbol2;
        do {
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), proposedUpdate);
            symbol = JobSupportKt.COMPLETING_ALREADY;
            if (tryMakeCompleting != symbol) {
                symbol2 = JobSupportKt.COMPLETING_RETRY;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Job ");
                sb.append(this);
                sb.append(" is already complete or completing, but is being completed with ");
                sb.append(proposedUpdate);
                throw new IllegalStateException(sb.toString(), getExceptionOrNull(proposedUpdate));
            }
        } while (tryMakeCompleting == symbol2);
        return tryMakeCompleting;
    }

    public final <T, R> void registerSelectClause1Internal$kotlinx_coroutines_core(SelectInstance<? super R> select, Function2<? super T, ? super Continuation<? super R>, ? extends Object> block) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (select.isSelected()) {
                return;
            }
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (select.trySelect()) {
                    if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                        select.resumeSelectWithException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause);
                        return;
                    } else {
                        UndispatchedKt.startCoroutineUnintercepted(block, JobSupportKt.unboxState(state$kotlinx_coroutines_core), select.getCompletion());
                        return;
                    }
                }
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) != 0);
        select.disposeOnSelect(invokeOnCompletion(new SelectAwaitOnCompletion(select, block)));
    }
}
