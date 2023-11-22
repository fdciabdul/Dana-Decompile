package com.alibaba.ariver.kernel.api.extension.resolver;

import java.util.List;

/* loaded from: classes3.dex */
public class BoolIntersectionResolver implements ResultResolver<Boolean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
    public Boolean resolve(List<Boolean> list) {
        Boolean bool = Boolean.FALSE;
        if (list == null) {
            return bool;
        }
        for (Boolean bool2 : list) {
            if (bool2 == null || !bool2.booleanValue()) {
                return bool;
            }
        }
        return Boolean.TRUE;
    }
}
