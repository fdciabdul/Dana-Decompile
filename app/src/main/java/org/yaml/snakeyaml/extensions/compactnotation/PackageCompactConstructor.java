package org.yaml.snakeyaml.extensions.compactnotation;

/* loaded from: classes9.dex */
public class PackageCompactConstructor extends CompactConstructor {
    private final String PrepareContext;

    @Override // org.yaml.snakeyaml.constructor.Constructor
    public final Class<?> MyBillsEntityDataFactory(String str) throws ClassNotFoundException {
        if (str.indexOf(46) < 0) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(this.PrepareContext);
                sb.append(".");
                sb.append(str);
                return Class.forName(sb.toString());
            } catch (ClassNotFoundException unused) {
            }
        }
        return super.MyBillsEntityDataFactory(str);
    }
}
