package id.dana.component.cellcomponent;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import id.dana.component.BaseRichView;
import id.dana.component.utils.SizeUtil;

/* loaded from: classes4.dex */
public abstract class BaseDanaCell extends BaseRichView {
    public static final int CELL_LEFT_ICON_LABEL = 2;
    public static final int CELL_LEFT_ICON_LABEL_DESC = 4;
    public static final int CELL_LEFT_ICON_LABEL_INDENT = 3;
    public static final int CELL_LEFT_LABEL = 0;
    public static final int CELL_LEFT_LABEL_DESC = 1;
    public static final int CELL_LEFT_LABEL_DESC_ICON_RIGHT = 8;
    public static final int CELL_LEFT_LABEL_ICON_RIGHT = 7;
    public static final int CELL_LEFT_LOGO_LABEL = 5;
    public static final int CELL_LEFT_LOGO_LABEL_DESC = 6;
    public static final int CELL_RIGHT_AMOUNT = 0;
    public static final int CELL_RIGHT_ARROW = 1;
    public static final int CELL_RIGHT_ARROW_CHIP = 5;
    public static final int CELL_RIGHT_ARROW_DANA = 6;
    public static final int CELL_RIGHT_ARROW_NOTIF = 3;
    public static final int CELL_RIGHT_ARROW_VALUE = 11;
    public static final int CELL_RIGHT_BUTTON = 2;
    public static final int CELL_RIGHT_CHIP = 4;
    public static final int CELL_RIGHT_ICON = 12;
    public static final int CELL_RIGHT_STEPPER = 8;
    public static final int CELL_RIGHT_SWITCH = 10;
    public static final int CELL_RIGHT_VALUE = 7;
    public static final int CELL_RIGHT_VALUE_DOUBLE = 9;

    public BaseDanaCell(Context context) {
        super(context);
    }

    public BaseDanaCell(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseDanaCell(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public BaseDanaCell(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setPaddingCell(ConstraintLayout constraintLayout, int i) {
        constraintLayout.setPadding(i, 0, SizeUtil.PlaceComponentResult(16), 0);
    }

    public void setSmallCell(ConstraintLayout constraintLayout) {
        constraintLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, SizeUtil.PlaceComponentResult(44)));
    }

    public void vallidateSmallCell(ConstraintLayout constraintLayout, boolean z) {
        if (z) {
            setSmallCell(constraintLayout);
        }
    }
}
