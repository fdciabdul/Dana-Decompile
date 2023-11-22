package id.dana.animation;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.dana.R;
import id.dana.core.ui.glide.GlideApp;
import id.dana.model.Banner;
import id.dana.model.PromotionBanner;
import java.util.List;

/* loaded from: classes8.dex */
public class SlidingBannerAdapter extends PagerAdapter {
    private Context MyBillsEntityDataFactory;
    private List<Banner> PlaceComponentResult;
    @BindView(R.id.imagePromotion)
    ImageView ivPromotion;
    @BindView(R.id.layout_parent)
    RelativeLayout lParent;

    /* loaded from: classes8.dex */
    public interface ItemListener {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.PlaceComponentResult.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = View.inflate(this.MyBillsEntityDataFactory, R.layout.view_simple_promotion, viewGroup);
        ButterKnife.BuiltInFictitiousFunctionClassFactory(this, inflate);
        List<Banner> list = this.PlaceComponentResult;
        if (list != null && list.get(i) != null) {
            final PromotionBanner promotionBanner = (PromotionBanner) this.PlaceComponentResult.get(i);
            GlideApp.getAuthRequestContext(this.MyBillsEntityDataFactory).PlaceComponentResult(promotionBanner.MyBillsEntityDataFactory).MyBillsEntityDataFactory(this.ivPromotion);
            this.lParent.setOnClickListener(new View.OnClickListener() { // from class: id.dana.home.SlidingBannerAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
        }
        viewGroup.addView(inflate);
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }
}
