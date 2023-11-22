package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class AccountPicker {

    /* loaded from: classes7.dex */
    public static class AccountChooserOptions {
        private Account zza;
        private boolean zzb;
        private ArrayList zzc;
        private ArrayList zzd;
        private boolean zze;
        private String zzf;
        private Bundle zzg;
        private boolean zzh;
        private int zzi;
        private String zzj;
        private boolean zzk;
        private zza zzl;
        private String zzm;
        private boolean zzn;
        private boolean zzo;

        /* loaded from: classes7.dex */
        public static class Builder {
            private Account zza;
            private ArrayList zzb;
            private ArrayList zzc;
            private boolean zzd = false;
            private String zze;
            private Bundle zzf;

            public AccountChooserOptions build() {
                Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
                Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
                AccountChooserOptions accountChooserOptions = new AccountChooserOptions();
                accountChooserOptions.zzd = this.zzc;
                accountChooserOptions.zzc = this.zzb;
                accountChooserOptions.zze = this.zzd;
                accountChooserOptions.zzl = null;
                accountChooserOptions.zzj = null;
                accountChooserOptions.zzg = this.zzf;
                accountChooserOptions.zza = this.zza;
                accountChooserOptions.zzb = false;
                accountChooserOptions.zzh = false;
                accountChooserOptions.zzm = null;
                accountChooserOptions.zzi = 0;
                accountChooserOptions.zzf = this.zze;
                accountChooserOptions.zzk = false;
                accountChooserOptions.zzn = false;
                accountChooserOptions.zzo = false;
                return accountChooserOptions;
            }

            public Builder setAllowableAccounts(List<Account> list) {
                this.zzb = list == null ? null : new ArrayList(list);
                return this;
            }

            public Builder setAllowableAccountsTypes(List<String> list) {
                this.zzc = list == null ? null : new ArrayList(list);
                return this;
            }

            public Builder setAlwaysShowAccountPicker(boolean z) {
                this.zzd = z;
                return this;
            }

            public Builder setOptionsForAddingAccount(Bundle bundle) {
                this.zzf = bundle;
                return this;
            }

            public Builder setSelectedAccount(Account account) {
                this.zza = account;
                return this;
            }

            public Builder setTitleOverrideText(String str) {
                this.zze = str;
                return this;
            }
        }

        static /* bridge */ /* synthetic */ boolean zzA(AccountChooserOptions accountChooserOptions) {
            boolean z = accountChooserOptions.zzo;
            return false;
        }

        static /* bridge */ /* synthetic */ boolean zzB(AccountChooserOptions accountChooserOptions) {
            boolean z = accountChooserOptions.zzb;
            return false;
        }

        static /* bridge */ /* synthetic */ boolean zzC(AccountChooserOptions accountChooserOptions) {
            boolean z = accountChooserOptions.zzh;
            return false;
        }

        static /* bridge */ /* synthetic */ boolean zzD(AccountChooserOptions accountChooserOptions) {
            boolean z = accountChooserOptions.zzk;
            return false;
        }

        static /* bridge */ /* synthetic */ int zza(AccountChooserOptions accountChooserOptions) {
            int i = accountChooserOptions.zzi;
            return 0;
        }

        static /* bridge */ /* synthetic */ zza zzd(AccountChooserOptions accountChooserOptions) {
            zza zzaVar = accountChooserOptions.zzl;
            return null;
        }

        static /* bridge */ /* synthetic */ String zze(AccountChooserOptions accountChooserOptions) {
            String str = accountChooserOptions.zzj;
            return null;
        }

        static /* bridge */ /* synthetic */ String zzf(AccountChooserOptions accountChooserOptions) {
            String str = accountChooserOptions.zzm;
            return null;
        }

        static /* bridge */ /* synthetic */ boolean zzz(AccountChooserOptions accountChooserOptions) {
            boolean z = accountChooserOptions.zzn;
            return false;
        }
    }

    private AccountPicker() {
    }

    @ResultIgnorabilityUnspecified
    @Deprecated
    public static Intent newChooseAccountIntent(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle) {
        Intent intent = new Intent();
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST, arrayList);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY, strArr);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE, bundle);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_SELECTED_ACCOUNT, account);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT, z);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_DESCRIPTION_TEXT_OVERRIDE, str);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING, str2);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY, strArr2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_OVERRIDE_THEME, 0);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_OVERRIDE_CUSTOM_THEME, 0);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_HOSTED_DOMAIN_FILTER, (String) null);
        return intent;
    }

    public static Intent newChooseAccountIntent(AccountChooserOptions accountChooserOptions) {
        Intent intent = new Intent();
        AccountChooserOptions.zzD(accountChooserOptions);
        AccountChooserOptions.zze(accountChooserOptions);
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        AccountChooserOptions.zzd(accountChooserOptions);
        Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
        AccountChooserOptions.zzB(accountChooserOptions);
        Preconditions.checkArgument(true, "Making the selected account non-clickable is only supported for the THEME_DAY_NIGHT_GOOGLE_MATERIAL2, THEME_LIGHT_GOOGLE_MATERIAL3, THEME_DARK_GOOGLE_MATERIAL3 or THEME_DAY_NIGHT_GOOGLE_MATERIAL3 themes");
        AccountChooserOptions.zzD(accountChooserOptions);
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST, accountChooserOptions.zzc);
        if (accountChooserOptions.zzd != null) {
            intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY, (String[]) accountChooserOptions.zzd.toArray(new String[0]));
        }
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE, accountChooserOptions.zzg);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_SELECTED_ACCOUNT, accountChooserOptions.zza);
        AccountChooserOptions.zzB(accountChooserOptions);
        intent.putExtra("selectedAccountIsNotClickable", false);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT, accountChooserOptions.zze);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_DESCRIPTION_TEXT_OVERRIDE, accountChooserOptions.zzf);
        AccountChooserOptions.zzC(accountChooserOptions);
        intent.putExtra("setGmsCoreAccount", false);
        AccountChooserOptions.zzf(accountChooserOptions);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_REAL_CLIENT_PACKAGE, (String) null);
        AccountChooserOptions.zza(accountChooserOptions);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_OVERRIDE_THEME, 0);
        AccountChooserOptions.zzD(accountChooserOptions);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_OVERRIDE_CUSTOM_THEME, 0);
        AccountChooserOptions.zze(accountChooserOptions);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_HOSTED_DOMAIN_FILTER, (String) null);
        Bundle bundle = new Bundle();
        AccountChooserOptions.zzD(accountChooserOptions);
        AccountChooserOptions.zzd(accountChooserOptions);
        AccountChooserOptions.zzz(accountChooserOptions);
        AccountChooserOptions.zzA(accountChooserOptions);
        if (!bundle.isEmpty()) {
            intent.putExtra("first_party_options_bundle", bundle);
        }
        return intent;
    }
}
