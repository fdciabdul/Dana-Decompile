package androidx.view;

import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0000"}, d2 = {}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PipHintTrackerKt {
    public static final /* synthetic */ Rect KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
