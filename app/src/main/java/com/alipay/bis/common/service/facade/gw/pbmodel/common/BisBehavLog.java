package com.alipay.bis.common.service.facade.gw.pbmodel.common;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class BisBehavLog extends Message {
    public static final List<BisBehavTask> DEFAULT_BEHAVTASK = Collections.emptyList();
    public static final int TAG_BEHAVCOMMON = 3;
    public static final int TAG_BEHAVTASK = 4;
    public static final int TAG_BEHAVTOKEN = 2;
    public static final int TAG_CLIENTINFO = 1;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3)
    public BisBehavCommon behavCommon;
    @ProtoField(label = Message.Label.REPEATED, tag = 4)
    public List<BisBehavTask> behavTask;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public BisBehavToken behavToken;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public BisClientInfo clientInfo;

    public BisBehavLog(BisBehavLog bisBehavLog) {
        super(bisBehavLog);
        if (bisBehavLog == null) {
            return;
        }
        this.clientInfo = bisBehavLog.clientInfo;
        this.behavToken = bisBehavLog.behavToken;
        this.behavCommon = bisBehavLog.behavCommon;
        this.behavTask = copyOf(bisBehavLog.behavTask);
    }

    public BisBehavLog() {
    }

    public final BisBehavLog fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.clientInfo = (BisClientInfo) obj;
        } else if (i == 2) {
            this.behavToken = (BisBehavToken) obj;
        } else if (i == 3) {
            this.behavCommon = (BisBehavCommon) obj;
        } else if (i == 4) {
            this.behavTask = immutableCopyOf((List) obj);
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BisBehavLog) {
            BisBehavLog bisBehavLog = (BisBehavLog) obj;
            return equals(this.clientInfo, bisBehavLog.clientInfo) && equals(this.behavToken, bisBehavLog.behavToken) && equals(this.behavCommon, bisBehavLog.behavCommon) && equals((List<?>) this.behavTask, (List<?>) bisBehavLog.behavTask);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            BisClientInfo bisClientInfo = this.clientInfo;
            int hashCode = bisClientInfo != null ? bisClientInfo.hashCode() : 0;
            BisBehavToken bisBehavToken = this.behavToken;
            int hashCode2 = bisBehavToken != null ? bisBehavToken.hashCode() : 0;
            BisBehavCommon bisBehavCommon = this.behavCommon;
            int hashCode3 = bisBehavCommon != null ? bisBehavCommon.hashCode() : 0;
            List<BisBehavTask> list = this.behavTask;
            int hashCode4 = (((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + (list != null ? list.hashCode() : 1);
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i;
    }
}
