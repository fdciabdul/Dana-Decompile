package com.twilio.security.storage;

import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\b\b\u0000\u0010\u0005*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\r\u001a\u00020\u0002\"\b\b\u0000\u0010\u0005*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0004\b\r\u0010\u000fJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0003\u0010\u0010"}, d2 = {"Lcom/twilio/security/storage/EncryptedStorage;", "", "", "BuiltInFictitiousFunctionClassFactory", "()V", "T", "", "p0", "Lkotlin/reflect/KClass;", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "", "getAuthRequestContext", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "(Ljava/lang/String;Ljava/lang/Object;)V", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public interface EncryptedStorage {
    void BuiltInFictitiousFunctionClassFactory();

    void BuiltInFictitiousFunctionClassFactory(String p0);

    <T> T KClassImpl$Data$declaredNonStaticMembers$2(String p0, KClass<T> p1) throws StorageException;

    <T> List<T> getAuthRequestContext(KClass<T> p0) throws StorageException;

    <T> void getAuthRequestContext(String p0, T p1) throws StorageException;
}
