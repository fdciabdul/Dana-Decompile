package com.twilio.verify;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0003\u001a\u0006*\u00020\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/Context;", "p0", "Landroid/content/SharedPreferences;", "PlaceComponentResult", "(Landroid/content/Context;)Landroid/content/SharedPreferences;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class TwilioVerifyKt {
    public static final SharedPreferences PlaceComponentResult(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "");
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".verify");
        return context.getSharedPreferences(sb.toString(), 0);
    }
}
