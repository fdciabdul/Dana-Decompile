package com.zoloz.rpc.encryption;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class EncryptionRequest extends Message {
    public static final ByteString DEFAULT_CONTENT = ByteString.EMPTY;
    public static final ByteString DEFAULT_CONTENTSIG = ByteString.EMPTY;
    public static final String DEFAULT_MID = "";
    public static final int TAG_CONTENT = 1;
    public static final int TAG_CONTENTSIG = 2;
    public static final int TAG_MID = 3;
    @ProtoField(tag = 1, type = Message.Datatype.BYTES)
    public ByteString content;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public ByteString contentSig;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public String mid;

    public EncryptionRequest(EncryptionRequest encryptionRequest) {
        super(encryptionRequest);
        if (encryptionRequest == null) {
            return;
        }
        this.content = encryptionRequest.content;
        this.contentSig = encryptionRequest.contentSig;
        this.mid = encryptionRequest.mid;
    }

    public EncryptionRequest() {
    }

    public final EncryptionRequest fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.content = (ByteString) obj;
        } else if (i == 2) {
            this.contentSig = (ByteString) obj;
        } else if (i == 3) {
            this.mid = (String) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EncryptionRequest) {
            EncryptionRequest encryptionRequest = (EncryptionRequest) obj;
            return equals(this.content, encryptionRequest.content) && equals(this.contentSig, encryptionRequest.contentSig) && equals(this.mid, encryptionRequest.mid);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            ByteString byteString = this.content;
            int hashCode = byteString != null ? byteString.hashCode() : 0;
            ByteString byteString2 = this.contentSig;
            int hashCode2 = byteString2 != null ? byteString2.hashCode() : 0;
            String str = this.mid;
            int hashCode3 = (((hashCode * 37) + hashCode2) * 37) + (str != null ? str.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i;
    }
}
