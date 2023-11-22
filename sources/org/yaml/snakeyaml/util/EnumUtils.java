package org.yaml.snakeyaml.util;

/* loaded from: classes6.dex */
public class EnumUtils {
    public static <T extends Enum<T>> T BuiltInFictitiousFunctionClassFactory(Class<T> cls, String str) {
        for (T t : cls.getEnumConstants()) {
            if (t.name().compareToIgnoreCase(str) == 0) {
                return t;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No enum constant ");
        sb.append(cls.getCanonicalName());
        sb.append(".");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }
}
