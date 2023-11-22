package io.reactivex.rxkotlin;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: Add missing generic type declarations: [R, T, U] */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u00002\r\u0010\u0005\u001a\t\u0018\u00018\u0000¢\u0006\u0002\b\u00042\r\u0010\u0006\u001a\t\u0018\u00018\u0001¢\u0006\u0002\b\u00042\r\u0010\u0007\u001a\t\u0018\u00018\u0002¢\u0006\u0002\b\u0004¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "T", "R", "U", "Lkotlin/ParameterName;", "p1", "p2", "p3", "Lkotlin/Triple;", BridgeDSL.INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes9.dex */
final /* synthetic */ class FlowableKt$combineLatest$3<R, T, U> extends FunctionReference implements Function3<T, R, U, Triple<? extends T, ? extends R, ? extends U>> {
    public static final FlowableKt$combineLatest$3 INSTANCE = new FlowableKt$combineLatest$3();

    FlowableKt$combineLatest$3() {
        super(3);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Triple.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "<init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((FlowableKt$combineLatest$3<R, T, U>) obj, obj2, obj3);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Triple<T, R, U> invoke(T t, R r, U u) {
        Intrinsics.checkParameterIsNotNull(t, "");
        Intrinsics.checkParameterIsNotNull(r, "");
        Intrinsics.checkParameterIsNotNull(u, "");
        return new Triple<>(t, r, u);
    }
}
