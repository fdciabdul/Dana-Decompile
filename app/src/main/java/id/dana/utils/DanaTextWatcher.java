package id.dana.utils;

import android.text.TextWatcher;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\n"}, d2 = {"Lid/dana/utils/DanaTextWatcher;", "", "Landroid/widget/EditText;", "p0", "Landroid/text/TextWatcher;", "p1", "", "PlaceComponentResult", "(Landroid/widget/EditText;Landroid/text/TextWatcher;)V", "", "Z", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaTextWatcher {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    public final void PlaceComponentResult(EditText p0, TextWatcher p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        try {
            p0.addTextChangedListener(p1);
        } catch (IndexOutOfBoundsException unused) {
        }
        this.MyBillsEntityDataFactory = true;
    }
}
