package id.dana.danah5.ocrreceipt;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/danah5/ocrreceipt/OCRReceiptException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "", "event", "Ljava/lang/String;", "getEvent", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OCRReceiptException extends IllegalStateException {
    private final String event;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OCRReceiptException(String str, String str2) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.event = str2;
    }

    @JvmName(name = "getEvent")
    public final String getEvent() {
        return this.event;
    }
}
