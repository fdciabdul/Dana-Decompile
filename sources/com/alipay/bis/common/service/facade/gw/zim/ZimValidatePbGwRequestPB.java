package com.alipay.bis.common.service.facade.gw.zim;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class ZimValidatePbGwRequestPB extends Message {
    public static final ByteString DEFAULT_ZIMDATA = ByteString.EMPTY;
    public static final String DEFAULT_ZIMID = "";
    public static final int TAG_BIZDATA = 3;
    public static final int TAG_ZIMDATA = 2;
    public static final int TAG_ZIMID = 1;
    @ProtoField(tag = 3)
    public MapStringString bizData;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public ByteString zimData;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public String zimId;

    public ZimValidatePbGwRequestPB(ZimValidatePbGwRequestPB zimValidatePbGwRequestPB) {
        super(zimValidatePbGwRequestPB);
        if (zimValidatePbGwRequestPB == null) {
            return;
        }
        this.zimId = zimValidatePbGwRequestPB.zimId;
        this.zimData = zimValidatePbGwRequestPB.zimData;
        this.bizData = zimValidatePbGwRequestPB.bizData;
    }

    public ZimValidatePbGwRequestPB() {
    }

    public final ZimValidatePbGwRequestPB fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.zimId = (String) obj;
        } else if (i == 2) {
            this.zimData = (ByteString) obj;
        } else if (i == 3) {
            this.bizData = (MapStringString) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ZimValidatePbGwRequestPB) {
            ZimValidatePbGwRequestPB zimValidatePbGwRequestPB = (ZimValidatePbGwRequestPB) obj;
            return equals(this.zimId, zimValidatePbGwRequestPB.zimId) && equals(this.zimData, zimValidatePbGwRequestPB.zimData) && equals(this.bizData, zimValidatePbGwRequestPB.bizData);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.zimId;
            int hashCode = str != null ? str.hashCode() : 0;
            ByteString byteString = this.zimData;
            int hashCode2 = byteString != null ? byteString.hashCode() : 0;
            MapStringString mapStringString = this.bizData;
            int hashCode3 = (((hashCode * 37) + hashCode2) * 37) + (mapStringString != null ? mapStringString.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i;
    }
}
