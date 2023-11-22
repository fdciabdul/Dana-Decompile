package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Landroidx/core/view/MenuKt$iterator$1;", "", "Landroid/view/MenuItem;", "", "hasNext", "()Z", "", "remove", "()V", "", "MyBillsEntityDataFactory", "I", "PlaceComponentResult"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class MenuKt$iterator$1 implements Iterator<MenuItem>, KMutableIterator, j$.util.Iterator {
    final /* synthetic */ Menu KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int PlaceComponentResult;

    @Override // j$.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.getAuthRequestContext(this, consumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super MenuItem> consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MenuKt$iterator$1(Menu menu) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = menu;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.PlaceComponentResult < this.KClassImpl$Data$declaredNonStaticMembers$2.size();
    }

    @Override // java.util.Iterator
    public final void remove() {
        Unit unit;
        Menu menu = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = this.PlaceComponentResult - 1;
        this.PlaceComponentResult = i;
        MenuItem item = menu.getItem(i);
        if (item != null) {
            Intrinsics.checkNotNullExpressionValue(item, "");
            menu.removeItem(item.getItemId());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.util.Iterator
    public final /* synthetic */ MenuItem next() {
        Menu menu = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = this.PlaceComponentResult;
        this.PlaceComponentResult = i + 1;
        MenuItem item = menu.getItem(i);
        if (item != null) {
            return item;
        }
        throw new IndexOutOfBoundsException();
    }
}
