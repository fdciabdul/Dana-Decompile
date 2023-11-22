package com.alipay.msync.core.model.spcode.pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class ProtoBizSyncData extends Message {
    public static final Integer DEFAULT_BIZ_ORDER;
    public static final String DEFAULT_BIZ_TYPE = "";
    public static final Boolean DEFAULT_HAS_MORE;
    public static final Boolean DEFAULT_MULTI_DEVICE;
    public static final List<ProtoOplog> DEFAULT_OPLOG;
    public static final Boolean DEFAULT_PERSISTENT_BIZ;
    public static final Long DEFAULT_SYNC_KEY;
    public static final int TAG_BIZ_ORDER = 1;
    public static final int TAG_BIZ_TYPE = 5;
    public static final int TAG_HAS_MORE = 2;
    public static final int TAG_MULTI_DEVICE = 6;
    public static final int TAG_OPLOG = 4;
    public static final int TAG_PERSISTENT_BIZ = 7;
    public static final int TAG_SYNC_KEY = 3;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public Integer biz_order;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public String biz_type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.BOOL)
    public Boolean has_more;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public Boolean multi_device;
    @ProtoField(label = Message.Label.REPEATED, tag = 4)
    public List<ProtoOplog> oplog;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public Boolean persistent_biz;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT64)
    public Long sync_key;

    static {
        Boolean bool = Boolean.FALSE;
        DEFAULT_BIZ_ORDER = 0;
        DEFAULT_HAS_MORE = bool;
        DEFAULT_SYNC_KEY = 0L;
        DEFAULT_OPLOG = Collections.emptyList();
        DEFAULT_MULTI_DEVICE = bool;
        DEFAULT_PERSISTENT_BIZ = bool;
    }

    public ProtoBizSyncData(ProtoBizSyncData protoBizSyncData) {
        super(protoBizSyncData);
        if (protoBizSyncData == null) {
            return;
        }
        this.biz_order = protoBizSyncData.biz_order;
        this.has_more = protoBizSyncData.has_more;
        this.sync_key = protoBizSyncData.sync_key;
        this.oplog = copyOf(protoBizSyncData.oplog);
        this.biz_type = protoBizSyncData.biz_type;
        this.multi_device = protoBizSyncData.multi_device;
        this.persistent_biz = protoBizSyncData.persistent_biz;
    }

    public ProtoBizSyncData() {
    }

    public final ProtoBizSyncData fillTagValue(int i, Object obj) {
        switch (i) {
            case 1:
                this.biz_order = (Integer) obj;
                break;
            case 2:
                this.has_more = (Boolean) obj;
                break;
            case 3:
                this.sync_key = (Long) obj;
                break;
            case 4:
                this.oplog = immutableCopyOf((List) obj);
                break;
            case 5:
                this.biz_type = (String) obj;
                break;
            case 6:
                this.multi_device = (Boolean) obj;
                break;
            case 7:
                this.persistent_biz = (Boolean) obj;
                break;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ProtoBizSyncData) {
            ProtoBizSyncData protoBizSyncData = (ProtoBizSyncData) obj;
            return equals(this.biz_order, protoBizSyncData.biz_order) && equals(this.has_more, protoBizSyncData.has_more) && equals(this.sync_key, protoBizSyncData.sync_key) && equals((List<?>) this.oplog, (List<?>) protoBizSyncData.oplog) && equals(this.biz_type, protoBizSyncData.biz_type) && equals(this.multi_device, protoBizSyncData.multi_device) && equals(this.persistent_biz, protoBizSyncData.persistent_biz);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.biz_order;
            int hashCode = num != null ? num.hashCode() : 0;
            Boolean bool = this.has_more;
            int hashCode2 = bool != null ? bool.hashCode() : 0;
            Long l = this.sync_key;
            int hashCode3 = l != null ? l.hashCode() : 0;
            List<ProtoOplog> list = this.oplog;
            int hashCode4 = list != null ? list.hashCode() : 1;
            String str = this.biz_type;
            int hashCode5 = str != null ? str.hashCode() : 0;
            Boolean bool2 = this.multi_device;
            int hashCode6 = bool2 != null ? bool2.hashCode() : 0;
            Boolean bool3 = this.persistent_biz;
            int hashCode7 = (((((((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + hashCode5) * 37) + hashCode6) * 37) + (bool3 != null ? bool3.hashCode() : 0);
            this.hashCode = hashCode7;
            return hashCode7;
        }
        return i;
    }
}
