package com.alibaba.ariver.ipc.uniform;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;

/* loaded from: classes3.dex */
public class CustomCLObjectInputStream extends ObjectInputStream {

    /* renamed from: a  reason: collision with root package name */
    private ClassLoader f6069a;

    protected CustomCLObjectInputStream() throws IOException {
    }

    public CustomCLObjectInputStream(InputStream inputStream, ClassLoader classLoader) throws StreamCorruptedException, IOException {
        super(inputStream);
        this.f6069a = classLoader;
    }

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        try {
            return super.resolveClass(objectStreamClass);
        } catch (Exception e) {
            RVLogger.e("MyObjectInputStream", "", e);
            return Class.forName(objectStreamClass.getName(), true, this.f6069a);
        }
    }
}
