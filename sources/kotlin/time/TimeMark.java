package kotlin.time;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u0002H&ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u001b\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\f\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019"}, d2 = {"Lkotlin/time/TimeMark;", "", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "elapsedNow", "", "hasNotPassedNow", "()Z", "hasPassedNow", "duration", "minus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "minus", "plus-LRDsOJo", "plus", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class TimeMark {
    /* renamed from: elapsedNow-UwyO8pc */
    public abstract long mo4483elapsedNowUwyO8pc();

    /* renamed from: plus-LRDsOJo */
    public TimeMark mo4484plusLRDsOJo(long duration) {
        return new AdjustedTimeMark(this, duration, null);
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public TimeMark m4619minusLRDsOJo(long duration) {
        return mo4484plusLRDsOJo(Duration.m4542unaryMinusUwyO8pc(duration));
    }

    public final boolean hasPassedNow() {
        return !Duration.m4523isNegativeimpl(mo4483elapsedNowUwyO8pc());
    }

    public final boolean hasNotPassedNow() {
        return Duration.m4523isNegativeimpl(mo4483elapsedNowUwyO8pc());
    }
}
