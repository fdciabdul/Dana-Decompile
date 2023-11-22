package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes7.dex */
public class FlexboxItemDecoration extends RecyclerView.ItemDecoration {
    public static final int BOTH = 3;
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    private Drawable mDrawable;
    private int mOrientation;
    public static final byte[] PlaceComponentResult = {109, -87, 105, -77, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 60;
    private static final int[] LIST_DIVIDER_ATTRS = {16843284};

    public FlexboxItemDecoration(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(LIST_DIVIDER_ATTRS);
        this.mDrawable = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 0);
        obtainStyledAttributes.recycle();
        setOrientation(3);
    }

    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.mDrawable = drawable;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        drawHorizontalDecorations(canvas, recyclerView);
        drawVerticalDecorations(canvas, recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            return;
        }
        if (!needsHorizontalDecoration() && !needsVerticalDecoration()) {
            rect.set(0, 0, 0, 0);
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
        List<FlexLine> flexLines = flexboxLayoutManager.getFlexLines();
        setOffsetAlongMainAxis(rect, childAdapterPosition, flexboxLayoutManager, flexLines, flexboxLayoutManager.getFlexDirection());
        setOffsetAlongCrossAxis(rect, childAdapterPosition, flexboxLayoutManager, flexLines);
    }

    private void setOffsetAlongCrossAxis(Rect rect, int i, FlexboxLayoutManager flexboxLayoutManager, List<FlexLine> list) {
        if (list.size() == 0 || flexboxLayoutManager.getPositionToFlexLineIndex(i) == 0) {
            return;
        }
        if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
            if (!needsHorizontalDecoration()) {
                rect.top = 0;
                rect.bottom = 0;
                return;
            }
            rect.top = this.mDrawable.getIntrinsicHeight();
            rect.bottom = 0;
        } else if (needsVerticalDecoration()) {
            if (flexboxLayoutManager.isLayoutRtl()) {
                rect.right = this.mDrawable.getIntrinsicWidth();
                rect.left = 0;
                return;
            }
            rect.left = this.mDrawable.getIntrinsicWidth();
            rect.right = 0;
        }
    }

    private void setOffsetAlongMainAxis(Rect rect, int i, FlexboxLayoutManager flexboxLayoutManager, List<FlexLine> list, int i2) {
        if (isFirstItemInLine(i, list, flexboxLayoutManager)) {
            return;
        }
        if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
            if (!needsVerticalDecoration()) {
                rect.left = 0;
                rect.right = 0;
            } else if (flexboxLayoutManager.isLayoutRtl()) {
                rect.right = this.mDrawable.getIntrinsicWidth();
                rect.left = 0;
            } else {
                rect.left = this.mDrawable.getIntrinsicWidth();
                rect.right = 0;
            }
        } else if (!needsHorizontalDecoration()) {
            rect.top = 0;
            rect.bottom = 0;
        } else if (i2 == 3) {
            rect.bottom = this.mDrawable.getIntrinsicHeight();
            rect.top = 0;
        } else {
            rect.top = this.mDrawable.getIntrinsicHeight();
            rect.bottom = 0;
        }
    }

    private void drawVerticalDecorations(Canvas canvas, RecyclerView recyclerView) {
        int left;
        int intrinsicWidth;
        FlexboxLayoutManager flexboxLayoutManager;
        int max;
        int bottom;
        int i;
        int min;
        int top;
        if (needsVerticalDecoration()) {
            FlexboxLayoutManager flexboxLayoutManager2 = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int top2 = recyclerView.getTop();
            int paddingTop = recyclerView.getPaddingTop();
            int bottom2 = recyclerView.getBottom();
            int paddingBottom = recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            int flexDirection = flexboxLayoutManager2.getFlexDirection();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = recyclerView.getChildAt(i2);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexboxLayoutManager2.isLayoutRtl()) {
                    intrinsicWidth = childAt.getRight() + layoutParams.rightMargin;
                    left = this.mDrawable.getIntrinsicWidth() + intrinsicWidth;
                } else {
                    left = childAt.getLeft() - layoutParams.leftMargin;
                    intrinsicWidth = left - this.mDrawable.getIntrinsicWidth();
                }
                if (flexboxLayoutManager2.isMainAxisDirectionHorizontal()) {
                    max = childAt.getTop() - layoutParams.topMargin;
                    bottom = childAt.getBottom();
                    i = layoutParams.bottomMargin;
                    flexboxLayoutManager = flexboxLayoutManager2;
                } else if (flexDirection == 3) {
                    flexboxLayoutManager = flexboxLayoutManager2;
                    min = Math.min(childAt.getBottom() + layoutParams.bottomMargin + this.mDrawable.getIntrinsicHeight(), bottom2 + paddingBottom);
                    top = childAt.getTop() - layoutParams.topMargin;
                    this.mDrawable.setBounds(intrinsicWidth, top, left, min);
                    this.mDrawable.draw(canvas);
                    i2++;
                    flexboxLayoutManager2 = flexboxLayoutManager;
                } else {
                    flexboxLayoutManager = flexboxLayoutManager2;
                    max = Math.max((childAt.getTop() - layoutParams.topMargin) - this.mDrawable.getIntrinsicHeight(), top2 - paddingTop);
                    bottom = childAt.getBottom();
                    i = layoutParams.bottomMargin;
                }
                min = bottom + i;
                top = max;
                this.mDrawable.setBounds(intrinsicWidth, top, left, min);
                this.mDrawable.draw(canvas);
                i2++;
                flexboxLayoutManager2 = flexboxLayoutManager;
            }
        }
    }

    private void drawHorizontalDecorations(Canvas canvas, RecyclerView recyclerView) {
        int top;
        int intrinsicHeight;
        FlexboxLayoutManager flexboxLayoutManager;
        int left;
        int right;
        int i;
        int i2;
        int i3;
        if (needsHorizontalDecoration()) {
            FlexboxLayoutManager flexboxLayoutManager2 = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int flexDirection = flexboxLayoutManager2.getFlexDirection();
            int left2 = recyclerView.getLeft();
            int paddingLeft = recyclerView.getPaddingLeft();
            int right2 = recyclerView.getRight();
            int paddingRight = recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            int i4 = 0;
            while (i4 < childCount) {
                View childAt = recyclerView.getChildAt(i4);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    intrinsicHeight = childAt.getBottom() + layoutParams.bottomMargin;
                    top = this.mDrawable.getIntrinsicHeight() + intrinsicHeight;
                } else {
                    top = childAt.getTop() - layoutParams.topMargin;
                    intrinsicHeight = top - this.mDrawable.getIntrinsicHeight();
                }
                if (flexboxLayoutManager2.isMainAxisDirectionHorizontal()) {
                    if (flexboxLayoutManager2.isLayoutRtl()) {
                        flexboxLayoutManager = flexboxLayoutManager2;
                        i3 = Math.min(childAt.getRight() + layoutParams.rightMargin + this.mDrawable.getIntrinsicWidth(), right2 + paddingRight);
                        i2 = childAt.getLeft() - layoutParams.leftMargin;
                        this.mDrawable.setBounds(i2, intrinsicHeight, i3, top);
                        this.mDrawable.draw(canvas);
                        i4++;
                        flexboxLayoutManager2 = flexboxLayoutManager;
                    } else {
                        flexboxLayoutManager = flexboxLayoutManager2;
                        left = Math.max((childAt.getLeft() - layoutParams.leftMargin) - this.mDrawable.getIntrinsicWidth(), left2 - paddingLeft);
                        right = childAt.getRight();
                        i = layoutParams.rightMargin;
                    }
                } else {
                    flexboxLayoutManager = flexboxLayoutManager2;
                    left = childAt.getLeft() - layoutParams.leftMargin;
                    right = childAt.getRight();
                    i = layoutParams.rightMargin;
                }
                int i5 = right + i;
                i2 = left;
                i3 = i5;
                this.mDrawable.setBounds(i2, intrinsicHeight, i3, top);
                this.mDrawable.draw(canvas);
                i4++;
                flexboxLayoutManager2 = flexboxLayoutManager;
            }
        }
    }

    private boolean needsHorizontalDecoration() {
        return (this.mOrientation & 1) > 0;
    }

    private boolean needsVerticalDecoration() {
        return (this.mOrientation & 2) > 0;
    }

    private boolean isFirstItemInLine(int i, List<FlexLine> list, FlexboxLayoutManager flexboxLayoutManager) {
        int positionToFlexLineIndex = flexboxLayoutManager.getPositionToFlexLineIndex(i);
        if ((positionToFlexLineIndex == -1 || positionToFlexLineIndex >= flexboxLayoutManager.getFlexLinesInternal().size() || flexboxLayoutManager.getFlexLinesInternal().get(positionToFlexLineIndex).mFirstIndex != i) && i != 0) {
            return list.size() != 0 && list.get(list.size() - 1).mLastIndex == i - 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003f -> B:15:0x0046). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r11, int r12) {
        /*
            byte[] r0 = com.google.android.flexbox.FlexboxItemDecoration.PlaceComponentResult
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 0
            r4 = 97
            r5 = 4
            if (r0 != 0) goto L15
            r5 = r2
            r6 = 23
            r7 = 4
            r9 = 0
            r2 = r0
            r0 = r12
            r12 = r11
            goto L46
        L15:
            r4 = r2
            r5 = 97
            r6 = 4
            r7 = 0
            r2 = r0
            r0 = r12
            r12 = r11
        L1d:
            byte r8 = (byte) r5
            int r9 = r7 + 1
            r4[r7] = r8
            if (r9 != r1) goto L3f
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4, r3)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r11 = r1.isInstance(r11)
            if (r11 == 0) goto L3a
            android.content.Context r12 = (android.content.Context) r12
            android.graphics.drawable.Drawable r11 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r12, r0)
            return r11
        L3a:
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r0)
            return r11
        L3f:
            r7 = r2[r6]
            r10 = r5
            r5 = r4
            r4 = r7
            r7 = r6
            r6 = r10
        L46:
            int r4 = -r4
            int r6 = r6 + r4
            int r4 = r7 + 1
            int r6 = r6 + (-8)
            r7 = r9
            r10 = r6
            r6 = r4
            r4 = r5
            r5 = r10
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxItemDecoration.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
