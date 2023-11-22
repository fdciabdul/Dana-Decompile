package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    boolean BuiltInFictitiousFunctionClassFactory;
    private boolean DatabaseTableConfigUtil;
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    int MyBillsEntityDataFactory;
    int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final RecyclerView NetworkUserEntityData$$ExternalSyntheticLambda1;
    ViewPager2.OnPageChangeCallback PlaceComponentResult;
    int getAuthRequestContext;
    private boolean getErrorConfigVersion;
    private final ViewPager2 initRecordTimeStamp;
    private final LinearLayoutManager lookAheadTest;
    ScrollEventValues moveToNextValue;
    int scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScrollEventAdapter(ViewPager2 viewPager2) {
        this.initRecordTimeStamp = viewPager2;
        RecyclerView recyclerView = viewPager2.mRecyclerView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = recyclerView;
        this.lookAheadTest = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.moveToNextValue = new ScrollEventValues();
        MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory() {
        this.getAuthRequestContext = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        ScrollEventValues scrollEventValues = this.moveToNextValue;
        scrollEventValues.BuiltInFictitiousFunctionClassFactory = -1;
        scrollEventValues.PlaceComponentResult = 0.0f;
        scrollEventValues.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        this.MyBillsEntityDataFactory = -1;
        this.scheduleImpl = -1;
        this.getErrorConfigVersion = false;
        this.DatabaseTableConfigUtil = false;
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        boolean z = true;
        if ((this.getAuthRequestContext != 1 || this.NetworkUserEntityData$$ExternalSyntheticLambda0 != 1) && i == 1) {
            BuiltInFictitiousFunctionClassFactory(false);
        } else if (NetworkUserEntityData$$ExternalSyntheticLambda0() && i == 2) {
            if (this.DatabaseTableConfigUtil) {
                KClassImpl$Data$declaredNonStaticMembers$2(2);
                this.getErrorConfigVersion = true;
            }
        } else {
            if (NetworkUserEntityData$$ExternalSyntheticLambda0() && i == 0) {
                KClassImpl$Data$declaredNonStaticMembers$2();
                if (!this.DatabaseTableConfigUtil) {
                    if (this.moveToNextValue.BuiltInFictitiousFunctionClassFactory != -1) {
                        int i2 = this.moveToNextValue.BuiltInFictitiousFunctionClassFactory;
                        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.PlaceComponentResult;
                        if (onPageChangeCallback != null) {
                            onPageChangeCallback.onPageScrolled(i2, 0.0f, 0);
                        }
                    }
                } else if (this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
                    z = false;
                } else if (this.MyBillsEntityDataFactory != this.moveToNextValue.BuiltInFictitiousFunctionClassFactory) {
                    int i3 = this.moveToNextValue.BuiltInFictitiousFunctionClassFactory;
                    ViewPager2.OnPageChangeCallback onPageChangeCallback2 = this.PlaceComponentResult;
                    if (onPageChangeCallback2 != null) {
                        onPageChangeCallback2.onPageSelected(i3);
                    }
                }
                if (z) {
                    KClassImpl$Data$declaredNonStaticMembers$2(0);
                    MyBillsEntityDataFactory();
                }
            }
            if (this.getAuthRequestContext == 2 && i == 0 && this.KClassImpl$Data$declaredNonStaticMembers$2) {
                KClassImpl$Data$declaredNonStaticMembers$2();
                if (this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                    if (this.scheduleImpl != this.moveToNextValue.BuiltInFictitiousFunctionClassFactory) {
                        int i4 = this.moveToNextValue.BuiltInFictitiousFunctionClassFactory == -1 ? 0 : this.moveToNextValue.BuiltInFictitiousFunctionClassFactory;
                        ViewPager2.OnPageChangeCallback onPageChangeCallback3 = this.PlaceComponentResult;
                        if (onPageChangeCallback3 != null) {
                            onPageChangeCallback3.onPageSelected(i4);
                        }
                    }
                    KClassImpl$Data$declaredNonStaticMembers$2(0);
                    MyBillsEntityDataFactory();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if ((r6 < 0) != r4.initRecordTimeStamp.isRtl()) goto L12;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onScrolled(androidx.recyclerview.widget.RecyclerView r5, int r6, int r7) {
        /*
            r4 = this;
            r5 = 1
            r4.DatabaseTableConfigUtil = r5
            r4.KClassImpl$Data$declaredNonStaticMembers$2()
            boolean r0 = r4.getErrorConfigVersion
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L42
            r4.getErrorConfigVersion = r2
            if (r7 > 0) goto L21
            if (r7 != 0) goto L1f
            if (r6 >= 0) goto L16
            r6 = 1
            goto L17
        L16:
            r6 = 0
        L17:
            androidx.viewpager2.widget.ViewPager2 r7 = r4.initRecordTimeStamp
            boolean r7 = r7.isRtl()
            if (r6 == r7) goto L21
        L1f:
            r6 = 0
            goto L22
        L21:
            r6 = 1
        L22:
            if (r6 == 0) goto L30
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r6 = r4.moveToNextValue
            int r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            if (r6 == 0) goto L30
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r6 = r4.moveToNextValue
            int r6 = r6.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + r5
            goto L34
        L30:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r6 = r4.moveToNextValue
            int r6 = r6.BuiltInFictitiousFunctionClassFactory
        L34:
            r4.scheduleImpl = r6
            int r7 = r4.MyBillsEntityDataFactory
            if (r7 == r6) goto L54
            androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback r7 = r4.PlaceComponentResult
            if (r7 == 0) goto L54
            r7.onPageSelected(r6)
            goto L54
        L42:
            int r6 = r4.getAuthRequestContext
            if (r6 != 0) goto L54
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r6 = r4.moveToNextValue
            int r6 = r6.BuiltInFictitiousFunctionClassFactory
            if (r6 != r1) goto L4d
            r6 = 0
        L4d:
            androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback r7 = r4.PlaceComponentResult
            if (r7 == 0) goto L54
            r7.onPageSelected(r6)
        L54:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r6 = r4.moveToNextValue
            int r6 = r6.BuiltInFictitiousFunctionClassFactory
            if (r6 != r1) goto L5c
            r6 = 0
            goto L60
        L5c:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r6 = r4.moveToNextValue
            int r6 = r6.BuiltInFictitiousFunctionClassFactory
        L60:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r7 = r4.moveToNextValue
            float r7 = r7.PlaceComponentResult
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r0 = r4.moveToNextValue
            int r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback r3 = r4.PlaceComponentResult
            if (r3 == 0) goto L6f
            r3.onPageScrolled(r6, r7, r0)
        L6f:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r6 = r4.moveToNextValue
            int r6 = r6.BuiltInFictitiousFunctionClassFactory
            int r7 = r4.scheduleImpl
            if (r6 == r7) goto L79
            if (r7 != r1) goto L89
        L79:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r6 = r4.moveToNextValue
            int r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            if (r6 != 0) goto L89
            int r6 = r4.NetworkUserEntityData$$ExternalSyntheticLambda0
            if (r6 == r5) goto L89
            r4.KClassImpl$Data$declaredNonStaticMembers$2(r2)
            r4.MyBillsEntityDataFactory()
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        int top;
        ScrollEventValues scrollEventValues = this.moveToNextValue;
        scrollEventValues.BuiltInFictitiousFunctionClassFactory = this.lookAheadTest.findFirstVisibleItemPosition();
        if (scrollEventValues.BuiltInFictitiousFunctionClassFactory != -1) {
            View findViewByPosition = this.lookAheadTest.findViewByPosition(scrollEventValues.BuiltInFictitiousFunctionClassFactory);
            if (findViewByPosition != null) {
                int leftDecorationWidth = this.lookAheadTest.getLeftDecorationWidth(findViewByPosition);
                int rightDecorationWidth = this.lookAheadTest.getRightDecorationWidth(findViewByPosition);
                int topDecorationHeight = this.lookAheadTest.getTopDecorationHeight(findViewByPosition);
                int bottomDecorationHeight = this.lookAheadTest.getBottomDecorationHeight(findViewByPosition);
                ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    leftDecorationWidth += marginLayoutParams.leftMargin;
                    rightDecorationWidth += marginLayoutParams.rightMargin;
                    topDecorationHeight += marginLayoutParams.topMargin;
                    bottomDecorationHeight += marginLayoutParams.bottomMargin;
                }
                int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
                int width = findViewByPosition.getWidth();
                if (this.lookAheadTest.getOrientation() == 0) {
                    top = (findViewByPosition.getLeft() - leftDecorationWidth) - this.NetworkUserEntityData$$ExternalSyntheticLambda1.getPaddingLeft();
                    if (this.initRecordTimeStamp.isRtl()) {
                        top = -top;
                    }
                    height = width + leftDecorationWidth + rightDecorationWidth;
                } else {
                    top = (findViewByPosition.getTop() - topDecorationHeight) - this.NetworkUserEntityData$$ExternalSyntheticLambda1.getPaddingTop();
                }
                scrollEventValues.KClassImpl$Data$declaredNonStaticMembers$2 = -top;
                if (scrollEventValues.KClassImpl$Data$declaredNonStaticMembers$2 < 0) {
                    if (new AnimateLayoutChangeDetector(this.lookAheadTest).MyBillsEntityDataFactory()) {
                        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
                    }
                    throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.KClassImpl$Data$declaredNonStaticMembers$2)));
                }
                scrollEventValues.PlaceComponentResult = height != 0 ? scrollEventValues.KClassImpl$Data$declaredNonStaticMembers$2 / height : 0.0f;
                return;
            }
            scrollEventValues.BuiltInFictitiousFunctionClassFactory = -1;
            scrollEventValues.PlaceComponentResult = 0.0f;
            scrollEventValues.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            return;
        }
        scrollEventValues.BuiltInFictitiousFunctionClassFactory = -1;
        scrollEventValues.PlaceComponentResult = 0.0f;
        scrollEventValues.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = z;
        this.getAuthRequestContext = z ? 4 : 1;
        int i = this.scheduleImpl;
        if (i != -1) {
            this.MyBillsEntityDataFactory = i;
            this.scheduleImpl = -1;
        } else if (this.MyBillsEntityDataFactory == -1) {
            this.MyBillsEntityDataFactory = this.lookAheadTest.findFirstVisibleItemPosition();
        }
        KClassImpl$Data$declaredNonStaticMembers$2(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        int i = this.getAuthRequestContext;
        return i == 1 || i == 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if ((this.getAuthRequestContext == 3 && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0) || this.NetworkUserEntityData$$ExternalSyntheticLambda0 == i) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.PlaceComponentResult;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ScrollEventValues {
        int BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        float PlaceComponentResult;

        ScrollEventValues() {
        }
    }
}
