/**
* Copyright Soramitsu Co., Ltd. All Rights Reserved.
* SPDX-License-Identifier: GPL-3.0
*/

package jp.co.soramitsu.feature_main_impl.presentation.receiveamount.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import jp.co.soramitsu.common.di.app.ScreenScope
import jp.co.soramitsu.feature_main_impl.presentation.MainRouter
import jp.co.soramitsu.feature_main_impl.presentation.receiveamount.ReceiveAmountFragment

@Subcomponent(
    modules = [
        ReceiveAmountModule::class
    ]
)
@ScreenScope
interface ReceiveAmountComponent {

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        @BindsInstance
        fun withRouter(router: MainRouter): Builder

        fun build(): ReceiveAmountComponent
    }

    fun inject(receiveAmountFragment: ReceiveAmountFragment)
}