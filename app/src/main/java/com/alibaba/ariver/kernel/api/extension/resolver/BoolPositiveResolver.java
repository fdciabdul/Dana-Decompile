package com.alibaba.ariver.kernel.api.extension.resolver;

import java.util.List;

/* loaded from: classes3.dex */
public class BoolPositiveResolver implements ResultResolver<Boolean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
    public Boolean resolve(List<Boolean> list) {
        boolean z;
        if (list != null) {
            for (Boolean bool : list) {
                if (bool != null && bool.booleanValue()) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
