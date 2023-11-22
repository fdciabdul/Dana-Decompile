package com.twilio.verify.networking;

import com.google.firebase.perf.FirebasePerformance;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f"}, d2 = {"Lcom/twilio/verify/networking/HttpMethod;", "", "", "method", "Ljava/lang/String;", "getMethod", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Get", "Post", MyBillsPurposeAction.DELETE, "Put"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public enum HttpMethod {
    Get("GET"),
    Post("POST"),
    Delete("DELETE"),
    Put(FirebasePerformance.HttpMethod.PUT);

    private final String method;

    HttpMethod(String str) {
        this.method = str;
    }

    @JvmName(name = "getMethod")
    public final String getMethod() {
        return this.method;
    }
}
