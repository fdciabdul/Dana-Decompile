package com.iap.ac.android.region.cdp.ui.badge;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.iap.ac.android.region.cdp.WalletCdpKit;
import com.iap.ac.android.region.cdp.util.CdpUtils;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class BadgeWrapperLayout extends RelativeLayout {
    public static final String TAG = CdpUtils.logTag("BadgeWrapperLayout");
    public boolean autoReportClick;
    public BadgeView badgeView;
    public boolean isModifiedClickable;
    public View vOriginView;

    public BadgeWrapperLayout(Context context) {
        this(context, null);
    }

    private void addBadgeToTopRight(BadgeView badgeView, Point point) {
        RelativeLayout.LayoutParams layoutParams;
        if (badgeView == null || badgeView.getParent() != null) {
            return;
        }
        this.badgeView = badgeView;
        if (badgeView.getLayoutParams() != null) {
            layoutParams = new RelativeLayout.LayoutParams(badgeView.getLayoutParams());
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(11);
        layoutParams.rightMargin -= (int) CdpUtils.dp2px(getContext(), point.x);
        layoutParams.topMargin += (int) CdpUtils.dp2px(getContext(), point.y);
        addView(badgeView, layoutParams);
    }

    public static BadgeWrapperLayout attachToRightTop(View view, String str, boolean z, Point point) {
        BadgeWrapperLayout wrapChild;
        if (view instanceof BadgeWrapperLayout) {
            wrapChild = (BadgeWrapperLayout) view;
        } else {
            wrapChild = wrapChild(view, z);
        }
        CdpUtils.removeChildWithClass(wrapChild, BadgeView.class);
        if (!TextUtils.isEmpty(str)) {
            initBadgeViewWithSpaceCode(wrapChild, str, point);
        }
        return wrapChild;
    }

    public static void initBadgeViewWithSpaceCode(BadgeWrapperLayout badgeWrapperLayout, String str, Point point) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        badgeWrapperLayout.addBadgeToTopRight(WalletCdpKit.getInstance().fetchBadgeViewWithCodes(badgeWrapperLayout.getContext(), arrayList, null).get(str), point);
    }

    public static void removeBadgeView(View view) {
        if (view instanceof BadgeWrapperLayout) {
            unwrapChild((BadgeWrapperLayout) view);
        }
    }

    public static void unwrapChild(BadgeWrapperLayout badgeWrapperLayout) {
        ViewGroup.LayoutParams layoutParams = badgeWrapperLayout.getLayoutParams();
        ViewParent parent = badgeWrapperLayout.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int indexOfChild = viewGroup.indexOfChild(badgeWrapperLayout);
            View view = badgeWrapperLayout.vOriginView;
            if (indexOfChild < 0 || view == null) {
                return;
            }
            if (badgeWrapperLayout.autoReportClick && badgeWrapperLayout.isModifiedClickable) {
                view.setClickable(true);
                badgeWrapperLayout.isModifiedClickable = false;
            }
            badgeWrapperLayout.removeView(view);
            viewGroup.removeViewAt(indexOfChild);
            viewGroup.addView(view, indexOfChild, layoutParams);
        }
    }

    public static BadgeWrapperLayout wrapChild(View view, boolean z) {
        BadgeWrapperLayout badgeWrapperLayout = new BadgeWrapperLayout(view.getContext());
        badgeWrapperLayout.vOriginView = view;
        badgeWrapperLayout.autoReportClick = z;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        badgeWrapperLayout.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        badgeWrapperLayout.addView(view, layoutParams2);
        if (z) {
            if (view.isClickable()) {
                view.setClickable(false);
                badgeWrapperLayout.isModifiedClickable = true;
            }
            badgeWrapperLayout.setOnClickListener(new View.OnClickListener() { // from class: com.iap.ac.android.region.cdp.ui.badge.BadgeWrapperLayout.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BadgeWrapperLayout.this.vOriginView.performClick();
                    if (BadgeWrapperLayout.this.badgeView != null) {
                        ViewParent parent = BadgeWrapperLayout.this.badgeView.getParent();
                        BadgeWrapperLayout badgeWrapperLayout2 = BadgeWrapperLayout.this;
                        if (parent == badgeWrapperLayout2) {
                            badgeWrapperLayout2.badgeView.reportClickAction();
                        }
                    }
                }
            });
        }
        return badgeWrapperLayout;
    }

    public BadgeWrapperLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
