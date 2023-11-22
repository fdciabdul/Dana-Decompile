package com.zoloz.zhub.endpoint.gwfacade.zhubalipay.empty.UnifiedContentPb;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;

/* loaded from: classes2.dex */
public final class MetaPbPB extends Message {
    public static final String DEFAULT_BISTOKEN = "";
    public static final String DEFAULT_COLLECTINFOSTR = "";
    public static final String DEFAULT_EXTINFO = "";
    public static final String DEFAULT_INVTPTYPE = "";
    public static final String DEFAULT_SCORESTR = "";
    public static final Integer DEFAULT_SERIALIZE = 0;
    public static final String DEFAULT_TYPE = "";
    public static final String DEFAULT_VERSION = "";
    public static final int TAG_BISTOKEN = 6;
    public static final int TAG_COLLECTINFOSTR = 4;
    public static final int TAG_EXTINFO = 8;
    public static final int TAG_INVTPTYPE = 7;
    public static final int TAG_SCORESTR = 3;
    public static final int TAG_SERIALIZE = 5;
    public static final int TAG_TYPE = 2;
    public static final int TAG_VERSION = 1;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public String bistoken;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public String collectInfoStr;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public String extInfo;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public String invtpType;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public String scoreStr;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public Integer serialize;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public String type;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public String version;

    public MetaPbPB(MetaPbPB metaPbPB) {
        super(metaPbPB);
        if (metaPbPB == null) {
            return;
        }
        this.version = metaPbPB.version;
        this.type = metaPbPB.type;
        this.scoreStr = metaPbPB.scoreStr;
        this.collectInfoStr = metaPbPB.collectInfoStr;
        this.serialize = metaPbPB.serialize;
        this.bistoken = metaPbPB.bistoken;
        this.invtpType = metaPbPB.invtpType;
        this.extInfo = metaPbPB.extInfo;
    }

    public MetaPbPB() {
    }

    public final MetaPbPB fillTagValue(int i, Object obj) {
        switch (i) {
            case 1:
                this.version = (String) obj;
                break;
            case 2:
                this.type = (String) obj;
                break;
            case 3:
                this.scoreStr = (String) obj;
                break;
            case 4:
                this.collectInfoStr = (String) obj;
                break;
            case 5:
                this.serialize = (Integer) obj;
                break;
            case 6:
                this.bistoken = (String) obj;
                break;
            case 7:
                this.invtpType = (String) obj;
                break;
            case 8:
                this.extInfo = (String) obj;
                break;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MetaPbPB) {
            MetaPbPB metaPbPB = (MetaPbPB) obj;
            return equals(this.version, metaPbPB.version) && equals(this.type, metaPbPB.type) && equals(this.scoreStr, metaPbPB.scoreStr) && equals(this.collectInfoStr, metaPbPB.collectInfoStr) && equals(this.serialize, metaPbPB.serialize) && equals(this.bistoken, metaPbPB.bistoken) && equals(this.invtpType, metaPbPB.invtpType) && equals(this.extInfo, metaPbPB.extInfo);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.version;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.type;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            String str3 = this.scoreStr;
            int hashCode3 = str3 != null ? str3.hashCode() : 0;
            String str4 = this.collectInfoStr;
            int hashCode4 = str4 != null ? str4.hashCode() : 0;
            Integer num = this.serialize;
            int hashCode5 = num != null ? num.hashCode() : 0;
            String str5 = this.bistoken;
            int hashCode6 = str5 != null ? str5.hashCode() : 0;
            String str6 = this.invtpType;
            int hashCode7 = str6 != null ? str6.hashCode() : 0;
            String str7 = this.extInfo;
            int hashCode8 = (((((((((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + hashCode5) * 37) + hashCode6) * 37) + hashCode7) * 37) + (str7 != null ? str7.hashCode() : 0);
            this.hashCode = hashCode8;
            return hashCode8;
        }
        return i;
    }
}
