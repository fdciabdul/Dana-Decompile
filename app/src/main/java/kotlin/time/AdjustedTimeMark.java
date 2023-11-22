package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B\u001a\u0012\u0006\u0010\r\u001a\u00020\u0001\u0012\u0006\u0010\n\u001a\u00020\u0002ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u00028\u0007ø\u0001\u0000¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00018\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019"}, d2 = {"Lkotlin/time/AdjustedTimeMark;", "Lkotlin/time/TimeMark;", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "elapsedNow", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "adjustment", "J", "getAdjustment-UwyO8pc", "mark", "Lkotlin/time/TimeMark;", "getMark", "()Lkotlin/time/TimeMark;", "<init>", "(Lkotlin/time/TimeMark;JLkotlin/jvm/internal/DefaultConstructorMarker;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
final class AdjustedTimeMark extends TimeMark {
    private final long adjustment;
    private final TimeMark mark;

    public /* synthetic */ AdjustedTimeMark(TimeMark timeMark, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(timeMark, j);
    }

    private AdjustedTimeMark(TimeMark timeMark, long j) {
        this.mark = timeMark;
        this.adjustment = j;
    }

    @JvmName(name = "getAdjustment-UwyO8pc")
    /* renamed from: getAdjustment-UwyO8pc  reason: not valid java name and from getter */
    public final long getAdjustment() {
        return this.adjustment;
    }

    @JvmName(name = "getMark")
    public final TimeMark getMark() {
        return this.mark;
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: elapsedNow-UwyO8pc */
    public final long mo4483elapsedNowUwyO8pc() {
        return Duration.m4525minusLRDsOJo(this.mark.mo4483elapsedNowUwyO8pc(), getAdjustment());
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: plus-LRDsOJo */
    public final TimeMark mo4484plusLRDsOJo(long duration) {
        return new AdjustedTimeMark(this.mark, Duration.m4526plusLRDsOJo(getAdjustment(), duration), null);
    }
}
