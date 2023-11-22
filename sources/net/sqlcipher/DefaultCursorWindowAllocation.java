package net.sqlcipher;

import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;

/* loaded from: classes6.dex */
public class DefaultCursorWindowAllocation implements CursorWindowAllocation {
    private long initialAllocationSize = ConvertUtils.MB;
    private long WindowAllocationUnbounded = 0;

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getInitialAllocationSize() {
        return this.initialAllocationSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getGrowthPaddingSize() {
        return this.initialAllocationSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getMaxAllocationSize() {
        return this.WindowAllocationUnbounded;
    }
}
