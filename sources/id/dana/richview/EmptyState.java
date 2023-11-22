package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRichView;

/* loaded from: classes5.dex */
public class EmptyState extends BaseRichView {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;
    private String PlaceComponentResult;
    @BindView(R.id.btn_action_emptystate)
    Button btnAction;
    private Drawable getAuthRequestContext;
    @BindView(R.id.iv_image_emptystate)
    ImageView ivEmptyState;
    @BindView(R.id.tv_message_emptystate)
    TextView tvMessage;
    @BindView(R.id.tv_title_emptystate)
    TextView tvTitle;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_empty_state;
    }

    public EmptyState(Context context) {
        super(context);
    }

    public EmptyState(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmptyState(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public EmptyState(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TypefaceCompatApi26Impl);
            try {
                this.getAuthRequestContext = ContextCompat.PlaceComponentResult(getContext(), obtainStyledAttributes.getResourceId(1, -1));
                this.MyBillsEntityDataFactory = obtainStyledAttributes.getString(3);
                this.PlaceComponentResult = obtainStyledAttributes.getString(2);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getString(0);
                this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getBoolean(4, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        setIcon(this.getAuthRequestContext);
        setTitle(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
        setMessage(this.PlaceComponentResult);
        if (PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
            setAction(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    public void setIcon(Drawable drawable) {
        this.ivEmptyState.setImageDrawable(drawable);
    }

    public void setTitle(String str, boolean z) {
        if (z) {
            this.tvTitle.setTypeface(Typeface.defaultFromStyle(1));
        }
        this.tvTitle.setText(str);
    }

    public void setMessage(String str) {
        this.tvMessage.setText(str);
    }

    private static boolean PlaceComponentResult(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setAction(String str) {
        this.btnAction.setText(str);
        this.btnAction.setVisibility(0);
    }

    public void setIcon(int i) {
        InstrumentInjector.Resources_setImageResource(this.ivEmptyState, i);
    }

    public void onActionClick(View.OnClickListener onClickListener) {
        Button button = this.btnAction;
        if (button != null) {
            button.setOnClickListener(onClickListener);
        }
    }
}
