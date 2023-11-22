package id.dana.component.edittextcomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import id.dana.component.BaseRichView;
import id.dana.component.R;

/* loaded from: classes8.dex */
public class DanaCustomTextInputView extends BaseRichView {
    private int BuiltInFictitiousFunctionClassFactory;
    private EditText KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    private boolean getAuthRequestContext;
    private View lookAheadTest;
    private TextView scheduleImpl;

    public DanaCustomTextInputView(Context context) {
        super(context);
    }

    public DanaCustomTextInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DanaCustomTextInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // id.dana.component.BaseRichView
    public int getLayout() {
        return R.layout.res_0x7f0d04df_kclassimpl_data_declarednonstaticmembers_2;
    }

    @Override // id.dana.component.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.i, 0, 0);
            try {
                this.getAuthRequestContext = obtainStyledAttributes.getBoolean(R.styleable.m, true);
                this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInt(R.styleable.l, 2);
                this.MyBillsEntityDataFactory = obtainStyledAttributes.getString(R.styleable.FlowViewUtil$textChanges$1);
                this.PlaceComponentResult = obtainStyledAttributes.getInt(R.styleable.k, 0);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getString(R.styleable.j);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.PlaceComponentResult > 0) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.PlaceComponentResult)});
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getValue() {
        Editable editable;
        if (this.getAuthRequestContext) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.scheduleImpl.getText().toString());
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2.getText().toString());
            editable = sb;
        } else {
            editable = this.KClassImpl$Data$declaredNonStaticMembers$2.getText();
        }
        return editable.toString();
    }

    public void setPrefixEnable(boolean z) {
        this.getAuthRequestContext = z;
        this.scheduleImpl.setVisibility(z ? 0 : 8);
    }

    public void setPrefixValue(String str) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        this.scheduleImpl.setText(TextUtils.isEmpty(str) ? "+62" : this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    public void setInputType(int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setInputType(i);
    }

    public void setHint(String str) {
        this.MyBillsEntityDataFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setHint(str);
    }

    public void setMaxLength(int i) {
        this.PlaceComponentResult = i;
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.component.BaseRichView
    public void setup() {
        this.lookAheadTest = findViewById(R.id.v_input_line);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (EditText) findViewById(R.id.newProxyInstance_res_0x7f0a06a3);
        TextView textView = (TextView) findViewById(R.id.tv_prefix);
        this.scheduleImpl = textView;
        textView.setVisibility(this.getAuthRequestContext ? 0 : 8);
        this.KClassImpl$Data$declaredNonStaticMembers$2.addTextChangedListener(new TextWatcher() { // from class: id.dana.component.edittextcomponent.DanaCustomTextInputView.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.length() != 0) {
                    DanaCustomTextInputView.this.lookAheadTest.setBackgroundColor(ResourcesCompat.PlaceComponentResult(DanaCustomTextInputView.this.getResources(), R.color.scheduleImpl, null));
                } else {
                    DanaCustomTextInputView.this.lookAheadTest.setBackgroundColor(ResourcesCompat.PlaceComponentResult(DanaCustomTextInputView.this.getResources(), R.color.res_0x7f060353_networkuserentitydata_externalsyntheticlambda0, null));
                }
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2.setInputType(this.BuiltInFictitiousFunctionClassFactory);
        this.KClassImpl$Data$declaredNonStaticMembers$2.setHint(this.MyBillsEntityDataFactory);
        KClassImpl$Data$declaredNonStaticMembers$2();
        this.scheduleImpl.setText(TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda0) ? "+62" : this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }
}
