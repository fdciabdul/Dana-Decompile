package io.split.android.client;

import com.google.common.base.Preconditions;
import io.split.android.client.api.SplitView;
import io.split.android.client.dtos.Partition;
import io.split.android.client.dtos.Split;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.SplitValidator;
import io.split.android.client.validators.ValidationErrorInfo;
import io.split.android.client.validators.ValidationMessageLogger;
import io.split.android.client.validators.ValidationMessageLoggerImpl;
import io.split.android.engine.experiments.ParsedCondition;
import io.split.android.engine.experiments.ParsedSplit;
import io.split.android.engine.experiments.SplitParser;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class SplitManagerImpl implements SplitManager {
    private final SplitParser _splitParser;
    private final SplitValidator _splitValidator;
    private final SplitsStorage _splitsStorage;
    private boolean _isManagerDestroyed = false;
    private final ValidationMessageLogger _validationMessageLogger = new ValidationMessageLoggerImpl();

    public SplitManagerImpl(SplitsStorage splitsStorage, SplitValidator splitValidator, SplitParser splitParser) {
        this._splitsStorage = (SplitsStorage) Preconditions.checkNotNull(splitsStorage);
        this._splitValidator = (SplitValidator) Preconditions.checkNotNull(splitValidator);
        this._splitParser = (SplitParser) Preconditions.checkNotNull(splitParser);
    }

    @Override // io.split.android.client.SplitManager
    public List<SplitView> splits() {
        ArrayList arrayList = new ArrayList();
        try {
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error getting feature flags: ");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
        }
        if (this._isManagerDestroyed) {
            Logger.e("Manager has already been destroyed - no calls possible");
            return arrayList;
        }
        Map<String, Split> all = this._splitsStorage.getAll();
        if (all != null && all.size() > 0) {
            Iterator<Split> it = this._splitsStorage.getAll().values().iterator();
            while (it.hasNext()) {
                ParsedSplit KClassImpl$Data$declaredNonStaticMembers$2 = this._splitParser.KClassImpl$Data$declaredNonStaticMembers$2(it.next(), null);
                if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    arrayList.add(toSplitView(KClassImpl$Data$declaredNonStaticMembers$2));
                }
            }
        }
        return arrayList;
    }

    @Override // io.split.android.client.SplitManager
    public SplitView split(String str) {
        try {
            if (this._isManagerDestroyed) {
                Logger.e("Manager has already been destroyed - no calls possible");
                return null;
            }
            ValidationErrorInfo validateName = this._splitValidator.validateName(str);
            if (validateName != null) {
                this._validationMessageLogger.log(validateName, "split");
                if (validateName.isError()) {
                    return null;
                }
                str = str.trim();
            }
            Split split = this._splitsStorage.get(str);
            ParsedSplit KClassImpl$Data$declaredNonStaticMembers$2 = split != null ? this._splitParser.KClassImpl$Data$declaredNonStaticMembers$2(split, null) : null;
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                this._validationMessageLogger.w(this._splitValidator.splitNotFoundMessage(str), "split");
                return null;
            }
            return toSplitView(KClassImpl$Data$declaredNonStaticMembers$2);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error getting split: ");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
            return null;
        }
    }

    @Override // io.split.android.client.SplitManager
    public List<String> splitNames() {
        ArrayList arrayList = new ArrayList();
        try {
            if (this._isManagerDestroyed) {
                Logger.e("Manager has already been destroyed - no calls possible");
                return arrayList;
            }
            Map<String, Split> all = this._splitsStorage.getAll();
            if (all != null && all.size() > 0) {
                Iterator<Split> it = all.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().name);
                }
            }
            return arrayList;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error getting feature flags: ");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
            return arrayList;
        }
    }

    @Override // io.split.android.client.SplitManager
    public void destroy() {
        this._isManagerDestroyed = true;
    }

    private SplitView toSplitView(ParsedSplit parsedSplit) {
        SplitView splitView = new SplitView();
        splitView.name = parsedSplit.getErrorConfigVersion;
        splitView.trafficType = parsedSplit.lookAheadTest;
        splitView.killed = parsedSplit.PlaceComponentResult();
        splitView.changeNumber = parsedSplit.BuiltInFictitiousFunctionClassFactory;
        splitView.configs = parsedSplit.KClassImpl$Data$declaredNonStaticMembers$2;
        HashSet hashSet = new HashSet();
        Iterator<ParsedCondition> it = parsedSplit.PlaceComponentResult.iterator();
        while (it.hasNext()) {
            Iterator<Partition> it2 = it.next().getAuthRequestContext.iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next().treatment);
            }
        }
        hashSet.add(parsedSplit.getAuthRequestContext);
        splitView.treatments = new ArrayList(hashSet);
        return splitView;
    }
}
