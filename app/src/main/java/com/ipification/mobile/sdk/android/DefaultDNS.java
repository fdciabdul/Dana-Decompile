package com.ipification.mobile.sdk.android;

import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Dns;

/* loaded from: classes3.dex */
public class DefaultDNS implements Dns {
    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ArrayList arrayList = new ArrayList();
                for (InetAddress inetAddress : InetAddress.getAllByName(str)) {
                    if (inetAddress instanceof Inet4Address) {
                        arrayList.add(0, inetAddress);
                    } else {
                        arrayList.add(inetAddress);
                    }
                }
                return arrayList;
            } catch (NullPointerException unused) {
                return Dns.SYSTEM.lookup(str);
            }
        }
        return Dns.SYSTEM.lookup(str);
    }
}
