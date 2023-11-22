package com.alipay.msync.core.model.spcode.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class ProtoSyncOpCode2001 extends Message {
    public static final List<ProtoBizSyncData> DEFAULT_BIZ_SYNC_DATA;
    public static final Boolean DEFAULT_HAS_MORE_DATA;
    public static final Boolean DEFAULT_NOT_CHECK_PRINCIPAL;
    public static final String DEFAULT_PRINCIPAL_ID = "";
    public static final Integer DEFAULT_PRINCIPAL_ID_TYPE;
    public static final Integer DEFAULT_SERVER_IP;
    public static final int TAG_BIZ_SYNC_DATA = 3;
    public static final int TAG_HAS_MORE_DATA = 6;
    public static final int TAG_NOT_CHECK_PRINCIPAL = 4;
    public static final int TAG_PRINCIPAL_ID = 2;
    public static final int TAG_PRINCIPAL_ID_TYPE = 1;
    public static final int TAG_SERVER_IP = 5;
    @ProtoField(label = Message.Label.REPEATED, tag = 3)
    public List<ProtoBizSyncData> biz_sync_data;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public Boolean has_more_data;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public Boolean not_check_principal;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public String principal_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public Integer principal_id_type;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public Integer server_ip;

    static {
        Boolean bool = Boolean.FALSE;
        DEFAULT_PRINCIPAL_ID_TYPE = 0;
        DEFAULT_BIZ_SYNC_DATA = Collections.emptyList();
        DEFAULT_NOT_CHECK_PRINCIPAL = bool;
        DEFAULT_SERVER_IP = 0;
        DEFAULT_HAS_MORE_DATA = bool;
    }

    public ProtoSyncOpCode2001(ProtoSyncOpCode2001 protoSyncOpCode2001) {
        super(protoSyncOpCode2001);
        if (protoSyncOpCode2001 == null) {
            return;
        }
        this.principal_id_type = protoSyncOpCode2001.principal_id_type;
        this.principal_id = protoSyncOpCode2001.principal_id;
        this.biz_sync_data = copyOf(protoSyncOpCode2001.biz_sync_data);
        this.not_check_principal = protoSyncOpCode2001.not_check_principal;
        this.server_ip = protoSyncOpCode2001.server_ip;
        this.has_more_data = protoSyncOpCode2001.has_more_data;
    }

    public ProtoSyncOpCode2001() {
    }

    public final ProtoSyncOpCode2001 fillTagValue(int i, Object obj) {
        switch (i) {
            case 1:
                this.principal_id_type = (Integer) obj;
                break;
            case 2:
                this.principal_id = (String) obj;
                break;
            case 3:
                this.biz_sync_data = immutableCopyOf((List) obj);
                break;
            case 4:
                this.not_check_principal = (Boolean) obj;
                break;
            case 5:
                this.server_ip = (Integer) obj;
                break;
            case 6:
                this.has_more_data = (Boolean) obj;
                break;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ProtoSyncOpCode2001) {
            ProtoSyncOpCode2001 protoSyncOpCode2001 = (ProtoSyncOpCode2001) obj;
            return equals(this.principal_id_type, protoSyncOpCode2001.principal_id_type) && equals(this.principal_id, protoSyncOpCode2001.principal_id) && equals((List<?>) this.biz_sync_data, (List<?>) protoSyncOpCode2001.biz_sync_data) && equals(this.not_check_principal, protoSyncOpCode2001.not_check_principal) && equals(this.server_ip, protoSyncOpCode2001.server_ip) && equals(this.has_more_data, protoSyncOpCode2001.has_more_data);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.principal_id_type;
            int hashCode = num != null ? num.hashCode() : 0;
            String str = this.principal_id;
            int hashCode2 = str != null ? str.hashCode() : 0;
            List<ProtoBizSyncData> list = this.biz_sync_data;
            int hashCode3 = list != null ? list.hashCode() : 1;
            Boolean bool = this.not_check_principal;
            int hashCode4 = bool != null ? bool.hashCode() : 0;
            Integer num2 = this.server_ip;
            int hashCode5 = num2 != null ? num2.hashCode() : 0;
            Boolean bool2 = this.has_more_data;
            int hashCode6 = (((((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + hashCode5) * 37) + (bool2 != null ? bool2.hashCode() : 0);
            this.hashCode = hashCode6;
            return hashCode6;
        }
        return i;
    }
}
