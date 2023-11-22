package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005*\u00020\u00008G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005*\u00020\u00008G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007"}, d2 = {"Landroid/view/ViewGroup;", "", "Landroid/view/View;", "getAuthRequestContext", "(Landroid/view/ViewGroup;)Ljava/util/Iterator;", "Lkotlin/sequences/Sequence;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "MyBillsEntityDataFactory"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewGroupKt {
    public static final Iterator<View> getAuthRequestContext(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public static final Sequence<View> BuiltInFictitiousFunctionClassFactory(final ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new Sequence<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // kotlin.sequences.Sequence
            public final Iterator<View> iterator() {
                return ViewGroupKt.getAuthRequestContext(viewGroup);
            }
        };
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public static final Sequence<View> MyBillsEntityDataFactory(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return SequencesKt.sequence(new ViewGroupKt$descendants$1(viewGroup, null));
    }
}
