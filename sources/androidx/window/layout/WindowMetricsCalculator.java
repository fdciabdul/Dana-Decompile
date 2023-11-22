package androidx.window.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculator;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface WindowMetricsCalculator {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.BuiltInFictitiousFunctionClassFactory;

    /* renamed from: androidx.window.layout.WindowMetricsCalculator$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = WindowMetricsCalculator.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculator$Companion;", "", "Lkotlin/Function1;", "Landroidx/window/layout/WindowMetricsCalculator;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();
        private static Function1<? super WindowMetricsCalculator, ? extends WindowMetricsCalculator> KClassImpl$Data$declaredNonStaticMembers$2 = new Function1<WindowMetricsCalculator, WindowMetricsCalculator>() { // from class: androidx.window.layout.WindowMetricsCalculator$Companion$decorator$1
            @Override // kotlin.jvm.functions.Function1
            public final WindowMetricsCalculator invoke(WindowMetricsCalculator windowMetricsCalculator) {
                Intrinsics.checkNotNullParameter(windowMetricsCalculator, "");
                return windowMetricsCalculator;
            }
        };

        private Companion() {
        }
    }
}
