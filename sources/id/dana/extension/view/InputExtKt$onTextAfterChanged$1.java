package id.dana.extension.view;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0006\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ1\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\r"}, d2 = {"Lid/dana/extension/view/InputExtKt$onTextAfterChanged$1;", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "p0", "", "afterTextChanged", "(Landroid/text/Editable;)V", "", "", "p1", "p2", "p3", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "onTextChanged"}, k = 1, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes5.dex */
public final class InputExtKt$onTextAfterChanged$1 implements TextWatcher {
    final /* synthetic */ Function1<String, Unit> MyBillsEntityDataFactory;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable p0) {
        Function1<String, Unit> function1 = this.MyBillsEntityDataFactory;
        String obj = p0 != null ? p0.toString() : null;
        if (obj == null) {
            obj = "";
        }
        function1.invoke(obj);
    }
}
