package androidx.core.graphics;

import android.graphics.Rect;
import android.graphics.RegionIterator;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/core/graphics/RegionKt$iterator$1;", "", "Landroid/graphics/Rect;", "", "hasNext", "()Z", "PlaceComponentResult", "Z", "Landroid/graphics/RegionIterator;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/graphics/RegionIterator;", "getAuthRequestContext", "Landroid/graphics/Rect;", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class RegionKt$iterator$1 implements Iterator<Rect>, KMappedMarker, j$.util.Iterator {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final RegionIterator getAuthRequestContext;
    private boolean PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Rect BuiltInFictitiousFunctionClassFactory;

    @Override // j$.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.getAuthRequestContext(this, consumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super Rect> consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.PlaceComponentResult;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Rect next() {
        if (this.PlaceComponentResult) {
            Rect rect = new Rect(this.BuiltInFictitiousFunctionClassFactory);
            this.PlaceComponentResult = this.getAuthRequestContext.next(this.BuiltInFictitiousFunctionClassFactory);
            return rect;
        }
        throw new IndexOutOfBoundsException();
    }
}
