package org.yaml.snakeyaml.tokens;

/* loaded from: classes6.dex */
public final class TagTuple {
    public final String BuiltInFictitiousFunctionClassFactory;
    public final String MyBillsEntityDataFactory;

    public TagTuple(String str, String str2) {
        if (str2 == null) {
            throw new NullPointerException("Suffix must be provided.");
        }
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.MyBillsEntityDataFactory = str2;
    }
}
