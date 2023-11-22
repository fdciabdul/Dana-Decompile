package id.dana.richview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import id.dana.onboarding.view.SimplePagerAdapter;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class CircularPagerAdapter<T> extends PagerAdapter {
    protected boolean BuiltInFictitiousFunctionClassFactory;
    public SimplePagerAdapter.OnItemClickListener NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected Context PlaceComponentResult;
    protected boolean getAuthRequestContext = true;
    protected int getErrorConfigVersion;
    protected List<T> lookAheadTest;

    /* loaded from: classes9.dex */
    public interface OnItemClickListener {
    }

    protected abstract View PlaceComponentResult(ViewGroup viewGroup, int i);

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public CircularPagerAdapter(Context context, boolean z) {
        this.PlaceComponentResult = context;
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    public final List<T> MyBillsEntityDataFactory() {
        return this.lookAheadTest;
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(List<T> list) {
        this.lookAheadTest = list;
        int i = 0;
        this.getAuthRequestContext = list.size() > 1;
        List<T> list2 = this.lookAheadTest;
        int size = list2 != null ? list2.size() : 0;
        this.getErrorConfigVersion = size;
        if (this.BuiltInFictitiousFunctionClassFactory && this.getAuthRequestContext) {
            i = 2;
        }
        this.getErrorConfigVersion = size + i;
        notifyDataSetChanged();
    }

    public final T KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if (i < 0 || i >= this.lookAheadTest.size()) {
            return null;
        }
        return this.lookAheadTest.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.getErrorConfigVersion;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final int getAuthRequestContext() {
        List<T> list = this.lookAheadTest;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            List<T> list = this.lookAheadTest;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        if (this.lookAheadTest == null) {
            return 0;
        }
        return r0.size() - 1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, final int i) {
        if (this.BuiltInFictitiousFunctionClassFactory && this.getAuthRequestContext) {
            if (i == 0) {
                i = (getCount() - 1) - 2;
            } else {
                i = i > getCount() + (-2) ? 0 : i - 1;
            }
        }
        View PlaceComponentResult = PlaceComponentResult(viewGroup, i);
        PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.CircularPagerAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircularPagerAdapter circularPagerAdapter = CircularPagerAdapter.this;
                int i2 = i;
                SimplePagerAdapter.OnItemClickListener onItemClickListener = circularPagerAdapter.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (onItemClickListener != null) {
                    onItemClickListener.BuiltInFictitiousFunctionClassFactory(i2);
                }
            }
        });
        viewGroup.addView(PlaceComponentResult);
        return PlaceComponentResult;
    }
}
