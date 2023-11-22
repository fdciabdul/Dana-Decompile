package com.alipay.imobile.network.quake.transport;

import com.alipay.imobile.network.quake.Request;

/* loaded from: classes3.dex */
public interface Transporter {
    void submitRequest(Request request, TransporterCallBack transporterCallBack);
}
