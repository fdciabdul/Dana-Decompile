package androidx.tracing;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class TraceApi18Impl {
    private TraceApi18Impl() {
    }

    public static void MyBillsEntityDataFactory(String str) {
        android.os.Trace.beginSection(str);
    }

    public static void MyBillsEntityDataFactory() {
        android.os.Trace.endSection();
    }
}
