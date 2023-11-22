package id.dana.sendmoney.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface RecipientSource {
    public static final String ALL_CONTACTS = "All Contacts";
    public static final String BANK_LIST_PAGE_ADD_NEW_BANK = "Bank Page - (Add New Bank)";
    public static final String BANK_PAGE = "Bank Page";
    public static final String CONTACT_PAGE_MANUAL_INPUT = "Contact Page Manual Input";
    public static final String DEEPLINK = "Deeplink";
    public static final String MANUAL_INPUT = "Manual Input";
    public static final String QUICK_SEND = "Quick Send";
    public static final String RECENT = "Recent";
    public static final String REQ_MONEY_BANK_WITHOUT_AMOUNT = "Request Money Bank - (Without Amount)";
    public static final String REQ_MONEY_BANK_WITH_AMOUNT = "Request Money Bank - (With Amount)";
    public static final String REQ_MONEY_USER_WITHOUT_AMOUNT = "Request Money User - (Without Amount)";
    public static final String REQ_MONEY_USER_WITH_AMOUNT = "Request Money User - (With Amount)";
    public static final String SEARCH = "Search";
    public static final String SEARCH_MANUAL_INPUT = "Search Manual Input";
    public static final String SEARCH_PAGE_ADD_NEW_BANK = "Search Page - (Add New Bank)";
}
