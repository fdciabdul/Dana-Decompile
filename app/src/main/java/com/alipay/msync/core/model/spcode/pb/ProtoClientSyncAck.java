package com.alipay.msync.core.model.spcode.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* loaded from: classes2.dex */
public final class ProtoClientSyncAck extends Message {
    public static final String DEFAULT_BIZ_TYPE = "";
    public static final String DEFAULT_CMK = "";
    public static final String DEFAULT_RESP_PAYLOAD = "";
    public static final int TAG_BIZ_ORDER = 1;
    public static final int TAG_BIZ_TYPE = 6;
    public static final int TAG_CMK = 2;
    public static final int TAG_MK = 3;
    public static final int TAG_RESP_CODE = 4;
    public static final int TAG_RESP_PAYLOAD = 5;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public Integer biz_order;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public String biz_type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public String cmk;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT64)
    public Long mk;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public Long resp_code;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public String resp_payload;
    public static final Integer DEFAULT_BIZ_ORDER = 0;
    public static final Long DEFAULT_MK = 0L;
    public static final Long DEFAULT_RESP_CODE = 0L;

    public ProtoClientSyncAck(ProtoClientSyncAck protoClientSyncAck) {
        super(protoClientSyncAck);
        if (protoClientSyncAck == null) {
            return;
        }
        this.biz_order = protoClientSyncAck.biz_order;
        this.cmk = protoClientSyncAck.cmk;
        this.mk = protoClientSyncAck.mk;
        this.resp_code = protoClientSyncAck.resp_code;
        this.resp_payload = protoClientSyncAck.resp_payload;
        this.biz_type = protoClientSyncAck.biz_type;
    }

    public ProtoClientSyncAck() {
    }

    public final ProtoClientSyncAck fillTagValue(int i, Object obj) {
        switch (i) {
            case 1:
                this.biz_order = (Integer) obj;
                break;
            case 2:
                this.cmk = (String) obj;
                break;
            case 3:
                this.mk = (Long) obj;
                break;
            case 4:
                this.resp_code = (Long) obj;
                break;
            case 5:
                this.resp_payload = (String) obj;
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
        if (obj instanceof ProtoClientSyncAck) {
            ProtoClientSyncAck protoClientSyncAck = (ProtoClientSyncAck) obj;
            return equals(this.biz_order, protoClientSyncAck.biz_order) && equals(this.cmk, protoClientSyncAck.cmk) && equals(this.mk, protoClientSyncAck.mk) && equals(this.resp_code, protoClientSyncAck.resp_code) && equals(this.resp_payload, protoClientSyncAck.resp_payload) && equals(this.biz_type, protoClientSyncAck.biz_type);
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
            Long l = this.mk;
            int hashCode3 = l != null ? l.hashCode() : 0;
            Long l2 = this.resp_code;
            int hashCode4 = l2 != null ? l2.hashCode() : 0;
            String str2 = this.resp_payload;
            int hashCode5 = str2 != null ? str2.hashCode() : 0;
            String str3 = this.biz_type;
            int hashCode6 = (((((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + hashCode5) * 37) + (str3 != null ? str3.hashCode() : 0);
            this.hashCode = hashCode6;
            return hashCode6;
        }
        return i;
    }
}
