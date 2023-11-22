package com.alibaba.ariver.resource.api.appinfo;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AppUpdaterFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final List<Rule> f6201a = new ArrayList();

    /* loaded from: classes3.dex */
    public interface Rule {
        IAppUpdater findUpdater(String str, Bundle bundle);
    }

    public static void clearRules() {
        List<Rule> list = f6201a;
        synchronized (list) {
            list.clear();
        }
    }

    public static void registerRule(Rule rule) {
        List<Rule> list = f6201a;
        synchronized (list) {
            list.add(rule);
        }
    }

    public static void unRegisterRule(Rule rule) {
        List<Rule> list = f6201a;
        synchronized (list) {
            list.remove(rule);
        }
    }

    public static IAppUpdater createUpdater(String str, Bundle bundle) {
        List<Rule> list = f6201a;
        synchronized (list) {
            for (int size = list.size() - 1; size >= 0; size--) {
                IAppUpdater findUpdater = f6201a.get(size).findUpdater(str, bundle);
                if (findUpdater != null) {
                    return findUpdater;
                }
            }
            return null;
        }
    }
}
