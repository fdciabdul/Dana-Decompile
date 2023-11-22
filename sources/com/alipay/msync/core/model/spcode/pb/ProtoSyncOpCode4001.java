package com.alipay.msync.core.model.spcode.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class ProtoSyncOpCode4001 extends Message {
    public static final List<ProtoBizError> DEFAULT_BIZ_ERROR = Collections.emptyList();
    public static final String DEFAULT_PRINCIPAL_ID = "";
    public static final int TAG_BIZ_ERROR = 1;
    public static final int TAG_PRINCIPAL_ID = 2;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public List<ProtoBizError> biz_error;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public String principal_id;

    public ProtoSyncOpCode4001(ProtoSyncOpCode4001 protoSyncOpCode4001) {
        super(protoSyncOpCode4001);
        if (protoSyncOpCode4001 == null) {
            return;
        }
        this.biz_error = copyOf(protoSyncOpCode4001.biz_error);
        this.principal_id = protoSyncOpCode4001.principal_id;
    }

    public ProtoSyncOpCode4001() {
    }

    public final ProtoSyncOpCode4001 fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.biz_error = immutableCopyOf((List) obj);
        } else if (i == 2) {
            this.principal_id = (String) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ProtoSyncOpCode4001) {
            ProtoSyncOpCode4001 protoSyncOpCode4001 = (ProtoSyncOpCode4001) obj;
            return equals((List<?>) this.biz_error, (List<?>) protoSyncOpCode4001.biz_error) && equals(this.principal_id, protoSyncOpCode4001.principal_id);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<ProtoBizError> list = this.biz_error;
            int hashCode = list != null ? list.hashCode() : 1;
            String str = this.principal_id;
            int hashCode2 = (hashCode * 37) + (str != null ? str.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i;
    }
}
