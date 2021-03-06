/**
* Copyright Soramitsu Co., Ltd. All Rights Reserved.
* SPDX-License-Identifier: GPL-3.0
*/

package jp.co.soramitsu.common.resourses

interface LanguagesHolder {

    fun getEnglishLang(): Language

    fun getLanguages(): List<Language>
}