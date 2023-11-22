package org.yaml.snakeyaml.constructor;

/* loaded from: classes9.dex */
public class CustomClassLoaderConstructor extends Constructor {
    private final ClassLoader newProxyInstance;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.yaml.snakeyaml.constructor.Constructor
    public final Class<?> MyBillsEntityDataFactory(String str) throws ClassNotFoundException {
        return Class.forName(str, true, this.newProxyInstance);
    }
}
