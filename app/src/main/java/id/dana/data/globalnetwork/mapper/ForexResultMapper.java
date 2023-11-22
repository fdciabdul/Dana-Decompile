package id.dana.data.globalnetwork.mapper;

import id.dana.data.globalnetwork.model.ForexResult;
import id.dana.domain.globalnetwork.model.Forex;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ForexResultMapper {
    @Inject
    public ForexResultMapper() {
    }

    public Forex map(ForexResult forexResult) {
        if (forexResult == null || !forexResult.getCurrencyPair().contains("/")) {
            return new Forex();
        }
        Forex forex = new Forex();
        forex.setCurrency(forexResult.getCurrencyPair().split("/")[0]);
        forex.setRate(Double.parseDouble(forexResult.getPrice()));
        return forex;
    }

    public List<Forex> transform(List<ForexResult> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            ForexResult forexResult = list.get(i);
            Forex forex = new Forex();
            if (forexResult != null && forexResult.getCurrencyPair() != null && forexResult.getCurrencyPair().contains("/")) {
                forex.setCurrency(forexResult.getCurrencyPair().split("/")[0]);
                forex.setRate(Double.parseDouble(forexResult.getPrice()));
                arrayList.add(forex);
            }
        }
        return arrayList;
    }
}
