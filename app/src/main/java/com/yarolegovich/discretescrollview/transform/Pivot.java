package com.yarolegovich.discretescrollview.transform;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes8.dex */
public class Pivot {
    private int PlaceComponentResult;
    private int getAuthRequestContext;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Axis {
    }

    /* loaded from: classes8.dex */
    public enum X {
        LEFT { // from class: com.yarolegovich.discretescrollview.transform.Pivot.X.1
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.X
            public final Pivot create() {
                return new Pivot(0, 0);
            }
        },
        CENTER { // from class: com.yarolegovich.discretescrollview.transform.Pivot.X.2
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.X
            public final Pivot create() {
                return new Pivot(0, -1);
            }
        },
        RIGHT { // from class: com.yarolegovich.discretescrollview.transform.Pivot.X.3
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.X
            public final Pivot create() {
                return new Pivot(0, -2);
            }
        };

        public abstract Pivot create();
    }

    /* loaded from: classes8.dex */
    public enum Y {
        TOP { // from class: com.yarolegovich.discretescrollview.transform.Pivot.Y.1
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.Y
            public final Pivot create() {
                return new Pivot(1, 0);
            }
        },
        CENTER { // from class: com.yarolegovich.discretescrollview.transform.Pivot.Y.2
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.Y
            public final Pivot create() {
                return new Pivot(1, -1);
            }
        },
        BOTTOM { // from class: com.yarolegovich.discretescrollview.transform.Pivot.Y.3
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.Y
            public final Pivot create() {
                return new Pivot(1, -2);
            }
        };

        public abstract Pivot create();
    }

    public Pivot(int i, int i2) {
        this.PlaceComponentResult = i;
        this.getAuthRequestContext = i2;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = this.PlaceComponentResult;
        if (i == 0) {
            int i2 = this.getAuthRequestContext;
            if (i2 == -2) {
                view.setPivotX(view.getWidth());
            } else if (i2 == -1) {
                view.setPivotX(view.getWidth() * 0.5f);
            } else {
                view.setPivotX(i2);
            }
        } else if (i == 1) {
            int i3 = this.getAuthRequestContext;
            if (i3 == -2) {
                view.setPivotY(view.getHeight());
            } else if (i3 == -1) {
                view.setPivotY(view.getHeight() * 0.5f);
            } else {
                view.setPivotY(i3);
            }
        }
    }
}
