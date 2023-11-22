package id.dana.danah5.globalnetwork.model.request;

import java.util.List;

/* loaded from: classes2.dex */
public class InquiryForexRateEntity {
    private String lastUpdated;
    private List<Query> queries;

    public List<Query> getQueries() {
        return this.queries;
    }

    public void setQueries(List<Query> list) {
        this.queries = list;
    }

    public String getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(String str) {
        this.lastUpdated = str;
    }

    /* loaded from: classes8.dex */
    public class Query {
        private String from;
        private String to;

        public Query() {
        }

        public String getFrom() {
            return this.from;
        }

        public void setFrom(String str) {
            this.from = str;
        }

        public String getTo() {
            return this.to;
        }

        public void setTo(String str) {
            this.to = str;
        }
    }
}
