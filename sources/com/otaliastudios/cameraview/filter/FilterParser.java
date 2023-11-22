package com.otaliastudios.cameraview.filter;

import android.content.res.TypedArray;
import com.otaliastudios.cameraview.R;

/* loaded from: classes2.dex */
public class FilterParser {
    public Filter getAuthRequestContext;

    public FilterParser(TypedArray typedArray) {
        this.getAuthRequestContext = null;
        try {
            this.getAuthRequestContext = (Filter) Class.forName(typedArray.getString(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda2)).newInstance();
        } catch (Exception unused) {
            this.getAuthRequestContext = new NoFilter();
        }
    }
}
