package com.twilio.security.storage;

import kotlin.Metadata;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J1\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/twilio/security/storage/Serializer;", "", "T", "", "p0", "Lkotlin/reflect/KClass;", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "([BLkotlin/reflect/KClass;)Ljava/lang/Object;", "MyBillsEntityDataFactory", "(Ljava/lang/Object;)[B"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public interface Serializer {
    <T> T KClassImpl$Data$declaredNonStaticMembers$2(byte[] p0, KClass<T> p1);

    <T> byte[] MyBillsEntityDataFactory(T p0);
}
