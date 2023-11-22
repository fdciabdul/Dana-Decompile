package com.zoloz.zhub.endpoint.gwfacade.zhubalipay.empty;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;

/* loaded from: classes2.dex */
public final class EntryStringString extends Message {
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_VALUE = "";
    public static final int TAG_KEY = 1;
    public static final int TAG_VALUE = 2;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public String key;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public String value;

    public EntryStringString(EntryStringString entryStringString) {
        super(entryStringString);
        if (entryStringString == null) {
            return;
        }
        this.key = entryStringString.key;
        this.value = entryStringString.value;
    }

    public EntryStringString() {
    }

    public final EntryStringString fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.key = (String) obj;
        } else if (i == 2) {
            this.value = (String) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EntryStringString) {
            EntryStringString entryStringString = (EntryStringString) obj;
            return equals(this.key, entryStringString.key) && equals(this.value, entryStringString.value);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.key;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.value;
            int hashCode2 = (hashCode * 37) + (str2 != null ? str2.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i;
    }
}
