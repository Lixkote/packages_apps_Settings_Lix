/*
 * Copyright (C) 2020 The Android Open Source Project
 * Copyright (C) 2022 The Calyx Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.other;

import android.content.Context;
import android.provider.Settings;

import com.android.settings.R;
import com.android.settings.core.TogglePreferenceController;

/**
 * Option controller for non-persistent MAC randomization.
 * package : com.android.settings.development.WifiNonPersistentMacRandomizationPreferenceController
 */
public class WifiNonPersistentMacRandomizationPreferenceController
        extends TogglePreferenceController {

    private static final String NON_PERSISTENT_MAC_RANDOMIZATION_FEATURE_FLAG =
            "non_persistent_mac_randomization_force_enabled";

    private Context mContext;

    public WifiNonPersistentMacRandomizationPreferenceController(
        Context context,
        String preferenceKey
    ) {
        super(context, preferenceKey);
        mContext = context;
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public boolean isChecked() {
        return Settings.Global.getInt(mContext.getContentResolver(),
                NON_PERSISTENT_MAC_RANDOMIZATION_FEATURE_FLAG, 0) == 1;
    }

    @Override
    public boolean setChecked(boolean isChecked) {
        Settings.Global.putInt(mContext.getContentResolver(),
                NON_PERSISTENT_MAC_RANDOMIZATION_FEATURE_FLAG, isChecked ? 1 : 0);
        return true;
    }

    @Override
    public int getSliceHighlightMenuRes() {
        return R.string.menu_key_system;
    }

}
