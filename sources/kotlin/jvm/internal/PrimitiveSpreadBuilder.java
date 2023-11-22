package kotlin.jvm.internal;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0004¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u0007*\u00028\u0000H$¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00078\u0005@\u0005X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011R\"\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00158\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u0018\u0010\u0019"}, d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "T", "spreadArgument", "", "addSpread", "(Ljava/lang/Object;)V", "", GriverMonitorConstants.KEY_SIZE, "()I", "values", "result", "toArray", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getSize", "(Ljava/lang/Object;)I", "position", "I", "getPosition", "setPosition", "(I)V", "", "spreads", "[Ljava/lang/Object;", "getSpreads$annotations", "()V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public abstract class PrimitiveSpreadBuilder<T> {
    private int position;
    private final int size;
    private final T[] spreads;

    private static /* synthetic */ void getSpreads$annotations() {
    }

    protected abstract int getSize(T t);

    public PrimitiveSpreadBuilder(int i) {
        this.size = i;
        this.spreads = (T[]) new Object[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getPosition")
    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "setPosition")
    public final void setPosition(int i) {
        this.position = i;
    }

    public final void addSpread(T spreadArgument) {
        Intrinsics.checkNotNullParameter(spreadArgument, "");
        T[] tArr = this.spreads;
        int i = this.position;
        this.position = i + 1;
        tArr[i] = spreadArgument;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int size() {
        int i = this.size - 1;
        int i2 = 0;
        if (i < 0) {
            return 0;
        }
        int i3 = 0;
        while (true) {
            T t = this.spreads[i2];
            i3 += t != null ? getSize(t) : 1;
            if (i2 == i) {
                return i3;
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T toArray(T values, T result) {
        int i;
        Intrinsics.checkNotNullParameter(values, "");
        Intrinsics.checkNotNullParameter(result, "");
        int i2 = this.size - 1;
        int i3 = 0;
        if (i2 >= 0) {
            int i4 = 0;
            int i5 = 0;
            i = 0;
            while (true) {
                T t = this.spreads[i4];
                if (t != null) {
                    if (i5 < i4) {
                        int i6 = i4 - i5;
                        System.arraycopy(values, i5, result, i, i6);
                        i += i6;
                    }
                    int size = getSize(t);
                    System.arraycopy(t, 0, result, i, size);
                    i += size;
                    i5 = i4 + 1;
                }
                if (i4 == i2) {
                    break;
                }
                i4++;
            }
            i3 = i5;
        } else {
            i = 0;
        }
        int i7 = this.size;
        if (i3 < i7) {
            System.arraycopy(values, i3, result, i, i7 - i3);
        }
        return result;
    }
}
