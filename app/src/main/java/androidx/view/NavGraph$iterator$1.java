package androidx.view;

import androidx.collection.SparseArrayCompat;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Landroidx/navigation/NavGraph$iterator$1;", "", "Landroidx/navigation/NavDestination;", "", "hasNext", "()Z", "", "remove", "()V", "", "BuiltInFictitiousFunctionClassFactory", "I", "getAuthRequestContext", "MyBillsEntityDataFactory", "Z"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavGraph$iterator$1 implements Iterator<NavDestination>, KMutableIterator, j$.util.Iterator {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int getAuthRequestContext = -1;
    final /* synthetic */ NavGraph KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;

    @Override // j$.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.getAuthRequestContext(this, consumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super NavDestination> consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NavGraph$iterator$1(NavGraph navGraph) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = navGraph;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.getAuthRequestContext + 1 < this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.MyBillsEntityDataFactory) {
            throw new IllegalStateException("You must call next() before you can remove an element".toString());
        }
        SparseArrayCompat<NavDestination> sparseArrayCompat = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
        sparseArrayCompat.lookAheadTest(this.getAuthRequestContext).moveToNextValue = null;
        sparseArrayCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
        this.getAuthRequestContext--;
        this.MyBillsEntityDataFactory = false;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ NavDestination next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.MyBillsEntityDataFactory = true;
        SparseArrayCompat<NavDestination> sparseArrayCompat = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = this.getAuthRequestContext + 1;
        this.getAuthRequestContext = i;
        NavDestination lookAheadTest = sparseArrayCompat.lookAheadTest(i);
        Intrinsics.checkNotNullExpressionValue(lookAheadTest, "");
        return lookAheadTest;
    }
}
