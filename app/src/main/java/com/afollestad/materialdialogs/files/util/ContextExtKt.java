package com.afollestad.materialdialogs.files.util;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/content/Context;", "Ljava/io/File;", "getExternalFilesDir", "(Landroid/content/Context;)Ljava/io/File;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class ContextExtKt {
    public static final File getExternalFilesDir(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "");
        return context.getExternalFilesDir(null);
    }
}
