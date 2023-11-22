package org.yaml.snakeyaml.introspector;

import java.lang.reflect.Field;

/* loaded from: classes6.dex */
public class FieldProperty extends GenericProperty {
    private final Field PlaceComponentResult;

    public FieldProperty(Field field) {
        super(field.getName(), field.getType(), field.getGenericType());
        this.PlaceComponentResult = field;
        field.setAccessible(true);
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public final void PlaceComponentResult(Object obj, Object obj2) throws Exception {
        this.PlaceComponentResult.set(obj, obj2);
    }
}
