/**
* Copyright Soramitsu Co., Ltd. All Rights Reserved.
* SPDX-License-Identifier: GPL-3.0
*/

package jp.co.soramitsu.common.util

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale
import javax.inject.Inject

class NumbersFormatter @Inject constructor() {

    companion object {
        private const val DECIMAL_PATTERN = "###.##"
    }

    fun format(num: Double): String {
        return DecimalFormat(DECIMAL_PATTERN).format(num)
    }

    fun format(num: BigDecimal, code: String): String {
        val formatter = NumberFormat.getCurrencyInstance(Locale.getDefault())
        formatter.currency = Currency.getInstance(code)
        return formatter.format(num)
    }

    fun formatBigDecimal(num: BigDecimal): String {
        val formatter = DecimalFormat()
        val decimalFormatSymbols = formatter.decimalFormatSymbols
        decimalFormatSymbols.groupingSeparator = ' '
        formatter.decimalFormatSymbols = decimalFormatSymbols
        return formatter.format(num)
    }

    fun formatInteger(num: BigDecimal): String {
        return formatBigDecimal(num.setScale(0, RoundingMode.FLOOR))
    }
}