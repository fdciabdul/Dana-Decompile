package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public final class PropertiesConventionUtilKt {
    public static final Name propertyNameByGetMethodName(Name name) {
        Intrinsics.checkNotNullParameter(name, "");
        Name propertyNameFromAccessorMethodName$default = propertyNameFromAccessorMethodName$default(name, "get", false, null, 12, null);
        return propertyNameFromAccessorMethodName$default == null ? propertyNameFromAccessorMethodName$default(name, "is", false, null, 8, null) : propertyNameFromAccessorMethodName$default;
    }

    public static final Name propertyNameBySetMethodName(Name name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "");
        return propertyNameFromAccessorMethodName$default(name, "set", false, z ? "is" : null, 4, null);
    }

    public static final List<Name> propertyNamesBySetMethodName(Name name) {
        Intrinsics.checkNotNullParameter(name, "");
        return CollectionsKt.listOfNotNull((Object[]) new Name[]{propertyNameBySetMethodName(name, false), propertyNameBySetMethodName(name, true)});
    }

    static /* synthetic */ Name propertyNameFromAccessorMethodName$default(Name name, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return propertyNameFromAccessorMethodName(name, str, z, str2);
    }

    private static final Name propertyNameFromAccessorMethodName(Name name, String str, boolean z, String str2) {
        if (name.isSpecial()) {
            return null;
        }
        String identifier = name.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "");
        boolean z2 = false;
        if (StringsKt.startsWith$default(identifier, str, false, 2, (Object) null) && identifier.length() != str.length()) {
            char charAt = identifier.charAt(str.length());
            if ('a' <= charAt && charAt < '{') {
                z2 = true;
            }
            if (z2) {
                return null;
            }
            if (str2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(StringsKt.removePrefix(identifier, (CharSequence) str));
                return Name.identifier(sb.toString());
            } else if (z) {
                String decapitalizeSmartForCompiler = CapitalizeDecapitalizeKt.decapitalizeSmartForCompiler(StringsKt.removePrefix(identifier, (CharSequence) str), true);
                if (Name.isValidIdentifier(decapitalizeSmartForCompiler)) {
                    return Name.identifier(decapitalizeSmartForCompiler);
                }
                return null;
            } else {
                return name;
            }
        }
        return null;
    }

    public static final List<Name> getPropertyNamesCandidatesByAccessorName(Name name) {
        Intrinsics.checkNotNullParameter(name, "");
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "");
        if (JvmAbi.isGetterName(asString)) {
            return CollectionsKt.listOfNotNull(propertyNameByGetMethodName(name));
        }
        if (JvmAbi.isSetterName(asString)) {
            return propertyNamesBySetMethodName(name);
        }
        return BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(name);
    }
}
