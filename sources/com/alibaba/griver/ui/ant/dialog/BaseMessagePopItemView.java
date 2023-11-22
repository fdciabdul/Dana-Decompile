package com.alibaba.griver.ui.ant.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.ui.ant.badge.AUBadgeView;
import com.alibaba.griver.ui.ant.layout.AULinearLayout;
import com.alibaba.griver.ui.ant.model.IconInfo;
import com.alibaba.griver.ui.ant.model.MessagePopItem;
import com.alibaba.griver.ui.ant.text.AUIconView;
import com.alibaba.griver.ui.ant.text.AUTextView;
import com.alibaba.griver.ui.ant.theme.AUAbsTheme;
import com.alibaba.griver.ui.ant.theme.AUThemeKey;
import com.alibaba.griver.ui.ant.theme.AUThemeManager;
import java.util.HashMap;

/* loaded from: classes6.dex */
public abstract class BaseMessagePopItemView extends AULinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f6680a;
    private boolean b;
    protected AUBadgeView mBadgeView;
    protected AUIconView mIconView;
    protected AUTextView mTitleView;

    protected abstract int getHorizonPadding(Context context);

    protected abstract void initView(Context context);

    public BaseMessagePopItemView(Context context) {
        super(context);
        this.b = false;
        initView(context);
        int horizonPadding = getHorizonPadding(context);
        this.f6680a = horizonPadding;
        setPadding(horizonPadding, 0, horizonPadding, 0);
    }

    public void setMakeTitleMax(boolean z) {
        this.b = z;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredWidth;
        if (this.b) {
            AUBadgeView aUBadgeView = this.mBadgeView;
            if (aUBadgeView != null && aUBadgeView.getVisibility() == 0) {
                int size = View.MeasureSpec.getSize(i);
                if (size != 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
                    int i3 = 0;
                    this.mBadgeView.measure(makeMeasureSpec, 0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBadgeView.getLayoutParams();
                    if (layoutParams != null) {
                        measuredWidth = this.mBadgeView.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                    } else {
                        measuredWidth = this.mBadgeView.getMeasuredWidth();
                    }
                    AUIconView aUIconView = this.mIconView;
                    if (aUIconView != null && aUIconView.getVisibility() == 0) {
                        this.mIconView.measure(makeMeasureSpec, 0);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mIconView.getLayoutParams();
                        if (layoutParams2 != null) {
                            i3 = this.mIconView.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin;
                        } else {
                            i3 = this.mIconView.getMeasuredWidth();
                        }
                    }
                    this.mTitleView.setMaxWidth(Math.max(((size - measuredWidth) - i3) - (this.f6680a * 2), (int) (this.mTitleView.getMeasuredWidth() + (this.mTitleView.getTextSize() * 2.0f))));
                } else {
                    this.mTitleView.setMaxWidth(Integer.MAX_VALUE);
                }
            } else {
                this.mTitleView.setMaxWidth(Integer.MAX_VALUE);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setPopItem(MessagePopItem messagePopItem) {
        if (messagePopItem == null || TextUtils.isEmpty(messagePopItem.title)) {
            return;
        }
        setTitleText(messagePopItem.title);
        a(this.mIconView, messagePopItem.icon);
        setBadgeInfo(messagePopItem.externParam);
    }

    public void setTitleText(CharSequence charSequence) {
        this.mTitleView.setText(charSequence);
    }

    public void setTitleTextSize(int i) {
        this.mTitleView.setTextSize(0, i);
    }

    public void setIconfontSize(int i) {
        this.mIconView.setIconfontSize(i);
        ViewGroup.LayoutParams layoutParams = this.mIconView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.mIconView.setLayoutParams(layoutParams);
    }

    public void setTitleTextColor(int i) {
        this.mTitleView.setTextColor(i);
    }

    private void a(AUIconView aUIconView, IconInfo iconInfo) {
        if (iconInfo == null) {
            aUIconView.setVisibility(8);
        } else if (iconInfo.type == 3) {
            if (iconInfo.iconRes != 0) {
                aUIconView.setImageResource(iconInfo.iconRes);
                aUIconView.setVisibility(0);
            } else if (iconInfo.drawable != null) {
                aUIconView.setImageDrawable(iconInfo.drawable);
                aUIconView.setVisibility(0);
            } else {
                aUIconView.setVisibility(8);
            }
        } else if (iconInfo.type == 2) {
            aUIconView.setVisibility(0);
            aUIconView.setIconfontUnicode(iconInfo.icon);
            AUAbsTheme currentTheme = AUThemeManager.getCurrentTheme();
            Integer color = currentTheme.getColor(getContext(), AUThemeKey.FLOATMENU_ICON_COLOR);
            if (color != null) {
                aUIconView.setIconfontColor(color.intValue());
            }
            Float dimension = currentTheme.getDimension(getContext(), AUThemeKey.FLOATMENU_ICON_SIZE);
            if (dimension != null) {
                aUIconView.setIconfontSize(dimension.floatValue());
            }
        } else {
            aUIconView.setVisibility(8);
        }
    }

    private void setBadgeInfo(HashMap<String, Object> hashMap) {
        try {
            this.mBadgeView.dismiss();
            if (hashMap != null) {
                Object obj = hashMap.get(AUBadgeView.KEY_BADGE_STYLE);
                if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                    this.mBadgeView.setVisibility(0);
                    if (obj.equals("msg_redpoint")) {
                        this.mBadgeView.setRedPoint(true);
                    } else if (obj.equals("msg_text")) {
                        this.mBadgeView.setStyleAndMsgText(AUBadgeView.Style.NUM, (String) hashMap.get(AUBadgeView.KEY_BADGE_CONTENT));
                    } else if (obj.equals("text")) {
                        this.mBadgeView.setStyleAndMsgText(AUBadgeView.Style.TEXT, (String) hashMap.get(AUBadgeView.KEY_BADGE_CONTENT));
                    }
                } else if (obj instanceof AUBadgeView.Style) {
                    this.mBadgeView.setStyleAndContent((AUBadgeView.Style) obj, (String) hashMap.get(AUBadgeView.KEY_BADGE_CONTENT));
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("setBadgeInfo ext : ");
            sb.append(th);
            RVLogger.e("BaseMessagePopItemView", sb.toString());
        }
    }
}
