/**
* Copyright Soramitsu Co., Ltd. All Rights Reserved.
* SPDX-License-Identifier: GPL-3.0
*/

package jp.co.soramitsu.feature_wallet_impl.presentation.contacts.adapter

import jp.co.soramitsu.feature_wallet_api.domain.model.Account

data class ContactListItem(
    val account: Account,
    var isLast: Boolean = false
)