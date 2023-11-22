package com.otaliastudios.cameraview.markers;

import android.content.res.TypedArray;
import com.otaliastudios.cameraview.R;

/* loaded from: classes2.dex */
public class MarkerParser {
    public AutoFocusMarker MyBillsEntityDataFactory;

    public MarkerParser(TypedArray typedArray) {
        this.MyBillsEntityDataFactory = null;
        String string = typedArray.getString(R.styleable.getErrorConfigVersion);
        if (string != null) {
            try {
                this.MyBillsEntityDataFactory = (AutoFocusMarker) Class.forName(string).newInstance();
            } catch (Exception unused) {
            }
        }
    }
}
