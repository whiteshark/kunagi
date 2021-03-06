/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>, Artjom Kochtchi
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package scrum.server.project;

import ilarkesto.base.Str;
import ilarkesto.base.Utl;
import ilarkesto.base.time.Date;
import ilarkesto.io.IO;
import ilarkesto.testng.ATest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import scrum.TestUtil;
import scrum.server.issues.Issue;
import scrum.server.sprint.Sprint;

public class HomepageUpdaterTest extends ATest {

	Project project;

	@BeforeSuite
	public void initglobal() {
		TestUtil.initialize();
	}

	@BeforeClass
	public void createProject() {
		project = TestUtil.createProject(TestUtil.getDuke());
	}

	@Test
	public void updateHomepage() {
		Sprint sprint = TestUtil.createSprint(project, Date.inDays(15));
		project.setCurrentSprint(sprint);
		sprint.setLabel(Str.generateRandomSentence(2, 4));
		sprint.setGoal(Str.generateRandomParagraph());

		for (int i = 1; i <= 5; i++) {
			Requirement story = TestUtil.createRequirement(project, i);
			story.setSprint(sprint);
			story.setEstimatedWorkAsString(Utl.randomElement(scrum.client.project.Requirement.WORK_ESTIMATION_VALUES));
			story.setDirty(false);
			for (int j = 1; j <= 5; j++) {
				TestUtil.createTask(story, j, 16);
			}
		}
		for (int i = 6; i <= 20; i++) {
			TestUtil.createRequirement(project, i);
		}

		TestUtil.createWikipage(project, "InstallDoc");
		TestUtil.createWikipage(project, "IncludedLibraries");

		for (int i = 0; i < 5; i++) {
			TestUtil.createBlogEntry(project, i).setPublished(true);
		}

		for (int i = 1; i <= 5; i++) {
			Issue issue = TestUtil.createIssue(project, i);
			issue.setAcceptDate(Date.today());
			issue.setUrgent(true);
			if (i == 1) TestUtil.createComments(issue, 2);
		}
		for (int i = 6; i <= 10; i++) {
			Issue issue = TestUtil.createIssue(project, i);
			issue.setAcceptDate(Date.today());
		}
		for (int i = 11; i <= 15; i++) {
			Issue issue = TestUtil.createIssue(project, i);
		}

		sprint.burndownTasksRandomly(sprint.getBegin(), Date.today().addDays(-1));

		IO.copyFile("src/projectHomepage/html", OUTPUT_DIR + "/homepage");
		new HomepageUpdater(project, "src/projectHomepage/velocity", OUTPUT_DIR + "/homepage").processAll();
	}

	@AfterClass
	public void cleanup() {
		if (project != null) TestUtil.getApp().getProjectDao().deleteEntity(project);
	}

}
