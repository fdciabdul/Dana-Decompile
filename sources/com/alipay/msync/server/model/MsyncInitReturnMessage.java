package com.alipay.msync.server.model;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* loaded from: classes2.dex */
public final class MsyncInitReturnMessage extends Message {
    public static final String DEFAULT_ACTION = "";
    public static final String DEFAULT_CDID = "";
    public static final int TAG_ACTION = 1;
    public static final int TAG_CDID = 5;
    public static final int TAG_HEARTTIMEOUT = 4;
    public static final int TAG_KEEPLIVETIME = 3;
    public static final int TAG_NEXTCONNECTITVL = 2;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public String action;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public String cdid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public Integer heartTimeOut;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public Integer keepLiveTime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public Integer nextConnectItvl;
    public static final Integer DEFAULT_NEXTCONNECTITVL = 0;
    public static final Integer DEFAULT_KEEPLIVETIME = 0;
    public static final Integer DEFAULT_HEARTTIMEOUT = 0;

    public MsyncInitReturnMessage(MsyncInitReturnMessage msyncInitReturnMessage) {
        super(msyncInitReturnMessage);
        if (msyncInitReturnMessage == null) {
            return;
        }
        this.action = msyncInitReturnMessage.action;
        this.nextConnectItvl = msyncInitReturnMessage.nextConnectItvl;
        this.keepLiveTime = msyncInitReturnMessage.keepLiveTime;
        this.heartTimeOut = msyncInitReturnMessage.heartTimeOut;
        this.cdid = msyncInitReturnMessage.cdid;
    }

    public MsyncInitReturnMessage() {
    }

    public final MsyncInitReturnMessage fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.action = (String) obj;
        } else if (i == 2) {
            this.nextConnectItvl = (Integer) obj;
        } else if (i == 3) {
            this.keepLiveTime = (Integer) obj;
        } else if (i == 4) {
            this.heartTimeOut = (Integer) obj;
        } else if (i == 5) {
            this.cdid = (String) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MsyncInitReturnMessage) {
            MsyncInitReturnMessage msyncInitReturnMessage = (MsyncInitReturnMessage) obj;
            return equals(this.action, msyncInitReturnMessage.action) && equals(this.nextConnectItvl, msyncInitReturnMessage.nextConnectItvl) && equals(this.keepLiveTime, msyncInitReturnMessage.keepLiveTime) && equals(this.heartTimeOut, msyncInitReturnMessage.heartTimeOut) && equals(this.cdid, msyncInitReturnMessage.cdid);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.action;
            int hashCode = str != null ? str.hashCode() : 0;
            Integer num = this.nextConnectItvl;
            int hashCode2 = num != null ? num.hashCode() : 0;
            Integer num2 = this.keepLiveTime;
            int hashCode3 = num2 != null ? num2.hashCode() : 0;
            Integer num3 = this.heartTimeOut;
            int hashCode4 = num3 != null ? num3.hashCode() : 0;
            String str2 = this.cdid;
            int hashCode5 = (((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + (str2 != null ? str2.hashCode() : 0);
            this.hashCode = hashCode5;
            return hashCode5;
        }
        return i;
    }
}
