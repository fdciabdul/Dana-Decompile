package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.LongCompanionObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/Duration;", "duration", "", "overflow-LRDsOJo", "(J)V", "overflow", "plusAssign-LRDsOJo", "plusAssign", "", "read", "()J", "reading", "J", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
    }

    @Override // kotlin.time.AbstractLongTimeSource
    /* renamed from: read  reason: from getter */
    protected final long getReading() {
        return this.reading;
    }

    /* renamed from: plusAssign-LRDsOJo  reason: not valid java name */
    public final void m4618plusAssignLRDsOJo(long duration) {
        long j;
        long m4536toLongimpl = Duration.m4536toLongimpl(duration, getUnit());
        if (m4536toLongimpl != Long.MIN_VALUE && m4536toLongimpl != LongCompanionObject.MAX_VALUE) {
            long j2 = this.reading;
            j = j2 + m4536toLongimpl;
            if ((m4536toLongimpl ^ j2) >= 0 && (j2 ^ j) < 0) {
                m4617overflowLRDsOJo(duration);
            }
        } else {
            double m4533toDoubleimpl = Duration.m4533toDoubleimpl(duration, getUnit());
            double d = this.reading;
            Double.isNaN(d);
            double d2 = d + m4533toDoubleimpl;
            if (d2 > 9.223372036854776E18d || d2 < -9.223372036854776E18d) {
                m4617overflowLRDsOJo(duration);
            }
            j = (long) d2;
        }
        this.reading = j;
    }

    /* renamed from: overflow-LRDsOJo  reason: not valid java name */
    private final void m4617overflowLRDsOJo(long duration) {
        StringBuilder sb = new StringBuilder();
        sb.append("TestTimeSource will overflow if its reading ");
        sb.append(this.reading);
        sb.append("ns is advanced by ");
        sb.append((Object) Duration.m4539toStringimpl(duration));
        sb.append('.');
        throw new IllegalStateException(sb.toString());
    }
}
