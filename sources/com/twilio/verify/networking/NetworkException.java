package com.twilio.verify.networking;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fB%\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\u000fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/twilio/verify/networking/NetworkException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/twilio/verify/networking/FailureResponse;", "failureResponse", "Lcom/twilio/verify/networking/FailureResponse;", "getFailureResponse", "()Lcom/twilio/verify/networking/FailureResponse;", "<init>", "(Lcom/twilio/verify/networking/FailureResponse;)V", "", "cause", "(Ljava/lang/Throwable;)V", "", "message", "(Ljava/lang/String;Ljava/lang/Throwable;Lcom/twilio/verify/networking/FailureResponse;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class NetworkException extends Exception {
    private final FailureResponse failureResponse;

    @JvmName(name = "getFailureResponse")
    public final FailureResponse getFailureResponse() {
        return this.failureResponse;
    }

    public NetworkException(String str, Throwable th, FailureResponse failureResponse) {
        super(str, th);
        this.failureResponse = failureResponse;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NetworkException(com.twilio.verify.networking.FailureResponse r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Network exception with status code "
            r0.append(r1)
            r1 = 0
            if (r4 == 0) goto L14
            int r2 = r4.MyBillsEntityDataFactory
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L15
        L14:
            r2 = r1
        L15:
            r0.append(r2)
            java.lang.String r2 = " and body: "
            r0.append(r2)
            if (r4 == 0) goto L22
            java.lang.String r2 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            goto L23
        L22:
            r2 = r1
        L23:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twilio.verify.networking.NetworkException.<init>(com.twilio.verify.networking.FailureResponse):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NetworkException(Throwable th) {
        this(th.getMessage(), th, null);
        Intrinsics.checkParameterIsNotNull(th, "");
    }
}
