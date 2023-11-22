package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.utils.CurrencyTextWatcher;
import id.dana.utils.OSUtil;

/* loaded from: classes9.dex */
public class CommonInputFieldView extends BaseRichView {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    @BindView(R.id.clearable_button_clear)
    Button btnClear;
    CommonInputAction commonInputAction;
    @BindView(R.id.et_group)
    TextInputLayout etGroup;
    @BindView(R.id.et_input2)
    EditText etInputCommon;
    @BindView(R.id.et_input1)
    EditText etInputMaterial;
    private String getAuthRequestContext;
    private int getErrorConfigVersion;
    @BindView(R.id.input_layout)
    TextInputLayout inputLayout;
    @BindView(R.id.lbl_title)
    TextView lblTitle;
    private String lookAheadTest;
    private int moveToNextValue;
    private int scheduleImpl;
    EditText selectedEt;
    @BindView(R.id.side_icon)
    ImageView sideIcon;

    /* loaded from: classes9.dex */
    public interface CommonInputAction {
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_common_input_field;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setup$0$id-dana-richview-CommonInputFieldView  reason: not valid java name */
    public /* synthetic */ void m2803lambda$setup$0$iddanarichviewCommonInputFieldView(View view) {
    }

    public CommonInputFieldView(Context context) {
        super(context);
    }

    public CommonInputFieldView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CommonInputFieldView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CommonInputFieldView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.isAuth);
            try {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.btnClear.getLayoutParams();
                String string = obtainStyledAttributes.getString(8);
                this.lookAheadTest = string;
                this.selectedEt = string == null ? this.etInputMaterial : this.etInputCommon;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getDimensionPixelSize(10, (int) this.lblTitle.getTextSize());
                this.scheduleImpl = obtainStyledAttributes.getColor(9, this.lblTitle.getCurrentTextColor());
                this.getAuthRequestContext = obtainStyledAttributes.getString(3);
                this.moveToNextValue = obtainStyledAttributes.getInt(7, 1);
                this.getErrorConfigVersion = obtainStyledAttributes.getDimensionPixelSize(6, (int) this.selectedEt.getTextSize());
                this.PlaceComponentResult = obtainStyledAttributes.getColor(5, this.selectedEt.getCurrentTextColor());
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getInt(4, 1);
                this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getBoolean(2, true);
                this.MyBillsEntityDataFactory = obtainStyledAttributes.getDimensionPixelSize(0, layoutParams.topMargin);
                this.selectedEt.setOnKeyListener(new View.OnKeyListener() { // from class: id.dana.richview.CommonInputFieldView$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnKeyListener
                    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                        return CommonInputFieldView.this.m2802x19a02493(view, i, keyEvent);
                    }
                });
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$clearText$1$id-dana-richview-CommonInputFieldView  reason: not valid java name */
    public /* synthetic */ void m2801lambda$clearText$1$iddanarichviewCommonInputFieldView(View view) {
        this.selectedEt.setText("");
    }

    public EditText getEditText() {
        return this.selectedEt;
    }

    public String getInputValue() {
        return this.selectedEt.getText().toString();
    }

    public void setInputValue(String str) {
        this.selectedEt.setText(str);
    }

    public void toggleClearButton(boolean z) {
        this.btnClear.setVisibility((!z || this.selectedEt.getText().length() <= 0) ? 4 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$dismissKeyboardListener$2$id-dana-richview-CommonInputFieldView  reason: not valid java name */
    public /* synthetic */ boolean m2802x19a02493(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.selectedEt.getWindowToken(), 0);
            return true;
        }
        return false;
    }

    public void setSideIcon(int i) {
        InstrumentInjector.Resources_setImageResource(this.sideIcon, i);
        this.sideIcon.setVisibility(0);
    }

    public void setErrorMsg(String str) {
        TextInputLayout textInputLayout = this.inputLayout;
        if (textInputLayout != null) {
            textInputLayout.setError(str);
            this.inputLayout.setErrorEnabled(!TextUtils.isEmpty(str));
        }
    }

    public void setColoredErrorMsg(String str, int i) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(i));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, 0, str.length(), 0);
        this.inputLayout.setError(spannableStringBuilder);
    }

    public void setLabelTextColor(int i) {
        this.lblTitle.setTextColor(i);
    }

    public void setBackgroundInputColor(int i) {
        this.selectedEt.getBackground().setColorFilter(getResources().getColor(i), PorterDuff.Mode.SRC_ATOP);
    }

    public void setInputHint(String str) {
        if (this.lookAheadTest == null) {
            this.etGroup.setHint(str);
        } else {
            this.etInputCommon.setHint(str);
        }
    }

    public void isInputEnabled(boolean z) {
        this.selectedEt.setEnabled(true);
        this.selectedEt.setFocusable(z);
        this.selectedEt.setClickable(!z);
        this.selectedEt.setFocusableInTouchMode(z);
    }

    public void setCommonInputAction(CommonInputAction commonInputAction) {
        this.commonInputAction = commonInputAction;
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.btnClear.setVisibility(4);
        this.btnClear.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.CommonInputFieldView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonInputFieldView.this.m2801lambda$clearText$1$iddanarichviewCommonInputFieldView(view);
            }
        });
        this.selectedEt.addTextChangedListener(new TextWatcher() { // from class: id.dana.richview.CommonInputFieldView.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                CommonInputFieldView.this.toggleClearButton(charSequence.length() > 0);
            }
        });
        this.etInputMaterial.setVisibility(this.lookAheadTest == null ? 0 : 8);
        this.etInputCommon.setVisibility(this.lookAheadTest == null ? 8 : 0);
        String str = this.lookAheadTest;
        this.lblTitle.setVisibility(str != null ? 0 : 8);
        this.lblTitle.setText(str);
        this.lblTitle.setTextSize(0, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        setLabelTextColor(this.scheduleImpl);
        if (OSUtil.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            this.selectedEt.setPaddingRelative(0, 0, 40, 0);
        }
        setInputHint(this.getAuthRequestContext);
        int i = this.moveToNextValue;
        if (i == 99) {
            i = 2;
        }
        this.selectedEt.setInputType(i);
        this.selectedEt.setTextSize(0, this.getErrorConfigVersion);
        this.selectedEt.setTextColor(this.PlaceComponentResult);
        this.selectedEt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.KClassImpl$Data$declaredNonStaticMembers$2)});
        ((RelativeLayout.LayoutParams) this.btnClear.getLayoutParams()).setMargins(0, this.MyBillsEntityDataFactory, 0, 0);
        isInputEnabled(this.BuiltInFictitiousFunctionClassFactory);
        if (this.moveToNextValue == 99) {
            EditText editText = this.selectedEt;
            editText.addTextChangedListener(new CurrencyTextWatcher(editText));
        }
        this.selectedEt.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.CommonInputFieldView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonInputFieldView.this.m2803lambda$setup$0$iddanarichviewCommonInputFieldView(view);
            }
        });
    }
}
