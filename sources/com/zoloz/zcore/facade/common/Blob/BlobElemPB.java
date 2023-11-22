package com.zoloz.zcore.facade.common.Blob;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class BlobElemPB extends Message {
    public static final String DEFAULT_SUBTYPE = "";
    public static final String DEFAULT_TYPE = "";
    public static final String DEFAULT_VERSION = "blobElemVersion";
    public static final int TAG_CONTENT = 5;
    public static final int TAG_DOCINFO = 7;
    public static final int TAG_FACEINFOS = 6;
    public static final int TAG_IDX = 3;
    public static final int TAG_SUBTYPE = 2;
    public static final int TAG_TYPE = 1;
    public static final int TAG_VERSION = 4;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public ByteString content;
    @ProtoField(tag = 7)
    public DocInfoPB docInfo;
    @ProtoField(label = Message.Label.REPEATED, tag = 6)
    public List<FaceInfoPB> faceInfos;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public Integer idx;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public String subType;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public String type;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public String version;
    public static final Integer DEFAULT_IDX = 0;
    public static final ByteString DEFAULT_CONTENT = ByteString.EMPTY;
    public static final List<FaceInfoPB> DEFAULT_FACEINFOS = Collections.emptyList();

    public BlobElemPB(BlobElemPB blobElemPB) {
        super(blobElemPB);
        if (blobElemPB == null) {
            return;
        }
        this.type = blobElemPB.type;
        this.subType = blobElemPB.subType;
        this.idx = blobElemPB.idx;
        this.version = blobElemPB.version;
        this.content = blobElemPB.content;
        this.faceInfos = copyOf(blobElemPB.faceInfos);
        this.docInfo = blobElemPB.docInfo;
    }

    public BlobElemPB() {
    }

    public final BlobElemPB fillTagValue(int i, Object obj) {
        switch (i) {
            case 1:
                this.type = (String) obj;
                break;
            case 2:
                this.subType = (String) obj;
                break;
            case 3:
                this.idx = (Integer) obj;
                break;
            case 4:
                this.version = (String) obj;
                break;
            case 5:
                this.content = (ByteString) obj;
                break;
            case 6:
                this.faceInfos = immutableCopyOf((List) obj);
                break;
            case 7:
                this.docInfo = (DocInfoPB) obj;
                break;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BlobElemPB) {
            BlobElemPB blobElemPB = (BlobElemPB) obj;
            return equals(this.type, blobElemPB.type) && equals(this.subType, blobElemPB.subType) && equals(this.idx, blobElemPB.idx) && equals(this.version, blobElemPB.version) && equals(this.content, blobElemPB.content) && equals((List<?>) this.faceInfos, (List<?>) blobElemPB.faceInfos) && equals(this.docInfo, blobElemPB.docInfo);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.type;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.subType;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            Integer num = this.idx;
            int hashCode3 = num != null ? num.hashCode() : 0;
            String str3 = this.version;
            int hashCode4 = str3 != null ? str3.hashCode() : 0;
            ByteString byteString = this.content;
            int hashCode5 = byteString != null ? byteString.hashCode() : 0;
            List<FaceInfoPB> list = this.faceInfos;
            int hashCode6 = list != null ? list.hashCode() : 1;
            DocInfoPB docInfoPB = this.docInfo;
            int hashCode7 = (((((((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + hashCode5) * 37) + hashCode6) * 37) + (docInfoPB != null ? docInfoPB.hashCode() : 0);
            this.hashCode = hashCode7;
            return hashCode7;
        }
        return i;
    }
}
