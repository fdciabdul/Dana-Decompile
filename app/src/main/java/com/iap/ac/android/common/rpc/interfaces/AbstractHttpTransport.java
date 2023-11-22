package com.iap.ac.android.common.rpc.interfaces;

import com.iap.ac.android.common.rpc.model.HttpRequest;
import com.iap.ac.android.common.rpc.model.HttpResponse;

/* loaded from: classes3.dex */
public interface AbstractHttpTransport {
    HttpResponse performRequest(HttpRequest httpRequest) throws Exception;
}
