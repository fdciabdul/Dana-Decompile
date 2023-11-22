package kotlin.reflect.jvm.internal.impl.renderer;

import com.j256.ormlite.stmt.query.SimpleComparison;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public enum RenderingFormat {
    PLAIN { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.PLAIN
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        public final String escape(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            return str;
        }
    },
    HTML { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        public final String escape(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            return StringsKt.replace$default(StringsKt.replace$default(str, SimpleComparison.LESS_THAN_OPERATION, "&lt;", false, 4, (Object) null), SimpleComparison.GREATER_THAN_OPERATION, "&gt;", false, 4, (Object) null);
        }
    };

    /* synthetic */ RenderingFormat(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String escape(String str);
}
