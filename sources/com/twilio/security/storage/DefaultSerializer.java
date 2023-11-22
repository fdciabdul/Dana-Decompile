package com.twilio.security.storage;

import id.dana.sendmoney.summary.SummaryActivity;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ1\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\n\u001a\u00020\u0004\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/twilio/security/storage/DefaultSerializer;", "Lcom/twilio/security/storage/Serializer;", "", "T", "", "p0", "Lkotlin/reflect/KClass;", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "([BLkotlin/reflect/KClass;)Ljava/lang/Object;", "MyBillsEntityDataFactory", "(Ljava/lang/Object;)[B", "<init>", "()V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class DefaultSerializer implements Serializer {
    @Override // com.twilio.security.storage.Serializer
    public final <T> byte[] MyBillsEntityDataFactory(T p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        if (p0 instanceof String) {
            byte[] bytes = ((String) p0).getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "");
            return bytes;
        } else if ((p0 instanceof Integer) || (p0 instanceof Double) || (p0 instanceof Boolean) || (p0 instanceof Float) || (p0 instanceof Long)) {
            String obj = p0.toString();
            Charset charset = Charsets.UTF_8;
            if (obj != null) {
                byte[] bytes2 = obj.getBytes(charset);
                Intrinsics.checkExpressionValueIsNotNull(bytes2, "");
                return bytes2;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } else {
            throw new IllegalArgumentException("Value type not supported");
        }
    }

    @Override // com.twilio.security.storage.Serializer
    public final <T> T KClassImpl$Data$declaredNonStaticMembers$2(byte[] p0, KClass<T> p1) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        if (SerializerKt.MyBillsEntityDataFactory(p1, Reflection.getOrCreateKotlinClass(String.class))) {
            r1 = new String(p0, Charsets.UTF_8);
        } else if (SerializerKt.MyBillsEntityDataFactory(p1, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            Object valueOf = Integer.valueOf(Integer.parseInt(new String(p0, Charsets.UTF_8)));
            return (T) (valueOf instanceof Object ? valueOf : null);
        } else if (SerializerKt.MyBillsEntityDataFactory(p1, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            Object valueOf2 = Double.valueOf(Double.parseDouble(new String(p0, Charsets.UTF_8)));
            return (T) (valueOf2 instanceof Object ? valueOf2 : null);
        } else if (SerializerKt.MyBillsEntityDataFactory(p1, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            String str = new String(p0, Charsets.UTF_8);
            boolean z = true;
            if (!StringsKt.equals(str, "false", true) && !StringsKt.equals(str, SummaryActivity.CHECKED, true)) {
                z = false;
            }
            if (!z) {
                str = null;
            }
            Object valueOf3 = str != null ? Boolean.valueOf(Boolean.parseBoolean(str)) : null;
            return (T) (valueOf3 instanceof Object ? valueOf3 : null);
        } else if (SerializerKt.MyBillsEntityDataFactory(p1, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            Object valueOf4 = Float.valueOf(Float.parseFloat(new String(p0, Charsets.UTF_8)));
            return (T) (valueOf4 instanceof Object ? valueOf4 : null);
        } else if (SerializerKt.MyBillsEntityDataFactory(p1, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            Object valueOf5 = Long.valueOf(Long.parseLong(new String(p0, Charsets.UTF_8)));
            if (valueOf5 instanceof Object) {
                r1 = valueOf5;
            }
        } else {
            throw new IllegalArgumentException("Value type not supported");
        }
        return (T) r1;
    }
}
