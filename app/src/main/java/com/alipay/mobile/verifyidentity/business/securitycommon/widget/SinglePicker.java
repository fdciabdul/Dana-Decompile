package com.alipay.mobile.verifyidentity.business.securitycommon.widget;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class SinglePicker<T> extends WheelPicker {
    private static final int ITEM_WIDTH_UNKNOWN = -99;
    private List<String> itemStrings;
    private int itemWidth;
    private List<T> items;
    private String label;
    private OnItemPickListener<T> onItemPickListener;
    private OnWheelListener<T> onWheelListener;
    private int selectedItemIndex;
    private WheelView wheelView;

    /* loaded from: classes7.dex */
    public interface OnItemPickListener<T> {
        void onItemPicked(int i, T t);
    }

    /* loaded from: classes7.dex */
    public interface OnWheelListener<T> {
        void onWheeled(int i, T t);
    }

    public SinglePicker(Activity activity, T[] tArr) {
        this(activity, Arrays.asList(tArr));
    }

    public SinglePicker(Activity activity, List<T> list) {
        super(activity);
        this.items = new ArrayList();
        this.itemStrings = new ArrayList();
        this.selectedItemIndex = 0;
        this.label = "";
        this.itemWidth = -99;
        setItems(list);
    }

    public List<T> getItems() {
        return this.items;
    }

    public void addItem(T t) {
        this.items.add(t);
        this.itemStrings.add(formatToString(t));
    }

    public void removeItem(T t) {
        this.items.remove(t);
        this.itemStrings.remove(formatToString(t));
    }

    public void setItems(T[] tArr) {
        setItems(Arrays.asList(tArr));
    }

    public void setItems(List<T> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.items.clear();
        this.items.addAll(list);
        this.itemStrings.clear();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.itemStrings.add(formatToString(it.next()));
        }
        WheelView wheelView = this.wheelView;
        if (wheelView != null) {
            wheelView.setItems(this.itemStrings, this.selectedItemIndex);
        }
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setSelectedIndex(int i) {
        if (i < 0 || i >= this.items.size()) {
            return;
        }
        this.selectedItemIndex = i;
    }

    public void setSelectedItem(T t) {
        setSelectedIndex(this.itemStrings.indexOf(formatToString(t)));
    }

    public void setItemWidth(int i) {
        WheelView wheelView = this.wheelView;
        if (wheelView != null) {
            ViewGroup.LayoutParams layoutParams = wheelView.getLayoutParams();
            layoutParams.width = ConvertUtils.toPx(this.activity, i);
            this.wheelView.setLayoutParams(layoutParams);
            return;
        }
        this.itemWidth = i;
    }

    public void setOnWheelListener(OnWheelListener<T> onWheelListener) {
        this.onWheelListener = onWheelListener;
    }

    public void setOnItemPickListener(OnItemPickListener<T> onItemPickListener) {
        this.onItemPickListener = onItemPickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConfirmPopup
    public View makeCenterView() {
        if (this.items.size() == 0) {
            throw new IllegalArgumentException("Items can't be empty");
        }
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        WheelView createWheelView = createWheelView();
        this.wheelView = createWheelView;
        linearLayout.addView(createWheelView);
        if (TextUtils.isEmpty(this.label)) {
            this.wheelView.setLayoutParams(new LinearLayout.LayoutParams(this.screenWidthPixels, -2));
        } else {
            this.wheelView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            TextView createLabelView = createLabelView();
            createLabelView.setText(this.label);
            linearLayout.addView(createLabelView);
        }
        this.wheelView.setItems(this.itemStrings, this.selectedItemIndex);
        this.wheelView.setOnItemSelectListener(new WheelView.OnItemSelectListener() { // from class: com.alipay.mobile.verifyidentity.business.securitycommon.widget.SinglePicker.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView.OnItemSelectListener
            public void onSelected(int i) {
                SinglePicker.this.selectedItemIndex = i;
                if (SinglePicker.this.onWheelListener != null) {
                    SinglePicker.this.onWheelListener.onWheeled(SinglePicker.this.selectedItemIndex, SinglePicker.this.items.get(i));
                }
            }
        });
        if (this.itemWidth != -99) {
            ViewGroup.LayoutParams layoutParams = this.wheelView.getLayoutParams();
            layoutParams.width = ConvertUtils.toPx(this.activity, this.itemWidth);
            this.wheelView.setLayoutParams(layoutParams);
        }
        return linearLayout;
    }

    private String formatToString(T t) {
        if ((t instanceof Float) || (t instanceof Double)) {
            return new DecimalFormat("0.00").format(t);
        }
        return t.toString();
    }

    @Override // com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConfirmPopup
    public void onSubmit() {
        OnItemPickListener<T> onItemPickListener = this.onItemPickListener;
        if (onItemPickListener != null) {
            onItemPickListener.onItemPicked(this.selectedItemIndex, getSelectedItem());
        }
    }

    public T getSelectedItem() {
        return this.items.get(this.selectedItemIndex);
    }

    public int getSelectedIndex() {
        return this.selectedItemIndex;
    }

    public WheelView getWheelView() {
        return this.wheelView;
    }
}
