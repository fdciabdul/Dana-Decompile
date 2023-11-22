package com.alipay.bis.common.service.facade.gw.pbmodel.common;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;

/* loaded from: classes2.dex */
public final class BisClientInfo extends Message {
    public static final String DEFAULT_CLIENTVER = "";
    public static final String DEFAULT_MODEL = "";
    public static final String DEFAULT_OS = "";
    public static final String DEFAULT_OSVER = "";
    public static final int TAG_CLIENTVER = 4;
    public static final int TAG_MODEL = 1;
    public static final int TAG_OS = 2;
    public static final int TAG_OSVER = 3;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public String clientVer;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public String model;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public String os;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public String osVer;

    public BisClientInfo(BisClientInfo bisClientInfo) {
        super(bisClientInfo);
        if (bisClientInfo == null) {
            return;
        }
        this.model = bisClientInfo.model;
        this.os = bisClientInfo.os;
        this.osVer = bisClientInfo.osVer;
        this.clientVer = bisClientInfo.clientVer;
    }

    public BisClientInfo() {
    }

    public final BisClientInfo fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.model = (String) obj;
        } else if (i == 2) {
            this.os = (String) obj;
        } else if (i == 3) {
            this.osVer = (String) obj;
        } else if (i == 4) {
            this.clientVer = (String) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BisClientInfo) {
            BisClientInfo bisClientInfo = (BisClientInfo) obj;
            return equals(this.model, bisClientInfo.model) && equals(this.os, bisClientInfo.os) && equals(this.osVer, bisClientInfo.osVer) && equals(this.clientVer, bisClientInfo.clientVer);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.model;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.os;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            String str3 = this.osVer;
            int hashCode3 = str3 != null ? str3.hashCode() : 0;
            String str4 = this.clientVer;
            int hashCode4 = (((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + (str4 != null ? str4.hashCode() : 0);
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i;
    }
}
