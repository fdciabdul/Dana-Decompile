package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Log extends CrashlyticsReport.Session.Event.Log {
    private final String content;

    private AutoValue_CrashlyticsReport_Session_Event_Log(String str) {
        this.content = str;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log
    public final String getContent() {
        return this.content;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Log{content=");
        sb.append(this.content);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Log) {
            return this.content.equals(((CrashlyticsReport.Session.Event.Log) obj).getContent());
        }
        return false;
    }

    public final int hashCode() {
        return this.content.hashCode() ^ 1000003;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Log.Builder {
        private String content;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder
        public final CrashlyticsReport.Session.Event.Log.Builder setContent(String str) {
            if (str == null) {
                throw new NullPointerException("Null content");
            }
            this.content = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder
        public final CrashlyticsReport.Session.Event.Log build() {
            String str;
            if (this.content == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" content");
                str = sb.toString();
            } else {
                str = "";
            }
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Missing required properties:");
                sb2.append(str);
                throw new IllegalStateException(sb2.toString());
            }
            return new AutoValue_CrashlyticsReport_Session_Event_Log(this.content);
        }
    }
}
