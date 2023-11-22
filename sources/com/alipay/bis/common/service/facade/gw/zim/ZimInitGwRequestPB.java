package com.alipay.bis.common.service.facade.gw.zim;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;

/* loaded from: classes2.dex */
public final class ZimInitGwRequestPB extends Message {
    public static final String DEFAULT_BIZDATA = "";
    public static final String DEFAULT_CHANNEL = "";
    public static final String DEFAULT_MERCHANT = "";
    public static final String DEFAULT_METAINFO = "";
    public static final String DEFAULT_PRODUCENODE = "";
    public static final String DEFAULT_PRODUCTNAME = "";
    public static final String DEFAULT_ZIMID = "";
    public static final int TAG_BIZDATA = 6;
    public static final int TAG_CHANNEL = 2;
    public static final int TAG_MERCHANT = 3;
    public static final int TAG_METAINFO = 7;
    public static final int TAG_PRODUCENODE = 5;
    public static final int TAG_PRODUCTNAME = 4;
    public static final int TAG_ZIMID = 1;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public String bizData;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public String channel;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public String merchant;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public String metaInfo;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public String produceNode;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public String productName;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public String zimId;

    public ZimInitGwRequestPB(ZimInitGwRequestPB zimInitGwRequestPB) {
        super(zimInitGwRequestPB);
        if (zimInitGwRequestPB == null) {
            return;
        }
        this.zimId = zimInitGwRequestPB.zimId;
        this.channel = zimInitGwRequestPB.channel;
        this.merchant = zimInitGwRequestPB.merchant;
        this.productName = zimInitGwRequestPB.productName;
        this.produceNode = zimInitGwRequestPB.produceNode;
        this.bizData = zimInitGwRequestPB.bizData;
        this.metaInfo = zimInitGwRequestPB.metaInfo;
    }

    public ZimInitGwRequestPB() {
    }

    public final ZimInitGwRequestPB fillTagValue(int i, Object obj) {
        switch (i) {
            case 1:
                this.zimId = (String) obj;
                break;
            case 2:
                this.channel = (String) obj;
                break;
            case 3:
                this.merchant = (String) obj;
                break;
            case 4:
                this.productName = (String) obj;
                break;
            case 5:
                this.produceNode = (String) obj;
                break;
            case 6:
                this.bizData = (String) obj;
                break;
            case 7:
                this.metaInfo = (String) obj;
                break;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ZimInitGwRequestPB) {
            ZimInitGwRequestPB zimInitGwRequestPB = (ZimInitGwRequestPB) obj;
            return equals(this.zimId, zimInitGwRequestPB.zimId) && equals(this.channel, zimInitGwRequestPB.channel) && equals(this.merchant, zimInitGwRequestPB.merchant) && equals(this.productName, zimInitGwRequestPB.productName) && equals(this.produceNode, zimInitGwRequestPB.produceNode) && equals(this.bizData, zimInitGwRequestPB.bizData) && equals(this.metaInfo, zimInitGwRequestPB.metaInfo);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.zimId;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.channel;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            String str3 = this.merchant;
            int hashCode3 = str3 != null ? str3.hashCode() : 0;
            String str4 = this.productName;
            int hashCode4 = str4 != null ? str4.hashCode() : 0;
            String str5 = this.produceNode;
            int hashCode5 = str5 != null ? str5.hashCode() : 0;
            String str6 = this.bizData;
            int hashCode6 = str6 != null ? str6.hashCode() : 0;
            String str7 = this.metaInfo;
            int hashCode7 = (((((((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + hashCode5) * 37) + hashCode6) * 37) + (str7 != null ? str7.hashCode() : 0);
            this.hashCode = hashCode7;
            return hashCode7;
        }
        return i;
    }
}
