package com.zoloz.rpc.encryption;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class EncryptionResponse extends Message {
    public static final ByteString DEFAULT_CONTENT = ByteString.EMPTY;
    public static final String DEFAULT_RETCODE = "";
    public static final int TAG_CONTENT = 1;
    public static final int TAG_RETCODE = 2;
    @ProtoField(tag = 1, type = Message.Datatype.BYTES)
    public ByteString content;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public String retCode;

    public EncryptionResponse(EncryptionResponse encryptionResponse) {
        super(encryptionResponse);
        if (encryptionResponse == null) {
            return;
        }
        this.content = encryptionResponse.content;
        this.retCode = encryptionResponse.retCode;
    }

    public EncryptionResponse() {
    }

    public final EncryptionResponse fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.content = (ByteString) obj;
        } else if (i == 2) {
            this.retCode = (String) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EncryptionResponse) {
            EncryptionResponse encryptionResponse = (EncryptionResponse) obj;
            return equals(this.content, encryptionResponse.content) && equals(this.retCode, encryptionResponse.retCode);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            ByteString byteString = this.content;
            int hashCode = byteString != null ? byteString.hashCode() : 0;
            String str = this.retCode;
            int hashCode2 = (hashCode * 37) + (str != null ? str.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i;
    }
}
