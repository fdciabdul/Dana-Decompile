package io.opentelemetry.api.trace;

/* loaded from: classes6.dex */
public interface TraceFlags {
    byte asByte();

    String asHex();

    boolean isSampled();

    /* renamed from: io.opentelemetry.api.trace.TraceFlags$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static int getLength() {
            return 2;
        }

        public static TraceFlags getDefault() {
            return ImmutableTraceFlags.DEFAULT;
        }

        public static TraceFlags getSampled() {
            return ImmutableTraceFlags.SAMPLED;
        }

        public static TraceFlags fromHex(CharSequence charSequence, int i) {
            return ImmutableTraceFlags.fromHex(charSequence, i);
        }

        public static TraceFlags fromByte(byte b) {
            return ImmutableTraceFlags.fromByte(b);
        }
    }
}
