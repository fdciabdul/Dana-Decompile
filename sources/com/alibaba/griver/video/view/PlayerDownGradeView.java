package com.alibaba.griver.video.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.alibaba.griver.video.R;

/* loaded from: classes6.dex */
public class PlayerDownGradeView extends RelativeLayout {
    public PlayerDownGradeView(Context context) {
        super(context);
        a(context);
    }

    public PlayerDownGradeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PlayerDownGradeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.grv_video_layout_bee_player_downgrade_view, this);
    }
}
