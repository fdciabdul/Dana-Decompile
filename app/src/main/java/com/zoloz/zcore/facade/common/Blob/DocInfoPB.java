package com.zoloz.zcore.facade.common.Blob;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class DocInfoPB extends Message {
    public static final String DEFAULT_DOCTYPE = "";
    public static final int TAG_DOCTYPE = 1;
    public static final int TAG_FACERECT = 5;
    public static final int TAG_FIELDS = 4;
    public static final int TAG_PAGENO = 2;
    public static final int TAG_REGION = 3;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public String docType;
    @ProtoField(tag = 5)
    public RectPB faceRect;
    @ProtoField(label = Message.Label.REPEATED, tag = 4)
    public List<DocFieldInfoPB> fields;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public Integer pageNo;
    @ProtoField(label = Message.Label.REPEATED, tag = 3)
    public List<PointPB> region;
    public static final Integer DEFAULT_PAGENO = 0;
    public static final List<PointPB> DEFAULT_REGION = Collections.emptyList();
    public static final List<DocFieldInfoPB> DEFAULT_FIELDS = Collections.emptyList();

    public DocInfoPB(DocInfoPB docInfoPB) {
        super(docInfoPB);
        if (docInfoPB == null) {
            return;
        }
        this.docType = docInfoPB.docType;
        this.pageNo = docInfoPB.pageNo;
        this.region = copyOf(docInfoPB.region);
        this.fields = copyOf(docInfoPB.fields);
        this.faceRect = docInfoPB.faceRect;
    }

    public DocInfoPB() {
    }

    public final DocInfoPB fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.docType = (String) obj;
        } else if (i == 2) {
            this.pageNo = (Integer) obj;
        } else if (i == 3) {
            this.region = immutableCopyOf((List) obj);
        } else if (i == 4) {
            this.fields = immutableCopyOf((List) obj);
        } else if (i == 5) {
            this.faceRect = (RectPB) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DocInfoPB) {
            DocInfoPB docInfoPB = (DocInfoPB) obj;
            return equals(this.docType, docInfoPB.docType) && equals(this.pageNo, docInfoPB.pageNo) && equals((List<?>) this.region, (List<?>) docInfoPB.region) && equals((List<?>) this.fields, (List<?>) docInfoPB.fields) && equals(this.faceRect, docInfoPB.faceRect);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.docType;
            int hashCode = str != null ? str.hashCode() : 0;
            Integer num = this.pageNo;
            int hashCode2 = num != null ? num.hashCode() : 0;
            List<PointPB> list = this.region;
            int hashCode3 = list != null ? list.hashCode() : 1;
            List<DocFieldInfoPB> list2 = this.fields;
            int hashCode4 = list2 != null ? list2.hashCode() : 1;
            RectPB rectPB = this.faceRect;
            int hashCode5 = (((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + (rectPB != null ? rectPB.hashCode() : 0);
            this.hashCode = hashCode5;
            return hashCode5;
        }
        return i;
    }
}
