package kotlin.reflect.full;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

@Metadata(d1 = {"\u0000^\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u001a+\u0010\u0004\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\n\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00022\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a!\u0010\r\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00022\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\r\u0010\u000b\u001a-\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000e\u0010\u0005\")\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00028G¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\"%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f*\u0006\u0012\u0002\b\u00030\u00028G¢\u0006\f\u0012\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0016\u0010\u0011\"%\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028G¢\u0006\f\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u001a\"!\u0010\u001f\u001a\u0004\u0018\u00010\u0000*\u0006\u0012\u0002\b\u00030\u00028G¢\u0006\f\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001d\u0010\u0007\")\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u000f*\u0006\u0012\u0002\b\u00030\u00028G¢\u0006\f\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b!\u0010\u0011\")\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u000f*\u0006\u0012\u0002\b\u00030\u00028G¢\u0006\f\u0012\u0004\b%\u0010\u0013\u001a\u0004\b$\u0010\u0011\"?\u0010*\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u00030'0\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028G¢\u0006\f\u0012\u0004\b)\u0010\u0013\u001a\u0004\b(\u0010\u0011\")\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u000f*\u0006\u0012\u0002\b\u00030\u00028G¢\u0006\f\u0012\u0004\b,\u0010\u0013\u001a\u0004\b+\u0010\u0011\";\u00101\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030.0\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028G¢\u0006\f\u0012\u0004\b0\u0010\u0013\u001a\u0004\b/\u0010\u0011\")\u00105\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u000f*\u0006\u0012\u0002\b\u00030\u00028G¢\u0006\f\u0012\u0004\b4\u0010\u0013\u001a\u0004\b3\u0010\u0011\"\"\u00109\u001a\u00020\u0015*\u0006\u0012\u0002\b\u00030\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0013\u001a\u0004\b6\u00107\")\u0010<\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u000f*\u0006\u0012\u0002\b\u00030\u00028G¢\u0006\f\u0012\u0004\b;\u0010\u0013\u001a\u0004\b:\u0010\u0011\"\u001c\u0010>\u001a\u00020\t*\u0006\u0012\u0002\b\u00030=8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?\"\u001c\u0010@\u001a\u00020\t*\u0006\u0012\u0002\b\u00030=8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010?\")\u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u000f*\u0006\u0012\u0002\b\u00030\u00028G¢\u0006\f\u0012\u0004\bB\u0010\u0013\u001a\u0004\bA\u0010\u0011\"?\u0010F\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u00030'0\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028G¢\u0006\f\u0012\u0004\bE\u0010\u0013\u001a\u0004\bD\u0010\u0011\")\u0010I\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u000f*\u0006\u0012\u0002\b\u00030\u00028G¢\u0006\f\u0012\u0004\bH\u0010\u0013\u001a\u0004\bG\u0010\u0011\";\u0010L\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030.0\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028G¢\u0006\f\u0012\u0004\bK\u0010\u0013\u001a\u0004\bJ\u0010\u0011\"3\u0010P\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 \"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028G¢\u0006\f\u0012\u0004\bO\u0010\u0013\u001a\u0004\bM\u0010N\")\u0010S\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u000f*\u0006\u0012\u0002\b\u00030\u00028G¢\u0006\f\u0012\u0004\bR\u0010\u0013\u001a\u0004\bQ\u0010\u0011\")\u0010W\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030T0\u000f*\u0006\u0012\u0002\b\u00030\u00028G¢\u0006\f\u0012\u0004\bV\u0010\u0013\u001a\u0004\bU\u0010\u0011\")\u0010\\\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020X*\u0006\u0012\u0002\b\u00030\u00028G¢\u0006\f\u0012\u0004\b[\u0010\u0013\u001a\u0004\bY\u0010Z"}, d2 = {"", "T", "Lkotlin/reflect/KClass;", "value", "cast", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "createInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "base", "", "isSubclassOf", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)Z", "derived", "isSuperclassOf", "safeCast", "", "getAllSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "getAllSuperclasses$annotations", "(Lkotlin/reflect/KClass;)V", "allSuperclasses", "Lkotlin/reflect/KType;", "getAllSupertypes", "getAllSupertypes$annotations", "allSupertypes", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "getCompanionObject$annotations", "companionObject", "getCompanionObjectInstance", "getCompanionObjectInstance$annotations", "companionObjectInstance", "Lkotlin/reflect/KFunction;", "getDeclaredFunctions", "getDeclaredFunctions$annotations", "declaredFunctions", "getDeclaredMemberExtensionFunctions", "getDeclaredMemberExtensionFunctions$annotations", "declaredMemberExtensionFunctions", "Lkotlin/reflect/KProperty2;", "getDeclaredMemberExtensionProperties", "getDeclaredMemberExtensionProperties$annotations", "declaredMemberExtensionProperties", "getDeclaredMemberFunctions", "getDeclaredMemberFunctions$annotations", "declaredMemberFunctions", "Lkotlin/reflect/KProperty1;", "getDeclaredMemberProperties", "getDeclaredMemberProperties$annotations", "declaredMemberProperties", "Lkotlin/reflect/KCallable;", "getDeclaredMembers", "getDeclaredMembers$annotations", "declaredMembers", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "getDefaultType$annotations", "defaultType", "getFunctions", "getFunctions$annotations", "functions", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "isExtension", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "getMemberExtensionFunctions", "getMemberExtensionFunctions$annotations", "memberExtensionFunctions", "getMemberExtensionProperties", "getMemberExtensionProperties$annotations", "memberExtensionProperties", "getMemberFunctions", "getMemberFunctions$annotations", "memberFunctions", "getMemberProperties", "getMemberProperties$annotations", "memberProperties", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "getPrimaryConstructor$annotations", "primaryConstructor", "getStaticFunctions", "getStaticFunctions$annotations", "staticFunctions", "Lkotlin/reflect/KProperty0;", "getStaticProperties", "getStaticProperties$annotations", "staticProperties", "", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "getSuperclasses$annotations", "superclasses"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class KClasses {
    public static /* synthetic */ void getAllSuperclasses$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getAllSupertypes$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getCompanionObject$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getCompanionObjectInstance$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberExtensionFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberExtensionProperties$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberProperties$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMembers$annotations(KClass kClass) {
    }

    @Deprecated(message = "This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    public static /* synthetic */ void getDefaultType$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getMemberExtensionFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getMemberExtensionProperties$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getMemberFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getMemberProperties$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getPrimaryConstructor$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getStaticFunctions$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getStaticProperties$annotations(KClass kClass) {
    }

    public static /* synthetic */ void getSuperclasses$annotations(KClass kClass) {
    }

    @JvmName(name = "getPrimaryConstructor")
    public static final <T> KFunction<T> getPrimaryConstructor(KClass<T> kClass) {
        T t;
        Intrinsics.checkNotNullParameter(kClass, "");
        Iterator<T> it = ((KClassImpl) kClass).getConstructors().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            KFunction kFunction = (KFunction) t;
            Intrinsics.checkNotNull(kFunction);
            FunctionDescriptor descriptor = ((KFunctionImpl) kFunction).getDescriptor();
            Intrinsics.checkNotNull(descriptor);
            if (((ConstructorDescriptor) descriptor).isPrimary()) {
                break;
            }
        }
        return (KFunction) t;
    }

    @JvmName(name = "getCompanionObject")
    public static final KClass<?> getCompanionObject(KClass<?> kClass) {
        Object obj;
        Intrinsics.checkNotNullParameter(kClass, "");
        Iterator<T> it = kClass.getNestedClasses().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            KClass kClass2 = (KClass) obj;
            Intrinsics.checkNotNull(kClass2);
            if (((KClassImpl) kClass2).getDescriptor().isCompanionObject()) {
                break;
            }
        }
        return (KClass) obj;
    }

    @JvmName(name = "getCompanionObjectInstance")
    public static final Object getCompanionObjectInstance(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        KClass<?> companionObject = getCompanionObject(kClass);
        if (companionObject != null) {
            return companionObject.getObjectInstance();
        }
        return null;
    }

    @JvmName(name = "getDefaultType")
    public static final KType getDefaultType(final KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        SimpleType defaultType = ((KClassImpl) kClass).getDescriptor().getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "");
        return new KTypeImpl(defaultType, new Function0<Type>() { // from class: kotlin.reflect.full.KClasses$defaultType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Type invoke() {
                return ((KClassImpl) kClass).getJClass();
            }
        });
    }

    @JvmName(name = "getDeclaredMembers")
    public static final Collection<KCallable<?>> getDeclaredMembers(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        return ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getDeclaredMembers();
    }

    @JvmName(name = "getFunctions")
    public static final Collection<KFunction<?>> getFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Collection<KCallable<?>> members = kClass.getMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : members) {
            if (obj instanceof KFunction) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @JvmName(name = "getStaticFunctions")
    public static final Collection<KFunction<?>> getStaticFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Collection<KCallableImpl<?>> allStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getAllStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allStaticMembers) {
            if (obj instanceof KFunction) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @JvmName(name = "getMemberFunctions")
    public static final Collection<KFunction<?>> getMemberFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @JvmName(name = "getMemberExtensionFunctions")
    public static final Collection<KFunction<?>> getMemberExtensionFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @JvmName(name = "getDeclaredFunctions")
    public static final Collection<KFunction<?>> getDeclaredFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Collection<KCallableImpl<?>> declaredMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getDeclaredMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : declaredMembers) {
            if (obj instanceof KFunction) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @JvmName(name = "getDeclaredMemberFunctions")
    public static final Collection<KFunction<?>> getDeclaredMemberFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : declaredNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @JvmName(name = "getDeclaredMemberExtensionFunctions")
    public static final Collection<KFunction<?>> getDeclaredMemberExtensionFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : declaredNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @JvmName(name = "getStaticProperties")
    public static final Collection<KProperty0<?>> getStaticProperties(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Collection<KCallableImpl<?>> allStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getAllStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty0)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @JvmName(name = "getMemberProperties")
    public static final <T> Collection<KProperty1<T, ?>> getMemberProperties(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : allNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) t;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty1)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @JvmName(name = "getMemberExtensionProperties")
    public static final <T> Collection<KProperty2<T, ?, ?>> getMemberExtensionProperties(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : allNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) t;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KProperty2)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @JvmName(name = "getDeclaredMemberProperties")
    public static final <T> Collection<KProperty1<T, ?>> getDeclaredMemberProperties(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : declaredNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) t;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty1)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @JvmName(name = "getDeclaredMemberExtensionProperties")
    public static final <T> Collection<KProperty2<T, ?, ?>> getDeclaredMemberExtensionProperties(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : declaredNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) t;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KProperty2)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @JvmName(name = "isExtension")
    private static final boolean isExtension(KCallableImpl<?> kCallableImpl) {
        return kCallableImpl.getDescriptor().getExtensionReceiverParameter() != null;
    }

    @JvmName(name = "isNotExtension")
    private static final boolean isNotExtension(KCallableImpl<?> kCallableImpl) {
        return !isExtension(kCallableImpl);
    }

    @JvmName(name = "getSuperclasses")
    public static final List<KClass<?>> getSuperclasses(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        List<KType> supertypes = kClass.getSupertypes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            KClassifier classifier = ((KType) it.next()).getClassifier();
            KClass kClass2 = classifier instanceof KClass ? (KClass) classifier : null;
            if (kClass2 != null) {
                arrayList.add(kClass2);
            }
        }
        return arrayList;
    }

    @JvmName(name = "getAllSupertypes")
    public static final Collection<KType> getAllSupertypes(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Object dfs = DFS.dfs(kClass.getSupertypes(), new DFS.Neighbors() { // from class: kotlin.reflect.full.KClasses$allSupertypes$1
            /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function0] */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public final Iterable<KType> getNeighbors(KType kType) {
                KClassifier classifier = kType.getClassifier();
                ?? r2 = 0;
                KClass kClass2 = classifier instanceof KClass ? (KClass) classifier : null;
                if (kClass2 == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Supertype not a class: ");
                    sb.append(kType);
                    throw new KotlinReflectionInternalError(sb.toString());
                }
                List<KType> supertypes = kClass2.getSupertypes();
                if (kType.getArguments().isEmpty()) {
                    return supertypes;
                }
                Intrinsics.checkNotNull(kType);
                TypeSubstitutor create = TypeSubstitutor.create(((KTypeImpl) kType).getType());
                List<KType> list = supertypes;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (KType kType2 : list) {
                    Intrinsics.checkNotNull(kType2);
                    KotlinType substitute = create.substitute(((KTypeImpl) kType2).getType(), Variance.INVARIANT);
                    if (substitute == null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Type substitution failed: ");
                        sb2.append(kType2);
                        sb2.append(" (");
                        sb2.append(kType);
                        sb2.append(')');
                        throw new KotlinReflectionInternalError(sb2.toString());
                    }
                    Intrinsics.checkNotNullExpressionValue(substitute, "");
                    arrayList.add(new KTypeImpl(substitute, r2, 2, r2));
                }
                return arrayList;
            }
        }, new DFS.VisitedWithSet(), new DFS.NodeHandlerWithListResult<KType, KType>() { // from class: kotlin.reflect.full.KClasses$allSupertypes$2
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public final boolean beforeChildren(KType current) {
                Intrinsics.checkNotNullParameter(current, "");
                ((LinkedList) this.result).add(current);
                return true;
            }
        });
        Intrinsics.checkNotNullExpressionValue(dfs, "");
        return (Collection) dfs;
    }

    @JvmName(name = "getAllSuperclasses")
    public static final Collection<KClass<?>> getAllSuperclasses(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Collection<KType> allSupertypes = getAllSupertypes(kClass);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allSupertypes, 10));
        for (KType kType : allSupertypes) {
            KClassifier classifier = kType.getClassifier();
            KClass kClass2 = classifier instanceof KClass ? (KClass) classifier : null;
            if (kClass2 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Supertype not a class: ");
                sb.append(kType);
                throw new KotlinReflectionInternalError(sb.toString());
            }
            arrayList.add(kClass2);
        }
        return arrayList;
    }

    public static final boolean isSubclassOf(KClass<?> kClass, final KClass<?> kClass2) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Intrinsics.checkNotNullParameter(kClass2, "");
        if (!Intrinsics.areEqual(kClass, kClass2)) {
            List listOf = CollectionsKt.listOf(kClass);
            final KClasses$isSubclassOf$1 kClasses$isSubclassOf$1 = new PropertyReference1() { // from class: kotlin.reflect.full.KClasses$isSubclassOf$1
                @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
                public final String getName() {
                    return "superclasses";
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final String getSignature() {
                    return "getSuperclasses(Lkotlin/reflect/KClass;)Ljava/util/List;";
                }

                @Override // kotlin.reflect.KProperty1
                public final Object get(Object obj) {
                    return KClasses.getSuperclasses((KClass) obj);
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final KDeclarationContainer getOwner() {
                    return Reflection.getOrCreateKotlinPackage(KClasses.class, "kotlin-reflection");
                }
            };
            Boolean ifAny = DFS.ifAny(listOf, new DFS.Neighbors() { // from class: kotlin.reflect.full.KClasses$sam$org_jetbrains_kotlin_utils_DFS_Neighbors$0
                @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
                public final /* synthetic */ Iterable getNeighbors(Object obj) {
                    return (Iterable) Function1.this.invoke(obj);
                }
            }, new Function1<KClass<?>, Boolean>() { // from class: kotlin.reflect.full.KClasses$isSubclassOf$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(KClass<?> kClass3) {
                    return Boolean.valueOf(Intrinsics.areEqual(kClass3, kClass2));
                }
            });
            Intrinsics.checkNotNullExpressionValue(ifAny, "");
            if (!ifAny.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isSuperclassOf(KClass<?> kClass, KClass<?> kClass2) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Intrinsics.checkNotNullParameter(kClass2, "");
        return isSubclassOf(kClass2, kClass);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(KClass<T> kClass, Object obj) {
        Intrinsics.checkNotNullParameter(kClass, "");
        if (!kClass.isInstance(obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Value cannot be cast to ");
            sb.append(kClass.getQualifiedName());
            throw new TypeCastException(sb.toString());
        }
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T safeCast(KClass<T> kClass, Object obj) {
        Intrinsics.checkNotNullParameter(kClass, "");
        if (kClass.isInstance(obj)) {
            Intrinsics.checkNotNull(obj);
            return obj;
        }
        return null;
    }

    public static final <T> T createInstance(KClass<T> kClass) {
        boolean z;
        Intrinsics.checkNotNullParameter(kClass, "");
        Iterator<T> it = kClass.getConstructors().iterator();
        KFunction kFunction = null;
        KFunction kFunction2 = null;
        boolean z2 = false;
        while (true) {
            if (it.hasNext()) {
                T next = it.next();
                List<KParameter> parameters = ((KFunction) next).getParameters();
                if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                    Iterator<T> it2 = parameters.iterator();
                    while (it2.hasNext()) {
                        if (!((KParameter) it2.next()).isOptional()) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    if (z2) {
                        break;
                    }
                    kFunction2 = next;
                    z2 = true;
                }
            } else if (z2) {
                kFunction = kFunction2;
            }
        }
        KFunction kFunction3 = kFunction;
        if (kFunction3 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Class should have a single no-arg constructor: ");
            sb.append(kClass);
            throw new IllegalArgumentException(sb.toString());
        }
        return (T) kFunction3.callBy(MapsKt.emptyMap());
    }
}
