package in.srain.cube.views.ptr;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes6.dex */
public class PtrClassicFrameLayout extends PtrFrameLayout {
    private PtrClassicDefaultHeader mPtrClassicHeader;

    public PtrClassicFrameLayout(Context context) {
        super(context);
        initViews();
    }

    public PtrClassicFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViews();
    }

    public PtrClassicFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initViews();
    }

    private void initViews() {
        PtrClassicDefaultHeader ptrClassicDefaultHeader = new PtrClassicDefaultHeader(getContext());
        this.mPtrClassicHeader = ptrClassicDefaultHeader;
        setHeaderView(ptrClassicDefaultHeader);
        addPtrUIHandler(this.mPtrClassicHeader);
    }

    public PtrClassicDefaultHeader getHeader() {
        return this.mPtrClassicHeader;
    }

    public void setLastUpdateTimeKey(String str) {
        PtrClassicDefaultHeader ptrClassicDefaultHeader = this.mPtrClassicHeader;
        if (ptrClassicDefaultHeader != null) {
            ptrClassicDefaultHeader.setLastUpdateTimeKey(str);
        }
    }

    public void setLastUpdateTimeRelateObject(Object obj) {
        PtrClassicDefaultHeader ptrClassicDefaultHeader = this.mPtrClassicHeader;
        if (ptrClassicDefaultHeader != null) {
            ptrClassicDefaultHeader.setLastUpdateTimeRelateObject(obj);
        }
    }
}
