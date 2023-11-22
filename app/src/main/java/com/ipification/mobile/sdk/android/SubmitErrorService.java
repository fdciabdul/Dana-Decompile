package com.ipification.mobile.sdk.android;

import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.ipification.mobile.sdk.android.IPConfiguration;
import com.ipification.mobile.sdk.android.interceptor.SdkLogInterceptor;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/ipification/mobile/sdk/android/SubmitErrorService;", "", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SubmitErrorService {
    public static void getAuthRequestContext(String p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
        if (IPConfiguration.Companion.MyBillsEntityDataFactory().getVerifyPinStateManager$executeRiskChallenge$2$2()) {
            IPConfiguration MyBillsEntityDataFactory = IPConfiguration.Companion.MyBillsEntityDataFactory();
            String str = MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7 == IPEnvironment.SANDBOX ? MyBillsEntityDataFactory.getSupportButtonTintMode : MyBillsEntityDataFactory.whenAvailable;
            FormBody build = new FormBody.Builder().add("log_data", p0).build();
            Intrinsics.checkExpressionValueIsNotNull(build, "");
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            InstrumentInjector.okhttp_addInterceptors(builder);
            builder.dns(new DefaultDNS());
            builder.addInterceptor(new SdkLogInterceptor());
            Request build2 = new Request.Builder().url(str).post(build).build();
            Intrinsics.checkExpressionValueIsNotNull(build2, "");
            FirebasePerfOkHttpClient.enqueue(builder.build().newCall(build2), new Callback() { // from class: com.ipification.mobile.sdk.android.SubmitErrorService$callService$1
                @Override // okhttp3.Callback
                public final void onFailure(Call p02, IOException p1) {
                    Intrinsics.checkParameterIsNotNull(p02, "");
                    Intrinsics.checkParameterIsNotNull(p1, "");
                }

                @Override // okhttp3.Callback
                public final void onResponse(Call p02, Response p1) {
                    Intrinsics.checkParameterIsNotNull(p02, "");
                    Intrinsics.checkParameterIsNotNull(p1, "");
                }
            });
        }
    }
}
