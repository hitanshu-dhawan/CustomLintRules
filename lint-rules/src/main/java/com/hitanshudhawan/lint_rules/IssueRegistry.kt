package com.hitanshudhawan.lint_rules

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

class IssueRegistry : IssueRegistry() {

    override val issues: List<Issue>
        get() = listOf(
            LogDetector.ISSUE
        )

    override val api: Int = CURRENT_API

}
