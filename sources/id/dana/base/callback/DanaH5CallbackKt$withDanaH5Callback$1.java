package id.dana.base.callback;

import android.os.Bundle;
import id.dana.utils.danah5.DanaH5Listener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006"}, d2 = {"Lid/dana/base/callback/DanaH5CallbackKt$withDanaH5Callback$1;", "Lid/dana/utils/danah5/DanaH5Listener;", "Landroid/os/Bundle;", "p0", "", "onContainerCreated", "(Landroid/os/Bundle;)V", "onContainerDestroyed"}, k = 1, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes4.dex */
public final class DanaH5CallbackKt$withDanaH5Callback$1 implements DanaH5Listener {
    final /* synthetic */ Function1<Bundle, Unit> MyBillsEntityDataFactory;
    final /* synthetic */ Function1<Bundle, Unit> PlaceComponentResult;

    @Override // id.dana.utils.danah5.DanaH5Listener
    public final void onContainerCreated(Bundle p0) {
        this.PlaceComponentResult.invoke(p0);
    }

    @Override // id.dana.utils.danah5.DanaH5Listener
    public final void onContainerDestroyed(Bundle p0) {
        this.MyBillsEntityDataFactory.invoke(p0);
    }
}
