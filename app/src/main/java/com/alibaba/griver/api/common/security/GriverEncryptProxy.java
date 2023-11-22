package com.alibaba.griver.api.common.security;

import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes6.dex */
public interface GriverEncryptProxy extends Proxiable {
    String decrypt(String str);

    String encrypt(String str);
}
