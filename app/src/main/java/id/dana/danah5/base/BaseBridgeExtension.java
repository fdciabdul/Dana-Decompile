package id.dana.danah5.base;

import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import id.dana.base.DisposableHandler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/danah5/base/BaseBridgeExtension;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Lid/dana/base/DisposableHandler;", "Lio/reactivex/disposables/Disposable;", "disposable", "", "addDisposable", "(Lio/reactivex/disposables/Disposable;)V", "dispose", "()V", "onFinalized", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class BaseBridgeExtension extends SimpleBridgeExtension implements DisposableHandler {
    private CompositeDisposable disposables;

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        dispose();
        super.onFinalized();
    }

    public void addDisposable(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "");
        if (this.disposables == null) {
            this.disposables = new CompositeDisposable();
        }
        CompositeDisposable compositeDisposable = this.disposables;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            compositeDisposable = null;
        }
        compositeDisposable.getAuthRequestContext(disposable);
    }

    public void dispose() {
        CompositeDisposable compositeDisposable = this.disposables;
        if (compositeDisposable != null) {
            CompositeDisposable compositeDisposable2 = null;
            if (compositeDisposable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                compositeDisposable = null;
            }
            if (compositeDisposable.isDisposed()) {
                return;
            }
            CompositeDisposable compositeDisposable3 = this.disposables;
            if (compositeDisposable3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                compositeDisposable2 = compositeDisposable3;
            }
            compositeDisposable2.dispose();
        }
    }
}
