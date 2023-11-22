package androidx.core.os;

import androidx.core.util.ObjectsCompat;

/* loaded from: classes3.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String str) {
        super(ObjectsCompat.BuiltInFictitiousFunctionClassFactory(str, "The operation has been canceled."));
    }
}
