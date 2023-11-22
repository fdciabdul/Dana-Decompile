package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0007\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ1\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\r¸\u0006\u000f"}, d2 = {"Landroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1;", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "p0", "", "afterTextChanged", "(Landroid/text/Editable;)V", "", "", "p1", "p2", "p3", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "onTextChanged", "androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1"}, k = 1, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes3.dex */
public final class TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ Function4 MyBillsEntityDataFactory;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable p0) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
        this.MyBillsEntityDataFactory.invoke(p0, Integer.valueOf(p1), Integer.valueOf(p2), Integer.valueOf(p3));
    }
}
