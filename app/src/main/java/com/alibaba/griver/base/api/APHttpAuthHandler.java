package com.alibaba.griver.base.api;

/* loaded from: classes6.dex */
public interface APHttpAuthHandler {
    void cancel();

    void proceed(String str, String str2);

    boolean useHttpAuthUsernamePassword();
}
