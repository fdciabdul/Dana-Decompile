package com.alibaba.exthub.config;

import android.content.Context;
import com.alibaba.ariver.kernel.api.bytedata.ByteOrderDataUtil;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.NebulaConfigBase;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class ExtHubMetaInfoOperator {
    public static final String TAG = "ExtHubMetaInfoOperator";

    /* renamed from: a  reason: collision with root package name */
    private Context f6265a;

    public ExtHubMetaInfoOperator(Context context) {
        this.f6265a = context;
    }

    public ExtHubMetaInfoOperator() {
        this(null);
    }

    private List<NebulaConfigBase<?>> a(BufferedInputStream bufferedInputStream) {
        try {
            int readInt = ByteOrderDataUtil.readInt(bufferedInputStream);
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                ExtensionMetaInfo extensionMetaInfo = ByteOrderDataUtil.readByte(bufferedInputStream) != 2 ? null : new ExtensionMetaInfo((String) null, (String) null, (String) null, (String) null, "bridge", true);
                if (extensionMetaInfo != null) {
                    extensionMetaInfo.deserialize(bufferedInputStream);
                    arrayList.add(extensionMetaInfo);
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public List<NebulaConfigBase<?>> readMetaInfo(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            return a(bufferedInputStream);
        } finally {
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private void a(List<NebulaConfigBase<?>> list, BufferedOutputStream bufferedOutputStream) throws IOException {
        if (this.f6265a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6265a.getCacheDir());
            sb.append("/.doWriteExtHubMetaInfo.lock");
            ProcessLock processLock = new ProcessLock(sb.toString());
            try {
                processLock.lock();
                b(list, bufferedOutputStream);
                return;
            } finally {
                processLock.unlock();
            }
        }
        b(list, bufferedOutputStream);
    }

    private void b(List<NebulaConfigBase<?>> list, BufferedOutputStream bufferedOutputStream) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ByteOrderDataUtil.writeInt(bufferedOutputStream, list.size());
        for (NebulaConfigBase<?> nebulaConfigBase : list) {
            if (nebulaConfigBase instanceof ExtensionMetaInfo) {
                ByteOrderDataUtil.writeByte(bufferedOutputStream, (byte) 2);
            }
            nebulaConfigBase.serialize(bufferedOutputStream);
        }
    }

    public void writeMetaInfo(List<NebulaConfigBase<?>> list, OutputStream outputStream) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        if (list == null || list.isEmpty() || outputStream == null) {
            return;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(outputStream);
        } catch (Throwable th) {
            th = th;
            bufferedOutputStream = null;
        }
        try {
            a(list, bufferedOutputStream);
            bufferedOutputStream.flush();
            try {
                bufferedOutputStream.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public void writeMetaInfo(List<NebulaConfigBase<?>> list, File file) throws IOException {
        if (list == null || list.isEmpty() || file == null) {
            return;
        }
        writeMetaInfo(list, new FileOutputStream(file));
    }
}
