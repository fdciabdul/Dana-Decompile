package com.afollestad.materialdialogs.callbacks;

import android.content.DialogInterface;
import com.afollestad.materialdialogs.MaterialDialog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a1\u0010\u0006\u001a\u00020\u0003*\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u00040\u00002\u0006\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a)\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004¢\u0006\u0004\b\t\u0010\n\u001a)\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004¢\u0006\u0004\b\u000b\u0010\n\u001a)\u0010\f\u001a\u00020\u0002*\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004¢\u0006\u0004\b\f\u0010\n\u001a)\u0010\r\u001a\u00020\u0002*\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004¢\u0006\u0004\b\r\u0010\n"}, d2 = {"", "Lkotlin/Function1;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "", "Lcom/afollestad/materialdialogs/DialogCallback;", "dialog", "invokeAll", "(Ljava/util/List;Lcom/afollestad/materialdialogs/MaterialDialog;)V", "callback", "onCancel", "(Lcom/afollestad/materialdialogs/MaterialDialog;Lkotlin/jvm/functions/Function1;)Lcom/afollestad/materialdialogs/MaterialDialog;", "onDismiss", "onPreShow", "onShow"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class DialogCallbackExtKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final MaterialDialog onPreShow(MaterialDialog materialDialog, Function1<? super MaterialDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(function1, "");
        materialDialog.getPreShowListeners$core().add(function1);
        return materialDialog;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final MaterialDialog onShow(final MaterialDialog materialDialog, Function1<? super MaterialDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(function1, "");
        materialDialog.getShowListeners$core().add(function1);
        if (materialDialog.isShowing()) {
            invokeAll(materialDialog.getShowListeners$core(), materialDialog);
        }
        materialDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.afollestad.materialdialogs.callbacks.DialogCallbackExtKt$onShow$1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DialogCallbackExtKt.invokeAll(MaterialDialog.this.getShowListeners$core(), MaterialDialog.this);
            }
        });
        return materialDialog;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final MaterialDialog onDismiss(final MaterialDialog materialDialog, Function1<? super MaterialDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(function1, "");
        materialDialog.getDismissListeners$core().add(function1);
        materialDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.afollestad.materialdialogs.callbacks.DialogCallbackExtKt$onDismiss$1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogCallbackExtKt.invokeAll(MaterialDialog.this.getDismissListeners$core(), MaterialDialog.this);
            }
        });
        return materialDialog;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final MaterialDialog onCancel(final MaterialDialog materialDialog, Function1<? super MaterialDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(function1, "");
        materialDialog.getCancelListeners$core().add(function1);
        materialDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.afollestad.materialdialogs.callbacks.DialogCallbackExtKt$onCancel$1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DialogCallbackExtKt.invokeAll(MaterialDialog.this.getCancelListeners$core(), MaterialDialog.this);
            }
        });
        return materialDialog;
    }

    public static final void invokeAll(List<Function1<MaterialDialog, Unit>> list, MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(list, "");
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Iterator<Function1<MaterialDialog, Unit>> it = list.iterator();
        while (it.hasNext()) {
            it.next().invoke(materialDialog);
        }
    }
}
