package com.zoloz.android.phone.zdoc.render;

import android.view.View;
import com.zoloz.android.phone.zdoc.R2;
import com.zoloz.android.phone.zdoc.ui.BaseMaskView;

/* loaded from: classes8.dex */
public class MaskViewRender extends BaseRender {
    private final BaseMaskView maskView;

    @Override // com.zoloz.android.phone.zdoc.render.BaseRender
    protected void renderBg() {
    }

    @Override // com.zoloz.android.phone.zdoc.render.BaseRender
    protected void renderLabel() {
    }

    public MaskViewRender(View view) {
        super(view);
        this.maskView = (BaseMaskView) view;
    }

    @Override // com.zoloz.android.phone.zdoc.render.BaseRender
    protected void renderColor() {
        this.maskView.setLineColor(R2.color.zdoc_line_color());
        this.maskView.setMaskColor(R2.color.zdoc_frame_bg_color());
    }
}
