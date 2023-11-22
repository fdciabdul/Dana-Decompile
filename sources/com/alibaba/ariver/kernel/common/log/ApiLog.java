package com.alibaba.ariver.kernel.common.log;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.log.BaseAppLog;

/* loaded from: classes3.dex */
public class ApiLog extends BaseAppLog {
    public static final String API_LOG_STATE_ERROR = "error";
    public static final String API_LOG_STATE_START = "start";
    public static final String API_LOG_STATE_SUCCESS = "success";

    /* renamed from: a  reason: collision with root package name */
    private String f6127a;
    private String b;
    private Integer c;
    private String d;

    private ApiLog(Builder builder) {
        super(builder);
        this.f6127a = builder.b;
        this.b = builder.f6128a;
        this.c = builder.c;
        this.d = builder.d;
    }

    @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog
    public String toString() {
        String str;
        String baseInfo = baseInfo();
        if (TextUtils.isEmpty(getState())) {
            return super.toString();
        }
        String state = getState();
        state.hashCode();
        char c = 65535;
        int hashCode = state.hashCode();
        if (hashCode != -1867169789) {
            if (hashCode != 96784904) {
                if (hashCode == 109757538 && state.equals("start")) {
                    c = 2;
                }
            } else if (state.equals("error")) {
                c = 1;
            }
        } else if (state.equals("success")) {
            c = 0;
        }
        String str2 = "";
        if (c != 0) {
            if (c == 1) {
                if (this.c != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("(");
                    sb.append(this.c.toString());
                    sb.append(") ");
                    str = sb.toString();
                } else {
                    str = "";
                }
                if (!TextUtils.isEmpty(this.b)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(this.b);
                    sb2.append(" ");
                    str = sb2.toString();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(baseInfo);
                sb3.append(" ");
                sb3.append(str);
                if (!TextUtils.isEmpty(this.d)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(this.d);
                    sb4.append(" ");
                    str2 = sb4.toString();
                }
                sb3.append(str2);
                sb3.append(this.f6127a);
                return sb3.toString();
            } else if (c != 2) {
                return super.toString();
            }
        }
        if (TextUtils.isEmpty(this.b)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(baseInfo);
            sb5.append(" ");
            if (!TextUtils.isEmpty(this.d)) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(this.d);
                sb6.append(" ");
                str2 = sb6.toString();
            }
            sb5.append(str2);
            sb5.append(this.f6127a);
            return sb5.toString();
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append(baseInfo);
        sb7.append(" ");
        sb7.append(this.b);
        sb7.append(" ");
        if (!TextUtils.isEmpty(this.d)) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append(this.d);
            sb8.append(" ");
            str2 = sb8.toString();
        }
        sb7.append(str2);
        sb7.append(this.f6127a);
        return sb7.toString();
    }

    public String getData() {
        return this.f6127a;
    }

    /* loaded from: classes3.dex */
    public static class Builder extends BaseAppLog.Builder<Builder> {

        /* renamed from: a  reason: collision with root package name */
        private String f6128a;
        private String b;
        private Integer c;
        private String d;

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public Builder getThis() {
            return this;
        }

        public Builder() {
            super(LogType.API);
        }

        public Builder setApiName(String str) {
            this.f6128a = str;
            return getThis();
        }

        public Builder setData(String str) {
            this.b = str;
            return getThis();
        }

        public Builder setErrCode(int i) {
            this.c = Integer.valueOf(i);
            return getThis();
        }

        public Builder setCallMode(String str) {
            this.d = str;
            return getThis();
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public BaseAppLog build() {
            return new ApiLog(this);
        }
    }
}
