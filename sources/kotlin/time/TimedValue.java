package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001a\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00020\u0005ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\b\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\t\u001a\u00028\u00002\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001a\u0010\t\u001a\u00028\u00008\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019"}, d2 = {"Lkotlin/time/TimedValue;", "T", "", "component1", "()Ljava/lang/Object;", "Lkotlin/time/Duration;", "component2-UwyO8pc", "()J", "component2", "value", "duration", "copy-RFiDyg4", "(Ljava/lang/Object;J)Lkotlin/time/TimedValue;", "copy", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "J", "getDuration-UwyO8pc", "Ljava/lang/Object;", "getValue", "<init>", "(Ljava/lang/Object;JLkotlin/jvm/internal/DefaultConstructorMarker;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class TimedValue<T> {
    private final long duration;
    private final T value;

    public /* synthetic */ TimedValue(Object obj, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-RFiDyg4$default  reason: not valid java name */
    public static /* synthetic */ TimedValue m4620copyRFiDyg4$default(TimedValue timedValue, Object obj, long j, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = timedValue.value;
        }
        if ((i & 2) != 0) {
            j = timedValue.duration;
        }
        return timedValue.m4622copyRFiDyg4(obj, j);
    }

    public final T component1() {
        return this.value;
    }

    /* renamed from: component2-UwyO8pc  reason: not valid java name and from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: copy-RFiDyg4  reason: not valid java name */
    public final TimedValue<T> m4622copyRFiDyg4(T value, long duration) {
        return new TimedValue<>(value, duration, null);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TimedValue) {
            TimedValue timedValue = (TimedValue) other;
            return Intrinsics.areEqual(this.value, timedValue.value) && Duration.m4495equalsimpl0(this.duration, timedValue.duration);
        }
        return false;
    }

    public final int hashCode() {
        T t = this.value;
        return ((t == null ? 0 : t.hashCode()) * 31) + Duration.m4518hashCodeimpl(this.duration);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TimedValue(value=");
        sb.append(this.value);
        sb.append(", duration=");
        sb.append((Object) Duration.m4539toStringimpl(this.duration));
        sb.append(')');
        return sb.toString();
    }

    private TimedValue(T t, long j) {
        this.value = t;
        this.duration = j;
    }

    @JvmName(name = "getDuration-UwyO8pc")
    /* renamed from: getDuration-UwyO8pc  reason: not valid java name */
    public final long m4623getDurationUwyO8pc() {
        return this.duration;
    }

    @JvmName(name = "getValue")
    public final T getValue() {
        return this.value;
    }
}
