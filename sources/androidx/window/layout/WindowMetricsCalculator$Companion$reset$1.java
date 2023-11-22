package androidx.window.layout;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculator;", "it", BridgeDSL.INVOKE, "(Landroidx/window/layout/WindowMetricsCalculator;)Landroidx/window/layout/WindowMetricsCalculator;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
final class WindowMetricsCalculator$Companion$reset$1 extends Lambda implements Function1<WindowMetricsCalculator, WindowMetricsCalculator> {
    public static final WindowMetricsCalculator$Companion$reset$1 INSTANCE = new WindowMetricsCalculator$Companion$reset$1();

    WindowMetricsCalculator$Companion$reset$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WindowMetricsCalculator invoke(WindowMetricsCalculator windowMetricsCalculator) {
        Intrinsics.checkNotNullParameter(windowMetricsCalculator, "");
        return windowMetricsCalculator;
    }
}
