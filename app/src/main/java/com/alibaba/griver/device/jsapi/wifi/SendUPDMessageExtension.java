package com.alibaba.griver.device.jsapi.wifi;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.device.R;
import java.lang.reflect.InvocationTargetException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/* loaded from: classes2.dex */
public class SendUPDMessageExtension implements BridgeExtension {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6526a = "SendUPDMessageExtension";

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    private static InetAddress a(Context context) throws UnknownHostException {
        if (b(context).booleanValue()) {
            return InetAddress.getByName(context.getResources().getString(R.string.griver_ip_192));
        }
        DhcpInfo dhcpInfo = ((WifiManager) context.getSystemService("wifi")).getDhcpInfo();
        if (dhcpInfo == null) {
            return InetAddress.getByName(context.getResources().getString(R.string.griver_ip_255));
        }
        int i = dhcpInfo.ipAddress;
        int i2 = dhcpInfo.netmask;
        int i3 = dhcpInfo.netmask;
        byte[] bArr = new byte[4];
        for (int i4 = 0; i4 < 4; i4++) {
            bArr[i4] = (byte) ((((i & i2) | (i3 ^ (-1))) >> (i4 * 8)) & 255);
        }
        return InetAddress.getByAddress(bArr);
    }

    private static Boolean b(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return (Boolean) wifiManager.getClass().getMethod("isWifiApEnabled", new Class[0]).invoke(wifiManager, new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            return Boolean.FALSE;
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public BridgeResponse sendUdpMessage(@BindingParam({"ip"}) String str, @BindingParam({"port"}) int i, @BindingParam({"data"}) String str2, @BindingParam({"broadcast"}) String str3, @BindingApiContext ApiContext apiContext) {
        boolean z = !str3.isEmpty() && WifiUtils.parseInt(str3) > 0;
        String str4 = f6526a;
        StringBuilder sb = new StringBuilder();
        sb.append("sendUdpMessage before ip:");
        sb.append(str);
        sb.append(",port:");
        sb.append(i);
        sb.append(",data:");
        sb.append(str2);
        sb.append(",broadcast:");
        sb.append(str3);
        RVLogger.e(str4, sb.toString());
        if (str == null || i == 0 || str2 == null) {
            RVLogger.e(str4, "sendUdpMessage param is empty");
            return new BridgeResponse.Error(12, "param is empty");
        }
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            try {
                InetAddress byName = InetAddress.getByName(str);
                if (z) {
                    datagramSocket.setBroadcast(true);
                    byName = a(apiContext.getActivity().getApplication());
                }
                byte[] decode = Base64.decode(str2.getBytes(), 2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("sendUdpMessage after ip:");
                sb2.append(str);
                sb2.append(",port:");
                sb2.append(i);
                sb2.append(",data:");
                sb2.append(decode);
                RVLogger.e(str4, sb2.toString());
                datagramSocket.send(new DatagramPacket(decode, decode.length, byName, i));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("message", (Object) "");
                datagramSocket.close();
                return new BridgeResponse(jSONObject);
            } catch (Throwable th) {
                datagramSocket.close();
                RVLogger.e(f6526a, String.format("sendSocketMessage error : %s", th.toString()), th);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("exception: ");
                sb3.append(th.getMessage());
                return new BridgeResponse.Error(12, sb3.toString());
            }
        } catch (SocketException e) {
            RVLogger.e(f6526a, String.format("sendUdpMessage error : %s", e.toString()), e);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("exception: ");
            sb4.append(e.getMessage());
            return new BridgeResponse.Error(12, sb4.toString());
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getSSID(@BindingApiContext ApiContext apiContext) {
        WifiManager wifiManager = (WifiManager) apiContext.getActivity().getApplicationContext().getSystemService("wifi");
        String ssid = wifiManager.isWifiEnabled() ? wifiManager.getConnectionInfo().getSSID() : "";
        String str = TextUtils.isEmpty(ssid) ? "" : ssid;
        if (Build.VERSION.SDK_INT >= 17 && str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ssid", (Object) str);
        return new BridgeResponse(jSONObject);
    }
}
