package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* loaded from: classes.dex */
public final class InlineClassRepresentation<Type extends SimpleTypeMarker> extends ValueClassRepresentation<Type> {
    private final Name underlyingPropertyName;
    private final Type underlyingType;

    public final Name getUnderlyingPropertyName() {
        return this.underlyingPropertyName;
    }

    public final Type getUnderlyingType() {
        return this.underlyingType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineClassRepresentation(Name name, Type type) {
        super(null);
        Intrinsics.checkNotNullParameter(name, "");
        Intrinsics.checkNotNullParameter(type, "");
        this.underlyingPropertyName = name;
        this.underlyingType = type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation
    public final List<Pair<Name, Type>> getUnderlyingPropertyNamesToTypes() {
        return CollectionsKt.listOf(TuplesKt.to(this.underlyingPropertyName, this.underlyingType));
    }
}
