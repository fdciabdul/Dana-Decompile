package io.reactivex.rxkotlin;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: Add missing generic type declarations: [R, T] */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\r\u0010\u0004\u001a\t\u0018\u00018\u0000¢\u0006\u0002\b\u00032\r\u0010\u0005\u001a\t\u0018\u00018\u0001¢\u0006\u0002\b\u0003¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "T", "R", "Lkotlin/ParameterName;", "p1", "p2", "Lkotlin/Pair;", BridgeDSL.INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes9.dex */
final /* synthetic */ class FlowableKt$combineLatest$2<R, T> extends FunctionReference implements Function2<T, R, Pair<? extends T, ? extends R>> {
    public static final FlowableKt$combineLatest$2 INSTANCE = new FlowableKt$combineLatest$2();

    FlowableKt$combineLatest$2() {
        super(2);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Pair.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "<init>(Ljava/lang/Object;Ljava/lang/Object;)V";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((FlowableKt$combineLatest$2<R, T>) obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Pair<T, R> invoke(T t, R r) {
        Intrinsics.checkParameterIsNotNull(t, "");
        Intrinsics.checkParameterIsNotNull(r, "");
        return new Pair<>(t, r);
    }
}
