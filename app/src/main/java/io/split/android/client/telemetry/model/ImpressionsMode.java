package io.split.android.client.telemetry.model;

/* loaded from: classes6.dex */
public enum ImpressionsMode {
    OPTIMIZED,
    DEBUG,
    NONE;

    /* renamed from: io.split.android.client.telemetry.model.ImpressionsMode$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$telemetry$model$ImpressionsMode;

        static {
            int[] iArr = new int[ImpressionsMode.values().length];
            $SwitchMap$io$split$android$client$telemetry$model$ImpressionsMode = iArr;
            try {
                iArr[ImpressionsMode.OPTIMIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$telemetry$model$ImpressionsMode[ImpressionsMode.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$telemetry$model$ImpressionsMode[ImpressionsMode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public final int intValue() {
        int i = AnonymousClass1.$SwitchMap$io$split$android$client$telemetry$model$ImpressionsMode[ordinal()];
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }
}
