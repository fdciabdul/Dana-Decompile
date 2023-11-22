package id.dana.richview;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.utils.KeyboardHelper;

/* loaded from: classes5.dex */
public class CustomEditText extends BaseRichView {
    private EditText BuiltInFictitiousFunctionClassFactory;
    private ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_custom_edittext;
    }

    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CustomEditText(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void init(Context context, AttributeSet attributeSet, boolean z) {
        super.init(context, attributeSet, z);
        this.BuiltInFictitiousFunctionClassFactory.addTextChangedListener(new TextWatcher() { // from class: id.dana.richview.CustomEditText.1
            int getAuthRequestContext;

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.getAuthRequestContext = charSequence.length();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                CustomEditText.access$000(CustomEditText.this, editable, this.getAuthRequestContext);
            }
        });
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        TextView textView = (TextView) findViewById(R.id.tv_edit_text_title);
        this.BuiltInFictitiousFunctionClassFactory = (EditText) findViewById(R.id.et_custom_edit_text);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (ImageView) findViewById(R.id.res_0x7f0a0ad5_networkuserentitydata_externalsyntheticlambda4);
        if (attributeSet != null) {
            setStyledAttributes(context, attributeSet, R.styleable.c);
            try {
                int i = getStyledAttributes().getInt(4, 0);
                int i2 = getStyledAttributes().getInt(1, 0);
                this.BuiltInFictitiousFunctionClassFactory.setHint(getStyledAtrributesString(2));
                this.BuiltInFictitiousFunctionClassFactory.setFocusable(getStyledAttributes().getBoolean(0, true));
                if (i2 != 0) {
                    this.BuiltInFictitiousFunctionClassFactory.setInputType(i2);
                }
                if (i > 0) {
                    this.BuiltInFictitiousFunctionClassFactory.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
                }
                int resourceId = getStyledAttributes().getResourceId(3, 0);
                if (resourceId > 0) {
                    InstrumentInjector.Resources_setImageResource(this.KClassImpl$Data$declaredNonStaticMembers$2, resourceId);
                }
                textView.setText(getStyledAtrributesString(5));
            } finally {
                getStyledAttributes().recycle();
            }
        }
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        getRootView().setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.CustomEditText$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KeyboardHelper.BuiltInFictitiousFunctionClassFactory(view);
            }
        });
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        return getText().equalsIgnoreCase(TextUtils.isEmpty(this.MyBillsEntityDataFactory) ? "" : this.MyBillsEntityDataFactory);
    }

    public boolean isManualInput() {
        return this.PlaceComponentResult;
    }

    public EditText getEtCustomEditText() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public String getText() {
        return this.BuiltInFictitiousFunctionClassFactory.getText().toString();
    }

    public void clearText() {
        EditText editText = this.BuiltInFictitiousFunctionClassFactory;
        if (editText != null) {
            editText.getText().clear();
        }
    }

    public void setOnEtCustomEditTextClicked(View.OnClickListener onClickListener) {
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(onClickListener);
    }

    public void setOnIconClickListener(View.OnClickListener onClickListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(onClickListener);
    }

    public void setContentDescriptionOnEditText(String str) {
        this.BuiltInFictitiousFunctionClassFactory.setContentDescription(str);
    }

    public void setContentDescriptionOnImageView(String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(str);
    }

    static /* synthetic */ void access$000(CustomEditText customEditText, Editable editable, int i) {
        customEditText.PlaceComponentResult = editable.length() - i <= 1 && !customEditText.BuiltInFictitiousFunctionClassFactory();
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(getText()) && str.length() > 2) {
            this.MyBillsEntityDataFactory = str;
        }
        this.BuiltInFictitiousFunctionClassFactory.setText(str);
    }
}
