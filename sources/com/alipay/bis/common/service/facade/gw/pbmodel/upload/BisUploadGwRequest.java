package com.alipay.bis.common.service.facade.gw.pbmodel.upload;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class BisUploadGwRequest extends Message {
    public static final String DEFAULT_BISTOKEN = "";
    public static final int TAG_BEHAVLOG = 4;
    public static final int TAG_BEHAVLOGSIG = 5;
    public static final int TAG_BISTOKEN = 1;
    public static final int TAG_CONTENT = 2;
    public static final int TAG_CONTENTSIG = 3;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public ByteString behavLog;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public ByteString behavLogSig;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public String bisToken;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public ByteString content;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public ByteString contentSig;
    public static final ByteString DEFAULT_CONTENT = ByteString.EMPTY;
    public static final ByteString DEFAULT_CONTENTSIG = ByteString.EMPTY;
    public static final ByteString DEFAULT_BEHAVLOG = ByteString.EMPTY;
    public static final ByteString DEFAULT_BEHAVLOGSIG = ByteString.EMPTY;

    public BisUploadGwRequest(BisUploadGwRequest bisUploadGwRequest) {
        super(bisUploadGwRequest);
        if (bisUploadGwRequest == null) {
            return;
        }
        this.bisToken = bisUploadGwRequest.bisToken;
        this.content = bisUploadGwRequest.content;
        this.contentSig = bisUploadGwRequest.contentSig;
        this.behavLog = bisUploadGwRequest.behavLog;
        this.behavLogSig = bisUploadGwRequest.behavLogSig;
    }

    public BisUploadGwRequest() {
    }

    public final BisUploadGwRequest fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.bisToken = (String) obj;
        } else if (i == 2) {
            this.content = (ByteString) obj;
        } else if (i == 3) {
            this.contentSig = (ByteString) obj;
        } else if (i == 4) {
            this.behavLog = (ByteString) obj;
        } else if (i == 5) {
            this.behavLogSig = (ByteString) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BisUploadGwRequest) {
            BisUploadGwRequest bisUploadGwRequest = (BisUploadGwRequest) obj;
            return equals(this.bisToken, bisUploadGwRequest.bisToken) && equals(this.content, bisUploadGwRequest.content) && equals(this.contentSig, bisUploadGwRequest.contentSig) && equals(this.behavLog, bisUploadGwRequest.behavLog) && equals(this.behavLogSig, bisUploadGwRequest.behavLogSig);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.bisToken;
            int hashCode = str != null ? str.hashCode() : 0;
            ByteString byteString = this.content;
            int hashCode2 = byteString != null ? byteString.hashCode() : 0;
            ByteString byteString2 = this.contentSig;
            int hashCode3 = byteString2 != null ? byteString2.hashCode() : 0;
            ByteString byteString3 = this.behavLog;
            int hashCode4 = byteString3 != null ? byteString3.hashCode() : 0;
            ByteString byteString4 = this.behavLogSig;
            int hashCode5 = (((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + (byteString4 != null ? byteString4.hashCode() : 0);
            this.hashCode = hashCode5;
            return hashCode5;
        }
        return i;
    }
}
