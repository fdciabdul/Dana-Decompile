package com.alipay.msync.core.model.spcode.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* loaded from: classes2.dex */
public final class ProtoBizError extends Message {
    public static final String DEFAULT_ERROR = "";
    public static final String DEFAULT_ERROR_CODE = "";
    public static final int TAG_BIZ_ORDER = 1;
    public static final int TAG_ERROR = 3;
    public static final int TAG_ERROR_CODE = 4;
    public static final int TAG_SYNC_KEY = 2;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public Integer biz_order;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public String error;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public String error_code;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public Long sync_key;
    public static final Integer DEFAULT_BIZ_ORDER = 0;
    public static final Long DEFAULT_SYNC_KEY = 0L;

    public ProtoBizError(ProtoBizError protoBizError) {
        super(protoBizError);
        if (protoBizError == null) {
            return;
        }
        this.biz_order = protoBizError.biz_order;
        this.sync_key = protoBizError.sync_key;
        this.error = protoBizError.error;
        this.error_code = protoBizError.error_code;
    }

    public ProtoBizError() {
    }

    public final ProtoBizError fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.biz_order = (Integer) obj;
        } else if (i == 2) {
            this.sync_key = (Long) obj;
        } else if (i == 3) {
            this.error = (String) obj;
        } else if (i == 4) {
            this.error_code = (String) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ProtoBizError) {
            ProtoBizError protoBizError = (ProtoBizError) obj;
            return equals(this.biz_order, protoBizError.biz_order) && equals(this.sync_key, protoBizError.sync_key) && equals(this.error, protoBizError.error) && equals(this.error_code, protoBizError.error_code);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.biz_order;
            int hashCode = num != null ? num.hashCode() : 0;
            Long l = this.sync_key;
            int hashCode2 = l != null ? l.hashCode() : 0;
            String str = this.error;
            int hashCode3 = str != null ? str.hashCode() : 0;
            String str2 = this.error_code;
            int hashCode4 = (((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + (str2 != null ? str2.hashCode() : 0);
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i;
    }
}
