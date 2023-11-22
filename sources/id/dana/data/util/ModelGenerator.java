package id.dana.data.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0005\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/util/ModelGenerator;", "", "<init>", "()V", "Companion", "ClassConstructor"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ModelGenerator {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b-\u0010.J%\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\f\u0010\rJ%\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000eH\u0002¢\u0006\u0004\b\f\u0010\u0010J#\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0015\"\u0004\b\u0000\u0010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00012\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u0014J\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001c\u0010\u001fJ#\u0010!\u001a\u00020 \"\u0004\b\u0000\u0010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0002¢\u0006\u0004\b!\u0010\"J%\u0010#\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0002¢\u0006\u0004\b#\u0010\u0014J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020 H\u0002¢\u0006\u0004\b&\u0010'J)\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(\"\u0004\b\u0000\u0010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0002¢\u0006\u0004\b)\u0010\u0017J\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010(2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b)\u0010,"}, d2 = {"Lid/dana/data/util/ModelGenerator$Companion;", "", "T", "newInstance", "Ljava/lang/reflect/Field;", "field", "", "assignValue", "(Ljava/lang/Object;Ljava/lang/reflect/Field;)V", "Ljava/lang/reflect/Constructor;", "constructor", "Lid/dana/data/util/ModelGenerator$ClassConstructor;", "createConstructorParams", "(Ljava/lang/reflect/Constructor;)Lid/dana/data/util/ModelGenerator$ClassConstructor;", "", "constructors", "([Ljava/lang/reflect/Constructor;)Lid/dana/data/util/ModelGenerator$ClassConstructor;", "Ljava/lang/Class;", "classObject", "generateNewObject", "(Ljava/lang/Class;)Ljava/lang/Object;", "", "generatePrimitiveListObject", "(Ljava/lang/Class;)Ljava/util/List;", "Ljava/lang/reflect/Type;", "type", "getClassObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Class;", "getNewValue", "Ljava/lang/reflect/Parameter;", "param", "(Ljava/lang/reflect/Parameter;)Ljava/lang/Object;", "", "getTypeName", "(Ljava/lang/Class;)Ljava/lang/String;", "initNewInstance", "typeName", "", "isList", "(Ljava/lang/String;)Z", "", "newListInstance", "Ljava/lang/reflect/ParameterizedType;", "parameterizedType", "(Ljava/lang/reflect/ParameterizedType;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> List<T> generatePrimitiveListObject(Class<T> classObject) {
            Intrinsics.checkNotNullParameter(classObject, "");
            ArrayList arrayList = new ArrayList();
            int randomInt = RandomMatchers.randomInt();
            if (randomInt >= 0) {
                int i = 0;
                while (true) {
                    arrayList.add(getNewValue((Class<?>) classObject));
                    if (i == randomInt) {
                        break;
                    }
                    i++;
                }
            }
            return arrayList;
        }

        public final <T> T generateNewObject(Class<T> classObject) {
            Intrinsics.checkNotNullParameter(classObject, "");
            T t = (T) initNewInstance(classObject);
            Field[] declaredFields = classObject.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "");
            for (Field field : declaredFields) {
                classObject.getDeclaredField(field.getName());
                field.setAccessible(true);
                try {
                    Companion companion = ModelGenerator.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(field, "");
                    companion.assignValue(t, field);
                } catch (Exception unused) {
                }
                field.setAccessible(false);
            }
            return t;
        }

        private final <T> T initNewInstance(Class<T> classObject) {
            T newInstance;
            Constructor<?>[] constructors = classObject.getConstructors();
            try {
                Intrinsics.checkNotNullExpressionValue(constructors, "");
                if ((!(constructors.length == 0)) != false) {
                    ClassConstructor<?> createConstructorParams = createConstructorParams(constructors);
                    newInstance = (T) NewInstanceGenerator.createInstance(createConstructorParams.getAuthRequestContext, createConstructorParams.BuiltInFictitiousFunctionClassFactory);
                } else {
                    Constructor<?>[] declaredConstructors = classObject.getDeclaredConstructors();
                    Intrinsics.checkNotNullExpressionValue(declaredConstructors, "");
                    if ((!(declaredConstructors.length == 0)) != false) {
                        Constructor<?> constructor = classObject.getDeclaredConstructors()[0];
                        constructor.setAccessible(true);
                        newInstance = (T) constructor.newInstance(new Object[0]);
                    } else {
                        newInstance = classObject.newInstance();
                    }
                }
                return newInstance;
            } catch (Exception unused) {
                return null;
            }
        }

        private final ClassConstructor<?> createConstructorParams(Constructor<?>[] constructors) {
            return createConstructorParams(constructors[0]);
        }

        private final <T> ClassConstructor<T> createConstructorParams(Constructor<T> constructor) {
            ArrayList arrayList = new ArrayList();
            constructor.setAccessible(true);
            Parameter[] parameters = constructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "");
            for (Parameter parameter : parameters) {
                Companion companion = ModelGenerator.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(parameter, "");
                Object newValue = companion.getNewValue(parameter);
                if (newValue != null) {
                    arrayList.add(newValue);
                }
            }
            return new ClassConstructor<>(constructor, arrayList);
        }

        private final List<Object> newListInstance(ParameterizedType parameterizedType) {
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "");
            if ((!(actualTypeArguments.length == 0)) != false) {
                Type type = parameterizedType.getActualTypeArguments()[0];
                Intrinsics.checkNotNullExpressionValue(type, "");
                return newListInstance(getClassObject(type));
            }
            return CollectionsKt.emptyList();
        }

        private final <T> List<T> newListInstance(Class<T> classObject) {
            ArrayList arrayList = new ArrayList();
            int randomInt = RandomMatchers.randomInt();
            if (randomInt >= 0) {
                int i = 0;
                while (true) {
                    Object generateNewObject = generateNewObject(classObject);
                    if (generateNewObject != null) {
                        arrayList.add(generateNewObject);
                    }
                    if (i == randomInt) {
                        break;
                    }
                    i++;
                }
            }
            return arrayList;
        }

        private final Class<?> getClassObject(Type type) {
            if ((type instanceof WildcardType) && (type = ((WildcardType) type).getUpperBounds()[0]) == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
            }
            return (Class) type;
        }

        private final Object getNewValue(Parameter param) {
            String name = param.getType().getName();
            Intrinsics.checkNotNullExpressionValue(name, "");
            if (!isList(name)) {
                Class<?> type = param.getType();
                Intrinsics.checkNotNullExpressionValue(type, "");
                return getNewValue(type);
            }
            Type parameterizedType = param.getParameterizedType();
            if (parameterizedType != null) {
                return newListInstance((ParameterizedType) parameterizedType);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        }

        private final boolean isList(String typeName) {
            return Intrinsics.areEqual(getTypeName(List.class), typeName);
        }

        private final Object getNewValue(Class<?> type) {
            String name = type.getName();
            if (Intrinsics.areEqual(name, getTypeName(Integer.TYPE))) {
                return Integer.valueOf(RandomMatchers.randomInt());
            }
            if (Intrinsics.areEqual(name, getTypeName(String.class))) {
                return RandomMatchers.randomString();
            }
            if (Intrinsics.areEqual(name, getTypeName(Float.TYPE))) {
                return Float.valueOf(Random.INSTANCE.nextFloat());
            }
            if (Intrinsics.areEqual(name, getTypeName(Boolean.TYPE))) {
                return Boolean.valueOf(RandomMatchers.randomBoolean());
            }
            if (Intrinsics.areEqual(name, getTypeName(Character.TYPE))) {
                return Character.valueOf(RandomMatchers.randomChar());
            }
            if (Intrinsics.areEqual(name, getTypeName(Double.TYPE))) {
                return Double.valueOf(Random.INSTANCE.nextDouble());
            }
            if (Intrinsics.areEqual(name, getTypeName(Long.TYPE))) {
                return Long.valueOf(RandomMatchers.randomLong());
            }
            if (Intrinsics.areEqual(name, getTypeName(HashMap.class)) ? true : Intrinsics.areEqual(name, getTypeName(Map.class))) {
                return new HashMap();
            }
            return Intrinsics.areEqual(name, getTypeName(Date.class)) ? new Date() : generateNewObject(type);
        }

        private final <T> String getTypeName(Class<T> classObject) {
            String name = classObject.getName();
            Intrinsics.checkNotNullExpressionValue(name, "");
            return name;
        }

        private final <T> void assignValue(T newInstance, Field field) {
            String name = field.getType().getName();
            Intrinsics.checkNotNullExpressionValue(name, "");
            if (!isList(name)) {
                Class<?> type = field.getType();
                Intrinsics.checkNotNullExpressionValue(type, "");
                field.set(newInstance, getNewValue(type));
                return;
            }
            Type genericType = field.getGenericType();
            if (genericType != null) {
                field.set(newInstance, newListInstance((ParameterizedType) genericType));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/data/util/ModelGenerator$ClassConstructor;", "T", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/reflect/Constructor;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/reflect/Constructor;", "getAuthRequestContext", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "p1", "<init>", "(Ljava/lang/reflect/Constructor;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final /* data */ class ClassConstructor<T> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final Constructor<T> getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final List<Object> BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof ClassConstructor) {
                ClassConstructor classConstructor = (ClassConstructor) p0;
                return Intrinsics.areEqual(this.getAuthRequestContext, classConstructor.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, classConstructor.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        public final int hashCode() {
            return (this.getAuthRequestContext.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ClassConstructor(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        public ClassConstructor(Constructor<T> constructor, List<? extends Object> list) {
            Intrinsics.checkNotNullParameter(constructor, "");
            Intrinsics.checkNotNullParameter(list, "");
            this.getAuthRequestContext = constructor;
            this.BuiltInFictitiousFunctionClassFactory = list;
        }
    }
}
