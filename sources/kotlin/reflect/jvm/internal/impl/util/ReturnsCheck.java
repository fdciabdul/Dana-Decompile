package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.util.Check;

/* loaded from: classes.dex */
public abstract class ReturnsCheck implements Check {
    private final String description;
    private final String name;
    private final Function1<KotlinBuiltIns, KotlinType> type;

    public /* synthetic */ ReturnsCheck(String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ReturnsCheck(String str, Function1<? super KotlinBuiltIns, ? extends KotlinType> function1) {
        this.name = str;
        this.type = function1;
        StringBuilder sb = new StringBuilder();
        sb.append("must return ");
        sb.append(str);
        this.description = sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return this.description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "");
        return Intrinsics.areEqual(functionDescriptor.getReturnType(), this.type.invoke(DescriptorUtilsKt.getBuiltIns(functionDescriptor)));
    }

    /* loaded from: classes.dex */
    public static final class ReturnsBoolean extends ReturnsCheck {
        public static final ReturnsBoolean INSTANCE = new ReturnsBoolean();

        private ReturnsBoolean() {
            super("Boolean", new Function1<KotlinBuiltIns, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsBoolean.1
                @Override // kotlin.jvm.functions.Function1
                public final KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                    Intrinsics.checkNotNullParameter(kotlinBuiltIns, "");
                    SimpleType booleanType = kotlinBuiltIns.getBooleanType();
                    Intrinsics.checkNotNullExpressionValue(booleanType, "");
                    return booleanType;
                }
            }, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class ReturnsInt extends ReturnsCheck {
        public static final ReturnsInt INSTANCE = new ReturnsInt();

        private ReturnsInt() {
            super("Int", new Function1<KotlinBuiltIns, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsInt.1
                @Override // kotlin.jvm.functions.Function1
                public final KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                    Intrinsics.checkNotNullParameter(kotlinBuiltIns, "");
                    SimpleType intType = kotlinBuiltIns.getIntType();
                    Intrinsics.checkNotNullExpressionValue(intType, "");
                    return intType;
                }
            }, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class ReturnsUnit extends ReturnsCheck {
        public static final ReturnsUnit INSTANCE = new ReturnsUnit();

        private ReturnsUnit() {
            super("Unit", new Function1<KotlinBuiltIns, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsUnit.1
                @Override // kotlin.jvm.functions.Function1
                public final KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                    Intrinsics.checkNotNullParameter(kotlinBuiltIns, "");
                    SimpleType unitType = kotlinBuiltIns.getUnitType();
                    Intrinsics.checkNotNullExpressionValue(unitType, "");
                    return unitType;
                }
            }, null);
        }
    }
}
