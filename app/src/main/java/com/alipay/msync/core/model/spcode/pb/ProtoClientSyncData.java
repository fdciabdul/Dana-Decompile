package com.alipay.msync.core.model.spcode.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class ProtoClientSyncData extends Message {
    public static final String DEFAULT_BIZ_ID = "";
    public static final String DEFAULT_BIZ_TYPE = "";
    public static final String DEFAULT_CMK = "";
    public static final String DEFAULT_PAYLOAD = "";
    public static final int TAG_BINARY_PAYLOAD = 5;
    public static final int TAG_BIZ_ID = 3;
    public static final int TAG_BIZ_ORDER = 1;
    public static final int TAG_BIZ_TYPE = 6;
    public static final int TAG_CMK = 2;
    public static final int TAG_PAYLOAD = 4;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public ByteString binary_payload;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public String biz_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public Integer biz_order;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public String biz_type;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public String cmk;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public String payload;
    public static final Integer DEFAULT_BIZ_ORDER = 0;
    public static final ByteString DEFAULT_BINARY_PAYLOAD = ByteString.EMPTY;

    public ProtoClientSyncData(ProtoClientSyncData protoClientSyncData) {
        super(protoClientSyncData);
        if (protoClientSyncData == null) {
            return;
        }
        this.biz_order = protoClientSyncData.biz_order;
        this.cmk = protoClientSyncData.cmk;
        this.biz_id = protoClientSyncData.biz_id;
        this.payload = protoClientSyncData.payload;
        this.binary_payload = protoClientSyncData.binary_payload;
        this.biz_type = protoClientSyncData.biz_type;
    }

    public ProtoClientSyncData() {
    }

    public final ProtoClientSyncData fillTagValue(int i, Object obj) {
        switch (i) {
            case 1:
                this.biz_order = (Integer) obj;
                break;
            case 2:
                this.cmk = (String) obj;
                break;
            case 3:
                this.biz_id = (String) obj;
                break;
            case 4:
                this.payload = (String) obj;
                break;
            case 5:
                this.binary_payload = (ByteString) obj;
                break;
            case 6:
                this.biz_type = (String) obj;
                break;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ProtoClientSyncData) {
            ProtoClientSyncData protoClientSyncData = (ProtoClientSyncData) obj;
            return equals(this.biz_order, protoClientSyncData.biz_order) && equals(this.cmk, protoClientSyncData.cmk) && equals(this.biz_id, protoClientSyncData.biz_id) && equals(this.payload, protoClientSyncData.payload) && equals(this.binary_payload, protoClientSyncData.binary_payload) && equals(this.biz_type, protoClientSyncData.biz_type);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.biz_order;
            int hashCode = num != null ? num.hashCode() : 0;
            String str = this.cmk;
            int hashCode2 = str != null ? str.hashCode() : 0;
            String str2 = this.biz_id;
            int hashCode3 = str2 != null ? str2.hashCode() : 0;
            String str3 = this.payload;
            int hashCode4 = str3 != null ? str3.hashCode() : 0;
            ByteString byteString = this.binary_payload;
            int hashCode5 = byteString != null ? byteString.hashCode() : 0;
            String str4 = this.biz_type;
            int hashCode6 = (((((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + hashCode5) * 37) + (str4 != null ? str4.hashCode() : 0);
            this.hashCode = hashCode6;
            return hashCode6;
        }
        return i;
    }
}
