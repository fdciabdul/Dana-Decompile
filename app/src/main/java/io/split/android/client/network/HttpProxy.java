package io.split.android.client.network;

import com.google.common.base.Preconditions;

/* loaded from: classes6.dex */
public class HttpProxy {
    private final String host;
    private final String password;
    private final int port;
    private final String username;

    public HttpProxy(String str, int i) {
        this(str, i, null, null);
    }

    public HttpProxy(String str, int i, String str2, String str3) {
        Preconditions.checkNotNull(str);
        this.host = str;
        this.port = i;
        this.username = str2;
        this.password = str3;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean usesCredentials() {
        return this.username == null;
    }
}
