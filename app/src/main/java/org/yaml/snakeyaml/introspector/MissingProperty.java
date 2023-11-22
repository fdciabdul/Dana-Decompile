package org.yaml.snakeyaml.introspector;

/* loaded from: classes6.dex */
public class MissingProperty extends Property {
    @Override // org.yaml.snakeyaml.introspector.Property
    public final Class<?>[] BuiltInFictitiousFunctionClassFactory() {
        return new Class[0];
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public final void PlaceComponentResult(Object obj, Object obj2) throws Exception {
    }

    public MissingProperty(String str) {
        super(str, Object.class);
    }
}
