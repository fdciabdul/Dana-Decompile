package com.ipification.mobile.sdk.android;

import android.net.Network;
import android.os.Build;
import com.ipification.mobile.sdk.android.utils.IPConstant;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dns;

/* loaded from: classes3.dex */
public class NetworkDns implements Dns {
    private static NetworkDns getAuthRequestContext;
    public Network KClassImpl$Data$declaredNonStaticMembers$2;

    private NetworkDns() {
    }

    public static NetworkDns PlaceComponentResult() {
        if (getAuthRequestContext == null) {
            getAuthRequestContext = new NetworkDns();
        }
        return getAuthRequestContext;
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) {
        IPConstant PlaceComponentResult;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null || Build.VERSION.SDK_INT < 21) {
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
        try {
            ArrayList arrayList2 = new ArrayList();
            for (InetAddress inetAddress2 : this.KClassImpl$Data$declaredNonStaticMembers$2.getAllByName(str)) {
                if (inetAddress2 instanceof Inet4Address) {
                    arrayList2.add(0, inetAddress2);
                } else {
                    arrayList2.add(inetAddress2);
                }
            }
            return arrayList2;
        } catch (NullPointerException | UnknownHostException e) {
            try {
                return Dns.SYSTEM.lookup(str);
            } catch (UnknownHostException unused2) {
                PlaceComponentResult = IPConstant.Companion.PlaceComponentResult();
                StringBuilder sb = new StringBuilder();
                sb.append("DNS - mNetwork != null - looked-up- - error ");
                sb.append(e.getLocalizedMessage());
                sb.append("\n");
                String obj = sb.toString();
                Intrinsics.checkParameterIsNotNull(obj, "");
                PlaceComponentResult.DatabaseTableConfigUtil = obj;
                return Arrays.asList(InetAddress.getAllByName(str));
            }
        }
    }
}
