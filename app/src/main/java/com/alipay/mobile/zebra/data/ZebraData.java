package com.alipay.mobile.zebra.data;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.alipay.mobile.zebra.Zebra;
import com.alipay.mobile.zebra.ZebraLoader;
import com.alipay.mobile.zebra.core.ZebraCompat;
import com.alipay.mobile.zebra.core.ZebraOption;
import com.alipay.mobile.zebra.layout.ZebraLayout;
import com.alipay.mobile.zebra.utils.ZebraUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public abstract class ZebraData<T extends ZebraLayout> {
    public static final String ATTR_BACKGROUND = "background";
    public static final String ATTR_BG_COLOR = "background-color";
    public static final String ATTR_BORDER_COLOR = "border-color";
    public static final String ATTR_BORDER_RADIUS = "border-radius";
    public static final String ATTR_BORDER_WIDTH = "border-width";
    public static final String ATTR_BOTTOM = "bottom";
    public static final String ATTR_CLICKABLE = "clickable";
    public static final String ATTR_HEIGHT = "height";
    public static final String ATTR_ID = "id";
    public static final String ATTR_LEFT = "left";
    public static final String ATTR_PADDING = "padding";
    public static final String ATTR_PADDING_BOTTOM = "padding-bottom";
    public static final String ATTR_PADDING_LEFT = "padding-left";
    public static final String ATTR_PADDING_RIGHT = "padding-right";
    public static final String ATTR_PADDING_TOP = "padding-top";
    public static final String ATTR_RIGHT = "right";
    public static final String ATTR_STYLE = "style";
    public static final String ATTR_TOP = "top";
    public static final String ATTR_WIDTH = "width";
    protected String mBackground;
    protected String mBackgroundColor;
    protected String mBorderColor;
    protected boolean mClickable;
    protected String mId;
    public T mLayoutContext;
    protected Zebra.OnLoadCallback mOnLoadCallback;
    protected volatile boolean mOnLoaded;
    protected Zebra.OnUpdateCallback mOnUpdateCallback;
    protected ZebraData<? extends ZebraLayout> mParent;
    public boolean mReady;
    protected List<ZebraData> mChildren = new ArrayList();
    protected Map<String, String> mAttributeMap = new HashMap();
    protected float mWidth = -1.0f;
    protected float mHeight = -1.0f;
    protected float mPercentWidth = -1.0f;
    protected float mPercentHeight = -1.0f;
    protected float mLeft = -1.0f;
    protected float mTop = -1.0f;
    protected float mRight = -1.0f;
    protected float mBottom = -1.0f;
    protected float mPercentLeft = -1.0f;
    protected float mPercentTop = -1.0f;
    protected float mPercentRight = -1.0f;
    protected float mPercentBottom = -1.0f;
    protected float mPadding = -1.0f;
    protected float mPaddingLeft = -1.0f;
    protected float mPaddingTop = -1.0f;
    protected float mPaddingRight = -1.0f;
    protected float mPaddingBottom = -1.0f;
    protected float mBorderRadius = -1.0f;
    protected float mBorderWidth = -1.0f;

    public boolean canUpdate() {
        return false;
    }

    public abstract View render(Context context);

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public void setWidth(float f) {
        this.mWidth = f;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public void setHeight(float f) {
        this.mHeight = f;
    }

    public float getPercentWidth() {
        return this.mPercentWidth;
    }

    public void setPercentWidth(float f) {
        this.mPercentWidth = f;
    }

    public float getPercentHeight() {
        return this.mPercentHeight;
    }

    public void setPercentHeight(float f) {
        this.mPercentHeight = f;
    }

    public float getLeft() {
        return this.mLeft;
    }

    public void setLeft(float f) {
        this.mLeft = f;
    }

    public float getTop() {
        return this.mTop;
    }

    public void setTop(float f) {
        this.mTop = f;
    }

    public float getRight() {
        return this.mRight;
    }

    public void setRight(float f) {
        this.mRight = f;
    }

    public float getBottom() {
        return this.mBottom;
    }

    public void setBottom(float f) {
        this.mBottom = f;
    }

    public float getPercentLeft() {
        return this.mPercentLeft;
    }

    public void setPercentLeft(float f) {
        this.mPercentLeft = f;
    }

    public float getPercentTop() {
        return this.mPercentTop;
    }

    public void setPercentTop(float f) {
        this.mPercentTop = f;
    }

    public float getPercentRight() {
        return this.mPercentRight;
    }

    public void setPercentRight(float f) {
        this.mPercentRight = f;
    }

    public float getPercentBottom() {
        return this.mPercentBottom;
    }

    public void setPercentBottom(float f) {
        this.mPercentBottom = f;
    }

    public String getBackground() {
        return this.mBackground;
    }

    public void setBackground(String str) {
        this.mBackground = str;
    }

    public String getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public void setBackgroundColor(String str) {
        this.mBackgroundColor = str;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public void setPadding(float f) {
        this.mPadding = f;
    }

    public float getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public void setPaddingLeft(float f) {
        this.mPaddingLeft = f;
    }

    public float getPaddingTop() {
        return this.mPaddingTop;
    }

    public void setPaddingTop(float f) {
        this.mPaddingTop = f;
    }

    public float getPaddingRight() {
        return this.mPaddingRight;
    }

    public void setPaddingRight(float f) {
        this.mPaddingRight = f;
    }

    public float getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public void setPaddingBottom(float f) {
        this.mPaddingBottom = f;
    }

    public String getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(String str) {
        this.mBorderColor = str;
    }

    public float getBorderRadius() {
        return this.mBorderRadius;
    }

    public void setBorderRadius(float f) {
        this.mBorderRadius = f;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setBorderWidth(float f) {
        this.mBorderWidth = f;
    }

    public boolean isClickable() {
        return this.mClickable;
    }

    public void setClickable(boolean z) {
        this.mClickable = z;
    }

    public ZebraData<? extends ZebraLayout> getParent() {
        return this.mParent;
    }

    public void setParent(ZebraData<? extends ZebraLayout> zebraData) {
        this.mParent = zebraData;
    }

    public Zebra.OnLoadCallback getOnLoadCallback() {
        return this.mOnLoadCallback;
    }

    public void setOnLoadCallback(Zebra.OnLoadCallback onLoadCallback) {
        this.mOnLoadCallback = onLoadCallback;
    }

    public Zebra.OnUpdateCallback getOnUpdateCallback() {
        return this.mOnUpdateCallback;
    }

    public void setOnUpdateCallback(Zebra.OnUpdateCallback onUpdateCallback) {
        this.mOnUpdateCallback = onUpdateCallback;
    }

    public void add(ZebraData zebraData) {
        this.mChildren.add(zebraData);
        zebraData.mParent = this;
    }

    public void remove(ZebraData zebraData) {
        this.mChildren.remove(zebraData);
        zebraData.mParent = null;
    }

    public List<ZebraData> getChildren() {
        return this.mChildren;
    }

    public String getAttribute(String str) {
        return this.mAttributeMap.get(str);
    }

    public T getLayoutContext() {
        return this.mLayoutContext;
    }

    public void setLayoutContext(T t) {
        this.mLayoutContext = t;
    }

    public void fromDSL(AttributeSet attributeSet, ZebraOption zebraOption) {
        String key;
        boolean z = zebraOption != null && zebraOption.isCompatCamelName();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = attributeSet.getAttributeName(i);
            String attributeValue = attributeSet.getAttributeValue(i);
            if (ATTR_STYLE.equals(attributeName)) {
                for (Map.Entry<String, String> entry : ZebraCompat.unpackStyle(attributeValue).entrySet()) {
                    Map<String, String> map = this.mAttributeMap;
                    if (z) {
                        key = ZebraCompat.wrapCamelName(entry.getKey());
                    } else {
                        key = entry.getKey();
                    }
                    map.put(key, entry.getValue());
                }
            } else {
                Map<String, String> map2 = this.mAttributeMap;
                if (z) {
                    attributeName = ZebraCompat.wrapCamelName(attributeName);
                }
                map2.put(attributeName, attributeValue);
            }
        }
        this.mId = this.mAttributeMap.get("id");
        String str = this.mAttributeMap.get(ATTR_WIDTH);
        if (str != null) {
            if (ZebraUtils.endWiths(str, '%')) {
                float parseFloat = ZebraUtils.parseFloat(str.substring(0, str.length() - 1), -1.0f);
                if (parseFloat != -1.0f) {
                    this.mPercentWidth = parseFloat / 100.0f;
                }
            } else {
                float parseFloat2 = ZebraUtils.parseFloat(str, -1.0f);
                if (parseFloat2 != -1.0f) {
                    this.mWidth = parseFloat2;
                }
            }
        }
        String str2 = this.mAttributeMap.get(ATTR_HEIGHT);
        if (str2 != null) {
            if (ZebraUtils.endWiths(str2, '%')) {
                float parseFloat3 = ZebraUtils.parseFloat(str2.substring(0, str2.length() - 1), -1.0f);
                if (parseFloat3 != -1.0f) {
                    this.mPercentHeight = parseFloat3 / 100.0f;
                }
            } else {
                float parseFloat4 = ZebraUtils.parseFloat(str2, -1.0f);
                if (parseFloat4 != -1.0f) {
                    this.mHeight = parseFloat4;
                }
            }
        }
        String str3 = this.mAttributeMap.get("left");
        if (str3 != null) {
            if (ZebraUtils.endWiths(str3, '%')) {
                float parseFloat5 = ZebraUtils.parseFloat(str3.substring(0, str3.length() - 1), -1.0f);
                if (parseFloat5 != -1.0f) {
                    this.mPercentLeft = parseFloat5 / 100.0f;
                }
            } else {
                float parseFloat6 = ZebraUtils.parseFloat(str3, -1.0f);
                if (parseFloat6 != -1.0f) {
                    this.mLeft = parseFloat6;
                }
            }
        }
        String str4 = this.mAttributeMap.get("top");
        if (str4 != null) {
            if (ZebraUtils.endWiths(str4, '%')) {
                float parseFloat7 = ZebraUtils.parseFloat(str4.substring(0, str4.length() - 1), -1.0f);
                if (parseFloat7 != -1.0f) {
                    this.mPercentTop = parseFloat7 / 100.0f;
                }
            } else {
                float parseFloat8 = ZebraUtils.parseFloat(str4, -1.0f);
                if (parseFloat8 != -1.0f) {
                    this.mTop = parseFloat8;
                }
            }
        }
        String str5 = this.mAttributeMap.get("right");
        if (str5 != null) {
            if (ZebraUtils.endWiths(str5, '%')) {
                float parseFloat9 = ZebraUtils.parseFloat(str5.substring(0, str5.length() - 1), -1.0f);
                if (parseFloat9 != -1.0f) {
                    this.mPercentRight = parseFloat9 / 100.0f;
                }
            } else {
                float parseFloat10 = ZebraUtils.parseFloat(str5, -1.0f);
                if (parseFloat10 != -1.0f) {
                    this.mRight = parseFloat10;
                }
            }
        }
        String str6 = this.mAttributeMap.get("bottom");
        if (str6 != null) {
            if (ZebraUtils.endWiths(str6, '%')) {
                float parseFloat11 = ZebraUtils.parseFloat(str6.substring(0, str6.length() - 1), -1.0f);
                if (parseFloat11 != -1.0f) {
                    this.mPercentBottom = parseFloat11 / 100.0f;
                }
            } else {
                float parseFloat12 = ZebraUtils.parseFloat(str6, -1.0f);
                if (parseFloat12 != -1.0f) {
                    this.mBottom = parseFloat12;
                }
            }
        }
        this.mBackground = this.mAttributeMap.get(ATTR_BACKGROUND);
        this.mBackgroundColor = this.mAttributeMap.get(ATTR_BG_COLOR);
        String str7 = this.mAttributeMap.get(ATTR_PADDING);
        if (str7 != null) {
            float parseFloat13 = ZebraUtils.parseFloat(str7, -1.0f);
            if (parseFloat13 != -1.0f) {
                this.mPadding = parseFloat13;
            }
        }
        String str8 = this.mAttributeMap.get(ATTR_PADDING_LEFT);
        if (str8 != null) {
            float parseFloat14 = ZebraUtils.parseFloat(str8, -1.0f);
            if (parseFloat14 != -1.0f) {
                this.mPaddingLeft = parseFloat14;
            }
        }
        String str9 = this.mAttributeMap.get(ATTR_PADDING_TOP);
        if (str9 != null) {
            float parseFloat15 = ZebraUtils.parseFloat(str9, -1.0f);
            if (parseFloat15 != -1.0f) {
                this.mPaddingTop = parseFloat15;
            }
        }
        String str10 = this.mAttributeMap.get(ATTR_PADDING_RIGHT);
        if (str10 != null) {
            float parseFloat16 = ZebraUtils.parseFloat(str10, -1.0f);
            if (parseFloat16 != -1.0f) {
                this.mPaddingRight = parseFloat16;
            }
        }
        String str11 = this.mAttributeMap.get(ATTR_PADDING_BOTTOM);
        if (str11 != null) {
            float parseFloat17 = ZebraUtils.parseFloat(str11, -1.0f);
            if (parseFloat17 != -1.0f) {
                this.mPaddingBottom = parseFloat17;
            }
        }
        this.mBorderColor = this.mAttributeMap.get(ATTR_BORDER_COLOR);
        String str12 = this.mAttributeMap.get(ATTR_BORDER_RADIUS);
        if (str12 != null) {
            float parseFloat18 = ZebraUtils.parseFloat(str12, -1.0f);
            if (parseFloat18 != -1.0f) {
                this.mBorderRadius = parseFloat18;
            }
        }
        String str13 = this.mAttributeMap.get(ATTR_BORDER_WIDTH);
        if (str13 != null) {
            float parseFloat19 = ZebraUtils.parseFloat(str13, -1.0f);
            if (parseFloat19 != -1.0f) {
                this.mBorderWidth = parseFloat19;
            }
        }
        String str14 = this.mAttributeMap.get(ATTR_CLICKABLE);
        if (str14 != null) {
            this.mClickable = Boolean.valueOf(str14).booleanValue();
        }
    }

    protected boolean isAllChildrenLoaded() {
        if (this.mChildren.size() == 0) {
            return true;
        }
        Iterator<ZebraData> it = this.mChildren.iterator();
        while (it.hasNext()) {
            if (!it.next().mOnLoaded) {
                return false;
            }
        }
        return true;
    }

    public void fireLoadedEvent() {
        if (!this.mOnLoaded && isAllChildrenLoaded()) {
            this.mOnLoaded = true;
            Zebra.OnLoadCallback onLoadCallback = this.mOnLoadCallback;
            if (onLoadCallback != null) {
                T t = this.mLayoutContext;
                onLoadCallback.onLoad(t != null ? t.getRenderContext() : null, this, this.mLayoutContext);
            }
            ZebraData<? extends ZebraLayout> zebraData = this.mParent;
            if (zebraData != null) {
                zebraData.notifyChildLoaded(this);
            }
        }
    }

    public void notifyChildLoaded(ZebraData<? extends ZebraLayout> zebraData) {
        if (this.mChildren.contains(zebraData) && isAllChildrenLoaded()) {
            fireLoadedEvent();
        }
    }

    public void loadResource(ZebraLoader zebraLoader) {
        this.mReady = true;
        if (this.mChildren.size() == 0) {
            fireLoadedEvent();
            return;
        }
        Iterator<ZebraData> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().loadResource(zebraLoader);
        }
    }

    public boolean isReady() {
        return this.mReady;
    }
}
