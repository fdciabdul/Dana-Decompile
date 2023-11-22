package com.afollestad.materialdialogs.internal.list;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.utils.DialogsKt;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "showTop", "p2", "showBottom", BridgeDSL.INVOKE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final /* synthetic */ class DialogRecyclerView$attach$1 extends FunctionReference implements Function2<Boolean, Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogRecyclerView$attach$1(MaterialDialog materialDialog) {
        super(2, materialDialog);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "invalidateDividers";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(DialogsKt.class, "core");
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "invalidateDividers(Lcom/afollestad/materialdialogs/MaterialDialog;ZZ)V";
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
        invoke(bool.booleanValue(), bool2.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, boolean z2) {
        DialogsKt.invalidateDividers((MaterialDialog) this.receiver, z, z2);
    }
}
