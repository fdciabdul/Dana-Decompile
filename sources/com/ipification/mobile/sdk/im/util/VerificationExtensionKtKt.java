package com.ipification.mobile.sdk.im.util;

import android.content.pm.PackageManager;
import com.ipification.mobile.sdk.android.utils.IPConstant;
import id.dana.cashier.view.InputCardNumberView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/content/pm/PackageManager;", "", "p0", "", "MyBillsEntityDataFactory", "(Landroid/content/pm/PackageManager;Ljava/lang/String;)Z"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class VerificationExtensionKtKt {
    public static final boolean MyBillsEntityDataFactory(PackageManager packageManager, String str) {
        Intrinsics.checkParameterIsNotNull(packageManager, "");
        Intrinsics.checkParameterIsNotNull(str, "");
        try {
            packageManager.getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            IPConstant.Companion companion = IPConstant.INSTANCE;
            IPConstant PlaceComponentResult = IPConstant.Companion.PlaceComponentResult();
            StringBuilder sb = new StringBuilder();
            sb.append(PlaceComponentResult.DatabaseTableConfigUtil);
            sb.append(str);
            sb.append(InputCardNumberView.DIVIDER);
            sb.append((Object) e.getMessage());
            sb.append('\n');
            String obj = sb.toString();
            Intrinsics.checkParameterIsNotNull(obj, "");
            PlaceComponentResult.DatabaseTableConfigUtil = obj;
            return false;
        }
    }
}
