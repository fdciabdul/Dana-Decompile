package org.yaml.snakeyaml.util;

/* loaded from: classes6.dex */
public class PlatformFeatureDetector {
    private Boolean MyBillsEntityDataFactory = null;

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        if (this.MyBillsEntityDataFactory == null) {
            String property = System.getProperty("java.runtime.name");
            this.MyBillsEntityDataFactory = Boolean.valueOf(property != null && property.startsWith("Android Runtime"));
        }
        return this.MyBillsEntityDataFactory.booleanValue();
    }
}
