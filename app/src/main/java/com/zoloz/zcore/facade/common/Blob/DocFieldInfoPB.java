package com.zoloz.zcore.facade.common.Blob;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;

/* loaded from: classes2.dex */
public final class DocFieldInfoPB extends Message {
    public static final String DEFAULT_FEATURE = "";
    public static final String DEFAULT_FEAVER = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_VALUE = "";
    public static final int TAG_FEATURE = 3;
    public static final int TAG_FEAVER = 4;
    public static final int TAG_NAME = 1;
    public static final int TAG_VALUE = 2;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public String feaVer;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public String feature;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public String name;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public String value;

    public DocFieldInfoPB(DocFieldInfoPB docFieldInfoPB) {
        super(docFieldInfoPB);
        if (docFieldInfoPB == null) {
            return;
        }
        this.name = docFieldInfoPB.name;
        this.value = docFieldInfoPB.value;
        this.feature = docFieldInfoPB.feature;
        this.feaVer = docFieldInfoPB.feaVer;
    }

    public DocFieldInfoPB() {
    }

    public final DocFieldInfoPB fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.name = (String) obj;
        } else if (i == 2) {
            this.value = (String) obj;
        } else if (i == 3) {
            this.feature = (String) obj;
        } else if (i == 4) {
            this.feaVer = (String) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DocFieldInfoPB) {
            DocFieldInfoPB docFieldInfoPB = (DocFieldInfoPB) obj;
            return equals(this.name, docFieldInfoPB.name) && equals(this.value, docFieldInfoPB.value) && equals(this.feature, docFieldInfoPB.feature) && equals(this.feaVer, docFieldInfoPB.feaVer);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.name;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.value;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            String str3 = this.feature;
            int hashCode3 = str3 != null ? str3.hashCode() : 0;
            String str4 = this.feaVer;
            int hashCode4 = (((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + (str4 != null ? str4.hashCode() : 0);
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i;
    }
}
