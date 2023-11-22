package id.dana.component.dialogcomponent;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class CustomDialog$sam$android_content_DialogInterface_OnDismissListener$0 implements DialogInterface.OnDismissListener {
    private final /* synthetic */ Function1 BuiltInFictitiousFunctionClassFactory;

    public CustomDialog$sam$android_content_DialogInterface_OnDismissListener$0(Function1 function1) {
        this.BuiltInFictitiousFunctionClassFactory = function1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final /* synthetic */ void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullExpressionValue(this.BuiltInFictitiousFunctionClassFactory.invoke(dialogInterface), "");
    }
}
