package com.alibaba.ariver.kernel.api.extension.registry;

import com.alibaba.ariver.kernel.api.bytedata.ByteOrderDataUtil;
import com.alibaba.ariver.kernel.api.extension.ExtensionType;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.ariver.kernel.common.utils.StringUtils;
import com.alibaba.exthub.common.ExtHubLogger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class ExtensionMetaInfo extends NebulaConfigBase {

    /* renamed from: a  reason: collision with root package name */
    private final Set<String> f6090a;
    private InstanceType b;
    public String bundleName;
    public String extensionClass;
    public List<String> filter;
    public String filterStrs;
    public boolean isLazy;
    public Class<? extends Scope> scope;
    public String scopeClassName;
    public ExtensionType type;
    public String typeString;

    public ExtensionMetaInfo(String str, String str2, String str3, Class<? extends Scope> cls) {
        this(str, str2, str3, cls, true);
    }

    public ExtensionMetaInfo(String str, String str2, String str3, boolean z) {
        this(str, str2, Collections.singletonList(str3), z);
    }

    public ExtensionMetaInfo(String str, String str2, String str3, Class<? extends Scope> cls, boolean z) {
        this(str, str2, Collections.singletonList(str3), cls, z);
    }

    public ExtensionMetaInfo(String str, String str2, List<String> list) {
        this(str, str2, list, true);
    }

    public ExtensionMetaInfo(String str, String str2, List<String> list, Class<? extends Scope> cls) {
        this(str, str2, list, cls, true);
    }

    public ExtensionMetaInfo(String str, String str2, List<String> list, boolean z) {
        this(str, str2, list, (Class<? extends Scope>) null, z);
    }

    public ExtensionMetaInfo(String str, String str2, List<String> list, Class<? extends Scope> cls, boolean z) {
        this(str, str2, list, cls, ExtensionType.NORMAL, z);
    }

    public ExtensionMetaInfo(String str, String str2, List<String> list, Class<? extends Scope> cls, ExtensionType extensionType, boolean z) {
        super((byte) 11);
        this.scope = null;
        this.f6090a = new HashSet();
        this.bundleName = str;
        this.extensionClass = str2;
        this.isLazy = z;
        this.filter = list;
        this.scope = cls;
        this.type = extensionType;
    }

    public ExtensionMetaInfo(String str, String str2, String str3, String str4, String str5, boolean z) {
        super((byte) 11);
        this.scope = null;
        this.f6090a = new HashSet();
        this.bundleName = str;
        this.extensionClass = str2;
        this.isLazy = z;
        this.filterStrs = str3;
        this.scopeClassName = str4;
        this.typeString = str5;
        this.filter = b(str3);
        this.scope = a(str4);
        this.type = "normal".equals(this.typeString) ? ExtensionType.NORMAL : ExtensionType.BRIDGE;
    }

    public ExtensionMetaInfo addExcludeNode(String str) {
        this.f6090a.add(str);
        return this;
    }

    public Set<String> getExcludeNodes() {
        return this.f6090a;
    }

    public ExtensionMetaInfo instanceType(InstanceType instanceType) {
        this.b = instanceType;
        return this;
    }

    public InstanceType getInstanceType() {
        if (this.b == null) {
            this.b = MultiInstanceUtils.getDefaultInstanceType();
        }
        return this.b;
    }

    private Class<? extends Scope> a(String str) {
        String str2;
        Class cls;
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            if ("App".equalsIgnoreCase(str)) {
                str2 = "com.alibaba.ariver.app.api.App";
            } else if (!"Page".equalsIgnoreCase(str)) {
                return null;
            } else {
                str2 = "com.alibaba.ariver.app.api.Page";
            }
            cls = Class.forName(str2);
        } catch (Throwable th) {
            ExtHubLogger.e("ExtensionMetaInfo", th);
        }
        if (Scope.class.isAssignableFrom(cls)) {
            return cls;
        }
        return null;
    }

    private List<String> b(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        String replace = str.replace(" ", "");
        if (StringUtils.isEmpty(replace)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("add event configs ");
        sb.append(replace);
        ExtHubLogger.d("ExtensionMetaInfo", sb.toString());
        return Arrays.asList(replace.split("\\|"));
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.NebulaConfigBase
    public ExtensionMetaInfo serialize(BufferedOutputStream bufferedOutputStream) throws IOException {
        ByteOrderDataUtil.writeByte(bufferedOutputStream, this.mFormatVersion);
        ByteOrderDataUtil.writeString(bufferedOutputStream, this.bundleName);
        ByteOrderDataUtil.writeString(bufferedOutputStream, this.filterStrs);
        ByteOrderDataUtil.writeString(bufferedOutputStream, this.extensionClass);
        ByteOrderDataUtil.writeBoolean(bufferedOutputStream, this.isLazy);
        ByteOrderDataUtil.writeString(bufferedOutputStream, this.scopeClassName);
        ByteOrderDataUtil.writeString(bufferedOutputStream, this.typeString);
        return this;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.registry.NebulaConfigBase
    public ExtensionMetaInfo deserialize(BufferedInputStream bufferedInputStream) throws IOException {
        this.mFormatVersion = ByteOrderDataUtil.readByte(bufferedInputStream);
        this.bundleName = ByteOrderDataUtil.readString(bufferedInputStream);
        this.filterStrs = ByteOrderDataUtil.readString(bufferedInputStream);
        this.extensionClass = ByteOrderDataUtil.readString(bufferedInputStream);
        this.isLazy = ByteOrderDataUtil.readBoolean(bufferedInputStream);
        this.scopeClassName = ByteOrderDataUtil.readString(bufferedInputStream);
        this.typeString = ByteOrderDataUtil.readString(bufferedInputStream);
        this.filter = b(this.filterStrs);
        this.scope = a(this.scopeClassName);
        this.type = "normal".equals(this.typeString) ? ExtensionType.NORMAL : ExtensionType.BRIDGE;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtensionMetaInfo{extensionClass=");
        sb.append(this.extensionClass);
        sb.append(", filter=");
        sb.append(this.filter);
        sb.append(", type=");
        sb.append(this.typeString);
        sb.append(", instanceType=");
        sb.append(getInstanceType());
        sb.append('}');
        return sb.toString();
    }
}
