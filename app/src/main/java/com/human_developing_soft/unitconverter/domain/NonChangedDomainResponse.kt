package com.human_developing_soft.unitconverter.domain

import android.widget.EditText
import android.widget.Spinner

data class NonChangedDomainResponse(
    private val mDecoratingObject: DomainResponse
) : DomainResponse {

    override fun putContent(field: EditText, spinner: Spinner) {
        // ignore this
    }
}