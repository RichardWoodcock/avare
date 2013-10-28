/*
Copyright (c) 2012, Apps4Av Inc. (apps4av.com) 
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
    *     * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
    *
    *     THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package com.ds.avare.utils;


import com.ds.avare.R;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;

/**
 * 
 * @author jlmcgraw
 *
 */
public class ListPreferenceWithSummary extends ListPreference {
    private String originalSummary = "";

    public ListPreferenceWithSummary(Context context, AttributeSet attrs) {
	super(context, attrs);
	originalSummary = super.getSummary().toString();
    }

    public ListPreferenceWithSummary(Context context) {
	super(context);
	originalSummary = super.getSummary().toString();
    }

    @Override
    public void setValue(String value) {
	super.setValue(value);
	setSummary(originalSummary + getContext().getString(R.string.CurrentlySetTo) + value);
    }

    @Override
    public void setSummary(CharSequence summary) {

	super.setSummary(originalSummary + getContext().getString(R.string.CurrentlySetTo) + getEntry());
    }
}
