package zipkin2.reporter;

import java.util.concurrent.CountDownLatch;
import zipkin2.Callback;

/* loaded from: classes9.dex */
public final class AwaitableCallback implements Callback<Void> {
    Throwable KClassImpl$Data$declaredNonStaticMembers$2;
    final CountDownLatch MyBillsEntityDataFactory = new CountDownLatch(1);

    @Override // zipkin2.Callback
    public final /* synthetic */ void onSuccess(Void r1) {
        this.MyBillsEntityDataFactory.countDown();
    }

    @Override // zipkin2.Callback
    public final void onError(Throwable th) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = th;
        this.MyBillsEntityDataFactory.countDown();
    }
}
