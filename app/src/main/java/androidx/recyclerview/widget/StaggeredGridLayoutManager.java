package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes3.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    OrientationHelper BuiltInFictitiousFunctionClassFactory;
    private boolean DatabaseTableConfigUtil;
    private int FragmentBottomSheetPaymentSettingBinding;
    private int GetContactSyncConfig;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean MyBillsEntityDataFactory;
    public Span[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Runnable NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Rect NetworkUserEntityData$$ExternalSyntheticLambda3;
    private BitSet NetworkUserEntityData$$ExternalSyntheticLambda4;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final LayoutState NetworkUserEntityData$$ExternalSyntheticLambda7;
    private int NetworkUserEntityData$$ExternalSyntheticLambda8;
    LazySpanLookup PlaceComponentResult;
    private SavedState PrepareContext;
    int getAuthRequestContext;
    boolean getErrorConfigVersion;
    private int initRecordTimeStamp;
    private boolean isLayoutRequested;
    OrientationHelper lookAheadTest;
    public int moveToNextValue;
    private int[] newProxyInstance;
    private final AnchorInfo scheduleImpl;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.moveToNextValue = -1;
        this.MyBillsEntityDataFactory = false;
        this.getErrorConfigVersion = false;
        this.getAuthRequestContext = -1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Integer.MIN_VALUE;
        this.PlaceComponentResult = new LazySpanLookup();
        this.initRecordTimeStamp = 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new Rect();
        this.scheduleImpl = new AnchorInfo();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
            @Override // java.lang.Runnable
            public void run() {
                StaggeredGridLayoutManager.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        };
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attributeSet, i, i2);
        int i3 = properties.PlaceComponentResult;
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i3 != this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = i3;
            OrientationHelper orientationHelper = this.BuiltInFictitiousFunctionClassFactory;
            this.BuiltInFictitiousFunctionClassFactory = this.lookAheadTest;
            this.lookAheadTest = orientationHelper;
            requestLayout();
        }
        NetworkUserEntityData$$ExternalSyntheticLambda0(properties.MyBillsEntityDataFactory);
        BuiltInFictitiousFunctionClassFactory(properties.KClassImpl$Data$declaredNonStaticMembers$2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new LayoutState();
        this.BuiltInFictitiousFunctionClassFactory = OrientationHelper.PlaceComponentResult(this, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        this.lookAheadTest = OrientationHelper.PlaceComponentResult(this, 1 - this.NetworkUserEntityData$$ExternalSyntheticLambda8);
    }

    public StaggeredGridLayoutManager() {
        this.moveToNextValue = -1;
        this.MyBillsEntityDataFactory = false;
        this.getErrorConfigVersion = false;
        this.getAuthRequestContext = -1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Integer.MIN_VALUE;
        this.PlaceComponentResult = new LazySpanLookup();
        this.initRecordTimeStamp = 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new Rect();
        this.scheduleImpl = new AnchorInfo();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
            @Override // java.lang.Runnable
            public void run() {
                StaggeredGridLayoutManager.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = 1;
        NetworkUserEntityData$$ExternalSyntheticLambda0(2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new LayoutState();
        this.BuiltInFictitiousFunctionClassFactory = OrientationHelper.PlaceComponentResult(this, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        this.lookAheadTest = OrientationHelper.PlaceComponentResult(this, 1 - this.NetworkUserEntityData$$ExternalSyntheticLambda8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return this.initRecordTimeStamp != 0;
    }

    final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        int position;
        int position2;
        if (getChildCount() == 0 || this.initRecordTimeStamp == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.getErrorConfigVersion) {
            int childCount = getChildCount();
            position = childCount == 0 ? 0 : getPosition(getChildAt(childCount - 1));
            if (getChildCount() != 0) {
                position2 = getPosition(getChildAt(0));
            }
            position2 = 0;
        } else {
            position = getChildCount() != 0 ? getPosition(getChildAt(0)) : 0;
            int childCount2 = getChildCount();
            if (childCount2 != 0) {
                position2 = getPosition(getChildAt(childCount2 - 1));
            }
            position2 = 0;
        }
        if (position == 0 && getAuthRequestContext() != null) {
            LazySpanLookup lazySpanLookup = this.PlaceComponentResult;
            int[] iArr = lazySpanLookup.PlaceComponentResult;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            lazySpanLookup.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            int i = this.getErrorConfigVersion ? -1 : 1;
            int i2 = position2 + 1;
            LazySpanLookup.FullSpanItem MyBillsEntityDataFactory = this.PlaceComponentResult.MyBillsEntityDataFactory(position, i2, i);
            if (MyBillsEntityDataFactory == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
                this.PlaceComponentResult.PlaceComponentResult(i2);
                return false;
            }
            LazySpanLookup.FullSpanItem MyBillsEntityDataFactory2 = this.PlaceComponentResult.MyBillsEntityDataFactory(position, MyBillsEntityDataFactory.PlaceComponentResult, i * (-1));
            if (MyBillsEntityDataFactory2 == null) {
                this.PlaceComponentResult.PlaceComponentResult(MyBillsEntityDataFactory.PlaceComponentResult);
            } else {
                this.PlaceComponentResult.PlaceComponentResult(MyBillsEntityDataFactory2.PlaceComponentResult + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        for (int i = 0; i < this.moveToNextValue; i++) {
            Span span = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
            span.BuiltInFictitiousFunctionClassFactory.clear();
            span.PlaceComponentResult = Integer.MIN_VALUE;
            span.getAuthRequestContext = Integer.MIN_VALUE;
            span.MyBillsEntityDataFactory = 0;
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0073, code lost:
    
        if (r10 == r11) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:
    
        if (r10 == r11) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0087, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0089, code lost:
    
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View getAuthRequestContext() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.moveToNextValue
            r2.<init>(r3)
            int r3 = r12.moveToNextValue
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.NetworkUserEntityData$$ExternalSyntheticLambda8
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.lookAheadTest()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.getErrorConfigVersion
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Laa
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.KClassImpl$Data$declaredNonStaticMembers$2
            int r9 = r9.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r9 = r12.BuiltInFictitiousFunctionClassFactory(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.KClassImpl$Data$declaredNonStaticMembers$2
            int r9 = r9.KClassImpl$Data$declaredNonStaticMembers$2
            r2.clear(r9)
        L54:
            boolean r9 = r8.BuiltInFictitiousFunctionClassFactory
            if (r9 != 0) goto La8
            int r9 = r0 + r5
            if (r9 == r6) goto La8
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.getErrorConfigVersion
            if (r10 == 0) goto L76
            androidx.recyclerview.widget.OrientationHelper r10 = r12.BuiltInFictitiousFunctionClassFactory
            int r10 = r10.PlaceComponentResult(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.BuiltInFictitiousFunctionClassFactory
            int r11 = r11.PlaceComponentResult(r9)
            if (r10 >= r11) goto L73
            return r7
        L73:
            if (r10 != r11) goto L89
            goto L87
        L76:
            androidx.recyclerview.widget.OrientationHelper r10 = r12.BuiltInFictitiousFunctionClassFactory
            int r10 = r10.getAuthRequestContext(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.BuiltInFictitiousFunctionClassFactory
            int r11 = r11.getAuthRequestContext(r9)
            if (r10 <= r11) goto L85
            return r7
        L85:
            if (r10 != r11) goto L89
        L87:
            r10 = 1
            goto L8a
        L89:
            r10 = 0
        L8a:
            if (r10 == 0) goto La8
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r8 = r8.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8.KClassImpl$Data$declaredNonStaticMembers$2
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r9.KClassImpl$Data$declaredNonStaticMembers$2
            int r9 = r9.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 - r9
            if (r8 >= 0) goto L9f
            r8 = 1
            goto La0
        L9f:
            r8 = 0
        La0:
            if (r3 >= 0) goto La4
            r9 = 1
            goto La5
        La4:
            r9 = 0
        La5:
            if (r8 == r9) goto La8
            return r7
        La8:
            int r0 = r0 + r5
            goto L2e
        Laa:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.getAuthRequestContext():android.view.View");
    }

    private boolean BuiltInFictitiousFunctionClassFactory(Span span) {
        boolean z;
        if (this.getErrorConfigVersion) {
            int i = span.getAuthRequestContext;
            if (i == Integer.MIN_VALUE) {
                span.KClassImpl$Data$declaredNonStaticMembers$2();
                i = span.getAuthRequestContext;
            }
            if (i < this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext()) {
                z = Span.BuiltInFictitiousFunctionClassFactory(span.BuiltInFictitiousFunctionClassFactory.get(span.BuiltInFictitiousFunctionClassFactory.size() - 1)).BuiltInFictitiousFunctionClassFactory;
                return !z;
            }
            return false;
        }
        int i2 = span.PlaceComponentResult;
        if (i2 == Integer.MIN_VALUE) {
            span.MyBillsEntityDataFactory();
            i2 = span.PlaceComponentResult;
        }
        if (i2 > this.BuiltInFictitiousFunctionClassFactory.moveToNextValue()) {
            z = Span.BuiltInFictitiousFunctionClassFactory(span.BuiltInFictitiousFunctionClassFactory.get(0)).BuiltInFictitiousFunctionClassFactory;
            return !z;
        }
        return false;
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda0(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.moveToNextValue) {
            LazySpanLookup lazySpanLookup = this.PlaceComponentResult;
            int[] iArr = lazySpanLookup.PlaceComponentResult;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            lazySpanLookup.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            requestLayout();
            this.moveToNextValue = i;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new BitSet(this.moveToNextValue);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Span[this.moveToNextValue];
            for (int i2 = 0; i2 < this.moveToNextValue; i2++) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2] = new Span(i2);
            }
            requestLayout();
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(boolean z) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.PrepareContext;
        if (savedState != null && savedState.MyBillsEntityDataFactory != z) {
            this.PrepareContext.MyBillsEntityDataFactory = z;
        }
        this.MyBillsEntityDataFactory = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.PrepareContext == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 1 || !lookAheadTest()) {
            this.getErrorConfigVersion = this.MyBillsEntityDataFactory;
        } else {
            this.getErrorConfigVersion = !this.MyBillsEntityDataFactory;
        }
    }

    private boolean lookAheadTest() {
        return getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 1) {
            chooseSize2 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            chooseSize = chooseSize(i, (this.FragmentBottomSheetPaymentSettingBinding * this.moveToNextValue) + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            chooseSize2 = chooseSize(i2, (this.FragmentBottomSheetPaymentSettingBinding * this.moveToNextValue) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        LazySpanLookup lazySpanLookup = this.PlaceComponentResult;
        int[] iArr = lazySpanLookup.PlaceComponentResult;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        lazySpanLookup.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        for (int i = 0; i < this.moveToNextValue; i++) {
            Span span = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
            span.BuiltInFictitiousFunctionClassFactory.clear();
            span.PlaceComponentResult = Integer.MIN_VALUE;
            span.getAuthRequestContext = Integer.MIN_VALUE;
            span.MyBillsEntityDataFactory = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.getAuthRequestContext = -1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Integer.MIN_VALUE;
        this.PrepareContext = null;
        this.scheduleImpl.getAuthRequestContext();
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i;
        int i2;
        int i3 = 0;
        if (this.DatabaseTableConfigUtil) {
            if (state.BuiltInFictitiousFunctionClassFactory) {
                i2 = state.getErrorConfigVersion - state.PlaceComponentResult;
            } else {
                i2 = state.scheduleImpl;
            }
            int childCount = getChildCount() - 1;
            while (true) {
                if (childCount >= 0) {
                    int position = getPosition(getChildAt(childCount));
                    if (position >= 0 && position < i2) {
                        i3 = position;
                        break;
                    }
                    childCount--;
                } else {
                    break;
                }
            }
        } else {
            if (state.BuiltInFictitiousFunctionClassFactory) {
                i = state.getErrorConfigVersion - state.PlaceComponentResult;
            } else {
                i = state.scheduleImpl;
            }
            int childCount2 = getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 < childCount2) {
                    int position2 = getPosition(getChildAt(i4));
                    if (position2 >= 0 && position2 < i) {
                        i3 = position2;
                        break;
                    }
                    i4++;
                } else {
                    break;
                }
            }
        }
        anchorInfo.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
        anchorInfo.PlaceComponentResult = Integer.MIN_VALUE;
        return true;
    }

    private boolean BuiltInFictitiousFunctionClassFactory(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i;
        int i2;
        int moveToNextValue;
        r1 = 0;
        int position = 0;
        if (!state.KClassImpl$Data$declaredNonStaticMembers$2() && (i = this.getAuthRequestContext) != -1) {
            if (i >= 0) {
                if (state.BuiltInFictitiousFunctionClassFactory) {
                    i2 = state.getErrorConfigVersion - state.PlaceComponentResult;
                } else {
                    i2 = state.scheduleImpl;
                }
                if (i < i2) {
                    SavedState savedState = this.PrepareContext;
                    if (savedState == null || savedState.BuiltInFictitiousFunctionClassFactory == -1 || this.PrepareContext.lookAheadTest <= 0) {
                        View findViewByPosition = findViewByPosition(this.getAuthRequestContext);
                        if (findViewByPosition != null) {
                            if (this.getErrorConfigVersion) {
                                int childCount = getChildCount();
                                if (childCount != 0) {
                                    position = getPosition(getChildAt(childCount - 1));
                                }
                            } else if (getChildCount() != 0) {
                                position = getPosition(getChildAt(0));
                            }
                            anchorInfo.KClassImpl$Data$declaredNonStaticMembers$2 = position;
                            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != Integer.MIN_VALUE) {
                                if (anchorInfo.BuiltInFictitiousFunctionClassFactory) {
                                    anchorInfo.PlaceComponentResult = (this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext() - this.KClassImpl$Data$declaredNonStaticMembers$2) - this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(findViewByPosition);
                                } else {
                                    anchorInfo.PlaceComponentResult = (this.BuiltInFictitiousFunctionClassFactory.moveToNextValue() + this.KClassImpl$Data$declaredNonStaticMembers$2) - this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(findViewByPosition);
                                }
                                return true;
                            } else if (this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(findViewByPosition) > this.BuiltInFictitiousFunctionClassFactory.scheduleImpl()) {
                                if (anchorInfo.BuiltInFictitiousFunctionClassFactory) {
                                    moveToNextValue = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
                                } else {
                                    moveToNextValue = this.BuiltInFictitiousFunctionClassFactory.moveToNextValue();
                                }
                                anchorInfo.PlaceComponentResult = moveToNextValue;
                                return true;
                            } else {
                                int authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(findViewByPosition) - this.BuiltInFictitiousFunctionClassFactory.moveToNextValue();
                                if (authRequestContext < 0) {
                                    anchorInfo.PlaceComponentResult = -authRequestContext;
                                    return true;
                                }
                                int authRequestContext2 = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext() - this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(findViewByPosition);
                                if (authRequestContext2 < 0) {
                                    anchorInfo.PlaceComponentResult = authRequestContext2;
                                    return true;
                                }
                                anchorInfo.PlaceComponentResult = Integer.MIN_VALUE;
                            }
                        } else {
                            anchorInfo.KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext;
                            int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                            if (i3 == Integer.MIN_VALUE) {
                                anchorInfo.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory(anchorInfo.KClassImpl$Data$declaredNonStaticMembers$2) == 1;
                                anchorInfo.PlaceComponentResult = anchorInfo.BuiltInFictitiousFunctionClassFactory ? StaggeredGridLayoutManager.this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext() : StaggeredGridLayoutManager.this.BuiltInFictitiousFunctionClassFactory.moveToNextValue();
                            } else if (anchorInfo.BuiltInFictitiousFunctionClassFactory) {
                                anchorInfo.PlaceComponentResult = StaggeredGridLayoutManager.this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext() - i3;
                            } else {
                                anchorInfo.PlaceComponentResult = StaggeredGridLayoutManager.this.BuiltInFictitiousFunctionClassFactory.moveToNextValue() + i3;
                            }
                            anchorInfo.MyBillsEntityDataFactory = true;
                        }
                    } else {
                        anchorInfo.PlaceComponentResult = Integer.MIN_VALUE;
                        anchorInfo.KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext;
                    }
                    return true;
                }
            }
            this.getAuthRequestContext = -1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.PrepareContext == null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return MyBillsEntityDataFactory(state);
    }

    private int MyBillsEntityDataFactory(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.KClassImpl$Data$declaredNonStaticMembers$2(state, this.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory(!this.NetworkUserEntityData$$ExternalSyntheticLambda6), getAuthRequestContext(!this.NetworkUserEntityData$$ExternalSyntheticLambda6), this, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.getErrorConfigVersion);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return MyBillsEntityDataFactory(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return BuiltInFictitiousFunctionClassFactory(state);
    }

    private int BuiltInFictitiousFunctionClassFactory(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.BuiltInFictitiousFunctionClassFactory(state, this.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory(!this.NetworkUserEntityData$$ExternalSyntheticLambda6), getAuthRequestContext(!this.NetworkUserEntityData$$ExternalSyntheticLambda6), this, this.NetworkUserEntityData$$ExternalSyntheticLambda6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return BuiltInFictitiousFunctionClassFactory(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return KClassImpl$Data$declaredNonStaticMembers$2(state);
    }

    private int KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.PlaceComponentResult(state, this.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory(!this.NetworkUserEntityData$$ExternalSyntheticLambda6), getAuthRequestContext(!this.NetworkUserEntityData$$ExternalSyntheticLambda6), this, this.NetworkUserEntityData$$ExternalSyntheticLambda6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return KClassImpl$Data$declaredNonStaticMembers$2(state);
    }

    private void PlaceComponentResult(View view, int i, int i2) {
        calculateItemDecorationsForChild(view, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(i, layoutParams.leftMargin + this.NetworkUserEntityData$$ExternalSyntheticLambda3.left, layoutParams.rightMargin + this.NetworkUserEntityData$$ExternalSyntheticLambda3.right);
        int KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(i2, layoutParams.topMargin + this.NetworkUserEntityData$$ExternalSyntheticLambda3.top, layoutParams.bottomMargin + this.NetworkUserEntityData$$ExternalSyntheticLambda3.bottom);
        if (shouldMeasureChild(view, KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22, layoutParams)) {
            view.measure(KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22);
        }
    }

    private static int KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.PrepareContext = savedState;
            if (this.getAuthRequestContext != -1) {
                savedState.moveToNextValue = null;
                savedState.lookAheadTest = 0;
                savedState.BuiltInFictitiousFunctionClassFactory = -1;
                savedState.getErrorConfigVersion = -1;
                SavedState savedState2 = this.PrepareContext;
                savedState2.moveToNextValue = null;
                savedState2.lookAheadTest = 0;
                savedState2.scheduleImpl = 0;
                savedState2.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
                savedState2.getAuthRequestContext = null;
            }
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.Parcelable onSaveInstanceState() {
        /*
            r5 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r0 = r5.PrepareContext
            if (r0 == 0) goto Lc
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r0 = new androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r5.PrepareContext
            r0.<init>(r1)
            return r0
        Lc:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r0 = new androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState
            r0.<init>()
            boolean r1 = r5.MyBillsEntityDataFactory
            r0.MyBillsEntityDataFactory = r1
            boolean r1 = r5.DatabaseTableConfigUtil
            r0.PlaceComponentResult = r1
            boolean r1 = r5.isLayoutRequested
            r0.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r1 = r5.PlaceComponentResult
            r2 = 0
            if (r1 == 0) goto L38
            int[] r1 = r1.PlaceComponentResult
            if (r1 == 0) goto L38
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r1 = r5.PlaceComponentResult
            int[] r1 = r1.PlaceComponentResult
            r0.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            int[] r1 = r0.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r1 = r1.length
            r0.scheduleImpl = r1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r1 = r5.PlaceComponentResult
            java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r1 = r1.KClassImpl$Data$declaredNonStaticMembers$2
            r0.getAuthRequestContext = r1
            goto L3a
        L38:
            r0.scheduleImpl = r2
        L3a:
            int r1 = r5.getChildCount()
            r3 = -1
            if (r1 <= 0) goto Lbb
            boolean r1 = r5.DatabaseTableConfigUtil
            r4 = 1
            if (r1 == 0) goto L58
            int r1 = r5.getChildCount()
            if (r1 != 0) goto L4e
        L4c:
            r1 = 0
            goto L66
        L4e:
            int r1 = r1 - r4
            android.view.View r1 = r5.getChildAt(r1)
            int r1 = r5.getPosition(r1)
            goto L66
        L58:
            int r1 = r5.getChildCount()
            if (r1 == 0) goto L4c
            android.view.View r1 = r5.getChildAt(r2)
            int r1 = r5.getPosition(r1)
        L66:
            r0.BuiltInFictitiousFunctionClassFactory = r1
            boolean r1 = r5.getErrorConfigVersion
            if (r1 == 0) goto L71
            android.view.View r1 = r5.getAuthRequestContext(r4)
            goto L75
        L71:
            android.view.View r1 = r5.MyBillsEntityDataFactory(r4)
        L75:
            if (r1 != 0) goto L78
            goto L7c
        L78:
            int r3 = r5.getPosition(r1)
        L7c:
            r0.getErrorConfigVersion = r3
            int r1 = r5.moveToNextValue
            r0.lookAheadTest = r1
            int r1 = r5.moveToNextValue
            int[] r1 = new int[r1]
            r0.moveToNextValue = r1
        L88:
            int r1 = r5.moveToNextValue
            if (r2 >= r1) goto Lc1
            boolean r1 = r5.DatabaseTableConfigUtil
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == 0) goto La3
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r1 = r5.NetworkUserEntityData$$ExternalSyntheticLambda0
            r1 = r1[r2]
            int r1 = r1.PlaceComponentResult(r3)
            if (r1 == r3) goto Lb4
            androidx.recyclerview.widget.OrientationHelper r3 = r5.BuiltInFictitiousFunctionClassFactory
            int r3 = r3.getAuthRequestContext()
            goto Lb3
        La3:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span[] r1 = r5.NetworkUserEntityData$$ExternalSyntheticLambda0
            r1 = r1[r2]
            int r1 = r1.KClassImpl$Data$declaredNonStaticMembers$2(r3)
            if (r1 == r3) goto Lb4
            androidx.recyclerview.widget.OrientationHelper r3 = r5.BuiltInFictitiousFunctionClassFactory
            int r3 = r3.moveToNextValue()
        Lb3:
            int r1 = r1 - r3
        Lb4:
            int[] r3 = r0.moveToNextValue
            r3[r2] = r1
            int r2 = r2 + 1
            goto L88
        Lbb:
            r0.BuiltInFictitiousFunctionClassFactory = r3
            r0.getErrorConfigVersion = r3
            r0.lookAheadTest = r2
        Lc1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onSaveInstanceState():android.os.Parcelable");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View MyBillsEntityDataFactory = MyBillsEntityDataFactory(false);
            View authRequestContext = getAuthRequestContext(false);
            if (MyBillsEntityDataFactory == null || authRequestContext == null) {
                return;
            }
            int position = getPosition(MyBillsEntityDataFactory);
            int position2 = getPosition(authRequestContext);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
                return;
            }
            accessibilityEvent.setFromIndex(position2);
            accessibilityEvent.setToIndex(position);
        }
    }

    private View MyBillsEntityDataFactory(boolean z) {
        int moveToNextValue = this.BuiltInFictitiousFunctionClassFactory.moveToNextValue();
        int authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int authRequestContext2 = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(childAt);
            if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(childAt) > moveToNextValue && authRequestContext2 < authRequestContext) {
                if (authRequestContext2 >= moveToNextValue || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private View getAuthRequestContext(boolean z) {
        int moveToNextValue = this.BuiltInFictitiousFunctionClassFactory.moveToNextValue();
        int authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int authRequestContext2 = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(childAt);
            int PlaceComponentResult = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(childAt);
            if (PlaceComponentResult > moveToNextValue && authRequestContext2 < authRequestContext) {
                if (PlaceComponentResult <= authRequestContext || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private void MyBillsEntityDataFactory(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int authRequestContext;
        int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(Integer.MIN_VALUE);
        if (BuiltInFictitiousFunctionClassFactory != Integer.MIN_VALUE && (authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext() - BuiltInFictitiousFunctionClassFactory) > 0) {
            int i = authRequestContext - (-PlaceComponentResult(-authRequestContext, recycler, state));
            if (!z || i <= 0) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(i);
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int moveToNextValue;
        int PlaceComponentResult = PlaceComponentResult(Integer.MAX_VALUE);
        if (PlaceComponentResult != Integer.MAX_VALUE && (moveToNextValue = PlaceComponentResult - this.BuiltInFictitiousFunctionClassFactory.moveToNextValue()) > 0) {
            int PlaceComponentResult2 = moveToNextValue - PlaceComponentResult(moveToNextValue, recycler, state);
            if (!z || PlaceComponentResult2 <= 0) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(-PlaceComponentResult2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void PlaceComponentResult(int r5, androidx.recyclerview.widget.RecyclerView.State r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.LayoutState r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda7
            r1 = 0
            r0.getAuthRequestContext = r1
            androidx.recyclerview.widget.LayoutState r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda7
            r0.MyBillsEntityDataFactory = r5
            boolean r0 = r4.isSmoothScrolling()
            r2 = 1
            if (r0 == 0) goto L2e
            int r6 = r6.NetworkUserEntityData$$ExternalSyntheticLambda1
            r0 = -1
            if (r6 == r0) goto L2e
            boolean r0 = r4.getErrorConfigVersion
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L25
            androidx.recyclerview.widget.OrientationHelper r5 = r4.BuiltInFictitiousFunctionClassFactory
            int r5 = r5.scheduleImpl()
            goto L2f
        L25:
            androidx.recyclerview.widget.OrientationHelper r5 = r4.BuiltInFictitiousFunctionClassFactory
            int r5 = r5.scheduleImpl()
            r6 = r5
            r5 = 0
            goto L30
        L2e:
            r5 = 0
        L2f:
            r6 = 0
        L30:
            boolean r0 = r4.getClipToPadding()
            if (r0 == 0) goto L4d
            androidx.recyclerview.widget.LayoutState r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda7
            androidx.recyclerview.widget.OrientationHelper r3 = r4.BuiltInFictitiousFunctionClassFactory
            int r3 = r3.moveToNextValue()
            int r3 = r3 - r6
            r0.scheduleImpl = r3
            androidx.recyclerview.widget.LayoutState r6 = r4.NetworkUserEntityData$$ExternalSyntheticLambda7
            androidx.recyclerview.widget.OrientationHelper r0 = r4.BuiltInFictitiousFunctionClassFactory
            int r0 = r0.getAuthRequestContext()
            int r0 = r0 + r5
            r6.BuiltInFictitiousFunctionClassFactory = r0
            goto L5d
        L4d:
            androidx.recyclerview.widget.LayoutState r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda7
            androidx.recyclerview.widget.OrientationHelper r3 = r4.BuiltInFictitiousFunctionClassFactory
            int r3 = r3.MyBillsEntityDataFactory()
            int r3 = r3 + r5
            r0.BuiltInFictitiousFunctionClassFactory = r3
            androidx.recyclerview.widget.LayoutState r5 = r4.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r6 = -r6
            r5.scheduleImpl = r6
        L5d:
            androidx.recyclerview.widget.LayoutState r5 = r4.NetworkUserEntityData$$ExternalSyntheticLambda7
            r5.lookAheadTest = r1
            androidx.recyclerview.widget.LayoutState r5 = r4.NetworkUserEntityData$$ExternalSyntheticLambda7
            r5.getErrorConfigVersion = r2
            androidx.recyclerview.widget.LayoutState r5 = r4.NetworkUserEntityData$$ExternalSyntheticLambda7
            androidx.recyclerview.widget.OrientationHelper r6 = r4.BuiltInFictitiousFunctionClassFactory
            int r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2()
            if (r6 != 0) goto L78
            androidx.recyclerview.widget.OrientationHelper r6 = r4.BuiltInFictitiousFunctionClassFactory
            int r6 = r6.MyBillsEntityDataFactory()
            if (r6 != 0) goto L78
            r1 = 1
        L78:
            r5.PlaceComponentResult = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.PlaceComponentResult(int, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    private void scheduleImpl(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.KClassImpl$Data$declaredNonStaticMembers$2 = this.getErrorConfigVersion != (i == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.moveToNextValue; i2++) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2].MyBillsEntityDataFactory(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.moveToNextValue; i2++) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2].MyBillsEntityDataFactory(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        getAuthRequestContext(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        getAuthRequestContext(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        LazySpanLookup lazySpanLookup = this.PlaceComponentResult;
        int[] iArr = lazySpanLookup.PlaceComponentResult;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        lazySpanLookup.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        getAuthRequestContext(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        getAuthRequestContext(i, i2, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getAuthRequestContext(int r8, int r9, int r10) {
        /*
            r7 = this;
            boolean r0 = r7.getErrorConfigVersion
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L17
            int r0 = r7.getChildCount()
            if (r0 != 0) goto Ld
            goto L26
        Ld:
            int r0 = r0 - r2
            android.view.View r0 = r7.getChildAt(r0)
            int r0 = r7.getPosition(r0)
            goto L27
        L17:
            int r0 = r7.getChildCount()
            if (r0 == 0) goto L26
            android.view.View r0 = r7.getChildAt(r1)
            int r0 = r7.getPosition(r0)
            goto L27
        L26:
            r0 = 0
        L27:
            r3 = 8
            if (r10 != r3) goto L34
            if (r8 >= r9) goto L30
            int r4 = r9 + 1
            goto L36
        L30:
            int r4 = r8 + 1
            r5 = r9
            goto L37
        L34:
            int r4 = r8 + r9
        L36:
            r5 = r8
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r6 = r7.PlaceComponentResult
            r6.BuiltInFictitiousFunctionClassFactory(r5)
            if (r10 == r2) goto L54
            r6 = 2
            if (r10 == r6) goto L4e
            if (r10 != r3) goto L59
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r10 = r7.PlaceComponentResult
            r10.KClassImpl$Data$declaredNonStaticMembers$2(r8, r2)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r8 = r7.PlaceComponentResult
            r8.getAuthRequestContext(r9, r2)
            goto L59
        L4e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r10 = r7.PlaceComponentResult
            r10.KClassImpl$Data$declaredNonStaticMembers$2(r8, r9)
            goto L59
        L54:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r10 = r7.PlaceComponentResult
            r10.getAuthRequestContext(r8, r9)
        L59:
            if (r4 > r0) goto L5c
            return
        L5c:
            boolean r8 = r7.getErrorConfigVersion
            if (r8 == 0) goto L6f
            int r8 = r7.getChildCount()
            if (r8 == 0) goto L7f
            android.view.View r8 = r7.getChildAt(r1)
            int r1 = r7.getPosition(r8)
            goto L7f
        L6f:
            int r8 = r7.getChildCount()
            if (r8 != 0) goto L76
            goto L7f
        L76:
            int r8 = r8 - r2
            android.view.View r8 = r7.getChildAt(r8)
            int r1 = r7.getPosition(r8)
        L7f:
            if (r5 > r1) goto L84
            r7.requestLayout()
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.getAuthRequestContext(int, int, int):void");
    }

    private int KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        int i;
        int i2;
        int moveToNextValue;
        int BuiltInFictitiousFunctionClassFactory;
        Span span;
        int i3;
        int i4;
        int i5;
        int MyBillsEntityDataFactory;
        LayoutParams layoutParams;
        boolean PlaceComponentResult;
        int i6;
        int i7;
        int i8;
        RecyclerView.Recycler recycler2 = recycler;
        char c = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4.set(0, this.moveToNextValue, true);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult) {
            i2 = layoutState.NetworkUserEntityData$$ExternalSyntheticLambda0 == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (layoutState.NetworkUserEntityData$$ExternalSyntheticLambda0 == 1) {
                i = layoutState.BuiltInFictitiousFunctionClassFactory + layoutState.getAuthRequestContext;
            } else {
                i = layoutState.scheduleImpl - layoutState.getAuthRequestContext;
            }
            i2 = i;
        }
        PlaceComponentResult(layoutState.NetworkUserEntityData$$ExternalSyntheticLambda0, i2);
        if (this.getErrorConfigVersion) {
            moveToNextValue = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        } else {
            moveToNextValue = this.BuiltInFictitiousFunctionClassFactory.moveToNextValue();
        }
        int i9 = moveToNextValue;
        boolean z = false;
        while (layoutState.getAuthRequestContext(state) && (this.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult || !this.NetworkUserEntityData$$ExternalSyntheticLambda4.isEmpty())) {
            View BuiltInFictitiousFunctionClassFactory2 = recycler2.BuiltInFictitiousFunctionClassFactory(layoutState.MyBillsEntityDataFactory);
            layoutState.MyBillsEntityDataFactory += layoutState.KClassImpl$Data$declaredNonStaticMembers$2;
            LayoutParams layoutParams2 = (LayoutParams) BuiltInFictitiousFunctionClassFactory2.getLayoutParams();
            int viewLayoutPosition = layoutParams2.getViewLayoutPosition();
            int[] iArr = this.PlaceComponentResult.PlaceComponentResult;
            int i10 = (iArr == null || viewLayoutPosition >= iArr.length) ? -1 : iArr[viewLayoutPosition];
            boolean z2 = i10 == -1;
            if (z2) {
                if (layoutParams2.BuiltInFictitiousFunctionClassFactory) {
                    span = this.NetworkUserEntityData$$ExternalSyntheticLambda0[c];
                } else {
                    if (moveToNextValue(layoutState.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                        i7 = this.moveToNextValue - 1;
                        i6 = -1;
                        i8 = -1;
                    } else {
                        i6 = this.moveToNextValue;
                        i7 = 0;
                        i8 = 1;
                    }
                    Span span2 = null;
                    if (layoutState.NetworkUserEntityData$$ExternalSyntheticLambda0 == 1) {
                        int moveToNextValue2 = this.BuiltInFictitiousFunctionClassFactory.moveToNextValue();
                        int i11 = Integer.MAX_VALUE;
                        while (i7 != i6) {
                            Span span3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i7];
                            int PlaceComponentResult2 = span3.PlaceComponentResult(moveToNextValue2);
                            if (PlaceComponentResult2 < i11) {
                                span2 = span3;
                                i11 = PlaceComponentResult2;
                            }
                            i7 += i8;
                        }
                    } else {
                        int authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
                        int i12 = Integer.MIN_VALUE;
                        while (i7 != i6) {
                            Span span4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i7];
                            int KClassImpl$Data$declaredNonStaticMembers$2 = span4.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
                            if (KClassImpl$Data$declaredNonStaticMembers$2 > i12) {
                                span2 = span4;
                                i12 = KClassImpl$Data$declaredNonStaticMembers$2;
                            }
                            i7 += i8;
                        }
                    }
                    span = span2;
                }
                LazySpanLookup lazySpanLookup = this.PlaceComponentResult;
                lazySpanLookup.KClassImpl$Data$declaredNonStaticMembers$2(viewLayoutPosition);
                lazySpanLookup.PlaceComponentResult[viewLayoutPosition] = span.KClassImpl$Data$declaredNonStaticMembers$2;
            } else {
                span = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i10];
            }
            Span span5 = span;
            layoutParams2.KClassImpl$Data$declaredNonStaticMembers$2 = span5;
            if (layoutState.NetworkUserEntityData$$ExternalSyntheticLambda0 == 1) {
                addView(BuiltInFictitiousFunctionClassFactory2);
            } else {
                addView(BuiltInFictitiousFunctionClassFactory2, 0);
            }
            if (layoutParams2.BuiltInFictitiousFunctionClassFactory) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 1) {
                    PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2, this.GetContactSyncConfig, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams2.height, true));
                } else {
                    PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams2.width, true), this.GetContactSyncConfig);
                }
            } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 1) {
                PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2, getChildMeasureSpec(this.FragmentBottomSheetPaymentSettingBinding, getWidthMode(), 0, layoutParams2.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams2.height, true));
            } else {
                PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams2.width, true), getChildMeasureSpec(this.FragmentBottomSheetPaymentSettingBinding, getHeightMode(), 0, layoutParams2.height, false));
            }
            if (layoutState.NetworkUserEntityData$$ExternalSyntheticLambda0 == 1) {
                int BuiltInFictitiousFunctionClassFactory3 = layoutParams2.BuiltInFictitiousFunctionClassFactory ? BuiltInFictitiousFunctionClassFactory(i9) : span5.PlaceComponentResult(i9);
                int MyBillsEntityDataFactory2 = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
                if (z2 && layoutParams2.BuiltInFictitiousFunctionClassFactory) {
                    LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
                    fullSpanItem.KClassImpl$Data$declaredNonStaticMembers$2 = new int[this.moveToNextValue];
                    for (int i13 = 0; i13 < this.moveToNextValue; i13++) {
                        fullSpanItem.KClassImpl$Data$declaredNonStaticMembers$2[i13] = BuiltInFictitiousFunctionClassFactory3 - this.NetworkUserEntityData$$ExternalSyntheticLambda0[i13].PlaceComponentResult(BuiltInFictitiousFunctionClassFactory3);
                    }
                    fullSpanItem.getAuthRequestContext = -1;
                    fullSpanItem.PlaceComponentResult = viewLayoutPosition;
                    this.PlaceComponentResult.PlaceComponentResult(fullSpanItem);
                }
                i4 = BuiltInFictitiousFunctionClassFactory3;
                i3 = MyBillsEntityDataFactory2 + BuiltInFictitiousFunctionClassFactory3;
            } else {
                int PlaceComponentResult3 = layoutParams2.BuiltInFictitiousFunctionClassFactory ? PlaceComponentResult(i9) : span5.KClassImpl$Data$declaredNonStaticMembers$2(i9);
                int MyBillsEntityDataFactory3 = PlaceComponentResult3 - this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
                if (z2 && layoutParams2.BuiltInFictitiousFunctionClassFactory) {
                    LazySpanLookup.FullSpanItem fullSpanItem2 = new LazySpanLookup.FullSpanItem();
                    fullSpanItem2.KClassImpl$Data$declaredNonStaticMembers$2 = new int[this.moveToNextValue];
                    for (int i14 = 0; i14 < this.moveToNextValue; i14++) {
                        fullSpanItem2.KClassImpl$Data$declaredNonStaticMembers$2[i14] = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i14].KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult3) - PlaceComponentResult3;
                    }
                    fullSpanItem2.getAuthRequestContext = 1;
                    fullSpanItem2.PlaceComponentResult = viewLayoutPosition;
                    this.PlaceComponentResult.PlaceComponentResult(fullSpanItem2);
                }
                i3 = PlaceComponentResult3;
                i4 = MyBillsEntityDataFactory3;
            }
            if (layoutParams2.BuiltInFictitiousFunctionClassFactory && layoutState.KClassImpl$Data$declaredNonStaticMembers$2 == -1) {
                if (!z2) {
                    if (layoutState.NetworkUserEntityData$$ExternalSyntheticLambda0 == 1) {
                        PlaceComponentResult = MyBillsEntityDataFactory();
                    } else {
                        PlaceComponentResult = PlaceComponentResult();
                    }
                    if ((!PlaceComponentResult) != false) {
                        LazySpanLookup.FullSpanItem authRequestContext2 = this.PlaceComponentResult.getAuthRequestContext(viewLayoutPosition);
                        if (authRequestContext2 != null) {
                            authRequestContext2.MyBillsEntityDataFactory = true;
                        }
                    }
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            }
            if (layoutState.NetworkUserEntityData$$ExternalSyntheticLambda0 == 1) {
                if (!layoutParams2.BuiltInFictitiousFunctionClassFactory) {
                    layoutParams2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2);
                } else {
                    for (int i15 = this.moveToNextValue - 1; i15 >= 0; i15--) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0[i15].KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2);
                    }
                }
            } else if (!layoutParams2.BuiltInFictitiousFunctionClassFactory) {
                layoutParams2.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2);
            } else {
                for (int i16 = this.moveToNextValue - 1; i16 >= 0; i16--) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0[i16].getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2);
                }
            }
            if (lookAheadTest() && this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 1) {
                int authRequestContext3 = layoutParams2.BuiltInFictitiousFunctionClassFactory ? this.lookAheadTest.getAuthRequestContext() : this.lookAheadTest.getAuthRequestContext() - (((this.moveToNextValue - 1) - span5.KClassImpl$Data$declaredNonStaticMembers$2) * this.FragmentBottomSheetPaymentSettingBinding);
                MyBillsEntityDataFactory = authRequestContext3;
                i5 = authRequestContext3 - this.lookAheadTest.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
            } else {
                int moveToNextValue3 = layoutParams2.BuiltInFictitiousFunctionClassFactory ? this.lookAheadTest.moveToNextValue() : (span5.KClassImpl$Data$declaredNonStaticMembers$2 * this.FragmentBottomSheetPaymentSettingBinding) + this.lookAheadTest.moveToNextValue();
                i5 = moveToNextValue3;
                MyBillsEntityDataFactory = this.lookAheadTest.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2) + moveToNextValue3;
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 1) {
                layoutParams = layoutParams2;
                layoutDecoratedWithMargins(BuiltInFictitiousFunctionClassFactory2, i5, i4, MyBillsEntityDataFactory, i3);
            } else {
                layoutParams = layoutParams2;
                layoutDecoratedWithMargins(BuiltInFictitiousFunctionClassFactory2, i4, i5, i3, MyBillsEntityDataFactory);
            }
            if (layoutParams.BuiltInFictitiousFunctionClassFactory) {
                PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda0, i2);
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2(span5, this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda0, i2);
            }
            PlaceComponentResult(recycler, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest && BuiltInFictitiousFunctionClassFactory2.hasFocusable()) {
                if (layoutParams.BuiltInFictitiousFunctionClassFactory) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda4.clear();
                } else {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda4.set(span5.KClassImpl$Data$declaredNonStaticMembers$2, false);
                    recycler2 = recycler;
                    z = true;
                    c = 0;
                }
            }
            recycler2 = recycler;
            z = true;
            c = 0;
        }
        RecyclerView.Recycler recycler3 = recycler2;
        if (!z) {
            PlaceComponentResult(recycler3, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda0 == -1) {
            BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.moveToNextValue() - PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue());
        } else {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext()) - this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        }
        if (BuiltInFictitiousFunctionClassFactory > 0) {
            return Math.min(layoutState.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory);
        }
        return 0;
    }

    private void PlaceComponentResult(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int min;
        int min2;
        if (!layoutState.getErrorConfigVersion || layoutState.PlaceComponentResult) {
            return;
        }
        if (layoutState.getAuthRequestContext == 0) {
            if (layoutState.NetworkUserEntityData$$ExternalSyntheticLambda0 == -1) {
                PlaceComponentResult(recycler, layoutState.BuiltInFictitiousFunctionClassFactory);
            } else {
                MyBillsEntityDataFactory(recycler, layoutState.scheduleImpl);
            }
        } else if (layoutState.NetworkUserEntityData$$ExternalSyntheticLambda0 == -1) {
            int KClassImpl$Data$declaredNonStaticMembers$2 = layoutState.scheduleImpl - KClassImpl$Data$declaredNonStaticMembers$2(layoutState.scheduleImpl);
            if (KClassImpl$Data$declaredNonStaticMembers$2 < 0) {
                min2 = layoutState.BuiltInFictitiousFunctionClassFactory;
            } else {
                min2 = layoutState.BuiltInFictitiousFunctionClassFactory - Math.min(KClassImpl$Data$declaredNonStaticMembers$2, layoutState.getAuthRequestContext);
            }
            PlaceComponentResult(recycler, min2);
        } else {
            int authRequestContext = getAuthRequestContext(layoutState.BuiltInFictitiousFunctionClassFactory) - layoutState.BuiltInFictitiousFunctionClassFactory;
            if (authRequestContext < 0) {
                min = layoutState.scheduleImpl;
            } else {
                min = Math.min(authRequestContext, layoutState.getAuthRequestContext) + layoutState.scheduleImpl;
            }
            MyBillsEntityDataFactory(recycler, min);
        }
    }

    private void PlaceComponentResult(int i, int i2) {
        for (int i3 = 0; i3 < this.moveToNextValue; i3++) {
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0[i3].BuiltInFictitiousFunctionClassFactory.isEmpty()) {
                KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0[i3], i, i2);
            }
        }
    }

    private int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        int KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[0].KClassImpl$Data$declaredNonStaticMembers$2(i);
        for (int i2 = 1; i2 < this.moveToNextValue; i2++) {
            int KClassImpl$Data$declaredNonStaticMembers$22 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2].KClassImpl$Data$declaredNonStaticMembers$2(i);
            if (KClassImpl$Data$declaredNonStaticMembers$22 > KClassImpl$Data$declaredNonStaticMembers$2) {
                KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$22;
            }
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private int PlaceComponentResult(int i) {
        int KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[0].KClassImpl$Data$declaredNonStaticMembers$2(i);
        for (int i2 = 1; i2 < this.moveToNextValue; i2++) {
            int KClassImpl$Data$declaredNonStaticMembers$22 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2].KClassImpl$Data$declaredNonStaticMembers$2(i);
            if (KClassImpl$Data$declaredNonStaticMembers$22 < KClassImpl$Data$declaredNonStaticMembers$2) {
                KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$22;
            }
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private boolean MyBillsEntityDataFactory() {
        int PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda0[0].PlaceComponentResult(Integer.MIN_VALUE);
        for (int i = 1; i < this.moveToNextValue; i++) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0[i].PlaceComponentResult(Integer.MIN_VALUE) != PlaceComponentResult) {
                return false;
            }
        }
        return true;
    }

    private boolean PlaceComponentResult() {
        int KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[0].KClassImpl$Data$declaredNonStaticMembers$2(Integer.MIN_VALUE);
        for (int i = 1; i < this.moveToNextValue; i++) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0[i].KClassImpl$Data$declaredNonStaticMembers$2(Integer.MIN_VALUE) != KClassImpl$Data$declaredNonStaticMembers$2) {
                return false;
            }
        }
        return true;
    }

    private int BuiltInFictitiousFunctionClassFactory(int i) {
        int PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda0[0].PlaceComponentResult(i);
        for (int i2 = 1; i2 < this.moveToNextValue; i2++) {
            int PlaceComponentResult2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2].PlaceComponentResult(i);
            if (PlaceComponentResult2 > PlaceComponentResult) {
                PlaceComponentResult = PlaceComponentResult2;
            }
        }
        return PlaceComponentResult;
    }

    private int getAuthRequestContext(int i) {
        int PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda0[0].PlaceComponentResult(i);
        for (int i2 = 1; i2 < this.moveToNextValue; i2++) {
            int PlaceComponentResult2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2].PlaceComponentResult(i);
            if (PlaceComponentResult2 < PlaceComponentResult) {
                PlaceComponentResult = PlaceComponentResult2;
            }
        }
        return PlaceComponentResult;
    }

    private void MyBillsEntityDataFactory(RecyclerView.Recycler recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(childAt) > i || this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(childAt) > i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.BuiltInFictitiousFunctionClassFactory) {
                for (int i2 = 0; i2 < this.moveToNextValue; i2++) {
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2].BuiltInFictitiousFunctionClassFactory.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.moveToNextValue; i3++) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0[i3].getErrorConfigVersion();
                }
            } else if (layoutParams.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.size() == 1) {
                return;
            } else {
                layoutParams.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion();
            }
            removeAndRecycleView(childAt, recycler);
        }
    }

    private void PlaceComponentResult(RecyclerView.Recycler recycler, int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(childAt) < i || this.BuiltInFictitiousFunctionClassFactory.moveToNextValue(childAt) < i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.BuiltInFictitiousFunctionClassFactory) {
                for (int i2 = 0; i2 < this.moveToNextValue; i2++) {
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2].BuiltInFictitiousFunctionClassFactory.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.moveToNextValue; i3++) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0[i3].BuiltInFictitiousFunctionClassFactory();
                }
            } else if (layoutParams.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.size() == 1) {
                return;
            } else {
                layoutParams.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
            }
            removeAndRecycleView(childAt, recycler);
        }
    }

    private boolean moveToNextValue(int i) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 0) {
            return (i == -1) != this.getErrorConfigVersion;
        }
        return ((i == -1) == this.getErrorConfigVersion) == lookAheadTest();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return PlaceComponentResult(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return PlaceComponentResult(i, recycler, state);
    }

    private int MyBillsEntityDataFactory(int i) {
        if (getChildCount() == 0) {
            return this.getErrorConfigVersion ? 1 : -1;
        }
        return (i < (getChildCount() != 0 ? getPosition(getChildAt(0)) : 0)) == this.getErrorConfigVersion ? 1 : -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        int MyBillsEntityDataFactory = MyBillsEntityDataFactory(i);
        PointF pointF = new PointF();
        if (MyBillsEntityDataFactory == 0) {
            return null;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 0) {
            pointF.x = MyBillsEntityDataFactory;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = MyBillsEntityDataFactory;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        SavedState savedState = this.PrepareContext;
        if (savedState != null && savedState.BuiltInFictitiousFunctionClassFactory != i) {
            SavedState savedState2 = this.PrepareContext;
            savedState2.moveToNextValue = null;
            savedState2.lookAheadTest = 0;
            savedState2.BuiltInFictitiousFunctionClassFactory = -1;
            savedState2.getErrorConfigVersion = -1;
        }
        this.getAuthRequestContext = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int PlaceComponentResult;
        int i3;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(i, state);
        int[] iArr = this.newProxyInstance;
        if (iArr == null || iArr.length < this.moveToNextValue) {
            this.newProxyInstance = new int[this.moveToNextValue];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.moveToNextValue; i5++) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.KClassImpl$Data$declaredNonStaticMembers$2 == -1) {
                PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl;
                i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i5].KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl);
            } else {
                PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i5].PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory);
                i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory;
            }
            int i6 = PlaceComponentResult - i3;
            if (i6 >= 0) {
                this.newProxyInstance[i4] = i6;
                i4++;
            }
        }
        Arrays.sort(this.newProxyInstance, 0, i4);
        for (int i7 = 0; i7 < i4 && this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext(state); i7++) {
            layoutPrefetchRegistry.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory, this.newProxyInstance[i7]);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory += this.NetworkUserEntityData$$ExternalSyntheticLambda7.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    private int PlaceComponentResult(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(i, state);
        int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(recycler, this.NetworkUserEntityData$$ExternalSyntheticLambda7, state);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext >= KClassImpl$Data$declaredNonStaticMembers$2) {
            i = i < 0 ? -KClassImpl$Data$declaredNonStaticMembers$2 : KClassImpl$Data$declaredNonStaticMembers$2;
        }
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(-i);
        this.DatabaseTableConfigUtil = this.getErrorConfigVersion;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext = 0;
        PlaceComponentResult(recycler, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x003a, code lost:
    
        if (r10.NetworkUserEntityData$$ExternalSyntheticLambda8 != 1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003f, code lost:
    
        if (r10.NetworkUserEntityData$$ExternalSyntheticLambda8 != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x004b, code lost:
    
        if (lookAheadTest() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0056, code lost:
    
        if (lookAheadTest() != false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0146 A[LOOP:2: B:109:0x0146->B:118:0x0166, LOOP_START, PHI: r5
      0x0146: PHI (r5v1 int) = (r5v0 int), (r5v2 int) binds: [B:96:0x011c, B:118:0x0166] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011e  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onFocusSearchFailed(android.view.View r11, int r12, androidx.recyclerview.widget.RecyclerView.Recycler r13, androidx.recyclerview.widget.RecyclerView.State r14) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public boolean BuiltInFictitiousFunctionClassFactory;
        Span KClassImpl$Data$declaredNonStaticMembers$2;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final boolean BuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    /* loaded from: classes3.dex */
    public class Span {
        final int KClassImpl$Data$declaredNonStaticMembers$2;
        public ArrayList<View> BuiltInFictitiousFunctionClassFactory = new ArrayList<>();
        int PlaceComponentResult = Integer.MIN_VALUE;
        int getAuthRequestContext = Integer.MIN_VALUE;
        int MyBillsEntityDataFactory = 0;

        Span(int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }

        final int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            int i2 = this.PlaceComponentResult;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.BuiltInFictitiousFunctionClassFactory.size() == 0) {
                return i;
            }
            MyBillsEntityDataFactory();
            return this.PlaceComponentResult;
        }

        final void MyBillsEntityDataFactory() {
            LazySpanLookup.FullSpanItem authRequestContext;
            View view = this.BuiltInFictitiousFunctionClassFactory.get(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.PlaceComponentResult = StaggeredGridLayoutManager.this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(view);
            if (layoutParams.BuiltInFictitiousFunctionClassFactory && (authRequestContext = StaggeredGridLayoutManager.this.PlaceComponentResult.getAuthRequestContext(layoutParams.getViewLayoutPosition())) != null && authRequestContext.getAuthRequestContext == -1) {
                int i = this.PlaceComponentResult;
                int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int[] iArr = authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
                this.PlaceComponentResult = i - (iArr != null ? iArr[i2] : 0);
            }
        }

        final int PlaceComponentResult(int i) {
            int i2 = this.getAuthRequestContext;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.BuiltInFictitiousFunctionClassFactory.size() == 0) {
                return i;
            }
            KClassImpl$Data$declaredNonStaticMembers$2();
            return this.getAuthRequestContext;
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2() {
            LazySpanLookup.FullSpanItem authRequestContext;
            ArrayList<View> arrayList = this.BuiltInFictitiousFunctionClassFactory;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.getAuthRequestContext = StaggeredGridLayoutManager.this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(view);
            if (layoutParams.BuiltInFictitiousFunctionClassFactory && (authRequestContext = StaggeredGridLayoutManager.this.PlaceComponentResult.getAuthRequestContext(layoutParams.getViewLayoutPosition())) != null && authRequestContext.getAuthRequestContext == 1) {
                int i = this.getAuthRequestContext;
                int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int[] iArr = authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
                this.getAuthRequestContext = i + (iArr == null ? 0 : iArr[i2]);
            }
        }

        final void BuiltInFictitiousFunctionClassFactory() {
            int size = this.BuiltInFictitiousFunctionClassFactory.size();
            View remove = this.BuiltInFictitiousFunctionClassFactory.remove(size - 1);
            LayoutParams layoutParams = (LayoutParams) remove.getLayoutParams();
            layoutParams.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.MyBillsEntityDataFactory -= StaggeredGridLayoutManager.this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(remove);
            }
            if (size == 1) {
                this.PlaceComponentResult = Integer.MIN_VALUE;
            }
            this.getAuthRequestContext = Integer.MIN_VALUE;
        }

        final void getErrorConfigVersion() {
            View remove = this.BuiltInFictitiousFunctionClassFactory.remove(0);
            LayoutParams layoutParams = (LayoutParams) remove.getLayoutParams();
            layoutParams.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            if (this.BuiltInFictitiousFunctionClassFactory.size() == 0) {
                this.getAuthRequestContext = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.MyBillsEntityDataFactory -= StaggeredGridLayoutManager.this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(remove);
            }
            this.PlaceComponentResult = Integer.MIN_VALUE;
        }

        static LayoutParams BuiltInFictitiousFunctionClassFactory(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        final void MyBillsEntityDataFactory(int i) {
            int i2 = this.PlaceComponentResult;
            if (i2 != Integer.MIN_VALUE) {
                this.PlaceComponentResult = i2 + i;
            }
            int i3 = this.getAuthRequestContext;
            if (i3 != Integer.MIN_VALUE) {
                this.getAuthRequestContext = i3 + i;
            }
        }

        public final int PlaceComponentResult() {
            if (StaggeredGridLayoutManager.this.MyBillsEntityDataFactory) {
                return BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.size() - 1, -1, false, false, true);
            }
            return BuiltInFictitiousFunctionClassFactory(0, this.BuiltInFictitiousFunctionClassFactory.size(), false, false, true);
        }

        public final int getAuthRequestContext() {
            if (StaggeredGridLayoutManager.this.MyBillsEntityDataFactory) {
                return BuiltInFictitiousFunctionClassFactory(0, this.BuiltInFictitiousFunctionClassFactory.size(), false, false, true);
            }
            return BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.size() - 1, -1, false, false, true);
        }

        public final int BuiltInFictitiousFunctionClassFactory(int i, int i2, boolean z, boolean z2, boolean z3) {
            int moveToNextValue = StaggeredGridLayoutManager.this.BuiltInFictitiousFunctionClassFactory.moveToNextValue();
            int authRequestContext = StaggeredGridLayoutManager.this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.BuiltInFictitiousFunctionClassFactory.get(i);
                int authRequestContext2 = StaggeredGridLayoutManager.this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(view);
                int PlaceComponentResult = StaggeredGridLayoutManager.this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(view);
                boolean z4 = false;
                boolean z5 = !z3 ? authRequestContext2 >= authRequestContext : authRequestContext2 > authRequestContext;
                if (!z3 ? PlaceComponentResult > moveToNextValue : PlaceComponentResult >= moveToNextValue) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (authRequestContext2 >= moveToNextValue && PlaceComponentResult <= authRequestContext) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (z2) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    } else {
                        if (authRequestContext2 < moveToNextValue || PlaceComponentResult > authRequestContext) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        public final View KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.BuiltInFictitiousFunctionClassFactory.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.BuiltInFictitiousFunctionClassFactory.get(i3);
                    if ((StaggeredGridLayoutManager.this.MyBillsEntityDataFactory && StaggeredGridLayoutManager.this.getPosition(view2) <= i) || ((!StaggeredGridLayoutManager.this.MyBillsEntityDataFactory && StaggeredGridLayoutManager.this.getPosition(view2) >= i) || !view2.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
            } else {
                int size2 = this.BuiltInFictitiousFunctionClassFactory.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.BuiltInFictitiousFunctionClassFactory.get(size2);
                    if ((StaggeredGridLayoutManager.this.MyBillsEntityDataFactory && StaggeredGridLayoutManager.this.getPosition(view3) >= i) || ((!StaggeredGridLayoutManager.this.MyBillsEntityDataFactory && StaggeredGridLayoutManager.this.getPosition(view3) <= i) || !view3.hasFocusable())) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.BuiltInFictitiousFunctionClassFactory.add(view);
            this.getAuthRequestContext = Integer.MIN_VALUE;
            if (this.BuiltInFictitiousFunctionClassFactory.size() == 1) {
                this.PlaceComponentResult = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.MyBillsEntityDataFactory += StaggeredGridLayoutManager.this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(view);
            }
        }

        final void getAuthRequestContext(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.BuiltInFictitiousFunctionClassFactory.add(0, view);
            this.PlaceComponentResult = Integer.MIN_VALUE;
            if (this.BuiltInFictitiousFunctionClassFactory.size() == 1) {
                this.getAuthRequestContext = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.MyBillsEntityDataFactory += StaggeredGridLayoutManager.this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class LazySpanLookup {
        List<FullSpanItem> KClassImpl$Data$declaredNonStaticMembers$2;
        int[] PlaceComponentResult;

        LazySpanLookup() {
        }

        final int PlaceComponentResult(int i) {
            List<FullSpanItem> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2.get(size).PlaceComponentResult >= i) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2.remove(size);
                    }
                }
            }
            return BuiltInFictitiousFunctionClassFactory(i);
        }

        final int BuiltInFictitiousFunctionClassFactory(int i) {
            int[] iArr = this.PlaceComponentResult;
            if (iArr != null && i < iArr.length) {
                int MyBillsEntityDataFactory = MyBillsEntityDataFactory(i);
                if (MyBillsEntityDataFactory == -1) {
                    int[] iArr2 = this.PlaceComponentResult;
                    Arrays.fill(iArr2, i, iArr2.length, -1);
                    return this.PlaceComponentResult.length;
                }
                int min = Math.min(MyBillsEntityDataFactory + 1, this.PlaceComponentResult.length);
                Arrays.fill(this.PlaceComponentResult, i, min, -1);
                return min;
            }
            return -1;
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            int[] iArr = this.PlaceComponentResult;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.PlaceComponentResult = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int length = iArr.length;
                while (length <= i) {
                    length *= 2;
                }
                int[] iArr3 = new int[length];
                this.PlaceComponentResult = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.PlaceComponentResult;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
            int[] iArr = this.PlaceComponentResult;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            KClassImpl$Data$declaredNonStaticMembers$2(i3);
            int[] iArr2 = this.PlaceComponentResult;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.PlaceComponentResult;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            PlaceComponentResult(i, i2);
        }

        private void PlaceComponentResult(int i, int i2) {
            List<FullSpanItem> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.KClassImpl$Data$declaredNonStaticMembers$2.get(size);
                if (fullSpanItem.PlaceComponentResult >= i) {
                    if (fullSpanItem.PlaceComponentResult < i + i2) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2.remove(size);
                    } else {
                        fullSpanItem.PlaceComponentResult -= i2;
                    }
                }
            }
        }

        final void getAuthRequestContext(int i, int i2) {
            int[] iArr = this.PlaceComponentResult;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            KClassImpl$Data$declaredNonStaticMembers$2(i3);
            int[] iArr2 = this.PlaceComponentResult;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.PlaceComponentResult, i, i3, -1);
            BuiltInFictitiousFunctionClassFactory(i, i2);
        }

        private void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
            List<FullSpanItem> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.KClassImpl$Data$declaredNonStaticMembers$2.get(size);
                if (fullSpanItem.PlaceComponentResult >= i) {
                    fullSpanItem.PlaceComponentResult += i2;
                }
            }
        }

        private int MyBillsEntityDataFactory(int i) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return -1;
            }
            FullSpanItem authRequestContext = getAuthRequestContext(i);
            if (authRequestContext != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.remove(authRequestContext);
            }
            int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.get(i2).PlaceComponentResult >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                FullSpanItem fullSpanItem = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i2);
                this.KClassImpl$Data$declaredNonStaticMembers$2.remove(i2);
                return fullSpanItem.PlaceComponentResult;
            }
            return -1;
        }

        public final void PlaceComponentResult(FullSpanItem fullSpanItem) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
            }
            int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
                if (fullSpanItem2.PlaceComponentResult == fullSpanItem.PlaceComponentResult) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.remove(i);
                }
                if (fullSpanItem2.PlaceComponentResult >= fullSpanItem.PlaceComponentResult) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.add(i, fullSpanItem);
                    return;
                }
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.add(fullSpanItem);
        }

        public final FullSpanItem getAuthRequestContext(int i) {
            List<FullSpanItem> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.KClassImpl$Data$declaredNonStaticMembers$2.get(size);
                if (fullSpanItem.PlaceComponentResult == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public final FullSpanItem MyBillsEntityDataFactory(int i, int i2, int i3) {
            List<FullSpanItem> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i4);
                if (fullSpanItem.PlaceComponentResult >= i2) {
                    return null;
                }
                if (fullSpanItem.PlaceComponentResult >= i && (i3 == 0 || fullSpanItem.getAuthRequestContext == i3 || fullSpanItem.MyBillsEntityDataFactory)) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                @Override // android.os.Parcelable.Creator
                public /* synthetic */ FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                public /* bridge */ /* synthetic */ FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };
            int[] KClassImpl$Data$declaredNonStaticMembers$2;
            boolean MyBillsEntityDataFactory;
            int PlaceComponentResult;
            int getAuthRequestContext;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            FullSpanItem(Parcel parcel) {
                this.PlaceComponentResult = parcel.readInt();
                this.getAuthRequestContext = parcel.readInt();
                this.MyBillsEntityDataFactory = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            FullSpanItem() {
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.PlaceComponentResult);
                parcel.writeInt(this.getAuthRequestContext);
                parcel.writeInt(this.MyBillsEntityDataFactory ? 1 : 0);
                int[] iArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    return;
                }
                parcel.writeInt(0);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("FullSpanItem{mPosition=");
                sb.append(this.PlaceComponentResult);
                sb.append(", mGapDir=");
                sb.append(this.getAuthRequestContext);
                sb.append(", mHasUnwantedGapAfter=");
                sb.append(this.MyBillsEntityDataFactory);
                sb.append(", mGapPerSpan=");
                sb.append(Arrays.toString(this.KClassImpl$Data$declaredNonStaticMembers$2));
                sb.append('}');
                return sb.toString();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState.1
            @Override // android.os.Parcelable.Creator
            public /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        int[] NetworkUserEntityData$$ExternalSyntheticLambda0;
        boolean PlaceComponentResult;
        List<LazySpanLookup.FullSpanItem> getAuthRequestContext;
        int getErrorConfigVersion;
        int lookAheadTest;
        int[] moveToNextValue;
        int scheduleImpl;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.BuiltInFictitiousFunctionClassFactory = parcel.readInt();
            this.getErrorConfigVersion = parcel.readInt();
            int readInt = parcel.readInt();
            this.lookAheadTest = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.moveToNextValue = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.scheduleImpl = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.MyBillsEntityDataFactory = parcel.readInt() == 1;
            this.PlaceComponentResult = parcel.readInt() == 1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readInt() == 1;
            this.getAuthRequestContext = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.lookAheadTest = savedState.lookAheadTest;
            this.BuiltInFictitiousFunctionClassFactory = savedState.BuiltInFictitiousFunctionClassFactory;
            this.getErrorConfigVersion = savedState.getErrorConfigVersion;
            this.moveToNextValue = savedState.moveToNextValue;
            this.scheduleImpl = savedState.scheduleImpl;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = savedState.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.MyBillsEntityDataFactory = savedState.MyBillsEntityDataFactory;
            this.PlaceComponentResult = savedState.PlaceComponentResult;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = savedState.KClassImpl$Data$declaredNonStaticMembers$2;
            this.getAuthRequestContext = savedState.getAuthRequestContext;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.BuiltInFictitiousFunctionClassFactory);
            parcel.writeInt(this.getErrorConfigVersion);
            parcel.writeInt(this.lookAheadTest);
            if (this.lookAheadTest > 0) {
                parcel.writeIntArray(this.moveToNextValue);
            }
            parcel.writeInt(this.scheduleImpl);
            if (this.scheduleImpl > 0) {
                parcel.writeIntArray(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
            parcel.writeInt(this.MyBillsEntityDataFactory ? 1 : 0);
            parcel.writeInt(this.PlaceComponentResult ? 1 : 0);
            parcel.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2 ? 1 : 0);
            parcel.writeList(this.getAuthRequestContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class AnchorInfo {
        boolean BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        int PlaceComponentResult;
        int[] getAuthRequestContext;

        AnchorInfo() {
            getAuthRequestContext();
        }

        final void getAuthRequestContext() {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            this.PlaceComponentResult = Integer.MIN_VALUE;
            this.BuiltInFictitiousFunctionClassFactory = false;
            this.MyBillsEntityDataFactory = false;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            int[] iArr = this.getAuthRequestContext;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Span span, int i, int i2) {
        int i3 = span.MyBillsEntityDataFactory;
        if (i == -1) {
            int i4 = span.PlaceComponentResult;
            if (i4 == Integer.MIN_VALUE) {
                span.MyBillsEntityDataFactory();
                i4 = span.PlaceComponentResult;
            }
            if (i4 + i3 <= i2) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda4.set(span.KClassImpl$Data$declaredNonStaticMembers$2, false);
                return;
            }
            return;
        }
        int i5 = span.getAuthRequestContext;
        if (i5 == Integer.MIN_VALUE) {
            span.KClassImpl$Data$declaredNonStaticMembers$2();
            i5 = span.getAuthRequestContext;
        }
        if (i5 - i3 >= i2) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.set(span.KClassImpl$Data$declaredNonStaticMembers$2, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x035a A[LOOP:0: B:3:0x0003->B:179:0x035a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0362 A[SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler r13, androidx.recyclerview.widget.RecyclerView.State r14) {
        /*
            Method dump skipped, instructions count: 867
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(int i, RecyclerView.State state) {
        int position;
        int i2;
        if (i > 0) {
            int childCount = getChildCount();
            position = childCount != 0 ? getPosition(getChildAt(childCount - 1)) : 0;
            i2 = 1;
        } else {
            position = getChildCount() != 0 ? getPosition(getChildAt(0)) : 0;
            i2 = -1;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.getErrorConfigVersion = true;
        PlaceComponentResult(position, state);
        scheduleImpl(i2);
        LayoutState layoutState = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        layoutState.MyBillsEntityDataFactory = position + layoutState.KClassImpl$Data$declaredNonStaticMembers$2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext = Math.abs(i);
    }
}
