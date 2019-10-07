/**
* Copyright Soramitsu Co., Ltd. All Rights Reserved.
* SPDX-License-Identifier: GPL-3.0
*/

package jp.co.soramitsu.feature_main_impl.presentation.main.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import jp.co.soramitsu.common.base.BaseFragment
import jp.co.soramitsu.common.util.ext.gone
import jp.co.soramitsu.common.util.ext.show
import jp.co.soramitsu.core_di.holder.FeatureUtils
import jp.co.soramitsu.feature_main_api.di.MainFeatureApi
import jp.co.soramitsu.feature_main_impl.R
import jp.co.soramitsu.feature_main_impl.di.MainFeatureComponent
import jp.co.soramitsu.feature_main_impl.presentation.MainRouter
import jp.co.soramitsu.feature_main_impl.presentation.main.MainProjectsAdapter
import jp.co.soramitsu.feature_main_impl.presentation.main.MainViewModel
import kotlinx.android.synthetic.main.fragment_favorite_projects.placeholder
import kotlinx.android.synthetic.main.fragment_favorite_projects.projects_recyclerview

class FavoriteProjectsFragment : BaseFragment<MainViewModel>() {

    companion object {

        fun newInstance(): FavoriteProjectsFragment {
            return FavoriteProjectsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorite_projects, container, false)
    }

    override fun initViews() {
    }

    override fun inject() {
        FeatureUtils.getFeature<MainFeatureComponent>(context!!, MainFeatureApi::class.java)
            .projectsComponentBuilder()
            .withFragment(parentFragment!!)
            .withRouter(activity as MainRouter)
            .build()
            .inject(this)
    }

    override fun subscribe(viewModel: MainViewModel) {
        observe(viewModel.favoriteProjectsLiveData, Observer {
            if (projects_recyclerview.adapter == null) {
                projects_recyclerview.layoutManager = LinearLayoutManager(activity!!)
                projects_recyclerview.adapter = MainProjectsAdapter(
                    activity!!, {
                    viewModel.voteClicked(it)
                }, {
                    if (it.isFavorite) {
                        viewModel.removeProjectFromFavorites(it)
                    } else {
                        viewModel.addProjectToFavorites(it)
                    }
                }, {
                    viewModel.projectClick(it)
                })
            }
            (projects_recyclerview.adapter as MainProjectsAdapter).submitList(it)
            if (it.isEmpty()) {
                placeholder.show()
                projects_recyclerview.gone()
            } else {
                placeholder.gone()
                projects_recyclerview.show()
            }
        })

        viewModel.updateFavoriteProjects()
    }
}