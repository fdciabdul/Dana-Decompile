package id.dana.sendmoney.ui.globalsend.form.view;

import android.view.KeyEvent;
import android.widget.TextView;
import id.dana.sendmoney.databinding.ViewEditTextFormBinding;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/view/EditTextFormView$setupImeActionListener$1;", "Landroid/widget/TextView$OnEditorActionListener;", "Landroid/widget/TextView;", "p0", "", "p1", "Landroid/view/KeyEvent;", "p2", "", "onEditorAction", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EditTextFormView$setupImeActionListener$1 implements TextView.OnEditorActionListener {
    final /* synthetic */ EditTextFormView KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EditTextFormView$setupImeActionListener$1(EditTextFormView editTextFormView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = editTextFormView;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView p0, int p1, KeyEvent p2) {
        ViewEditTextFormBinding binding;
        ViewEditTextFormBinding binding2;
        if (p1 == 5) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.getFormInputType() == 5) {
                binding = this.KClassImpl$Data$declaredNonStaticMembers$2.getBinding();
                binding.KClassImpl$Data$declaredNonStaticMembers$2.clearFocus();
                this.KClassImpl$Data$declaredNonStaticMembers$2.getOnImeButtonClickListener().invoke();
                return true;
            }
            return false;
        } else if (p1 == 6 && this.KClassImpl$Data$declaredNonStaticMembers$2.getFormInputType() == 4) {
            binding2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getBinding();
            binding2.KClassImpl$Data$declaredNonStaticMembers$2.clearFocus();
            return false;
        } else {
            return false;
        }
    }
}
