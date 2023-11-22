package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* loaded from: classes.dex */
public final class MultiFieldValueClassRepresentation<Type extends SimpleTypeMarker> extends ValueClassRepresentation<Type> {
    private final Map<Name, Type> map;
    private final List<Pair<Name, Type>> underlyingPropertyNamesToTypes;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation
    public final List<Pair<Name, Type>> getUnderlyingPropertyNamesToTypes() {
        return this.underlyingPropertyNamesToTypes;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MultiFieldValueClassRepresentation(List<? extends Pair<Name, ? extends Type>> list) {
        super(null);
        Intrinsics.checkNotNullParameter(list, "");
        this.underlyingPropertyNamesToTypes = list;
        Map<Name, Type> map = MapsKt.toMap(getUnderlyingPropertyNamesToTypes());
        if (map.size() == getUnderlyingPropertyNamesToTypes().size()) {
            this.map = map;
            return;
        }
        throw new IllegalArgumentException("Some properties have the same names".toString());
    }
}
