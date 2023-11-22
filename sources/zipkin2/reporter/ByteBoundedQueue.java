package zipkin2.reporter;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes9.dex */
final class ByteBoundedQueue<S> implements SpanWithSizeConsumer<S> {
    final int BuiltInFictitiousFunctionClassFactory;
    final Condition KClassImpl$Data$declaredNonStaticMembers$2;
    final ReentrantLock MyBillsEntityDataFactory;
    int NetworkUserEntityData$$ExternalSyntheticLambda0;
    int PlaceComponentResult;
    final S[] getAuthRequestContext;
    int getErrorConfigVersion;
    final int[] lookAheadTest;
    int moveToNextValue;
    final int scheduleImpl;

    @Override // zipkin2.reporter.SpanWithSizeConsumer
    public final boolean PlaceComponentResult(S s, int i) {
        int i2;
        this.MyBillsEntityDataFactory.lock();
        try {
            int i3 = this.PlaceComponentResult;
            int i4 = this.scheduleImpl;
            if (i3 != i4 && (i2 = this.getErrorConfigVersion + i) <= this.BuiltInFictitiousFunctionClassFactory) {
                S[] sArr = this.getAuthRequestContext;
                int i5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                sArr[i5] = s;
                int[] iArr = this.lookAheadTest;
                int i6 = i5 + 1;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i6;
                iArr[i5] = i;
                if (i6 == i4) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
                }
                this.PlaceComponentResult = i3 + 1;
                this.getErrorConfigVersion = i2;
                this.KClassImpl$Data$declaredNonStaticMembers$2.signal();
                return true;
            }
            return false;
        } finally {
            this.MyBillsEntityDataFactory.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int PlaceComponentResult(SpanWithSizeConsumer<S> spanWithSizeConsumer, long j) {
        try {
            this.MyBillsEntityDataFactory.lockInterruptibly();
            while (this.PlaceComponentResult == 0) {
                try {
                    if (j <= 0) {
                        return 0;
                    }
                    j = this.KClassImpl$Data$declaredNonStaticMembers$2.awaitNanos(j);
                } finally {
                    this.MyBillsEntityDataFactory.unlock();
                }
            }
            int i = 0;
            int i2 = 0;
            while (i < this.PlaceComponentResult) {
                S[] sArr = this.getAuthRequestContext;
                int i3 = this.moveToNextValue;
                S s = sArr[i3];
                int i4 = this.lookAheadTest[i3];
                if (s == null || !spanWithSizeConsumer.PlaceComponentResult(s, i4)) {
                    break;
                }
                i++;
                i2 += i4;
                S[] sArr2 = this.getAuthRequestContext;
                int i5 = this.moveToNextValue;
                sArr2[i5] = null;
                int i6 = i5 + 1;
                this.moveToNextValue = i6;
                if (i6 == sArr2.length) {
                    this.moveToNextValue = 0;
                }
            }
            this.PlaceComponentResult -= i;
            this.getErrorConfigVersion -= i2;
            return i;
        } catch (InterruptedException unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getAuthRequestContext() {
        this.MyBillsEntityDataFactory.lock();
        try {
            int i = this.PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
            this.moveToNextValue = 0;
            this.getErrorConfigVersion = 0;
            this.PlaceComponentResult = 0;
            Arrays.fill(this.getAuthRequestContext, (Object) null);
            return i;
        } finally {
            this.MyBillsEntityDataFactory.unlock();
        }
    }
}
