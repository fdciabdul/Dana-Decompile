package com.alibaba.ariver.kernel.api.extension.bridge;

import com.alibaba.ariver.kernel.api.annotation.UsePermission;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class ActionMeta {
    public Method actionMethod;
    public String actionName;
    public Class<? extends BridgeExtension> bridgeExtensionClazz;
    public String[] nativePermissions;
    public Annotation[][] paramAnnotationArray;
    public Class[] paramTypes;
    public UsePermission usePermission;
    public boolean paramRequired = false;
    public boolean autoCallback = false;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionMeta{actionName='");
        sb.append(this.actionName);
        sb.append('\'');
        sb.append(", bridgeExtensionClazz=");
        sb.append(this.bridgeExtensionClazz);
        sb.append(", paramRequired=");
        sb.append(this.paramRequired);
        sb.append(", autoCallback=");
        sb.append(this.autoCallback);
        sb.append('}');
        return sb.toString();
    }
}
