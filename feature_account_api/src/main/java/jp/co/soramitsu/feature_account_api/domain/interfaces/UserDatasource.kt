/**
* Copyright Soramitsu Co., Ltd. All Rights Reserved.
* SPDX-License-Identifier: GPL-3.0
*/

package jp.co.soramitsu.feature_account_api.domain.interfaces

import jp.co.soramitsu.common.util.OnboardingState
import jp.co.soramitsu.feature_account_api.domain.model.InvitedUser
import jp.co.soramitsu.feature_account_api.domain.model.Reputation
import jp.co.soramitsu.feature_account_api.domain.model.User

interface UserDatasource {

    fun isPushTokenUpdateNeeded(): Boolean

    fun saveIsPushTokenUpdateNeeded(updateNeeded: Boolean)

    fun savePin(pin: String)

    fun retrievePin(): String

    fun savePushToken(notificationToken: String)

    fun retrievePushToken(): String

    fun saveUser(user: User)

    fun saveUserReputation(reputationDto: Reputation)

    fun retrieveUser(): User?

    fun retrieveUserReputation(): Reputation

    fun saveInvitedUsers(invitedUsers: Array<InvitedUser>)

    fun retrieveInvitedUsers(): Array<InvitedUser>?

    fun saveRegistrationState(onboardingState: OnboardingState)

    fun retrieveRegistratrionState(): OnboardingState

    fun clearUserData()

    fun saveInvitationParent(parentInfo: InvitedUser)

    fun retrieveInvitationParent(): InvitedUser?

    fun saveParentInviteCode(inviteCode: String)

    fun getParentInviteCode(): String

    fun getCurrentLanguage(): String

    fun changeLanguage(language: String)
}