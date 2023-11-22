package com.afollestad.materialdialogs.files.util;

import android.view.View;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a%\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "T", "", MaintenanceBroadcastResult.KEY_VISIBLE, "", "setVisible", "(Landroid/view/View;Z)V"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class ViewExtKt {
    public static final <T extends View> void setVisible(T t, boolean z) {
        Intrinsics.checkParameterIsNotNull(t, "");
        t.setVisibility(z ? 0 : 4);
    }
}
