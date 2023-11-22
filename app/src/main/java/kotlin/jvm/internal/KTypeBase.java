package kotlin.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/jvm/internal/KTypeBase;", "Lkotlin/reflect/KType;", "Ljava/lang/reflect/Type;", "getJavaType", "()Ljava/lang/reflect/Type;", "javaType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface KTypeBase extends KType {
    @JvmName(name = "getJavaType")
    Type getJavaType();
}
