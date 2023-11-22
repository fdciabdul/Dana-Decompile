package id.dana.showcase.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.showcase.Content;

/* loaded from: classes5.dex */
public class SimpleContentView extends BaseRichView {
    private Content MyBillsEntityDataFactory;
    @BindView(R.id.getAuthRequestContext_res_0x7f0a025a)
    Button button;
    @BindView(R.id.description)
    TextView description;
    private OnSimpleContentActionListener getAuthRequestContext;
    @BindView(R.id.title)
    TextView title;

    /* loaded from: classes5.dex */
    public interface OnSimpleContentActionListener {
        void BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_tooltip_simple;
    }

    public SimpleContentView(Context context, Content content) {
        super(context);
        setContent(content);
    }

    public SimpleContentView(Context context) {
        super(context);
    }

    public SimpleContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SimpleContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SimpleContentView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setContent(Content content) {
        this.MyBillsEntityDataFactory = content;
        if (content != null) {
            this.title.setText(content.KClassImpl$Data$declaredNonStaticMembers$2);
            if (this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory != null) {
                this.description.setText(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory);
            } else {
                this.description.setText(this.MyBillsEntityDataFactory.getAuthRequestContext);
            }
        }
    }

    public void setOnSimpleContentActionListener(OnSimpleContentActionListener onSimpleContentActionListener) {
        this.getAuthRequestContext = onSimpleContentActionListener;
    }

    public void setButtonText(String str) {
        this.button.setText(str);
    }

    public void setButtonContentDescription(String str) {
        this.button.setContentDescription(str);
    }

    public void setTitleContentDesciption(String str) {
        this.title.setContentDescription(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.getAuthRequestContext_res_0x7f0a025a})
    public void onButtonClick() {
        OnSimpleContentActionListener onSimpleContentActionListener = this.getAuthRequestContext;
        if (onSimpleContentActionListener != null) {
            onSimpleContentActionListener.BuiltInFictitiousFunctionClassFactory();
        }
    }
}
