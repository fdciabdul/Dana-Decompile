package com.alibaba.ariver.ipc.uniform;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.UniformIpcUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class ObjSerializUtil {
    public static final byte[] serializ(Serializable serializable) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        try {
            objectOutputStream.writeObject(serializable);
            objectOutputStream.flush();
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            try {
                byteArrayOutputStream.close();
                objectOutputStream.close();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ObjSerializUtil serializ exception: ");
                sb.append(e.toString());
                RVLogger.w(UniformIpcUtils.TAG, sb.toString());
            }
        }
    }

    public static final Serializable deserializ(byte[] bArr) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        try {
            return (Serializable) objectInputStream.readObject();
        } finally {
            try {
                byteArrayInputStream.close();
                objectInputStream.close();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ObjSerializUtil deserializ exception: ");
                sb.append(e.toString());
                RVLogger.w(UniformIpcUtils.TAG, sb.toString());
            }
        }
    }

    public static final Serializable deserializ(byte[] bArr, ClassLoader classLoader) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        CustomCLObjectInputStream customCLObjectInputStream = new CustomCLObjectInputStream(byteArrayInputStream, classLoader);
        try {
            return (Serializable) customCLObjectInputStream.readObject();
        } finally {
            try {
                byteArrayInputStream.close();
                customCLObjectInputStream.close();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ObjSerializUtil deserializ2 exception: ");
                sb.append(e.toString());
                RVLogger.w(UniformIpcUtils.TAG, sb.toString());
            }
        }
    }
}
