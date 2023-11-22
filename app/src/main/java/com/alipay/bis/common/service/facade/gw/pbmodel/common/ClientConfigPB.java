package com.alipay.bis.common.service.facade.gw.pbmodel.common;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class ClientConfigPB extends Message {
    public static final ByteString DEFAULT_SIGN = ByteString.EMPTY;
    public static final int TAG_CONTENT = 1;
    public static final int TAG_SIGN = 2;
    @ProtoField(tag = 1)
    public ClientConfigContentPB content;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public ByteString sign;

    public ClientConfigPB(ClientConfigPB clientConfigPB) {
        super(clientConfigPB);
        if (clientConfigPB == null) {
            return;
        }
        this.content = clientConfigPB.content;
        this.sign = clientConfigPB.sign;
    }

    public ClientConfigPB() {
    }

    public final ClientConfigPB fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.content = (ClientConfigContentPB) obj;
        } else if (i == 2) {
            this.sign = (ByteString) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ClientConfigPB) {
            ClientConfigPB clientConfigPB = (ClientConfigPB) obj;
            return equals(this.content, clientConfigPB.content) && equals(this.sign, clientConfigPB.sign);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            ClientConfigContentPB clientConfigContentPB = this.content;
            int hashCode = clientConfigContentPB != null ? clientConfigContentPB.hashCode() : 0;
            ByteString byteString = this.sign;
            int hashCode2 = (hashCode * 37) + (byteString != null ? byteString.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i;
    }
}
