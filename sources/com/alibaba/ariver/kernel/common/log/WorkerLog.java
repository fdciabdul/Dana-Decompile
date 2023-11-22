package com.alibaba.ariver.kernel.common.log;

import com.alibaba.ariver.kernel.common.log.BaseAppLog;

/* loaded from: classes6.dex */
public class WorkerLog extends BaseAppLog {
    public static final String WORKER_LOG_STATE_ERROR = "error";
    public static final String WORKER_LOG_STATE_START = "start";
    public static final String WORKER_LOG_STATE_SUCCESS = "success";

    /* renamed from: a  reason: collision with root package name */
    private String f6142a;
    private String b;
    private String c;
    private Integer d;

    private WorkerLog(Builder builder) {
        super(builder);
        this.f6142a = builder.f6143a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
    }

    @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog
    public String toString() {
        char c;
        String state = getState();
        state.hashCode();
        int hashCode = state.hashCode();
        if (hashCode == -1867169789) {
            if (state.equals("success")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 96784904) {
            if (hashCode == 109757538 && state.equals("start")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (state.equals("error")) {
                c = 1;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c == 1) {
                String format = String.format("%s %s(%s) %s", baseInfo(), this.f6142a, String.valueOf(this.d), this.b);
                if (this.c != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(format);
                    sb.append(" ");
                    sb.append(this.c);
                    return sb.toString();
                }
                return format;
            } else if (c != 2) {
                return super.toString();
            }
        }
        String format2 = String.format("%s %s %s", baseInfo(), this.f6142a, this.b);
        if (this.c != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(format2);
            sb2.append(" ");
            sb2.append(this.c);
            return sb2.toString();
        }
        return format2;
    }

    public String getData() {
        return this.c;
    }

    /* loaded from: classes6.dex */
    public static class Builder extends BaseAppLog.Builder<Builder> {

        /* renamed from: a  reason: collision with root package name */
        private String f6143a;
        private String b;
        private String c;
        private Integer d;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public Builder getThis() {
            return this;
        }

        public Builder() {
            super(LogType.WORKER);
        }

        public Builder setAppId(String str) {
            this.f6143a = str;
            return getThis();
        }

        public Builder setTag(String str) {
            this.b = str;
            return getThis();
        }

        public Builder setDesc(String str) {
            this.c = str;
            return getThis();
        }

        public Builder setErrCode(int i) {
            this.d = Integer.valueOf(i);
            return getThis();
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public BaseAppLog build() {
            return new WorkerLog(this);
        }
    }
}
