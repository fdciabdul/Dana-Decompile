package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class RawTypeImpl extends FlexibleType implements RawType {
    private RawTypeImpl(SimpleType simpleType, SimpleType simpleType2, boolean z) {
        super(simpleType, simpleType2);
        if (z) {
            return;
        }
        KotlinTypeChecker.DEFAULT.isSubtypeOf(simpleType, simpleType2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RawTypeImpl(SimpleType simpleType, SimpleType simpleType2) {
        this(simpleType, simpleType2, false);
        Intrinsics.checkNotNullParameter(simpleType, "");
        Intrinsics.checkNotNullParameter(simpleType2, "");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public final SimpleType getDelegate() {
        return getLowerBound();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser, kotlin.jvm.internal.DefaultConstructorMarker] */
    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public final MemberScope getMemberScope() {
        ClassifierDescriptor mo4441getDeclarationDescriptor = getConstructor().mo4441getDeclarationDescriptor();
        ?? r2 = 0;
        ClassDescriptor classDescriptor = mo4441getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo4441getDeclarationDescriptor : null;
        if (classDescriptor == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Incorrect classifier: ");
            sb.append(getConstructor().mo4441getDeclarationDescriptor());
            throw new IllegalStateException(sb.toString().toString());
        }
        MemberScope memberScope = classDescriptor.getMemberScope(new RawSubstitution(r2, 1, r2));
        Intrinsics.checkNotNullExpressionValue(memberScope, "");
        return memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public final RawTypeImpl replaceAttributes(TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "");
        return new RawTypeImpl(getLowerBound().replaceAttributes(typeAttributes), getUpperBound().replaceAttributes(typeAttributes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public final RawTypeImpl makeNullableAsSpecified(boolean z) {
        return new RawTypeImpl(getLowerBound().makeNullableAsSpecified(z), getUpperBound().makeNullableAsSpecified(z));
    }

    private static final boolean render$onlyOutDiffers(String str, String str2) {
        return Intrinsics.areEqual(str, StringsKt.removePrefix(str2, (CharSequence) "out ")) || Intrinsics.areEqual(str2, "*");
    }

    private static final List<String> render$renderArguments(DescriptorRenderer descriptorRenderer, KotlinType kotlinType) {
        List<TypeProjection> arguments = kotlinType.getArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
        Iterator<T> it = arguments.iterator();
        while (it.hasNext()) {
            arrayList.add(descriptorRenderer.renderTypeProjection((TypeProjection) it.next()));
        }
        return arrayList;
    }

    private static final String render$replaceArgs(String str, String str2) {
        if (StringsKt.contains$default((CharSequence) str, (char) Typography.less, false, 2, (Object) null)) {
            StringBuilder sb = new StringBuilder();
            sb.append(StringsKt.substringBefore$default(str, (char) Typography.less, (String) null, 2, (Object) null));
            sb.append(Typography.less);
            sb.append(str2);
            sb.append(Typography.greater);
            sb.append(StringsKt.substringAfterLast$default(str, (char) Typography.greater, (String) null, 2, (Object) null));
            return sb.toString();
        }
        return str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public final String render(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions) {
        Intrinsics.checkNotNullParameter(descriptorRenderer, "");
        Intrinsics.checkNotNullParameter(descriptorRendererOptions, "");
        String renderType = descriptorRenderer.renderType(getLowerBound());
        String renderType2 = descriptorRenderer.renderType(getUpperBound());
        if (descriptorRendererOptions.getDebugMode()) {
            StringBuilder sb = new StringBuilder();
            sb.append("raw (");
            sb.append(renderType);
            sb.append("..");
            sb.append(renderType2);
            sb.append(')');
            return sb.toString();
        } else if (getUpperBound().getArguments().isEmpty()) {
            return descriptorRenderer.renderFlexibleType(renderType, renderType2, TypeUtilsKt.getBuiltIns(this));
        } else {
            List<String> render$renderArguments = render$renderArguments(descriptorRenderer, getLowerBound());
            List<String> render$renderArguments2 = render$renderArguments(descriptorRenderer, getUpperBound());
            List<String> list = render$renderArguments;
            String joinToString$default = CollectionsKt.joinToString$default(list, ", ", null, null, 0, null, new Function1<String, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl$render$newArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(String str) {
                    Intrinsics.checkNotNullParameter(str, "");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("(raw) ");
                    sb2.append(str);
                    return sb2.toString();
                }
            }, 30, null);
            List zip = CollectionsKt.zip(list, render$renderArguments2);
            boolean z = true;
            if (!(zip instanceof Collection) || !zip.isEmpty()) {
                Iterator it = zip.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Pair pair = (Pair) it.next();
                    if (!render$onlyOutDiffers((String) pair.getFirst(), (String) pair.getSecond())) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                renderType2 = render$replaceArgs(renderType2, joinToString$default);
            }
            String render$replaceArgs = render$replaceArgs(renderType, joinToString$default);
            return Intrinsics.areEqual(render$replaceArgs, renderType2) ? render$replaceArgs : descriptorRenderer.renderFlexibleType(render$replaceArgs, renderType2, TypeUtilsKt.getBuiltIns(this));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public final FlexibleType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "");
        KotlinType refineType = kotlinTypeRefiner.refineType((KotlinTypeMarker) getLowerBound());
        Intrinsics.checkNotNull(refineType);
        KotlinType refineType2 = kotlinTypeRefiner.refineType((KotlinTypeMarker) getUpperBound());
        Intrinsics.checkNotNull(refineType2);
        return new RawTypeImpl((SimpleType) refineType, (SimpleType) refineType2, true);
    }
}
