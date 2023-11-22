package kotlin.reflect.jvm.internal.calls;

import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import id.dana.cashier.view.InputCardNumberView;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.text.Typography;

@Metadata(d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001aI\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\u0010\u000b\u001a$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u001a\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¨\u0006\u0014²\u0006\u0014\u0010\u0015\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002²\u0006\u0014\u0010\u0016\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"createAnnotationInstance", "T", "", "annotationClass", "Ljava/lang/Class;", "values", "", "", RequestConstants.Menu.METHODS, "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection", "hashCode", "toString"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AnnotationConstructorCallerKt {
    public static final Object transformKotlinToJvm(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof KClass) {
            obj = JvmClassMappingKt.getJavaClass((KClass) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof KClass[]) {
                Intrinsics.checkNotNull(obj);
                KClass[] kClassArr = (KClass[]) obj;
                ArrayList arrayList = new ArrayList(kClassArr.length);
                for (KClass kClass : kClassArr) {
                    arrayList.add(JvmClassMappingKt.getJavaClass(kClass));
                }
                obj = arrayList.toArray(new Class[0]);
                Intrinsics.checkNotNull(obj);
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }

    public static final Void throwIllegalArgumentType(int i, String str, Class<?> cls) {
        KClass orCreateKotlinClass;
        String qualifiedName;
        if (Intrinsics.areEqual(cls, Class.class)) {
            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KClass.class);
        } else {
            orCreateKotlinClass = (cls.isArray() && Intrinsics.areEqual(cls.getComponentType(), Class.class)) ? Reflection.getOrCreateKotlinClass(KClass[].class) : JvmClassMappingKt.getKotlinClass(cls);
        }
        if (Intrinsics.areEqual(orCreateKotlinClass.getQualifiedName(), Reflection.getOrCreateKotlinClass(Object[].class).getQualifiedName())) {
            StringBuilder sb = new StringBuilder();
            sb.append(orCreateKotlinClass.getQualifiedName());
            sb.append(Typography.less);
            Class<?> componentType = JvmClassMappingKt.getJavaClass(orCreateKotlinClass).getComponentType();
            Intrinsics.checkNotNullExpressionValue(componentType, "");
            sb.append(JvmClassMappingKt.getKotlinClass(componentType).getQualifiedName());
            sb.append(Typography.greater);
            qualifiedName = sb.toString();
        } else {
            qualifiedName = orCreateKotlinClass.getQualifiedName();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Argument #");
        sb2.append(i);
        sb2.append(InputCardNumberView.DIVIDER);
        sb2.append(str);
        sb2.append(" is not of the required type ");
        sb2.append(qualifiedName);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static /* synthetic */ Object createAnnotationInstance$default(Class cls, Map map, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            Set keySet = map.keySet();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(keySet, 10));
            Iterator it = keySet.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), new Class[0]));
            }
            list = arrayList;
        }
        return createAnnotationInstance(cls, map, list);
    }

    public static final <T> boolean createAnnotationInstance$equals(Class<T> cls, List<Method> list, Map<String, ? extends Object> map, Object obj) {
        boolean areEqual;
        boolean z;
        KClass annotationClass;
        Class cls2 = null;
        Annotation annotation = obj instanceof Annotation ? (Annotation) obj : null;
        if (annotation != null && (annotationClass = JvmClassMappingKt.getAnnotationClass(annotation)) != null) {
            cls2 = JvmClassMappingKt.getJavaClass(annotationClass);
        }
        if (Intrinsics.areEqual(cls2, cls)) {
            List<Method> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                for (Method method : list2) {
                    Object obj2 = map.get(method.getName());
                    Object invoke = method.invoke(obj, new Object[0]);
                    if (obj2 instanceof boolean[]) {
                        Intrinsics.checkNotNull(invoke);
                        areEqual = Arrays.equals((boolean[]) obj2, (boolean[]) invoke);
                    } else if (obj2 instanceof char[]) {
                        Intrinsics.checkNotNull(invoke);
                        areEqual = Arrays.equals((char[]) obj2, (char[]) invoke);
                    } else if (obj2 instanceof byte[]) {
                        Intrinsics.checkNotNull(invoke);
                        areEqual = Arrays.equals((byte[]) obj2, (byte[]) invoke);
                    } else if (obj2 instanceof short[]) {
                        Intrinsics.checkNotNull(invoke);
                        areEqual = Arrays.equals((short[]) obj2, (short[]) invoke);
                    } else if (obj2 instanceof int[]) {
                        Intrinsics.checkNotNull(invoke);
                        areEqual = Arrays.equals((int[]) obj2, (int[]) invoke);
                    } else if (obj2 instanceof float[]) {
                        Intrinsics.checkNotNull(invoke);
                        areEqual = Arrays.equals((float[]) obj2, (float[]) invoke);
                    } else if (obj2 instanceof long[]) {
                        Intrinsics.checkNotNull(invoke);
                        areEqual = Arrays.equals((long[]) obj2, (long[]) invoke);
                    } else if (obj2 instanceof double[]) {
                        Intrinsics.checkNotNull(invoke);
                        areEqual = Arrays.equals((double[]) obj2, (double[]) invoke);
                    } else if (obj2 instanceof Object[]) {
                        Intrinsics.checkNotNull(invoke);
                        areEqual = Arrays.equals((Object[]) obj2, (Object[]) invoke);
                    } else {
                        areEqual = Intrinsics.areEqual(obj2, invoke);
                    }
                    if (!areEqual) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static final <T> T createAnnotationInstance(final Class<T> cls, final Map<String, ? extends Object> map, final List<Method> list) {
        Intrinsics.checkNotNullParameter(cls, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(list, "");
        final Lazy lazy = LazyKt.lazy(new Function0<Integer>() { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                int hashCode;
                Iterator<T> it = map.entrySet().iterator();
                int i = 0;
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof boolean[]) {
                        hashCode = Arrays.hashCode((boolean[]) value);
                    } else if (value instanceof char[]) {
                        hashCode = Arrays.hashCode((char[]) value);
                    } else if (value instanceof byte[]) {
                        hashCode = Arrays.hashCode((byte[]) value);
                    } else if (value instanceof short[]) {
                        hashCode = Arrays.hashCode((short[]) value);
                    } else if (value instanceof int[]) {
                        hashCode = Arrays.hashCode((int[]) value);
                    } else if (value instanceof float[]) {
                        hashCode = Arrays.hashCode((float[]) value);
                    } else if (value instanceof long[]) {
                        hashCode = Arrays.hashCode((long[]) value);
                    } else if (value instanceof double[]) {
                        hashCode = Arrays.hashCode((double[]) value);
                    } else {
                        hashCode = value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode();
                    }
                    i += hashCode ^ (str.hashCode() * 127);
                }
                return Integer.valueOf(i);
            }
        });
        final Lazy lazy2 = LazyKt.lazy(new Function0<String>() { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$toString$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Class<T> cls2 = cls;
                Map<String, Object> map2 = map;
                StringBuilder sb = new StringBuilder();
                sb.append('@');
                sb.append(cls2.getCanonicalName());
                CollectionsKt.joinTo$default(map2.entrySet(), sb, ", ", "(", ")", 0, null, new Function1<Map.Entry<? extends String, ? extends Object>, CharSequence>() { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends Object> entry) {
                        return invoke2((Map.Entry<String, ? extends Object>) entry);
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final CharSequence invoke2(Map.Entry<String, ? extends Object> entry) {
                        String obj;
                        Intrinsics.checkNotNullParameter(entry, "");
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof boolean[]) {
                            obj = Arrays.toString((boolean[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "");
                        } else if (value instanceof char[]) {
                            obj = Arrays.toString((char[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "");
                        } else if (value instanceof byte[]) {
                            obj = Arrays.toString((byte[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "");
                        } else if (value instanceof short[]) {
                            obj = Arrays.toString((short[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "");
                        } else if (value instanceof int[]) {
                            obj = Arrays.toString((int[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "");
                        } else if (value instanceof float[]) {
                            obj = Arrays.toString((float[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "");
                        } else if (value instanceof long[]) {
                            obj = Arrays.toString((long[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "");
                        } else if (value instanceof double[]) {
                            obj = Arrays.toString((double[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "");
                        } else if (value instanceof Object[]) {
                            obj = Arrays.toString((Object[]) value);
                            Intrinsics.checkNotNullExpressionValue(obj, "");
                        } else {
                            obj = value.toString();
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(key);
                        sb2.append('=');
                        sb2.append(obj);
                        return sb2.toString();
                    }
                }, 48, null);
                String obj = sb.toString();
                Intrinsics.checkNotNullExpressionValue(obj, "");
                return obj;
            }
        });
        T t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$result$1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                boolean createAnnotationInstance$equals;
                String m4432createAnnotationInstance$lambda3;
                int m4431createAnnotationInstance$lambda2;
                String name = method.getName();
                if (name != null) {
                    int hashCode = name.hashCode();
                    if (hashCode != -1776922004) {
                        if (hashCode != 147696667) {
                            if (hashCode == 1444986633 && name.equals("annotationType")) {
                                return cls;
                            }
                        } else if (name.equals("hashCode")) {
                            m4431createAnnotationInstance$lambda2 = AnnotationConstructorCallerKt.m4431createAnnotationInstance$lambda2(lazy);
                            return Integer.valueOf(m4431createAnnotationInstance$lambda2);
                        }
                    } else if (name.equals("toString")) {
                        m4432createAnnotationInstance$lambda3 = AnnotationConstructorCallerKt.m4432createAnnotationInstance$lambda3(lazy2);
                        return m4432createAnnotationInstance$lambda3;
                    }
                }
                if (Intrinsics.areEqual(name, "equals")) {
                    if (objArr != null && objArr.length == 1) {
                        Class<T> cls2 = cls;
                        List<Method> list2 = list;
                        Map<String, Object> map2 = map;
                        Intrinsics.checkNotNullExpressionValue(objArr, "");
                        createAnnotationInstance$equals = AnnotationConstructorCallerKt.createAnnotationInstance$equals(cls2, list2, map2, ArraysKt.single(objArr));
                        return Boolean.valueOf(createAnnotationInstance$equals);
                    }
                }
                if (map.containsKey(name)) {
                    return map.get(name);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Method is not supported: ");
                sb.append(method);
                sb.append(" (args: ");
                if (objArr == null) {
                    objArr = new Object[0];
                }
                sb.append(ArraysKt.toList(objArr));
                sb.append(')');
                throw new KotlinReflectionInternalError(sb.toString());
            }
        });
        Intrinsics.checkNotNull(t);
        return t;
    }

    /* renamed from: createAnnotationInstance$lambda-2 */
    public static final int m4431createAnnotationInstance$lambda2(Lazy<Integer> lazy) {
        return lazy.getValue().intValue();
    }

    /* renamed from: createAnnotationInstance$lambda-3 */
    public static final String m4432createAnnotationInstance$lambda3(Lazy<String> lazy) {
        return lazy.getValue();
    }
}
