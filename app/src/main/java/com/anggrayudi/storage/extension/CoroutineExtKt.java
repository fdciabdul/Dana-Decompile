package com.anggrayudi.storage.extension;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\b\u001a\u00020\u00072)\u0010\u0006\u001a%\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0000¢\u0006\u0002\b\u0005ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "p0", "Lkotlinx/coroutines/Job;", "BuiltInFictitiousFunctionClassFactory", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class CoroutineExtKt {
    public static /* synthetic */ Job getAuthRequestContext(long j, Function0 function0) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(function0, "");
        launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new CoroutineExtKt$startCoroutineTimer$1(0L, j, false, function0, null), 3, null);
        return launch$default;
    }

    public static final Job BuiltInFictitiousFunctionClassFactory(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(function2, "");
        launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, function2, 2, null);
        return launch$default;
    }
}
