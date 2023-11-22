package com.alipay.bis.common.service.facade.gw.pbmodel.common;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;

/* loaded from: classes2.dex */
public final class ClientConfigContentPB extends Message {
    public static final String DEFAULT_ANDROIDCFG = "";
    public static final String DEFAULT_H5CFG = "";
    public static final String DEFAULT_IOSCFG = "";
    public static final String DEFAULT_TOKEN = "";
    public static final int TAG_ANDROIDCFG = 5;
    public static final int TAG_H5CFG = 7;
    public static final int TAG_IOSCFG = 6;
    public static final int TAG_SAMPLEMODE = 3;
    public static final int TAG_TOKEN = 1;
    public static final int TAG_TYPE = 2;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public String androidcfg;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public String h5cfg;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public String ioscfg;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public Integer sampleMode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public String token;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public Integer type;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_SAMPLEMODE = 0;

    public ClientConfigContentPB(ClientConfigContentPB clientConfigContentPB) {
        super(clientConfigContentPB);
        if (clientConfigContentPB == null) {
            return;
        }
        this.token = clientConfigContentPB.token;
        this.type = clientConfigContentPB.type;
        this.sampleMode = clientConfigContentPB.sampleMode;
        this.androidcfg = clientConfigContentPB.androidcfg;
        this.ioscfg = clientConfigContentPB.ioscfg;
        this.h5cfg = clientConfigContentPB.h5cfg;
    }

    public ClientConfigContentPB() {
    }

    public final ClientConfigContentPB fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.token = (String) obj;
        } else if (i == 2) {
            this.type = (Integer) obj;
        } else if (i == 3) {
            this.sampleMode = (Integer) obj;
        } else if (i == 5) {
            this.androidcfg = (String) obj;
        } else if (i == 6) {
            this.ioscfg = (String) obj;
        } else if (i == 7) {
            this.h5cfg = (String) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ClientConfigContentPB) {
            ClientConfigContentPB clientConfigContentPB = (ClientConfigContentPB) obj;
            return equals(this.token, clientConfigContentPB.token) && equals(this.type, clientConfigContentPB.type) && equals(this.sampleMode, clientConfigContentPB.sampleMode) && equals(this.androidcfg, clientConfigContentPB.androidcfg) && equals(this.ioscfg, clientConfigContentPB.ioscfg) && equals(this.h5cfg, clientConfigContentPB.h5cfg);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.token;
            int hashCode = str != null ? str.hashCode() : 0;
            Integer num = this.type;
            int hashCode2 = num != null ? num.hashCode() : 0;
            Integer num2 = this.sampleMode;
            int hashCode3 = num2 != null ? num2.hashCode() : 0;
            String str2 = this.androidcfg;
            int hashCode4 = str2 != null ? str2.hashCode() : 0;
            String str3 = this.ioscfg;
            int hashCode5 = str3 != null ? str3.hashCode() : 0;
            String str4 = this.h5cfg;
            int hashCode6 = (((((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + hashCode5) * 37) + (str4 != null ? str4.hashCode() : 0);
            this.hashCode = hashCode6;
            return hashCode6;
        }
        return i;
    }
}
