package com.alibaba.ariver.kernel.api.classloader;

/* loaded from: classes6.dex */
public class DefaultClassLoaderFactory implements RVClassLoaderFactory {
    @Override // com.alibaba.ariver.kernel.api.classloader.RVClassLoaderFactory
    public ClassLoader getClassLoader(String str) {
        return DefaultClassLoaderFactory.class.getClassLoader();
    }
}
