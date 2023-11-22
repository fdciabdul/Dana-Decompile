package com.afollestad.materialdialogs;

import android.content.Context;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Landroid/content/Context;", HummerConstants.CONTEXT, "Lcom/afollestad/materialdialogs/DialogBehavior;", "dialogBehavior", "", "inferTheme", "(Landroid/content/Context;Lcom/afollestad/materialdialogs/DialogBehavior;)I", "", "inferThemeIsLight", "(Landroid/content/Context;)Z"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class ThemeKt {
    public static final int inferTheme(Context context, DialogBehavior dialogBehavior) {
        Intrinsics.checkParameterIsNotNull(context, "");
        Intrinsics.checkParameterIsNotNull(dialogBehavior, "");
        return dialogBehavior.getThemeRes(!inferThemeIsLight(context));
    }

    public static final boolean inferThemeIsLight(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "");
        MDUtil mDUtil = MDUtil.INSTANCE;
        return MDUtil.isColorDark$default(mDUtil, MDUtil.resolveColor$default(mDUtil, context, null, 16842806, null, 10, null), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1, null);
    }
}
