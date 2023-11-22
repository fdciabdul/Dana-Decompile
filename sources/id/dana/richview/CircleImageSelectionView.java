package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.extension.view.ViewExtKt;
import id.dana.utils.ImageResize;

/* loaded from: classes5.dex */
public class CircleImageSelectionView extends BaseRichView {
    private ImageView BuiltInFictitiousFunctionClassFactory;
    private int GetContactSyncConfig;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private ImageView MyBillsEntityDataFactory;
    private ImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    private FrameLayout PlaceComponentResult;
    private int getAuthRequestContext;
    private int getErrorConfigVersion;
    private ImageView lookAheadTest;
    private ImageView moveToNextValue;
    private Listener scheduleImpl;

    /* loaded from: classes5.dex */
    public interface Listener {
        void MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_circle_image_selection;
    }

    public CircleImageSelectionView(Context context) {
        super(context);
        this.GetContactSyncConfig = 0;
    }

    public CircleImageSelectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GetContactSyncConfig = 0;
    }

    public CircleImageSelectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.GetContactSyncConfig = 0;
    }

    public CircleImageSelectionView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.GetContactSyncConfig = 0;
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.PlaceComponentResult = (FrameLayout) findViewById(R.id.fl_container);
        this.lookAheadTest = (ImageView) findViewById(R.id.iv_photo);
        this.moveToNextValue = (ImageView) findViewById(R.id.iv_photo_circle);
        this.MyBillsEntityDataFactory = (ImageView) findViewById(R.id.iv_checklist);
        this.BuiltInFictitiousFunctionClassFactory = (ImageView) findViewById(R.id.iv_checklist_top);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (ImageView) findViewById(R.id.BannerEntityDataFactory_Factory_res_0x7f0a0c11);
        ViewGroup.LayoutParams layoutParams = this.lookAheadTest.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.moveToNextValue.getLayoutParams();
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i != 0 && this.getAuthRequestContext != 0) {
            layoutParams2.width = i;
            layoutParams2.height = this.getAuthRequestContext;
            layoutParams.width = this.KClassImpl$Data$declaredNonStaticMembers$2 - ViewExtKt.PlaceComponentResult(this.GetContactSyncConfig);
            layoutParams.height = this.getAuthRequestContext - ViewExtKt.PlaceComponentResult(this.GetContactSyncConfig);
        }
        ImageView imageView = this.MyBillsEntityDataFactory;
        int i2 = this.getErrorConfigVersion;
        ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = i2;
            layoutParams3.height = i2;
        }
        ImageView imageView2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i3 = this.getErrorConfigVersion;
        ViewGroup.LayoutParams layoutParams4 = imageView2.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = i3;
            layoutParams4.height = i3;
        }
        ImageView imageView3 = this.BuiltInFictitiousFunctionClassFactory;
        int i4 = this.getErrorConfigVersion;
        ViewGroup.LayoutParams layoutParams5 = imageView3.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.width = i4;
            layoutParams5.height = i4;
        }
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842996, 16842997});
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getDimensionPixelSize(0, -2);
                this.getAuthRequestContext = obtainStyledAttributes.getDimensionPixelSize(1, -2);
                obtainStyledAttributes.recycle();
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.K);
                try {
                    float dimension = obtainStyledAttributes.getDimension(0, 9.0f);
                    float dimension2 = obtainStyledAttributes.getDimension(1, 0.0f);
                    this.getErrorConfigVersion = Math.round(dimension);
                    this.GetContactSyncConfig = Math.round(dimension2);
                } finally {
                }
            } finally {
            }
        }
    }

    public void loadImage(String str) {
        loadImage(str, R.drawable.ic_avatar_grey_default);
    }

    public void loadImage(String str, int i) {
        GlideApp.getAuthRequestContext(getContext()).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(str).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion(i).PlaceComponentResult(i).MyBillsEntityDataFactory(this.lookAheadTest);
    }

    public void useRemoveIcon(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(z ? 0 : 8);
        if (z) {
            this.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.CircleImageSelectionView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleImageSelectionView.this.m2799lambda$useRemoveIcon$0$iddanarichviewCircleImageSelectionView(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$useRemoveIcon$0$id-dana-richview-CircleImageSelectionView  reason: not valid java name */
    public /* synthetic */ void m2799lambda$useRemoveIcon$0$iddanarichviewCircleImageSelectionView(View view) {
        Listener listener = this.scheduleImpl;
        if (listener != null) {
            listener.MyBillsEntityDataFactory();
        }
    }

    public void setActionIcon(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), i));
    }

    public void setSelectedState() {
        this.MyBillsEntityDataFactory.setVisibility(0);
        this.PlaceComponentResult.setAlpha(0.7f);
    }

    public void setUnselectedState() {
        this.MyBillsEntityDataFactory.setVisibility(8);
        this.PlaceComponentResult.setAlpha(1.0f);
    }

    public void setCheckTopVisibleState() {
        this.BuiltInFictitiousFunctionClassFactory.setVisibility(0);
        this.moveToNextValue.setVisibility(0);
        this.moveToNextValue.setBackground(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.bg_gradient_blue_circle));
    }

    public void setCheckTopInvisibleState() {
        this.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
        this.moveToNextValue.setVisibility(4);
    }

    public void setPaddingPhoto(int i) {
        this.lookAheadTest.setPadding(i, i, i, i);
    }

    public void setPhotoCircleDisplay(boolean z) {
        this.moveToNextValue.setVisibility(z ? 0 : 8);
    }

    public void setYellowBorderWithStar() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.ic_star_favorite_quicksend));
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(0);
        this.moveToNextValue.setVisibility(0);
        this.moveToNextValue.setBackground(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.bg_circle_yellow_50));
    }

    public void removeYellowBorderWithStar() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(8);
        this.moveToNextValue.setVisibility(8);
    }

    public void setBorderColor(int i) {
        this.moveToNextValue.setVisibility(0);
        this.moveToNextValue.setBackground(ContextCompat.PlaceComponentResult(getContext(), i));
    }

    public void setListener(Listener listener) {
        this.scheduleImpl = listener;
    }
}
