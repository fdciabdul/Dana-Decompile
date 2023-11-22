package com.alibaba.ariver.kernel.api.extension.registry;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public interface ExtensionRegistry {
    ActionMeta findActionMeta(InstanceType instanceType, String str);

    Collection<Class<? extends Extension>> findExtensions(InstanceType instanceType, String str);

    Collection<Class<? extends Extension>> findExtensions(String str);

    int getActionCount();

    Class<? extends Extension> getExtensionClass(String str);

    Class<? extends Scope> getScope(Class<? extends Extension> cls);

    Class<? extends Scope> getScope(String str);

    void register(ExtensionMetaInfo extensionMetaInfo);

    void register(Class<? extends Extension> cls);

    void register(Class<? extends Extension> cls, Class<? extends Scope> cls2);

    void register(Class<? extends Extension> cls, Class<? extends Scope> cls2, InstanceType instanceType);

    void unRegister(List<String> list);
}
