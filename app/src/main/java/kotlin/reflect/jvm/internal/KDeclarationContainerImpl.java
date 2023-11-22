package kotlin.reflect.jvm.internal;

import com.alibaba.exthub.config.ExtHubMetaInfoParser;
import id.dana.data.constant.BranchLinkConstant;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000 J2\u00020\u0001:\u0003JKLB\u0007¢\u0006\u0004\bH\u0010IJ1\u0010\n\u001a\u00020\t2\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u000eJ'\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u001f2\u0006\u0010\u0010\u001a\u00020\u001eH&¢\u0006\u0004\b \u0010!J\u0019\u0010$\u001a\u0004\u0018\u00010\u001b2\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J)\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0\u001f2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0004¢\u0006\u0004\b+\u0010,J\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0006\u0010\u0010\u001a\u00020\u001eH&¢\u0006\u0004\b-\u0010!J!\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030.2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b/\u00100J\u001b\u00101\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b1\u00102J+\u00105\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\"H\u0002¢\u0006\u0004\b5\u00106JG\u0010;\u001a\u0004\u0018\u00010\u0012*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003072\n\u00109\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010:\u001a\u00020\u0007H\u0002¢\u0006\u0004\b;\u0010<J/\u0010=\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f*\u0006\u0012\u0002\b\u00030\u00032\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030.H\u0002¢\u0006\u0004\b=\u0010>J?\u0010?\u001a\u0004\u0018\u00010\u0012*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003072\n\u00109\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b?\u0010@R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020A0\u001f8'X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0018\u0010G\u001a\u0006\u0012\u0002\b\u00030\u00038UX\u0094\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "", "Ljava/lang/Class;", "result", "", "desc", "", "isConstructor", "", "addParametersAndMasks", "(Ljava/util/List;Ljava/lang/String;Z)V", "Ljava/lang/reflect/Constructor;", "findConstructorBySignature", "(Ljava/lang/String;)Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "name", "isMember", "Ljava/lang/reflect/Method;", "findDefaultMethod", "(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/reflect/Method;", BranchLinkConstant.OauthParams.SIGNATURE, "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "findFunctionDescriptor", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "findMethodBySignature", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/reflect/Method;", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "findPropertyDescriptor", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "", "getFunctions", "(Lkotlin/reflect/jvm/internal/impl/name/Name;)Ljava/util/Collection;", "", "index", "getLocalProperty", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", ExtHubMetaInfoParser.KEY_EXTENSION_SCOPE_CLASS_NAME, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "belonginess", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getMembers", "(Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;)Ljava/util/Collection;", "getProperties", "", "loadParameterTypes", "(Ljava/lang/String;)Ljava/util/List;", "loadReturnType", "(Ljava/lang/String;)Ljava/lang/Class;", "begin", "end", "parseType", "(Ljava/lang/String;II)Ljava/lang/Class;", "", "parameterTypes", "returnType", "isStaticDefault", "lookupMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetConstructor", "(Ljava/lang/Class;Ljava/util/List;)Ljava/lang/reflect/Constructor;", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructorDescriptors", "getMethodOwner", "()Ljava/lang/Class;", "methodOwner", "<init>", "()V", "Companion", "Data", "MemberBelonginess"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
    private static final Regex LOCAL_PROPERTY_SIGNATURE = new Regex("<v#(\\d+)>");

    @JvmName(name = "getConstructorDescriptors")
    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    public abstract Collection<FunctionDescriptor> getFunctions(Name name);

    public abstract PropertyDescriptor getLocalProperty(int index);

    public abstract Collection<PropertyDescriptor> getProperties(Name name);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes.dex */
    public abstract class Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};

        /* renamed from: moduleData$delegate  reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal moduleData;

        public Data() {
            KDeclarationContainerImpl.this = r2;
            this.moduleData = ReflectProperties.lazySoft(new Function0<RuntimeModuleData>() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$Data$moduleData$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final RuntimeModuleData invoke() {
                    return ModuleByClassLoaderKt.getOrCreateModule(KDeclarationContainerImpl.this.getJClass());
                }
            });
        }

        public final RuntimeModuleData getModuleData() {
            T value = this.moduleData.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(value, "");
            return (RuntimeModuleData) value;
        }
    }

    @JvmName(name = "getMethodOwner")
    protected Class<?> getMethodOwner() {
        Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        return wrapperByPrimitive == null ? getJClass() : wrapperByPrimitive;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0056 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0022 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getMembers(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r8, kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess r9) {
        /*
            r7 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1 r0 = new kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1
            r0.<init>(r7)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope r8 = (kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope) r8
            r1 = 0
            r2 = 3
            java.util.Collection r8 = kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls.getContributedDescriptors$default(r8, r1, r1, r2, r1)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r8 = r8.iterator()
        L22:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L5a
            java.lang.Object r3 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            if (r4 == 0) goto L53
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r5 = r4.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r6 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INVISIBLE_FAKE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 != 0) goto L53
            boolean r4 = r9.accept(r4)
            if (r4 == 0) goto L53
            r4 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor) r4
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            java.lang.Object r3 = r3.accept(r4, r5)
            kotlin.reflect.jvm.internal.KCallableImpl r3 = (kotlin.reflect.jvm.internal.KCallableImpl) r3
            goto L54
        L53:
            r3 = r1
        L54:
            if (r3 == 0) goto L22
            r2.add(r3)
            goto L22
        L5a:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r8 = kotlin.collections.CollectionsKt.toList(r2)
            java.util.Collection r8 = (java.util.Collection) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.getMembers(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess):java.util.Collection");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0084\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "member", "", "accept", "(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;)Z", "<init>", "(Ljava/lang/String;I)V", "DECLARED", "INHERITED"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes.dex */
    public enum MemberBelonginess {
        DECLARED,
        INHERITED;

        public final boolean accept(CallableMemberDescriptor member) {
            Intrinsics.checkNotNullParameter(member, "");
            return member.getKind().isReal() == (this == DECLARED);
        }
    }

    public final PropertyDescriptor findPropertyDescriptor(String name, String r21) {
        String obj;
        Intrinsics.checkNotNullParameter(name, "");
        Intrinsics.checkNotNullParameter(r21, "");
        MatchResult matchEntire = LOCAL_PROPERTY_SIGNATURE.matchEntire(r21);
        if (matchEntire != null) {
            String str = matchEntire.getDestructured().getMatch().getGroupValues().get(1);
            PropertyDescriptor localProperty = getLocalProperty(Integer.parseInt(str));
            if (localProperty != null) {
                return localProperty;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Local property #");
            sb.append(str);
            sb.append(" not found in ");
            sb.append(getJClass());
            throw new KotlinReflectionInternalError(sb.toString());
        }
        Name identifier = Name.identifier(name);
        Intrinsics.checkNotNullExpressionValue(identifier, "");
        Collection<PropertyDescriptor> properties = getProperties(identifier);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : properties) {
            if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapPropertySignature((PropertyDescriptor) obj2).getString(), r21)) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Property '");
            sb2.append(name);
            sb2.append("' (JVM signature: ");
            sb2.append(r21);
            sb2.append(") not resolved in ");
            sb2.append(this);
            throw new KotlinReflectionInternalError(sb2.toString());
        } else if (arrayList2.size() == 1) {
            return (PropertyDescriptor) CollectionsKt.single((List) arrayList2);
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj3 : arrayList2) {
                DescriptorVisibility visibility = ((PropertyDescriptor) obj3).getVisibility();
                Object obj4 = linkedHashMap.get(visibility);
                if (obj4 == null) {
                    obj4 = (List) new ArrayList();
                    linkedHashMap.put(visibility, obj4);
                }
                ((List) obj4).add(obj3);
            }
            Collection values = MapsKt.toSortedMap(linkedHashMap, new Comparator() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2
                @Override // java.util.Comparator
                public final int compare(DescriptorVisibility descriptorVisibility, DescriptorVisibility descriptorVisibility2) {
                    Integer compare = DescriptorVisibilities.compare(descriptorVisibility, descriptorVisibility2);
                    if (compare == null) {
                        return 0;
                    }
                    return compare.intValue();
                }
            }).values();
            Intrinsics.checkNotNullExpressionValue(values, "");
            List list = (List) CollectionsKt.last(values);
            if (list.size() == 1) {
                Intrinsics.checkNotNullExpressionValue(list, "");
                return (PropertyDescriptor) CollectionsKt.first(list);
            }
            Name identifier2 = Name.identifier(name);
            Intrinsics.checkNotNullExpressionValue(identifier2, "");
            String joinToString$default = CollectionsKt.joinToString$default(getProperties(identifier2), "\n", null, null, 0, null, new Function1<PropertyDescriptor, CharSequence>() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(PropertyDescriptor propertyDescriptor) {
                    Intrinsics.checkNotNullParameter(propertyDescriptor, "");
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(DescriptorRenderer.DEBUG_TEXT.render(propertyDescriptor));
                    sb3.append(" | ");
                    sb3.append(RuntimeTypeMapper.INSTANCE.mapPropertySignature(propertyDescriptor).getString());
                    return sb3.toString();
                }
            }, 30, null);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Property '");
            sb3.append(name);
            sb3.append("' (JVM signature: ");
            sb3.append(r21);
            sb3.append(") not resolved in ");
            sb3.append(this);
            sb3.append(':');
            if (joinToString$default.length() == 0) {
                obj = " no members found";
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append('\n');
                sb4.append(joinToString$default);
                obj = sb4.toString();
            }
            sb3.append(obj);
            throw new KotlinReflectionInternalError(sb3.toString());
        }
    }

    public final FunctionDescriptor findFunctionDescriptor(String name, String r13) {
        List functions;
        String obj;
        Intrinsics.checkNotNullParameter(name, "");
        Intrinsics.checkNotNullParameter(r13, "");
        if (Intrinsics.areEqual(name, "<init>")) {
            functions = CollectionsKt.toList(getConstructorDescriptors());
        } else {
            Name identifier = Name.identifier(name);
            Intrinsics.checkNotNullExpressionValue(identifier, "");
            functions = getFunctions(identifier);
        }
        Collection<FunctionDescriptor> collection = functions;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : collection) {
            if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapSignature((FunctionDescriptor) obj2).get_signature(), r13)) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() != 1) {
            String joinToString$default = CollectionsKt.joinToString$default(collection, "\n", null, null, 0, null, new Function1<FunctionDescriptor, CharSequence>() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(FunctionDescriptor functionDescriptor) {
                    Intrinsics.checkNotNullParameter(functionDescriptor, "");
                    StringBuilder sb = new StringBuilder();
                    sb.append(DescriptorRenderer.DEBUG_TEXT.render(functionDescriptor));
                    sb.append(" | ");
                    sb.append(RuntimeTypeMapper.INSTANCE.mapSignature(functionDescriptor).get_signature());
                    return sb.toString();
                }
            }, 30, null);
            StringBuilder sb = new StringBuilder();
            sb.append("Function '");
            sb.append(name);
            sb.append("' (JVM signature: ");
            sb.append(r13);
            sb.append(") not resolved in ");
            sb.append(this);
            sb.append(':');
            if (joinToString$default.length() == 0) {
                obj = " no members found";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append('\n');
                sb2.append(joinToString$default);
                obj = sb2.toString();
            }
            sb.append(obj);
            throw new KotlinReflectionInternalError(sb.toString());
        }
        return (FunctionDescriptor) CollectionsKt.single((List) arrayList2);
    }

    private final Method lookupMethod(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z) {
        Method lookupMethod;
        if (z) {
            clsArr[0] = cls;
        }
        Method tryGetMethod = tryGetMethod(cls, str, clsArr, cls2);
        if (tryGetMethod != null) {
            return tryGetMethod;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || (lookupMethod = lookupMethod(superclass, str, clsArr, cls2, z)) == null) {
            Class<?>[] interfaces = cls.getInterfaces();
            Intrinsics.checkNotNullExpressionValue(interfaces, "");
            for (Class<?> cls3 : interfaces) {
                Intrinsics.checkNotNullExpressionValue(cls3, "");
                Method lookupMethod2 = lookupMethod(cls3, str, clsArr, cls2, z);
                if (lookupMethod2 != null) {
                    return lookupMethod2;
                }
                if (z) {
                    ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(cls3);
                    StringBuilder sb = new StringBuilder();
                    sb.append(cls3.getName());
                    sb.append("$DefaultImpls");
                    Class<?> tryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(safeClassLoader, sb.toString());
                    if (tryLoadClass != null) {
                        clsArr[0] = cls3;
                        Method tryGetMethod2 = tryGetMethod(tryLoadClass, str, clsArr, cls2);
                        if (tryGetMethod2 != null) {
                            return tryGetMethod2;
                        }
                    }
                }
            }
            return null;
        }
        return lookupMethod;
    }

    private final Method tryGetMethod(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        Method method;
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (Intrinsics.areEqual(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "");
            Method[] methodArr = declaredMethods;
            int length = methodArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = methodArr[i];
                Method method2 = method;
                if (Intrinsics.areEqual(method2.getName(), str) && Intrinsics.areEqual(method2.getReturnType(), cls2) && Arrays.equals(method2.getParameterTypes(), clsArr)) {
                    break;
                }
                i++;
            }
            return method;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final Constructor<?> tryGetConstructor(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            Intrinsics.checkNotNull(array);
            Class[] clsArr = (Class[]) array;
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final Method findMethodBySignature(String name, String desc) {
        Method lookupMethod;
        Intrinsics.checkNotNullParameter(name, "");
        Intrinsics.checkNotNullParameter(desc, "");
        if (Intrinsics.areEqual(name, "<init>")) {
            return null;
        }
        Object[] array = loadParameterTypes(desc).toArray(new Class[0]);
        Intrinsics.checkNotNull(array);
        Class<?>[] clsArr = (Class[]) array;
        Class<?> loadReturnType = loadReturnType(desc);
        Method lookupMethod2 = lookupMethod(getMethodOwner(), name, clsArr, loadReturnType, false);
        if (lookupMethod2 != null) {
            return lookupMethod2;
        }
        if (!getMethodOwner().isInterface() || (lookupMethod = lookupMethod(Object.class, name, clsArr, loadReturnType, false)) == null) {
            return null;
        }
        return lookupMethod;
    }

    public final Method findDefaultMethod(String name, String desc, boolean isMember) {
        Intrinsics.checkNotNullParameter(name, "");
        Intrinsics.checkNotNullParameter(desc, "");
        if (Intrinsics.areEqual(name, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (isMember) {
            arrayList.add(getJClass());
        }
        addParametersAndMasks(arrayList, desc, false);
        Class<?> methodOwner = getMethodOwner();
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append("$default");
        String obj = sb.toString();
        Object[] array = arrayList.toArray(new Class[0]);
        Intrinsics.checkNotNull(array);
        return lookupMethod(methodOwner, obj, (Class[]) array, loadReturnType(desc), isMember);
    }

    public final Constructor<?> findConstructorBySignature(String desc) {
        Intrinsics.checkNotNullParameter(desc, "");
        return tryGetConstructor(getJClass(), loadParameterTypes(desc));
    }

    public final Constructor<?> findDefaultConstructor(String desc) {
        Intrinsics.checkNotNullParameter(desc, "");
        Class<?> jClass = getJClass();
        ArrayList arrayList = new ArrayList();
        addParametersAndMasks(arrayList, desc, true);
        Unit unit = Unit.INSTANCE;
        return tryGetConstructor(jClass, arrayList);
    }

    private final void addParametersAndMasks(List<Class<?>> result, String desc, boolean isConstructor) {
        result.addAll(loadParameterTypes(desc));
        int size = ((r5.size() + 32) - 1) / 32;
        for (int i = 0; i < size; i++) {
            Class<?> cls = Integer.TYPE;
            Intrinsics.checkNotNullExpressionValue(cls, "");
            result.add(cls);
        }
        if (isConstructor) {
            Class<?> cls2 = DEFAULT_CONSTRUCTOR_MARKER;
            result.remove(cls2);
            Intrinsics.checkNotNullExpressionValue(cls2, "");
            result.add(cls2);
            return;
        }
        result.add(Object.class);
    }

    private final List<Class<?>> loadParameterTypes(String desc) {
        int indexOf$default;
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (desc.charAt(i) != ')') {
            int i2 = i;
            while (desc.charAt(i2) == '[') {
                i2++;
            }
            char charAt = desc.charAt(i2);
            if (StringsKt.contains$default((CharSequence) "VZCBSIFJD", charAt, false, 2, (Object) null)) {
                indexOf$default = i2 + 1;
            } else if (charAt == 'L') {
                indexOf$default = StringsKt.indexOf$default((CharSequence) desc, ';', i, false, 4, (Object) null) + 1;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown type prefix in the method signature: ");
                sb.append(desc);
                throw new KotlinReflectionInternalError(sb.toString());
            }
            arrayList.add(parseType(desc, i, indexOf$default));
            i = indexOf$default;
        }
        return arrayList;
    }

    private final Class<?> parseType(String desc, int begin, int end) {
        char charAt = desc.charAt(begin);
        if (charAt == 'L') {
            ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(getJClass());
            String substring = desc.substring(begin + 1, end - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            Class<?> loadClass = safeClassLoader.loadClass(StringsKt.replace$default(substring, '/', '.', false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(loadClass, "");
            return loadClass;
        } else if (charAt == '[') {
            return UtilKt.createArrayType(parseType(desc, begin + 1, end));
        } else {
            if (charAt == 'V') {
                Class<?> cls = Void.TYPE;
                Intrinsics.checkNotNullExpressionValue(cls, "");
                return cls;
            } else if (charAt == 'Z') {
                return Boolean.TYPE;
            } else {
                if (charAt == 'C') {
                    return Character.TYPE;
                }
                if (charAt == 'B') {
                    return Byte.TYPE;
                }
                if (charAt == 'S') {
                    return Short.TYPE;
                }
                if (charAt == 'I') {
                    return Integer.TYPE;
                }
                if (charAt == 'F') {
                    return Float.TYPE;
                }
                if (charAt == 'J') {
                    return Long.TYPE;
                }
                if (charAt == 'D') {
                    return Double.TYPE;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown type prefix in the method signature: ");
                sb.append(desc);
                throw new KotlinReflectionInternalError(sb.toString());
            }
        }
    }

    private final Class<?> loadReturnType(String desc) {
        return parseType(desc, StringsKt.indexOf$default((CharSequence) desc, ')', 0, false, 6, (Object) null) + 1, desc.length());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR \u0010\u0003\u001a\u000e\u0012\u0002\b\u0003*\u0006\u0012\u0002\b\u00030\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00058\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "Ljava/lang/Class;", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "Lkotlin/text/Regex;", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "<init>", "()V"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection")
        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.LOCAL_PROPERTY_SIGNATURE;
        }
    }
}
