package id.dana.richview;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;

/* loaded from: classes9.dex */
public class CommonInputFieldView_ViewBinding implements Unbinder {
    private CommonInputFieldView MyBillsEntityDataFactory;

    public CommonInputFieldView_ViewBinding(CommonInputFieldView commonInputFieldView, View view) {
        this.MyBillsEntityDataFactory = commonInputFieldView;
        commonInputFieldView.sideIcon = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.side_icon, "field 'sideIcon'", ImageView.class);
        commonInputFieldView.inputLayout = (TextInputLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.input_layout, "field 'inputLayout'", TextInputLayout.class);
        commonInputFieldView.etGroup = (TextInputLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.et_group, "field 'etGroup'", TextInputLayout.class);
        commonInputFieldView.lblTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.lbl_title, "field 'lblTitle'", TextView.class);
        commonInputFieldView.etInputMaterial = (EditText) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.et_input1, "field 'etInputMaterial'", EditText.class);
        commonInputFieldView.etInputCommon = (EditText) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.et_input2, "field 'etInputCommon'", EditText.class);
        commonInputFieldView.btnClear = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.clearable_button_clear, "field 'btnClear'", Button.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        CommonInputFieldView commonInputFieldView = this.MyBillsEntityDataFactory;
        if (commonInputFieldView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        commonInputFieldView.sideIcon = null;
        commonInputFieldView.inputLayout = null;
        commonInputFieldView.etGroup = null;
        commonInputFieldView.lblTitle = null;
        commonInputFieldView.etInputMaterial = null;
        commonInputFieldView.etInputCommon = null;
        commonInputFieldView.btnClear = null;
    }
}
