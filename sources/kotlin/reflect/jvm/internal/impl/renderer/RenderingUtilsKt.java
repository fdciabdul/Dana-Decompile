package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* loaded from: classes.dex */
public final class RenderingUtilsKt {
    public static final String render(Name name) {
        Intrinsics.checkNotNullParameter(name, "");
        if (!shouldBeEscaped(name)) {
            String asString = name.asString();
            Intrinsics.checkNotNullExpressionValue(asString, "");
            return asString;
        }
        StringBuilder sb = new StringBuilder();
        String asString2 = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append('`');
        sb2.append(asString2);
        sb.append(sb2.toString());
        sb.append('`');
        return sb.toString();
    }

    private static final boolean shouldBeEscaped(Name name) {
        boolean z;
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "");
        if (KeywordStringsGenerated.KEYWORDS.contains(asString)) {
            return true;
        }
        String str = asString;
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z = false;
                break;
            }
            char charAt = str.charAt(i);
            if ((Character.isLetterOrDigit(charAt) || charAt == '_') ? false : true) {
                z = true;
                break;
            }
            i++;
        }
        return z;
    }

    public static final String render(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "");
        List<Name> pathSegments = fqNameUnsafe.pathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "");
        return renderFqName(pathSegments);
    }

    public static final String renderFqName(List<Name> list) {
        Intrinsics.checkNotNullParameter(list, "");
        StringBuilder sb = new StringBuilder();
        for (Name name : list) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(render(name));
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }
}
