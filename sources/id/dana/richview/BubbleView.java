package id.dana.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseRichView;

/* loaded from: classes5.dex */
public class BubbleView extends BaseRichView {
    private TextView KClassImpl$Data$declaredNonStaticMembers$2;
    private ImageView MyBillsEntityDataFactory;
    private ImageView PlaceComponentResult;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_bubble_toast;
    }

    public BubbleView(Context context) {
        super(context);
    }

    public BubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public BubbleView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (TextView) findViewById(R.id.tv_toast_text);
        this.MyBillsEntityDataFactory = (ImageView) findViewById(R.id.iv_notes_placeholder);
        this.PlaceComponentResult = (ImageView) findViewById(R.id.iv_pointer);
    }

    public String getText() {
        TextView textView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return textView != null ? textView.getText().toString() : "";
    }

    public void setText(String str) {
        TextView textView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setVisibilityPointer(boolean z) {
        ImageView imageView = this.PlaceComponentResult;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void setVisibilityBubbleText(boolean z) {
        TextView textView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    public void setVisibilityBubbleImage(boolean z) {
        ImageView imageView = this.MyBillsEntityDataFactory;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }
}
