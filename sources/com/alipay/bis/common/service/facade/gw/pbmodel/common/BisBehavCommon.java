package com.alipay.bis.common.service.facade.gw.pbmodel.common;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;

/* loaded from: classes2.dex */
public final class BisBehavCommon extends Message {
    public static final String DEFAULT_INVTP = "";
    public static final String DEFAULT_RETRY = "";
    public static final String DEFAULT_TM = "";
    public static final int TAG_INVTP = 1;
    public static final int TAG_RETRY = 3;
    public static final int TAG_TM = 2;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public String invtp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public String retry;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public String tm;

    public BisBehavCommon(BisBehavCommon bisBehavCommon) {
        super(bisBehavCommon);
        if (bisBehavCommon == null) {
            return;
        }
        this.invtp = bisBehavCommon.invtp;
        this.tm = bisBehavCommon.tm;
        this.retry = bisBehavCommon.retry;
    }

    public BisBehavCommon() {
    }

    public final BisBehavCommon fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.invtp = (String) obj;
        } else if (i == 2) {
            this.tm = (String) obj;
        } else if (i == 3) {
            this.retry = (String) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BisBehavCommon) {
            BisBehavCommon bisBehavCommon = (BisBehavCommon) obj;
            return equals(this.invtp, bisBehavCommon.invtp) && equals(this.tm, bisBehavCommon.tm) && equals(this.retry, bisBehavCommon.retry);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.invtp;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.tm;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            String str3 = this.retry;
            int hashCode3 = (((hashCode * 37) + hashCode2) * 37) + (str3 != null ? str3.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i;
    }
}
