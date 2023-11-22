package com.fullstory;

import android.view.View;
import android.webkit.WebView;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public class FS {
    public static final String EXCLUDE_CLASS = "fs-exclude";
    public static final String EXCLUDE_WITHOUT_CONSENT_CLASS = "fs-exclude-without-consent";
    public static final String MASK_CLASS = "fs-mask";
    public static final String MASK_WITHOUT_CONSENT_CLASS = "fs-mask-without-consent";
    public static final String OMIT_CLASS = "fs-omit";
    public static final String OMIT_WITHOUT_CONSENT_CLASS = "fs-omit-without-consent";
    public static final String UNMASK_CLASS = "fs-unmask";
    public static final String UNMASK_WITH_CONSENT_CLASS = "fs-unmask-with-consent";
    public static final String WATCH_CLASS = "fs-watch";
    public static final String WATCH_WITH_CONSENT_CLASS = "fs-watch-with-consent";

    /* loaded from: classes.dex */
    public enum LogLevel {
        OFF,
        LOG,
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    public static void __endPage(UUID uuid) {
        InstrumentInjector.__endPage(uuid);
    }

    public static void __internal(String str, Object obj) {
        InstrumentInjector.__sendInternalMessage(str, obj);
    }

    public static boolean __isPreviewMode() {
        return InstrumentInjector.isPreviewMode();
    }

    public static void __pageView(UUID uuid, String str, Map map) {
        InstrumentInjector.__pageView(uuid, str, map);
    }

    public static void __updatePageProperties(UUID uuid, Map map) {
        InstrumentInjector.__updatePageProperties(uuid, map);
    }

    public static void addClass(View view, String str) {
        InstrumentInjector.addClass(view, str);
    }

    public static void addClasses(View view, Collection collection) {
        InstrumentInjector.addClasses(view, collection);
    }

    public static void addPopupMenuClass(Object obj, String str) {
        InstrumentInjector.addPopupMenuClass(obj, str);
    }

    public static void anonymize() {
        InstrumentInjector.anonymize();
    }

    public static void consent(boolean z) {
        InstrumentInjector.consent(z);
    }

    public static void disableInjection(WebView webView) {
        InstrumentInjector.disableInjection(webView);
    }

    public static void event(String str, Map map) {
        InstrumentInjector.event(str, map);
    }

    public static void exclude(View view) {
        InstrumentInjector.addClass(view, EXCLUDE_CLASS);
    }

    public static void excludePopupMenu(Object obj) {
        InstrumentInjector.addPopupMenuClass(obj, EXCLUDE_CLASS);
    }

    public static void excludePopupMenuWithoutConsent(Object obj) {
        InstrumentInjector.addPopupMenuClass(obj, EXCLUDE_WITHOUT_CONSENT_CLASS);
    }

    public static void excludeWithoutConsent(View view) {
        InstrumentInjector.addClass(view, EXCLUDE_WITHOUT_CONSENT_CLASS);
    }

    public static String getCurrentSession() {
        return InstrumentInjector.getCurrentSession();
    }

    public static String getCurrentSessionURL() {
        return InstrumentInjector.getCurrentSessionURL(false);
    }

    public static String getCurrentSessionURL(boolean z) {
        return InstrumentInjector.getCurrentSessionURL(z);
    }

    public static void identify(String str) {
        InstrumentInjector.updateUser(str, null);
    }

    public static void identify(String str, Map map) {
        InstrumentInjector.updateUser(str, map);
    }

    public static void log(LogLevel logLevel, String str) {
        InstrumentInjector.log(logLevel, str);
    }

    public static void mask(View view) {
        InstrumentInjector.addClass(view, MASK_CLASS);
    }

    public static void maskPopupMenu(Object obj) {
        InstrumentInjector.addPopupMenuClass(obj, MASK_CLASS);
    }

    public static void maskPopupMenuWithoutConsent(Object obj) {
        InstrumentInjector.addPopupMenuClass(obj, MASK_WITHOUT_CONSENT_CLASS);
    }

    public static void maskWithoutConsent(View view) {
        InstrumentInjector.addClass(view, MASK_WITHOUT_CONSENT_CLASS);
    }

    public static FSPage page(String str) {
        return page(str, null);
    }

    public static FSPage page(String str, Map map) {
        return InstrumentInjector.page(str, map);
    }

    public static void removeAllClasses(View view) {
        InstrumentInjector.removeAllClasses(view);
    }

    public static void removeAttribute(View view, String str) {
        InstrumentInjector.removeAttribute(view, str);
    }

    public static void removeClass(View view, String str) {
        InstrumentInjector.removeClass(view, str);
    }

    public static void removeClasses(View view, Collection collection) {
        InstrumentInjector.removeClasses(view, collection);
    }

    public static void removePopupMenuClass(Object obj, String str) {
        InstrumentInjector.removePopupMenuClass(obj, str);
    }

    public static void resetIdleTimer() {
        InstrumentInjector.resetIdleTimer();
    }

    public static void restart() {
        InstrumentInjector.restart();
    }

    public static void setAttribute(View view, String str, String str2) {
        InstrumentInjector.setAttribute(view, str, str2);
    }

    public static void setReadyListener(FSOnReadyListener fSOnReadyListener) {
        InstrumentInjector.setReadyListener(fSOnReadyListener);
    }

    public static void setTagName(View view, String str) {
        InstrumentInjector.setTagName(view, str);
    }

    public static void setUserVars(Map map) {
        InstrumentInjector.updateUser(null, map);
    }

    public static void shutdown() {
        InstrumentInjector.shutdown();
    }

    public static void unmask(View view) {
        InstrumentInjector.addClass(view, UNMASK_CLASS);
    }

    public static void unmaskPopupMenu(Object obj) {
        InstrumentInjector.addPopupMenuClass(obj, UNMASK_CLASS);
    }

    public static void unmaskPopupMenuWithConsent(Object obj) {
        InstrumentInjector.addPopupMenuClass(obj, UNMASK_WITH_CONSENT_CLASS);
    }

    public static void unmaskWithConsent(View view) {
        InstrumentInjector.addClass(view, UNMASK_WITH_CONSENT_CLASS);
    }
}
