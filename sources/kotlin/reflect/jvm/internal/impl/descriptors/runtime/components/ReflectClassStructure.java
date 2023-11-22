package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ReflectClassStructure {
    public static final ReflectClassStructure INSTANCE = new ReflectClassStructure();

    private ReflectClassStructure() {
    }

    public final void loadClassAnnotations(Class<?> cls, KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor) {
        Intrinsics.checkNotNullParameter(cls, "");
        Intrinsics.checkNotNullParameter(annotationVisitor, "");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "");
        for (Annotation annotation : declaredAnnotations) {
            Intrinsics.checkNotNullExpressionValue(annotation, "");
            processAnnotation(annotationVisitor, annotation);
        }
        annotationVisitor.visitEnd();
    }

    public final void visitMembers(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Intrinsics.checkNotNullParameter(cls, "");
        Intrinsics.checkNotNullParameter(memberVisitor, "");
        loadMethodAnnotations(cls, memberVisitor);
        loadConstructorAnnotations(cls, memberVisitor);
        loadFieldAnnotations(cls, memberVisitor);
    }

    private final void loadMethodAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Method[] methodArr;
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "");
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            Method method = declaredMethods[i];
            Name identifier = Name.identifier(method.getName());
            Intrinsics.checkNotNullExpressionValue(identifier, "");
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(method, "");
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(identifier, signatureSerializer.methodDesc(method));
            if (visitMethod != null) {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "");
                for (Annotation annotation : declaredAnnotations) {
                    Intrinsics.checkNotNullExpressionValue(annotation, "");
                    processAnnotation(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "");
                Annotation[][] annotationArr = parameterAnnotations;
                int length2 = annotationArr.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    Annotation[] annotationArr2 = annotationArr[i2];
                    Intrinsics.checkNotNullExpressionValue(annotationArr2, "");
                    int length3 = annotationArr2.length;
                    int i3 = 0;
                    while (i3 < length3) {
                        Annotation annotation2 = annotationArr2[i3];
                        Class<?> javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation2));
                        ClassId classId = ReflectClassUtilKt.getClassId(javaClass);
                        Intrinsics.checkNotNullExpressionValue(annotation2, "");
                        Method[] methodArr2 = declaredMethods;
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i2, classId, new ReflectAnnotationSource(annotation2));
                        if (visitParameterAnnotation != null) {
                            INSTANCE.processAnnotationArguments(visitParameterAnnotation, annotation2, javaClass);
                        }
                        i3++;
                        declaredMethods = methodArr2;
                    }
                }
                methodArr = declaredMethods;
                visitMethod.visitEnd();
            } else {
                methodArr = declaredMethods;
            }
            i++;
            declaredMethods = methodArr;
        }
    }

    private final void loadConstructorAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Constructor<?>[] constructorArr;
        String str;
        int i;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        String str2 = "";
        Intrinsics.checkNotNullExpressionValue(declaredConstructors, "");
        int length = declaredConstructors.length;
        int i2 = 0;
        while (i2 < length) {
            Constructor<?> constructor = declaredConstructors[i2];
            Name name = SpecialNames.INIT;
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(constructor, str2);
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(name, signatureSerializer.constructorDesc(constructor));
            if (visitMethod != null) {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations, str2);
                for (Annotation annotation : declaredAnnotations) {
                    Intrinsics.checkNotNullExpressionValue(annotation, str2);
                    processAnnotation(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                Intrinsics.checkNotNullExpressionValue(parameterAnnotations, str2);
                Annotation[][] annotationArr = parameterAnnotations;
                if ((!(annotationArr.length == 0)) != false) {
                    int length2 = constructor.getParameterTypes().length - annotationArr.length;
                    int length3 = annotationArr.length;
                    for (int i3 = 0; i3 < length3; i3++) {
                        Annotation[] annotationArr2 = parameterAnnotations[i3];
                        Intrinsics.checkNotNullExpressionValue(annotationArr2, str2);
                        int length4 = annotationArr2.length;
                        int i4 = 0;
                        while (i4 < length4) {
                            Annotation annotation2 = annotationArr2[i4];
                            Class<?> javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation2));
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            ClassId classId = ReflectClassUtilKt.getClassId(javaClass);
                            Intrinsics.checkNotNullExpressionValue(annotation2, str2);
                            String str3 = str2;
                            int i5 = length;
                            KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i3 + length2, classId, new ReflectAnnotationSource(annotation2));
                            if (visitParameterAnnotation != null) {
                                INSTANCE.processAnnotationArguments(visitParameterAnnotation, annotation2, javaClass);
                            }
                            i4++;
                            declaredConstructors = constructorArr2;
                            str2 = str3;
                            length = i5;
                        }
                    }
                }
                constructorArr = declaredConstructors;
                str = str2;
                i = length;
                visitMethod.visitEnd();
            } else {
                constructorArr = declaredConstructors;
                str = str2;
                i = length;
            }
            i2++;
            declaredConstructors = constructorArr;
            str2 = str;
            length = i;
        }
    }

    private final void loadFieldAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "");
        for (Field field : declaredFields) {
            Name identifier = Name.identifier(field.getName());
            Intrinsics.checkNotNullExpressionValue(identifier, "");
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(field, "");
            KotlinJvmBinaryClass.AnnotationVisitor visitField = memberVisitor.visitField(identifier, signatureSerializer.fieldDesc(field), null);
            if (visitField != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "");
                for (Annotation annotation : declaredAnnotations) {
                    Intrinsics.checkNotNullExpressionValue(annotation, "");
                    processAnnotation(visitField, annotation);
                }
                visitField.visitEnd();
            }
        }
    }

    private final void processAnnotation(KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, Annotation annotation) {
        Class<?> javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation));
        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationVisitor.visitAnnotation(ReflectClassUtilKt.getClassId(javaClass), new ReflectAnnotationSource(annotation));
        if (visitAnnotation != null) {
            INSTANCE.processAnnotationArguments(visitAnnotation, annotation, javaClass);
        }
    }

    private final void processAnnotationArguments(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, Annotation annotation, Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "");
        for (Method method : declaredMethods) {
            try {
                Object invoke = method.invoke(annotation, new Object[0]);
                Intrinsics.checkNotNull(invoke);
                Name identifier = Name.identifier(method.getName());
                Intrinsics.checkNotNullExpressionValue(identifier, "");
                processAnnotationArgumentValue(annotationArgumentVisitor, identifier, invoke);
            } catch (IllegalAccessException unused) {
            }
        }
        annotationArgumentVisitor.visitEnd();
    }

    private final ClassLiteralValue classLiteralValue(Class<?> cls) {
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
            Intrinsics.checkNotNullExpressionValue(cls, "");
        }
        if (cls.isPrimitive()) {
            if (Intrinsics.areEqual(cls, Void.TYPE)) {
                ClassId classId = ClassId.topLevel(StandardNames.FqNames.unit.toSafe());
                Intrinsics.checkNotNullExpressionValue(classId, "");
                return new ClassLiteralValue(classId, i);
            }
            PrimitiveType primitiveType = JvmPrimitiveType.get(cls.getName()).getPrimitiveType();
            Intrinsics.checkNotNullExpressionValue(primitiveType, "");
            if (i > 0) {
                ClassId classId2 = ClassId.topLevel(primitiveType.getArrayTypeFqName());
                Intrinsics.checkNotNullExpressionValue(classId2, "");
                return new ClassLiteralValue(classId2, i - 1);
            }
            ClassId classId3 = ClassId.topLevel(primitiveType.getTypeFqName());
            Intrinsics.checkNotNullExpressionValue(classId3, "");
            return new ClassLiteralValue(classId3, i);
        }
        ClassId classId4 = ReflectClassUtilKt.getClassId(cls);
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqName asSingleFqName = classId4.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "");
        ClassId mapJavaToKotlin = javaToKotlinClassMap.mapJavaToKotlin(asSingleFqName);
        if (mapJavaToKotlin != null) {
            classId4 = mapJavaToKotlin;
        }
        return new ClassLiteralValue(classId4, i);
    }

    private final void processAnnotationArgumentValue(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, Name name, Object obj) {
        Set set;
        Class<?> cls = obj.getClass();
        if (!Intrinsics.areEqual(cls, Class.class)) {
            set = ReflectKotlinClassKt.TYPES_ELIGIBLE_FOR_SIMPLE_VISIT;
            if (set.contains(cls)) {
                annotationArgumentVisitor.visit(name, obj);
                return;
            } else if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(cls)) {
                if (!cls.isEnum()) {
                    cls = cls.getEnclosingClass();
                }
                Intrinsics.checkNotNullExpressionValue(cls, "");
                ClassId classId = ReflectClassUtilKt.getClassId(cls);
                Intrinsics.checkNotNull(obj);
                Name identifier = Name.identifier(((Enum) obj).name());
                Intrinsics.checkNotNullExpressionValue(identifier, "");
                annotationArgumentVisitor.visitEnum(name, classId, identifier);
                return;
            } else if (Annotation.class.isAssignableFrom(cls)) {
                Class<?>[] interfaces = cls.getInterfaces();
                Intrinsics.checkNotNullExpressionValue(interfaces, "");
                Class<?> cls2 = (Class) ArraysKt.single(interfaces);
                Intrinsics.checkNotNullExpressionValue(cls2, "");
                KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationArgumentVisitor.visitAnnotation(name, ReflectClassUtilKt.getClassId(cls2));
                if (visitAnnotation == null) {
                    return;
                }
                Intrinsics.checkNotNull(obj);
                processAnnotationArguments(visitAnnotation, (Annotation) obj, cls2);
                return;
            } else if (cls.isArray()) {
                KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray = annotationArgumentVisitor.visitArray(name);
                if (visitArray == null) {
                    return;
                }
                Class<?> componentType = cls.getComponentType();
                int i = 0;
                if (componentType.isEnum()) {
                    Intrinsics.checkNotNullExpressionValue(componentType, "");
                    ClassId classId2 = ReflectClassUtilKt.getClassId(componentType);
                    Intrinsics.checkNotNull(obj);
                    Object[] objArr = (Object[]) obj;
                    int length = objArr.length;
                    while (i < length) {
                        Object obj2 = objArr[i];
                        Intrinsics.checkNotNull(obj2);
                        Name identifier2 = Name.identifier(((Enum) obj2).name());
                        Intrinsics.checkNotNullExpressionValue(identifier2, "");
                        visitArray.visitEnum(classId2, identifier2);
                        i++;
                    }
                } else if (Intrinsics.areEqual(componentType, Class.class)) {
                    Intrinsics.checkNotNull(obj);
                    Object[] objArr2 = (Object[]) obj;
                    int length2 = objArr2.length;
                    while (i < length2) {
                        Object obj3 = objArr2[i];
                        Intrinsics.checkNotNull(obj3);
                        visitArray.visitClassLiteral(classLiteralValue((Class) obj3));
                        i++;
                    }
                } else if (Annotation.class.isAssignableFrom(componentType)) {
                    Intrinsics.checkNotNull(obj);
                    Object[] objArr3 = (Object[]) obj;
                    int length3 = objArr3.length;
                    while (i < length3) {
                        Object obj4 = objArr3[i];
                        Intrinsics.checkNotNullExpressionValue(componentType, "");
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation2 = visitArray.visitAnnotation(ReflectClassUtilKt.getClassId(componentType));
                        if (visitAnnotation2 != null) {
                            Intrinsics.checkNotNull(obj4);
                            processAnnotationArguments(visitAnnotation2, (Annotation) obj4, componentType);
                        }
                        i++;
                    }
                } else {
                    Intrinsics.checkNotNull(obj);
                    Object[] objArr4 = (Object[]) obj;
                    int length4 = objArr4.length;
                    while (i < length4) {
                        visitArray.visit(objArr4[i]);
                        i++;
                    }
                }
                visitArray.visitEnd();
                return;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unsupported annotation argument value (");
                sb.append(cls);
                sb.append("): ");
                sb.append(obj);
                throw new UnsupportedOperationException(sb.toString());
            }
        }
        Intrinsics.checkNotNull(obj);
        annotationArgumentVisitor.visitClassLiteral(name, classLiteralValue((Class) obj));
    }
}
