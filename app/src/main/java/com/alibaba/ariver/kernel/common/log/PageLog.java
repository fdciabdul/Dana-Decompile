package com.alibaba.ariver.kernel.common.log;

import com.alibaba.ariver.kernel.common.log.BaseAppLog;

/* loaded from: classes6.dex */
public class PageLog extends BaseAppLog {
    public static final String PAGE_LOG_STATE_FAIL = "fail";
    public static final String PAGE_LOG_STATE_FINISH = "finish";
    public static final String PAGE_LOG_STATE_START = "start";
    public static final String PAGE_LOG_TAGS = "tags";

    /* renamed from: a  reason: collision with root package name */
    private String f6140a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private PageSource g;
    private String h;

    private PageLog(Builder builder) {
        super(builder);
        this.f6140a = builder.b;
        this.b = builder.f6141a;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.g = builder.g;
        this.f = builder.f;
        this.h = builder.h;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog
    public String toString() {
        char c;
        String baseInfo = baseInfo();
        String state = getState();
        switch (state.hashCode()) {
            case -1274442605:
                if (state.equals("finish")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3135262:
                if (state.equals("fail")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3552281:
                if (state.equals(PAGE_LOG_TAGS)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 109757538:
                if (state.equals("start")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            if (this.g != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(baseInfo);
                sb.append(" ");
                sb.append(this.f6140a);
                sb.append(", source:");
                sb.append(this.g.sourceType.getRaw());
                sb.append(" from ");
                sb.append(this.g.sourceDesc);
                sb.append(", ");
                sb.append(this.e);
                sb.append(", ");
                sb.append(this.f);
                sb.append(", ");
                sb.append(this.g.sourcePageAppLogToken);
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(baseInfo);
            sb2.append(" ");
            sb2.append(this.f6140a);
            sb2.append(", ");
            sb2.append(this.e);
            return sb2.toString();
        } else if (c == 1) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(baseInfo);
            sb3.append(" ");
            sb3.append(this.f6140a);
            sb3.append(", ");
            sb3.append(this.d);
            sb3.append(" ");
            sb3.append(this.c);
            return sb3.toString();
        } else if (c == 2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(baseInfo);
            sb4.append(" error:");
            sb4.append(this.b);
            sb4.append(" warning:");
            sb4.append(this.h);
            sb4.append(" title:");
            sb4.append(this.d);
            return sb4.toString();
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(baseInfo);
            sb5.append(" ");
            sb5.append(this.f6140a);
            sb5.append(", ");
            sb5.append(this.b);
            return sb5.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static class Builder extends BaseAppLog.Builder<Builder> {

        /* renamed from: a  reason: collision with root package name */
        private String f6141a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private PageSource g;
        private String h;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public Builder getThis() {
            return this;
        }

        public Builder() {
            super(LogType.PAGE);
        }

        public Builder setUrl(String str) {
            this.b = str;
            return getThis();
        }

        public Builder setErrMsg(String str) {
            this.f6141a = str;
            return getThis();
        }

        public Builder setWarningMsg(String str) {
            this.h = str;
            return getThis();
        }

        public Builder setRefer(String str) {
            this.c = str;
            return getThis();
        }

        public Builder setTitle(String str) {
            this.d = str;
            return getThis();
        }

        public Builder setToken(String str) {
            this.e = str;
            return getThis();
        }

        public Builder setPageSource(PageSource pageSource) {
            this.g = pageSource;
            return getThis();
        }

        public Builder setAppStartSessionToken(String str) {
            this.f = str;
            return getThis();
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public Builder setGroupId(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_Page");
            return (Builder) super.setGroupId(sb.toString());
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public BaseAppLog build() {
            return new PageLog(this);
        }
    }
}
