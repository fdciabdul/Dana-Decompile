package com.twilio.verify.threading;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\f\b\u0001\u0010\u0003*\u00060\u0001j\u0002`\u00022\r\u0010\u0005\u001a\t\u0018\u00018\u0000¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"T", "Ljava/lang/Exception;", "Lkotlin/Exception;", "E", "Lkotlin/ParameterName;", "p1", "", BridgeDSL.INVOKE, "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes4.dex */
final /* synthetic */ class Task$run$1<T> extends FunctionReference implements Function1<T, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public Task$run$1(Task task) {
        super(1, task);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "safeSuccess";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Task.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "safeSuccess(Ljava/lang/Object;)V";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2((Task$run$1<T>) obj);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(T t) {
        Task.KClassImpl$Data$declaredNonStaticMembers$2((Task) this.receiver, t);
    }
}
