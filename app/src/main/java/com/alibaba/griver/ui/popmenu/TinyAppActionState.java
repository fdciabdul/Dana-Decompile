package com.alibaba.griver.ui.popmenu;

import android.content.res.Resources;
import com.alibaba.griver.ui.R;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class TinyAppActionState {
    public static final String ACTION_BLUE_TOOTH = "bluetooth";
    public static final String ACTION_LOCATION = "location";
    public static final String ACTION_RECORD = "record";

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Integer> f6724a = new HashMap();
    private String b;
    private boolean c;
    private int d;

    public TinyAppActionState(String str, boolean z) {
        this.b = str;
        this.c = z;
    }

    public String getAction() {
        return this.b;
    }

    public void increaseCount(String str) {
        Integer num = this.f6724a.get(str);
        if (num == null) {
            this.f6724a.put(str, 1);
            this.d++;
        } else if (this.c) {
            this.f6724a.put(str, Integer.valueOf(num.intValue() + 1));
            this.d++;
        }
    }

    public void decreaseCount(String str) {
        if (this.f6724a.get(str) != null) {
            Integer valueOf = Integer.valueOf(r0.intValue() - 1);
            if (valueOf.intValue() == 0) {
                this.f6724a.remove(str);
            } else {
                this.f6724a.put(str, valueOf);
            }
            this.d--;
        }
    }

    public int getCount() {
        return this.d;
    }

    public String getIconUnicode(Resources resources) {
        char c;
        String str = this.b;
        str.hashCode();
        int hashCode = str.hashCode();
        if (hashCode == -934908847) {
            if (str.equals(ACTION_RECORD)) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 1901043637) {
            if (hashCode == 1968882350 && str.equals(ACTION_BLUE_TOOTH)) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("location")) {
                c = 1;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    return null;
                }
                return resources.getString(R.string.griver_menu_mini_bluetooth);
            }
            return resources.getString(R.string.griver_menu_mini_location);
        }
        return resources.getString(R.string.griver_menu_mini_record);
    }

    public String getTips(Resources resources) {
        char c;
        String str = this.b;
        str.hashCode();
        int hashCode = str.hashCode();
        if (hashCode == -934908847) {
            if (str.equals(ACTION_RECORD)) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 1901043637) {
            if (hashCode == 1968882350 && str.equals(ACTION_BLUE_TOOTH)) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("location")) {
                c = 1;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    return null;
                }
                return resources.getString(R.string.griver_menu_tiny_use_bluetooth);
            }
            return resources.getString(R.string.griver_menu_tiny_use_location);
        }
        return resources.getString(R.string.griver_menu_tiny_recording);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TinyAppActionState{mAction='");
        sb.append(this.b);
        sb.append('\'');
        sb.append(", mDuplicate=");
        sb.append(this.c);
        sb.append(", mTypeMap=");
        sb.append(this.f6724a);
        sb.append(", mCount=");
        sb.append(this.d);
        sb.append('}');
        return sb.toString();
    }
}
