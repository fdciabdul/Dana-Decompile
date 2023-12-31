package com.twilio.security.storage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\b\u0016\u0012\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0004\u0010\u0005B!\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002¢\u0006\u0004\b\u0004\u0010\b"}, d2 = {"Lcom/twilio/security/storage/StorageException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "<init>", "(Ljava/lang/Exception;)V", "", "message", "(Ljava/lang/String;Ljava/lang/Exception;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class StorageException extends Exception {
    public StorageException(String str, Exception exc) {
        super(str, exc);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StorageException(Exception exc) {
        this(exc.getMessage(), exc);
        Intrinsics.checkParameterIsNotNull(exc, "");
    }
}
