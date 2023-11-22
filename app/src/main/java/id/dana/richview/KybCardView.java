package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRichView;

/* loaded from: classes5.dex */
public class KybCardView extends BaseRichView {
    private ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    private ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    private TextView MyBillsEntityDataFactory;
    private TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    private ImageView PlaceComponentResult;
    private ImageView getAuthRequestContext;
    private SkeletonScreen getErrorConfigVersion;
    private SkeletonScreen scheduleImpl;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.cardview_kyb;
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
    }

    public KybCardView(Context context) {
        super(context);
    }

    public KybCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KybCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (TextView) findViewById(R.id.kyb_header_text);
        this.MyBillsEntityDataFactory = (TextView) findViewById(R.id.kyb_body_text);
        this.PlaceComponentResult = (ImageView) findViewById(R.id.kyb_cicle);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (ImageView) findViewById(R.id.ic_image);
        this.getAuthRequestContext = (ImageView) findViewById(R.id.kyb_image_arrow);
        this.BuiltInFictitiousFunctionClassFactory = (ConstraintLayout) findViewById(R.id.cl_main_parent);
        if (attributeSet != null) {
            int i = 0;
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.applyTrimPathIfNeeded, 0, 0);
            try {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(obtainStyledAttributes.getString(1));
                this.MyBillsEntityDataFactory.setText(obtainStyledAttributes.getString(0));
                InstrumentInjector.Resources_setImageResource(this.KClassImpl$Data$declaredNonStaticMembers$2, obtainStyledAttributes.getResourceId(4, R.drawable.ic_kyb));
                InstrumentInjector.Resources_setImageResource(this.getAuthRequestContext, obtainStyledAttributes.getResourceId(2, R.drawable.arrow));
                this.getAuthRequestContext.setRotation(obtainStyledAttributes.getFloat(3, 0.0f));
                ImageView imageView = this.PlaceComponentResult;
                if (!obtainStyledAttributes.getBoolean(5, false)) {
                    i = 8;
                }
                imageView.setVisibility(i);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public String getKybBodyText() {
        return this.MyBillsEntityDataFactory.getText().toString();
    }

    public void setKybBodyText(String str) {
        int dimensionPixelOffset;
        TextView textView = this.MyBillsEntityDataFactory;
        if (textView != null) {
            textView.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
            this.MyBillsEntityDataFactory.setText(str);
            if (TextUtils.isEmpty(str)) {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.f33522131165998);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.f33512131165997);
            }
            Integer valueOf = Integer.valueOf(dimensionPixelOffset);
            this.BuiltInFictitiousFunctionClassFactory.setPadding(0, valueOf.intValue(), 0, valueOf.intValue());
        }
    }

    public void setKybSubtitleColor(String str) {
        if (str == null || str.equals("")) {
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, (int) R.style.f49862132017440);
        } else {
            this.MyBillsEntityDataFactory.setTextColor(Color.parseColor(str));
        }
    }

    public String getKybHeaderText() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.getText().toString();
    }

    public void setKybHeaderText(String str) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null && !TextUtils.isEmpty(str)) {
            hideTextViewSkeleton();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(str);
            return;
        }
        showTextViewSkeleton();
    }

    public void setIcKyb(Drawable drawable) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setImageDrawable(drawable);
    }

    public void setArrowImage(Drawable drawable) {
        this.getAuthRequestContext.setImageDrawable(drawable);
    }

    public void setCircleMarkVisibility(boolean z) {
        ImageView imageView = this.PlaceComponentResult;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void setParentVisibility(int i) {
        this.BuiltInFictitiousFunctionClassFactory.setVisibility(i);
    }

    private static SkeletonScreen KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(view);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_icon_me_page_skeleton;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        return viewSkeletonScreen;
    }

    public void hideTextViewSkeleton() {
        SkeletonScreen skeletonScreen = this.getErrorConfigVersion;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
            this.getErrorConfigVersion = null;
        }
        SkeletonScreen skeletonScreen2 = this.scheduleImpl;
        if (skeletonScreen2 != null) {
            skeletonScreen2.PlaceComponentResult();
            this.scheduleImpl = null;
        }
    }

    public void showTextViewSkeleton() {
        this.getErrorConfigVersion = KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        this.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
    }
}
