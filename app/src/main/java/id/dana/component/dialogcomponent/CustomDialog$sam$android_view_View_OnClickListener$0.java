package id.dana.component.dialogcomponent;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class CustomDialog$sam$android_view_View_OnClickListener$0 implements View.OnClickListener {
    private final /* synthetic */ Function1 KClassImpl$Data$declaredNonStaticMembers$2;

    public CustomDialog$sam$android_view_View_OnClickListener$0(Function1 function1) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View view) {
        Intrinsics.checkNotNullExpressionValue(this.KClassImpl$Data$declaredNonStaticMembers$2.invoke(view), "");
    }
}
