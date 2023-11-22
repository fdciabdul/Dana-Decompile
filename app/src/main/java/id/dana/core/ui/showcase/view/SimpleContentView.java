package id.dana.core.ui.showcase.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.databinding.ViewShowcaseSimpleBinding;
import id.dana.core.ui.showcase.Content;

/* loaded from: classes4.dex */
public class SimpleContentView extends BaseViewBindingRichView<ViewShowcaseSimpleBinding> {
    private OnSimpleContentActionListener MyBillsEntityDataFactory;
    private Content PlaceComponentResult;

    /* loaded from: classes4.dex */
    public interface OnSimpleContentActionListener {
        void getAuthRequestContext();
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
        this.PlaceComponentResult = content;
        if (content != null) {
            getBinding().getAuthRequestContext.setText(this.PlaceComponentResult.PlaceComponentResult);
            if (this.PlaceComponentResult.getAuthRequestContext != null) {
                getBinding().PlaceComponentResult.setText(this.PlaceComponentResult.getAuthRequestContext);
            } else {
                getBinding().PlaceComponentResult.setText(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    public void setOnSimpleContentActionListener(OnSimpleContentActionListener onSimpleContentActionListener) {
        this.MyBillsEntityDataFactory = onSimpleContentActionListener;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public ViewShowcaseSimpleBinding inflateViewBinding() {
        return ViewShowcaseSimpleBinding.MyBillsEntityDataFactory(LayoutInflater.from(getContext()));
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public void setup() {
        super.setup();
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.showcase.view.SimpleContentView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleContentView.this.m623x3cdc05a7(view);
            }
        });
    }

    public void setButtonText(String str) {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText(str);
    }

    public void setButtonVisibility(boolean z) {
        if (z) {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
        } else {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
        }
    }

    public void setButtonContentDescription(String str) {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setButtonClick$0$id-dana-core-ui-showcase-view-SimpleContentView  reason: not valid java name */
    public /* synthetic */ void m623x3cdc05a7(View view) {
        onButtonClick();
    }

    void onButtonClick() {
        OnSimpleContentActionListener onSimpleContentActionListener = this.MyBillsEntityDataFactory;
        if (onSimpleContentActionListener != null) {
            onSimpleContentActionListener.getAuthRequestContext();
        }
    }
}
