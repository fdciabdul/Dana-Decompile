package id.dana.showcase.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.onboarding.view.BaseSimpleView;
import id.dana.onboarding.view.SimplePagerAdapter;
import id.dana.popup.LockableViewPager;
import java.util.List;

/* loaded from: classes5.dex */
public class PagerContentView extends BaseRichView {
    private SimplePagerAdapter MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    @BindView(R.id.btn_left)
    Button btnLeft;
    @BindView(R.id.btn_right)
    Button btnRight;
    private PagerContentActionListener getAuthRequestContext;
    @BindView(R.id.RecurringAnnouncementEntity)
    ImageView ivClose;
    @BindView(R.id.view_pager)
    LockableViewPager viewPager;

    /* loaded from: classes5.dex */
    public interface PagerContentActionListener {
        void BuiltInFictitiousFunctionClassFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(int i);

        void getAuthRequestContext();
    }

    private static boolean getAuthRequestContext(int i) {
        return i == 0;
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_tooltip_pager;
    }

    public PagerContentView(Context context) {
        super(context);
        this.PlaceComponentResult = true;
    }

    public PagerContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PlaceComponentResult = true;
    }

    public PagerContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.PlaceComponentResult = true;
    }

    public PagerContentView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.PlaceComponentResult = true;
    }

    public void setPagerContentActionListener(PagerContentActionListener pagerContentActionListener) {
        this.getAuthRequestContext = pagerContentActionListener;
    }

    public void setViewList(List<BaseSimpleView> list) {
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(list);
        this.MyBillsEntityDataFactory.notifyDataSetChanged();
        this.viewPager.post(new Runnable() { // from class: id.dana.showcase.view.PagerContentView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                PagerContentView.this.m2947lambda$setViewList$0$iddanashowcaseviewPagerContentView();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setViewList$0$id-dana-showcase-view-PagerContentView  reason: not valid java name */
    public /* synthetic */ void m2947lambda$setViewList$0$iddanashowcaseviewPagerContentView() {
        this.viewPager.setAdapter(this.MyBillsEntityDataFactory);
    }

    public void setScrollable(boolean z) {
        this.PlaceComponentResult = z;
        this.viewPager.setSwipeable(z);
    }

    private boolean getAuthRequestContext() {
        return this.MyBillsEntityDataFactory.getCount() == 1;
    }

    private boolean MyBillsEntityDataFactory(int i) {
        return i == this.MyBillsEntityDataFactory.getCount() - 1;
    }

    private void PlaceComponentResult(int i) {
        if (!getAuthRequestContext()) {
            if (!getAuthRequestContext(i)) {
                if (MyBillsEntityDataFactory(i)) {
                    this.btnLeft.setText(R.string.tooltip_prev);
                    this.btnRight.setText(R.string.tooltip_finish);
                    return;
                }
                this.btnLeft.setText(R.string.tooltip_prev);
                this.btnRight.setText(R.string.tooltip_next);
                return;
            }
            this.btnLeft.setText(R.string.tooltip_skip);
            this.btnRight.setText(R.string.tooltip_next);
            return;
        }
        this.btnLeft.setText(R.string.tooltip_skip);
        this.btnRight.setText(R.string.tooltip_finish);
    }

    static /* synthetic */ void access$000(PagerContentView pagerContentView, int i) {
        pagerContentView.PlaceComponentResult(i);
        PagerContentActionListener pagerContentActionListener = pagerContentView.getAuthRequestContext;
        if (pagerContentActionListener != null) {
            pagerContentActionListener.PlaceComponentResult(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initAdapter$3$id-dana-showcase-view-PagerContentView  reason: not valid java name */
    public /* synthetic */ void m2944lambda$initAdapter$3$iddanashowcaseviewPagerContentView(View view) {
        PagerContentActionListener pagerContentActionListener = this.getAuthRequestContext;
        if (pagerContentActionListener != null) {
            pagerContentActionListener.BuiltInFictitiousFunctionClassFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initButtons$1$id-dana-showcase-view-PagerContentView  reason: not valid java name */
    public /* synthetic */ void m2945lambda$initButtons$1$iddanashowcaseviewPagerContentView(View view) {
        int currentItem = this.viewPager.getCurrentItem();
        if (currentItem > 0) {
            this.viewPager.setCurrentItem(currentItem - 1, this.PlaceComponentResult);
            return;
        }
        PagerContentActionListener pagerContentActionListener = this.getAuthRequestContext;
        if (pagerContentActionListener != null) {
            pagerContentActionListener.PlaceComponentResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initButtons$2$id-dana-showcase-view-PagerContentView  reason: not valid java name */
    public /* synthetic */ void m2946lambda$initButtons$2$iddanashowcaseviewPagerContentView(View view) {
        PagerContentActionListener pagerContentActionListener;
        int currentItem = this.viewPager.getCurrentItem();
        if (currentItem < this.MyBillsEntityDataFactory.getCount() - 1) {
            this.viewPager.setCurrentItem(currentItem + 1, this.PlaceComponentResult);
        } else if (!MyBillsEntityDataFactory(currentItem) || (pagerContentActionListener = this.getAuthRequestContext) == null) {
        } else {
            pagerContentActionListener.getAuthRequestContext();
        }
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.MyBillsEntityDataFactory = new SimplePagerAdapter(getContext());
        this.ivClose.setOnClickListener(new View.OnClickListener() { // from class: id.dana.showcase.view.PagerContentView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PagerContentView.this.m2944lambda$initAdapter$3$iddanashowcaseviewPagerContentView(view);
            }
        });
        this.viewPager.setAdapter(this.MyBillsEntityDataFactory);
        this.viewPager.setOffscreenPageLimit(3);
        this.viewPager.measure(-1, -2);
        this.viewPager.setSwipeable(this.PlaceComponentResult);
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: id.dana.showcase.view.PagerContentView.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                PagerContentView.access$000(PagerContentView.this, i);
            }
        });
        PlaceComponentResult(0);
        this.btnLeft.setOnClickListener(new View.OnClickListener() { // from class: id.dana.showcase.view.PagerContentView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PagerContentView.this.m2945lambda$initButtons$1$iddanashowcaseviewPagerContentView(view);
            }
        });
        this.btnRight.setOnClickListener(new View.OnClickListener() { // from class: id.dana.showcase.view.PagerContentView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PagerContentView.this.m2946lambda$initButtons$2$iddanashowcaseviewPagerContentView(view);
            }
        });
    }
}
