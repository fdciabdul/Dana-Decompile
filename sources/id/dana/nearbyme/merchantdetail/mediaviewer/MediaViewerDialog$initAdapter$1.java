package id.dana.nearbyme.merchantdetail.mediaviewer;

import android.os.Parcelable;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class MediaViewerDialog$initAdapter$1<T> extends FunctionReferenceImpl implements Function2<T, View, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaViewerDialog$initAdapter$1(Object obj) {
        super(2, obj, MediaViewerDialog.class, "getAuthRequestContext", "getAuthRequestContext(Landroid/os/Parcelable;Landroid/view/View;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Unit invoke(Object obj, View view) {
        invoke((Parcelable) obj, view);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;Landroid/view/View;)V */
    public final void invoke(Parcelable parcelable, View view) {
        Intrinsics.checkNotNullParameter(parcelable, "");
        Intrinsics.checkNotNullParameter(view, "");
        ((MediaViewerDialog) this.receiver).getAuthRequestContext(parcelable, view);
    }
}
