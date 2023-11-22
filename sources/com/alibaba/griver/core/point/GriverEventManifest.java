package com.alibaba.griver.core.point;

import com.alibaba.ariver.kernel.api.node.Scope;
import java.util.List;

/* loaded from: classes3.dex */
public class GriverEventManifest {

    /* renamed from: a  reason: collision with root package name */
    private String f6435a;
    private List<String> b;
    private Class<? extends Scope> c;

    public GriverEventManifest(String str, List<String> list, Class<? extends Scope> cls) {
        this.f6435a = str;
        this.b = list;
        this.c = cls;
    }

    public String getHandlerClassName() {
        return this.f6435a;
    }

    public void setHandlerClassName(String str) {
        this.f6435a = str;
    }

    public List<String> getEventClassNames() {
        return this.b;
    }

    public void setEventClassNames(List<String> list) {
        this.b = list;
    }

    public Class<? extends Scope> getScope() {
        return this.c;
    }

    public void setScope(Class<? extends Scope> cls) {
        this.c = cls;
    }
}
