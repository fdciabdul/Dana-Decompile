package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.MemberKindCheck;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck;

/* loaded from: classes.dex */
public final class OperatorChecks extends AbstractModifierChecks {
    public static final OperatorChecks INSTANCE = new OperatorChecks();
    private static final List<Checks> checks;

    private OperatorChecks() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks
    public final List<Checks> getChecks$descriptors() {
        return checks;
    }

    static {
        Function1 function1 = null;
        int i = 4;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Function1 function12 = null;
        int i2 = 4;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        checks = CollectionsKt.listOf((Object[]) new Checks[]{new Checks(OperatorNameConventions.GET, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, new ValueParameterCountCheck.AtLeast(1)}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.SET, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, new ValueParameterCountCheck.AtLeast(2)}, new Function1<FunctionDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(FunctionDescriptor functionDescriptor) {
                Intrinsics.checkNotNullParameter(functionDescriptor, "");
                List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "");
                ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) CollectionsKt.lastOrNull((List) valueParameters);
                boolean z = false;
                if (valueParameterDescriptor != null) {
                    if (!DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor) && valueParameterDescriptor.getVarargElementType() == null) {
                        z = true;
                    }
                }
                OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
                if (z) {
                    return null;
                }
                return "last parameter should not have a default value or be a vararg";
            }
        }), new Checks(OperatorNameConventions.GET_VALUE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.AtLeast(2), IsKPropertyCheck.INSTANCE}, function1, i, defaultConstructorMarker), new Checks(OperatorNameConventions.SET_VALUE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.AtLeast(3), IsKPropertyCheck.INSTANCE}, function12, i2, defaultConstructorMarker2), new Checks(OperatorNameConventions.PROVIDE_DELEGATE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.Equals(2), IsKPropertyCheck.INSTANCE}, function1, i, defaultConstructorMarker), new Checks(OperatorNameConventions.INVOKE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE}, function12, i2, defaultConstructorMarker2), new Checks(OperatorNameConventions.CONTAINS, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, ReturnsCheck.ReturnsBoolean.INSTANCE}, function1, i, defaultConstructorMarker), new Checks(OperatorNameConventions.ITERATOR, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, function1, i, defaultConstructorMarker), new Checks(OperatorNameConventions.NEXT, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, function1, i, defaultConstructorMarker), new Checks(OperatorNameConventions.HAS_NEXT, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE, ReturnsCheck.ReturnsBoolean.INSTANCE}, function1, i, defaultConstructorMarker), new Checks(OperatorNameConventions.RANGE_TO, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, function1, i, defaultConstructorMarker), new Checks(OperatorNameConventions.EQUALS, new Check[]{MemberKindCheck.Member.INSTANCE}, new Function1<FunctionDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$2
            private static final boolean invoke$isAny(DeclarationDescriptor declarationDescriptor) {
                return (declarationDescriptor instanceof ClassDescriptor) && KotlinBuiltIns.isAny((ClassDescriptor) declarationDescriptor);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
            
                if (r5 != false) goto L15;
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.String invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r5) {
                /*
                    r4 = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                    kotlin.reflect.jvm.internal.impl.util.OperatorChecks r1 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks.INSTANCE
                    kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks r1 = (kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks) r1
                    kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r5.getContainingDeclaration()
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                    boolean r1 = invoke$isAny(r1)
                    r2 = 0
                    r3 = 1
                    if (r1 != 0) goto L4d
                    java.util.Collection r5 = r5.getOverriddenDescriptors()
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                    java.lang.Iterable r5 = (java.lang.Iterable) r5
                    r1 = r5
                    java.util.Collection r1 = (java.util.Collection) r1
                    boolean r1 = r1.isEmpty()
                    if (r1 == 0) goto L2b
                    goto L4a
                L2b:
                    java.util.Iterator r5 = r5.iterator()
                L2f:
                    boolean r1 = r5.hasNext()
                    if (r1 == 0) goto L4a
                    java.lang.Object r1 = r5.next()
                    kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r1
                    kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r1.getContainingDeclaration()
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                    boolean r1 = invoke$isAny(r1)
                    if (r1 == 0) goto L2f
                    r5 = 1
                    goto L4b
                L4a:
                    r5 = 0
                L4b:
                    if (r5 == 0) goto L4e
                L4d:
                    r2 = 1
                L4e:
                    if (r2 != 0) goto L53
                    java.lang.String r5 = "must override ''equals()'' in Any"
                    goto L54
                L53:
                    r5 = 0
                L54:
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$2.invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor):java.lang.String");
            }
        }), new Checks(OperatorNameConventions.COMPARE_TO, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ReturnsCheck.ReturnsInt.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, function1, i, defaultConstructorMarker), new Checks(OperatorNameConventions.BINARY_OPERATION_NAMES, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, function1, i, defaultConstructorMarker), new Checks(OperatorNameConventions.SIMPLE_UNARY_OPERATION_NAMES, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, function1, i, defaultConstructorMarker), new Checks(CollectionsKt.listOf((Object[]) new Name[]{OperatorNameConventions.INC, OperatorNameConventions.DEC}), new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE}, new Function1<FunctionDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$3
            /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
            
                if (r6 != false) goto L14;
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.String invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r6) {
                /*
                    r5 = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                    kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r1 = r6.getDispatchReceiverParameter()
                    if (r1 != 0) goto Lf
                    kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r1 = r6.getExtensionReceiverParameter()
                Lf:
                    kotlin.reflect.jvm.internal.impl.util.OperatorChecks r2 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks.INSTANCE
                    kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks r2 = (kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks) r2
                    r2 = 0
                    if (r1 == 0) goto L34
                    kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r6.getReturnType()
                    if (r3 == 0) goto L28
                    kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r1.getType()
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
                    boolean r0 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isSubtypeOf(r3, r4)
                    goto L29
                L28:
                    r0 = 0
                L29:
                    if (r0 != 0) goto L33
                    kotlin.reflect.jvm.internal.impl.util.OperatorChecks r0 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks.INSTANCE
                    boolean r6 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks.access$incDecCheckForExpectClass(r0, r6, r1)
                    if (r6 == 0) goto L34
                L33:
                    r2 = 1
                L34:
                    if (r2 != 0) goto L39
                    java.lang.String r6 = "receiver must be a supertype of the return type"
                    goto L3a
                L39:
                    r6 = 0
                L3a:
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$3.invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor):java.lang.String");
            }
        }), new Checks(OperatorNameConventions.ASSIGNMENT_OPERATIONS, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ReturnsCheck.ReturnsUnit.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, function1, i, defaultConstructorMarker), new Checks(OperatorNameConventions.COMPONENT_REGEX, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, function1, i, defaultConstructorMarker)});
    }

    public final boolean incDecCheckForExpectClass(FunctionDescriptor functionDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor) {
        ClassId classId;
        KotlinType returnType;
        ReceiverValue value = receiverParameterDescriptor.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        if (value instanceof ImplicitClassReceiver) {
            ClassDescriptor classDescriptor = ((ImplicitClassReceiver) value).getClassDescriptor();
            if (classDescriptor.isExpect() && (classId = DescriptorUtilsKt.getClassId(classDescriptor)) != null) {
                ClassifierDescriptor findClassifierAcrossModuleDependencies = FindClassInModuleKt.findClassifierAcrossModuleDependencies(DescriptorUtilsKt.getModule(classDescriptor), classId);
                if (!(findClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor)) {
                    findClassifierAcrossModuleDependencies = null;
                }
                TypeAliasDescriptor typeAliasDescriptor = (TypeAliasDescriptor) findClassifierAcrossModuleDependencies;
                if (typeAliasDescriptor == null || (returnType = functionDescriptor.getReturnType()) == null) {
                    return false;
                }
                return TypeUtilsKt.isSubtypeOf(returnType, typeAliasDescriptor.getExpandedType());
            }
            return false;
        }
        return false;
    }
}
