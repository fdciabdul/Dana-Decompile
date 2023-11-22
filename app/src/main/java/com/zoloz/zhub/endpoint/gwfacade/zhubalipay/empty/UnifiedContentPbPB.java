package com.zoloz.zhub.endpoint.gwfacade.zhubalipay.empty;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;
import com.zoloz.zcore.facade.common.BlobPB;
import com.zoloz.zhub.endpoint.gwfacade.zhubalipay.empty.UnifiedContentPb.MetaPbPB;

/* loaded from: classes2.dex */
public final class UnifiedContentPbPB extends Message {
    public static final int TAG_BLOB = 2;
    public static final int TAG_META = 1;
    @ProtoField(tag = 2)
    public BlobPB blob;
    @ProtoField(tag = 1)
    public MetaPbPB meta;

    public UnifiedContentPbPB(UnifiedContentPbPB unifiedContentPbPB) {
        super(unifiedContentPbPB);
        if (unifiedContentPbPB == null) {
            return;
        }
        this.meta = unifiedContentPbPB.meta;
        this.blob = unifiedContentPbPB.blob;
    }

    public UnifiedContentPbPB() {
    }

    public final UnifiedContentPbPB fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.meta = (MetaPbPB) obj;
        } else if (i == 2) {
            this.blob = (BlobPB) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UnifiedContentPbPB) {
            UnifiedContentPbPB unifiedContentPbPB = (UnifiedContentPbPB) obj;
            return equals(this.meta, unifiedContentPbPB.meta) && equals(this.blob, unifiedContentPbPB.blob);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            MetaPbPB metaPbPB = this.meta;
            int hashCode = metaPbPB != null ? metaPbPB.hashCode() : 0;
            BlobPB blobPB = this.blob;
            int hashCode2 = (hashCode * 37) + (blobPB != null ? blobPB.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i;
    }
}
