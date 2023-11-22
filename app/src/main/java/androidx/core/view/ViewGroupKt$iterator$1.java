package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Landroidx/core/view/ViewGroupKt$iterator$1;", "", "Landroid/view/View;", "", "hasNext", "()Z", "", "remove", "()V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewGroupKt$iterator$1 implements Iterator<View>, KMutableIterator, j$.util.Iterator {
    final /* synthetic */ ViewGroup BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    @Override // j$.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.getAuthRequestContext(this, consumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super View> consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroupKt$iterator$1(ViewGroup viewGroup) {
        this.BuiltInFictitiousFunctionClassFactory = viewGroup;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.MyBillsEntityDataFactory < this.BuiltInFictitiousFunctionClassFactory.getChildCount();
    }

    @Override // java.util.Iterator
    public final void remove() {
        ViewGroup viewGroup = this.BuiltInFictitiousFunctionClassFactory;
        int i = this.MyBillsEntityDataFactory - 1;
        this.MyBillsEntityDataFactory = i;
        viewGroup.removeViewAt(i);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ View next() {
        ViewGroup viewGroup = this.BuiltInFictitiousFunctionClassFactory;
        int i = this.MyBillsEntityDataFactory;
        this.MyBillsEntityDataFactory = i + 1;
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }
}
