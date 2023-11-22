package com.iap.ac.android.biz.common.proxy;

import com.iap.ac.android.common.rpc.model.HttpRequest;
import com.iap.ac.android.common.rpc.model.HttpResponse;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface HttpTransporter {
    HttpResponse sendHttpRequest(HttpRequest httpRequest) throws IOException;
}
