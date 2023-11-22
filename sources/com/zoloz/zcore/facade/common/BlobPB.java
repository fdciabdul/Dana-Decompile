package com.zoloz.zcore.facade.common;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;
import com.zoloz.zcore.facade.common.Blob.BlobElemPB;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class BlobPB extends Message {
    public static final List<BlobElemPB> DEFAULT_BLOBELEM = Collections.emptyList();
    public static final String DEFAULT_BLOBVERSION = "blobVersion";
    public static final int TAG_BLOBELEM = 2;
    public static final int TAG_BLOBVERSION = 1;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public List<BlobElemPB> blobElem;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public String blobVersion;

    public BlobPB(BlobPB blobPB) {
        super(blobPB);
        if (blobPB == null) {
            return;
        }
        this.blobVersion = blobPB.blobVersion;
        this.blobElem = copyOf(blobPB.blobElem);
    }

    public BlobPB() {
    }

    public final BlobPB fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.blobVersion = (String) obj;
        } else if (i == 2) {
            this.blobElem = immutableCopyOf((List) obj);
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BlobPB) {
            BlobPB blobPB = (BlobPB) obj;
            return equals(this.blobVersion, blobPB.blobVersion) && equals((List<?>) this.blobElem, (List<?>) blobPB.blobElem);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.blobVersion;
            int hashCode = str != null ? str.hashCode() : 0;
            List<BlobElemPB> list = this.blobElem;
            int hashCode2 = (hashCode * 37) + (list != null ? list.hashCode() : 1);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i;
    }
}
