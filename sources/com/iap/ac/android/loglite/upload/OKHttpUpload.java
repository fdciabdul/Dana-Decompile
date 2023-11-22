package com.iap.ac.android.loglite.upload;

import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* loaded from: classes3.dex */
public class OKHttpUpload {
    public static final MediaType b = MediaType.parse("text/xml");
    public static volatile OKHttpUpload c;

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f7599a;

    public OKHttpUpload() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        InstrumentInjector.okhttp_addInterceptors(builder);
        OkHttpClient.Builder protocols = builder.protocols(Collections.unmodifiableList(Arrays.asList(Protocol.HTTP_1_1, Protocol.HTTP_2)));
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f7599a = protocols.connectTimeout(20000L, timeUnit).readTimeout(20000L, timeUnit).build();
    }
}
