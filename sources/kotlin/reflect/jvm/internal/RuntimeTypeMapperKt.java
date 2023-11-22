package kotlin.reflect.jvm.internal;

import id.dana.data.constant.BranchLinkConstant;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003"}, d2 = {"Ljava/lang/reflect/Method;", "", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", BranchLinkConstant.OauthParams.SIGNATURE}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class RuntimeTypeMapperKt {
    public static final /* synthetic */ String access$getSignature(Method method) {
        return getSignature(method);
    }

    @JvmName(name = "getSignature")
    public static final String getSignature(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "");
        sb.append(ArraysKt.joinToString$default(parameterTypes, "", "(", ")", 0, (CharSequence) null, new Function1<Class<?>, CharSequence>() { // from class: kotlin.reflect.jvm.internal.RuntimeTypeMapperKt$signature$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Class<?> cls) {
                Intrinsics.checkNotNullExpressionValue(cls, "");
                return ReflectClassUtilKt.getDesc(cls);
            }
        }, 24, (Object) null));
        Class<?> returnType = method.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "");
        sb.append(ReflectClassUtilKt.getDesc(returnType));
        return sb.toString();
    }
}
