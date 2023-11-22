package androidx.core.os;

import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class ExecutorCompat {
    public static Executor PlaceComponentResult(Handler handler) {
        return new HandlerExecutor(handler);
    }

    private ExecutorCompat() {
    }

    /* loaded from: classes6.dex */
    static class HandlerExecutor implements Executor {
        private final Handler PlaceComponentResult;

        HandlerExecutor(Handler handler) {
            this.PlaceComponentResult = (Handler) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.PlaceComponentResult.post((Runnable) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(runnable))) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.PlaceComponentResult);
            sb.append(" is shutting down");
            throw new RejectedExecutionException(sb.toString());
        }
    }
}
