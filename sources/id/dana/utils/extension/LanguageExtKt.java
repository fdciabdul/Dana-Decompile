package id.dana.utils.extension;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "getAuthRequestContext", "()Z"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LanguageExtKt {
    public static final boolean getAuthRequestContext() {
        String obj = Locale.getDefault().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return StringsKt.endsWith$default(obj, "ID", false, 2, (Object) null);
    }
}
