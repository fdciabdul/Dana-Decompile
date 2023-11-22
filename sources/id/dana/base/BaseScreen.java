package id.dana.base;

import android.os.Bundle;
import android.os.Parcelable;
import com.zhuinden.simplestack.navigator.DefaultViewKey;
import com.zhuinden.simplestack.navigator.ViewChangeHandler;
import com.zhuinden.simplestack.navigator.changehandlers.SegueViewChangeHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0016¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/base/BaseScreen;", "Lcom/zhuinden/simplestack/navigator/DefaultViewKey;", "Landroid/os/Parcelable;", "Lcom/zhuinden/simplestack/navigator/ViewChangeHandler;", "viewChangeHandler", "()Lcom/zhuinden/simplestack/navigator/ViewChangeHandler;", "Landroid/os/Bundle;", "MyBillsEntityDataFactory", "Landroid/os/Bundle;", "p0", "<init>", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseScreen implements DefaultViewKey, Parcelable {
    public final Bundle MyBillsEntityDataFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Bundle, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BaseScreen() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.base.BaseScreen.<init>():void");
    }

    public BaseScreen(Bundle bundle) {
        this.MyBillsEntityDataFactory = bundle;
    }

    public /* synthetic */ BaseScreen(Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Bundle() : bundle);
    }

    @Override // com.zhuinden.simplestack.navigator.DefaultViewKey
    public ViewChangeHandler viewChangeHandler() {
        return new SegueViewChangeHandler();
    }
}
