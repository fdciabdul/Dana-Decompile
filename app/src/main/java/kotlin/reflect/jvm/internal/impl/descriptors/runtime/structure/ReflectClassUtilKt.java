package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.sendmoney.summary.SummaryActivity;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public final class ReflectClassUtilKt {
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
    private static final List<KClass<? extends Object>> PRIMITIVE_CLASSES;
    private static final Map<Class<? extends Object>, Class<? extends Object>> PRIMITIVE_TO_WRAPPER;
    private static final Map<Class<? extends Object>, Class<? extends Object>> WRAPPER_TO_PRIMITIVE;

    public static final ClassLoader getSafeClassLoader(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            Intrinsics.checkNotNullExpressionValue(systemClassLoader, "");
            return systemClassLoader;
        }
        return classLoader;
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "");
        return Enum.class.isAssignableFrom(cls);
    }

    static {
        int i = 0;
        List<KClass<? extends Object>> listOf = CollectionsKt.listOf((Object[]) new KClass[]{Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE)});
        PRIMITIVE_CLASSES = listOf;
        List<KClass<? extends Object>> list = listOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            KClass kClass = (KClass) it.next();
            arrayList.add(TuplesKt.to(JvmClassMappingKt.getJavaObjectType(kClass), JvmClassMappingKt.getJavaPrimitiveType(kClass)));
        }
        WRAPPER_TO_PRIMITIVE = MapsKt.toMap(arrayList);
        List<KClass<? extends Object>> list2 = PRIMITIVE_CLASSES;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            KClass kClass2 = (KClass) it2.next();
            arrayList2.add(TuplesKt.to(JvmClassMappingKt.getJavaPrimitiveType(kClass2), JvmClassMappingKt.getJavaObjectType(kClass2)));
        }
        PRIMITIVE_TO_WRAPPER = MapsKt.toMap(arrayList2);
        List listOf2 = CollectionsKt.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf2, 10));
        for (Object obj : listOf2) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList3.add(TuplesKt.to((Class) obj, Integer.valueOf(i)));
            i++;
        }
        FUNCTION_CLASSES = MapsKt.toMap(arrayList3);
    }

    public static final Class<?> getPrimitiveByWrapper(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "");
        return WRAPPER_TO_PRIMITIVE.get(cls);
    }

    public static final Class<?> getWrapperByPrimitive(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "");
        return PRIMITIVE_TO_WRAPPER.get(cls);
    }

    public static final Integer getFunctionClassArity(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "");
        return FUNCTION_CLASSES.get(cls);
    }

    public static final ClassId getClassId(Class<?> cls) {
        ClassId classId;
        ClassId classId2;
        Intrinsics.checkNotNullParameter(cls, "");
        if (cls.isPrimitive()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't compute ClassId for primitive type: ");
            sb.append(cls);
            throw new IllegalArgumentException(sb.toString());
        } else if (cls.isArray()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't compute ClassId for array type: ");
            sb2.append(cls);
            throw new IllegalArgumentException(sb2.toString());
        } else {
            if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                String simpleName = cls.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "");
                if (!(simpleName.length() == 0)) {
                    Class<?> declaringClass = cls.getDeclaringClass();
                    if (declaringClass == null || (classId2 = getClassId(declaringClass)) == null || (classId = classId2.createNestedClassId(Name.identifier(cls.getSimpleName()))) == null) {
                        classId = ClassId.topLevel(new FqName(cls.getName()));
                    }
                    Intrinsics.checkNotNullExpressionValue(classId, "");
                    return classId;
                }
            }
            FqName fqName = new FqName(cls.getName());
            return new ClassId(fqName.parent(), FqName.topLevel(fqName.shortName()), true);
        }
    }

    public static final String getDesc(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "");
        if (cls.isPrimitive()) {
            String name = cls.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            return SummaryActivity.DAYS;
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            return "I";
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            return DiskFormatter.B;
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            return "C";
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            return "J";
                        }
                        break;
                    case 3625364:
                        if (name.equals("void")) {
                            return "V";
                        }
                        break;
                    case 64711720:
                        if (name.equals("boolean")) {
                            return "Z";
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            return LogConstants.RESULT_FALSE;
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            return "S";
                        }
                        break;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported primitive type: ");
            sb.append(cls);
            throw new IllegalArgumentException(sb.toString());
        } else if (cls.isArray()) {
            String name2 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "");
            return StringsKt.replace$default(name2, '.', '/', false, 4, (Object) null);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('L');
            String name3 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "");
            sb2.append(StringsKt.replace$default(name3, '.', '/', false, 4, (Object) null));
            sb2.append(';');
            return sb2.toString();
        }
    }

    public static final List<Type> getParameterizedTypeArguments(Type type) {
        Intrinsics.checkNotNullParameter(type, "");
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (parameterizedType.getOwnerType() == null) {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "");
                return ArraysKt.toList(actualTypeArguments);
            }
            return SequencesKt.toList(SequencesKt.flatMap(SequencesKt.generateSequence(type, new Function1<ParameterizedType, ParameterizedType>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt$parameterizedTypeArguments$1
                @Override // kotlin.jvm.functions.Function1
                public final ParameterizedType invoke(ParameterizedType parameterizedType2) {
                    Intrinsics.checkNotNullParameter(parameterizedType2, "");
                    Type ownerType = parameterizedType2.getOwnerType();
                    if (ownerType instanceof ParameterizedType) {
                        return (ParameterizedType) ownerType;
                    }
                    return null;
                }
            }), new Function1<ParameterizedType, Sequence<? extends Type>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt$parameterizedTypeArguments$2
                @Override // kotlin.jvm.functions.Function1
                public final Sequence<Type> invoke(ParameterizedType parameterizedType2) {
                    Intrinsics.checkNotNullParameter(parameterizedType2, "");
                    Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                    Intrinsics.checkNotNullExpressionValue(actualTypeArguments2, "");
                    return ArraysKt.asSequence(actualTypeArguments2);
                }
            }));
        }
        return CollectionsKt.emptyList();
    }
}
