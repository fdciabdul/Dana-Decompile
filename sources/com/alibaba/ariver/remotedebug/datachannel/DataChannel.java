package com.alibaba.ariver.remotedebug.datachannel;

import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Map;

/* loaded from: classes6.dex */
public interface DataChannel {
    public static final int WEB_SOCKET_CHANNE = 1;

    /* loaded from: classes6.dex */
    public interface DataStatusChangedListener {
        void onConnectClosed(String str);

        void onConnectError(String str, int i, String str2);

        void onConnectFailed();

        void onConnectSuccess(String str);

        void recv(String str);

        void recv(byte[] bArr);
    }

    void close(int i, String str);

    void connect(String str, Map<String, String> map, JSONObject jSONObject) throws IOException, InvalidParameterException;

    boolean send(String str);
}
