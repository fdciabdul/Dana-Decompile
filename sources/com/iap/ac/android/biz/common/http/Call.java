package com.iap.ac.android.biz.common.http;

import com.iap.ac.android.biz.common.model.http.HttpResponse;

/* loaded from: classes8.dex */
public interface Call {
    HttpResponse call() throws Exception;

    HttpResponse execute() throws Exception;
}
