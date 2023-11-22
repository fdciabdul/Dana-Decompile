package kotlin.time;

import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H$¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0005X\u0084\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource;", "Lkotlin/time/TimeMark;", "markNow", "()Lkotlin/time/TimeMark;", "", "read", "()D", "Lkotlin/time/DurationUnit;", OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT, "Lkotlin/time/DurationUnit;", "getUnit", "()Lkotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "DoubleTimeMark"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public abstract class AbstractDoubleTimeSource implements TimeSource {
    private final DurationUnit unit;

    protected abstract double read();

    public AbstractDoubleTimeSource(DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "");
        this.unit = durationUnit;
    }

    @JvmName(name = "getUnit")
    protected final DurationUnit getUnit() {
        return this.unit;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lkotlin/time/TimeMark;", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "elapsedNow", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "offset", "J", "", "startedAt", SummaryActivity.DAYS, "Lkotlin/time/AbstractDoubleTimeSource;", "timeSource", "Lkotlin/time/AbstractDoubleTimeSource;", "<init>", "(DLkotlin/time/AbstractDoubleTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    static final class DoubleTimeMark extends TimeMark {
        private final long offset;
        private final double startedAt;
        private final AbstractDoubleTimeSource timeSource;

        public /* synthetic */ DoubleTimeMark(double d, AbstractDoubleTimeSource abstractDoubleTimeSource, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(d, abstractDoubleTimeSource, j);
        }

        private DoubleTimeMark(double d, AbstractDoubleTimeSource abstractDoubleTimeSource, long j) {
            this.startedAt = d;
            this.timeSource = abstractDoubleTimeSource;
            this.offset = j;
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: elapsedNow-UwyO8pc  reason: not valid java name */
        public final long mo4483elapsedNowUwyO8pc() {
            return Duration.m4525minusLRDsOJo(DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: plus-LRDsOJo  reason: not valid java name */
        public final TimeMark mo4484plusLRDsOJo(long duration) {
            return new DoubleTimeMark(this.startedAt, this.timeSource, Duration.m4526plusLRDsOJo(this.offset, duration), null);
        }
    }

    @Override // kotlin.time.TimeSource
    public TimeMark markNow() {
        return new DoubleTimeMark(read(), this, Duration.INSTANCE.m4592getZEROUwyO8pc(), null);
    }
}
