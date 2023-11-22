package com.twilio.verify;

import com.alipay.iap.android.f2fpay.logger.BehaviorLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\tB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/twilio/verify/TwilioVerifyException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "cause", "Lcom/twilio/verify/TwilioVerifyException$ErrorCode;", "errorCode", "<init>", "(Ljava/lang/Throwable;Lcom/twilio/verify/TwilioVerifyException$ErrorCode;)V", BehaviorLogger.Key.ERROR_CODE}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class TwilioVerifyException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwilioVerifyException(Throwable th, ErrorCode errorCode) {
        super(errorCode.getMessage(), th);
        Intrinsics.checkParameterIsNotNull(th, "");
        Intrinsics.checkParameterIsNotNull(errorCode, "");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f"}, d2 = {"Lcom/twilio/verify/TwilioVerifyException$ErrorCode;", "", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "NetworkError", "MapperError", "StorageError", "InputError", "KeyStorageError", "InitializationError", "AuthenticationTokenError"}, k = 1, mv = {1, 8, 0})
    /* loaded from: classes.dex */
    public enum ErrorCode {
        NetworkError("{60401} Exception while calling the API"),
        MapperError("{60402} Exception while mapping an entity"),
        StorageError("{60403} Exception while storing/loading an entity"),
        InputError("{60404} Exception while loading input"),
        KeyStorageError("{60405} Exception while storing/loading key pairs"),
        InitializationError("{60406} Exception while initializing"),
        AuthenticationTokenError("{60407} Exception while generating token");

        private final String message;

        ErrorCode(String str) {
            this.message = str;
        }

        @JvmName(name = "getMessage")
        public final String getMessage() {
            return this.message;
        }
    }
}
