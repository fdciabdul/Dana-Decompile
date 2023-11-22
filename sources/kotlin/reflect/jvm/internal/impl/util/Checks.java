package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.CheckResult;
import kotlin.text.Regex;

/* loaded from: classes.dex */
public final class Checks {
    private final Function1<FunctionDescriptor, String> additionalCheck;
    private final Check[] checks;
    private final Name name;
    private final Collection<Name> nameList;
    private final Regex regex;

    /* JADX WARN: Multi-variable type inference failed */
    private Checks(Name name, Regex regex, Collection<Name> collection, Function1<? super FunctionDescriptor, String> function1, Check... checkArr) {
        this.name = name;
        this.regex = regex;
        this.nameList = collection;
        this.additionalCheck = function1;
        this.checks = checkArr;
    }

    public final boolean isApplicable(FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "");
        if (this.name == null || Intrinsics.areEqual(functionDescriptor.getName(), this.name)) {
            if (this.regex != null) {
                String asString = functionDescriptor.getName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "");
                if (!this.regex.matches(asString)) {
                    return false;
                }
            }
            Collection<Name> collection = this.nameList;
            return collection == null || collection.contains(functionDescriptor.getName());
        }
        return false;
    }

    public final CheckResult checkAll(FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "");
        for (Check check : this.checks) {
            String invoke = check.invoke(functionDescriptor);
            if (invoke != null) {
                return new CheckResult.IllegalSignature(invoke);
            }
        }
        String invoke2 = this.additionalCheck.invoke(functionDescriptor);
        if (invoke2 != null) {
            return new CheckResult.IllegalSignature(invoke2);
        }
        return CheckResult.SuccessCheck.INSTANCE;
    }

    public /* synthetic */ Checks(Name name, Check[] checkArr, AnonymousClass2 anonymousClass2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(name, checkArr, (i & 4) != 0 ? new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.Checks.2
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(FunctionDescriptor functionDescriptor) {
                Intrinsics.checkNotNullParameter(functionDescriptor, "");
                return null;
            }
        } : anonymousClass2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Checks(Name name, Check[] checkArr, Function1<? super FunctionDescriptor, String> function1) {
        this(name, (Regex) null, (Collection<Name>) null, function1, (Check[]) Arrays.copyOf(checkArr, checkArr.length));
        Intrinsics.checkNotNullParameter(name, "");
        Intrinsics.checkNotNullParameter(checkArr, "");
        Intrinsics.checkNotNullParameter(function1, "");
    }

    public /* synthetic */ Checks(Regex regex, Check[] checkArr, AnonymousClass3 anonymousClass3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(regex, checkArr, (i & 4) != 0 ? new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.Checks.3
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(FunctionDescriptor functionDescriptor) {
                Intrinsics.checkNotNullParameter(functionDescriptor, "");
                return null;
            }
        } : anonymousClass3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Checks(Regex regex, Check[] checkArr, Function1<? super FunctionDescriptor, String> function1) {
        this((Name) null, regex, (Collection<Name>) null, function1, (Check[]) Arrays.copyOf(checkArr, checkArr.length));
        Intrinsics.checkNotNullParameter(regex, "");
        Intrinsics.checkNotNullParameter(checkArr, "");
        Intrinsics.checkNotNullParameter(function1, "");
    }

    public /* synthetic */ Checks(Collection collection, Check[] checkArr, AnonymousClass4 anonymousClass4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(collection, checkArr, (i & 4) != 0 ? new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.Checks.4
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(FunctionDescriptor functionDescriptor) {
                Intrinsics.checkNotNullParameter(functionDescriptor, "");
                return null;
            }
        } : anonymousClass4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Checks(Collection<Name> collection, Check[] checkArr, Function1<? super FunctionDescriptor, String> function1) {
        this((Name) null, (Regex) null, collection, function1, (Check[]) Arrays.copyOf(checkArr, checkArr.length));
        Intrinsics.checkNotNullParameter(collection, "");
        Intrinsics.checkNotNullParameter(checkArr, "");
        Intrinsics.checkNotNullParameter(function1, "");
    }
}
