package kotlin.internal;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "", "cause", "exception", "", "addSuppressed", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "Lkotlin/random/Random;", "defaultPlatformRandom", "()Lkotlin/random/Random;", "Ljava/util/regex/MatchResult;", "matchResult", "", "name", "Lkotlin/text/MatchGroup;", "getMatchResultNamedGroup", "(Ljava/util/regex/MatchResult;Ljava/lang/String;)Lkotlin/text/MatchGroup;", "", "getSuppressed", "(Ljava/lang/Throwable;)Ljava/util/List;", "<init>", "()V", "ReflectThrowable"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class PlatformImplementations {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "Ljava/lang/reflect/Method;", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    static final class ReflectThrowable {
        public static final ReflectThrowable INSTANCE = new ReflectThrowable();
        public static final Method addSuppressed;
        public static final Method getSuppressed;

        private ReflectThrowable() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0040 A[LOOP:0: B:3:0x0015->B:12:0x0040, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[EDGE_INSN: B:23:0x0044->B:14:0x0044 BREAK  A[LOOP:0: B:3:0x0015->B:12:0x0040], SYNTHETIC] */
        static {
            /*
                kotlin.internal.PlatformImplementations$ReflectThrowable r0 = new kotlin.internal.PlatformImplementations$ReflectThrowable
                r0.<init>()
                kotlin.internal.PlatformImplementations.ReflectThrowable.INSTANCE = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r0 = r0.getMethods()
                java.lang.String r1 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                int r2 = r0.length
                r3 = 0
                r4 = 0
            L15:
                r5 = 0
                if (r4 >= r2) goto L43
                r6 = r0[r4]
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
                if (r7 == 0) goto L3d
                java.lang.Class[] r7 = r6.getParameterTypes()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
                java.lang.Object[] r7 = (java.lang.Object[]) r7
                java.lang.Object r7 = kotlin.collections.ArraysKt.singleOrNull(r7)
                java.lang.Class<java.lang.Throwable> r8 = java.lang.Throwable.class
                boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
                if (r7 == 0) goto L3d
                r7 = 1
                goto L3e
            L3d:
                r7 = 0
            L3e:
                if (r7 != 0) goto L44
                int r4 = r4 + 1
                goto L15
            L43:
                r6 = r5
            L44:
                kotlin.internal.PlatformImplementations.ReflectThrowable.addSuppressed = r6
                int r1 = r0.length
            L47:
                if (r3 >= r1) goto L5b
                r2 = r0[r3]
                java.lang.String r4 = r2.getName()
                java.lang.String r6 = "getSuppressed"
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r6)
                if (r4 != 0) goto L5a
                int r3 = r3 + 1
                goto L47
            L5a:
                r5 = r2
            L5b:
                kotlin.internal.PlatformImplementations.ReflectThrowable.getSuppressed = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.PlatformImplementations.ReflectThrowable.<clinit>():void");
        }
    }

    public void addSuppressed(Throwable cause, Throwable exception) {
        Intrinsics.checkNotNullParameter(cause, "");
        Intrinsics.checkNotNullParameter(exception, "");
        Method method = ReflectThrowable.addSuppressed;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public List<Throwable> getSuppressed(Throwable exception) {
        Object invoke;
        List<Throwable> asList;
        Intrinsics.checkNotNullParameter(exception, "");
        Method method = ReflectThrowable.getSuppressed;
        return (method == null || (invoke = method.invoke(exception, new Object[0])) == null || (asList = ArraysKt.asList((Throwable[]) invoke)) == null) ? CollectionsKt.emptyList() : asList;
    }

    public MatchGroup getMatchResultNamedGroup(MatchResult matchResult, String name) {
        Intrinsics.checkNotNullParameter(matchResult, "");
        Intrinsics.checkNotNullParameter(name, "");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    public Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }
}
