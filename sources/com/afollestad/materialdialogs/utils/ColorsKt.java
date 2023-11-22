package com.afollestad.materialdialogs.utils;

import android.graphics.Color;
import com.afollestad.materialdialogs.MaterialDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a=\u0010\n\u001a\u00020\u0000*\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\bH\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a:\u0010\u0010\u001a\u00020\f*\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u001d\b\u0002\u0010\t\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0000¢\u0006\u0002\b\u000f\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"", "", "alpha", "adjustAlpha", "(IF)I", "Lcom/afollestad/materialdialogs/MaterialDialog;", "res", "attr", "Lkotlin/Function0;", "fallback", "resolveColor", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)I", "", "attrs", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "resolveColors", "(Lcom/afollestad/materialdialogs/MaterialDialog;[ILkotlin/jvm/functions/Function1;)[I"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class ColorsKt {
    public static /* synthetic */ int resolveColor$default(MaterialDialog materialDialog, Integer num, Integer num2, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return resolveColor(materialDialog, num, num2, function0);
    }

    public static final int resolveColor(MaterialDialog materialDialog, Integer num, Integer num2, Function0<Integer> function0) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        return MDUtil.INSTANCE.resolveColor(materialDialog.getWindowContext(), num, num2, function0);
    }

    public static /* synthetic */ int[] resolveColors$default(MaterialDialog materialDialog, int[] iArr, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return resolveColors(materialDialog, iArr, function1);
    }

    public static final int[] resolveColors(MaterialDialog materialDialog, int[] iArr, Function1<? super Integer, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(iArr, "");
        return MDUtil.INSTANCE.resolveColors(materialDialog.getWindowContext(), iArr, function1);
    }

    public static final int adjustAlpha(int i, float f) {
        return Color.argb((int) (f * 255.0f), Color.red(i), Color.green(i), Color.blue(i));
    }
}
