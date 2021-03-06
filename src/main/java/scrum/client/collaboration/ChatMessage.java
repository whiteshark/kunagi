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
package scrum.client.collaboration;

import ilarkesto.gwt.client.Date;
import ilarkesto.gwt.client.DateAndTime;
import ilarkesto.gwt.client.Time;

import java.util.Map;

import scrum.client.admin.User;
import scrum.client.project.Project;

public class ChatMessage extends GChatMessage implements Comparable<ChatMessage> {

	public ChatMessage(Project project, User author, String text) {
		setProject(project);
		setAuthor(author);
		setText(text);
		setDateAndTime(DateAndTime.now());
	}

	public ChatMessage(Map data) {
		super(data);
	}

	@Override
	public String toString() {
		return getAuthor() + ": " + getText();
	}

	public boolean isOld() {
		DateAndTime dt = getDateAndTime();

		Date today = Date.today();
		if (!dt.getDate().equals(today)) return true;

		return Time.now().toSeconds() - dt.getTime().toSeconds() > 900;
	}

	public int compareTo(ChatMessage o) {
		return getDateAndTime().compareTo(o.getDateAndTime());
	}

}
