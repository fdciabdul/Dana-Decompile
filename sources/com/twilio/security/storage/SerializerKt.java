package com.twilio.security.storage;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a;\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "T", "R", "Lkotlin/reflect/KClass;", "p0", "", "MyBillsEntityDataFactory", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)Z"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class SerializerKt {
    public static final <T, R> boolean MyBillsEntityDataFactory(KClass<T> kClass, KClass<R> kClass2) {
        Intrinsics.checkParameterIsNotNull(kClass, "");
        Intrinsics.checkParameterIsNotNull(kClass2, "");
        return JvmClassMappingKt.getJavaObjectType(kClass).isAssignableFrom(JvmClassMappingKt.getJavaObjectType(kClass2));
    }
}
