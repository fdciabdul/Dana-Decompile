package kotlin.reflect.jvm.internal;

import id.dana.data.constant.BranchLinkConstant;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.FunctionWithAllInvokes;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.CallerKt;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.InlineClassManglingRulesKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB5\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0012J.\u00102\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000304032\n\u00105\u001a\u0006\u0012\u0002\b\u0003042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00106\u001a\u00020)H\u0002J\u0010\u00107\u001a\u0002082\u0006\u00105\u001a\u000209H\u0002J\u0010\u0010:\u001a\u0002082\u0006\u00105\u001a\u000209H\u0002J\u0010\u0010;\u001a\u0002082\u0006\u00105\u001a\u000209H\u0002J\u0013\u0010<\u001a\u00020)2\b\u0010=\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010>\u001a\u00020\u0014H\u0016J\b\u0010?\u001a\u00020\tH\u0016R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R!\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b\"\u0010\u001cR\u001b\u0010\r\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010*R\u0014\u0010+\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010*R\u0014\u0010.\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u0014\u0010/\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010*R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", BranchLinkConstant.PathTarget.CONTAINER, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", BranchLinkConstant.OauthParams.SIGNATURE, "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "arity", "", "getArity", "()I", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "member", "isDefault", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "hashCode", "toString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class KFunctionImpl extends KCallableImpl<Object> implements FunctionBase<Object>, KFunction<Object>, FunctionWithAllInvokes {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};

    /* renamed from: caller$delegate  reason: from kotlin metadata */
    private final ReflectProperties.LazyVal caller;
    private final KDeclarationContainerImpl container;

    /* renamed from: defaultCaller$delegate  reason: from kotlin metadata */
    private final ReflectProperties.LazyVal defaultCaller;

    /* renamed from: descriptor$delegate  reason: from kotlin metadata */
    private final ReflectProperties.LazySoftVal descriptor;
    private final Object rawBoundReceiver;
    private final String signature;

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3);
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4);
    }

    @Override // kotlin.jvm.functions.Function5
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5);
    }

    @Override // kotlin.jvm.functions.Function6
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // kotlin.jvm.functions.Function7
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // kotlin.jvm.functions.Function8
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // kotlin.jvm.functions.Function9
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // kotlin.jvm.functions.Function10
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // kotlin.jvm.functions.Function11
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // kotlin.jvm.functions.Function12
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // kotlin.jvm.functions.Function13
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // kotlin.jvm.functions.Function14
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // kotlin.jvm.functions.Function15
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // kotlin.jvm.functions.Function16
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // kotlin.jvm.functions.Function17
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // kotlin.jvm.functions.Function18
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // kotlin.jvm.functions.Function19
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // kotlin.jvm.functions.Function20
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // kotlin.jvm.functions.Function21
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    @Override // kotlin.jvm.functions.Function22
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21, Object obj22) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public final KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    /* synthetic */ KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, FunctionDescriptor functionDescriptor, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kDeclarationContainerImpl, str, str2, functionDescriptor, (i & 16) != 0 ? CallableReference.NO_RECEIVER : obj);
    }

    private KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, final String str, String str2, FunctionDescriptor functionDescriptor, Object obj) {
        this.container = kDeclarationContainerImpl;
        this.signature = str2;
        this.rawBoundReceiver = obj;
        this.descriptor = ReflectProperties.lazySoft(functionDescriptor, new Function0<FunctionDescriptor>() { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$descriptor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final FunctionDescriptor invoke() {
                String str3;
                KDeclarationContainerImpl container = KFunctionImpl.this.getContainer();
                String str4 = str;
                str3 = KFunctionImpl.this.signature;
                return container.findFunctionDescriptor(str4, str3);
            }
        });
        this.caller = ReflectProperties.lazy(new Function0<Caller<? extends Member>>() { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$caller$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Caller<? extends Member> invoke() {
                Constructor<?> constructor;
                CallerImpl.Method createJvmStaticInObjectCaller;
                CallerImpl.Method method;
                JvmFunctionSignature mapSignature = RuntimeTypeMapper.INSTANCE.mapSignature(KFunctionImpl.this.getDescriptor());
                if (mapSignature instanceof JvmFunctionSignature.KotlinConstructor) {
                    if (KFunctionImpl.this.isAnnotationConstructor()) {
                        Class<?> jClass = KFunctionImpl.this.getContainer().getJClass();
                        List<KParameter> parameters = KFunctionImpl.this.getParameters();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameters, 10));
                        Iterator<T> it = parameters.iterator();
                        while (it.hasNext()) {
                            String name = ((KParameter) it.next()).getName();
                            Intrinsics.checkNotNull(name);
                            arrayList.add(name);
                        }
                        return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
                    }
                    constructor = KFunctionImpl.this.getContainer().findConstructorBySignature(((JvmFunctionSignature.KotlinConstructor) mapSignature).getConstructorDesc());
                } else if (mapSignature instanceof JvmFunctionSignature.KotlinFunction) {
                    JvmFunctionSignature.KotlinFunction kotlinFunction = (JvmFunctionSignature.KotlinFunction) mapSignature;
                    constructor = KFunctionImpl.this.getContainer().findMethodBySignature(kotlinFunction.getMethodName(), kotlinFunction.getMethodDesc());
                } else if (mapSignature instanceof JvmFunctionSignature.JavaMethod) {
                    constructor = ((JvmFunctionSignature.JavaMethod) mapSignature).getMethod();
                } else if (!(mapSignature instanceof JvmFunctionSignature.JavaConstructor)) {
                    if (mapSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                        List<Method> methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) mapSignature).getMethods();
                        Class<?> jClass2 = KFunctionImpl.this.getContainer().getJClass();
                        List<Method> list = methods;
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        Iterator<T> it2 = list.iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(((Method) it2.next()).getName());
                        }
                        return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, methods);
                    }
                    throw new NoWhenBranchMatchedException();
                } else {
                    constructor = ((JvmFunctionSignature.JavaConstructor) mapSignature).getConstructor();
                }
                if (constructor instanceof Constructor) {
                    KFunctionImpl kFunctionImpl = KFunctionImpl.this;
                    method = kFunctionImpl.createConstructorCaller((Constructor) constructor, kFunctionImpl.getDescriptor(), false);
                } else if (constructor instanceof Method) {
                    Method method2 = (Method) constructor;
                    if (!Modifier.isStatic(method2.getModifiers())) {
                        createJvmStaticInObjectCaller = KFunctionImpl.this.createInstanceMethodCaller(method2);
                    } else {
                        createJvmStaticInObjectCaller = KFunctionImpl.this.getDescriptor().getAnnotations().mo4435findAnnotation(UtilKt.getJVM_STATIC()) != null ? KFunctionImpl.this.createJvmStaticInObjectCaller(method2) : KFunctionImpl.this.createStaticMethodCaller(method2);
                    }
                    method = createJvmStaticInObjectCaller;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not compute caller for function: ");
                    sb.append(KFunctionImpl.this.getDescriptor());
                    sb.append(" (member = ");
                    sb.append(constructor);
                    sb.append(')');
                    throw new KotlinReflectionInternalError(sb.toString());
                }
                return InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded$default(method, KFunctionImpl.this.getDescriptor(), false, 2, null);
            }
        });
        this.defaultCaller = ReflectProperties.lazy(new Function0<Caller<? extends Member>>() { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$defaultCaller$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.reflect.Member, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final Caller<? extends Member> invoke() {
                Constructor<?> constructor;
                CallerImpl.Method method;
                CallerImpl.Method createStaticMethodCaller;
                JvmFunctionSignature mapSignature = RuntimeTypeMapper.INSTANCE.mapSignature(KFunctionImpl.this.getDescriptor());
                if (mapSignature instanceof JvmFunctionSignature.KotlinFunction) {
                    KDeclarationContainerImpl container = KFunctionImpl.this.getContainer();
                    JvmFunctionSignature.KotlinFunction kotlinFunction = (JvmFunctionSignature.KotlinFunction) mapSignature;
                    String methodName = kotlinFunction.getMethodName();
                    String methodDesc = kotlinFunction.getMethodDesc();
                    Intrinsics.checkNotNull(KFunctionImpl.this.getCaller().mo4428getMember());
                    constructor = container.findDefaultMethod(methodName, methodDesc, !Modifier.isStatic(r5.getModifiers()));
                } else if (mapSignature instanceof JvmFunctionSignature.KotlinConstructor) {
                    if (KFunctionImpl.this.isAnnotationConstructor()) {
                        Class<?> jClass = KFunctionImpl.this.getContainer().getJClass();
                        List<KParameter> parameters = KFunctionImpl.this.getParameters();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameters, 10));
                        Iterator<T> it = parameters.iterator();
                        while (it.hasNext()) {
                            String name = ((KParameter) it.next()).getName();
                            Intrinsics.checkNotNull(name);
                            arrayList.add(name);
                        }
                        return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
                    }
                    constructor = KFunctionImpl.this.getContainer().findDefaultConstructor(((JvmFunctionSignature.KotlinConstructor) mapSignature).getConstructorDesc());
                } else if (mapSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                    List<Method> methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) mapSignature).getMethods();
                    Class<?> jClass2 = KFunctionImpl.this.getContainer().getJClass();
                    List<Method> list = methods;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((Method) it2.next()).getName());
                    }
                    return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, methods);
                } else {
                    constructor = null;
                }
                if (constructor instanceof Constructor) {
                    KFunctionImpl kFunctionImpl = KFunctionImpl.this;
                    method = kFunctionImpl.createConstructorCaller((Constructor) constructor, kFunctionImpl.getDescriptor(), true);
                } else if (constructor instanceof Method) {
                    if (KFunctionImpl.this.getDescriptor().getAnnotations().mo4435findAnnotation(UtilKt.getJVM_STATIC()) != null) {
                        DeclarationDescriptor containingDeclaration = KFunctionImpl.this.getDescriptor().getContainingDeclaration();
                        Intrinsics.checkNotNull(containingDeclaration);
                        if (!((ClassDescriptor) containingDeclaration).isCompanionObject()) {
                            createStaticMethodCaller = KFunctionImpl.this.createJvmStaticInObjectCaller((Method) constructor);
                            method = createStaticMethodCaller;
                        }
                    }
                    createStaticMethodCaller = KFunctionImpl.this.createStaticMethodCaller((Method) constructor);
                    method = createStaticMethodCaller;
                } else {
                    method = null;
                }
                if (method != null) {
                    return InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded(method, KFunctionImpl.this.getDescriptor(), true);
                }
                return null;
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        this(kDeclarationContainerImpl, str, str2, null, obj);
        Intrinsics.checkNotNullParameter(kDeclarationContainerImpl, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public KFunctionImpl(kotlin.reflect.jvm.internal.KDeclarationContainerImpl r11, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r12) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            kotlin.reflect.jvm.internal.impl.name.Name r1 = r12.getName()
            java.lang.String r4 = r1.asString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            kotlin.reflect.jvm.internal.RuntimeTypeMapper r0 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE
            kotlin.reflect.jvm.internal.JvmFunctionSignature r0 = r0.mapSignature(r12)
            java.lang.String r5 = r0.get_signature()
            r7 = 0
            r8 = 16
            r9 = 0
            r2 = r10
            r3 = r11
            r6 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KFunctionImpl.<init>(kotlin.reflect.jvm.internal.KDeclarationContainerImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor):void");
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public final boolean isBound() {
        return !Intrinsics.areEqual(this.rawBoundReceiver, CallableReference.NO_RECEIVER);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public final FunctionDescriptor getDescriptor() {
        T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(value, "");
        return (FunctionDescriptor) value;
    }

    @Override // kotlin.reflect.KCallable
    public final String getName() {
        String asString = getDescriptor().getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "");
        return asString;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public final Caller<?> getCaller() {
        T value = this.caller.getValue(this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue(value, "");
        return (Caller) value;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public final Caller<?> getDefaultCaller() {
        return (Caller) this.defaultCaller.getValue(this, $$delegatedProperties[2]);
    }

    private final Object getBoundReceiver() {
        return InlineClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, getDescriptor());
    }

    public final CallerImpl.Method createStaticMethodCaller(Method member) {
        return isBound() ? new CallerImpl.Method.BoundStatic(member, getBoundReceiver()) : new CallerImpl.Method.Static(member);
    }

    public final CallerImpl.Method createJvmStaticInObjectCaller(Method member) {
        return isBound() ? new CallerImpl.Method.BoundJvmStaticInObject(member) : new CallerImpl.Method.JvmStaticInObject(member);
    }

    public final CallerImpl.Method createInstanceMethodCaller(Method member) {
        return isBound() ? new CallerImpl.Method.BoundInstance(member, getBoundReceiver()) : new CallerImpl.Method.Instance(member);
    }

    public final CallerImpl<Constructor<?>> createConstructorCaller(Constructor<?> member, FunctionDescriptor descriptor, boolean isDefault) {
        if (!isDefault && InlineClassManglingRulesKt.shouldHideConstructorDueToInlineClassTypeValueParameters(descriptor)) {
            if (isBound()) {
                return new CallerImpl.AccessorForHiddenBoundConstructor(member, getBoundReceiver());
            }
            return new CallerImpl.AccessorForHiddenConstructor(member);
        } else if (isBound()) {
            return new CallerImpl.BoundConstructor(member, getBoundReceiver());
        } else {
            return new CallerImpl.Constructor(member);
        }
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return CallerKt.getArity(getCaller());
    }

    @Override // kotlin.reflect.KFunction
    public final boolean isInline() {
        return getDescriptor().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public final boolean isExternal() {
        return getDescriptor().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public final boolean isOperator() {
        return getDescriptor().isOperator();
    }

    @Override // kotlin.reflect.KFunction
    public final boolean isInfix() {
        return getDescriptor().isInfix();
    }

    @Override // kotlin.reflect.KCallable
    public final boolean isSuspend() {
        return getDescriptor().isSuspend();
    }

    public final boolean equals(Object other) {
        KFunctionImpl asKFunctionImpl = UtilKt.asKFunctionImpl(other);
        return asKFunctionImpl != null && Intrinsics.areEqual(getContainer(), asKFunctionImpl.getContainer()) && Intrinsics.areEqual(getName(), asKFunctionImpl.getName()) && Intrinsics.areEqual(this.signature, asKFunctionImpl.signature) && Intrinsics.areEqual(this.rawBoundReceiver, asKFunctionImpl.rawBoundReceiver);
    }

    public final int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    public final String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderFunction(getDescriptor());
    }
}
